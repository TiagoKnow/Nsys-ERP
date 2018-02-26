package TelasContabil;

import BeansNS.BeanEmpresas;
import BeansNS.BeanGrupoEmpresa;
import Beans.BeanPlanoReferencial;
import Beans.BeanUsuarios;
import Dao.DaoMySQL;
import FuncoesInternas.ExportarParaExcel;
import FuncoesInternas.MostraMensagem;
import Parametros.parametrosNS;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
/*
 @author Tiago e Paulo
 */
public class PlanoReferencialConsulta extends javax.swing.JFrame {
    //int's
    int    Linha                                = 0;
    int    abriuPlanoReferencial                = 0;
    
    //String's
    String sql                                  = "";
    String sqlstate                             = "";
    String Mensagem                             = "";
    String somostra                             = "";
    String retorno                              = "";
    
    //Vetores
    ArrayList            parametros                    = new ArrayList();
    ArrayList            dadosPadroes                  = new ArrayList();
    ArrayList<ArrayList> dadosPlanoReferencial         = new ArrayList<ArrayList>();
    ArrayList            dadosUsuarios                 = new ArrayList();
    
    //Bean's
    BeanGrupoEmpresa                bge     = new BeanGrupoEmpresa();
    BeanPlanoReferencial            bpref   = new BeanPlanoReferencial();
    BeanUsuarios                    bu      = new BeanUsuarios();
    
    //Especiais para Excportação em Excel
    JFileChooser                    SeletorExcel;
    String                          NomeArquivoExcel    = "";
    String                          LocalArquivo        = "";
    int                             SalvarExcel         = 0;
    
    //Especiais
    DefaultTableModel               TablePlanoReferencial;
    
    //Telas
    PlanoReferencialCadastro        PlaRefCad;
    
    public PlanoReferencialConsulta(ArrayList DadosPadroes){
        dadosPadroes                        = DadosPadroes;
        
        somostra                            = (String)  dadosPadroes.get(0);
        
        initComponents();
    }
    
    private void PegaPlanoReferencial(){
        dadosPlanoReferencial.clear();
        dadosPlanoReferencial = parametrosNS.dao.Consulta(sql);
        PegaDadosPlanoReferencial();
    }
    
    private void PegaDadosPlanoReferencial(){
        tabela_plano_referencial.getColumnModel().getColumn(0).setResizable(false);
        tabela_plano_referencial.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabela_plano_referencial.getColumnModel().getColumn(1).setPreferredWidth(800);
        tabela_plano_referencial.getColumnModel().getColumn(2).setResizable(false);
        tabela_plano_referencial.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabela_plano_referencial.getColumnModel().getColumn(3).setResizable(false);
        tabela_plano_referencial.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabela_plano_referencial.getColumnModel().getColumn(4).setResizable(false);
        tabela_plano_referencial.getColumnModel().getColumn(4).setPreferredWidth(75);
        tabela_plano_referencial.getColumnModel().getColumn(5).setPreferredWidth(1500);
        
        TablePlanoReferencial.setNumRows(0);
        for(int i = 0; i < dadosPlanoReferencial.size(); i++){
            if(dadosPlanoReferencial.get(i).get(0)  != null){bpref.idPlanoReferencial                = Integer.parseInt(  String.valueOf(dadosPlanoReferencial.get(i).get(0)));}
            if(dadosPlanoReferencial.get(i).get(1)  != null){bpref.codigoGrupo                       = Integer.parseInt(  String.valueOf(dadosPlanoReferencial.get(i).get(1)));}
            if(dadosPlanoReferencial.get(i).get(2)  != null){bpref.codigoPlanoReferencial            =                    String.valueOf(dadosPlanoReferencial.get(i).get(2));}
            if(dadosPlanoReferencial.get(i).get(3)  != null){bpref.descricaoPlanoReferencial         =                    String.valueOf(dadosPlanoReferencial.get(i).get(3));}
            if(dadosPlanoReferencial.get(i).get(4)  != null){bpref.dataInicial                       =                    String.valueOf(dadosPlanoReferencial.get(i).get(4));}
            if(dadosPlanoReferencial.get(i).get(5)  != null){bpref.dataFinal                         =                    String.valueOf(dadosPlanoReferencial.get(i).get(5));}
            if(dadosPlanoReferencial.get(i).get(6)  != null){bpref.tipoPlanoReferencial              =                    String.valueOf(dadosPlanoReferencial.get(i).get(6));}
            if(dadosPlanoReferencial.get(i).get(7)  != null){bpref.codigoPlanoReferencialSuperior    =                    String.valueOf(dadosPlanoReferencial.get(i).get(7));}
            if(dadosPlanoReferencial.get(i).get(8)  != null){bpref.nivel                             = Integer.parseInt(  String.valueOf(dadosPlanoReferencial.get(i).get(8)));}
            if(dadosPlanoReferencial.get(i).get(9)  != null){bpref.natureza                          = Integer.parseInt(  String.valueOf(dadosPlanoReferencial.get(i).get(9)));}
            if(dadosPlanoReferencial.get(i).get(10) != null){bpref.orientacoes                       =                    String.valueOf(dadosPlanoReferencial.get(i).get(10));}
            
            if(check_ativo      .isSelected() == true)if(Integer.parseInt(bpref.codigoPlanoReferencial.substring(0, 1)) != 1)continue;
            if(check_passivo    .isSelected() == true)if(Integer.parseInt(bpref.codigoPlanoReferencial.substring(0, 1)) != 2)continue;
            if(check_resultado  .isSelected() == true)if(Integer.parseInt(bpref.codigoPlanoReferencial.substring(0, 1)) != 3)continue;
            
            if(combo_tipoDeConta.getSelectedIndex() == 1)if(!bpref.tipoPlanoReferencial.equals("S"))continue;
            if(combo_tipoDeConta.getSelectedIndex() == 2)if(!bpref.tipoPlanoReferencial.equals("A"))continue;
            
            switch(bpref.tipoPlanoReferencial){
                case "A": bpref.tipoPlanoReferencial        = "Analítica";break;
                case "S": bpref.tipoPlanoReferencial        = "Sintética";
                          bpref.descricaoPlanoReferencial   = bpref.descricaoPlanoReferencial.toUpperCase();break;
            }
            
            TablePlanoReferencial.addRow(new Object[] {bpref.codigoPlanoReferencial, bpref.descricaoPlanoReferencial.toUpperCase(), bpref.tipoPlanoReferencial, bpref.codigoPlanoReferencialSuperior, bpref.nivel, bpref.orientacoes.toUpperCase()});
        }
        if(tabela_plano_referencial.getRowCount() > 0)
            bt_exportar.setEnabled(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        MenuPopup = new javax.swing.JPopupMenu();
        bt_detalhes = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_plano_referencial = new javax.swing.JTable();
        check_ativo = new javax.swing.JRadioButton();
        check_passivo = new javax.swing.JRadioButton();
        check_resultado = new javax.swing.JRadioButton();
        combo_tipoDeConta = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        check_todas = new javax.swing.JRadioButton();
        txt_codigoPlanoReferencial = new javax.swing.JTextField();
        txt_descricaoPlanoReferencial = new javax.swing.JTextField();
        bt_sair = new javax.swing.JButton();
        bt_exportar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_cadastroPlanoReferencial = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        bt_sair1 = new javax.swing.JMenuItem();

        bt_detalhes.setText("Detalhes");
        bt_detalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_detalhesActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_detalhes);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Plano Referencial");
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
        jLabel1.setText("Planos Referenciais");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_plano_referencial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_plano_referencial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Tipo de Conta", "Conta Superior", "Nível", "Orientações"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_plano_referencial.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_plano_referencial.getTableHeader().setReorderingAllowed(false);
        tabela_plano_referencial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_plano_referencialMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_plano_referencial);
        if (tabela_plano_referencial.getColumnModel().getColumnCount() > 0) {
            tabela_plano_referencial.getColumnModel().getColumn(0).setResizable(false);
            tabela_plano_referencial.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabela_plano_referencial.getColumnModel().getColumn(1).setResizable(false);
            tabela_plano_referencial.getColumnModel().getColumn(2).setResizable(false);
            tabela_plano_referencial.getColumnModel().getColumn(3).setResizable(false);
            tabela_plano_referencial.getColumnModel().getColumn(4).setResizable(false);
            tabela_plano_referencial.getColumnModel().getColumn(5).setResizable(false);
        }

        buttonGroup1.add(check_ativo);
        check_ativo.setText("Ativo");
        check_ativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_ativoActionPerformed(evt);
            }
        });

        buttonGroup1.add(check_passivo);
        check_passivo.setText("Passivo");
        check_passivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_passivoActionPerformed(evt);
            }
        });

        buttonGroup1.add(check_resultado);
        check_resultado.setText("Resultado Líquido do Período");
        check_resultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_resultadoActionPerformed(evt);
            }
        });

        combo_tipoDeConta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ambas", "Sintética", "Analítica" }));
        combo_tipoDeConta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_tipoDeContaItemStateChanged(evt);
            }
        });

        jLabel2.setText("Tipo de Conta:");

        buttonGroup1.add(check_todas);
        check_todas.setSelected(true);
        check_todas.setText("Todas");
        check_todas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_todasActionPerformed(evt);
            }
        });

        txt_codigoPlanoReferencial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoPlanoReferencialKeyReleased(evt);
            }
        });

        txt_descricaoPlanoReferencial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_descricaoPlanoReferencialKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(check_ativo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(check_passivo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(check_resultado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(check_todas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_tipoDeConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_codigoPlanoReferencial, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_descricaoPlanoReferencial)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(check_ativo)
                    .addComponent(check_passivo)
                    .addComponent(check_resultado)
                    .addComponent(combo_tipoDeConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(check_todas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoPlanoReferencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_descricaoPlanoReferencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {check_ativo, check_passivo, check_resultado, combo_tipoDeConta, jLabel2});

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        bt_exportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Table.png"))); // NOI18N
        bt_exportar.setText("Exportar");
        bt_exportar.setEnabled(false);
        bt_exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_exportarActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        bt_cadastroPlanoReferencial.setText("Cadastro Plano Referencial");
        bt_cadastroPlanoReferencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastroPlanoReferencialActionPerformed(evt);
            }
        });
        jMenu1.add(bt_cadastroPlanoReferencial);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bt_exportar)
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
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_exportar, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_exportar, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void check_ativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_ativoActionPerformed
        PegaPlanoReferencial();
    }//GEN-LAST:event_check_ativoActionPerformed

    private void check_passivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_passivoActionPerformed
        PegaPlanoReferencial();
    }//GEN-LAST:event_check_passivoActionPerformed

    private void check_resultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_resultadoActionPerformed
        PegaPlanoReferencial();
    }//GEN-LAST:event_check_resultadoActionPerformed

    private void check_todasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_todasActionPerformed
        PegaPlanoReferencial();
    }//GEN-LAST:event_check_todasActionPerformed

    private void combo_tipoDeContaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_tipoDeContaItemStateChanged
        PegaPlanoReferencial();
    }//GEN-LAST:event_combo_tipoDeContaItemStateChanged

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void tabela_plano_referencialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_plano_referencialMouseClicked
        Linha = tabela_plano_referencial.getSelectedRow();
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
        retorno = String.valueOf(tabela_plano_referencial.getValueAt(Linha, 0)).replace(".", "");
        if(evt.getClickCount() < 2)
            return;
        dispose();
    }//GEN-LAST:event_tabela_plano_referencialMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        TablePlanoReferencial   = (DefaultTableModel)tabela_plano_referencial.getModel();
        if(parametrosNS.bu.nivelUsuario < 4){
            bt_cadastroPlanoReferencial.setVisible(false);
            jSeparator1.setVisible(false);
        }
        
        sql = "select * from ns_plano_referencial where codigoGrupo = 0 or codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " order by codigoPlanoReferencial asc;";
        PegaPlanoReferencial();
    }//GEN-LAST:event_formWindowOpened

    private void txt_codigoPlanoReferencialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoPlanoReferencialKeyReleased
        bpref.codigoPlanoReferencial = txt_codigoPlanoReferencial.getText().replace(".", "");
        if(bpref.codigoPlanoReferencial.equals("")){
            sql = "select * from ns_plano_referencial order by codigoPlanoReferencial asc;";
            PegaPlanoReferencial();
            return;
        }
        sql = "select * from ns_plano_referencial where replace(codigoPlanoReferencial, '.', '') like '%" + bpref.codigoPlanoReferencial + "%' and codigoGrupo = 0 or codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " order by codigoPlanoReferencial asc;";
        PegaPlanoReferencial();
    }//GEN-LAST:event_txt_codigoPlanoReferencialKeyReleased

    private void txt_descricaoPlanoReferencialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descricaoPlanoReferencialKeyReleased
        bpref.descricaoPlanoReferencial = txt_descricaoPlanoReferencial.getText();
        if(bpref.descricaoPlanoReferencial.equals("")){
            sql = "select * from ns_plano_referencial order by codigoPlanoReferencial asc;";
            PegaPlanoReferencial();
            return;
        }
        sql = "select * from ns_plano_referencial where descricaoPlanoReferencial like '%" + bpref.descricaoPlanoReferencial + "%' and codigoGrupo = 0 or codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " order by codigoPlanoReferencial asc;";
        PegaPlanoReferencial();
    }//GEN-LAST:event_txt_descricaoPlanoReferencialKeyReleased

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_exportarActionPerformed
        SeletorExcel = new JFileChooser();
        SalvarExcel = SeletorExcel.showSaveDialog(tabela_plano_referencial);
        if(SalvarExcel != JFileChooser.APPROVE_OPTION)
            return;
        NomeArquivoExcel    = SeletorExcel.getSelectedFile().getName();
        LocalArquivo        = SeletorExcel.getSelectedFile().getParentFile().getPath();
        String Extensao = "";
        if(NomeArquivoExcel.length() > 4){
            Extensao = NomeArquivoExcel.substring(NomeArquivoExcel.length() - 4, NomeArquivoExcel.length());
        }
        if(Extensao.equals(".xls")) {
            LocalArquivo = LocalArquivo + "/" + NomeArquivoExcel;
        }else{
            LocalArquivo = LocalArquivo + "/" + NomeArquivoExcel + ".xls";
        }
        try {
            new ExportarParaExcel(tabela_plano_referencial, new File(LocalArquivo), 0, 0, 0);
        } catch (IOException erro) {
            Mensagem = "Erro: " + erro.getMessage();
            new MostraMensagem(Mensagem);
        }
    }//GEN-LAST:event_bt_exportarActionPerformed

    private void bt_cadastroPlanoReferencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastroPlanoReferencialActionPerformed
        if(PlaRefCad != null)if(PlaRefCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuPlanoReferencial = 1;
        parametros.clear();
        parametros.add("SN");
        parametros.add("");
        PlaRefCad = new PlanoReferencialCadastro(parametros);
        PlaRefCad.setVisible(true);
    }//GEN-LAST:event_bt_cadastroPlanoReferencialActionPerformed

    private void bt_detalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesActionPerformed
        if(PlaRefCad != null)if(PlaRefCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("S");
        parametros.add(retorno);
        PlaRefCad = new PlanoReferencialCadastro(parametros);
        PlaRefCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
        if(abriuPlanoReferencial == 0)
            return;
        abriuPlanoReferencial = 0;
        sql = "select * from ns_plano_referencial order by codigoPlanoReferencial asc;";
        PegaPlanoReferencial();
    }//GEN-LAST:event_formWindowGainedFocus

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(PlaRefCad    != null)PlaRefCad.dispose();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_cadastroPlanoReferencial;
    private javax.swing.JMenuItem bt_detalhes;
    private javax.swing.JButton bt_exportar;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton check_ativo;
    private javax.swing.JRadioButton check_passivo;
    private javax.swing.JRadioButton check_resultado;
    private javax.swing.JRadioButton check_todas;
    private javax.swing.JComboBox<String> combo_tipoDeConta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable tabela_plano_referencial;
    private javax.swing.JTextField txt_codigoPlanoReferencial;
    private javax.swing.JTextField txt_descricaoPlanoReferencial;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
}
