package com.api.ong.controller;

import com.api.ong.model.ClinicalCaseModel;
import com.api.ong.model.GrantModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/clinical-cases")
public interface ClinicalCaseController {

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<ClinicalCaseModel> create(@Valid @RequestBody ClinicalCaseModel clinicalCase);

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<ClinicalCaseModel> update(@Valid @RequestBody ClinicalCaseModel clinicalCase);

    @DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<ClinicalCaseModel> delete(@PathVariable Long id);

    @GetMapping(value = "/grants/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<GrantModel>> getGrants(@PathVariable Long id);

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<ClinicalCaseModel> getById(@PathVariable Long id);

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<ClinicalCaseModel>> getAll();
}
