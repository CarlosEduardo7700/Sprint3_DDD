package org.example.controllers;

import org.example.models.Tipo_Modal;
import org.example.services.TipoModalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TipoModalController {
    private TipoModalService tipoModalService;
    private Scanner scan;

    public TipoModalController() {
        this.tipoModalService = new TipoModalService();
        this.scan = new Scanner(System.in);
    }

    public void Cadastrar() throws ParseException {
        System.out.println("\nAdicionar um novo tipo de modal:\n");

        int id = tipoModalService.GetAll().size() + 1;

        System.out.println("Informe o nome do tipo:");
        String nome = scan.nextLine();

        System.out.println("Informe a data em que esse cadastro está sendo feito (Nesse formato: dd/mm/yyyy):");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataCadastro = formato.parse(scan.nextLine());

        System.out.println("Informe o nome do usuário que realizou o cadastro:");
        String nomeUsuario = scan.nextLine();

        Tipo_Modal tipoModal = new Tipo_Modal(id, nome, dataCadastro, nomeUsuario);

        tipoModalService.Add(tipoModal);
    }

    public void Buscar() {
        System.out.println("Informe o ID do tipo de modal:");
        int id = scan.nextInt();

        Tipo_Modal tipoModal = tipoModalService.Get(id);

        System.out.println("Tipo Encontrado:");
        System.out.println("\nID: " + tipoModal.getIdTipoModal() + "\nNOME: " + tipoModal.getNomeTipoModal() + "\nDATA DE CADASTRO: " + tipoModal.getDtCadastro() + "\nNOME DO USUÁRIO: " + tipoModal.getNomeUsuario() + "\n");

        scan.nextLine();
    }

    public void BuscarTodos() {
        System.out.println("\nAqui está uma lista com todos os tipos de modais:\n");
        List<Tipo_Modal> listaDeTipos = tipoModalService.GetAll();
        for (Tipo_Modal tipoModal : listaDeTipos) {
            System.out.println("ID: " + tipoModal.getIdTipoModal() + " | NOME: " + tipoModal.getNomeTipoModal() + " | DATA DE CADASTRO: " + tipoModal.getDtCadastro() + " | NOME DO USUÁRIO: " + tipoModal.getNomeUsuario() + "\n");
        }
    }

    public void Atualizar() throws ParseException {
        System.out.println("Informe o ID do tipo de modal que você deseja atualizar:");
        int id = scan.nextInt();

        Tipo_Modal tipoModal = tipoModalService.Get(id);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Qual informação você deseja atualizar:");
            System.out.println("1 - Nome: " + tipoModal.getNomeTipoModal());
            System.out.println("2 - Data de Cadastro: " + tipoModal.getDtCadastro());
            System.out.println("3 - Usuário: " + tipoModal.getNomeUsuario());
            System.out.println("0 - Voltar.");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Informe a alteração:");
                    String nome = scan.nextLine();

                    tipoModal.setNomeTipoModal(nome);
                    break;
                case 2:
                    System.out.println("Informe a alteração(dd/mm/yyyy):");
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataCadastro = formato.parse(scan.nextLine());

                    tipoModal.setDtCadastro(dataCadastro);
                    break;
                case 3:
                    System.out.println("Informe a alteração:");
                    String nomeUsuario = scan.nextLine();

                    tipoModal.setNomeUsuario(nomeUsuario);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            tipoModalService.Update(id, tipoModal);
        }
    }

    public void Deletar() {
        System.out.println("Informe o ID do tipo de modal que você deseja deletar:");
        int id = scan.nextInt();

        tipoModalService.Delete(id);
    }
}
