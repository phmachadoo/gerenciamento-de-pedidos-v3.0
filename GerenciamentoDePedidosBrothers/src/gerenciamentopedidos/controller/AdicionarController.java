
package gerenciamentopedidos.controller;

import gerenciamentopedidos.model.Cliente;
import gerenciamentopedidos.model.ItemPedido;
import gerenciamentopedidos.model.Pedido;
import gerenciamentopedidos.model.Produto;
import gerenciamentopedidos.service.AdicionarService;
import java.util.ArrayList;
import java.util.Date;

public class AdicionarController {
    
    AdicionarService adService = new AdicionarService();
    
    
    
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
    
    
    
    
    
    }
    
}
