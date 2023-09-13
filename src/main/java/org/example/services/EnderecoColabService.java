package org.example.services;

import org.example.models.EnderecoColaborador;

import java.util.ArrayList;
import java.util.List;

public class EnderecoColabService implements IService<EnderecoColaborador> {
    private final List<EnderecoColaborador> EnderecosColabs;

    public EnderecoColabService() {
        EnderecosColabs = new ArrayList<EnderecoColaborador>();
    }

    @Override
    public void Add(EnderecoColaborador item) {
        EnderecosColabs.add(item);
    }

    @Override
    public EnderecoColaborador Get(int id) {
        EnderecoColaborador enderecoColaborador = EnderecosColabs.get(id - 1);
        return enderecoColaborador;
    }

    @Override
    public List<EnderecoColaborador> GetAll() {
        return EnderecosColabs;
    }

    @Override
    public void Update(int id, EnderecoColaborador item) {
        EnderecosColabs.set(id - 1, item);
    }

    @Override
    public void Delete(int id) {
        EnderecosColabs.remove(id - 1);
    }
}
