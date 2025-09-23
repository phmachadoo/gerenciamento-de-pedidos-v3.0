
package gerenciamentopedidos.service;

import gerenciamentopedidos.dao.ClientesDao;
import gerenciamentopedidos.database.ClienteDataBase;
import gerenciamentopedidos.model.Cliente;
import gerenciamentopedidos.utils.StringUtils;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ClientesService {
    
    ClientesDao clienteDao = new ClientesDao();
    ClienteDataBase clienteDataBase = new ClienteDataBase();
    StringUtils sUtils = new StringUtils();
    
    public String cadastroClienteService(Cliente cliente){
        if(cliente.getNome().trim().isEmpty() &&
              cliente.getTelefone().trim().isEmpty() &&
                cliente.getEmail().trim().isEmpty() && 
                    cliente.getDescricao().trim().isEmpty()){
            
        throw new IllegalArgumentException(sUtils.formatarTexto("PREENCHA OS CAMPOS DE 'CLIENTE'."));
        
        }   else if(cliente.getNome().trim().isEmpty()){
        
        throw new IllegalArgumentException("CAMPO ''NOME'' NÃO PODE SER VAZIO.");
        } 
        
        else if (cliente.getTelefone().trim().isEmpty() && 
         cliente.getEmail().trim().isEmpty()) {
        throw new IllegalArgumentException(sUtils.formatarTexto("CAMPOS ''TELEFONE'' E ''EMAIL'' NÃO PODEM SER VAZIOS."));
        }
       
        if(cliente.getNome().length() >= 16){
        throw new IllegalArgumentException(sUtils.formatarTexto("O CAMPO ''NOME'' NÃO PODE EXCEDER A 16 CARACTERES."));
        }
        
        clienteDataBase.clientes();
        clienteDao.inserirClientes(cliente);
         return "NOME: " + cliente.getNome() 
              + "\nTELEFONE: "+ cliente.getTelefone() + "\nEMAIL: " + cliente.getEmail()
              + "\nDESCRIÇÃO: " + cliente.getDescricao(); 
        
       
    }
    
    
    public String atualizarClienteService(Cliente cliente){
    ArrayList condicao = new ArrayList<>();
    ArrayList<Cliente> listaCliente = new ArrayList<>();
    StringBuilder sb = new StringBuilder(); 
    
            condicao.add(cliente.getNome().trim().isEmpty());
            condicao.add(cliente.getTelefone().trim().isEmpty());
            condicao.add(cliente.getEmail().trim().isEmpty());
            condicao.add(cliente.getDescricao().trim().isEmpty());
     
     clienteDataBase.clientes();
     clienteDao.atualizarCliente(condicao, cliente);
     clienteDao.listarClientes("ID", "Listar Id", cliente,listaCliente);
     
        for (int i = 0; i < listaCliente.size(); i++) {
            sb.append("ID: " + listaCliente.get(i).getId() +" | NOME: " + listaCliente.get(i).getNome() 
              + "\nTELEFONE: "+ listaCliente.get(i).getTelefone() + "\nEMAIL: " + listaCliente.get(i).getEmail()
              + "\nDESCRIÇÃO: " + listaCliente.get(i).getDescricao());
        }
     
     
    return sb.toString();
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
