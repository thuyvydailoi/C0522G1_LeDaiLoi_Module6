package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CandidateType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer candidateTypeId;
    private String candidateTypeName;

    public CandidateType() {
    }

    public Integer getCandidateTypeId() {
        return candidateTypeId;
    }

    public void setCandidateTypeId(Integer candidateTypeId) {
        this.candidateTypeId = candidateTypeId;
    }

    public String getCandidateTypeName() {
        return candidateTypeName;
    }

    public void setCandidateTypeName(String candidateTypeName) {
        this.candidateTypeName = candidateTypeName;
    }
}
