package org.example.controllers;

import org.example.models.Cliente;
import org.example.models.Veic_Cliente;
import org.example.models.Veiculo;
import org.example.services.VeicClienteService;

import java.util.List;
import java.util.Scanner;

public class VeicClienteController {
    private VeicClienteService veicClienteService;
    private Scanner scan;

    public VeicClienteController() {
        this.veicClienteService = new VeicClienteService();
        this.scan = new Scanner(System.in);
    }

    public void Cadastrar() {
        System.out.println("\nAdicionar um novo veículo do cliente:\n");

        System.out.println("Insira o ID do cliente:");
        Cliente cliente = new Cliente();
        cliente.setIdCliente(scan.nextInt());

        System.out.println("Insira o ID do veículo:");
        Veiculo veiculo = new Veiculo();
        veiculo.setIdVeiculo(scan.nextInt());

        Veic_Cliente veicCliente = new Veic_Cliente(cliente, veiculo);

        veicClienteService.Add(veicCliente);
    }

    public void Buscar() {
        System.out.println("Informe o ID do cliente:");
        int id = scan.nextInt();

        Veic_Cliente veicCliente = veicClienteService.Get(id);

        System.out.println("Veiculo encontrado:");
        System.out.println("\nID CLIENTE: " + veicCliente.getIdCliente().getIdCliente() + "\nID VEÍCULO: " + veicCliente.getIdVeiculo().getIdVeiculo() + "\n");
    }

    public void BuscarTodos() {
        System.out.println("\nAqui está uma lista com todos veículos dos clientes:\n");
        List<Veic_Cliente> veicClientes = veicClienteService.GetAll();
        for (Veic_Cliente veicCliente : veicClientes) {
            System.out.println("ID CLIENTE: " + veicCliente.getIdCliente().getIdCliente() + " | ID VEÍCULO: " + veicCliente.getIdVeiculo().getIdVeiculo() + "\n");
        }
    }

    public void Atualizar() {
        System.out.println("Informe o ID do cliente para poder fazer a atualização:");
        int id = scan.nextInt();

        Veic_Cliente veicCliente = veicClienteService.Get(id);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Qual informação você deseja alterar:");
            System.out.println("1 - ID do Cliente: " + veicCliente.getIdCliente().getIdCliente());
            System.out.println("2 - ID do Veículo: " + veicCliente.getIdVeiculo().getIdVeiculo());
            System.out.println("0 - Voltar.");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Informe a alteração:");
                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(scan.nextInt());

                    veicCliente.setIdCliente(cliente);
                    break;
                case 2:
                    System.out.println("Informe a alteração:");
                    Veiculo veiculo = new Veiculo();
                    veiculo.setIdVeiculo(scan.nextInt());

                    veicCliente.setIdVeiculo(veiculo);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            veicClienteService.Update(id, veicCliente);
        }
    }

    public void Deletar() {
        System.out.println("Informe o ID do veículo que você deseja deletar:");
        int id = scan.nextInt();

        veicClienteService.Delete(id);
    }
}
