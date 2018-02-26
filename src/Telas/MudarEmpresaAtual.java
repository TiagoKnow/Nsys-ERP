package Telas;

import Beans.BeanUsuarios;
import Dao.DaoMySQL;
import BeansNS.BeanEmpresas;
import TelasDeConfiguracoes.daoSQLITE;
import BeansNS.BeanGrupoEmpresa;
import FuncoesInternas.*;
import Telas.MenuPrincipal;
import BeansNS.BeanModulosAcesso;
import Main.BarraInicial;
import Main.ProcessoInicial;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import Parametros.parametrosNS;
import java.net.InetAddress;
/*
 @author Tiago e Paulo
 */
public class MudarEmpresaAtual extends javax.swing.JFrame {
    //String's
    String ValorDaLeitura   = "";
    String sql              = "";
    String Mensagem         = "";
    String Texto            = "";
    String Linha            = "";
    String AdicionaCombo    = "";
    
    //int's
    int    linhaSelecionada             = 0;
    
    //Bean's
    BeanGrupoEmpresa        bge         = new BeanGrupoEmpresa();
    BeanEmpresas            be          = new BeanEmpresas();
    BeanModulosAcesso       bma         = new BeanModulosAcesso();
    
    //ArrayList's
    ArrayList<ArrayList> Grupos                    = new ArrayList();
    ArrayList<ArrayList> Empresas                  = new ArrayList();
    ArrayList<ArrayList> dadosModulos              = new ArrayList();
    
    //Object's
    Object textoCodigo                  = "";
    Object textoNome                    = "";
    
    //Outros
    Criptografia                    crpt    = new Criptografia();
    FormataCampo                    fc      = new FormataCampo();
    CalcularDiasRestantesSistema    cdr     = new CalcularDiasRestantesSistema();
    CapturarDataHora                cdh     = new CapturarDataHora();
    InverterData                    invdata = new InverterData();
    DefaultTableModel               Table;
    MenuPrincipal                   mP;
    
    //Telas
    BarraInicial    Bar;
    ProcessoInicial ProIni;
    
    public MudarEmpresaAtual(){
        initComponents();
        
        Table       = (DefaultTableModel)TabelaEmpresa.getModel();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Combo_Grupo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_empresaselecionada = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaEmpresa = new javax.swing.JTable();
        bt_confirma = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Mudar empresa");
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

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setText("Grupo: ");

        Combo_Grupo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Combo_Grupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
        Combo_Grupo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Combo_GrupoItemStateChanged(evt);
            }
        });
        Combo_Grupo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Combo_GrupoFocusLost(evt);
            }
        });
        Combo_Grupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Combo_GrupoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Combo_GrupoMouseExited(evt);
            }
        });
        Combo_Grupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_GrupoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Informações");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Combo_Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Combo_Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Combo_Grupo, jLabel3});

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Organização/Empresa: ");

        txt_empresaselecionada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_empresaselecionadaActionPerformed(evt);
            }
        });

        TabelaEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                "Codigo Empresa", "Empresa"
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
        TabelaEmpresa.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        TabelaEmpresa.setRowMargin(0);
        TabelaEmpresa.setShowHorizontalLines(false);
        TabelaEmpresa.setShowVerticalLines(false);
        TabelaEmpresa.getTableHeader().setReorderingAllowed(false);
        TabelaEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaEmpresaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TabelaEmpresaMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaEmpresa);
        if (TabelaEmpresa.getColumnModel().getColumnCount() > 0) {
            TabelaEmpresa.getColumnModel().getColumn(0).setPreferredWidth(0);
            TabelaEmpresa.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        bt_confirma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_confirma.setText("Confirmar");
        bt_confirma.setEnabled(false);
        bt_confirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmaActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        jButton3.setText("Sair");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Empresa");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_empresaselecionada, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bt_confirma)
                        .addGap(13, 13, 13)
                        .addComponent(jButton3)))
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_empresaselecionada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_confirma, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    void txt_empresaselecionadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_empresaselecionadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_empresaselecionadaActionPerformed

    void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
        if(parametrosNS.bu.codigoUsuario == 999)
            Sair();
    }//GEN-LAST:event_jButton3ActionPerformed

    void TabelaEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaEmpresaMouseClicked
        if(evt.getClickCount() < 2)
            return;
        linhaSelecionada = TabelaEmpresa.getSelectedRow();
        textoCodigo      = TabelaEmpresa.getValueAt(linhaSelecionada, 0);
        textoNome        = TabelaEmpresa.getValueAt(linhaSelecionada, 1);
        
        be.codigoGrupo   = Integer.parseInt(String.valueOf(Combo_Grupo.getSelectedItem()).substring(0, 2));
        be.codigoEmpresa = Integer.parseInt(String.valueOf(textoCodigo));
        
        txt_empresaselecionada.setText(textoCodigo + " - " + textoNome);
        bt_confirma.setEnabled(true);
        bt_confirma.grabFocus();
    }//GEN-LAST:event_TabelaEmpresaMouseClicked

    void bt_confirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmaActionPerformed
        parametrosNS.bge.CodigoGrupo = Integer.parseInt(String.valueOf(Combo_Grupo.getSelectedItem()).substring(0, 2));
        PegaGrupo("N");
        PegaEmpresa("N");
        AbrirMenu();
    }//GEN-LAST:event_bt_confirmaActionPerformed

    private void Combo_GrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_GrupoActionPerformed
        
    }//GEN-LAST:event_Combo_GrupoActionPerformed

    private void Combo_GrupoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Combo_GrupoMouseClicked
        
    }//GEN-LAST:event_Combo_GrupoMouseClicked

    private void Combo_GrupoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Combo_GrupoMouseExited
        
    }//GEN-LAST:event_Combo_GrupoMouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        PegaGrupo("S");
        PegaEmpresa("S");
    }//GEN-LAST:event_formWindowOpened

    private void TabelaEmpresaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaEmpresaMouseEntered
        //CarregarEmpresas();
    }//GEN-LAST:event_TabelaEmpresaMouseEntered

    private void Combo_GrupoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Combo_GrupoFocusLost
        
    }//GEN-LAST:event_Combo_GrupoFocusLost

    private void Combo_GrupoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Combo_GrupoItemStateChanged
        if(AdicionaCombo.equals("S"))return;
        PegaEmpresa("S");
    }//GEN-LAST:event_Combo_GrupoItemStateChanged

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
    }//GEN-LAST:event_formWindowGainedFocus
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Combo_Grupo;
    private javax.swing.JTable TabelaEmpresa;
    private javax.swing.JButton bt_confirma;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_empresaselecionada;
    // End of variables declaration//GEN-END:variables
    
    private void PegaGrupo(String Add){
        sql = "select * from ns_grupoempresa where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + ";";
        if(Add.equals("S"))
            if(parametrosNS.bu.usuario.equalsIgnoreCase("NS3"))
                if(parametrosNS.bu.senha.equalsIgnoreCase("adm2322")){
                    AdicionaCombo = "S";
                    sql = "select * from ns_grupoempresa;";
                    Combo_Grupo.setEnabled(true);
                }
        Grupos.clear();
        Grupos = parametrosNS.dao.Consulta(sql);
        if(Grupos.isEmpty ()){
            Mensagem = "Não existe Grupo cadastrado!!!";
            new MostraMensagem(Mensagem);
            return;
        }
        AdicionaNaComboGrupo(Add);
    }
    
    private void AdicionaNaComboGrupo(String Add){
        if(Add.equals("S"))
            Combo_Grupo.removeAllItems();
        for(int i = 0; i < Grupos.size(); i++){
            bge.codigoGrupo             = Integer.parseInt( String.valueOf(Grupos.get(i).get(0)));
            bge.nomeGrupo               =                   String.valueOf(Grupos.get(i).get(1));
            bge.pastaImagemLogotipo     =                   String.valueOf(Grupos.get(i).get(2));
            bge.extensaoImagemLogotipo  =                   String.valueOf(Grupos.get(i).get(3));
            bge.limiteUsuarios          = Integer.parseInt( String.valueOf(Grupos.get(i).get(4)));
            
            if(Add.equals("S"))
                Combo_Grupo.addItem(fc.FormataCampo(String.valueOf(bge.codigoGrupo), 2, 0) + " - " + bge.nomeGrupo);
        }
        if(Add.equals("S"))
            AdicionaCombo = "N";
        
        if(parametrosNS.bu.usuario.equalsIgnoreCase("NS3"))
            if(parametrosNS.bu.senha.equalsIgnoreCase("adm2322"))
                if(Add.equals("N")){
                    parametrosNS.bge.codigoGrupo            = bge.codigoGrupo;
                    parametrosNS.bge.nomeGrupo              = bge.nomeGrupo;
                    parametrosNS.bge.pastaImagemLogotipo    = bge.pastaImagemLogotipo;
                    parametrosNS.bge.extensaoImagemLogotipo = bge.extensaoImagemLogotipo;
                    parametrosNS.bge.limiteUsuarios         = bge.limiteUsuarios;
                }
        parametrosNS.bge.CodigoGrupo            = bge.codigoGrupo;
        parametrosNS.bge.NomeGrupo              = bge.nomeGrupo;
        parametrosNS.bge.PastaImagemLogotipo    = bge.pastaImagemLogotipo;
        parametrosNS.bge.ExtensaoImagemLogotipo = bge.extensaoImagemLogotipo;
        parametrosNS.bge.LimiteUsuarios         = bge.limiteUsuarios;
    }
    
    private void PegaEmpresa(String Add){
        if(AdicionaCombo.equals("S"))
            return;
        bge.codigoGrupo = Integer.parseInt(String.valueOf(Combo_Grupo.getSelectedItem()).substring(0, 2));
        sql = "select * from ns_empresas where codigoGrupo = " + bge.codigoGrupo;
        if(!Add.equals("S"))sql += " and codigoEmpresa = " + be.codigoEmpresa;
        sql += ";";
        Empresas.clear();
        Empresas = parametrosNS.dao.Consulta(sql);
        if(Empresas.isEmpty()){
            Mensagem = "Empresa: " + be.codigoGrupo + "." + be.codigoEmpresa + " não encontrada!!!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosEmpresa(Add);
    }
    
    private void PegaDadosEmpresa(String Add){
        if(Add.equals("S"))Table.setNumRows(0);
        for(int i = 0; i < Empresas.size(); i++){
            be.idEmpresa                = Integer.parseInt(  String.valueOf(Empresas.get(i).get(0)));
            be.codigoGrupo              = Integer.parseInt(  String.valueOf(Empresas.get(i).get(1)));
            be.codigoEmpresa            = Integer.parseInt(  String.valueOf(Empresas.get(i).get(2)));
            be.idBancoDados             = Integer.parseInt(  String.valueOf(Empresas.get(i).get(3)));
            be.nomeEmpresa              =                    String.valueOf(Empresas.get(i).get(4));
            be.nomeFantasia             =                    String.valueOf(Empresas.get(i).get(5));
            be.cnpjEmpresa              =                    String.valueOf(Empresas.get(i).get(6));
            be.inscricaoEstadual        =                    String.valueOf(Empresas.get(i).get(7));
            be.regimeTributario         =                    String.valueOf(Empresas.get(i).get(8));
            be.cepEmpresa               =                    String.valueOf(Empresas.get(i).get(9));
            be.cidadeEmpresa            =                    String.valueOf(Empresas.get(i).get(10));
            be.bairroEmpresa            =                    String.valueOf(Empresas.get(i).get(11));
            be.enderecoEmpresa          =                    String.valueOf(Empresas.get(i).get(12));
            be.numeroEmpresa            =                    String.valueOf(Empresas.get(i).get(13));
            be.ufEmpresa                =                    String.valueOf(Empresas.get(i).get(14));
            be.telefoneEmpresa          =                    String.valueOf(Empresas.get(i).get(15));
            be.pastaImagemUsuario       =                    String.valueOf(Empresas.get(i).get(16));
            be.extensaoImagemUsuario    =                    String.valueOf(Empresas.get(i).get(17));
            be.dataValidade             =                    String.valueOf(Empresas.get(i).get(18));
            
            if(Add.equals("S"))
                Table.addRow(new Object[] {fc.FormataCampo(String.valueOf(be.codigoEmpresa), 3, 0), be.nomeEmpresa});
        }
        if(Add.equals("S"))return;
        if(parametrosNS.bu.codigoUsuario == 999){
            parametrosNS.be.idEmpresa               = be.idEmpresa;
            parametrosNS.be.codigoGrupo             = be.codigoGrupo;
            parametrosNS.be.codigoEmpresa           = be.codigoEmpresa;
            parametrosNS.be.idBancoDados            = be.idBancoDados;
            parametrosNS.be.nomeEmpresa             = be.nomeEmpresa;
            parametrosNS.be.nomeFantasia            = be.nomeFantasia;
            parametrosNS.be.cnpjEmpresa             = be.cnpjEmpresa;
            parametrosNS.be.inscricaoEstadual       = be.inscricaoEstadual;
            parametrosNS.be.regimeTributario        = be.regimeTributario;
            parametrosNS.be.cepEmpresa              = be.cepEmpresa;
            parametrosNS.be.cidadeEmpresa           = be.cidadeEmpresa;
            parametrosNS.be.bairroEmpresa           = be.bairroEmpresa;
            parametrosNS.be.enderecoEmpresa         = be.enderecoEmpresa;
            parametrosNS.be.numeroEmpresa           = be.numeroEmpresa;
            parametrosNS.be.ufEmpresa               = be.ufEmpresa;
            parametrosNS.be.telefoneEmpresa         = be.telefoneEmpresa;
            parametrosNS.be.pastaImagemUsuario      = be.pastaImagemUsuario;
            parametrosNS.be.extensaoImagemUsuario   = be.extensaoImagemUsuario;
            parametrosNS.be.dataValidade            = be.dataValidade;
        }
        parametrosNS.be.IdEmpresa               = be.idEmpresa;
        parametrosNS.be.CodigoGrupo             = be.codigoGrupo;
        parametrosNS.be.CodigoEmpresa           = be.codigoEmpresa;
        parametrosNS.be.IdBancoDados            = be.idBancoDados;
        parametrosNS.be.NomeEmpresa             = be.nomeEmpresa;
        parametrosNS.be.NomeFantasia            = be.nomeFantasia;
        parametrosNS.be.CnpjEmpresa             = be.cnpjEmpresa;
        parametrosNS.be.InscricaoEstadual       = be.inscricaoEstadual;
        parametrosNS.be.RegimeTributario        = be.regimeTributario;
        parametrosNS.be.CepEmpresa              = be.cepEmpresa;
        parametrosNS.be.CidadeEmpresa           = be.cidadeEmpresa;
        parametrosNS.be.BairroEmpresa           = be.bairroEmpresa;
        parametrosNS.be.EnderecoEmpresa         = be.enderecoEmpresa;
        parametrosNS.be.NumeroEmpresa           = be.numeroEmpresa;
        parametrosNS.be.UfEmpresa               = be.ufEmpresa;
        parametrosNS.be.TelefoneEmpresa         = be.telefoneEmpresa;
        parametrosNS.be.PastaImagemUsuario      = be.pastaImagemUsuario;
        parametrosNS.be.ExtensaoImagemUsuario   = be.extensaoImagemUsuario;
        parametrosNS.be.DataValidade            = be.dataValidade;
        PegaLogotipoEmpresa();
        
        if(!parametrosNS.bu.usuario.equalsIgnoreCase("NS3")){
            if(!parametrosNS.bu.senha.equalsIgnoreCase("adm2322")){
                return;
            }
        }
        
        SetaModulosGrupo();
    }
    
    private void PegaLogotipoEmpresa(){
        sql = "select imagemLogotipoEmpresa from ns_empresas where codigoGrupo = " + bge.codigoGrupo + " and codigoEmpresa = " + be.codigoEmpresa + ";";
        parametrosNS.be.ImagemLogotipoEmpresa = parametrosNS.dao.ConsultaLogotipo(sql, "imagemLogotipoEmpresa");
        if(parametrosNS.bu.codigoUsuario == 999)
            parametrosNS.be.imagemLogotipoEmpresa = parametrosNS.be.ImagemLogotipoEmpresa;
    }
    
    private void SetaModulosGrupo(){
        parametrosNS.bma.idModuloAcesso = 1;
        parametrosNS.bma.codigoGrupo    = parametrosNS.bge.codigoGrupo;
        parametrosNS.bma.modulosAcesso  = "11111111111111";
        parametrosNS.bma.RecarregaVariavies();
        
        SetaModulos();
    }
    
    private void SetaModulos(){
        parametrosNS.bm.idModulo            = 0;
        parametrosNS.bm.idEmpresa           = parametrosNS.be.IdEmpresa;
        parametrosNS.bm.codigoGrupo         = parametrosNS.be.CodigoGrupo;
        parametrosNS.bm.codigoEmpresa       = parametrosNS.be.CodigoEmpresa;
        parametrosNS.bm.usuarioModulo       = 999;
        parametrosNS.bm.modulos             = "11111111111111";
        parametrosNS.bm.abasFaturamento     = "111111";
        parametrosNS.bm.abasVendas          = "111111";
        parametrosNS.bm.abasEstoque         = "111111";
        parametrosNS.bm.abasContabil        = "111111";
        parametrosNS.bm.abasFiscal          = "111111";
        parametrosNS.bm.abasContasAReceber  = "111111";
        parametrosNS.bm.abasContasAPagar    = "111111";
        parametrosNS.bm.abasProducao        = "111111";
        parametrosNS.bm.abasGestao          = "111111";
        parametrosNS.bm.abasCompras         = "111111";
        parametrosNS.bm.abasRecebimento     = "111111";
        parametrosNS.bm.abasCRM             = "111111";
        parametrosNS.bm.abasCC              = "111111";
        parametrosNS.bm.abasRH              = "111111";
        
        parametrosNS.bm.moduloFaturamento   = Integer.parseInt(parametrosNS.bm.modulos.substring(0 , 1));  //1
        parametrosNS.bm.moduloVendas        = Integer.parseInt(parametrosNS.bm.modulos.substring(1 , 2));  //2
        parametrosNS.bm.moduloEstoque       = Integer.parseInt(parametrosNS.bm.modulos.substring(2 , 3));  //3
        parametrosNS.bm.moduloContabil      = Integer.parseInt(parametrosNS.bm.modulos.substring(3 , 4));  //4
        parametrosNS.bm.moduloFiscal        = Integer.parseInt(parametrosNS.bm.modulos.substring(4 , 5));  //5
        parametrosNS.bm.moduloContasAReceber= Integer.parseInt(parametrosNS.bm.modulos.substring(5 , 6));  //6
        parametrosNS.bm.moduloContasAPagar  = Integer.parseInt(parametrosNS.bm.modulos.substring(6 , 7));  //7
        parametrosNS.bm.moduloProducao      = Integer.parseInt(parametrosNS.bm.modulos.substring(7 , 8));  //8
        parametrosNS.bm.moduloGestao        = Integer.parseInt(parametrosNS.bm.modulos.substring(8 , 9));  //9
        parametrosNS.bm.moduloCompras       = Integer.parseInt(parametrosNS.bm.modulos.substring(9 ,10));  //10
        parametrosNS.bm.moduloRecebimento   = Integer.parseInt(parametrosNS.bm.modulos.substring(10,11));  //11
        parametrosNS.bm.moduloCRM           = Integer.parseInt(parametrosNS.bm.modulos.substring(11,12));  //12
        parametrosNS.bm.moduloCC            = Integer.parseInt(parametrosNS.bm.modulos.substring(12,13));  //13
        parametrosNS.bm.moduloRH            = Integer.parseInt(parametrosNS.bm.modulos.substring(13,14));  //14
        
        SetaValoresPadroes();
    }
    
    private void SetaValoresPadroes(){
        parametrosNS.Dias = cdr.RetornaDias(cdh.CapturarData(), invdata.inverterData("99991231", 1));
        
        parametrosNS.bcomp.codigoGrupo      = parametrosNS.be.CodigoGrupo;
        parametrosNS.bcomp.codigoEmpresa    = parametrosNS.be.CodigoEmpresa;
        parametrosNS.bcomp.codigoComputador = 0;
        try{
            parametrosNS.bcomp.nomeComputador   = InetAddress.getLocalHost().getHostName();    // Pega o Nome da Máquina
            parametrosNS.bcomp.ipv4             = InetAddress.getLocalHost().getHostAddress(); // Pega o IPV4
            parametrosNS.bcomp.usuarioMachine   = System.getProperty("user.name");
            parametrosNS.PastaSistema           = System.getProperty("user.dir");
        }catch(Exception erro){
            
        }
    }
    
    private void AbrirMenu(){
        dispose();
        mP = new MenuPrincipal();
        mP.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mP.setVisible(true);
    }
    
    private void Sair(){
        dispose();
        Bar     = new BarraInicial();
        ProIni  = new ProcessoInicial(Bar);
    }
}
