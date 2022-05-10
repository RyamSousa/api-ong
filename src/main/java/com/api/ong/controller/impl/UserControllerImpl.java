package com.api.ong.controller.impl;

import com.api.ong.controller.UserController;
import com.api.ong.model.UserModel;
import com.api.ong.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static com.api.ong.Utils.Message.ID_CANT_BE_NULL;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

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
    public ResponseEntity<List<UserModel>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }
}
