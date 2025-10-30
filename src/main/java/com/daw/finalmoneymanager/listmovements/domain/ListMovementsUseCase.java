package com.daw.finalmoneymanager.listmovements.domain;

import com.daw.finalmoneymanager.shared.domain.Movement;
import com.daw.finalmoneymanager.shared.domain.MovementRepository;
import com.daw.finalmoneymanager.shared.domain.TypeMovement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListMovementsUseCase {

    private final MovementRepository movementRepository;

    public ListMovementsUseCase(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public MovementDashboard execute() {
        List<Movement> movements = movementRepository.findAll();

        double totalIngresos = movements.stream()
                .filter(mov -> mov.getType() == TypeMovement.INCOME)
                .mapToDouble(mov -> mov.getAmount() != null ? mov.getAmount().doubleValue() : 0.0)
                .sum();

        double totalGastos = movements.stream()
                .filter(mov -> mov.getType() == TypeMovement.EXPENSES)
                .mapToDouble(mov -> mov.getAmount() != null ? mov.getAmount().doubleValue() : 0.0)
                .sum();

        double balanceTotal = totalIngresos - totalGastos;

        return new MovementDashboard(movements, totalIngresos, totalGastos, balanceTotal);
    }
}