package org.example.controllers;

import org.example.models.Medida;
import org.example.services.MedidaService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MedidaController {
    private MedidaService medidaService;
    private Scanner scan;

    public MedidaController() {
        this.medidaService = new MedidaService();
        this.scan = new Scanner(System.in);
    }

    public void Cadastrar() throws ParseException {
        System.out.println("\nAdicionar uma nova medida:\n");

        int id = medidaService.GetAll().size() + 1;

        System.out.println("Informe a altura:");
        double altura = scan.nextDouble();

        System.out.println("Informe a largura:");
        double largura = scan.nextDouble();

        System.out.println("Informe o comprimento:");
        double comprimento = scan.nextDouble();

        System.out.println("Informe o peso do veículo:");
        double peso = scan.nextDouble();

        System.out.println("Informe o peso suportado:");
        double pesoSuportado = scan.nextDouble();
        scan.nextLine();

        System.out.println("Informe a data em que esse cadastro está sendo feito (Nesse formato: dd/mm/yyyy):");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataCadastro = formato.parse(scan.nextLine());

        System.out.println("Informe o nome do usuário que realizou o cadastro:");
        String nomeUsuario = scan.nextLine();

        Medida novaMedida = new Medida(id, altura, largura, comprimento, peso, pesoSuportado, dataCadastro, nomeUsuario);

        medidaService.Add(novaMedida);
    }

    public void Buscar() {
        System.out.println("Informe o ID da medida:");
        int id = scan.nextInt();

        Medida medida = medidaService.Get(id);

        System.out.println("Medida encontrada:");
        System.out.println("\nID: " + medida.getIdMedida() + "\nALTURA: " + medida.getAltura() + "\nLARGURA: " + medida.getLargura() + "\nCOMPRIMENTO: " + medida.getComprimento() + "\nPESO: " + medida.getPesoVeiculo() + "\nPESO SUPORTADO: " + medida.getPesoSuportadoModal() + "\nDATA DE CADASTRO: " + medida.getDtCadastro() + "\nNOME DO USUÁRIO: " + medida.getNomeUsuario() + "\n");

        scan.nextLine();
    }

    public void BuscarTodos() {
        System.out.println("\nAqui está uma lista com todos as medidas:\n");
        List<Medida> listaDeMedidas = medidaService.GetAll();
        for (Medida medida : listaDeMedidas) {
            System.out.println("ID: " + medida.getIdMedida() + " | ALTURA: " + medida.getAltura() + " | LARGURA: " + medida.getLargura() + " | COMPRIMENTO: " + medida.getComprimento() + " | PESO: " + medida.getPesoVeiculo() + " | PESO SUPORTADO: " + medida.getPesoSuportadoModal() + " | DATA DE CADASTRO: " + medida.getDtCadastro() + " | NOME DO USUÁRIO: " + medida.getNomeUsuario() + "\n");
        }
    }

    public void Atualizar() throws ParseException {
        System.out.println("Informe o ID da medida que você deseja atualizar:");
        int id = scan.nextInt();

        Medida medida = medidaService.Get(id);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Qual informação você deseja atualizar:");
            System.out.println("1 - Altura: " + medida.getAltura());
            System.out.println("2 - Largura: " + medida. getLargura());
            System.out.println("3 - Comprimento: " + medida.getComprimento());
            System.out.println("4 - Peso: " + medida.getPesoVeiculo());
            System.out.println("5 - Peso suportado: " + medida.getPesoSuportadoModal());
            System.out.println("6 - Data de Cadastro: " + medida.getDtCadastro());
            System.out.println("7 - Usuário: " + medida.getNomeUsuario());
            System.out.println("0 - Voltar.");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Informe a alteração:");
                    double altura = scan.nextDouble();

                    medida.setAltura(altura);
                    break;
                case 2:
                    System.out.println("Informe a alteração:");
                    double largura = scan.nextDouble();

                    medida.setLargura(largura);
                    break;
                case 3:
                    System.out.println("Informe a alteração:");
                    double comprimento = scan.nextDouble();

                    medida.setComprimento(comprimento);
                    break;
                case 4:
                    System.out.println("Informe a alteração:");
                    double peso = scan.nextDouble();

                    medida.setPesoVeiculo(peso);
                    break;
                case 5:
                    System.out.println("Informe a alteração:");
                    double pesoSuportado = scan.nextDouble();

                    medida.setPesoSuportadoModal(pesoSuportado);
                    break;
                case 6:
                    System.out.println("Informe a alteração(dd/mm/yyyy):");
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataCadastro = formato.parse(scan.nextLine());

                    medida.setDtCadastro(dataCadastro);
                    break;
                case 7:
                    System.out.println("Informe a alteração:");
                    String nomeUsuario = scan.nextLine();

                    medida.setNomeUsuario(nomeUsuario);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            medidaService.Update(id, medida);
        }
    }

    public void Deletar() {
        System.out.println("Informe o ID da medida que você deseja deletar:");
        int id = scan.nextInt();

        medidaService.Delete(id);
    }
}
