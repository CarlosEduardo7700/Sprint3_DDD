package org.example.controllers;

import org.example.models.Tipo_Chassi;
import org.example.models.Tipo_Eixo;
import org.example.services.TipoEixoService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TipoEixoController {
    private TipoEixoService tipoEixoService;
    private Scanner scan;

    public TipoEixoController() {
        this.tipoEixoService = new TipoEixoService();
        this.scan = new Scanner(System.in);
    }

    public void Cadastrar() throws ParseException {
        System.out.println("\nAdicionar um novo tipo de eixo:\n");

        int id = tipoEixoService.GetAll().size() + 1;

        System.out.println("Informe o nome do tipo:");
        String nome = scan.nextLine();

        System.out.println("Informe um descrição desse tipo:");
        String descTipo = scan.nextLine();

        System.out.println("Informe a data em que esse cadastro está sendo feito (Nesse formato: dd/mm/yyyy):");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataCadastro = formato.parse(scan.nextLine());

        System.out.println("Informe o nome do usuário que realizou o cadastro:");
        String nomeUsuario = scan.nextLine();

        Tipo_Eixo novoTipoEixo = new Tipo_Eixo(id, nome, descTipo, dataCadastro, nomeUsuario);

        tipoEixoService.Add(novoTipoEixo);
    }

    public void Buscar() {
        System.out.println("Informe o ID do tipo de eixo:");
        int id = scan.nextInt();

        Tipo_Eixo tipoEixo = tipoEixoService.Get(id);

        System.out.println("Tipo Encontrado:");
        System.out.println("\nID: " + tipoEixo.getIdEixo() + "\nNOME: " + tipoEixo.getNomeTipoEixo() + "\nDESCRIÇÃO: " + tipoEixo.getDescTipoEixo() + "\nDATA DE CADASTRO: " + tipoEixo.getDtCadastro() + "\nNOME DO USUÁRIO: " + tipoEixo.getNomeUsuario() + "\n");

        scan.nextLine();
    }

    public void BuscarTodos() {
        System.out.println("\nAqui está uma lista com todos os tipos de eixo:\n");
        List<Tipo_Eixo> listaDeTipos = tipoEixoService.GetAll();
        for (Tipo_Eixo tipoEixo : listaDeTipos) {
            System.out.println("ID: " + tipoEixo.getIdEixo() + " | NOME: " + tipoEixo.getNomeTipoEixo() + " | DESCRIÇÃO: " + tipoEixo.getDescTipoEixo() + " | DATA DE CADASTRO: " + tipoEixo.getDtCadastro() + " | NOME DO USUÁRIO: " + tipoEixo.getNomeUsuario() + "\n");
        }
    }

    public void Atualizar() throws ParseException {
        System.out.println("Informe o ID do tipo de eixo que você deseja atualizar:");
        int id = scan.nextInt();

        Tipo_Eixo tipoEixo = tipoEixoService.Get(id);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Qual informação você deseja atualizar:");
            System.out.println("1 - Nome: " + tipoEixo.getNomeTipoEixo());
            System.out.println("2 - Descrição: " + tipoEixo.getDescTipoEixo());
            System.out.println("4 - Data de Cadastro: " + tipoEixo.getDtCadastro());
            System.out.println("5 - Usuário: " + tipoEixo.getNomeUsuario());
            System.out.println("0 - Voltar.");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Informe a alteração:");
                    String nome = scan.nextLine();

                    tipoEixo.setNomeTipoEixo(nome);
                    break;
                case 2:
                    System.out.println("Informe a alteração:");
                    String descTipo = scan.nextLine();

                    tipoEixo.setDescTipoEixo(descTipo);
                    break;
                case 3:
                    System.out.println("Informe a alteração(dd/mm/yyyy):");
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataCadastro = formato.parse(scan.nextLine());

                    tipoEixo.setDtCadastro(dataCadastro);
                    break;
                case 4:
                    System.out.println("Informe a alteração:");
                    String nomeUsuario = scan.nextLine();

                    tipoEixo.setNomeUsuario(nomeUsuario);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            tipoEixoService.Update(id, tipoEixo);
        }
    }

    public void Deletar() {
        System.out.println("Informe o ID do tipo de eixo que você deseja deletar:");
        int id = scan.nextInt();

        tipoEixoService.Delete(id);
    }
}
