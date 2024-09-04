package com.modules;

import java.util.List;
import com.modules.Disciplina;

public class Curso {
    private String nome;
    private int numeroDeCreditos;
    private List<Disciplina> disciplinas;

    public Curso(String nome, int numeroDeCreditos, List<Disciplina> disciplinas) {
        this.nome = nome;
        this.numeroDeCreditos = numeroDeCreditos;
        this.disciplinas = disciplinas;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    public void removerDisciplina(Disciplina disciplina) {
        this.disciplinas.remove(disciplina);
    }

    public void listarDisciplinas() {
        if (this.disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada no curso.");
            return;
        }

        System.out.println("Disciplinas do curso " + this.nome + ":");
        for (Disciplina disciplina : this.disciplinas) {
            System.out.println("- " + disciplina.getNome() + " (" + disciplina.getCodigo() + ")");
        }
    }
}