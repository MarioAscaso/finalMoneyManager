package com.daw.finalmoneymanager.newmovement.application;

import com.daw.finalmoneymanager.shared.domain.TypeMovement;

import java.math.BigDecimal;
import java.time.LocalDate;

public record NewMovementRequest(
        String concept,
        BigDecimal amount,
        LocalDate date,
        TypeMovement type
) {
}