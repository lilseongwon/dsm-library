package com.example.entryassignment.domain.apply.service;

import com.example.entryassignment.domain.apply.domain.Apply;
import com.example.entryassignment.domain.apply.domain.repository.ApplyRepository;
import com.example.entryassignment.domain.apply.presentation.dto.response.QueryApplyInfoListResponse;
import com.example.entryassignment.domain.apply.presentation.dto.response.QueryApplyInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryApplyListService {

    private final ApplyRepository applyRepository;

    @Transactional(readOnly = true)
    public QueryApplyInfoListResponse execute() {
        List<QueryApplyInfoResponse> applyList = applyRepository.findAllByOrderById()
                .stream()
                .map(this::applyBuilder)
                .collect(Collectors.toList());

        return new QueryApplyInfoListResponse(applyList);
    }

    private QueryApplyInfoResponse applyBuilder(Apply apply) {
        return QueryApplyInfoResponse.builder()
                .title(apply.getTitle())
                .isbn(apply.getIsbn())
                .build();
    }
}