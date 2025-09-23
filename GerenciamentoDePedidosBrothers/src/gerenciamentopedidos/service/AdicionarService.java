
package gerenciamentopedidos.service;

import gerenciamentopedidos.dao.ClientesDao;
import gerenciamentopedidos.dao.ProdutoDao;
import gerenciamentopedidos.model.Cliente;
import gerenciamentopedidos.model.ItemPedido;
import gerenciamentopedidos.model.Pedido;
import gerenciamentopedidos.model.Produto;
import gerenciamentopedidos.utils.StringUtils;
import java.text.SimpleDateFormat;
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
    StringBuilder sb = new StringBuilder();
    SimpleDateFormat sdf = new SimpleDateFormat();
    sb.append("ADICIONADO AO CARRINHO:\n");
    
         if(cliente.getNome().trim().isEmpty() &&
              cliente.getTelefone().trim().isEmpty() &&
                cliente.getEmail().trim().isEmpty() && 
                    cliente.getDescricao().trim().isEmpty()){
                    throw new IllegalArgumentException("PREENCHA OS CAMPOS DE 'CLIENTE'.");
            }
    
    else if(cliente.getNome().trim().isEmpty()){
        throw new IllegalArgumentException("CAMPO ''NOME'' NÃO PODE SER VAZIO.");
        } 
       
    else if (cliente.getTelefone().trim().isEmpty() && 
         cliente.getEmail().trim().isEmpty()) {
        throw new IllegalArgumentException(sUtils.formatarTexto("CAMPOS ''TELEFONE'' OU ''EMAIL'' NÃO PODEM SER VAZIOS."));
        }
        
         if(item.getDate() == null){
         throw new IllegalArgumentException("PREENCHA O CAMPO 'DATA'.");
         }else{
         String data = sdf.format(item.getDate());
         }
         
          if(clienteAtual == null){
          clienteAtual = cliente;
          pedido.getCarrinho().add(item);
          }
          else if(clienteAtual.getNome().equals(cliente.getNome())){
          pedido.getCarrinho().add(item);
          }else{
          return sUtils.formatarTexto("AO ADICIONAR NO CARRINHO, OS CLIENTES DEVEM SER IGUAIS.");
          }
       
          sb.append("NOME: " + cliente.getNome());
          for (int i = 0; i < pedido.getCarrinho().size(); i++) {
             sb.append("ITEM/PRODUTO: " + pedido.getCarrinho().get(i).getNomeProduto() +"\n");
             //sb.append("DESCRIÇÃO DO PRODUTO: " + pedido.getCarrinho().get(i).)
             sb.append("QUANTIDADE: " + pedido.getCarrinho().get(i).getQuantidade()+"\n");
             sb.append("PREÇO: " + pedido.getCarrinho().get(i).getPreco()+"\n");
             sb.append("DESCRIÇÃO DO PEDIDO: " + pedido.getCarrinho().get(i).getDescricao()+"\n");
             sb.append("DATA: " + pedido.getCarrinho().get(i).getDate()+"\n\n");
        }
          
    
    return sb.toString();
    }
    
    
    
    public String adicionarClienteService(String clienteFixo, Cliente cliente){
    return "";
    
    }
    
    
    
}
