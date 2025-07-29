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
      StringBuilder sb = new StringBuilder();
      String sql;
      boolean condicao = cliente.getNome() == null || cliente.getNome().isEmpty();
      
      if(condicao){
          sql= "SELECT * FROM clientes ORDER BY id;";
         }else{
          sql = "SELECT * FROM clientes WHERE nome LIKE ? ORDER BY id;";
         }
      
          try (Connection conn = BrothersDataBase.conexao();
               PreparedStatement ps = conn.prepareStatement(sql)){
              
              if(!condicao){
                  ps.setString(1, "%" + cliente.getNome() + "%");
              }

              
          try (ResultSet rs = ps.executeQuery()){
              
              while(rs.next()){
              int id = rs.getInt("id");
              String nome = rs.getString("nome");
              String email = rs.getString("email");
              String telefone = rs.getString("telefone");
              String descricao = rs.getString("descricao");
              
               sb.append("ID: " + id + " | NOME: " + nome +
                       "\nEMAIL: " + email + "\nTELEFONE: " + telefone + "\nDESCRIÇÃO: " + descricao +"\n\n");
                               }
          }
                     
          } catch (SQLException e) {
          e.printStackTrace();
          return "NÃO FOI POSSÍVEL MANTER A CONEXÃO.";
          }
          
      return sb.toString();
      
      }
  
  
    
    
    
    
    
    
    
    
    
    
}
