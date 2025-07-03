
package controlefinanceiro.view;

import controlefinanceiro.dao.BrothersFinancaDAO;
import controlefinanceiro.model.BrothersFinanca;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ControleFinanceiroTela extends javax.swing.JFrame {
    BrothersFinancaDAO broDAO = new BrothersFinancaDAO();
    Date[] periodo = new Date[2];
    int contador = 0;
    
    public ControleFinanceiroTela() {
        initComponents();
        setResizable(false);
        setTitle("Brothers Gráfica & Copiadora");
        if(!broDAO.criarTabela()){
        txtArea.setText(" Não foi possível criar a tabela.");
        }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        txtMotivo = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        calendario = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        btntEntrada = new javax.swing.JButton();
        btnSaida = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        btnPdf = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("MOTIVO:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("TIPO:");

        txtValor.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtValor.setForeground(new java.awt.Color(0, 0, 102));

        txtMotivo.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtMotivo.setForeground(new java.awt.Color(0, 0, 102));

        txtTipo.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtTipo.setForeground(new java.awt.Color(0, 0, 102));
        txtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("VALOR: R$");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("DATA:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(3, 3, 3)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtValor, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(txtMotivo))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/controlefinanceiro/image/LOGO1.jpg"))); // NOI18N

        btntEntrada.setBackground(new java.awt.Color(0, 0, 102));
        btntEntrada.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btntEntrada.setForeground(new java.awt.Color(255, 255, 255));
        btntEntrada.setText("ENTRADA");
        btntEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntEntradaActionPerformed(evt);
            }
        });

        btnSaida.setBackground(new java.awt.Color(0, 0, 102));
        btnSaida.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnSaida.setForeground(new java.awt.Color(255, 255, 255));
        btnSaida.setText("SAIDA");
        btnSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaidaActionPerformed(evt);
            }
        });

        btnListar.setBackground(new java.awt.Color(0, 0, 102));
        btnListar.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnListar.setForeground(new java.awt.Color(255, 255, 255));
        btnListar.setText("LISTAR");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        txtArea.setColumns(20);
        txtArea.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtArea.setForeground(new java.awt.Color(0, 0, 102));
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        btnPdf.setBackground(new java.awt.Color(102, 0, 0));
        btnPdf.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnPdf.setForeground(new java.awt.Color(204, 204, 204));
        btnPdf.setText("GERAR RELATÓRIO .PDF");
        btnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfActionPerformed(evt);
            }
        });

        btnRemover.setBackground(new java.awt.Color(0, 0, 102));
        btnRemover.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnRemover.setForeground(new java.awt.Color(255, 255, 255));
        btnRemover.setText("REMOVER");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("ID:");

        txtID.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btntEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntEntrada)
                    .addComponent(btnSaida)
                    .addComponent(btnListar)
                    .addComponent(btnRemover))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btntEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntEntradaActionPerformed
        String valorStr = txtValor.getText();
        String tipo = null;
        String tipoPagamento = txtTipo.getText().toUpperCase();
        String motivo = "";
        Date date = calendario.getDate();
        
        if(valorStr.isEmpty() || tipoPagamento.isEmpty() || date == null){
        txtArea.setText(" Não foi possivel inserir.\n"
                + " Por favor, preencha os campos 'VALOR', 'TIPO' e 'DATA'.");
        } else{
            try {
                double valor = Double.parseDouble(valorStr);
               
                BrothersFinanca brothers = new BrothersFinanca(valor, tipo, tipoPagamento, motivo, date);
                
                if (broDAO.entradaValores(brothers)){
                txtArea.setText("Inserido com sucesso!");
                txtValor.setText("");
                txtTipo.setText("");
                calendario.setDate(null);
                }

            } catch (NumberFormatException e) {
                txtArea.setText(" Dados incorretos."); 
          e.printStackTrace();
            }
        
        
        }

        txtValor.setText("");
        txtMotivo.setText("");
        txtTipo.setText("");
       calendario.setDate(null);
        
    }//GEN-LAST:event_btntEntradaActionPerformed

    private void btnSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaidaActionPerformed

        String valorStr = txtValor.getText();
        String tipo = null;
        String tipoPagamento = txtTipo.getText().toUpperCase();
        String motivo = txtMotivo.getText().toUpperCase();
        Date date = calendario.getDate();
        
        if(valorStr.isEmpty() || tipoPagamento.isEmpty() || motivo.isEmpty() || date == null){
        txtArea.setText(" Não foi possivel inserir.\n"
                + " Por favor, preencha os campos 'VALOR', 'TIPO', 'MOTIVO' e 'DATA'.");
        } else{
            try {
                 double valor = Double.parseDouble(valorStr);
                 
                 BrothersFinanca brothers = new BrothersFinanca(valor,tipo,tipoPagamento,motivo,date);
                 
                 
                 if(broDAO.saidaValores(brothers)){
                txtArea.setText(" Inserido com sucesso!");
                txtValor.setText("");
                txtTipo.setText("");
                txtMotivo.setText("");
                calendario.setDate(null);
                 
                 }
            } catch (Exception e) {
                txtArea.setText(" Dados incorretos: " + e.getMessage());
                e.printStackTrace();
            }
           
        }
        
        txtValor.setText("");
        txtMotivo.setText("");
        txtTipo.setText("");
       calendario.setDate(null);
    }//GEN-LAST:event_btnSaidaActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        txtArea.setText("");
        String tipo = txtTipo.getText().toUpperCase();
        Date date = calendario.getDate();
        Date dateHora = new Date();
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if(tipo.isEmpty() && date== null){
                txtArea.setText(broDAO.listar());
                
            }else{
        
        String data = sdf.format(date);
         
        if(tipo.isEmpty() && !data.isEmpty()){
        txtArea.setText(broDAO.listarData(data));
        }
        
        else if(!tipo.isEmpty() && !data.isEmpty()){
        txtArea.setText(broDAO.listarDataTipo(data, tipo));
        } 
        
        }} catch (Exception e) {
             txtArea.setText(" Dados incorretos: " + e.getMessage());
        }
        
       
        txtTipo.setText("");
       calendario.setDate(null);
       
        
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
        Date date = calendario.getDate();
        
        int id = 0;
        BrothersFinanca brothers = new BrothersFinanca(id);
        if(contador<2 && date != null){
            periodo[contador] = date;
            
            contador++;
           txtArea.setText("Data " + contador + " registrada: " +
            new SimpleDateFormat("dd/MM/yyyy").format(date));
        }else{
        txtArea.setText(" Não foi possível inserir.\n Por favor, preencha o campo 'DATA'.");
        }
        
        
        if(contador == 2){
            if(!periodo[0].before(periodo[1])){
                txtArea.setText(" Não foi possível inserir.\n A primeira data inserida deve ser mais antiga que a segunda data.\n\n"
                        + " Exemplo:\n"
                        + " Primeira data: 07/06/2025\n"
                        + " Segunda data: 01/01/2025\n"
                        + " Isso não é permitido.");
                
                for (int i = 0; i < periodo.length; i++) {
                periodo[i] = null;
                System.out.println(periodo[i]);
               contador = 0;
            }
            }else{
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String dataAntiga = sdf.format(periodo[0]);
                String dataNova = sdf.format(periodo[1]);
                
                String resultado = broDAO.gerarRelatorio(dataAntiga, dataNova, brothers);
                txtArea.setText(resultado);
            } catch (Exception e) {
                txtArea.setText("Dados incorretos: " + e.getMessage());
                e.printStackTrace();
            }
            
            
            for (int i = 0; i < periodo.length; i++) {
                periodo[i] = null;
                System.out.println(periodo[i]);
               contador = 0;
            }
        
            }
            
        }
        calendario.setDate(null);
    }//GEN-LAST:event_btnPdfActionPerformed

    private void txtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoActionPerformed
        
    }//GEN-LAST:event_txtTipoActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
       String idStr = txtID.getText();
        try {
            
            if (idStr.isEmpty()) {
                txtArea.setText(" Não foi possível remover.\n Por favor, preencha o campo 'ID'.");
            } else{
            
                int id = Integer.parseInt(idStr);
                
                BrothersFinanca brothers = new BrothersFinanca(id);
                
                if (broDAO.remover(brothers)) {
                    txtArea.setText(" Removido com sucesso!");
                    
                } else{
                txtArea.setText(" Não foi possível remover.");
                }

            
            }
            
            
        } catch (Exception e) {
        txtArea.setText(" Dados incorretos. ");
        e.printStackTrace();
        }
        txtID.setText("");
       
    }//GEN-LAST:event_btnRemoverActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControleFinanceiroTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnPdf;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSaida;
    private javax.swing.JButton btntEntrada;
    private com.toedter.calendar.JDateChooser calendario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMotivo;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
