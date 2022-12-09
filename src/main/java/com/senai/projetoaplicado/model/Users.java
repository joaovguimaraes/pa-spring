package com.senai.projetoaplicado.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class Users {
    @Id
    private String id;
    private String name;
    private String cpf;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(unique = true)
    private String code;

    public Users(String name, String cpf, String email, String password) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.code = name+"_"+UUID.randomUUID().toString();
    }
}
