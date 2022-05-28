package com.animalia.crudanimalia;

import com.animalia.crudanimalia.model.*;
import com.animalia.crudanimalia.persistence.PetDao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

public class PetMainTest {
    public static void main(String[] args) {
        Pet pet = new Pet("Bud", new BigDecimal("10.00"));
        try (Connection connection = new ConnectionFactory().retrieveConnection()) {
            PetDao petDao = new PetDao(connection);
            petDao.insert(pet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
