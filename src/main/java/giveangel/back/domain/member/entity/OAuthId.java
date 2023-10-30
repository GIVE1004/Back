package giveangel.back.domain.member.entity;


import static lombok.AccessLevel.PROTECTED;

import giveangel.back.global.oauth.vendor.enums.OAuthServerType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public class OAuthId {

	@Column(nullable = false, name = "oauth_server_id")
	private String oauthServerId;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, name = "oauth_server")
	private OAuthServerType oauthServerType;


}
