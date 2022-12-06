package com.example.service;

import com.example.dto.ICandidateDto;
import com.example.model.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICandidateService {
    void save(Candidate candidate);

    Optional<Candidate> findById(Integer id);

    void update(Candidate candidate);

    void deleteLogical(Integer id);

    Page<ICandidateDto> searchCandidate(String nameSearch, String typeSearch, Pageable pageable);
}
