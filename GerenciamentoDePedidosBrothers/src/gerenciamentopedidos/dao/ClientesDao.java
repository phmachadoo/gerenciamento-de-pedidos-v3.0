package gerenciamentopedidos.dao;

import gerenciamentopedidos.database.BrothersDataBase;
import gerenciamentopedidos.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClientesDao {
    
    public boolean inserirClientes(Cliente cliente){
    String sql = "INSERT INTO clientes (nome, telefone, email, descricao) VALUES (?, ?, ?, ?);";
    
        try (Connection conn = BrothersDataBase.conexao();
             PreparedStatement ps = conn.prepareStatement(sql);
                ){
            
            ps.setString(1, cliente.getNome());
            ps.setString(2,cliente.getTelefone());
            ps.setString(3,cliente.getEmail());
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
  
      public String listarClientes(String nome){
        ArrayList<Cliente> lista = new ArrayList<>();
          
        String sql;
        boolean condicao = nome.isEmpty();
    
        if(condicao){
        sql = "SELECT * FROM clientes ORDER BY id;";
        }else{
        sql = "SELECT * FROM cliente WHERE nome LIKE ? ORDER BY id;";
        }
        
          try (Connection conn = BrothersDataBase.conexao();
               PreparedStatement ps = conn.prepareStatement(sql)){
              
              if(!condicao){
                  ps.setString(1, "%" + nome + "%");
              }

              
          try (ResultSet rs = ps.executeQuery()){
              
              Cliente cliente = new Cliente();
              
              while(rs.next()){
              cliente.setId(rs.getInt("id")); 
              cliente.setNome(rs.getString("nome"));
              cliente.setTelefone(rs.getString("telefone"));
              cliente.setEmail(rs.getString("email"));
              cliente.setDescricao(rs.getString("descricao"));
              
              
              
                               }
          }
                     
          } catch (SQLException e) {
          e.printStackTrace();
          return "NÃO FOI POSSÍVEL MANTER A CONEXÃO.";
          }
          
          
          
          return sb.toString();
      
      
      }
  
  
    
    
    
    
    
    
    
    
    
    
}
