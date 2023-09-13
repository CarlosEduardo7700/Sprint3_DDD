package org.example.controllers;

import org.example.models.Tipo_Chassi;
import org.example.services.TipoChassiService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TipoChassiController {
    private TipoChassiService tipoChassiService;
    private Scanner scan;

    public TipoChassiController() {
        this.tipoChassiService = new TipoChassiService();
        this.scan = new Scanner(System.in);
    }

    public void Cadastrar() throws ParseException {
        System.out.println("\nAdicionar um novo tipo de chassi:\n");

        int id = tipoChassiService.GetAll().size() + 1;

        System.out.println("Informe o nome do tipo:");
        String nome = scan.nextLine();

        System.out.println("Informe um descrição desse tipo:");
        String descTipo = scan.nextLine();

        System.out.println("Informe a data em que esse cadastro está sendo feito (Nesse formato: dd/mm/yyyy):");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataCadastro = formato.parse(scan.nextLine());

        System.out.println("Informe o nome do usuário que realizou o cadastro:");
        String nomeUsuario = scan.nextLine();

        Tipo_Chassi novoTipoChassi = new Tipo_Chassi(id, nome, descTipo, dataCadastro, nomeUsuario);

        tipoChassiService.Add(novoTipoChassi);
    }

    public void Buscar() {
        System.out.println("Informe o ID do tipo de chassi:");
        int id = scan.nextInt();

        Tipo_Chassi tipoChassi = tipoChassiService.Get(id);

        System.out.println("Tipo Encontrado:");
        System.out.println("\nID: " + tipoChassi.getIdChassi() + "\nNOME: " + tipoChassi.getNomeTipoChassi() + "\nDESCRIÇÃO: " + tipoChassi.getDescTipoChassi() + "\nDATA DE CADASTRO: " + tipoChassi.getDtCadastro() + "\nNOME DO USUÁRIO: " + tipoChassi.getNomeUsuario() + "\n");

        scan.nextLine();
    }

    public void BuscarTodos() {
        System.out.println("\nAqui está uma lista com todos os tipos de chassi:\n");
        List<Tipo_Chassi> listaDeTipos = tipoChassiService.GetAll();
        for (Tipo_Chassi tipoChassi : listaDeTipos) {
            System.out.println("ID: " + tipoChassi.getIdChassi() + " | NOME: " + tipoChassi.getNomeTipoChassi() + " | DESCRIÇÃO: " + tipoChassi.getDescTipoChassi() + " | DATA DE CADASTRO: " + tipoChassi.getDtCadastro() + " | NOME DO USUÁRIO: " + tipoChassi.getNomeUsuario() + "\n");
        }
    }

    public void Atualizar() throws ParseException {
        System.out.println("Informe o ID do tipo de chassi que você deseja atualizar:");
        int id = scan.nextInt();

        Tipo_Chassi tipoChassi = tipoChassiService.Get(id);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Qual informação você deseja atualizar:");
            System.out.println("1 - Nome: " + tipoChassi.getNomeTipoChassi());
            System.out.println("2 - Descrição: " + tipoChassi.getDescTipoChassi());
            System.out.println("3 - Data de Cadastro: " + tipoChassi.getDtCadastro());
            System.out.println("4 - Usuário: " + tipoChassi.getNomeUsuario());
            System.out.println("0 - Voltar.");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Informe a alteração:");
                    String nome = scan.nextLine();

                    tipoChassi.setNomeTipoChassi(nome);
                    break;
                case 2:
                    System.out.println("Informe a alteração:");
                    String descTipo = scan.nextLine();

                    tipoChassi.setDescTipoChassi(descTipo);
                    break;
                case 3:
                    System.out.println("Informe a alteração(dd/mm/yyyy):");
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataCadastro = formato.parse(scan.nextLine());

                    tipoChassi.setDtCadastro(dataCadastro);
                    break;
                case 4:
                    System.out.println("Informe a alteração:");
                    String nomeUsuario = scan.nextLine();

                    tipoChassi.setNomeUsuario(nomeUsuario);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            tipoChassiService.Update(id, tipoChassi);
        }
    }

    public void Deletar() {
        System.out.println("Informe o ID do tipo de chassi que você deseja deletar:");
        int id = scan.nextInt();

        tipoChassiService.Delete(id);
    }
}
