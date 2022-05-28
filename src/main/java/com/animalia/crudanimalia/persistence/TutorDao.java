package com.animalia.crudanimalia.persistence;

import com.animalia.crudanimalia.model.Pet;
import com.animalia.crudanimalia.model.Tutor;

import java.sql.*;
import java.util.List;

import static com.animalia.crudanimalia.model.utils.ValidadorUtils.cantBeNull;

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
    public void delete(Long id) throws SQLException {
        cantBeNull(id);
        connection.setAutoCommit(false);
        try (PreparedStatement stm = connection.prepareStatement("DELETE FROM tutor WHERE id = ?")) {
            stm.setLong(1, id);
            stm.execute();
            Integer deletedLines = stm.getUpdateCount();
            System.out.println("Modified lines: " + deletedLines);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }
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
