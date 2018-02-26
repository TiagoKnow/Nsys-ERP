package TelasVendas;

import Beans.BeanFormasPagamentos;
import FuncoesInternas.*;
import Parametros.parametrosNS;
import java.util.*;
/*
 @author Tiago e Paulo
 */
public class FormasDePagamentoCadastro extends javax.swing.JFrame {
    //Vetores
    ArrayList            parametros                        = new ArrayList();
//    ArrayList            dadosPadroes                      = new ArrayList();
    ArrayList<ArrayList> dadosFormasPagamentos             = new ArrayList<ArrayList>();
    
    //Bean's
    BeanFormasPagamentos    bfp                 = new BeanFormasPagamentos();
    
    //String's
    String sql                                  = "";
    String sqlstate                             = "";
    String somostra                             = "";
    String Mensagem                             = "";
    String fatal                                = "";
    String operacao                             = "";
    String retorno                              = "";
    
    //int's
    int    UltimoRegistro                       = 0;
    int    abriuPagamentos                      = 0;
    
    //Especiais
    FormataCampo                    fc          = new FormataCampo();
    PegaProximoRegistro             PegProReg   = new PegaProximoRegistro();
    
    //Telas
    FormasDePagamentoConsulta   ForDePagCon;
    
    public FormasDePagamentoCadastro(String Somostra, int CodigoPagamento){
        somostra            = Somostra;
        bfp.codigoPagamento = CodigoPagamento;
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigoPagamento = new javax.swing.JFormattedTextField();
        bt_novo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_descricaoPagamento = new javax.swing.JTextField();
        bt_incluir = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_pesquisa = new javax.swing.JButton();
        bt_Sair = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        jLabel1.setText("Formas de Pagamentos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Código: ");

        txt_codigoPagamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoPagamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoPagamentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoPagamentoFocusLost(evt);
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_codigoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_novo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_descricaoPagamento)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_codigoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_descricaoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, jLabel2, jLabel3, txt_codigoPagamento});

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

        bt_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_Sair.setText("Sair");
        bt_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SairActionPerformed(evt);
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
                        .addComponent(bt_incluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_alterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_pesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Sair)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_Sair, bt_alterar, bt_incluir, bt_pesquisa});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_Sair, bt_alterar, bt_incluir, bt_pesquisa});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        ReiniciaCampos();
        HabilitaCampos(true);
        
        bfp.codigoPagamento = PegProReg.PegaProximoRegistro("tb_formaspagamentos", "codigoPagamento", "");
        txt_codigoPagamento.setText(fc.FormataCampo(String.valueOf(bfp.codigoPagamento), 2, 0));
        
        operacao = "I";
        HabilitaBotoes();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void txt_codigoPagamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPagamentoFocusGained
        if(txt_codigoPagamento.isEditable()== false)
            return;
        if(somostra.equals("S"))
            return;
        txt_codigoPagamento.setText("");
        operacao = "";
        HabilitaBotoes();
        ReiniciaCampos();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoPagamentoFocusGained

    private void txt_codigoPagamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPagamentoFocusLost
        if(txt_codigoPagamento.isEditable() == false)
            return;
        if(txt_codigoPagamento.getText().replace(" ","").equals(""))
            return;
        PegaPagamento();
    }//GEN-LAST:event_txt_codigoPagamentoFocusLost

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "insert into tb_formaspagamentos (idEmpresa, codigoGrupo, codigoEmpresa, codigoPagamento, descricaoPagamento) "
            + "values (" + bfp.idEmpresa + ", " + bfp.codigoGrupo + ", " + bfp.codigoEmpresa + ", " + bfp.codigoPagamento + ", '" + bfp.descricaoPagamento + "');";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoPagamento.grabFocus();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        sql = "update tb_formaspagamentos set descricaoPagamento = '"   + bfp.descricaoPagamento    + "' "    +
                                        "where idPagamento = "      + bfp.idPagamento           + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoPagamento.grabFocus();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        if(ForDePagCon != null)if(ForDePagCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuPagamentos = 1;
        ForDePagCon = new FormasDePagamentoConsulta("S");
        ForDePagCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuPagamentos == 0)
            return;
        retorno = ForDePagCon.getRetorno();
        if(retorno.equals(""))
            return;
        abriuPagamentos = 0;
        txt_codigoPagamento.setText(retorno);
        PegaPagamento();
    }//GEN-LAST:event_formWindowGainedFocus

    private void bt_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_SairActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HabilitaCampos(false);
        if(somostra.equals("S")){
            txt_codigoPagamento     .setEditable(false);
            bt_novo                 .setEnabled (false);
            bt_incluir              .setVisible (false);
            bt_alterar              .setVisible (false);
            bt_pesquisa             .setVisible (false);
        }
        if(bfp.codigoPagamento != 0){
            txt_codigoPagamento     .setText(String.valueOf(bfp.codigoPagamento));
            PegaPagamento();
        }
        if(somostra.equals("SN")){
            bt_pesquisa             .setVisible (false);
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(ForDePagCon  != null)ForDePagCon.dispose();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Sair;
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisa;
    private javax.swing.JMenuItem bt_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txt_codigoPagamento;
    private javax.swing.JTextField txt_descricaoPagamento;
    // End of variables declaration//GEN-END:variables
    
    private void ReiniciaCampos(){
        txt_descricaoPagamento.setText("");
    }
    
    private void HabilitaCampos(boolean Habilita){
        txt_descricaoPagamento      .setEditable    (Habilita);
        txt_descricaoPagamento      .setFocusable   (Habilita);
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
    
    private void PegaPagamento(){
        txt_codigoPagamento.setText(fc.FormataCampo(txt_codigoPagamento.getText(), 2, 0));
        bfp.codigoPagamento = Integer.parseInt(txt_codigoPagamento.getText());
        if(bfp.codigoPagamento == 0)
            return;
        sql = "select * from tb_formaspagamentos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoPagamento = " + bfp.codigoPagamento + ";";
        dadosFormasPagamentos.clear();
        dadosFormasPagamentos = parametrosNS.dao.Consulta(sql);
        if(dadosFormasPagamentos.isEmpty()){
            Mensagem = "Forma de Pagamento código " + bfp.codigoPagamento + " não encontrado, para incluir pressione Novo!";
            new MostraMensagem(Mensagem);
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        HabilitaCampos(true);
        PreencherCamposFormaPagamento();
    }
    
    private void PreencherCamposFormaPagamento(){
        for(int i = 0; i < dadosFormasPagamentos.size(); i++){
            bfp = new BeanFormasPagamentos();
            bfp.idPagamento             = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(0)));
            bfp.idEmpresa               = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(1)));
            bfp.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(2)));
            bfp.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(3)));
            bfp.codigoPagamento         = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(4)));
            bfp.descricaoPagamento      =                    String.valueOf(dadosFormasPagamentos.get(i).get(5));
        }
        txt_descricaoPagamento.setText(bfp.descricaoPagamento);
    }
    
    private void PegaValores(){
        fatal = "N";
        bfp.idEmpresa           = parametrosNS.be.IdEmpresa;
        bfp.codigoGrupo         = parametrosNS.bge.CodigoGrupo;
        bfp.codigoEmpresa       = parametrosNS.be.CodigoEmpresa;
        bfp.codigoPagamento     = Integer.parseInt(txt_codigoPagamento.getText());
        bfp.descricaoPagamento  = txt_descricaoPagamento.getText();
        if(bfp.descricaoPagamento.equals("")){
            Mensagem = "Descrição inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
    }
    
}
