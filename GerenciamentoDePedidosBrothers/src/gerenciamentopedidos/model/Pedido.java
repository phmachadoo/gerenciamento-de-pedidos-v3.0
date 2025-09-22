package gerenciamentopedidos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<ItemPedido> carrinho = new ArrayList<>();
    private String status;
    private double valorTotal;


    public Pedido() {
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemPedido> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(List<ItemPedido> carrinho) {
        this.carrinho = carrinho;
    }

  
   
    
    
    
    
}
