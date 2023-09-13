package org.example.controllers;

import org.example.models.*;
import org.example.services.ColaboradorService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ColaboradorController {
    private ColaboradorService colaboradorService;
    private Scanner scan;

    public ColaboradorController() {
        this.colaboradorService = new ColaboradorService();
        this.scan = new Scanner(System.in);
    }

    public void Cadastrar() throws ParseException {
        System.out.println("\nAdicionar um novo colaborador:\n");

        int id = colaboradorService.GetAll().size() + 1;

        System.out.println("Informe o caminho da imagem:");
        String imagem = scan.nextLine();

        System.out.println("Informe o modal fornecido:");
        Modal modal = new Modal();
        modal.setModeloModal(scan.nextLine());

        System.out.println("Informe o gênero:");
        Genero genero = new Genero();
        genero.setNomeGenero(scan.nextLine());

        System.out.println("Informe o endereço do colaborador:");
        EnderecoColaborador enderecoColaborador = new EnderecoColaborador();
        enderecoColaborador.setDescLogradouroColaborador(scan.nextLine());

        System.out.println("Informe o nome do colaborador:");
        String nome = scan.nextLine();

        System.out.println("Informe o CPF:");
        String cpf = scan.nextLine();

        System.out.println("Informe o RG:");
        String rg = scan.nextLine();

        System.out.println("Informe sua data de nascimento (dd/mm/yyyy):");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNasc = formato.parse(scan.nextLine());

        System.out.println("Informe o telefone:");
        Telefone telefone = new Telefone();
        telefone.setNumeroTelefone(scan.nextLine());

        System.out.println("Informe a CNH:");
        String cnh = scan.nextLine();

        System.out.println("Informe o email do colaborador");
        String email = scan.nextLine();

        System.out.println("Informe a senha do colaborador");
        String senha = scan.nextLine();

        System.out.println("Informe a data em que esse cadastro está sendo feito (Nesse formato: dd/mm/yyyy):");
        Date dataCadastro = formato.parse(scan.nextLine());

        System.out.println("Informe o nome do usuário que realizou o cadastro:");
        String nomeUsuario = scan.nextLine();

        Colaborador colaborador = new Colaborador(id, imagem, modal, genero, enderecoColaborador, telefone, nome, cpf, rg, email, senha, cnh, dataNasc, dataCadastro, nomeUsuario);

        colaboradorService.Add(colaborador);
    }

    public void Buscar() {
        System.out.println("Informe o ID do colaborador:");
        int id = scan.nextInt();

        Colaborador colaborador = colaboradorService.Get(id);

        System.out.println("Colaborador encontrado:");
        System.out.println("\nID: " + colaborador.getIdColaborador() + "\nCAMINHO DA IMAGEM: " + colaborador.getCaminhoImagem() + "\nMODAL: " + colaborador.getModal().getModeloModal() + "\nGÊNERO: " + colaborador.getGenero().getNomeGenero() + "\nENDEREÇO: " + colaborador.getEnderecoColaborador().getDescLogradouroColaborador() + "\nNOME: " + colaborador.getNomeColaborador() + "\nCPF: " + colaborador.getCpfColaborador() + "\nRG: " + colaborador.getRgColaborador() + "\nDATA DE NASCIMENTO: " + colaborador.getDataNascimentoColaborador() + "\nTELEFONE: " + colaborador.getTelefone().getNumeroTelefone() + "\nCNH: " + colaborador.getCnhColaborador() + "\nEMAIL: " + colaborador.getEmailColaborador() + "\nSENHA: " + colaborador.getSenhaColaborador() + "\nDATA DE CADASTRO: " + colaborador.getDtCadastro() + "\nNOME DO USUÁRIO: " + colaborador.getNomeUsuario() + "\n");

        scan.nextLine();
    }

    public void BuscarTodos(){
        System.out.println("\nAqui está uma lista com todos os colaboradores:\n");
        List<Colaborador> listaDeColaborador = colaboradorService.GetAll();
        for (Colaborador colaborador : listaDeColaborador) {
            System.out.println("ID: " + colaborador.getIdColaborador() + " | CAMINHO DA IMAGEM: " + colaborador.getCaminhoImagem() + " | MODAL: " + colaborador.getModal().getModeloModal() + " | GÊNERO: " + colaborador.getGenero().getNomeGenero() + " | ENDEREÇO: " + colaborador.getEnderecoColaborador().getDescLogradouroColaborador() + " | NOME: " + colaborador.getNomeColaborador() + " | CPF: " + colaborador.getCpfColaborador() + " | RG: " + colaborador.getRgColaborador() + " | DATA DE NASCIMENTO: " + colaborador.getDataNascimentoColaborador() + " | TELEFONE: " + colaborador.getTelefone().getNumeroTelefone() + " | CNH: " + colaborador.getCnhColaborador() + " | EMAIL: " + colaborador.getEmailColaborador() + " | SENHA: " + colaborador.getSenhaColaborador() + " | DATA DE CADASTRO: " + colaborador.getDtCadastro() + " | NOME DO USUÁRIO: " + colaborador.getNomeUsuario() + "\n");
        }
    }

    public void Atualizar() throws ParseException {
        System.out.println("Informe o ID do colaborador que você deseja atualizar:");
        int id = scan.nextInt();

        Colaborador colaborador = colaboradorService.Get(id);

        boolean continuar = true;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        while (continuar) {
            System.out.println("Qual informação você deseja alterar:");
            System.out.println("1 - Caminho da Imagem: " + colaborador.getCaminhoImagem());
            System.out.println("2 - Gênero: " + colaborador.getGenero().getNomeGenero());
            System.out.println("3 - Modal: " + colaborador.getModal().getModeloModal());
            System.out.println("4 - Endereço: " + colaborador.getEnderecoColaborador().getDescLogradouroColaborador());
            System.out.println("5 - Nome: " + colaborador.getNomeColaborador());
            System.out.println("6 - CPF: " + colaborador.getCpfColaborador());
            System.out.println("7 - RG: " + colaborador.getRgColaborador());
            System.out.println("8 - Data de Nascimento: " + colaborador.getDataNascimentoColaborador());
            System.out.println("9 - Telefone: " + colaborador.getTelefone().getNumeroTelefone());
            System.out.println("10 - CNH: " + colaborador.getCnhColaborador());
            System.out.println("11 - Email: " + colaborador.getEmailColaborador());
            System.out.println("12 - Senha: " + colaborador.getSenhaColaborador());
            System.out.println("13 - Data de Cadastro: " + colaborador.getDtCadastro());
            System.out.println("14 - Usuário: " + colaborador.getNomeUsuario());
            System.out.println("0 - Voltar.");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Informe a alteração:");
                    String imagem = scan.nextLine();

                    colaborador.setCaminhoImagem(imagem);
                    break;
                case 2:
                    System.out.println("Informe a alteração:");
                    Genero genero = new Genero();
                    genero.setNomeGenero(scan.nextLine());

                    colaborador.setGenero(genero);
                    break;
                case 3:
                    System.out.println("Informe a alteração:");
                    Modal modal = new Modal();
                    modal.setModeloModal(scan.nextLine());

                    colaborador.setModal(modal);
                    break;
                case 4:
                    System.out.println("Informe a alteração:");
                    EnderecoColaborador enderecoColaborador = new EnderecoColaborador();
                    enderecoColaborador.setDescLogradouroColaborador(scan.nextLine());

                    colaborador.setEnderecoColaborador(enderecoColaborador);
                    break;
                case 5:
                    System.out.println("Informe a alteração:");
                    String nome = scan.nextLine();

                    colaborador.setNomeColaborador(nome);
                    break;
                case 6:
                    System.out.println("Informe a alteração:");
                    String cpf = scan.nextLine();

                    colaborador.setCpfColaborador(cpf);
                    break;
                case 7:
                    System.out.println("Informe a alteração:");
                    String rg = scan.nextLine();

                    colaborador.setRgColaborador(rg);
                    break;
                case 8:
                    System.out.println("Informe a alteração:");
                    Date dataNasc = formato.parse(scan.nextLine());

                    colaborador.setDataNascimentoColaborador(dataNasc);
                    break;
                case 9:
                    System.out.println("Informe a alteração:");
                    Telefone telefone = new Telefone();
                    telefone.setNumeroTelefone(scan.nextLine());

                    colaborador.setTelefone(telefone);
                    break;
                case 10:
                    System.out.println("Informe a alteração:");
                    String cnh = scan.nextLine();

                    colaborador.setCnhColaborador(cnh);
                    break;
                case 11:
                    System.out.println("Informe a alteração:");
                    String email = scan.nextLine();

                    colaborador.setEmailColaborador(email);
                    break;
                case 12:
                    System.out.println("Informe a alteração:");
                    String senha = scan.nextLine();

                    colaborador.setSenhaColaborador(senha);
                    break;
                case 13:
                    System.out.println("Informe a alteração (dd/mm/yyyy):");
                    Date dataCadastro = formato.parse(scan.nextLine());

                    colaborador.setDtCadastro(dataCadastro);
                    break;
                case 14:
                    System.out.println("Informe a alteração:");
                    String nomeUsuario = scan.nextLine();

                    colaborador.setNomeUsuario(nomeUsuario);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            colaboradorService.Update(id, colaborador);
        }
    }

    public void Deletar() {
        System.out.println("Informe o ID do colaborador que você deseja deletar:");
        int id = scan.nextInt();

        colaboradorService.Delete(id);
    }
}
