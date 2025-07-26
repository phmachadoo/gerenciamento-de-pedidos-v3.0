
package gerenciamentopedidos.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ClienteDataBase {
    public static boolean clientes(){
    String sql = "CREATE TABLE IF NOT EXISTS clientes("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "nome TEXT NOT NULL,"
            + "telefone TEXT,"
            + "email TEXT,"
            + "descricao TEXT,"
            + "total_pedidos INTEGER DEFAULT 0"
            + ");";
    
        try(Connection conn = BrothersDataBase.conexao();
            PreparedStatement ps = conn.prepareStatement(sql);
                ) {
            
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Não foi possivel criar a tabela clientes. Motivo: " + e.getMessage());
            return false;
        }
    }
    
}
