package com.senai.projetoaplicado.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
@RequiredArgsConstructor
public class Candidates {

    @Id
    private Long id;

    @Column(name = "sigla")
    private String ue;

    @Column(name = "sigla_unidade_da_federacao")
    private String uf;

    @Column(name = "nome_unidade_eleitoral")
    private String electoralUnit;

    @Column(name = "cargo_eleicao")
    private String role;

    @Column(name = "numero_candidato")
    private String number;

    @Column(name = "nome_candidato")
    private String name;

    @Column(name = "nome_social_candidato")
    private String socialName;

    @Column(name = "situacao_candidatura")
    private String candidacyStatus;

    @Column(name = "sigla_partido")
    private String partyAcronym;

    @Column(name = "nome_partido")
    private String partyName;

    @Column(name = "nacionalidade")
    private String nationality;

    @Column(name = "uf_nascimento")
    private String stateOfBirth;

    @Column(name = "municipio_nascimento")
    private String cityOfBirth;

    @Column(name = "data_nascimento")
    private String birthdate;

    @Column(name = "idade")
    private String age;

    @Column(name = "genero")
    private String genre;

    @Column(name = "grau_instrucao")
    private String educationDegree;

    @Column(name = "estado_civil")
    private String maritalStatus;

    @Column(name = "cor_raca")
    private String raceColor;

    public Candidates(Long id, String ue, String uf, String electoralUnit, String role, String number, String name, String socialName, String candidacyStatus, String partyAcronym, String partyName, String nationality, String stateOfBirth, String cityOfBirth, String birthdate, String age, String genre, String educationDegree, String maritalStatus, String raceColor) {
        this.id = id;
        this.ue = ue;
        this.uf = uf;
        this.electoralUnit = electoralUnit;
        this.role = role;
        this.number = number;
        this.name = name;
        this.socialName = socialName;
        this.candidacyStatus = candidacyStatus;
        this.partyAcronym = partyAcronym;
        this.partyName = partyName;
        this.nationality = nationality;
        this.stateOfBirth = stateOfBirth;
        this.cityOfBirth = cityOfBirth;
        this.birthdate = birthdate;
        this.age = age;
        this.genre = genre;
        this.educationDegree = educationDegree;
        this.maritalStatus = maritalStatus;
        this.raceColor = raceColor;
    }
}
