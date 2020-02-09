/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AdministradorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Administrador;

/**
 *
 * @author marco
 */
@WebServlet(name = "AdministradorController", urlPatterns = {"/AdministradorController"})
public class AdministradorController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            RequestDispatcher rd = request.getRequestDispatcher("/admin/AdminFormJSP.jsp");
            rd.forward(request, response);
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdministradorController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdministradorController at " + request.getContextPath() + "</h1>");
            out.println("<form method=\"post\" action=\"AdministradorController\">");
            out.println("<label> digite o nome: </label>");
            out.println("<input type=\"text\" name=\"nome\">");
            out.println("<label> digite o login: </label>");
            out.println("<input type=\"text\" name=\"login\">");
            out.println("<label> digite a senha: </label>");
            out.println("<input type=\"password\" name=\"senha\">");
            out.println("<input type=\"submit\" value=\"Enviar!\">");
            out.println("</form>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String mensagem;
        Administrador admin = new Administrador();
//        if(!request.getParameter("id").isEmpty()){
//            admin.setId(Integer.parseInt(request.getParameter("id")));
//        }
        admin.setNome(request.getParameter("nome"));
        admin.setLogin(request.getParameter("login"));
        admin.setSenha(request.getParameter("senha"));
        AdministradorDAO adminDao = new AdministradorDAO();
        if(adminDao.gravar(admin)){
            mensagem = "Admin Salvo com sucesso!";
        }
        else{
            mensagem = "Erro ao gravar admin";
        }
        request.setAttribute("mensagem", mensagem);
        RequestDispatcher rd = request.getRequestDispatcher("/admin/AdminShowJSP.jsp");
        rd.forward(request, response);
//        try (PrintWriter out = response.getWriter()) {
//            
//        
//        }
//        catch(Exception e){
//            mensagem = "Erro ao gravar usuario: "+ e.getMessage();
//        }
//        System.out.println(mensagem);

    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
