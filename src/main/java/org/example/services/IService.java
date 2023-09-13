package org.example.services;

import java.util.List;

public interface IService<T> {
    void Add(T item);
    T Get(int id);
    List<T> GetAll();
    // Rever o Update!!
    void Update(int id, T item);
    void Delete(int id);
}
