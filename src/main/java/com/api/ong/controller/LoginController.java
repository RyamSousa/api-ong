package com.api.ong.controller;

import com.api.ong.model.LoginModel;
import com.api.ong.model.OngModel;
import com.api.ong.model.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "api/login")
public interface LoginController {

    @PostMapping(value = "/user", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<UserModel> loginUser(@Valid @RequestBody LoginModel user);

    @PostMapping(value = "/ong", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<OngModel> loginOng(@Valid @RequestBody LoginModel ong);
}
