package org.example.controllers;

import org.example.models.Bairro;
import org.example.models.Cliente;
import org.example.models.EnderecoCliente;
import org.example.models.Logradouro;
import org.example.services.EnderecoClienteService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EnderecoClienteController {
    private EnderecoClienteService enderecoClienteService;
    private Scanner scan;

    public EnderecoClienteController() {
        this.enderecoClienteService = new EnderecoClienteService();
        this.scan = new Scanner(System.in);
    }

    public void Cadastrar() throws ParseException {
        System.out.println("\nAdicionar um novo endereço do cliente:\n");

        int id = enderecoClienteService.GetAll().size() + 1;

        System.out.println("Informe o nome do cliente:");
        Cliente cliente = new Cliente();
        cliente.setNomeCliente(scan.nextLine());

        System.out.println("Informe o logradouro:");
        Logradouro logradouro = new Logradouro();
        logradouro.setNomeLogradouro(scan.nextLine());

        System.out.println("Informe o número do logradouro:");
        int numLogradouro = scan.nextInt();
        scan.nextLine();

        System.out.println("Informe uma descrição do logradouro:");
        String descLogradouro = scan.nextLine();

        System.out.println("Informe a data em que esse cadastro está sendo feito (Nesse formato: dd/mm/yyyy):");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataCadastro = formato.parse(scan.nextLine());

        System.out.println("Informe o nome do usuário que realizou o cadastro:");
        String nomeUsuario = scan.nextLine();

        EnderecoCliente novoEnderecoCliente = new EnderecoCliente(id, cliente, logradouro, numLogradouro, descLogradouro, dataCadastro, nomeUsuario);

        enderecoClienteService.Add(novoEnderecoCliente);
    }

    public void Buscar() {
        System.out.println("Informe o ID do endereço do cliente:");
        int id = scan.nextInt();

        EnderecoCliente enderecoCliente = enderecoClienteService.Get(id);

        System.out.println("Endereco Encontrado:");
        System.out.println("\nID: " + enderecoCliente.getIdEnderecoCliente() + "\nCLIENTE: " + enderecoCliente.getCliente().getNomeCliente() + "\nLOGRADOURO: " + enderecoCliente.getLogradouro().getNomeLogradouro() + "\nNÚMERO DO LOGRADOURO: " + enderecoCliente.getNumLogradouroCliente() + "\nDESCRIÇÃO DO LOGRADOURO: " + enderecoCliente.getDescLogradouroCliente() + "\nDATA DE CADASTRO: " + enderecoCliente.getDtCadastro() + "\nNOME DO USUÁRIO: " + enderecoCliente.getNomeUsuario() + "\n");

        scan.nextLine();
    }

    public void BuscarTodos() {
        System.out.println("\nAqui está uma lista com todos os endereços de clientes:\n");
        List<EnderecoCliente> listaDeEndClientes = enderecoClienteService.GetAll();
        for (EnderecoCliente enderecoCliente : listaDeEndClientes) {
            System.out.println("ID: " + enderecoCliente.getIdEnderecoCliente() + " | CLIENTE: " + enderecoCliente.getCliente().getNomeCliente() + " | Logradouro: " + enderecoCliente.getLogradouro().getNomeLogradouro() + " | DATA DE CADASTRO: " + enderecoCliente.getDtCadastro() + " | NOME DO USUÁRIO: " + enderecoCliente.getNomeUsuario() + "\n");
        }
    }

    public void Atualizar() throws ParseException {
        System.out.println("Informe o ID do endereço do cliente que você deseja atualizar:");
        int id = scan.nextInt();

        EnderecoCliente enderecoCliente = enderecoClienteService.Get(id);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Qual informação você deseja alterar:");
            System.out.println("1 - Cliente: " + enderecoCliente.getCliente().getNomeCliente());
            System.out.println("2 - Logradouro: " + enderecoCliente.getLogradouro().getNomeLogradouro());
            System.out.println("3 - Número do logradouro: " + enderecoCliente.getNumLogradouroCliente());
            System.out.println("4 - Descrição do Logradouro: " + enderecoCliente.getDescLogradouroCliente());
            System.out.println("5 - Data de Cadastro: " + enderecoCliente.getDtCadastro());
            System.out.println("6 - Usuário: " + enderecoCliente.getNomeUsuario());
            System.out.println("0 - Voltar.");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Informe a alteração:");
                    Cliente cliente = new Cliente();
                    cliente.setNomeCliente(scan.nextLine());

                    enderecoCliente.setCliente(cliente);
                    break;
                case 2:
                    System.out.println("Informe a alteração:");
                    Logradouro logradouro = new Logradouro();
                    logradouro.setNomeLogradouro(scan.nextLine());

                    enderecoCliente.setLogradouro(logradouro);
                    break;
                case 3:
                    System.out.println("Informe a alteração:");
                    int numLogradouro = scan.nextInt();

                    enderecoCliente.setNumLogradouroCliente(numLogradouro);
                    break;
                case 4:
                    System.out.println("Informe a alteração:");
                    String descLogradouro = scan.nextLine();

                    enderecoCliente.setDescLogradouroCliente(descLogradouro);
                    break;
                case 5:
                    System.out.println("Informe a alteração(dd/mm/yyyy):");
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataCadastro = formato.parse(scan.nextLine());

                    enderecoCliente.setDtCadastro(dataCadastro);
                    break;
                case 6:
                    System.out.println("Informe a alteração:");
                    String nomeUsuario = scan.nextLine();

                    enderecoCliente.setNomeUsuario(nomeUsuario);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            enderecoClienteService.Update(id, enderecoCliente);
        }
    }

    public void Deletar() {
        System.out.println("Informe o ID do endereço do cliente que você deseja deletar:");
        int id = scan.nextInt();

        enderecoClienteService.Delete(id);
    }
}
