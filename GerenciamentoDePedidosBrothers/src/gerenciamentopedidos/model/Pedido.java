package gerenciamentopedidos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<Produto> carrinho = new ArrayList<>();
    private String status;
    private double valorTotal;
    private Date data;

    public Pedido(int id, Cliente cliente, String status, Date data,double valorTotal) {
        this.id = id;
        this.cliente = cliente;
        this.status = status;
        this.valorTotal = valorTotal;
        this.data = data;
    }

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
   
    
    
    
    
}
