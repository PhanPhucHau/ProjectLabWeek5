package com.example.labweek05.backend.services;

import com.example.labweek05.backend.models.Job;
import com.example.labweek05.backend.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Page<Job> getJobsWithPagination(Pageable pageable) {
        return jobRepository.findAll(pageable);
    }

    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    public Job findJobById(long id) {
        return jobRepository.findById(id).orElse(null);
    }
    public void deleteJob(Long jobId) {
        jobRepository.deleteById(jobId);
    }
}
