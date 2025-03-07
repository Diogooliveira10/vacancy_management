package br.com.diogooliveira.vacancy_management.modules.candidate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthCandidadeResponseDTO {
    
    private String access_token;
}
