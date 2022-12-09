package com.senai.projetoaplicado.repository;

import com.senai.projetoaplicado.model.Candidates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatesRepository extends JpaRepository<Candidates, Long> {
}
