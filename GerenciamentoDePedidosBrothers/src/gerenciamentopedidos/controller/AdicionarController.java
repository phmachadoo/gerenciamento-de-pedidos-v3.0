
package gerenciamentopedidos.controller;

import gerenciamentopedidos.model.Cliente;
import gerenciamentopedidos.model.Produto;
import gerenciamentopedidos.service.AdicionarService;
import java.util.ArrayList;

public class AdicionarController {
    
    AdicionarService adService = new AdicionarService();
    
    
    
    public ArrayList<Cliente> comboBoxClientesController(ArrayList<Cliente> listaClientesController){
    Cliente cliente = new Cliente();
    adService.comboBoxClientesService(cliente,listaClientesController);
    
    return listaClientesController;
    }
    
    
    
    public String pesquisarClienteController(String clienteFixo, String nome, String email, String telefone, String descricao){
    
        AdicionarService adService = new AdicionarService();
        
        try {
            
                Cliente cliente = new Cliente();
                cliente.setNome(nome);
                cliente.setTelefone(telefone);
                cliente.setEmail(email);
                cliente.setDescricao(descricao);
                
            
         return adService.adicionarClienteService(clienteFixo, cliente);
            
            
            
        } catch (IllegalArgumentException e) {
           return "ERRO:" + e.getMessage();
        }
    
    }
    
    public ArrayList<Produto> comboBoxProdutosController(ArrayList<Produto> listaProdutosController){
    Produto produto = new Produto();
    adService.comboBoxProdutosService(produto, listaProdutosController);
    
    return listaProdutosController;
    
    }
    
    
    
}
