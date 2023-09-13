package org.example.services;

import org.example.models.Logradouro;

import java.util.ArrayList;
import java.util.List;

public class LogradouroService implements IService<Logradouro> {

    private final List<Logradouro> Logradouros;

    public LogradouroService() {Logradouros = new ArrayList<Logradouro>();}

    @Override
    public void Add(Logradouro item) {
        Logradouros.add(item);
    }

    @Override
    public Logradouro Get(int id) {
        Logradouro logradouroBuscado = Logradouros.get(id - 1);
        return logradouroBuscado;
    }

    @Override
    public List<Logradouro> GetAll() {
        return Logradouros;
    }

    @Override
    public void Update(int id, Logradouro item) {
        Logradouros.set(id - 1, item);
    }

    @Override
    public void Delete(int id) {
        Logradouros.remove(id - 1);
    }
}
