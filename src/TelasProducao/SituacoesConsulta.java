package TelasProducao;

import Beans.*;
import Dao.*;
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
public class SituacoesConsulta extends javax.swing.JFrame {
    //String's
    String sql                      = "";
    String somostra                 = "";
    String retorno                  = "";
    String Mensagem                 = "";
    
    //int's
    int    linha                    = 0;
    int    abriuSituacoes           = 0;
    
    //Vetores
    ArrayList            parametros            = new ArrayList();
    ArrayList            dadosPadroes          = new ArrayList();
    ArrayList<ArrayList> dadosSituacoes        = new ArrayList<ArrayList>();
    
    //Bean's
    BeanSituacoes           bsit    = new BeanSituacoes();
    
    //Especiais
    DefaultTableModel       Table;
    FormataCampo            fc      = new FormataCampo();
    
    //Telas
    SituacoesCadastro       SitCad;
    
    public SituacoesConsulta(ArrayList DadosPadres){
        dadosPadroes        = DadosPadres;
        
        somostra            = (String)  dadosPadroes.get(0);
        
        initComponents();
    }
    
    private void PegaSituacoes(){
        dadosSituacoes.clear();
        dadosSituacoes = parametrosNS.dao.Consulta(sql);
        PreencherTabelaSituacoes();
    }
    
    private void PreencherTabelaSituacoes(){
        Table.setNumRows(0);
        for(int i = 0; i < dadosSituacoes.size(); i++){
            bsit.idSituacao         = Integer.parseInt(  String.valueOf(dadosSituacoes.get(i).get(0)));
            bsit.idEmpresa          = Integer.parseInt(  String.valueOf(dadosSituacoes.get(i).get(1)));
            bsit.codigoGrupo        = Integer.parseInt(  String.valueOf(dadosSituacoes.get(i).get(2)));
            bsit.codigoEmpresa      = Integer.parseInt(  String.valueOf(dadosSituacoes.get(i).get(3)));
            bsit.codigoSituacao     = Integer.parseInt(  String.valueOf(dadosSituacoes.get(i).get(4)));
            bsit.descricaoSituacao  =                    String.valueOf(dadosSituacoes.get(i).get(5));
            
            txt_qtdRegistros.setText(String.valueOf(i + 1));
            
            Table.addRow(new Object [] {fc.FormataCampo(String.valueOf(bsit.codigoSituacao), 3, 0), bsit.descricaoSituacao});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_detalhesItem = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_situacoes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_codigoSituacao = new javax.swing.JFormattedTextField();
        txt_descricaoSituacao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_qtdRegistros = new javax.swing.JTextField();
        bt_sair = new javax.swing.JButton();
        jMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        bt_cadastroSituacoes = new javax.swing.JMenuItem();
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
        setTitle("Consulta Situações");
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

        tabela_situacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição da Situação"
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
        tabela_situacoes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_situacoes.getTableHeader().setReorderingAllowed(false);
        tabela_situacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_situacoesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_situacoes);
        if (tabela_situacoes.getColumnModel().getColumnCount() > 0) {
            tabela_situacoes.getColumnModel().getColumn(0).setResizable(false);
            tabela_situacoes.getColumnModel().getColumn(1).setResizable(false);
            tabela_situacoes.getColumnModel().getColumn(1).setPreferredWidth(280);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consulta Situações");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_codigoSituacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoSituacao.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_codigoSituacao.setText("   ");
        txt_codigoSituacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoSituacaoKeyReleased(evt);
            }
        });

        txt_descricaoSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_descricaoSituacaoActionPerformed(evt);
            }
        });
        txt_descricaoSituacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_descricaoSituacaoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_descricaoSituacao)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_descricaoSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setText("Total de registros:");

        txt_qtdRegistros.setEditable(false);
        txt_qtdRegistros.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        jMenu2.setText("Cadastro");

        bt_cadastroSituacoes.setText("Situações");
        bt_cadastroSituacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastroSituacoesActionPerformed(evt);
            }
        });
        jMenu2.add(bt_cadastroSituacoes);

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
                        .addComponent(txt_qtdRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txt_qtdRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_sair, jLabel2, txt_qtdRegistros});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoSituacaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoSituacaoKeyReleased
        bsit.codigoSituacao = Integer.parseInt(fc.FormataCampo(txt_codigoSituacao.getText(), 3, 0));
        if(bsit.codigoSituacao == 0){
            sql = "select * from tb_situacoes where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaSituacoes();
            return;
        }
        sql = "select * from tb_situacoes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoSituacao >= '" + bsit.codigoSituacao + "';";
        PegaSituacoes();
    }//GEN-LAST:event_txt_codigoSituacaoKeyReleased

    private void txt_descricaoSituacaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descricaoSituacaoKeyReleased
        bsit.descricaoSituacao = txt_descricaoSituacao.getText();
        if(bsit.descricaoSituacao.equals("")){
            sql = "select * from tb_situacoes where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaSituacoes();
            return;
        }
        sql = "select * from tb_situacoes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and descricaoSituacao like '%" + bsit.descricaoSituacao + "%';";
        PegaSituacoes();
    }//GEN-LAST:event_txt_descricaoSituacaoKeyReleased

    private void txt_descricaoSituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_descricaoSituacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descricaoSituacaoActionPerformed

    private void tabela_situacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_situacoesMouseClicked
        linha   = tabela_situacoes.getSelectedRow();
        retorno = String.valueOf(tabela_situacoes.getValueAt(linha, 0));
        if(evt.getButton() == MouseEvent.BUTTON3){
            if(somostra.equalsIgnoreCase("N")){
                MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
        if(evt.getClickCount() < 2)
            return;
        dispose();
    }//GEN-LAST:event_tabela_situacoesMouseClicked

    private void bt_detalhesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesItemActionPerformed
        if(SitCad != null)if(SitCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuSituacoes = 1;
        parametros.clear();
        parametros.add("S");
        parametros.add(Integer.parseInt(retorno));
        SitCad = new SituacoesCadastro(parametros);
        SitCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesItemActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_cadastroSituacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastroSituacoesActionPerformed
        if(SitCad != null)if(SitCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuSituacoes = 1;
        parametros.clear();
        parametros.add("SN");
        parametros.add(0);
        SitCad = new SituacoesCadastro(parametros);
        SitCad.setVisible(true);
    }//GEN-LAST:event_bt_cadastroSituacoesActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuSituacoes == 0)
            return;
        sql = "select * from tb_situacoes where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        PegaSituacoes();
    }//GEN-LAST:event_formWindowGainedFocus

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Table = (DefaultTableModel)tabela_situacoes.getModel();
        
        sql = "select * from tb_situacoes where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        PegaSituacoes();
        
        if(parametrosNS.bu.nivelUsuario  < 4 | somostra.equals("S"))
            jMenu.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(SitCad   != null)SitCad.dispose();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_cadastroSituacoes;
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
    private javax.swing.JTable tabela_situacoes;
    private javax.swing.JFormattedTextField txt_codigoSituacao;
    private javax.swing.JTextField txt_descricaoSituacao;
    private javax.swing.JTextField txt_qtdRegistros;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
}
