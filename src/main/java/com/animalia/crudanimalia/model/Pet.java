package com.animalia.crudanimalia.model;

import java.math.BigDecimal;

import static com.animalia.crudanimalia.utils.validator.ValidadorUtils.cantBeNull;
import static com.animalia.crudanimalia.utils.validator.ValidadorUtils.cantBeNullOrEmpty;

public class Pet {
    private Long id;
    private String name;
    private BigDecimal monthlyCost;
    private PetKind kind = PetKind.DOG;
    private PetSize size = PetSize.MEDIUM;

    @Deprecated
    public Pet() {}

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

    @Deprecated
    public Pet(Long id, String name, BigDecimal monthlyCost, PetKind kind, PetSize size) {
        this(name, monthlyCost, kind, size);
        this.id = id;
    }

    public Long getId() {
        return id;
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

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", monthlyCost=" + monthlyCost +
                ", kind=" + kind +
                ", size=" + size +
                '}';
    }
}
