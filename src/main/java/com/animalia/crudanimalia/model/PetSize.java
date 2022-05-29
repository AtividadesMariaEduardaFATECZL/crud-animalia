package com.animalia.crudanimalia.model;

public enum PetSize {
    MINI("MINI"),
    SMALL("SMALL"),
    MEDIUM("MEDIUM"),
    BIG("BIG"),
    GIANT("GIANT");

    private final String displayName;

    PetSize(String displayName) {
        this.displayName = displayName;
    }
}
