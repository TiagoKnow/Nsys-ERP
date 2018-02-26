package TelasFaturamento;

import Beans.*;
import Dao.DaoMySQL;
import java.sql.*;
import java.text.*;
import java.util.*;
import FuncoesInternas.*;
import Parametros.parametrosNS;
import java.awt.event.MouseEvent;
import javax.swing.table.*;

/*
 @author Tiago e Paulo
 */
public class ManutencoesConsulta extends javax.swing.JFrame {
    //ArrayList's
    ArrayList parametros        = new ArrayList();
    ArrayList dadosPadroes      = new ArrayList();
    ArrayList dadosManutencao   = new ArrayList();
    
    //int's
    int    linha    = 0;
    
    //String's
    String sql      = "";
    String sqlstate = "";
    String Mensagem = "";
    String somostra = "";
    String retorno  = "";
    
    //Bean's
    BeanManutencoes                 bman    = new BeanManutencoes();
    BeanUsuarios                    bu      = new BeanUsuarios();
    
    //Especiais
    DefaultTableModel Tabela;
    
    //Especiais
    FormataCampo                    fc          = new FormataCampo();
    TransformaValorStringeDouble    TransStrDou = new TransformaValorStringeDouble();
    
    //Telas
    ManutencoesCadastro             ManCad;
    
    public ManutencoesConsulta(ArrayList DadosPadroes){
        dadosPadroes                    = DadosPadroes;
        
        somostra                        = (String)  dadosPadroes.get(0);
        
        initComponents();
    }
    
    private void PegaManutencoes(){
        dadosManutencao.clear();
        dadosManutencao = parametrosNS.dao.ConsultaManutencoes(sql);
        PreencherTabela();
    }
    
    private void PreencherTabela(){
        Tabela.setNumRows(0);
        for(int i = 0; i < dadosManutencao.size(); i++){
            bman.codigoManutencao     = ((BeanManutencoes)(dadosManutencao.get(i))).codigoManutencao;
            bman.descricaoManutencao  = ((BeanManutencoes)(dadosManutencao.get(i))).descricaoManutencao;
            bman.valorManutencao      = ((BeanManutencoes)(dadosManutencao.get(i))).valorManutencao;
            
            Tabela.addRow(new Object [] {fc.FormataCampo(String.valueOf(bman.codigoManutencao), 3, 0), bman.descricaoManutencao, TransStrDou.TransformaValorStringeDouble(String.valueOf(bman.valorManutencao), 0)});
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
        Tabela_Manutencao = new javax.swing.JTable();
        txt_codigoManutencao = new javax.swing.JFormattedTextField();
        txt_descricaoManutencao = new javax.swing.JTextField();
        bt_sair = new javax.swing.JButton();

        bt_detalhesItem.setText("Detalhes");
        bt_detalhesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_detalhesItemActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_detalhesItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Código Manuteção");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manuteções");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Tabela_Manutencao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Manutenção", "Valor da Manutenção"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        Tabela_Manutencao.getTableHeader().setReorderingAllowed(false);
        Tabela_Manutencao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabela_ManutencaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabela_Manutencao);
        if (Tabela_Manutencao.getColumnModel().getColumnCount() > 0) {
            Tabela_Manutencao.getColumnModel().getColumn(0).setResizable(false);
            Tabela_Manutencao.getColumnModel().getColumn(0).setPreferredWidth(20);
            Tabela_Manutencao.getColumnModel().getColumn(1).setResizable(false);
            Tabela_Manutencao.getColumnModel().getColumn(1).setPreferredWidth(200);
            Tabela_Manutencao.getColumnModel().getColumn(2).setResizable(false);
        }

        try {
            txt_codigoManutencao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoManutencao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoManutencaoKeyReleased(evt);
            }
        });

        txt_descricaoManutencao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_descricaoManutencaoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoManutencao, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_descricaoManutencao, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoManutencao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_descricaoManutencao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_sair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        retorno = "";
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void Tabela_ManutencaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabela_ManutencaoMouseClicked
        linha = Tabela_Manutencao.getSelectedRow();
        if(linha < 0){
            Mensagem = "Item não selecionado!";
            new MostraMensagem(Mensagem);
            return;
        }
        retorno = String.valueOf(Tabela_Manutencao.getValueAt(linha, 0));
        if(evt.getButton() == MouseEvent.BUTTON3){
            if(somostra.equals("N")){
                MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
        if(evt.getClickCount() < 2)
            return;
        dispose();
    }//GEN-LAST:event_Tabela_ManutencaoMouseClicked

    private void bt_detalhesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesItemActionPerformed
        if(ManCad != null)if(ManCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("S");
        parametros.add(Integer.parseInt(retorno));
        ManCad = new ManutencoesCadastro(parametros);
        ManCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesItemActionPerformed

    private void txt_codigoManutencaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoManutencaoKeyReleased
        if(txt_codigoManutencao.getText().replace(" ", "").equals("")){
            sql = "select * from tb_codigomanutencoes;";
            PegaManutencoes();
            return;
        }
        bman.codigoManutencao       = Integer.parseInt(txt_codigoManutencao.getText().replace(" ", ""));
        sql = "select * from tb_codigomanutencoes where codigoManutencao >= " + bman.codigoManutencao + ";";
        PegaManutencoes();
    }//GEN-LAST:event_txt_codigoManutencaoKeyReleased

    private void txt_descricaoManutencaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descricaoManutencaoKeyReleased
        bman.descricaoManutencao    = txt_descricaoManutencao.getText();
        if(bman.descricaoManutencao.equals("")){
            sql = "select * from tb_codigomanutencoes;";
            PegaManutencoes();
            return;
        }
        sql = "select * from tb_codigomanutencoes where descricaoManutencao like '%" + bman.descricaoManutencao + "%';";
        PegaManutencoes();
    }//GEN-LAST:event_txt_descricaoManutencaoKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Tabela = (DefaultTableModel)Tabela_Manutencao.getModel();
        sql = "select * from tb_codigomanutencoes;";
        PegaManutencoes();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(ManCad   != null)ManCad.dispose();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JTable Tabela_Manutencao;
    private javax.swing.JMenuItem bt_detalhesItem;
    private javax.swing.JButton bt_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField txt_codigoManutencao;
    private javax.swing.JTextField txt_descricaoManutencao;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
}
