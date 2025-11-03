package com.daw.finalmoneymanager.newmovement.domain;

import com.daw.finalmoneymanager.newmovement.application.NewMovementRequest;
import com.daw.finalmoneymanager.shared.domain.Movement;
import com.daw.finalmoneymanager.shared.domain.MovementRepository;
import org.springframework.stereotype.Service;

@Service
public class NewMovementUseCase {

    private final MovementRepository movementRepository;

    public NewMovementUseCase(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public void execute(NewMovementRequest request) {
        Movement movement = new Movement(
                request.getConcept(),
                request.getAmount(),
                request.getDate(),
                request.getType()
        );

        movementRepository.save(movement);
    }
}