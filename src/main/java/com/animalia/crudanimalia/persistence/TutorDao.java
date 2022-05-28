package com.animalia.crudanimalia.persistence;

import com.animalia.crudanimalia.model.Pet;
import com.animalia.crudanimalia.model.Tutor;

import java.sql.*;
import java.util.List;

public class TutorDao implements IObjDao<Tutor>{

    private Connection connection;

    public TutorDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Tutor tutor) {
    }

    @Override
    public void update(Pet pet) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Tutor findById(Long id) {
        return null;
    }

    @Override
    public List<Tutor> findAll() {
        return null;
    }
}
