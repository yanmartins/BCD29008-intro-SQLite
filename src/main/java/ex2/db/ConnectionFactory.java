package ex2.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConnectionFactory {

    private static final String dbPath = "src/main/resources/lab01.sqlite";

    private static Connection conexao;


    public static Connection getConnection(){
        try {
            Class.forName("org.sqlite.JDBC"); // Uma camada de abstração do Java para comunicação com o Banco
            conexao = DriverManager.getConnection("jdbc:sqlite:" + dbPath); // Criando uma conexão
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return conexao;
    }

}
