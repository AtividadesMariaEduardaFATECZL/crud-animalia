package com.animalia.crudanimalia.persistence;

import com.animalia.crudanimalia.model.Pet;

import java.sql.SQLException;
import java.util.List;

public interface IObjDao<T> {

    public void insert(T t) throws SQLException;
    public void update(Pet pet) throws SQLException;
    public void delete(Long id) throws SQLException;
    public T findById(Long id) throws SQLException;
    public List<T> findAll() throws SQLException;

}
