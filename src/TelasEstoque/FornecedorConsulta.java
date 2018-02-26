package TelasEstoque;

import Beans.*;
import FuncoesInternas.*;
import Parametros.parametrosNS;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/*
 @author Tiago e Paulo
 */
public class FornecedorConsulta extends javax.swing.JFrame {
    //String
    String sql                  = "";
    String sqlstate             = "";
    String Mensagem             = "";
    String somostra             = "";
    String retorno              = "";
    String texto                = "";
    
    //int's
    int    linha                = 0;
    int    index                = 0;
    int    User                 = 0;
    
    //Vetores
    ArrayList            parametros        = new ArrayList();
//    ArrayList            dadosPadroes      = new ArrayList();
    ArrayList<ArrayList> dadosFornecedor   = new ArrayList<ArrayList>();
    
    //Beans
    BeanFornecedor      bfor    = new BeanFornecedor();
    
    //Especiais
    DefaultTableModel           Table;
    FormataCPFCNPJ              FCpfCnpj  = new FormataCPFCNPJ();
    FormataCampo                fc        = new FormataCampo();
    
    //Telas
    FornecedorCadastro          ForCad;
    
    public FornecedorConsulta(String Somostra){
        somostra                = Somostra;
        
        initComponents();
    }
    
    private void PegaFornecedor(){
        dadosFornecedor.clear();
        dadosFornecedor = parametrosNS.dao.Consulta(sql);
        PegaDadosFornecedor();
    }
    
    private void PegaDadosFornecedor(){
        Table.setNumRows(0);
        for(int i = 0; i < dadosFornecedor.size(); i++){
            bfor.idFornecedor       = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(0)));
            bfor.idEmpresa          = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(1)));
            bfor.codigoGrupo        = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(2)));
            bfor.codigoEmpresa      = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(3)));
            bfor.codigoFornecedor   = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(4)));
            bfor.cnpj               =                    String.valueOf(dadosFornecedor.get(i).get(5));
            bfor.nome               =                    String.valueOf(dadosFornecedor.get(i).get(6));
            
            bfor.cnpj = FCpfCnpj.FormataCPFCNPJ(bfor.cnpj);
            
            Table.addRow(new Object [] {fc.FormataCampo(String.valueOf(bfor.codigoFornecedor), 5 , 0), bfor.nome, bfor.cnpj});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_detalhesItem = new javax.swing.JMenuItem();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_fornecedor = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        combo_parametro = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txt_parametro = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        bt_sair = new javax.swing.JButton();
        jMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
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

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_fornecedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_fornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CNPJ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_fornecedor.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_fornecedor.getTableHeader().setResizingAllowed(false);
        tabela_fornecedor.getTableHeader().setReorderingAllowed(false);
        tabela_fornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_fornecedorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabela_fornecedor);
        if (tabela_fornecedor.getColumnModel().getColumnCount() > 0) {
            tabela_fornecedor.getColumnModel().getColumn(0).setResizable(false);
            tabela_fornecedor.getColumnModel().getColumn(1).setResizable(false);
            tabela_fornecedor.getColumnModel().getColumn(1).setPreferredWidth(400);
            tabela_fornecedor.getColumnModel().getColumn(2).setResizable(false);
            tabela_fornecedor.getColumnModel().getColumn(2).setPreferredWidth(200);
        }

        jLabel2.setText("Pesquisa: ");

        combo_parametro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo do Fornecedor", "Nome do Fornecedor", "CNPJ do Fornecedor" }));

        jLabel3.setText("Parâmetro: ");

        txt_parametro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_parametroKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Fornecedores");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_parametro, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_parametro, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(combo_parametro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_parametro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {combo_parametro, jLabel2, jLabel3, txt_parametro});

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        jMenu2.setText("Cadastro");

        jMenuItem1.setText("Fornecedores");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

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
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bt_sair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_sair)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabela_fornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_fornecedorMouseClicked
        linha = tabela_fornecedor.getSelectedRow();
        retorno = String.valueOf(tabela_fornecedor.getValueAt(linha, 0));
        if(evt.getButton() == MouseEvent.BUTTON3)
            if(somostra.equalsIgnoreCase("N"))
                MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
        if(evt.getClickCount() < 2)
            return;
        dispose();
    }//GEN-LAST:event_tabela_fornecedorMouseClicked

    private void txt_parametroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_parametroKeyReleased
        index = combo_parametro.getSelectedIndex();
        texto = txt_parametro.getText();
        if(texto.equals("")){
            sql = "select idFornecedor, idEmpresa, codigoGrupo, codigoEmpresa, codigoFornecedor, cnpj, nome from tb_fornecedor where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaFornecedor();
            return;
        }
        switch(index){
            case 0: sql = "select idFornecedor, idEmpresa, codigoGrupo, codigoEmpresa, codigoFornecedor, cnpj, nome from tb_fornecedor where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoFornecedor >= "  + texto + ";";  break;
            case 1: sql = "select idFornecedor, idEmpresa, codigoGrupo, codigoEmpresa, codigoFornecedor, cnpj, nome from tb_fornecedor where idEmpresa = " + parametrosNS.be.IdEmpresa + " and nome like '%"          + texto + "%';";break;
            case 2: sql = "select idFornecedor, idEmpresa, codigoGrupo, codigoEmpresa, codigoFornecedor, cnpj, nome from tb_fornecedor where idEmpresa = " + parametrosNS.be.IdEmpresa + " and cnpj like '%"          + texto + "%';";break;
        }
        PegaFornecedor();
    }//GEN-LAST:event_txt_parametroKeyReleased

    private void bt_detalhesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesItemActionPerformed
        if(ForCad != null)if(ForCad.isVisible()){
            Mensagem = "Tela já Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        ForCad = new FornecedorCadastro("S", Integer.parseInt(retorno));
        ForCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesItemActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(ForCad != null)if(ForCad.isVisible()){
            Mensagem = "Tela já Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        ForCad = new FornecedorCadastro("SN", 0);
        ForCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Table = (DefaultTableModel)tabela_fornecedor.getModel();
        
        sql = "select idFornecedor, idEmpresa, codigoGrupo, codigoEmpresa, codigoFornecedor, cnpj, nome from tb_fornecedor where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        PegaFornecedor();
        
        if(parametrosNS.bu.nivelUsuario  < 4 | somostra.equals("S"))
            jMenu.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(ForCad   != null)ForCad.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
    }//GEN-LAST:event_formWindowGainedFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_detalhesItem;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JComboBox<String> combo_parametro;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable tabela_fornecedor;
    private javax.swing.JTextField txt_parametro;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
}
