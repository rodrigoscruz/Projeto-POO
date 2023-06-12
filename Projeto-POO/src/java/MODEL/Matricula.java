/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.sql.*;


public class Matricula {
    public static final String CLASS_NAME = "org.sqlite.JDBC";
    public static final String URL = "jdbc:sqlite:to-do.db";
    public static Exception exception = null;

    // Método para criar a tabela no banco de dados
    public static void createTable() {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            stmt.execute("create table if not exists matricula(id_aluno varchar not null, id_curso varchar not null, nivel varchar not null, presenca varchar not null, valor_mensalidade varchar not null)");
            stmt.close();
            con.close();
        } catch (Exception ex) {
            exception = ex;
        }

    }

    // Método para obter a conexão com o banco de dados
    public static Connection getConnection() throws Exception {
        Class.forName(CLASS_NAME);
        return DriverManager.getConnection(URL);
    }

    // Método para obter a lista de matrículas do banco de dados
    public static ArrayList<Matricula> getList() throws Exception {
        ArrayList<Matricula> list = new ArrayList<>();
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from matricula");
        while (rs.next()) {
            list.add(new Matricula(rs.getString("id_aluno"), rs.getString("id_curso"), rs.getString("nivel"), rs.getString("presenca"), rs.getString("valor_mensalidade")));
        }
        rs.close();
        stmt.close();
        con.close();
        return list;
    }

    // Método para adicionar uma nova matrícula ao banco de dados
    public static void addMatricula(String id_aluno, String id_curso, String nivel, String presenca, String valor_mensalidade) throws Exception {
        Connection con = getConnection();
        PreparedStatement stmt = con.prepareStatement("insert into matricula values(?, ?, ?, ?, ?)");
        stmt.setString(1, id_aluno);
        stmt.setString(2, id_curso);
        stmt.setString(3, nivel);
        stmt.setString(4, presenca);
        stmt.setString(5, valor_mensalidade);
        stmt.execute();
        stmt.close();
        con.close();
    }

    // Método para remover uma matrícula do banco de dados
    public static void removeMatricula(String id_aluno, String id_curso) throws Exception {
        Connection con = getConnection();
        PreparedStatement stmt = con.prepareStatement("delete from matricula where id_aluno = ?");
        stmt.setString(1, id_aluno);
        stmt.execute();
        stmt.close();
        con.close();
    }


    public static ArrayList<Matricula> list = new ArrayList<>();
    public String id_aluno;
    public String id_curso;
    public String nivel;
    public String presenca;
    public String valor_mensalidade;

    // Construtor padrão da classe
    public Matricula() {
        this.setIdAluno("[Novo]");
        this.setIdCurso("[Novo]");
        this.setNivel("[Novo]");
        this.setPresenca("[Novo]");
        this.setValorMensalidade("[Novo]");
    }

    // Construtor da classe com parâmetros
    public Matricula(String id_aluno, String id_curso, String nivel, String presenca, String valor_mensalidade) {
        this.id_aluno = id_aluno;
        this.id_curso = id_curso;
        this.nivel = nivel;
        this.presenca = presenca;
        this.valor_mensalidade = valor_mensalidade;
    }

    // Método para definir a lista de matrículas
    public static void setList(ArrayList<Matricula> list) {
        Matricula.list = list;
    }

    // Método getter para o ID do aluno
    public String getIdAluno() {
        return id_aluno;
    }

    // Método setter para o ID do aluno
    public void setIdAluno(String id_aluno) {
        this.id_aluno = id_aluno;
    }

    // Método getter para o ID do curso
    public String getIdCurso() {
        return id_curso;
    }

    // Método setter para o ID do curso
    public void setIdCurso(String id_curso) {
        this.id_curso = id_curso;
    }

    // Método getter para o nível
    public String getNivel() {
        return nivel;
    }

    // Método setter para o nível
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    // Método getter para a presença
    public String getPresenca() {
        return presenca;
    }

    // Método setter para a presença
    public void setPresenca(String presenca) {
        this.presenca = presenca;
    }

    // Método getter para o valor da mensalidade
    public String getValorMensalidade() {
        return valor_mensalidade;
    }

    // Método setter para o valor da mensalidade
    public void setValorMensalidade(String valor_mensalidade) {
        this.valor_mensalidade = valor_mensalidade;
    }
}
