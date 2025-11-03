package com.daw.finalmoneymanager.shared.domain;

import com.daw.finalmoneymanager.listmovements.domain.MovementSummary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BalanceCalculatorService {

    public BigDecimal calculateBalance(MovementRepository movementRepository) {
        List<Movement> movements = movementRepository.findAll();

        BigDecimal totalIngresos = movements.stream()
                .filter(mov -> mov.getType() == TypeMovement.INCOME)
                .map(Movement::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalGastos = movements.stream()
                .filter(mov -> mov.getType() == TypeMovement.EXPENSES)
                .map(Movement::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalIngresos.subtract(totalGastos);
    }

    public MovementSummary calculateSummary(MovementRepository movementRepository) {
        List<Movement> movements = movementRepository.findAllByOrderByDateDesc();

        BigDecimal totalIngresos = movements.stream()
                .filter(mov -> mov.getType() == TypeMovement.INCOME)
                .map(Movement::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalGastos = movements.stream()
                .filter(mov -> mov.getType() == TypeMovement.EXPENSES)
                .map(Movement::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal balanceTotal = totalIngresos.subtract(totalGastos);

        return new MovementSummary(movements, totalIngresos, totalGastos, balanceTotal);
    }
}