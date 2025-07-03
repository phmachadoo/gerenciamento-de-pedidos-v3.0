package gerenciamentopedidos.model;

public class Pedido {
    private int id;
    private Cliente cliente;
    private Produto produto;
    private String status;
    private double valorTotal;
    //adicionar data

    public Pedido(int id, Cliente cliente, Produto produto, double valorTotal, String status) {
        this.id = id;
        this.cliente = cliente;
        this.produto = produto;
        this.valorTotal = valorTotal;
        this.status = status;
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
    
    
    
    
}
