package com.senai.projetoaplicado.controller;

import com.senai.projetoaplicado.dto.CreateUserDTO;
import com.senai.projetoaplicado.dto.UpdateUserDTO;
import com.senai.projetoaplicado.dto.UserWithoutPasswordDTO;
import com.senai.projetoaplicado.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public ResponseEntity<UserWithoutPasswordDTO> findById(@PathVariable String id, @RequestHeader("Authorization") String bearerToken) {
        if (userService.validate(bearerToken)) {
            return ResponseEntity.ok(userService.findById(id));
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Not authorized.");
    }

    @PostMapping()
    public ResponseEntity<UserWithoutPasswordDTO> createUser(@RequestBody @Valid CreateUserDTO createUserDTO) {
        return new ResponseEntity<>(userService.createUser(createUserDTO), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserWithoutPasswordDTO> update(@RequestHeader("Authorization") String bearerToken, @PathVariable String id, @RequestBody @Valid UpdateUserDTO updateUserDTO) {
        if (userService.validate(bearerToken)) {
            return new ResponseEntity<>(userService.update(id, updateUserDTO), HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Not authorized.");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@RequestHeader("Authorization") String bearerToken, @PathVariable String id) {
        if (userService.validate(bearerToken)) {
            userService.delete(id);
            return new ResponseEntity<>("Users delete successfully", HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Not authorized.");
    }
}
