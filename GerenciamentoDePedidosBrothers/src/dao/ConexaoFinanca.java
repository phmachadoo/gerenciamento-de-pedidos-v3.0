
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;


public class ConexaoFinanca {
    private static final String URL = "jdbc:sqlite:brotherscopiadora.db";
    
    public static Connection conexao(){
        try {
            Connection conn = DriverManager.getConnection(URL);
            if(conn!=null){
             System.out.println("Conexao bem sucedida");
            }
           
            return conn;
        } catch (SQLException e) {
            System.out.println("Não foi possivel conectar.");
        e.printStackTrace();
        return null;
        }
    }
    
}
