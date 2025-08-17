/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciamentopedidos.service;

import gerenciamentopedidos.dao.ProdutoDao;
import gerenciamentopedidos.database.ProdutoDataBase;
import gerenciamentopedidos.model.Produto;

public class ProdutosService {
ProdutoDataBase produtoDataBase = new ProdutoDataBase();
ProdutoDao produtoDao = new ProdutoDao();

public String cadastroProdutoService(Produto produto){
    if(produto.getNome().trim().isEmpty()){
        throw new IllegalArgumentException("CAMPO 'NOME'\nNÃO PODE ESTAR VAZIO.");
    
    }

    
    produtoDataBase.produto();
    produtoDao.cadastroProduto(produto);
    return "PRODUTO: " + produto.getNome()+ "\n"
        + "DESCRIÇÃO: " + produto.getDescricao() + "\n"
        + "PREÇO: " + produto.getPreco();

}

    
}
