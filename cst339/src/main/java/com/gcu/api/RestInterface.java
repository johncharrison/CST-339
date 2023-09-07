package com.gcu.api;

public interface RestInterface<T> {

    public Iterable<T> findAll();

    public T get(long id);

    public T create(T model);

    public T update(long id, T model);

    public void delete(long id);

}
