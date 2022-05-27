package com.animalia.crudanimalia.persistence;

import java.util.List;

public interface IObjDao<T> {

    public void insert(T t);
    public void update(Long id);
    public void remove(Long id);
    public T findById(Long id);
    public List<T> lista();

}
