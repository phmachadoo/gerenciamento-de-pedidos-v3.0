/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciamentopedidos.dao;
import gerenciamentopedidos.database.BrothersDataBase;
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
    
    
    public boolean atualizarProduto(ArrayList<Boolean> condicao,Produto produto){
    ArrayList<String> valores = new ArrayList<>();
    String sql = "UPDATE produto SET ";
    String[] colunas = {"nome","descricao", "preco"};
    String strPreco = String.valueOf(produto.getPreco());
        for (int i = 0; i < condicao.size(); i++) {
            
            if(!condicao.get(i)){
            sql += colunas[i] + " = ?,";
            
            switch(i){
                case 0 -> valores.add(produto.getNome());
                case 1 -> valores.add(produto.getDescricao());
                case 2 -> valores.add(strPreco);
            
            }
            
            }
            
        }
      
            sql = sql.substring(0, sql.length() - 1);
            sql += " WHERE id = ?;";
             System.out.println(sql);
        try(Connection conn = BrothersDataBase.conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            int contador = 1;
            
           for(String valor : valores){
           ps.setString(contador++, valor);
           }
            
            ps.setInt(contador++,produto.getId());
            
            int linhas = ps.executeUpdate();
            return linhas>0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
            
            
    }
    
    public boolean removerProduto(Produto produto){
      String sql = "DELETE FROM produto WHERE id = ?;";
      
      try (Connection conn = BrothersDataBase.conexao();
           PreparedStatement ps = conn.prepareStatement(sql)){
          
          ps.setInt(1, produto.getId());
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
