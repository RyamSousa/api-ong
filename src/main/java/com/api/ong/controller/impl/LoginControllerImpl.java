package com.api.ong.controller.impl;

import com.api.ong.controller.LoginController;
import com.api.ong.model.LoginModel;
import com.api.ong.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoginControllerImpl implements LoginController {

    private final LoginService loginService;

    @Override
    public ResponseEntity<LoginModel> loginUser(LoginModel user) {
        return ResponseEntity.ok(loginService.loginUser(user));
    }

    @Override
    public ResponseEntity<LoginModel> loginOng(LoginModel ong) {
        return ResponseEntity.ok(loginService.loginOng(ong));
    }
}
