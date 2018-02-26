package TelasFaturamento;

import BeansNS.BeanCidades;
import BeansNS.BeanEstados;
import Beans.BeanVeiculos;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.PegaProximoRegistro;
import Parametros.parametrosNS;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 @author Tiago e Paulo
 */
public class VeiculosCadastro extends javax.swing.JFrame {
    //String's
    String sql                              = "";
    String sqlstate                         = "";
    String fatal                            = "";
    String Mensagem                         = "";
    String somostra                         = "";
    String operacao                         = "";
    String retorno                          = "";
    
    //int's
    int    abriuVeiCon                      = 0;
    
    //ArrayList's
    ArrayList            parametros                    = new ArrayList();
    ArrayList            dadosPadroes                  = new ArrayList();
    ArrayList<ArrayList> dadosCidades                  = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosVeiculos                 = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosEstados                  = new ArrayList<ArrayList>();
    
    //Bean's
    BeanCidades                 bcid        = new BeanCidades();
    BeanEstados                 best        = new BeanEstados();
    BeanVeiculos                bvei        = new BeanVeiculos();
    
    //Especiais
    FormataCampo                fc          = new FormataCampo();
    PegaProximoRegistro         PegProReg   = new PegaProximoRegistro();
    
    //Telas
    VeiculosConsulta            VeiCon;
    
    public VeiculosCadastro(ArrayList DadosPadroes){
        dadosPadroes                        = DadosPadroes;
        
        somostra                            = (String)  dadosPadroes.get(0);
        bvei.codigoVeiculo                  = (int)     dadosPadroes.get(1);
        
        initComponents();
    }

    private void PegaUF(){
        sql = "select uf from ns_estados;";
        dadosEstados.clear();
        dadosEstados = parametrosNS.dao.Consulta(sql);
        if(dadosEstados.isEmpty()){
            Mensagem = "Unidades Federativas Não encontradas!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosUF();
    }
    
    private void PegaDadosUF(){
        combo_uf.removeAllItems();
        combo_uf.addItem("--");
        for(int i = 0; i < dadosEstados.size(); i++){
            best.uf = String.valueOf(dadosEstados.get(i).get(0));
            combo_uf.addItem(best.uf);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_excluir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_placa = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_codigoVeiculo = new javax.swing.JFormattedTextField();
        bt_novo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        combo_uf = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_rntc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        combo_cidade = new javax.swing.JComboBox<>();
        bt_incluir = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        bt_pesquisa = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Veículos");
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
        jLabel1.setText("Cadastro de Veículos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Código:");

        try {
            txt_placa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("***-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_placa.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Placa:");

        try {
            txt_codigoVeiculo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoVeiculo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoVeiculo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoVeiculoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoVeiculoFocusLost(evt);
            }
        });

        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        jLabel4.setText("UF:");

        combo_uf.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_ufItemStateChanged(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("RNTC:");

        jLabel6.setText("Cidade:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_codigoVeiculo)
                            .addComponent(txt_placa, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(60, 60, 60))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combo_uf, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_rntc))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel5});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_codigoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_placa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(combo_uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(combo_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_rntc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, combo_cidade, combo_uf, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, txt_codigoVeiculo, txt_placa, txt_rntc});

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

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        bt_pesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/View.png"))); // NOI18N
        bt_pesquisa.setText("Pesquisa");
        bt_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaActionPerformed(evt);
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
                    .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HabilitaCampos(false);
        PegaUF();
        
        if(somostra.equals("S")){
            bt_novo             .setEnabled (false);
            txt_codigoVeiculo   .setEditable(false);
            combo_uf            .setEnabled (false);
            combo_cidade        .setEnabled (false);
            bt_incluir          .setVisible (false);
            bt_alterar          .setVisible (false);
            bt_excluir          .setVisible (false);
            bt_pesquisa         .setVisible (false);
        }
        if(bvei.codigoVeiculo != 0){
            txt_codigoVeiculo   .setText(String.valueOf(bvei.codigoVeiculo));
            PegaVeiculo();
        }
        if(somostra.equals("SN"))
            bt_pesquisa         .setVisible (false);
    }//GEN-LAST:event_formWindowOpened

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        ReiniciaCampos();
        HabilitaCampos(true);
        
        bvei.codigoVeiculo  = PegProReg.PegaProximoRegistro("tb_veiculos", "codigoVeiculo", "");
        txt_codigoVeiculo   .setText(fc.FormataCampo(String.valueOf(bvei.codigoVeiculo), 5, 0));
        
        operacao = "I";
        HabilitaBotoes();
        txt_placa.grabFocus();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void txt_codigoVeiculoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoVeiculoFocusGained
        if(txt_codigoVeiculo.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        operacao = "";
        ReiniciaCampos();
        HabilitaBotoes();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoVeiculoFocusGained

    private void txt_codigoVeiculoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoVeiculoFocusLost
        if(txt_codigoVeiculo.isEditable() == false)
            return;
        if(txt_codigoVeiculo.getText().replace(" ", "").equals(""))
            return;
        PegaVeiculo();
    }//GEN-LAST:event_txt_codigoVeiculoFocusLost

    private void combo_ufItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_ufItemStateChanged
        if(combo_uf.isEnabled() == false)
            return;
        PegaCidades();
    }//GEN-LAST:event_combo_ufItemStateChanged

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "insert into tb_veiculos (idEmpresa, codigoGrupo, codigoEmpresa, codigoVeiculo, placaVeiculo, ufVeiculo, cidadeVeiculo, rntcVeiculo) "
            + "values (" + bvei.idEmpresa + ", " + bvei.codigoGrupo + ", " + bvei.codigoEmpresa + ", " + bvei.codigoVeiculo + ", '" + bvei.placaVeiculo + "', '" + bvei.ufVeiculo + "', '" + bvei.cidadeVeiculo + "', '" + bvei.rntcVeiculo + "');";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoVeiculo.grabFocus();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "update tb_veiculos set placaVeiculo = '"         + bvei.placaVeiculo     + "'," +
                                    " ufVeiculo = '"            + bvei.ufVeiculo        + "'," +
                                    " cidadeVeiculo = '"        + bvei.cidadeVeiculo    + "'," +
                                    " rntcVeiculo = '"          + bvei.rntcVeiculo      + "' " +
                                    " where idVeiculo = "   + bvei.idVeiculo        + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoVeiculo.grabFocus();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void bt_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluirActionPerformed
        bvei.codigoVeiculo  = Integer.parseInt(txt_codigoVeiculo.getText());
        if(JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir o registro n°" + bvei.codigoVeiculo + "?", "", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION)
            return;
        
        sql = "delete from tb_veiculos where idVeiculo = " + bvei.idVeiculo + ";";
        sqlstate = parametrosNS.dao.ExcluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoVeiculo.grabFocus();
    }//GEN-LAST:event_bt_excluirActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        abriuVeiCon = 1;
        parametros.clear();
        parametros.add("S");
        if(VeiCon != null)if(VeiCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuVeiCon = 1;
        VeiCon = new VeiculosConsulta(parametros);
        VeiCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuVeiCon == 0)
            return;
        abriuVeiCon = 0;
        retorno = VeiCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoVeiculo.setText(retorno);
        PegaVeiculo();
    }//GEN-LAST:event_formWindowGainedFocus

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(VeiCon   != null)VeiCon.dispose();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_excluir;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisa;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JComboBox<String> combo_cidade;
    private javax.swing.JComboBox<String> combo_uf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txt_codigoVeiculo;
    private javax.swing.JFormattedTextField txt_placa;
    private javax.swing.JTextField txt_rntc;
    // End of variables declaration//GEN-END:variables
    
    private void ReiniciaCampos(){
        txt_codigoVeiculo   .setText("");
        txt_placa           .setText("");
        combo_uf            .setSelectedIndex(0);
        if(combo_cidade.getItemCount() > 0)combo_cidade        .setSelectedIndex(0);
        txt_rntc            .setText("");
    }
    
    private void HabilitaCampos(boolean Habilita){
        txt_placa           .setEditable    (Habilita);
        txt_placa           .setFocusable   (Habilita);
        combo_uf            .setEnabled     (Habilita);
        combo_uf            .setFocusable   (Habilita);
        combo_cidade        .setEnabled     (Habilita);
        combo_cidade        .setFocusable   (Habilita);
        txt_rntc            .setEditable    (Habilita);
        txt_rntc            .setFocusable   (Habilita);
    }
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_incluir  .setEnabled(true);
            bt_alterar  .setEnabled(false);
            bt_excluir  .setEnabled(false);
            return;
        }
        if(operacao.equals("A")){
            bt_incluir  .setEnabled(false);
            bt_alterar  .setEnabled(true);
            bt_excluir  .setEnabled(true);
            return;
        }
        bt_incluir      .setEnabled(false);
        bt_alterar      .setEnabled(false);
        bt_excluir      .setEnabled(false);
    }
    
    private void PegaVeiculo(){
        txt_codigoVeiculo.setText(fc.FormataCampo(txt_codigoVeiculo.getText(), 5, 0));
        bvei.codigoVeiculo  = Integer.parseInt(txt_codigoVeiculo.getText());
        if(bvei.codigoVeiculo == 0)
            return;
        sql = "select * from tb_veiculos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoVeiculo = " + bvei.codigoVeiculo + ";";
        dadosVeiculos.clear();
        dadosVeiculos = parametrosNS.dao.Consulta(sql);
        if(dadosVeiculos.isEmpty()){
            Mensagem = "Veículo n°" + bvei.codigoVeiculo + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        HabilitaCampos(true);
        PegaDadosVeiculos();
    }
    
    private void PegaDadosVeiculos(){
        for(int i = 0; i < dadosVeiculos.size(); i++){
            if(dadosVeiculos.get(i).get(0) != null)
                bvei.idVeiculo      = Integer.parseInt(  String.valueOf(dadosVeiculos.get(i).get(0)));
            if(dadosVeiculos.get(i).get(1) != null)
                bvei.idEmpresa      = Integer.parseInt(  String.valueOf(dadosVeiculos.get(i).get(1)));
            if(dadosVeiculos.get(i).get(2) != null)
                bvei.codigoGrupo    = Integer.parseInt(  String.valueOf(dadosVeiculos.get(i).get(2)));
            if(dadosVeiculos.get(i).get(3) != null)
                bvei.codigoEmpresa  = Integer.parseInt(  String.valueOf(dadosVeiculos.get(i).get(3)));
            if(dadosVeiculos.get(i).get(4) != null)
                bvei.codigoVeiculo  = Integer.parseInt(  String.valueOf(dadosVeiculos.get(i).get(4)));
                bvei.placaVeiculo   =                    String.valueOf(dadosVeiculos.get(i).get(5));
                bvei.ufVeiculo      =                    String.valueOf(dadosVeiculos.get(i).get(6));
                bvei.cidadeVeiculo  =                    String.valueOf(dadosVeiculos.get(i).get(7));
                bvei.rntcVeiculo    =                    String.valueOf(dadosVeiculos.get(i).get(8));
        }
        txt_placa       .setText        (bvei.placaVeiculo);
        combo_uf        .setSelectedItem(bvei.ufVeiculo);
        PegaCidades();
        combo_cidade    .setSelectedItem(bvei.cidadeVeiculo);
        if(bvei.rntcVeiculo.equals("null"))
            bvei.rntcVeiculo = "";
        txt_rntc        .setText        (bvei.rntcVeiculo);
    }
    
    private void PegaCidades(){
        combo_cidade    .removeAllItems();
        combo_cidade    .setEditable(false);
        bcid.uf = String.valueOf(combo_uf.getSelectedItem());
        bcid.uf = bcid.uf.replace("-", "");
        if(bcid.uf.equals("ZZ")){
            UnidadeFederativaExterior();
            return;
        }
        if(bcid.uf.equals(""))
            return;
        combo_cidade.addItem("----------");
        sql = "select * from ns_cidades where uf = '" + bcid.uf + "';";
        dadosCidades.clear();
        dadosCidades = parametrosNS.dao.Consulta(sql);
        if(dadosCidades.isEmpty()){
            Mensagem = "Não foram encontrado cidades para a sigla " + bcid.uf + "!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosCidades();
    }
    
    private void PegaDadosCidades(){
        for(int i = 0; i < dadosCidades.size(); i++){
            bcid.codigoCidade   = Integer.parseInt(  String.valueOf(dadosCidades.get(i).get(0)));
            bcid.codigoEstado   = Integer.parseInt(  String.valueOf(dadosCidades.get(i).get(1)));
            bcid.uf             =                    String.valueOf(dadosCidades.get(i).get(2));
            bcid.nome           =                    String.valueOf(dadosCidades.get(i).get(3));
            
            combo_cidade.addItem(bcid.nome);
        }
    }
    
    private void UnidadeFederativaExterior(){
        combo_cidade    .setEditable(true);
        combo_cidade    .grabFocus();
    }
    
    private void PegaValores(){
        fatal = "N";
        bvei.idEmpresa          = parametrosNS.be.IdEmpresa;
        bvei.codigoGrupo        = parametrosNS.bge.CodigoGrupo;
        bvei.codigoEmpresa      = parametrosNS.be.CodigoEmpresa;
        bvei.codigoVeiculo      = Integer.parseInt(txt_codigoVeiculo.getText());
        bvei.placaVeiculo       = txt_placa.getText().replace(" ", "");
        if(bvei.placaVeiculo.equals("")){
            Mensagem = "Placa Inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        if(combo_uf.getSelectedIndex() == 0){
            Mensagem = "Unidade Federativa(UF) Inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bvei.ufVeiculo          = String.valueOf(combo_uf       .getSelectedItem());
        bvei.cidadeVeiculo      = String.valueOf(combo_cidade   .getSelectedItem());
        if(bvei.cidadeVeiculo.equals("")){
            Mensagem = "Cidade selecionada inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
    }
    
}
