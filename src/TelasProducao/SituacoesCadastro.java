package TelasProducao;

import Beans.*;
import Dao.*;
import FuncoesInternas.*;
import Parametros.parametrosNS;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 @author Tiago e Paulo
 */
public class SituacoesCadastro extends javax.swing.JFrame {
    //String's
    String sql                          = "";
    String sqlstate                     = "";
    String fatal                        = "";
    String somostra                     = "";
    String Mensagem                     = "";
    String operacao                     = "";
    String retorno                      = "";
    
    //int's
    int    abriuSituacoes               = 0;
    
    //Vetores
    ArrayList            parametros                = new ArrayList();
    ArrayList            dadosPadroes              = new ArrayList();
    ArrayList<ArrayList> dadosSituacoes            = new ArrayList<ArrayList>();
    
    //Bean's
    BeanSituacoes           bsit        = new BeanSituacoes();
    
    //Especiais
    FormataCampo            fc          = new FormataCampo();
    PegaProximoRegistro     PegProReg   = new PegaProximoRegistro();
    
    //Telas
    SituacoesConsulta       SitCon;
    
    public SituacoesCadastro(ArrayList DadosPadroes){
        dadosPadroes                    = DadosPadroes;
        
        somostra                        = (String)  dadosPadroes.get(0);
        bsit.codigoSituacao             = (int)     dadosPadroes.get(1);
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigoSituacao = new javax.swing.JFormattedTextField();
        bt_novo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_descricaoSituacao = new javax.swing.JTextField();
        bt_incluir = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_pesquisa = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Situações");
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
        jLabel1.setText("Situçãoes");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Código: ");

        try {
            txt_codigoSituacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoSituacao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoSituacao.setText("   ");
        txt_codigoSituacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoSituacaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoSituacaoFocusLost(evt);
            }
        });

        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Descrição: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_novo)
                        .addGap(0, 363, Short.MAX_VALUE))
                    .addComponent(txt_descricaoSituacao))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_codigoSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_descricaoSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, jLabel2, txt_codigoSituacao});

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

        bt_pesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/View.png"))); // NOI18N
        bt_pesquisa.setText("Pesquisa");
        bt_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaActionPerformed(evt);
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
                        .addComponent(bt_incluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_alterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_pesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_alterar)
                    .addComponent(bt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_alterar, bt_incluir, bt_pesquisa});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoSituacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoSituacaoFocusGained
        if(txt_codigoSituacao.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        operacao = "";
        ReiniciaCampos();
        HabilitaBotoes();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoSituacaoFocusGained

    private void txt_codigoSituacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoSituacaoFocusLost
        if(txt_codigoSituacao.isEditable() == false)
            return;
        if(txt_codigoSituacao.getText().replace(" ", "").equals(""))
            return;
        PegaSituacoes();
    }//GEN-LAST:event_txt_codigoSituacaoFocusLost

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        ReiniciaCampos();
        HabilitaCampos(true);
        
        bsit.codigoSituacao = PegProReg.PegaProximoRegistro("tb_situacoes", "codigoSituacao", "");
        txt_codigoSituacao.setText(fc.FormataCampo(String.valueOf(bsit.codigoSituacao), 3, 0));
        
        operacao = "I";
        HabilitaBotoes();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S"))
            return;
        sql = "insert into tb_situacoes (idEmpresa, codigoGrupo, codigoEmpresa, codigoSituacao, descricaoSituacao) "
            + "values (" + bsit.idEmpresa + ", " + bsit.codigoGrupo + ", " + bsit.codigoEmpresa + ", " + bsit.codigoSituacao + ", '" + bsit.descricaoSituacao + "');";
        
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoSituacao.grabFocus();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S"))
            return;
        sql = "update tb_situacoes set descricaoSituacao = '"   + bsit.descricaoSituacao    + "' "
                                    + "where idSituacao = "     + bsit.idSituacao           + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoSituacao.grabFocus();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        if(SitCon != null)if(SitCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuSituacoes = 1;
        parametros.clear();
        parametros.add("S");
        SitCon = new SituacoesConsulta(parametros);
        SitCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuSituacoes == 0)
            return;
        abriuSituacoes = 0;
        retorno = SitCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoSituacao.setText(retorno);
        PegaSituacoes();
    }//GEN-LAST:event_formWindowGainedFocus

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HabilitaCampos(false);
        if(somostra.equals("S")){
            bt_novo             .setEnabled (false);
            bt_incluir          .setVisible (false);
            bt_alterar          .setVisible (false);
            txt_codigoSituacao  .setEditable(false);
            bt_pesquisa         .setVisible (false);
        }
        if(bsit.codigoSituacao != 0){
            txt_codigoSituacao.setText(String.valueOf(bsit.codigoSituacao));
            PegaSituacoes();
        }
        if(somostra.equalsIgnoreCase("SN"))
            bt_pesquisa         .setVisible (false);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(SitCon   != null)SitCon.dispose();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisa;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txt_codigoSituacao;
    private javax.swing.JTextField txt_descricaoSituacao;
    // End of variables declaration//GEN-END:variables
    
    private void ReiniciaCampos(){
        txt_codigoSituacao      .setText("");
        txt_descricaoSituacao   .setText("");
    }
    
    private void HabilitaCampos(boolean Habilita){
        txt_descricaoSituacao       .setEditable    (Habilita);
        txt_descricaoSituacao       .setFocusable   (Habilita);
    }
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_incluir.setEnabled(true);
            bt_alterar.setEnabled(false);
            return;
        }
        if(operacao.equals("A")){
            bt_incluir.setEnabled(false);
            bt_alterar.setEnabled(true);
            return;
        }
        bt_incluir.setEnabled(false);
        bt_alterar.setEnabled(false);
    }
    
    private void PegaSituacoes(){
        txt_codigoSituacao.setText(fc.FormataCampo(String.valueOf(txt_codigoSituacao.getText()), 3, 0));
        bsit.codigoSituacao = Integer.parseInt(txt_codigoSituacao.getText());
        if(bsit.codigoSituacao == 0)
            return;
        sql = "select * from tb_situacoes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoSituacao = " + bsit.codigoSituacao + ";";
        dadosSituacoes.clear();
        dadosSituacoes = parametrosNS.dao.Consulta(sql);
        if(dadosSituacoes.isEmpty()){
            Mensagem = "Não foram encontradas situações cadastradas!";
            new MostraMensagem(Mensagem);
            return;
        }
        operacao = "A";
        PreencherSituacoes();
        HabilitaBotoes();
        HabilitaCampos(true);
    }
    
    private void PreencherSituacoes(){
        for(int i = 0; i < dadosSituacoes.size(); i++){
            bsit.idSituacao         = Integer.parseInt(  String.valueOf(dadosSituacoes.get(i).get(0)));
            bsit.idEmpresa          = Integer.parseInt(  String.valueOf(dadosSituacoes.get(i).get(1)));
            bsit.codigoGrupo        = Integer.parseInt(  String.valueOf(dadosSituacoes.get(i).get(2)));
            bsit.codigoEmpresa      = Integer.parseInt(  String.valueOf(dadosSituacoes.get(i).get(3)));
            bsit.codigoSituacao     = Integer.parseInt(  String.valueOf(dadosSituacoes.get(i).get(4)));
            bsit.descricaoSituacao  =                    String.valueOf(dadosSituacoes.get(i).get(5));
        }
        txt_descricaoSituacao.setText(bsit.descricaoSituacao);
    }
    
    private void PegaValores(){
        fatal = "N";
        bsit.idEmpresa          = parametrosNS.be.IdEmpresa;
        bsit.codigoGrupo        = parametrosNS.bge.CodigoGrupo;
        bsit.codigoEmpresa      = parametrosNS.be.CodigoEmpresa;
        bsit.codigoSituacao     = Integer.parseInt(txt_codigoSituacao.getText());
        bsit.descricaoSituacao  = txt_descricaoSituacao.getText();
        if(bsit.descricaoSituacao.equals("")){
            Mensagem = "Descrição inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
    }
    
}
