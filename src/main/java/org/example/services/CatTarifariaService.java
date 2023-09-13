package org.example.services;

import org.example.models.Cat_Tarifa;

import java.util.ArrayList;
import java.util.List;

public class CatTarifariaService implements IService<Cat_Tarifa> {
    private final List<Cat_Tarifa> CatsTarifas;

    public CatTarifariaService() {
        CatsTarifas = new ArrayList<Cat_Tarifa>();
    }

    @Override
    public void Add(Cat_Tarifa item) {
        CatsTarifas.add(item);
    }

    @Override
    public Cat_Tarifa Get(int id) {
        Cat_Tarifa catTarifaBuscada = CatsTarifas.get(id - 1);
        return catTarifaBuscada;
    }

    @Override
    public List<Cat_Tarifa> GetAll() {
        return CatsTarifas;
    }

    @Override
    public void Update(int id, Cat_Tarifa item) {
        CatsTarifas.set(id - 1, item);
    }

    @Override
    public void Delete(int id) {
        CatsTarifas.remove(id - 1);
    }
}
