package com.animalia.crudanimalia.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pet {
    private Long id;
    private String name;
    private BigDecimal monthlyCost;
    private LocalDate birthday;
    private PetKind kind = PetKind.DOG;
    private PetSize size = PetSize.MEDIUM;
    private LocalDateTime adoptedAt;
}
