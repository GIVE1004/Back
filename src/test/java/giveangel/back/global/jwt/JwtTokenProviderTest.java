package giveangel.back.global.jwt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.time.Duration;
import java.util.Date;
import javax.crypto.SecretKey;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class JwtTokenProviderTest {

	@Mock
	private JwtProps props;

	@InjectMocks
	private JwtTokenProvider manager;

	@Test
	void issueToken() throws InterruptedException {
	    //given
		SecretKey key = Keys.hmacShaKeyFor(
			"vsaddadsvdvasadsdassdvsdadasvdasssvdvsavas".getBytes());
		String token = Jwts.builder()
			.id("test")
			.expiration(new Date())
			.signWith(key)
			.compact();

		Thread.sleep(3000);

		try {
			Claims payload = Jwts.parser()
				.verifyWith(key)
				.build()
				.parseSignedClaims(token)
				.getPayload();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}