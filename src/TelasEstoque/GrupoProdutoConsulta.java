package TelasEstoque;

import Beans.*;
import FuncoesInternas.MostraMensagem;
import Parametros.parametrosNS;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/*
 @author Tiago e Paulo
 */
public class GrupoProdutoConsulta extends javax.swing.JFrame {
    //String's
    String sql                      = "";
    String sqlstate                 = "";
    String Mensagem                 = "";
    String somostra                 = "";
    String retorno                  = "";
    
    //int's
    int    linha                    = 0;
    
    //Vetores
    ArrayList            parametros             = new ArrayList();
//    ArrayList            dadosPadroes           = new ArrayList();
    ArrayList<ArrayList> dadosGrupoProdutos     = new ArrayList<ArrayList>();
    
    //Bean's
    BeanGrupoProduto        bgp     = new BeanGrupoProduto();
    
    //Especiais
    DefaultTableModel       Table;
    
    //Telas
    GrupoProdutoCadastro    GruProCad;
    
    public GrupoProdutoConsulta(String Somostra){
        somostra            = Somostra;
        
        initComponents();
    }
    
    private void PegaGrupos(){
        dadosGrupoProdutos.clear();
        dadosGrupoProdutos = parametrosNS.dao.Consulta(sql);
        PreencherTabela();
    }
    
    private void PreencherTabela(){
        Table.setNumRows(0);
        for(int i = 0; i < dadosGrupoProdutos.size(); i++){
            bgp.idGrupoProduto          = Integer.parseInt(  String.valueOf(dadosGrupoProdutos.get(i).get(0)));
            bgp.idEmpresa               = Integer.parseInt(  String.valueOf(dadosGrupoProdutos.get(i).get(1)));
            bgp.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosGrupoProdutos.get(i).get(2)));
            bgp.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosGrupoProdutos.get(i).get(3)));
            bgp.codigoGrupoProduto      = Integer.parseInt(  String.valueOf(dadosGrupoProdutos.get(i).get(4)));
            bgp.descricaoGrupo          =                    String.valueOf(dadosGrupoProdutos.get(i).get(5));
            
            Table.addRow(new Object [] {String.valueOf(bgp.codigoGrupoProduto), bgp.descricaoGrupo});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_detalhesItem = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_grupos = new javax.swing.JTable();
        txt_descricao = new javax.swing.JTextField();
        txt_codigoGrupoDoProduto = new javax.swing.JFormattedTextField();
        bt_sair = new javax.swing.JButton();
        jMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        bt_cadastroGrupoDeProduto = new javax.swing.JMenuItem();
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

        tabela_grupos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo do Grupo", "Descrição do Grupo"
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
        tabela_grupos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_grupos.getTableHeader().setReorderingAllowed(false);
        tabela_grupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_gruposMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_grupos);
        if (tabela_grupos.getColumnModel().getColumnCount() > 0) {
            tabela_grupos.getColumnModel().getColumn(0).setResizable(false);
            tabela_grupos.getColumnModel().getColumn(0).setPreferredWidth(20);
            tabela_grupos.getColumnModel().getColumn(1).setResizable(false);
            tabela_grupos.getColumnModel().getColumn(1).setPreferredWidth(230);
        }

        txt_descricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_descricaoFocusLost(evt);
            }
        });
        txt_descricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_descricaoKeyReleased(evt);
            }
        });

        try {
            txt_codigoGrupoDoProduto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoGrupoDoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoGrupoDoProdutoKeyReleased(evt);
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
                        .addComponent(txt_codigoGrupoDoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(txt_descricao))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoGrupoDoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
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

        bt_cadastroGrupoDeProduto.setText("Grupo de Produto");
        bt_cadastroGrupoDeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastroGrupoDeProdutoActionPerformed(evt);
            }
        });
        jMenu2.add(bt_cadastroGrupoDeProduto);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void tabela_gruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_gruposMouseClicked
        linha = tabela_grupos.getSelectedRow();
        retorno = String.valueOf(tabela_grupos.getValueAt(linha, 0));
        if(evt.getButton() == MouseEvent.BUTTON3){
            if(somostra.equalsIgnoreCase("N")){
                MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
        if(evt.getClickCount() < 2)
            return;
        dispose();
    }//GEN-LAST:event_tabela_gruposMouseClicked

    private void txt_descricaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_descricaoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descricaoFocusLost

    private void txt_descricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descricaoKeyReleased
        bgp.descricaoGrupo = txt_descricao.getText();
        if(bgp.descricaoGrupo.equals("")){
            sql = "select * from tb_grupoproduto where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaGrupos();
            return;
        }
        sql = "select * from tb_grupoproduto where idEmpresa = " + parametrosNS.be.IdEmpresa + " and descricaoGrupo like '%" + bgp.descricaoGrupo + "%';";
        PegaGrupos();
    }//GEN-LAST:event_txt_descricaoKeyReleased

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_detalhesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesItemActionPerformed
        if(GruProCad != null)if(GruProCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        GruProCad = new GrupoProdutoCadastro("S", Integer.parseInt(retorno));
        GruProCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesItemActionPerformed

    private void txt_codigoGrupoDoProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoGrupoDoProdutoKeyReleased
        if(txt_codigoGrupoDoProduto.getText().replace(" ", "").equals("")){
            sql = "select * from tb_grupoproduto where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaGrupos();
            return;
        }
        bgp.codigoGrupoProduto = Integer.parseInt(txt_codigoGrupoDoProduto.getText().replace(" ", ""));
        sql = "select * from tb_grupoproduto where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoGrupoProduto >= " + bgp.codigoGrupoProduto + ";";
        PegaGrupos();
    }//GEN-LAST:event_txt_codigoGrupoDoProdutoKeyReleased

    private void bt_cadastroGrupoDeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastroGrupoDeProdutoActionPerformed
        if(GruProCad != null)if(GruProCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        GruProCad = new GrupoProdutoCadastro("SN", 0);
        GruProCad.setVisible(true);
    }//GEN-LAST:event_bt_cadastroGrupoDeProdutoActionPerformed

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Table = (DefaultTableModel)tabela_grupos.getModel();
        
        sql = "select * from tb_grupoproduto where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        PegaGrupos();
        if(parametrosNS.bu.nivelUsuario  < 4 | somostra.equals("S"))
            jMenu.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(GruProCad    != null)GruProCad.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
    }//GEN-LAST:event_formWindowGainedFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_cadastroGrupoDeProduto;
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
    private javax.swing.JTable tabela_grupos;
    private javax.swing.JFormattedTextField txt_codigoGrupoDoProduto;
    private javax.swing.JTextField txt_descricao;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
}
