/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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

import MODEL.Turma;
import java.util.ArrayList;
import org.json.JSONArray;

/**
 *
 * @author rsstr
 */
@WebServlet(name = "TurmaServlet", urlPatterns = {"/turmas"})
public class TurmaServlet extends HttpServlet {

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
            file.put("exception", Turma.exception);
            ArrayList<Turma> list = Turma.getList();
            JSONArray arr = new JSONArray();
            for(Turma t : list){
                arr.put(t.getTurma());
            }
            file.put("list", arr);
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
            String nomeTurma = body.getString("nomeAluno");
            if (nomeTurma != null) {
                Turma.addTask(nomeTurma);
            }
            ArrayList<Turma> list = Turma.getList();
            JSONArray arr = new JSONArray();
            for(Turma t : list){
                arr.put(t.getClass());
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
            String nomeTurma = request.getParameter("nomeAluno");
            Turma.removeTask(nomeTurma);
            ArrayList<Turma> list = Turma.getList();
            JSONArray arr =  new JSONArray();
                for (Turma t : list) {
                    arr.put(t.getTurma());
                }
                file.put("list", arr);
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

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        Turma.createTable();
    }
}
