package com.education.nawamaga;

import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import java.util.Base64;

@SpringBootTest
class NawamagaApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void keyGenerate() {
		SecretKey key = Jwts.SIG.HS256.key().build();

		byte[] encoded = key.getEncoded();
		String s = Base64.getEncoder().encodeToString(encoded);
		System.out.println(s);

//		iny4QSJ9nKPnYZE3FeQSB1SsUD1xHMBKjGmnQ/O80HE=
	}


}
