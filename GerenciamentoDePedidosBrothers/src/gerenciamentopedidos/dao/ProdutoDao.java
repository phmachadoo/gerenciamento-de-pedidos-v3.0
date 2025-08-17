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
    
    
    
}
