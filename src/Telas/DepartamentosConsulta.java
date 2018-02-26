package Telas;

import Dao.*;
import Beans.*;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import Parametros.parametrosNS;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
/*
 @author Tiago e Paulo
 */
public class DepartamentosConsulta extends javax.swing.JFrame {
    //String's
    String sql                          = "";
    String sqlstate                     = "";
    String Mensagem                     = "";
    String retorno                      = "";
    String somostra                     = "";
    
    //int's
    int    Linha                        = 0;
    int    User                         = 0;
    
    //Vetores
    ArrayList            parametros                = new ArrayList();
    ArrayList            dadosPadroes              = new ArrayList();
    ArrayList<ArrayList> dadosDepartamentos        = new ArrayList<ArrayList>();
    
    //Bean's
    BeanDepartamento        bd          = new BeanDepartamento();
    
    //Especiais
    DefaultTableModel       Table;
    FormataCampo            fc          = new FormataCampo();
    
    //Telas
    DepartamentosCadastro       CadDep;
    
    public DepartamentosConsulta(String SoMostra){
        somostra = SoMostra;
        
        initComponents();
    }
    
    private void PegaDepartamento(){
        dadosDepartamentos.clear();
        dadosDepartamentos = parametrosNS.dao.Consulta(sql);
        PegaDadosDepartamento();
    }
    
    private void PegaDadosDepartamento(){
        Table.setNumRows(0);
        for(int i = 0; i < dadosDepartamentos.size(); i++){
            bd = new BeanDepartamento();
            bd.idDepartamento           = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(0)));
            bd.idEmpresa                = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(1)));
            bd.codigoGrupo              = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(2)));
            bd.codigoEmpresa            = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(3)));
            bd.codigoDepartamento       = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(4)));
            bd.descricaoDepartamento    =                    String.valueOf(dadosDepartamentos.get(i).get(5));
            
            Table.addRow(new Object [] {fc.FormataCampo(String.valueOf(bd.codigoDepartamento), 2, 0), bd.descricaoDepartamento});
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
        tabela_departamentos = new javax.swing.JTable();
        txt_codigo = new javax.swing.JTextField();
        txt_descricao = new javax.swing.JTextField();
        bt_sair = new javax.swing.JButton();

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
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Departamentos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_departamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Departamento"
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
        tabela_departamentos.getTableHeader().setReorderingAllowed(false);
        tabela_departamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_departamentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_departamentos);
        if (tabela_departamentos.getColumnModel().getColumnCount() > 0) {
            tabela_departamentos.getColumnModel().getColumn(0).setResizable(false);
            tabela_departamentos.getColumnModel().getColumn(1).setResizable(false);
            tabela_departamentos.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        txt_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoKeyReleased(evt);
            }
        });

        txt_descricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_descricaoKeyReleased(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_descricao)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_sair)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_sair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoKeyReleased
        if(txt_codigo.getText().replace(" ", "").equals("")){
            sql = "select * from tb_departamento where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaDepartamento();
            return;
        }
        sql = "select * from tb_departamento where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoDepartamento >= '" + txt_codigo.getText() + "';";
        PegaDepartamento();
    }//GEN-LAST:event_txt_codigoKeyReleased

    private void txt_descricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descricaoKeyReleased
        if(txt_descricao.getText().replace(" ", "").equals("")){
            sql = "select * from tb_departamento where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaDepartamento();
            return;
        }
        bd.descricaoDepartamento = txt_descricao.getText();
        sql = "select * from tb_departamento where idEmpresa = " + parametrosNS.be.IdEmpresa + " and descricaoDepartamento like '%" + bd.descricaoDepartamento + "%';";
        PegaDepartamento();
    }//GEN-LAST:event_txt_descricaoKeyReleased

    private void tabela_departamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_departamentosMouseClicked
        Linha   = tabela_departamentos.getSelectedRow();
        if(Linha < 0){
            Mensagem = "Item não selecionado!";
            new MostraMensagem(Mensagem);
            return;
        }
        if(evt.getButton() == MouseEvent.BUTTON3)
            if(somostra.equalsIgnoreCase("N"))
                MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
        retorno = String.valueOf(Integer.parseInt(String.valueOf(tabela_departamentos.getValueAt(Linha, 0))));
        if(evt.getClickCount() < 2)
            return;
        dispose();
    }//GEN-LAST:event_tabela_departamentosMouseClicked

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_detalhesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesItemActionPerformed
        parametros.clear();
        parametros.add("S");
        parametros.add("");
        parametros.add(Integer.parseInt(retorno));
        CadDep = new DepartamentosCadastro(parametros);
        CadDep.setVisible(true);
    }//GEN-LAST:event_bt_detalhesItemActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Table = (DefaultTableModel)tabela_departamentos.getModel();
        sql = "select * from tb_departamento where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(sqlstate.equals("42S02")){
            dispose();
            return;
        }
        PegaDepartamento();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
    }//GEN-LAST:event_formWindowGainedFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_detalhesItem;
    private javax.swing.JButton bt_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_departamentos;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_descricao;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
}
