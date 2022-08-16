package com.example.entryassignment.domain.apply.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class ApplyBookRequest {

    @Size(min = 1, max = 60, message = "책 제목은 Null을 허용하지 않으며, 1~60자 내외여야 합니다.")
    private String title;

    @Size(min = 10, max = 20, message = "ISBN은 Null과 공백을 허용하지 않으며, 10~20자 이하여야 합니다.")
    private String isbn;
}
