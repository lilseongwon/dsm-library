package com.example.entryassignment.domain.auth.presentation;

import com.example.entryassignment.domain.auth.presentation.dto.request.SignInRequest;
import com.example.entryassignment.domain.auth.presentation.dto.response.TokenResponse;
import com.example.entryassignment.domain.auth.service.TokenRefreshService;
import com.example.entryassignment.domain.auth.service.UserSignInService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class AuthController {
    private final UserSignInService userSignInService;
    private final TokenRefreshService tokenRefreshService;

    @PostMapping("/token")
    public TokenResponse userSignIn(@RequestBody @Valid SignInRequest signInRequest) {
        return userSignInService.execute(signInRequest);
    }

    @PatchMapping("token")
    public TokenResponse tokenRefresh(@RequestHeader("Refresh-Token") String refreshToken) {
        return tokenRefreshService.execute(refreshToken);
    }
}
