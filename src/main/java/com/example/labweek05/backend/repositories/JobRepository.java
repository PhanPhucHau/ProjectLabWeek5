package com.example.labweek05.backend.repositories;

import com.example.labweek05.backend.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
