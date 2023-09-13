package org.example.controllers;

import org.example.models.Chamada;
import org.example.models.Modal;
import org.example.models.Veiculo;
import org.example.services.ChamadaService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ChamadaController {
    private ChamadaService chamadaService;
    private Scanner scan;

    public ChamadaController() {
        this.chamadaService = new ChamadaService();
        this.scan = new Scanner(System.in);
    }

    public void Cadastrar() throws ParseException {
        System.out.println("\nAdicionar uma nova chamada:\n");

        int id = chamadaService.GetAll().size() + 1;

        System.out.println("Informe o caminhos das imagens:");
        String imagens = scan.nextLine();

        System.out.println("Informe o veículo:");
        Veiculo veiculo = new Veiculo();
        veiculo.setModelo(scan.nextLine());

        System.out.println("Informe o modal:");
        Modal modal = new Modal();
        modal.setModeloModal(scan.nextLine());

        System.out.println("Informe a data de início (Nesse formato: dd/mm/yyyy):");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataInicio = formato.parse(scan.nextLine());

        System.out.println("Informe a data de fim:");
        Date dataFim = formato.parse(scan.nextLine());

        System.out.println("Informe a localidade:");
        String local = scan.nextLine();

        System.out.println("Informe o destino:");
        String destino = scan.nextLine();

        System.out.println("Descreva o local:");
        String descLocal = scan.nextLine();

        System.out.println("Informe se há carga no veículo (s/n):");
        String op = scan.nextLine();
        boolean carga = true;

        if (op.equalsIgnoreCase("s")) {
            carga = true;
        } else {
            carga = false;
        }

        System.out.println("Descreva o problema:");
        String descProblema = scan.nextLine();

        System.out.println("Informe a data em que esse cadastro está sendo feito:");
        Date dataCadastro = formato.parse(scan.nextLine());

        System.out.println("Informe o nome do usuário que realizou o cadastro:");
        String nomeUsuario = scan.nextLine();

        Chamada chamada = new Chamada(id, imagens, veiculo, modal, dataInicio, dataFim, local, destino, descLocal, carga, descProblema, dataCadastro, nomeUsuario);

        chamadaService.Add(chamada);
    }

    public void Buscar() {
        System.out.println("Informe o ID da chamada:");
        int id = scan.nextInt();

        Chamada chamada = chamadaService.Get(id);

        System.out.println("Chamada encontrada:");
        System.out.println("\nID: " + chamada.getIdChamada() + "\nCAMINHO DAS IMAGENS: " + chamada.getCaminhosImagens() + "\nVEÍCULO: " + chamada.getVeiculo().getModelo() + "\nMODAL: " + chamada.getModal().getModeloModal() + "\nDATA DE INÍCIO: " + chamada.getDataInicio() + "\nDATA FIM: " + chamada.getDataFim() + "\nLOCAL: " + chamada.getLocal() + "\nDESTINO: " + chamada.getDestino() + "\nDESC. DO LOCAL: " + chamada.getDescLocal() + "\nHÁ CARGA: " + chamada.isCargaVeiculo() + "\nDESC. DO PROBLEMA: " + chamada.getDescProblema() + "\nDATA DE CADASTRO: " + chamada.getDtCadastro() + "\nNOME DO USUÁRIO: " + chamada.getNomeUsuario() + "\n");

        scan.nextLine();
    }

    public void BuscarTodos() {
        System.out.println("\nAqui está uma lista com todas as chamadas:\n");
        List<Chamada> listaDeChamadas = chamadaService.GetAll();
        for (Chamada chamada : listaDeChamadas) {
            System.out.println("ID: " + chamada.getIdChamada() + " | CAMINHO DAS IMAGENS: " + chamada.getCaminhosImagens() + " | VEÍCULO: " + chamada.getVeiculo().getModelo() + " | MODAL: " + chamada.getModal().getModeloModal() + " | DATA DE INÍCIO: " + chamada.getDataInicio() + " | DATA FIM: " + chamada.getDataFim() + " | LOCAL: " + chamada.getLocal() + " | DESTINO: " + chamada.getDestino() + " | DESC. DO LOCAL: " + chamada.getDescLocal() + " | HÁ CARGA: " + chamada.isCargaVeiculo() + " | DESC. DO PROBLEMA: " + chamada.getDescProblema() + " | DATA DE CADASTRO: " + chamada.getDtCadastro() + " | NOME DO USUÁRIO: " + chamada.getNomeUsuario() + "\n");
        }
    }

    public void Atualizar() throws ParseException {
        System.out.println("Informe o ID da chamada que você deseja atualizar:");
        int id = scan.nextInt();

        Chamada chamada = chamadaService.Get(id);

        boolean continuar = true;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        while (continuar) {
            System.out.println("Qual informação você deseja alterar:");
            System.out.println("1 - Caminho das imagens: " + chamada.getCaminhosImagens());
            System.out.println("2 - Veículo: " + chamada.getVeiculo().getModelo());
            System.out.println("3 - Modal: " + chamada.getModal().getModeloModal());
            System.out.println("4 - Data de início: " + chamada.getDataInicio());
            System.out.println("5 - Data fim: " + chamada.getDataFim());
            System.out.println("6 - Local: " + chamada.getLocal());
            System.out.println("7 - Destino: " + chamada.getDestino());
            System.out.println("8 - Desc. do Local: " + chamada.getDescLocal());
            System.out.println("9 - Há Carga: " + chamada.isCargaVeiculo());
            System.out.println("10 - Desc. do Problema: " + chamada.getDescProblema());
            System.out.println("11 - Data de Cadastro: " + chamada.getDtCadastro());
            System.out.println("12 - Usuário: " + chamada.getNomeUsuario());
            System.out.println("0 - Voltar.");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Informe a alteração:");
                    String imagens = scan.nextLine();

                    chamada.setCaminhosImagens(imagens);
                    break;
                case 2:
                    System.out.println("Informe a alteração:");
                    Veiculo veiculo = new Veiculo();
                    veiculo.setModelo(scan.nextLine());

                    chamada.setVeiculo(veiculo);
                    break;
                case 3:
                    System.out.println("Informe a alteração:");
                    Modal modal = new Modal();
                    modal.setModeloModal(scan.nextLine());

                    chamada.setModal(modal);
                    break;
                case 4:
                    System.out.println("Informe a alteração:");
                    Date dataInicio = formato.parse(scan.nextLine());

                    chamada.setDataInicio(dataInicio);
                    break;
                case 5:
                    System.out.println("Informe a alteração:");
                    Date dataFim = formato.parse(scan.nextLine());

                    chamada.setDataFim(dataFim);
                    break;
                case 6:
                    System.out.println("Informe a alteração:");
                    String local = scan.nextLine();

                    chamada.setLocal(local);
                    break;
                case 7:
                    System.out.println("Informe a alteração:");
                    String destino = scan.nextLine();

                    chamada.setDestino(destino);
                    break;
                case 8:
                    System.out.println("Informe a alteração:");
                    String descLocal = scan.nextLine();

                    chamada.setDescLocal(descLocal);
                    break;
                case 9:
                    System.out.println("Informe a alteração (s / n):");
                    String op = scan.nextLine();
                    boolean carga = true;

                    if (op.equalsIgnoreCase("s")) {
                        carga = true;
                    } else {
                        carga = false;
                    }

                    chamada.setCargaVeiculo(carga);
                    break;
                case 10:
                    System.out.println("Informe a alteração:");
                    String descProblema = scan.nextLine();

                    chamada.setDescProblema(descProblema);
                    break;
                case 11:
                    System.out.println("Informe a alteração(dd/mm/yyyy):");
                    Date dataCadastro = formato.parse(scan.nextLine());

                    chamada.setDtCadastro(dataCadastro);
                    break;
                case 12:
                    System.out.println("Informe a alteração:");
                    String nomeUsuario = scan.nextLine();

                    chamada.setNomeUsuario(nomeUsuario);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            chamadaService.Update(id, chamada);
        }
    }

    public void Deletar() {
        System.out.println("Informe o ID da chamada que você deseja deletar:");
        int id = scan.nextInt();

        chamadaService.Delete(id);
    }
}
