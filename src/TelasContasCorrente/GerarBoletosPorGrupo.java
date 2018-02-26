package TelasContasCorrente;

import Beans.BeanClientes;
import Beans.BeanIntervalos;
import Beans.BeanParametros;
import Beans.BeanParametrosCC;
import BeansNS.BeanBanco;
import TelasFaturamento.ClientesConsulta;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.TestarData;
import Parametros.parametrosNS;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/*
 @author Paulo
 */
public class GerarBoletosPorGrupo extends javax.swing.JFrame {
    //String's
    String sql           = "";
    String fatal         = "";
    String retorno       = "";
    String mensagem      = "";
    String preenchimento = "";
    
    //int's
    int abriuCliente = 0;
    
    //Bean's
    BeanBanco        bb     = new BeanBanco();
    BeanClientes     bc     = new BeanClientes();
    BeanIntervalos   binter = new BeanIntervalos();
    BeanParametros   bpar   = new BeanParametros();
    BeanParametrosCC bparcc = new BeanParametrosCC();
    
    //ArrayList's
    ArrayList<ArrayList> dadosCliente      = new ArrayList();
    ArrayList<ArrayList> dadosBoletos      = new ArrayList();
    ArrayList<ArrayList> dadosParametros = new ArrayList();
    ArrayList<ArrayList> dadosParametrosCC = new ArrayList();
    
    //Outros
    FormataCampo     fc   = new FormataCampo();
    CapturarDataHora cdh  = new CapturarDataHora();
    TestarData       Test = new TestarData();
    
    //Telas
    ClientesConsulta CliCon;
    
    //Especiais Para Boletos
    String                jpv     = "";
    JasperPrint           jpp     = null;
    HashMap               hm      = new HashMap();
    
    //Especiais
    BufferedImage                   BuffImg;
    ByteArrayOutputStream           BytesImg;
    ImageIcon                       imgIcon;
    Image                           img;
    
    public GerarBoletosPorGrupo(){
        initComponents();
    }
    
    private void InicializaCampos(){
        txt_dataEmissaoInicial.setText(cdh.CapturarData());
        txt_dataEmissaoFinal  .setText(cdh.CapturarData());
        txt_codigoCliente     .setText(fc.FormataCampo("", 5, 0));
        
//        PegaParametros();
        PegaParametrosCC();
    }
    
//    private void PegaParametros(){
//        sql = "select * from tb_parametros where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
//        dadosParametros.clear();
//        dadosParametros = parametrosNS.dao.Consulta(sql);
//        if(dadosParametros.isEmpty()){
//            bt_imprimir.setEnabled(false);
//            mensagem = "Não foi possível encontrar diretório de relatórios!";
//            new MostraMensagem(mensagem);
//            return;
//        }
//        PegaDadosParametros();
//    }
//    
//    private void PegaDadosParametros(){
//        for(int i = 0; i < dadosParametros.size(); i++){
//            bpar.idParametros       = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(0)));
//            bpar.idEmpresa          = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(1)));
//            bpar.codigoGrupo        = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(2)));
//            bpar.codigoEmpresa      = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(3)));
//            bpar.pastaRelatorios    =                    String.valueOf(dadosParametros.get(i).get(4));
//        }
//    }
    
    private void PegaParametrosCC(){
        sql = "select * from tb_parametroscc where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosParametrosCC.clear();
        dadosParametrosCC = parametrosNS.dao.Consulta(sql);
        if(dadosParametrosCC.isEmpty()){
            mensagem = "Não foram encontrados parametros de impressão para boletos!";
            new MostraMensagem(mensagem);
            return;
        }
        PegadadosParametrosCC();
    }
    
    private void PegadadosParametrosCC(){
        for(int i = 0; i < dadosParametrosCC.size(); i++){
            bparcc.idParametrosCC           = Integer.parseInt(  String.valueOf(dadosParametrosCC.get(i).get(0)));
            bparcc.idEmpresa                = Integer.parseInt(  String.valueOf(dadosParametrosCC.get(i).get(1)));
            bparcc.codigoGrupo              = Integer.parseInt(  String.valueOf(dadosParametrosCC.get(i).get(2)));
            bparcc.codigoEmpresa            = Integer.parseInt(  String.valueOf(dadosParametrosCC.get(i).get(3)));
        }
        PegaImagemBoletos();
    }
    
    private void PegaImagemBoletos(){
        sql = "select imagemBoletos from tb_parametroscc where idEmpresa = " + bparcc.idEmpresa + ";";
        bparcc.imagemBoletos = parametrosNS.dao.ConsultaLogotipo(sql, "imagemBoletos");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_dataEmissaoInicial = new javax.swing.JFormattedTextField();
        txt_dataEmissaoFinal = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_codigoCliente = new javax.swing.JFormattedTextField();
        bt_pesquisaCliente = new javax.swing.JButton();
        label_nomeCliente = new javax.swing.JLabel();
        bt_imprimir = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Imprimir boletos por Grupo");
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
        jLabel1.setText("Parametros de pesquisa     F11 - [Geral]");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Data de emissão:");

        try {
            txt_dataEmissaoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataEmissaoInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataEmissaoInicial.setText("00/00/0000");
        txt_dataEmissaoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataEmissaoInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataEmissaoInicialFocusLost(evt);
            }
        });
        txt_dataEmissaoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataEmissaoInicialKeyPressed(evt);
            }
        });

        try {
            txt_dataEmissaoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataEmissaoFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataEmissaoFinal.setText("99/99/9999");
        txt_dataEmissaoFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataEmissaoFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataEmissaoFinalFocusLost(evt);
            }
        });
        txt_dataEmissaoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataEmissaoFinalKeyPressed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Inicial");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Final");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Cliente:");

        try {
            txt_codigoCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoCliente.setText("00000");
        txt_codigoCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoClienteFocusLost(evt);
            }
        });
        txt_codigoCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_codigoClienteMouseEntered(evt);
            }
        });
        txt_codigoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoClienteKeyPressed(evt);
            }
        });

        bt_pesquisaCliente.setText("jButton1");
        bt_pesquisaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaClienteActionPerformed(evt);
            }
        });

        label_nomeCliente.setText("Geral");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE))
                    .addComponent(txt_dataEmissaoInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_nomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txt_dataEmissaoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 269, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, txt_dataEmissaoFinal});

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
                    .addComponent(jLabel2)
                    .addComponent(txt_dataEmissaoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dataEmissaoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nomeCliente))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaCliente, jLabel2, jLabel3, jLabel4, jLabel5, label_nomeCliente, txt_codigoCliente, txt_dataEmissaoFinal, txt_dataEmissaoInicial});

        bt_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/print.png"))); // NOI18N
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

    private void txt_codigoClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_codigoClienteMouseEntered
        txt_codigoCliente.setToolTipText("00000 - Geral");
    }//GEN-LAST:event_txt_codigoClienteMouseEntered

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        InicializaCampos();
    }//GEN-LAST:event_formWindowOpened

    private void txt_dataEmissaoInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataEmissaoInicialFocusGained
        txt_dataEmissaoInicial.setSelectionStart(0);
        txt_dataEmissaoInicial.setSelectionEnd  (txt_dataEmissaoInicial.getText().length());
    }//GEN-LAST:event_txt_dataEmissaoInicialFocusGained

    private void txt_dataEmissaoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataEmissaoInicialFocusLost
        txt_dataEmissaoInicial.setText(fc.FormataCampo(txt_dataEmissaoInicial.getText(), 8, 0));
    }//GEN-LAST:event_txt_dataEmissaoInicialFocusLost

    private void txt_dataEmissaoInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataEmissaoInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataEmissaoFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataEmissaoInicial.setText(fc.FormataCampo("", 8, 0));
            txt_dataEmissaoFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataEmissaoInicialKeyPressed

    private void txt_dataEmissaoFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataEmissaoFinalFocusGained
        txt_dataEmissaoFinal.setSelectionStart(0);
        txt_dataEmissaoFinal.setSelectionEnd  (txt_dataEmissaoFinal.getText().length());
    }//GEN-LAST:event_txt_dataEmissaoFinalFocusGained

    private void txt_dataEmissaoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataEmissaoFinalFocusLost
        txt_dataEmissaoFinal.setText(fc.FormataCampo(txt_dataEmissaoFinal.getText(), 8, 0));
    }//GEN-LAST:event_txt_dataEmissaoFinalFocusLost

    private void txt_dataEmissaoFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataEmissaoFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoCliente.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataEmissaoFinal.setText("99999999");
            txt_codigoCliente.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataEmissaoFinalKeyPressed

    private void txt_codigoClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteFocusGained
        txt_codigoCliente.setSelectionStart(0);
        txt_codigoCliente.setSelectionEnd  (txt_codigoCliente.getText().length());
    }//GEN-LAST:event_txt_codigoClienteFocusGained

    private void txt_codigoClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteFocusLost
        if(txt_codigoCliente.isEditable() == false)
            return;
        if(txt_codigoCliente.getText().replace(" ", "").equals(""))
            return;
        PegaCliente();
    }//GEN-LAST:event_txt_codigoClienteFocusLost

    private void txt_codigoClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoClienteKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            bt_imprimir.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoCliente.setText(fc.FormataCampo("", 5, 0));
            bt_imprimir.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoClienteKeyPressed

    private void bt_pesquisaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaClienteActionPerformed
        if(CliCon != null)if(CliCon.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        abriuCliente = 1;
        CliCon = new ClientesConsulta("N");
        CliCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaClienteActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuCliente == 0)
            return;
        abriuCliente = 0;
        retorno = CliCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoCliente.setText(retorno);
        PegaCliente();
    }//GEN-LAST:event_formWindowGainedFocus

    private void bt_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimirActionPerformed
        ImprimirBoletosPorGrupo();
    }//GEN-LAST:event_bt_imprimirActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_imprimir;
    private javax.swing.JButton bt_pesquisaCliente;
    private javax.swing.JButton bt_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_nomeCliente;
    private javax.swing.JFormattedTextField txt_codigoCliente;
    private javax.swing.JFormattedTextField txt_dataEmissaoFinal;
    private javax.swing.JFormattedTextField txt_dataEmissaoInicial;
    // End of variables declaration//GEN-END:variables
    
    private void PegaCliente(){
        label_nomeCliente.setText("Geral");
        txt_codigoCliente.setText(fc.FormataCampo(txt_codigoCliente.getText(), 5, 0));
        bc.codigoCliente = Integer.parseInt(txt_codigoCliente.getText());
        if(bc.codigoCliente == 0)
            return;
        sql = "select codigoCliente, nome from tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCliente = " + bc.codigoCliente + ";";
        dadosCliente.clear();
        dadosCliente = parametrosNS.dao.Consulta(sql);
        if(dadosCliente.isEmpty()){
            mensagem = "Cliente não encontrado!";
            new MostraMensagem(mensagem);
            return;
        }
        PegaDadosCliente();
    }
    
    private void PegaDadosCliente(){
        for(int i = 0; i < dadosCliente.size(); i++){
            bc.codigoCliente = Integer.parseInt(String.valueOf(dadosCliente.get(i).get(0)));
            bc.nome          = String.valueOf(dadosCliente.get(i).get(1));
        }
        label_nomeCliente.setText(bc.nome);
    }
    
    private void PegaValores(){
        fatal = "N";
        binter.dataEmissaoInicial = Test.Testa(txt_dataEmissaoInicial.getText());
        binter.dataEmissaoFinal   = Test.Testa(txt_dataEmissaoFinal.getText());
        if(binter.dataEmissaoInicial > binter.dataEmissaoFinal){
            mensagem = "Data de emissão inicial não pode ser maior do que a data de emissão final!";
            new MostraMensagem(mensagem);
            fatal = "S";
            return;
        }
        
        preenchimento = "";
        if(bc.codigoCliente != 0){
            preenchimento = " and codigoCliente = " + bc.codigoCliente;
            binter.clienteInicial = bc.codigoCliente;
            binter.clienteFinal   = bc.codigoCliente;
        }
        else{
            binter.clienteInicial   = 0;
            binter.clienteFinal     = 99999;
        }
    }
    
    private void ImprimirBoletosPorGrupo(){
        PegaValores();
        if(fatal.equals("S"))
            return;
        
        sql = "select codigoBoleto, substring(CodigoDeBarras, 1, 3) from tb_boletos " +
              "where idEmpresa = " + parametrosNS.be.IdEmpresa + " and " +
              "dataEmissao between " + binter.dataEmissaoInicial + " and " + binter.dataEmissaoFinal + preenchimento + ";";
        dadosBoletos.clear();
        dadosBoletos = parametrosNS.dao.Consulta(sql);
        if(dadosBoletos.isEmpty()){
            mensagem = "Não foram encontrato boletos para o intervalos selecionado!";
            new MostraMensagem(mensagem);
            return;
        }
        Imprimir();
    }
    
    private void Imprimir(){
        binter.codigoBoletoInicial = Integer.parseInt(String.valueOf(dadosBoletos.get(0).get(0)));
        bb.codigoBanco             = String.valueOf(dadosBoletos.get(0).get(1));
        binter.codigoBoletoFinal   = Integer.parseInt(String.valueOf(dadosBoletos.get(dadosBoletos.size() - 1).get(0)));
        
        try{
            if(bparcc.imagemBoletos != null){
                BuffImg = ImageIO.read(new ByteArrayInputStream(bparcc.imagemBoletos));
                imgIcon = new ImageIcon(BuffImg);
                img     = imgIcon.getImage();
            }
            
            hm.clear();
            hm.put("idEmpresa"  ,       parametrosNS.be.IdEmpresa);
            hm.put("nomeEmpresa",       parametrosNS.be.NomeEmpresa.toUpperCase());
            hm.put("cnpjEmpresa",       parametrosNS.be.CnpjEmpresa);
            
            if(bparcc.imagemBoletos != null)
                hm.put("logoEmpresa",img);
            else
                hm.put("logoEmpresa",null);
            
            hm.put("codigoBoletoInicial"  , binter.codigoBoletoInicial);
            hm.put("codigoBoletoFinal"    , binter.codigoBoletoFinal);
            hm.put("codigoClienteInicial" , binter.clienteInicial);
            hm.put("codigoClienteFinal"   , binter.clienteFinal);
            
            jpv = null;
            if(bb.codigoBanco.equals("033"))
                jpv     = "Relatorios/BoletoSantander.jasper";
            if(bb.codigoBanco.equals("237"))
                jpv     = "Relatorios/BoletoBradesco.jasper";
            if(bb.codigoBanco.equals("341"))
                jpv     = "Relatorios/BoletoItau.jasper";
            
            retorno = "ok";
            
            jpp     = JasperFillManager.fillReport(jpv, hm, parametrosNS.con);
            JasperViewer.viewReport(jpp, false);
        }catch(Exception erro){
            mensagem = "Erro ao imprimir: " + erro.getMessage();
            new MostraMensagem(mensagem);
        }
    }
    
}
