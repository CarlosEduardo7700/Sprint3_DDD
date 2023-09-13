package org.example.components;

import org.example.controllers.*;

import java.text.ParseException;
import java.util.Scanner;

public class MenuComponents {
    private VeiculoController veiculoController;
    private BairroController bairroController;
    private CidadeController cidadeController;
    private EstadoController estadoController;
    private LogradouroController logradouroController;
    private GeneroController generoController;
    private ClienteController clienteController;
    private EnderecoClienteController enderecoClienteController;
    private TelefoneController telefoneController;
    private TipoChassiController tipoChassiController;
    private TipoEixoController tipoEixoController;
    private CatTarifaController catTarifaController;
    private MedidaController medidaController;
    private ModalController modalController;
    private TipoModalController tipoModalController;
    private ColaboradorController colaboradorController;
    private EnderecoColabController enderecoColabController;
    private ChamadaController chamadaController;
    private VeicClienteController veicClienteController;
    private ModalColabController modalColabController;
    private Scanner scanner;

    public MenuComponents() {
        this.veiculoController = new VeiculoController();
        this.bairroController = new BairroController();
        this.cidadeController = new CidadeController();
        this.estadoController = new EstadoController();
        this.logradouroController = new LogradouroController();
        this.generoController = new GeneroController();
        this.clienteController = new ClienteController();
        this.enderecoClienteController = new EnderecoClienteController();
        this.telefoneController = new TelefoneController();
        this.tipoChassiController = new TipoChassiController();
        this.tipoEixoController = new TipoEixoController();
        this.catTarifaController = new CatTarifaController();
        this.medidaController = new MedidaController();
        this.modalController = new ModalController();
        this.tipoModalController = new TipoModalController();
        this.colaboradorController = new ColaboradorController();
        this.enderecoColabController = new EnderecoColabController();
        this.chamadaController = new ChamadaController();
        this.veicClienteController = new VeicClienteController();
        this.modalColabController = new ModalColabController();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenuDeAlteracao() {
        System.out.println("Menu de Alteração:");
        System.out.println("1 - Cadastrar.");
        System.out.println("2 - Buscar.");
        System.out.println("3 - Buscar por todos.");
        System.out.println("4 - Atualizar.");
        System.out.println("5 - Deletar.");
        System.out.println("0 - Sair.");
        System.out.println("Escolha uma opção:");
    }

    public void exibirMenu() throws ParseException {
        boolean cont = true;

        while (cont) {
            System.out.println("Com qual tabela você deseja mexer:");
            System.out.println("1 - Chamada");
            System.out.println("2 - Veículo");
            System.out.println("3 - Tipo Chassi");
            System.out.println("4 - Tipo Eixo");
            System.out.println("5 - Categoria Tarifária");
            System.out.println("6 - Modal");
            System.out.println("7 - Tipo Modal");
            System.out.println("8 - Medida");
            System.out.println("9 - Cliente");
            System.out.println("10 - Veículo do Cliente");
            System.out.println("11 - Colaborador");
            System.out.println("12 - Modal do Colaborador");
            System.out.println("13 - Gênero");
            System.out.println("14 - Telefone");
            System.out.println("15 - Endereço do cliente");
            System.out.println("16 - Endereço do colaborador");
            System.out.println("17 - Logradouro");
            System.out.println("18 - Bairro");
            System.out.println("19 - Cidade");
            System.out.println("20 - Estado");
            System.out.println("0 - Sair");
            System.out.println("Informe sua escolha:");

            int op = scanner.nextInt();

            boolean continuar = true;

            switch (op) {
                case 1:
                    while (continuar) {
                        exibirMenuDeAlteracao();

                        int opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {
                            case 1:
                                chamadaController.Cadastrar();
                                break;
                            case 2:
                                chamadaController.Buscar();
                                break;
                            case 3:
                                chamadaController.BuscarTodos();
                                break;
                            case 4:
                                chamadaController.Atualizar();
                                break;
                            case 5:
                                chamadaController.Deletar();
                                break;
                            case 0:
                                continuar = false;
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                    }
                case 2:
                    while (continuar) {
                        exibirMenuDeAlteracao();

                        int opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {
                            case 1:
                                veiculoController.CadastrarVeiculo();
                                break;
                            case 2:
                                veiculoController.BuscarVeiculo();
                                break;
                            case 3:
                                veiculoController.BuscarTodosVeiculos();
                                break;
                            case 4:
                                veiculoController.AtualizarVeiculo();
                                break;
                            case 5:
                                veiculoController.DeletarVeiculo();
                                break;
                            case 0:
                                continuar = false;
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }

                    }
                case 3:
                    while (continuar) {
                        exibirMenuDeAlteracao();

                        int opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {
                            case 1:
                                tipoChassiController.Cadastrar();
                                break;
                            case 2:
                                tipoChassiController.Buscar();
                                break;
                            case 3:
                                tipoChassiController.BuscarTodos();
                                break;
                            case 4:
                                tipoChassiController.Atualizar();
                                break;
                            case 5:
                                tipoChassiController.Deletar();
                                break;
                            case 0:
                                continuar = false;
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                    }
                case 4:
                    while (continuar) {
                        exibirMenuDeAlteracao();

                        int opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {
                            case 1:
                                tipoEixoController.Cadastrar();
                                break;
                            case 2:
                                tipoEixoController.Buscar();
                                break;
                            case 3:
                                tipoEixoController.BuscarTodos();
                                break;
                            case 4:
                                tipoEixoController.Atualizar();
                                break;
                            case 5:
                                tipoEixoController.Deletar();
                                break;
                            case 0:
                                continuar = false;
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                    }
                case 5:
                    while (continuar) {
                        exibirMenuDeAlteracao();

                        int opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {
                            case 1:
                                catTarifaController.Cadastrar();
                                break;
                            case 2:
                                catTarifaController.Buscar();
                                break;
                            case 3:
                                catTarifaController.BuscarTodos();
                                break;
                            case 4:
                                catTarifaController.Atualizar();
                                break;
                            case 5:
                                catTarifaController.Deletar();
                                break;
                            case 0:
                                continuar = false;
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                    }
                case 6:
                    while (continuar) {
                        exibirMenuDeAlteracao();

                        int opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {
                            case 1:
                                modalController.Cadastrar();
                                break;
                            case 2:
                                modalController.Buscar();
                                break;
                            case 3:
                                modalController.BuscarTodos();
                                break;
                            case 4:
                                modalController.Atualizar();
                                break;
                            case 5:
                                modalController.Deletar();
                                break;
                            case 0:
                                continuar = false;
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                    }
                case 7:
                    while (continuar) {
                        exibirMenuDeAlteracao();

                        int opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {
                            case 1:
                                tipoModalController.Cadastrar();
                                break;
                            case 2:
                                tipoModalController.Buscar();
                                break;
                            case 3:
                                tipoModalController.BuscarTodos();
                                break;
                            case 4:
                                tipoModalController.Atualizar();
                                break;
                            case 5:
                                tipoModalController.Deletar();
                                break;
                            case 0:
                                continuar = false;
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                    }
                case 8:
                    while (continuar) {
                        exibirMenuDeAlteracao();

                        int opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {
                            case 1:
                                medidaController.Cadastrar();
                                break;
                            case 2:
                                medidaController.Buscar();
                                break;
                            case 3:
                                medidaController.BuscarTodos();
                                break;
                            case 4:
                                medidaController.Atualizar();
                                break;
                            case 5:
                                medidaController.Deletar();
                                break;
                            case 0:
                                continuar = false;
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                    }
                case 9:
                    while (continuar) {
                        exibirMenuDeAlteracao();

                        int opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {
                            case 1:
                                clienteController.Cadastrar();
                                break;
                            case 2:
                                clienteController.Buscar();
                                break;
                            case 3:
                                clienteController.BuscarTodos();
                                break;
                            case 4:
                                clienteController.Atualizar();
                                break;
                            case 5:
                                clienteController.Deletar();
                                break;
                            case 0:
                                continuar = false;
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                    }
                case 10:
                    while (continuar) {
                        exibirMenuDeAlteracao();

                        int opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {
                            case 1:
                                veicClienteController.Cadastrar();
                                break;
                            case 2:
                                veicClienteController.Buscar();
                                break;
                            case 3:
                                veicClienteController.BuscarTodos();
                                break;
                            case 4:
                                veicClienteController.Atualizar();
                                break;
                            case 5:
                                veicClienteController.Deletar();
                                break;
                            case 0:
                                continuar = false;
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                    }
                case 11:
                    while (continuar) {
                        exibirMenuDeAlteracao();

                        int opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {
                            case 1:
                                colaboradorController.Cadastrar();
                                break;
                            case 2:
                                colaboradorController.Buscar();
                                break;
                            case 3:
                                colaboradorController.BuscarTodos();
                                break;
                            case 4:
                                colaboradorController.Atualizar();
                                break;
                            case 5:
                                colaboradorController.Deletar();
                                break;
                            case 0:
                                continuar = false;
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                    }
                case 12:
                    while (continuar) {
                        exibirMenuDeAlteracao();

                        int opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {
                            case 1:
                                modalColabController.Cadastrar();
                                break;
                            case 2:
                                modalColabController.Buscar();
                                break;
                            case 3:
                                modalColabController.BuscarTodos();
                                break;
                            case 4:
                                modalColabController.Atualizar();
                                break;
                            case 5:
                                modalColabController.Deletar();
                                break;
                            case 0:
                                continuar = false;
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                    }
                case 13:
                    while (continuar) {
                        exibirMenuDeAlteracao();

                        int opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {
                            case 1:
                                generoController.Cadastrar();
                                break;
                            case 2:
                                generoController.Buscar();
                                break;
                            case 3:
                                generoController.BuscarTodos();
                                break;
                            case 4:
                                generoController.Atualizar();
                                break;
                            case 5:
                                generoController.Deletar();
                                break;
                            case 0:
                                continuar = false;
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                    }
                case 14:
                    while (continuar) {
                        exibirMenuDeAlteracao();

                        int opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {
                            case 1:
                                telefoneController.Cadastrar();
                                break;
                            case 2:
                                telefoneController.Buscar();
                                break;
                            case 3:
                                telefoneController.BuscarTodos();
                                break;
                            case 4:
                                telefoneController.Atualizar();
                                break;
                            case 5:
                                telefoneController.Deletar();
                                break;
                            case 0:
                                continuar = false;
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                    }
                case 15:
                    while (continuar) {
                        exibirMenuDeAlteracao();

                        int opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {
                            case 1:
                                enderecoClienteController.Cadastrar();
                                break;
                            case 2:
                                enderecoClienteController.Buscar();
                                break;
                            case 3:
                                enderecoClienteController.BuscarTodos();
                                break;
                            case 4:
                                enderecoClienteController.Atualizar();
                                break;
                            case 5:
                                enderecoClienteController.Deletar();
                                break;
                            case 0:
                                continuar = false;
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                    }
                case 16:
                    while (continuar) {
                        exibirMenuDeAlteracao();

                        int opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {
                            case 1:
                                enderecoColabController.Cadastrar();
                                break;
                            case 2:
                                enderecoColabController.Buscar();
                                break;
                            case 3:
                                enderecoColabController.BuscarTodos();
                                break;
                            case 4:
                                enderecoColabController.Atualizar();
                                break;
                            case 5:
                                enderecoColabController.Deletar();
                                break;
                            case 0:
                                continuar = false;
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                    }
                case 17:
                    while (continuar) {
                        exibirMenuDeAlteracao();

                        int opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {
                            case 1:
                                logradouroController.Cadastrar();
                                break;
                            case 2:
                                logradouroController.Buscar();
                                break;
                            case 3:
                                logradouroController.BuscarTodos();
                                break;
                            case 4:
                                logradouroController.Atualizar();
                                break;
                            case 5:
                                logradouroController.Deletar();
                                break;
                            case 0:
                                continuar = false;
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                    }
                case 18:
                    while (continuar) {
                        exibirMenuDeAlteracao();

                        int opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {
                            case 1:
                                bairroController.CadastrarBairro();
                                break;
                            case 2:
                                bairroController.BuscarBairro();
                                break;
                            case 3:
                                bairroController.BuscarTodosBairros();
                                break;
                            case 4:
                                bairroController.AtuaizarBairro();
                                break;
                            case 5:
                                bairroController.DeletarBairro();
                                break;
                            case 0:
                                continuar = false;
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                    }
                case 19:
                    while (continuar) {
                        exibirMenuDeAlteracao();

                        int opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {
                            case 1:
                                cidadeController.CadastrarCidade();
                                break;
                            case 2:
                                cidadeController.BuscarCidade();
                                break;
                            case 3:
                                cidadeController.BuscarTodasCidades();
                                break;
                            case 4:
                                cidadeController.AtualizarCidade();
                                break;
                            case 5:
                                cidadeController.DeletarCidade();
                                break;
                            case 0:
                                continuar = false;
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                    }
                case 20:
                    while (continuar) {
                        exibirMenuDeAlteracao();

                        int opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {
                            case 1:
                                estadoController.Cadastrar();
                                break;
                            case 2:
                                estadoController.Buscar();
                                break;
                            case 3:
                                estadoController.BuscarTodos();
                                break;
                            case 4:
                                estadoController.Atualizar();
                                break;
                            case 5:
                                estadoController.Deletar();
                                break;
                            case 0:
                                continuar = false;
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                    }
                case 0:
                    System.out.println("Saindo...");
                    cont = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
