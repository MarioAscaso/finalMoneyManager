package com.daw.finalmoneymanager.newmovement.infrastructure.controllers;

import com.daw.finalmoneymanager.newmovement.application.NewMovementApp;
import com.daw.finalmoneymanager.newmovement.application.NewMovementRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NewMovementController {

    private final NewMovementApp newMovementApp;

    public NewMovementController(NewMovementApp newMovementApp) {
        this.newMovementApp = newMovementApp;
    }

    @PostMapping("/movements/new")
    public String newMovement(@ModelAttribute NewMovementRequest request) {
        newMovementApp.execute(request);
        return "redirect:/";
    }
}