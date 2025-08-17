
package gerenciamentopedidos.service;

import gerenciamentopedidos.dao.ClientesDao;
import gerenciamentopedidos.database.ClienteDataBase;
import gerenciamentopedidos.model.Cliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ClientesService {
    
    ClientesDao clienteDao = new ClientesDao();
    ClienteDataBase clienteDataBase = new ClienteDataBase();
    
    public String cadastroClienteService(Cliente cliente){
        
        if(cliente.getNome().trim().isEmpty() &&
              cliente.getTelefone().trim().isEmpty() &&
                cliente.getEmail().trim().isEmpty() && 
                    cliente.getDescricao().trim().isEmpty()){
            
        throw new IllegalArgumentException("CAMPOS ''NOME'', ''TELEFONE'', ''EMAIL''\n"
                + "E ''DESCRIÇÃO'' NÃO PODEM SER VAZIOS.");
        
        }   else if(cliente.getNome().trim().isEmpty()){
        
        throw new IllegalArgumentException("CAMPO ''NOME'' NÃO PODE SER VAZIO.");
        } 
        
        
        
        else if (cliente.getTelefone().trim().isEmpty() && 
         cliente.getEmail().trim().isEmpty()) {
        throw new IllegalArgumentException("CAMPOS ''TELEFONE'' E ''EMAIL''\nNÃO PODEM SER VAZIOS.");
        }
       
        clienteDataBase.clientes();
        clienteDao.inserirClientes(cliente);
         return "NOME: " + cliente.getNome() 
              + "\nTELEFONE: "+ cliente.getTelefone() + "\nEMAIL: " + cliente.getEmail()
              + "\nDESCRIÇÃO: " + cliente.getDescricao(); 
        
       
    }
    
    
    public String atualizarClienteService(Cliente cliente){
    ArrayList condicao = new ArrayList<>();
    
     if(cliente.getNome().trim().isEmpty() &&
              cliente.getTelefone().trim().isEmpty() &&
                cliente.getEmail().trim().isEmpty() && 
                    cliente.getDescricao().trim().isEmpty()){
     throw new IllegalArgumentException("CAMPOS ''NOME'', ''TELEFONE'', ''EMAIL'' E ''DESCRIÇÃO''\n"
             + "NÃO PODEM SER VAZIOS.");
     }
    
            condicao.add(cliente.getNome().trim().isEmpty());
            condicao.add(cliente.getTelefone().trim().isEmpty());
            condicao.add(cliente.getEmail().trim().isEmpty());
            condicao.add(cliente.getDescricao().trim().isEmpty());
     
     
     clienteDataBase.clientes();
     clienteDao.atualizarCliente(condicao, cliente);
     
    return "ID: " + cliente.getId() +" | NOME: " + cliente.getNome() 
              + "\nTELEFONE: "+ cliente.getTelefone() + "\nEMAIL: " + cliente.getEmail()
              + "\nDESCRIÇÃO: " + cliente.getDescricao();
    }



    
    public String listarClienteService(Cliente cliente){
    String filtro;
    boolean condicao = cliente.getNome().isEmpty(); 
    ArrayList<Cliente> listaClientes = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    
    if(condicao){
    filtro = "Listar todos";
    } else {
    filtro = "Listar filtrado";
    }
        
    clienteDataBase.clientes();
    clienteDao.listarClientes("NOME", filtro, cliente,listaClientes);
    
        for (int i = 0; i < listaClientes.size(); i++) {
            sb.append("ID: " + listaClientes.get(i).getId() + " | NOME: " + listaClientes.get(i).getNome() 
              + "\nTELEFONE: "+ listaClientes.get(i).getTelefone() + "\nEMAIL: " + listaClientes.get(i).getEmail()
              + "\nDESCRIÇÃO: " + listaClientes.get(i).getDescricao()+ "\n\n") ;
        }
    
    return sb.toString();
    
    }
    
    public String removerClienteService(Cliente cliente){
        
    String resultado = "";
    ArrayList<Cliente> listaClientes = new ArrayList<>();
    
       clienteDataBase.clientes();
       if(!clienteDao.listarClientes("ID", "Listar Id", cliente,listaClientes).isEmpty()){
           
           int resposta = JOptionPane.showConfirmDialog(
            null,
            "TEM CERTEZA QUE DESEJA REMOVER O(A) CLIENTE?",
            "CONFIRMAÇÃO",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
           
           if (resposta == JOptionPane.YES_OPTION) {
            clienteDao.removerClientes(cliente);
            resultado = "CLIENTE REMOVIDO COM SUCESSO.";
            
            } else if (resposta == JOptionPane.NO_OPTION){
            
            resultado = "NÃO FOI POSSÍVEL REMOVER O(A) CLIENTE.";
            
            }
            
             
        } else {
           resultado = "ID NÃO ENCONTRADO.\nPOR FAVOR, TENTE NOVAMENTE.";
       }
       
       return resultado;

}
    
    
    
    
}
