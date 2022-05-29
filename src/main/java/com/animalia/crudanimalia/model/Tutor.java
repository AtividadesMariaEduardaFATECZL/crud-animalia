package com.animalia.crudanimalia.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.animalia.crudanimalia.model.utils.ValidadorUtils.cantBeNull;
import static com.animalia.crudanimalia.model.utils.ValidadorUtils.cantBeNullOrEmpty;

public class Tutor {
    private Long id;
    private String name;
    private String cpf;
    private BigDecimal remuneration;
    private HomeKind homeKind = HomeKind.HOUSE;

    @Deprecated
    public Tutor() {}

    public Tutor(String name, String cpf,BigDecimal remuneration) {
        cantBeNullOrEmpty(name);
        cantBeNullOrEmpty(cpf);
        cantBeNull(remuneration);
        this.name = name;
        this.cpf = cpf;
        this.remuneration = remuneration;
    }

    public Tutor(String name, String cpf, BigDecimal remuneration, HomeKind homeKind) {
        this(name, cpf, remuneration);
        this.homeKind = homeKind;
    }

    public Tutor(Long id, String name, String cpf, BigDecimal remuneration, HomeKind homeKind) {
       this(name, cpf, remuneration);
       this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public BigDecimal getRemuneration() {
        return remuneration;
    }

    public HomeKind getHomeKind() {
        return homeKind;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", remuneration=" + remuneration +
                ", homeKind=" + homeKind +
                '}';
    }
}