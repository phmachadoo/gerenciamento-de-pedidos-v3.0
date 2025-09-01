
package gerenciamentopedidos.controller;

import gerenciamentopedidos.model.Produto;
import gerenciamentopedidos.service.ProdutosService;
import gerenciamentopedidos.utils.StringUtils;

public class ProdutosController {
    
    ProdutosService produtoService = new ProdutosService();
    StringUtils strUtils = new StringUtils();
    
    public String cadastroProdutoController(String nome, String descricao, String strPreco){
        try {
            if(nome.isEmpty() && descricao.isEmpty() && strPreco.isEmpty()){
            throw new IllegalArgumentException(strUtils.formatarTexto("PREENCHA OS CAMPOS A SEREM CADASTRADOS."));
        }
            
            Produto produto = new Produto();
            produto.setNome(strUtils.formatarTexto(nome));
            produto.setDescricao(strUtils.formatarTexto(descricao));
            double preco = Double.parseDouble(strPreco);
            produto.setPreco(preco);
            return produtoService.cadastroProdutoService(produto);
            
            
        } catch (NumberFormatException e){
        return "ERRO AO CADASTRAR O PRODUTO:\n" + strUtils.formatarTexto("CAMPO ''PREÇO'' ACEITA-SE SOMENTE NÚMEROS.");
        } 
        catch (IllegalArgumentException e) {
            return "ERRO AO CADASTRAR O PRODUTO:\n" + e.getMessage();
        }
    
    }
    
    public String atualizarProdutoController(String nome, String descricao, String strPreco,String strId){
        double preco;
        try {
          if(nome.trim().isEmpty() && descricao.trim().isEmpty() && strPreco.trim().isEmpty()){
         throw new IllegalArgumentException(strUtils.formatarTexto("PREENCHA OS CAMPOS A SEREM ATUALIZADOS."));
        } 
          if(strId.isEmpty()){
            throw new IllegalArgumentException("CAMPO ''ID'' NÃO PODE SER VAZIO.");
        }
         if(strPreco.isEmpty()){
             strPreco = "0.0";
             preco = Double.parseDouble(strPreco);
         }else {
        preco = Double.parseDouble(strPreco);
         
         }
             
            Produto produto = new Produto();
            int id = Integer.parseInt(strId);
            produto.setId(id);
            produto.setNome(nome);
            produto.setDescricao(descricao);
            produto.setPreco(preco);
            return produtoService.atualizarProdutoService(produto);
            
        } catch(NumberFormatException e){
        return "NÃO FOI POSSÍVEL ATUALIZAR\nO PRODUTO:\n"  + strUtils.formatarTexto("NOS CAMPOS ''PREÇO'' E ''ID''"
                + " ACEITA-SE SOMENTE NÚMEROS.");
        
        }
        catch (IllegalArgumentException e) {
            return strUtils.formatarTexto("NÃO FOI POSSIVEL ATUALIZAR O PRODUTO:\n") + e.getMessage();
        }
       
    }
    
    
    public String removerProdutoController(String strId){
    
        try {
            if(strId.isEmpty()){
            throw new IllegalArgumentException(strUtils.formatarTexto("PREENCHA O CAMPO ''ID''."));
            }
            
            Produto produto = new Produto();
            int id = Integer.parseInt(strId);
            produto.setId(id);
            return produtoService.removerProdutoService(produto);
            
            
        } catch(NumberFormatException e){
            return "ERRO AO REMOVER O PRODUTO:\n" +  strUtils.formatarTexto("ACEITA-SE SOMENTE NÚMEROS. TENTE NOVAMENTE");
        }
        catch (IllegalArgumentException e) {
            return strUtils.formatarTexto("NÃO FOI POSSÍVEL REMOVER O PRODUTO:\n") + e.getMessage();
        }
    
    
    
    }
    
    
    public String listarProdutoController(String nome){
     Produto produto = new Produto();
     produto.setNome(nome);
     return produtoService.listarProdutoService(produto);
    
    }
    
    
}
