package com.api.ong.service.impl;

import com.api.ong.model.AnimalModel;
import com.api.ong.model.ClinicalCaseModel;
import com.api.ong.model.GrantModel;
import com.api.ong.model.OngModel;
import com.api.ong.repository.AnimalRepository;
import com.api.ong.repository.ClinicalCaseRepository;
import com.api.ong.repository.OngRepository;
import com.api.ong.service.ClinicalCaseService;
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
public class ClinicalCaseServiceImpl implements ClinicalCaseService {

    private final ClinicalCaseRepository clinicalCaseRepository;
    private final OngRepository ongRepository;
    private final AnimalRepository animalRepository;

    @Override
    public ClinicalCaseModel create(@NotNull ClinicalCaseModel clinicalCase) {
        if (clinicalCase.getId() != null) {
            Optional<ClinicalCaseModel> clinicalCaseById = clinicalCaseRepository.findById(clinicalCase.getId());

            clinicalCaseById.ifPresent(cc -> {
                if (cc.getId().equals(clinicalCase.getId())) {
                    throw new ResponseStatusException(CONFLICT, RESOURCE_ALREADY_EXISTS);
                }
            });
        }

        Optional<AnimalModel> animalById = animalRepository.findById(clinicalCase.getAnimal().getId());
        Optional<OngModel> ongById = ongRepository.findById(clinicalCase.getOng().getId());

        if (ongById.isEmpty() || animalById.isEmpty()) {
            throw new ResponseStatusException(BAD_REQUEST, USER_OR_ONG_NOT_FOUND);
        }

        clinicalCase.setAnimal(animalById.get());
        clinicalCase.setOng(ongById.get());

        return clinicalCaseRepository.save(clinicalCase);
    }

    @Override
    public ClinicalCaseModel update(@NotNull ClinicalCaseModel clinicalCase) {
        if (clinicalCase.getId() == null) {
            throw new ResponseStatusException(BAD_REQUEST, ID_CANT_BE_NULL);
        }

        return clinicalCaseRepository.save(clinicalCase);
    }

    @Override
    public ClinicalCaseModel delete(@NotNull Long id) {
        Optional<ClinicalCaseModel> clinicalCaseById = clinicalCaseRepository.findById(id);

        if (clinicalCaseById.isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, RESOURCE_NOT_FOUND);
        }
        clinicalCaseRepository.deleteById(clinicalCaseById.get().getId());

        return clinicalCaseById.get();
    }

    @Override
    public ClinicalCaseModel getById(@NotNull Long id) {
        Optional<ClinicalCaseModel> clinicalCase = clinicalCaseRepository.findById(id);

        if (clinicalCase.isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, RESOURCE_NOT_FOUND);
        }

        return clinicalCase.get();
    }

    @Override
    public List<GrantModel> getGrants(Long id) {
        Optional<ClinicalCaseModel> clinicalCase = clinicalCaseRepository.findById(id);

        if (clinicalCase.isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, RESOURCE_NOT_FOUND);
        }
        return clinicalCase.get().getGrants();
    }

    @Override
    public List<ClinicalCaseModel> getAll() {
        List<ClinicalCaseModel> allClinicalCases = clinicalCaseRepository.findAll();

        if (allClinicalCases.isEmpty()) {
            throw new ResponseStatusException(NO_CONTENT, NO_RECORDS_FOUND);
        }

        return allClinicalCases;
    }
}
