
package gerenciamentopedidos.controller;

import gerenciamentopedidos.model.Cliente;
import gerenciamentopedidos.service.ClientesService;
import gerenciamentopedidos.utils.StringUtils;

public class ClientesController {
    
    ClientesService clienteService = new ClientesService();
    StringUtils sUtils = new StringUtils();
    
    public String cadastroClienteController(String nome, String telefone, String email, String descricao){
        try {
            
             Cliente clientes = new Cliente();
             clientes.setNome(sUtils.formatarTexto(nome));
             clientes.setTelefone(telefone);
             clientes.setEmail(email);
             clientes.setDescricao(sUtils.formatarTexto(descricao));
             return clienteService.cadastroClienteService(clientes);
            
        } catch (IllegalArgumentException e) {
            return "ERRO AO CADASTRAR O CLIENTE:\n" + e.getMessage();
        }
    
    }
    
    
    public String atualizarClienteController(String strId, String nome, String telefone, String email, String descricao){
    
    
        try {
            if(strId.isEmpty()){
            throw new NumberFormatException("CAMPO 'ID' NÃO PODE SER VAZIO.");
        }
            if (!strId.matches("\\d+")) {
            throw new IllegalArgumentException("CAMPO 'ID' DEVE CONTER\nSOMENTE NÚMEROS.");
        }
            
            Cliente clientes = new Cliente();
            int id = Integer.parseInt(strId);
            clientes.setId(id);
            clientes.setNome(sUtils.formatarTexto(nome));
            clientes.setTelefone(telefone);
            clientes.setEmail(email);
            clientes.setDescricao(sUtils.formatarTexto(descricao));
            return clienteService.atualizarClienteService(clientes);
            
            
            
        } catch(NumberFormatException e){
            return "NÃO FOI POSSÍVEL ATUALIZAR O CLIENTE:\n"
                    + e.getMessage();
        
        }
        catch (IllegalArgumentException e) {
            return "ERRO AO ATUALIZAR O CLIENTE:\n" + e.getMessage();
        }

        
    }
    
    
    public String listarClienteController(String nome){
            Cliente clientes = new Cliente();
            clientes.setNome(nome);
            return clienteService.listarClienteService(clientes);
    
    }
    
    
    public String removerClienteController(String strId){
        try {
            if(strId.isEmpty()){
            throw new NumberFormatException("CAMPO 'ID' NÃO PODE SER VAZIO.");
        }
            
            Cliente clientes = new Cliente();
            int id = Integer.parseInt(strId);
            clientes.setId(id);
            return clienteService.removerClienteService(clientes);
            
            
        } catch (NumberFormatException e) {
        return "ERRO AO REMOVER O(A) CLIENTE:\n" + e.getMessage();
        }
    
    }
    
    
    
    
    
    
    
}
