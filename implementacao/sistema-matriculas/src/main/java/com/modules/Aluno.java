package com.modules;

import java.util.List;

public class Aluno extends Usuario{
    private String nome;
    private String matricula;

    public boolean matricularEmDisciplina(Disciplina disciplina, boolean obrigatoria) {
        // TODO implementação
        return false;
    }

    public boolean cancelarMatricula(Disciplina disciplina) {
        // TODO implementação
        return false;
    }

    public List<Disciplina> verificarDisciplinasMatriculadas() {
        // TODO implementação
        return null;
    }

    public void notificarSistemaDeCobrancas() {
        // TODO implementação
    }
}
