package controller.turma;

import dao.TurmaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
        turma.setInstrutores_id(Integer.parseInt(request.getParameter("instrutores_id")));
        turma.setCursos_id(Integer.parseInt(request.getParameter("cursos_id")));
        Date data_inicio = Date.valueOf(request.getParameter("data_inicio"));
        Date data_fim = Date.valueOf(request.getParameter("data_fim"));
        turma.setData_inicio(data_inicio);
        turma.setData_final(data_fim);
        turma.setCarga_horaria(Integer.parseInt(request.getParameter("carga_horaria")));
        TurmaDAO turmaDAO = new TurmaDAO();
        if(turmaDAO.gravar(turma)){
            mensagem = "Turma Salvo com sucesso!";
        }
        else{
            mensagem = "Erro ao gravar turma";
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
