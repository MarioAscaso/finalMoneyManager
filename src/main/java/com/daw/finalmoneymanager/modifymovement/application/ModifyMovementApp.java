package com.daw.finalmoneymanager.modifymovement.application;

import com.daw.finalmoneymanager.modifymovement.domain.ModifyMovementUseCase;
import com.daw.finalmoneymanager.shared.domain.Movement;
import org.springframework.stereotype.Service;

@Service
public class ModifyMovementApp {

    private final ModifyMovementUseCase modifyMovementUseCase;

    public ModifyMovementApp(ModifyMovementUseCase modifyMovementUseCase) {
        this.modifyMovementUseCase = modifyMovementUseCase;
    }

    public void execute(Movement movement) {
        modifyMovementUseCase.execute(movement);
    }
}