package org.example.services;

import org.example.models.Bairro;

import java.util.ArrayList;
import java.util.List;

public class BairroService implements IService<Bairro> {
    private final List<Bairro> Bairros;

    public BairroService() {Bairros = new ArrayList<Bairro>();}

    @Override
    public void Add(Bairro item) {
        Bairros.add(item);
    }

    @Override
    public Bairro Get(int id) {
        Bairro bairroBuscado = Bairros.get(id - 1);
        return bairroBuscado;
    }

    @Override
    public List<Bairro> GetAll() {
        return Bairros;
    }

    @Override
    public void Update(int id, Bairro item) {
        Bairros.set(id - 1, item);
    }

    @Override
    public void Delete(int id) {
        Bairros.remove(id - 1);
    }
}
