package com.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.modules.Aluno;
import com.modules.Professor;
import com.modules.Usuario;

public class Auth {
    public static Usuario login(String login, String password) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT u.id, u.login, u.name, u.role, a.matricula, p.codigo FROM users u " +
                         "LEFT JOIN aluno a ON u.id = a.id " +
                         "LEFT JOIN professor p ON u.id = p.id " +
                         "WHERE u.login = ? AND u.password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
    
            if (resultSet.next()) {
                String role = resultSet.getString("role");
                String nome = resultSet.getString("name");
    
                if ("aluno".equals(role)) {
                    String matricula = resultSet.getString("matricula");
                    return new Aluno(login, nome, matricula);
                } else if ("professor".equals(role)) {
                    String codigo = resultSet.getString("codigo");
                    return new Professor(login, nome, codigo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }    

    public static boolean registerStudent(String login, String password, String name, String registration) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String userSql = "INSERT INTO users (login, password, name, role) VALUES (?, ?, ?, ?)";
            PreparedStatement userStmt = connection.prepareStatement(userSql, PreparedStatement.RETURN_GENERATED_KEYS);
            userStmt.setString(1, login);
            userStmt.setString(2, password);
            userStmt.setString(3, name);
            userStmt.setString(4, "aluno");
            userStmt.executeUpdate();
    
            ResultSet generatedKeys = userStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int userId = generatedKeys.getInt(1);
    
                String alunoSql = "INSERT INTO aluno (id, matricula) VALUES (?, ?)";
                PreparedStatement alunoStmt = connection.prepareStatement(alunoSql);
                alunoStmt.setInt(1, userId);  // Usar o userId como o id do aluno
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
            String userSql = "INSERT INTO users (login, password, name, role) VALUES (?, ?, ?, ?)";
            PreparedStatement userStmt = connection.prepareStatement(userSql, PreparedStatement.RETURN_GENERATED_KEYS);
            userStmt.setString(1, login);
            userStmt.setString(2, password);
            userStmt.setString(3, name);
            userStmt.setString(4, "professor");
            userStmt.executeUpdate();
    
            ResultSet generatedKeys = userStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int userId = generatedKeys.getInt(1);
    
                String professorSql = "INSERT INTO professor (id, codigo, user_id) VALUES (?, ?, ?)";
                PreparedStatement professorStmt = connection.prepareStatement(professorSql);
                professorStmt.setInt(1, userId);  // Usar o userId como o id do professor
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
