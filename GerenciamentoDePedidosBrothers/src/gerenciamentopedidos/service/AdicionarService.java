
package gerenciamentopedidos.service;

import gerenciamentopedidos.dao.ClientesDao;
import gerenciamentopedidos.dao.ProdutoDao;
import gerenciamentopedidos.model.Cliente;
import gerenciamentopedidos.model.Produto;
import java.util.ArrayList;

public class AdicionarService {
    
    ClientesDao clientesDao = new ClientesDao();
    ProdutoDao produtoDao = new ProdutoDao();
    public ArrayList<Cliente> comboBoxClientesService(Cliente cliente, ArrayList<Cliente> listaClientesService){
    
    clientesDao.listarClientes("NOME", "Listar todos", cliente,listaClientesService);
    return listaClientesService;
    }
    
    public ArrayList<Produto> comboBoxProdutosService(Produto produto, ArrayList<Produto> listaProdutosService){
    produtoDao.listarProduto("NOME", "Listar todos", produto, listaProdutosService);
    return listaProdutosService;
    
    }
    
    
    public String adicionarClienteService(String clienteFixo, Cliente cliente){
    return "";
    
    }
    
    
    
}
