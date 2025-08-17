/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciamentopedidos.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ProdutoDataBase {
    
    public static boolean produto(){
    String sql = "CREATE TABLE IF NOT EXISTS produto("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "nome TEXT NOT NULL,"
            + "descricao TEXT,"
            + "preco REAL NOT NULL"
            + ");";
    
            try(Connection conn = BrothersDataBase.conexao();
                 PreparedStatement ps = conn.prepareStatement(sql)){
                
                ps.execute();
                return true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Não foi possivel criar a tabela clientes. Motivo: " + e.getMessage());
            return false;
        }
    
    
    
    }
    
}
