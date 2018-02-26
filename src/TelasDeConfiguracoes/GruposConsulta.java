package TelasDeConfiguracoes;

import BeansNS.BeanGrupoEmpresa;
import Dao.DaoMySQL;
import FuncoesInternas.*;
import Parametros.parametrosNS;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/*
 @author Tiago e Paulo
 */
public class GruposConsulta extends javax.swing.JFrame {
    //int's
    int   linha                             = 0;
    
    //String's
    String valorLeitura                     = "";
    String retorno                          = "";
    String texto                            = "";
    String Mensagem                         = "";
    String sql                              = "";
    String fatal                            = "N";
    
    //ArrayList's
    ArrayList<ArrayList> dadosGrupos        = new ArrayList<ArrayList>();
    
    //Bean's
    BeanGrupoEmpresa                bge     = new BeanGrupoEmpresa();
    
    //Especiais
    DefaultTableModel               Table;
    FormataCampo                    fc      = new FormataCampo();
    
    //Telas
    
    public GruposConsulta(){
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_grupo = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair = new javax.swing.JMenuItem();

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

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consulta de Grupos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_grupo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabela_grupo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Grupo", "Nome do Grupo"
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
        tabela_grupo.setShowVerticalLines(false);
        tabela_grupo.getTableHeader().setReorderingAllowed(false);
        tabela_grupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_grupoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_grupo);
        if (tabela_grupo.getColumnModel().getColumnCount() > 0) {
            tabela_grupo.getColumnModel().getColumn(0).setResizable(false);
            tabela_grupo.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabela_grupo.getColumnModel().getColumn(1).setResizable(false);
            tabela_grupo.getColumnModel().getColumn(1).setPreferredWidth(250);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jMenu1.setText("Arquivo");

        bt_sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });
        jMenu1.add(bt_sair);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Table = (DefaultTableModel)tabela_grupo.getModel();
        PegaGrupoEmpresa();
    }//GEN-LAST:event_formWindowOpened

    private void tabela_grupoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_grupoMouseClicked
        if(evt.getClickCount() < 2)
            return;
        linha = tabela_grupo.getSelectedRow();
        
        retorno = String.valueOf(Integer.parseInt(String.valueOf(tabela_grupo.getValueAt(linha, 0))));
        dispose();
    }//GEN-LAST:event_tabela_grupoMouseClicked

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
    }//GEN-LAST:event_formWindowGainedFocus
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem bt_sair;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_grupo;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
    private void PegaGrupoEmpresa(){
        sql = "select codigoGrupo, nomeGrupo, limiteUsuarios from ns_grupoempresa;";
        dadosGrupos.clear();
        dadosGrupos = parametrosNS.dao.Consulta(sql);
        if(dadosGrupos.isEmpty()){
            Mensagem = "Não existem Grupos Cadastrados!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        PegaDadosGrupoEmpresa();
    }
    
    public void PegaDadosGrupoEmpresa(){
        for(int i = 0; i < dadosGrupos.size(); i++){
            bge.codigoGrupo             = Integer.parseInt( String.valueOf(dadosGrupos.get(i).get(0)));
            bge.nomeGrupo               =                   String.valueOf(dadosGrupos.get(i).get(1));
            bge.limiteUsuarios          = Integer.parseInt( String.valueOf(dadosGrupos.get(i).get(2)));
            
            Table.addRow(new Object[] {fc.FormataCampo(String.valueOf(bge.codigoGrupo), 2, 0), bge.nomeGrupo});
        }
    }
    
}
