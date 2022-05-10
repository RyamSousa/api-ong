package com.api.ong.controller.impl;

import com.api.ong.controller.AnimalController;
import com.api.ong.model.AnimalModel;
import com.api.ong.model.ClinicalCaseModel;
import com.api.ong.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AnimalControllerImpl implements AnimalController {

    private final AnimalService animalService;

    @Override
    public ResponseEntity<AnimalModel> create(AnimalModel animal) {
        return ResponseEntity.ok(animalService.create(animal));
    }

    @Override
    public ResponseEntity<AnimalModel> update(AnimalModel animal) {
        return ResponseEntity.ok(animalService.update(animal));
    }

    @Override
    public ResponseEntity<AnimalModel> delete(Long id) {
        return ResponseEntity.ok(animalService.delete(id));
    }

    @Override
    public ResponseEntity<AnimalModel> getById(Long id) {
        return ResponseEntity.ok(animalService.getById(id));
    }

    @Override
    public ResponseEntity<List<ClinicalCaseModel>> getClinicalCases(Long id) {
        return ResponseEntity.ok(animalService.getClinicalCases(id));
    }

    @Override
    public ResponseEntity<List<AnimalModel>> getBySpecies(String specie) {
        return ResponseEntity.ok(animalService.getBySpecies(specie));
    }

    @Override
    public ResponseEntity<List<AnimalModel>> getAll() {
        return ResponseEntity.ok(animalService.getAll());
    }
}
