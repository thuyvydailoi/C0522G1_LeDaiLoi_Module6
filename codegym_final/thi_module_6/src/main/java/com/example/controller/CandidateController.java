package com.example.controller;

import com.example.dto.CandidateDto;
import com.example.dto.ICandidateDto;
import com.example.model.Candidate;
import com.example.model.CandidateType;
import com.example.service.ICandidateService;
import com.example.service.ICandidateTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/candidate")
@CrossOrigin("*")
public class CandidateController {
    @Autowired
    private ICandidateService iCandidateService;

    @Autowired
    private ICandidateTypeService iCandidateTypeService;

    @GetMapping("/list/{nameSearch}&{typeSearch}")
    public ResponseEntity<Page<ICandidateDto>> getAllProductPaging(@PageableDefault(value = 5) Pageable pageable,
                                                                   @PathVariable("nameSearch") String nameSearch,
                                                                   @PathVariable("typeSearch") String typeSearch) {
        Page<ICandidateDto> candidateDtos = iCandidateService.searchCandidate(nameSearch, typeSearch, pageable);
        return new ResponseEntity<>(candidateDtos, HttpStatus.OK);
    }

    @GetMapping("/type-list")
    public ResponseEntity<List<CandidateType>> getAllProductType() {
        List<CandidateType> candidateTypes = iCandidateTypeService.findAll();
        if (candidateTypes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(candidateTypes, HttpStatus.OK);
    }

    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<?> getInfoCandidate(@PathVariable Integer id) {

        Optional<Candidate> candidateObj = this.iCandidateService.findById(id);

        if (candidateObj == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(candidateObj, HttpStatus.OK);
    }

    @DeleteMapping("/delete-candidate/{id}")
    public ResponseEntity<Candidate> deleteProduct(@PathVariable Integer id) {
        Optional<Candidate> candidate = iCandidateService.findById(id);
        if (!candidate.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iCandidateService.deleteLogical(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCandidate(@Valid @RequestBody CandidateDto candidateDto,
                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.BAD_REQUEST);
        }

        Candidate candidate = new Candidate();
        BeanUtils.copyProperties(candidateDto, candidate);
        iCandidateService.save(candidate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<?> editProduct(@Valid @RequestBody CandidateDto candidateDto,
                                         @PathVariable Integer id,
                                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.BAD_REQUEST);
        }

        Optional<Candidate> candidate = iCandidateService.findById(id);

        if (candidate.isPresent()) {
            BeanUtils.copyProperties(candidateDto, candidate.get());
            iCandidateService.update(candidate.get());
            return new ResponseEntity<>(candidate.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
