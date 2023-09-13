package org.example.controllers;

import org.example.models.Bairro;
import org.example.models.Cidade;
import org.example.services.BairroService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BairroController {
    private BairroService bairroService;
    private Scanner scan;

    public BairroController(){
        this.bairroService = new BairroService();
        this.scan = new Scanner(System.in);
    }

    public void CadastrarBairro() throws ParseException {
        System.out.println("\nAdicionar um novo bairro:");

        System.out.println("Informe a cidade:");
        Cidade cidade = new Cidade();
        cidade.setNomeCidade(scan.nextLine());

        System.out.println("Informe o nome do bairro:");
        String nome = scan.nextLine();

        System.out.println("Informe a zona do bairro:");
        String zona = scan.nextLine();

        System.out.println("Informe a data em que esse cadastro está sendo feito (Nesse formato: dd/mm/yyyy):");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataCadastro = formato.parse(scan.nextLine());

        System.out.println("Informe o nome do usuário que realizou o cadastro:");
        String nomeUsuario = scan.nextLine();

        int id = bairroService.GetAll().size() + 1;

        Bairro novoBairro = new Bairro(id, cidade, nome, zona, dataCadastro, nomeUsuario);

        bairroService.Add(novoBairro);
    }

    public void BuscarBairro(){
        System.out.println("Informe o ID do bairro:");
        int id = scan.nextInt();

        Bairro bairro = bairroService.Get(id);

        System.out.println("Bairro Encontrado:");
        System.out.println("\nID: " + bairro.getIdBairro() + "\nCIDADE: " + bairro.getCidade().getNomeCidade() + "\nNOME: " + bairro.getNomeBairro() + "\nZONA: " + bairro.getNomeZona() + "\nDATA DE CADASTRO: " + bairro.getDtCadastro() + "\nNOME DO USUÁRIO: " + bairro.getNomeUsuario() + "\n");

        scan.nextLine();
    }

    public void BuscarTodosBairros() {
        System.out.println("\nAqui está uma lista com todos os bairros:\n");
        List<Bairro> listaDeBairros = bairroService.GetAll();
        for (Bairro bairro : listaDeBairros) {
            System.out.println("\nID: " + bairro.getIdBairro() + " | CIDADE: " + bairro.getCidade().getNomeCidade() + " | NOME: " + bairro.getNomeBairro() + " | ZONA: " + bairro.getNomeZona() + " | DATA DE CADASTRO: " + bairro.getDtCadastro() + " | NOME DO USUÁRIO: " + bairro.getNomeUsuario() + "\n");
        }
    }

    public void AtuaizarBairro() throws ParseException {
        System.out.println("Informe o ID do bairro que você deseja atualizar:");
        int id = scan.nextInt();

        Bairro bairro = bairroService.Get(id);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Qual informação você deseja alterar:");
            System.out.println("1 - Cidade: " + bairro.getCidade().getNomeCidade());
            System.out.println("2 - Nome: " + bairro.getNomeBairro());
            System.out.println("3 - Zona: " + bairro.getNomeZona());
            System.out.println("4 - Data de Cadastro: " + bairro.getDtCadastro());
            System.out.println("5 - Usuário: " + bairro.getNomeUsuario());
            System.out.println("0 - Voltar.");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Informe a alteração:");
                    Cidade cidade = new Cidade();
                    cidade.setNomeCidade(scan.nextLine());

                    bairro.setCidade(cidade);
                    break;
                case 2:
                    System.out.println("Informe a alteração:");
                    String nome = scan.nextLine();

                    bairro.setNomeBairro(nome);
                    break;
                case 3:
                    System.out.println("Informe a alteração:");
                    String zona = scan.nextLine();

                    bairro.setNomeZona(zona);
                    break;
                case 4:
                    System.out.println("Informe a alteração(dd/mm/yyyy):");
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataCadastro = formato.parse(scan.nextLine());

                    bairro.setDtCadastro(dataCadastro);
                    break;
                case 5:
                    System.out.println("Informe a alteração:");
                    String nomeUsuario = scan.nextLine();

                    bairro.setNomeUsuario(nomeUsuario);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            bairroService.Update(id, bairro);
        }
    }

    public void DeletarBairro() {
        System.out.println("Informe o ID do bairro que você deseja deletar:");
        int id = scan.nextInt();

        bairroService.Delete(id);
    }

}
