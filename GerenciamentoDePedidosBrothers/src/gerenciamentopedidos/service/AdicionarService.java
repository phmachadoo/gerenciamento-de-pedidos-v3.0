
package gerenciamentopedidos.service;

import gerenciamentopedidos.dao.ClientesDao;
import gerenciamentopedidos.dao.ProdutoDao;
import gerenciamentopedidos.model.Cliente;
import gerenciamentopedidos.model.ItemPedido;
import gerenciamentopedidos.model.Pedido;
import gerenciamentopedidos.model.Produto;
import gerenciamentopedidos.utils.StringUtils;
import java.util.ArrayList;

public class AdicionarService {
    
    ClientesDao clientesDao = new ClientesDao();
    ProdutoDao produtoDao = new ProdutoDao();
    Pedido pedido = new Pedido();
    StringUtils sUtils = new StringUtils();
    Cliente clienteAtual;
    
    
    public ArrayList<Cliente> comboBoxClientesService(Cliente cliente, ArrayList<Cliente> listaClientesService){
    
    clientesDao.listarClientes("NOME", "Listar todos", cliente,listaClientesService);
    return listaClientesService;
    }
    
    public ArrayList<Produto> comboBoxProdutosService(Produto produto, ArrayList<Produto> listaProdutosService){
    produtoDao.listarProduto("NOME", "Listar todos", produto, listaProdutosService);
    return listaProdutosService;
    
    }
    
    public String adicionarCarrinhoService(Cliente cliente, ItemPedido item){
    
    
        
        
          if(clienteAtual == null){
          clienteAtual = cliente;
          pedido.getCarrinho().add(item);
          }
          else if(clienteAtual.getNome().equals(cliente.getNome())){
          pedido.getCarrinho().add(item);
          }else{
          return sUtils.formatarTexto("AO ADICIONAR NO CARRINHO, OS CLIENTES DEVEM SER IGUAIS.");
          }
        
          
          for (int i = 0; i < pedido.getCarrinho().size(); i++) {
              System.out.println(cliente.getNome());
              System.out.println(pedido.getCarrinho().get(i).getNomeProduto());
        }
        
         
    
    
    return clienteAtual.getNome();
    }
    
    public String adicionarClienteService(String clienteFixo, Cliente cliente){
    return "";
    
    }
    
    
    
}
