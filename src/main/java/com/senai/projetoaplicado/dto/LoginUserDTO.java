package com.senai.projetoaplicado.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ToString
@Data
@RequiredArgsConstructor
public class LoginUserDTO {
    @Email(message = "email is not valid")
    private String email;
    
    private String code;
    @Size(min = 6, max = 30, message = "password has to have more than 5 digits")
    @NotBlank(message = "password is not valid")
    private String password;

    public LoginUserDTO(String email, String password, String code) {
        this.email = email;
        this.password = password;
        this.code = code;
    }
}
