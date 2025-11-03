package com.daw.finalmoneymanager.notifications.application;

import com.daw.finalmoneymanager.notifications.domain.BalanceNotifier;
import com.daw.finalmoneymanager.shared.domain.BalanceCalculatorService;
import com.daw.finalmoneymanager.shared.domain.MovementRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class NotifyNegativeBalanceApp {

    private final BalanceCalculatorService balanceCalculator;
    private final BalanceNotifier balanceNotifier;
    private final MovementRepository movementRepository;

    public NotifyNegativeBalanceApp(BalanceCalculatorService balanceCalculator, BalanceNotifier balanceNotifier, MovementRepository movementRepository) {
        this.balanceCalculator = balanceCalculator;
        this.balanceNotifier = balanceNotifier;
        this.movementRepository = movementRepository;
    }

    public void execute() {
        BigDecimal newBalance = balanceCalculator.calculateBalance(movementRepository);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            balanceNotifier.notifyNegativeBalance(newBalance);
        }
    }
}