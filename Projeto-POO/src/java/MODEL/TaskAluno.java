
package MODEL;

import java.util.ArrayList;

public class TaskAluno {
    
    public static ArrayList<TaskAluno> list = new ArrayList<>();
    public String nomeAluno;

    public TaskAluno() {
        this.setNomeAluno("[Novo]");
    }

    public TaskAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public static ArrayList<TaskAluno> getList() {
        return list;
    }

    public static void setList(ArrayList<TaskAluno> list) {
        TaskAluno.list = list;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }
}
