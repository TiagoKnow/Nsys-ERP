package TelasVendas;

import Beans.BeanCaixaMotivoSaida;
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
public class MotivosDeSaidaDeCaixaCadastro extends javax.swing.JFrame {
    //String's
    String sql                              = "";
    String somostra                         = "";
    String sqlstate                         = "";
    String retorno                          = "";
    String Mensagem                         = "";
    String operacao                         = "";
    String fatal                            = "";
    
    //int's
    int    UltimoRegistro                   = 0;
    int    abriuPesquisa                    = 0;
    
    //Vetores ArrayList
    ArrayList            parametros                    = new ArrayList();
    ArrayList            dadosPadroes                  = new ArrayList();
    ArrayList<ArrayList> dadosMotivoSaida              = new ArrayList<ArrayList>();
    
    //Bean's
    BeanCaixaMotivoSaida        bcms        = new BeanCaixaMotivoSaida();
    
    //Especiais
    FormataCampo                fc          = new FormataCampo();
    PegaProximoRegistro         PegProReg   = new PegaProximoRegistro();
    
    //Telas
    MotivosDeSaidaDeCaixaConsulta           MotSaiCaiCon;
    
    public MotivosDeSaidaDeCaixaCadastro(ArrayList DadosPadroes){
        dadosPadroes                        = DadosPadroes;
        
        somostra                            = (String)  dadosPadroes.get(0);
        bcms.codigoMotivoSaida              = (int)     dadosPadroes.get(1);
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_excluir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigoMotivoSaida = new javax.swing.JFormattedTextField();
        txt_descricaoMotivoSaida = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        bt_novo = new javax.swing.JButton();
        bt_incluir = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_pesquisa = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair1 = new javax.swing.JMenuItem();

        bt_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Delete.png"))); // NOI18N
        bt_excluir.setText("Excluir");
        bt_excluir.setEnabled(false);
        bt_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluirActionPerformed(evt);
            }
        });

        setTitle("Motivos de Saida de Caixa");
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
        jLabel1.setText("Motivos de Saída de Caixa");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Código:");

        try {
            txt_codigoMotivoSaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoMotivoSaida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoMotivoSaida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoMotivoSaidaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoMotivoSaidaFocusLost(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Descrição:");

        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

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
                        .addComponent(txt_codigoMotivoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_novo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txt_descricaoMotivoSaida))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_codigoMotivoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_descricaoMotivoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, jLabel2, jLabel3, txt_codigoMotivoSaida, txt_descricaoMotivoSaida});

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
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
                    .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_alterar)
                    .addComponent(bt_pesquisa)
                    .addComponent(bt_sair))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_alterar, bt_incluir, bt_pesquisa});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        txt_descricaoMotivoSaida.grabFocus();
        ReiniciaCampos();
        HabilitaCampos(true);
        
        bcms.codigoMotivoSaida  = PegProReg.PegaProximoRegistro("tb_caixa_motivo_saida", "codigoMotivoSaida", "");
        txt_codigoMotivoSaida.setText(fc.FormataCampo(String.valueOf(bcms.codigoMotivoSaida), 3, 0));
        
        operacao = "I";
        HabilitaBotoes();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        sql = "insert into tb_caixa_motivo_saida (idEmpresa, codigoGrupo, codigoEmpresa, codigoMotivoSaida, descricaoMotivoSaida) "
            + "values (" + bcms.idEmpresa + ", " + bcms.codigoGrupo + ", " + bcms.codigoEmpresa + ", " + bcms.codigoMotivoSaida + ", '" + bcms.descricaoMotivoSaida + "');";
        
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoMotivoSaida.grabFocus();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        sql = "update tb_caixa_motivo_saida set descricaoMotivoSaida = '"       + bcms.descricaoMotivoSaida + "' "
                                            + "where idMotivoSaida = "  + bcms.idMotivoSaida    + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoMotivoSaida.grabFocus();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void bt_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluirActionPerformed
        bcms.codigoMotivoSaida      = Integer.parseInt(txt_codigoMotivoSaida.getText());
        if(JOptionPane.showConfirmDialog(null, "Deseja realmente deletar o registro " + bcms.codigoMotivoSaida + " ?") != JOptionPane.YES_OPTION)
            return;
        
        sql = "delete from tb_caixa_motivo_saida where idMotivoSaida = " + bcms.idMotivoSaida + ";";
        sqlstate = parametrosNS.dao.ExcluirRegistro(sql);
        
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoMotivoSaida.grabFocus();
    }//GEN-LAST:event_bt_excluirActionPerformed

    private void txt_codigoMotivoSaidaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoMotivoSaidaFocusGained
        if(somostra.equalsIgnoreCase("S"))
            return;
        operacao = "";
        ReiniciaCampos();
        HabilitaBotoes();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoMotivoSaidaFocusGained

    private void txt_codigoMotivoSaidaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoMotivoSaidaFocusLost
        if(txt_codigoMotivoSaida.getText().replace(" ", "").equals(""))
            return;
        if(somostra.equalsIgnoreCase("S"))
            return;
        PegaMotivoSaida();
    }//GEN-LAST:event_txt_codigoMotivoSaidaFocusLost

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        if(MotSaiCaiCon != null)if(MotSaiCaiCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuPesquisa = 1;
        parametros.clear();
        parametros.add("S");
        MotSaiCaiCon = new MotivosDeSaidaDeCaixaConsulta(parametros);
        MotSaiCaiCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuPesquisa == 0)
            return;
        abriuPesquisa = 0;
        retorno = MotSaiCaiCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoMotivoSaida.setText(retorno);
        PegaMotivoSaida();
    }//GEN-LAST:event_formWindowGainedFocus

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HabilitaCampos(false);
        if(somostra.equalsIgnoreCase("S")){
            bt_incluir                  .setVisible(false);
            bt_alterar                  .setVisible(false);
            bt_excluir                  .setVisible(false);
            bt_pesquisa                 .setEnabled(false);
            txt_codigoMotivoSaida       .setEditable(false);
            bt_novo                     .setEnabled(false);
        }
        if(bcms.codigoMotivoSaida   != 0){
            txt_codigoMotivoSaida.setText(String.valueOf(bcms.codigoMotivoSaida));
            PegaMotivoSaida();
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(MotSaiCaiCon != null)MotSaiCaiCon.dispose();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_excluir;
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
    private javax.swing.JFormattedTextField txt_codigoMotivoSaida;
    private javax.swing.JTextField txt_descricaoMotivoSaida;
    // End of variables declaration//GEN-END:variables
    
    private void ReiniciaCampos(){
        txt_codigoMotivoSaida.setText("");
        txt_descricaoMotivoSaida.setText("");
    }
    
    private void HabilitaCampos(boolean Habilita){
        txt_descricaoMotivoSaida        .setEditable    (Habilita);
        txt_descricaoMotivoSaida        .setFocusable   (Habilita);
    }
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_incluir.setEnabled(true);
            bt_alterar.setEnabled(false);
            bt_excluir.setEnabled(false);
            return;
        }
        if(operacao.equals("A")){
            bt_incluir.setEnabled(false);
            bt_alterar.setEnabled(true);
            bt_excluir.setEnabled(true);
            return;
        }
        bt_incluir.setEnabled(false);
        bt_alterar.setEnabled(false);
        bt_excluir.setEnabled(false);
    }
    
    private void PegaValores(){
        fatal = "N";
        bcms.idEmpresa              = parametrosNS.be.IdEmpresa;
        bcms.codigoGrupo            = parametrosNS.bge.CodigoGrupo;
        bcms.codigoEmpresa          = parametrosNS.be.CodigoEmpresa;
        bcms.codigoMotivoSaida      = Integer.parseInt(txt_codigoMotivoSaida.getText());
        bcms.descricaoMotivoSaida   = txt_descricaoMotivoSaida.getText();
        if(bcms.descricaoMotivoSaida.equals("")){
            fatal = "S";
            Mensagem = "Descrição Inválida!";
            new MostraMensagem(Mensagem);
            return;
        }
    }
    
    private void PegaMotivoSaida(){
        txt_codigoMotivoSaida.setText(fc.FormataCampo(txt_codigoMotivoSaida.getText(), 3, 0));
        bcms.codigoMotivoSaida      = Integer.parseInt(txt_codigoMotivoSaida.getText());
        if(bcms.codigoMotivoSaida == 0)
            return;
        sql = "select * from tb_caixa_motivo_saida where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoMotivoSaida = " + bcms.codigoMotivoSaida + ";";
        dadosMotivoSaida.clear();
        dadosMotivoSaida = parametrosNS.dao.Consulta(sql);
        if(dadosMotivoSaida.isEmpty()){
            Mensagem = "Código " + bcms + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        HabilitaCampos(true);
        PegaDadosMotivoSaida();
    }
    
    private void PegaDadosMotivoSaida(){
        for(int i = 0; i < dadosMotivoSaida.size(); i++){
            bcms.idMotivoSaida          = Integer.parseInt(  String.valueOf(dadosMotivoSaida.get(i).get(0)));
            bcms.idEmpresa              = Integer.parseInt(  String.valueOf(dadosMotivoSaida.get(i).get(1)));
            bcms.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosMotivoSaida.get(i).get(2)));
            bcms.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosMotivoSaida.get(i).get(3)));
            bcms.codigoMotivoSaida      = Integer.parseInt(  String.valueOf(dadosMotivoSaida.get(i).get(4)));
            bcms.descricaoMotivoSaida   =                    String.valueOf(dadosMotivoSaida.get(i).get(5));
        }
        txt_descricaoMotivoSaida.setText(bcms.descricaoMotivoSaida);
    }
    
}
