package TelasProducao;

import BeansNS.BeanEmpresas;
import Beans.*;
import Dao.*;
import FuncoesInternas.*;
import TelasDeConfiguracoes.*;
import Parametros.parametrosNS;
import java.sql.*;
import java.text.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 @author Tiago e Paulo
 */
public class ServicoCadastro extends javax.swing.JFrame {
    //String's
    String sql                      = "";
    String fatal                    = "";
    String sqlstate                 = "";
    String somostra                 = "";
    String operacao                 = "";
    String Mensagem                 = "";
    String retorno                  = "";
    
    //int's
    int    abriuServico             = 0;
    
    //Vetores
    ArrayList            parametros            = new ArrayList();
//    ArrayList            dadosPadroes          = new ArrayList();
    ArrayList<ArrayList> dadosServicos         = new ArrayList<ArrayList>();
    
    //Bean's
    BeanServicos            bser    = new BeanServicos();
    
    //Especiais
    FormataCampo                    fc          = new FormataCampo();
    PegaProximoRegistro             PegProReg   = new PegaProximoRegistro();
    TransformaValorStringeDouble    TransStrDou = new TransformaValorStringeDouble();
    
    //Telas
    ServicoConsulta     SerCon;
    
    public ServicoCadastro(String Somostra, int CodigoServico){
        somostra           = Somostra;
        bser.codigoServico = CodigoServico;
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_excluir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_codigoServico = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_descricaoServico = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_valorServico = new javax.swing.JTextField();
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
        jLabel1.setText("Cadastro de Serviços");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_codigoServico.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        try {
            txt_codigoServico.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoServico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoServico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoServicoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoServicoFocusLost(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Código: ");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Descrição: ");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Valor: ");

        txt_valorServico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorServicoFocusLost(evt);
            }
        });

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
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_codigoServico, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_novo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_descricaoServico)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_valorServico, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 322, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_descricaoServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_valorServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, jLabel2, jLabel3, jLabel4, txt_codigoServico});

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
                    .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        txt_descricaoServico.grabFocus();
        ReiniciaCampos();
        HabilitaCampos(true);
        
        bser.codigoServico = PegProReg.PegaProximoRegistro("tb_servicos", "codigoServico", "");
        txt_codigoServico.setText(fc.FormataCampo(String.valueOf(bser.codigoServico), 6, 0));
        
        operacao = "I";
        HabilitaBotoes();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void txt_codigoServicoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoServicoFocusLost
        if(somostra.equals("S"))
            return;
        if(txt_codigoServico.getText().replace(" ", "").equals(""))
            return;
        PegaServico();
    }//GEN-LAST:event_txt_codigoServicoFocusLost

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        sql = "insert into tb_servicos (idEmpresa, codigoGrupo, codigoEmpresa, codigoServico, descricaoServico, valorServico) "
            + "values (" + bser.idEmpresa + ", " + bser.codigoGrupo + ", " + bser.codigoEmpresa + ", " + bser.codigoServico + ", '" + bser.descricaoServico + "', " + bser.valorServico + ");";
        
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoServico.grabFocus();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        sql = "update tb_servicos set descricaoServico = '"     + bser.descricaoServico + "', " +
                                     "valorServico = "          + bser.valorServico     + " "  +
                                     "where idServico = "   + bser.idServico        + ";";
        
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoServico.grabFocus();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        if(SerCon != null)if(SerCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuServico = 1;
        parametros.clear();
        parametros.add("S");
        SerCon = new ServicoConsulta(parametros);
        SerCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuServico == 0)
            return;
        retorno = SerCon.getRetorno();
        if(retorno.equals(""))
            return;
        abriuServico = 0;
        txt_codigoServico.setText(retorno);
        PegaServico();
    }//GEN-LAST:event_formWindowGainedFocus

    private void txt_codigoServicoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoServicoFocusGained
        if(somostra.equals("S"))
            return;
        operacao = "";
        ReiniciaCampos();
        HabilitaBotoes();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoServicoFocusGained

    private void txt_valorServicoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorServicoFocusLost
        if(!txt_valorServico.getText().equals(""))
            txt_valorServico.setText(TransStrDou.TransformaValorStringeDouble(txt_valorServico.getText(), 0));
    }//GEN-LAST:event_txt_valorServicoFocusLost

    private void bt_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluirActionPerformed
        bser.codigoServico      = Integer.parseInt(txt_codigoServico.getText());
        if(JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir o registro n°" + bser.codigoServico + "?") != JOptionPane.YES_OPTION)
            return;
        sql = "delete from tb_servicos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoServico = '" + bser.codigoServico + "';";
        sqlstate = parametrosNS.dao.ExcluirRegistro(sql);
        
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoServico.grabFocus();
    }//GEN-LAST:event_bt_excluirActionPerformed

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HabilitaCampos(false);
        bt_excluir.setVisible(false);
        if(somostra.equalsIgnoreCase("S")){
            bt_incluir          .setVisible (false);
            bt_alterar          .setVisible (false);
            bt_excluir          .setVisible (false);
            bt_pesquisa         .setVisible (false);
            txt_codigoServico   .setEditable(false);
            bt_novo             .setEnabled (false);
        }
        if(somostra.equalsIgnoreCase("SN"))
            bt_pesquisa         .setVisible (false);
        if(bser.codigoServico != 0){
            txt_codigoServico.setText(String.valueOf(bser.codigoServico));
            PegaServico();
        }
    }//GEN-LAST:event_formWindowOpened

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(SerCon   != null)SerCon.dispose();
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txt_codigoServico;
    private javax.swing.JTextField txt_descricaoServico;
    private javax.swing.JTextField txt_valorServico;
    // End of variables declaration//GEN-END:variables
    
    private void ReiniciaCampos(){
        txt_codigoServico.setText("");
        txt_descricaoServico.setText("");
        txt_valorServico.setText("");
    }
    
    private void HabilitaCampos(boolean Habilita){
        txt_descricaoServico        .setEditable    (Habilita);
        txt_descricaoServico        .setFocusable   (Habilita);
        txt_valorServico            .setEditable    (Habilita);
        txt_valorServico            .setFocusable   (Habilita);
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
    
    private void PegaServico(){
        if(abriuServico == 1)
            return;
        txt_codigoServico.setText(fc.FormataCampo(txt_codigoServico.getText(), 6, 0));
        bser.codigoServico = Integer.parseInt(txt_codigoServico.getText());
        if(bser.codigoServico == 0)
            return;
        sql = "select * from tb_servicos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoServico = '" + bser.codigoServico + "';";
        dadosServicos.clear();
        dadosServicos = parametrosNS.dao.Consulta(sql);
        if(dadosServicos.isEmpty()){
            Mensagem = "Serviço código " + bser.codigoServico + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        operacao = "A";
        PegaDadosServicos();
        HabilitaBotoes();
        HabilitaCampos(true);
    }
    
    private void PegaDadosServicos(){
        for(int i = 0; i < dadosServicos.size(); i++){
            if(dadosServicos.get(i).get(0) != null)
                bser.idServico          = Integer.parseInt(  String.valueOf(dadosServicos.get(i).get(0)));
            if(dadosServicos.get(i).get(1) != null)
                bser.idEmpresa          = Integer.parseInt(  String.valueOf(dadosServicos.get(i).get(1)));
            if(dadosServicos.get(i).get(2) != null)
                bser.codigoGrupo        = Integer.parseInt(  String.valueOf(dadosServicos.get(i).get(2)));
            if(dadosServicos.get(i).get(3) != null)
                bser.codigoEmpresa      = Integer.parseInt(  String.valueOf(dadosServicos.get(i).get(3)));
            if(dadosServicos.get(i).get(4) != null)
                bser.codigoServico      = Integer.parseInt(  String.valueOf(dadosServicos.get(i).get(4)));
                bser.descricaoServico   =                    String.valueOf(dadosServicos.get(i).get(5));
            if(dadosServicos.get(i).get(6) != null)
                bser.valorServico       = Double.parseDouble(String.valueOf(dadosServicos.get(i).get(6)));
        }
        txt_descricaoServico.setText(bser.descricaoServico);
        txt_valorServico.setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(bser.valorServico), 0));
    }
    
    private void PegaValores(){
        fatal = "N";
        bser.idEmpresa          = parametrosNS.be.IdEmpresa;
        bser.codigoGrupo        = parametrosNS.bge.CodigoGrupo;
        bser.codigoEmpresa      = parametrosNS.be.CodigoEmpresa;
        bser.codigoServico      = Integer.parseInt(txt_codigoServico.getText());
        bser.descricaoServico   = txt_descricaoServico.getText();
        if(bser.descricaoServico.equals("")){
            Mensagem = "Descrição inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        if(txt_valorServico.getText().equals("")){
            Mensagem = "Valor do Serviço inválido!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bser.valorServico       = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_valorServico.getText(), 1));
    }
    
}
