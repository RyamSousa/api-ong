package com.api.ong.service;

import com.api.ong.model.LoginModel;
import com.api.ong.model.OngModel;
import com.api.ong.model.UserModel;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface LoginService {

    UserModel loginUser(LoginModel user);

    OngModel loginOng(LoginModel ong);
}
