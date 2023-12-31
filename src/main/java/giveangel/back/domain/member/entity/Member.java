package giveangel.back.domain.member.entity;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import giveangel.back.global.common.BaseEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
@Builder
@Table(
	uniqueConstraints = @UniqueConstraint(
		name = "oauth_id_unique",
		columnNames = {
			"oauth_server_id", "oauth_server"
		})
)
@Entity
public class Member extends BaseEntity {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@Embedded
	private OAuthId oAuthId;
	private String email;
	private String nickname;
	private String profileImageUrl;

	@Enumerated(STRING)
	private MemberRole role;

}
