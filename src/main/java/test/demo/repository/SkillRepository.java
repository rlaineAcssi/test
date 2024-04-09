package test.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.demo.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

}
