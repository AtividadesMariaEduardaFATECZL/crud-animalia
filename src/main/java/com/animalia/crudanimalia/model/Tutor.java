package com.animalia.crudanimalia.model;

import java.time.LocalDate;

import static com.animalia.crudanimalia.utils.validator.ValidadorUtils.cantBeNullOrEmpty;

public class Tutor {
    private Long id;
    private String name;
    private String cpf;
    private LocalDate birthday;
    @Deprecated
    public Tutor() {}

    public Tutor(String name, String cpf,LocalDate birthday) {
        cantBeNullOrEmpty(name);
        cantBeNullOrEmpty(cpf);
        this.name = name;
        this.cpf = cpf;
        this.birthday = birthday;
    }

    @Deprecated
    public Tutor(Long id, String name, String cpf, LocalDate birthday) {
        this(name, cpf, birthday);
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

    public LocalDate getBirthday() {
        return birthday;
    }
}