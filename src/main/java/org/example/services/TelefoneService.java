package org.example.services;

import org.example.models.Telefone;

import java.util.ArrayList;
import java.util.List;

public class TelefoneService implements IService<Telefone> {
    private final List<Telefone> Telefones;

    public TelefoneService() {Telefones = new ArrayList<Telefone>();}

    @Override
    public void Add(Telefone item) {
        Telefones.add(item);
    }

    @Override
    public Telefone Get(int id) {
        Telefone telefoneBuscado = Telefones.get(id - 1);
        return telefoneBuscado;
    }

    @Override
    public List<Telefone> GetAll() {
        return Telefones;
    }

    @Override
    public void Update(int id, Telefone item) {
        Telefones.set(id - 1, item);
    }

    @Override
    public void Delete(int id) {
        Telefones.remove(id - 1);
    }
}
