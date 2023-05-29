package API;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import org.json.JSONObject;

import MODEL.TaskAluno;
import org.json.JSONArray;

@WebServlet(name = "TasksAlunoServlet", urlPatterns = {"/tasksAluno"})
public class TasksAlunoServlet extends HttpServlet {

   private JSONObject getJSONBody(BufferedReader reader) throws Exception {
        StringBuilder buffer = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        return new JSONObject(buffer.toString());
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        JSONObject file = new JSONObject();
        
        try {
              file.put("list", new JSONArray(TaskAluno.list));
        } catch (Exception ex) {
            response.setStatus(500);
            file.put("error", ex.getLocalizedMessage());
        }
        response.getWriter().print(file.toString());
    }
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        JSONObject file = new JSONObject();
        
        try {
            JSONObject body = getJSONBody(request.getReader());
            String nomeAluno = body.getString("nomeAluno");
            if (nomeAluno != null) {
                TaskAluno t = new TaskAluno(nomeAluno);
                TaskAluno.list.add(t);
            }
            file.put("list", new JSONArray(TaskAluno.list));
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
            String nomeAluno = request.getParameter("nomeAluno");
            int i = -1;
                for (TaskAluno t : TaskAluno.list) {
                    if (t.getNomeAluno().equals(nomeAluno)) {
                        i = TaskAluno.list.indexOf(t);
                        break;
                    }
                }
                if (i > -1) {
                    TaskAluno.list.remove(i);
                }
                file.put("list", new JSONArray(TaskAluno.list));
        } catch (Exception ex) {
            response.setStatus(500);
            file.put("error", ex.getLocalizedMessage());
        }
        response.getWriter().print(file.toString());
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
