package com.modules;
import com.modules.Turma;

public class Disciplina {
    private String nome;
    private String codigo;
    private int numeroDeCreditos;
    private boolean obrigatoria;

    public Disciplina(String nome, String codigo, int numeroDeCreditos, boolean obrigatoria) {
        this.nome = nome;
        this.codigo = codigo;
        this.numeroDeCreditos = numeroDeCreditos;
        this.obrigatoria = obrigatoria;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCodigo() {
        return this.codigo;
    }
}
