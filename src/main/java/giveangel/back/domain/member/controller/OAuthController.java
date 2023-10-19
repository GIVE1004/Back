package giveangel.back.domain.member.controller;

import giveangel.back.domain.member.dto.LoginResponse;
import giveangel.back.domain.member.dto.Tokens;
import giveangel.back.global.common.Message;
import giveangel.back.global.oauth.vendor.enums.OAuthServerType;
import giveangel.back.domain.member.service.OAuthService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<Message> redirectOAuthCodeRequestUrl(
		@PathVariable OAuthServerType oAuthServerType,
		HttpServletResponse response
	) {

		String redirectUrl = oAuthService.provideAuthCodeRequestUrl(oAuthServerType);

		response.sendRedirect(redirectUrl);

		return ResponseEntity.ok().body(Message.success());
	}

	@GetMapping("/login/{oAuthServerType}")
	public ResponseEntity<Message<LoginResponse>> login(
		@PathVariable OAuthServerType oAuthServerType,
		@RequestParam("code") String authCode
	) {
		LoginResponse result = oAuthService.login(oAuthServerType, authCode);
		return ResponseEntity.ok().body(Message.success(result));
	}

	@PostMapping("/refresh")
	public ResponseEntity<Message<Tokens>> refreshToken(@RequestBody Tokens tokens) {
		return ResponseEntity.ok().body(Message.success(oAuthService.refreshToken(tokens)));
	}
}
