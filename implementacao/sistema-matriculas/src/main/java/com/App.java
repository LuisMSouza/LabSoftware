package com;

import java.util.Scanner;

import com.utils.Auth;

public class App {
    public static void main( String[] args ) {
        // Utilize esse script comentado apenas para popular o banco de dados com alguns usuários

        // DatabaseConnection.initalizeDatabase();
        // Auth.registerStudent("student1", "student", "Student 1", "123456");
        // Auth.registerProfessor("professor1", "professor", "Professor 1", "654321");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu login:");
        String email = scanner.nextLine();
        System.out.println("Digite sua senha:");
        String password = scanner.nextLine();

        while (!Auth.login(email, password)) {
            System.out.println("Login ou senha invalidos. Tente novamente.");
            System.out.println("Digite seu login:");
            email = scanner.nextLine();
            System.out.println("Digite sua senha:");
            password = scanner.nextLine();
        }

        System.out.println("Login efetuado com sucesso!");
    }
}
