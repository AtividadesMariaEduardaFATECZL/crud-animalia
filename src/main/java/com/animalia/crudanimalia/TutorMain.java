package com.animalia.crudanimalia;

import com.animalia.crudanimalia.model.Tutor;
import com.animalia.crudanimalia.persistence.TutorDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TutorMain {
    public static void main(String[] args) {
        try (Connection connection = new ConnectionFactory().retrieveConnection()) {
            TutorDao tutorDao = new TutorDao(connection);
            Tutor byId = tutorDao.findById(2L);
            byId.setName("tatiii");
            tutorDao.update(byId);
            System.out.println(byId);
//            List<Tutor> all = tutorDao.findAll();
//            all.forEach(System.out::println);
//            Tutor byId = tutorDao.findById(2L);
//            System.out.println(byId.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
