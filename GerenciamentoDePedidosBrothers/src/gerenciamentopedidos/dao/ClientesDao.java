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
            ps.setString(2,cliente.getTelefone());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getDescricao());
            int linhas = ps.executeUpdate();
            return linhas>0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void atualizarCliente(Cliente cliente){
    String sql = "UPDATE cliente SET";
    
    if(cliente.getNome() != null || !cliente.getNome().isEmpty()){
        sql += "nome = ?";
    }
    
    if(cliente.getTelefone() != null || !cliente.getTelefone().isEmpty()){
        sql += ",telefone = ?";
    }
    
    if(cliente.getEmail() == null || cliente.getEmail().isEmpty()){
                    sql = ",email = ?";}
    
    if(cliente.getDescricao() == null || cliente.getDescricao().isEmpty()){
                   sql = ",descricao = ?";
    }
    
    
    
            
            
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
  
      public String listarClientes(String tipoBusca, String filtro, Cliente cliente){
      String sql= "";
      StringBuilder sb = new StringBuilder();
      boolean usarNome = tipoBusca.equalsIgnoreCase("NOME");
      boolean usarID = tipoBusca.equalsIgnoreCase("ID");
      
      
      
      if(usarNome){
      
         if(filtro == "Listar todos"){
          sql = "SELECT * FROM clientes ORDER BY id;";
         }else{
          sql = "SELECT * FROM clientes WHERE nome LIKE ? ORDER BY id;";
         }
      
      } else if(usarID){
      sql = "SELECT * FROM clientes WHERE id = ?;";
      }
      
      
      
          try (Connection conn = BrothersDataBase.conexao();
               PreparedStatement ps = conn.prepareStatement(sql)){
              
              if(filtro == "Listar filtrado"){
                  ps.setString(1, "%" + cliente.getNome() + "%");
              } else if(filtro == "Listar Id"){
              ps.setInt(1, cliente.getId());
              } 
              
          try (ResultSet rs = ps.executeQuery()){
              
              while(rs.next()){
              int id = rs.getInt("id");
              String nome = rs.getString("nome");
              String telefone = rs.getString("telefone");
              String email = rs.getString("email");
              String descricao = rs.getString("descricao");
              
               sb.append("ID: " + id + " | NOME: " + nome +
                       "\nTELEFONE: " + telefone + "\nEMAIL: " + email +
                       "\nDESCRIÇÃO: " + descricao +"\n\n");
                               }
          }
                     
          } catch (SQLException e) {
          e.printStackTrace();
          return "NÃO FOI POSSÍVEL MANTER A CONEXÃO.";
          }
          
      return sb.toString();
      
      }
  
  
    
    
    
    
    
    
    
    
    
    
}
