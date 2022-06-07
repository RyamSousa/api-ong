package com.api.ong.repository;

import com.api.ong.model.LoginRegistrationModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoginRegistrationRepository extends MongoRepository<LoginRegistrationModel, String> {
}
