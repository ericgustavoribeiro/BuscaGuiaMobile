package br.edu.fafica.buscaguiaapp;

/**
 * Created by Eric Gustavo on 04/12/2016.
 */

public class PontoTuristico {

    private String nome;
    private String descricao;
    private int img;

    public PontoTuristico(String nome, String descricao, int img){
        this.nome = nome;
        this.descricao = descricao;
        this.img = img;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
