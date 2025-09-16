package gerenciamentopedidos.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemPedidoDataBase {
    
    public boolean itemPedido(){
    String sql = "CREATE TABLE IF NOT EXISTS item_pedido("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "id_pedido INTEGER NOT NULL,"
            + "id_produtos INTEGER NOT NULL,"
            + "descricao TEXT DEFAULT '',"
            + "quantidade INTEGER NOT NULL,"
            + "subtotal REAL NOT NULL,"
            + "FOREIGN KEY(id_pedido) REFERENCES pedido(id),"
            + "FOREIGN KEY(id_produtos) REFERENCES produtos(id)"
            + ");";
    
        try (Connection conn = BrothersDataBase.conexao();
             PreparedStatement ps = conn.prepareStatement(sql);
                ){
            
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Não foi possivel criar a tabela. Motivo: "+e.getMessage());
            return false;
        
        }
    }
    
    
    
    
    
    
}
