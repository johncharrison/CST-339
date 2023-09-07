package com.gcu.data.dao;

import java.util.List;

public interface DaoInterface<T> {

    public List<T> findAll();

    public T get(int id);

    public boolean create(T model);

    public boolean update(int id, T model);

    public boolean delete(int id);
}
