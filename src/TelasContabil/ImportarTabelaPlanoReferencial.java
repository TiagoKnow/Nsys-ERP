package TelasContabil;

import Beans.BeanPlanoReferencial;
import Dao.DaoMySQL;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.InverterData;
import FuncoesInternas.LerArquivoExcel;
import FuncoesInternas.MostraMensagem;
import Parametros.parametrosNS;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import jxl.read.biff.BiffException;

/*
 @author Tiago e Paulo
 */
public class ImportarTabelaPlanoReferencial extends javax.swing.JFrame {
    //String's
    String sql                                  = "";
    String sqlstate                             = "";
    String Mensagem                             = "";
    String Texto                                = "";
    
    //int's
    int    User                                 = 0;
    
    //Vetores
    ArrayList dadosPlanilha                     = new ArrayList();
    
    //Bean's
    BeanPlanoReferencial                bpref   = new BeanPlanoReferencial();
    
    //Especiais
    LerArquivoExcel                     Lae     = new LerArquivoExcel();
    FormataCampo                        fc      = new FormataCampo();
    InverterData                        invdata = new InverterData();
    DefaultTableModel                   TablePlanoReferencial;
    
    //File
    JFileChooser    Seletor                     = new JFileChooser();
    File            ArquivoPasta;
    
    //Telas
    
    public ImportarTabelaPlanoReferencial(){
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_nomeDoArquivo = new javax.swing.JTextField();
        bt_pesquisardiretorio = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_plano_referencial = new javax.swing.JTable();
        bt_processa = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Importar Tabela de Plano Referencial");
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Importar Tabela de Plano Referencial");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Pasta:");

        txt_nomeDoArquivo.setEditable(false);

        bt_pesquisardiretorio.setText("...");
        bt_pesquisardiretorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisardiretorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_nomeDoArquivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_pesquisardiretorio, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nomeDoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisardiretorio, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisardiretorio, jLabel2, txt_nomeDoArquivo});

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Dados do Excel");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_plano_referencial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_plano_referencial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Data Inicial", "Data Final", "Tipo de Conta", "Conta Superior", "Nível", "Natureza", "Orientacoes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_plano_referencial.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_plano_referencial.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_plano_referencial.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabela_plano_referencial);
        if (tabela_plano_referencial.getColumnModel().getColumnCount() > 0) {
            tabela_plano_referencial.getColumnModel().getColumn(0).setResizable(false);
            tabela_plano_referencial.getColumnModel().getColumn(1).setResizable(false);
            tabela_plano_referencial.getColumnModel().getColumn(2).setResizable(false);
            tabela_plano_referencial.getColumnModel().getColumn(3).setResizable(false);
            tabela_plano_referencial.getColumnModel().getColumn(4).setResizable(false);
            tabela_plano_referencial.getColumnModel().getColumn(5).setResizable(false);
            tabela_plano_referencial.getColumnModel().getColumn(6).setResizable(false);
            tabela_plano_referencial.getColumnModel().getColumn(7).setResizable(false);
            tabela_plano_referencial.getColumnModel().getColumn(8).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addGap(13, 13, 13))
        );

        bt_processa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/1280454766_system-software-update.png"))); // NOI18N
        bt_processa.setText("Processar");
        bt_processa.setEnabled(false);
        bt_processa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_processaActionPerformed(evt);
            }
        });

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_processa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_sair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_processa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_processa, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_pesquisardiretorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisardiretorioActionPerformed
        Seletor = new JFileChooser("C:/");
        Seletor.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = Seletor.showOpenDialog(null);
        if(i == 1){
            return;
        }
        ArquivoPasta = Seletor.getSelectedFile();
        if(ArquivoPasta.getPath().equals(""))
            return;
        bt_processa.setEnabled(false);
        txt_nomeDoArquivo.setText(ArquivoPasta.getPath());
        dadosPlanilha = Lae.LerArquivoExcel(ArquivoPasta.getPath());
        PegaDadosPlanilha();
    }//GEN-LAST:event_bt_pesquisardiretorioActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_processaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_processaActionPerformed
        PegaDadosPlanoReferencial();
    }//GEN-LAST:event_bt_processaActionPerformed

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        TablePlanoReferencial   = (DefaultTableModel)tabela_plano_referencial.getModel();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
    }//GEN-LAST:event_formWindowGainedFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_pesquisardiretorio;
    private javax.swing.JButton bt_processa;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_plano_referencial;
    private javax.swing.JTextField txt_nomeDoArquivo;
    // End of variables declaration//GEN-END:variables
    
    private void PegaDadosPlanilha(){
        tabela_plano_referencial.getColumnModel().getColumn(0).setResizable(false);
        tabela_plano_referencial.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabela_plano_referencial.getColumnModel().getColumn(1).setPreferredWidth(800);
        tabela_plano_referencial.getColumnModel().getColumn(2).setResizable(false);
        tabela_plano_referencial.getColumnModel().getColumn(2).setPreferredWidth(80);
        tabela_plano_referencial.getColumnModel().getColumn(3).setResizable(false);
        tabela_plano_referencial.getColumnModel().getColumn(3).setPreferredWidth(80);
        tabela_plano_referencial.getColumnModel().getColumn(4).setResizable(false);
        tabela_plano_referencial.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabela_plano_referencial.getColumnModel().getColumn(5).setResizable(false);
        tabela_plano_referencial.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabela_plano_referencial.getColumnModel().getColumn(6).setResizable(false);
        tabela_plano_referencial.getColumnModel().getColumn(6).setPreferredWidth(75);
        tabela_plano_referencial.getColumnModel().getColumn(7).setResizable(false);
        tabela_plano_referencial.getColumnModel().getColumn(7).setPreferredWidth(75);
        tabela_plano_referencial.getColumnModel().getColumn(8).setResizable(false);
        tabela_plano_referencial.getColumnModel().getColumn(8).setPreferredWidth(1500);
        
        TablePlanoReferencial.setNumRows(0);
        if(dadosPlanilha.isEmpty())
            return;
        for(int i = 0; i < dadosPlanilha.size(); i++){
            Texto = (String)    dadosPlanilha.get(i);
            
            bpref.codigoPlanoReferencial            =                   Texto.substring(0  , 16);
            bpref.descricaoPlanoReferencial         =                   Texto.substring(16 ,816);
            bpref.dataInicial                       =                   Texto.substring(816,826);
            bpref.dataFinal                         =                   Texto.substring(826,836);
            bpref.tipoPlanoReferencial              =                   Texto.substring(836,837);
            bpref.codigoPlanoReferencialSuperior    =                   Texto.substring(837,850);
            if(!Texto.substring(850,851).replace(" ", "").equals("")){bpref.nivel       = Integer.parseInt( Texto.substring(850,851));}else{bpref.nivel = 0;}
            if(!Texto.substring(851,852).replace(" ", "").equals("")){bpref.natureza    = Integer.parseInt( Texto.substring(851,852));}else{bpref.natureza = 0;}
            bpref.orientacoes                       =                   Texto.substring(852,Texto.length());
            
            bpref.codigoPlanoReferencial            = bpref.codigoPlanoReferencial.replace(" ", "");
            bpref.descricaoPlanoReferencial         = bpref.descricaoPlanoReferencial.replace("  ", "");
            
            if(!bpref.dataInicial.replace(" ", "").equals("")){bpref.dataInicial        = invdata.inverterData(bpref.dataInicial, 1);}else{bpref.dataInicial = "";}
            bpref.dataFinal                         = bpref.dataFinal.replace(" ", "");
            
            bpref.codigoPlanoReferencialSuperior    = bpref.codigoPlanoReferencialSuperior.replace(" ", "");
            
            switch(bpref.tipoPlanoReferencial){
                case "A": bpref.tipoPlanoReferencial = "Analítico";break;
                case "S": bpref.tipoPlanoReferencial = "Sintético";break;
            }
            
            TablePlanoReferencial.addRow(new Object[] {bpref.codigoPlanoReferencial, bpref.descricaoPlanoReferencial, bpref.dataInicial, bpref.dataFinal, bpref.tipoPlanoReferencial, bpref.codigoPlanoReferencialSuperior, bpref.nivel, bpref.natureza, bpref.orientacoes});
        }
        if(tabela_plano_referencial.getRowCount() < 0)
            return;
        bt_processa.setEnabled(true);
    }
    
    private void PegaDadosPlanoReferencial(){
        bt_processa                 .setEnabled(false);
        tabela_plano_referencial    .setVisible(false);
        bt_sair                     .setEnabled(false);
        bt_pesquisardiretorio       .setEnabled(false);
        for(int i = 0; i < tabela_plano_referencial.getRowCount(); i++){
            bpref.codigoPlanoReferencial            = String.valueOf(tabela_plano_referencial.getValueAt(i, 0)).replace(" " , "");
            bpref.descricaoPlanoReferencial         = String.valueOf(tabela_plano_referencial.getValueAt(i, 1)).replace("  ", "");
            bpref.dataInicial                       = String.valueOf(tabela_plano_referencial.getValueAt(i, 2));
            bpref.dataFinal                         = String.valueOf(tabela_plano_referencial.getValueAt(i, 3));
            bpref.tipoPlanoReferencial              = String.valueOf(tabela_plano_referencial.getValueAt(i, 4)).substring(0, 1);
            bpref.codigoPlanoReferencialSuperior    = String.valueOf(tabela_plano_referencial.getValueAt(i, 5)).replace(" " , "");
//            if(!String.valueOf(tabela_plano_referencial.getValueAt(i, 6)).equals("")){
//                bpref.nivel     = Integer.parseInt(String.valueOf(tabela_plano_referencial.getValueAt(i, 6)));
//            }else{
//                bpref.nivel     = 0;
//            }
            if(!String.valueOf(tabela_plano_referencial.getValueAt(i, 7)).equals("")){
                bpref.natureza  = Integer.parseInt(String.valueOf(tabela_plano_referencial.getValueAt(i, 7)));
            }else{
                bpref.natureza  = 0;
            }
            bpref.orientacoes                       = String.valueOf(tabela_plano_referencial.getValueAt(i, 8));
            
            if(bpref.codigoPlanoReferencial.length() >  0)bpref.nivel = 1;
            if(bpref.codigoPlanoReferencial.length() >  1)bpref.nivel = 2;
            if(bpref.codigoPlanoReferencial.length() >  4)bpref.nivel = 3;
            if(bpref.codigoPlanoReferencial.length() >  7)bpref.nivel = 4;
            if(bpref.codigoPlanoReferencial.length() > 10)bpref.nivel = 5;
            if(bpref.codigoPlanoReferencial.length() > 13)bpref.nivel = 6;
            
            if(!bpref.dataInicial.replace(" ", "").equals("")){
                bpref.dataInicial   = "'" + invdata.inverterData(bpref.dataInicial, 2) + "'";
            }else{
                bpref.dataInicial   = null;
            }
            if(!bpref.dataFinal.replace(" ", "").equals("")){
                bpref.dataFinal     = "'" + invdata.inverterData(bpref.dataFinal, 2) + "'";
            }else{
                bpref.dataFinal     = null;
            }
            
            sql = "insert into ns_plano_referencial (codigoPlanoReferencial, descricaoPlanoReferencial, dataInicial, dataFinal, tipoPlanoReferencial, codigoPlanoReferencialSuperior, nivel, natureza, orientacoes) "
                + "values ('" + bpref.codigoPlanoReferencial + "', '" + bpref.descricaoPlanoReferencial + "', " + bpref.dataInicial + ", " + bpref.dataFinal + ", '" + bpref.tipoPlanoReferencial + "', '" + bpref.codigoPlanoReferencialSuperior + "', " + bpref.nivel + ", " + bpref.natureza + ", '" + bpref.orientacoes + "');";
            sqlstate = parametrosNS.dao.incluirRegistro(sql);
            if(!sqlstate.equals("00000")){
                Mensagem = "Erro ao inserir Código Referencial: " + bpref.codigoPlanoReferencial + "!";
                new MostraMensagem(Mensagem);
                return;
            }
        }
        tabela_plano_referencial    .setVisible(true);
        bt_sair                     .setEnabled(true);
        bt_pesquisardiretorio       .setEnabled(true);
    }
    
}
