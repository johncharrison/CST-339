package com.gcu.service;

public interface ServiceInterface<T> {

    public Iterable<T> findAll();

    public T findById(long id);

    public T save(T t);

    public T update(T t);

    public void delete(long id);

}
