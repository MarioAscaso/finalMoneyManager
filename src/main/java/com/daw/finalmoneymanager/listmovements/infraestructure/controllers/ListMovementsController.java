package com.daw.finalmoneymanager.listmovements.infraestructure.controllers;

import com.daw.finalmoneymanager.listmovements.application.ListMovementsApp;
import com.daw.finalmoneymanager.shared.domain.Movement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ListMovementsController {

    private final ListMovementsApp listMovementsApp;

    public ListMovementsController(ListMovementsApp listMovementsApp) {
        this.listMovementsApp = listMovementsApp;
    }

    @GetMapping("/")
    public String listMovements(Model model) {
        List<Movement> movements = listMovementsApp.execute();
        model.addAttribute("movements", movements);
        return "index";
    }
}