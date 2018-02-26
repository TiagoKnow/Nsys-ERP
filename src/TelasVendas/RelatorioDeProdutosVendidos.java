package TelasVendas;

import Beans.BeanIntervalos;
import Parametros.parametrosNS;
import TelasEstoque.ProdutosConsulta;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/*
 @author Paulo e Tiago 30/08/2017 15:57
 */
public class RelatorioDeProdutosVendidos extends javax.swing.JFrame {
    //String
    String sql              = "";
    String sqlstate         = "";
    String campo            = "";
    String mensagem         = "";
    String retorno          = "";
    
    //int
    int    abriuProdutos    = 0;
    
    //ArrayList
    ArrayList            parametros     = new ArrayList();
    ArrayList<ArrayList> dadosProdutos  = new ArrayList();
    
    //Bean
    BeanIntervalos  binter  = new BeanIntervalos();
    
    //Especiais para Relatórios
    String      jpv         = "";
    JasperPrint jpp         = null;
    HashMap     hm          = new HashMap();
    
    //Especiais
    BufferedImage   buffImg;
    ImageIcon       imgIcon;
    Image           img;
    
    //Telas
    ProdutosConsulta    ProCon;
    
    public RelatorioDeProdutosVendidos() {
        initComponents();
    }
    
    private void InicializaCampos(){
        txt_codigoProdutoInicial    .setText(parametrosNS.fc.FormataCampo("", 6, 0));
        txt_codigoProdutoFinal      .setText("999999");
        txt_dataVendaInicial        .setText(parametrosNS.fc.FormataCampo("", 8, 0));
        txt_dataVendaFinal          .setText(parametrosNS.cdh.CapturarData());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigoProdutoInicial = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        bt_pesquisaProdutoInicial = new javax.swing.JButton();
        txt_codigoProdutoFinal = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        bt_pesquisaProdutoFinal = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_dataVendaInicial = new javax.swing.JFormattedTextField();
        txt_dataVendaFinal = new javax.swing.JFormattedTextField();
        bt_imprimir = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatórios de Produtos Vendidos");
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
        jLabel1.setText("Relatórios de Produtos Vendidos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Código do Produto");

        try {
            txt_codigoProdutoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoProdutoInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoProdutoInicial.setText("000000");
        txt_codigoProdutoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoProdutoInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoProdutoInicialFocusLost(evt);
            }
        });
        txt_codigoProdutoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoProdutoInicialKeyPressed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Inicial");

        bt_pesquisaProdutoInicial.setText("...");
        bt_pesquisaProdutoInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaProdutoInicialActionPerformed(evt);
            }
        });

        try {
            txt_codigoProdutoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoProdutoFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoProdutoFinal.setText("999999");
        txt_codigoProdutoFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoProdutoFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoProdutoFinalFocusLost(evt);
            }
        });
        txt_codigoProdutoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoProdutoFinalKeyPressed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Final");

        bt_pesquisaProdutoFinal.setText("...");
        bt_pesquisaProdutoFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaProdutoFinalActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Data da Venda:");

        try {
            txt_dataVendaInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataVendaInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataVendaInicial.setText("00/00/0000");
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
            txt_dataVendaFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataVendaFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataVendaFinal.setText("99/99/9999");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_codigoProdutoInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(txt_dataVendaInicial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_pesquisaProdutoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_dataVendaFinal)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_codigoProdutoFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_pesquisaProdutoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel4, txt_codigoProdutoFinal, txt_codigoProdutoInicial});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel5});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoProdutoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaProdutoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoProdutoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaProdutoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_dataVendaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dataVendaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaProdutoFinal, bt_pesquisaProdutoInicial, jLabel2, jLabel3, jLabel4, jLabel5, txt_codigoProdutoFinal, txt_codigoProdutoInicial});

        bt_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/print.png"))); // NOI18N
        bt_imprimir.setText("Imprimir");
        bt_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imprimirActionPerformed(evt);
            }
        });

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");

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

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_imprimir, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        InicializaCampos();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        
    }//GEN-LAST:event_formWindowGainedFocus

    private void txt_codigoProdutoInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoProdutoInicialFocusGained
        txt_codigoProdutoInicial.setSelectionStart(0);
        txt_codigoProdutoInicial.setSelectionEnd  (txt_codigoProdutoInicial.getText().length());
    }//GEN-LAST:event_txt_codigoProdutoInicialFocusGained

    private void txt_codigoProdutoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoProdutoInicialFocusLost
        txt_codigoProdutoInicial.setText(parametrosNS.fc.FormataCampo(txt_codigoProdutoInicial.getText(), 6, 0));
    }//GEN-LAST:event_txt_codigoProdutoInicialFocusLost

    private void txt_codigoProdutoInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoProdutoInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoProdutoFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoProdutoInicial.setText(parametrosNS.fc.FormataCampo("", 6, 0));
            txt_codigoProdutoFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoProdutoInicialKeyPressed

    private void txt_codigoProdutoFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoProdutoFinalFocusGained
        txt_codigoProdutoFinal.setSelectionStart(0);
        txt_codigoProdutoFinal.setSelectionEnd  (txt_codigoProdutoFinal.getText().length());
    }//GEN-LAST:event_txt_codigoProdutoFinalFocusGained

    private void txt_codigoProdutoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoProdutoFinalFocusLost
        txt_codigoProdutoFinal.setText(parametrosNS.fc.FormataCampo(txt_codigoProdutoFinal.getText(), 6, 0));
    }//GEN-LAST:event_txt_codigoProdutoFinalFocusLost

    private void txt_codigoProdutoFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoProdutoFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataVendaInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoProdutoFinal.setText("999999");
            txt_dataVendaInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoProdutoFinalKeyPressed

    private void txt_dataVendaInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVendaInicialFocusGained
        txt_dataVendaInicial.setSelectionStart(0);
        txt_dataVendaInicial.setSelectionEnd  (txt_dataVendaInicial.getText().length());
    }//GEN-LAST:event_txt_dataVendaInicialFocusGained

    private void txt_dataVendaInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVendaInicialFocusLost
        txt_dataVendaInicial.setText(parametrosNS.fc.FormataCampo(txt_dataVendaInicial.getText(), 8, 0));
    }//GEN-LAST:event_txt_dataVendaInicialFocusLost

    private void txt_dataVendaInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataVendaInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataVendaFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataVendaInicial.setText(parametrosNS.fc.FormataCampo("", 8, 0));
            txt_dataVendaFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataVendaInicialKeyPressed

    private void txt_dataVendaFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVendaFinalFocusGained
        txt_dataVendaFinal.setSelectionStart(0);
        txt_dataVendaFinal.setSelectionEnd  (txt_dataVendaFinal.getText().length());
    }//GEN-LAST:event_txt_dataVendaFinalFocusGained

    private void txt_dataVendaFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVendaFinalFocusLost
        txt_dataVendaFinal.setText(parametrosNS.fc.FormataCampo(txt_dataVendaFinal.getText(), 8, 0));
    }//GEN-LAST:event_txt_dataVendaFinalFocusLost

    private void txt_dataVendaFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataVendaFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            bt_imprimir.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataVendaFinal.setText(parametrosNS.cdh.CapturarData());
            bt_imprimir.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataVendaFinalKeyPressed

    private void bt_pesquisaProdutoInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaProdutoInicialActionPerformed
        campo = "I";
        PesquisaProdutos();
    }//GEN-LAST:event_bt_pesquisaProdutoInicialActionPerformed
    
    private void PesquisaProdutos(){
        if(ProCon != null){
            if(ProCon.isVisible()){
                ProCon.setState(JFrame.NORMAL);
                return;
            }
        }
        abriuProdutos = 1;
        parametros.clear();
        parametros.add("N");
        parametros.add("");
        ProCon = new ProdutosConsulta(parametros);
        ProCon.setVisible(true);
    }
    
    private void bt_pesquisaProdutoFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaProdutoFinalActionPerformed
        campo = "F";
        PesquisaProdutos();
    }//GEN-LAST:event_bt_pesquisaProdutoFinalActionPerformed

    private void bt_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimirActionPerformed
        ImprimirRelatorioDeProdutosMaisVendidos();
    }//GEN-LAST:event_bt_imprimirActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_imprimir;
    private javax.swing.JButton bt_pesquisaProdutoFinal;
    private javax.swing.JButton bt_pesquisaProdutoInicial;
    private javax.swing.JButton bt_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txt_codigoProdutoFinal;
    private javax.swing.JFormattedTextField txt_codigoProdutoInicial;
    private javax.swing.JFormattedTextField txt_dataVendaFinal;
    private javax.swing.JFormattedTextField txt_dataVendaInicial;
    // End of variables declaration//GEN-END:variables
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    private void ImprimirRelatorioDeProdutosMaisVendidos(){
        binter.produtoInicial   = Integer.parseInt(txt_codigoProdutoInicial.getText());
        binter.produtoFinal     = Integer.parseInt(txt_codigoProdutoFinal.getText());
        if(binter.produtoInicial > binter.produtoFinal){
            mensagem = "Produto inicial não pode ser maior do que produto final!";
            mostraMensagem();
            return;
        }
        
        binter.dataVendaInicial = parametrosNS.Test.Testa(txt_dataVendaInicial.getText());
        binter.dataVendaFinal   = parametrosNS.Test.Testa(txt_dataVendaFinal.getText());
        if(binter.dataVendaInicial > binter.dataVendaFinal){
            mensagem = "Data de venda inicial não pode ser maior do que a venda final!";
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
            if(parametrosNS.be.ImagemLogotipoEmpresa != null)
                hm.put("logotipoEmpresa", img);
            else
                hm.put("logotipoEmpresa", null);
            
            hm.put("intervaloSelecionado", "Relatório de produtos mais vendidos entre o dia " + parametrosNS.invdata.inverterData(parametrosNS.fc.FormataCampo(String.valueOf(binter.dataVendaInicial), 8, 0), 1) + " e " + parametrosNS.invdata.inverterData(parametrosNS.fc.FormataCampo(String.valueOf(binter.dataVendaFinal), 8, 0), 1) + ".");
            hm.put("dataVendaInicial"    , binter.dataVendaInicial);
            hm.put("dataVendaFinal"      , binter.dataVendaFinal);
            hm.put("codigoProdutoInicial", binter.produtoInicial);
            hm.put("codigoProdutoFinal"  , binter.produtoFinal);
            
            jpv = "Relatorios/RelatorioGeralDeProdutosVendidos.jasper";
            
            jpp = JasperFillManager.fillReport(jpv, hm, parametrosNS.con);
            JasperViewer.viewReport(jpp, false);
        }catch(Exception erro){
            mensagem = "Erro ao imprimir: " + erro.getMessage();
            mostraMensagem();
        }
    }
    
}
