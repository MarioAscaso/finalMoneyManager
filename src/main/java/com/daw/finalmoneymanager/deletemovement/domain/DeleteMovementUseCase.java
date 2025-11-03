package com.daw.finalmoneymanager.deletemovement.domain;

import com.daw.finalmoneymanager.shared.domain.MovementRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteMovementUseCase {

    private final MovementRepository movementRepository;

    public DeleteMovementUseCase(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public void execute(Long id) {
        movementRepository.deleteById(id);
    }
}