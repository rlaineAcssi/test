package test.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import test.demo.model.Profil;
import test.demo.repository.ProfilRepository;
import test.demo.repository.SkillRepository;

@RestController
public class ProfilController {

	private final ProfilRepository profilRepository;

	private final SkillRepository skillRepository;

	@Autowired
	public ProfilController(ProfilRepository profilRepository, SkillRepository skillRepository) {
		this.profilRepository = profilRepository;
		this.skillRepository = skillRepository;
	}

	@PostMapping("/profil/create")
	public void createProfil(@RequestBody Profil newProfil) {
		newProfil.getSkills().forEach(e -> skillRepository.save(e));
		profilRepository.save(newProfil);
	}

	@PostMapping("/profil/delete")
	public void deleteProfil(@RequestBody Profil newProfil) {
		profilRepository.save(newProfil);
	}

	@GetMapping("/profil/all")
	public List<Profil> getAll() {
		return profilRepository.findAll();
	}

	@GetMapping("/profil/one")
	public Profil getProfil(@RequestBody Long id) {
		return profilRepository.getReferenceById(id);
	}

}
