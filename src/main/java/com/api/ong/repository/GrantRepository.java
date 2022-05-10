package com.api.ong.repository;

import com.api.ong.model.GrantModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrantRepository extends JpaRepository<GrantModel, Long> {
}
