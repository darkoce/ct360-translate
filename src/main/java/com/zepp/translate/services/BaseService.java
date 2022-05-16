package com.zepp.translate.services;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();
    T saveEntity(T dto);
    T updateEntity(long id, T dto);
    T findById(long id);
    void delete(long id);
}
