package com.example.service.impl;

import com.example.model.CandidateType;
import com.example.repository.ICandidateTypeRepository;
import com.example.service.ICandidateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateTypeService implements ICandidateTypeService {
    @Autowired
    private ICandidateTypeRepository iCandidateTypeRepository;

    @Override
    public List<CandidateType> findAll() {
        return iCandidateTypeRepository.findAll();
    }
}
