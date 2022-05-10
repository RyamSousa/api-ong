package com.api.ong.controller;

import com.api.ong.model.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<UserModel>> getAll();
}
