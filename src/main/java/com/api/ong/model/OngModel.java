package com.api.ong.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ong")
public class OngModel {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String phone;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "ong", cascade = ALL)
    private List<AnimalModel> animals;

    @JsonIgnore
    @OneToMany(mappedBy = "ong", cascade = ALL)
    private List<ClinicalCaseModel> clinicalCases;
}
