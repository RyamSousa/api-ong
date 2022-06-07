package com.api.ong.controller.impl;

import com.api.ong.controller.LoginController;
import com.api.ong.controller.LoginRegistrationController;
import com.api.ong.model.LoginModel;
import com.api.ong.model.LoginRegistrationModel;
import com.api.ong.model.OngModel;
import com.api.ong.model.UserModel;
import com.api.ong.service.LoginRegistrationService;
import com.api.ong.service.LoginService;
import com.api.ong.service.impl.LoginRegistrationServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoginRegistrationControllerImpl implements LoginRegistrationController {

    private final LoginRegistrationService loginRegistrationService;

    @Override
    public ResponseEntity<List<LoginRegistrationModel>> getAllRegisters() {
        return ResponseEntity.ok(loginRegistrationService.getAll());
    }
}
