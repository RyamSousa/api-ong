package com.api.ong.service.impl;

import com.api.ong.model.AnimalModel;
import com.api.ong.model.ClinicalCaseModel;
import com.api.ong.model.GrantModel;
import com.api.ong.model.OngModel;
import com.api.ong.repository.AnimalRepository;
import com.api.ong.repository.ClinicalCaseRepository;
import com.api.ong.repository.OngRepository;
import com.api.ong.service.AnimalService;
import com.api.ong.service.ClinicalCaseService;
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
public class ClinicalCaseServiceImpl implements ClinicalCaseService {

    private final ClinicalCaseRepository clinicalCaseRepository;
    private final OngService ongService;
    private final AnimalService animalService;

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

        AnimalModel animalById = animalService.getById(clinicalCase.getAnimal().getId());
        OngModel ongById = ongService.getById(clinicalCase.getOng().getId());

        clinicalCase.setAnimal(animalById);
        clinicalCase.setOng(ongById);

        return clinicalCaseRepository.save(clinicalCase);
    }

    @Override
    public ClinicalCaseModel update(@NotNull ClinicalCaseModel clinicalCase) {
        if (clinicalCase.getId() == null) {
            throw new ResponseStatusException(BAD_REQUEST, ID_CANT_BE_NULL);
        }

        animalService.getById(clinicalCase.getAnimal().getId());
        ongService.getById(clinicalCase.getOng().getId());

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
            throw new ResponseStatusException(NOT_FOUND, CLINICAL_CASE_NOT_FOUND);
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
