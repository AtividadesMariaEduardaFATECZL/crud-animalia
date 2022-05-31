package com.animalia.crudanimalia.model;

import static com.animalia.crudanimalia.utils.validator.ValidadorUtils.cantBeNullOrEmpty;

public class Pet {
    private Long id;
    private String name;
    private String kind;
    private String size;

    @Deprecated
    public Pet() {}

    public Pet(String name) {
        cantBeNullOrEmpty(name);
        this.name = name;
    }

    public Pet(String name, String kind, String size) {
        this(name);
        this. kind = kind;
        this.size = size;
    }

    @Deprecated
    public Pet(Long id, String name, String kind, String size) {
        this(name);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getKind() {
        return kind;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kind=" + kind +
                ", size=" + size +
                '}';
    }
}
