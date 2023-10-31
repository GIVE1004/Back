package giveangel.back.domain.charity.service;

import static giveangel.back.domain.charity.exception.CharityErrorCode.NOT_EXISTS_CHARITY;

import giveangel.back.domain.charity.exception.CharityException;
import giveangel.back.domain.charity.repository.CharityRepository;
import giveangel.back.domain.charity.service.dto.AssetInfo;
import giveangel.back.domain.charity.service.dto.CharityInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CharityService {

	private final CharityRepository charityRepository;

	public CharityInfo inquiryCharity(Long charityId) {
		return CharityInfo.of(charityRepository.findById(charityId)
			.orElseThrow(() -> new CharityException(NOT_EXISTS_CHARITY)));
	}

}
