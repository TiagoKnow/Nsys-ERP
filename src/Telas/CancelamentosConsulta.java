package Telas;

import Beans.BeanCancelamentos;
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
public class CancelamentosConsulta extends javax.swing.JFrame {
    //String's
    String sql      = "";
    String Mensagem = "";
    String somostra = "";
    String retorno  = "";
    
    //int's
    int    linha         = 0;
    int    abriuCadDeCan = 0;
    
    //Vetores
    ArrayList            parametros                = new ArrayList();
//    ArrayList            dadosPadroes              = new ArrayList();
    ArrayList<ArrayList> dadosCancelamentos        = new ArrayList<ArrayList>();
    
    //Bean's
    BeanCancelamentos bcan    = new BeanCancelamentos();
    
    //Especiais
    FormataCampo      fc      = new FormataCampo();
    DefaultTableModel Table;
    
    //Telas
    CancelamentosCadastro CadCanVen;
    CancelamentosCadastro CadDeCan;
    
    public CancelamentosConsulta(String Somostra){
        somostra                        = Somostra;
        
        initComponents();
    }
    
    private void PegaCancelamentos(){
        linha = 0;
        dadosCancelamentos.clear();
        dadosCancelamentos = parametrosNS.dao.Consulta(sql);
        PegaDadosCancelamentos();
    }
    
    private void PegaDadosCancelamentos(){
        Table.setNumRows(0);
        for(int i = 0; i < dadosCancelamentos.size(); i++){
            bcan.idCancelamento         = Integer.parseInt(  String.valueOf(dadosCancelamentos.get(i).get(0)));
            bcan.idEmpresa              = Integer.parseInt(  String.valueOf(dadosCancelamentos.get(i).get(1)));
            bcan.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosCancelamentos.get(i).get(2)));
            bcan.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosCancelamentos.get(i).get(3)));
            bcan.codigoCancelamento     = Integer.parseInt(  String.valueOf(dadosCancelamentos.get(i).get(4)));
            bcan.descricaoCancelamento  =                    String.valueOf(dadosCancelamentos.get(i).get(5));
            
            Table.addRow(new Object [] {fc.FormataCampo(String.valueOf(bcan.codigoCancelamento), 2, 0), bcan.descricaoCancelamento});
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
        tabela_cancelamento = new javax.swing.JTable();
        txt_codigoCancelamento = new javax.swing.JFormattedTextField();
        txt_descricaoCancelamento = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        bt_detalhes.setText("Detalhes");
        bt_detalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_detalhesActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_detalhes);

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
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consulta Motivos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_cancelamento.setModel(new javax.swing.table.DefaultTableModel(
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
        tabela_cancelamento.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_cancelamento.setShowHorizontalLines(false);
        tabela_cancelamento.getTableHeader().setReorderingAllowed(false);
        tabela_cancelamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_cancelamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_cancelamento);
        if (tabela_cancelamento.getColumnModel().getColumnCount() > 0) {
            tabela_cancelamento.getColumnModel().getColumn(0).setResizable(false);
            tabela_cancelamento.getColumnModel().getColumn(1).setResizable(false);
            tabela_cancelamento.getColumnModel().getColumn(1).setPreferredWidth(350);
        }

        try {
            txt_codigoCancelamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoCancelamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoCancelamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoCancelamentoKeyReleased(evt);
            }
        });

        txt_descricaoCancelamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_descricaoCancelamentoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoCancelamento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_descricaoCancelamento)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoCancelamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_descricaoCancelamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
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

        jMenuItem1.setText("Motivos de Cancelamentos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenu1.add(jMenu2);

        jMenu.add(jMenu1);

        setJMenuBar(jMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabela_cancelamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_cancelamentoMouseClicked
        linha   = tabela_cancelamento.getSelectedRow();
        if(linha < 0){
            Mensagem = "Item não selecionado!";
            new MostraMensagem(Mensagem);
            return;
        }
        linha = linha + 1;
        if(evt.getButton() == MouseEvent.BUTTON3){
            if(somostra.equalsIgnoreCase("S"))
                return;
            MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
            return;
        }
        if(evt.getClickCount() > 1){
            retorno = String.valueOf(Integer.parseInt(String.valueOf(tabela_cancelamento.getValueAt(linha - 1, 0))));
            dispose();
        }
    }//GEN-LAST:event_tabela_cancelamentoMouseClicked

    private void bt_detalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesActionPerformed
        if(CadCanVen != null)if(CadCanVen.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        if(linha == 0){
            Mensagem = "Item não selecionado!";
            new MostraMensagem(Mensagem);
            return;
        }
        linha = linha - 1;
        bcan.codigoCancelamento = Integer.parseInt(String.valueOf(tabela_cancelamento.getValueAt(linha, 0)));
        CadCanVen = new CancelamentosCadastro("S", bcan.codigoCancelamento);
        CadCanVen.setVisible(true);
    }//GEN-LAST:event_bt_detalhesActionPerformed

    private void txt_codigoCancelamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoCancelamentoKeyReleased
        if(txt_codigoCancelamento.getText().replace(" ", "").equals("")){
            sql = "select * from tb_cancelamento where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaCancelamentos();
            return;
        }
        bcan.codigoCancelamento = Integer.parseInt(txt_codigoCancelamento.getText().replace(" ", ""));
        sql = "select * from tb_cancelamento where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCancelamento >= '" + bcan.codigoCancelamento + "';";
        PegaCancelamentos();
    }//GEN-LAST:event_txt_codigoCancelamentoKeyReleased

    private void txt_descricaoCancelamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descricaoCancelamentoKeyReleased
        bcan.descricaoCancelamento  = txt_descricaoCancelamento.getText();
        if(bcan.descricaoCancelamento.equals("")){
            sql = "select * from tb_cancelamento where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaCancelamentos();
            return;
        }
        sql = "select * from tb_cancelamento where idEmpresa = " + parametrosNS.be.IdEmpresa + " and descricaoCancelamento like '%" + bcan.descricaoCancelamento + "%';";
        PegaCancelamentos();
    }//GEN-LAST:event_txt_descricaoCancelamentoKeyReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(CadDeCan != null)if(CadDeCan.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuCadDeCan = 1;
        CadDeCan = new CancelamentosCadastro("SN", 0);
        CadDeCan.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Table   = (DefaultTableModel)tabela_cancelamento.getModel();
        
        sql     = "select * from tb_cancelamento where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        PegaCancelamentos();
        
        if(parametrosNS.bu.nivelUsuario  < 4 | somostra.equals("S"))
            jMenu.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
        if(abriuCadDeCan == 0)
            return;
        sql     = "select * from tb_cancelamento where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        PegaCancelamentos();
    }//GEN-LAST:event_formWindowGainedFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_detalhes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_cancelamento;
    private javax.swing.JFormattedTextField txt_codigoCancelamento;
    private javax.swing.JTextField txt_descricaoCancelamento;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
}
