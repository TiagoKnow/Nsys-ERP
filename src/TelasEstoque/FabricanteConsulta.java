package TelasEstoque;

import Beans.BeanFabricante;
import Beans.BeanUsuarios;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import Parametros.parametrosNS;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 * @author Tiago e Paulo
 */
public class FabricanteConsulta extends javax.swing.JFrame {
    //String
    String sql                      = "";
    String Mensagem                 = "";
    String retorno                  = "";
    String somostra                 = "";
    String sqlstate                 = "";
    
    //int's
    int    linha                    = 0;
    
    //Vetores
    ArrayList            parametros            = new ArrayList();
//    ArrayList            dadosPadroes          = new ArrayList();
    ArrayList<ArrayList> dadosFabricante       = new ArrayList<ArrayList>();
    
    //Bean's
    BeanFabricante          bfab    = new BeanFabricante();
    BeanUsuarios            bu      = new BeanUsuarios();
    
    //Especiais
    DefaultTableModel       Table;
    FormataCampo            fc      = new FormataCampo();
    
    //Telas
    FabricanteCadastro      FabCad;
    
    public FabricanteConsulta(String Somostra){
        somostra                    = Somostra;
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_detalhesItem = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_fabricante = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_nome = new javax.swing.JTextField();
        txt_site = new javax.swing.JTextField();
        bt_sair = new javax.swing.JButton();
        jMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        bt_cadastroFabricantes = new javax.swing.JMenuItem();
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

        tabela_fabricante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_fabricante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Site"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_fabricante.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_fabricante.getTableHeader().setReorderingAllowed(false);
        tabela_fabricante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_fabricanteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_fabricante);
        if (tabela_fabricante.getColumnModel().getColumnCount() > 0) {
            tabela_fabricante.getColumnModel().getColumn(0).setResizable(false);
            tabela_fabricante.getColumnModel().getColumn(1).setResizable(false);
            tabela_fabricante.getColumnModel().getColumn(1).setPreferredWidth(175);
            tabela_fabricante.getColumnModel().getColumn(2).setResizable(false);
            tabela_fabricante.getColumnModel().getColumn(2).setPreferredWidth(175);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Fabricante");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_codigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoFocusLost(evt);
            }
        });
        txt_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoActionPerformed(evt);
            }
        });
        txt_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoKeyReleased(evt);
            }
        });

        txt_nome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_nomeFocusLost(evt);
            }
        });
        txt_nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nomeKeyReleased(evt);
            }
        });

        txt_site.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_siteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_siteFocusLost(evt);
            }
        });
        txt_site.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_siteKeyReleased(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_site)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_site, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
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

        bt_cadastroFabricantes.setText("Fabricantes");
        bt_cadastroFabricantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastroFabricantesActionPerformed(evt);
            }
        });
        jMenu2.add(bt_cadastroFabricantes);

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

    private void tabela_fabricanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_fabricanteMouseClicked
        linha = tabela_fabricante.getSelectedRow();
        retorno = String.valueOf(tabela_fabricante.getValueAt(linha, 0));
        if(evt.getButton() == MouseEvent.BUTTON3){
            if(somostra.equalsIgnoreCase("N")){
                MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
        if(evt.getClickCount() < 2)
            return;
        dispose();
    }//GEN-LAST:event_tabela_fabricanteMouseClicked

    private void txt_codigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoKeyReleased
        if(txt_codigo.getText().equals("")){
            sql = "select * from tb_Fabricante where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaFabricante();
            return;
        }
        sql = "select * from tb_fabricante where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoFabricante >= '" + txt_codigo.getText() + "';";
        PegaFabricante();
    }//GEN-LAST:event_txt_codigoKeyReleased

    private void txt_nomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nomeFocusLost
        
    }//GEN-LAST:event_txt_nomeFocusLost

    private void txt_siteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_siteFocusLost
        
    }//GEN-LAST:event_txt_siteFocusLost

    private void txt_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoActionPerformed

    private void txt_codigoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFocusGained
        
    }//GEN-LAST:event_txt_codigoFocusGained

    private void txt_nomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nomeKeyReleased
        bfab.nomeFabricante = txt_nome.getText();
        if(bfab.nomeFabricante.equals("")){
            sql = "select * from tb_fabricante where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaFabricante();
            return;
        }
        sql = "select * from tb_fabricante where idEmpresa = " + parametrosNS.be.IdEmpresa + " and nomeFabricante like '%" + bfab.nomeFabricante + "%';";
        PegaFabricante();
    }//GEN-LAST:event_txt_nomeKeyReleased

    private void txt_siteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_siteFocusGained
        
    }//GEN-LAST:event_txt_siteFocusGained

    private void txt_codigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoFocusLost

    private void txt_siteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_siteKeyReleased
        bfab.siteFabricante = txt_site.getText();
        if(bfab.siteFabricante.equals("")){
            sql = "select * from tb_Fabricante where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaFabricante();
            return;
        }
        sql = "select * from tb_fabricante where idEmpresa = " + parametrosNS.be.IdEmpresa + " and siteFabricante like '%" + bfab.siteFabricante + "%';";
        PegaFabricante();
    }//GEN-LAST:event_txt_siteKeyReleased

    private void bt_detalhesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesItemActionPerformed
        if(FabCad != null)if(FabCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        FabCad = new FabricanteCadastro("S", Integer.parseInt(retorno));
        FabCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesItemActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_cadastroFabricantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastroFabricantesActionPerformed
        if(FabCad != null)if(FabCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        FabCad = new FabricanteCadastro("SN", 0);
        FabCad.setVisible(true);
    }//GEN-LAST:event_bt_cadastroFabricantesActionPerformed

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Table = (DefaultTableModel)tabela_fabricante.getModel();
        
        sql = "select * from tb_fabricante where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        PegaFabricante();
        
        if(parametrosNS.bu.nivelUsuario  < 4 | somostra.equals("S"))
            jMenu.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(FabCad   != null)FabCad.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
    }//GEN-LAST:event_formWindowGainedFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_cadastroFabricantes;
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
    private javax.swing.JTable tabela_fabricante;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_site;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
    private void PegaFabricante() {
        dadosFabricante.clear();
        dadosFabricante = parametrosNS.dao.Consulta(sql);
        PreencherTabela();
    }
    
    private void PreencherTabela(){
        Table.setNumRows(0);
        for(int i = 0; i < dadosFabricante.size(); i++){
            bfab = new BeanFabricante();
            bfab.idFabricante       = Integer.parseInt(  String.valueOf(dadosFabricante.get(i).get(0)));
            bfab.idEmpresa          = Integer.parseInt(  String.valueOf(dadosFabricante.get(i).get(1)));
            bfab.codigoGrupo        = Integer.parseInt(  String.valueOf(dadosFabricante.get(i).get(2)));
            bfab.codigoEmpresa      = Integer.parseInt(  String.valueOf(dadosFabricante.get(i).get(3)));
            bfab.codigoFabricante   = Integer.parseInt(  String.valueOf(dadosFabricante.get(i).get(4)));
            bfab.nomeFabricante     =                    String.valueOf(dadosFabricante.get(i).get(5));
            bfab.siteFabricante     =                    String.valueOf(dadosFabricante.get(i).get(6));
            
            Table.addRow(new Object [] {fc.FormataCampo(String.valueOf(bfab.codigoFabricante), 5, 0), bfab.nomeFabricante, bfab.siteFabricante});
        }
    }
    
}
