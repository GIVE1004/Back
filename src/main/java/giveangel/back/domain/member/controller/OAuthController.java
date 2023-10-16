package giveangel.back.domain.member.controller;

import giveangel.back.global.oauth.vendor.enums.OAuthServerType;
import giveangel.back.domain.member.service.OAuthService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RequestMapping("/oauth")
@RestController
public class OAuthController {

	private final OAuthService oAuthService;

	@SneakyThrows
	@GetMapping("/{oAuthServerType}")
	public ResponseEntity<Void> redirectOAuthCodeRequestUrl(
		@PathVariable OAuthServerType oAuthServerType,
		HttpServletResponse response
	) {

		String redirectUrl = oAuthService.provideAuthCodeRequestUrl(oAuthServerType);

		response.sendRedirect(redirectUrl);

		return ResponseEntity.ok().build();
	}

	@GetMapping("/login/{oAuthServerType}")
	public ResponseEntity<Long> login(
		@PathVariable OAuthServerType oAuthServerType,
		@RequestParam("code") String authCode
	) {
		Long login = oAuthService.login(oAuthServerType, authCode);
		return ResponseEntity.ok(login);
	}
}