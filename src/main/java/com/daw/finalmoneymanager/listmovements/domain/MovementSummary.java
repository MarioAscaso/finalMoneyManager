package com.daw.finalmoneymanager.listmovements.domain;

import com.daw.finalmoneymanager.shared.domain.Movement;
import java.math.BigDecimal;
import java.util.List;

public record MovementSummary(
        List<Movement> movements,
        BigDecimal totalIngresos,
        BigDecimal totalGastos,
        BigDecimal balanceTotal
) {
}