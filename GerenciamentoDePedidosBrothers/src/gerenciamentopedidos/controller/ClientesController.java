/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciamentopedidos.controller;

import gerenciamentopedidos.model.Cliente;
import gerenciamentopedidos.service.ClientesService;

public class ClientesController {
    
    ClientesService clienteService = new ClientesService();
    
    
    public String cadastroClienteController(String nome, String telefone, String email, String descricao){
        try {
             Cliente clientes = new Cliente(nome,telefone,email,descricao);
             return clienteService.cadastroClienteService(clientes);
            
        } catch (IllegalArgumentException e) {
            return "Erro ao cadastrar o cliente:\n" + e.getMessage();
        }
    
    }
    
    
    public String listarClienteController(String nome){
        try {
            Cliente clientes = new Cliente();
            return clienteService.listarClienteService(clientes);
            
            
            
            
        } catch (IllegalArgumentException e) {
            return "Erro ao listar cliente(s):\n" + e.getMessage();
        }
    
    
    }
    
    
    
    
    
    
    
}
