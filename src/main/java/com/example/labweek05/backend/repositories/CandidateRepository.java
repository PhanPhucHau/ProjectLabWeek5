package com.example.labweek05.backend.repositories;

import com.example.labweek05.backend.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
