package com.example.entryassignment.domain.user.service;

import com.example.entryassignment.domain.auth.domain.RefreshToken;
import com.example.entryassignment.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.entryassignment.domain.auth.exception.RefreshTokenNotFoundException;
import com.example.entryassignment.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LogoutService {
    private final UserFacade userFacade;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public void execute() {
        RefreshToken refreshToken = refreshTokenRepository.findByAccountId(
                        userFacade.getCurrentUser().getAccountId())
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        refreshTokenRepository.delete(refreshToken);
    }
}
