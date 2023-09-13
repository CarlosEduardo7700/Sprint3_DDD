package org.example.controllers;

import org.example.models.Estado;
import org.example.services.CidadeService;
import org.example.services.EstadoService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EstadoController {
    private EstadoService estadoService;
    private Scanner scan;

    public EstadoController() {
        this.estadoService = new EstadoService();
        this.scan = new Scanner(System.in);
    }

    public void Cadastrar() throws ParseException {
        System.out.println("\nAdicionar um novo estado:\n");

        int id = estadoService.GetAll().size() + 1;

        System.out.println("Informe as sigla do estado:");
        String sigla =  scan.nextLine();

        System.out.println("Informe o nome do estado:");
        String nome = scan.nextLine();

        System.out.println("Informe a data em que esse cadastro está sendo feito (Nesse formato: dd/mm/yyyy):");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataCadastro = formato.parse(scan.nextLine());

        System.out.println("Informe o nome do usuário que realizou o cadastro:");
        String nomeUsuario = scan.nextLine();

        Estado novoEstado = new Estado(id, sigla, nome, dataCadastro, nomeUsuario);

        estadoService.Add(novoEstado);
    }

    public void Buscar(){
        System.out.println("Informe o ID do estado:");
        int id = scan.nextInt();

        Estado estado = estadoService.Get(id);

        System.out.println("Estado encontrado:");
        System.out.println("\nID: " + estado.getIdEstado() + "\nSIGLA: " + estado.getSigla() + "\nNOME: " + estado.getNomeEstado() + "\nDATA DE CADASTRO: " + estado.getDtCadastro() + "\nNOME DO USUÁRIO: " + estado.getNomeUsuario() + "\n");

        scan.nextLine();
    }

    public void BuscarTodos() {
        System.out.println("\nAqui está uma lista com todos os Estados:\n");
        List<Estado> listaDeEstados = estadoService.GetAll();
        for (Estado estado : listaDeEstados) {
            System.out.println("\nID: " + estado.getIdEstado() + " | SIGLA: " + estado.getSigla() + " | NOME: " + estado.getNomeEstado() + " | DATA DE CADASTRO: " + estado.getDtCadastro() + " | NOME DO USUÁRIO: " + estado.getNomeUsuario() + "\n");
        }
    }

    public void Atualizar() throws ParseException {
        System.out.println("Informe o ID do estado que você deseja atualizar:");
        int id = scan.nextInt();

        Estado estado = estadoService.Get(id);

        boolean continuar = true;
        while (continuar) {
            System.out.println("Qual informação você deseja alterar:");
            System.out.println("1 - Sigla: " + estado.getSigla());
            System.out.println("2 - Nome: " + estado.getNomeEstado());
            System.out.println("4 - Data de Cadastro: " + estado.getDtCadastro());
            System.out.println("5 - Usuário: " + estado.getNomeUsuario());
            System.out.println("0 - Voltar.");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Informe a alteração:");
                    String sigla = scan.nextLine();

                    estado.setSigla(sigla);
                    break;
                case 2:
                    System.out.println("Informe a alteração:");
                    String nome = scan.nextLine();

                    estado.setNomeEstado(nome);
                    break;
                case 3:
                    System.out.println("Informe a alteração(dd/mm/yyyy):");
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataCadastro = formato.parse(scan.nextLine());

                    estado.setDtCadastro(dataCadastro);
                    break;
                case 4:
                    System.out.println("Informe a alteração:");
                    String nomeUsuario = scan.nextLine();

                    estado.setNomeUsuario(nomeUsuario);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            estadoService.Update(id, estado);
        }
    }

    public void Deletar() {
        System.out.println("Informe o ID do estado que você deseja deletar:");
        int id = scan.nextInt();

        estadoService.Delete(id);
    }

}
