package API;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletConfig;
import java.io.BufferedReader;
import org.json.JSONObject;

import MODEL.Matricula;
import java.util.ArrayList;
import org.json.JSONArray;

@WebServlet(name = "MatriculaServlet", urlPatterns = {"/matriculas"})
public class MatriculaServlet extends HttpServlet {

    private JSONObject getJSONBody(BufferedReader reader) throws Exception {
        StringBuilder buffer = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        return new JSONObject(buffer.toString());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        JSONObject file = new JSONObject();

        try {
            file.put("exception", Matricula.exception);
            ArrayList<Matricula> list = Matricula.getList();
            JSONArray arr = new JSONArray();
            for (Matricula t : list) {
                JSONObject matriculaObj = new JSONObject();
                matriculaObj.put("id_aluno", t.getIdAluno());
                matriculaObj.put("id_curso", t.getIdCurso());
                matriculaObj.put("nivel", t.getNivel());
                matriculaObj.put("presenca", t.getPresenca());
                matriculaObj.put("valor_mensalidade", t.getValorMensalidade());
                arr.put(matriculaObj);
            }
            file.put("list", arr);
        } catch (Exception ex) {
            response.setStatus(500);
            file.put("error", ex.getLocalizedMessage());
        }
        response.getWriter().print(file.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        JSONObject file = new JSONObject();

        try {
            JSONObject body = getJSONBody(request.getReader());
            String idAluno = body.getString("id_aluno");
            String idCurso = body.getString("id_curso");
            String nivel = body.getString("nivel");
            String presenca = body.getString("presenca");
            String valorMensalidade = body.getString("valor_mensalidade");

            if (idAluno != null && idCurso != null && nivel != null && presenca != null && valorMensalidade != null) {
                Matricula.addMatricula(idAluno, idCurso, nivel, presenca, valorMensalidade);
            }

            ArrayList<Matricula> list = Matricula.getList();
            JSONArray arr = new JSONArray();
            for (Matricula t : list) {
                JSONObject matriculaObj = new JSONObject();
                matriculaObj.put("id_aluno", t.getIdAluno());
                matriculaObj.put("id_curso", t.getIdCurso());
                matriculaObj.put("nivel", t.getNivel());
                matriculaObj.put("presenca", t.getPresenca());
                matriculaObj.put("valor_mensalidade", t.getValorMensalidade());
                arr.put(matriculaObj);
            }
            file.put("list", arr);
        } catch (Exception ex) {
            response.setStatus(500);
            file.put("error", ex.getLocalizedMessage());
        }
        response.getWriter().print(file.toString());
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        JSONObject file = new JSONObject();

        try {
            String idAluno = request.getParameter("id_aluno");
           

            if (idAluno != null && idCurso != null) {
                Matricula.removeMatricula(idAluno, idCurso);
            }

            ArrayList<Matricula> list = Matricula.getList();
            JSONArray arr = new JSONArray();
            for (Matricula t : list) {
                JSONObject matriculaObj = new JSONObject();
                matriculaObj.put("id_aluno", t.getIdAluno());
                matriculaObj.put("id_curso", t.getIdCurso());
                matriculaObj.put("nivel", t.getNivel());
                matriculaObj.put("presenca", t.getPresenca());
                matriculaObj.put("valor_mensalidade", t.getValorMensalidade());
                arr.put(matriculaObj);
            }
            file.put("list", arr);
        } catch (Exception ex) {
            response.setStatus(500);
            file.put("error", ex.getLocalizedMessage());
        }
        response.getWriter().print(file.toString());
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        Matricula.createTable();
    }
}
