package com.animalia.crudanimalia.persistence;

import com.animalia.crudanimalia.model.Pet;

import java.sql.*;
import java.util.List;

import static com.animalia.crudanimalia.model.utils.ValidadorUtils.cantBeNull;

public class PetDao implements IObjDao<Pet> {

    private Connection connection;

    public PetDao(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void insert(Pet pet) throws SQLException {
        cantBeNull(pet);
        String sql =
                "INSERT INTO pet (name, monthlyCost) " +
                        "VALUES(?, ?)";
        try (PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            cantBeNull(pet);
            cantBeNull(stm);
            stm.setString(1, pet.getName());
            stm.setBigDecimal(2, pet.getMonthlyCost());
//            stm.setString(4, pet.getKind().name());
//            stm.setString(5, pet.getSize().name());

            stm.execute();

            ResultSet rst = stm.getGeneratedKeys();
            while (rst.next()) {
                Integer id = rst.getInt(1);
                System.out.println("O id criado foi: " + id);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("EXECUTING ROLLBACK!");
            connection.rollback();
        }
    }

    @Override
    public void update(Long id) {

    }

    @Override
    public void delete(Long id) throws SQLException {
        cantBeNull(id);
        connection.setAutoCommit(false);
        try (PreparedStatement stm = connection.prepareStatement("DELETE FROM course WHERE id = ?")) {
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
    public Pet findById(Long id) {
        return null;
    }

    @Override
    public List<Pet> list() {
        return null;
    }
}
