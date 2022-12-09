package com.senai.projetoaplicado.dto;

import com.senai.projetoaplicado.model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ToString
@Data
public class CreateUserDTO {
    @NotBlank(message = "name is required")
    private String name;

    @CPF(message = "cpf is not valid")
    private String cpf;

    @Email(message = "email is not valid")
    private String email;

    @Size(min = 6, max = 30, message = "password has to have more than 5 digits")
    @NotBlank(message = "password is not valid")
    private String password;

    public CreateUserDTO(String name, String cpf, String email, String password) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
    }

    public Users toUser() {
        return new Users(
                this.name,
                this.cpf,
                this.email,
                this.password
        );
    }
}
