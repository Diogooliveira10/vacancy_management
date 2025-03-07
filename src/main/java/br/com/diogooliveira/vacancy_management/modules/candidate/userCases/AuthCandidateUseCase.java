package br.com.diogooliveira.vacancy_management.modules.candidate.userCases;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.diogooliveira.vacancy_management.modules.candidate.CandidateRepository;
import br.com.diogooliveira.vacancy_management.modules.candidate.dto.AuthCandidadeResponseDTO;
import br.com.diogooliveira.vacancy_management.modules.candidate.dto.AuthCandidateRequestDTO;

@Service
public class AuthCandidateUseCase {

    @Value("${security.token.candidate}")
    private String secretKey;
    
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthCandidadeResponseDTO execute(AuthCandidateRequestDTO atuthCandidateRequestDTO) throws AuthenticationException {

        var candidate = this.candidateRepository.findByUsername(atuthCandidateRequestDTO.username())
            .orElseThrow(() -> {
                throw new UsernameNotFoundException("Username/password incorrect.");
            });

        var passwordMatches = this.passwordEncoder
            .matches(atuthCandidateRequestDTO.password(), candidate.getPassword());

        if (!passwordMatches) {
            throw new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var token = JWT.create()
            .withIssuer("javacancy")
            .withSubject(candidate.getId().toString())
            .withClaim("roles", Arrays.asList("candidate"))
            .withExpiresAt(Instant.now().plus(Duration.ofMinutes(10)))
            .sign(algorithm);

        var authCandidateResponse = AuthCandidadeResponseDTO.builder()
            .access_token(token)
            .build();

        return authCandidateResponse;
    }
}
