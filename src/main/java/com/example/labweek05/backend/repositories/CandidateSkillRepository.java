package com.example.labweek05.backend.repositories;

import com.example.labweek05.backend.ids.CandidateSkillId;
import com.example.labweek05.backend.models.CandidateSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, CandidateSkillId> {
}
