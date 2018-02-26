package TelasDeConfiguracoes;

import BeansNS.BeanGrupoEmpresa;
import BeansNS.BeanEmpresas;
import Dao.DaoMySQL;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import FuncoesInternas.*;
import Parametros.parametrosNS;
import java.sql.Connection;

/*
 @author Paulo e Tiago
 */
public class EmpresasConsulta extends javax.swing.JFrame {
    //String's
    String sql                      = "";
    String Mensagem                 = "";
    String retorno                  = "";
    String Fatal                    = "";
    String ValorFormatado           = "";
    
    //int's
    int    Linha                    = 0;
    
    //ArrayList's
    ArrayList            parametros            = new ArrayList();
//    ArrayList            dadosPadroes          = new ArrayList();
    ArrayList<ArrayList> dadosEmpresas         = new ArrayList<ArrayList>();
    
    //Bean's
    BeanGrupoEmpresa        bge     = new BeanGrupoEmpresa();
    BeanEmpresas            be      = new BeanEmpresas();
    
    //Especiais
    FormataCampo            fc      = new FormataCampo();
    DefaultTableModel       Table;
    
    //Telas
    
    public EmpresasConsulta(int CodigoGrupo){
        bge.codigoGrupo = CodigoGrupo;
        
        initComponents();
    }
    
    private void PesquisaEmpresas(){
        sql = "select * from ns_empresas where codigoGrupo = " + bge.codigoGrupo + ";";
        dadosEmpresas.clear();
        dadosEmpresas = parametrosNS.dao.Consulta(sql);
        if(dadosEmpresas.isEmpty())
            return;
        PegaDadosEmpresas();
    }
    
    private void PegaDadosEmpresas(){
        for(int i = 0; i < dadosEmpresas.size(); i++){
            be.codigoGrupo      = Integer.parseInt(  String.valueOf(dadosEmpresas.get(i).get(1)));
            be.codigoEmpresa    = Integer.parseInt(  String.valueOf(dadosEmpresas.get(i).get(2)));
            be.nomeEmpresa      =                    String.valueOf(dadosEmpresas.get(i).get(4));
            be.nomeFantasia     =                    String.valueOf(dadosEmpresas.get(i).get(5));
            
            Table.addRow(new Object[] {fc.FormataCampo(String.valueOf(bge.codigoGrupo), 2, 0) + "." +  fc.FormataCampo(String.valueOf(be.codigoEmpresa), 3, 0) + " - " + be.nomeEmpresa});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_empresas = new javax.swing.JTable();
        bt_sair = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair1 = new javax.swing.JMenuItem();

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
        jLabel1.setText("Consulta de Empresas");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_empresas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Empresa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_empresas.getTableHeader().setReorderingAllowed(false);
        tabela_empresas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_empresasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_empresas);
        if (tabela_empresas.getColumnModel().getColumnCount() > 0) {
            tabela_empresas.getColumnModel().getColumn(0).setResizable(false);
            tabela_empresas.getColumnModel().getColumn(0).setPreferredWidth(250);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        bt_sair1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        bt_sair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair1.setText("Sair");
        bt_sair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sair1ActionPerformed(evt);
            }
        });
        jMenu1.add(bt_sair1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bt_sair)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void tabela_empresasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_empresasMouseClicked
        if(evt.getClickCount() < 2)
            return;
        Linha   = tabela_empresas.getSelectedRow();
        if(Linha < 0){
            Mensagem = "Item não selecionado!";
            new MostraMensagem(Mensagem);
            return;
        }
        retorno = String.valueOf(Integer.parseInt(String.valueOf(tabela_empresas.getValueAt(Linha, 0)).substring(3, 6)));
        dispose();
    }//GEN-LAST:event_tabela_empresasMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Table = (DefaultTableModel)tabela_empresas.getModel();
        PesquisaEmpresas();
    }//GEN-LAST:event_formWindowOpened

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
    }//GEN-LAST:event_formWindowGainedFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_empresas;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
}
