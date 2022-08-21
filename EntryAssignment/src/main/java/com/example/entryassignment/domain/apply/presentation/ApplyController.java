package com.example.entryassignment.domain.apply.presentation;

import com.example.entryassignment.domain.apply.service.ApplyBookService;
import com.example.entryassignment.domain.apply.service.DeleteApplyService;
import com.example.entryassignment.domain.apply.service.QueryApplyListService;
import com.example.entryassignment.domain.apply.presentation.dto.request.ApplyBookRequest;
import com.example.entryassignment.domain.apply.presentation.dto.response.QueryApplyInfoListResponse;
import com.example.entryassignment.domain.apply.service.QueryMyApplyListService;
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
    private final QueryMyApplyListService queryMyApplyListService;
    private final DeleteApplyService deleteApplyService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void applyBook(@RequestBody @Valid ApplyBookRequest request) {
        applyBookService.execute(request);
    }

    @GetMapping
    public QueryApplyInfoListResponse queryApplyList() {
        return queryApplyListService.execute();
    }

    @GetMapping("/my")
    public QueryApplyInfoListResponse queryMyApplyList() {
        return queryMyApplyListService.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{apply-id}")
    public void deleteApply(@PathVariable(name = "apply-id") Long id) {
        deleteApplyService.execute(id);
    }
}
