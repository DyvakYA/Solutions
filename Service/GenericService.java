package com.dy.model.services;

import java.util.List;

public interface GenericService<E> {

    void create(E e);

    void update(E e);

    void delete(Long id);

    List<E> getAll();

    E get(long id);
}
