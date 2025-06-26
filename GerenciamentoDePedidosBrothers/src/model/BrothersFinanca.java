/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

public class BrothersFinanca {
    private int id;
    private double valor;
    private String tipo,tipoPagamento, motivo;
    private Date date;

    public BrothersFinanca(double valor, String tipo, String tipoPagamento, String motivo, Date date) {
        this.valor = valor;
        this.tipo = tipo;
        this.tipoPagamento = tipoPagamento;
        this.motivo = motivo;
        this.date = date;
    }

    public BrothersFinanca(int id) {
        this.id=id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

  
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    @Override
    public String toString() {
        return "Brothers{" + "valor=" + valor + ", tipoPagamento=" + tipoPagamento + ", motivo=" + motivo + ", date=" + date + '}';
    }

   
    
    
    
    
}
