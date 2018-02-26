package TelasEstoque;

import Parametros.parametrosNS;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import FuncoesInternas.converterCampoFormatadoDouble;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @author Tiago
 */
public class GeradorEtiquetas extends javax.swing.JFrame {
    //String
    String mensagem = "";
    String sql      = "";
    
    //Funções
    NumberFormat                  nf = new DecimalFormat("R$ ###,##0.00");
    converterCampoFormatadoDouble cv = new converterCampoFormatadoDouble();
    
    //Relatórios
    String        jpv         = "";
    JasperPrint   jpp         = null;
    HashMap       hm          = new HashMap();
    
    String titulo       = "";
    String codigoBarras = "";
    double valor        = 0;
    int qtd = 0;
    public GeradorEtiquetas(String ti, String cod, double val, String qt) {
        titulo = ti;
        codigoBarras = cod;
        valor = val;
        qtd = Integer.parseInt(qt);
        initComponents();
        txt_titulo.setText(ti);
        txt_codigoBarras.setText(parametrosNS.fc.FormataCampo(codigoBarras, 10, 0));
        txt_valor.setText(nf.format(valor));
        txt_quantidade.setText(String.valueOf(qtd));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_titulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_valor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_quantidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        combo_tipoImpressao = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        txt_codigoBarras = new javax.swing.JFormattedTextField();
        bt_gerar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerador de etiquetas v1.0");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Parâmetros");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setText("Título: ");

        txt_titulo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setText("Código de barras: ");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setText("Valor: ");

        txt_valor.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txt_valor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorFocusLost(evt);
            }
        });
        txt_valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_valorKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel5.setText("Quantidade: ");

        txt_quantidade.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel6.setText("Tipo de impressão: ");

        combo_tipoImpressao.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        combo_tipoImpressao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "30 por folha (pimaco)", "Impressora de etiqueta", "Ribbon", "Daruma", "Zebra", "Argox", "Epson", "Unitaria" }));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel7.setText("Tipo de etiqueta: ");

        jComboBox2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EAN13", "EAN128", "ARGB", "ESAT" }));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel8.setText("Tipo de conexão: ");

        jComboBox3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USB", "COM1", "COM2", "COM3", "COM4", "LPT1", "LPT2", "ETH01" }));

        try {
            txt_codigoBarras.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoBarras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoBarrasFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_quantidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                        .addComponent(txt_valor, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(combo_tipoImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_codigoBarras, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_titulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_codigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(combo_tipoImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        bt_gerar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        bt_gerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_gerar.setText("Gerar");
        bt_gerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_gerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_gerar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_gerar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_gerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_gerarActionPerformed
        sql = "delete from tb_etiquetas";
        parametrosNS.dao.incluirRegistro(sql);
                
        qtd = Integer.parseInt(txt_quantidade.getText());
                
        titulo = txt_titulo.getText();
        codigoBarras = txt_codigoBarras.getText().replace(" ", "");
        valor = Float.parseFloat(cv.converter(txt_valor.getText().replace(".", "")));                    
        
        for(int i = 0; i < qtd; i ++){
            sql = "insert into tb_etiquetas (titulo, codigoBarras, valor, quantidade) values ('"+titulo+"', '"+codigoBarras+"', '"+valor+"', '"+qtd+"')";
            parametrosNS.dao.incluirRegistro(sql);
        }
        
        if(combo_tipoImpressao.getSelectedItem().equals("30 por folha (pimaco)")){
            jpv = "Relatorios/EtiquetasEAN13.jasper";
        }else if(combo_tipoImpressao.getSelectedItem().equals("Unitaria")){
            jpv = "Relatorios/EtiquetaUnitaria.jasper";
        }
        
        try {
            jpp = null;
            
            hm.clear();
            //hm.put("codigoOrdemServico", bos.codigoOrdemServico);
            
            try{
                jpp = JasperFillManager.fillReport(jpv, hm, parametrosNS.con);
            }catch(Exception e){
                mensagem = "visualizar solicitar relatorios " + e + jpv;
                mostraMensagem();
                mensagem = e.getMessage();
                mostraMensagem();
            }
            JasperViewer.viewReport(jpp, false);
            //dispose();

        } catch (Exception e) {
            mensagem = "O erro foi no solicitar relatorios: " + e + jpv;
            mostraMensagem();
        }
    }//GEN-LAST:event_bt_gerarActionPerformed

    private void txt_valorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorFocusLost
        try{
            Float val = converteValorDigitadoemFloat(txt_valor.getText());
            txt_valor.setText( nf.format(val));
        }catch (Exception e) {
            mensagem =  "Dados inválidos no campo valor!";
            mostraMensagem();
        }
    }//GEN-LAST:event_txt_valorFocusLost

    private void txt_valorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valorKeyReleased
        String excluiPonto = txt_valor.getText();
        txt_valor.setText(excluiPonto.replace(".", ""));
    }//GEN-LAST:event_txt_valorKeyReleased

    private void txt_codigoBarrasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoBarrasFocusLost
        txt_codigoBarras.setText(parametrosNS.fc.FormataCampo(txt_codigoBarras.getText(), 10, 0));
    }//GEN-LAST:event_txt_codigoBarrasFocusLost



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_gerar;
    private javax.swing.JComboBox<String> combo_tipoImpressao;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txt_codigoBarras;
    private javax.swing.JTextField txt_quantidade;
    private javax.swing.JTextField txt_titulo;
    private javax.swing.JTextField txt_valor;
    // End of variables declaration//GEN-END:variables

    private void mostraMensagem() {
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    public Float converteValorDigitadoemFloat(String valor) {
        String formatoFloat = valor;
        formatoFloat = formatoFloat.replace(".", "");
        formatoFloat = formatoFloat.replace(",", ".");
        formatoFloat = formatoFloat.replace("R$ ", "");
        Float val = Float.parseFloat(formatoFloat);
        return val;
    }
}
