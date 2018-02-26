package FuncoesInternas;

import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @author Tiago
 */
public class IntervaloDatas extends javax.swing.JFrame {
    
    //String
    String mensagem      = "";
    String arquivoJasper = "";
    String dataInicial   = "";
    String dataFinal     = "";
    
    String tipoRelatorio = "";
    
    //Jasper
    JasperPrint rel = null;
    HashMap map = new HashMap();
    
    //Funções
    InverterData        invdata     = new InverterData();
    FormataCPFCNPJ      FCpfCnpj    = new FormataCPFCNPJ();
    
    public IntervaloDatas(String tipoRelatorio1){
        initComponents();
        
        tipoRelatorio = tipoRelatorio1;
        txt_tipoRelatorio.setText(tipoRelatorio);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        label_titulo1 = new javax.swing.JLabel();
        txt_dataInicial = new javax.swing.JFormattedTextField();
        label_titulo2 = new javax.swing.JLabel();
        txt_dataFinal = new javax.swing.JFormattedTextField();
        bt_processar = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();
        txt_tipoRelatorio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(":: Intervalo datas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Intervalo de Datas");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        label_titulo1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label_titulo1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_titulo1.setText("Data inicial:");

        try {
            txt_dataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataInicial.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_dataInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataInicialKeyPressed(evt);
            }
        });

        label_titulo2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label_titulo2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_titulo2.setText("Data final:");

        try {
            txt_dataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataFinal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_dataFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataFinalKeyPressed(evt);
            }
        });

        bt_processar.setText("Visualizar");
        bt_processar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_processarActionPerformed(evt);
            }
        });
        bt_processar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bt_processarKeyPressed(evt);
            }
        });

        bt_cancelar.setText("Cancelar");
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });
        bt_cancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bt_cancelarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(label_titulo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label_titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_dataInicial)
                            .addComponent(txt_dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(bt_cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_processar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_titulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_processar)
                    .addComponent(bt_cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_tipoRelatorio.setEditable(false);

        jLabel2.setText("Relatório: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tipoRelatorio)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tipoRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_dataFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataFinalKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        bt_processar.grabFocus();
    }//GEN-LAST:event_txt_dataFinalKeyPressed

    private void txt_dataInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataInicialKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        txt_dataFinal.grabFocus();
    }//GEN-LAST:event_txt_dataInicialKeyPressed

    private void bt_processarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_processarActionPerformed
        Processar();
    }//GEN-LAST:event_bt_processarActionPerformed

    private void bt_processarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bt_processarKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        Processar();
    }//GEN-LAST:event_bt_processarKeyPressed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void bt_cancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bt_cancelarKeyPressed

    }//GEN-LAST:event_bt_cancelarKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(tipoRelatorio.equalsIgnoreCase("Produtos Vendidos")){
            arquivoJasper = "Relatorios\\RelatorioDeProdutosVendidos.jasper";
        }
        if(tipoRelatorio.equalsIgnoreCase("Formas de Pagamento")){
            arquivoJasper = "Relatorios\\RelatorioDePagamentosEfetuados.jasper";
        }
        if(tipoRelatorio.equalsIgnoreCase("PagamentoDeRecibos")){
            arquivoJasper = "Relatorios\\RelatorioRecibosPagamentos.jasper";
        }
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_processar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label_titulo1;
    private javax.swing.JLabel label_titulo2;
    private javax.swing.JFormattedTextField txt_dataFinal;
    private javax.swing.JFormattedTextField txt_dataInicial;
    private javax.swing.JTextField txt_tipoRelatorio;
    // End of variables declaration//GEN-END:variables
    private void Processar(){
        try{
            dataInicial = txt_dataInicial.getText();
            dataInicial = invdata.inverterData(dataInicial, 2);
            
            dataFinal   = txt_dataFinal.getText();
            dataFinal   = invdata.inverterData(dataFinal, 2);

            visualizarRelatorio();
            
        }catch(Exception e){
            mensagem = "Erro ao visualizar o relatório: " + e;
            new MostraMensagem(mensagem);
        }
    }
    
    private void visualizarRelatorio() {
        try {
            rel = null;

            map = new HashMap();

            map.put("dataInicial", dataInicial);
            map.put("dataFinal", "" + dataFinal);
            
            map.put("nomeEmpresa",       parametrosNS.be.nomeEmpresa);
            map.put("enderecoEmpresa",   parametrosNS.be.enderecoEmpresa + ", " + parametrosNS.be.numeroEmpresa);
            map.put("cepEmpresa",        parametrosNS.be.cepEmpresa);
            map.put("cidadeEmpresa",     parametrosNS.be.cidadeEmpresa + ", " + parametrosNS.be.ufEmpresa);
            map.put("bairroEmpresa",     parametrosNS.be.bairroEmpresa);
            map.put("logotipoEmpresa",   parametrosNS.bge.pastaImagemLogotipo + "/LOGOTIPO." + parametrosNS.bge.extensaoImagemLogotipo);
            map.put("telefoneEmpresa",   parametrosNS.be.telefoneEmpresa);
            map.put("cnpjEmpresa",       FCpfCnpj.FormataCPFCNPJ(parametrosNS.be.cnpjEmpresa));

            try{
                rel = JasperFillManager.fillReport(arquivoJasper, map, parametrosNS.con);
            }catch(Exception e){
                mensagem = "visualizar solicitar relatorios " + e + arquivoJasper;
                new MostraMensagem(mensagem);
                mensagem = e.getMessage();
                new MostraMensagem(mensagem);
            }
            JasperViewer.viewReport(rel, false);
            dispose();

        } catch (Exception e) {
            mensagem = "O erro foi no solicitar relatorios: " + e + arquivoJasper;
            new MostraMensagem(mensagem);
        }
    }
}

