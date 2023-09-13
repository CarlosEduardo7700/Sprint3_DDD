package org.example.models;

import java.util.Date;
import java.util.List;

public class Bairro {

    // Atributos
    private int idBairro;
    private Cidade cidade; //composição
    private String nomeBairro;
    private String nomeZona;
    private Date dtCadastro;
    private String nomeUsuario;




    // Construtor
    public Bairro(int idBairro, Cidade cidade, String nomeBairro, String nomeZona, Date dtCadastro, String nomeUsuario) {
        this.idBairro = idBairro;
        this.cidade = cidade;
        this.nomeBairro = nomeBairro;
        this.nomeZona = nomeZona;
        this.dtCadastro = dtCadastro;
        this.nomeUsuario = nomeUsuario;
    }
    public Bairro() {}







    // GetterSetter
    public int getIdBairro() {
        return idBairro;
    }
    public void setIdBairro(int idBairro) {
        this.idBairro = idBairro;
    }

    public Cidade getCidade() {
        return cidade;
    }
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getNomeBairro() {
        return nomeBairro;
    }
    public void setNomeBairro(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }

    public String getNomeZona() {
        return nomeZona;
    }
    public void setNomeZona(String nomeZona) {
        this.nomeZona = nomeZona;
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
