package com.api.ong.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "doacao")
public class GrantModel {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @NotNull
    private Double value;

    @ManyToOne
    private UserModel user;

    @ManyToOne
    private ClinicalCaseModel clinicalCase;
}
