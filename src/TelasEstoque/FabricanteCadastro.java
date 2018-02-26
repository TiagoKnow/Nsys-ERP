package TelasEstoque;

import BeansNS.BeanEmpresas;
import Beans.*;
import FuncoesInternas.*;
import Parametros.parametrosNS;
import java.util.ArrayList;
/*
 @author Tiago e Paulo
 */
public class FabricanteCadastro extends javax.swing.JFrame {
    //String's
    String Mensagem                     = "";
    String sql                          = "";
    String sqlstate                     = "";
    String operacao                     = "";
    String retorno                      = "";
    String fatal                        = "";
    String valorFormatado               = "";
    String somostra                     = "";
    
    //int's
    int    abriuFabricante              = 0;
    
    //ArrayList
    ArrayList            parametros                = new ArrayList();
//    ArrayList            dadosPadroes              = new ArrayList();
    ArrayList<ArrayList> dadosFabricante           = new ArrayList<ArrayList>();
    
    //Bean's
    BeanEmpresas            be          = new BeanEmpresas();
    BeanFabricante          bfab        = new BeanFabricante();
    
    //Especiais
    FormataCampo            fc          = new FormataCampo();
    PegaProximoRegistro     PegProReg   = new PegaProximoRegistro();
    
    //Telas
    FabricanteConsulta      FabCon;
    
    public FabricanteCadastro(String Somostra, int CodigoFabricante){
        somostra                = Somostra;
        bfab.codigoFabricante   = CodigoFabricante;
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigoFabricantre = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_nomeFabricante = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_siteFabricante = new javax.swing.JTextField();
        bt_novo = new javax.swing.JButton();
        bt_incluir = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_pesquisa = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair1 = new javax.swing.JMenuItem();

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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Fabricante");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Código:");

        try {
            txt_codigoFabricantre.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoFabricantre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoFabricantreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoFabricantreFocusLost(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nome:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Site:");

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nomeFabricante)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoFabricantre, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_novo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txt_siteFabricante))
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
                    .addComponent(txt_codigoFabricantre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_nomeFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_siteFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, jLabel2, jLabel3, jLabel4, txt_codigoFabricantre, txt_siteFabricante});

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
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bt_incluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_alterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_pesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_sair)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_alterar, bt_incluir, bt_pesquisa, bt_sair});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisa)
                    .addComponent(bt_sair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_alterar, bt_incluir, bt_pesquisa});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoFabricantreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFabricantreFocusGained
        if(somostra.equals("S"))
            return;
        txt_codigoFabricantre.setText("");
        operacao = "";
        ReiniciaCampos();
        HabilitaBotoes();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoFabricantreFocusGained

    private void txt_codigoFabricantreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFabricantreFocusLost
        if(somostra.equals("S"))
            return;
        if(txt_codigoFabricantre.getText().replace(" ", "").equals(""))
            return;
        txt_codigoFabricantre.setText(fc.FormataCampo(txt_codigoFabricantre.getText(), 5, 0));
        PegaFabricante();
    }//GEN-LAST:event_txt_codigoFabricantreFocusLost

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        ReiniciaCampos();
        HabilitaCampos(true);
        
        bfab.codigoFabricante = PegProReg.PegaProximoRegistro("tb_fabricante", "codigoFabricante", "");
        txt_codigoFabricantre.setText(fc.FormataCampo(String.valueOf(bfab.codigoFabricante), 5, 0));
        
        operacao = "I";
        HabilitaBotoes();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "insert into tb_fabricante (idEmpresa, codigoGrupo, codigoEmpresa, codigoFabricante, nomeFabricante, siteFabricante) "
            + "values (" + bfab.idEmpresa + ", " + bfab.codigoGrupo + ", " + bfab.codigoEmpresa + ", " + bfab.codigoFabricante + ", '" + bfab.nomeFabricante + "', '" + bfab.siteFabricante + "');";

        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoFabricantre.grabFocus();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "update tb_fabricante set nomeFabricante = '"         + bfab.nomeFabricante       + "', "     +
                                      "siteFabricante = '"          + bfab.siteFabricante       + "' "      +
                                      "where idFabricante = "   + bfab.idFabricante         + ";";
        
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoFabricantre.grabFocus();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        if(FabCon != null)if(FabCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuFabricante = 1;
        FabCon = new FabricanteConsulta("S");
        FabCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
        if(abriuFabricante == 0)
            return;
        retorno = FabCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoFabricantre.setText(fc.FormataCampo(retorno, 5, 0));
        PegaFabricante();
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
            txt_codigoFabricantre   .setEditable(false);
            bt_novo                 .setEnabled (false);
            bt_incluir              .setVisible (false);
            bt_alterar              .setVisible (false);
            bt_pesquisa             .setVisible (false);
        }
        if(bfab.codigoFabricante != 0){
            txt_codigoFabricantre   .setText(String.valueOf(bfab.codigoFabricante));
            PegaFabricante();
        }
        if(somostra.equals("SN"))
            bt_pesquisa             .setVisible (false);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(FabCon   != null)FabCon.dispose();
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txt_codigoFabricantre;
    private javax.swing.JTextField txt_nomeFabricante;
    private javax.swing.JTextField txt_siteFabricante;
    // End of variables declaration//GEN-END:variables
    
    private void ReiniciaCampos(){
        bfab = new BeanFabricante();
        txt_nomeFabricante.setText("");
        txt_siteFabricante.setText("");
    }
    
    private void HabilitaCampos(boolean Habilita){
        txt_nomeFabricante      .setEditable    (Habilita);
        txt_nomeFabricante      .setFocusable   (Habilita);
        txt_siteFabricante      .setEditable    (Habilita);
        txt_siteFabricante      .setFocusable   (Habilita);
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
    
    private void PegaFabricante(){
        txt_codigoFabricantre.setText(fc.FormataCampo(txt_codigoFabricantre.getText(), 5, 0));
        bfab.codigoFabricante = Integer.parseInt(fc.FormataCampo(txt_codigoFabricantre.getText(), 5, 0));
        if(bfab.codigoFabricante == 0)
            return;
        sql = "select * from tb_fabricante where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoFabricante = '" + bfab.codigoFabricante + "';";
        dadosFabricante.clear();
        dadosFabricante = parametrosNS.dao.Consulta(sql);
        if(dadosFabricante.isEmpty()){
            Mensagem = "Fabricante " + bfab.codigoFabricante + " não encontrado, para incluir pressione NOVO!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        HabilitaCampos(true);
        PreencherFabricante();
    }
    
    private void PreencherFabricante(){
        for(int i = 0; i < dadosFabricante.size(); i++){
            bfab = new BeanFabricante();
            bfab.idFabricante       = Integer.parseInt(  String.valueOf(dadosFabricante.get(i).get(0)));
            bfab.idEmpresa          = Integer.parseInt(  String.valueOf(dadosFabricante.get(i).get(1)));
            bfab.codigoGrupo        = Integer.parseInt(  String.valueOf(dadosFabricante.get(i).get(2)));
            bfab.codigoEmpresa      = Integer.parseInt(  String.valueOf(dadosFabricante.get(i).get(3)));
            bfab.codigoFabricante   = Integer.parseInt(  String.valueOf(dadosFabricante.get(i).get(4)));
            bfab.nomeFabricante     =                    String.valueOf(dadosFabricante.get(i).get(5));
            bfab.siteFabricante     =                    String.valueOf(dadosFabricante.get(i).get(6));
        }
        txt_nomeFabricante.setText(bfab.nomeFabricante);
        txt_siteFabricante.setText(bfab.siteFabricante);
    }
    
    private void PegaValores(){
        fatal = "N";
        bfab.idEmpresa          = parametrosNS.be.IdEmpresa;
        bfab.codigoGrupo        = parametrosNS.bge.CodigoGrupo;
        bfab.codigoEmpresa      = parametrosNS.be.CodigoEmpresa;
        bfab.codigoFabricante   = Integer.parseInt(txt_codigoFabricantre.getText());
        bfab.nomeFabricante     = txt_nomeFabricante.getText();
        if(bfab.nomeFabricante.equals("")){
            Mensagem = "Nome do fabricante inválido!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bfab.siteFabricante     = txt_siteFabricante.getText();
    }
    
}
