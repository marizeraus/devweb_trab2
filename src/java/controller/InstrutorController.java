import dao.CursoDAO;
import dao.InstrutorDAO;
import model.Curso;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Instrutor;


@WebServlet(name = "InstrutorController", urlPatterns = {"/InstrutorController"})
public class InstrutorController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            RequestDispatcher rd = request.getRequestDispatcher("/instrutor/InstrutorFormJSP.jsp");
            rd.forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String mensagem;
        Instrutor instrutor = new Instrutor();
//        if(!request.getParameter("id").isEmpty()){
//            admin.setId(Integer.parseInt(request.getParameter("id")));Curso
//        }
        instrutor.setNome(request.getParameter("nome"));
        instrutor.setEmail(request.getParameter("email"));
        instrutor.setLogin(request.getParameter("login"));
        instrutor.setExperiencia(request.getParameter("experiencia"));
        instrutor.setSenha(request.getParameter("senha"));
        instrutor.setValorhora(request.getParameter("valor_hora"));


        InstrutorDAO instrutorDAO = new InstrutorDAO();
        if(InstrutorDAO.gravar(instrutor)){
            mensagem = "Instrutpr Salvo com sucesso!";
        }
        else{
            mensagem = "Erro ao gravar instrutor";
        }
        request.setAttribute("mensagem", mensagem);
        RequestDispatcher rd = request.getRequestDispatcher("/instrutor/InstrutorShowJSP.jsp");
        rd.forward(request, response);

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
