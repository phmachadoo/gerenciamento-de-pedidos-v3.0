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
import javax.swing.JOptionPane;

public class ProdutosService {
ProdutoDataBase produtoDataBase = new ProdutoDataBase();
ProdutoDao produtoDao = new ProdutoDao();
StringUtils strUtils = new  StringUtils();

public String cadastroProdutoService(Produto produto){
    //DEIXAR O NOME COM LETRAS MAIÚSCULAS
    if(produto.getNome().trim().isEmpty()){
        throw new IllegalArgumentException(strUtils.formatarTexto("CAMPO 'NOME' NÃO PODE ESTAR VAZIO."));
    }

    if(produto.getNome().length() > 30){
    throw new IllegalArgumentException("CAMPO 'NOME' NÃO PODE EXCEDER A 30 CARACTERES.");
    
    }
    
    produtoDataBase.produto();
    produtoDao.cadastroProduto(produto);
    return "PRODUTO: " + produto.getNome()+ "\n"
        + "DESCRIÇÃO: " + produto.getDescricao() + "\n"
        + "PREÇO: " + produto.getPreco();

}


public String atualizarProdutoService(Produto produto){
ArrayList<Boolean> condicao = new ArrayList<>();
ArrayList<Produto> listaProduto = new ArrayList<>();
StringBuilder sb = new StringBuilder();

    condicao.add(produto.getNome().isEmpty());
    condicao.add(produto.getDescricao().isEmpty());
    condicao.add(produto.getPreco() == 0.0);

    if(produto.getNome().length() >= 20){
    throw new IllegalArgumentException("CAMPO 'NOME' NÃO PODE EXCEDER A 16 CARACTERES.");
    
    }
    
    produtoDataBase.produto();
    produtoDao.atualizarProduto(condicao,produto);
    produtoDao.listarProduto("ID", "Listar Id", produto, listaProduto);
    
    if(!listaProduto.isEmpty()){
        
    for (int i = 0; i < listaProduto.size(); i++) {
        sb.append("ID: " + listaProduto.get(i).getId() +" | NOME: " + listaProduto.get(i).getNome() 
              + "\nDESCRIÇÃO: " + listaProduto.get(i).getDescricao() + 
                "\nPREÇO: " + listaProduto.get(i).getPreco());}
    
    return sb.toString();
    } else { throw new IllegalArgumentException(strUtils.formatarTexto("PRODUTO NÃO ENCONTRADO."));} 
    
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

public String removerProdutoService(Produto produto){
    String resultado = "";
    ArrayList<Produto> listaProdutos = new ArrayList<>();
    
       ProdutoDataBase.produto();
       if(!produtoDao.listarProduto("ID", "Listar Id", produto,listaProdutos).isEmpty()){
           
           int resposta = JOptionPane.showConfirmDialog(
            null,
            "TEM CERTEZA QUE DESEJA REMOVER O PRODUTO?",
            "CONFIRMAÇÃO",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
           
           if (resposta == JOptionPane.YES_OPTION) {
            produtoDao.removerProduto(produto);
            resultado = "PRODUTO REMOVIDO COM SUCESSO.";
            
            } else if (resposta == JOptionPane.NO_OPTION){
            
            resultado = "NÃO FOI POSSÍVEL REMOVER O PRODUTO.";
            
            }
            
             
        } else {
           resultado = "ID NÃO ENCONTRADO.\nPOR FAVOR, TENTE NOVAMENTE.";
       }
       
       return resultado;

}


}
