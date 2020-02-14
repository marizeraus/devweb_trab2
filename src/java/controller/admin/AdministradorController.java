package controller.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Administrador;
import service.AdministradorService;

/**
 *
 * @author marco
 */
@WebServlet(name = "AdministradorController", urlPatterns = {"/AdministradorController"})
public class AdministradorController extends HttpServlet {
    private final AdministradorService adminService = new AdministradorService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            RequestDispatcher rd = request.getRequestDispatcher("/admin/AdminFormJSP.jsp");
//            rd.forward(request, response);
//        }
        String action = request.getServletPath();
        try {
            switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertAdmin(request, response);
                break;
            case "/delete":
                deleteAdmin(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateAdmin(request, response);
                break;
            default:
                listAdmin(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        
//        String mensagem;
//        Administrador admin = new Administrador();
////        if(!request.getParameter("id").isEmpty()){
////            admin.setId(Integer.parseInt(request.getParameter("id")));
////        }
//        admin.setNome(request.getParameter("nome"));
//        admin.setLogin(request.getParameter("login"));
//        admin.setSenha(request.getParameter("senha"));
//        AdministradorDAO adminDao = new AdministradorDAO();
//        if(adminDao.gravar(admin)){
//            mensagem = "Admin Salvo com sucesso!";
//        }
//        else{
//            mensagem = "Erro ao gravar admin";
//        }
//        request.setAttribute("mensagem", mensagem);
//        RequestDispatcher rd = request.getRequestDispatcher("/admin/AdminShowJSP.jsp");
//        rd.forward(request, response);
          doGet(request, response);
    }
    
    private void listAdmin(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Administrador> listAdmin = adminService.listaAdministradores();
        request.setAttribute("listAdmin", listAdmin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/AdminList.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/AdminFormJSP.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Administrador admin = adminService.getAdministradorPorID(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/AdminFormJSP.jsp");
        request.setAttribute("admin", admin);
        dispatcher.forward(request, response);
 
    }
 
    private void insertAdmin(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
 
        Administrador novoAdmin = new Administrador(nome,login, senha);
        adminService.gravar(novoAdmin);
        response.sendRedirect("list");
    }
 
    private void updateAdmin(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
 
        Administrador admin = new Administrador(id, nome, login, senha);
        adminService.gravar(admin);
        response.sendRedirect("list");
    }
 
    private void deleteAdmin(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        adminService.excluir(id);
        response.sendRedirect("list");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}