package com.daw.finalmoneymanager.modifymovement.application;

import com.daw.finalmoneymanager.modifymovement.domain.GetMovementByIdUseCase;
import com.daw.finalmoneymanager.shared.domain.Movement;
import org.springframework.stereotype.Service;

@Service
public class GetMovementByIdApp {

    private final GetMovementByIdUseCase getMovementByIdUseCase;

    public GetMovementByIdApp(GetMovementByIdUseCase getMovementByIdUseCase) {
        this.getMovementByIdUseCase = getMovementByIdUseCase;
    }

    public Movement execute(Long id) {
        return getMovementByIdUseCase.execute(id).orElseThrow(() -> new RuntimeException("Movement not found with id: " + id));
    }
}