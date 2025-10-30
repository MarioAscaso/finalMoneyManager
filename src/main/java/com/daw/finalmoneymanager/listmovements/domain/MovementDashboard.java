package com.daw.finalmoneymanager.listmovements.domain;

import com.daw.finalmoneymanager.shared.domain.Movement;

import java.util.List;

public class MovementDashboard {

    private final List<Movement> movements;
    private final double totalIngresos;
    private final double totalGastos;
    private final double balanceTotal;

    public MovementDashboard(List<Movement> movements, double totalIngresos, double totalGastos, double balanceTotal) {
        this.movements = movements;
        this.totalIngresos = totalIngresos;
        this.totalGastos = totalGastos;
        this.balanceTotal = balanceTotal;
    }

    public List<Movement> getMovements() {
        return movements;
    }

    public double getTotalIngresos() {
        return totalIngresos;
    }

    public double getTotalGastos() {
        return totalGastos;
    }

    public double getBalanceTotal() {
        return balanceTotal;
    }
}