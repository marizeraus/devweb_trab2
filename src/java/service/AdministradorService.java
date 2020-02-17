/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AdministradorDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Administrador;

/**
 *
 * @author flavio
 */
public class AdministradorService {

    private AdministradorDAO administradorDAO;

    public AdministradorService(){
        try {
            this.administradorDAO = new AdministradorDAO();
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdministradorService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Administrador> listaAdministradores() throws SQLException {
        return administradorDAO.listaAdministradores(); //To change body of generated methods, choose Tools | Templates.
    }

    public void gravar(Administrador novoAdmin) {
        administradorDAO.gravar(novoAdmin); //To change body of generated methods, choose Tools | Templates.
    }

    public void excluir(int id) {
        administradorDAO.excluir(id);
    }

    public Administrador getAdministradorPorID(int id) {
        return administradorDAO.getAdministradorPorID(id); //To change body of generated methods, choose Tools | Templates.
    }
    
}
