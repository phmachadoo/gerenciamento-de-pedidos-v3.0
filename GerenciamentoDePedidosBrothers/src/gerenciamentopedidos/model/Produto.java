
package gerenciamentopedidos.model;


public class Produto {
    private int id;
    private String nomeProduto;
    private int quantidade;
    private double preco;

    public Produto(int id,String nomeProduto, int quantidade, double preco) {
        this.id=id;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

     public Produto() {
        this.nomeProduto = "";
        this.quantidade = 0;
        this.preco = 0.0;
    }
     
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
    
}
