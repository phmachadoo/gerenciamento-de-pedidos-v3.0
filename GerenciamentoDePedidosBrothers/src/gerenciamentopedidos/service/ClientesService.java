
package gerenciamentopedidos.service;

import gerenciamentopedidos.dao.ClientesDao;
import gerenciamentopedidos.database.ClienteDataBase;
import gerenciamentopedidos.model.Cliente;
import gerenciamentopedidos.view.TelaClientes;


public class ClientesService {
    
    ClientesDao clienteDao = new ClientesDao();
    ClienteDataBase clienteDataBase = new ClienteDataBase();
    
    public String cadastroClienteService(Cliente cliente){
        
        if((cliente.getNome() == null || cliente.getNome().trim().isEmpty()) &&
             (cliente.getTelefone() == null || cliente.getTelefone().trim().isEmpty()) &&
                (cliente.getEmail()== null || cliente.getEmail().trim().isEmpty()) && 
                   (cliente.getDescricao() == null  || cliente.getDescricao().trim().isEmpty())){
            
        throw new IllegalArgumentException("Campos 'NOME', 'TELEFONE', 'EMAIL'\n"
                + "e 'DESCRIÇÃO' não podem ser vazios.");
        
        } else if ((cliente.getTelefone() == null || cliente.getTelefone().trim().isEmpty()) && 
        (cliente.getEmail() == null && cliente.getEmail().trim().isEmpty())) {
        throw new IllegalArgumentException("Campos 'TELEFONE' e 'EMAIL'\nnão podem ser vazios.");
        }
       
        clienteDataBase.clientes();
        clienteDao.inserirClientes(cliente);
        return "Nome: " + cliente.getNome() 
              + "\nTelefone: "+ cliente.getTelefone() + "\nEmail: " + cliente.getEmail()
              + "\nDescrição: " + cliente.getDescricao();  
        
       
    }
    
    
    
    public String listarClienteService(Cliente cliente){
    
    clienteDataBase.clientes();
    return clienteDao.listarClientes(cliente);
    
    }
    
    
    
    
}
