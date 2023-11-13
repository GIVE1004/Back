package giveangel.back.domain.analysis.entity;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

import giveangel.back.domain.charity.entity.Charity;
import giveangel.back.global.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
public class Analysis extends BaseEntity {

	@GeneratedValue(strategy = IDENTITY)
	@Id
	private Long id;

	@ManyToOne(fetch = LAZY, optional = false)
	@JoinColumn(nullable = false, name = "public_interest_corporation_id")
	private Charity charity;

	@Column(columnDefinition = "TEXT")
	private String review;
	@Column(columnDefinition = "TEXT")
	private String news;
	@Column(columnDefinition = "TEXT")
	private String overall;
	@Column(columnDefinition = "TEXT")
	private String audit;
	@Column(columnDefinition = "TEXT")
	private String finance;
	@Column(columnDefinition = "TEXT")
	private String profile;

	@Column
	private Integer trustScore;

}
