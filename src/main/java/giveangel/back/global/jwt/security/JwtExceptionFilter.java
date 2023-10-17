package giveangel.back.global.jwt.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import giveangel.back.global.common.Message;
import giveangel.back.global.jwt.exception.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

@RequiredArgsConstructor
public class JwtExceptionFilter extends OncePerRequestFilter {

	private final ObjectMapper objectMapper;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
		FilterChain filterChain) throws ServletException, IOException {

		try {
			filterChain.doFilter(request, response);
		} catch (JwtException e) {
			response.setStatus(e.getErrorCode().getHttpStatus().value());
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			response.setCharacterEncoding("UTF-8");

			response.getWriter()
				.write(objectMapper.writeValueAsString(
					Message.fail(e.getErrorCode().name(), e.getMessage())));

			response.getWriter().flush();
		}

	}
}
