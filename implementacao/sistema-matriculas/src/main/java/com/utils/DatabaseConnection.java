package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String JDBC_URL = "jdbc:h2:~/labsoft";
    private static final String USER = "admin";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
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
