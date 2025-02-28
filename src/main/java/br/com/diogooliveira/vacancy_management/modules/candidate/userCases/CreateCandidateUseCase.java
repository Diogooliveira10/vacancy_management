package br.com.diogooliveira.vacancy_management.modules.candidate.userCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diogooliveira.vacancy_management.exceptions.UserFoundException;
import br.com.diogooliveira.vacancy_management.modules.candidate.CandidateEntity;
import br.com.diogooliveira.vacancy_management.modules.candidate.CandidateRepository;

@Service
public class CreateCandidateUseCase {
    
    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository
            .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
            .ifPresent((user) -> {
                throw new UserFoundException();
            });

        return this.candidateRepository.save(candidateEntity);
    }
}
