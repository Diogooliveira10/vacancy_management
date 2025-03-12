package br.com.diogooliveira.vacancy_management.modules.candidate.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidateResponseDTO {

    @Schema(
        example = "Java Developer"
    )
    private String description;

    @Schema(
        example = "Janedoe"
    )
    private String username;

    @Schema(
        example = "janedoe@gmail.com"
    )
    private String email;
    private UUID id;

    @Schema(
        example = "Jane Doe"
    )
    private String name;
}
