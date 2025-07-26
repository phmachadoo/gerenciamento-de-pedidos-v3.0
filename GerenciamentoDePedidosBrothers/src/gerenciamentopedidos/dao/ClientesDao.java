package gerenciamentopedidos.dao;

import gerenciamentopedidos.database.BrothersDataBase;
import gerenciamentopedidos.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ClientesDao {
    
    public boolean inserirClientes(Cliente cliente){
    String sql = "INSERT INTO clientes (nome, telefone, email, descricao) VALUES (?, ?, ?, ?);";
    
        try (Connection conn = BrothersDataBase.conexao();
             PreparedStatement ps = conn.prepareStatement(sql);
                ){
            
            ps.setString(1, cliente.getNome());
            ps.setString(2,cliente.getEmail());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4, cliente.getDescricao());
            int linhas = ps.executeUpdate();
            return linhas>0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void atualizarCliente(){
    String sql = "UPDATE clientes SET"; //nome = ? AND email = ? AND telefone = ?";
            
            
    }
    
    
    
  public boolean removerClientes(Cliente cliente){
      String sql = "DELETE FROM clientes WHERE id = ?;";
      
      try (Connection conn = BrothersDataBase.conexao();
           PreparedStatement ps = conn.prepareStatement(sql);){
          
          ps.setInt(1, cliente.getId());
          int linhas = ps.executeUpdate();
          return linhas>0;
          
      } catch (SQLException e) {
          e.printStackTrace();
          return false;
      }
  }
  
      public String listarClientes(Cliente cliente){
      String sql = "SELECT * FROM clientes WHERE nome = ?;";
      StringBuilder sb = new StringBuilder();
          try (Connection conn = BrothersDataBase.conexao();
               PreparedStatement ps = conn.prepareStatement(sql);
               ResultSet rs = ps.executeQuery();
                  ){
              
              ps.setString(1, cliente.getNome());
              
              while(rs.next()){
              cliente.setId(rs.getInt("id"));
              cliente.setNome(rs.getString("nome"));
              cliente.setEmail(rs.getString("email"));
              cliente.setTelefone(rs.getString("telefone"));
              cliente.setDescricao(rs.getString("descricao"));
              cliente.setTotalPedidos(rs.getInt("total_pedidos"));
              
      sb.append("ID: " + cliente.getId() + " | NOME: " + cliente.getNome() + "\nEMAIL: " + cliente.getEmail() +
      " | TEL: " + cliente.getTelefone() + "\nDESCRIÇÃO: " + cliente.getDescricao());
              }
              
          } catch (SQLException e) {
          e.printStackTrace();
          return "NÃO FOI POSSÍVEL MANTER A CONEXÃO.";
          }
          
      return sb.toString();
      
      
      }
  
  
    
    
    
    
    
    
    
    
    
    
}
