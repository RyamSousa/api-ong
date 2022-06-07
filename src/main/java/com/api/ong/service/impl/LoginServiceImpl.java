package com.api.ong.service.impl;

import com.api.ong.model.LoginModel;
import com.api.ong.model.LoginRegistrationModel;
import com.api.ong.model.OngModel;
import com.api.ong.model.UserModel;
import com.api.ong.repository.LoginRegistrationRepository;
import com.api.ong.repository.OngRepository;
import com.api.ong.repository.UserRepository;
import com.api.ong.service.LoginService;
import com.api.ong.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static com.api.ong.utils.Utils.*;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoginServiceImpl implements LoginService {

    private final LoginRegistrationRepository loginRegistrationRepository;
    private final OngRepository ongRepository;
    private final UserRepository userRepository;

    @Override
    public UserModel loginUser(LoginModel user) {
        Optional<UserModel> userById = userRepository.findByEmail(user.getEmail());
        user.setPassword(encryptPassword(user.getPassword()));

        userById.ifPresentOrElse(u -> {
            if (!u.getEmail().equals(user.getEmail()) || !u.getPassword().equals(user.getPassword())) {
                throw new ResponseStatusException(UNAUTHORIZED, EMAIL_OR_PASSWORD_INCORRECT);
            }
        }, () -> {
            throw new ResponseStatusException(NOT_FOUND, RESOURCE_NOT_FOUND);
        });

        loginRegistrationRepository.save(new LoginRegistrationModel(user.getEmail(), Utils.generateDate()));

        return userById.get();
    }

    @Override
    public OngModel loginOng(LoginModel ong) {
        Optional<OngModel> ongById = ongRepository.findByEmail(ong.getEmail());
        ong.setPassword(encryptPassword(ong.getPassword()));

        ongById.ifPresentOrElse(u -> {
            if (!u.getEmail().equals(ong.getEmail()) || !u.getPassword().equals(ong.getPassword())) {
                throw new ResponseStatusException(UNAUTHORIZED, EMAIL_OR_PASSWORD_INCORRECT);
            }
        }, () -> {
            throw new ResponseStatusException(NOT_FOUND, RESOURCE_NOT_FOUND);
        });

        loginRegistrationRepository.save(new LoginRegistrationModel(ong.getEmail(), Utils.generateDate()));

        return ongById.get();
    }
}
