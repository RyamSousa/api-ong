package com.api.ong.repository;

import com.api.ong.model.AnimalModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnimalRepository extends JpaRepository<AnimalModel, Long> {

    Optional<List<AnimalModel>> findBySpecie(String specie);
}
