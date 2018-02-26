package TelasVendas;

import Beans.BeanIntervalos;
import Beans.BeanParametrosVendas;
import Parametros.parametrosNS;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/*
 @author Tiago e Paulo 22/12/2017 21:50
 */
public class RelatorioDeVendasMensalPorUsuario extends javax.swing.JFrame {
    //String
    String sql          = "";
    String mensagem     = "";
    
    //Vetores ArrayList's
    ArrayList            parametros            = new ArrayList();
    ArrayList<ArrayList> dadosParametrosVendas = new ArrayList();
    
    //Bean
    BeanIntervalos       binter  = new BeanIntervalos();
    BeanParametrosVendas bparven = new BeanParametrosVendas();
    
    //Especiais para Relatórios
    String      jpv         = "";
    JasperPrint jpp         = null;
    HashMap     hm          = new HashMap();
    
    //Especiais
    BufferedImage   buffImg;
    ImageIcon       imgIcon;
    Image           img;
    
    public RelatorioDeVendasMensalPorUsuario() {
        initComponents();
    }
    
    private void InicializaCampos(){
        txt_dataVendaInicial    .setText(parametrosNS.fc.FormataCampo("", 6, 0));
        txt_dataVendaFinal      .setText("999999");
        txt_codigoUsuarioInicial.setText(parametrosNS.fc.FormataCampo("", 3, 0));
        txt_codigoUsuarioFinal  .setText("999");
        
        PegaParametrosVendas();
    }
    
    private void PegaParametrosVendas(){
        sql = "select * from tb_parametrosvendas where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosParametrosVendas = new ArrayList();
        dadosParametrosVendas = parametrosNS.dao.Consulta(sql);
        if(dadosParametrosVendas.isEmpty()){
            mensagem = "Não foram encontrados parametros para vendas!";
            mostraMensagem();
            return;
        }
        PegaDadosParametrosVendas();
    }
    
    private void PegaDadosParametrosVendas(){
        for(int i = 0; i < dadosParametrosVendas.size(); i++){
            if(dadosParametrosVendas.get(0).get(i) != null){
                bparven.idParametrosVendas    = Integer.parseInt(  String.valueOf(dadosParametrosVendas.get(i).get(0)));
            }
            if(dadosParametrosVendas.get(0).get(i) != null){
                bparven.idEmpresa             = Integer.parseInt(  String.valueOf(dadosParametrosVendas.get(i).get(1)));
            }
            if(dadosParametrosVendas.get(0).get(i) != null){
                bparven.codigoGrupo           = Integer.parseInt(  String.valueOf(dadosParametrosVendas.get(i).get(2)));
            }
            if(dadosParametrosVendas.get(0).get(i) != null){
                bparven.codigoEmpresa         = Integer.parseInt(  String.valueOf(dadosParametrosVendas.get(i).get(3)));
            }
            if(dadosParametrosVendas.get(0).get(i) != null){
                bparven.infQtdMenor           = Integer.parseInt(  String.valueOf(dadosParametrosVendas.get(i).get(4)));
            }
            if(dadosParametrosVendas.get(0).get(i) != null){
                bparven.valorDeMeta           = Double.parseDouble(String.valueOf(dadosParametrosVendas.get(i).get(5)));
            }
            if(dadosParametrosVendas.get(0).get(i) != null){
                bparven.porcentagemDeComissao = Double.parseDouble(String.valueOf(dadosParametrosVendas.get(i).get(6)));
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_dataVendaInicial = new javax.swing.JFormattedTextField();
        txt_dataVendaFinal = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_codigoUsuarioInicial = new javax.swing.JFormattedTextField();
        txt_codigoUsuarioFinal = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        bt_imprimir = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de Vendas Mensal por Usuário");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Intervalos de pesquisa   F11 [Geral]");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Data da venda(mês/ano):");

        try {
            txt_dataVendaInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataVendaInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataVendaInicial.setText("00/0000");
        txt_dataVendaInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataVendaInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataVendaInicialFocusLost(evt);
            }
        });
        txt_dataVendaInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataVendaInicialKeyPressed(evt);
            }
        });

        try {
            txt_dataVendaFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataVendaFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataVendaFinal.setText("99/9999");
        txt_dataVendaFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataVendaFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataVendaFinalFocusLost(evt);
            }
        });
        txt_dataVendaFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataVendaFinalKeyPressed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Inicial");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Final");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Usuário:");

        try {
            txt_codigoUsuarioInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoUsuarioInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoUsuarioInicial.setText("000");
        txt_codigoUsuarioInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoUsuarioInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoUsuarioInicialFocusLost(evt);
            }
        });
        txt_codigoUsuarioInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoUsuarioInicialKeyPressed(evt);
            }
        });

        try {
            txt_codigoUsuarioFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoUsuarioFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoUsuarioFinal.setText("999");
        txt_codigoUsuarioFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoUsuarioFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoUsuarioFinalFocusLost(evt);
            }
        });
        txt_codigoUsuarioFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoUsuarioFinalKeyPressed(evt);
            }
        });

        jButton1.setText("...");

        jButton2.setText("...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_dataVendaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoUsuarioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoUsuarioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addComponent(txt_dataVendaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel4, txt_dataVendaFinal, txt_dataVendaInicial});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_dataVendaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dataVendaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_codigoUsuarioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoUsuarioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jLabel2, jLabel3, jLabel4, jLabel5, txt_codigoUsuarioFinal, txt_codigoUsuarioInicial, txt_dataVendaFinal, txt_dataVendaInicial});

        bt_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Print.png"))); // NOI18N
        bt_imprimir.setText("Imprimir");
        bt_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imprimirActionPerformed(evt);
            }
        });

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        bt_sair1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        bt_sair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair1.setText("Sair");
        bt_sair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sair1ActionPerformed(evt);
            }
        });
        jMenu1.add(bt_sair1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_imprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_sair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        InicializaCampos();
    }//GEN-LAST:event_formWindowOpened

    private void txt_dataVendaInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVendaInicialFocusGained
        txt_dataVendaInicial.setSelectionStart(0);
        txt_dataVendaInicial.setSelectionEnd  (txt_dataVendaInicial.getText().length());
    }//GEN-LAST:event_txt_dataVendaInicialFocusGained

    private void txt_dataVendaInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVendaInicialFocusLost
        txt_dataVendaInicial.setText(parametrosNS.fc.FormataCampo(txt_dataVendaInicial.getText(), 6, 0));
        String dataVendaInicial = txt_dataVendaInicial.getText().replace("/", "");
        if(Integer.parseInt(dataVendaInicial) == 0){
            return;
        }
        txt_dataVendaFinal.setText(txt_dataVendaInicial.getText());
    }//GEN-LAST:event_txt_dataVendaInicialFocusLost

    private void txt_dataVendaInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataVendaInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataVendaFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataVendaInicial.setText(parametrosNS.fc.FormataCampo("", 6, 0));
            txt_dataVendaFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataVendaInicialKeyPressed

    private void txt_dataVendaFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVendaFinalFocusGained
        txt_dataVendaFinal.setSelectionStart(0);
        txt_dataVendaFinal.setSelectionEnd  (txt_dataVendaFinal.getText().length());
    }//GEN-LAST:event_txt_dataVendaFinalFocusGained

    private void txt_dataVendaFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVendaFinalFocusLost
        txt_dataVendaFinal.setText(parametrosNS.fc.FormataCampo(txt_dataVendaFinal.getText(), 6, 0));
    }//GEN-LAST:event_txt_dataVendaFinalFocusLost

    private void txt_codigoUsuarioInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoUsuarioInicialFocusGained
        txt_codigoUsuarioInicial.setSelectionStart(0);
        txt_codigoUsuarioInicial.setSelectionEnd  (txt_codigoUsuarioInicial.getText().length());
    }//GEN-LAST:event_txt_codigoUsuarioInicialFocusGained

    private void txt_codigoUsuarioInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoUsuarioInicialFocusLost
        txt_codigoUsuarioInicial.setText(parametrosNS.fc.FormataCampo(txt_codigoUsuarioInicial.getText(), 3, 0));
    }//GEN-LAST:event_txt_codigoUsuarioInicialFocusLost

    private void txt_codigoUsuarioInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoUsuarioInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoUsuarioFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoUsuarioInicial.setText(parametrosNS.fc.FormataCampo("", 3, 0));
            txt_codigoUsuarioFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoUsuarioInicialKeyPressed

    private void txt_codigoUsuarioFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoUsuarioFinalFocusGained
        txt_codigoUsuarioFinal.setSelectionStart(0);
        txt_codigoUsuarioFinal.setSelectionEnd  (txt_codigoUsuarioFinal.getText().length());
    }//GEN-LAST:event_txt_codigoUsuarioFinalFocusGained

    private void txt_codigoUsuarioFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoUsuarioFinalFocusLost
        txt_codigoUsuarioFinal.setText(parametrosNS.fc.FormataCampo(txt_codigoUsuarioFinal.getText(), 3, 0));
    }//GEN-LAST:event_txt_codigoUsuarioFinalFocusLost

    private void txt_codigoUsuarioFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoUsuarioFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoUsuarioFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoUsuarioFinal.setText("99999999");
            bt_imprimir.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoUsuarioFinalKeyPressed

    private void txt_dataVendaFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataVendaFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoUsuarioInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataVendaFinal.setText("99999999");
            txt_codigoUsuarioInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataVendaFinalKeyPressed

    private void bt_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimirActionPerformed
        ImprimirRelatorioDeVendasMensalPorUsuario();
    }//GEN-LAST:event_bt_imprimirActionPerformed

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        Sair();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        Sair();
    }//GEN-LAST:event_bt_sairActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_imprimir;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txt_codigoUsuarioFinal;
    private javax.swing.JFormattedTextField txt_codigoUsuarioInicial;
    private javax.swing.JFormattedTextField txt_dataVendaFinal;
    private javax.swing.JFormattedTextField txt_dataVendaInicial;
    // End of variables declaration//GEN-END:variables
    
    private void Sair(){
        dispose();
    }
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    private void ImprimirRelatorioDeVendasMensalPorUsuario(){
        binter.dataVendaInicial = parametrosNS.Test.Testa("01/" + txt_dataVendaInicial.getText());
        binter.dataVendaFinal   = parametrosNS.Test.Testa("31/" + txt_dataVendaFinal.getText());
        if(binter.dataVendaInicial > binter.dataVendaFinal){
            mensagem = "Data Inicial não pode ser maior do que a Data Final!";
            mostraMensagem();
            return;
        }
        
        binter.usuarioInicial   = Integer.parseInt(txt_codigoUsuarioInicial.getText());
        binter.usuarioFinal     = Integer.parseInt(txt_codigoUsuarioFinal.getText());
        if(binter.usuarioInicial > binter.usuarioFinal){
            mensagem = "Usuário final não pode ser maior do que o usuário final!";
            mostraMensagem();
            return;
        }
        try{
            img = null;
            if(parametrosNS.be.ImagemLogotipoEmpresa != null){
                buffImg = ImageIO.read(new ByteArrayInputStream(parametrosNS.be.ImagemLogotipoEmpresa));
                imgIcon = new ImageIcon(buffImg);
                img     = imgIcon.getImage();
            }
            hm.clear();
            hm.put("idEmpresa"      , parametrosNS.be.IdEmpresa);
            hm.put("nomeEmpresa"    , parametrosNS.be.NomeEmpresa);
            hm.put("cnpjEmpresa"    , parametrosNS.be.CnpjEmpresa);
            hm.put("cidadeEmpresa"  , parametrosNS.be.CidadeEmpresa + ", " + parametrosNS.be.UfEmpresa);
            hm.put("enderecoEmpresa", parametrosNS.be.EnderecoEmpresa + ", " + parametrosNS.be.NumeroEmpresa + ", " + parametrosNS.be.BairroEmpresa);
            hm.put("cepEmpresa"     , parametrosNS.be.CepEmpresa);
            hm.put("telefoneEmpresa", parametrosNS.be.TelefoneEmpresa);
            if(parametrosNS.be.ImagemLogotipoEmpresa != null){
                hm.put("logotipoEmpresa", img);
            }else{
                hm.put("logotipoEmpresa", null);
            }
            if(txt_dataVendaInicial.getText().equals(txt_dataVendaFinal.getText())){
                hm.put("intervaloSelecionado", "Intervalo selecionado para o mês " + txt_dataVendaInicial.getText() + ".");
            }else{
                hm.put("intervaloSelecionado", "Intervalo selecionado para o mês " + txt_dataVendaInicial.getText() + " até " + txt_dataVendaFinal.getText() + ".");
            }
            hm.put("valorDeMeta"         , bparven.valorDeMeta);
            hm.put("dataVendaInicial"    , binter.dataVendaInicial);
            hm.put("dataVendaFinal"      , binter.dataVendaFinal);
            hm.put("codigoUsuarioInicial", binter.usuarioInicial);
            hm.put("codigoUsuarioFinal"  , binter.usuarioFinal);
            
            jpv = "Relatorios/RelatorioDeVendaMensalPorUsuario.jasper";
            jpp = JasperFillManager.fillReport(jpv, hm, parametrosNS.con);
            JasperViewer.viewReport(jpp, false);
        }catch(Exception erro){
            mensagem = "Erro ao imprimir: " + erro.getMessage();
            mostraMensagem();
        }
    }
    
}
