package com.api.ong.service;

import com.api.ong.model.LoginModel;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface LoginService {

    LoginModel loginUser(LoginModel user);

    LoginModel loginOng(LoginModel ong);
}
