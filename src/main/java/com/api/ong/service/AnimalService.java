package com.api.ong.service;

import com.api.ong.model.AnimalModel;
import com.api.ong.model.ClinicalCaseModel;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface AnimalService {

    AnimalModel create(AnimalModel animal);

    AnimalModel update(AnimalModel animal);

    AnimalModel delete(Long id);

    AnimalModel getById(Long id);

    List<ClinicalCaseModel> getClinicalCases(Long id);

    List<AnimalModel> getBySpecies(String specie);

    List<AnimalModel> getAll();
}
