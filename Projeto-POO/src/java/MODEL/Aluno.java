
package MODEL;

import java.util.ArrayList;
import java.sql.*;

public class Aluno {
    public static final String CLASS_NAME = "org.sqlite.JDBC";
    public static final String URL = "jdbc.sqlite:to-do.db";    
    public static Exception exception = null;
    
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
    
    public static ArrayList<Aluno> getList() throws Exception {
        ArrayList<Aluno> list = new ArrayList<>();
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from tasks");
        while(rs.next()){
            list.add(new Aluno(rs.getString("title")));
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
    
    
    public static ArrayList<Aluno> list = new ArrayList<>();
    public String nomeAluno;

    public Aluno() {
        this.setNomeAluno("[Novo]");
    }

    public Aluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    /*public static ArrayList<TaskAluno> getList() {
        return list;
    }*/

    public static void setList(ArrayList<Aluno> list) {
        Aluno.list = list;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }
}
