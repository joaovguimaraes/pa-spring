package com.senai.projetoaplicado.dto;

import com.senai.projetoaplicado.model.Users;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ToString
@Data
public class UpdateUserDTO {

    @NotBlank(message = "name is required")
    private String name;
    @CPF(message = "cpf is not valid")
    private String cpf;
    @Email(message = "email is not valid")
    private String email;
    @Size(min = 6, message = "password has to have more than 5 digits")
    @NotBlank(message = "password is not valid")
    private String password;

    public void updateUser(Users users) {
        if (this.name != null) {
            users.setName(this.name);
        }
        if (this.cpf != null) {
            users.setCpf(this.cpf);
        }
        if (this.email != null) {
            users.setEmail(this.email);
        }
        if (this.password != null) {
            users.setPassword(this.password);
        }
    }
}
