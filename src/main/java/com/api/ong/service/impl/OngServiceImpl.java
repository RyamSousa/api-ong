package com.api.ong.service.impl;

import com.api.ong.model.AnimalModel;
import com.api.ong.model.ClinicalCaseModel;
import com.api.ong.model.OngModel;
import com.api.ong.repository.OngRepository;
import com.api.ong.service.OngService;
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
public class OngServiceImpl implements OngService {

    private final OngRepository ongRepository;

    @Override
    public OngModel create(@NotNull OngModel ong) {
        if (ong.getId() != null) {
            Optional<OngModel> ongById = ongRepository.findById(ong.getId());

            ongById.ifPresent(o -> {
                if (o.getEmail().equals(ong.getEmail()) || o.getId().equals(ong.getId())) {
                    throw new ResponseStatusException(CONFLICT, RESOURCE_ALREADY_EXISTS);
                }
            });
        }
        ong.setPassword(encryptPassword(ong.getPassword()));

        return ongRepository.save(ong);
    }

    @Override
    public OngModel update(@NotNull OngModel ong) {
        if (ong.getId() == null) {
            throw new ResponseStatusException(BAD_REQUEST, ID_CANT_BE_NULL);
        }

        return ongRepository.save(ong);
    }

    @Override
    public OngModel delete(@NotNull Long id) {
        Optional<OngModel> ongById = ongRepository.findById(id);

        if (ongById.isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, RESOURCE_NOT_FOUND);
        }
        ongRepository.deleteById(ongById.get().getId());

        return ongById.get();
    }

    @Override
    public OngModel getById(@NotNull Long id) {
        Optional<OngModel> ong = ongRepository.findById(id);

        if (ong.isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, RESOURCE_NOT_FOUND);
        }

        return ong.get();
    }

    @Override
    public List<OngModel> getAll() {
        List<OngModel> allOng = ongRepository.findAll();

        if (allOng.isEmpty()) {
            throw new ResponseStatusException(NO_CONTENT, NO_RECORDS_FOUND);
        }

        return allOng;
    }

    @Override
    public List<AnimalModel> getAnimals(Long id) {
        Optional<OngModel> allOng = ongRepository.findById(id);

        if (allOng.isEmpty()) {
            throw new ResponseStatusException(NO_CONTENT, NO_RECORDS_FOUND);
        }

        return allOng.get().getAnimals();
    }

    @Override
    public List<ClinicalCaseModel> getClinicalCases(Long id) {
        Optional<OngModel> allOng = ongRepository.findById(id);

        if (allOng.isEmpty()) {
            throw new ResponseStatusException(NO_CONTENT, NO_RECORDS_FOUND);
        }

        return allOng.get().getClinicalCases();
    }
}
