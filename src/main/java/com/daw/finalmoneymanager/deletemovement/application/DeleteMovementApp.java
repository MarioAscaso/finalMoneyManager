package com.daw.finalmoneymanager.deletemovement.application;

import com.daw.finalmoneymanager.deletemovement.domain.DeleteMovementUseCase;
import com.daw.finalmoneymanager.notifications.application.NotifyNegativeBalanceApp;
import org.springframework.stereotype.Service;

@Service
public class DeleteMovementApp {

    private final DeleteMovementUseCase deleteMovementUseCase;
    private final NotifyNegativeBalanceApp notifyNegativeBalanceApp;

    public DeleteMovementApp(DeleteMovementUseCase deleteMovementUseCase, NotifyNegativeBalanceApp notifyNegativeBalanceApp) {
        this.deleteMovementUseCase = deleteMovementUseCase;
        this.notifyNegativeBalanceApp = notifyNegativeBalanceApp;
    }

    public void execute(Long id) {
        deleteMovementUseCase.execute(id);
        notifyNegativeBalanceApp.execute();
    }
}