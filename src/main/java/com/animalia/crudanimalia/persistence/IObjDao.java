package com.animalia.crudanimalia.persistence;

import java.sql.SQLException;
import java.util.List;

public interface IObjDao<T> {

    public void insert(T t) throws SQLException;
    public void update(Long id);
    public void delete(Long id) throws SQLException;
    public T findById(Long id);
    public List<T> findAll() throws SQLException;

}
