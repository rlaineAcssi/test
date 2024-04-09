package test.demo.junit;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import test.demo.security.AuthenticationService;

@SpringBootTest
public class AuthentificationServiceTest {

	@Test
	void assertExceptionWHenUsePublicConstructor() {
		assertThrows(IllegalStateException.class, () -> new AuthenticationService());

	}

}
