package dao;

import dao.dbconfig.ConexaoConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Instrutor;

/**
 *
 * @author marco
 */
public class InstrutorDAO {
    private Connection conexao;
    
    public InstrutorDAO(){
        try{
        conexao = ConexaoConfig.criaConexao();
        }
        catch(Exception e){
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }
    
    
    public Instrutor getInstrutorPorID(int codigo) {
        Instrutor instrutor = new Instrutor();
        try{
            String sql = "SELECT * FROM instrutores WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if( rs.next()){
                instrutor.setId(rs.getInt("id"));
                instrutor.setNome(rs.getString("nome"));
                instrutor.setEmail(rs.getString("email"));
                instrutor.setLogin(rs.getString("login"));
                instrutor.setExperiencia(rs.getString("experiencia"));
                instrutor.setSenha(rs.getString("senha"));
                instrutor.setValorhora(rs.getInt("valor_hora"));

            }
        }
        catch(SQLException e){
            System.out.println("Erro de SQL: "+ e.getMessage());
        }
    return instrutor;
    }
    
    public boolean excluir(int id){
        try{
            String sql = "DELETE FROM instrutores WHERE id = ?";
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
    
    public boolean gravar(Instrutor instrutor){
        try{
            String sql;
            if(instrutor.getId() == 0){
                sql = "INSERT INTO instrutor(nome, email, valor_hora, login, senha, experiencia) VALUES (?,?,?,?,?)";
            }
            else {
                sql = "UPDATE instrutor SET nome=?, email=?, valor_hora=?, login=?, senha=?, experiencia=? WHERE id=?";
            }
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, instrutor.getNome());
            ps.setString(2, instrutor.getEmail());
            ps.setInt(3, instrutor.getValorhora() );
            ps.setString(4, instrutor.getLogin());
            ps.setString(5, instrutor.getSenha());
            ps.setString(6, instrutor.getExperiencia());

            if(instrutor.getId() > 0){
                ps.setInt(7, instrutor.getId());
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
