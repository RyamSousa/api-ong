package com.api.ong.service;

import com.api.ong.model.AnimalModel;
import com.api.ong.model.ClinicalCaseModel;
import com.api.ong.model.OngModel;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface OngService {

    OngModel create(OngModel ong);

    OngModel update(OngModel ong);

    OngModel delete(Long id);

    OngModel getById(Long id);

    List<OngModel> getAll();

    List<AnimalModel> getAnimals(Long id);

    List<ClinicalCaseModel> getClinicalCases(Long id);
}
