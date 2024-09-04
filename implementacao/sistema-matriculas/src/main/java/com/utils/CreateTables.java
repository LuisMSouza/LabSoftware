package com.utils;

import java.sql.Connection;
import java.sql.Statement;

public class CreateTables {
    public static void createUserTable() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS users (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "login VARCHAR(255), " +
                    "password VARCHAR(255), " +
                    "name VARCHAR(255), " +
                    "role VARCHAR(50))");
            System.out.println("Tabela de usuários criada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public static void createAlunoTable() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS aluno (" +
                              "id INT PRIMARY KEY, " +
                              "matricula VARCHAR(255))");
            System.out.println("Tabela de alunos criada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void createProfessorTable() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS professor (" +
                              "id INT PRIMARY KEY, " +
                              "codigo VARCHAR(255), " +
                              "user_id INT, " +
                              "FOREIGN KEY (user_id) REFERENCES users(id))");
            System.out.println("Tabela de professores criada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createDisciplinaTable() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS disciplina (" +
                              "id INT PRIMARY KEY AUTO_INCREMENT, " +
                              "nome VARCHAR(255), " +
                              "codigo VARCHAR(255), " +
                              "numeroDeCreditos INT, " +
                              "status BOOLEAN, " +
                              "professor_id INT, " +
                              "FOREIGN KEY (professor_id) REFERENCES professor(id))");
            System.out.println("Tabela de disciplinas criada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createCursoTable() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS curso (" +
                              "id INT PRIMARY KEY AUTO_INCREMENT, " +
                              "nome VARCHAR(255), " +
                              "numeroDeCreditos INT)");
            System.out.println("Tabela de cursos criada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createCursoDisciplinaTable() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS curso_disciplina (" +
                              "curso_id INT, " +
                              "disciplina_id INT, " +
                              "PRIMARY KEY (curso_id, disciplina_id), " +
                              "FOREIGN KEY (curso_id) REFERENCES curso(id), " +
                              "FOREIGN KEY (disciplina_id) REFERENCES disciplina(id))");
            System.out.println("Tabela de relacionamento entre cursos e disciplinas criada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createTurmaTable() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS turma (" +
                              "id INT PRIMARY KEY AUTO_INCREMENT, " +
                              "semestre VARCHAR(50), " +
                              "numeroDeAlunos INT, " +
                              "professor_id INT, " +
                              "disciplina_id INT, " +
                              "FOREIGN KEY (professor_id) REFERENCES professor(id), " +
                              "FOREIGN KEY (disciplina_id) REFERENCES disciplina(id))");
            System.out.println("Tabela de turmas criada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createTurmaAlunoTable() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS turma_aluno (" +
                              "turma_id INT, " +
                              "aluno_id INT, " +
                              "PRIMARY KEY (turma_id, aluno_id), " +
                              "FOREIGN KEY (turma_id) REFERENCES turma(id), " +
                              "FOREIGN KEY (aluno_id) REFERENCES aluno(id))");
            System.out.println("Tabela de relacionamento entre turmas e alunos criada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}