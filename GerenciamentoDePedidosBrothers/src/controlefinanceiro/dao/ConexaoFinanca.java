
package controlefinanceiro.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;


public class ConexaoFinanca {
    private static final String URL = "jdbc:sqlite:brotherscopiadora.db";
    
    public static Connection conexao(){
        Connection conn = null; 
        try {
            conn = DriverManager.getConnection(URL);
            if(conn != null)
            System.out.println("Conexao bem sucedida");
           
            return conn;
        } catch (SQLException e) {
        System.out.println("Não foi possivel conectar. Motivo: " + e.getMessage());
        e.printStackTrace();
        return null;
        }
    }
    
}
