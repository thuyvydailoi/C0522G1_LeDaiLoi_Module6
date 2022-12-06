package com.example.repository;

import com.example.model.CandidateType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICandidateTypeRepository extends JpaRepository<CandidateType, Integer> {
}
