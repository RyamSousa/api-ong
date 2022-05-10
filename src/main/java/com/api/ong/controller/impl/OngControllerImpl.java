package com.api.ong.controller.impl;

import com.api.ong.controller.OngController;
import com.api.ong.model.AnimalModel;
import com.api.ong.model.ClinicalCaseModel;
import com.api.ong.model.OngModel;
import com.api.ong.service.OngService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OngControllerImpl implements OngController {

    private final OngService ongService;

    @Override
    public ResponseEntity<OngModel> create(OngModel ong) {
        return ResponseEntity.ok(ongService.create(ong));
    }

    @Override
    public ResponseEntity<OngModel> update(OngModel ong) {
        return ResponseEntity.ok(ongService.update(ong));
    }

    @Override
    public ResponseEntity<OngModel> delete(Long id) {
        return ResponseEntity.ok(ongService.delete(id));
    }

    @Override
    public ResponseEntity<OngModel> getById(Long id) {
        return ResponseEntity.ok(ongService.getById(id));
    }

    @Override
    public ResponseEntity<List<AnimalModel>> getAnimals(Long id) {
        return ResponseEntity.ok(ongService.getAnimals(id));
    }

    @Override
    public ResponseEntity<List<ClinicalCaseModel>> getClinicalCases(Long id) {
        return ResponseEntity.ok(ongService.getClinicalCases(id));
    }

    @Override
    public ResponseEntity<List<OngModel>> getAll() {
        return ResponseEntity.ok(ongService.getAll());
    }
}
