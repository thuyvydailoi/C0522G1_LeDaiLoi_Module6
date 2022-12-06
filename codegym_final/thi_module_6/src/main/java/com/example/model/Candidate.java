package com.example.model;

import javax.persistence.*;

@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer candidateId;
    private String candidateName;
    private String dateOfBirth;
    private String address;
    private String phoneNumber;
    private boolean isDelete;

    @ManyToOne
    @JoinColumn(name= "candidate_type_id",referencedColumnName = "candidateTypeId")
    private CandidateType CandidateType;

    public Candidate() {
    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public com.example.model.CandidateType getCandidateType() {
        return CandidateType;
    }

    public void setCandidateType(com.example.model.CandidateType candidateType) {
        CandidateType = candidateType;
    }
}
