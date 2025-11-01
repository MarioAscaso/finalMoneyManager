package com.daw.finalmoneymanager.listmovements.domain;

import com.daw.finalmoneymanager.shared.domain.Movement;
import com.daw.finalmoneymanager.shared.domain.MovementRepository;
import com.daw.finalmoneymanager.shared.domain.TypeMovement;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ListMovementsUseCase {

    public ListMovementsUseCase(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    private final MovementRepository movementRepository;

    public MovementSummary execute() {

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