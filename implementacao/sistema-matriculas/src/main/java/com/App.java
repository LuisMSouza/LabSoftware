package com;

import java.util.Scanner;

import com.utils.Auth;
import com.utils.DatabaseConnection;
import com.modules.Aluno;
import com.modules.Professor;
import com.modules.Usuario;
import com.utils.UserUtils;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static Usuario loggedUser = null;
    public static Scanner scanner = new Scanner(System.in);

    public static void main( String[] args ) {
        // Utilize esse script comentado apenas para popular o banco de dados com alguns usuários

/*         DatabaseConnection.dropTables();
        DatabaseConnection.initalizeDatabase();
        Auth.registerStudent("student1", "student", "Student 1", "123456");
        Auth.registerProfessor("professor1", "professor", "Professor 1", "654321"); */
        Scanner scanner = new Scanner(System.in);

        authenticate();
    }
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 

    public static void showStudentMenu() {
        System.out.println("1 - Matricular-se em uma disciplina");
        System.out.println("2 - Ver disciplinas matriculadas");
        System.out.println("3 - Ver notas");
        System.out.println("4 - Sair");
        System.out.println("\n");
        System.out.print("Digite a opção desejada: ");
        
        int option = scanner.nextInt();
    }

    public static void showProfessorMenu() {
        System.out.println("1 - Acessar lista de alunos");
        System.out.println("2 - Sair");
        System.out.println("\n");
        System.out.print("Digite a opção desejada: ");
        
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                showStudentList();
                break;
            case 2:
                loggedUser = null;
                authenticate();
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    public static void showStudentList() {
        if ((loggedUser instanceof Professor)) {
            Professor professor = (Professor) loggedUser;
            List<Aluno> alunos = professor.acessarListaAlunos();
    
            System.out.println("\nLista de alunos:");
            System.out.println("\n");
            alunos.stream().forEach(aluno -> {
                System.out.println("Nome: " + aluno.getNome() + " - Matrícula: " + aluno.getMatricula() + "\n");
            });
            System.out.print("Pressione qualquer tecla para voltar ao menu: ");
        } else {
            System.out.println("Você não tem permissão para acessar a lista de alunos.");
        }
    }    

    public static void authenticate() {
        clearScreen();
        System.out.print("Digite seu login: ");
        String email = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String password = scanner.nextLine();

        Usuario usuario = Auth.login(email, password);

        while (usuario == null) {
            clearScreen();
            System.out.println("Login ou senha inválidos.");
            System.out.println("________________________________________________________________________________________");
            System.out.println("\n");
            System.out.print("Digite seu login: ");
            email = scanner.nextLine();
            System.out.print("Digite sua senha: ");
            password = scanner.nextLine();
            usuario = Auth.login(email, password);
        }

        if (usuario != null) {
            clearScreen();
            if (usuario instanceof Aluno) {
                Aluno aluno = (Aluno) usuario;
                System.out.println("Bem-vindo, Aluno: " + aluno.getNome() + " - Matrícula: " + aluno.getMatricula());
                System.out.println("________________________________________________________________________________________");
                System.out.println("\n");
                loggedUser = aluno;
                showStudentMenu();
            } else if (usuario instanceof Professor) {
                Professor professor = (Professor) usuario;
                loggedUser = professor;
                System.out.println("Bem-vindo, Professor: " + professor.getNome() + " - Código: " + professor.getCodigo());
                System.out.println("________________________________________________________________________________________");
                System.out.println("\n");
                showProfessorMenu();
            }
        } else {
            System.out.println("Login ou senha inválidos.");
        }

        scanner.close();
    }
}
