package Telas;

import Parametros.parametrosNS;
import BeansNS.BeanEmpresas;
import Beans.*;
import FuncoesInternas.*;
import daoConexao.*;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Tiago e Paulo 12/03/2016 03:09
 */
public class BuscaAvancada extends javax.swing.JFrame {
    //Connection's
    Connection con;
    
    //int's
    int    INDEX           = 0;
    int    USER            = 0;
    int    QTDLINHAS       = 0;
    
    //String's
    String fatal           = "N";
    String nomeTabela      = "";
    String sql             = "";
    String Mensagem        = "";
    String NOMEDACOLUNA    = "";
    String NOMEDALINHA     = "";
    String tabelaSelect    = "";
    String CONDICAO        = "";
    String PARAMETRO       = "";
    String operacao        = "";
    String removerColunas  = "";
    
    //ArrayList's
    ArrayList colunas           = new ArrayList();
    ArrayList colunatype        = new ArrayList();
    ArrayList tabelas           = new ArrayList();
    ArrayList nomedascolunas    = new ArrayList();
    //VETORES DE DADOS
    ArrayList dadosTabela       = new ArrayList();
    ArrayList comentariosTabela = new ArrayList();
    //ArrayList ArrayList            = new ArrayList();
    
    //DefaultTableModel
    DefaultTableModel Table;
    
    // ArrayList's
    ArrayList<ArrayList> ArrayList = new ArrayList();
    
    //Bean's
    BeanEmpresas        be      = new BeanEmpresas();
    beanColunas         bcol    = new beanColunas();
    beanTabelas         btab    = new beanTabelas();
    
    //Telas
    
    public BuscaAvancada(){
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_parametro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        combo_pesquisa = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        combo_tabela = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        combo_coluna = new javax.swing.JComboBox();
        txt_rodape = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(":: Buscas Avançadas");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(":: Parâmetros para Pesquisa"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Parâmetro: ");

        txt_parametro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_parametroFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Forma de Pesquisa: ");

        combo_pesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01 - Que contém", "02 - Igual a", "03 - Diferente de", "04 - Maior que", "05 - Menor que", "06 - Maior que ou igual a", "07 - Menor que ou igual a", "08 - Que está contido em", "09 - Que não contém", "10 - Que não está contido em", "11 -  Exatamente igual a" }));
        combo_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_pesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_parametro)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(combo_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txt_parametro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {combo_pesquisa, jLabel2, jLabel3, txt_parametro});

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(":: Resultado da Pesquisa"));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(":: Informações do Banco de Dados"));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Tabela: ");

        combo_tabela.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "tb_concessionarios" }));
        combo_tabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_tabelaActionPerformed(evt);
            }
        });
        combo_tabela.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                combo_tabelaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo_tabelaFocusLost(evt);
            }
        });
        combo_tabela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo_tabelaKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Coluna: ");

        combo_coluna.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        combo_coluna.setEnabled(false);
        combo_coluna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_colunaActionPerformed(evt);
            }
        });
        combo_coluna.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo_colunaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_tabela, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_coluna, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel6});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combo_coluna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(combo_tabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {combo_tabela, jLabel6});

        txt_rodape.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setText("Resultado da Pesquisa: ");

        jMenu1.setText("Arquivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem1.setText(":: Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_rodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(txt_rodape, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void combo_tabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_tabelaActionPerformed
        
    }//GEN-LAST:event_combo_tabelaActionPerformed

    private void combo_tabelaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo_tabelaFocusLost
        Table = (DefaultTableModel)jTable1.getModel();
        Table.setColumnCount(0);
        fatal = "N";
        nomeTabela = "";
        combo_coluna.setEnabled(true);
        AdicionaColuna();
        sql = "SELECT TABLE_SCHEMA, TABLE_NAME, TABLE_TYPE, TABLE_ROWS, DATA_LENGTH, CREATE_TIME, TABLE_COMMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = '" + parametrosNS.bbd.nomeBanco + "' AND TABLE_NAME = '" + nomeTabela + "';";
        SetaTamanhoTabela();
        
        operacao = "I";
        preencherDadosTabela();
        
        txt_rodape.setText("Tabela: " + nomeTabela + " | Quantidade de Registros: " + btab.TABLE_ROWS + " | Tamanho total: " + btab.DATA_LENGTH + " bytes" + " | Data de Criação: " + btab.CREATE_TIME);
    }//GEN-LAST:event_combo_tabelaFocusLost

    private void combo_colunaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo_colunaFocusLost
        
    }//GEN-LAST:event_combo_colunaFocusLost

    private void combo_colunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_colunaActionPerformed
//        VerificaColuna();
    }//GEN-LAST:event_combo_colunaActionPerformed

    private void combo_tabelaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo_tabelaFocusGained
        combo_coluna.removeAllItems();
        combo_coluna.setEnabled(false);
        Table.setNumRows(0);
    }//GEN-LAST:event_combo_tabelaFocusGained

    private void txt_parametroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_parametroFocusLost
        PARAMETRO = txt_parametro.getText();
        if (PARAMETRO.equals(""))
            return;
        Table        = (DefaultTableModel)jTable1.getModel();
        NOMEDACOLUNA = (String) combo_coluna.getSelectedItem();
        VERIFICACONDICAO();
        sql = "select * from " + nomeTabela + " where " + NOMEDACOLUNA + " " + CONDICAO + " '%" + PARAMETRO + "%';";
        //System.out.printl(nsql);
        ArrayList.clear();
        ArrayList = parametrosNS.dtab.ConsultaValoresTabela(sql, nomedascolunas);
        if (ArrayList.isEmpty()){
            Mensagem = btab.TABLE_COMMENT + " está vazia!!!";
            new MostraMensagem(Mensagem);
            return;
        }
        preencherTabela();
    }//GEN-LAST:event_txt_parametroFocusLost

    private void combo_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_pesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_pesquisaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Table = (DefaultTableModel)jTable1.getModel();
        sql = "select table_schema, table_name, table_type, table_rows, data_length, create_time, table_comment from information_schema.tables where table_schema = '" + parametrosNS.bbd.nomeBanco + "' and table_type <> 'view' and table_comment <> 'view' and table_comment <> '';";
        SetaTamanhoTabela();
        preencherDadosTabela();
    }//GEN-LAST:event_formWindowOpened

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void combo_tabelaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_tabelaKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        combo_coluna.grabFocus();
    }//GEN-LAST:event_combo_tabelaKeyPressed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
    }//GEN-LAST:event_formWindowGainedFocus
    
    public void preencherTabela(){
        QTDLINHAS = ArrayList.size();
        Table.setNumRows(0);
        Table.setNumRows(QTDLINHAS);
        
        String VALOR     = "";
        
        for (int LINHA = 0; LINHA < QTDLINHAS; LINHA++){
            for(int COLUNA = 0; COLUNA < Table.getColumnCount(); COLUNA++){
                fatal = "N";
                bcol.Field = (String)nomedascolunas.get(COLUNA);
                VALOR = (String) ArrayList.get(LINHA).get(COLUNA);
                Table.setValueAt(VALOR, LINHA, COLUNA);
            }
        }
    }
    
    public void VERIFICACONDICAO(){
        INDEX = combo_pesquisa.getSelectedIndex();
        switch(INDEX){
            case 0: CONDICAO = "LIKE"; break;
        }
    }
    
    public void SetaTamanhoTabela(){
        dadosTabela.clear();
        dadosTabela = parametrosNS.dtab.ConsultaPropriedadesTabela(sql);
        if(dadosTabela.isEmpty()){
//            Mensagem = "Dados da tabela " + nomeTabela + " não reconhecidos.";
//            new MostraMensagem(Mensagem);
            return;
        }
    }
    
    public void preencherDadosTabela(){
        if(!operacao.equalsIgnoreCase("I")){
            combo_tabela.removeAllItems();
            tabelas.clear();
        }
        for(int i = 0; i < dadosTabela.size(); i++){
            btab.TABLE_SCHEMA        = ((beanTabelas)(dadosTabela.get(i))).TABLE_SCHEMA;
            btab.TABLE_NAME          = ((beanTabelas)(dadosTabela.get(i))).TABLE_NAME;
            btab.TABLE_TYPE          = ((beanTabelas)(dadosTabela.get(i))).TABLE_TYPE;
            btab.TABLE_ROWS          = ((beanTabelas)(dadosTabela.get(i))).TABLE_ROWS;
            btab.DATA_LENGTH         = ((beanTabelas)(dadosTabela.get(i))).DATA_LENGTH;
            btab.CREATE_TIME         = ((beanTabelas)(dadosTabela.get(i))).CREATE_TIME;
            btab.TABLE_COMMENT       = ((beanTabelas)(dadosTabela.get(i))).TABLE_COMMENT;
            
            if(!operacao.equalsIgnoreCase("I")){
                tabelas.add(btab.TABLE_NAME);
                combo_tabela.addItem(btab.TABLE_COMMENT);
            }
        }
        //System.out.println(tabelas);
    }
    
//    public void AdicionaTabelas(){
//        tabelas.clear();
//        tabelas = dtab.ConsultaTabelas(NOMEBANCO);
//        if(tabelas.isEmpty()){
//            Mensagem = "Banco " + NOMEBANCO + " NÃO POSSUI tabelas EXISTENTES!!!";
//            new MostraMensagem(Mensagem);
//            return;
//        }
//        preencherComboTabelas();
//    }
    
    public void VerificaColuna(){
        if(colunatype.isEmpty())
            return;
        INDEX = 0;
        INDEX = combo_coluna.getSelectedIndex();
        if(INDEX == 0)
            return;
        bcol.Type  = (String)colunatype.get(INDEX);
        //txt_type.setText(TYPE);
    }
    
    public void VerificaTabela(){
        INDEX = 0;
        INDEX = combo_tabela.getSelectedIndex();
        nomeTabela = (String)tabelas.get(INDEX);
        VerificaTabelasColunas();
    }
    
    public void AdicionaColuna(){
        VerificaTabela();
        if(fatal.equalsIgnoreCase("S"))
            return;
        //System.out.println(sql);
        colunas = parametrosNS.dtab.buscarColunas(sql);
        if(colunas.isEmpty()){
            Mensagem = "Tabela " + nomeTabela + " não possui Colunas!!!";
            new MostraMensagem(Mensagem);
            return;
        }
        preencherComboColunas();
        AdicionaColunasNaTabela();
    }
    
    private void VerificaTabelasColunas(){
        switch(nomeTabela){
            case "tb_usuarios": sql = "SHOW COLUMNS FROM TB_USUARIOS WHERE FIELD <> 'SENHA' AND FIELD <> 'DATAALTEROU' AND FIELD <> 'HOTAALTEROU' AND FIELD <> 'USUARIOALTEROU'"; break;
        }
    }
    
    public void AdicionaColunasNaTabela(){
        bcol.Field = "";
        for(int i = 0; i < nomedascolunas.size(); i++){
            fatal = "N";
            bcol.Field = (String)nomedascolunas.get(i);
            Table        = (DefaultTableModel)jTable1.getModel();
            Table.addColumn(bcol.Field);
        }
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    }
    
    public void preencherComboColunas(){
        combo_coluna.removeAllItems();
        colunatype.clear();
        nomedascolunas.clear();
        for(int i = 0; i < colunas.size(); i++){
            fatal = "N";
            bcol.Field       = ((beanColunas)(colunas.get(i))).Field;
            bcol.Type        = ((beanColunas)(colunas.get(i))).Type;
            bcol.Null        = ((beanColunas)(colunas.get(i))).Null;
            bcol.Key         = ((beanColunas)(colunas.get(i))).Key;
            bcol.Default     = ((beanColunas)(colunas.get(i))).Default;
            bcol.Extra       = ((beanColunas)(colunas.get(i))).Extra;
            
            //System.out.println(FIELD);
            nomedascolunas.add(bcol.Field);
            colunatype.add(bcol.Type);
            combo_coluna.addItem(bcol.Field);
        }
    }
    
    private void VERIFICAREMOCAODECOLUNAS(){
        if(removerColunas.equals("USU")){
            RemoveColunasUsuarios();
            return;
        }
    }
    
    private void RemoveColunasUsuarios() {
        if (bcol.Field.equals("SENHA")
         || bcol.Field.equals("DATAALTEROU")
         || bcol.Field.equals("HORAALTEROU")
         || bcol.Field.equals("USUARIOALTEROU")){
            fatal = "S";
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox combo_coluna;
    private javax.swing.JComboBox combo_pesquisa;
    private javax.swing.JComboBox combo_tabela;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField txt_parametro;
    private javax.swing.JLabel txt_rodape;
    // End of variables declaration//GEN-END:variables
    
}
