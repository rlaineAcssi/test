package test.demo.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import test.demo.model.Profil;
import test.demo.model.Skill;
import test.demo.model.cons.SkillCategory;
import test.demo.repository.ProfilRepository;

@RestController
public class CreateMultipleProfilController {

	private final ProfilRepository profilRepository;

	private List<Skill> skills;

	public CreateMultipleProfilController(ProfilRepository profilRepository) {
		this.profilRepository = profilRepository;
	}

	private void initSkills() {
		skills = new ArrayList<>();
		Skill skill = new Skill();
		skill.setCategory(SkillCategory.DATA);
		skill.setName("IA");
		skills.add(null);
	}

	@PostMapping("/profil/create-multiple")
	public void createMultipleProfil(@RequestBody List<String> names) {
		initSkills();
		names.forEach(name -> {
			Profil profil = new Profil();
			profil.setEntrance(LocalDateTime.now());
			profil.setName(name);
			profil.setSkills(skills);
			profilRepository.save(profil);
		});
	}

}
