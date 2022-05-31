package com.animalia.crudanimalia.persistence;

import com.animalia.crudanimalia.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.animalia.crudanimalia.utils.validator.ValidadorUtils.cantBeNull;

public class PetDao implements IObjDao<Pet> {

    private final Connection connection;

    public PetDao(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void insert(Pet pet) throws SQLException {
        cantBeNull(pet);
        connection.setAutoCommit(false);
        String sql =
                "INSERT INTO pet (name, kind, size) " +
                        "VALUES(?, ?, ?)";
        try (PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            cantBeNull(pet);
            cantBeNull(stm);
            stm.setString(1, pet.getName());
            stm.setString(2, pet.getKind());
            stm.setString(3, pet.getSize());

            stm.execute();

            ResultSet rst = stm.getGeneratedKeys();
            while (rst.next()) {
                int id = rst.getInt(1);
                System.out.println("O id criado foi: " + id);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("EXECUTING ROLLBACK!");
            connection.rollback();
        }
    }

    @Override
    public void update(Pet pet) throws SQLException {
        cantBeNull(pet);
        connection.setAutoCommit(false);
        String sql = "UPDATE pet p SET p.name = ?,  p.kind = ?, p.size = ? WHERE id = ?";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            cantBeNull(pet);
            cantBeNull(stm);
            stm.setString(1, pet.getName());
            stm.setString(2, pet.getKind());
            stm.setString(3, pet.getSize());
            stm.setLong(4, pet.getId());
            stm.execute();
            int updateCount = stm.getUpdateCount();
            System.out.println("Modified lines: " + updateCount);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        cantBeNull(id);
        connection.setAutoCommit(false);
        try (PreparedStatement stm = connection.prepareStatement("DELETE FROM pet WHERE id = ?")) {
            stm.setLong(1, id);
            stm.execute();
            int deletedLines = stm.getUpdateCount();
            System.out.println("Modified lines: " + deletedLines);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }
    }

    @Override
    public Pet findById(Long id) throws SQLException {
        cantBeNull(id);
        Pet pet = new Pet();
        connection.setAutoCommit(false);
        String sql = "SELECT p.id, p.name, p.kind, p.size FROM pet p WHERE p.id = ?";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setLong(1, id);
            stm.execute();
            try (ResultSet rst = stm.getResultSet()) {
                while (rst.next()) {
                    pet = new Pet(rst.getLong("p.id"), rst.getString("p.name"),
                            (rst.getString("p.kind")),
                            (rst.getString("p.size")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }
        return pet;
    }

    @Override
    public List<Pet> findAll() {
        List<Pet> pets = new ArrayList<>();

        String sql =
                "SELECT p.name, p.kind, p.size FROM pet p";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.execute();
            this.turnResultSetInPet(pets, stm);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }

    @Override
    public List<Pet> findByName(String name) throws SQLException {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT p.name, p.kind, p.size FROM pet p WHERE t.name LIKE '%" + name + "%'";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.execute();
            this.turnResultSetInPet(pets, stm);
        }
        return pets;
    }


    private void turnResultSetInPet(List<Pet> pets, PreparedStatement pstm) throws SQLException {
        try (ResultSet rst = pstm.getResultSet()) {
            while (rst.next()) {
                Pet pet = new Pet(rst.getString("p.name"), (rst.getString("p.kind")),
                        (rst.getString("p.size")));
                pets.add(pet);
            }
        }
    }
}

