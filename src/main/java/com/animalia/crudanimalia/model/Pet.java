package com.animalia.crudanimalia.model;

import com.animalia.crudanimalia.model.utils.ValidadorUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.animalia.crudanimalia.model.utils.ValidadorUtils.cantBeNull;
import static com.animalia.crudanimalia.model.utils.ValidadorUtils.cantBeNullOrEmpty;

public class Pet {
    private Long id;
    private String name;
    private BigDecimal monthlyCost;
    private LocalDate birthday;
    private PetKind kind = PetKind.DOG;
    private PetSize size = PetSize.MEDIUM;
    private LocalDateTime adoptedAt;

    public Pet(String name, BigDecimal monthlyCost, LocalDate birthday, LocalDateTime adoptedAt) {
        cantBeNullOrEmpty(name);
        cantBeNull(monthlyCost);
        cantBeNull(birthday);
        cantBeNull(adoptedAt);
        this.name = name;
        this.monthlyCost = monthlyCost;
        this.birthday = birthday;
        this.adoptedAt = adoptedAt;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getMonthlyCost() {
        return monthlyCost;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public PetKind getKind() {
        return kind;
    }

    public PetSize getSize() {
        return size;
    }

    public LocalDateTime getAdoptedAt() {
        return adoptedAt;
    }
}
