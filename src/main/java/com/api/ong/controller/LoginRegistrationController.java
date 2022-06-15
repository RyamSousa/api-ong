package com.api.ong.controller;

import com.api.ong.model.LoginRegistrationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "api/login-registration")
public interface LoginRegistrationController {

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<LoginRegistrationModel>> getAllRegisters();
}
