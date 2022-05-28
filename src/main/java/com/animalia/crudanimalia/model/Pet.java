package com.animalia.crudanimalia.model;

import java.math.BigDecimal;

import static com.animalia.crudanimalia.model.utils.ValidadorUtils.cantBeNull;
import static com.animalia.crudanimalia.model.utils.ValidadorUtils.cantBeNullOrEmpty;

public class Pet {
    private Long id;
    private String name;
    private BigDecimal monthlyCost;
    private PetKind kind = PetKind.DOG;
    private PetSize size = PetSize.MEDIUM;

    public Pet(String name, BigDecimal monthlyCost) {
        cantBeNullOrEmpty(name);
        cantBeNull(monthlyCost);
        this.name = name;
        this.monthlyCost = monthlyCost;
    }

    public Pet(String name, BigDecimal monthlyCost, PetKind kind, PetSize size) {
        this(name, monthlyCost);
        this.kind = kind;
        this.size = size;
    }




    public String getName() {
        return name;
    }

    public BigDecimal getMonthlyCost() {
        return monthlyCost;
    }

    public PetKind getKind() {
        return kind;
    }

    public PetSize getSize() {
        return size;
    }
}
