package br.com.diogooliveira.vacancy_management.modules.candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data // Criando os getters e setters para todos os atributos para CandidateEntity
@Entity(name = "candidate")
public class CandidateEntity { // Informações do candidato
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(
        example = "John Doe",
        requiredMode = RequiredMode.REQUIRED,
        description = "Candidate's name."
    )
    private String name;

    @NotBlank()
    @Pattern(regexp =  "\\S+", message =  "The [username] field should not contain spaces.")
    @Schema(
        example = "johndoe",
        requiredMode = RequiredMode.REQUIRED,
        description = "Candidate's username."
    )
    private String username;

    @Email(message = "The [email] field must contain a valid email.")
    @Schema(
        example = "Johndoe@gmail.com",
        requiredMode = RequiredMode.REQUIRED,
        description = "Candidate's e-mail."
    )
    private String email;

    @Length(min = 10, max = 100, message = "The password must contain between (10) and (100) characters.")
    @Schema(
        example = "admin@1234",
        minLength = 10,
        maxLength = 100,
        requiredMode = RequiredMode.REQUIRED,
        description = "Candidate's password."
    )
    private String password;

    @Schema(
        example = "Java Developer",
        requiredMode = RequiredMode.REQUIRED,
        description = "A brief description of the candidate."
    )
    private String description;
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
