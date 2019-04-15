package com.impagno.reclyclerexample.model;

public class Produto {
    private String nome;
    private double qtde;

    public Produto() {
    }

    public Produto(String nome, double qtde) {
        this.nome = nome;
        this.qtde = qtde;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getQtde() {
        return qtde;
    }

    public void setQtde(double qtde) {
        this.qtde = qtde;
    }
}

