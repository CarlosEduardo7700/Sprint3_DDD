package org.example.models;

import java.util.Date;
import java.util.List;

public class Cidade{

    // Atributos
    private int idCidade;
    private Estado estado; //composição
    private String nomeCidade;
    private int ibgeCodigo;
    private int ddd;
    private Date dtCadastro;
    private String nomeUsuario;




    // Construtor
    public Cidade(int idCidade, Estado estado, String nomeCidade, int ibgeCodigo, int ddd, Date dtCadastro, String nomeUsuario) {
        this.idCidade = idCidade;
        this.estado = estado;
        this.nomeCidade = nomeCidade;
        this.ibgeCodigo = ibgeCodigo;
        this.ddd = ddd;
        this.dtCadastro = dtCadastro;
        this.nomeUsuario = nomeUsuario;
    }
    public Cidade() {}







    // GetterSetter
    public int getIdCidade() {
        return idCidade;
    }
    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }
    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public int getIbgeCodigo() {
        return ibgeCodigo;
    }
    public void setIbgeCodigo(int ibgeCodigo) {
        this.ibgeCodigo = ibgeCodigo;
    }

    public int getDdd() {
        return ddd;
    }
    public void setDdd(int ddd) {
        this.ddd = ddd;
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
}
