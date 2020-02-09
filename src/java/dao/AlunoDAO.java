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
import model.Aluno;

/**
 *
 * @author marco
 */
public class AlunoDAO {
    private Connection conexao;
    
    public AlunoDAO(){
        try{
            conexao = ConexaoConfig.criaConexao();
        }
        catch(Exception e){
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        
        }
    }
    
    
    public Aluno getAlunoPorID(int codigo) {
        Aluno aluno = new Aluno();
        try{
            String sql = "SELECT * FROM alunos WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if( rs.next()){
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setEmail(rs.getString("email"));
                aluno.setCelular(rs.getString("celular"));
                aluno.setLogin(rs.getString("login"));
                aluno.setSenha(rs.getString("senha"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setCidade(rs.getString("cidade"));
                aluno.setBairro(rs.getString("bairro"));
                aluno.setCep(rs.getString("cep"));
                aluno.setComentario(rs.getString("comentario"));
                aluno.setAprovado(rs.getString("aprovado"));
            }
        }
        catch(SQLException e){
            System.out.println("Erro de SQL: "+ e.getMessage());
        }
    return aluno;
    }
    
    public boolean excluir(int id){
        try{
            String sql = "DELETE FROM alunos WHERE id = ?";
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
    
    public boolean gravar(Aluno aluno){
        try{
            String sql;
            if(aluno.getId() == 0){
                sql = "INSERT INTO alunos(cpf, nome, email, celular, login, senha, endereco, cidade, bairro, cep, comentario, aprovado) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            }
            else {
                sql = "UPDATE alunos SET cpf=?, nome=?, email=?, celular=?, login=?, senha=?, endereco=?, cidade=?, bairro=?, cep=?, comentario=?, aprovado=? WHERE id=?";
            }
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, aluno.getCpf());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getEmail());
            ps.setString(4, aluno.getCelular());
            ps.setString(5, aluno.getLogin());
            ps.setString(6, aluno.getSenha());
            ps.setString(7, aluno.getEndereco());
            ps.setString(8, aluno.getCidade());
            ps.setString(9, aluno.getBairro());
            ps.setString(10, aluno.getCep());
            ps.setString(11, aluno.getComentario());
            ps.setString(12, aluno.getAprovado());
            
            if(aluno.getId() > 0){
                ps.setInt(13, aluno.getId());
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
