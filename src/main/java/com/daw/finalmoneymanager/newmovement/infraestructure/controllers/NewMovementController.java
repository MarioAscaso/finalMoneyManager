package com.daw.finalmoneymanager.newmovement.infraestructure.controllers;

import com.daw.finalmoneymanager.shared.domain.TypeMovement;
import com.daw.finalmoneymanager.newmovement.application.NewMovementRequest;
import com.daw.finalmoneymanager.newmovement.application.NewMovementApp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;

@Controller
public class NewMovementController {

    private final NewMovementApp newMovementApp;

    public NewMovementController(NewMovementApp newMovementApp) {
        this.newMovementApp = newMovementApp;
    }

    @PostMapping("/movements/new")
    public String createMovement(
            @RequestParam String concept,
            @RequestParam BigDecimal amount,
            @RequestParam LocalDate date,
            @RequestParam TypeMovement type) {

        NewMovementRequest request = new NewMovementRequest(concept, amount, date, type);
        newMovementApp.execute(request);
        return "redirect:/";
    }
}