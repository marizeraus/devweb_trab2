/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoConfig {
    private static Connection conexao = null;
    
    public static Connection criaConexao() throws SQLException {
        if( conexao == null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver foi carregado!");
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/lerolero", "root", "123456");
                System.out.println("Conexao realizada com sucesso!");
            }
            catch(ClassNotFoundException e){
                System.out.println("Driver nao foi localizado!");
            }
        }
        return conexao;
    }
}
