package be.esi.repository;

import org.springframework.data.repository.CrudRepository;

import be.esi.model.Skill;

public interface SkillRepository extends CrudRepository<Skill, Integer> {

    Skill findById(int id);
}
