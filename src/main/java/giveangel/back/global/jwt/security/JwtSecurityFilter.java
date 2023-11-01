package giveangel.back.global.jwt.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import giveangel.back.global.common.Message;
import giveangel.back.global.jwt.JwtTokenProvider;
import giveangel.back.global.jwt.exception.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@RequiredArgsConstructor
public class JwtSecurityFilter extends OncePerRequestFilter {

	private final JwtTokenProvider jwtTokenProvider;
	private final ObjectMapper objectMapper;
	private static final String BEARER_PREFIX = "Bearer ";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
		FilterChain filterChain) throws ServletException, IOException {

		String accessToken = getJwtFrom(request);

		if (StringUtils.hasText(accessToken)) {
			try {
				LoginMember member = jwtTokenProvider.parseAccessToken(accessToken);

				SecurityContextHolder.getContext()
					.setAuthentication(createAuthenticationToken(member));
			} catch (JwtException e) {
				SecurityContextHolder.clearContext();
				sendError(response, e);
				return;
			}
		}

		filterChain.doFilter(request, response);
	}

	private String getJwtFrom(HttpServletRequest request) {
		String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);

		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER_PREFIX)) {
			return bearerToken.substring(BEARER_PREFIX.length());
		}

		return null;
	}

	private JwtAuthenticationToken createAuthenticationToken(LoginMember member) {
		return new JwtAuthenticationToken(member, "",
			List.of(new SimpleGrantedAuthority(member.role().name())));
	}

	private void sendError(HttpServletResponse response, JwtException e)
		throws IOException {
		response.setStatus(e.getErrorCode().getHttpStatus().value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setCharacterEncoding("UTF-8");

		PrintWriter writer = response.getWriter();
		writer
			.write(objectMapper.writeValueAsString(
				Message.fail(e.getErrorCode().name(), e.getMessage())));

		writer.flush();
	}


}
