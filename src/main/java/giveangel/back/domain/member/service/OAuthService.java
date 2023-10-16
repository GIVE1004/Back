package giveangel.back.domain.member.service;

import giveangel.back.domain.member.entity.Member;
import giveangel.back.domain.member.repository.MemberRepository;
import giveangel.back.global.oauth.component.OAuthCodeUrlProvider;
import giveangel.back.global.oauth.component.OAuthMemberClient;
import giveangel.back.global.oauth.vendor.enums.OAuthServerType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class OAuthService {

	private final OAuthCodeUrlProvider oAuthCodeUrlProvider;
	private final OAuthMemberClient oAuthMemberClient;
	private final MemberRepository memberRepository;

	public String provideAuthCodeRequestUrl(OAuthServerType oAuthServerType) {
		return oAuthCodeUrlProvider.provide(oAuthServerType);
	}

	public Long login(OAuthServerType oAuthServerType, String authCode) {
		Member oauthMember = oAuthMemberClient.fetch(oAuthServerType, authCode);

		Member member = memberRepository.findByoAuthId(oauthMember.getOAuthId())
			.orElseGet(() -> memberRepository.save(oauthMember));

		return member.getId();
	}

}
