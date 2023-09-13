package org.example.controllers;

import org.example.models.*;
import org.example.services.VeiculoService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VeiculoController {
    private VeiculoService veiculoService;
    private Scanner scan;

    public VeiculoController(){
        this.veiculoService = new VeiculoService();
        this.scan = new Scanner(System.in);
    }

    public void CadastrarVeiculo() throws ParseException {
        System.out.println("\nAdicionar um novo veículo:\n");

        int id = veiculoService.GetAll().size() + 1;

        System.out.println("Insira o caminho da imagem do veículo:");
        String caminhoImagem = scan.nextLine();

        System.out.println("Informe o tipo de eixo:");
        Tipo_Eixo tipoEixo = new Tipo_Eixo();
        tipoEixo.setNomeTipoEixo(scan.nextLine());

        System.out.println("Informe o tipo do chassi:");
        Tipo_Chassi tipoChassi = new Tipo_Chassi();
        tipoChassi.setNomeTipoChassi(scan.nextLine());

        System.out.println("Informe sua categoria tarifária:");
        Cat_Tarifa catTarifa = new Cat_Tarifa();
        catTarifa.setNomeCategoria(scan.nextLine());

        System.out.println("Informe as medidas em metros do veículo (Insira 1º a Altura e precione enter, em seguida informe o Comprimento e por fim a Largura):");
        Medida medida = new Medida();
        medida.setAltura(scan.nextDouble());
        medida.setComprimento(scan.nextDouble());
        medida.setLargura(scan.nextDouble());

        System.out.println("Informe o número do chassi do veículo:");
        int numChassi = scan.nextInt();

        System.out.println("Insira a apólice do veículo:");
        int apolice = scan.nextInt();

        System.out.println("Informe o modelo do veículo:");
        scan.nextLine();
        String modelo = scan.nextLine();

        System.out.println("Informe a cor do veículo:");
        String cor = scan.nextLine();

        System.out.println("Informe a marca do veículo:");
        String marca = scan.nextLine();

        System.out.println("Informe a placa do veículo:");
        String placa = scan.nextLine();

        System.out.println("Informe o ano de fabricação:");
        int anoFabricacao = scan.nextInt();

        System.out.println("Informe a quantidade de eixos:");
        int quantidadeEixos = scan.nextInt();

        System.out.println("Informe a renavan:");
        scan.nextLine();
        String renavan = scan.nextLine();

        System.out.println("Informe a data em que esse cadastro está sendo feito (Nesse formato: dd/mm/yyyy):");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataCadastro = formato.parse(scan.nextLine());

        System.out.println("Informe o nome do usuário que realizou o cadastro:");
        String nomeUsuario = scan.nextLine();

        Veiculo veiculo = new Veiculo(id, caminhoImagem, tipoEixo, tipoChassi, catTarifa, medida, apolice, modelo, cor, marca, placa, anoFabricacao, quantidadeEixos, renavan, numChassi, dataCadastro, nomeUsuario);

        veiculoService.Add(veiculo);
    }

    public void BuscarVeiculo() {
        System.out.println("Digite a placa do veículo: ");
        String placa = scan.nextLine();

        Veiculo veiculo = veiculoService.GetPlaca(placa);

        System.out.println("Veículo Encontrado:");
        System.out.println("\nID: " + veiculo.getIdVeiculo() + "\nCAMINHO DA IMAGEM: " + veiculo.getCaminhoImagem() + "\nTIPO DE EIXO: " + veiculo.getTipoEixo().getNomeTipoEixo() + "\nTIPO DO CHASSI: " + veiculo.getTipoChassi().getNomeTipoChassi() + "\nCATG. TARIFÁRIA: " + veiculo.getCatTarifaria().getNomeCategoria() + "\nMEDIDAS (ALTURA, COMPRIMENTO, LARGURA): " + veiculo.getMedidaVeiculo().getAltura() + ", " + veiculo.getMedidaVeiculo().getComprimento() + ", " + veiculo.getMedidaVeiculo().getLargura() + "\nNÚMERO DO CHASSI: " + veiculo.getNumChassi() + "\nAPÓLICE: " + veiculo.getApolice() + "\nMODELO: " + veiculo.getModelo() + "\nCOR: " + veiculo.getCor() + "\nMARCA: " + veiculo.getMarca() + "\nPLACA: " + veiculo.getPlaca() + "\nANO DE FABRICAÇÃO: " + veiculo.getAnoFabricacao() + "\nQUANT. DE EIXOS: " + veiculo.getQuantidadeEixos() + "\nRENAVAN: " + veiculo.getRenavan() + "\nDATA DE CADASTRO: " + veiculo.getDtCadastro() + "\nNOME DO USUÁRIO: " + veiculo.getNomeUsuario() + "\n");
    }

    public void BuscarTodosVeiculos() {
        System.out.println("\nAqui está uma lista com todos os veículos:\n");
        List<Veiculo> listaDeVeiculos = veiculoService.GetAll();
        for (Veiculo item : listaDeVeiculos) {
            System.out.println("ID: " + item.getIdVeiculo() + " | APÓLICE: " + item.getApolice() + " | MODELO: " + item.getModelo() + " | MARCA: " + item.getMarca() + " | PLACA: " + item.getPlaca() + " | QUANT. DE EIXOS: " + item.getQuantidadeEixos() + " | DATA DE CADASTRO: " + item.getDtCadastro() + " | NOME DO USUÁRIO: " + item.getNomeUsuario());
        }
    }

    public void AtualizarVeiculo() throws ParseException {
        System.out.println("Informe o ID do veículo que você deseja atualizar:");
        int id = scan.nextInt();

        Veiculo veiculo = veiculoService.Get(id);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Qual informação você deseja alterar:");
            System.out.println("1 - Caminho da Imagem: " + veiculo.getCaminhoImagem());
            System.out.println("2 - Tipo de Eixo: " + veiculo.getTipoEixo().getNomeTipoEixo());
            System.out.println("3 - Tipo de Chassi: " + veiculo.getTipoChassi().getNomeTipoChassi());
            System.out.println("4 - Categoria Tarifária: " + veiculo.getCatTarifaria().getNomeCategoria());
            System.out.println("5 - Medidas do Veículo (Altura, Comprimento e Largura): " + veiculo.getMedidaVeiculo().getAltura() + ", " + veiculo.getMedidaVeiculo().getComprimento() + " e " + veiculo.getMedidaVeiculo().getLargura() + ", ");
            System.out.println("6 - Número do chassi: " + veiculo.getNumChassi());
            System.out.println("7 - Apólice: " + veiculo.getApolice());
            System.out.println("8 - Modelo do Veículo: " + veiculo.getModelo());
            System.out.println("9 - Cor do Veículo: " + veiculo.getCor());
            System.out.println("10 - Marca do Veículo: " + veiculo.getMarca());
            System.out.println("11 - Placa: " + veiculo.getPlaca());
            System.out.println("12 - Ano de Fabricação: " + veiculo.getAnoFabricacao());
            System.out.println("13 - Quantidade de Eixos: " + veiculo.getQuantidadeEixos());
            System.out.println("14 - Renavan: " + veiculo.getRenavan());
            System.out.println("15 - Data de Cadastro: " + veiculo.getDtCadastro());
            System.out.println("16 - Nome do Usuário: " + veiculo.getNomeUsuario());
            System.out.println("0 - Voltar.");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Informe a alteração:");
                    String caminhoImagem = scan.nextLine();

                    veiculo.setCaminhoImagem(caminhoImagem);
                    break;
                case 2:
                    System.out.println("Informe a alteração:");
                    Tipo_Eixo tipoEixo = new Tipo_Eixo();
                    tipoEixo.setNomeTipoEixo(scan.nextLine());

                    veiculo.setTipoEixo(tipoEixo);
                    break;
                case 3:
                    System.out.println("Informe a alteração:");
                    Tipo_Chassi tipoChassi = new Tipo_Chassi();
                    tipoChassi.setNomeTipoChassi(scan.nextLine());

                    veiculo.setTipoChassi(tipoChassi);
                    break;
                case 4:
                    System.out.println("Informe a alteração:");
                    Cat_Tarifa catTarifa = new Cat_Tarifa();
                    catTarifa.setNomeCategoria(scan.nextLine());

                    veiculo.setCatTarifaria(catTarifa);
                    break;
                case 5:
                    System.out.println("Informe a alteração (Altura, Comprimento e Largura):");
                    Medida medida = new Medida();
                    medida.setAltura(scan.nextDouble());
                    medida.setComprimento(scan.nextDouble());
                    medida.setLargura(scan.nextDouble());

                    veiculo.setMedidaVeiculo(medida);
                    break;
                case 6:
                    System.out.println("Informe a alteração:");
                    int numChassi = scan.nextInt();

                    veiculo.setNumChassi(numChassi);
                    break;
                case 7:
                    System.out.println("Informe a alteração:");
                    int apolice = scan.nextInt();

                    veiculo.setApolice(apolice);
                    break;
                case 8:
                    System.out.println("Informe a alteração:");
                    String modelo = scan.nextLine();

                    veiculo.setModelo(modelo);
                    break;
                case 9:
                    System.out.println("Informe a alteração:");
                    String cor = scan.nextLine();

                    veiculo.setCor(cor);
                    break;
                case 10:
                    System.out.println("Informe a alteração:");
                    String marca = scan.nextLine();

                    veiculo.setMarca(marca);
                    break;
                case 11:
                    System.out.println("Informe a alteração:");
                    String placa = scan.nextLine();

                    veiculo.setPlaca(placa);
                    break;
                case 12:
                    System.out.println("Informe a alteração:");
                    int anoFabricacao = scan.nextInt();

                    veiculo.setAnoFabricacao(anoFabricacao);
                    break;
                case 13:
                    System.out.println("Informe a alteração:");
                    int quantidadeEixos = scan.nextInt();

                    veiculo.setQuantidadeEixos(quantidadeEixos);
                    break;
                case 14:
                    System.out.println("Informe a alteração:");
                    String renavan = scan.nextLine();

                    veiculo.setRenavan(renavan);
                    break;
                case 15:
                    System.out.println("Informe a alteração(dd/mm/yyyy):");
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataCadastro = formato.parse(scan.nextLine());

                    veiculo.setDtCadastro(dataCadastro);
                    break;
                case 16:
                    System.out.println("Informe a alteração:");
                    String nomeUsuario = scan.nextLine();

                    veiculo.setNomeUsuario(nomeUsuario);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            veiculoService.Update(id, veiculo);
        }
    }

    public void DeletarVeiculo() {
        System.out.println("Informe o ID do veículo que você deseja deletar:");
        int id = scan.nextInt();

        veiculoService.Delete(id);
    }
}
