package org.example.controllers;

import org.example.models.Cliente;
import org.example.models.Colaborador;
import org.example.models.Telefone;
import org.example.services.TelefoneService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TelefoneController {
    private TelefoneService telefoneService;
    private Scanner scan;

    public TelefoneController() {
        this.telefoneService = new TelefoneService();
        this.scan = new Scanner(System.in);
    }

    public void Cadastrar() throws ParseException {
        System.out.println("\nAdicionar um novo telefone:\n");

        int id = telefoneService.GetAll().size() + 1;

        System.out.println("Informe o nome do cliente:");
        Cliente cliente = new Cliente();
        cliente.setNomeCliente(scan.nextLine());

        System.out.println("Informe o nome do colaborador:");
        Colaborador colaborador = new Colaborador();
        colaborador.setNomeColaborador(scan.nextLine());

        System.out.println("Informe o tipo do telefone:");
        String tipoTelefone = scan.nextLine();

        System.out.println("Informe o número de telefone:");
        String numTelefone = scan.nextLine();

        System.out.println("Informe o DDD:");
        String ddd = scan.nextLine();

        System.out.println("Informe o DDI:");
        String ddi = scan.nextLine();

        System.out.println("Informe a data em que esse cadastro está sendo feito (Nesse formato: dd/mm/yyyy):");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataCadastro = formato.parse(scan.nextLine());

        System.out.println("Informe o nome do usuário que realizou o cadastro:");
        String nomeUsuario = scan.nextLine();

        Telefone novoTelefone = new Telefone(id, cliente, colaborador, tipoTelefone, numTelefone, ddd, ddi, dataCadastro, nomeUsuario);

        telefoneService.Add(novoTelefone);
    }

    public void Buscar() {
        System.out.println("Informe o ID do telefone:");
        int id = scan.nextInt();

        Telefone telefone = telefoneService.Get(id);

        System.out.println("Telefone encontrado:");
        System.out.println("\nID: " + telefone.getIdTelefone() + "\nCLIENTE: " + telefone.getCliente().getNomeCliente() + "\nCOLABORADOR: " + telefone.getColaborador().getNomeColaborador() + "\nTIPO: " + telefone.getTipoTelefone() + "\nNÚMERO: " + telefone.getNumeroTelefone() + "\nDDD: " + telefone.getDddTelefone() + "\nDDI: " + telefone.getDdiTelefone() + "\nDATA DE CADASTRO: " + telefone.getDtCadastro() + "\nNOME DO USUÁRIO: " + telefone.getNomeUsuario() + "\n");

        scan.nextLine();
    }

    public void BuscarTodos() {
        System.out.println("\nAqui está uma lista com todos os telefones:\n");
        List<Telefone> listaDeTelefones = telefoneService.GetAll();
        for (Telefone telefone : listaDeTelefones) {
            System.out.println("ID: " + telefone.getIdTelefone() + " | CLIENTE: " + telefone.getCliente().getNomeCliente() + " | COLABORADOR: " + telefone.getColaborador().getNomeColaborador() + " | TIPO: " + telefone.getTipoTelefone() + " | NÚMERO: " + telefone.getNumeroTelefone() + " | DATA DE CADASTRO: " + telefone.getDtCadastro() + " | NOME DO USUÁRIO: " + telefone.getNomeUsuario() + "\n");
        }
    }

    public void Atualizar() throws ParseException {
        System.out.println("Informe o ID do telefone que você deseja atualizar:");
        int id = scan.nextInt();

        Telefone telefone = telefoneService.Get(id);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Qual informação você deseja alterar:");
            System.out.println("1 - Cliente: " + telefone.getCliente().getNomeCliente());
            System.out.println("2 - Colaborador: " + telefone.getColaborador().getNomeColaborador());
            System.out.println("3 - Tipo: " + telefone.getTipoTelefone());
            System.out.println("4 - Número: " + telefone.getNumeroTelefone());
            System.out.println("5 - DDD: " + telefone.getDddTelefone());
            System.out.println("6 - DDI: " + telefone.getDdiTelefone());
            System.out.println("7 - Data de Cadastro: " + telefone.getDtCadastro());
            System.out.println("8 - Usuário: " + telefone.getNomeUsuario());
            System.out.println("0 - Voltar.");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Informe a alteração:");
                    Cliente cliente = new Cliente();
                    cliente.setNomeCliente(scan.nextLine());

                    telefone.setCliente(cliente);
                    break;
                case 2:
                    System.out.println("Informe a alteração:");
                    Colaborador colaborador = new Colaborador();
                    colaborador.setNomeColaborador(scan.nextLine());

                    telefone.setColaborador(colaborador);
                    break;
                case 3:
                    System.out.println("Informe a alteração:");
                    String tipoTelefone = scan.nextLine();

                    telefone.setTipoTelefone(tipoTelefone);
                    break;
                case 4:
                    System.out.println("Informe a alteração:");
                    String numTelefone = scan.nextLine();

                    telefone.setNumeroTelefone(numTelefone);
                    break;
                case 5:
                    System.out.println("Informe a alteração:");
                    String ddd = scan.nextLine();

                    telefone.setDddTelefone(ddd);
                    break;
                case 6:
                    System.out.println("Informe a alteração:");
                    String ddi = scan.nextLine();

                    telefone.setDdiTelefone(ddi);
                    break;
                case 7:
                    System.out.println("Informe a alteração(dd/mm/yyyy):");
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataCadastro = formato.parse(scan.nextLine());

                    telefone.setDtCadastro(dataCadastro);
                    break;
                case 8:
                    System.out.println("Informe a alteração:");
                    String nomeUsuario = scan.nextLine();

                    telefone.setNomeUsuario(nomeUsuario);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            telefoneService.Update(id, telefone);
        }
    }

    public void Deletar() {
        System.out.println("Informe o ID do telefone que você deseja deletar:");
        int id = scan.nextInt();

        telefoneService.Delete(id);
    }
}
