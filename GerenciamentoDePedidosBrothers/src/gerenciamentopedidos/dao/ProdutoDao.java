/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciamentopedidos.dao;
import gerenciamentopedidos.database.BrothersDataBase;
import gerenciamentopedidos.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import gerenciamentopedidos.model.Produto;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutoDao {
    
    public boolean cadastroProduto(Produto produto){
    String sql = "INSERT INTO produto (nome, descricao, preco) VALUES (?,?,?);";
    
        try (Connection conn = BrothersDataBase.conexao();
              PreparedStatement ps = conn.prepareStatement(sql)){
            
            ps.setString(1,produto.getNome());
            ps.setString(2, produto.getDescricao());
            ps.setDouble(3, produto.getPreco());
            int linhas = ps.executeUpdate();
            return linhas>0;
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    
    }
    
    
    public ArrayList<Produto> listarProduto(String tipoBusca, String filtro,
            Produto produto, ArrayList<Produto> listaProdutos){
        
        String sql= "";
      boolean usarNome = tipoBusca.equalsIgnoreCase("NOME");
      boolean usarID = tipoBusca.equalsIgnoreCase("ID");
      
      
      if(usarNome){
         if(filtro == "Listar todos"){
          sql = "SELECT * FROM produto ORDER BY id;";
         }else{
          sql = "SELECT * FROM produto WHERE nome LIKE ? ORDER BY id;";
         }
      
      } else if(usarID){
      sql = "SELECT * FROM produto WHERE id = ?;";
      }
      
       try (Connection conn = BrothersDataBase.conexao();
               PreparedStatement ps = conn.prepareStatement(sql)){
              
              if(filtro == "Listar filtrado"){
                  ps.setString(1, "%" + produto.getNome() + "%");
              } else if(filtro == "Listar Id"){
              ps.setInt(1, produto.getId());
              } 
              
          try (ResultSet rs = ps.executeQuery()){
              while(rs.next()){
              Produto objProduto = new Produto();    
              objProduto.setId(rs.getInt("id"));
              objProduto.setNome(rs.getString("nome"));
              objProduto.setDescricao(rs.getString("descricao"));
              objProduto.setPreco(rs.getDouble("preco"));

              listaProdutos.add(objProduto);
                               }
          }
                     
          } catch (SQLException e) {
          e.printStackTrace();
          }
          
      return listaProdutos;
      
      
        
    
    }
    
    
    
    
}
