package org.example.services;

import org.example.models.Modal;
import org.example.models.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class ModalService implements IService<Modal> {
    private final List<Modal> Modais;

    public ModalService() {
        Modais = new ArrayList<Modal>();
    }

    @Override
    public void Add(Modal item) {
        Modais.add(item);
    }

    @Override
    public Modal Get(int id) {
        Modal modal = Modais.get(id - 1);
        return modal;
    }

    public Modal GetPlaca(String placa) {
        Modal itemEncontrado = null;
        for (Modal item : Modais) {
            if (item.getPlacaModal().equals(placa)) {
                itemEncontrado = item;
                break;
            }
        }
        return itemEncontrado;
    }

    @Override
    public List<Modal> GetAll() {
        return Modais;
    }

    @Override
    public void Update(int id, Modal item) {
        Modais.set(id - 1, item);
    }

    @Override
    public void Delete(int id) {
        Modais.remove(id - 1);
    }
}
