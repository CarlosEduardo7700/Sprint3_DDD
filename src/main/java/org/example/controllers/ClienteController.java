package org.example.controllers;

import org.example.models.Cliente;
import org.example.models.EnderecoCliente;
import org.example.models.Genero;
import org.example.models.Telefone;
import org.example.services.ClienteService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ClienteController {
    private ClienteService clienteService;
    private Scanner scan;

    public ClienteController() {
        this.clienteService = new ClienteService();
        this.scan = new Scanner(System.in);
    }

    public void Cadastrar() throws ParseException {
        System.out.println("\nAdicionar um novo cliente:\n");

        int id = clienteService.GetAll().size() + 1;

        System.out.println("Informe o caminho da imagem:");
        String imagem = scan.nextLine();

        System.out.println("Informe o gênero:");
        Genero genero = new Genero();
        genero.setNomeGenero(scan.nextLine());

        System.out.println("Informe o endereço do cliente:");
        EnderecoCliente enderecoCliente = new EnderecoCliente();
        enderecoCliente.setDescLogradouroCliente(scan.nextLine());

        System.out.println("Informe o nome do cliente:");
        String nome = scan.nextLine();

        System.out.println("Informe o CPF:");
        String cpf = scan.nextLine();

        System.out.println("Informe o RG:");
        String rg = scan.nextLine();

        System.out.println("Informe sua data de nascimento (dd/mm/yyyy):");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNasc = formato.parse(scan.nextLine());

        System.out.println("Informe seu telefone:");
        Telefone telefone = new Telefone();
        telefone.setNumeroTelefone(scan.nextLine());

        System.out.println("Informe a CNH:");
        String cnh = scan.nextLine();

        System.out.println("Informe o email do cliente");
        String email = scan.nextLine();

        System.out.println("Informe a senha do cliente");
        String senha = scan.nextLine();

        System.out.println("Informe a data em que esse cadastro está sendo feito (Nesse formato: dd/mm/yyyy):");
        Date dataCadastro = formato.parse(scan.nextLine());

        System.out.println("Informe o nome do usuário que realizou o cadastro:");
        String nomeUsuario = scan.nextLine();

        Cliente novoCliente = new Cliente(id, imagem, genero, enderecoCliente, nome, cpf, rg, dataNasc, telefone, cnh, email, senha, dataCadastro, nomeUsuario);

        clienteService.Add(novoCliente);
    }

    public void Buscar() {
        System.out.println("Informe o ID do cliente:");
        int id = scan.nextInt();

        Cliente cliente = clienteService.Get(id);

        System.out.println("Cliente encontrado:");
        System.out.println("\nID: " + cliente.getIdCliente() + "\nCAMINHO DA IMAGEM: " + cliente.getCaminhoImagem() + "\nGÊNERO: " + cliente.getGenero().getNomeGenero() + "\nENDEREÇO: " + cliente.getEnderecoCliente().getDescLogradouroCliente() + "\nNOME: " + cliente.getNomeCliente() + "\nCPF: " + cliente.getCpfCliente() + "\nRG: " + cliente.getRgCliente() + "\nDATA DE NASCIMENTO: " + cliente.getDataNascimentoCliente() + "\nTELEFONE: " + cliente.getTelefone().getNumeroTelefone() + "\nCNH: " + cliente.getCnhCliente() + "\nEMAIL: " + cliente.getEmailCliente() + "\nSENHA: " + cliente.getSenhaCliente() + "\nDATA DE CADASTRO: " + cliente.getDtCadastro() + "\nNOME DO USUÁRIO: " + cliente.getNomeUsuario() + "\n");

        scan.nextLine();
    }

    public void BuscarTodos(){
        System.out.println("\nAqui está uma lista com todos os clientes:\n");
        List<Cliente> listaDeCliente = clienteService.GetAll();
        for (Cliente cliente : listaDeCliente) {
            System.out.println("ID: " + cliente.getIdCliente() + " | ENDEREÇO: " + cliente.getEnderecoCliente().getDescLogradouroCliente() + " | NOME: " + cliente.getNomeCliente() + " | CPF: " + cliente.getCpfCliente() + " | RG: " + cliente.getRgCliente() + " | TELEFONE: " + cliente.getTelefone().getNumeroTelefone() + " | CNH: " + cliente.getCnhCliente() + " | EMAIL: " + cliente.getEmailCliente() + " | SENHA: " + cliente.getSenhaCliente() + " | DATA DE CADASTRO: " + cliente.getDtCadastro() + " | NOME DO USUÁRIO: " + cliente.getNomeUsuario() + "\n");
        }
    }

    public void Atualizar() throws ParseException {
        System.out.println("Informe o ID do cliente que você deseja atualizar:");
        int id = scan.nextInt();

        Cliente cliente = clienteService.Get(id);

        boolean continuar = true;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        while (continuar) {
            System.out.println("Qual informação você deseja alterar:");
            System.out.println("1 - Caminho da Imagem: " + cliente.getCaminhoImagem());
            System.out.println("2 - Gênero: " + cliente.getGenero().getNomeGenero());
            System.out.println("3 - Endereço: " + cliente.getEnderecoCliente().getDescLogradouroCliente());
            System.out.println("4 - Nome: " + cliente.getNomeCliente());
            System.out.println("5 - CPF: " + cliente.getCpfCliente());
            System.out.println("6 - RG: " + cliente.getRgCliente());
            System.out.println("7 - Data de Nascimento: " + cliente.getDataNascimentoCliente());
            System.out.println("8 - Telefone: " + cliente.getTelefone().getNumeroTelefone());
            System.out.println("9 - CNH: " + cliente.getCnhCliente());
            System.out.println("10 - Email: " + cliente.getEmailCliente());
            System.out.println("11 - Senha: " + cliente.getSenhaCliente());
            System.out.println("12 - Data de Cadastro: " + cliente.getDtCadastro());
            System.out.println("13 - Usuário: " + cliente.getNomeUsuario());
            System.out.println("0 - Voltar.");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Informe a alteração:");
                    String imagem = scan.nextLine();

                    cliente.setCaminhoImagem(imagem);
                    break;
                case 2:
                    System.out.println("Informe a alteração:");
                    Genero genero = new Genero();
                    genero.setNomeGenero(scan.nextLine());

                    cliente.setGenero(genero);
                    break;
                case 3:
                    System.out.println("Informe a alteração:");
                    EnderecoCliente enderecoCliente = new EnderecoCliente();
                    enderecoCliente.setDescLogradouroCliente(scan.nextLine());

                    cliente.setEnderecoCliente(enderecoCliente);
                    break;
                case 4:
                    System.out.println("Informe a alteração:");
                    String nome = scan.nextLine();

                    cliente.setNomeCliente(nome);
                    break;
                case 5:
                    System.out.println("Informe a alteração:");
                    String cpf = scan.nextLine();

                    cliente.setCpfCliente(cpf);
                    break;
                case 6:
                    System.out.println("Informe a alteração:");
                    String rg = scan.nextLine();

                    cliente.setRgCliente(rg);
                    break;
                case 7:
                    System.out.println("Informe a alteração:");
                    Date dataNasc = formato.parse(scan.nextLine());

                    cliente.setDataNascimentoCliente(dataNasc);
                    break;
                case 8:
                    System.out.println("Informe a alteração:");
                    Telefone telefone = new Telefone();
                    telefone.setNumeroTelefone(scan.nextLine());

                    cliente.setTelefone(telefone);
                    break;
                case 9:
                    System.out.println("Informe a alteração:");
                    String cnh = scan.nextLine();

                    cliente.setCnhCliente(cnh);
                    break;
                case 10:
                    System.out.println("Informe a alteração:");
                    String email = scan.nextLine();

                    cliente.setEmailCliente(email);
                    break;
                case 11:
                    System.out.println("Informe a alteração:");
                    String senha = scan.nextLine();

                    cliente.setSenhaCliente(senha);
                    break;
                case 12:
                    System.out.println("Informe a alteração (dd/mm/yyyy):");
                    Date dataCadastro = formato.parse(scan.nextLine());

                    cliente.setDtCadastro(dataCadastro);
                    break;
                case 13:
                    System.out.println("Informe a alteração:");
                    String nomeUsuario = scan.nextLine();

                    cliente.setNomeUsuario(nomeUsuario);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            clienteService.Update(id, cliente);
        }
    }

    public void Deletar() {
        System.out.println("Informe o ID do cliente que você deseja deletar:");
        int id = scan.nextInt();

        clienteService.Delete(id);
    }
}
