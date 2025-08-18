/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciamentopedidos.service;

import gerenciamentopedidos.dao.ProdutoDao;
import gerenciamentopedidos.database.ProdutoDataBase;
import gerenciamentopedidos.model.Produto;
import gerenciamentopedidos.utils.StringUtils;
import java.util.ArrayList;

public class ProdutosService {
ProdutoDataBase produtoDataBase = new ProdutoDataBase();
ProdutoDao produtoDao = new ProdutoDao();
StringUtils strUtils = new  StringUtils();
public String cadastroProdutoService(Produto produto){
    if(produto.getNome().trim().isEmpty()){
        throw new IllegalArgumentException(strUtils.formatarTexto("CAMPO 'NOME' NÃO PODE ESTAR VAZIO."));
    }

    
    produtoDataBase.produto();
    produtoDao.cadastroProduto(produto);
    return "PRODUTO: " + produto.getNome()+ "\n"
        + "DESCRIÇÃO: " + produto.getDescricao() + "\n"
        + "PREÇO: " + produto.getPreco();

}




public String atualizarProdutoService(Produto produto){
ArrayList condicao = new ArrayList<>();

    condicao.add(produto.getNome().isEmpty());
    condicao.add(produto.getDescricao().isEmpty());
    condicao.add(produto.getPreco() == 0.0);

    produtoDataBase.produto();
    produtoDao.atualizarProduto(condicao,produto);

    return "ID: " + produto.getId() +" | NOME: " + produto.getNome() 
              + "\nDESCRIÇÃO: " + produto.getDescricao() + 
                "\nPREÇO: " + produto.getPreco();
}



    
public String listarProdutoService(Produto produto){
String filtro;
boolean condicao = produto.getNome().trim().isEmpty();
ArrayList<Produto> listaProduto = new ArrayList<>();
StringBuilder sb = new StringBuilder();

    if(condicao){
    filtro = "Listar todos";
    }else{
    filtro = "Listar filtrado";
    }

    produtoDataBase.produto();
    produtoDao.listarProduto("NOME",filtro,produto,listaProduto);

    for (int i = 0; i < listaProduto.size(); i++) {
        sb.append("ID: " + listaProduto.get(i).getId()+ " | NOME: " + listaProduto.get(i).getNome()+
                "\nDESCRIÇÃO: " + listaProduto.get(i).getDescricao() +
                "\nPREÇO: " + listaProduto.get(i).getPreco() + "\n\n"
                );
    }
    
    return sb.toString();

}


}
