
package MODEL;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.sql.*;


public class Turma {
    public static final String CLASS_NAME = "org.sqlite.JDBC";
    public static final String URL = "jdbc.sqlite:to-do.db";
    public static Exception exception = null;
    
    private static ArrayList<Turma> list = new ArrayList<>();


    public static void setList(ArrayList<Turma> aList) {
        list = aList;
    }
    
    
    public static void createTable(){
        try{
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            stmt.execute("create table if not exists tasks(title varchar not null)");
            stmt.close();
            con.close();
        }catch(Exception ex){
            exception = ex;
        }
        
    }
    
    public static Connection getConnection() throws Exception {
        Class.forName(CLASS_NAME);
        return DriverManager.getConnection(URL);
    }
    
    public static ArrayList<Turma> getList() throws Exception {
        ArrayList<Turma> list = new ArrayList<>();
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from tasks");
        while(rs.next()){
            list.add(new Turma(rs.getString("title")));
        }
        rs.close();
        stmt.close();
        con.close();
        return list;
    }
    
    public static void addTask(String title) throws Exception {
        Connection con = getConnection();
        PreparedStatement stmt = con.prepareStatement("insert into tasks values(?)");
        stmt.setString(1, title);
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    public static void removeTask(String title) throws Exception {
        Connection con = getConnection();
        PreparedStatement stmt = con.prepareStatement("delete from tasks where title = ?");
        stmt.setString(1, title);
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    

    
   
    

    public Turma(int idTurma, String turma, LocalTime horarioInicio, LocalTime horarioTermino, LocalDate dataInicio, LocalDate dataTermino, int idProfessor, int idAluno, int idCurso) {
        this.idTurma = idTurma;
        this.turma = turma;
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.idProfessor = idProfessor;
        this.idAluno = idAluno;
        this.idCurso = idCurso;
    }

    private int idTurma;
    private String turma;
    private LocalTime horarioInicio;
    private LocalTime horarioTermino;   
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private int idProfessor;
    private int idAluno;
    private int idCurso;

    private Turma(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalTime getHorarioTermino() {
        return horarioTermino;
    }

    public void setHorarioTermino(LocalTime horarioTermino) {
        this.horarioTermino = horarioTermino;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
    
    
}
