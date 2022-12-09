package com.senai.projetoaplicado.controller;

import com.senai.projetoaplicado.dto.CandidatesDTO;
import com.senai.projetoaplicado.service.CandidatesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidates")
public class CandidatesController {
    private final CandidatesService candidatesService;


    public CandidatesController(CandidatesService candidatesService) {
        this.candidatesService = candidatesService;
    }

    @GetMapping("{id}")
    public ResponseEntity<CandidatesDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(candidatesService.findById(id));
    }
}
