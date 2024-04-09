package test.demo.junit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import test.demo.model.Skill;
import test.demo.model.cons.SkillCategory;
import test.demo.repository.SkillRepository;

@SpringBootTest
public class SkillTest {

	@Autowired
	private SkillRepository skillRepository;

	private static Skill skill;

	private static Skill skillPersisted;

	private static Instant startedAt;

	@BeforeAll
	static public void initStartingTime() {
		System.out.println("Appel avant tous les tests");
		startedAt = Instant.now();
	}

	@AfterAll
	static public void showTestDuration() {
		System.out.println("Appel après tous les tests");
		Instant endedAt = Instant.now();
		long duration = Duration.between(startedAt, endedAt).toMillis();
		System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
	}

	@BeforeEach
	public void initSkill() {
		skill = new Skill();
		skill.setName("test");
		skill.setCategory(SkillCategory.DATA);
	}

	@Timeout(20)
	@Test
	void testCreateSkill() {
		skillPersisted = skillRepository.save(skill);
		assertNotNull(skillPersisted);
		assertNotNull(skillPersisted.getId());
	}

	@Test
	public void deletePersistedSkill() {
		if (skillPersisted != null) {
			skillRepository.delete(skillPersisted);
			assertNull(skillRepository.getReferenceById(skillPersisted.getId()));
			skillPersisted = null;
		}
	}
}
