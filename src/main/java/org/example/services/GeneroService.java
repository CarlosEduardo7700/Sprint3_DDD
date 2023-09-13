package org.example.services;

import org.example.models.Genero;

import java.util.ArrayList;
import java.util.List;

public class GeneroService implements IService<Genero> {
    private final List<Genero> Generos;

    public GeneroService(){Generos = new ArrayList<Genero>();}

    @Override
    public void Add(Genero item) {
        Generos.add(item);
    }

    @Override
    public Genero Get(int id) {
        Genero generoBuscado = Generos.get(id - 1);
        return generoBuscado;
    }

    @Override
    public List<Genero> GetAll() {
        return Generos;
    }

    @Override
    public void Update(int id, Genero item) {
        Generos.set(id - 1, item);
    }

    @Override
    public void Delete(int id) {
        Generos.remove(id - 1);
    }
}
