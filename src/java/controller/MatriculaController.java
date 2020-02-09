package controller;

import dao.MatriculaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Matricula;

/**
 *
 * @author marco
 */
@WebServlet(name = "MatriculaController", urlPatterns = {"/MatriculaController"})
public class MatriculaController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            RequestDispatcher rd = request.getRequestDispatcher("/matricula/MatriculaFormJSP.jsp");
            rd.forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String mensagem;
        Matricula matricula = new Matricula();
//        if(!request.getParameter("id").isEmpty()){
//            admin.setId(Integer.parseInt(request.getParameter("id")));
//        }
        matricula.setTurmas_id(request.getParameter("turmas_id"));
        matricula.setNota(request.getParameter("nota"));
        matricula.setData_matricula(request.getParameter("data_matricula"));
        matricula.setAlunos_id(request.getParameter("alunos_id"));

        MatriculaDAO matriculaDAO = new MatriculaDAO();
        if(matriculaDAO.gravar(matricula)){
            mensagem = "Admin Salvo com sucesso!";
        }
        else{
            mensagem = "Erro ao gravar admin";
        }
        request.setAttribute("mensagem", mensagem);
        RequestDispatcher rd = request.getRequestDispatcher("/matricula/MatriculaShowJSP.jsp");
        rd.forward(request, response);

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
