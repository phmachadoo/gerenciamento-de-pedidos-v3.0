
package gerenciamentopedidos.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDataBase {
    public static boolean clientes(){
    String sql = "CREATE TABLE IF NOT EXISTS clientes("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "nome TEXT NOT NULL,"
            + "email TEXT DEFAULT '',"
            + "telefone TEXT NOT NULL UNIQUE,"
            + "descricao TEXT DEFAULT '',"
            + "total_pedidos INTEGER NOT NULL DEFAULT 0"
            + ");";
    
        try(Connection conn = BrothersDataBase.conexao();
            PreparedStatement ps = conn.prepareStatement(sql);
                ) {
            
            ps.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Não foi possivel criar a tabela clientes. Motivo: " + e.getMessage());
            return false;
        }
    
    
    }
    
}
