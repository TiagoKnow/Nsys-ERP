package TelasVendas;

import BeansNS.BeanEmpresas;
import Beans.*;
import Dao.*;
import FuncoesInternas.*;
import TelasDeConfiguracoes.*;
import Parametros.parametrosNS;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;

/*
 @author Tiago e Paulo
 */
public class FormasDePagamentoConsulta extends javax.swing.JFrame {
    //String's
    String sql                              = "";
    String retorno                          = "";
    String somostra                         = "";
    String sqlstate                         = "";
    String Mensagem                         = "";
    
    //int's
    int    Linha                            = 0;
    int    QtdRegistros                     = 0;
    
    //Vetorees
    ArrayList            parametros                  = new ArrayList();
//    ArrayList            dadosPadroes                = new ArrayList();
    ArrayList<ArrayList> dadosFormasPagamentos       = new ArrayList<ArrayList> ();
    
    //Bean's
    BeanFormasPagamentos            bfp     = new BeanFormasPagamentos();
    BeanUsuarios                    bu      = new BeanUsuarios();
    
    //Especiais
    FormataCampo                    fc      = new FormataCampo();
    DefaultTableModel               Table;
    
    //Telas
    FormasDePagamentoCadastro       ForDePagCad;
    
    public FormasDePagamentoConsulta(String Somostra){
        somostra    = Somostra;
        
        initComponents();
    }
    
    private void PegaPagamentos(){
        dadosFormasPagamentos.clear();
        dadosFormasPagamentos = parametrosNS.dao.Consulta(sql);
        PreencherTabela();
    }
    
    private void PreencherTabela(){
        Table.setNumRows(0);
        QtdRegistros = 0;
        for(int i = 0; i < dadosFormasPagamentos.size(); i++){
            bfp = new BeanFormasPagamentos();
            bfp.idPagamento             = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(0)));
            bfp.idEmpresa               = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(1)));
            bfp.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(2)));
            bfp.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(3)));
            bfp.codigoPagamento         = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(4)));
            bfp.descricaoPagamento      =                    String.valueOf(dadosFormasPagamentos.get(i).get(5));
            
            QtdRegistros = i + 1;
            
            Table.addRow(new Object [] {fc.FormataCampo(String.valueOf(bfp.codigoPagamento), 2, 0), bfp.descricaoPagamento});
        }
        txt_quantidadeRegistros.setText(String.valueOf(QtdRegistros));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_detalhesItem = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_formasPagamentos = new javax.swing.JTable();
        txt_codigoPagamento = new javax.swing.JTextField();
        txt_descricaoPagamento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_quantidadeRegistros = new javax.swing.JTextField();
        bt_sair = new javax.swing.JButton();
        jMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        bt_cadastroFormasDePagamentos = new javax.swing.JMenuItem();
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
        jLabel1.setText("Formas de Pagamentos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_formasPagamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descricão"
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
        tabela_formasPagamentos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_formasPagamentos.getTableHeader().setReorderingAllowed(false);
        tabela_formasPagamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_formasPagamentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_formasPagamentos);
        if (tabela_formasPagamentos.getColumnModel().getColumnCount() > 0) {
            tabela_formasPagamentos.getColumnModel().getColumn(0).setResizable(false);
            tabela_formasPagamentos.getColumnModel().getColumn(1).setResizable(false);
            tabela_formasPagamentos.getColumnModel().getColumn(1).setPreferredWidth(225);
        }

        txt_codigoPagamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoPagamentoKeyReleased(evt);
            }
        });

        txt_descricaoPagamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_descricaoPagamentoKeyReleased(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_descricaoPagamento)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_descricaoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jLabel2.setText("Registros");

        txt_quantidadeRegistros.setEditable(false);
        txt_quantidadeRegistros.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_quantidadeRegistros.setEnabled(false);

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        jMenu2.setText("Cadastro");

        bt_cadastroFormasDePagamentos.setText("Formas de Pagamentos");
        bt_cadastroFormasDePagamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastroFormasDePagamentosActionPerformed(evt);
            }
        });
        jMenu2.add(bt_cadastroFormasDePagamentos);

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_quantidadeRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jLabel2)
                    .addComponent(txt_quantidadeRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_sair, jLabel2, txt_quantidadeRegistros});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoPagamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoPagamentoKeyReleased
        if(txt_codigoPagamento.getText().equals("")){
            sql = "select* from tb_formaspagamentos where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaPagamentos();
            return;
        }
        sql = "select* from tb_formaspagamentos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoPagamento >= '" + txt_codigoPagamento.getText() + "';";
        PegaPagamentos();
    }//GEN-LAST:event_txt_codigoPagamentoKeyReleased

    private void txt_descricaoPagamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descricaoPagamentoKeyReleased
        bfp.descricaoPagamento = txt_descricaoPagamento.getText();
        if(bfp.descricaoPagamento.equals("")){
            sql = "select* from tb_formaspagamentos where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaPagamentos();
            return;
        }
        sql = "select* from tb_formaspagamentos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and descricaoPagamento like '%" + bfp.descricaoPagamento + "%';";
        PegaPagamentos();
    }//GEN-LAST:event_txt_descricaoPagamentoKeyReleased

    private void tabela_formasPagamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_formasPagamentosMouseClicked
        Linha = tabela_formasPagamentos.getSelectedRow();
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
        retorno = String.valueOf(tabela_formasPagamentos.getValueAt(Linha, 0));
        if(evt.getClickCount() < 2)
            return;
        dispose();
    }//GEN-LAST:event_tabela_formasPagamentosMouseClicked

    private void bt_detalhesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesItemActionPerformed
        if(ForDePagCad != null)if(ForDePagCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        ForDePagCad = new FormasDePagamentoCadastro("S", Integer.parseInt(retorno));
        ForDePagCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesItemActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_cadastroFormasDePagamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastroFormasDePagamentosActionPerformed
        if(ForDePagCad != null)if(ForDePagCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        ForDePagCad = new FormasDePagamentoCadastro("SN", 0);
        ForDePagCad.setVisible(true);
    }//GEN-LAST:event_bt_cadastroFormasDePagamentosActionPerformed

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Table   = (DefaultTableModel)tabela_formasPagamentos.getModel();
        
        sql = "select* from tb_formaspagamentos where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        PegaPagamentos();
        if(parametrosNS.bu.nivelUsuario  < 4 | somostra.equals("S"))
            jMenu.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(ForDePagCad  != null)ForDePagCad.dispose();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_cadastroFormasDePagamentos;
    private javax.swing.JMenuItem bt_detalhesItem;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable tabela_formasPagamentos;
    private javax.swing.JTextField txt_codigoPagamento;
    private javax.swing.JTextField txt_descricaoPagamento;
    private javax.swing.JTextField txt_quantidadeRegistros;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
}
