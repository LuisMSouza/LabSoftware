package com.modules;

import com.modules.Aluno;
import com.modules.Usuario;
import java.util.List;
import java.util.ArrayList;
import com.utils.UserUtils;

public class Professor extends Usuario {
    private String codigo;

    public Professor(String login, String nome, String codigo) {
        super(login, null, nome, "professor");
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public List<Aluno> acessarListaAlunos() {
        return UserUtils.getStudents();
    }
}
