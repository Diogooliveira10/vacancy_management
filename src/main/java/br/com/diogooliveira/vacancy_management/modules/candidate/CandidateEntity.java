package br.com.diogooliveira.vacancy_management.modules.candidate;

import java.util.UUID;

import lombok.Data;

@Data // Criando os getters e setters para todos os atributos para CandidateEntity
public class CandidateEntity { // Informações do candidato
    
    private UUID id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String description;
    private String curriculum;

}
