
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
            
            
        } catch (NumberFormatException e){
        return "ERRO AO CADASTRAR O PRODUTO:\n" + e.getMessage();
        } 
        catch (IllegalArgumentException e) {
            return "ERRO AO CADASTRAR O PRODUTO:\n" + e.getMessage();
        }
    
    }
    
    public String atualizarProdutoController(String nome, String descricao, String strPreco,String strId){
        try {
            
             if(nome.trim().isEmpty() && descricao.trim().isEmpty() && strPreco.trim().isEmpty() && strId.isEmpty()){
    throw new IllegalArgumentException(strUtils.formatarTexto("CAMPOS ''NOME'', ''DESCRIÇÃO'', ''PREÇO'' E ''ID'' NÃO PODEM SER VAZIOS."));
        }
            
            if(strId.isEmpty()){
            throw new IllegalArgumentException("CAMPO ''ID'' NÃO PODE SER VAZIO.");
        }
           
            Produto produto = new Produto();
            produto.setNome(nome);
            produto.setDescricao(descricao);
            double preco = Double.parseDouble(strPreco);
            produto.setPreco(preco);
            return produtoService.atualizarProdutoService(produto);
            
        } catch(NumberFormatException e){
        return "NÃO FOI POSSÍVEL ATUALIZAR\nO PRODUTO:\n"  + strUtils.formatarTexto("NOS CAMPOS ''PREÇO'' E ''ID'' NÃO É "
                + "PERMITIDO LETRAS, SOMENTE NÚMEROS.");
        
        }
        catch (IllegalArgumentException e) {
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
