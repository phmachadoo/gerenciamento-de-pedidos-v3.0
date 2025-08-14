
package gerenciamentopedidos.service;

import gerenciamentopedidos.dao.ClientesDao;
import gerenciamentopedidos.model.Cliente;
import java.util.ArrayList;

public class AdicionarService {
    
    ClientesDao clientesDao = new ClientesDao();
    
    public ArrayList<Cliente> comboBoxClientesService(Cliente cliente, ArrayList<Cliente> listaClientesService){
    
    clientesDao.listarClientes("NOME", "Listar todos", cliente,listaClientesService);
    return listaClientesService;
    }
    
    
    
    
    public String adicionarClienteService(String clienteFixo, Cliente cliente){
    return "";
    
    }
    
    
    
}
