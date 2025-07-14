
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
            + "telefone TEXT DEFAULT '',"
            + "descricao TEXT DEFAULT '',"
            + "total_pedidos INTEGER DEFAULT 0"
            + ");";
    
            //mudar as configurações da tabela
        try(Connection conn = BrothersDataBase.conexao();
            PreparedStatement ps = conn.prepareStatement(sql);
                ) {
            
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Não foi possivel criar a tabela clientes. Motivo: " + e.getMessage());
            return false;
        }
    }
    
}
