package com.daw.finalmoneymanager.newmovement.application;

import com.daw.finalmoneymanager.shared.domain.TypeMovement;

import java.math.BigDecimal;
import java.time.LocalDate;

//En mantenimiento para que funcione Lombok (evitar tener que poner los getters y setters)
public class NewMovementRequest {

    private String concept;
    private BigDecimal amount;
    private LocalDate date;
    private TypeMovement type;

    public String getConcept() {return concept;}
    public BigDecimal getAmount() {return amount;}
    public LocalDate getDate() {return date;}
    public TypeMovement getType() {return type;}

    public void setConcept(String concept) {this.concept = concept;}
    public void setAmount(BigDecimal amount) {this.amount = amount;}
    public void setDate(LocalDate date) {this.date = date;}
    public void setType(TypeMovement type) {this.type = type;}
}