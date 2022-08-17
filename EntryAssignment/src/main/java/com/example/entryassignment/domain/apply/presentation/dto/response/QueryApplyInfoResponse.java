package com.example.entryassignment.domain.apply.presentation.dto.response;

import com.example.entryassignment.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryApplyInfoResponse {
    private final String title;
    private final String isbn;
    private final User user;

}
