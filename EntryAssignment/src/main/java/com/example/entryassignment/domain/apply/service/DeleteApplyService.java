package com.example.entryassignment.domain.apply.service;

import com.example.entryassignment.domain.apply.domain.Apply;
import com.example.entryassignment.domain.apply.domain.repository.ApplyRepository;
import com.example.entryassignment.domain.apply.exception.ApplyIsNotExistException;
import com.example.entryassignment.domain.apply.facade.ApplyFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DeleteApplyService {
    private final ApplyFacade applyFacade;
    private final ApplyRepository applyRepository;

    public void execute(Long id) {
        Apply apply = applyRepository.findById(id)
                .orElseThrow(() -> ApplyIsNotExistException.EXCEPTION);

        applyFacade.checkAppliedUser(apply.getIsbn());

        applyRepository.delete(apply);
    }
}
