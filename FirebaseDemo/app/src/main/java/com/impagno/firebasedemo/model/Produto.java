package com.impagno.firebasedemo.model;

public class Produto {
    private String nome;
    private String valor;

    public Produto() {
    }

    public Produto(String nome, String valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
