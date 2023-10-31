package giveangel.back.domain.charity.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "public_interest_corporations")
public class Charity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "public_interest_corporation_id", nullable = false)
	private Long id;

	@Size(max = 64)
	@NotNull
	@Column(name = "public_interest_corporation_name", nullable = false, length = 64)
	private String name;

	@Size(max = 32)
	@NotNull
	@Column(name = "representative_name", nullable = false, length = 32)
	private String representative;

	@NotNull
	@Column(name = "establishment_date", nullable = false)
	private LocalDate establishmentDate;

	@Size(max = 64)
	@Column(name = "road_name_address", length = 64)
	private String location;

	@Size(max = 16)
	@NotNull
	@Column(name = "telephone_number", nullable = false, length = 16)
	private String tel;

	@Size(max = 256)
	@Column(name = "homepage_address", length = 256)
	private String homepage;

	@Size(max = 320)
	@NotNull
	@Column(name = "email_address", nullable = false, length = 320)
	private String email;

	@Size(max = 32)
	@Column(name = "competent_authority", length = 32)
	private String competentAuthority;

	@Size(max = 8)
	@NotNull
	@Column(name = "contribution_type", nullable = false, length = 8)
	private String contributionType;

	@Size(max = 256)
	@Column(name = "establishment_law", length = 256)
	private String establishmentLaw;

	@Size(max = 8)
	@NotNull
	@Column(name = "establishment_type", nullable = false, length = 8)
	private String establishmentType;

	@Size(max = 8)
	@NotNull
	@Column(name = "public_business_type", nullable = false, length = 8)
	private String publicBusinessType;

	@Size(max = 8)
	@NotNull
	@Column(name = "founding_entity", nullable = false, length = 8)
	private String foundingEntity;

	@NotNull
	@Column(name = "director_count", nullable = false)
	private Integer directorCount;

	@NotNull
	@Column(name = "yearly_volunteer_count", nullable = false)
	private Integer yearlyVolunteerCount;

	@NotNull
	@Column(name = "employee_count", nullable = false)
	private Integer employeeCount;

	@Size(max = 512)
	@Column(name = "business_status", length = 512)
	private String businessStatus;

	@Size(max = 256)
	@Column(name = "business_activities", length = 256)
	private String businessActivities;

	@Size(max = 64)
	@Column(name = "business_targets", length = 64)
	private String businessTargets;

	@Size(max = 64)
	@Column(name = "business_domestic_area", length = 64)
	private String businessDomesticArea;

	@Size(max = 32)
	@Column(name = "business_overseas_area", length = 32)
	private String businessOverseasArea;

	@Column(name = "business_count")
	private Integer businessCount;

}