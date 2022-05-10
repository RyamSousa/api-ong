package com.api.ong.service.impl;

import com.api.ong.model.AnimalModel;
import com.api.ong.model.GrantModel;
import com.api.ong.model.UserModel;
import com.api.ong.repository.UserRepository;
import com.api.ong.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

import static com.api.ong.Utils.Message.*;
import static org.springframework.http.HttpStatus.*;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserModel create(@NotNull UserModel user) {
        if (user.getId() != null) {
            Optional<UserModel> userById = userRepository.findById(user.getId());

            userById.ifPresent(u -> {
                if (u.getEmail().equals(user.getEmail()) || u.getId().equals(user.getId())) {
                    throw new ResponseStatusException(CONFLICT, RESOURCE_ALREADY_EXISTS);
                }
            });
        }

        return userRepository.save(user);
    }

    @Override
    public UserModel update(@NotNull UserModel user) {
        if (user.getId() == null) {
            throw new ResponseStatusException(BAD_REQUEST, ID_CANT_BE_NULL);
        }

        return userRepository.save(user);
    }

    @Override
    public UserModel delete(@NotNull Long id) {
        Optional<UserModel> userById = userRepository.findById(id);

        if (userById.isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, RESOURCE_NOT_FOUND);
        }
        userRepository.deleteById(userById.get().getId());

        return userById.get();
    }

    @Override
    public UserModel getById(@NotNull Long id) {
        Optional<UserModel> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, RESOURCE_NOT_FOUND);
        }

        return user.get();
    }

    @Override
    public List<GrantModel> getGrants(Long id) {
        Optional<UserModel> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, RESOURCE_NOT_FOUND);
        }
        return user.get().getGrants();
    }

    @Override
    public List<AnimalModel> getAnimals(Long id) {
        Optional<UserModel> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, RESOURCE_NOT_FOUND);
        }
        return user.get().getAnimalModels();
    }

    @Override
    public List<UserModel> getAll() {
        List<UserModel> allUsers = userRepository.findAll();

        if (allUsers.isEmpty()) {
            throw new ResponseStatusException(NO_CONTENT, NO_RECORDS_FOUND);
        }

        return allUsers;
    }
}
