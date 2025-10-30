package com.daw.finalmoneymanager.modifymovement.infraestructure.controllers;

import com.daw.finalmoneymanager.modifymovement.application.GetMovementByIdApp;
import com.daw.finalmoneymanager.modifymovement.application.ModifyMovementApp;
import com.daw.finalmoneymanager.shared.domain.Movement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ModifyMovementController {

    private final GetMovementByIdApp getMovementByIdApp;
    private final ModifyMovementApp modifyMovementApp;

    public ModifyMovementController(GetMovementByIdApp getMovementByIdApp, ModifyMovementApp modifyMovementApp) {
        this.getMovementByIdApp = getMovementByIdApp;
        this.modifyMovementApp = modifyMovementApp;
    }

    @GetMapping("/movements/modify/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Movement movement = getMovementByIdApp.execute(id);
        model.addAttribute("movement", movement);
        return "modify-movement";
    }

    @PostMapping("/movements/edit")
    public String modifyMovement(Movement movement) {
        modifyMovementApp.execute(movement);
        return "redirect:/";
    }
}