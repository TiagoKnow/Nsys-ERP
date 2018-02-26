package Telas;

import BeansNS.BeanBanco;
import Beans.*;
import FuncoesInternas.*;
import Dao.DaoMySQL;
import Parametros.parametrosNS;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/*
 @author Tiago e Paulo
 */
public class BancosConsulta extends javax.swing.JFrame {
    //Vetores
    ArrayList            parametros = new ArrayList();
    ArrayList<ArrayList> dadosBanco = new ArrayList();
    
    //ints
    int    Linha                = 0;
    
    //Strings
    String sql                  = "";
    String Mensagem             = "";
    String retorno              = "";
    
    //Beas
    BeanBanco           bb      = new BeanBanco();
    
    //Especiais
    DefaultTableModel   Tabela;
    
    //Telas
    
    public BancosConsulta(){
        initComponents();
    }
    
    private void ConsultaBancos(){
        dadosBanco.clear();
        dadosBanco = parametrosNS.dao.Consulta(sql);
        if(dadosBanco.isEmpty())
            return;
        PreencherTabela();
    }
    
    private void PreencherTabela(){
        Tabela.setNumRows(0);
        for(int i = 0; i < dadosBanco.size(); i++){
            bb.idBanco          = Integer.parseInt(  String.valueOf(dadosBanco.get(i).get(0)));
            bb.nomeBanco        =                    String.valueOf(dadosBanco.get(i).get(1));
            bb.codigoBanco      =                    String.valueOf(dadosBanco.get(i).get(2));
            
            Tabela.addRow(new Object [] {String.valueOf(bb.codigoBanco), bb.nomeBanco});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_bancos = new javax.swing.JTable();
        txt_codigoBanco = new javax.swing.JTextField();
        txt_nomeBanco = new javax.swing.JTextField();
        bt_sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bancos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_bancos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_bancos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome do Banco"
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
        tabela_bancos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_bancosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_bancos);
        if (tabela_bancos.getColumnModel().getColumnCount() > 0) {
            tabela_bancos.getColumnModel().getColumn(0).setResizable(false);
            tabela_bancos.getColumnModel().getColumn(1).setPreferredWidth(270);
        }

        txt_codigoBanco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoBancoFocusGained(evt);
            }
        });
        txt_codigoBanco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoBancoKeyReleased(evt);
            }
        });

        txt_nomeBanco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_nomeBancoFocusGained(evt);
            }
        });
        txt_nomeBanco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nomeBancoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nomeBanco)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nomeBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 274, Short.MAX_VALUE)
                        .addComponent(bt_sair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addComponent(bt_sair)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        retorno = "";
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void tabela_bancosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_bancosMouseClicked
        if(evt.getClickCount() < 2)
            return;
        Linha = tabela_bancos.getSelectedRow();
        if(Linha < 0){
            Mensagem = "Item não selecionado!";
            new MostraMensagem(Mensagem);
            return;
        }
        retorno = String.valueOf(tabela_bancos.getValueAt(Linha, 0));
        dispose();
    }//GEN-LAST:event_tabela_bancosMouseClicked

    private void txt_codigoBancoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoBancoKeyReleased
        bb.codigoBanco = txt_codigoBanco.getText();
        if(bb.codigoBanco.equals("")){
            sql = "select * from ns_bancos;";
            ConsultaBancos();
            return;
        }
        sql = "select * from ns_bancos where codigoBanco like '%" + bb.codigoBanco + "%';";
        ConsultaBancos();
    }//GEN-LAST:event_txt_codigoBancoKeyReleased

    private void txt_nomeBancoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nomeBancoKeyReleased
        bb.nomeBanco = txt_nomeBanco.getText();
        if(bb.nomeBanco.equals("")){
            sql = "select * from ns_bancos;";
            ConsultaBancos();
            return;
        }
        sql = "select * from ns_bancos where nomeBanco like '%" + bb.nomeBanco + "%';";
        ConsultaBancos();
    }//GEN-LAST:event_txt_nomeBancoKeyReleased

    private void txt_codigoBancoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoBancoFocusGained
        txt_nomeBanco.setText("");
        sql = "select * from ns_bancos;";
        ConsultaBancos();
    }//GEN-LAST:event_txt_codigoBancoFocusGained

    private void txt_nomeBancoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nomeBancoFocusGained
        txt_codigoBanco.setText("");
        sql = "select * from ns_bancos;";
        ConsultaBancos();
    }//GEN-LAST:event_txt_nomeBancoFocusGained

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Tabela      = (DefaultTableModel)tabela_bancos.getModel();
        sql         = "select * from ns_bancos;";
        ConsultaBancos();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
    }//GEN-LAST:event_formWindowGainedFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_bancos;
    private javax.swing.JTextField txt_codigoBanco;
    private javax.swing.JTextField txt_nomeBanco;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
}
