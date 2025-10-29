package com.daw.finalmoneymanager.deletemovement.application;

import com.daw.finalmoneymanager.deletemovement.domain.DeleteMovementUseCase;
import org.springframework.stereotype.Service;

@Service
public class DeleteMovementApp {

    private final DeleteMovementUseCase deleteMovementUseCase;

    public DeleteMovementApp(DeleteMovementUseCase deleteMovementUseCase) {
        this.deleteMovementUseCase = deleteMovementUseCase;
    }

    public void execute(Long id) {
        deleteMovementUseCase.execute(id);
    }
}