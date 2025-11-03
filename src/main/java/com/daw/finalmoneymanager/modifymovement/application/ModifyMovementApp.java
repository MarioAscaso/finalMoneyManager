package com.daw.finalmoneymanager.modifymovement.application;

import com.daw.finalmoneymanager.modifymovement.domain.ModifyMovementUseCase;
import com.daw.finalmoneymanager.notifications.application.NotifyNegativeBalanceApp;
import com.daw.finalmoneymanager.shared.domain.Movement;
import org.springframework.stereotype.Service;

@Service
public class ModifyMovementApp {

    private final ModifyMovementUseCase modifyMovementUseCase;
    private final NotifyNegativeBalanceApp notifyNegativeBalanceApp;

    public ModifyMovementApp(ModifyMovementUseCase modifyMovementUseCase, NotifyNegativeBalanceApp notifyNegativeBalanceApp) {
        this.modifyMovementUseCase = modifyMovementUseCase;
        this.notifyNegativeBalanceApp = notifyNegativeBalanceApp;
    }

    public void execute(Movement movement) {
        modifyMovementUseCase.execute(movement);
        notifyNegativeBalanceApp.execute();
    }
}