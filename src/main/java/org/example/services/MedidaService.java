package org.example.services;

import org.example.models.Medida;

import java.util.ArrayList;
import java.util.List;

public class MedidaService implements IService<Medida> {
    private final List<Medida> Medidas;

    public MedidaService() {
        Medidas = new ArrayList<Medida>();
    }

    @Override
    public void Add(Medida item) {
        Medidas.add(item);
    }

    @Override
    public Medida Get(int id) {
        Medida medidaBuscada = Medidas.get(id - 1);
        return medidaBuscada;
    }

    @Override
    public List<Medida> GetAll() {
        return Medidas;
    }

    @Override
    public void Update(int id, Medida item) {
        Medidas.set(id - 1, item);
    }

    @Override
    public void Delete(int id) {
        Medidas.remove(id - 1);
    }
}
