package TelasFinanceiro;

import Beans.BeanDespesasTipo;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.PegaProximoRegistro;
import Parametros.parametrosNS;
import java.util.ArrayList;

/*
 @author Tiago e Paulo
 */
public class DespesasTipoCadastro extends javax.swing.JFrame {
    //int's
    int    abriuDespesaTipo                             = 0;
    
    //String's
    String sql                                          = "";
    String fatal                                        = "";
    String sqlstate                                     = "";
    String somostra                                     = "";
    String operacao                                     = "";
    String Mensagem                                     = "";
    String retorno                                      = "";
    
    //Vetores
    ArrayList            parametros                                = new ArrayList();
    ArrayList            dadosPadroes                              = new ArrayList();
    ArrayList<ArrayList> dadosDespesasTipo                         = new ArrayList<ArrayList>();
    
    //Bean's
    BeanDespesasTipo                        bdest       = new BeanDespesasTipo();
    
    //Especiais
    PegaProximoRegistro                     PegProReg   = new PegaProximoRegistro();
    
    //Telas
    DespesasTipoConsulta        DesTipoCon;
    
    public DespesasTipoCadastro(ArrayList DadosPadroes){
        dadosPadroes                    = DadosPadroes;
        
        somostra                        = (String)  dadosPadroes.get(0);
        bdest.codigoDespesaTipo         = (int)     dadosPadroes.get(1);
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigoDespesaTipo = new javax.swing.JFormattedTextField();
        bt_novo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_descricaoDespesaTipo = new javax.swing.JTextField();
        bt_incluir = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        bt_pesquisa = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Tipo de Despesas");
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
        jLabel1.setText("Tipos de Despesas");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Código:");

        try {
            txt_codigoDespesaTipo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoDespesaTipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoDespesaTipo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoDespesaTipoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoDespesaTipoFocusLost(evt);
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoDespesaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_novo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txt_descricaoDespesaTipo))
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
                    .addComponent(txt_codigoDespesaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_descricaoDespesaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, jLabel2, jLabel3, txt_codigoDespesaTipo});

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
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

    private void txt_codigoDespesaTipoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoDespesaTipoFocusGained
        if(txt_codigoDespesaTipo.getText().replace(" ", "").equals(""))
            return;
        if(txt_codigoDespesaTipo.isEditable() == false)
            return;
        operacao = "";
        HabilitaBotoes();
        HabilitaCampos(false);
        ReiniciaCampos();
    }//GEN-LAST:event_txt_codigoDespesaTipoFocusGained

    private void txt_codigoDespesaTipoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoDespesaTipoFocusLost
        if(txt_codigoDespesaTipo.getText().replace(" ", "").equals(""))
            return;
        if(somostra.equals("S"))
            return;
        PegaDespesaTipo();
    }//GEN-LAST:event_txt_codigoDespesaTipoFocusLost

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        ReiniciaCampos();
        HabilitaCampos(true);
        
        bdest.codigoDespesaTipo = PegProReg.PegaProximoRegistro("tb_despesas_tipo", "codigoDespesaTipo", "");
        txt_codigoDespesaTipo.setText(parametrosNS.fc.FormataCampo(String.valueOf(bdest.codigoDespesaTipo), 2, 0));
        
        operacao = "I";
        HabilitaBotoes();
        txt_descricaoDespesaTipo.grabFocus();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "insert into tb_despesas_tipo (idEmpresa, codigoGrupo, codigoEmpresa, codigoDespesaTipo, descricaoDespesaTipo) "
            + "values (" + bdest.idEmpresa + ", " + bdest.codigoGrupo + ", " + bdest.codigoEmpresa + ", " + bdest.codigoDespesaTipo + ", '" + bdest.descricaoDespesaTipo + "');";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoDespesaTipo.grabFocus();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "update tb_despesas_tipo set descricaoDespesaTipo = '"    + bdest.descricaoDespesaTipo    + "' "
                                        + "where idDespesaTipo = "  + bdest.idDespesaTipo   + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoDespesaTipo.grabFocus();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        abriuDespesaTipo = 1;
        parametros.clear();
        parametros.add("S");
        DesTipoCon = new DespesasTipoConsulta(parametros);
        DesTipoCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuDespesaTipo == 0)
            return;
        abriuDespesaTipo = 0;
        retorno = DesTipoCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoDespesaTipo.setText(retorno);
        PegaDespesaTipo();
    }//GEN-LAST:event_formWindowGainedFocus

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HabilitaCampos(false);
        if(somostra.equals("S")){
            txt_codigoDespesaTipo   .setEditable(false);
            bt_novo                 .setEnabled (false);
            bt_incluir              .setVisible (false);
            bt_alterar              .setVisible (false);
            bt_pesquisa             .setVisible (false);
        }
        if(bdest.codigoDespesaTipo != 0){
            txt_codigoDespesaTipo   .setText(String.valueOf(bdest.codigoDespesaTipo));
            PegaDespesaTipo();
        }
        if(somostra.equals("SN")){
            bt_pesquisa             .setVisible (false);
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(DesTipoCon   != null)DesTipoCon.dispose();
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
    private javax.swing.JFormattedTextField txt_codigoDespesaTipo;
    private javax.swing.JTextField txt_descricaoDespesaTipo;
    // End of variables declaration//GEN-END:variables
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_incluir          .setEnabled (true);
            bt_alterar          .setEnabled (false);
            return;
        }
        if(operacao.equals("A")){
            bt_incluir          .setEnabled (false);
            bt_alterar          .setEnabled (true);
            return;
        }
        bt_incluir              .setEnabled (false);
        bt_alterar              .setEnabled (false);
    }
    
    private void ReiniciaCampos(){
        txt_codigoDespesaTipo   .setText("");
        txt_descricaoDespesaTipo.setText("");
    }
    
    private void HabilitaCampos(boolean Habilita){
        txt_descricaoDespesaTipo    .setEditable    (Habilita);
        txt_descricaoDespesaTipo    .setFocusable   (Habilita);
    }
    
    private void PegaDespesaTipo(){
        bdest.codigoDespesaTipo = Integer.parseInt(txt_codigoDespesaTipo.getText().replace(" ", ""));
        if(bdest.codigoDespesaTipo == 0)
            return;
        sql = "select * from tb_despesas_tipo where codigoGrupo = " + parametrosNS.bge.codigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and codigoDespesaTipo = " + bdest.codigoDespesaTipo + ";";
        dadosDespesasTipo.clear();
        dadosDespesasTipo = parametrosNS.dao.Consulta(sql);
        if(dadosDespesasTipo.isEmpty()){
            Mensagem = "Tipo de despesa n°" + bdest.codigoDespesaTipo + " não encontrada!";
            new MostraMensagem(Mensagem);
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        HabilitaCampos(true);
        PegaDadosDespesaTipo();
    }
    
    private void PegaDadosDespesaTipo(){
        for(int i = 0; i < dadosDespesasTipo.size(); i++){
            bdest = new BeanDespesasTipo();
            bdest.idDespesaTipo         = Integer.parseInt(  String.valueOf(dadosDespesasTipo.get(i).get(0)));
            bdest.idEmpresa             = Integer.parseInt(  String.valueOf(dadosDespesasTipo.get(i).get(1)));
            bdest.codigoGrupo           = Integer.parseInt(  String.valueOf(dadosDespesasTipo.get(i).get(2)));
            bdest.codigoEmpresa         = Integer.parseInt(  String.valueOf(dadosDespesasTipo.get(i).get(3)));
            bdest.codigoDespesaTipo     = Integer.parseInt(  String.valueOf(dadosDespesasTipo.get(i).get(4)));
            bdest.descricaoDespesaTipo  =                    String.valueOf(dadosDespesasTipo.get(i).get(5));
        }
        txt_codigoDespesaTipo   .setText(parametrosNS.fc.FormataCampo(String.valueOf(bdest.codigoDespesaTipo), 2, 0));
        txt_descricaoDespesaTipo.setText(bdest.descricaoDespesaTipo);
    }
    
    private void PegaValores(){
        bdest.idEmpresa                 = parametrosNS.be.IdEmpresa;
        bdest.codigoGrupo               = parametrosNS.bge.CodigoGrupo;
        bdest.codigoEmpresa             = parametrosNS.be.CodigoEmpresa;
        bdest.codigoDespesaTipo         = Integer.parseInt(txt_codigoDespesaTipo.getText());
        bdest.descricaoDespesaTipo      = txt_descricaoDespesaTipo.getText();
        if(bdest.descricaoDespesaTipo.equals("")){
            Mensagem = "Descrição Inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
//            return;
        }
    }
    
}
