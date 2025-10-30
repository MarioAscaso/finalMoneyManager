package com.daw.finalmoneymanager.modifymovement.domain;

import com.daw.finalmoneymanager.shared.domain.Movement;
import com.daw.finalmoneymanager.shared.domain.MovementRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetMovementByIdUseCase {

    private final MovementRepository movementRepository;

    public GetMovementByIdUseCase(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public Optional<Movement> execute(Long id) {
        return movementRepository.findById(id);
    }
}