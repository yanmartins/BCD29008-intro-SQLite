package bcd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Exemplo1 {

    private static final String dbPath = "src/main/resources/lab01.sqlite";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("Olá mundo");

        Class.forName("org.sqlite.JDBC"); // Uma camada de abstração do Java para comunicação com o Banco

        Connection conexao = DriverManager.getConnection("jdbc:sqlite:" + dbPath); // Criando uma conexão

        Statement stmt = conexao.createStatement();

        String query = "INSERT INTO aluno VALUES (2,'juca',80,180,'juca@email.com')";

        stmt.executeUpdate(query);
        stmt.close();
        conexao.close();

    }
}
