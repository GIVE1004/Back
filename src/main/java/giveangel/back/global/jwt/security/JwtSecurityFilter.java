package giveangel.back.global.jwt.security;

import giveangel.back.domain.member.entity.Member;
import giveangel.back.global.jwt.JwtTokenProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@RequiredArgsConstructor
public class JwtSecurityFilter extends OncePerRequestFilter {

	private final JwtTokenProvider jwtTokenProvider;
	private static final String BEARER_PREFIX = "Bearer ";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
		FilterChain filterChain) throws ServletException, IOException {

		String accessToken = getJwtFrom(request);

		Member member = jwtTokenProvider.parseAccessToken(accessToken);

		SecurityContextHolder.getContext().setAuthentication(createAuthenticationToken(member));

		filterChain.doFilter(request, response);
	}

	private String getJwtFrom(HttpServletRequest request) {
		String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);

		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER_PREFIX)) {
			return bearerToken.substring(BEARER_PREFIX.length());
		}

		return null;
	}

	private JwtAuthenticationToken createAuthenticationToken(Member member) {
		return new JwtAuthenticationToken(member, "",
			List.of(new SimpleGrantedAuthority(member.getRole().name())));
	}


}
