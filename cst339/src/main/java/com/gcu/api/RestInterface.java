package com.gcu.api;

import java.util.List;

public interface RestInterface<T> {

    public List<T> list();

    public T get(int id);

    public T create(T model);

    public T update(int id, T model);

    public void delete(int id);

}
