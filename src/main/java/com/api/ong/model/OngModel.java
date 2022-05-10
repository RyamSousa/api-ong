package com.api.ong.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

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
    private String address;

    @OneToMany(mappedBy = "ong", cascade = CascadeType.ALL)
    private List<AnimalModel> animalModels;

    @OneToMany(mappedBy = "ong", cascade = CascadeType.ALL)
    private List<ClinicalCaseModel> clinicalCases;
}
