package TelasContabil;

import Beans.BeanPlanoDeContas;
import Beans.BeanPlanoReferencial;
import FuncoesInternas.ExportarParaExcel;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.FormataCampoADireita;
import FuncoesInternas.MostraMensagem;
import Parametros.parametrosNS;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
/*
 @author Tiago e Paulo
 */
public class PlanoDeContasConsulta extends javax.swing.JFrame {
    //String's
    String sql                              = "";
    String sqlstate                         = "";
    String Mensagem                         = "";
    String retorno                          = "";
    String somostra                         = "";
    
    //int's
    int    Linha                            = 0;
    int    abriuPlanoDeContas               = 0;
    
    //Vetores
    ArrayList            parametros                    = new ArrayList();
    ArrayList            dadosPadroes                  = new ArrayList();
    ArrayList<ArrayList> dadosPlanoDeContas            = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosPlanoReferencial         = new ArrayList<ArrayList>();
    
    //Bean's
    BeanPlanoDeContas               bpla    = new BeanPlanoDeContas();
    BeanPlanoReferencial            bpref   = new BeanPlanoReferencial();
    
    //Especiais para Excportação em Excel
    JFileChooser                    SeletorExcel;
    String                          NomeArquivoExcel    = "";
    String                          LocalArquivo        = "";
    int                             SalvarExcel         = 0;
    
    //Especiais
    DefaultTableModel               TablePlanoDeContas;
    FormataCampo                    fc      = new FormataCampo();
    FormataCampoADireita            fcad    = new FormataCampoADireita();
    
    //Telas
    PlanoDeContasCadastro           PlaDeConCad;
    
    public PlanoDeContasConsulta(ArrayList DadosPadroes){
        dadosPadroes                        = DadosPadroes;
        
        somostra                            = (String)  dadosPadroes.get(0);
        
        initComponents();
    }
    
    private void PegaPlanoDeContas(){
        dadosPlanoDeContas.clear();
        dadosPlanoDeContas = parametrosNS.dao.Consulta(sql);
        PegaDadosPlanoDeContas();
    }
    
    private void PegaDadosPlanoDeContas(){
        String NivelPlanoDeContas = "";
        String NivelReferencial   = "";
        TablePlanoDeContas.setNumRows(0);
        for(int i = 0; i < dadosPlanoDeContas.size(); i++){
            bpla = new BeanPlanoDeContas();
        if(dadosPlanoDeContas.get(i).get(0) != null)
            bpla.idPlanoDeContas                = Integer.parseInt(  String.valueOf(dadosPlanoDeContas.get(i).get(0)));
        if(dadosPlanoDeContas.get(i).get(1) != null)
            bpla.idEmpresa                      = Integer.parseInt(  String.valueOf(dadosPlanoDeContas.get(i).get(1)));
        if(dadosPlanoDeContas.get(i).get(2) != null)
            bpla.codigoGrupo                    = Integer.parseInt(  String.valueOf(dadosPlanoDeContas.get(i).get(2)));
        if(dadosPlanoDeContas.get(i).get(3) != null)
            bpla.codigoEmpresa                  = Integer.parseInt(  String.valueOf(dadosPlanoDeContas.get(i).get(3)));
            bpla.codigoPlanoDeContas            =                    String.valueOf(dadosPlanoDeContas.get(i).get(4));
            bpla.descricaoPlanoDeContas         =                    String.valueOf(dadosPlanoDeContas.get(i).get(5));
            bpla.tipoPlanoDeContas              =                    String.valueOf(dadosPlanoDeContas.get(i).get(6));
        if(dadosPlanoDeContas.get(i).get(7) != null)
            bpla.saldoDeAbertura                = Double.parseDouble(String.valueOf(dadosPlanoDeContas.get(i).get(7)));
            bpla.codigoPlanoDeContasSuperior    =                    String.valueOf(dadosPlanoDeContas.get(i).get(8));
        if(dadosPlanoDeContas.get(i).get(9) != null)
            bpla.nivelPlanoDeContas             = Integer.parseInt(  String.valueOf(dadosPlanoDeContas.get(i).get(9)));
        if(dadosPlanoDeContas.get(i).get(10) != null)
            bpla.idPlanoReferencial             = Integer.parseInt(  String.valueOf(dadosPlanoDeContas.get(i).get(10)));
            
            bpla.RecarregaCodigosPlanosDeContas();
            bpla.RecarregaPlanoDeContas("S", "S");
            
            bpref.idPlanoReferencial    = bpla.idPlanoReferencial;
            PegaPlanoReferencial();
            
            switch(bpla.tipoPlanoDeContas){
                case "A": bpla.tipoPlanoDeContas            = "Analítica";break;
                case "S": bpla.tipoPlanoDeContas            = "Sintética";
                          bpla.descricaoPlanoDeContas       = bpla.descricaoPlanoDeContas.toUpperCase();break;
            }
            
            switch(bpref.tipoPlanoReferencial){
                case "A": bpref.tipoPlanoReferencial        = "Analítica";break;
                case "S": bpref.tipoPlanoReferencial        = "Sintética";
                          bpref.descricaoPlanoReferencial   = bpref.descricaoPlanoReferencial.toUpperCase();break;
            }
            
            NivelPlanoDeContas  = String.valueOf(bpla.nivelPlanoDeContas);
            NivelReferencial    = String.valueOf(bpref.nivel);
            
            if(bpla.nivelPlanoDeContas == 0)NivelPlanoDeContas  = "";
            if(bpref.nivel == 0)            NivelReferencial    = "";
            
            TablePlanoDeContas.addRow(new Object[] {bpla.codigoPlanoDeContas, NivelPlanoDeContas, bpla.tipoPlanoDeContas, bpla.descricaoPlanoDeContas.toUpperCase(), bpref.codigoPlanoReferencial, NivelReferencial, bpref.tipoPlanoReferencial, bpref.descricaoPlanoReferencial.toUpperCase()});
        }
        if(tabela_planodecontas.getRowCount() > 0)
            bt_exportar.setEnabled(true);
    }
    
    private void PegaPlanoReferencial(){
        if(bpref.idPlanoReferencial == 0)
            return;
        sql = "select * from ns_plano_referencial where idPlanoReferencial = " + bpref.idPlanoReferencial + ";";
        dadosPlanoReferencial.clear();
        dadosPlanoReferencial = parametrosNS.dao.Consulta(sql);
        if(dadosPlanoReferencial.isEmpty())
            return;
        PegaDadosPlanoReferencial();
    }
    
    private void PegaDadosPlanoReferencial(){
        for(int i = 0; i < dadosPlanoReferencial.size(); i++){
            if(dadosPlanoReferencial.get(i).get(0) != null)
                bpref.idPlanoReferencial                = Integer.parseInt(  String.valueOf(dadosPlanoReferencial.get(i).get(0)));
            if(dadosPlanoReferencial.get(i).get(1) != null)
                bpref.codigoGrupo                       = Integer.parseInt(  String.valueOf(dadosPlanoReferencial.get(i).get(1)));
                bpref.codigoPlanoReferencial            =                    String.valueOf(dadosPlanoReferencial.get(i).get(2));
                bpref.descricaoPlanoReferencial         =                    String.valueOf(dadosPlanoReferencial.get(i).get(3));
                bpref.dataInicial                       =                    String.valueOf(dadosPlanoReferencial.get(i).get(4));
                bpref.dataFinal                         =                    String.valueOf(dadosPlanoReferencial.get(i).get(5));
                bpref.tipoPlanoReferencial              =                    String.valueOf(dadosPlanoReferencial.get(i).get(6));
                bpref.codigoPlanoReferencialSuperior    =                    String.valueOf(dadosPlanoReferencial.get(i).get(7));
            if(dadosPlanoReferencial.get(i).get(9) != null)
                bpref.nivel                             = Integer.parseInt(  String.valueOf(dadosPlanoReferencial.get(i).get(8)));
            if(dadosPlanoReferencial.get(i).get(10) != null)
                bpref.natureza                          = Integer.parseInt(  String.valueOf(dadosPlanoReferencial.get(i).get(9)));
                bpref.orientacoes                       =                    String.valueOf(dadosPlanoReferencial.get(i).get(10));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_detalhes = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_planodecontas = new javax.swing.JTable();
        txt_codigoPlanoDeContas = new javax.swing.JTextField();
        txt_nivelPlanoDeContas = new javax.swing.JFormattedTextField();
        txt_tipoPlanoDeContas = new javax.swing.JFormattedTextField();
        txt_descricaoPlanoDeContas = new javax.swing.JTextField();
        bt_sair = new javax.swing.JButton();
        bt_exportar = new javax.swing.JButton();
        jMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_cadastrarPlanoDeContas = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();

        bt_detalhes.setText("Detalhes");
        bt_detalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_detalhesActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_detalhes);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Plano de Contas");
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
        jLabel1.setText("Consulta Plano de Contas");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_planodecontas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Conta", "Nível", "Tipo", "Descrição", "N° Conta Referencial", "Nível", "Tipo", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_planodecontas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_planodecontas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_planodecontas.getTableHeader().setReorderingAllowed(false);
        tabela_planodecontas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_planodecontasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_planodecontas);
        if (tabela_planodecontas.getColumnModel().getColumnCount() > 0) {
            tabela_planodecontas.getColumnModel().getColumn(0).setResizable(false);
            tabela_planodecontas.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabela_planodecontas.getColumnModel().getColumn(1).setResizable(false);
            tabela_planodecontas.getColumnModel().getColumn(1).setPreferredWidth(40);
            tabela_planodecontas.getColumnModel().getColumn(2).setResizable(false);
            tabela_planodecontas.getColumnModel().getColumn(2).setPreferredWidth(50);
            tabela_planodecontas.getColumnModel().getColumn(3).setResizable(false);
            tabela_planodecontas.getColumnModel().getColumn(3).setPreferredWidth(350);
            tabela_planodecontas.getColumnModel().getColumn(4).setResizable(false);
            tabela_planodecontas.getColumnModel().getColumn(4).setPreferredWidth(100);
            tabela_planodecontas.getColumnModel().getColumn(5).setResizable(false);
            tabela_planodecontas.getColumnModel().getColumn(5).setPreferredWidth(40);
            tabela_planodecontas.getColumnModel().getColumn(6).setResizable(false);
            tabela_planodecontas.getColumnModel().getColumn(6).setPreferredWidth(50);
            tabela_planodecontas.getColumnModel().getColumn(7).setResizable(false);
            tabela_planodecontas.getColumnModel().getColumn(7).setPreferredWidth(350);
        }

        txt_codigoPlanoDeContas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoPlanoDeContasKeyReleased(evt);
            }
        });

        try {
            txt_nivelPlanoDeContas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_nivelPlanoDeContas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nivelPlanoDeContas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nivelPlanoDeContasKeyReleased(evt);
            }
        });

        try {
            txt_tipoPlanoDeContas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("*")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_tipoPlanoDeContas.setToolTipText("(A) - Analítica   (S) - Sintética");
        txt_tipoPlanoDeContas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_tipoPlanoDeContasKeyReleased(evt);
            }
        });

        txt_descricaoPlanoDeContas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_descricaoPlanoDeContasKeyReleased(evt);
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
                        .addComponent(txt_codigoPlanoDeContas, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nivelPlanoDeContas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tipoPlanoDeContas, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_descricaoPlanoDeContas, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 64, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoPlanoDeContas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nivelPlanoDeContas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tipoPlanoDeContas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_descricaoPlanoDeContas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

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

        bt_cadastrarPlanoDeContas.setText("Cadastro Plano de Contas");
        bt_cadastrarPlanoDeContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastrarPlanoDeContasActionPerformed(evt);
            }
        });
        jMenu1.add(bt_cadastrarPlanoDeContas);
        jMenu1.add(jSeparator1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        jMenuItem2.setText("Sair");
        jMenu1.add(jMenuItem2);

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
                    .addComponent(bt_exportar, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_exportar, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        TablePlanoDeContas = (DefaultTableModel)tabela_planodecontas.getModel();
        sql = "select * from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " order by codigoPlanoDeContas asc;";
        PegaPlanoDeContas();
        
        if(parametrosNS.bu.nivelUsuario  < 4 | somostra.equals("S"))
            jMenu.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void txt_codigoPlanoDeContasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContasKeyReleased
        bpla.codigoPlanoDeContas = txt_codigoPlanoDeContas.getText();
        if(bpla.codigoPlanoDeContas.equals("")){
            sql = "select * from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " order by codigoPlanoDeContas asc;";
            PegaPlanoDeContas();
            return;
        }
        bpla.codigoPlanoDeContas = bpla.codigoPlanoDeContas.replace(".", "");
        sql = "select * from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and codigoPlanoDeContas like '%" + bpla.codigoPlanoDeContas + "%' order by codigoPlanoDeContas asc;";
        PegaPlanoDeContas();
    }//GEN-LAST:event_txt_codigoPlanoDeContasKeyReleased

    private void txt_nivelPlanoDeContasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nivelPlanoDeContasKeyReleased
        bpla.nivelPlanoDeContas = Integer.parseInt(fc.FormataCampo(txt_nivelPlanoDeContas.getText(), 1, 0));
        if(bpla.nivelPlanoDeContas == 0){
            sql = "select * from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " order by codigoPlanoDeContas asc;";
            PegaPlanoDeContas();
            return;
        }
        sql = "select * from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and nivelPlanoDeContas = " + bpla.nivelPlanoDeContas + " order by codigoPlanoDeContas asc";
        PegaPlanoDeContas();
    }//GEN-LAST:event_txt_nivelPlanoDeContasKeyReleased

    private void txt_tipoPlanoDeContasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tipoPlanoDeContasKeyReleased
        bpla.tipoPlanoDeContas = txt_tipoPlanoDeContas.getText().replace(" ", "");
        if(bpla.tipoPlanoDeContas.equals("")){
            sql = "select * from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " order by codigoPlanoDeContas asc;";
            PegaPlanoDeContas();
            return;
        }
        sql = "select * from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and tipoPlanoDeContas = '" + bpla.tipoPlanoDeContas + "' order by codigoPlanoDeContas asc;";
        PegaPlanoDeContas();
    }//GEN-LAST:event_txt_tipoPlanoDeContasKeyReleased

    private void txt_descricaoPlanoDeContasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descricaoPlanoDeContasKeyReleased
        bpla.descricaoPlanoDeContas = txt_descricaoPlanoDeContas.getText();
        if(bpla.descricaoPlanoDeContas.equals("")){
            sql = "select * from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " order by codigoPlanoDeContas asc;";
            PegaPlanoDeContas();
            return;
        }
        sql = "select * from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and descricaoPlanoDeContas like '%" + bpla.descricaoPlanoDeContas + "%' order by codigoPlanoDeContas asc;";
        PegaPlanoDeContas();
    }//GEN-LAST:event_txt_descricaoPlanoDeContasKeyReleased

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void tabela_planodecontasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_planodecontasMouseClicked
        Linha = tabela_planodecontas.getSelectedRow();
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
        retorno = fcad.FormataCampoADireita(String.valueOf(tabela_planodecontas.getValueAt(Linha, 0)).replace(".", ""), 11, 0);
        if(evt.getClickCount() < 2)
            return;
        dispose();
    }//GEN-LAST:event_tabela_planodecontasMouseClicked

    private void bt_exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_exportarActionPerformed
        SeletorExcel = new JFileChooser();
        SalvarExcel = SeletorExcel.showSaveDialog(tabela_planodecontas);
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
            new ExportarParaExcel(tabela_planodecontas, new File(LocalArquivo), 0, 0, 0);
        } catch (IOException erro) {
            Mensagem = "Erro: " + erro.getMessage();
            new MostraMensagem(Mensagem);
        }
    }//GEN-LAST:event_bt_exportarActionPerformed

    private void bt_detalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesActionPerformed
        if(PlaDeConCad != null)if(PlaDeConCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("S");
        parametros.add(retorno);
        PlaDeConCad = new PlanoDeContasCadastro(parametros);
        PlaDeConCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesActionPerformed

    private void bt_cadastrarPlanoDeContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastrarPlanoDeContasActionPerformed
        if(PlaDeConCad != null)if(PlaDeConCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuPlanoDeContas = 1;
        parametros.clear();
        parametros.add("SN");
        parametros.add("");
        PlaDeConCad = new PlanoDeContasCadastro(parametros);
        PlaDeConCad.setVisible(true);
    }//GEN-LAST:event_bt_cadastrarPlanoDeContasActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
        if(abriuPlanoDeContas == 0)
            return;
        abriuPlanoDeContas = 0;
        sql = "select * from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " order by codigoPlanoDeContas asc;";
        PegaPlanoDeContas();
    }//GEN-LAST:event_formWindowGainedFocus

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(PlaDeConCad  != null)PlaDeConCad.dispose();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_cadastrarPlanoDeContas;
    private javax.swing.JMenuItem bt_detalhes;
    private javax.swing.JButton bt_exportar;
    private javax.swing.JButton bt_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable tabela_planodecontas;
    private javax.swing.JTextField txt_codigoPlanoDeContas;
    private javax.swing.JTextField txt_descricaoPlanoDeContas;
    private javax.swing.JFormattedTextField txt_nivelPlanoDeContas;
    private javax.swing.JFormattedTextField txt_tipoPlanoDeContas;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
}
