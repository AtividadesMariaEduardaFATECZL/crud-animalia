package com.animalia.crudanimalia.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tutor {
    private Long id;
    private String name;
    private String cpf;
    private LocalDate birthday;
    private BigDecimal remuneration;
    private HomeKind homeKind = HomeKind.HOUSE;
    private List<Pet> pets = new ArrayList<>();
}