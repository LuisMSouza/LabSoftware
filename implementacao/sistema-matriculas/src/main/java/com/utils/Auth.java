package com.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Auth {
    public static boolean login(String login, String password) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM users WHERE login = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean  registerStudent(String login, String password, String name, String registration) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String userSql = "INSERT INTO users (login, password) VALUES (?, ?)";
            PreparedStatement userStmt = connection.prepareStatement(userSql, PreparedStatement.RETURN_GENERATED_KEYS);
            userStmt.setString(1, login);
            userStmt.setString(2, password);
            userStmt.executeUpdate();

            ResultSet generatedKeys = userStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int userId = generatedKeys.getInt(1);

                String alunoSql = "INSERT INTO aluno (nome, matricula) VALUES (?, ?)";
                PreparedStatement alunoStmt = connection.prepareStatement(alunoSql);
                alunoStmt.setString(1, name);
                alunoStmt.setString(2, registration);
                alunoStmt.executeUpdate();

                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public static boolean registerProfessor(String login, String password, String name, String code) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String userSql = "INSERT INTO users (login, password) VALUES (?, ?)";
            PreparedStatement userStmt = connection.prepareStatement(userSql, PreparedStatement.RETURN_GENERATED_KEYS);
            userStmt.setString(1, login);
            userStmt.setString(2, password);
            userStmt.executeUpdate();

            ResultSet generatedKeys = userStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int userId = generatedKeys.getInt(1);

                String professorSql = "INSERT INTO professor (nome, codigo, user_id) VALUES (?, ?, ?)";
                PreparedStatement professorStmt = connection.prepareStatement(professorSql);
                professorStmt.setString(1, name);
                professorStmt.setString(2, code);
                professorStmt.setInt(3, userId);
                professorStmt.executeUpdate();

                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
