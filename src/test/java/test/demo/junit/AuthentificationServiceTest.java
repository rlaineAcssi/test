package test.demo.junit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.authentication.BadCredentialsException;

import test.demo.security.AuthenticationService;

@SpringBootTest
public class AuthentificationServiceTest {

	@Test
	void assertExceptionWHenUsePublicConstructor() {
		assertThrows(IllegalStateException.class, () -> new AuthenticationService());
	}

	@Test
	void getInvalidAuthentificationThrowError() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.addHeader("X-API-KEY", "toto");
		assertThrows(BadCredentialsException.class, () -> AuthenticationService.getAuthentication(request));
	}

	@Test
	void getInvalidHeaderThrowError() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.addHeader("toto", "no-database");
		assertThrows(BadCredentialsException.class, () -> AuthenticationService.getAuthentication(request));
	}

	@Test
	void assertIdentification() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.addHeader("X-API-KEY", "no-database");
		assertNotNull(AuthenticationService.getAuthentication(request));
	}

}
