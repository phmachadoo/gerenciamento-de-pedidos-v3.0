
package gerenciamentopedidos.controller;

import gerenciamentopedidos.model.Cliente;
import gerenciamentopedidos.service.ClientesService;

public class ClientesController {
    
    ClientesService clienteService = new ClientesService();
    
    
    public String cadastroClienteController(String nome, String telefone, String email, String descricao){
        try {
             Cliente clientes = new Cliente(nome,telefone,email,descricao);
             return clienteService.cadastroClienteService(clientes);
            
        } catch (IllegalArgumentException e) {
            return "Erro ao cadastrar o cliente:\n" + e.getMessage();
        }
    
    }
    
    
    public String listarClienteController(String nome){
        try {
            Cliente clientes = new Cliente();
            clientes.setNome(nome);
            return clienteService.listarClienteService(clientes);
            
            
        } catch (IllegalArgumentException e) {
            return "Erro ao listar cliente(s):\n" + e.getMessage();
        }
    
    
    }
    
    
    public String removerClienteController(String strId){
        try {
            if(strId.isEmpty()){
            return "Campo 'ID' não pode ser vazio.";
        }
            
            Cliente clientes = new Cliente();
            int id = Integer.parseInt(strId);
            clientes.setId(id);
            return clienteService.removerClienteService(clientes);
            
            
        } catch (NumberFormatException e) {
        return "Dados inválidos.\nAceita-se somente números.";
        }
    
    }
    
    
    
    
    
    
    
}
