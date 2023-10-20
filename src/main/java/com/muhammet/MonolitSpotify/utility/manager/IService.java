package com.muhammet.MonolitSpotify.utility.manager;

import java.util.List;

public interface IService<T,ID> {
    T save(T entity);
    Iterable<T> saveAll(Iterable<T> entites);
    T update(T entity);
    void delete(T t);
    void deleteById(ID id);
    List<T> findAll();
}
