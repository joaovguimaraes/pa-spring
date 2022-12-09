package com.senai.projetoaplicado.service;

import com.senai.projetoaplicado.dto.CreateUserDTO;
import com.senai.projetoaplicado.dto.LoginUserDTO;
import com.senai.projetoaplicado.dto.UpdateUserDTO;
import com.senai.projetoaplicado.dto.UserWithoutPasswordDTO;
import com.senai.projetoaplicado.model.Users;
import com.senai.projetoaplicado.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public UserWithoutPasswordDTO createUser(CreateUserDTO createUserDTO) {
        if (createUserDTO == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid body.");
        }

        createUserDTO.setPassword(encoder.encode(createUserDTO.getPassword()));
        Users users = createUserDTO.toUser();
        userRepository.save(users);
        return new UserWithoutPasswordDTO(users.getName(), users.getCpf(), users.getEmail(), users.getCode());
    }

    public Boolean validate(String bearerToken) {
        Optional<Users> user = userRepository.findByCode(bearerToken);
        return user.get().getCode() != null;
    }


    public UserWithoutPasswordDTO findById(String id) {
        Optional<Users> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This user does not exists.");
        }
        return new UserWithoutPasswordDTO(
                user.get().getName(),
                user.get().getCpf(),
                user.get().getEmail(),
                user.get().getCode()
        );
    }

    public UserWithoutPasswordDTO update(String id, UpdateUserDTO updateUserDTO) {
        if (updateUserDTO == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid body.");
        }

        Users users = userRepository.findById(id).orElse(null);
        if (users == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This users does not exists.");
        }

        updateUserDTO.updateUser(users);
        userRepository.save(users);

        return new UserWithoutPasswordDTO(
                users.getName(),
                users.getCpf(),
                users.getEmail(),
                users.getCode()
        );
    }

    public void delete(String id) {
        Optional<Users> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
        }
    }
}
