package test.demo.junit.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@SpringBootTest
@AutoConfigureMockMvc
class ProfilControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void ensureProfilCreate() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.appendField("name", "test");
		jsonObject.appendField("entrance", "2023-12-03T10:15:30");

		JSONArray jsonArraySkill = new JSONArray();
		jsonArraySkill.appendElement(new JSONObject().appendField("name", "Java").appendField("category", "DIGITAL"));

		jsonObject.appendField("skills", jsonArraySkill);

		this.mockMvc
				.perform(post("/profil/create").header("X-API-KEY", "no-database")
						.contentType(MediaType.APPLICATION_JSON).content(jsonObject.toJSONString()))
				.andExpect(status().isOk());
	}

	@Test
	void ensureProfilAll() throws Exception {
		this.mockMvc.perform(get("/profil/all").header("X-API-KEY", "no-database")).andExpect(status().isOk());
	}

}