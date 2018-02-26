package RelatoriosVendas;

import Beans.BeanIntervalos;
import Beans.BeanParametros;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.TestarData;
import Parametros.parametrosNS;
import Telas.ComputadoresConsulta;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import java.util.*;

/*
 @author Paulo
 */
public class RelatorioFechamentoCaixaGeral extends javax.swing.JFrame {
    //String
    String gssql      = "";
    String gsmensagem = "";
    String gscampo    = "";
    String gsretorno  = "";
    
    //int
    int abriuComputador = 0;
    
    //Vetores
    ArrayList<ArrayList> dadosParametros   = new ArrayList(); 
   
    //Beans
    BeanIntervalos  binter  = new BeanIntervalos();
    BeanParametros  bpar    = new BeanParametros();
    
    //Funções
    FormataCampo fc     = new FormataCampo();
    TestarData   Test   = new TestarData();
    
    //Telas
    ComputadoresConsulta  CompCon;
    
    //Especiais para Relatórios
    String      jpv         = "";
    JasperPrint jpp         = null;
    HashMap     hm          = new HashMap();
    
    //Especiais
    BufferedImage buffImg;
    ImageIcon     imgIcon;
    Image         img;
    
    public RelatorioFechamentoCaixaGeral(){
        initComponents();
    }
    
    private void InicializaCampos(){
        txt_codigoComputadorInicial.setText(parametrosNS.fc.FormataCampo("", 2, 0));
        txt_codigoComputadorFinal  .setText("99");
        txt_dataAberturaInicial    .setText(parametrosNS.cdh.CapturarData());
        txt_dataAberturaFinal      .setText(parametrosNS.cdh.CapturarData());
        PegaParametros();
    }
    
    private void PegaParametros(){
        gssql = "select * from tb_parametros where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosParametros.clear();
        dadosParametros = parametrosNS.dao.Consulta(gssql);
        if(dadosParametros.isEmpty()){
            return;
        }
        PegaDadosParametros();
    }
    
    private void PegaDadosParametros(){
        for(int i = 0; i < dadosParametros.size(); i++){
            bpar.idParametros       = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(0)));
            bpar.idEmpresa          = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(1)));
            bpar.codigoGrupo        = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(2)));
            bpar.codigoEmpresa      = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(3)));
            bpar.pastaRelatorios    =                    String.valueOf(dadosParametros.get(i).get(4));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_dataAberturaInicial = new javax.swing.JFormattedTextField();
        txt_dataAberturaFinal = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_codigoComputadorInicial = new javax.swing.JFormattedTextField();
        bt_pesquisaCodigoComputadorInicial = new javax.swing.JButton();
        txt_codigoComputadorFinal = new javax.swing.JFormattedTextField();
        bt_pesquisaCodigoComputadorFinal = new javax.swing.JButton();
        bt_imprimir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de fechamento de caixa");
        setResizable(false);
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Intervalos de pesquisa    F11[Geral]");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Data do Caixa:");

        try {
            txt_dataAberturaInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataAberturaInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataAberturaInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataAberturaInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataAberturaInicialFocusLost(evt);
            }
        });
        txt_dataAberturaInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataAberturaInicialKeyPressed(evt);
            }
        });

        try {
            txt_dataAberturaFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataAberturaFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataAberturaFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataAberturaFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataAberturaFinalFocusLost(evt);
            }
        });
        txt_dataAberturaFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataAberturaFinalKeyPressed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Inicial");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Final");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Computador:");

        try {
            txt_codigoComputadorInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoComputadorInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoComputadorInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoComputadorInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoComputadorInicialFocusLost(evt);
            }
        });
        txt_codigoComputadorInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoComputadorInicialKeyPressed(evt);
            }
        });

        bt_pesquisaCodigoComputadorInicial.setText("...");
        bt_pesquisaCodigoComputadorInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaCodigoComputadorInicialActionPerformed(evt);
            }
        });

        try {
            txt_codigoComputadorFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoComputadorFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoComputadorFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoComputadorFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoComputadorFinalFocusLost(evt);
            }
        });
        txt_codigoComputadorFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoComputadorFinalKeyPressed(evt);
            }
        });

        bt_pesquisaCodigoComputadorFinal.setText("jButton3");
        bt_pesquisaCodigoComputadorFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaCodigoComputadorFinalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoComputadorInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisaCodigoComputadorInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_dataAberturaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_dataAberturaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoComputadorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisaCodigoComputadorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_codigoComputadorInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaCodigoComputadorInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoComputadorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaCodigoComputadorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_dataAberturaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dataAberturaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaCodigoComputadorFinal, bt_pesquisaCodigoComputadorInicial, jLabel2, jLabel3, jLabel4, jLabel5, txt_codigoComputadorFinal, txt_codigoComputadorInicial, txt_dataAberturaFinal, txt_dataAberturaInicial});

        bt_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/print.png"))); // NOI18N
        bt_imprimir.setText("Imprimir");
        bt_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imprimirActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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
                        .addComponent(jButton2)))
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
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_imprimir, jButton2});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        InicializaCampos();
    }//GEN-LAST:event_formWindowOpened

    private void txt_dataAberturaInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataAberturaInicialFocusGained
        txt_dataAberturaInicial.setSelectionStart(0);
        txt_dataAberturaInicial.setSelectionEnd  (txt_dataAberturaInicial.getText().length());
    }//GEN-LAST:event_txt_dataAberturaInicialFocusGained

    private void txt_dataAberturaInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataAberturaInicialFocusLost
        txt_dataAberturaInicial.setText(fc.FormataCampo(txt_dataAberturaInicial.getText(), 8, 0));
    }//GEN-LAST:event_txt_dataAberturaInicialFocusLost

    private void txt_dataAberturaInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataAberturaInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataAberturaFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataAberturaInicial.setText(fc.FormataCampo("", 8, 0));
            txt_dataAberturaFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataAberturaInicialKeyPressed

    private void txt_dataAberturaFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataAberturaFinalFocusGained
        txt_dataAberturaFinal.setSelectionStart(0);
        txt_dataAberturaFinal.setSelectionEnd  (txt_dataAberturaFinal.getText().length());
    }//GEN-LAST:event_txt_dataAberturaFinalFocusGained

    private void txt_dataAberturaFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataAberturaFinalFocusLost
        txt_dataAberturaFinal.setText(fc.FormataCampo(txt_dataAberturaFinal.getText(), 8, 0));
    }//GEN-LAST:event_txt_dataAberturaFinalFocusLost

    private void txt_dataAberturaFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataAberturaFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            bt_imprimir.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataAberturaFinal.setText("99999999");
            bt_imprimir.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataAberturaFinalKeyPressed

    private void bt_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimirActionPerformed
        ImprimirRelatorioVendasGeral();
    }//GEN-LAST:event_bt_imprimirActionPerformed

    private void txt_codigoComputadorInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoComputadorInicialFocusGained
        txt_codigoComputadorInicial.setSelectionStart(0);
        txt_codigoComputadorInicial.setSelectionEnd  (txt_codigoComputadorInicial.getText().length());
    }//GEN-LAST:event_txt_codigoComputadorInicialFocusGained

    private void txt_codigoComputadorInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoComputadorInicialFocusLost
        txt_codigoComputadorInicial.setText(fc.FormataCampo(txt_codigoComputadorInicial.getText(), 2, 0));
    }//GEN-LAST:event_txt_codigoComputadorInicialFocusLost

    private void txt_codigoComputadorInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoComputadorInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoComputadorFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoComputadorInicial.setText(fc.FormataCampo("", 2, 0));
            txt_codigoComputadorFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoComputadorInicialKeyPressed

    private void txt_codigoComputadorFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoComputadorFinalFocusGained
        txt_codigoComputadorFinal.setSelectionStart(0);
        txt_codigoComputadorFinal.setSelectionEnd  (txt_codigoComputadorFinal.getText().length());
    }//GEN-LAST:event_txt_codigoComputadorFinalFocusGained

    private void txt_codigoComputadorFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoComputadorFinalFocusLost
        txt_codigoComputadorFinal.setText(fc.FormataCampo(txt_codigoComputadorFinal.getText(), 2, 0));
    }//GEN-LAST:event_txt_codigoComputadorFinalFocusLost

    private void txt_codigoComputadorFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoComputadorFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataAberturaInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoComputadorFinal.setText("99");
            txt_dataAberturaInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoComputadorFinalKeyPressed
    
    private void bt_pesquisaCodigoComputadorInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaCodigoComputadorInicialActionPerformed
        gscampo = "I";
        PesquisaComputador();
    }//GEN-LAST:event_bt_pesquisaCodigoComputadorInicialActionPerformed
    
    private void PesquisaComputador(){
        if(CompCon != null)if(CompCon.isVisible()){
            gsmensagem = "Tela já aberta!";
            new MostraMensagem(gsmensagem);
            return;
        }
        abriuComputador = 1;
        CompCon = new ComputadoresConsulta();
        CompCon.setVisible(true);
    }
    
    private void bt_pesquisaCodigoComputadorFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaCodigoComputadorFinalActionPerformed
        gscampo = "F";
        PesquisaComputador();
    }//GEN-LAST:event_bt_pesquisaCodigoComputadorFinalActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuComputador == 0)
            return;
        abriuComputador = 0;
        gsretorno = CompCon.getRetorno();
        if(gsretorno.equals(""))
            return;
        if(gscampo.equals("I")){
            txt_codigoComputadorInicial.setText(fc.FormataCampo(gsretorno, 2, 0));
            return;
        }
        txt_codigoComputadorFinal.setText(fc.FormataCampo(gsretorno, 2, 0));
    }//GEN-LAST:event_formWindowGainedFocus

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_imprimir;
    private javax.swing.JButton bt_pesquisaCodigoComputadorFinal;
    private javax.swing.JButton bt_pesquisaCodigoComputadorInicial;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txt_codigoComputadorFinal;
    private javax.swing.JFormattedTextField txt_codigoComputadorInicial;
    private javax.swing.JFormattedTextField txt_dataAberturaFinal;
    private javax.swing.JFormattedTextField txt_dataAberturaInicial;
    // End of variables declaration//GEN-END:variables
    
    private void ImprimirRelatorioVendasGeral(){
        binter.codigoComputadorInicial  = Integer.parseInt(txt_codigoComputadorInicial.getText());
        binter.codigoComputadorFinal    = Integer.parseInt(txt_codigoComputadorFinal.getText());
        if(binter.codigoComputadorInicial > binter.codigoComputadorFinal){
            gsmensagem = "Computador inicial não pode ser maior do que computador final!";
            new MostraMensagem(gsmensagem);
            return;
        }
        
        binter.dataAberturaInicial  = Test.Testa(txt_dataAberturaInicial.getText());
        binter.dataAberturaFinal    = Test.Testa(txt_dataAberturaFinal.getText());
        if(binter.dataAberturaInicial > binter.dataAberturaFinal){
            gsmensagem = "Data de fechamento inicial não pode ser maior do que data de fechamento final!";
            new MostraMensagem(gsmensagem);
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
            
            if(parametrosNS.be.ImagemLogotipoEmpresa != null)
                hm.put("logotipoEmpresa", img);
            else
                hm.put("logotipoEmpresa", null);
            
            hm.put("codigoComputadorInicial", binter.codigoComputadorInicial);
            hm.put("codigoComputadorFinal"  , binter.codigoComputadorFinal);
            hm.put("dataAberturaInicial"    , binter.dataAberturaInicial);
            hm.put("dataAberturaFinal"      , binter.dataAberturaFinal);
            
            jpv     = "Relatorios/RelatorioDeFechamentoDeCaixa.jasper";
            
            jpp     = JasperFillManager.fillReport(jpv, hm, parametrosNS.con);
            JasperViewer.viewReport(jpp, false);
        }catch(Exception erro){
            gsmensagem = "Erro ao imprimir: " + erro.getMessage();
            new MostraMensagem(gsmensagem);
        }
    }
    
}
