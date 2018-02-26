package TelasFaturamento;

import Beans.BeanManutencoes;
import Dao.DaoMySQL;
import FuncoesInternas.ConverteValorDigitadoEmDouble;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.TransformaValorStringeDouble;
import Parametros.parametrosNS;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

/*
 @author Tiago e Paulo
 */
public class ManutencoesCadastro extends javax.swing.JFrame {
    //String's
    String sql      = "";
    String fatal    = "";
    String sqlstate = "";
    String Mensagem = "";
    String operacao = "";
    String somostra = "";
    String retorno  = "";
    
    //int's
    int    abriuManutencao  = 0;
    
    //Vetores
    ArrayList            parametros             = new ArrayList();
    ArrayList            dadosPadroes           = new ArrayList();
    ArrayList            dadosManutencoes       = new ArrayList();
    ArrayList<ArrayList> dadosAutoIncremento    = new ArrayList<ArrayList>();
    
    //Bean's
    BeanManutencoes                 bman    = new BeanManutencoes();
    
    //Especiais
    FormataCampo                    fc      = new FormataCampo();
    TransformaValorStringeDouble    TransStrDou = new TransformaValorStringeDouble();

    //Telas
    ManutencoesConsulta                 ManCon;
    
    public ManutencoesCadastro(ArrayList DadosPadroes){
        dadosPadroes                            = DadosPadroes;
        
        somostra                                = (String)  dadosPadroes.get(0);
        bman.codigoManutencao                   = (int)     dadosPadroes.get(1);
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigoManutencao = new javax.swing.JFormattedTextField();
        bt_novo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_descricaoManutencao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_valorManutencao = new javax.swing.JTextField();
        bt_incluir = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        bt_pesquisa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Manutenções");
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
        jLabel1.setText("Cadastro de Manutenções");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Código:");

        try {
            txt_codigoManutencao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoManutencao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoManutencao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoManutencaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoManutencaoFocusLost(evt);
            }
        });

        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Descrição da Manutençao:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Valor Da Manutenção:");

        txt_valorManutencao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_valorManutencaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorManutencaoFocusLost(evt);
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
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_descricaoManutencao)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_codigoManutencao, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_novo))
                            .addComponent(txt_valorManutencao, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 279, Short.MAX_VALUE)))
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
                    .addComponent(txt_codigoManutencao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_descricaoManutencao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_valorManutencao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, jLabel2, jLabel3, jLabel4, txt_codigoManutencao});

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

    private void txt_codigoManutencaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoManutencaoFocusGained
        if(txt_codigoManutencao.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        operacao = "";
        ReiniciaCampos();
        HabilitaBotoes();
        HabilitaBotoes(false);
    }//GEN-LAST:event_txt_codigoManutencaoFocusGained

    private void txt_codigoManutencaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoManutencaoFocusLost
        if(txt_codigoManutencao.isEditable() == false)
            return;
        if(txt_codigoManutencao.getText().replace(" ", "").equals(""))
            return;
        PegaManutencao();
    }//GEN-LAST:event_txt_codigoManutencaoFocusLost

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        ReiniciaCampos();
        HabilitaBotoes(true);
        
        bman.codigoManutencao   = parametrosNS.dao.ConsultaAutoIncremento("tb_codigomanutencoes");
        txt_codigoManutencao.setText(fc.FormataCampo(String.valueOf(bman.codigoManutencao), 3, 0));
        
        operacao = "I";
        HabilitaBotoes();
        txt_descricaoManutencao.grabFocus();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void txt_valorManutencaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorManutencaoFocusGained
        if(!txt_valorManutencao.getText().equals(""))
            txt_valorManutencao.setText(TransStrDou.TransformaValorStringeDouble(txt_valorManutencao.getText(), 0));
    }//GEN-LAST:event_txt_valorManutencaoFocusGained

    private void txt_valorManutencaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorManutencaoFocusLost
        if(!txt_valorManutencao.getText().equals(""))
            txt_valorManutencao.setText(TransStrDou.TransformaValorStringeDouble(txt_valorManutencao.getText(), 0));
    }//GEN-LAST:event_txt_valorManutencaoFocusLost

    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        parametros.clear();
        parametros.add("S");
        if(ManCon != null)if(ManCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuManutencao = 1;
        ManCon = new ManutencoesConsulta(parametros);
        ManCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuManutencao == 0)
            return;
        abriuManutencao = 0;
        retorno = ManCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoManutencao.setText(retorno);
        PegaManutencao();
    }//GEN-LAST:event_formWindowGainedFocus

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "insert into tb_codigomanutencoes (descricaoManutencao, valorManutencao) "
            + "values ('" + bman.descricaoManutencao + "', " + bman.valorManutencao + ");";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoManutencao.grabFocus();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "update tb_codigomanutencoes set descricaoManutencao = '"     + bman.descricaoManutencao  + "', "
                                            + "valorManutencao = "          + bman.valorManutencao      + " "
                                            + "where codigoManutencao = "   + bman.codigoManutencao     + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoManutencao.grabFocus();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HabilitaBotoes(false);
        if(somostra.equals("S")){
            bt_novo                     .setEnabled (false);
            txt_codigoManutencao        .setEditable(false);
            bt_incluir                  .setVisible (false);
            bt_alterar                  .setVisible (false);
            bt_pesquisa                 .setVisible (false);
        }
        if(bman.codigoManutencao != 0){
            txt_codigoManutencao        .setText(String.valueOf(bman.codigoManutencao));
            PegaManutencao();
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(ManCon    != null)ManCon.dispose();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisa;
    private javax.swing.JButton bt_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txt_codigoManutencao;
    private javax.swing.JTextField txt_descricaoManutencao;
    private javax.swing.JTextField txt_valorManutencao;
    // End of variables declaration//GEN-END:variables
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_incluir          .setEnabled(true);
            bt_alterar          .setEnabled(false);
            return;
        }
        if(operacao.equals("A")){
            bt_incluir          .setEnabled(false);
            bt_alterar          .setEnabled(true);
            return;
        }
        bt_incluir              .setEnabled(false);
        bt_alterar              .setEnabled(false);
    }
    
    private void ReiniciaCampos(){
        bman = new BeanManutencoes();
        txt_codigoManutencao    .setText("");
        txt_descricaoManutencao .setText("");
        txt_valorManutencao     .setText("");
    }
    
    private void HabilitaBotoes(boolean Habilita){
        txt_descricaoManutencao         .setEditable    (Habilita);
        txt_descricaoManutencao         .setFocusable   (Habilita);
        txt_valorManutencao             .setEditable    (Habilita);
        txt_valorManutencao             .setFocusable   (Habilita);
    }
    
    private void PegaManutencao(){
        txt_codigoManutencao.setText(fc.FormataCampo(txt_codigoManutencao.getText(), 3, 0));
        bman.codigoManutencao   = Integer.parseInt(txt_codigoManutencao.getText());
        if(bman.codigoManutencao == 0)
            return;
        sql = "select * from tb_codigomanutencoes where codigoManutencao = " + bman.codigoManutencao + ";";
        dadosManutencoes.clear();
        dadosManutencoes = parametrosNS.dao.ConsultaManutencoes(sql);
        if(dadosManutencoes.isEmpty()){
            Mensagem = "Manutenção n°" + bman.codigoManutencao + " não encontrada!";
            new MostraMensagem(Mensagem);
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        HabilitaBotoes(true);
        PegaDadosManutencao();
    }
    
    private void PegaDadosManutencao(){
        for(int i = 0; i < dadosManutencoes.size(); i++){
            bman.codigoManutencao       = ((BeanManutencoes)(dadosManutencoes.get(i))).codigoManutencao;
            bman.descricaoManutencao    = ((BeanManutencoes)(dadosManutencoes.get(i))).descricaoManutencao;
            bman.valorManutencao        = ((BeanManutencoes)(dadosManutencoes.get(i))).valorManutencao;
        }
        txt_descricaoManutencao.setText(bman.descricaoManutencao);
        txt_valorManutencao.setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(bman.valorManutencao), 0));
    }
    
    private void PegaValores(){
        fatal = "N";
        bman.codigoManutencao       = Integer.parseInt(txt_codigoManutencao.getText());
        bman.descricaoManutencao    = txt_descricaoManutencao.getText();
        if(bman.descricaoManutencao.equals("")){
            Mensagem = "Descrição Inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        if(txt_valorManutencao.getText().equals("")){
            Mensagem = "Valor Inválido!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bman.valorManutencao        = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_valorManutencao.getText(), 1));
        if(bman.valorManutencao == 0){
            Mensagem = "Valor da Manutenção não pode ser 0!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
    }
    
}
