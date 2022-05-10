package com.api.ong.controller.impl;

import com.api.ong.controller.ClinicalCaseController;
import com.api.ong.model.ClinicalCaseModel;
import com.api.ong.model.GrantModel;
import com.api.ong.service.ClinicalCaseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClinicalCaseControllerImpl implements ClinicalCaseController {

    private final ClinicalCaseService clinicalCaseService;

    @Override
    public ResponseEntity<ClinicalCaseModel> create(ClinicalCaseModel clinicalCase) {
        return ResponseEntity.ok(clinicalCaseService.create(clinicalCase));
    }

    @Override
    public ResponseEntity<ClinicalCaseModel> update(ClinicalCaseModel clinicalCase) {
        return ResponseEntity.ok(clinicalCaseService.update(clinicalCase));
    }

    @Override
    public ResponseEntity<ClinicalCaseModel> delete(Long id) {
        return ResponseEntity.ok(clinicalCaseService.delete(id));
    }

    @Override
    public ResponseEntity<ClinicalCaseModel> getById(Long id) {
        return ResponseEntity.ok(clinicalCaseService.getById(id));
    }

    @Override
    public ResponseEntity<List<GrantModel>> getGrants(Long id) {
        return ResponseEntity.ok(clinicalCaseService.getGrants(id));
    }

    @Override
    public ResponseEntity<List<ClinicalCaseModel>> getAll() {
        return ResponseEntity.ok(clinicalCaseService.getAll());
    }
}
