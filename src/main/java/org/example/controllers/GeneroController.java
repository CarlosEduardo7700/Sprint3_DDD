package org.example.controllers;

import org.example.models.Bairro;
import org.example.models.Genero;
import org.example.services.GeneroService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class GeneroController {
    private GeneroService generoService;
    private Scanner scan;

    public GeneroController() {
        this.generoService = new GeneroService();
        this.scan = new Scanner(System.in);
    }

    public void Cadastrar() throws ParseException {
        System.out.println("\nAdicionar um novo genero:\n");

        int id = generoService.GetAll().size() + 1;

        System.out.println("Informe o nome:");
        String nome = scan.nextLine();

        System.out.println("Informe a data em que esse cadastro está sendo feito (Nesse formato: dd/mm/yyyy):");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataCadastro = formato.parse(scan.nextLine());

        System.out.println("Informe o nome do usuário que realizou o cadastro:");
        String nomeUsuario = scan.nextLine();

        Genero novoGenero = new Genero(id, nome, dataCadastro, nomeUsuario);

        generoService.Add(novoGenero);
    }

    public void Buscar(){
        System.out.println("Informe o ID do genero:");
        int id = scan.nextInt();

        Genero genero = generoService.Get(id);

        System.out.println("Gênero Encontrado:");
        System.out.println("\nID: " + genero.getIdGenero() + "\nNOME: " + genero.getNomeGenero() + "\nDATA DE CADASTRO: " + genero.getDtCadastro() + "\nNOME DO USUÁRIO: " + genero.getNomeUsuario() + "\n");

        scan.nextLine();
    }

    public void BuscarTodos() {
        System.out.println("\nAqui está uma lista com todos os gêneros:\n");
        List<Genero> listaDeGenero = generoService.GetAll();
        for (Genero genero : listaDeGenero) {
            System.out.println("ID: " + genero.getIdGenero() + " | NOME: " + genero.getNomeGenero() + " | DATA DE CADASTRO: " + genero.getDtCadastro() + " | NOME DO USUÁRIO: " + genero.getNomeUsuario() + "\n");
        }
    }

    public void Atualizar() throws ParseException {
        System.out.println("Informe o ID do genero que você deseja atualizar:");
        int id = scan.nextInt();

        Genero genero = generoService.Get(id);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Qual informação você deseja alterar:");
            System.out.println("1 - Nome: " + genero.getNomeGenero());
            System.out.println("2 - Data de Cadastro: " + genero.getDtCadastro());
            System.out.println("3 - Usuário: " + genero.getNomeUsuario());
            System.out.println("0 - Voltar.");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Informe a alteração:");
                    String nome = scan.nextLine();

                    genero.setNomeGenero(nome);
                    break;
                case 2:
                    System.out.println("Informe a alteração(dd/mm/yyyy):");
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataCadastro = formato.parse(scan.nextLine());

                    genero.setDtCadastro(dataCadastro);
                    break;
                case 3:
                    System.out.println("Informe a alteração:");
                    String nomeUsuario = scan.nextLine();

                    genero.setNomeUsuario(nomeUsuario);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");

            }

            generoService.Update(id, genero);
        }
    }

    public void Deletar() {
        System.out.println("Informe o ID do genero que você deseja deletar:");
        int id = scan.nextInt();

        generoService.Delete(id);
    }
}
