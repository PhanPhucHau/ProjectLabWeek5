package com.example.labweek05.backend.repositories;

import com.example.labweek05.backend.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
