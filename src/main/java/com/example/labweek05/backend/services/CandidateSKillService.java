package com.example.labweek05.backend.services;

import com.example.labweek05.backend.models.CandidateSkill;
import com.example.labweek05.backend.repositories.CandidateSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateSKillService {
    @Autowired
    private CandidateSkillRepository candidateSkillRepository;

    public List<CandidateSkill> getAllCandidateSkills() {
        return candidateSkillRepository.findAll();
    }

    public Page<CandidateSkill> getCandidateSkillWithPagination(Pageable pageable) {
        return candidateSkillRepository.findAll(pageable);
    }

    public CandidateSkill saveCandidateSkill(CandidateSkill candidateSkill) {
        return candidateSkillRepository.save(candidateSkill);
    }


}
