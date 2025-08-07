
package gerenciamentopedidos.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class PedidoDataBase {
    
    public boolean pedido(){
    String sql = "CREATE TABLE IF NOT EXISTS pedidos("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "id_cliente INTEGER NOT NULL,"
            + "data TEXT NOT NULL,"
            + "status TEXT NOT NULL,"
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
        System.out.println("Não foi possível criar a tabela. Motivo: "+ e.getMessage());
        return false;
        }
    
    
    }
    
    
}
