package giveangel.back.global.jwt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MemberTokenManagerTest {

	@Mock
	private JwtProps props;

	@InjectMocks
	private MemberTokenManager manager;

	@Test
	void issueToken(){
	    //given

		given(props.accessExpiration()).willReturn(Duration.ofMinutes(10));

	    //when

		long millis = props.accessExpiration().toMillis();

		//then
		assertEquals(10000, millis);

	}
}