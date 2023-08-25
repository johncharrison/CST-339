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
        // TODO Auto-generated method stub

        return dao.create(model);
    }

    public void delete(int id) {
        // TODO Auto-generated method stub

    }

    public T get(int id) {
        return dao.get(id);
    }

    public List<T> list() {
        // TODO Auto-generated method stub
        return dao.list();
    }

    public T update(int id, T model) {
        // TODO Auto-generated method stub
        return null;
    }

}
