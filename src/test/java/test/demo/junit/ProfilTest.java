package test.demo.junit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import test.demo.model.Profil;
import test.demo.model.Skill;
import test.demo.repository.ProfilRepository;
import test.demo.repository.SkillRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProfilTest {

	private Profil profil;

	@Autowired
	private ProfilRepository profilRepository;

	@Autowired
	private SkillRepository skillRepository;

	private List<Skill> initSkills() {
		List<Skill> skills = new ArrayList<>();
		skills.add(skillRepository.save(new Skill()));
		return skills;
	}

	@Test
	public void createProfil() {

		List<Skill> skills = initSkills();

		profil = new Profil();
		profil.setEntrance(LocalDateTime.now());
		profil.setName("Test du profil");
		profil.setSkills(skills);
		assertNotNull(profilRepository.save(profil));

	}

}
