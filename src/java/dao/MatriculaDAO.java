package dao;

import dao.dbconfig.ConexaoConfig;
import model.Matricula;
import model.Turma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MatriculaDAO {

    private Connection conexao;

    public MatriculaDAO(){
        try{
            conexao = ConexaoConfig.criaConexao();
        }
        catch(Exception e){
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);

        }
    }


    public Matricula getMatriculaPorId(int codigo) {
        Matricula matricula = new Matricula();
        try{
            String sql = "SELECT * FROM matriculas WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);

            ResultSet rs = ps.executeQuery();

            if( rs.next()){
                matricula.setId(rs.getInt("id"));
                matricula.setAlunos_id(rs.getInt("alunos_id"));
                matricula.setData_matricula(rs.getDate("data_matricula"));
                matricula.setNota(rs.getDouble("nota"));
                matricula.setTurmas_id(rs.getInt("turmas_id"));
            }
        }
        catch(SQLException e){
            System.out.println("Erro de SQL: "+ e.getMessage());
        }
        return matricula;
    }

    public boolean excluir(int id){
        try{
            String sql = "DELETE FROM matriculas WHERE id = ?";
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

    public boolean gravar(Matricula matricula){
        try{
            String sql;
            if(matricula.getId() == 0){
                sql = "INSERT INTO matriculas(turmas_id, alunos_id, data_matricula, nota) VALUES (?,?,?,?)";
            }
            else {
                sql = "UPDATE matriculas SET turmas_id=?, alunos_id=?, data_matricula=?, nota=? WHERE id=?";
            }

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, matricula.getTurmas_id());
            ps.setInt(2, matricula.getAlunos_id());
            ps.setDate(3, matricula.getData_matricula());
            ps.setDouble(4, matricula.getNota());

            if(matricula.getId() > 0){
                ps.setInt(5, matricula.getId());
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
