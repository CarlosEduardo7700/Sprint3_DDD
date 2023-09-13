package org.example.models;

import java.util.Date;
import java.util.List;

public class Veiculo {

    // Atributos
    private int idVeiculo;
    private String caminhoImagem;
    private Tipo_Eixo tipoEixo; //composição
    private Tipo_Chassi tipoChassi; //composição
    private Cat_Tarifa catTarifaria; //composição
    private Medida medidaVeiculo; //composição
    private int apolice;
    private String modelo;
    private String cor;
    private String marca;
    private String placa;
    private int anoFabricacao;
    private int quantidadeEixos;
    private String renavan;
    private int numChassi;
    private Date dtCadastro;
    private String nomeUsuario;




    // Construtor
    public Veiculo(int idVeiculo, String caminhoImagem, Tipo_Eixo tipoEixo, Tipo_Chassi tipoChassi, Cat_Tarifa catTarifaria, Medida medidaVeiculo, int apolice, String modelo, String cor, String marca, String placa, int anoFabricacao, int quantidadeEixos, String renavan, int numChassi, Date dtCadastro, String nomeUsuario) {
        this.idVeiculo = idVeiculo;
        this.caminhoImagem = caminhoImagem;
        this.tipoEixo = tipoEixo;
        this.tipoChassi = tipoChassi;
        this.catTarifaria = catTarifaria;
        this.medidaVeiculo = medidaVeiculo;
        this.apolice = apolice;
        this.modelo = modelo;
        this.cor = cor;
        this.marca = marca;
        this.placa = placa;
        this.anoFabricacao = anoFabricacao;
        this.quantidadeEixos = quantidadeEixos;
        this.renavan = renavan;
        this.numChassi = numChassi;
        this.dtCadastro = dtCadastro;
        this.nomeUsuario = nomeUsuario;
    }

    public Veiculo() {}










    // GetterSetter
    public int getIdVeiculo() {
        return idVeiculo;
    }
    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Tipo_Eixo getTipoEixo() {
        return tipoEixo;
    }
    public void setTipoEixo(Tipo_Eixo tipoEixo) {
        this.tipoEixo = tipoEixo;
    }

    public Tipo_Chassi getTipoChassi() {
        return tipoChassi;
    }
    public void setTipoChassi(Tipo_Chassi tipoChassi) {
        this.tipoChassi = tipoChassi;
    }

    public Cat_Tarifa getCatTarifaria() {
        return catTarifaria;
    }
    public void setCatTarifaria(Cat_Tarifa catTarifaria) {
        this.catTarifaria = catTarifaria;
    }

    public Medida getMedidaVeiculo() {
        return medidaVeiculo;
    }
    public void setMedidaVeiculo(Medida medidaVeiculo) {
        this.medidaVeiculo = medidaVeiculo;
    }

    public int getApolice() {
        return apolice;
    }
    public void setApolice(int apolice) {
        this.apolice = apolice;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }
    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public int getQuantidadeEixos() {
        return quantidadeEixos;
    }
    public void setQuantidadeEixos(int quantidadeEixos) {
        this.quantidadeEixos = quantidadeEixos;
    }

    public String getRenavan() {
        return renavan;
    }
    public void setRenavan(String renavan) {
        this.renavan = renavan;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }
    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }
    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public int getNumChassi() {
        return numChassi;
    }
    public void setNumChassi(int numChassi) {
        this.numChassi = numChassi;
    }
}
