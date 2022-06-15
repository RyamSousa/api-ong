package com.api.ong.service.impl;

import com.api.ong.model.LoginRegistrationModel;
import com.api.ong.repository.LoginRegistrationRepository;
import com.api.ong.service.LoginRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoginRegistrationServiceImpl implements LoginRegistrationService {

    private final LoginRegistrationRepository loginRegistrationRepository;

    @Override
    public List<LoginRegistrationModel> getAll() {
        return loginRegistrationRepository.findAll();
    }
}
