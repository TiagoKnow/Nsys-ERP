package Telas;

import Beans.BeanUsuarios;
import BeansNS.BeanPais;
import Dao.DaoMySQL;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import FuncoesInternas.*;
import Parametros.parametrosNS;

/*
 @author Tiago e Paulo
 */
public class PaisesConsulta extends javax.swing.JFrame {
    //ArrayList's
    ArrayList            parametros        = new ArrayList();
    ArrayList<ArrayList> dadosPaises       = new ArrayList<ArrayList>();
    
    //int's
    int    Linha                = 0;
    
    //String's
    String sql                  = "";
    String sqlstate             = "";
    String Mensagem             = "";
    String retorno              = "";
    
    //Bean's
    BeanPais            bpais   = new BeanPais();
    
    //Especiais
    DefaultTableModel Tabela;
    FormataCampo      fc    = new FormataCampo();
    
    //Telas
    
    public PaisesConsulta(){
        initComponents();
    }
    
    private void ConsultaPaises(){
        dadosPaises.clear();
        dadosPaises = parametrosNS.dao.Consulta(sql);
        if(dadosPaises.isEmpty())
            return;
        PreencherTabela();
    }
    
    private void PreencherTabela(){
        Tabela.setNumRows(0);
        for(int i = 0; i < dadosPaises.size(); i++){
            bpais.codigoPais = Integer.parseInt(  String.valueOf(dadosPaises.get(i).get(0)));
            bpais.nomePais   =                    String.valueOf(dadosPaises.get(i).get(1));
            
            Tabela.addRow(new Object [] {fc.FormataCampo(String.valueOf(bpais.codigoPais), 4, 0), bpais.nomePais});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_paises = new javax.swing.JTable();
        txt_codigoPais = new javax.swing.JFormattedTextField();
        txt_nomePais = new javax.swing.JTextField();
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
        jLabel1.setText("Países");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_paises.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_paises.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome do Pais"
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
        tabela_paises.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_paisesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_paises);
        if (tabela_paises.getColumnModel().getColumnCount() > 0) {
            tabela_paises.getColumnModel().getColumn(0).setResizable(false);
            tabela_paises.getColumnModel().getColumn(1).setResizable(false);
            tabela_paises.getColumnModel().getColumn(1).setPreferredWidth(270);
        }

        try {
            txt_codigoPais.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoPais.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoPaisFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoPaisFocusLost(evt);
            }
        });
        txt_codigoPais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoPaisKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoPaisKeyReleased(evt);
            }
        });

        txt_nomePais.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_nomePaisFocusGained(evt);
            }
        });
        txt_nomePais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nomePaisKeyReleased(evt);
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
                        .addComponent(txt_codigoPais, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nomePais)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nomePais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(6, 6, 6))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabela_paisesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_paisesMouseClicked
        if(evt.getClickCount() < 2)
            return;
        Linha = tabela_paises.getSelectedRow();
        retorno = String.valueOf(Integer.parseInt(String.valueOf(tabela_paises.getValueAt(Linha, 0))));
        dispose();
    }//GEN-LAST:event_tabela_paisesMouseClicked

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        retorno = "";
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void txt_codigoPaisFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPaisFocusLost
        
    }//GEN-LAST:event_txt_codigoPaisFocusLost

    private void txt_codigoPaisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoPaisKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoPaisKeyPressed

    private void txt_codigoPaisKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoPaisKeyReleased
        if(txt_codigoPais.getText().replace(" ", "").equals("")){
            sql = "select * from ns_paises;";
            ConsultaPaises();
            return;
        }
        bpais.codigoPais = Integer.parseInt(String.valueOf(txt_codigoPais.getText().replace(" ", "")));
        sql = "select * from ns_paises where codigoPaus >= '" + bpais.codigoPais + "';";
        ConsultaPaises();
    }//GEN-LAST:event_txt_codigoPaisKeyReleased

    private void txt_nomePaisKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nomePaisKeyReleased
        if(txt_nomePais.getText().equals("")){
            sql = "select * from ns_paises;";
            ConsultaPaises();
            return;
        }
        bpais.nomePais = txt_nomePais.getText();
        sql = "select * from ns_paises where nomePais like '%" + bpais.nomePais + "%';";
        ConsultaPaises();
    }//GEN-LAST:event_txt_nomePaisKeyReleased

    private void txt_codigoPaisFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPaisFocusGained
        txt_nomePais.setText("");
        sql = "select * from ns_paises;";
        ConsultaPaises();
    }//GEN-LAST:event_txt_codigoPaisFocusGained

    private void txt_nomePaisFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nomePaisFocusGained
        txt_codigoPais.setText("");
        sql = "select * from ns_paises;";
        ConsultaPaises();
    }//GEN-LAST:event_txt_nomePaisFocusGained

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Tabela = (DefaultTableModel)tabela_paises.getModel();
        
        sql = "select * from ns_paises;";
        ConsultaPaises();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
    }//GEN-LAST:event_formWindowGainedFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_paises;
    private javax.swing.JFormattedTextField txt_codigoPais;
    private javax.swing.JTextField txt_nomePais;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
}
