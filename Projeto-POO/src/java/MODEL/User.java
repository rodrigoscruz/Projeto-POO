/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;
import java.util.ArrayList;
import web.AppListener;

/**
 * Classe que representa um usuário do sistema.
 */
public class User {

    private long rowId;
    private String name;
    private String login;
    private String role;
    private String passwordHash;

    /**
      Retorna a declaração SQL para criar a tabela "users" no banco de dados, se ela não existir.
     
     @return Declaração SQL para criar a tabela "users".
     */
    public static String getCreateStatement() {
        return "CREATE TABLE IF NOT EXISTS users("
                + "login VARCHAR(50) UNIQUE NOT NULL,"
                + "name VARCHAR(200) NOT NULL,"
                + "role VARCHAR(20) NOT NULL,"
                + "password_hash VARCHAR NOT NULL"
                + ")";
    }

    /**
     Retorna uma lista de todos os usuários do banco de dados.
     * @return Lista de usuários.
     * @throws Exception Se ocorrer um erro durante a execução da consulta.
     */
    public static ArrayList<User> getUsers() throws Exception{
        ArrayList<User> list = new ArrayList<>();
        Connection con = AppListener.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT rowid, * from users");
        while(rs.next()){
            long rowId = rs.getLong("rowid");
            String login = rs.getString("login");
            String name = rs.getString("name");
            String role = rs.getString("role");
            String passwordHash = rs.getString("password_hash");
            list.add(new User(rowId, login, name, role, passwordHash));
        }
        rs.close();
        stmt.close();
        con.close();
        return list;
    }
    
    /*
     Retorna um objeto User correspondente ao login e senha fornecidos.
  
     */
    public static User getUser(String login, String password) throws Exception{
        User user = null;
        Connection con = AppListener.getConnection();
        String sql = "SELECT rowid, * from users WHERE login=? AND password_hash=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, login);
        stmt.setString(2, AppListener.getMd5Hash(password));
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
            long rowId = rs.getLong("rowid");
            String name = rs.getString("name");
            String role = rs.getString("role");
            String passwordHash = rs.getString("password_hash");
            user = new User(rowId, login, name, role, passwordHash);
        }
        rs.close();
        stmt.close();
        con.close();
        return user;
    }
    
    /*
     * Insere um novo usuário no banco de dados.
     */
    public static void insertUser(String login, String name, String role, String password) throws Exception{
        Connection con = AppListener.getConnection();
        String sql = "INSERT INTO users(login, name, role, password_hash) "
                + "VALUES(?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, login);
        stmt.setString(2, name);
        stmt.setString(3, role);
        stmt.setString(4, AppListener.getMd5Hash(password));
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    /*
     Atualiza as informações de um usuário no banco de dados.
     */
    public static void updateUser(String login, String name, String role, String password) throws Exception{
        Connection con = AppListener.getConnection();
        String sql = "UPDATE users SET name=?, role=?, password_hash=? WHERE login=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, role);
        stmt.setString(3, AppListener.getMd5Hash(password));
        stmt.setString(4, login);
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    /**
     Exclui um usuário do banco de dados.
     */
    public static void deleteUser(long rowId) throws Exception{
        Connection con = AppListener.getConnection();
        String sql = "DELETE FROM users WHERE rowid = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setLong(1, rowId);
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    /**
     Altera a senha de um usuário.
     */
    public static void changePassword(String login, String password) throws Exception{
        Connection con = AppListener.getConnection();
        String sql = "UPDATE users SET password_hash = ? WHERE login = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, AppListener.getMd5Hash(password));
        stmt.setString(2, login);
        stmt.execute();
        stmt.close();
        con.close();
    }

    /**
     Construtor da classe User.
     */
    public User(long rowId, String name, String login, String role, String passwordHash) {
        this.rowId = rowId;
        this.login = login;
        this.name = name;
        this.role = role;
        this.passwordHash = passwordHash;
    }


    public String getPasswordHash() {
        return passwordHash;
    }


    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
    

    public long getRowId() {
        return rowId;
    }


    public void setRowId(long rowId) {
        this.rowId = rowId;
    }


    public String getName() {
        return name;
    }


  
    public void setName(String name) {
        this.name = name;
    }


    public String getLogin() {
        return login;
    }


    public void setLogin(String login) {
        this.login = login;
    }

 
    public String getRole() {
        return role;
    }


    public void setRole(String role) {
        this.role = role;
    }
}
