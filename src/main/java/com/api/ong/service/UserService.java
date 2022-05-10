package com.api.ong.service;

import com.api.ong.model.UserModel;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface UserService {

    UserModel create(UserModel user);

    UserModel update(UserModel user);

    UserModel delete(Long id);

    UserModel getById(Long id);

    List<UserModel> getAll();
}
