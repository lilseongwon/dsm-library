package com.example.entryassignment.domain.user.presentation;

import com.example.entryassignment.domain.user.presentation.dto.request.UpdatePasswordRequest;
import com.example.entryassignment.domain.user.service.*;
import com.example.entryassignment.domain.user.presentation.dto.request.UserSignupRequest;
import com.example.entryassignment.domain.user.presentation.dto.response.QueryMyInformationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserSignupService userSignupService;
    private final QueryMyInformationService queryMyInformationService;
    private final MemberWithdrawlService memberWithdrawlService;
    private final UpdatePasswordService updatePasswordService;
    private final LogoutService logoutService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void userSignup(@RequestBody @Valid UserSignupRequest request) {
        userSignupService.execute(request);
    }

    @GetMapping("/info")
    public QueryMyInformationResponse queryMyInformation() {
        return queryMyInformationService.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete")
    public void memberWithdrawl() {
        memberWithdrawlService.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/logout")
    public void logout() {
        logoutService.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/password")
    public void UpdatePassword(@RequestBody @Valid UpdatePasswordRequest request) {
        updatePasswordService.execute(request);
    }
}
