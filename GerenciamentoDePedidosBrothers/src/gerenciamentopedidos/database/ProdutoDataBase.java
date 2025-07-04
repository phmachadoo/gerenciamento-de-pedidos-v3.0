
package gerenciamentopedidos.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDataBase {
    
    public boolean produtos(){
    String sql = "CREATE TABLE IF NOT EXISTS produto("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "id_pedido INTEGER NOT NULL,"
            + "nome_produto TEXT NOT NULL,"
            + "quantidade INTEGER NOT NULL,"
            + "valor_unitario REAL NOT NULL,"
            + "FOREIGN KEY(id_pedido) REFERENCES pedido(id)"
            + ");";
    
        try (Connection conn = BrothersDataBase.conexao();
             PreparedStatement ps = conn.prepareStatement(sql);
                ){
            
            ps.executeUpdate();
            return true;
            
        } catch (SQLException e) {
        e.printStackTrace();
            System.out.println("Não foi possivel criar a tabela. Motivo: "+e.getMessage());
            return false;
        
        }
    }
    
    
    
    
    
    
}
