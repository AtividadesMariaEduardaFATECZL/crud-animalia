package com.animalia.crudanimalia.model;

import com.animalia.crudanimalia.model.utils.ValidadorUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.animalia.crudanimalia.model.utils.ValidadorUtils.cantBeNull;
import static com.animalia.crudanimalia.model.utils.ValidadorUtils.cantBeNullOrEmpty;

public class Tutor {
    private Long id;
    private String name;
    private String cpf;
    private LocalDate birthday;
    private BigDecimal remuneration;
    private HomeKind homeKind = HomeKind.HOUSE;
    private List<Pet> pets = new ArrayList<>();

    public Tutor(String name, String cpf, LocalDate birthday, BigDecimal remuneration, List<Pet> pets) {
        cantBeNullOrEmpty(name);
        cantBeNullOrEmpty(cpf);
        cantBeNull(birthday);
        cantBeNull(remuneration);
        cantBeNull(pets);
        this.name = name;
        this.cpf = cpf;
        this.birthday = birthday;
        this.remuneration = remuneration;
        this.pets = pets;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public BigDecimal getRemuneration() {
        return remuneration;
    }

    public HomeKind getHomeKind() {
        return homeKind;
    }

    public List<Pet> getPets() {
        return pets;
    }
}