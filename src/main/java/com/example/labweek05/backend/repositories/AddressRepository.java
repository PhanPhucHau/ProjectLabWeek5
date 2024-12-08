package com.example.labweek05.backend.repositories;

import com.example.labweek05.backend.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
