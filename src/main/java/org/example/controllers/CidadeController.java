package org.example.controllers;

import org.example.models.Cidade;
import org.example.models.Estado;
import org.example.services.CidadeService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CidadeController {
    private CidadeService cidadeService;
    private Scanner scan;

    public CidadeController(){
        this.cidadeService = new CidadeService();
        this.scan = new Scanner(System.in);
    }

    public void CadastrarCidade() throws ParseException{
        System.out.println("\nAdicionar uma nova cidade:\n");

        int id = cidadeService.GetAll().size() + 1;

        System.out.println("Informe o estado:");
        Estado estado = new Estado();
        estado.setNomeEstado(scan.nextLine());

        System.out.println("Informe o nome da cidade:");
        String nome = scan.nextLine();

        System.out.println("Informe o código do IBGE:");
        int ibgeCodigo = scan.nextInt();

        System.out.println("Informe o DDD da cidade:");
        int ddd = scan.nextInt();
        scan.nextLine();

        System.out.println("Informe a data em que esse cadastro está sendo feito (Nesse formato: dd/mm/yyyy):");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataCadastro = formato.parse(scan.nextLine());

        System.out.println("Informe o nome do usuário que realizou o cadastro:");
        String nomeUsuario = scan.nextLine();

        Cidade novaCidade = new Cidade(id, estado, nome, ibgeCodigo, ddd, dataCadastro, nomeUsuario);

        cidadeService.Add(novaCidade);
    }

    public void BuscarCidade() {
        System.out.println("Informe o ID da cidade:");
        int id = scan.nextInt();

        Cidade cidade = cidadeService.Get(id);

        System.out.println("Cidade encontrada:");
        System.out.println("\nID: " + cidade.getIdCidade() + "\nESTADO: " + cidade.getEstado().getNomeEstado() + "\nNOME: " + cidade.getNomeCidade() + "\nCÓDIGO DO IBGE: " + cidade.getIbgeCodigo() + "\nDDD: " + cidade.getDdd() + "\nDATA DE CADASTRO: " + cidade.getDtCadastro() + "\nNOME DO USUÁRIO: " + cidade.getNomeUsuario() + "\n");

        scan.nextLine();
    }

    public void BuscarTodasCidades() {
        System.out.println("\nAqui está uma lista com todas as cidades:\n");
        List<Cidade> listaDeCidades = cidadeService.GetAll();
        for (Cidade cidade : listaDeCidades) {
            System.out.println("\nID: " + cidade.getIdCidade() + " | ESTADO: " + cidade.getEstado().getNomeEstado() + " | NOME: " + cidade.getNomeCidade() + " | DATA DE CADASTRO: " + cidade.getDtCadastro() + "| NOME DO USUÁRIO: " + cidade.getNomeUsuario() + "\n");
        }
    }

    public void AtualizarCidade() throws ParseException {
        System.out.println("Informe o ID da cidade que você deseja atualizar:");
        int id = scan.nextInt();

        Cidade cidade = cidadeService.Get(id);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Qual informação você deseja alterar:");
            System.out.println("1 - Estado: " + cidade.getEstado().getNomeEstado());
            System.out.println("2 - Nome: " + cidade.getNomeCidade());
            System.out.println("3 - Código do IBGE: " + cidade.getIbgeCodigo());
            System.out.println("4 - DDD: " + cidade.getDdd());
            System.out.println("5 - Data de Cadastro: " + cidade.getDtCadastro());
            System.out.println("6 - Usuário: " + cidade.getNomeUsuario());
            System.out.println("0 - Voltar.");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Informe a alteração:");
                    Estado estado = new Estado();
                    estado.setNomeEstado(scan.nextLine());

                    cidade.setEstado(estado);
                    break;
                case 2:
                    System.out.println("Informe a alteração:");
                    String nome = scan.nextLine();

                    cidade.setNomeCidade(nome);
                    break;
                case 3:
                    System.out.println("Informe a alteração:");
                    int ibgeCod = scan.nextInt();

                    cidade.setIbgeCodigo(ibgeCod);
                    break;
                case 4:
                    System.out.println("Informe a alteração:");
                    int ddd = scan.nextInt();

                    cidade.setDdd(ddd);
                    break;
                case 5:
                    System.out.println("Informe a alteração(dd/mm/yyyy):");
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataCadastro = formato.parse(scan.nextLine());

                    cidade.setDtCadastro(dataCadastro);
                    break;
                case 6:
                    System.out.println("Informe a alteração:");
                    String nomeUsuario = scan.nextLine();

                    cidade.setNomeUsuario(nomeUsuario);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            cidadeService.Update(id, cidade);
        }
    }

    public  void DeletarCidade() {
        System.out.println("Informe o ID da cidade que você deseja deletar:");
        int id = scan.nextInt();

        cidadeService.Delete(id);
    }
}
