package giveangel.back.domain.member.controller;

import giveangel.back.domain.member.entity.Member;
import giveangel.back.domain.member.entity.MemberRole;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/test")
	public MemberRole test() {
		return MemberRole.ADMIN;
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/security/admin")
	public String securityTest(@AuthenticationPrincipal Member member) {
		return member.getNickname();
	}

	@PreAuthorize("hasAuthority('MEMBER')")
	@GetMapping("/security/member")
	public String securityMember(@AuthenticationPrincipal Member member) {
		return member.getNickname();
	}
}
