
package gerenciamentopedidos.model;


public class ItemPedido {
    //refazer a classe para o 'item_pedido'
    private int id;
    private String nomeProduto, descricao;
    private int quantidade;
    private double preco;

    public ItemPedido(int id, String nomeProduto, String descricao, int quantidade, double preco) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public ItemPedido() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
