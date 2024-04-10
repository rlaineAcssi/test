package test.demo.junit.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class HelloWorldControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void ensureMultipleProfilCreate() throws Exception {
		this.mockMvc.perform(get("/hello").header("X-API-KEY", "no-database")).andExpect(status().isOk());
	}

}