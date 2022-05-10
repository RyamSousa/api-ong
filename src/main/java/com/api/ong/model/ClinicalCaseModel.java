package com.api.ong.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "caso_clinico")
public class ClinicalCaseModel {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @NotNull
    private Double targetValue;

    @NotNull
    private Double amountCollected;

    @ManyToOne
    private AnimalModel animal;

    @ManyToOne
    private OngModel ong;

    @OneToMany(mappedBy = "clinicalCase", cascade = CascadeType.ALL)
    private List<GrantModel> grants;
}
