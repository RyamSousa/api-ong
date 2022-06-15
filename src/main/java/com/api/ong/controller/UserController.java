package com.api.ong.controller;

import com.api.ong.model.AnimalModel;
import com.api.ong.model.GrantModel;
import com.api.ong.model.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "api/users")
public interface UserController {

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<UserModel> create(@Valid @RequestBody UserModel user);

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<UserModel> update(@Valid @RequestBody UserModel user);

    @DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<UserModel> delete(@PathVariable Long id);

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<UserModel> getById(@PathVariable Long id);

    @GetMapping(value = "/grants/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<GrantModel>> getGrants(@PathVariable Long id);

    @GetMapping(value = "/animals/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<AnimalModel>> getAnimals(@PathVariable Long id);

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<UserModel>> getAll();
}
