package com.daw.finalmoneymanager.deletemovement.infraestructure.controllers;

import com.daw.finalmoneymanager.deletemovement.application.DeleteMovementApp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteMovementController {

    private final DeleteMovementApp deleteMovementApp;

    public DeleteMovementController(DeleteMovementApp deleteMovementApp) {
        this.deleteMovementApp = deleteMovementApp;
    }

    @PostMapping("/movements/delete")
    public String deleteMovement(@RequestParam Long id) {
        deleteMovementApp.execute(id);
        return "redirect:/";
    }
}