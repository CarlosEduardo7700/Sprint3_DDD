package org.example.services;

import org.example.models.Chamada;

import java.util.ArrayList;
import java.util.List;

public class ChamadaService implements IService<Chamada> {
    private final List<Chamada> Chamadas;

    public ChamadaService() {
        Chamadas = new ArrayList<Chamada>();
    }

    @Override
    public void Add(Chamada item) {
        Chamadas.add(item);
    }

    @Override
    public Chamada Get(int id) {
        Chamada chamada = Chamadas.get(id - 1);
        return chamada;
    }

    @Override
    public List<Chamada> GetAll() {
        return Chamadas;
    }

    @Override
    public void Update(int id, Chamada item) {
        Chamadas.set(id - 1, item);
    }

    @Override
    public void Delete(int id) {
        Chamadas.remove(id - 1);
    }
}
