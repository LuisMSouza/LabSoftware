package com.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.utils.DatabaseConnection;
import java.sql.ResultSet;
import java.util.List;
import com.modules.Aluno;
import java.util.ArrayList;

public class UserUtils {
    public static List<Aluno> getStudents() {
        List<Aluno> alunos = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT u.name, a.matricula FROM users u " +
                           "INNER JOIN aluno a ON u.id = a.id " +
                           "WHERE u.role = 'aluno'";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
    
            while (result.next()) {
                Aluno aluno = new Aluno(null, result.getString("name"), result.getString("matricula"));
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alunos;
    }
    
}
