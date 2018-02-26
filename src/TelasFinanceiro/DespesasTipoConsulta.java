package TelasFinanceiro;

import Beans.BeanDespesasTipo;
import Beans.BeanUsuarios;
import Dao.DaoMySQL;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import Parametros.parametrosNS;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 @author Tiago e Paulo
 */
public class DespesasTipoConsulta extends javax.swing.JFrame {
    //int's
    int    Linha                                = 0;
    int    abriuDespesaTipo                     = 0;
    
    //Strin's
    String sql                                  = "";
    String sqlstate                             = "";
    String Mensagem                             = "";
    String somostra                             = "";
    String retorno                              = "";
    
    //Vetores
    ArrayList            parametros                        = new ArrayList();
    ArrayList            dadosPadroes                      = new ArrayList();
    ArrayList<ArrayList> dadosDespesasTipo                 = new ArrayList<ArrayList>();
    
    //Bean's
    BeanDespesasTipo                    bdest   = new BeanDespesasTipo();
    BeanUsuarios                        bu      = new BeanUsuarios();
    
    //Especiais
    DefaultTableModel                   TableDespesasTipo;
    FormataCampo                        fc      = new FormataCampo();
    
    //Telas
    DespesasTipoCadastro    DesTipoCad;
    
    public DespesasTipoConsulta(ArrayList DadosPadroes){
        dadosPadroes                            = DadosPadroes;
        
        somostra                                = (String)  dadosPadroes.get(0);
        
        initComponents();
    }
    
    private void PegaDespesasTipo(){
        dadosDespesasTipo.clear();
        dadosDespesasTipo = parametrosNS.dao.Consulta(sql);
        PegaDadosDespesasTipo();
    }
    
    private void PegaDadosDespesasTipo(){
        TableDespesasTipo.setNumRows(0);
        for(int i = 0; i < dadosDespesasTipo.size(); i++){
            bdest = new BeanDespesasTipo();
            bdest.idDespesaTipo         = Integer.parseInt(  String.valueOf(dadosDespesasTipo.get(i).get(0)));
            bdest.idEmpresa             = Integer.parseInt(  String.valueOf(dadosDespesasTipo.get(i).get(1)));
            bdest.codigoGrupo           = Integer.parseInt(  String.valueOf(dadosDespesasTipo.get(i).get(2)));
            bdest.codigoEmpresa         = Integer.parseInt(  String.valueOf(dadosDespesasTipo.get(i).get(3)));
            bdest.codigoDespesaTipo     = Integer.parseInt(  String.valueOf(dadosDespesasTipo.get(i).get(4)));
            bdest.descricaoDespesaTipo  =                    String.valueOf(dadosDespesasTipo.get(i).get(5));
            
            TableDespesasTipo.addRow(new Object[] {fc.FormataCampo(String.valueOf(bdest.codigoDespesaTipo), 2, 0), bdest.descricaoDespesaTipo});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_detalhes = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_despesasTipo = new javax.swing.JTable();
        txt_codigoDespesaTipo = new javax.swing.JFormattedTextField();
        txt_descricaoDespesaTipo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        bt_cadastroDespesasTipo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        bt_sair = new javax.swing.JMenuItem();

        bt_detalhes.setText("Detalhes");
        bt_detalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_detalhesActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_detalhes);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Tipos de Despesas");
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
        jLabel1.setText("Consulta Tipo de Despesas");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_despesasTipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição"
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
        tabela_despesasTipo.getTableHeader().setReorderingAllowed(false);
        tabela_despesasTipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_despesasTipoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_despesasTipo);
        if (tabela_despesasTipo.getColumnModel().getColumnCount() > 0) {
            tabela_despesasTipo.getColumnModel().getColumn(0).setResizable(false);
            tabela_despesasTipo.getColumnModel().getColumn(1).setResizable(false);
            tabela_despesasTipo.getColumnModel().getColumn(1).setPreferredWidth(400);
        }

        try {
            txt_codigoDespesaTipo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoDespesaTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoDespesaTipoKeyReleased(evt);
            }
        });

        txt_descricaoDespesaTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_descricaoDespesaTipoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoDespesaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txt_descricaoDespesaTipo)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoDespesaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_descricaoDespesaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        jMenu2.setText("Cadastro");

        bt_cadastroDespesasTipo.setText("Tipo de Despesas");
        bt_cadastroDespesasTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastroDespesasTipoActionPerformed(evt);
            }
        });
        jMenu2.add(bt_cadastroDespesasTipo);

        jMenu1.add(jMenu2);
        jMenu1.add(jSeparator1);

        bt_sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });
        jMenu1.add(bt_sair);

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
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoDespesaTipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoDespesaTipoKeyReleased
        if(txt_codigoDespesaTipo.getText().replace(" ", "").equals("")){
            sql = "select * from tb_despesas_tipo where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaDespesasTipo();
            return;
        }
        bdest.codigoDespesaTipo = Integer.parseInt(txt_codigoDespesaTipo.getText().replace(" ", ""));
        sql = "select * from tb_despesas_tipo where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoDespesaTipo >= " + bdest.codigoDespesaTipo + ";";
        PegaDespesasTipo();
    }//GEN-LAST:event_txt_codigoDespesaTipoKeyReleased

    private void txt_descricaoDespesaTipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descricaoDespesaTipoKeyReleased
        bdest.descricaoDespesaTipo = txt_descricaoDespesaTipo.getText();
        if(bdest.descricaoDespesaTipo.equals("")){
            sql = "select * from tb_despesas_tipo where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaDespesasTipo();
            return;
        }
        sql = "select * from tb_despesas_tipo where idEmpresa = " + parametrosNS.be.IdEmpresa + " and descricaoDespesaTipo like '%" + bdest.descricaoDespesaTipo + "%';";
        PegaDespesasTipo();
    }//GEN-LAST:event_txt_descricaoDespesaTipoKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bt_cadastroDespesasTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastroDespesasTipoActionPerformed
        abriuDespesaTipo = 1;
        parametros.clear();
        parametros.add("SN");
        parametros.add(0);
        DesTipoCad = new DespesasTipoCadastro(parametros);
        DesTipoCad.setVisible(true);
    }//GEN-LAST:event_bt_cadastroDespesasTipoActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuDespesaTipo == 0)
            return;
        abriuDespesaTipo = 0;
        sql = "select * from tb_despesas_tipo where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        PegaDespesasTipo();
    }//GEN-LAST:event_formWindowGainedFocus

    private void tabela_despesasTipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_despesasTipoMouseClicked
        Linha = tabela_despesasTipo.getSelectedRow();
        if(Linha < 0){
            Mensagem = "Item não selecionado!";
            new MostraMensagem(Mensagem);
            return;
        }
        if(evt.getButton() == MouseEvent.BUTTON3){
            if(somostra.equalsIgnoreCase("N")){
                MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
        retorno = String.valueOf(Integer.parseInt(String.valueOf(tabela_despesasTipo.getValueAt(Linha, 0))));
        if(evt.getClickCount() < 2)
            return;
        dispose();
    }//GEN-LAST:event_tabela_despesasTipoMouseClicked

    private void bt_detalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesActionPerformed
        parametros.clear();
        parametros.add("S");
        parametros.add(Integer.parseInt(retorno));
        DesTipoCad = new DespesasTipoCadastro(parametros);
        DesTipoCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        TableDespesasTipo = (DefaultTableModel)tabela_despesasTipo.getModel();
        
        sql = "select * from tb_despesas_tipo where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        PegaDespesasTipo();
        
        if(parametrosNS.bu.nivelUsuario  < 4 | somostra.equals("S"))
            jMenu.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(DesTipoCad   != null)DesTipoCad.dispose();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_cadastroDespesasTipo;
    private javax.swing.JMenuItem bt_detalhes;
    private javax.swing.JMenuItem bt_sair;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable tabela_despesasTipo;
    private javax.swing.JFormattedTextField txt_codigoDespesaTipo;
    private javax.swing.JTextField txt_descricaoDespesaTipo;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
}
