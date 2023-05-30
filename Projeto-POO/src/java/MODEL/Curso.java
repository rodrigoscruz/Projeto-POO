package MODEL;

import java.util.ArrayList;

public class Curso {

    private static ArrayList<Curso> list = new ArrayList<>();

    private int idCurso;
    private String curso;
    private int cargaHoraria;
    private String horario;
    private String modulo;
    private double preco;

    public static ArrayList<Curso> getList() {
        return list;
    }

    public static void setList(ArrayList<Curso> aList) {
        list = aList;
    }

    public Curso(int idCurso, String curso, int cargaHoraria, String horario, String modulo, double preco) {
        this.idCurso = idCurso;
        this.curso = curso;
        this.cargaHoraria = cargaHoraria;
        this.horario = horario;
        this.modulo = modulo;
        this.preco = preco;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
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
