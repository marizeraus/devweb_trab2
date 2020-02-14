/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.dbconfig.ConexaoConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Administrador;

/**
 *
 * @author marco
 */
public class AdministradorDAO {
    private Connection conexao;
    
    public AdministradorDAO(){
        try{
            conexao = ConexaoConfig.criaConexao();
        }
        catch(Exception e){
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        
        }
    }
    
    
    public Administrador getAdministradorPorID(int codigo) {
        Administrador admin = new Administrador();
        try{
            String sql = "SELECT * FROM administrador WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if( rs.next()){
                admin.setId(rs.getInt("id"));
                admin.setNome(rs.getString("nome"));
                admin.setSenha(rs.getString("senha"));
                admin.setLogin(rs.getString("login"));
            }
        }
        catch(SQLException e){
            System.out.println("Erro de SQL: "+ e.getMessage());
        }
    return admin;
    }
    
    public boolean excluir(int id){
        try{
            String sql = "DELETE FROM administrador WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        }
        catch(SQLException e){
            System.out.println("Erro de SQL: "+ e.getMessage());
            return false;
        }
    }
        
    public boolean gravar(Administrador admin){
        try{
            String sql;
            if(admin.getId() == 0){
                sql = "INSERT INTO administrador(nome, login, senha) VALUES (?,?,?)";
            }
            else {
                sql = "UPDATE administrador SET nome=?, login=?, senha=? WHERE id=?";
            }
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, admin.getNome());
            ps.setString(2, admin.getLogin());
            ps.setString(3, admin.getSenha());
            
            if(admin.getId() > 0){
                ps.setInt(4, admin.getId());
            }
            
            ps.execute();
            
            return true;
        }
        catch(SQLException e){
            System.out.println("Erro de SQL: "+ e.getMessage());
            return false;
        }
    }
    
    public List<Administrador> listaAdministradores() throws SQLException {
        List<Administrador> listaAdmin = new ArrayList<>();
         
        String sql = "SELECT * FROM administrador";
        PreparedStatement ps = conexao.prepareStatement(sql);
        try (ResultSet resultSet = ps.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String login = resultSet.getString("login");
                String senha = resultSet.getString("senha");
                
                Administrador admin = new Administrador();
                admin.setId(id);
                admin.setLogin(login);
                admin.setNome(nome);
                admin.setSenha(senha);
                listaAdmin.add(admin);
            }
        }
         
        return listaAdmin;
    }
    
}
