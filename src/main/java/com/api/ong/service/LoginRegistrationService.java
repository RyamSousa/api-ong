package com.api.ong.service;

import com.api.ong.model.LoginRegistrationModel;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface LoginRegistrationService {

    List<LoginRegistrationModel> getAll();
}
