package com.animalia.crudanimalia.persistence;

import com.animalia.crudanimalia.model.Tutor;

import java.sql.SQLException;
import java.util.List;

public interface IObjDao<T> {

    public void insert(T t) throws SQLException;
    public void update(T t) throws SQLException;
    public void delete(Long id) throws SQLException;
    public T findById(Long id) throws SQLException;
    public List<T> findAll() throws SQLException;

    List<Tutor> findByName(String name) throws SQLException;
}
