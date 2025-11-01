package com.daw.finalmoneymanager.listmovements.infraestructure.controllers;

import com.daw.finalmoneymanager.listmovements.application.ListMovementsApp;
import com.daw.finalmoneymanager.listmovements.domain.MovementSummary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListMovementsController {

    private final ListMovementsApp listMovementsApp;

    public ListMovementsController(ListMovementsApp listMovementsApp) {
        this.listMovementsApp = listMovementsApp;
    }

    @GetMapping("/")
    public String listMovements(Model model) {
        MovementSummary summary = listMovementsApp.execute();

        model.addAttribute("movements", summary.movements());
        model.addAttribute("totalIngresos", summary.totalIngresos());
        model.addAttribute("totalGastos", summary.totalGastos());
        model.addAttribute("balanceTotal", summary.balanceTotal());

        return "index";
    }
}