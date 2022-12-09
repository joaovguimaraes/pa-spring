package com.senai.projetoaplicado.service;

import com.senai.projetoaplicado.dto.VotersDTO;
import com.senai.projetoaplicado.model.Voters;
import com.senai.projetoaplicado.repository.VotersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class VotersService {
    private final VotersRepository votersRepository;

    public VotersService(VotersRepository votersRepository) {
        this.votersRepository = votersRepository;
    }


    public VotersDTO findById(Long id) {
        Optional<Voters> voter = votersRepository.findById(id);
        if (voter.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This voter does not exists.");
        }

        return new VotersDTO(voter.get().getId(), voter.get().getState(), voter.get().getCity(), voter.get().getZoneNumber(), voter.get().getGender(), voter.get().getMaritalStatus(), voter.get().getAgeGroup(), voter.get().getEducationalDegree(), voter.get().getQtnVoters(), voter.get().getQtnVotersDisabled());
    }
}
