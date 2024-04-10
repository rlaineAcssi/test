package test.demo.junit.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import net.minidev.json.JSONArray;

@SpringBootTest
@AutoConfigureMockMvc
public class MultipleProfilControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void ensureMultipleProfilCreate() throws Exception {
		JSONArray ja = new JSONArray();
		ja.appendElement("test");
		this.mockMvc.perform(post("/profil/create-multiple").header("X-API-KEY", "no-database")
				.contentType(MediaType.APPLICATION_JSON).content(ja.toJSONString())).andExpect(status().isOk());
	}

}