package com.example.entryassignment.domain.apply.presentation;

import com.example.entryassignment.domain.apply.service.ApplyBookService;
import com.example.entryassignment.domain.apply.service.QueryApplyListService;
import com.example.entryassignment.domain.apply.presentation.dto.request.ApplyBookRequest;
import com.example.entryassignment.domain.apply.presentation.dto.response.QueryApplyInfoListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/apply")
public class ApplyController {
    private final ApplyBookService applyBookService;
    private final QueryApplyListService queryApplyListService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void applyBook(@RequestBody @Valid ApplyBookRequest request) {
        applyBookService.execute(request);
    }

    @GetMapping
    public QueryApplyInfoListResponse queryApplyList() {
        return queryApplyListService.execute();
    }
}
