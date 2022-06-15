package com.api.ong.controller;

import com.api.ong.model.GrantModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "api/grants")
public interface GrantController {

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<GrantModel> create(@Valid @RequestBody GrantModel grant);

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<GrantModel> update(@Valid @RequestBody GrantModel grant);

    @DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<GrantModel> delete(@PathVariable Long id);

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<GrantModel> getById(@PathVariable Long id);

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<GrantModel>> getAll();
}
