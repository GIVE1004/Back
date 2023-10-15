package giveangel.back.global.oauth;

import giveangel.back.domain.member.entity.Member;
import giveangel.back.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class OAuthService {

	private final OAuthCodeUrlProviderComposite oAuthCodeUrlProviderComposite;
	private final OAuthMemberClientComposite oAuthMemberClientComposite;
	private final MemberRepository memberRepository;

	public String getAuthCodeRequestUrl(OAuthServerType oAuthServerType) {
		return oAuthCodeUrlProviderComposite.provide(oAuthServerType);
	}

	public Long login(OAuthServerType oAuthServerType, String authCode) {
		Member oauthMember = oAuthMemberClientComposite.fetch(oAuthServerType, authCode);

		Member member = memberRepository.findByoAuthId(oauthMember.getOAuthId())
			.orElseGet(() -> memberRepository.save(oauthMember));

		return member.getId();
	}

}
