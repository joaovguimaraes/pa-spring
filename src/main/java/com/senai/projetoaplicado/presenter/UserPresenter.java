package com.senai.projetoaplicado.presenter;

import com.senai.projetoaplicado.dto.CreateUserDTO;
import com.senai.projetoaplicado.dto.UserWithoutPasswordDTO;
import com.senai.projetoaplicado.service.UserService;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class UserPresenter {
    private final UserService userService;

    public UserPresenter(@Valid UserService userService) {
        this.userService = userService;
    }

    public UserWithoutPasswordDTO createUser(CreateUserDTO createUserDTO) {
        return userService.createUser(createUserDTO);
    }
}
