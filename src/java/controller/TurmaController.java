package controller;

import dao.TurmaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Administrador;
import model.Turma;

/**
 *
 * @author marco
 */
@WebServlet(name = "TurmaController", urlPatterns = {"/TurmaController"})
public class TurmaController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            RequestDispatcher rd = request.getRequestDispatcher("/turma/TurmaFormJSP.jsp");
            rd.forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String mensagem;
        Turma turma = new Turma();
//        if(!request.getParameter("id").isEmpty()){
//            admin.setId(Integer.parseInt(request.getParameter("id")));
//        }
        turma.setInstrutores_id(request.getParameter("instrutores_id"));
        turma.setCursos_id(request.getParameter("cursos_id"));
        turma.setData_inicio(request.getParameter("data_inicio"));
        turma.setData_final(request.getParameter("data_final"));
        turma.setCarga_horaria(request.getParameter("carga_horaria"));
        TurmaDAO turmaDAO = new TurmaDAO();
        if(turmaDAO.gravar(turma)){
            mensagem = "Admin Salvo com sucesso!";
        }
        else{
            mensagem = "Erro ao gravar admin";
        }
        request.setAttribute("mensagem", mensagem);
        RequestDispatcher rd = request.getRequestDispatcher("/turma/TurmaShowJSP.jsp");
        rd.forward(request, response);

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
