package com.animalia.crudanimalia.model.dto;

import com.animalia.crudanimalia.model.PetKind;
import com.animalia.crudanimalia.model.PetSize;

import java.math.BigDecimal;

public class PetDTO {
    private String name;
    private BigDecimal monthlyCost;
    private PetKind kind = PetKind.DOG;
    private PetSize size = PetSize.MEDIUM;

    public PetDTO(String name, BigDecimal monthlyCost, PetKind kind, PetSize size) {
        this.name = name;
        this.monthlyCost = monthlyCost;
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
