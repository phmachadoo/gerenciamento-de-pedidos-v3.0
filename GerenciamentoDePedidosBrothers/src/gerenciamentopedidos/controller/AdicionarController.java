
package gerenciamentopedidos.controller;

import gerenciamentopedidos.model.Cliente;
import gerenciamentopedidos.service.AdicionarService;

public class AdicionarController {
    
    
    public String adicionarClienteController(String clienteFixo, String nome, String email, String telefone, String descricao){
    
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
    
    
    
    
}
