package com.animalia.crudanimalia.model;

import java.time.LocalDate;

import static com.animalia.crudanimalia.utils.validator.ValidadorUtils.cantBeNullOrEmpty;

public class Tutor {
    private Long id;
    private String name;
    private String cpf;
    @Deprecated
    public Tutor() {}

    public Tutor(String name, String cpf) {
        cantBeNullOrEmpty(name);
        cantBeNullOrEmpty(cpf);
        this.name = name;
        this.cpf = cpf;
    }

    @Deprecated
    public Tutor(Long id, String name, String cpf) {
        this(name, cpf);
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

    @Override
    public String toString() {
        return "Tutor{" +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}