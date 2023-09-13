package org.example.models;

import java.util.Date;
import java.util.List;

public class Logradouro {

    // Atributos
    private int idLogradouro;
    private Bairro bairro; //composição
    private String nomeLogradouro;
    private String cep;
    private Date dtCadastro;
    private String nomeUsuario;





    // Construtor
    public Logradouro(int idLogradouro, Bairro bairro, String nomeLogradouro, String cep, Date dtCadastro, String nomeUsuario) {
        this.idLogradouro = idLogradouro;
        this.bairro = bairro;
        this.nomeLogradouro = nomeLogradouro;
        this.cep = cep;
        this.dtCadastro = dtCadastro;
        this.nomeUsuario = nomeUsuario;
    }
    public Logradouro() {}







    // GetterSetter
    public int getIdLogradouro() {
        return idLogradouro;
    }
    public void setIdLogradouro(int idLogradouro) {
        this.idLogradouro = idLogradouro;
    }

    public Bairro getBairro() {
        return bairro;
    }
    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }
    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
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
