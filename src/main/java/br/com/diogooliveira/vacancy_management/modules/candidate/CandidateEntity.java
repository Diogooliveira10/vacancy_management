package br.com.diogooliveira.vacancy_management.modules.candidate;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data // Criando os getters e setters para todos os atributos para CandidateEntity
public class CandidateEntity { // Informações do candidato
    
    private UUID id;
    private String name;

    @Pattern(regexp =  "^(?!\\s*$).+", message =  "The 'username' field should not contain spaces.")
    private String username;

    @Email(message = "The 'email' field must contain a valid email.")
    private String email;

    @Length(min = 10, max = 100)
    private String password;
    private String description;
    private String curriculum;

}
