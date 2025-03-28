package br.com.diogooliveira.vacancy_management.modules.candidate.userCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diogooliveira.vacancy_management.modules.company.entities.JobEntity;
import br.com.diogooliveira.vacancy_management.modules.company.repositories.JobRepository;

@Service
public class ListAllJobsByFilterUseCase {

    @Autowired
    private JobRepository jogRepository;
    
    public List<JobEntity> execute(String filter) {
        return this.jogRepository.findByDescriptionContainingIgnoreCase(filter);
    }
}
