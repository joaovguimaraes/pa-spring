package com.senai.projetoaplicado.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@RequiredArgsConstructor
public class Voters {
    @Id
    private Long id;
    @Column(name = "sigla_uf")
    private String state;
    @Column(name = "nome_municipio")
    private String city;
    @Column(name = "numero_zona")
    private String zoneNumber;
    @Column(name = "genero")
    private String gender;
    @Column(name = "estado_civil")
    private String maritalStatus;
    @Column(name = "faixa_etaria")
    private String ageGroup;
    @Column(name = "grau_escolaridade")
    private String educationalDegree;
    @Column(name = "quantidade_de_eleitores")
    private String qtnVoters;
    @Column(name = "quantidade_de_eleitores_deficientes")
    private String qtnVotersDisabled;

    public Voters(Long id, String state, String city, String zoneNumber, String gender, String maritalStatus, String ageGroup, String educationalDegree, String qtnVoters, String qtnVotersDisabled) {
        this.id = id;
        this.state = state;
        this.city = city;
        this.zoneNumber = zoneNumber;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.ageGroup = ageGroup;
        this.educationalDegree = educationalDegree;
        this.qtnVoters = qtnVoters;
        this.qtnVotersDisabled = qtnVotersDisabled;
    }
}
