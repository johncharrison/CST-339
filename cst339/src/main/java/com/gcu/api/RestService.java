package com.gcu.api;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gcu.data.DaoInterface;

@Service
public class RestService<T> implements RestInterface<T> {

    private final DaoInterface<T> dao;

    public RestService(DaoInterface<T> dao) {
        this.dao = dao;
    }

    public T create(T model) {
        return dao.create(model);
    }

    public void delete(int id) {
        dao.delete(id);
    }

    public T get(int id) {
        return dao.get(id);
    }

    public List<T> list() {
        return dao.list();
    }

    public T update(int id, T model) {
        return dao.update(id, model);
    }

}
