package com.animalia.crudanimalia;

import com.animalia.crudanimalia.model.Pet;
import com.animalia.crudanimalia.persistence.PetDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PetSelect {
    public static void main(String[] args) {
        try (Connection connection = new ConnectionFactory().retrieveConnection()) {
            PetDao petDao = new PetDao(connection);
            List<Pet> all = petDao.findAll();
            all.forEach(a -> System.out.println(a.toString()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
