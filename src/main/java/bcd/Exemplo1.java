package bcd;

import java.sql.*;
import java.util.Scanner;

public class Exemplo1 {

    private static final String dbPath = "src/main/resources/lab01.sqlite";

    public static void inserir() throws ClassNotFoundException, SQLException {
        Scanner teclado = new Scanner(System.in);
//        String lido = teclado.nextLine();
//        teclado.next(); // consumir caractere extra do ENTER CR/LF
//        int lidoINT = teclado.nextInt();

        Class.forName("org.sqlite.JDBC"); // Uma camada de abstração do Java para comunicação com o Banco

        Connection conexao = DriverManager.getConnection("jdbc:sqlite:" + dbPath); // Criando uma conexão

        Statement stmt = conexao.createStatement();

//        String query = "INSERT INTO aluno VALUES (2,'juca',80,180,'juca@email.com')";

        System.out.println("ID: ");
        int id = teclado.nextInt();
        //teclado.next(); // consumir caractere extra do ENTER CR/LF

        System.out.println("Nome: ");
        String nome = teclado.next();
        //teclado.nextLine(); // consumir caractere extra do ENTER CR/LF
        System.out.println(nome);

        System.out.println("Peso ");
        double peso = teclado.nextDouble();
        //teclado.next(); // consumir caractere extra do ENTER CR/LF

        System.out.println("Altura: ");
        int altura = teclado.nextInt();
        //teclado.next(); // consumir caractere extra do ENTER CR/LF

        System.out.println("E-mail: ");
        String email = teclado.next();
        //teclado.nextLine(); // consumir caractere extra do ENTER CR/LF

        //String query = "INSERT INTO aluno VALUES (2,'juca',80,180,'juca@email.com')";
        String query = "INSERT INTO aluno VALUES (" + id + ",'" + nome + "'," + peso + "," + altura + ",'" + email + "')";

        //System.out.println(query);

        stmt.executeUpdate(query);
        stmt.close();
        conexao.close();

    }

    public static void listarRegistros() throws ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC"); // Uma camada de abstração do Java para comunicação com o Banco
        Connection conexao = DriverManager.getConnection("jdbc:sqlite:" + dbPath); // Criando uma conexão
        Statement stmt = conexao.createStatement();


        String query = "SELECT * FROM aluno";

        ResultSet linhas = stmt.executeQuery(query);

        printarLinhas(linhas);

        linhas.close();
        stmt.close();
        conexao.close();
    }

    public static void printarLinhas(ResultSet linhas) throws SQLException {
        System.out.println(String.format("|%-5s|%-25s|%-25s", "ID", "Nome", "Email"));
        while(linhas.next()){
            System.out.println(String.format("|%-5d|%-25s|%-25s", linhas.getInt("idAluno"),linhas.getString("nome"), linhas.getString("email")));
        }
    }

    public static void buscar() throws ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC"); // Uma camada de abstração do Java para comunicação com o Banco
        Connection conexao = DriverManager.getConnection("jdbc:sqlite:" + dbPath); // Criando uma conexão
        Statement stmt = conexao.createStatement();

        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe um e-mail: ");
        String email = teclado.next();

        String query = "SELECT * FROM aluno WHERE email = '" + email + "'";

        ResultSet linhas = stmt.executeQuery(query);

        printarLinhas(linhas);

        linhas.close();
        stmt.close();
        conexao.close();
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //listarRegistros();
        buscar();
    }
}
