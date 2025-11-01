package com.daw.finalmoneymanager.listmovements.application;

import com.daw.finalmoneymanager.listmovements.domain.ListMovementsUseCase;
import com.daw.finalmoneymanager.listmovements.domain.MovementSummary;
import com.daw.finalmoneymanager.shared.domain.Movement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListMovementsApp {

    private final ListMovementsUseCase listMovementsUseCase;

    public ListMovementsApp(ListMovementsUseCase listMovementsUseCase) {
        this.listMovementsUseCase = listMovementsUseCase;
    }

    public MovementSummary execute() {
        return listMovementsUseCase.execute();
    }
}


