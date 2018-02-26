package Parametros;

import Beans.BeanParametrosVendas;
import FuncoesInternas.MostraMensagem;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 @author Tiago e Paulo
 */
public class ParametrosVendas extends javax.swing.JFrame {
    //String's
    String sql                              = "";
    String sqlstate                         = "";
    String mensagem                         = "";
    String operacao                         = "";
    String fatal                            = "";
    
    //Bean
    BeanParametrosVendas bparven = new BeanParametrosVendas();
    
    //ArrayList
    ArrayList<ArrayList>    dadosParametrosVendas   = new ArrayList();
    
    public ParametrosVendas(){
        initComponents();
    }
    
    private void PegaParametrosVendas(){
        sql = "select * from tb_parametrosvendas where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosParametrosVendas.clear();
        dadosParametrosVendas = parametrosNS.dao.Consulta(sql);
        if(dadosParametrosVendas.isEmpty()){
            operacao = "I";
            return;
        }
        operacao = "A";
        PegaDadosParametrosVendas();
    }
    
    private void PegaDadosParametrosVendas(){
        for(int i = 0; i < dadosParametrosVendas.size(); i++){
            if(dadosParametrosVendas.get(i).get(0) != null){
                bparven.idParametrosVendas      = Integer.parseInt(  String.valueOf(dadosParametrosVendas.get(i).get(0)));
            }
            if(dadosParametrosVendas.get(i).get(1) != null){
                bparven.idEmpresa                   = Integer.parseInt(  String.valueOf(dadosParametrosVendas.get(i).get(1)));
            }
            if(dadosParametrosVendas.get(i).get(2) != null){
                bparven.codigoGrupo                 = Integer.parseInt(  String.valueOf(dadosParametrosVendas.get(i).get(2)));
            }
            if(dadosParametrosVendas.get(i).get(3) != null){
                bparven.codigoEmpresa               = Integer.parseInt(  String.valueOf(dadosParametrosVendas.get(i).get(3)));
            }
            if(dadosParametrosVendas.get(i).get(4) != null){
                bparven.infQtdMenor                 = Integer.parseInt(  String.valueOf(dadosParametrosVendas.get(i).get(4)));
            }
            if(dadosParametrosVendas.get(i).get(5) != null){
                bparven.valorDeMeta                 = Double.parseDouble(String.valueOf(dadosParametrosVendas.get(i).get(5)));
            }
            if(dadosParametrosVendas.get(i).get(6) != null){
                bparven.porcentagemDeComissao       = Double.parseDouble(String.valueOf(dadosParametrosVendas.get(i).get(6)));
            }
            if(dadosParametrosVendas.get(i).get(7) != null){
                bparven.pastaImpressaoAberturaCaixa =                    String.valueOf(dadosParametrosVendas.get(i).get(7));
            }
        }
        combo_infQtdMenor.setSelectedIndex(bparven.infQtdMenor);
        txt_valorDeMeta  .setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bparven.valorDeMeta), 0));
        txt_porcentagemDeComissao.setText(String.valueOf(bparven.porcentagemDeComissao * 100) + "%");
        
        if(!bparven.pastaImpressaoAberturaCaixa.equals("")){
            if(parametrosNS.bbd.so.equalsIgnoreCase("Windows")){
                bparven.pastaImpressaoAberturaCaixa = bparven.pastaImpressaoAberturaCaixa.replace("\\\\", "\\");
            }
            txt_pastaImpressaoAberturaCaixa.setText(bparven.pastaImpressaoAberturaCaixa);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        combo_infQtdMenor = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txt_valorDeMeta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_porcentagemDeComissao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_pastaImpressaoAberturaCaixa = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        bt_confirma = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Parâmetros de Vendas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Parâmetros de Vendas");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Informar quando produto estiver abaixo do limite ou em falta:");

        combo_infQtdMenor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Valor de meta para comissão dos usuários:");

        txt_valorDeMeta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_valorDeMetaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorDeMetaFocusLost(evt);
            }
        });
        txt_valorDeMeta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_valorDeMetaKeyPressed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Porcentagem de comissão para os usuários:");

        txt_porcentagemDeComissao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_porcentagemDeComissao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_porcentagemDeComissaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_porcentagemDeComissaoFocusLost(evt);
            }
        });
        txt_porcentagemDeComissao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_porcentagemDeComissaoKeyPressed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Pasta de destino de impressão da abertura de caixa:");

        txt_pastaImpressaoAberturaCaixa.setEditable(false);

        jButton1.setText("...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_pastaImpressaoAberturaCaixa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_valorDeMeta, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_infQtdMenor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_porcentagemDeComissao, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 162, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(combo_infQtdMenor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_valorDeMeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_porcentagemDeComissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_pastaImpressaoAberturaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {combo_infQtdMenor, jButton1, jLabel2, jLabel3, jLabel4, jLabel5, txt_pastaImpressaoAberturaCaixa, txt_porcentagemDeComissao, txt_valorDeMeta});

        bt_confirma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_confirma.setText("Confirma");
        bt_confirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmaActionPerformed(evt);
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
                        .addComponent(bt_confirma)
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
                    .addComponent(bt_confirma, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_confirma, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        PegaParametrosVendas();
    }//GEN-LAST:event_formWindowOpened

    private void bt_confirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmaActionPerformed
        if(operacao.equals("I")){
            IncluirParametrosVendas();
            return;
        }
        AlterarParametrosVendas();
    }//GEN-LAST:event_bt_confirmaActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void txt_valorDeMetaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorDeMetaFocusGained
        txt_valorDeMeta.setSelectionStart(0);
        txt_valorDeMeta.setSelectionEnd  (txt_valorDeMeta.getText().length());
        if(txt_valorDeMeta.getText().equals("")){
            return;
        }
        txt_valorDeMeta.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble((txt_valorDeMeta.getText()), 1));
    }//GEN-LAST:event_txt_valorDeMetaFocusGained

    private void txt_valorDeMetaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorDeMetaFocusLost
        if(txt_valorDeMeta.getText().equals("")){
            bparven.valorDeMeta = 0;
            return;
        }
        txt_valorDeMeta.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble((txt_valorDeMeta.getText()), 0));
    }//GEN-LAST:event_txt_valorDeMetaFocusLost

    private void txt_porcentagemDeComissaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_porcentagemDeComissaoFocusGained
        txt_porcentagemDeComissao.setSelectionStart(0);
        txt_porcentagemDeComissao.setSelectionEnd  (txt_porcentagemDeComissao.getText().length());
    }//GEN-LAST:event_txt_porcentagemDeComissaoFocusGained

    private void txt_porcentagemDeComissaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_porcentagemDeComissaoFocusLost
        try{
            if(!txt_porcentagemDeComissao.getText().replace(" ", "").equals("")){
                if(!txt_porcentagemDeComissao.getText().substring(txt_porcentagemDeComissao.getText().length() - 1, txt_porcentagemDeComissao.getText().length()).equals("%")){
                    txt_porcentagemDeComissao.setText(txt_porcentagemDeComissao.getText() + "%");
                }
            }
        }catch(Exception erro){
            mensagem = "Porcentagem de comissão inválido!";
            mostraMensagem();
        }
    }//GEN-LAST:event_txt_porcentagemDeComissaoFocusLost

    private void txt_valorDeMetaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valorDeMetaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_porcentagemDeComissao.grabFocus();
        }
    }//GEN-LAST:event_txt_valorDeMetaKeyPressed

    private void txt_porcentagemDeComissaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_porcentagemDeComissaoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            bt_confirma.grabFocus();
        }
    }//GEN-LAST:event_txt_porcentagemDeComissaoKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_confirma;
    private javax.swing.JButton bt_sair;
    private javax.swing.JComboBox<String> combo_infQtdMenor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_pastaImpressaoAberturaCaixa;
    private javax.swing.JTextField txt_porcentagemDeComissao;
    private javax.swing.JTextField txt_valorDeMeta;
    // End of variables declaration//GEN-END:variables
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    private void PegaValores(){
        bparven.idEmpresa                   = parametrosNS.be.IdEmpresa;
        bparven.codigoGrupo                 = parametrosNS.bge.CodigoGrupo;
        bparven.codigoEmpresa               = parametrosNS.be.CodigoEmpresa;
        bparven.infQtdMenor                 = combo_infQtdMenor.getSelectedIndex();
        bparven.valorDeMeta                 = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorDeMeta.getText(), 1));
        bparven.porcentagemDeComissao       = Double.parseDouble(txt_porcentagemDeComissao.getText().replace("%", "")) / 100;
        bparven.pastaImpressaoAberturaCaixa = txt_pastaImpressaoAberturaCaixa.getText();
        if(bparven.pastaImpressaoAberturaCaixa.equals("")){
            fatal = "S";
            mensagem = "Pasta de destino de impressões da abertura da caixa inválida!";
            mostraMensagem();
            return;
        }
        if(parametrosNS.bbd.so.equalsIgnoreCase("Windows")){
            bparven.pastaImpressaoAberturaCaixa = bparven.pastaImpressaoAberturaCaixa.replace("\\", "\\\\");
        }
    }
    
    private void IncluirParametrosVendas(){
        PegaValores();
        if(fatal.equals("S")){
            return;
        }
        sql = "insert into tb_parametrosvendas (idEmpresa, codigoGrupo, codigoEmpresa, infQtdMenor, valorDeMeta, porcentagemDeComissao, pastaImpressaoAberturaCaixa) "
            + "values (" + bparven.idEmpresa + ", " + bparven.codigoGrupo + ", " + bparven.codigoEmpresa + ", " + bparven.infQtdMenor + ", " + bparven.valorDeMeta + ", " + bparven.porcentagemDeComissao + ", '" + bparven.pastaImpressaoAberturaCaixa + "');";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao incluir parâmetros de vendas!";
            mostraMensagem();
            return;
        }
        mensagem = "Registro incluido com sucesso!";
        mostraMensagem();
    }
    
    private void AlterarParametrosVendas(){
        PegaValores();
        if(fatal.equals("S")){
            return;
        }
        sql = "update tb_parametrosvendas set infQtdMenor = "             + bparven.infQtdMenor                 + ", "
                                       + "valorDeMeta = "                 + bparven.valorDeMeta                 + ", "
                                       + "porcentagemDeComissao = "       + bparven.porcentagemDeComissao       + ", "
                                       + "pastaImpressaoAberturaCaixa = " + bparven.pastaImpressaoAberturaCaixa + " "
                                       + "where idEmpresa = " + bparven.idEmpresa + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao alterar parâmetros de vendas!";
            mostraMensagem();
            return;
        }
        mensagem = "Registro alterado com sucesso!";
        mostraMensagem();
    }
    
}
