package com.example.dto;

import com.example.model.CandidateType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CandidateDto {
    private Integer candidateId;

    @NotBlank(message = "Tên sản phẩm không được để trống.")
    @Size(min = 5, max = 50, message = "Tên sản phẩm phải từ 5 đến 50 kí tự.")
    private String candidateName;

    //    @NotBlank(message = "Giá sản phẩm không được để trống.")
//    @Pattern(regexp = "^[1-9]\\d*| *$", message = "Giá (VNĐ) phải là số nguyên dương.")
//    @Min(value = 100000, message = "Giá bắt đầu thấp nhất phải là 100.000 VNĐ.")
//    private String productPrice;
//
//    @NotBlank(message = "Trạng thái không được để trống.")
//    private String productStatus;

    @NotBlank
    private String dateOfBirth;

    @NotBlank
    private String address;

    @NotBlank
    private String phoneNumber;

    private CandidateType candidateType;

    public CandidateDto() {
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

    public CandidateType getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(CandidateType candidateType) {
        this.candidateType = candidateType;
    }
}
