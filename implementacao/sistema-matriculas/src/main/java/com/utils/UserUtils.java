package com.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserUtils {
    public static void registerUser(String login, String password) {
            try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO users (login, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            System.out.println("Usuário registrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
