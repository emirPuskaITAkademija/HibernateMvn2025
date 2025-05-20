package com.itakademija;

import java.util.List;

public interface Dao<E> {

    List<E> getAll();

    E getById(int id);

    E save(E e);

    void delete(E e);

    void update(E e);
}
