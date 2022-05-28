package com.animalia.crudanimalia;

import com.animalia.crudanimalia.model.*;
import com.animalia.crudanimalia.persistence.PetDao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

public class PetMainTest {
    public static void main(String[] args) {
        try (Connection connection = new ConnectionFactory().retrieveConnection()) {
            PetDao petDao = new PetDao(connection);
            Pet pet2 = petDao.findById(2L);
            System.out.println(pet2);
//            petDao.update(pet2);
//            System.out.println(pet2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
