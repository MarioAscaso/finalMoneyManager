package com.daw.finalmoneymanager.newmovement.application;

import com.daw.finalmoneymanager.newmovement.domain.NewMovementUseCase;
import com.daw.finalmoneymanager.notifications.application.NotifyNegativeBalanceApp;
import org.springframework.stereotype.Service;

@Service
public class NewMovementApp {

    private final NewMovementUseCase newMovementUseCase;
    private final NotifyNegativeBalanceApp notifyNegativeBalanceApp;

    public NewMovementApp(NewMovementUseCase newMovementUseCase, NotifyNegativeBalanceApp notifyNegativeBalanceApp) {
        this.newMovementUseCase = newMovementUseCase;
        this.notifyNegativeBalanceApp = notifyNegativeBalanceApp;
    }

    public void execute(NewMovementRequest request) {
        newMovementUseCase.execute(request);
        notifyNegativeBalanceApp.execute();
    }
}