/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Font;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import model.BrothersFinanca;

public class BrothersFinancaDAO {
    
    public static boolean criarTabela(){
    String sql = "CREATE TABLE IF NOT EXISTS valores("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "valor REAL NOT NULL,"
            + "tipo Text NOT NULL DEFAULT '',"
            + "tipo_pagamento TEXT NOT NULL,"
            + "motivo TEXT,"
            + "data TEXT NOT NULL);";
    
        try (Connection conn = ConexaoFinanca.conexao();
            PreparedStatement ps = conn.prepareStatement(sql);){
            
            ps.executeUpdate();
            return true;
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean entradaValores(BrothersFinanca brothers){
    String sql = "INSERT INTO valores (valor,tipo,tipo_pagamento,data) VALUES (?,'ENTRADA',?,?);";
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    String data = sdf.format(brothers.getDate());
    
        try (Connection conn = ConexaoFinanca.conexao();
            PreparedStatement ps = conn.prepareStatement(sql);){ 
            
            ps.setDouble(1,brothers.getValor());
            ps.setString(2,brothers.getTipoPagamento());
            ps.setString(3,data);
            
            int linhas = ps.executeUpdate();
            return linhas>0;
            
        } catch (SQLException e) {
        e.printStackTrace();
        return false;
        }
    
    }
    
    public static boolean saidaValores(BrothersFinanca brothers){
            String sql = "INSERT INTO valores (valor,tipo, tipo_pagamento, motivo, data) VALUES (?,'SAIDA',?,?,?);";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String data = sdf.format(brothers.getDate());
        
        try (Connection conn = ConexaoFinanca.conexao();
            PreparedStatement ps = conn.prepareStatement(sql);){
            
            ps.setDouble(1, brothers.getValor());
            ps.setString(2, brothers.getTipoPagamento());
            ps.setString(3, brothers.getMotivo());
            ps.setString(4,data);
            
            int linhas = ps.executeUpdate();
            
            return linhas>0;
            
            
        } catch (SQLException e) {
            System.out.println("Não foi possível manter a conexao com o banco de dados");
            e.printStackTrace();
            return false;
        }
        
        
    }
    
    public static String listar() throws ParseException{
        String sql = "SELECT * FROM valores;";
        int id = 0;
        BrothersFinanca brothers = new BrothersFinanca(id);
        StringBuilder sb = new StringBuilder();
        
        
        SimpleDateFormat sdfBanco = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfUsuario = new SimpleDateFormat("dd/MM/yyyy");
        
        
        try (Connection conn = ConexaoFinanca.conexao();
            PreparedStatement ps = conn.prepareStatement(sql);){
            
            try (ResultSet rs = ps.executeQuery();){
                  while(rs.next()){
                        brothers.setId(rs.getInt("id"));
                        brothers.setValor(rs.getDouble("valor"));
                        brothers.setTipo(rs.getString("tipo"));
                        brothers.setTipoPagamento(rs.getString("tipo_pagamento"));
                        brothers.setMotivo(rs.getString("motivo"));
                        String dataBanco = rs.getString("data");
                        
                        Date data = sdfBanco.parse(dataBanco);
                        String dataFormatada = sdfUsuario.format(data);
                        
                       sb.append(" VALOR: " + brothers.getValor() + " | TIPO: " + brothers.getTipo() + " | PAGAMENTO: " + brothers.getTipoPagamento() +
           " | MOTIVO: " + brothers.getMotivo() + " | DATA: " + dataFormatada +" | ID: " + brothers.getId()
                   +"\n--------------------------------------------------------------------------\n");
                        
                        
                
            }
            } catch (SQLException e) {
                 e.printStackTrace();
                return " Não foi possível manter a conexão";
            }
            
            return sb.toString();
            
        } catch (SQLException e) {
        e.printStackTrace();
        return " Não foi possivel manter a conexão.";
        }
        
        
        }
    
    
    public static String listarData(String date) throws ParseException{
    String sql = "SELECT * FROM valores WHERE data = ?";
    int id = 0;
    BrothersFinanca brothers = new BrothersFinanca(id);
    StringBuilder sb = new StringBuilder();
    
    SimpleDateFormat sdfBanco = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdfUsuario = new SimpleDateFormat("dd/MM/yyyy");
    
       try (Connection conn = ConexaoFinanca.conexao();
            PreparedStatement ps = conn.prepareStatement(sql);){
            
            ps.setString(1, date);
            
            try (ResultSet rs = ps.executeQuery();){
                while(rs.next()){
                        brothers.setId(rs.getInt("id"));
                        brothers.setValor(rs.getDouble("valor"));
                        brothers.setTipo(rs.getString("tipo"));
                        brothers.setTipoPagamento(rs.getString("tipo_pagamento"));
                        brothers.setMotivo(rs.getString("motivo"));
                        String dataBanco = rs.getString("data");
                        Date data = sdfBanco.parse(dataBanco);
                        String dataFormatada = sdfUsuario.format(data);
                        
           sb.append(" VALOR: " + brothers.getValor() + " | TIPO: " + brothers.getTipo() + " | PAGAMENTO: " + brothers.getTipoPagamento() +
           " | MOTIVO: " + brothers.getMotivo() + " | DATA: " + dataFormatada +" | ID: " + brothers.getId()
                   +"\n--------------------------------------------------------------------------\n");
                        
            }
            } catch (SQLException e) {
               e.printStackTrace();
               return " Não foi possivel manter a conexão";
           }

            } catch (SQLException e) {
                
            e.printStackTrace();
            return " Não foi possível manter a conexão.";
            } 
       
       return sb.toString();
    }
    
    
    public static String listarDataTipo(String date, String tipo) throws ParseException{
    
    String sql = "SELECT * FROM valores WHERE data = ? AND tipo = ?;";
    int id = 0;
    BrothersFinanca brothers = new BrothersFinanca(id);
    StringBuilder sb = new StringBuilder();
    double soma = 0;
    SimpleDateFormat sdfBanco = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdfUsuario = new SimpleDateFormat("dd/MM/yyyy");
    
        try (Connection conn = ConexaoFinanca.conexao();
            PreparedStatement ps = conn.prepareStatement(sql);){
            
            ps.setString(1, date);
            ps.setString(2,tipo);
            
            try (ResultSet rs = ps.executeQuery();){
           
            while(rs.next()){
                        brothers.setId(rs.getInt("id"));
                        brothers.setValor(rs.getDouble("valor"));
                        brothers.setTipo(rs.getString("tipo"));
                        brothers.setTipoPagamento(rs.getString("tipo_pagamento"));
                        brothers.setMotivo(rs.getString("motivo"));
                        String dataBanco = rs.getString("data");
                        Date data = sdfBanco.parse(dataBanco);
                        String dataFormatada = sdfUsuario.format(data);
                        
           sb.append(" VALOR: " + brothers.getValor() + " | TIPO: " + brothers.getTipo() + " | PAGAMENTO: " + brothers.getTipoPagamento() +
           " | MOTIVO: " + brothers.getMotivo() + " | DATA: " + dataFormatada +" | ID: " + brothers.getId()
                   +"\n--------------------------------------------------------------------------\n");
                        
                    soma += brothers.getValor();
                            }
            } catch (SQLException e) {
                e.printStackTrace();
                return "Não foi possivel manter a conexão.";
            }
            
            } catch (SQLException e) {
            e.printStackTrace();
            return "Não foi possível manter a conexão.";
            } 
        
        sb.append(" Total: R$ " + soma);
        return sb.toString();
    }
    
    public static boolean remover(BrothersFinanca brothers){
    String sql = "DELETE FROM valores WHERE id = ?;";
    
        try (Connection conn = ConexaoFinanca.conexao();
             PreparedStatement ps = conn.prepareStatement(sql);
                ){
                
                 ps.setInt(1,brothers.getId());
                 int linhas = ps.executeUpdate();
                 return linhas>0;
            
        } catch (SQLException e) {
        e.printStackTrace();
        return false;
        }
    }
    
   public static String gerarRelatorio(String dataAntiga, String dataNova, BrothersFinanca brothers) {
    String sql = "SELECT * FROM valores WHERE data BETWEEN ? AND ?;";
    Document doc = new Document();

    try (Connection conn = ConexaoFinanca.conexao();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        // Formatadores de datas
        DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoBanco = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatoSaida = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Converte datas de entrada para o formato do banco
        LocalDate dataInicio = LocalDate.parse(dataAntiga, formatoEntrada);
        LocalDate dataFim = LocalDate.parse(dataNova, formatoEntrada);

        String dataInicioSql = dataInicio.format(formatoBanco);
        String dataFimSql = dataFim.format(formatoBanco);

        ps.setString(1, dataInicioSql);
        ps.setString(2, dataFimSql);

        // Nome dinâmico para o arquivo PDF com intervalo
        String nomeArquivo = String.format("RelatorioFinanceiro_%s_a_%s.pdf",
                dataInicio.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                dataFim.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
        );

        // Início do PDF
        PdfWriter.getInstance(doc, new FileOutputStream(nomeArquivo));
        doc.open();

        com.lowagie.text.Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
        Paragraph titulo = new Paragraph("Relatório Financeiro", tituloFont);
        titulo.setAlignment(Element.ALIGN_CENTER);
        doc.add(titulo);
        doc.add(new Paragraph(" "));

        PdfPTable tabela = new PdfPTable(4);
        tabela.setWidthPercentage(100);
        tabela.addCell("Tipo");
        tabela.addCell("Motivo");
        tabela.addCell("Valor");
        tabela.addCell("Data");

        // Resultado da consulta
        Map<String, List<String[]>> transacoesPorData = new HashMap<>();
        double totalEntradas = 0.0;
        double totalSaidas = 0.0;

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String dataBanco = rs.getString("data"); // yyyy-MM-dd
                LocalDate dataLocal = LocalDate.parse(dataBanco, formatoBanco);
                String dataFormatada = dataLocal.format(formatoSaida); // dd/MM/yyyy

                String tipo = rs.getString("tipo");
                String motivo = rs.getString("motivo") != null ? rs.getString("motivo") : "--";
                double valor = rs.getDouble("valor");
                String valorFormatado = String.format("R$ %.2f", valor);

                if ("ENTRADA".equalsIgnoreCase(tipo)) {
                    totalEntradas += valor;
                } else if ("SAIDA".equalsIgnoreCase(tipo)) {
                    totalSaidas += valor;
                }

                transacoesPorData
                        .computeIfAbsent(dataBanco, k -> new ArrayList<>())
                        .add(new String[]{tipo, motivo, valorFormatado, dataFormatada});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao executar consulta: " + e.getMessage();
        }

        // Todas as datas do período
        List<LocalDate> datasPeriodo = new ArrayList<>();
        LocalDate atual = dataInicio;
        while (!atual.isAfter(dataFim)) {
            datasPeriodo.add(atual);
            atual = atual.plusDays(1);
        }

        // Preencher tabela
        for (LocalDate dia : datasPeriodo) {
            String dataBanco = dia.format(formatoBanco);
            String dataExibida = dia.format(formatoSaida);

            if (transacoesPorData.containsKey(dataBanco)) {
                for (String[] transacao : transacoesPorData.get(dataBanco)) {
                    tabela.addCell(transacao[0]); // tipo
                    tabela.addCell(transacao[1]); // motivo
                    tabela.addCell(transacao[2]); // valor
                    tabela.addCell(transacao[3]); // data formatada
                }
            } else {
                tabela.addCell("--");
                tabela.addCell("--");
                tabela.addCell("--");
                tabela.addCell(dataExibida);
            }
        }

        // Adiciona tabela ao PDF
        doc.add(tabela);

        // Totais
        doc.add(new Paragraph(" "));
        Paragraph totalEntradasP = new Paragraph("Total de Entradas: R$ " + String.format("%.2f", totalEntradas));
        Paragraph totalSaidasP = new Paragraph("Total de Saídas: R$ " + String.format("%.2f", totalSaidas));
        Paragraph totalGeralP = new Paragraph("Total Geral: R$ " + String.format("%.2f", totalEntradas - totalSaidas));

        totalEntradasP.setAlignment(Element.ALIGN_RIGHT);
        totalSaidasP.setAlignment(Element.ALIGN_RIGHT);
        totalGeralP.setAlignment(Element.ALIGN_RIGHT);

        doc.add(totalEntradasP);
        doc.add(totalSaidasP);
        doc.add(totalGeralP);

        doc.close();
        return "PDF gerado com sucesso: " + nomeArquivo;

    } catch (Exception e) {
        e.printStackTrace();
        return "Erro ao gerar PDF: " + e.getMessage();
    }
}
}
