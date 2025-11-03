package com.daw.finalmoneymanager.listmovements.domain;

import com.daw.finalmoneymanager.shared.domain.BalanceCalculatorService;
import com.daw.finalmoneymanager.shared.domain.MovementRepository;
import org.springframework.stereotype.Service;

@Service
public class ListMovementsUseCase {

    private final MovementRepository movementRepository;
    private final BalanceCalculatorService balanceCalculator;

    public ListMovementsUseCase(MovementRepository movementRepository, BalanceCalculatorService balanceCalculator) {
        this.movementRepository = movementRepository;
        this.balanceCalculator = balanceCalculator;
    }

    public MovementSummary execute() {
        return balanceCalculator.calculateSummary(movementRepository);
    }
}