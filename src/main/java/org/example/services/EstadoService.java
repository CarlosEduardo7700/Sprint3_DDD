package org.example.services;

import org.example.models.Estado;

import java.util.ArrayList;
import java.util.List;

public class EstadoService implements IService<Estado> {

    private final List<Estado> Estados;

    public EstadoService(){
        Estados = new ArrayList<Estado>();
    }

    @Override
    public void Add(Estado item) {
        Estados.add(item);
    }

    @Override
    public Estado Get(int id) {
        Estado estadoBuscado = Estados.get(id - 1);
        return estadoBuscado;
    }

    @Override
    public List<Estado> GetAll() {
        return Estados;
    }

    @Override
    public void Update(int id, Estado item) {
        Estados.set(id - 1, item);
    }

    @Override
    public void Delete(int id) {
        Estados.remove(id - 1);
    }
}
