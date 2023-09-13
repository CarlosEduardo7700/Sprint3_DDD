package org.example.services;

import org.example.models.Colaborador;

import java.util.ArrayList;
import java.util.List;

public class ColaboradorService implements IService<Colaborador> {
    private final List<Colaborador> Colaboradores;

    public ColaboradorService() {
        Colaboradores = new ArrayList<Colaborador>();
    }

    @Override
    public void Add(Colaborador item) {
        Colaboradores.add(item);
    }

    @Override
    public Colaborador Get(int id) {
        Colaborador colaborador = Colaboradores.get(id - 1);
        return colaborador;
    }

    @Override
    public List<Colaborador> GetAll() {
        return Colaboradores;
    }

    @Override
    public void Update(int id, Colaborador item) {
        Colaboradores.set(id - 1, item);
    }

    @Override
    public void Delete(int id) {
        Colaboradores.remove(id - 1);
    }
}
