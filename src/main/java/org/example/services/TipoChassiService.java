package org.example.services;

import org.example.models.Tipo_Chassi;

import java.util.ArrayList;
import java.util.List;

public class TipoChassiService implements IService<Tipo_Chassi> {
    private final List<Tipo_Chassi> TiposChassi;

    public TipoChassiService() {
        TiposChassi = new ArrayList<Tipo_Chassi>();
    }

    @Override
    public void Add(Tipo_Chassi item) {
        TiposChassi.add(item);
    }

    @Override
    public Tipo_Chassi Get(int id) {
        Tipo_Chassi tipoChassiBuscado = TiposChassi.get(id - 1);
        return tipoChassiBuscado;
    }

    @Override
    public List<Tipo_Chassi> GetAll() {
        return TiposChassi;
    }

    @Override
    public void Update(int id, Tipo_Chassi item) {
        TiposChassi.set(id - 1, item);
    }

    @Override
    public void Delete(int id) {
        TiposChassi.remove(id - 1);
    }
}
