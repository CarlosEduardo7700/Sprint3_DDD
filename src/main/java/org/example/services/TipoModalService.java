package org.example.services;

import org.example.models.Tipo_Modal;

import java.util.ArrayList;
import java.util.List;

public class TipoModalService implements IService<Tipo_Modal> {
    private final List<Tipo_Modal> TiposModais;

    public TipoModalService() {
        TiposModais = new ArrayList<Tipo_Modal>();
    }

    @Override
    public void Add(Tipo_Modal item) {
        TiposModais.add(item);
    }

    @Override
    public Tipo_Modal Get(int id) {
        Tipo_Modal tipoModal = TiposModais.get(id - 1);
        return tipoModal;
    }

    @Override
    public List<Tipo_Modal> GetAll() {
        return TiposModais;
    }

    @Override
    public void Update(int id, Tipo_Modal item) {
        TiposModais.set(id - 1, item);
    }

    @Override
    public void Delete(int id) {
        TiposModais.remove(id - 1);
    }
}
