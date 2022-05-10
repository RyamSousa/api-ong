package com.api.ong.controller.impl;

import com.api.ong.controller.UserController;
import com.api.ong.model.AnimalModel;
import com.api.ong.model.GrantModel;
import com.api.ong.model.UserModel;
import com.api.ong.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public ResponseEntity<UserModel> create(UserModel user) {
        return ResponseEntity.ok(userService.create(user));
    }

    @Override
    public ResponseEntity<UserModel> update(UserModel user) {
        return ResponseEntity.ok(userService.update(user));
    }

    @Override
    public ResponseEntity<UserModel> delete(Long id) {
        return ResponseEntity.ok(userService.delete(id));
    }

    @Override
    public ResponseEntity<UserModel> getById(Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @Override
    public ResponseEntity<List<GrantModel>> getGrants(Long id) {
        return ResponseEntity.ok(userService.getGrants(id));
    }

    @Override
    public ResponseEntity<List<AnimalModel>> getAnimals(Long id) {
        return ResponseEntity.ok(userService.getAnimals(id));
    }

    @Override
    public ResponseEntity<List<UserModel>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }
}
