package com.daw.finalmoneymanager.newmovement.application;

import com.daw.finalmoneymanager.newmovement.domain.NewMovementUseCase;
import org.springframework.stereotype.Service;

@Service
public class NewMovementApp {

    private final NewMovementUseCase newMovementUseCase;

    public NewMovementApp(NewMovementUseCase newMovementUseCase) {
        this.newMovementUseCase = newMovementUseCase;
    }

    public void execute(NewMovementRequest request) {
        newMovementUseCase.execute(request);
    }
}