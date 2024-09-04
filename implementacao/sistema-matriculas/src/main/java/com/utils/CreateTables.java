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
}