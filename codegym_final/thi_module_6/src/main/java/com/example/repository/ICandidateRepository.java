package com.example.repository;

import com.example.dto.ICandidateDto;
import com.example.model.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ICandidateRepository extends JpaRepository<Candidate, Integer> {
    @Query(value = "select candidate.candidate_id as id, candidate.candidate_name as name, candidate.date_of_birth as dateOfBirth, " +
            "candidate.phone_number as phoneNumber, candidate.address as address, candidate_type.candidate_type_name as type " +
            "from candidate join candidate_type on candidate.candidate_type_id = candidate_type.candidate_type_id " +
            "where candidate.candidate_name like %:nameSearch% and candidate_type.candidate_type_name like %:typeSearch% " +
            "and candidate.is_delete = false",
            countQuery = "select count(*) " +
                    "from candidate join candidate_type on candidate.candidate_type_id = candidate_type.candidate_type_id " +
                    "where candidate.candidate_name like %:nameSearch% and candidate_type.candidate_type_name like %:typeSearch% " +
                    "and candidate.is_delete = false",
            nativeQuery = true)
    Page<ICandidateDto> searchCandidate(@Param("nameSearch") String nameSearch,
                                      @Param("typeSearch") String typeSearch,
                                      Pageable pageable);

    @Modifying
    @Query(value = "update candidate set is_delete = true where candidate_id = :idDelete", nativeQuery = true)
    void deleteLogical(@Param("idDelete") Integer id);
}
