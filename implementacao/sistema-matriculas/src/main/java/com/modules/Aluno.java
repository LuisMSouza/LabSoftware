package com.modules;

public class Aluno extends Usuario {
    private String matricula;

    public Aluno(String login, String nome, String matricula) {
        super(login, null, nome, "aluno");
        this.matricula = matricula;
    }

    public String getNome() {
        return this.nome;
    }

    public String getMatricula() {
        return matricula;
    }

}
