package com.example.entryassignment.domain.auth.service;

import com.example.entryassignment.domain.auth.domain.RefreshToken;
import com.example.entryassignment.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.entryassignment.domain.auth.presentation.dto.response.TokenResponse;
import com.example.entryassignment.domain.auth.exception.InvalidRefreshTokenException;
import com.example.entryassignment.domain.auth.exception.RefreshTokenNotFoundException;
import com.example.entryassignment.global.security.jwt.JwtProperties;
import com.example.entryassignment.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TokenRefreshService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;


    @Transactional
    public TokenResponse execute(String refreshToken) {
        return reIssue(refreshToken);
    }

    private TokenResponse reIssue(String refreshToken) {
        String parseToken = jwtTokenProvider.parseToken(refreshToken);
        if (parseToken == null) {
            throw InvalidRefreshTokenException.EXCEPTION;
        }

        RefreshToken redisRefreshToken = refreshTokenRepository.findByToken(parseToken)
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);


        TokenResponse tokens = jwtTokenProvider.generateTokens(redisRefreshToken.getAccountId());

        redisRefreshToken.updateToken(tokens.getRefreshToken(), jwtProperties.getRefreshExp() * 1000);

        return TokenResponse.builder()
                .accessToken(tokens.getAccessToken())
                .refreshToken(tokens.getRefreshToken())
                .build();
    }
}