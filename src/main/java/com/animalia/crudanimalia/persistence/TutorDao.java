package com.animalia.crudanimalia.persistence;

import com.animalia.crudanimalia.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.animalia.crudanimalia.utils.validator.ValidadorUtils.cantBeNull;

public class TutorDao implements IObjDao<Tutor>{

    private final Connection connection;

    public TutorDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Tutor tutor) throws SQLException {
        cantBeNull(tutor);
        connection.setAutoCommit(false);
        String sql =
                "INSERT INTO tutor (name, cpf) " +
                        "VALUES(?, ?)";
        try (PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            cantBeNull(tutor);
            cantBeNull(stm);
            stm.setString(1, tutor.getName());
            stm.setString(2, tutor.getCpf());

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
    public void update(Tutor tutor) throws SQLException {
        cantBeNull(tutor);
        connection.setAutoCommit(false);
        String sql = "UPDATE tutor t SET t.name = ?, t.cpf = ? = ? WHERE id = ?";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            cantBeNull(tutor);
            cantBeNull(stm);
            stm.setString(1, tutor.getName());
            stm.setString(2, tutor.getCpf());
            stm.setLong(3, tutor.getId());
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
    public Tutor findById(Long id) throws SQLException {
        cantBeNull(id);
        Tutor tutor = new Tutor();
        connection.setAutoCommit(false);
        String sql = "SELECT t.id, t.name, t.cpf FROM tutor t WHERE t.id = ?";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setLong(1, id);
            stm.execute();
            try (ResultSet rst = stm.getResultSet()) {
                while (rst.next()) {
                    tutor = new Tutor(rst.getLong("t.id"), rst.getString("t.name"),
                            rst.getString("t.cpf"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }
        return tutor;
    }

    @Override
    public List<Tutor> findAll() {
        List<Tutor> tutors = new ArrayList<>();
        String sql = "SELECT t.id, t.name, t.cpf FROM tutor t";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.execute();
            this.turnResultSetInTutor(tutors, stm);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tutors;
    }

    private void turnResultSetInTutor(List<Tutor> tutors, PreparedStatement pstm) throws SQLException {
        try (ResultSet rst = pstm.getResultSet()) {
            while (rst.next()) {
                Tutor tutor = new Tutor(rst.getString("t.name"), rst.getString("t.cpf"));
                tutors.add(tutor);
            }
        }
    }
}
