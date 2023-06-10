package web;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import java.util.Date;
import java.sql.*;
import java.security.*;
import java.math.*;
import model.User;

@WebListener
public class AppListener implements ServletContextListener {
    // Constantes para a conexão com o banco de dados
    public static final String CLASS_NAME = "org.sqlite.JDBC";
    public static final String URL = "jdbc:sqlite:parkapp.db";
    
    // Variáveis para armazenar informações de inicialização e exceções
    public static String initializeLog = "";
    public static Exception exception = null;

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Método vazio para tratar o evento de destruição do contexto da aplicação
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            // Estabelecendo a conexão com o banco de dados
            Connection c = AppListener.getConnection();
            Statement s = c.createStatement();
            
            // Registrando a data e hora da criação do banco de dados
            initializeLog += new Date() + ": Initializing database creation; ";
            
            // Criando a tabela "Users" se ela não existir
            initializeLog += "Creating Users table if not exists...";
            s.execute(User.getCreateStatement());
            initializeLog += "done; ";
            
            // Verificando se não há usuários no banco de dados
            if(User.getUsers().isEmpty()){
                initializeLog += "Adding default users...";
                
                // Inserindo usuários padrão na tabela "Users"
                User.insertUser("admin", "Administrador", "ADMIN", "1234");
                initializeLog += "Admin added; ";
                User.insertUser("Rodrigo", "Rodrigo Cruz", "USER", "1234");
                initializeLog += "Fulano added; ";
            }
            
        } catch (Exception ex) {
            // Registrando uma exceção, se ocorrer
            initializeLog += "Erro: " + ex.getMessage();
        }
    }

    // Método para gerar um hash MD5 a partir de uma string
    public static String getMd5Hash(String text) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(text.getBytes(), 0, text.length());
        return new BigInteger(1, m.digest()).toString();
    }

    // Método para obter a conexão com o banco de dados
    public static Connection getConnection() throws Exception {
        Class.forName(CLASS_NAME);
        return DriverManager.getConnection(URL);
    }
}
