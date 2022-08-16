package com.example.entryassignment.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class UpdatePasswordRequest {

    @NotBlank
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,60}",
            message = "비밀번호는 공백과 띄어쓰기를 허용하지 않고, 영어, 숫자, 특수기호를 포함한 8~60자리여야 합니다.")
    private String password;

    @NotBlank
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,60}",
            message = "비밀번호는 공백과 띄어쓰기를 허용하지 않고, 영어, 숫자, 특수기호를 포함한 8~60자리여야 합니다.")
    private String newPassword;
}
