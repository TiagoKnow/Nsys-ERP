package TelasEstoque;

import Beans.*;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import Parametros.parametrosNS;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 @author Tiago e Paulo
 */
public class SubGrupoProdutoConsulta extends javax.swing.JFrame {
    //String's
    String sql                          = "";
    String sqlstate                     = "";
    String Mensagem                     = "";
    String somostra                     = "";
    String retorno                      = "";
    
    //int's
    int    linha                        = 0;
    
    //Vetores
    ArrayList            parametros                = new ArrayList();
//    ArrayList            dadosPadroes              = new ArrayList();
    ArrayList<ArrayList> dadosGrupoProdutos        = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosSubGrupoProdutos     = new ArrayList<ArrayList>();
    
    //Bean's
    BeanGrupoProduto            bgp     = new BeanGrupoProduto();
    BeanSubGrupoProduto         bsgp    = new BeanSubGrupoProduto();
    
    //Especiais
    DefaultTableModel           Table;
    FormataCampo                fc      = new FormataCampo();
    
    //Telas
    SubGrupoProdutoCadastro     SubGruProCad;
    
    public SubGrupoProdutoConsulta(String Somostra){
        somostra                = Somostra;
        
        initComponents();
    }
    
    private void PegaSubGrupoProdutos(){
        dadosSubGrupoProdutos.clear();
        dadosSubGrupoProdutos = parametrosNS.dao.Consulta(sql);
        PegaDadosSubGrupoProdutos();
    }
    
    private void PegaDadosSubGrupoProdutos(){
        Table.setNumRows(0);
        for(int i = 0; i < dadosSubGrupoProdutos.size(); i++){
            bgp  = new BeanGrupoProduto();
            bsgp = new BeanSubGrupoProduto();
            
            if(dadosSubGrupoProdutos.get(i).get(0) != null){bsgp.idSubGrupoProduto          = Integer.parseInt(  String.valueOf(dadosSubGrupoProdutos.get(i).get(0)));}
            if(dadosSubGrupoProdutos.get(i).get(1) != null){bsgp.idEmpresa                  = Integer.parseInt(  String.valueOf(dadosSubGrupoProdutos.get(i).get(1)));}
            if(dadosSubGrupoProdutos.get(i).get(2) != null){bsgp.codigoGrupo                = Integer.parseInt(  String.valueOf(dadosSubGrupoProdutos.get(i).get(2)));}
            if(dadosSubGrupoProdutos.get(i).get(3) != null){bsgp.codigoEmpresa              = Integer.parseInt(  String.valueOf(dadosSubGrupoProdutos.get(i).get(3)));}
            if(dadosSubGrupoProdutos.get(i).get(4) != null){bsgp.codigoGrupoProduto         = Integer.parseInt(  String.valueOf(dadosSubGrupoProdutos.get(i).get(4)));}
            if(dadosSubGrupoProdutos.get(i).get(5) != null){bsgp.codigoSubGrupoProduto      = Integer.parseInt(  String.valueOf(dadosSubGrupoProdutos.get(i).get(5)));}
            if(dadosSubGrupoProdutos.get(i).get(6) != null){bsgp.descricaoSubGrupo          =                    String.valueOf(dadosSubGrupoProdutos.get(i).get(6));}
            
            bgp.idEmpresa          = bsgp.idEmpresa;
            bgp.codigoGrupo        = bsgp.codigoGrupo;
            bgp.codigoEmpresa      = bsgp.codigoEmpresa;
            bgp.codigoGrupoProduto = bsgp.codigoGrupoProduto;
            if(dadosSubGrupoProdutos.get(i).get(7) != null){bgp.descricaoGrupo              =                    String.valueOf(dadosSubGrupoProdutos.get(i).get(7));}
            
            Table.addRow(new Object [] {fc.FormataCampo(String.valueOf(bgp.codigoGrupoProduto  ), 3, 0) + "-" + bgp.descricaoGrupo, fc.FormataCampo(String.valueOf(bsgp.codigoSubGrupoProduto), 3, 0) + "-" + bsgp.descricaoSubGrupo});
        }
    }
    
    private void PegaGrupoProdutos(){
        sql = "select idGrupoProduto from tb_grupoproduto where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoGrupoProduto = " + bgp.codigoGrupoProduto + ";";
        dadosGrupoProdutos.clear();
        dadosGrupoProdutos = parametrosNS.dao.Consulta(sql);
        PegaDadosGrupoProdutos();
    }
    
    private void PegaDadosGrupoProdutos(){
        for(int i = 0; i < dadosGrupoProdutos.size(); i++)
            bgp.idGrupoProduto          = Integer.parseInt(  String.valueOf(dadosGrupoProdutos.get(i).get(0)));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_detalhesItem = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_subGrupos = new javax.swing.JTable();
        txt_descricaoSubGrupo = new javax.swing.JTextField();
        txt_subgrupoProduto = new javax.swing.JFormattedTextField();
        bt_sair = new javax.swing.JButton();
        jMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        bt_cadastrarSubGrupoProdutos = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        bt_sair1 = new javax.swing.JMenuItem();

        bt_detalhesItem.setText("Detalhes");
        bt_detalhesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_detalhesItemActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_detalhesItem);

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
        jLabel1.setText("Grupos de Produtos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_subGrupos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição do Grupo", "Descrição do SubGrupo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_subGrupos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_subGrupos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_subGrupos.getTableHeader().setReorderingAllowed(false);
        tabela_subGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_subGruposMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_subGrupos);
        if (tabela_subGrupos.getColumnModel().getColumnCount() > 0) {
            tabela_subGrupos.getColumnModel().getColumn(0).setResizable(false);
            tabela_subGrupos.getColumnModel().getColumn(0).setPreferredWidth(180);
            tabela_subGrupos.getColumnModel().getColumn(1).setResizable(false);
            tabela_subGrupos.getColumnModel().getColumn(1).setPreferredWidth(350);
        }

        txt_descricaoSubGrupo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_descricaoSubGrupoKeyReleased(evt);
            }
        });

        try {
            txt_subgrupoProduto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_subgrupoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_subgrupoProdutoKeyReleased(evt);
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(txt_subgrupoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_descricaoSubGrupo))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_descricaoSubGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_subgrupoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addContainerGap())
        );

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        jMenu2.setText("Cadastro");

        bt_cadastrarSubGrupoProdutos.setText("Sub Grupo de Produto");
        bt_cadastrarSubGrupoProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastrarSubGrupoProdutosActionPerformed(evt);
            }
        });
        jMenu2.add(bt_cadastrarSubGrupoProdutos);

        jMenu1.add(jMenu2);
        jMenu1.add(jSeparator1);

        bt_sair1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        bt_sair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair1.setText("Sair");
        bt_sair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sair1ActionPerformed(evt);
            }
        });
        jMenu1.add(bt_sair1);

        jMenu.add(jMenu1);

        setJMenuBar(jMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bt_sair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_sair)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabela_subGruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_subGruposMouseClicked
        linha = tabela_subGrupos.getSelectedRow();
        if(linha < 0){
            Mensagem = "Item não selecionado!";
            new MostraMensagem(Mensagem);
            return;
        }
        bgp.codigoGrupoProduto  = Integer.parseInt(String.valueOf(tabela_subGrupos.getValueAt(linha, 0)).substring(0, 3));
        PegaGrupoProdutos();
        
        retorno = String.valueOf(Integer.parseInt(String.valueOf(tabela_subGrupos.getValueAt(linha, 1)).substring(0, 3)));
        if(evt.getButton() == MouseEvent.BUTTON3)
            if(somostra.equalsIgnoreCase("N"))
                MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
        if(evt.getClickCount() < 2)
            return;
        dispose();
    }//GEN-LAST:event_tabela_subGruposMouseClicked

    private void txt_descricaoSubGrupoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descricaoSubGrupoKeyReleased
        bsgp.descricaoSubGrupo = txt_descricaoSubGrupo.getText().replace(" ", "");
        if(bsgp.descricaoSubGrupo.equals("")){
            sql = "select "
                + " grus.idSubGrupoProduto, "
                + " grus.idEmpresa, "
                + " grus.codigoGrupo, "
                + " grus.codigoEmpresa, "
                + " grus.codigoGrupoProduto, "
                + " grus.codigoSubGrupoProduto, "
                + " grus.descricaoSubGrupo, "
                + " gru.descricaoGrupo "
                + "from "
                + " tb_subgrupoproduto grus "
                + "  inner join tb_grupoproduto gru on ((gru.idEmpresa = grus.idEmpresa) and (gru.codigoGrupoProduto = grus.codigoGrupoProduto))"
                + "  where gru.codigoGrupo = " + parametrosNS.bge.codigoGrupo + " and gru.codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " order by gru.codigoGrupoProduto, grus.codigoSubGrupoProduto asc;";
            PegaSubGrupoProdutos();
            return;
        }
        sql = "select "
            + " grus.idSubGrupoProduto, "
            + " grus.idEmpresa, "
            + " grus.codigoGrupo, "
            + " grus.codigoEmpresa, "
            + " grus.codigoGrupoProduto, "
            + " grus.codigoSubGrupoProduto, "
            + " grus.descricaoSubGrupo, "
            + " gru.descricaoGrupo "
            + "from "
            + " tb_subgrupoproduto grus "
            + "	inner join tb_grupoproduto gru on ((gru.idEmpresa = grus.idEmpresa) and (gru.codigoGrupoProduto = grus.codigoGrupoProduto))"
            + "  where gru.codigoGrupo = " + parametrosNS.bge.codigoGrupo + " and gru.codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and descricaoSubGrupo like '%" + bsgp.descricaoSubGrupo + "%' order by gru.codigoGrupoProduto, grus.codigoSubGrupoProduto asc;";
        PegaSubGrupoProdutos();
    }//GEN-LAST:event_txt_descricaoSubGrupoKeyReleased

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_detalhesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesItemActionPerformed
        if(SubGruProCad != null)if(SubGruProCad.isVisible()){
            Mensagem = "Tela já Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        SubGruProCad = new SubGrupoProdutoCadastro("S", bgp.idGrupoProduto, Integer.parseInt(retorno));
        SubGruProCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesItemActionPerformed

    private void bt_cadastrarSubGrupoProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastrarSubGrupoProdutosActionPerformed
        if(SubGruProCad != null)if(SubGruProCad.isVisible()){
            Mensagem = "Tela já Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        SubGruProCad = new SubGrupoProdutoCadastro("SN", 0, 0);
        SubGruProCad.setVisible(true);
    }//GEN-LAST:event_bt_cadastrarSubGrupoProdutosActionPerformed

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Table = (DefaultTableModel)tabela_subGrupos.getModel();
        
        sql = "select "
            + " grus.idSubGrupoProduto, "
            + " grus.idEmpresa, "
            + " grus.codigoGrupo, "
            + " grus.codigoEmpresa, "
            + " grus.codigoGrupoProduto, "
            + " grus.codigoSubGrupoProduto, "
            + " grus.descricaoSubGrupo, "
            + " gru.descricaoGrupo "
            + "from "
            + " tb_subgrupoproduto grus "
            + "	inner join tb_grupoproduto gru on ((gru.idEmpresa = grus.idEmpresa) and (gru.codigoGrupoProduto = grus.codigoGrupoProduto))"
            + "  where gru.codigoGrupo = " + parametrosNS.bge.codigoGrupo + " and gru.codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " order by gru.codigoGrupoProduto, grus.codigoSubGrupoProduto asc;";
        PegaSubGrupoProdutos();
        
        if(parametrosNS.bu.nivelUsuario  < 4 | somostra.equals("S"))jMenu.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(SubGruProCad != null)SubGruProCad.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
    }//GEN-LAST:event_formWindowGainedFocus

    private void txt_subgrupoProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_subgrupoProdutoKeyReleased
        if(txt_subgrupoProduto.getText().replace(" ", "").equals("")){
            sql = "select "
                + " grus.idSubGrupoProduto, "
                + " grus.idEmpresa, "
                + " grus.codigoGrupo, "
                + " grus.codigoEmpresa, "
                + " grus.codigoGrupoProduto, "
                + " grus.codigoSubGrupoProduto, "
                + " grus.descricaoSubGrupo, "
                + " gru.descricaoGrupo "
                + "from "
                + " tb_subgrupoproduto grus "
                + " inner join tb_grupoproduto gru on ((gru.idEmpresa = grus.idEmpresa) and (gru.codigoGrupoProduto = grus.codigoGrupoProduto))"
                + "  where gru.codigoGrupo = " + parametrosNS.bge.codigoGrupo + " and gru.codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " order by gru.codigoGrupoProduto, grus.codigoSubGrupoProduto asc;";
            PegaSubGrupoProdutos();
            return;
        }
        bsgp.codigoSubGrupoProduto    = Integer.parseInt(txt_subgrupoProduto.getText().replace(" ", ""));
        sql = "select "
            + " grus.idSubGrupoProduto, "
            + " grus.idEmpresa, "
            + " grus.codigoGrupo, "
            + " grus.codigoEmpresa, "
            + " grus.codigoGrupoProduto, "
            + " grus.codigoSubGrupoProduto, "
            + " grus.descricaoSubGrupo, "
            + " gru.descricaoGrupo "
            + "from "
            + " tb_subgrupoproduto grus "
            + "	inner join tb_grupoproduto gru on ((gru.idEmpresa = grus.idEmpresa) and (gru.codigoGrupoProduto = grus.codigoGrupoProduto))"
            + "  where gru.codigoGrupo = " + parametrosNS.bge.codigoGrupo + " and gru.codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and codigoSubGrupoProduto >= " + bsgp.codigoSubGrupoProduto   + " order by gru.codigoGrupoProduto, grus.codigoSubGrupoProduto asc;";
        PegaSubGrupoProdutos();
    }//GEN-LAST:event_txt_subgrupoProdutoKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_cadastrarSubGrupoProdutos;
    private javax.swing.JMenuItem bt_detalhesItem;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable tabela_subGrupos;
    private javax.swing.JTextField txt_descricaoSubGrupo;
    private javax.swing.JFormattedTextField txt_subgrupoProduto;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
}
