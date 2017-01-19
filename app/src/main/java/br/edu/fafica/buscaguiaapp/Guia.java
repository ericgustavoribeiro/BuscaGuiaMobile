package br.edu.fafica.buscaguiaapp;

/**
 * Created by Eric Gustavo on 03/12/2016.
 */

public class Guia {
    //guia
    private int id_guia;
    private String nome;
    private String cpf;
    private String descricao;
    private String imagem;

    // contato
    private String email;
    private String telefone;
    private String celular;

    // endereco
    private String logradouro;
    private String numero;
    private String bairro;

    // adm
    private int id_adm;

    public Guia(int id_guia, String nome, String cpf, String descricao,
                String imagem, String email, String telefone, String celular,
                String logradouro, String numero, String bairro, int id_adm) {
        super();
        this.id_guia = id_guia;
        this.nome = nome;
        this.cpf = cpf;
        this.descricao = descricao;
        this.imagem = imagem;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.id_adm = id_adm;
    }

    public Guia() {

    }

    public int getId_guia() {
        return id_guia;
    }

    public void setId_guia(int id_guia) {
        this.id_guia = id_guia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getId_adm() {
        return id_adm;
    }

    public void setId_adm(int id_adm) {
        this.id_adm = id_adm;
    }
}
