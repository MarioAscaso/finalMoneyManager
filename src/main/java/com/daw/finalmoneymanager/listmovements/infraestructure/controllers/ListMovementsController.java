package com.daw.finalmoneymanager.listmovements.infraestructure.controllers;

import com.daw.finalmoneymanager.listmovements.application.ListMovementsApp;
import com.daw.finalmoneymanager.shared.domain.Movement;
import com.daw.finalmoneymanager.shared.domain.TypeMovement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
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

        BigDecimal totalIngresos = movements.stream()
                .filter(mov -> mov.getType() == TypeMovement.INCOME)
                .map(Movement::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalGastos = movements.stream()
                .filter(mov -> mov.getType() == TypeMovement.EXPENSES)
                .map(Movement::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal balanceTotal = totalIngresos.subtract(totalGastos);

        model.addAttribute("movements", movements);
        model.addAttribute("totalIngresos", totalIngresos);
        model.addAttribute("totalGastos", totalGastos);
        model.addAttribute("balanceTotal", balanceTotal);

        return "index";
    }
}