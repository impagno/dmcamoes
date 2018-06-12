package br.spei.cepagora;

/**
 * Created by ipagn on 03/05/2017.
 */

public class Endereco {
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

    public Endereco() {

    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.localidade = cidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }
}
