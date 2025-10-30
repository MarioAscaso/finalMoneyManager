package com.daw.finalmoneymanager.listmovements.application;

import com.daw.finalmoneymanager.listmovements.domain.ListMovementsUseCase;
import com.daw.finalmoneymanager.listmovements.domain.MovementDashboard;
import org.springframework.stereotype.Service;


@Service
public class ListMovementsApp {

    private final ListMovementsUseCase listMovementsUseCase;

    public ListMovementsApp(ListMovementsUseCase listMovementsUseCase) {
        this.listMovementsUseCase = listMovementsUseCase;
    }

    public MovementDashboard execute() {
        return listMovementsUseCase.execute();
    }
}