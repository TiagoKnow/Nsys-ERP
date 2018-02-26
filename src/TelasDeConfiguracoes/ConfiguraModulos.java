package TelasDeConfiguracoes;

import BeansNS.BeanGrupoEmpresa;
import BeansNS.BeanModulosAcesso;
import Dao.DaoMySQL;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import Main.BarraInicial;
import Main.ProcessoInicial;
import Telas.Login;
import Parametros.parametrosNS;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 @author Tiago e Paulo
 */
public class ConfiguraModulos extends javax.swing.JFrame {
    //Connection's
    Connection con;
    
    //String's
    String sql                      = "";
    String sqlstate                 = "";
    String operacao                 = "";
    String mensagem                 = "";
    
    //int's
    int    coluna                   = 0;
    int    linha                    = 0;
    int    qtdLinhas                = 0;
    
    //Vetores
    ArrayList<ArrayList> dadosModulosAcesso    = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosGrupos           = new ArrayList<ArrayList>();
    
    //Dao's
    
    //Bean's
    BeanGrupoEmpresa        bge     = new BeanGrupoEmpresa();
    BeanModulosAcesso       bma     = new BeanModulosAcesso();
    
    //Telas
    parametrosNS                  Ini;
    BarraInicial            Bar;
    ProcessoInicial         ProIni;
    
    //Especiais
    FormataCampo            fc      = new FormataCampo();
    
    public ConfiguraModulos(){
        operacao        = "I";
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_modulos = new javax.swing.JTable();
        combo_grupo = new javax.swing.JComboBox<>();
        bt_confirma = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Configurar Modulos");
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
        jLabel1.setText("Módulos para Acesso");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_modulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Módulos", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_modulos.setShowVerticalLines(false);
        tabela_modulos.getTableHeader().setReorderingAllowed(false);
        tabela_modulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_modulosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_modulos);
        if (tabela_modulos.getColumnModel().getColumnCount() > 0) {
            tabela_modulos.getColumnModel().getColumn(0).setResizable(false);
            tabela_modulos.getColumnModel().getColumn(0).setPreferredWidth(500);
            tabela_modulos.getColumnModel().getColumn(1).setResizable(false);
        }

        combo_grupo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_grupoItemStateChanged(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_grupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bt_confirma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_confirma.setText("Confirma");
        bt_confirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmaActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_confirma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_confirma, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_confirma, jButton1});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_confirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmaActionPerformed
        PegaValoresModulos();
        if(operacao.equals("I")){
            IncluirRegistro();
            return;
        }
        AlterarRegistro();
    }//GEN-LAST:event_bt_confirmaActionPerformed

    private void tabela_modulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_modulosMouseClicked
        qtdLinhas   = tabela_modulos.getRowCount();
        coluna      = tabela_modulos.getSelectedColumn();
        linha       = tabela_modulos.getSelectedRow();
        if(coluna   != 1)
            return;
        if(linha    != 0){
            tabela_modulos.setValueAt(false, 0, 1);
            return;
        }
        for(int i = 1; i < qtdLinhas; i++)
            if(Boolean.valueOf(String.valueOf(tabela_modulos.getValueAt(linha, coluna))) == false)
                tabela_modulos.setValueAt(false, i, coluna);
            else
                tabela_modulos.setValueAt(true, i, coluna);
    }//GEN-LAST:event_tabela_modulosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Sair();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        SetaNomeModulos();
        PegaGrupos("S");
    }//GEN-LAST:event_formWindowOpened

    private void combo_grupoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_grupoItemStateChanged
        if(combo_grupo.getSelectedIndex() == 0){
            operacao = "I";
            bma.modulosAcesso = fc.FormataCampo("", 14, 0);
            PegaValoresModulos();
            return;
        }
        bge.codigoGrupo = Integer.parseInt(String.valueOf(combo_grupo.getSelectedItem()).substring(0, 2));
        PegaGrupos("N");
    }//GEN-LAST:event_combo_grupoItemStateChanged

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        Sair();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
    }//GEN-LAST:event_formWindowGainedFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_confirma;
    private javax.swing.JMenuItem bt_sair;
    private javax.swing.JComboBox<String> combo_grupo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_modulos;
    // End of variables declaration//GEN-END:variables

    private void mostraMensagem() {
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    private void SetaNomeModulos(){
        tabela_modulos.setValueAt("Geral                ", 0, 0);
        tabela_modulos.setValueAt("Faturamento          ", 1, 0);
        tabela_modulos.setValueAt("Vendas               ", 2, 0);
        tabela_modulos.setValueAt("Estoque              ", 3, 0);
        tabela_modulos.setValueAt("Contábil             ", 4, 0);
        tabela_modulos.setValueAt("Fiscal               ", 5, 0);
        tabela_modulos.setValueAt("Contas à Receber     ", 6, 0);
        tabela_modulos.setValueAt("Contas à Pagar       ", 7, 0);
        tabela_modulos.setValueAt("Produção             ", 8, 0);
        tabela_modulos.setValueAt("Gestão Administrativa", 9, 0);
        tabela_modulos.setValueAt("Compras              ",10, 0);
        tabela_modulos.setValueAt("Recebimento          ",11, 0);
        tabela_modulos.setValueAt("CRM                  ",12, 0);
        tabela_modulos.setValueAt("ContasCorrentes      ",13, 0);
        tabela_modulos.setValueAt("Recursos Humanos     ",14, 0);
    }
    
    private void PegaGrupos(String Add){
        sql = "select codigoGrupo, nomeGrupo, limiteUsuarios from ns_grupoempresa where codigoGrupo = " + bge.codigoGrupo + ";";
        if(Add.equals("S")){
            sql = "select codigoGrupo, nomeGrupo, limiteUsuarios from ns_grupoempresa;";
            combo_grupo.removeAllItems();
            combo_grupo.addItem("----------");
        }
        dadosGrupos.clear();
        dadosGrupos = parametrosNS.dao.Consulta(sql);
        if(dadosGrupos.isEmpty()){
            mensagem = "Não existe Grupos cadastrados!";
            mostraMensagem();
            return;
        }
        PegaDadosGrupos(Add);
    }
    
    private void PegaDadosGrupos(String Add){
        for(int i = 0; i < dadosGrupos.size(); i++){
            bge.codigoGrupo             = Integer.parseInt( String.valueOf(dadosGrupos.get(i).get(0)));
            bge.nomeGrupo               =                   String.valueOf(dadosGrupos.get(i).get(1));
            bge.limiteUsuarios          = Integer.parseInt( String.valueOf(dadosGrupos.get(i).get(2)));
            
            if(Add.equals("S"))
                combo_grupo.addItem(fc.FormataCampo(String.valueOf(bge.codigoGrupo), 2, 0) + "-" + bge.nomeGrupo);
        }
        if(Add.equals("N"))
            PegaModulosAcesso();
    }
    
    private void PegaModulosAcesso(){
        bma.codigoGrupo     = bge.codigoGrupo;
        sql = "select modulosAcesso from ns_modulos_acesso where codigoGrupo = " + bma.codigoGrupo + ";";
        dadosModulosAcesso.clear();
        dadosModulosAcesso = parametrosNS.dao.Consulta(sql);
        if(dadosModulosAcesso.isEmpty()){
//            mensagem = "Não foram encontrados Módulos de Acesso para o grupo: " + bge.nomeGrupo + "!";
//            mostraMensagem();
            return;
        }
        operacao = "A";
        PegaDadosModulosAcesso();
    }
    
    private void PegaDadosModulosAcesso(){
        for(int i = 0; i < dadosModulosAcesso.size(); i++)
            bma.modulosAcesso           = String.valueOf(dadosModulosAcesso.get(i).get(0));
        RecarregaModulos();
    }
    
    private void RecarregaModulos(){
        qtdLinhas = tabela_modulos.getRowCount();
        for(int linha = 1; linha < qtdLinhas; linha++)
            if(bma.modulosAcesso.substring(linha - 1, linha).equals("1"))
                tabela_modulos.setValueAt(true, linha, 1);
            else
                tabela_modulos.setValueAt(false, linha, 1);
    }
    
    private void PegaValoresModulos(){
        qtdLinhas   = tabela_modulos.getRowCount();
        bma.modulosAcesso = "";
        for(int i = 1; i < qtdLinhas; i++){
            if(Boolean.valueOf(String.valueOf(tabela_modulos.getValueAt(i, 1))) == false){
                bma.modulosAcesso   = bma.modulosAcesso + "0";
            }else{
                bma.modulosAcesso   = bma.modulosAcesso + "1";
            }
        }
    }

    private void IncluirRegistro(){
        sql = "insert into ns_modulos_acesso (codigoGrupo, ModulosAcesso) values (" + bma.codigoGrupo + ", '" + bma.modulosAcesso + "');";
        
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equalsIgnoreCase("00000"))
            return;
        mensagem = "Registro Incluído com Sucesso!";
        mostraMensagem();
        combo_grupo.setSelectedIndex(0);
    }
    
    private void AlterarRegistro(){
        sql = "update ns_modulos_acesso set ModulosAcesso = '"       + bma.modulosAcesso + "' " +
                                                          "where codigoGrupo = "    + bma.codigoGrupo   + ";";
        
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equalsIgnoreCase("00000"))
            return;
        mensagem = "Registro Alterado com Sucesso!";
        mostraMensagem();
        combo_grupo.setSelectedIndex(0);
    }
    
    private void Sair(){
        dispose();
        Bar     = new BarraInicial();
        ProIni  = new ProcessoInicial(Bar);
    }
    
}
