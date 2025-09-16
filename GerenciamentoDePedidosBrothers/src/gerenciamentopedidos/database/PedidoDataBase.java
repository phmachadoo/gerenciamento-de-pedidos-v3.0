
package gerenciamentopedidos.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class PedidoDataBase {
    
    public static boolean pedido(){
    String sql = "CREATE TABLE IF NOT EXISTS pedidos("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "id_cliente INTEGER NOT NULL,"
            + "data TEXT NOT NULL,"
            + "total REAL,"
            + "FOREIGN KEY (id_cliente) REFERENCES cliente(id)"
            + ");";
    
            try(Connection conn = BrothersDataBase.conexao();
             PreparedStatement ps = conn.prepareStatement(sql);)
                 {
                     
                     ps.execute();
                     return true;
            
        } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null,"Não foi possivel criar a tabela clientes. Motivo: " + e.getMessage());
        return false;
        }
    
    
    }
    
    
}
