package com.modules;

public class Usuario {
    private String login;
    private String senha;
    protected String nome;
    protected String cargo;

    public Usuario(String login, String senha, String nome, String cargo) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.cargo = cargo;
    }

    public boolean autenticar(String login, String senha) {
        // TODO implementação
        return false;
    }

    public void alterarSenha(String login, String senha, String novaSenha) {
        // TODO implementação
    }

}
