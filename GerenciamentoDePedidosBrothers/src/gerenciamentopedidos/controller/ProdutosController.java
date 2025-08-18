
package gerenciamentopedidos.controller;

import gerenciamentopedidos.model.Produto;
import gerenciamentopedidos.service.ProdutosService;
import gerenciamentopedidos.utils.StringUtils;

public class ProdutosController {
    
    ProdutosService produtoService = new ProdutosService();
    StringUtils strUtils = new StringUtils();
    
    public String cadastroProdutoController(String nome, String descricao, String strPreco){
        try {
            if(strPreco.isEmpty()){
            throw new NumberFormatException(strUtils.formatarTexto("CAMPO 'PREÇO' NÃO PODE SER VAZIO."));
        }
            if (!strPreco.matches("\\d+(\\.\\d+)?")) {
            throw new IllegalArgumentException(
                    strUtils.formatarTexto("CAMPO 'PREÇO' DEVE CONTER UM NÚMERO VÁLIDO (ex: 10 ou 10.50)."));
            }
            
            Produto produto = new Produto();
            produto.setNome(strUtils.formatarTexto(nome));
            produto.setDescricao(strUtils.formatarTexto(descricao));
            double preco = Double.parseDouble(strPreco);
            produto.setPreco(preco);
            return produtoService.cadastroProdutoService(produto);
            
        } catch (IllegalArgumentException e) {
            return strUtils.formatarTexto("ERRO AO CADASTRAR O PRODUTO:\n") + e.getMessage();
        }
    
    }
    
    public String atualizarProdutoController(String nome, String descricao, String strPreco){
        try {
            if(strPreco.isEmpty()){
            throw new NumberFormatException(strUtils.formatarTexto("CAMPO 'PREÇO' NÃO PODE SER VAZIO."));
        }
            if(!strPreco.matches("\\d+(\\.\\d+)?")) {
            throw new IllegalArgumentException(strUtils.formatarTexto("CAMPO 'PREÇO' DEVE CONTER UM NÚMERO VÁLIDO (ex: 10 ou 10.50)."));
            }
            
                return "";
        } catch (IllegalArgumentException e) {
            return strUtils.formatarTexto("NÃO FOI POSSIVEL ATUALIZAR O PRODUTO:\n") + e.getMessage();
        }

    }
    
    
    //public String removerProdutoController(){}
    
    
    
    
    
    
    public String listarProdutoController(String nome){
     Produto produto = new Produto();
     produto.setNome(nome);
     return produtoService.listarProdutoService(produto);
    
    }
    
    
}
