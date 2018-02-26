package TelasContasCorrente;

import Beans.BeanBoletosInstrucoes;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.PegaProximoRegistro;
import Parametros.parametrosNS;
import java.util.ArrayList;

/*
 @author Tiago e Paulo 01/08/2016 12:10
 */
public class InstrucoesDeBoletosCadastro extends javax.swing.JFrame {
    //String's
    String  sql                                     = "";
    String  sqlstate                                = "";
    String  fatal                                   = "";
    String  Mensagem                                = "";
    String  retorno                                 = "";
    String  operacao                                = "";
    String  somostra                                = "";
    
    //int's
    int     abriuIntrucao                           = 0;
    
    //Vetores
    ArrayList            parametros                          = new ArrayList();
//    ArrayList            dadosPadroes                        = new ArrayList();
    ArrayList<ArrayList> dadosBoletosInstrucoes              = new ArrayList<ArrayList>();
    
    //Bean's
    BeanBoletosInstrucoes               bbi         = new BeanBoletosInstrucoes();
    
    //Especiais
    FormataCampo                        fc          = new FormataCampo();
    PegaProximoRegistro                 PegProReg   = new PegaProximoRegistro();
    
    //Telas
    InstrucoesDeBoletosConsulta         InsBolCon;
    
    public InstrucoesDeBoletosCadastro(String Somostra, int CodigoBoletoInstrucao){
        somostra                                = Somostra;
        bbi.codigoBoletoInstrucao               = CodigoBoletoInstrucao;
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigoBoletoInstrucao = new javax.swing.JFormattedTextField();
        bt_novo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_descricaoInstrucao = new javax.swing.JTextField();
        txt_primeiraInstrucao = new javax.swing.JTextField();
        txt_segundaInstrucao = new javax.swing.JTextField();
        txt_terceiraInstrucao = new javax.swing.JTextField();
        bt_incluir = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        bt_pesquisaBoletoInstrucao = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Instruções de Boletos Bancários");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Intruções de Boletos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Código:");

        try {
            txt_codigoBoletoInstrucao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoBoletoInstrucao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoBoletoInstrucao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoBoletoInstrucaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoBoletoInstrucaoFocusLost(evt);
            }
        });

        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Descrição da Intrução:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("1ª Intrução:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("2ª Intrução:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("3ª Intrução:");

        txt_primeiraInstrucao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_primeiraInstrucaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_primeiraInstrucaoFocusLost(evt);
            }
        });

        txt_segundaInstrucao.setEditable(false);
        txt_segundaInstrucao.setText("Pagamento em X Parcelas de R$ XXX,XX - Parcelas X de Y");
        txt_segundaInstrucao.setFocusable(false);

        txt_terceiraInstrucao.setEditable(false);
        txt_terceiraInstrucao.setFocusable(false);
        txt_terceiraInstrucao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_terceiraInstrucaoFocusGained(evt);
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
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_descricaoInstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_primeiraInstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_segundaInstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoBoletoInstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_novo))
                    .addComponent(txt_terceiraInstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5, jLabel6});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_descricaoInstrucao, txt_primeiraInstrucao, txt_segundaInstrucao, txt_terceiraInstrucao});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_codigoBoletoInstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_descricaoInstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_primeiraInstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_segundaInstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_terceiraInstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, txt_codigoBoletoInstrucao, txt_descricaoInstrucao, txt_primeiraInstrucao, txt_segundaInstrucao, txt_terceiraInstrucao});

        bt_incluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_incluir.setText("Incluir");
        bt_incluir.setEnabled(false);
        bt_incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_incluirActionPerformed(evt);
            }
        });

        bt_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Save.png"))); // NOI18N
        bt_alterar.setText("Alterar");
        bt_alterar.setEnabled(false);
        bt_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterarActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        jButton3.setText("Sair");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        bt_pesquisaBoletoInstrucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/View.png"))); // NOI18N
        bt_pesquisaBoletoInstrucao.setText("Pesquisa");
        bt_pesquisaBoletoInstrucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaBoletoInstrucaoActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        bt_sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });
        jMenu1.add(bt_sair);

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
                        .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_alterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_pesquisaBoletoInstrucao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_alterar, bt_incluir, bt_pesquisaBoletoInstrucao, jButton3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_alterar)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaBoletoInstrucao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_alterar, bt_incluir, bt_pesquisaBoletoInstrucao, jButton3});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        ReiniciaCampos();
        HabilitaCampos(true);
        
        bbi.codigoBoletoInstrucao   = PegProReg.PegaProximoRegistro("tb_boletos_instrucoes", "codigoBoletoInstrucao", "");
        txt_codigoBoletoInstrucao.setText(fc.FormataCampo(String.valueOf(bbi.codigoBoletoInstrucao), 2, 0));
        
        operacao    = "I";
        HabilitaBotoes();
        txt_descricaoInstrucao.grabFocus();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void txt_codigoBoletoInstrucaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoBoletoInstrucaoFocusGained
        if(txt_codigoBoletoInstrucao.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        operacao = "";
        ReiniciaCampos();
        HabilitaBotoes();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoBoletoInstrucaoFocusGained

    private void txt_codigoBoletoInstrucaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoBoletoInstrucaoFocusLost
        if(txt_codigoBoletoInstrucao.isEditable() == false)
            return;
        if(txt_codigoBoletoInstrucao.getText().replace(" ", "").equals(""))
            return;
        PegaBoletosInstrucoes();
    }//GEN-LAST:event_txt_codigoBoletoInstrucaoFocusLost

    private void txt_primeiraInstrucaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_primeiraInstrucaoFocusGained
        if(somostra.equals("S"))
            return;
        if(operacao.equals("I"))
            txt_primeiraInstrucao.setText(txt_descricaoInstrucao.getText() + ":");
    }//GEN-LAST:event_txt_primeiraInstrucaoFocusGained

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "insert into tb_boletos_instrucoes (idEmpresa, codigoGrupo, codigoEmpresa, codigoBoletoInstrucao, descricaoInstrucao, primeiraInstrucao, segundaInstrucao, terceiraInstrucao) "
            + "values (" + bbi.idEmpresa + ", " + bbi.codigoGrupo + ", " + bbi.codigoEmpresa + ", " + bbi.codigoBoletoInstrucao + ", '" + bbi.descricaoInstrucao + "', '" + bbi.primeiraInstrucao + "', '" + bbi.segundaInstrucao + "', '" + bbi.terceiraInstrucao + "');";
        
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoBoletoInstrucao.grabFocus();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "update tb_boletos_instrucoes set descricaoInstrucao = '"             + bbi.descricaoInstrucao    + "', "
                                            + "primeiraInstrucao = '"               + bbi.primeiraInstrucao     + "', "
                                            + "segundaInstrucao = '"                + bbi.segundaInstrucao      + "', "
                                            + "terceiraInstrucao = '"               + bbi.terceiraInstrucao     + "' "
                                            + "where idBoletoInstrucao = "          + bbi.idBoletoInstrucao     + ";";
        
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoBoletoInstrucao.grabFocus();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void bt_pesquisaBoletoInstrucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaBoletoInstrucaoActionPerformed
        if(InsBolCon   != null)if(InsBolCon.isVisible()){
            Mensagem = "Tela ja Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuIntrucao = 1;
        InsBolCon = new InstrucoesDeBoletosConsulta("S");
        InsBolCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaBoletoInstrucaoActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
        if(abriuIntrucao == 0)
            return;
        abriuIntrucao = 0;
        retorno = InsBolCon.getRetornoBoletoInstrucoes();
        if(retorno.equals(""))
            return;
        txt_codigoBoletoInstrucao.setText(retorno);
        PegaBoletosInstrucoes();
    }//GEN-LAST:event_formWindowGainedFocus

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txt_primeiraInstrucaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_primeiraInstrucaoFocusLost
        if(somostra.equals("S"))
            return;
        bbi.primeiraInstrucao   = txt_primeiraInstrucao.getText();
        if(!bbi.primeiraInstrucao.equals("")){
            txt_terceiraInstrucao.setEditable   (true);
            txt_terceiraInstrucao.setFocusable  (true);
            txt_terceiraInstrucao.grabFocus();
//            return;
        }else{
            txt_terceiraInstrucao.setEditable   (false);
            txt_terceiraInstrucao.setFocusable  (false);
            txt_terceiraInstrucao.setText("");
//            return;
        }
    }//GEN-LAST:event_txt_primeiraInstrucaoFocusLost

    private void txt_terceiraInstrucaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_terceiraInstrucaoFocusGained
        
    }//GEN-LAST:event_txt_terceiraInstrucaoFocusGained

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HabilitaCampos(false);
        if(somostra.equals("S")){
            txt_codigoBoletoInstrucao   .setEditable(false);
            bt_novo                     .setEnabled(false);
            bt_incluir                  .setVisible(false);
            bt_alterar                  .setVisible(false);
            bt_pesquisaBoletoInstrucao  .setVisible(false);
        }
        if(bbi.codigoBoletoInstrucao != 0){
            txt_codigoBoletoInstrucao.setText(fc.FormataCampo(String.valueOf(bbi.codigoBoletoInstrucao), 2, 0));
            PegaBoletosInstrucoes();
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(InsBolCon    != null)InsBolCon.dispose();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisaBoletoInstrucao;
    private javax.swing.JMenuItem bt_sair;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txt_codigoBoletoInstrucao;
    private javax.swing.JTextField txt_descricaoInstrucao;
    private javax.swing.JTextField txt_primeiraInstrucao;
    private javax.swing.JTextField txt_segundaInstrucao;
    private javax.swing.JTextField txt_terceiraInstrucao;
    // End of variables declaration//GEN-END:variables
    
    private void ReiniciaCampos(){
        txt_codigoBoletoInstrucao   .setText("");
        txt_descricaoInstrucao      .setText("");
        txt_primeiraInstrucao       .setText("");
        txt_terceiraInstrucao       .setText("");
        txt_terceiraInstrucao       .setEditable(false);
        txt_terceiraInstrucao       .setEditable(false);
    }
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_incluir      .setEnabled(true);
            bt_alterar      .setEnabled(false);
            return;
        }
        if(operacao.equals("A")){
            bt_incluir      .setEnabled(false);
            bt_alterar      .setEnabled(true);
            return;
        }
        bt_incluir          .setEnabled(false);
        bt_alterar          .setEnabled(false);
    }
    
    private void HabilitaCampos(boolean Habilita){
        txt_descricaoInstrucao      .setEditable    (Habilita);
        txt_descricaoInstrucao      .setFocusable   (Habilita);
        txt_primeiraInstrucao       .setEditable    (Habilita);
        txt_primeiraInstrucao       .setFocusable   (Habilita);
    }
    
    private void PegaBoletosInstrucoes(){
        txt_codigoBoletoInstrucao.setText(fc.FormataCampo(txt_codigoBoletoInstrucao.getText(), 2, 0));
        bbi.codigoBoletoInstrucao   = Integer.parseInt(txt_codigoBoletoInstrucao.getText());
        if(bbi.codigoBoletoInstrucao == 0)
            return;
        sql = "select * from tb_boletos_instrucoes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoBoletoInstrucao = " + bbi.codigoBoletoInstrucao + ";";
        dadosBoletosInstrucoes.clear();
        dadosBoletosInstrucoes = parametrosNS.dao.Consulta(sql);
        if(dadosBoletosInstrucoes.isEmpty()){
            Mensagem = "Instrução " + bbi.codigoBoletoInstrucao + " não encontrada!";
            new MostraMensagem(Mensagem);
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        HabilitaCampos(true);
        PegaDadosBoletoInstrucoes();
    }
    
    private void PegaDadosBoletoInstrucoes(){
        for(int i = 0; i < dadosBoletosInstrucoes.size(); i++){
            bbi.idBoletoInstrucao       = Integer.parseInt(  String.valueOf(dadosBoletosInstrucoes.get(i).get(0)));
            bbi.idEmpresa               = Integer.parseInt(  String.valueOf(dadosBoletosInstrucoes.get(i).get(1)));
            bbi.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosBoletosInstrucoes.get(i).get(2)));
            bbi.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosBoletosInstrucoes.get(i).get(3)));
            bbi.codigoBoletoInstrucao   = Integer.parseInt(  String.valueOf(dadosBoletosInstrucoes.get(i).get(4)));
            bbi.descricaoInstrucao      =                    String.valueOf(dadosBoletosInstrucoes.get(i).get(5));
            bbi.primeiraInstrucao       =                    String.valueOf(dadosBoletosInstrucoes.get(i).get(6));
            bbi.segundaInstrucao        =                    String.valueOf(dadosBoletosInstrucoes.get(i).get(7));
            bbi.terceiraInstrucao       =                    String.valueOf(dadosBoletosInstrucoes.get(i).get(8));
        }
        txt_descricaoInstrucao  .setText(bbi.descricaoInstrucao);
        txt_primeiraInstrucao   .setText(bbi.primeiraInstrucao);
        
        if(!bbi.terceiraInstrucao.equals(""))
            txt_terceiraInstrucao.setEditable(true);
        txt_terceiraInstrucao   .setText(bbi.terceiraInstrucao);
    }
    
    private void PegaValores(){
        fatal = "N";
        bbi.idEmpresa               = parametrosNS.be.IdEmpresa;
        bbi.codigoGrupo             = parametrosNS.bge.CodigoGrupo;
        bbi.codigoEmpresa           = parametrosNS.be.CodigoEmpresa;
        bbi.codigoBoletoInstrucao   = Integer.parseInt(txt_codigoBoletoInstrucao.getText());
        bbi.descricaoInstrucao      = txt_descricaoInstrucao.getText();
        if(bbi.descricaoInstrucao   .equals("")){
            Mensagem = "Descriçao da Instrução Inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bbi.primeiraInstrucao       = txt_primeiraInstrucao.getText();
        if(bbi.primeiraInstrucao.equals("")){
            Mensagem = "Primeira Instrução Inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
//            return;
        }
        bbi.segundaInstrucao        = txt_segundaInstrucao.getText();
        bbi.terceiraInstrucao       = txt_terceiraInstrucao.getText();
    }
    
}
