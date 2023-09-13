package org.example.services;

import org.example.models.EnderecoCliente;

import java.util.ArrayList;
import java.util.List;

public class EnderecoClienteService implements IService<EnderecoCliente> {
    private final List<EnderecoCliente> EnderecosClientes;

    public EnderecoClienteService() {
        EnderecosClientes = new ArrayList<EnderecoCliente>();
    }

    @Override
    public void Add(EnderecoCliente item) {
        EnderecosClientes.add(item);
    }

    @Override
    public EnderecoCliente Get(int id) {
        EnderecoCliente enderecoClienteBuscado = EnderecosClientes.get(id - 1);
        return enderecoClienteBuscado;
    }

    @Override
    public List<EnderecoCliente> GetAll() {
        return EnderecosClientes;
    }

    @Override
    public void Update(int id, EnderecoCliente item) {
        EnderecosClientes.set(id - 1, item);
    }

    @Override
    public void Delete(int id) {
        EnderecosClientes.remove(id - 1);
    }
}
