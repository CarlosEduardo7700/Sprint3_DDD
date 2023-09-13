package org.example.controllers;

import org.example.models.Bairro;
import org.example.models.Logradouro;
import org.example.services.LogradouroService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LogradouroController {
    private LogradouroService logradouroService;
    private Scanner scan;

    public LogradouroController(){
        this.logradouroService = new LogradouroService();
        this.scan = new Scanner(System.in);
    }

    public void Cadastrar() throws ParseException {
        System.out.println("\nAdicionar um novo logradouro:\n");

        int id = logradouroService.GetAll().size() + 1;

        System.out.println("Informe o bairro:");
        Bairro bairro = new Bairro();
        bairro.setNomeBairro(scan.nextLine());

        System.out.println("Informe o nome:");
        String nome = scan.nextLine();

        System.out.println("Informe o CEP:");
        String cep = scan.nextLine();

        System.out.println("Informe a data em que esse cadastro está sendo feito (Nesse formato: dd/mm/yyyy):");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataCadastro = formato.parse(scan.nextLine());

        System.out.println("Informe o nome do usuário que realizou o cadastro:");
        String nomeUsuario = scan.nextLine();

        Logradouro novoLogradouro = new Logradouro(id, bairro, nome, cep, dataCadastro, nomeUsuario);

        logradouroService.Add(novoLogradouro);
    }

    public void Buscar(){
        System.out.println("Informe o ID do logradouro:");
        int id = scan.nextInt();

        Logradouro logradouro = logradouroService.Get(id);

        System.out.println("Logradouro encontrado:");
        System.out.println("\nID: " + logradouro.getIdLogradouro() + "\nBAIRRO: " + logradouro.getBairro().getNomeBairro() + "\nNOME: " + logradouro.getNomeLogradouro() + "\nCEP: " + logradouro.getCep() + "\nDATA DE CADASTRO: " + logradouro.getDtCadastro() + "\nNOME DO USUÁRIO: " + logradouro.getNomeUsuario() + "\n");

        scan.nextLine();
    }

    public void BuscarTodos() {
        System.out.println("\nAqui está uma lista com todos os logradouros:\n");
        List<Logradouro> listaDeLogradouros = logradouroService.GetAll();
        for (Logradouro logradouro : listaDeLogradouros) {
            System.out.println("\nID: " + logradouro.getIdLogradouro() + " | BAIRRO: " + logradouro.getBairro().getNomeBairro() + " | NOME: " + logradouro.getNomeLogradouro() + " | CEP: " + logradouro.getCep() + " | DATA DE CADASTRO: " + logradouro.getDtCadastro() + " | NOME DO USUÁRIO: " + logradouro.getNomeUsuario() + "\n");
        }
    }

    public void Atualizar() throws ParseException {
        System.out.println("Informe o ID do logradouro que você deseja atualizar:");
        int id = scan.nextInt();

        Logradouro logradouro = logradouroService.Get(id);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Qual informação você deseja alterar:");
            System.out.println("1 - Bairro: " + logradouro.getBairro().getNomeBairro());
            System.out.println("2 - NOME: " + logradouro.getNomeLogradouro());
            System.out.println("3 - CEP: " + logradouro.getCep());
            System.out.println("4 - Data de Cadastro: " + logradouro.getDtCadastro());
            System.out.println("5 - Usuário: " + logradouro.getNomeUsuario());
            System.out.println("0 - Voltar.");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Informe a alteração:");
                    Bairro bairro = new Bairro();
                    bairro.setNomeBairro(scan.nextLine());

                    logradouro.setBairro(bairro);
                    break;
                case 2:
                    System.out.println("Informe a alteração:");
                    String nome = scan.nextLine();

                    logradouro.setNomeLogradouro(nome);
                    break;
                case 3:
                    System.out.println("Informe a alteração:");
                    String cep = scan.nextLine();

                    logradouro.setCep(cep);
                    break;
                case 4:
                    System.out.println("Informe a alteração(dd/mm/yyyy):");
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataCadastro = formato.parse(scan.nextLine());

                    logradouro.setDtCadastro(dataCadastro);
                    break;
                case 5:
                    System.out.println("Informe a alteração:");
                    String nomeUsuario = scan.nextLine();

                    logradouro.setNomeUsuario(nomeUsuario);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            logradouroService.Update(id, logradouro);
        }
    }

    public void Deletar() {
        System.out.println("Informe o ID do logradouro que você deseja deletar:");
        int id = scan.nextInt();

        logradouroService.Delete(id);
    }

}
