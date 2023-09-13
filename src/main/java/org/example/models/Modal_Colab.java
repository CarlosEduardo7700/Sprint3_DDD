package org.example.models;

public class Modal_Colab {
    private Modal modal;
    private Colaborador colaborador;

    public Modal_Colab(Modal modal, Colaborador colaborador) {
        this.modal = modal;
        this.colaborador = colaborador;
    }

    public Modal getModal() {
        return modal;
    }

    public void setModal(Modal modal) {
        this.modal = modal;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }
}
