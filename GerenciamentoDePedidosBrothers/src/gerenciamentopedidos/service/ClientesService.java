
package gerenciamentopedidos.service;

import gerenciamentopedidos.dao.ClientesDao;
import gerenciamentopedidos.database.ClienteDataBase;
import gerenciamentopedidos.model.Cliente;
import gerenciamentopedidos.view.TelaClientes;
import javax.swing.JOptionPane;


public class ClientesService {
    
    ClientesDao clienteDao = new ClientesDao();
    ClienteDataBase clienteDataBase = new ClienteDataBase();
    
    public String cadastroClienteService(Cliente cliente){
        
        if( cliente.getNome().trim().isEmpty() &&
              cliente.getTelefone().trim().isEmpty() &&
                cliente.getEmail().trim().isEmpty() && 
                    cliente.getDescricao().trim().isEmpty()){
            
        throw new IllegalArgumentException("Campos 'NOME', 'TELEFONE', 'EMAIL'\n"
                + "e 'DESCRIÇÃO' não podem ser vazios.");
        
        } else if ( cliente.getTelefone().trim().isEmpty() && 
         cliente.getEmail().trim().isEmpty()) {
        throw new IllegalArgumentException("Campos 'TELEFONE' e 'EMAIL'\nnão podem ser vazios.");
        }
       
        clienteDataBase.clientes();
        clienteDao.inserirClientes(cliente);
        return "Nome: " + cliente.getNome() 
              + "\nTelefone: "+ cliente.getTelefone() + "\nEmail: " + cliente.getEmail()
              + "\nDescrição: " + cliente.getDescricao();  
        
       
    }
    
    
    
    public String listarClienteService(Cliente cliente){
    String filtro;
    boolean condicao = cliente.getNome().isEmpty(); 
    
    if(condicao){
    filtro = "Listar todos";
    } else {
    filtro = "Listar filtrado";
    }
        
    clienteDataBase.clientes();
    return clienteDao.listarClientes("NOME", filtro, cliente);
    
    }
    
    
    public String removerClienteService(Cliente cliente){
        
    String resultado = "";
       
       clienteDataBase.clientes();
       if(!clienteDao.listarClientes("ID", "Listar Id", cliente).isEmpty()){
           
           int resposta = JOptionPane.showConfirmDialog(
            null,
            "Tem certeza que deseja remover o cliente?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
           
           if (resposta == JOptionPane.YES_OPTION) {
            clienteDao.removerClientes(cliente);
            resultado = "Cliente removido com sucesso.";
            
            } else if (resposta == JOptionPane.NO_OPTION){
            
            resultado = "Não foi possível remover o cliente.";
            
            }
            
             
        } else {
           resultado = "Id não encontrado.\nPor favor, tente novamente.";
       }
       
       return resultado;

}
    
    
    
    
}
