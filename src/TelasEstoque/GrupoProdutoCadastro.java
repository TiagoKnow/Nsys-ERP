package TelasEstoque;

import Dao.DaoMySQL;
import java.sql.*;
import java.util.*;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import FuncoesInternas.*;
import Beans.*;
import Parametros.parametrosNS;

/*
 @author Tiago e Paulo
 */
public class GrupoProdutoCadastro extends javax.swing.JFrame {
    //ArrayList's
    ArrayList            parametros                = new ArrayList();
//    ArrayList            dadosPadroes              = new ArrayList();
    ArrayList<ArrayList> dadosGrupoProdutos        = new ArrayList<ArrayList>();
    
    //String's
    String sql                          = "";
    String fatal                        = "";
    String sqlstate                     = "";
    String Mensagem                     = "";
    String somostra                     = "";
    String retorno                      = "";
    String operacao                     = "";
    
    //int's
    int    UltimoRegistro               = 0;
    int    AbriuGrupoProduto            = 0;
    
    //bean's
    BeanGrupoProduto        bgp         = new BeanGrupoProduto();
    
    //Telas
    GrupoProdutoConsulta    GruProCon;
    
    //Especiais
    FormataCampo            fc          = new FormataCampo();
    PegaProximoRegistro     PegProReg   = new PegaProximoRegistro();
    
    public GrupoProdutoCadastro(String Somostra, int CodigoGrupoProduto){
        somostra                        = Somostra;
        bgp.codigoGrupoProduto          = CodigoGrupoProduto;
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_excluir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        bt_novo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_descricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_codigoGrupoProduto = new javax.swing.JFormattedTextField();
        bt_incluir = new javax.swing.JButton();
        bt_proximo = new javax.swing.JButton();
        bt_anterior = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_pesquisa = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair = new javax.swing.JMenuItem();

        bt_excluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Delete.png"))); // NOI18N
        bt_excluir.setText("Excluir");
        bt_excluir.setEnabled(false);
        bt_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluirActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(":: Cadastro grupos");
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

        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Código: ");

        jLabel2.setText("Descrição: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tipos de Produtos");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_codigoGrupoProduto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoGrupoProduto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoGrupoProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoGrupoProdutoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoGrupoProdutoFocusLost(evt);
            }
        });
        txt_codigoGrupoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoGrupoProdutoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoGrupoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_novo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txt_descricao))
                .addContainerGap())
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoGrupoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, jLabel1, jLabel2, txt_codigoGrupoProduto, txt_descricao});

        bt_incluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_incluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_incluir.setText("Incluir");
        bt_incluir.setEnabled(false);
        bt_incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_incluirActionPerformed(evt);
            }
        });

        bt_proximo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_proximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Next.png"))); // NOI18N
        bt_proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_proximoActionPerformed(evt);
            }
        });

        bt_anterior.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Previous.png"))); // NOI18N
        bt_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_anteriorActionPerformed(evt);
            }
        });

        bt_alterar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                        .addComponent(bt_pesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_proximo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_alterar)
                        .addComponent(bt_pesquisa))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bt_anterior)
                        .addComponent(bt_proximo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_alterar, bt_anterior, bt_incluir, bt_pesquisa, bt_proximo});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        ReiniciaCampos();
        HabilitaCampos(true);
        
        bgp.codigoGrupoProduto   = PegProReg.PegaProximoRegistro("tb_grupoproduto", "codigoGrupoProduto", "");
        txt_codigoGrupoProduto.setText(fc.FormataCampo(String.valueOf(bgp.codigoGrupoProduto), 3, 0));
        
        operacao = "I";
        HabilitaBotoes();
        txt_descricao.grabFocus();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        sql = "insert into tb_grupoproduto (idEmpresa, codigoGrupo, codigoEmpresa, codigoGrupoProduto, descricaoGrupo) "
            + "values (" + bgp.idEmpresa + ", " + bgp.codigoGrupo + ", " + bgp.codigoEmpresa + ", " + bgp.codigoGrupoProduto + ", '" + bgp.descricaoGrupo + "');";
        
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoGrupoProduto.grabFocus();
        VerificaUltimoRegistro();
    }//GEN-LAST:event_bt_incluirActionPerformed
    
    private void bt_proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_proximoActionPerformed
        bgp.codigoGrupoProduto   = Integer.parseInt(fc.FormataCampo(txt_codigoGrupoProduto.getText().replace(" ", ""), 3, 0));
        if(bgp.codigoGrupoProduto   <= UltimoRegistro)
            bgp.codigoGrupoProduto   = bgp.codigoGrupoProduto + 1;
        
        if(bgp.codigoGrupoProduto    > UltimoRegistro){
            bgp.codigoGrupoProduto   = UltimoRegistro;
            Mensagem = "Esse é o ultimo registro!!!";
            new MostraMensagem(Mensagem);
            return;
        }
        txt_codigoGrupoProduto.setText(String.valueOf(bgp.codigoGrupoProduto  ));
        PegaCodigo();
    }//GEN-LAST:event_bt_proximoActionPerformed

    private void bt_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_anteriorActionPerformed
        bgp.codigoGrupoProduto   = Integer.parseInt(fc.FormataCampo(txt_codigoGrupoProduto.getText().replace(" ", ""), 3, 0));
        if(bgp.codigoGrupoProduto   == 1){
            Mensagem = "Não existe registro anterior!!";
            new MostraMensagem(Mensagem);
            return;
        }
        if(bgp.codigoGrupoProduto   == 0)
            bgp.codigoGrupoProduto   = 2;
        
        if(bgp.codigoGrupoProduto   <= UltimoRegistro)
            bgp.codigoGrupoProduto   = bgp.codigoGrupoProduto   - 1;
        
        if(bgp.codigoGrupoProduto    > UltimoRegistro)
            bgp.codigoGrupoProduto   = UltimoRegistro;
        txt_codigoGrupoProduto.setText(String.valueOf(bgp.codigoGrupoProduto));
        PegaCodigo();
    }//GEN-LAST:event_bt_anteriorActionPerformed

    private void bt_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluirActionPerformed
        bgp.codigoGrupoProduto   = Integer.parseInt(txt_codigoGrupoProduto.getText());
        if(JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir o registro n°" + bgp.codigoGrupoProduto   + "?", "", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION)
            return;
        sql = "delete from tb_grupoproduto where idGrupoProduto = " + bgp.idGrupoProduto + ";";
        sqlstate = parametrosNS.dao.ExcluirRegistro(sql);
        
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoGrupoProduto.grabFocus();
        VerificaUltimoRegistro();
    }//GEN-LAST:event_bt_excluirActionPerformed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        sql = "update tb_grupoproduto set descricaoGrupo = '" + bgp.descricaoGrupo + "' where idGrupoProduto = " + bgp.idGrupoProduto + ";";
        
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");

        if(!sqlstate.equals("00000"))
            return;
        txt_codigoGrupoProduto.grabFocus();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        if(GruProCon != null)if(GruProCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        AbriuGrupoProduto = 1;
        GruProCon = new GrupoProdutoConsulta("S");
        GruProCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
        if(AbriuGrupoProduto == 0)
            return;
        retorno = GruProCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoGrupoProduto.setText(retorno);
        PegaCodigo();
    }//GEN-LAST:event_formWindowGainedFocus

    private void txt_codigoGrupoProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoGrupoProdutoFocusGained
        if(txt_codigoGrupoProduto.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        ReiniciaTela();
        HabilitaCampos(false);
        txt_codigoGrupoProduto.grabFocus();
    }//GEN-LAST:event_txt_codigoGrupoProdutoFocusGained

    private void txt_codigoGrupoProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoGrupoProdutoFocusLost
        if(txt_codigoGrupoProduto.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        if(txt_codigoGrupoProduto.getText().equals(""))
            return;
        PegaCodigo();
    }//GEN-LAST:event_txt_codigoGrupoProdutoFocusLost

    private void txt_codigoGrupoProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoGrupoProdutoKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        txt_descricao.grabFocus();
    }//GEN-LAST:event_txt_codigoGrupoProdutoKeyPressed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HabilitaCampos(false);
        VerificaUltimoRegistro();
        
        if(somostra.equals("S")){
            txt_codigoGrupoProduto .setEditable(false);
            bt_novo         .setEnabled(false);
            bt_incluir      .setVisible(false);
            bt_alterar      .setVisible(false);
            bt_excluir      .setVisible(false);
            bt_pesquisa     .setVisible(false);
            bt_anterior     .setVisible(false);
            bt_proximo      .setVisible(false);
        }
        if(bgp.codigoGrupoProduto   != 0){
            txt_codigoGrupoProduto .setEditable(false);
            txt_codigoGrupoProduto .setText(String.valueOf(bgp.codigoGrupoProduto  ));
            PegaCodigo();
        }
        if(somostra.equals("SN"))
            bt_pesquisa     .setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(GruProCon    != null)GruProCon.dispose();
    }//GEN-LAST:event_formWindowClosed
    
    private void PegaCodigo(){
        txt_codigoGrupoProduto.setText(fc.FormataCampo(txt_codigoGrupoProduto.getText(), 3, 0));
        bgp.codigoGrupoProduto   = Integer.parseInt(txt_codigoGrupoProduto.getText());
        if(bgp.codigoGrupoProduto   == 0)
            return;
        sql = "select * from tb_grupoproduto where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoGrupoProduto   = " + bgp.codigoGrupoProduto   + ";";
        dadosGrupoProdutos.clear();
        dadosGrupoProdutos = parametrosNS.dao.Consulta(sql);
        if(dadosGrupoProdutos.isEmpty()){
            Mensagem = "Tipo de produto não cadastrado!!!";
            new MostraMensagem(Mensagem);
            txt_codigoGrupoProduto.grabFocus();
            return;
        }
        HabilitaCampos(true);
        PreencherCampos();
    }
    
    private void PreencherCampos(){
        for(int i = 0; i < dadosGrupoProdutos.size(); i++){
            bgp.idGrupoProduto          = Integer.parseInt(  String.valueOf(dadosGrupoProdutos.get(i).get(0)));
            bgp.idEmpresa               = Integer.parseInt(  String.valueOf(dadosGrupoProdutos.get(i).get(1)));
            bgp.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosGrupoProdutos.get(i).get(2)));
            bgp.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosGrupoProdutos.get(i).get(3)));
            bgp.codigoGrupoProduto      = Integer.parseInt(  String.valueOf(dadosGrupoProdutos.get(i).get(4)));
            bgp.descricaoGrupo          =                    String.valueOf(dadosGrupoProdutos.get(i).get(5));
        }
        txt_descricao.setText(bgp.descricaoGrupo);
        bt_incluir.setEnabled(false);
        bt_alterar.setEnabled(true);
        bt_excluir.setEnabled(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_anterior;
    private javax.swing.JButton bt_excluir;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisa;
    private javax.swing.JButton bt_proximo;
    private javax.swing.JMenuItem bt_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txt_codigoGrupoProduto;
    private javax.swing.JTextField txt_descricao;
    // End of variables declaration//GEN-END:variables
    
    private void ReiniciaTela(){
        bt_incluir.setEnabled(false);
        bt_excluir.setEnabled(false);
        ReiniciaCampos();
    }
    
    private void ReiniciaCampos(){
        txt_codigoGrupoProduto.setText("");
        txt_descricao.setText("");
    }
    
    private void HabilitaCampos(boolean Habilita){
        txt_descricao       .setEditable    (Habilita);
        txt_descricao       .setFocusable   (Habilita);
    }
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_incluir.setEnabled(true);
            bt_excluir.setEnabled(false);
            return;
        }
        if(operacao.equals("A")){
            bt_incluir.setEnabled(false);
            bt_excluir.setEnabled(true);
            return;
        }
        bt_incluir.setEnabled(false);
        bt_excluir.setEnabled(false);
    }
    
    private void PegaValores(){
        fatal = "N";
        bgp.idEmpresa           = parametrosNS.be.IdEmpresa;
        bgp.codigoGrupo         = parametrosNS.bge.CodigoGrupo;
        bgp.codigoEmpresa       = parametrosNS.be.CodigoEmpresa;
        bgp.codigoGrupoProduto    = Integer.parseInt(txt_codigoGrupoProduto.getText());
        bgp.descricaoGrupo = txt_descricao.getText();
        if(bgp.descricaoGrupo.equals("")){
            Mensagem = "Descrição Inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
    }
    
    private void VerificaUltimoRegistro(){
        UltimoRegistro = PegProReg.PegaProximoRegistro("tb_grupoproduto", "codigoGrupoProduto", "") - 1;
    }
    
}
