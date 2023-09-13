package org.example.controllers;

import org.example.models.*;
import org.example.services.ModalColabService;

import java.util.List;
import java.util.Scanner;

public class ModalColabController {
    private ModalColabService modalColabService;
    private Scanner scan;

    public ModalColabController() {
        this.modalColabService = new ModalColabService();
        this.scan = new Scanner(System.in);
    }

    public void Cadastrar() {
        System.out.println("\nAdicionar um novo modal do colaborador:\n");

        System.out.println("Insira o ID do colaborador:");
        Colaborador colaborador = new Colaborador();
        colaborador.setIdColaborador(scan.nextInt());

        System.out.println("Insira o ID do modal:");
        Modal modal = new Modal();
        modal.setIdModal(scan.nextInt());

        Modal_Colab modalColab = new Modal_Colab(modal, colaborador);

        modalColabService.Add(modalColab);
    }

    public void Buscar() {
        System.out.println("Informe o ID do colaborador:");
        int id = scan.nextInt();

        Modal_Colab modalColab = modalColabService.Get(id);

        System.out.println("Modal encontrado:");
        System.out.println("\nID COLABORADOR: " + modalColab.getColaborador().getIdColaborador() + "\nID MODAL: " + modalColab.getModal().getIdModal() + "\n");
    }

    public void BuscarTodos() {
        System.out.println("\nAqui está uma lista com todos modais dos colaboradores:\n");
        List<Modal_Colab> modaisColab = modalColabService.GetAll();
        for (Modal_Colab modalColab : modaisColab) {
            System.out.println("ID COLABORADOR: " + modalColab.getColaborador().getIdColaborador() + " | ID MODAL: " + modalColab.getModal().getIdModal() + "\n");
        }
    }

    public void Atualizar() {
        System.out.println("Informe o ID do colaborador para poder fazer a atualização:");
        int id = scan.nextInt();

        Modal_Colab modalColab = modalColabService.Get(id);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Qual informação você deseja alterar:");
            System.out.println("1 - ID do Colaborador: " + modalColab.getColaborador().getIdColaborador());
            System.out.println("2 - ID do Modal: " + modalColab.getModal().getIdModal());
            System.out.println("0 - Voltar.");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Informe a alteração:");
                    Colaborador colaborador = new Colaborador();
                    colaborador.setIdColaborador(scan.nextInt());

                    modalColab.setColaborador(colaborador);
                    break;
                case 2:
                    System.out.println("Informe a alteração:");
                    Modal modal = new Modal();
                    modal.setIdModal(scan.nextInt());

                    modalColab.setModal(modal);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            modalColabService.Update(id, modalColab);
        }
    }

    public void Deletar() {
        System.out.println("Informe o ID do modal que você deseja deletar:");
        int id = scan.nextInt();

        modalColabService.Delete(id);
    }
}
