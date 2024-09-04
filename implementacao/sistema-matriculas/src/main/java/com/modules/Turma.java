package com.modules;

import java.util.ArrayList;
import java.util.List;
import com.modules.Aluno;
import com.modules.Professor;
import com.modules.Disciplina;

public class Turma {
    private String semestre;
    private Professor professor;
    private List<Aluno> alunos;
    private Disciplina disciplina;
    private boolean status;


    public Turma(String semestre, Professor professor, Disciplina disciplina) {
        this.semestre = semestre;
        this.professor = professor;
        this.disciplina = disciplina;
        this.alunos = new ArrayList<>();
        this.status = true;
    }

    public boolean adicionarAluno(Aluno aluno) {
        if (aluno == null) {
            return false;
        }

        if (this.alunos.contains(aluno)) {
            return false;
        }

        if (this.alunos.size() < 60) {
            this.alunos.add(aluno);
            return true;
        } else {
            System.out.println("Turma cheia. Limte 60 alunos.");
            return false;
        }
    }

    public boolean removerAluno(Aluno aluno) {
        if (aluno == null) {
            return false;
        }

        if (this.alunos.remove(aluno)) {
            return true;
        } else {
            System.out.println("Aluno não encontrado na turma.");
            return false;
        }
    }


    public int verificarNumeroAlunos() {

        return this.alunos.size();
    }

    public void encerrarMatriculas() {
        this.status= false;
    }

    public void associarProfessor(Professor professor) {
        this.professor = professor;
    }
}
