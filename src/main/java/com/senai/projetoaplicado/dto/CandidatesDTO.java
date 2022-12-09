package com.senai.projetoaplicado.dto;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;

@ToString
@Data
public class CandidatesDTO {

    @Id
    private Long id;

    private String ue;

    private String uf;

    private String electoralUnit;

    private String role;

    private String number;

    private String name;

    private String socialName;

    private String candidacyStatus;

    private String partyAcronym;

    private String partyName;

    private String nationality;

    private String stateOfBirth;

    private String cityOfBirth;

    private String birthdate;

    private String age;

    private String genre;


    private String educationDegree;

    private String maritalStatus;

    private String raceColor;

    public CandidatesDTO(Long id, String ue, String uf, String electoralUnit, String role, String number, String name, String socialName, String candidacyStatus, String partyAcronym, String partyName, String nationality, String stateOfBirth, String cityOfBirth, String birthdate, String age, String genre, String educationDegree, String maritalStatus, String raceColor) {
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
