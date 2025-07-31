
package gerenciamentopedidos.service;

import gerenciamentopedidos.dao.ClientesDao;
import gerenciamentopedidos.database.ClienteDataBase;
import gerenciamentopedidos.model.Cliente;
import gerenciamentopedidos.view.TelaClientes;


public class ClientesService {
    
    ClientesDao clienteDao = new ClientesDao();
    ClienteDataBase clienteDataBase = new ClienteDataBase();
    
    public String cadastroClienteService(Cliente cliente){
        
        if(cliente.getNome().trim().isEmpty()){
            
        throw new IllegalArgumentException("Campos 'NOME''\n"
                + "não pode ser vazio.");
        
        } else if (cliente.getTelefone().trim().isEmpty() && 
                   cliente.getEmail().trim().isEmpty()) {
        throw new IllegalArgumentException("Campos 'TELEFONE' e 'EMAIL'\nnão podem ser vazios.");
        }
       
        clienteDataBase.clientes();
        clienteDao.inserirClientes(cliente);
        
        return "Nome: " + cliente.getNome() 
              + "\nTelefone: "+ cliente.getTelefone() + "\nEmail: " + cliente.getEmail()
              + "\nDescrição: " + cliente.getDescricao();  
        
       
    }
    
    
    
    public String listarClienteService(String nome){
    String sql;
    boolean condicao = nome.isEmpty();
    
    if(condicao){
    sql = "SELECT * FROM clientes ORDER BY id;";
    }else{
    sql = "SELECT * FROM cliente WHERE nome LIKE ? ORDER BY id;";
    }
    
        
    clienteDataBase.clientes();
    return clienteDao.listarClientes(sql, condicao, nome);
    
    }
    
    
    
    
}
