package com.example.service.impl;

import com.example.dto.ICandidateDto;
import com.example.model.Candidate;
import com.example.repository.ICandidateRepository;
import com.example.service.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidateService implements ICandidateService {
    @Autowired
    private ICandidateRepository iCandidateRepository;

    @Override
    public void save(Candidate candidate) {
        iCandidateRepository.save(candidate);
    }

    @Override
    public Optional<Candidate> findById(Integer id) {
        return iCandidateRepository.findById(id);
    }

    @Override
    public void update(Candidate candidate) {
        iCandidateRepository.save(candidate);
    }

    @Override
    public void deleteLogical(Integer id) {
        iCandidateRepository.deleteLogical(id);
    }

    @Override
    public Page<ICandidateDto> searchCandidate(String nameSearch, String typeSearch, Pageable pageable) {
        return iCandidateRepository.searchCandidate(nameSearch, typeSearch, pageable);
    }
}
