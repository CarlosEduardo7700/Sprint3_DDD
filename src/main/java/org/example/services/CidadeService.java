package org.example.services;

import org.example.models.Cidade;

import java.util.ArrayList;
import java.util.List;

public class CidadeService implements IService<Cidade> {

    private final List<Cidade> Cidades;

    public CidadeService() {Cidades = new ArrayList<Cidade>();}

    @Override
    public void Add(Cidade item) {
        Cidades.add(item);
    }

    @Override
    public Cidade Get(int id) {
        Cidade cidadeBuscada = Cidades.get(id - 1);
        return cidadeBuscada;
    }

    @Override
    public List<Cidade> GetAll() {
        return Cidades;
    }

    @Override
    public void Update(int id, Cidade item) {
        Cidades.set(id - 1, item);
    }

    @Override
    public void Delete(int id) {
        Cidades.remove(id - 1);
    }
}
