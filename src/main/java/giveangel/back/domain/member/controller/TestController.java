package giveangel.back.domain.member.controller;

import giveangel.back.domain.member.entity.MemberRole;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/test")
	public MemberRole test() {

		return MemberRole.ADMIN;
	}
}
