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
@Table(name = "animal")
public class AnimalModel {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotNull
    private String specie;

    @ManyToOne
    private UserModel user;

    @ManyToOne
    private OngModel ong;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private List<ClinicalCaseModel> clinicalCases;
}
