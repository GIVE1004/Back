package giveangel.back.global.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import giveangel.back.global.jwt.JwtTokenProvider;
import giveangel.back.global.jwt.security.JwtSecurityFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableMethodSecurity(securedEnabled = true)
@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

	private final JwtTokenProvider jwtTokenProvider;
	private final ObjectMapper objectMapper;


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.cors(cors ->
				cors.configurationSource(corsConfigurationSource())
			)
			.httpBasic(AbstractHttpConfigurer::disable)
			.headers(header ->
				header.frameOptions(
					FrameOptionsConfig::disable
				)
			)
			.authorizeHttpRequests(auth ->
				auth.anyRequest().permitAll()
			)
			.formLogin(AbstractHttpConfigurer::disable)
			.logout(AbstractHttpConfigurer::disable)
			.addFilterBefore(jwtSecurityFilter(), UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().anyRequest();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.addAllowedOriginPattern("*");
		configuration.addAllowedMethod("*");
		configuration.addAllowedHeader("*");
		configuration.setAllowCredentials(true);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Bean
	public JwtSecurityFilter jwtSecurityFilter() {
		return new JwtSecurityFilter(jwtTokenProvider, objectMapper);
	}

}
