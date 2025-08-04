/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciamentopedidos.model;

public class Cliente {
    private int id, totalPedidos;
    private String nome, descricao, email, telefone;

    public Cliente(int id, int totalPedidos, String nome, String telefone,String email,String descricao) {
        this.id = id;
        this.totalPedidos = totalPedidos;
        this.nome = nome;
        this.descricao = descricao;
        this.email = email;
        this.telefone = telefone;
    }
    
    public Cliente() {
        this.totalPedidos = 0;
        this.nome = "";
        this.descricao = "";
        this.email = "";
        this.telefone = "";
    }
    
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalPedidos() {
        return totalPedidos;
    }

    public void setTotalPedidos(int totalPedidos) {
        this.totalPedidos = totalPedidos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    
}
