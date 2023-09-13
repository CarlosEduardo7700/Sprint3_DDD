package org.example.services;

import org.example.models.Veic_Cliente;

import java.util.ArrayList;
import java.util.List;

public class VeicClienteService implements IService<Veic_Cliente> {
    private final List<Veic_Cliente> VeicsClientes;

    public VeicClienteService() {
        VeicsClientes = new ArrayList<Veic_Cliente>();
    }

    @Override
    public void Add(Veic_Cliente item) {
        VeicsClientes.add(item);
    }

    @Override
    public Veic_Cliente Get(int id) {
        Veic_Cliente veicCliente = VeicsClientes.get(id - 1);
        return veicCliente;
    }

    @Override
    public List<Veic_Cliente> GetAll() {
        return VeicsClientes;
    }

    @Override
    public void Update(int id, Veic_Cliente item) {
        VeicsClientes.set(id - 1, item);
    }

    @Override
    public void Delete(int id) {
        VeicsClientes.remove(id - 1);
    }
}
