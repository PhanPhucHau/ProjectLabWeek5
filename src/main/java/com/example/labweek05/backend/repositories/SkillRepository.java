package com.example.labweek05.backend.repositories;

import com.example.labweek05.backend.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
