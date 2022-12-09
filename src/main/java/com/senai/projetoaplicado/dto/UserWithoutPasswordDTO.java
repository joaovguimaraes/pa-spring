package com.senai.projetoaplicado.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@ToString
@Data
@RequiredArgsConstructor
public class UserWithoutPasswordDTO {
    @NotBlank(message = "name is required")
    private String name;
    @CPF(message = "cpf is not valid")
    private String cpf;
    @Email(message = "email is not valid")
    private String email;

    private String code;

    public UserWithoutPasswordDTO(String name, String cpf, String email, String code) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.code = code;
    }
}
