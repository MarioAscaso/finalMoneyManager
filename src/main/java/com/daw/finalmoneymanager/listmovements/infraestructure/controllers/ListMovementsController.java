package com.daw.finalmoneymanager.listmovements.infraestructure.controllers;

import com.daw.finalmoneymanager.listmovements.application.ListMovementsApp;
import com.daw.finalmoneymanager.listmovements.domain.MovementDashboard;
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
        MovementDashboard dashboardData = listMovementsApp.execute();

        model.addAttribute("movements", dashboardData.getMovements());
        model.addAttribute("totalIngresos", dashboardData.getTotalIngresos());
        model.addAttribute("totalGastos", dashboardData.getTotalGastos());
        model.addAttribute("balanceTotal", dashboardData.getBalanceTotal());

        return "index";
    }
}