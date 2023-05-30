
package MODEL;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Turma {
    
    private static ArrayList<Turma> list = new ArrayList<>();

    public static ArrayList<Turma> getList() {
        return list;
    }

    public static void setList(ArrayList<Turma> aList) {
        list = aList;
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
