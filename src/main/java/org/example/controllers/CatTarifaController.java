package org.example.controllers;

import org.example.models.Cat_Tarifa;
import org.example.services.CatTarifariaService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CatTarifaController {

    private CatTarifariaService catTarifariaService;
    private Scanner scan;

    public CatTarifaController() {
        this.catTarifariaService = new CatTarifariaService();
        this.scan = new Scanner(System.in);
    }

    public void Cadastrar() throws ParseException {
        System.out.println("\nAdicionar uma nova categoria tarifária:\n");

        int id = catTarifariaService.GetAll().size() + 1;

        System.out.println("Informe o nome da categoria:");
        String nome = scan.nextLine();

        System.out.println("Informe um descrição dessa categoria:");
        String descCateg = scan.nextLine();

        System.out.println("Informe o valor da categoria:");
        double valor = scan.nextDouble();
        scan.nextLine();

        System.out.println("Informe a data em que esse cadastro está sendo feito (Nesse formato: dd/mm/yyyy):");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataCadastro = formato.parse(scan.nextLine());

        System.out.println("Informe o nome do usuário que realizou o cadastro:");
        String nomeUsuario = scan.nextLine();

        Cat_Tarifa novaCatTarifa = new Cat_Tarifa(id, nome, descCateg, valor, dataCadastro, nomeUsuario);

        catTarifariaService.Add(novaCatTarifa);
    }

    public void Buscar() {
        System.out.println("Informe o ID da categoria tarifária:");
        int id = scan.nextInt();

        Cat_Tarifa catTarifa = catTarifariaService.Get(id);

        System.out.println("Categoria Encontrada:");
        System.out.println("\nID: " + catTarifa.getIdCatTarifa() + "\nNOME: " + catTarifa.getNomeCategoria() + "\nDESCRIÇÃO: " + catTarifa.getDescricaoCategoria() + "\nVALOR: " + catTarifa.getValorCategoria() + "\nDATA DE CADASTRO: " + catTarifa.getDtCadastro() + "\nNOME DO USUÁRIO: " + catTarifa.getNomeUsuario() + "\n");

        scan.nextLine();
    }

    public void BuscarTodos() {
        System.out.println("\nAqui está uma lista com todas as categorias tarifárias:\n");
        List<Cat_Tarifa> listaDeCategs = catTarifariaService.GetAll();
        for (Cat_Tarifa catTarifa : listaDeCategs) {
            System.out.println("ID: " + catTarifa.getIdCatTarifa() + " | NOME: " + catTarifa.getNomeCategoria() + " | DESCRIÇÃO: " + catTarifa.getDescricaoCategoria() + " | VALOR: " + catTarifa.getValorCategoria() + " | DATA DE CADASTRO: " + catTarifa.getDtCadastro() + " | NOME DO USUÁRIO: " + catTarifa.getNomeUsuario() + "\n");
        }
    }

    public void Atualizar() throws ParseException {
        System.out.println("Informe o ID da categoria tarifária que você deseja atualizar:");
        int id = scan.nextInt();

        Cat_Tarifa catTarifa = catTarifariaService.Get(id);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Qual informação você deseja atualizar:");
            System.out.println("1 - Nome: " + catTarifa.getNomeCategoria());
            System.out.println("2 - Descrição: " + catTarifa.getDescricaoCategoria());
            System.out.println("3 - Valor: " + catTarifa.getValorCategoria());
            System.out.println("4 - Data de Cadastro: " + catTarifa.getDtCadastro());
            System.out.println("5 - Usuário: " + catTarifa.getNomeUsuario());
            System.out.println("0 - Voltar.");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Informe a alteração:");
                    String nome = scan.nextLine();

                    catTarifa.setNomeCategoria(nome);
                    break;
                case 2:
                    System.out.println("Informe a alteração:");
                    String descCateg = scan.nextLine();

                    catTarifa.setDescricaoCategoria(descCateg);
                    break;
                case 3:
                    System.out.println("Informe a alteração:");
                    double valor = scan.nextDouble();

                    catTarifa.setValorCategoria(valor);
                    break;
                case 4:
                    System.out.println("Informe a alteração(dd/mm/yyyy):");
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataCadastro = formato.parse(scan.nextLine());

                    catTarifa.setDtCadastro(dataCadastro);
                    break;
                case 5:
                    System.out.println("Informe a alteração:");
                    String nomeUsuario = scan.nextLine();

                    catTarifa.setNomeUsuario(nomeUsuario);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            catTarifariaService.Update(id, catTarifa);
        }
    }

    public void Deletar() {
        System.out.println("Informe o ID da categoria tarifária que você deseja deletar:");
        int id = scan.nextInt();

        catTarifariaService.Delete(id);
    }
}
