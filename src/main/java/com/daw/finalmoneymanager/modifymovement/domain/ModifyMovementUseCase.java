package com.daw.finalmoneymanager.modifymovement.domain;

import com.daw.finalmoneymanager.shared.domain.Movement;
import com.daw.finalmoneymanager.shared.domain.MovementRepository;
import org.springframework.stereotype.Service;

@Service
public class ModifyMovementUseCase {

    private final MovementRepository movementRepository;

    public ModifyMovementUseCase(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public void execute(Movement movement) {
        movementRepository.save(movement);
    }
}