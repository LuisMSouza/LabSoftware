package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    private static final String JDBC_URL = "jdbc:h2:~/labsoft";
    private static final String USER = "admin";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

    public static void dropTables() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS aluno");
            statement.execute("DROP TABLE IF EXISTS professor");
            statement.execute("DROP TABLE IF EXISTS users");
            statement.execute("DROP TABLE IF EXISTS curso");
            statement.execute("DROP TABLE IF EXISTS disciplina");
            statement.execute("DROP TABLE IF EXISTS curso_disciplina");
            statement.execute("DROP TABLE IF EXISTS turma");
            statement.execute("DROP TABLE IF EXISTS turma_aluno");
            System.out.println("Tabelas removidas com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initalizeDatabase() {
        try (Connection connection = getConnection()) {
            CreateTables.createUserTable();
            CreateTables.createProfessorTable();
            CreateTables.createAlunoTable();
            CreateTables.createCursoTable();
            CreateTables.createDisciplinaTable();
            CreateTables.createCursoDisciplinaTable();
            CreateTables.createTurmaTable();
            CreateTables.createTurmaAlunoTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
