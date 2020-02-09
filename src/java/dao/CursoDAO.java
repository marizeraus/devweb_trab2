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
import model.Curso;

/**
 *
 * @author marco
 */
public class CursoDAO {
    private Connection conexao;
    
    public CursoDAO(){
        try{
            conexao = ConexaoConfig.criaConexao();
        }
        catch(Exception e){
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        
        }
    }
    
    
    public Curso getCursoPorID(int codigo) {
        Curso curso = new Curso();
        try{
            String sql = "SELECT * FROM cursos WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if( rs.next()){
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setRequisito(rs.getString("requisito"));
                curso.setEmenta(rs.getString("ementa"));
                curso.setCarga_horaria(rs.getInt("carga_horaria"));
                curso.setPreco(rs.getDouble("preco"));
                
            }
        }
        catch(SQLException e){
            System.out.println("Erro de SQL: "+ e.getMessage());
        }
    return curso;
    }
    
    public boolean excluir(int id){
        try{
            String sql = "DELETE FROM cursos WHERE id = ?";
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
    
    public boolean gravar(Curso curso){
        try{
            String sql;
            if(curso.getId() == 0){
                sql = "INSERT INTO cursos(nome, requisito, ementa, carga_horaria, preco) VALUES (?,?,?,?,?)";
            }
            else {
                sql = "UPDATE administrador SET nome=?, requisito=?, ementa=?, carga_horaria=?, preco=? WHERE id=?";
            }
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, curso.getNome());
            ps.setString(2, curso.getRequisito());
            ps.setString(3, curso.getEmenta());
            ps.setInt(4, curso.getCarga_horaria());
            ps.setDouble(5, curso.getPreco());
            
            if(curso.getId() > 0){
                ps.setInt(6, curso.getId());
            }
            
            ps.execute();
            
            return true;
        }
        catch(SQLException e){
            System.out.println("Erro de SQL: "+ e.getMessage());
            return false;
        }
    }
}
