package test.demo.junit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import test.demo.security.AuthenticationService;

@SpringBootTest
public class AuthentificationServiceTest {

	@Autowired
	private AuthenticationService authentificationService;

	@Test
	void assertAutentificationNotNull() {
		assertNotNull(authentificationService);
	}

	@Test
	void assertExceptionWHenUsePublicConstructor() {
		assertThrows(IllegalStateException.class, () -> new AuthenticationService());

	}

}
