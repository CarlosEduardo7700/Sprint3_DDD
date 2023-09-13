package org.example.controllers;

import org.example.models.*;
import org.example.services.EnderecoColabService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EnderecoColabController {
    private EnderecoColabService enderecoColabService;
    private Scanner scan;

    public EnderecoColabController() {
        this.enderecoColabService = new EnderecoColabService();
        this.scan = new Scanner(System.in);
    }

    public void Cadastrar() throws ParseException {
        System.out.println("\nAdicionar um novo endereço do colaborador:\n");

        int id = enderecoColabService.GetAll().size() + 1;

        System.out.println("Informe o nome do colaborador:");
        Colaborador colaborador = new Colaborador();
        colaborador.setNomeColaborador(scan.nextLine());

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

        EnderecoColaborador enderecoColaborador = new EnderecoColaborador(id, colaborador, logradouro, numLogradouro, descLogradouro, dataCadastro, nomeUsuario);

        enderecoColabService.Add(enderecoColaborador);
    }

    public void Buscar() {
        System.out.println("Informe o ID do endereço do colaborador:");
        int id = scan.nextInt();

        EnderecoColaborador enderecoColaborador = enderecoColabService.Get(id);

        System.out.println("Endereco Encontrado:");
        System.out.println("\nID: " + enderecoColaborador.getId() + "\nCLIENTE: " + enderecoColaborador.getColaborador().getNomeColaborador() + "\nLOGRADOURO: " + enderecoColaborador.getLogradouro().getNomeLogradouro() + "\nNÚMERO DO LOGRADOURO: " + enderecoColaborador.getNumLogradouroColaborador() + "\nDESCRIÇÃO DO LOGRADOURO: " + enderecoColaborador.getDescLogradouroColaborador() + "\nDATA DE CADASTRO: " + enderecoColaborador.getDtCadastro() + "\nNOME DO USUÁRIO: " + enderecoColaborador.getNomeUsuario() + "\n");

        scan.nextLine();
    }

    public void BuscarTodos() {
        System.out.println("\nAqui está uma lista com todos os endereços de colaboradores:\n");
        List<EnderecoColaborador> listaDeEndColab = enderecoColabService.GetAll();
        for (EnderecoColaborador enderecoColaborador : listaDeEndColab) {
            System.out.println("ID: " + enderecoColaborador.getId() + " | CLIENTE: " + enderecoColaborador.getColaborador().getNomeColaborador() + " | LOGRADOURO: " + enderecoColaborador.getLogradouro().getNomeLogradouro() + " | NÚMERO DO LOGRADOURO: " + enderecoColaborador.getNumLogradouroColaborador() + " | DESCRIÇÃO DO LOGRADOURO: " + enderecoColaborador.getDescLogradouroColaborador() + " | DATA DE CADASTRO: " + enderecoColaborador.getDtCadastro() + " | NOME DO USUÁRIO: " + enderecoColaborador.getNomeUsuario() + "\n");
        }
    }

    public void Atualizar() throws ParseException {
        System.out.println("Informe o ID do endereço do colaboradores que você deseja atualizar:");
        int id = scan.nextInt();

        EnderecoColaborador enderecoColaborador = enderecoColabService.Get(id);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Qual informação você deseja alterar:");
            System.out.println("1 - Colaborador: " + enderecoColaborador.getColaborador().getNomeColaborador());
            System.out.println("2 - Logradouro: " + enderecoColaborador.getLogradouro().getNomeLogradouro());
            System.out.println("3 - Número do logradouro: " + enderecoColaborador.getNumLogradouroColaborador());
            System.out.println("4 - Descrição do Logradouro: " + enderecoColaborador.getDescLogradouroColaborador());
            System.out.println("5 - Data de Cadastro: " + enderecoColaborador.getDtCadastro());
            System.out.println("6 - Usuário: " + enderecoColaborador.getNomeUsuario());
            System.out.println("0 - Voltar.");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Informe a alteração:");
                    Colaborador colaborador = new Colaborador();
                    colaborador.setNomeColaborador(scan.nextLine());

                    enderecoColaborador.setColaborador(colaborador);
                    break;
                case 2:
                    System.out.println("Informe a alteração:");
                    Logradouro logradouro = new Logradouro();
                    logradouro.setNomeLogradouro(scan.nextLine());

                    enderecoColaborador.setLogradouro(logradouro);
                    break;
                case 3:
                    System.out.println("Informe a alteração:");
                    int numLogradouro = scan.nextInt();

                    enderecoColaborador.setNumLogradouroColaborador(numLogradouro);
                    break;
                case 4:
                    System.out.println("Informe a alteração:");
                    String descLogradouro = scan.nextLine();

                    enderecoColaborador.setDescLogradouroColaborador(descLogradouro);
                    break;
                case 5:
                    System.out.println("Informe a alteração(dd/mm/yyyy):");
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataCadastro = formato.parse(scan.nextLine());

                    enderecoColaborador.setDtCadastro(dataCadastro);
                    break;
                case 6:
                    System.out.println("Informe a alteração:");
                    String nomeUsuario = scan.nextLine();

                    enderecoColaborador.setNomeUsuario(nomeUsuario);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            enderecoColabService.Update(id, enderecoColaborador);
        }
    }

    public void Deletar() {
        System.out.println("Informe o ID do endereço do colaborador que você deseja deletar:");
        int id = scan.nextInt();

        enderecoColabService.Delete(id);
    }
}
