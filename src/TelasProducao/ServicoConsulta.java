package TelasProducao;

import Beans.*;
import Dao.*;
import FuncoesInternas.*;
import BeansNS.BeanEmpresas;
import Parametros.parametrosNS;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.*;
import java.text.*;
import javax.swing.*;
import javax.swing.table.*;

/*
 @author Tiago e Paulo
 */
public class ServicoConsulta extends javax.swing.JFrame {
    //String's
    String sql                      = "";
    String sqlstate                 = "";
    String Mensagem                 = "";
    String converte                 = "";
    String somostra                 = "";
    String retorno                  = "";
    
    //int
    int    linha                    = 0;
    int    abriuServico             = 0;
    
    //Vetores
    ArrayList            parametros            = new ArrayList();
    ArrayList            dadosPadroes          = new ArrayList();
    ArrayList<ArrayList> dadosServicos         = new ArrayList<ArrayList>();
    
    //Bean's
    BeanServicos            bser    = new BeanServicos();
    
    //Especiais
    FormataCampo                    fc          = new FormataCampo();
    TransformaValorStringeDouble    TransStrDou = new TransformaValorStringeDouble();
    DefaultTableModel               Table;
    
    //Teals
    ServicoCadastro     SerCad;
    
    public ServicoConsulta(ArrayList DadosPadroes){
        dadosPadroes = DadosPadroes;
        
        somostra            = (String)  dadosPadroes.get(0);
        
        initComponents();
    }
    
    private void PegaServicos(){
        dadosServicos.clear();
        dadosServicos = parametrosNS.dao.Consulta(sql);
        PreencherTabela();
    }
    
    private void PreencherTabela(){
        Table.setNumRows(0);
        String valorServico = "";
        for(int i = 0; i < dadosServicos.size(); i++){
            if(dadosServicos.get(i).get(0) != null)
                bser.idServico          = Integer.parseInt(  String.valueOf(dadosServicos.get(i).get(0)));
            if(dadosServicos.get(i).get(1) != null)
                bser.idEmpresa          = Integer.parseInt(  String.valueOf(dadosServicos.get(i).get(1)));
            if(dadosServicos.get(i).get(2) != null)
                bser.codigoGrupo        = Integer.parseInt(  String.valueOf(dadosServicos.get(i).get(2)));
            if(dadosServicos.get(i).get(3) != null)
                bser.codigoEmpresa      = Integer.parseInt(  String.valueOf(dadosServicos.get(i).get(3)));
            if(dadosServicos.get(i).get(4) != null)
                bser.codigoServico      = Integer.parseInt(  String.valueOf(dadosServicos.get(i).get(4)));
                bser.descricaoServico   =                    String.valueOf(dadosServicos.get(i).get(5));
            if(dadosServicos.get(i).get(6) != null)
                bser.valorServico       = Double.parseDouble(String.valueOf(dadosServicos.get(i).get(6)));
            
            if(bser.valorServico != 0)
                valorServico = TransStrDou.TransformaValorStringeDouble(String.valueOf(bser.valorServico), 0);
            
            txt_registros.setText(String.valueOf(i + 1));
            
            Table.addRow(new Object [] {fc.FormataCampo(String.valueOf(bser.codigoServico), 6, 0), bser.descricaoServico, valorServico});
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
        tabela_servicos = new javax.swing.JTable();
        txt_descricaoServico = new javax.swing.JTextField();
        txt_valorServico = new javax.swing.JTextField();
        txt_codigoServico = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_registros = new javax.swing.JTextField();
        bt_sair = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
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
        setResizable(false);
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
        jLabel1.setText("Serviços");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_servicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição do Serviço", "Valor do Serviço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_servicos.setAutoResizeMode(tabela_servicos.AUTO_RESIZE_OFF);
        tabela_servicos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_servicos.getTableHeader().setReorderingAllowed(false);
        tabela_servicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_servicosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_servicos);
        if (tabela_servicos.getColumnModel().getColumnCount() > 0) {
            tabela_servicos.getColumnModel().getColumn(0).setResizable(false);
            tabela_servicos.getColumnModel().getColumn(1).setResizable(false);
            tabela_servicos.getColumnModel().getColumn(1).setPreferredWidth(225);
            tabela_servicos.getColumnModel().getColumn(2).setResizable(false);
            tabela_servicos.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        txt_descricaoServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_descricaoServicoKeyReleased(evt);
            }
        });

        txt_valorServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_valorServicoKeyReleased(evt);
            }
        });

        try {
            txt_codigoServico.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoServicoKeyReleased(evt);
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
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoServico, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_descricaoServico, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_valorServico)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_descricaoServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_valorServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setText("Registros: ");

        txt_registros.setEnabled(false);

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        jMenu2.setText("Cadastro");

        jMenuItem1.setText("Serviços");
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

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

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
                        .addComponent(txt_registros, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jLabel2)
                    .addComponent(txt_registros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_sair, jLabel2, txt_registros});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabela_servicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_servicosMouseClicked
        linha   = tabela_servicos.getSelectedRow();
        retorno = String.valueOf(Integer.parseInt(String.valueOf(tabela_servicos.getValueAt(linha, 0))));
        if(evt.getButton() == MouseEvent.BUTTON3){
            if(somostra.equalsIgnoreCase("N")){
                MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
        if(evt.getClickCount() < 2)
            return;
        dispose();
    }//GEN-LAST:event_tabela_servicosMouseClicked

    private void bt_detalhesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesItemActionPerformed
        if(SerCad != null)if(SerCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        SerCad = new ServicoCadastro("S", Integer.parseInt(retorno));
        SerCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesItemActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Table = (DefaultTableModel)tabela_servicos.getModel();
        
        sql = "select * from tb_servicos where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        PegaServicos();
    }//GEN-LAST:event_formWindowOpened

    private void txt_codigoServicoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoServicoKeyReleased
        if(txt_codigoServico.getText().replace(" ", "").equals("")){
            sql = "select * from tb_servicos where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaServicos();
            return;
        }
        bser.codigoServico      = Integer.parseInt(txt_codigoServico.getText().replace(" ", ""));
        sql = "select * from tb_servicos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoServico >= " + bser.codigoServico + ";";
        PegaServicos();
    }//GEN-LAST:event_txt_codigoServicoKeyReleased

    private void txt_descricaoServicoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descricaoServicoKeyReleased
        bser.descricaoServico   = txt_descricaoServico.getText();
        if(bser.descricaoServico.equals("")){
            sql = "select * from tb_servicos where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaServicos();
            return;
        }
        sql = "select * from tb_servicos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and descricaoServico like '%" + bser.descricaoServico + "%';";
        PegaServicos();
    }//GEN-LAST:event_txt_descricaoServicoKeyReleased

    private void txt_valorServicoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valorServicoKeyReleased
        String ValorServico     = txt_descricaoServico.getText();
        if(ValorServico.equals("")){
            sql = "select * from tb_servicos where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaServicos();
            return;
        }
        sql = "select * from tb_servicos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and valorServico like '%" + ValorServico + "%';";
        PegaServicos();
    }//GEN-LAST:event_txt_valorServicoKeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(SerCad   != null)SerCad.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(SerCad != null)if(SerCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuServico = 1;
        SerCad = new ServicoCadastro("SN", 0);
        SerCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuServico == 0){
            return;
        }
        abriuServico = 0;
        sql = "select * from tb_servicos where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        PegaServicos();
    }//GEN-LAST:event_formWindowGainedFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_detalhesItem;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable tabela_servicos;
    private javax.swing.JFormattedTextField txt_codigoServico;
    private javax.swing.JTextField txt_descricaoServico;
    private javax.swing.JTextField txt_registros;
    private javax.swing.JTextField txt_valorServico;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
}
