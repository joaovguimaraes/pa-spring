package com.senai.projetoaplicado.controller;

import com.senai.projetoaplicado.dto.UserWithoutPasswordDTO;
import com.senai.projetoaplicado.dto.VotersDTO;
import com.senai.projetoaplicado.service.VotersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/voters")
public class VotersController {
    private final VotersService votersService;

    public VotersController(VotersService votersService) {
        this.votersService = votersService;
    }

    @GetMapping("{id}")
    public ResponseEntity<VotersDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(votersService.findById(id));
    }
}
