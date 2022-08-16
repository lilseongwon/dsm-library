package com.example.entryassignment.domain.user.service;

import com.example.entryassignment.domain.user.domain.User;
import com.example.entryassignment.domain.user.presentation.dto.response.QueryMyInformationResponse;
import com.example.entryassignment.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryMyInformationService {

    private final UserFacade userFacade;

    @Transactional
    public QueryMyInformationResponse execute() {
        User user = userFacade.getCurrentUser();

        return QueryMyInformationResponse.builder()
                .accountId(user.getAccountId())
                .name(user.getName())
                .build();
    }
}
