package com.daw.finalmoneymanager.listmovements.domain;

import com.daw.finalmoneymanager.shared.domain.Movement;
import com.daw.finalmoneymanager.shared.domain.MovementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListMovementsUseCase {

    private final MovementRepository movementRepository;

    public ListMovementsUseCase(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public List<Movement> execute() {
        return movementRepository.findAll();
    }
}