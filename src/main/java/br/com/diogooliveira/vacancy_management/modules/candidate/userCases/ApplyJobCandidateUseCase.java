package br.com.diogooliveira.vacancy_management.modules.candidate.userCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diogooliveira.vacancy_management.exceptions.JobNotFoundException;
import br.com.diogooliveira.vacancy_management.exceptions.UserNotFoundException;
import br.com.diogooliveira.vacancy_management.modules.candidate.CandidateRepository;
import br.com.diogooliveira.vacancy_management.modules.candidate.entity.ApplyJobEntity;
import br.com.diogooliveira.vacancy_management.modules.candidate.repository.ApplyJobRepository;
import br.com.diogooliveira.vacancy_management.modules.company.repositories.JobRepository;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;
    
    // ID do Candidato
    // ID da Vaga
    public ApplyJobEntity execute(UUID idCandidate, UUID idJob) {
        // Validar se candidato existe
        this.candidateRepository.findById(idCandidate)
        .orElseThrow(() -> {
            throw new UserNotFoundException();
        });

        // Validar se a vaga existe
        this.jobRepository.findById(idJob)
        .orElseThrow(() -> {
            throw new JobNotFoundException();
        });

        // Candidato se inscrever na vaga
        var applyJob = ApplyJobEntity.builder()
            .candidateId(idCandidate)
            .jobId(idJob)
            .build();

        applyJob = applyJobRepository.save(applyJob);
        return applyJob;
    }
}
