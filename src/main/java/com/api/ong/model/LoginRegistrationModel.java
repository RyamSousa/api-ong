package com.api.ong.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Document(collection = "login-registration")
public class LoginRegistrationModel {

    public LoginRegistrationModel(String email, String date) {
        this.email = email;
        this.date = date;
    }

    @Id
    private String id;

    @NotNull
    private String email;

    @NotNull
    private String date;
}
