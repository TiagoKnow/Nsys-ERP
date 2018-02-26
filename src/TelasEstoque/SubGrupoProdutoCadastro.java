package TelasEstoque;

import Beans.BeanGrupoProduto;
import Beans.BeanSubGrupoProduto;
import Beans.BeanUsuarios;
import Dao.DaoMySQL;
import FuncoesInternas.*;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/*
 @author Tiago e Paulo
 */
public class SubGrupoProdutoCadastro extends javax.swing.JFrame {
    //String's
    String sql                          = "";
    String Mensagem                     = "";
    String valorFormatado               = "";
    String sqlstate                     = "";
    String fatal                        = "";
    String operacao                     = "";
    String somostra                     = "";
    String retorno                      = "";
    
    //int's
    int    AbriuSubGrupoProduto         = 0;
    int    AbriuGrupoProduto            = 0;
    
    //Vetores
    ArrayList            parametros                = new ArrayList();
//    ArrayList            dadosPadroes              = new ArrayList();
    ArrayList<ArrayList> dadosSubGrupoProdutos     = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosGrupoProdutos        = new ArrayList<ArrayList>();
    
    //Bean's
    BeanGrupoProduto         bgp        = new BeanGrupoProduto();
    BeanSubGrupoProduto      bsgp       = new BeanSubGrupoProduto();
    
    //Especiais
    FormataCampo            fc          = new FormataCampo();
    PegaProximoRegistro     PegProReg   = new PegaProximoRegistro();
    
    //Telas
    GrupoProdutoConsulta    GruProCon;
    SubGrupoProdutoConsulta ConSubGruPro;
    
    public SubGrupoProdutoCadastro(String Somostra, int IdGrupoProduto, int CodigoSubGrupoProduto){
        somostra                        = Somostra;
        bgp.idGrupoProduto              = IdGrupoProduto;
        bsgp.codigoSubGrupoProduto      = CodigoSubGrupoProduto;
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_anterior = new javax.swing.JButton();
        bt_proximo = new javax.swing.JButton();
        bt_excluir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bt_novo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        label_nomeGrupoProduto = new javax.swing.JLabel();
        bt_pesquisaGrupoProduto = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_descricaoSubGrupoProduto = new javax.swing.JTextField();
        txt_codigoGrupoProduto = new javax.swing.JFormattedTextField();
        txt_codigoSubGrupoProduto = new javax.swing.JFormattedTextField();
        bt_incluir = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_pesquisaSubGrupoProduto = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair1 = new javax.swing.JMenuItem();

        bt_anterior.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Previous.png"))); // NOI18N
        bt_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_anteriorActionPerformed(evt);
            }
        });

        bt_proximo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_proximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Next.png"))); // NOI18N
        bt_proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_proximoActionPerformed(evt);
            }
        });

        bt_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Delete.png"))); // NOI18N
        bt_excluir.setText("Excluir");
        bt_excluir.setEnabled(false);
        bt_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluirActionPerformed(evt);
            }
        });

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sub grupos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Codigo:");

        bt_novo.setText("Novo");
        bt_novo.setEnabled(false);
        bt_novo.setFocusable(false);
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Grupo:");

        bt_pesquisaGrupoProduto.setText("...");
        bt_pesquisaGrupoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaGrupoProdutoActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Descricao:");

        try {
            txt_codigoGrupoProduto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        try {
            txt_codigoGrupoProduto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoGrupoProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoGrupoProdutoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoGrupoProdutoFocusLost(evt);
            }
        });
        txt_codigoGrupoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoGrupoProdutoActionPerformed(evt);
            }
        });
        txt_codigoGrupoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoGrupoProdutoKeyPressed(evt);
            }
        });

        try {
            txt_codigoSubGrupoProduto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoSubGrupoProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoSubGrupoProdutoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoSubGrupoProdutoFocusLost(evt);
            }
        });
        txt_codigoSubGrupoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoSubGrupoProdutoActionPerformed(evt);
            }
        });
        txt_codigoSubGrupoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoSubGrupoProdutoKeyPressed(evt);
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
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoGrupoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisaGrupoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_nomeGrupoProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoSubGrupoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_novo)
                        .addGap(113, 348, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_descricaoSubGrupoProduto)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(label_nomeGrupoProduto)
                    .addComponent(bt_pesquisaGrupoProduto)
                    .addComponent(txt_codigoGrupoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(bt_novo)
                    .addComponent(txt_codigoSubGrupoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_descricaoSubGrupoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, jLabel2, jLabel3, jLabel5, label_nomeGrupoProduto, txt_codigoGrupoProduto, txt_codigoSubGrupoProduto, txt_descricaoSubGrupoProduto});

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

        bt_pesquisaSubGrupoProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/View.png"))); // NOI18N
        bt_pesquisaSubGrupoProduto.setText("Pesquisa");
        bt_pesquisaSubGrupoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaSubGrupoProdutoActionPerformed(evt);
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
                        .addComponent(bt_pesquisaSubGrupoProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaSubGrupoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_alterar, bt_incluir, bt_pesquisaSubGrupoProduto, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        ReiniciaCampos();
        
        bsgp.idEmpresa          = bgp.idEmpresa;
        bsgp.codigoGrupo        = bgp.codigoGrupo;
        bsgp.codigoEmpresa      = bgp.codigoEmpresa;
        bsgp.codigoGrupoProduto = bgp.codigoGrupoProduto;
        bsgp.codigoSubGrupoProduto      = PegProReg.PegaProximoRegistro("tb_subgrupoproduto grus inner join tb_grupoproduto gru on ((grus.idEmpresa = gru.idEmpresa) and (grus.codigoGrupoProduto = gru.codigoGrupoProduto))", "codigoSubGrupoProduto", " and grus.codigoGrupoProduto = " + bsgp.codigoGrupoProduto);
        txt_codigoSubGrupoProduto.setText(fc.FormataCampo(String.valueOf(bsgp.codigoSubGrupoProduto), 3, 0));
        
        operacao = "I";
        HabilitaBotoes();
        HabilitaCampos(true);
    }//GEN-LAST:event_bt_novoActionPerformed

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "insert into tb_subgrupoproduto (idEmpresa, codigoGrupo, codigoEmpresa, codigoGrupoProduto, codigoSubGrupoProduto, descricaoSubGrupo) "
            + "values (" + bsgp.idEmpresa + ", " + bsgp.codigoGrupo + ", " + bsgp.codigoEmpresa + ", " + bsgp.codigoGrupoProduto + ", " + bsgp.codigoSubGrupoProduto + ", '" + bsgp.descricaoSubGrupo + "');";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoGrupoProduto.grabFocus();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void txt_codigoGrupoProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoGrupoProdutoFocusLost
        if(txt_codigoGrupoProduto.isEditable()== false)
            return;
        if(txt_codigoGrupoProduto.getText().replace(" ", "").equals(""))
            return;
        PegaGrupoProduto();
    }//GEN-LAST:event_txt_codigoGrupoProdutoFocusLost

    private void txt_codigoGrupoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoGrupoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoGrupoProdutoActionPerformed

    private void txt_codigoGrupoProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoGrupoProdutoFocusGained
        if(txt_codigoGrupoProduto.getText().replace(" ", "").equals(""))
            return;
        if(txt_codigoGrupoProduto.isEditable()== false)
            return;
//        if(bsgp.idSubGrupoProduto != 0)
//            return;
        operacao = "";
        ReiniciaTela();
        HabilitaBotoes();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoGrupoProdutoFocusGained

    private void txt_codigoSubGrupoProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoSubGrupoProdutoFocusGained
        if(txt_codigoSubGrupoProduto.getText().replace(" ", "").equals(""))
            return;
        if(txt_codigoSubGrupoProduto.isEditable() == false)
            return;
        txt_codigoSubGrupoProduto.setSelectionStart(0);
        txt_codigoSubGrupoProduto.setSelectionEnd  (txt_codigoSubGrupoProduto.getText().length());
        bsgp = new BeanSubGrupoProduto();
        operacao = "";
        ReiniciaCampos();
        HabilitaBotoes();
    }//GEN-LAST:event_txt_codigoSubGrupoProdutoFocusGained

    private void txt_codigoSubGrupoProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoSubGrupoProdutoFocusLost
        if(txt_codigoSubGrupoProduto.isEditable() == false)
            return;
        if(txt_codigoSubGrupoProduto.getText().replace(" ", "").equals(""))
            return;
        PegaSubGrupoProduto();
    }//GEN-LAST:event_txt_codigoSubGrupoProdutoFocusLost

    private void txt_codigoSubGrupoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoSubGrupoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoSubGrupoProdutoActionPerformed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S"))
            return;
        
        sql = "update tb_subgrupoproduto set codigoGrupoProduto = "         + bsgp.codigoGrupoProduto           + ", " +
                                            "descricaoSubGrupo = '"         + bsgp.descricaoSubGrupo        + "' " +
                                            "where idSubGrupoProduto = "    + bsgp.idSubGrupoProduto        + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoGrupoProduto.grabFocus();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void bt_pesquisaGrupoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaGrupoProdutoActionPerformed
        if(GruProCon != null)if(GruProCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        AbriuGrupoProduto = 1;
        GruProCon = new GrupoProdutoConsulta("S");
        GruProCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaGrupoProdutoActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
        if(AbriuSubGrupoProduto == 0){
            AbriuGrupoProduto();
            return;
        }
        retorno = ConSubGruPro.getRetorno();
        if(retorno.equals(""))
            return;
        AbriuSubGrupoProduto = 0;
        txt_codigoSubGrupoProduto.setText(retorno);
        PegaSubGrupoProduto();
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbriuGrupoProduto(){
        if(AbriuGrupoProduto == 0)
            return;
        retorno = GruProCon.getRetorno();
        if(retorno.equals(""))
            return;
        AbriuGrupoProduto = 0;
        txt_codigoGrupoProduto.setText(retorno);
        PegaGrupoProduto();
    }
    
    private void bt_pesquisaSubGrupoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaSubGrupoProdutoActionPerformed
        if(ConSubGruPro != null)if(ConSubGruPro.isVisible()){
            Mensagem = "Tela já Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        AbriuSubGrupoProduto = 1;
        ConSubGruPro = new SubGrupoProdutoConsulta("S");
        ConSubGruPro.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaSubGrupoProdutoActionPerformed

    private void bt_proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_proximoActionPerformed
//        bsgp.codigoSubGrupoProduto = Integer.parseInt(fc.FormataCampo(txt_cod, WIDTH, WIDTH));
//        if(txt_codigoSubGrupoDoProduto.getText().equals("")){
//            txt_codigoSubGrupoDoProduto.setText("0");
//        }
//        if(bsgp.codigoSubGrupoProduto  < UltimoRegistro){
//            bsgp.codigoSubGrupoProduto = bsgp.codigoSubGrupoProduto + 1;
//        }
//        if(bsgp.codigoSubGrupoProduto  > UltimoRegistro){
//            bsgp.codigoSubGrupoProduto = UltimoRegistro;
//            Mensagem = "Esse é o ultimo registro!!!";
//            new MostraMensagem(Mensagem);
//            return;
//        }
//        txt_codigoSubGrupoDoProduto.setText(String.valueOf(bsgp.codigoSubGrupoProduto));
//        PegaSubGrupoProduto();
    }//GEN-LAST:event_bt_proximoActionPerformed

    private void bt_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_anteriorActionPerformed
//        if(txt_codigoSubGrupoDoProduto.getText().equals("1")){
//            Mensagem = "Não existe registro anterior!!";
//            new MostraMensagem(Mensagem);
//            return;
//        }
//        if(txt_codigoSubGrupoDoProduto.getText().equals("")){
//            txt_codigoSubGrupoDoProduto.setText("2");
//        }
//        bsgp.codigoSubGrupoProduto = Integer.parseInt(txt_codigoSubGrupoDoProduto.getText());
//        if(bsgp.codigoSubGrupoProduto <  UltimoRegistro){
//            bsgp.codigoSubGrupoProduto = bsgp.codigoSubGrupoProduto - 1;
//        }
//        txt_codigoSubGrupoDoProduto.setText(String.valueOf(bsgp.codigoSubGrupoProduto));
//        if(bsgp.codigoSubGrupoProduto >= UltimoRegistro){
//            bsgp.codigoSubGrupoProduto = UltimoRegistro;
//        }
//        PegaSubGrupoProduto();
    }//GEN-LAST:event_bt_anteriorActionPerformed

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HabilitaCampos(false);
        if(somostra.equals("S")){
            bt_novo                     .setEnabled(false);
            bt_incluir                  .setVisible(false);
            bt_alterar                  .setVisible(false);
            bt_excluir                  .setVisible(false);
            bt_pesquisaGrupoProduto     .setEnabled(false);
            bt_pesquisaSubGrupoProduto  .setVisible(false);
            bt_anterior                 .setVisible(false);
            bt_proximo                  .setVisible(false);
        }
        if(bgp.idGrupoProduto != 0){
            sql = "select * from tb_grupoproduto where idGrupoProduto = " + bgp.idGrupoProduto + ";";
            PegaGrupoProduto();
            txt_codigoGrupoProduto          .setText(fc.FormataCampo(String.valueOf(bgp.codigoGrupoProduto), 3, 0));
            txt_codigoGrupoProduto          .setEditable    (false);
            txt_codigoGrupoProduto          .setFocusable   (false);
            txt_codigoSubGrupoProduto       .setText(fc.FormataCampo(String.valueOf(bsgp.codigoSubGrupoProduto), 3, 0));
            PegaSubGrupoProduto();
            txt_codigoSubGrupoProduto       .setEditable    (false);
            txt_codigoSubGrupoProduto       .setFocusable   (false);
            bt_novo                         .setEnabled     (false);
            bt_novo                         .setFocusable   (false);
        }
        if(somostra.equals("SN"))
            bt_pesquisaSubGrupoProduto  .setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void bt_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluirActionPerformed
        bsgp.codigoSubGrupoProduto = Integer.parseInt(txt_codigoSubGrupoProduto.getText());
        if(JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir o registro n°" + bsgp.codigoSubGrupoProduto + "?", "", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION)
            return;
        sql = "delete from tb_subgrupoproduto where idSubGrupoProduto = " + bsgp.idSubGrupoProduto + ";";
        sqlstate = parametrosNS.dao.ExcluirRegistro(sql);
        
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoGrupoProduto.grabFocus();
    }//GEN-LAST:event_bt_excluirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(GruProCon    != null)GruProCon   .dispose();
        if(ConSubGruPro != null)ConSubGruPro.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void txt_codigoGrupoProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoGrupoProdutoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            bt_pesquisaGrupoProduto.grabFocus();
    }//GEN-LAST:event_txt_codigoGrupoProdutoKeyPressed

    private void txt_codigoSubGrupoProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoSubGrupoProdutoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            bt_novo.grabFocus();
    }//GEN-LAST:event_txt_codigoSubGrupoProdutoKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_anterior;
    private javax.swing.JButton bt_excluir;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisaGrupoProduto;
    private javax.swing.JButton bt_pesquisaSubGrupoProduto;
    private javax.swing.JButton bt_proximo;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_nomeGrupoProduto;
    private javax.swing.JFormattedTextField txt_codigoGrupoProduto;
    private javax.swing.JFormattedTextField txt_codigoSubGrupoProduto;
    private javax.swing.JTextField txt_descricaoSubGrupoProduto;
    // End of variables declaration//GEN-END:variables
    
    private void ReiniciaTela(){
        txt_codigoGrupoProduto      .setText("");
        label_nomeGrupoProduto      .setText("");
        txt_codigoSubGrupoProduto   .setText("");
        ReiniciaCampos();
    }
    
    private void ReiniciaCampos(){
        txt_descricaoSubGrupoProduto.setText("");
    }
    
    private void HabilitaCampos(boolean Habilita){
        txt_codigoSubGrupoProduto   .setEditable    (Habilita);
        txt_codigoSubGrupoProduto   .setFocusable   (Habilita);
        bt_novo                     .setEnabled     (Habilita);
        bt_novo                     .setFocusable   (Habilita);
        txt_descricaoSubGrupoProduto.setEditable    (Habilita);
        txt_descricaoSubGrupoProduto.setFocusable   (Habilita);
        bt_pesquisaSubGrupoProduto  .setEnabled     (Habilita);
        bt_pesquisaSubGrupoProduto  .setFocusable   (Habilita);
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
    
    private void PegaGrupoProduto(){
        txt_codigoGrupoProduto.setText(fc.FormataCampo(txt_codigoGrupoProduto.getText(), 3, 0));
        bgp.codigoGrupoProduto = Integer.parseInt(txt_codigoGrupoProduto.getText());
        if(bgp.codigoGrupoProduto != 0)
            sql = "select * from tb_grupoproduto where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoGrupoProduto = " + bgp.codigoGrupoProduto + ";";
        dadosGrupoProdutos.clear();
        dadosGrupoProdutos = parametrosNS.dao.Consulta(sql);
        if(dadosGrupoProdutos.isEmpty()){
            label_nomeGrupoProduto.setText("Não existe");
            bt_incluir.setEnabled(false);
            bt_alterar.setEnabled(false);
            bt_excluir.setEnabled(false);
            return;
        }
        HabilitaBotoes();
        PegaDadosGrupoProduto();
    }
    
    private void PegaDadosGrupoProduto(){
        for(int i = 0; i < dadosGrupoProdutos.size(); i++){
            bgp.idGrupoProduto          = Integer.parseInt(  String.valueOf(dadosGrupoProdutos.get(i).get(0)));
            bgp.idEmpresa               = Integer.parseInt(  String.valueOf(dadosGrupoProdutos.get(i).get(1)));
            bgp.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosGrupoProdutos.get(i).get(2)));
            bgp.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosGrupoProdutos.get(i).get(3)));
            bgp.codigoGrupoProduto      = Integer.parseInt(  String.valueOf(dadosGrupoProdutos.get(i).get(4)));
            bgp.descricaoGrupo          =                    String.valueOf(dadosGrupoProdutos.get(i).get(5));
        }
        HabilitaCampos(true);
        label_nomeGrupoProduto.setText(bgp.descricaoGrupo);
        txt_codigoSubGrupoProduto.grabFocus();
    }
    
    private void PegaSubGrupoProduto(){
        bsgp.idEmpresa             = bgp.idEmpresa;
        bsgp.codigoGrupo           = bgp.codigoGrupo;
        bsgp.codigoEmpresa         = bgp.codigoEmpresa;
        bsgp.codigoGrupoProduto    = bgp.codigoGrupoProduto;
        txt_codigoSubGrupoProduto.setText(fc.FormataCampo(txt_codigoSubGrupoProduto.getText(), 3, 0));
        bsgp.codigoSubGrupoProduto = Integer.parseInt(txt_codigoSubGrupoProduto.getText());
        if(bsgp.codigoSubGrupoProduto == 0)
            return;
        sql = "select * from tb_subgrupoproduto where idEmpresa = " + bsgp.idEmpresa + " and codigoGrupoProduto = " + bsgp.codigoGrupoProduto + " and codigoSubGrupoProduto = " + bsgp.codigoSubGrupoProduto + ";";
        dadosSubGrupoProdutos.clear();
        dadosSubGrupoProdutos = parametrosNS.dao.Consulta(sql);
        if(dadosSubGrupoProdutos.isEmpty()){
            Mensagem = "SubGrupo " + bsgp.codigoSubGrupoProduto + " não encontrado!\nPara incluir pressione NOVO!";
            new MostraMensagem(Mensagem);
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        HabilitaCampos(true);
        PegaDadosSubGrupoProduto();
    }
    
    private void PegaDadosSubGrupoProduto(){
        for(int i = 0; i < dadosSubGrupoProdutos.size(); i++){
            bsgp = new BeanSubGrupoProduto();
            if(dadosSubGrupoProdutos.get(i).get(0) != null){bsgp.idSubGrupoProduto          = Integer.parseInt(  String.valueOf(dadosSubGrupoProdutos.get(i).get(0)));}
            if(dadosSubGrupoProdutos.get(i).get(1) != null){bsgp.idEmpresa                  = Integer.parseInt(  String.valueOf(dadosSubGrupoProdutos.get(i).get(1)));}
            if(dadosSubGrupoProdutos.get(i).get(2) != null){bsgp.codigoGrupo                = Integer.parseInt(  String.valueOf(dadosSubGrupoProdutos.get(i).get(2)));}
            if(dadosSubGrupoProdutos.get(i).get(3) != null){bsgp.codigoEmpresa              = Integer.parseInt(  String.valueOf(dadosSubGrupoProdutos.get(i).get(3)));}
            if(dadosSubGrupoProdutos.get(i).get(4) != null){bsgp.codigoGrupoProduto         = Integer.parseInt(  String.valueOf(dadosSubGrupoProdutos.get(i).get(4)));}
            if(dadosSubGrupoProdutos.get(i).get(5) != null){bsgp.codigoSubGrupoProduto      = Integer.parseInt(  String.valueOf(dadosSubGrupoProdutos.get(i).get(5)));}
            if(dadosSubGrupoProdutos.get(i).get(6) != null){bsgp.descricaoSubGrupo          =                    String.valueOf(dadosSubGrupoProdutos.get(i).get(6));}
        }
        txt_descricaoSubGrupoProduto    .setText(bsgp.descricaoSubGrupo);
        txt_descricaoSubGrupoProduto    .grabFocus();
    }
    
    private void PegaValores(){
        fatal = "N";
        bsgp.idEmpresa          = bgp.idEmpresa;
        bsgp.codigoGrupo        = bgp.codigoGrupo;
        bsgp.codigoEmpresa      = bgp.codigoEmpresa;
        bsgp.codigoGrupoProduto = bgp.codigoGrupoProduto;
        if(txt_descricaoSubGrupoProduto.getText().equals("")){
            Mensagem = "Descrição inválido!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bsgp.codigoSubGrupoProduto    = Integer.parseInt(txt_codigoSubGrupoProduto.getText().replace(" ", ""));
        if(txt_codigoGrupoProduto.getText().replace(" ", "").equals("")){
            Mensagem = "Grupo inválido!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bsgp.descricaoSubGrupo          = txt_descricaoSubGrupoProduto.getText();
    }
    
}
