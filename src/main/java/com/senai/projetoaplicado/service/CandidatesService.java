package com.senai.projetoaplicado.service;


import com.senai.projetoaplicado.dto.CandidatesDTO;
import com.senai.projetoaplicado.model.Candidates;
import com.senai.projetoaplicado.repository.CandidatesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CandidatesService {

    private final CandidatesRepository candidatesRepository;

    public CandidatesService(CandidatesRepository candidatesRepository) {
        this.candidatesRepository = candidatesRepository;
    }

    public CandidatesDTO findById(Long id) {
        Optional<Candidates> candidate = candidatesRepository.findById(id);
        if (candidate.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This user does not exists.");
        }
        return new CandidatesDTO(
                candidate.get().getId(),
                candidate.get().getUe(),
                candidate.get().getUf(),
                candidate.get().getElectoralUnit(),
                candidate.get().getRole(),
                candidate.get().getNumber(),
                candidate.get().getName(),
                candidate.get().getSocialName(),
                candidate.get().getCandidacyStatus(),
                candidate.get().getPartyAcronym(),
                candidate.get().getPartyName(),
                candidate.get().getNationality(),
                candidate.get().getStateOfBirth(),
                candidate.get().getCityOfBirth(),
                candidate.get().getBirthdate(),
                candidate.get().getAge(),
                candidate.get().getGenre(),
                candidate.get().getEducationDegree(),
                candidate.get().getMaritalStatus(),
                candidate.get().getRaceColor()
        );
    }
}
