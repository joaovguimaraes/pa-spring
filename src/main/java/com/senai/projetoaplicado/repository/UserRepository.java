package com.senai.projetoaplicado.repository;

import com.senai.projetoaplicado.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {
    public Optional<Users> findByEmail(String email);

    public Optional<Users> findByCode(String code);
}
