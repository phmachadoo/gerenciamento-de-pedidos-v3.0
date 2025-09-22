
package gerenciamentopedidos.controller;

import gerenciamentopedidos.model.Cliente;
import gerenciamentopedidos.model.ItemPedido;
import gerenciamentopedidos.model.Pedido;
import gerenciamentopedidos.model.Produto;
import gerenciamentopedidos.service.AdicionarService;
import gerenciamentopedidos.utils.StringUtils;
import java.util.ArrayList;
import java.util.Date;

public class AdicionarController {
    
    AdicionarService adService = new AdicionarService();
    StringUtils sUtils = new StringUtils();
    
    
    public ArrayList<Cliente> comboBoxClientesController(ArrayList<Cliente> listaClientesController){
    Cliente cliente = new Cliente();
    adService.comboBoxClientesService(cliente,listaClientesController);
    
    return listaClientesController;
    }
    
    
    public ArrayList<Produto> comboBoxProdutosController(ArrayList<Produto> listaProdutosController){
    Produto produto = new Produto();
    adService.comboBoxProdutosService(produto, listaProdutosController);
    
    return listaProdutosController;
    
    }
    
    
    public String adicionarCarrinhoController(String nome, String telefone, String email, String descricao, String tipoServico,
            String quantidade, String preco, String descricaoPedido, Date data){
        
        try {
            
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setEmail(email);
        cliente.setDescricao(descricao);
        
        if(cliente.getNome().trim().isEmpty() &&
              cliente.getTelefone().trim().isEmpty() &&
                cliente.getEmail().trim().isEmpty() && 
                    cliente.getDescricao().trim().isEmpty()){
    throw new IllegalArgumentException("PREENCHA OS CAMPOS DE 'CLIENTE'.");
    }
    
    else if(cliente.getNome().trim().isEmpty()){
        throw new IllegalArgumentException("CAMPO ''NOME'' NÃO PODE SER VAZIO.");
        } 
       
    else if (cliente.getTelefone().trim().isEmpty() && 
         cliente.getEmail().trim().isEmpty()) {
        throw new IllegalArgumentException(sUtils.formatarTexto("CAMPOS ''TELEFONE'' OU ''EMAIL'' NÃO PODEM SER VAZIOS."));
        }
        
        int quantidades = Integer.parseInt(quantidade);
        double valor = Double.parseDouble(preco);
        
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setNomeProduto(tipoServico);
        itemPedido.setQuantidade(quantidades);
        itemPedido.setPreco(valor);
        itemPedido.setDescricao(descricaoPedido);
        itemPedido.setDate(data);
        
        if(itemPedido.getNomeProduto().equalsIgnoreCase("selecione um produto")){
              throw new IllegalArgumentException("SELECIONE UM PRODUTO VÁLIDO");
        }   
        
        return adService.adicionarCarrinhoService(cliente, itemPedido);
            
        } catch (NumberFormatException e) {
            return "NÃO FOI POSSÍVEL ADICIONAR AO CARRINHO:\n"
                    + sUtils.formatarTexto("CAMPOS 'QUANTIDADE' E 'PREÇO' DEVEM CONTER NÚMEROS.") ;
        } catch (Exception e){
            return "NÃO FOI POSSÍVEL ADICIONAR AO CARRINHO:\n" + e.getMessage();  
        }
        
    
    }
    
    
    
    
    public String finalizarPedidoController(String nome, String telefone, String email, String descricao, String tipoServico,
            String descricaoProduto, String quantidade, String preco, String descricaoPedido, Date data){
        
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setEmail(email);
        cliente.setDescricao(descricao);
        
        try {
            
        int quantidad = Integer.parseInt(quantidade);
        double valor = Double.parseDouble(preco);
        
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setNomeProduto(tipoServico);
        itemPedido.setDescricao(descricaoProduto);
        itemPedido.setQuantidade(quantidad);
        itemPedido.setPreco(valor);
        itemPedido.setDescricao(descricaoPedido);
        
        double valorTotal = itemPedido.getPreco()*itemPedido.getQuantidade();
        
        
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setValorTotal(valor);
        
            
        } catch (Exception e) {
        }
        
        
        
        
        
    return "";
    
    
    
    }
    
   
    public boolean zerarCarrinho(){
    
    
    
    
    return true;
    }
    
}
