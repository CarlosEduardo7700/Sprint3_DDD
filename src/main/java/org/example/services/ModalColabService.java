package org.example.services;

import org.example.models.Modal_Colab;

import java.util.ArrayList;
import java.util.List;

public class ModalColabService implements IService<Modal_Colab> {
    private final List<Modal_Colab> ModaisColab;

    public ModalColabService() {
        ModaisColab = new ArrayList<Modal_Colab>();
    }

    @Override
    public void Add(Modal_Colab item) {
        ModaisColab.add(item);
    }

    @Override
    public Modal_Colab Get(int id) {
        Modal_Colab modalColab = ModaisColab.get(id - 1);
        return modalColab;
    }

    @Override
    public List<Modal_Colab> GetAll() {
        return ModaisColab;
    }

    @Override
    public void Update(int id, Modal_Colab item) {
        ModaisColab.set(id - 1, item);
    }

    @Override
    public void Delete(int id) {
        ModaisColab.remove(id - 1);
    }
}
