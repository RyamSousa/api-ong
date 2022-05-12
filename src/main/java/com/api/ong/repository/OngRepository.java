package com.api.ong.repository;

import com.api.ong.model.OngModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OngRepository extends JpaRepository<OngModel, Long> {

    Optional<OngModel> findByEmail(String email);
}
