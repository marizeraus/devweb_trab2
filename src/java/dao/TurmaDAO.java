package dao;

import dao.dbconfig.ConexaoConfig;
import model.Turma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TurmaDAO {

    private Connection conexao;

    public TurmaDAO(){
        try{
            conexao = ConexaoConfig.criaConexao();
        }
        catch(Exception e){
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);

        }
    }


    public Turma getTurmaPorId(int codigo) {
        Turma turma = new Turma();
        try{
            String sql = "SELECT * FROM turmas WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);

            ResultSet rs = ps.executeQuery();

            if( rs.next()){
                turma.setId(rs.getInt("id"));
                turma.setCarga_horaria(rs.getInt("carga_horaria"));
                turma.setCursos_id(rs.getInt("cursos_id"));
                turma.setData_final(rs.getDate("data_final"));
                turma.setData_inicio(rs.getDate("data_inicio"));
                turma.setInstrutores_id(rs.getInt("instrutores_id"));
            }
        }
        catch(SQLException e){
            System.out.println("Erro de SQL: "+ e.getMessage());
        }
        return turma;
    }

    public boolean excluir(int id){
        try{
            String sql = "DELETE FROM turmas WHERE id = ?";
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

    public boolean gravar(Turma turma){
        try{
            String sql;
            if(turma.getId() == 0){
                sql = "INSERT INTO turmas(instrutores_id, cursos_id, data_inicio, data_final, carga_horaria) VALUES (?,?,?,?,?)";
            }
            else {
                sql = "UPDATE turmas SET instrutores_id=?, cursos_id=?, data_inicio=?, data_final=?, carga_horaria=? WHERE id=?";
            }

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, turma.getInstrutores_id());
            ps.setInt(2, turma.getCursos_id());
            ps.setDate(3, turma.getData_inicio());
            ps.setDate(4, turma.getData_final());
            ps.setInt(5, turma.getCarga_horaria());

            if(turma.getId() > 0){
                ps.setInt(6, turma.getId());
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
