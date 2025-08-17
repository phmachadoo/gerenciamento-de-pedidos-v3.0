
package gerenciamentopedidos.controller;

import gerenciamentopedidos.model.Produto;
import gerenciamentopedidos.service.ProdutosService;

public class ProdutosController {
    
    ProdutosService produtoService = new ProdutosService();
    
    public String cadastroProdutoController(String nome, String descricao, String strPreco){
        try {
            if(strPreco.isEmpty()){
            throw new NumberFormatException("CAMPO 'PREÇO' NÃO PODE SER VAZIO.");
        }
            if (!strPreco.matches("\\d+(\\.\\d+)?")) {
            throw new IllegalArgumentException("CAMPO 'PREÇO' DEVE CONTER\nUM NÚMERO VÁLIDO (ex: 10 ou 10.50).");
            }
            
            Produto produto = new Produto();
            produto.setNome(nome);
            produto.setDescricao(descricao);
            double preco = Double.parseDouble(strPreco);
            produto.setPreco(preco);
            return produtoService.cadastroProdutoService(produto);
            
        } catch (IllegalArgumentException e) {
            return "ERRO AO CADASTRAR O PRODUTO:\n" + e.getMessage();
        }
    
    }
    
    
    
    
}
