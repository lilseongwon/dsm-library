package com.example.entryassignment.domain.apply.presentation.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;


@Getter
@RequiredArgsConstructor
public class QueryApplyInfoListResponse {
    private final List<QueryApplyInfoResponse> applyLists;
}
