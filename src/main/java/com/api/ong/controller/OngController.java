package com.api.ong.controller;

import com.api.ong.model.AnimalModel;
import com.api.ong.model.ClinicalCaseModel;
import com.api.ong.model.OngModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/ongs")
public interface OngController {

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<OngModel> create(@Valid @RequestBody OngModel ong);

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<OngModel> update(@Valid @RequestBody OngModel ong);

    @DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<OngModel> delete(@PathVariable Long id);

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<OngModel> getById(@PathVariable Long id);

    @GetMapping(value = "/animals/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<AnimalModel>> getAnimals(@PathVariable Long id);

    @GetMapping(value = "/clinical-cases/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<ClinicalCaseModel>> getClinicalCases(@PathVariable Long id);

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<OngModel>> getAll();
}
