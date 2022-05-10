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
@Table(name = "caso_clinico")
public class ClinicalCaseModel {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotNull
    private Double targetValue;

    @NotNull
    private Double amountCollected;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private AnimalModel animal;

    @ManyToOne
    @JoinColumn(name = "ong_id")
    private OngModel ong;

    @JsonIgnore
    @OneToMany(mappedBy = "clinicalCase", cascade = ALL)
    private List<GrantModel> grants;
}
