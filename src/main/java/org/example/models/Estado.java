package org.example.models;

import java.util.Date;
import java.util.List;

public class Estado{

    // Atributos
    private int idEstado;
    private String sigla;
    private String nomeEstado;
    private Date dtCadastro;
    private String nomeUsuario;





    // Construtor
    public Estado(int idEstado, String sigla, String nomeEstado, Date dtCadastro, String nomeUsuario) {
        this.idEstado = idEstado;
        this.sigla = sigla;
        this.nomeEstado = nomeEstado;
        this.dtCadastro = dtCadastro;
        this.nomeUsuario = nomeUsuario;
    }
    public Estado() {}






    // GetterSetter
    public int getIdEstado() {
        return idEstado;
    }
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getSigla() {
        return sigla;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }
    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
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
