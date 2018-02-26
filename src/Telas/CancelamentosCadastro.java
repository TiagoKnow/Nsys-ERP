package Telas;

import Beans.BeanCancelamentos;
import Dao.DaoMySQL;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.PegaProximoRegistro;
import Parametros.parametrosNS;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 @author Tiago e Paulo
 */
public class CancelamentosCadastro extends javax.swing.JFrame {
    //int's
    int    abriuPesquisa                = 0;
    
    //String's
    String sql                          = "";
    String sqlstate                     = "";
    String fatal                        = "";
    String Mensagem                     = "";
    String somostra                     = "";
    String operacao                     = "";
    String retorno                      = "";
    
    //Vetores
    ArrayList            parametros                = new ArrayList();
//    ArrayList            dadosPadroes              = new ArrayList();
    ArrayList<ArrayList> dadosCancelamentos        = new ArrayList<ArrayList>();
    
    //Bean's
    BeanCancelamentos           bcan        = new BeanCancelamentos();
    
    //Especiais
    FormataCampo                fc          = new FormataCampo();
    PegaProximoRegistro         PegProReg   = new PegaProximoRegistro();
    
    //Telas
    CancelamentosConsulta       ConCanVen;
    
    public CancelamentosCadastro(String Somostra, int CodigoCancelamento){
        somostra                = Somostra;
        bcan.codigoCancelamento = CodigoCancelamento;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_excluir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigoCancelamento = new javax.swing.JFormattedTextField();
        bt_novo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_descricaoCancelamento = new javax.swing.JTextField();
        bt_incluir = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_pesquisa = new javax.swing.JButton();
        bt_Sair = new javax.swing.JButton();

        bt_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Delete.png"))); // NOI18N
        bt_excluir.setText("Excluir");
        bt_excluir.setEnabled(false);
        bt_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluirActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Cancelamento de Vendas");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Código:");

        try {
            txt_codigoCancelamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoCancelamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoCancelamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoCancelamentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoCancelamentoFocusLost(evt);
            }
        });

        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Descrição:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoCancelamento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_novo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txt_descricaoCancelamento))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_codigoCancelamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_descricaoCancelamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, jLabel2, jLabel3, txt_codigoCancelamento});

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_incluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_alterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_Sair, bt_alterar, bt_incluir, bt_pesquisa});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        txt_descricaoCancelamento.grabFocus();
        ReiniciaCampos();
        HabilitaCampos(true);
        
        bcan.codigoCancelamento = PegProReg.PegaProximoRegistro("tb_cancelamento", "codigoCancelamento", "");
        txt_codigoCancelamento.setText(fc.FormataCampo(String.valueOf(bcan.codigoCancelamento), 2, 0));
        
        operacao = "I";
        HabilitaBotoes();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        sql = "insert into tb_cancelamento (idEmpresa, codigoGrupo, codigoEmpresa, codigoCancelamento, descricaoCancelamento)"
            + " values (" + bcan.idEmpresa + ", " + bcan.codigoGrupo + ", " + bcan.codigoEmpresa + ", " + bcan.codigoCancelamento + ", '" + bcan.descricaoCancelamento + "');";
        
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoCancelamento.grabFocus();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        sql = "update tb_cancelamento set descricaoCancelamento = '"        + bcan.descricaoCancelamento    + "' "
                                        + "where idCancelamento = " + bcan.idCancelamento       + ";";
        
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoCancelamento.grabFocus();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void txt_codigoCancelamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoCancelamentoFocusGained
        if(somostra.equalsIgnoreCase("S"))
            return;
        operacao = "";
        HabilitaBotoes();
        ReiniciaCampos();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoCancelamentoFocusGained

    private void bt_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluirActionPerformed
        bcan.codigoCancelamento      = Integer.parseInt(txt_codigoCancelamento.getText());
        if(JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir o cancelamento de código n°" + bcan.codigoCancelamento + "?", "", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION)
            return;
        sql = "delete from tb_cancelamento where idCancelamento = " + bcan.idCancelamento + ";";
        sqlstate = parametrosNS.dao.ExcluirRegistro(sql);
        
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoCancelamento.grabFocus();
    }//GEN-LAST:event_bt_excluirActionPerformed

    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        if(ConCanVen != null)if(ConCanVen.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuPesquisa = 1;
        ConCanVen = new CancelamentosConsulta("S");
        ConCanVen.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
        if(abriuPesquisa == 0)
            return;
        abriuPesquisa = 0;
        retorno = ConCanVen.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoCancelamento.setText(retorno);
        PegaCancelamento();
    }//GEN-LAST:event_formWindowGainedFocus

    private void txt_codigoCancelamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoCancelamentoFocusLost
        if(txt_codigoCancelamento.getText().replace(" ", "").equals(""))
            return;
        if(somostra.equalsIgnoreCase("S"))
            return;
        PegaCancelamento();
    }//GEN-LAST:event_txt_codigoCancelamentoFocusLost

    private void bt_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_SairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HabilitaCampos(false);
        if(somostra.equalsIgnoreCase("S")){
            bt_incluir              .setVisible (false);
            bt_alterar              .setVisible (false);
            bt_excluir              .setVisible (false);
            bt_pesquisa             .setEnabled (false);
            txt_codigoCancelamento  .setEditable(false);
            bt_novo                 .setEnabled (false);
        }
        if(bcan.codigoCancelamento != 0){
            txt_codigoCancelamento  .setText    (String.valueOf(bcan.codigoCancelamento));
            PegaCancelamento();
        }
        if(somostra.equals("SN")){
            bt_pesquisa             .setVisible (false);
        }
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Sair;
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_excluir;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txt_codigoCancelamento;
    private javax.swing.JTextField txt_descricaoCancelamento;
    // End of variables declaration//GEN-END:variables
    
    private void ReiniciaCampos(){
        txt_codigoCancelamento.setText("");
        txt_descricaoCancelamento.setText("");
    }
    
    private void HabilitaCampos(boolean Habilita){
        txt_descricaoCancelamento.setEditable(Habilita);
    }
    
    private void HabilitaBotoes(){
        if(operacao.equalsIgnoreCase("I")){
            bt_incluir          .setEnabled(true);
            bt_alterar          .setEnabled(false);
            bt_excluir          .setEnabled(false);
            return;
        }
        if(operacao.equalsIgnoreCase("A")){
            bt_incluir          .setEnabled(false);
            bt_alterar          .setEnabled(true);
            bt_excluir          .setEnabled(true);
            return;
        }
        bt_incluir          .setEnabled(false);
        bt_alterar          .setEnabled(false);
        bt_excluir          .setEnabled(false);
    }
    
    private void PegaValores(){
        fatal = "N";
        bcan.idEmpresa              = parametrosNS.be.IdEmpresa;
        bcan.codigoGrupo            = parametrosNS.bge.CodigoGrupo;
        bcan.codigoEmpresa          = parametrosNS.be.CodigoEmpresa;
        bcan.codigoCancelamento     = Integer.parseInt(txt_codigoCancelamento.getText());
        bcan.descricaoCancelamento  = txt_descricaoCancelamento.getText();
        if(bcan.descricaoCancelamento.equals("")){
            Mensagem = "Descrição inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
    }
    
    private void PegaCancelamento(){
        txt_codigoCancelamento.setText(fc.FormataCampo(txt_codigoCancelamento.getText(), 2, 0));
        bcan.codigoCancelamento = Integer.parseInt(txt_codigoCancelamento.getText());
        if(bcan.codigoCancelamento == 0)
            return;
        sql = "select * from tb_cancelamento where idEmpresa = " + parametrosNS.be.IdEmpresa+ " and codigoCancelamento >= " + bcan.codigoCancelamento + ";";
        dadosCancelamentos.clear();
        dadosCancelamentos = parametrosNS.dao.Consulta(sql);
        if(dadosCancelamentos.isEmpty()){
            Mensagem = "Cancelamento " + bcan.codigoCancelamento + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        HabilitaCampos(true);
        PegaDadosCancelamento();
    }
    
    private void PegaDadosCancelamento(){
        for(int i = 0; i < dadosCancelamentos.size(); i++){
            bcan.idCancelamento         = Integer.parseInt(  String.valueOf(dadosCancelamentos.get(i).get(0)));
            bcan.idEmpresa              = Integer.parseInt(  String.valueOf(dadosCancelamentos.get(i).get(1)));
            bcan.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosCancelamentos.get(i).get(2)));
            bcan.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosCancelamentos.get(i).get(3)));
            bcan.codigoCancelamento     = Integer.parseInt(  String.valueOf(dadosCancelamentos.get(i).get(4)));
            bcan.descricaoCancelamento  =                    String.valueOf(dadosCancelamentos.get(i).get(5));
        }
        txt_descricaoCancelamento.setText(bcan.descricaoCancelamento);
    }
    
}
