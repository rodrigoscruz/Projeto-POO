package MODEL;

import java.util.ArrayList;

public class Curso {

    public static ArrayList<Curso> list = new ArrayList<>();
    
    public String curso;
    public int cargaHoraria;
    public String horario;
    public String modulo;
    public double preco;
       
    public Curso() {
        this.setCurso("[Novo]");
    }
    //construtor
    public Curso(String curso, int cargaHoraria, String horario, String modulo, double preco) {
        this.curso = curso;
        this.cargaHoraria = cargaHoraria;
        this.horario = horario;
        this.modulo = modulo;
        this.preco = preco;
    }
    //getter/setter
    
    public static ArrayList<Curso> getList() {
        return list;
    }

    public static void setList(ArrayList<Curso> list) {
        Curso.list = list;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }       
}
