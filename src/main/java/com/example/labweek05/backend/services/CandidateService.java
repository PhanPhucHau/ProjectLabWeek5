package com.example.labweek05.backend.services;

import com.example.labweek05.backend.models.Candidate;
import com.example.labweek05.backend.models.Job;
import com.example.labweek05.backend.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    public List<Candidate> findAllCandidates() {
        return candidateRepository.findAll();
    }
    public Page<Candidate> findCandidatesWithPagination(int pageNo, int pageSize, String sortBy, String direction) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy));
        return candidateRepository.findAll(pageable);
    }
    public Candidate findCandidateById(long id) {
        return candidateRepository.findById(id).orElse(null);
    }






}
