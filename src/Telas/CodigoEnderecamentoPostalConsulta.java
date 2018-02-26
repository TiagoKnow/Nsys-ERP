package Telas;

import BeansNS.BeanCEP;
import Beans.*;
import Dao.DaoMySQL;
import FuncoesInternas.*;
import Parametros.parametrosNS;
import java.awt.event.*;
import java.sql.Connection;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/*
 @author Paulo
 */
public class CodigoEnderecamentoPostalConsulta extends javax.swing.JFrame {
    //String's
    String sql                  = "";
    String sqlstate             = "";
    String retorno              = "";
    
    //int's
    int    qtdRegistros         = 0;
    int    linha                = 0;
    
    //Vetores
    ArrayList<ArrayList> dadosCEP           = new ArrayList<ArrayList>();
    
    //Bean's
    BeanCEP             bcep    = new BeanCEP();
    
    //Outros
    DefaultTableModel   Table;
    
    //Especiais
    FormataCampo        fc      = new FormataCampo();
    
    //Telas
    
    public CodigoEnderecamentoPostalConsulta(){
        initComponents();
    }
    
    private void SQLPadrao(){
        PegaQtdRegistros();
        sql = "select * from ns_cep limit " + qtdRegistros + ";";
        PegaCep();
    }
    
    private void PegaCep(){
        dadosCEP.clear();
        dadosCEP = parametrosNS.dao.Consulta(sql);
        PreencherTabelaCEP();
    }
    
    private void PreencherTabelaCEP(){
        Table.setNumRows(0);
        for(int i = 0; i < dadosCEP.size(); i++){
            bcep.cep        = String.valueOf(dadosCEP.get(i).get(0));
            bcep.endereco   = String.valueOf(dadosCEP.get(i).get(1));
            bcep.cidade     = String.valueOf(dadosCEP.get(i).get(2));
            bcep.bairro     = String.valueOf(dadosCEP.get(i).get(3));
            bcep.uf         = String.valueOf(dadosCEP.get(i).get(4));
            
            Table.addRow(new Object [] {bcep.cep, bcep.endereco, bcep.cidade, bcep.bairro, bcep.uf});
        }
    }
    
    private void PegaQtdRegistros(){
        qtdRegistros = Integer.parseInt(txt_qtdRegistros.getText());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_cep = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_cep = new javax.swing.JFormattedTextField();
        txt_endereco = new javax.swing.JTextField();
        txt_cidade = new javax.swing.JTextField();
        txt_bairro = new javax.swing.JTextField();
        txt_qtdRegistros = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bt_sair = new javax.swing.JButton();
        bt_processa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Código de Enderecamento Postal");
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

        tabela_cep.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_cep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CEP", "Endereço", "Cidade", "Bairro", "UF"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_cep.getTableHeader().setReorderingAllowed(false);
        tabela_cep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_cepMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_cep);
        if (tabela_cep.getColumnModel().getColumnCount() > 0) {
            tabela_cep.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabela_cep.getColumnModel().getColumn(1).setPreferredWidth(350);
            tabela_cep.getColumnModel().getColumn(2).setPreferredWidth(150);
            tabela_cep.getColumnModel().getColumn(3).setResizable(false);
            tabela_cep.getColumnModel().getColumn(3).setPreferredWidth(150);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Código de Enderecamento Postal");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try{
            txt_cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cep.setText("     -   ");
        txt_cep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cepKeyReleased(evt);
            }
        });

        txt_endereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_enderecoKeyReleased(evt);
            }
        });

        txt_cidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cidadeKeyReleased(evt);
            }
        });

        txt_bairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_bairroKeyReleased(evt);
            }
        });

        try {
            txt_qtdRegistros.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_qtdRegistros.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_qtdRegistros.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_qtdRegistrosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_qtdRegistrosFocusLost(evt);
            }
        });

        jLabel2.setText("Mostrar os");

        jLabel3.setText("primeiros registros");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_qtdRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 65, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(txt_qtdRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3, txt_qtdRegistros});

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        bt_processa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/1280454766_system-software-update.png"))); // NOI18N
        bt_processa.setText("Processa");
        bt_processa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_processaActionPerformed(evt);
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
                        .addComponent(bt_processa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_sair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_sair)
                    .addComponent(bt_processa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cepKeyReleased
        bcep.cep = txt_cep.getText();
        bcep.cep = bcep.cep.replace(" ", "");
        bcep.cep = bcep.cep.replace("-", "");
        if(bcep.cep.equals("")){
            SQLPadrao();
            return;
        }
        PegaQtdRegistros();
        sql = "select * from ns_cep where cep >= " + bcep.cep + " limit " + qtdRegistros + ";";
        PegaCep();
    }//GEN-LAST:event_txt_cepKeyReleased

    private void txt_qtdRegistrosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_qtdRegistrosFocusLost
        txt_qtdRegistros.setText(fc.FormataCampo(txt_qtdRegistros.getText(), 6, 0));
        if(Integer.parseInt(txt_qtdRegistros.getText()) == 0)
            txt_qtdRegistros.setText(fc.FormataCampo("100", 6, 0));
        PegaQtdRegistros();
    }//GEN-LAST:event_txt_qtdRegistrosFocusLost

    private void txt_cidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cidadeKeyReleased
        bcep.cidade = txt_cidade.getText();
        if(bcep.cidade.equals("")){
            SQLPadrao();
            return;
        }
        PegaQtdRegistros();
        sql = "select * from ns_cep where cidade like '%" + bcep.cidade + "%' limit " + qtdRegistros + ";";
        PegaCep();
    }//GEN-LAST:event_txt_cidadeKeyReleased

    private void txt_enderecoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_enderecoKeyReleased
        bcep.endereco = txt_endereco.getText();
        if(bcep.endereco.equals("")){
            SQLPadrao();
            return;
        }
        PegaQtdRegistros();
        sql = "select * from ns_cep where endereco like '%" + bcep.endereco + "%' limit " + qtdRegistros + ";";
        PegaCep();
    }//GEN-LAST:event_txt_enderecoKeyReleased

    private void txt_bairroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_bairroKeyReleased
        bcep.bairro = txt_bairro.getText();
        if(bcep.bairro.equals("")){
            SQLPadrao();
            return;
        }
        PegaQtdRegistros();
        sql = "select * from ns_cep where bairro like '%" + bcep.bairro + "%' limit " + qtdRegistros + ";";
        PegaCep();
    }//GEN-LAST:event_txt_bairroKeyReleased

    private void tabela_cepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_cepMouseClicked
        if(evt.getClickCount() < 2)
            return;
        linha = tabela_cep.getSelectedRow();
        retorno = String.valueOf(tabela_cep.getValueAt(linha, 0)).replace("-", "");
        dispose();
    }//GEN-LAST:event_tabela_cepMouseClicked

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_processaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_processaActionPerformed
        SQLPadrao();
    }//GEN-LAST:event_bt_processaActionPerformed

    private void txt_qtdRegistrosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_qtdRegistrosFocusGained
        txt_qtdRegistros.setText("");
    }//GEN-LAST:event_txt_qtdRegistrosFocusGained

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Table = (DefaultTableModel)tabela_cep.getModel();
        txt_qtdRegistros.setText(fc.FormataCampo("100", 6, 0));
        SQLPadrao();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
    }//GEN-LAST:event_formWindowGainedFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_processa;
    private javax.swing.JButton bt_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_cep;
    private javax.swing.JTextField txt_bairro;
    private javax.swing.JFormattedTextField txt_cep;
    private javax.swing.JTextField txt_cidade;
    private javax.swing.JTextField txt_endereco;
    private javax.swing.JFormattedTextField txt_qtdRegistros;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
}
