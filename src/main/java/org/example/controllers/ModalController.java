package org.example.controllers;

import org.example.models.Medida;
import org.example.models.Modal;
import org.example.models.Tipo_Chassi;
import org.example.models.Tipo_Modal;
import org.example.services.ModalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ModalController {

    private ModalService modalService;
    private Scanner scan;

    public ModalController() {
        this.modalService = new ModalService();
        this.scan = new Scanner(System.in);
    }

    public void Cadastrar() throws ParseException {
        System.out.println("\nAdicionar um novo modal:\n");

        int id = modalService.GetAll().size() + 1;

        System.out.println("Informe o caminho da imagem: ");
        String caminhoImagem = scan.nextLine();

        System.out.println("Informe o tipo do modal:");
        Tipo_Modal tipoModal = new Tipo_Modal();
        tipoModal.setNomeTipoModal(scan.nextLine());

        System.out.println("Informe as medidas em metros do modal (Insira 1º a Altura e precione enter, em seguida informe o Comprimento e por fim a Largura):");
        Medida medida = new Medida();
        medida.setAltura(scan.nextDouble());
        medida.setComprimento(scan.nextDouble());
        medida.setLargura(scan.nextDouble());

        System.out.println("Informe o modelo do modal:");
        scan.nextLine();
        String modelo = scan.nextLine();

        System.out.println("Informe a placa do modal:");
        String placa = scan.nextLine();

        System.out.println("Informe a marca do modal:");
        String marca = scan.nextLine();

        System.out.println("Informe o ano de fabricação:");
        int anoFabricacao = scan.nextInt();
        scan.nextLine();

        System.out.println("Informe a data em que esse cadastro está sendo feito (Nesse formato: dd/mm/yyyy):");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataCadastro = formato.parse(scan.nextLine());

        System.out.println("Informe o nome do usuário que realizou o cadastro:");
        String nomeUsuario = scan.nextLine();

        Modal modal = new Modal(id, caminhoImagem, tipoModal, medida, modelo, placa, marca, anoFabricacao, dataCadastro, nomeUsuario);

        modalService.Add(modal);
    }

    public void Buscar() {
        System.out.println("Informe a placa do modal:");
        String placa = scan.nextLine();

        Modal modal = modalService.GetPlaca(placa);

        System.out.println("Modal Encontrado:");
        System.out.println("\nID: " + modal.getIdModal() + "\nCAMINHO DA IMAGEM: " + modal.getCaminhaImagem() + "\nTIPO: " + modal.getTipoModal().getNomeTipoModal() + "\nMEDIDAS (ALTURA, COMPRIMENTO, LARGURA): " + modal.getMedidaModal().getAltura() + ", " + modal.getMedidaModal().getComprimento() + ", " + modal.getMedidaModal().getLargura() + "\nMODELO: " + modal.getModeloModal() + "\nPLACA: " + modal.getPlacaModal() + "\nMARCA: " + modal.getMarcaModal() + "\nANO: " + modal.getMarcaModal() + "\nDATA DE CADASTRO: " + modal.getDtCadastro() + "\nNOME DO USUÁRIO: " + modal.getNomeUsuario() + "\n");

        scan.nextLine();
    }

    public void BuscarTodos() {
        System.out.println("\nAqui está uma lista com todos os modais:\n");
        List<Modal> listaDeModais = modalService.GetAll();
        for (Modal modal : listaDeModais) {
            System.out.println("ID: " + modal.getIdModal() + " | CAMINHO DA IMAGEM: " + modal.getCaminhaImagem() + " | TIPO: " + modal.getTipoModal().getNomeTipoModal() + " | MEDIDAS (ALTURA, COMPRIMENTO, LARGURA): " + modal.getMedidaModal().getAltura() + ", " + modal.getMedidaModal().getComprimento() + ", " + modal.getMedidaModal().getLargura() + " | MODELO: " + modal.getModeloModal() + " | PLACA: " + modal.getPlacaModal() + " | MARCA: " + modal.getMarcaModal() + " | ANO: " + modal.getMarcaModal() + " | DATA DE CADASTRO: " + modal.getDtCadastro() + " | NOME DO USUÁRIO: " + modal.getNomeUsuario() + "\n");
        }
    }

    public void Atualizar() throws ParseException {
        System.out.println("Informe o ID do modal que você deseja atualizar:");
        int id = scan.nextInt();

        Modal modal = modalService.Get(id);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Qual informação você deseja atualizar:");
            System.out.println("1 - Caminho da Imagem: " + modal.getCaminhaImagem());
            System.out.println("2 - Tipo: " + modal.getTipoModal().getNomeTipoModal());
            System.out.println("3 - Medidas (Altura, Comprimento e Largura): " + modal.getMedidaModal().getAltura() + ", " + modal.getMedidaModal().getComprimento() + " e " + modal.getMedidaModal().getLargura());
            System.out.println("4 - Modelo: " + modal.getModeloModal());
            System.out.println("5 - Placa: " + modal.getPlacaModal());
            System.out.println("6 - Marca: " + modal.getMarcaModal());
            System.out.println("7 - Ano: " + modal.getAnoModal());
            System.out.println("8 - Data de Cadastro: " + modal.getDtCadastro());
            System.out.println("9 - Usuário: " + modal.getNomeUsuario());
            System.out.println("0 - Voltar.");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Informe a alteração:");
                    String imagem = scan.nextLine();

                    modal.setCaminhaImagem(imagem);
                    break;
                case 2:
                    System.out.println("Informe a alteração:");
                    Tipo_Modal tipoModal = new Tipo_Modal();
                    tipoModal.setNomeTipoModal(scan.nextLine());

                    modal.setTipoModal(tipoModal);
                    break;
                case 3:
                    System.out.println("Informe a alteração (Altura, Comprimento e Largura):");
                    Medida medida = new Medida();
                    medida.setAltura(scan.nextDouble());
                    medida.setComprimento(scan.nextDouble());
                    medida.setLargura(scan.nextDouble());

                    modal.setMedidaModal(medida);
                    break;
                case 4:
                    System.out.println("Informe a alteração:");
                    String modelo = scan.nextLine();

                    modal.setModeloModal(modelo);
                    break;
                case 5:
                    System.out.println("Informe a alteração:");
                    String placa = scan.nextLine();

                    modal.setPlacaModal(placa);
                    break;
                case 6:
                    System.out.println("Informe a alteração:");
                    String marca = scan.nextLine();

                    modal.setMarcaModal(marca);
                    break;
                case 7:
                    System.out.println("Informe a alteração:");
                    int ano = scan.nextInt();

                    modal.setAnoModal(ano);
                    break;
                case 8:
                    System.out.println("Informe a alteração(dd/mm/yyyy):");
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataCadastro = formato.parse(scan.nextLine());

                    modal.setDtCadastro(dataCadastro);
                    break;
                case 9:
                    System.out.println("Informe a alteração:");
                    String nomeUsuario = scan.nextLine();

                    modal.setNomeUsuario(nomeUsuario);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            modalService.Update(id, modal);
        }
    }

    public void Deletar() {
        System.out.println("Informe o ID do modal que você deseja deletar:");
        int id = scan.nextInt();

        modalService.Delete(id);
    }
}
