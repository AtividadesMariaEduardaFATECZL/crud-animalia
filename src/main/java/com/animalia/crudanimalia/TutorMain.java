package com.animalia.crudanimalia;

import com.animalia.crudanimalia.persistence.PetDao;
import com.animalia.crudanimalia.persistence.TutorDao;

import java.sql.Connection;
import java.sql.SQLException;

public class TutorMain {
    public static void main(String[] args) {
        try (Connection connection = new ConnectionFactory().retrieveConnection()) {
            TutorDao tutorDao = new TutorDao(connection);
            tutorDao.delete(1L);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
