package com.api.ong.service.impl;

import com.api.ong.model.AnimalModel;
import com.api.ong.model.ClinicalCaseModel;
import com.api.ong.model.OngModel;
import com.api.ong.model.UserModel;
import com.api.ong.repository.AnimalRepository;
import com.api.ong.repository.OngRepository;
import com.api.ong.repository.UserRepository;
import com.api.ong.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

import static com.api.ong.utils.Utils.*;
import static org.springframework.http.HttpStatus.*;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;
    private final UserRepository userRepository;
    private final OngRepository ongRepository;

    @Override
    public AnimalModel create(@NotNull AnimalModel animal) {
        if (animal.getId() != null) {
            Optional<AnimalModel> animalById = animalRepository.findById(animal.getId());

            animalById.ifPresent(a -> {
                if (a.getUser().getId().equals(animal.getId()) && a.getId().equals(animal.getId())) {
                    throw new ResponseStatusException(CONFLICT, RESOURCE_ALREADY_EXISTS);
                }
            });

            Optional<UserModel> userById = userRepository.findById(animal.getUser().getId());
            Optional<OngModel> ongById = ongRepository.findById(animal.getOng().getId());

            if (ongById.isEmpty()) {
                throw new ResponseStatusException(BAD_REQUEST, USER_OR_ONG_NOT_FOUND);
            }

            userById.ifPresent(userModel -> animal.setUser(userById.get()));
            animal.setOng(ongById.get());
        }

        return animalRepository.save(animal);
    }

    @Override
    public AnimalModel update(@NotNull AnimalModel animal) {
        if (animal.getId() == null) {
            throw new ResponseStatusException(BAD_REQUEST, ID_CANT_BE_NULL);
        }

        return animalRepository.save(animal);
    }

    @Override
    public AnimalModel delete(@NotNull Long id) {
        Optional<AnimalModel> animalById = animalRepository.findById(id);

        if (animalById.isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, RESOURCE_NOT_FOUND);
        }
        animalRepository.deleteById(animalById.get().getId());

        return animalById.get();
    }

    @Override
    public AnimalModel getById(@NotNull Long id) {
        Optional<AnimalModel> animal = animalRepository.findById(id);

        if (animal.isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, RESOURCE_NOT_FOUND);
        }

        return animal.get();
    }

    @Override
    public List<ClinicalCaseModel> getClinicalCases(@NotNull Long id) {
        Optional<AnimalModel> animal = animalRepository.findById(id);

        if (animal.isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, RESOURCE_NOT_FOUND);
        }

        return animal.get().getClinicalCases();
    }

    @Override
    public List<AnimalModel> getBySpecies(String specie) {
        Optional<List<AnimalModel>> animals = animalRepository.findBySpecie(specie);

        if (animals.isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, RESOURCE_NOT_FOUND);
        }

        return animals.get();
    }

    @Override
    public List<AnimalModel> getAll() {
        List<AnimalModel> allAnimals = animalRepository.findAll();

        if (allAnimals.isEmpty()) {
            throw new ResponseStatusException(NO_CONTENT, NO_RECORDS_FOUND);
        }

        return allAnimals;
    }
}
