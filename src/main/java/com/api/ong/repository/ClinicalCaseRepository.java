package com.api.ong.repository;

import com.api.ong.model.ClinicalCaseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicalCaseRepository extends JpaRepository<ClinicalCaseModel, Long> {
}
