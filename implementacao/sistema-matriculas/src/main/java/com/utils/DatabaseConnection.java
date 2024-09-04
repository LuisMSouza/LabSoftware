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
            System.out.println("Tabelas removidas com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initalizeDatabase() {
        try (Connection connection = getConnection()) {
            CreateTables.createUserTable();
            CreateTables.createAlunoTable();
            CreateTables.createProfessorTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
