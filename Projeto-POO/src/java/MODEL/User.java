/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class User {
    private long rowID;
    private String name;
    private String login;
    private String role;
    private String senhaHash;
    
    
    // DEVOLVE A STRING QUE USA PRA CRIAR OBJETO NO BANCO
    
    public static String getCreateStatement( ) {
    return "CREATE TABLE IF NOT EXISTS users ("
    + "login VARCHAR(50) UNIQUE NOT NULL,"
    + "name VARCHAR(200) NOT NULL,"
    + "role VARCHAR(20) NOT NULL,"
    + "senhaHash VARCHAR NOT NULL"   
    + ")";        
    }

    public User(long rowID, String name, String login, String role, String senhaHash) {
        this.rowID = rowID;
        this.name = name;
        this.login = login;
        this.role = role;
        this.senhaHash = senhaHash;
    }

    public long getRowID() {
        return rowID;
    }

    public void setRowID(long rowID) {
        this.rowID = rowID;
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

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }
    
    
     
    
}
