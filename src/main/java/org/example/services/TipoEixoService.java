package org.example.services;

import org.example.models.Tipo_Eixo;

import java.util.ArrayList;
import java.util.List;

public class TipoEixoService implements IService<Tipo_Eixo> {
    private final List<Tipo_Eixo> TiposEixo;

    public TipoEixoService() {
        TiposEixo = new ArrayList<Tipo_Eixo>();
    }

    @Override
    public void Add(Tipo_Eixo item) {
        TiposEixo.add(item);
    }

    @Override
    public Tipo_Eixo Get(int id) {
        Tipo_Eixo tipoEixoBuscado = TiposEixo.get(id - 1);
        return tipoEixoBuscado;
    }

    @Override
    public List<Tipo_Eixo> GetAll() {
        return TiposEixo;
    }

    @Override
    public void Update(int id, Tipo_Eixo item) {
        TiposEixo.set(id - 1, item);
    }

    @Override
    public void Delete(int id) {
        TiposEixo.remove(id - 1);
    }
}
