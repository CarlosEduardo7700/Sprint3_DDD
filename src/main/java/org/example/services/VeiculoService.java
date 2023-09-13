package org.example.services;

import org.example.models.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoService implements IService<Veiculo> {
    private final List<Veiculo> Veiculos;

    public VeiculoService() { Veiculos = new ArrayList<Veiculo>(); }

    @Override
    public void Add(Veiculo item) {
        Veiculos.add(item);
    }

    @Override
    public Veiculo Get(int id) {
        Veiculo veiculoBuscado = Veiculos.get(id - 1);
        return veiculoBuscado;
    }

    public Veiculo GetPlaca(String placa) {
        Veiculo itemEncontrado = null;
        for (Veiculo item : Veiculos) {
            if (item.getPlaca().equals(placa)) {
                itemEncontrado = item;
                break;
            }
        }
        return itemEncontrado;
    }

    @Override
    public List<Veiculo> GetAll() {
        return Veiculos;
    }

    @Override
    public void Update(int id, Veiculo item) {
        Veiculos.set(id - 1, item);
    }

    @Override
    public void Delete(int id) {
        Veiculos.remove(id - 1);
    }
}
