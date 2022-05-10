package com.api.ong.service;

import com.api.ong.model.ClinicalCaseModel;
import com.api.ong.model.GrantModel;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface ClinicalCaseService {

    ClinicalCaseModel create(ClinicalCaseModel clinicalCase);

    ClinicalCaseModel update(ClinicalCaseModel clinicalCase);

    ClinicalCaseModel delete(Long id);

    ClinicalCaseModel getById(Long id);

    List<GrantModel> getGrants(Long id);

    List<ClinicalCaseModel> getAll();
}
