
package gerenciamentopedidos.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class BrothersDataBase {
    private static final String URL = "jdbc:mysql://localhost:3306/gerenciamento_brothers";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public static Connection conexao(){
        Connection conn = null; 
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            if(conn != null)
            System.out.println("Conexao bem sucedida");
           
            return conn;
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(null,"Não foi possivel criar a tabela clientes. Motivo: " + e.getMessage());
        e.printStackTrace();
        return null;
        }
    
    }
    
}
