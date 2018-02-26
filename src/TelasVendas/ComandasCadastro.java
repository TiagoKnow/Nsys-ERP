package TelasVendas;

import Beans.BeanComandas;
import Dao.DaoMySQL;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.PegaProximoRegistro;
import Parametros.parametrosNS;
import java.sql.Connection;
import java.util.ArrayList;

/*
 @author Tiago e Paulo 19/08/2016 as 16:20
 */
public class ComandasCadastro extends javax.swing.JFrame {
    //String's
    String sql                                  = "";
    String fatal                                = "";
    String sqlstate                             = "";
    String Mensagem                             = "";
    String retorno                              = "";
    String somostra                             = "";
    String operacao                             = "";
    
    //int's
    int    abriuComanda                         = 0;
    
    //Vetores
    ArrayList            parametros                        = new ArrayList();
    ArrayList            dadosPadroes                      = new ArrayList();
    ArrayList<ArrayList> dadosComandas                     = new ArrayList<ArrayList>();
    
    //Bean's
    BeanComandas                    bcom        = new BeanComandas();
    
    //Especiais
    FormataCampo                    fc          = new FormataCampo();
    PegaProximoRegistro             PegProReg   = new PegaProximoRegistro();

    //Telas
    ComandasConsulta                ComCon;
    
    public ComandasCadastro(ArrayList DadosPadroes){
        dadosPadroes                            = DadosPadroes;
        
        somostra                                = (String)  dadosPadroes.get(0);
        bcom.codigoComanda                      = (int)     dadosPadroes.get(1);
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bt_novo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_codigoBarrasComanda = new javax.swing.JTextField();
        check_statusComanda = new javax.swing.JCheckBox();
        txt_codigoComanda = new javax.swing.JFormattedTextField();
        bt_incluir = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        bt_pesquisa = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Comandas");
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
        jLabel1.setText("Cadastro de Comandas");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Código da Comanda: ");

        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Código de Barras: ");

        check_statusComanda.setText("Inativa");

        try {
            txt_codigoComanda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoComanda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoComanda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoComandaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoComandaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_codigoBarrasComanda)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_novo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(check_statusComanda)
                        .addGap(0, 141, Short.MAX_VALUE)))
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
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_statusComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoComanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_codigoBarrasComanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, check_statusComanda, jLabel2, jLabel3, txt_codigoBarrasComanda, txt_codigoComanda});

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
                        .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(bt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_alterar, bt_incluir, bt_pesquisa, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoComandaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoComandaFocusGained
        if(txt_codigoComanda.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        operacao = "";
        ReiniciaCampos();
        HabilitaBotoes();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoComandaFocusGained

    private void txt_codigoComandaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoComandaFocusLost
        if(txt_codigoComanda.isEditable() == false)
            return;
        if(txt_codigoComanda.getText().replace(" ", "").equals(""))
            return;
        PegaComandas();
    }//GEN-LAST:event_txt_codigoComandaFocusLost

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        ReiniciaCampos();
        HabilitaCampos(true);
        
        bcom.codigoComanda = PegProReg.PegaProximoRegistro("tb_comandas", "codigoComanda", "");
        txt_codigoComanda.setText(fc.FormataCampo(String.valueOf(bcom.codigoComanda), 3, 0));
        
        operacao = "I";
        HabilitaBotoes();
        txt_codigoBarrasComanda.grabFocus();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "insert into tb_comandas (idEmpresa, codigoGrupo, codigoEmpresa, codigoComanda, codigoBarrasComanda, statusComanda) "
            + "values(" + bcom.idEmpresa + ", " + bcom.codigoGrupo + ", " + bcom.codigoEmpresa + ", " + bcom.codigoComanda + ", '" + bcom.codigoBarrasComanda + "', " + bcom.statusComanda + ");";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoComanda.grabFocus();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "update tb_comandas set codigoBarrasComanda = '"  + bcom.codigoBarrasComanda  + "', "
                                    + "statusComanda = "        + bcom.statusComanda        + " "
                                    + "where idComanda = "  + bcom.idComanda        + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoComanda.grabFocus();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        if(ComCon != null)if(ComCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuComanda = 1;
        parametros.clear();
        parametros.add("S");
        parametros.add("");
        ComCon = new ComandasConsulta(parametros);
        ComCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuComanda == 0)
            return;
        abriuComanda = 0;
        retorno = ComCon.getRetornoComanda();
        if(retorno.equals(""))
            return;
        txt_codigoComanda.setText(retorno);
        PegaComandas();
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
            txt_codigoComanda   .setEditable(false);
            bt_novo             .setEnabled (false);
            bt_incluir          .setVisible (false);
            bt_alterar          .setVisible (false);
            bt_pesquisa         .setVisible (false);
        }
        if(bcom.codigoComanda != 0){
            txt_codigoComanda   .setText(String.valueOf(bcom.codigoComanda));
            PegaComandas();
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(ComCon   != null)ComCon.dispose();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisa;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JCheckBox check_statusComanda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_codigoBarrasComanda;
    private javax.swing.JFormattedTextField txt_codigoComanda;
    // End of variables declaration//GEN-END:variables
    
    private void ReiniciaCampos(){
        bcom = new BeanComandas();
        txt_codigoComanda           .setText("");
        txt_codigoBarrasComanda     .setText("");
        check_statusComanda         .setSelected(false);
    }
    
    private void HabilitaCampos(boolean Habilita){
        check_statusComanda         .setEnabled     (Habilita);
        check_statusComanda         .setFocusable   (Habilita);
        txt_codigoBarrasComanda     .setEditable    (Habilita);
        txt_codigoBarrasComanda     .setFocusable   (Habilita);
    }
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_incluir              .setEnabled(true);
            bt_alterar              .setEnabled(false);
            return;
        }
        if(operacao.equals("A")){
            bt_incluir              .setEnabled(false);
            bt_alterar              .setEnabled(true);
            return;
        }
        bt_incluir                  .setEnabled(false);
        bt_alterar                  .setEnabled(false);
    }
    
    private void PegaComandas(){
        txt_codigoComanda.setText(fc.FormataCampo(txt_codigoComanda.getText(), 3, 0));
        bcom.codigoComanda  = Integer.parseInt(txt_codigoComanda.getText());
        if(bcom.codigoComanda == 0)
            return;
        sql = "select * from tb_comandas where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoComanda = " + bcom.codigoComanda + ";";
        dadosComandas.clear();
        dadosComandas = parametrosNS.dao.Consulta(sql);
        if(dadosComandas.isEmpty()){
            Mensagem = "Comanda n°" + bcom.codigoComanda + " não encontrada!";
            new MostraMensagem(Mensagem);
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        HabilitaCampos(true);
        PegaDadosComandas();
    }
    
    private void PegaDadosComandas(){
        for(int i = 0; i < dadosComandas.size(); i++){
            bcom = new BeanComandas();
            bcom.idComanda              = Integer.parseInt(  String.valueOf(dadosComandas.get(i).get(0)));
            bcom.idEmpresa              = Integer.parseInt(  String.valueOf(dadosComandas.get(i).get(1)));
            bcom.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosComandas.get(i).get(2)));
            bcom.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosComandas.get(i).get(3)));
            bcom.codigoComanda          = Integer.parseInt(  String.valueOf(dadosComandas.get(i).get(4)));
            bcom.codigoBarrasComanda    =                    String.valueOf(dadosComandas.get(i).get(5));
            bcom.statusComanda          = Integer.parseInt(  String.valueOf(dadosComandas.get(i).get(6)));
        }
        txt_codigoBarrasComanda.setText(bcom.codigoBarrasComanda);
        switch(bcom.statusComanda){
            case  2: check_statusComanda.setSelected(true);break;
            default: check_statusComanda.setSelected(false);
        }
    }
    
    private void PegaValores(){
        fatal = "N";
        bcom.idEmpresa                  = parametrosNS.be.IdEmpresa;
        bcom.codigoGrupo                = parametrosNS.bge.CodigoGrupo;
        bcom.codigoEmpresa              = parametrosNS.be.CodigoEmpresa;
        bcom.codigoComanda              = Integer.parseInt(txt_codigoComanda.getText());
        bcom.codigoBarrasComanda        = txt_codigoBarrasComanda.getText();
        if(bcom.codigoBarrasComanda.equals("")){
            Mensagem = "Código de Barras Inválido!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        if(check_statusComanda.isSelected() == false)
            bcom.statusComanda          = 0;
        else
            bcom.statusComanda          = 2;
    }
    
}
