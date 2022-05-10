package com.api.ong.repository;

import com.api.ong.model.OngModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OngRepository extends JpaRepository<OngModel, Long> {
}
