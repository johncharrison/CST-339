package com.gcu.data;

import java.util.List;

public interface DaoInterface<T> {

    public List<T> list();

    public T get(int id);

    public T create(T model);
}
