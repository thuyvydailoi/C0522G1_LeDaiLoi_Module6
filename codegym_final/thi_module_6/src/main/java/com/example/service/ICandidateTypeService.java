package com.example.service;

import com.example.model.Candidate;
import com.example.model.CandidateType;

import java.util.List;

public interface ICandidateTypeService {
    List<CandidateType> findAll();
}
