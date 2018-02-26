package TelasContabil;

import Beans.BeanParametrosContabil;
import Beans.BeanPlanoDeContas;
import Beans.BeanPlanoDeContasMovimentos;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.TransformaValorStringeDouble;
import Parametros.parametrosNS;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

/*
 @author Tiago e Paulo
 */
public class MovimentoContabilConsulta extends javax.swing.JFrame {
    //String's
    String sql                              = "";
    String sql1                             = "";
    String sqlstate                         = "";
    String Mensagem                         = "";
    String somostra                         = "";
    String retorno                          = "";
    String DataInicial                      = "";
    String DataFinal                        = "";
    
    //int's
    int    geral                            = 0;
    
    //double's
    double SaldoInicialPorMes               = 0;
    double SaldoFinalPorMes                 = 0;
    
    //Vetores
    ArrayList            parametros                    = new ArrayList();
    ArrayList            dadosPadroes                  = new ArrayList();
    ArrayList<ArrayList> dadosPlanoDeContas            = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosParametrosContabil       = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosPlanoDeContasMovimentos  = new ArrayList<ArrayList>();
    
    //Bean's
    BeanPlanoDeContas               bpla    = new BeanPlanoDeContas();
    BeanPlanoDeContasMovimentos     bplamov = new BeanPlanoDeContasMovimentos();
    BeanParametrosContabil          bparcon = new BeanParametrosContabil();
    
    //Especiais
    FormataCampo                    fc          = new FormataCampo();
    InverterData                    invdata     = new InverterData();
    CapturarDataHora                cdh         = new CapturarDataHora();
    TransformaValorStringeDouble    TransStrDou = new TransformaValorStringeDouble();
    
    //DefaultMutableTreeNode
    DefaultMutableTreeNode          ItemSelecionadoArvore;
    DefaultMutableTreeNode          Arvore_Contabil = new DefaultMutableTreeNode("Planos De Contas");
    DefaultMutableTreeNode          Arvore_Contabil1;
    DefaultMutableTreeNode          Arvore_Contabil2;
    DefaultMutableTreeNode          Arvore_Contabil3;
    DefaultMutableTreeNode          Arvore_Contabil4;
    DefaultMutableTreeNode          Arvore_Contabil5;
    DefaultMutableTreeNode          Arvore_Contabil6;
    
    //Telas
    
    public MovimentoContabilConsulta(ArrayList DadosPadroes){
        dadosPadroes                        = DadosPadroes;
        
        somostra                            = (String)  dadosPadroes.get(0);
        
        initComponents();
        sql         = "select * from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " order by codigoPlanoDeContas asc;";
        Mensagem    = "Não foram encontrados Planos de Contas cadastrados para a Empresa: " + fc.FormataCampo(String.valueOf(parametrosNS.bge.CodigoGrupo), 2, 0) + "." + fc.FormataCampo(String.valueOf(parametrosNS.be.CodigoEmpresa), 3, 0) + " - " + parametrosNS.be.nomeEmpresa;
        PegaPlanoDeContas("S");
    }
    
    private void PegaPlanoDeContas(String Mostra){
        arvore_contabil.removeAll();
        dadosPlanoDeContas.clear();
        dadosPlanoDeContas = parametrosNS.dao.Consulta(sql);
        if(dadosPlanoDeContas.isEmpty()){
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosPlanoDeContas(Mostra);
    }
    
    private void PegaDadosPlanoDeContas(String Mostra){
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
            
            if(Mostra.equals("SN")){PegaPlanoDeContasMovimentos();continue;}
            if(Mostra.equals("N"))  continue;
            
            bpla.RecarregaCodigosPlanosDeContas();
            bpla.RecarregaPlanoDeContas("S", "S");
            
            bpla.descricaoPlanoDeContas         = bpla.codigoPlanoDeContas + " - " + bpla.descricaoPlanoDeContas;
            
            if(bpla.nivelPlanoDeContas == 1)Arvore_Contabil1 = new DefaultMutableTreeNode(bpla.descricaoPlanoDeContas);
            if(bpla.nivelPlanoDeContas == 2)Arvore_Contabil2 = new DefaultMutableTreeNode(bpla.descricaoPlanoDeContas);
            if(bpla.nivelPlanoDeContas == 3)Arvore_Contabil3 = new DefaultMutableTreeNode(bpla.descricaoPlanoDeContas);
            if(bpla.nivelPlanoDeContas == 4)Arvore_Contabil4 = new DefaultMutableTreeNode(bpla.descricaoPlanoDeContas);
            if(bpla.nivelPlanoDeContas == 5)Arvore_Contabil5 = new DefaultMutableTreeNode(bpla.descricaoPlanoDeContas);
            if(bpla.nivelPlanoDeContas == 6)Arvore_Contabil6 = new DefaultMutableTreeNode(bpla.descricaoPlanoDeContas);
            
            if(bpla.nivelPlanoDeContas == 1){Arvore_Contabil.add(Arvore_Contabil1);arvore_contabil.setModel(new javax.swing.tree.DefaultTreeModel(Arvore_Contabil));}
            if(bpla.nivelPlanoDeContas == 2)Arvore_Contabil1.add(Arvore_Contabil2);
            if(bpla.nivelPlanoDeContas == 3)Arvore_Contabil2.add(Arvore_Contabil3);
            if(bpla.nivelPlanoDeContas == 4)Arvore_Contabil3.add(Arvore_Contabil4);
            if(bpla.nivelPlanoDeContas == 5)Arvore_Contabil4.add(Arvore_Contabil5);
            if(bpla.nivelPlanoDeContas == 6)Arvore_Contabil5.add(Arvore_Contabil6);
        }
        if(Mostra.equals("S"))  return;
        if(Mostra.equals("SN")) return;
        txt_tipoPlanoDeContas           .setText(bpla.tipoPlanoDeContas);
        txt_nivelPlanoDeContas          .setText(String.valueOf(bpla.nivelPlanoDeContas));
        bpla.RecarregaCodigosPlanosDeContasSuperior();
        bpla.RecarregaPlanoDeContasSuperior("S");
        txt_codigoPlanoDeContasSuperior .setText(bpla.codigoPlanoDeContasSuperior);
        txt_descricaoPlanoDeContas      .setText(bpla.descricaoPlanoDeContas);
    }
    
    private void PegaParametrosContabil(){
        sql = "select * from tb_parametroscontabil where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + ";";
        dadosParametrosContabil.clear();
        dadosParametrosContabil = parametrosNS.dao.Consulta(sql);
        if(dadosParametrosContabil.isEmpty()){
            bparcon.dataContabil    = cdh.CapturarData();
            bparcon.dataContabil    = bparcon.dataContabil.replace("/", "");
            return;
        }
        PegaDadosParametrosContabil();
    }
    
    private void PegaDadosParametrosContabil(){
        for(int i = 0; i < dadosParametrosContabil.size(); i++){
            bparcon.idParametrosContabil    = Integer.parseInt(  String.valueOf(dadosParametrosContabil.get(i).get(0)));
            bparcon.idEmpresa               = Integer.parseInt(  String.valueOf(dadosParametrosContabil.get(i).get(1)));
            bparcon.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosParametrosContabil.get(i).get(2)));
            bparcon.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosParametrosContabil.get(i).get(3)));
            bparcon.dataContabil            =                    String.valueOf(dadosParametrosContabil.get(i).get(4));
        }
        bparcon.dataContabil    = invdata.inverterData(bparcon.dataContabil, 1);
        bparcon.dataContabil    = bparcon.dataContabil.replace("/", "");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        arvore_contabil = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_valores = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_tipoPlanoDeContas = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_nivelPlanoDeContas = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_codigoPlanoDeContasSuperior = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_descricaoPlanoDeContas = new javax.swing.JTextArea();

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

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        arvore_contabil.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        arvore_contabil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arvore_contabilMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(arvore_contabil);

        tabela_valores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"01-Janeiro", null, null},
                {"02-Fevereiro", null, null},
                {"03-Março", null, null},
                {"04-Abril", null, null},
                {"05-Maio", null, null},
                {"06-Junho", null, null},
                {"07-Julho", null, null},
                {"08-Agosto", null, null},
                {"09-Setembro", null, null},
                {"10-Outubro", null, null},
                {"11-Novembro", null, null},
                {"12-Dezembro", null, null}
            },
            new String [] {
                "Mês", "Saldo Inicial", "Saldo Final"
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
        tabela_valores.setEnabled(false);
        tabela_valores.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabela_valores);
        if (tabela_valores.getColumnModel().getColumnCount() > 0) {
            tabela_valores.getColumnModel().getColumn(0).setResizable(false);
            tabela_valores.getColumnModel().getColumn(0).setPreferredWidth(60);
            tabela_valores.getColumnModel().getColumn(1).setResizable(false);
            tabela_valores.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabela_valores.getColumnModel().getColumn(2).setResizable(false);
            tabela_valores.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Informações");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Tipo:");

        txt_tipoPlanoDeContas.setEditable(false);
        try {
            txt_tipoPlanoDeContas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("*")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_tipoPlanoDeContas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_tipoPlanoDeContas.setToolTipText("(A) - Analítica   (S) - Sintética");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nível:");

        txt_nivelPlanoDeContas.setEditable(false);
        try {
            txt_nivelPlanoDeContas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_nivelPlanoDeContas.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Conta Superior:");

        txt_codigoPlanoDeContasSuperior.setEditable(false);

        txt_descricaoPlanoDeContas.setEditable(false);
        txt_descricaoPlanoDeContas.setColumns(20);
        txt_descricaoPlanoDeContas.setLineWrap(true);
        txt_descricaoPlanoDeContas.setRows(5);
        jScrollPane3.setViewportView(txt_descricaoPlanoDeContas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_tipoPlanoDeContas, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                            .addComponent(txt_nivelPlanoDeContas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_codigoPlanoDeContasSuperior))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_tipoPlanoDeContas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_nivelPlanoDeContas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_codigoPlanoDeContasSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, txt_codigoPlanoDeContasSuperior, txt_nivelPlanoDeContas, txt_tipoPlanoDeContas});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void arvore_contabilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arvore_contabilMouseClicked
        PegaPlanoDeContasSelecionado();
    }//GEN-LAST:event_arvore_contabilMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        PegaParametrosContabil();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
    }//GEN-LAST:event_formWindowGainedFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arvore_contabil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabela_valores;
    private javax.swing.JTextField txt_codigoPlanoDeContasSuperior;
    private javax.swing.JTextArea txt_descricaoPlanoDeContas;
    private javax.swing.JFormattedTextField txt_nivelPlanoDeContas;
    private javax.swing.JFormattedTextField txt_tipoPlanoDeContas;
    // End of variables declaration//GEN-END:variables
    
    private void ReiniciaTabela(){
        for(int i = 0; i < tabela_valores.getRowCount(); i++){
            for(int j = 1; j < tabela_valores.getColumnCount(); j++){
                tabela_valores.setValueAt("", i, j);
            }
        }
        txt_tipoPlanoDeContas           .setText("");
        txt_nivelPlanoDeContas          .setText("");
        txt_codigoPlanoDeContasSuperior .setText("");
        txt_descricaoPlanoDeContas      .setText("");
    }
    
    private void PegaPlanoDeContasSelecionado(){
        geral = 0;
        ItemSelecionadoArvore = (DefaultMutableTreeNode)arvore_contabil.getLastSelectedPathComponent();
        if(ItemSelecionadoArvore == null)
            return;
        bpla.codigoPlanoDeContas = ItemSelecionadoArvore.toString();
        ReiniciaTabela();
        if(bpla.codigoPlanoDeContas.equals("Planos De Contas"))
            geral = 1;
        bpla.codigoPlanoDeContas    = bpla.codigoPlanoDeContas.replace(".", "");
        if(bpla.codigoPlanoDeContas.indexOf("-") ==  2){
            bpla.codigoPlanoDeContas = bpla.codigoPlanoDeContas.substring(0, 1);
        }
        if(bpla.codigoPlanoDeContas.indexOf("-") ==  3){
            bpla.codigoPlanoDeContas = bpla.codigoPlanoDeContas.substring(0, 2);
        }
        if(bpla.codigoPlanoDeContas.indexOf("-") ==  4){
            bpla.codigoPlanoDeContas = bpla.codigoPlanoDeContas.substring(0, 3);
        }
        if(bpla.codigoPlanoDeContas.indexOf("-") ==  6){
            bpla.codigoPlanoDeContas = bpla.codigoPlanoDeContas.substring(0, 5);
        }
        if(bpla.codigoPlanoDeContas.indexOf("-") ==  8){
            bpla.codigoPlanoDeContas = bpla.codigoPlanoDeContas.substring(0, 7);
        }
        if(bpla.codigoPlanoDeContas.indexOf("-") == 12){
            bpla.codigoPlanoDeContas = bpla.codigoPlanoDeContas.substring(0, 11);
        }
        
        bpla.CarregaPlanoDeContas();
        
        sql         = "select * from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and codigoPlanoDeContas = '" + bpla.codigoPlanoDeContas + "';";
        if(geral == 1)sql = "select * from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + ";";
        if(geral != 1){
            Mensagem    = "Não foi encontrado o Planos de Contas n°" + bpla.codigoPlanoDeContas + " cadastrado para a Empresa: " + fc.FormataCampo(String.valueOf(parametrosNS.bge.CodigoGrupo), 2, 0) + "." + fc.FormataCampo(String.valueOf(parametrosNS.be.CodigoEmpresa), 3, 0) + " - " + parametrosNS.be.nomeEmpresa;
            PegaPlanoDeContas("N");
            if(bpla.nivelPlanoDeContas == 1)sql = "select * from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and substring(codigoPlanoDeContas, 1, 1) = '" + bpla.codigoPlanoDeContas.substring(0, 1) + "';";
            if(bpla.nivelPlanoDeContas == 2)sql = "select * from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and substring(codigoPlanoDeContas, 1, 2) = '" + bpla.codigoPlanoDeContas.substring(0, 2) + "';";
            if(bpla.nivelPlanoDeContas == 3)sql = "select * from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and substring(codigoPlanoDeContas, 1, 3) = '" + bpla.codigoPlanoDeContas.substring(0, 3) + "';";
            if(bpla.nivelPlanoDeContas == 4)sql = "select * from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and substring(codigoPlanoDeContas, 1, 5) = '" + bpla.codigoPlanoDeContas.substring(0, 5) + "';";
            if(bpla.nivelPlanoDeContas == 5)sql = "select * from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and substring(codigoPlanoDeContas, 1, 7) = '" + bpla.codigoPlanoDeContas.substring(0, 7) + "';";
        }
        PegaSaldoPlanoDeContasSelecionado();
    }
    
    private void PegaSaldoPlanoDeContasSelecionado(){
        for(int i = 0; i < Integer.parseInt(bparcon.dataContabil.substring(2, 4)); i++){
            SaldoInicialPorMes  = 0;
            SaldoFinalPorMes    = 0;
            DataInicial             = bparcon.dataContabil.substring(4, 8) + "-" + String.valueOf(tabela_valores.getValueAt(i, 0)).substring(0, 2) + "-01";
            DataFinal               = bparcon.dataContabil.substring(4, 8) + "-" + String.valueOf(tabela_valores.getValueAt(i, 0)).substring(0, 2) + "-31";
            
            if(geral == 0){PegaPlanoDeContas("SN");}else{PegaPlanoDeContasMovimentos();}
            
            tabela_valores.setValueAt(TransStrDou.TransformaValorStringeDouble(String.valueOf(SaldoInicialPorMes)   , 0), i, 1);
            tabela_valores.setValueAt(TransStrDou.TransformaValorStringeDouble(String.valueOf(SaldoFinalPorMes)     , 0), i, 2);
        }
    }
    
    private void PegaPlanoDeContasMovimentos(){
        bplamov.codigoPlanoDeContas = bpla.codigoPlanoDeContas;
        sql1 = "select * from tb_planodecontasmovimentos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoPlanoDeContas = " + bplamov.codigoPlanoDeContas + " and dataPlanoDeContas between '" + DataInicial + "' and '" + DataFinal + "' order by dataPlanoDeContas asc;";
        if(geral == 1)sql1 = "select * from tb_planodecontasmovimentos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and dataPlanoDeContas between '" + DataInicial + "' and '" + DataFinal + "' order by dataPlanoDeContas asc;";
        dadosPlanoDeContasMovimentos.clear();
        dadosPlanoDeContasMovimentos = parametrosNS.dao.Consulta(sql1);
        PegaDadosPlanoDeContasMovimentos();
    }
    
    private void PegaDadosPlanoDeContasMovimentos(){
        for(int i = 0; i < dadosPlanoDeContasMovimentos.size(); i++){
            bplamov.idPlanoDeContasMovimentos   = Integer.parseInt(  String.valueOf(dadosPlanoDeContasMovimentos.get(i).get(0)));
            bplamov.idEmpresa                   = Integer.parseInt(  String.valueOf(dadosPlanoDeContasMovimentos.get(i).get(1)));
            bplamov.codigoGrupo                 = Integer.parseInt(  String.valueOf(dadosPlanoDeContasMovimentos.get(i).get(2)));
            bplamov.codigoEmpresa               = Integer.parseInt(  String.valueOf(dadosPlanoDeContasMovimentos.get(i).get(3)));
            bplamov.codigoPlanoDeContas         =                    String.valueOf(dadosPlanoDeContasMovimentos.get(i).get(4));
            bplamov.dataPlanoDeContas           =                    String.valueOf(dadosPlanoDeContasMovimentos.get(i).get(5));
            bplamov.saldo                       = Double.parseDouble(String.valueOf(dadosPlanoDeContasMovimentos.get(i).get(6)));
            
            if(i == 0)SaldoInicialPorMes       += bplamov.saldo;
            SaldoFinalPorMes                   += bplamov.saldo;
        }
    }
    
}
