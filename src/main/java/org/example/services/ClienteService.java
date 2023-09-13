package org.example.services;

import org.example.models.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteService implements IService<Cliente> {
    private final List<Cliente> Clientes;

    public ClienteService() {
        Clientes = new ArrayList<Cliente>();
    }

    @Override
    public void Add(Cliente item) {
        Clientes.add(item);
    }

    @Override
    public Cliente Get(int id) {
        Cliente clienteBuscado = Clientes.get(id - 1);
        return clienteBuscado;
    }

    @Override
    public List<Cliente> GetAll() {
        return Clientes;
    }

    @Override
    public void Update(int id, Cliente item) {
        Clientes.set(id - 1, item);
    }

    @Override
    public void Delete(int id) {
        Clientes.remove(id - 1);
    }
}
