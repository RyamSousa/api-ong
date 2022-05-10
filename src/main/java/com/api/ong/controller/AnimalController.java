package com.api.ong.controller;

import com.api.ong.model.AnimalModel;
import com.api.ong.model.ClinicalCaseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/animals")
public interface AnimalController {

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<AnimalModel> create(@Valid @RequestBody AnimalModel animal);

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<AnimalModel> update(@Valid @RequestBody AnimalModel animal);

    @DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<AnimalModel> delete(@PathVariable Long id);

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<AnimalModel> getById(@PathVariable Long id);

    @GetMapping(value = "/clinical-cases/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<ClinicalCaseModel>> getClinicalCases(@PathVariable Long id);

    @GetMapping(value = "/specie/{specie}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<AnimalModel>> getBySpecies(@PathVariable String specie);

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<AnimalModel>> getAll();
}
