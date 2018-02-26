package TelasContasCorrente;

import Beans.BeanBoletos;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.ConverteValorDigitadoEmDouble;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.TransformaValorStringeDouble;
import FuncoesInternas.ValidarData;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 @author Tiago e Paulo
 */

public class BaixaManualDeBoletos extends javax.swing.JFrame {
    //String
    String sql                              = "";
    String fatal                            = "";
    String Mensagem                         = "";
    String sqlstate                         = "";
    
    //Vetores
    ArrayList            parametros                    = new ArrayList();
    ArrayList            dadosPadroes                  = new ArrayList();
    ArrayList<ArrayList> dadosBoletos                  = new ArrayList();
    
    //Bean's
    BeanBoletos                     bbol    = new BeanBoletos();
    
    //Funções
    FormataCampo                    fc          = new FormataCampo();
    InverterData                    invdata     = new InverterData();
    CapturarDataHora                cdh         = new CapturarDataHora();
    ValidarData                     ValData     = new ValidarData();
    TransformaValorStringeDouble    TransStrDou = new TransformaValorStringeDouble();
    
    //Inicia
    
    //Beans
    public BaixaManualDeBoletos(ArrayList DadosPadroes){
        dadosPadroes = DadosPadroes;
        
        bbol.codigoBoleto       = (int)     dadosPadroes.get(0);
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_codigoBoleto = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_valorPago = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_dataPagamento = new javax.swing.JFormattedTextField();
        bt_baixar = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Baixa Manual de Boletos");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Boleto");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_codigoBoleto.setEditable(false);
        try {
            txt_codigoBoleto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoBoleto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoBoleto.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_codigoBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_codigoBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Informações para Baixa");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_valorPago.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_valorPagoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorPagoFocusLost(evt);
            }
        });
        txt_valorPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_valorPagoKeyPressed(evt);
            }
        });

        jLabel3.setText("Valor pago: ");

        jLabel4.setText("Data de Pagamento: ");

        try {
            txt_dataPagamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataPagamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataPagamento.setText("00/00/0000");
        txt_dataPagamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataPagamentoFocusGained(evt);
            }
        });
        txt_dataPagamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataPagamentoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_valorPago, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_dataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_valorPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txt_dataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        bt_baixar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Down.png"))); // NOI18N
        bt_baixar.setText("Baixar");
        bt_baixar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_baixarActionPerformed(evt);
            }
        });

        bt_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_cancelar.setText("Sair");
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_baixar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_baixar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel1, jPanel2});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_dataPagamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataPagamentoFocusGained
        txt_dataPagamento.setSelectionStart(0);
        txt_dataPagamento.setSelectionEnd  (txt_dataPagamento.getText().length());
    }//GEN-LAST:event_txt_dataPagamentoFocusGained

    private void txt_dataPagamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataPagamentoKeyPressed
        
    }//GEN-LAST:event_txt_dataPagamentoKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        PegaBoleto();
    }//GEN-LAST:event_formWindowOpened

    private void txt_valorPagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valorPagoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            txt_dataPagamento.grabFocus();
    }//GEN-LAST:event_txt_valorPagoKeyPressed

    private void bt_baixarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_baixarActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Confirma baixa do boleto n°" + bbol.codigoBoleto + "?", "", JOptionPane.YES_NO_OPTION) != 0)
            return;
        BaixarBoleto();
    }//GEN-LAST:event_bt_baixarActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowGainedFocus

    private void txt_valorPagoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorPagoFocusGained
        if(!txt_valorPago.getText().equals(""))
            txt_valorPago.setText(TransStrDou.TransformaValorStringeDouble(txt_valorPago.getText(), 1));
        txt_valorPago.setSelectionStart(0);
        txt_valorPago.setSelectionEnd  (txt_valorPago.getText().length());
    }//GEN-LAST:event_txt_valorPagoFocusGained

    private void txt_valorPagoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorPagoFocusLost
        if(!txt_valorPago.getText().equals(""))
            txt_valorPago.setText(TransStrDou.TransformaValorStringeDouble(txt_valorPago.getText(), 0));
        txt_valorPago.setSelectionStart(0);
        txt_valorPago.setSelectionEnd  (txt_valorPago.getText().length());
    }//GEN-LAST:event_txt_valorPagoFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_baixar;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JFormattedTextField txt_codigoBoleto;
    private javax.swing.JFormattedTextField txt_dataPagamento;
    private javax.swing.JTextField txt_valorPago;
    // End of variables declaration//GEN-END:variables
    
    private void PegaBoleto(){
        txt_codigoBoleto.setText(fc.FormataCampo(String.valueOf(bbol.codigoBoleto), 8, 0));
        bbol.codigoBoleto       = Integer.parseInt(txt_codigoBoleto.getText());
        if(bbol.codigoBoleto == 0)
            return;
        sql = "select * from tb_boletos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoBoleto = " + bbol.codigoBoleto + ";";
        dadosBoletos.clear();
        dadosBoletos = parametrosNS.dao.Consulta(sql);
        PegaDadosBoleto();
    }
    
    private void PegaDadosBoleto(){
        for(int i = 0; i < dadosBoletos.size(); i++){
            bbol.idBoletos              = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(0)));
            bbol.idEmpresa              = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(1)));
            bbol.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(2)));
            bbol.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(3)));
            bbol.codigoBoleto           = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(4)));
        }
        txt_valorPago.grabFocus();
    }
    
    private void PegaValores(){
        fatal = "N";
        bbol.valorPago              = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_valorPago.getText(), 1));
        bbol.dataDePagamento        = txt_dataPagamento.getText();
        bbol.dataDePagamento        = bbol.dataDePagamento.replace(" ", "");
        bbol.dataDePagamento        = bbol.dataDePagamento.replace("/", "");
        if(bbol.dataDePagamento.equals("") || ValData.ValidaData(bbol.dataDePagamento).equals("N")){
            Mensagem = "Data de Pagamento inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bbol.dataDePagamento        = invdata.inverterData(bbol.dataDePagamento, 2);
        bbol.idEmpresaAlterou       = parametrosNS.be.idEmpresa;
        bbol.codigoGrupoAlterou     = parametrosNS.bge.codigoGrupo;
        bbol.codigoEmpresaAlterou   = parametrosNS.be.codigoEmpresa;
        bbol.dataAlterou            = invdata.inverterData(cdh.CapturarData(), 2);
        bbol.horaAlterou            = cdh.CapturaHora();
        bbol.usuarioAlterou         = parametrosNS.bu.codigoUsuario;
    }
    
    private void BaixarBoleto(){
        PegaValores();
        if(fatal.equals("S"))
            return;
        String valorPago = "";
        valorPago = String.valueOf(bbol.valorPago);
        if(bbol.valorPago == 0){
            valorPago = "null";
        }
        sql = "update tb_boletos set valorPago = "              + bbol.valorPago            + ", "
                                  + "dataDePagamento = '"       + bbol.dataDePagamento      + "', "
                                  + "Ocorrencia = 6, "
                                  + "idEmpresaAlterou = "       + bbol.idEmpresaAlterou     + ", "
                                  + "codigoGrupoAlterou = "     + bbol.codigoGrupoAlterou   + ", "
                                  + "codigoEmpresaAlterou = "   + bbol.codigoEmpresaAlterou + ", "
                                  + "dataAlterou = '"           + bbol.dataAlterou          + "', "
                                  + "horaAlterou = '"           + bbol.horaAlterou          + "', "
                                  + "usuarioAlterou = "         + bbol.usuarioAlterou       + " "
                                  + "where idBoletos = "        + bbol.idBoletos + ";";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        Mensagem = "Boleto baixado com sucesso!";
        new MostraMensagem(Mensagem);
        dispose();
    }
}
