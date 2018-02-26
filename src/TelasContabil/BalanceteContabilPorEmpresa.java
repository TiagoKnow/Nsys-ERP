package TelasContabil;

import Beans.BeanIntervalos;
import Beans.BeanParametrosContabil;
import Beans.BeanPlanoDeContas;
import Beans.BeanPlanoDeContasMovimentos;
import BeansNS.BeanEmpresas;
import BeansNS.BeanGrupoEmpresa;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.ColorirFonteTabela;
import FuncoesInternas.ExportarParaExcel;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.TransformaValorStringeDouble;
import TelasDeConfiguracoes.EmpresasConsulta;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
/*
 @author Tiago e Paulo 20/02/2017 16:11
 */
public class BalanceteContabilPorEmpresa extends javax.swing.JFrame {
    //String
    String sql                                  = "";
    String Mensagem                             = "";
    String sqlstate                             = "";
    String somostra                             = "";
    String retorno                              = "";
    String Campo                                = "";
    String pegouMovimentos                      = "N";
    
    //int
    int    Linha                                = 0;
    int    j                                    = 0;
    int    nivelPlanoDeContas                   = 0;
    int    abriuPlanoDeContas                   = 0;
    int    abriuEmpresa                         = 0;
    
    //Vetores
    ArrayList            parametros                        = new ArrayList();
    ArrayList            dadosPadroes                      = new ArrayList();
    ArrayList            dadosSaldoGrupo                   = new ArrayList();
    ArrayList            dadosSaldoEmpresa                 = new ArrayList();
    ArrayList            dadosSaldoNivel1                  = new ArrayList();
    ArrayList            dadosSaldoNivel2                  = new ArrayList();
    ArrayList            dadosSaldoNivel3                  = new ArrayList();
    ArrayList            dadosSaldoNivel4                  = new ArrayList();
    ArrayList            dadosSaldoNivel5                  = new ArrayList();
    
    //ArrayList's<ArrayList>
    ArrayList<ArrayList> dadosGrupos                       = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosEmpresas                     = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosParametrosContabil           = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosPlanoDeContas                = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosPlanoDeContasMovimentos      = new ArrayList<ArrayList>();
    
    //Beans
    BeanEmpresas                    be          = new BeanEmpresas();
    BeanGrupoEmpresa                bge         = new BeanGrupoEmpresa();
    BeanIntervalos                  binter      = new BeanIntervalos();
    BeanPlanoDeContas               bpla        = new BeanPlanoDeContas();
    BeanPlanoDeContasMovimentos     bplamov     = new BeanPlanoDeContasMovimentos();
    BeanParametrosContabil          bparcon     = new BeanParametrosContabil();
    
    //Especiais
    FormataCampo                    fc          = new FormataCampo();
    InverterData                    invdata     = new InverterData();
    CapturarDataHora                cdh         = new CapturarDataHora();
    TransformaValorStringeDouble    TransStrDou = new TransformaValorStringeDouble();
    DefaultTableModel               Table_Balancete;
    
    //Especiais para Excportação em Excel
    JFileChooser                    SeletorExcel;
    String                          NomeArquivoExcel    = "";
    String                          LocalArquivo        = "";
    int                             SalvarExcel         = 0;
    
    //Telas
    PlanoDeContasConsulta           PlaDeConCon;
    EmpresasConsulta                EmpCon;
    
    public BalanceteContabilPorEmpresa(ArrayList DadosPadroes){
        dadosPadroes            = DadosPadroes;
        
        somostra                = (String)  dadosPadroes.get(0);
        
        initComponents();
    }
    
    private void InicializaCampos(){
        txt_codigoPlanoDeContasInicial  .setText(fc.FormataCampo("", 11, 0));
        txt_codigoPlanoDeContasFinal    .setText("99999999999");
        txt_codigoEmpresaInicial        .setText(fc.FormataCampo("", 3, 0));
        txt_codigoEmpresaFinal          .setText("999");
        combo_tipoConta                 .setSelectedIndex(0);
    }
    
    private void PegaParametrosContabil(){
        sql = "select * from tb_parametroscontabil where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosParametrosContabil.clear();
        dadosParametrosContabil = parametrosNS.dao.Consulta(sql);
        if(dadosParametrosContabil.isEmpty()){
            bparcon.dataContabil    = cdh.CapturarData().replace("/", "");
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
        bparcon.dataContabil    = invdata.inverterData(bparcon.dataContabil, 1).replace("/", "");
    }
    
    public void ColorirFonteTabela(){
        TableCellRenderer colorir = new ColorirFonteTabela(0);
        for(int i = 0; i < tabela_balancete.getColumnCount(); i++){;
            tabela_balancete.getColumnModel().getColumn(i).setCellRenderer(colorir);
        }
        tabela_balancete.updateUI();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_balancete = new javax.swing.JTable();
        bt_exportar = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_codigoPlanoDeContasInicial = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_codigoPlanoDeContasFinal = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_codigoEmpresaInicial = new javax.swing.JFormattedTextField();
        bt_pesquisaPlanoDeContasFinal = new javax.swing.JButton();
        bt_pesquisaPlanoDeContasInicial = new javax.swing.JButton();
        txt_codigoEmpresaFinal = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        combo_tipoConta = new javax.swing.JComboBox<>();
        bt_pesquisaEmpresaInicial = new javax.swing.JButton();
        bt_pesquisaEmpresaFinal = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        check_todasUnidades = new javax.swing.JCheckBox();
        bt_processa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Balancete Contábil");
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
        jLabel1.setText("Balancete Contábil");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_balancete.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Nível", "Descrição", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_balancete.setShowVerticalLines(false);
        tabela_balancete.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabela_balancete);
        if (tabela_balancete.getColumnModel().getColumnCount() > 0) {
            tabela_balancete.getColumnModel().getColumn(0).setResizable(false);
            tabela_balancete.getColumnModel().getColumn(1).setResizable(false);
            tabela_balancete.getColumnModel().getColumn(3).setResizable(false);
            tabela_balancete.getColumnModel().getColumn(4).setResizable(false);
            tabela_balancete.getColumnModel().getColumn(5).setResizable(false);
            tabela_balancete.getColumnModel().getColumn(6).setResizable(false);
            tabela_balancete.getColumnModel().getColumn(7).setResizable(false);
            tabela_balancete.getColumnModel().getColumn(8).setResizable(false);
            tabela_balancete.getColumnModel().getColumn(9).setResizable(false);
            tabela_balancete.getColumnModel().getColumn(10).setResizable(false);
            tabela_balancete.getColumnModel().getColumn(11).setResizable(false);
            tabela_balancete.getColumnModel().getColumn(12).setResizable(false);
            tabela_balancete.getColumnModel().getColumn(13).setResizable(false);
            tabela_balancete.getColumnModel().getColumn(14).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addContainerGap())
        );

        bt_exportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Table.png"))); // NOI18N
        bt_exportar.setText("Exportar");
        bt_exportar.setEnabled(false);
        bt_exportar.setFocusable(false);
        bt_exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_exportarActionPerformed(evt);
            }
        });

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Intervalos de Consulta     F11[Geral]");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Plano de Contas:");

        try {
            txt_codigoPlanoDeContasInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.#.#.##.##.####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoPlanoDeContasInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoPlanoDeContasInicial.setText("0.0.0.00.00.0000");
        txt_codigoPlanoDeContasInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoDeContasInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoDeContasInicialFocusLost(evt);
            }
        });
        txt_codigoPlanoDeContasInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoPlanoDeContasInicialKeyPressed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Inicial");

        try {
            txt_codigoPlanoDeContasFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.#.#.##.##.####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoPlanoDeContasFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoPlanoDeContasFinal.setText("9.9.9.99.99.9999");
        txt_codigoPlanoDeContasFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoDeContasFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoDeContasFinalFocusLost(evt);
            }
        });
        txt_codigoPlanoDeContasFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoPlanoDeContasFinalKeyPressed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Final");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Empresa:");

        try {
            txt_codigoEmpresaInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoEmpresaInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoEmpresaInicial.setText("000");
        txt_codigoEmpresaInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoEmpresaInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoEmpresaInicialFocusLost(evt);
            }
        });
        txt_codigoEmpresaInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoEmpresaInicialKeyPressed(evt);
            }
        });

        bt_pesquisaPlanoDeContasFinal.setText("...");
        bt_pesquisaPlanoDeContasFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaPlanoDeContasFinalActionPerformed(evt);
            }
        });

        bt_pesquisaPlanoDeContasInicial.setText("...");
        bt_pesquisaPlanoDeContasInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaPlanoDeContasInicialActionPerformed(evt);
            }
        });

        try {
            txt_codigoEmpresaFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoEmpresaFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoEmpresaFinal.setText("999");
        txt_codigoEmpresaFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoEmpresaFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoEmpresaFinalFocusLost(evt);
            }
        });
        txt_codigoEmpresaFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoEmpresaFinalKeyPressed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Inicial");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Final");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Tipo de conta:");

        combo_tipoConta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ambas", "Sintética", "Analítica" }));
        combo_tipoConta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_tipoContaItemStateChanged(evt);
            }
        });
        combo_tipoConta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo_tipoContaKeyPressed(evt);
            }
        });

        bt_pesquisaEmpresaInicial.setText("...");
        bt_pesquisaEmpresaInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaEmpresaInicialActionPerformed(evt);
            }
        });

        bt_pesquisaEmpresaFinal.setText("...");
        bt_pesquisaEmpresaFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaEmpresaFinalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_codigoPlanoDeContasInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisaPlanoDeContasInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_codigoPlanoDeContasFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisaPlanoDeContasFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(txt_codigoEmpresaInicial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisaEmpresaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_codigoEmpresaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_pesquisaEmpresaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(combo_tipoConta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(600, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, txt_codigoPlanoDeContasInicial});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel8, txt_codigoEmpresaFinal});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel6, jLabel9});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txt_codigoPlanoDeContasInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(txt_codigoEmpresaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bt_pesquisaPlanoDeContasFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_codigoPlanoDeContasFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bt_pesquisaPlanoDeContasInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_codigoEmpresaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_pesquisaEmpresaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_pesquisaEmpresaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(combo_tipoConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaEmpresaFinal, bt_pesquisaEmpresaInicial, bt_pesquisaPlanoDeContasFinal, bt_pesquisaPlanoDeContasInicial, combo_tipoConta, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, txt_codigoEmpresaFinal, txt_codigoEmpresaInicial, txt_codigoPlanoDeContasFinal, txt_codigoPlanoDeContasInicial});

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        check_todasUnidades.setText("Todas as Unidades");
        check_todasUnidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_todasUnidadesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(check_todasUnidades)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(check_todasUnidades)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bt_processa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/1280454766_system-software-update.png"))); // NOI18N
        bt_processa.setText("Processa");
        bt_processa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_processaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_processa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_exportar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_sair))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_exportar, bt_processa});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_exportar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_processa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_exportar, bt_processa, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        InicializaCampos();
        PegaParametrosContabil();
        
        if(parametrosNS.bu.nivelUsuario < 4){
            check_todasUnidades.setEnabled(false);
        }
        
        Table_Balancete = (DefaultTableModel)tabela_balancete.getModel();
        
        VerificaCheckBoxTodasUnidades();
        
        ColorirFonteTabela();
    }//GEN-LAST:event_formWindowOpened

    private void bt_exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_exportarActionPerformed
        SeletorExcel = new JFileChooser();
        SalvarExcel = SeletorExcel.showSaveDialog(tabela_balancete);
        if(SalvarExcel != JFileChooser.APPROVE_OPTION)
            return;
        NomeArquivoExcel    = SeletorExcel.getSelectedFile().getName();
        LocalArquivo        = SeletorExcel.getSelectedFile().getParentFile().getPath();
        String Extensao = "";
        if(NomeArquivoExcel.length() > 4)
            Extensao = NomeArquivoExcel.substring(NomeArquivoExcel.length() - 4, NomeArquivoExcel.length());
        if(Extensao.equals(".xls")) 
            LocalArquivo = LocalArquivo + "/" + NomeArquivoExcel;
        else
            LocalArquivo = LocalArquivo + "/" + NomeArquivoExcel + ".xls";
        try {
            new ExportarParaExcel(tabela_balancete, new File(LocalArquivo), 0, 0, 0);
        } catch (IOException erro) {
            Mensagem = "Erro: " + erro.getMessage();
            new MostraMensagem(Mensagem);
        }
    }//GEN-LAST:event_bt_exportarActionPerformed

    private void check_todasUnidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_todasUnidadesMouseClicked
        VerificaCheckBoxTodasUnidades();
    }//GEN-LAST:event_check_todasUnidadesMouseClicked

    private void txt_codigoPlanoDeContasInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContasInicialFocusLost
        try{
            if(String.valueOf(txt_codigoPlanoDeContasInicial.getText().replace(".", "")).length() < 11){
                txt_codigoPlanoDeContasInicial.setText(fc.FormataCampo("", 11, 0));
            }
        }catch(Exception erro){
            
        }
    }//GEN-LAST:event_txt_codigoPlanoDeContasInicialFocusLost

    private void txt_codigoPlanoDeContasFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContasFinalFocusLost
        try{
            if(String.valueOf(txt_codigoPlanoDeContasFinal.getText().replace(".", "")).length() < 11){
                txt_codigoPlanoDeContasFinal.setText(fc.FormataCampo("", 11, 0));
            }
        }catch(Exception erro){
            
        }
    }//GEN-LAST:event_txt_codigoPlanoDeContasFinalFocusLost

    private void txt_codigoEmpresaInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoEmpresaInicialFocusLost
        txt_codigoEmpresaInicial.setText(fc.FormataCampo(txt_codigoEmpresaInicial.getText(), 3, 0));
    }//GEN-LAST:event_txt_codigoEmpresaInicialFocusLost

    private void txt_codigoEmpresaFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoEmpresaFinalFocusLost
        txt_codigoEmpresaFinal.setText(fc.FormataCampo(txt_codigoEmpresaFinal.getText(), 3, 0));
    }//GEN-LAST:event_txt_codigoEmpresaFinalFocusLost

    private void txt_codigoPlanoDeContasInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContasInicialFocusGained
        txt_codigoPlanoDeContasInicial.setSelectionStart(0);
        txt_codigoPlanoDeContasInicial.setSelectionEnd  (txt_codigoPlanoDeContasInicial.getText().length());
    }//GEN-LAST:event_txt_codigoPlanoDeContasInicialFocusGained

    private void txt_codigoPlanoDeContasFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContasFinalFocusGained
        txt_codigoPlanoDeContasFinal.setSelectionStart(0);
        txt_codigoPlanoDeContasFinal.setSelectionEnd  (txt_codigoPlanoDeContasFinal.getText().length());
    }//GEN-LAST:event_txt_codigoPlanoDeContasFinalFocusGained

    private void txt_codigoEmpresaInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoEmpresaInicialFocusGained
        txt_codigoEmpresaInicial.setSelectionStart(0);
        txt_codigoEmpresaInicial.setSelectionEnd  (txt_codigoEmpresaInicial.getText().length());
    }//GEN-LAST:event_txt_codigoEmpresaInicialFocusGained

    private void txt_codigoEmpresaFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoEmpresaFinalFocusGained
        txt_codigoEmpresaFinal.setSelectionStart(0);
        txt_codigoEmpresaFinal.setSelectionEnd  (txt_codigoEmpresaFinal.getText().length());
    }//GEN-LAST:event_txt_codigoEmpresaFinalFocusGained

    private void txt_codigoPlanoDeContasInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContasInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoPlanoDeContasFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoPlanoDeContasInicial.setText(fc.FormataCampo("", 11, 0));
            txt_codigoPlanoDeContasFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoPlanoDeContasInicialKeyPressed

    private void txt_codigoPlanoDeContasFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContasFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoEmpresaInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoPlanoDeContasFinal.setText("99999999999");
            txt_codigoEmpresaInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoPlanoDeContasFinalKeyPressed

    private void txt_codigoEmpresaInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoEmpresaInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoEmpresaFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoEmpresaInicial.setText(fc.FormataCampo("", 3, 0));
            txt_codigoEmpresaFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoEmpresaInicialKeyPressed

    private void txt_codigoEmpresaFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoEmpresaFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            combo_tipoConta.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoEmpresaFinal.setText("999");
            combo_tipoConta.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoEmpresaFinalKeyPressed

    private void combo_tipoContaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_tipoContaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            bt_exportar.grabFocus();
    }//GEN-LAST:event_combo_tipoContaKeyPressed

    private void bt_pesquisaPlanoDeContasInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaPlanoDeContasInicialActionPerformed
        Campo = "I";
        PesquisaPlanoDeContas();
    }//GEN-LAST:event_bt_pesquisaPlanoDeContasInicialActionPerformed
    
    private void PesquisaPlanoDeContas(){
        if(PlaDeConCon != null)if(PlaDeConCon.isVisible()){
            abriuPlanoDeContas = 0;
            Mensagem = "Tela já Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuPlanoDeContas = 1;
        parametros.clear();
        parametros.add("S");
        PlaDeConCon = new PlanoDeContasConsulta(parametros);
        PlaDeConCon.setVisible(true);
    }
    
    private void bt_pesquisaPlanoDeContasFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaPlanoDeContasFinalActionPerformed
        Campo = "F";
        PesquisaPlanoDeContas();
    }//GEN-LAST:event_bt_pesquisaPlanoDeContasFinalActionPerformed

    private void bt_pesquisaEmpresaInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaEmpresaInicialActionPerformed
        Campo = "I";
        PesquisaEmpresa();
    }//GEN-LAST:event_bt_pesquisaEmpresaInicialActionPerformed
    
    private void PesquisaEmpresa(){
        if(EmpCon != null)if(EmpCon.isVisible()){
            abriuEmpresa = 0;
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuEmpresa = 1;
        EmpCon = new EmpresasConsulta(parametrosNS.bge.CodigoGrupo);
        EmpCon.setVisible(true);
    }
    
    private void bt_pesquisaEmpresaFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaEmpresaFinalActionPerformed
        Campo = "F";
        PesquisaEmpresa();
    }//GEN-LAST:event_bt_pesquisaEmpresaFinalActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();return;}
        if(abriuPlanoDeContas == 0){
            AbreEmpresas();
            return;
        }
        abriuPlanoDeContas = 0;
        retorno = PlaDeConCon.getRetorno();
        if(retorno.equals(""))
            return;
        if(Campo.equals("I")){
            txt_codigoPlanoDeContasInicial.setText(fc.FormataCampo(retorno, 11, 0));
            return;
        }
        txt_codigoPlanoDeContasFinal.setText(fc.FormataCampo(retorno, 11, 0));
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbreEmpresas(){
        if(abriuEmpresa == 0)
            return;
        abriuEmpresa = 0;
        retorno = EmpCon.getRetorno();
        if(retorno.equals(""))
            return;
        if(Campo.equals("I")){
            txt_codigoEmpresaInicial.setText(fc.FormataCampo(retorno, 3, 0));
            return;
        }
        txt_codigoEmpresaFinal.setText(fc.FormataCampo(retorno, 3, 0));
    }
    
    private void bt_processaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_processaActionPerformed
        PegaGrupo();
    }//GEN-LAST:event_bt_processaActionPerformed

    private void combo_tipoContaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_tipoContaItemStateChanged
        PegaGrupo();
    }//GEN-LAST:event_combo_tipoContaItemStateChanged
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_exportar;
    private javax.swing.JButton bt_pesquisaEmpresaFinal;
    private javax.swing.JButton bt_pesquisaEmpresaInicial;
    private javax.swing.JButton bt_pesquisaPlanoDeContasFinal;
    private javax.swing.JButton bt_pesquisaPlanoDeContasInicial;
    private javax.swing.JButton bt_processa;
    private javax.swing.JButton bt_sair;
    private javax.swing.JCheckBox check_todasUnidades;
    private javax.swing.JComboBox<String> combo_tipoConta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_balancete;
    private javax.swing.JFormattedTextField txt_codigoEmpresaFinal;
    private javax.swing.JFormattedTextField txt_codigoEmpresaInicial;
    private javax.swing.JFormattedTextField txt_codigoPlanoDeContasFinal;
    private javax.swing.JFormattedTextField txt_codigoPlanoDeContasInicial;
    // End of variables declaration//GEN-END:variables
    
    private void VerificaCheckBoxTodasUnidades(){
        bt_exportar.setEnabled(false);
        txt_codigoEmpresaInicial        .setEditable    (true);
        txt_codigoEmpresaFinal          .setEditable    (true);
        txt_codigoEmpresaInicial        .setFocusable   (true);
        txt_codigoEmpresaFinal          .setFocusable   (true);
        txt_codigoEmpresaInicial        .setText(fc.FormataCampo("", 3, 0));
        txt_codigoEmpresaFinal          .setText("999");
        bt_pesquisaEmpresaInicial       .setEnabled(true);
        bt_pesquisaEmpresaFinal         .setEnabled(true);
        if(check_todasUnidades.isSelected() == false){
            txt_codigoEmpresaInicial    .setEditable    (false);
            txt_codigoEmpresaFinal      .setEditable    (false);
            txt_codigoEmpresaInicial    .setFocusable   (false);
            txt_codigoEmpresaFinal      .setFocusable   (false);
            txt_codigoEmpresaInicial    .setText(fc.FormataCampo(String.valueOf(parametrosNS.be.CodigoEmpresa), 3, 0));
            txt_codigoEmpresaFinal      .setText(fc.FormataCampo(String.valueOf(parametrosNS.be.CodigoEmpresa), 3, 0));
            bt_pesquisaEmpresaInicial   .setEnabled(false);
            bt_pesquisaEmpresaFinal     .setEnabled(false);
        }
        PegaGrupo();
        if(tabela_balancete.getRowCount() > 0){
            bt_exportar.setEnabled(true);
        }
    }
    
    private void PegaValores(){
        binter.codigoPlanoDeContasInicial   = Long.parseLong(txt_codigoPlanoDeContasInicial.getText().replace(".", ""));
        binter.codigoPlanoDeContasFinal     = Long.parseLong(txt_codigoPlanoDeContasFinal.getText().replace(".", ""));
        if(binter.codigoPlanoDeContasInicial > binter.codigoPlanoDeContasFinal){
            Mensagem = "Plano de Contas Inicial não pode ser maior do que o Plano de Contas Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        binter.codigoEmpresaInicial         = Integer.parseInt(txt_codigoEmpresaInicial.getText().replace(" ", ""));
        binter.codigoEmpresaFinal           = Integer.parseInt(txt_codigoEmpresaFinal.getText().replace(" ", ""));
        if(binter.codigoEmpresaInicial > binter.codigoEmpresaFinal){
            Mensagem = "Empresa Inicial não pode ser maior do q a Empresa Final!";
            new MostraMensagem(Mensagem);
            return;
        }
    }
    
    private void PegaGrupo(){
        tabela_balancete.getColumnModel().getColumn(0).setResizable(false);
        tabela_balancete.getColumnModel().getColumn(0).setPreferredWidth(200);
        tabela_balancete.getColumnModel().getColumn(1).setResizable(false);
        tabela_balancete.getColumnModel().getColumn(1).setPreferredWidth(35);
        tabela_balancete.getColumnModel().getColumn(2).setPreferredWidth(175);
        tabela_balancete.getColumnModel().getColumn(3).setResizable(false);
        tabela_balancete.getColumnModel().getColumn(3).setPreferredWidth(110);
        tabela_balancete.getColumnModel().getColumn(4).setResizable(false);
        tabela_balancete.getColumnModel().getColumn(4).setPreferredWidth(110);
        tabela_balancete.getColumnModel().getColumn(5).setResizable(false);
        tabela_balancete.getColumnModel().getColumn(5).setPreferredWidth(110);
        tabela_balancete.getColumnModel().getColumn(6).setResizable(false);
        tabela_balancete.getColumnModel().getColumn(6).setPreferredWidth(110);
        tabela_balancete.getColumnModel().getColumn(7).setResizable(false);
        tabela_balancete.getColumnModel().getColumn(7).setPreferredWidth(110);
        tabela_balancete.getColumnModel().getColumn(8).setResizable(false);
        tabela_balancete.getColumnModel().getColumn(8).setPreferredWidth(110);
        tabela_balancete.getColumnModel().getColumn(9).setResizable(false);
        tabela_balancete.getColumnModel().getColumn(9).setPreferredWidth(110);
        tabela_balancete.getColumnModel().getColumn(10).setResizable(false);
        tabela_balancete.getColumnModel().getColumn(10).setPreferredWidth(110);
        tabela_balancete.getColumnModel().getColumn(11).setResizable(false);
        tabela_balancete.getColumnModel().getColumn(11).setPreferredWidth(110);
        tabela_balancete.getColumnModel().getColumn(12).setResizable(false);
        tabela_balancete.getColumnModel().getColumn(12).setPreferredWidth(110);
        tabela_balancete.getColumnModel().getColumn(13).setResizable(false);
        tabela_balancete.getColumnModel().getColumn(13).setPreferredWidth(110);
        tabela_balancete.getColumnModel().getColumn(14).setResizable(false);
        tabela_balancete.getColumnModel().getColumn(14).setPreferredWidth(110);
        
        PegaValores();
        bge.codigoGrupo     = parametrosNS.bge.CodigoGrupo;
        sql = "select * from ns_grupoempresa where codigoGrupo = " + bge.codigoGrupo + ";";
        dadosGrupos.clear();
        dadosGrupos = parametrosNS.dao.Consulta(sql);
        if(dadosGrupos.isEmpty()){
            Mensagem = "Grupo " + parametrosNS.bge.CodigoGrupo + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosGrupo();
    }
    
    private void PegaDadosGrupo(){
        dadosSaldoGrupo.clear();
        dadosSaldoEmpresa.clear();
        dadosSaldoNivel1.clear();
        dadosSaldoNivel2.clear();
        dadosSaldoNivel3.clear();
        dadosSaldoNivel4.clear();
        dadosSaldoNivel5.clear();
        Table_Balancete.setNumRows(0);
        for(int i = 0; i < dadosGrupos.size(); i++){
            bpla.saldoGrupo01   = 0;
            bpla.saldoGrupo02   = 0;
            bpla.saldoGrupo03   = 0;
            bpla.saldoGrupo04   = 0;
            bpla.saldoGrupo05   = 0;
            bpla.saldoGrupo06   = 0;
            bpla.saldoGrupo07   = 0;
            bpla.saldoGrupo08   = 0;
            bpla.saldoGrupo09   = 0;
            bpla.saldoGrupo10   = 0;
            bpla.saldoGrupo11   = 0;
            bpla.saldoGrupo12   = 0;
            
            bge = new BeanGrupoEmpresa();
            bge.codigoGrupo             = Integer.parseInt( String.valueOf(dadosGrupos.get(i).get(0)));
            bge.nomeGrupo               =                   String.valueOf(dadosGrupos.get(i).get(1));
            bge.pastaImagemLogotipo     =                   String.valueOf(dadosGrupos.get(i).get(2));
            bge.extensaoImagemLogotipo  =                   String.valueOf(dadosGrupos.get(i).get(3));
            bge.limiteUsuarios          = Integer.parseInt( String.valueOf(dadosGrupos.get(i).get(4)));
            
            Table_Balancete.addRow(new Object [] {bge.nomeGrupo});
            
            PegaEmpresas();
            
            if(check_todasUnidades.isSelected() == false)continue;
            
            dadosSaldoGrupo.add(bpla.saldoGrupo01);
            dadosSaldoGrupo.add(bpla.saldoGrupo02);
            dadosSaldoGrupo.add(bpla.saldoGrupo03);
            dadosSaldoGrupo.add(bpla.saldoGrupo04);
            dadosSaldoGrupo.add(bpla.saldoGrupo05);
            dadosSaldoGrupo.add(bpla.saldoGrupo06);
            dadosSaldoGrupo.add(bpla.saldoGrupo07);
            dadosSaldoGrupo.add(bpla.saldoGrupo08);
            dadosSaldoGrupo.add(bpla.saldoGrupo09);
            dadosSaldoGrupo.add(bpla.saldoGrupo10);
            dadosSaldoGrupo.add(bpla.saldoGrupo11);
            dadosSaldoGrupo.add(bpla.saldoGrupo12);
            AdicionaSaldoGrupo();
        }
    }
    
    private void PegaEmpresas(){
        be.codigoGrupo          = parametrosNS.bge.CodigoGrupo;
        sql = "select idEmpresa, codigoGrupo, codigoEmpresa, idBancoDados, nomeEmpresa, nomeFantasia from ns_empresas where codigoGrupo = " + bge.codigoGrupo + " and codigoEmpresa between " + binter.codigoEmpresaInicial + " and " + binter.codigoEmpresaFinal + ";";
        dadosEmpresas.clear();
        dadosEmpresas = parametrosNS.dao.Consulta(sql);
        if(dadosEmpresas.isEmpty()){
            Mensagem = "Não foram encontrado empresas para o Grupo n°" + be.codigoEmpresa + "!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosEmpresas();
    }
    
    private void PegaDadosEmpresas(){
        dadosSaldoEmpresa.clear();
        dadosSaldoNivel1.clear();
        dadosSaldoNivel2.clear();
        dadosSaldoNivel3.clear();
        dadosSaldoNivel4.clear();
        dadosSaldoNivel5.clear();
        for(int i = 0; i < dadosEmpresas.size(); i++){
            bpla.saldoEmpresa01     = 0;
            bpla.saldoEmpresa02     = 0;
            bpla.saldoEmpresa03     = 0;
            bpla.saldoEmpresa04     = 0;
            bpla.saldoEmpresa05     = 0;
            bpla.saldoEmpresa06     = 0;
            bpla.saldoEmpresa07     = 0;
            bpla.saldoEmpresa08     = 0;
            bpla.saldoEmpresa09     = 0;
            bpla.saldoEmpresa10     = 0;
            bpla.saldoEmpresa11     = 0;
            bpla.saldoEmpresa12     = 0;
            
            be = new BeanEmpresas();
            be.idEmpresa                = Integer.parseInt(  String.valueOf(dadosEmpresas.get(i).get(0)));
            be.codigoGrupo              = Integer.parseInt(  String.valueOf(dadosEmpresas.get(i).get(1)));
            be.codigoEmpresa            = Integer.parseInt(  String.valueOf(dadosEmpresas.get(i).get(2)));
            be.idBancoDados             = Integer.parseInt(  String.valueOf(dadosEmpresas.get(i).get(3)));
            be.nomeEmpresa              =                    String.valueOf(dadosEmpresas.get(i).get(4));
            be.nomeFantasia             =                    String.valueOf(dadosEmpresas.get(i).get(5));
            
            Table_Balancete.addRow(new Object [] {" " + be.nomeFantasia});
            
            PegaPlanoDeContas();
            
            bpla.saldoGrupo01 += bpla.saldoEmpresa01;
            bpla.saldoGrupo02 += bpla.saldoEmpresa02;
            bpla.saldoGrupo03 += bpla.saldoEmpresa03;
            bpla.saldoGrupo04 += bpla.saldoEmpresa04;
            bpla.saldoGrupo05 += bpla.saldoEmpresa05;
            bpla.saldoGrupo06 += bpla.saldoEmpresa06;
            bpla.saldoGrupo07 += bpla.saldoEmpresa07;
            bpla.saldoGrupo08 += bpla.saldoEmpresa08;
            bpla.saldoGrupo09 += bpla.saldoEmpresa09;
            bpla.saldoGrupo10 += bpla.saldoEmpresa10;
            bpla.saldoGrupo11 += bpla.saldoEmpresa11;
            bpla.saldoGrupo12 += bpla.saldoEmpresa12;
            dadosSaldoEmpresa.add(bpla.saldoEmpresa01);
            dadosSaldoEmpresa.add(bpla.saldoEmpresa02);
            dadosSaldoEmpresa.add(bpla.saldoEmpresa03);
            dadosSaldoEmpresa.add(bpla.saldoEmpresa04);
            dadosSaldoEmpresa.add(bpla.saldoEmpresa05);
            dadosSaldoEmpresa.add(bpla.saldoEmpresa06);
            dadosSaldoEmpresa.add(bpla.saldoEmpresa07);
            dadosSaldoEmpresa.add(bpla.saldoEmpresa08);
            dadosSaldoEmpresa.add(bpla.saldoEmpresa09);
            dadosSaldoEmpresa.add(bpla.saldoEmpresa10);
            dadosSaldoEmpresa.add(bpla.saldoEmpresa11);
            dadosSaldoEmpresa.add(bpla.saldoEmpresa12);
            AdicionaSaldoEmpresa();
        }
    }
    
    private void PegaPlanoDeContas(){
        bpla.idEmpresa      = be.idEmpresa;
        bpla.codigoGrupo    = be.codigoGrupo;
        bpla.codigoEmpresa  = be.codigoEmpresa;
        sql = "select * from tb_planodecontas where codigoGrupo = " + bpla.codigoGrupo + " and codigoEmpresa = " + bpla.codigoEmpresa + " and codigoPlanoDeContas between " + binter.codigoPlanoDeContasInicial + " and " + binter.codigoPlanoDeContasFinal + ";";
        dadosPlanoDeContas.clear();
        dadosPlanoDeContas = parametrosNS.dao.Consulta(sql);
        if(dadosPlanoDeContas.isEmpty()){
//            Mensagem = "Não foram encontrados planos de contas cadastrados para a empresa " + fc.FormataCampo(String.valueOf(bpla.codigoGrupo), 2, 0) + "." + fc.FormataCampo(String.valueOf(bpla.codigoEmpresa), 3, 0) + "";
//            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosPlanoDeContas();
    }
    
    private void PegaDadosPlanoDeContas(){
        nivelPlanoDeContas  = 0;
        bpla.saldoNivel1    = 0;
        bpla.saldoNivel2    = 0;
        bpla.saldoNivel3    = 0;
        bpla.saldoNivel4    = 0;
        bpla.saldoNivel5    = 0;
        bpla.saldoNivel6    = 0;
        dadosSaldoNivel1.clear();
        dadosSaldoNivel2.clear();
        dadosSaldoNivel3.clear();
        dadosSaldoNivel4.clear();
        dadosSaldoNivel5.clear();
        for(int i = 0; i < dadosPlanoDeContas.size(); i++){
            pegouMovimentos = "N";
            if(dadosPlanoDeContas.get(i).get(0)  != null){bpla.idPlanoDeContas                = Integer.parseInt(  String.valueOf(dadosPlanoDeContas.get(i).get(0)));}
            if(dadosPlanoDeContas.get(i).get(1)  != null){bpla.idEmpresa                      = Integer.parseInt(  String.valueOf(dadosPlanoDeContas.get(i).get(1)));}
            if(dadosPlanoDeContas.get(i).get(2)  != null){bpla.codigoGrupo                    = Integer.parseInt(  String.valueOf(dadosPlanoDeContas.get(i).get(2)));}
            if(dadosPlanoDeContas.get(i).get(3)  != null){bpla.codigoEmpresa                  = Integer.parseInt(  String.valueOf(dadosPlanoDeContas.get(i).get(3)));}
            if(dadosPlanoDeContas.get(i).get(4)  != null){bpla.codigoPlanoDeContas            =                    String.valueOf(dadosPlanoDeContas.get(i).get(4));}
            if(dadosPlanoDeContas.get(i).get(5)  != null){bpla.descricaoPlanoDeContas         =                    String.valueOf(dadosPlanoDeContas.get(i).get(5));}
            if(dadosPlanoDeContas.get(i).get(6)  != null){bpla.tipoPlanoDeContas              =                    String.valueOf(dadosPlanoDeContas.get(i).get(6));}
            if(dadosPlanoDeContas.get(i).get(7)  != null){bpla.saldoDeAbertura                = Double.parseDouble(String.valueOf(dadosPlanoDeContas.get(i).get(7)));}
            if(dadosPlanoDeContas.get(i).get(8)  != null){bpla.codigoPlanoDeContasSuperior    =                    String.valueOf(dadosPlanoDeContas.get(i).get(8));}
            if(dadosPlanoDeContas.get(i).get(9)  != null){bpla.nivelPlanoDeContas             = Integer.parseInt(  String.valueOf(dadosPlanoDeContas.get(i).get(9)));}
            if(dadosPlanoDeContas.get(i).get(10) != null){bpla.idPlanoReferencial             = Integer.parseInt(  String.valueOf(dadosPlanoDeContas.get(i).get(10)));}
            
            bpla.RecarregaCodigosPlanosDeContas();
            bpla.RecarregaPlanoDeContas("S", "S");
            
            Linha = tabela_balancete.getRowCount(); 
            
            if(bpla.nivelPlanoDeContas == 6){
                if(combo_tipoConta.getSelectedIndex() != 1){
                    Table_Balancete.addRow(new Object [] {"       " + bpla.codigoPlanoDeContas, bpla.nivelPlanoDeContas, bpla.descricaoPlanoDeContas});
                }
            }
            if(bpla.nivelPlanoDeContas == 5){
                if(nivelPlanoDeContas > bpla.nivelPlanoDeContas){pegouMovimentos = "S";PlanoDeContasMovimentosNivel6();if(!dadosSaldoNivel5.isEmpty())AdicionaSaldoNivel5();}
                if(combo_tipoConta.getSelectedIndex() != 2){
                    Table_Balancete.addRow(new Object [] {"      " + bpla.codigoPlanoDeContas, bpla.nivelPlanoDeContas, bpla.descricaoPlanoDeContas});
                }
            }
            if(bpla.nivelPlanoDeContas == 4){
                if(nivelPlanoDeContas > bpla.nivelPlanoDeContas){pegouMovimentos = "S";PlanoDeContasMovimentosNivel6();if(!dadosSaldoNivel4.isEmpty())AdicionaSaldoNivel4();}
                if(combo_tipoConta.getSelectedIndex() != 2){
                    Table_Balancete.addRow(new Object [] {"     " + bpla.codigoPlanoDeContas, bpla.nivelPlanoDeContas, bpla.descricaoPlanoDeContas});
                }
            }
            if(bpla.nivelPlanoDeContas == 3){
                if(nivelPlanoDeContas > bpla.nivelPlanoDeContas){pegouMovimentos = "S";PlanoDeContasMovimentosNivel6();if(!dadosSaldoNivel3.isEmpty())AdicionaSaldoNivel3();}
                if(combo_tipoConta.getSelectedIndex() != 2){
                    Table_Balancete.addRow(new Object [] {"    " + bpla.codigoPlanoDeContas, bpla.nivelPlanoDeContas, bpla.descricaoPlanoDeContas});
                }
            }
            if(bpla.nivelPlanoDeContas == 2){
                if(nivelPlanoDeContas > bpla.nivelPlanoDeContas){pegouMovimentos = "S";PlanoDeContasMovimentosNivel6();if(!dadosSaldoNivel2.isEmpty())AdicionaSaldoNivel2();}
                if(combo_tipoConta.getSelectedIndex() != 2){
                    Table_Balancete.addRow(new Object [] {"   " + bpla.codigoPlanoDeContas, bpla.nivelPlanoDeContas, bpla.descricaoPlanoDeContas});
                }
            }
            if(bpla.nivelPlanoDeContas == 1){
                if(nivelPlanoDeContas > bpla.nivelPlanoDeContas){pegouMovimentos = "S";PlanoDeContasMovimentosNivel6();if(!dadosSaldoNivel1.isEmpty())AdicionaSaldoNivel1();}
                if(combo_tipoConta.getSelectedIndex() != 2){
                    Table_Balancete.addRow(new Object [] {"  " + bpla.codigoPlanoDeContas, bpla.nivelPlanoDeContas, bpla.descricaoPlanoDeContas});
                }
            }
            
            if(pegouMovimentos.equals("N")){PlanoDeContasMovimentosNivel6();}
            
            nivelPlanoDeContas = bpla.nivelPlanoDeContas;
        }
        bpla.nivelPlanoDeContas = 1;
        if(nivelPlanoDeContas > bpla.nivelPlanoDeContas){
            for(int i = 1; i < 13; i++){
                SomaValoresMensais(i);
                dadosSaldoNivel5.add(bpla.saldoNivel5);
                dadosSaldoNivel4.add(bpla.saldoNivel4);
                dadosSaldoNivel3.add(bpla.saldoNivel3);
                dadosSaldoNivel2.add(bpla.saldoNivel2);
                dadosSaldoNivel1.add(bpla.saldoNivel1);
            }
        }
    }
    
    private void SomaValoresMensais(int i){
        if(i ==  1){if(bpla.nivelPlanoDeContas == 6){bpla.saldoNivel501 += bpla.saldoNivel6;}else if(nivelPlanoDeContas > bpla.nivelPlanoDeContas){bpla.saldoNivel5 = bpla.saldoNivel501;bpla.saldoNivel401 += bpla.saldoNivel5;if(bpla.nivelPlanoDeContas <= 4){bpla.saldoNivel4 = bpla.saldoNivel401;bpla.saldoNivel301 += bpla.saldoNivel4;}if(bpla.nivelPlanoDeContas <= 3){bpla.saldoNivel3 = bpla.saldoNivel301;bpla.saldoNivel201 += bpla.saldoNivel3;}if(bpla.nivelPlanoDeContas <= 2){bpla.saldoNivel2 = bpla.saldoNivel201;bpla.saldoNivel101 += bpla.saldoNivel2;}if(bpla.nivelPlanoDeContas <= 1){bpla.saldoNivel1 = bpla.saldoNivel101;bpla.saldoEmpresa01 += bpla.saldoNivel1;}}}
        if(i ==  2){if(bpla.nivelPlanoDeContas == 6){bpla.saldoNivel502 += bpla.saldoNivel6;}else if(nivelPlanoDeContas > bpla.nivelPlanoDeContas){bpla.saldoNivel5 = bpla.saldoNivel502;bpla.saldoNivel402 += bpla.saldoNivel5;if(bpla.nivelPlanoDeContas <= 4){bpla.saldoNivel4 = bpla.saldoNivel402;bpla.saldoNivel302 += bpla.saldoNivel4;}if(bpla.nivelPlanoDeContas <= 3){bpla.saldoNivel3 = bpla.saldoNivel302;bpla.saldoNivel202 += bpla.saldoNivel3;}if(bpla.nivelPlanoDeContas <= 2){bpla.saldoNivel2 = bpla.saldoNivel202;bpla.saldoNivel102 += bpla.saldoNivel2;}if(bpla.nivelPlanoDeContas <= 1){bpla.saldoNivel1 = bpla.saldoNivel102;bpla.saldoEmpresa02 += bpla.saldoNivel1;}}}
        if(i ==  3){if(bpla.nivelPlanoDeContas == 6){bpla.saldoNivel503 += bpla.saldoNivel6;}else if(nivelPlanoDeContas > bpla.nivelPlanoDeContas){bpla.saldoNivel5 = bpla.saldoNivel503;bpla.saldoNivel403 += bpla.saldoNivel5;if(bpla.nivelPlanoDeContas <= 4){bpla.saldoNivel4 = bpla.saldoNivel403;bpla.saldoNivel303 += bpla.saldoNivel4;}if(bpla.nivelPlanoDeContas <= 3){bpla.saldoNivel3 = bpla.saldoNivel303;bpla.saldoNivel203 += bpla.saldoNivel3;}if(bpla.nivelPlanoDeContas <= 2){bpla.saldoNivel2 = bpla.saldoNivel203;bpla.saldoNivel103 += bpla.saldoNivel2;}if(bpla.nivelPlanoDeContas <= 1){bpla.saldoNivel1 = bpla.saldoNivel103;bpla.saldoEmpresa03 += bpla.saldoNivel1;}}}
        if(i ==  4){if(bpla.nivelPlanoDeContas == 6){bpla.saldoNivel504 += bpla.saldoNivel6;}else if(nivelPlanoDeContas > bpla.nivelPlanoDeContas){bpla.saldoNivel5 = bpla.saldoNivel504;bpla.saldoNivel404 += bpla.saldoNivel5;if(bpla.nivelPlanoDeContas <= 4){bpla.saldoNivel4 = bpla.saldoNivel404;bpla.saldoNivel304 += bpla.saldoNivel4;}if(bpla.nivelPlanoDeContas <= 3){bpla.saldoNivel3 = bpla.saldoNivel304;bpla.saldoNivel204 += bpla.saldoNivel3;}if(bpla.nivelPlanoDeContas <= 2){bpla.saldoNivel2 = bpla.saldoNivel204;bpla.saldoNivel104 += bpla.saldoNivel2;}if(bpla.nivelPlanoDeContas <= 1){bpla.saldoNivel1 = bpla.saldoNivel104;bpla.saldoEmpresa04 += bpla.saldoNivel1;}}}
        if(i ==  5){if(bpla.nivelPlanoDeContas == 6){bpla.saldoNivel505 += bpla.saldoNivel6;}else if(nivelPlanoDeContas > bpla.nivelPlanoDeContas){bpla.saldoNivel5 = bpla.saldoNivel505;bpla.saldoNivel405 += bpla.saldoNivel5;if(bpla.nivelPlanoDeContas <= 4){bpla.saldoNivel4 = bpla.saldoNivel405;bpla.saldoNivel305 += bpla.saldoNivel4;}if(bpla.nivelPlanoDeContas <= 3){bpla.saldoNivel3 = bpla.saldoNivel305;bpla.saldoNivel205 += bpla.saldoNivel3;}if(bpla.nivelPlanoDeContas <= 2){bpla.saldoNivel2 = bpla.saldoNivel205;bpla.saldoNivel105 += bpla.saldoNivel2;}if(bpla.nivelPlanoDeContas <= 1){bpla.saldoNivel1 = bpla.saldoNivel105;bpla.saldoEmpresa05 += bpla.saldoNivel1;}}}
        if(i ==  6){if(bpla.nivelPlanoDeContas == 6){bpla.saldoNivel506 += bpla.saldoNivel6;}else if(nivelPlanoDeContas > bpla.nivelPlanoDeContas){bpla.saldoNivel5 = bpla.saldoNivel506;bpla.saldoNivel406 += bpla.saldoNivel5;if(bpla.nivelPlanoDeContas <= 4){bpla.saldoNivel4 = bpla.saldoNivel406;bpla.saldoNivel306 += bpla.saldoNivel4;}if(bpla.nivelPlanoDeContas <= 3){bpla.saldoNivel3 = bpla.saldoNivel306;bpla.saldoNivel206 += bpla.saldoNivel3;}if(bpla.nivelPlanoDeContas <= 2){bpla.saldoNivel2 = bpla.saldoNivel206;bpla.saldoNivel106 += bpla.saldoNivel2;}if(bpla.nivelPlanoDeContas <= 1){bpla.saldoNivel1 = bpla.saldoNivel106;bpla.saldoEmpresa06 += bpla.saldoNivel1;}}}
        if(i ==  7){if(bpla.nivelPlanoDeContas == 6){bpla.saldoNivel507 += bpla.saldoNivel6;}else if(nivelPlanoDeContas > bpla.nivelPlanoDeContas){bpla.saldoNivel5 = bpla.saldoNivel507;bpla.saldoNivel407 += bpla.saldoNivel5;if(bpla.nivelPlanoDeContas <= 4){bpla.saldoNivel4 = bpla.saldoNivel407;bpla.saldoNivel307 += bpla.saldoNivel4;}if(bpla.nivelPlanoDeContas <= 3){bpla.saldoNivel3 = bpla.saldoNivel307;bpla.saldoNivel207 += bpla.saldoNivel3;}if(bpla.nivelPlanoDeContas <= 2){bpla.saldoNivel2 = bpla.saldoNivel207;bpla.saldoNivel107 += bpla.saldoNivel2;}if(bpla.nivelPlanoDeContas <= 1){bpla.saldoNivel1 = bpla.saldoNivel107;bpla.saldoEmpresa07 += bpla.saldoNivel1;}}}
        if(i ==  8){if(bpla.nivelPlanoDeContas == 6){bpla.saldoNivel508 += bpla.saldoNivel6;}else if(nivelPlanoDeContas > bpla.nivelPlanoDeContas){bpla.saldoNivel5 = bpla.saldoNivel508;bpla.saldoNivel408 += bpla.saldoNivel5;if(bpla.nivelPlanoDeContas <= 4){bpla.saldoNivel4 = bpla.saldoNivel408;bpla.saldoNivel308 += bpla.saldoNivel4;}if(bpla.nivelPlanoDeContas <= 3){bpla.saldoNivel3 = bpla.saldoNivel308;bpla.saldoNivel208 += bpla.saldoNivel3;}if(bpla.nivelPlanoDeContas <= 2){bpla.saldoNivel2 = bpla.saldoNivel208;bpla.saldoNivel108 += bpla.saldoNivel2;}if(bpla.nivelPlanoDeContas <= 1){bpla.saldoNivel1 = bpla.saldoNivel108;bpla.saldoEmpresa08 += bpla.saldoNivel1;}}}
        if(i ==  9){if(bpla.nivelPlanoDeContas == 6){bpla.saldoNivel509 += bpla.saldoNivel6;}else if(nivelPlanoDeContas > bpla.nivelPlanoDeContas){bpla.saldoNivel5 = bpla.saldoNivel509;bpla.saldoNivel409 += bpla.saldoNivel5;if(bpla.nivelPlanoDeContas <= 4){bpla.saldoNivel4 = bpla.saldoNivel409;bpla.saldoNivel309 += bpla.saldoNivel4;}if(bpla.nivelPlanoDeContas <= 3){bpla.saldoNivel3 = bpla.saldoNivel309;bpla.saldoNivel209 += bpla.saldoNivel3;}if(bpla.nivelPlanoDeContas <= 2){bpla.saldoNivel2 = bpla.saldoNivel209;bpla.saldoNivel109 += bpla.saldoNivel2;}if(bpla.nivelPlanoDeContas <= 1){bpla.saldoNivel1 = bpla.saldoNivel109;bpla.saldoEmpresa09 += bpla.saldoNivel1;}}}
        if(i == 10){if(bpla.nivelPlanoDeContas == 6){bpla.saldoNivel510 += bpla.saldoNivel6;}else if(nivelPlanoDeContas > bpla.nivelPlanoDeContas){bpla.saldoNivel5 = bpla.saldoNivel510;bpla.saldoNivel410 += bpla.saldoNivel5;if(bpla.nivelPlanoDeContas <= 4){bpla.saldoNivel4 = bpla.saldoNivel410;bpla.saldoNivel310 += bpla.saldoNivel4;}if(bpla.nivelPlanoDeContas <= 3){bpla.saldoNivel3 = bpla.saldoNivel310;bpla.saldoNivel210 += bpla.saldoNivel3;}if(bpla.nivelPlanoDeContas <= 2){bpla.saldoNivel2 = bpla.saldoNivel210;bpla.saldoNivel110 += bpla.saldoNivel2;}if(bpla.nivelPlanoDeContas <= 1){bpla.saldoNivel1 = bpla.saldoNivel110;bpla.saldoEmpresa10 += bpla.saldoNivel1;}}}
        if(i == 11){if(bpla.nivelPlanoDeContas == 6){bpla.saldoNivel511 += bpla.saldoNivel6;}else if(nivelPlanoDeContas > bpla.nivelPlanoDeContas){bpla.saldoNivel5 = bpla.saldoNivel511;bpla.saldoNivel411 += bpla.saldoNivel5;if(bpla.nivelPlanoDeContas <= 4){bpla.saldoNivel4 = bpla.saldoNivel411;bpla.saldoNivel311 += bpla.saldoNivel4;}if(bpla.nivelPlanoDeContas <= 3){bpla.saldoNivel3 = bpla.saldoNivel311;bpla.saldoNivel211 += bpla.saldoNivel3;}if(bpla.nivelPlanoDeContas <= 2){bpla.saldoNivel2 = bpla.saldoNivel211;bpla.saldoNivel111 += bpla.saldoNivel2;}if(bpla.nivelPlanoDeContas <= 1){bpla.saldoNivel1 = bpla.saldoNivel111;bpla.saldoEmpresa11 += bpla.saldoNivel1;}}}
        if(i == 12){if(bpla.nivelPlanoDeContas == 6){bpla.saldoNivel512 += bpla.saldoNivel6;}else if(nivelPlanoDeContas > bpla.nivelPlanoDeContas){bpla.saldoNivel5 = bpla.saldoNivel512;bpla.saldoNivel412 += bpla.saldoNivel5;if(bpla.nivelPlanoDeContas <= 4){bpla.saldoNivel4 = bpla.saldoNivel412;bpla.saldoNivel312 += bpla.saldoNivel4;}if(bpla.nivelPlanoDeContas <= 3){bpla.saldoNivel3 = bpla.saldoNivel312;bpla.saldoNivel212 += bpla.saldoNivel3;}if(bpla.nivelPlanoDeContas <= 2){bpla.saldoNivel2 = bpla.saldoNivel212;bpla.saldoNivel112 += bpla.saldoNivel2;}if(bpla.nivelPlanoDeContas <= 1){bpla.saldoNivel1 = bpla.saldoNivel112;bpla.saldoEmpresa12 += bpla.saldoNivel1;}}}
    }
    
    private void PlanoDeContasMovimentosNivel6(){
        bplamov.idEmpresa           = bpla.idEmpresa;
        bplamov.codigoGrupo         = bpla.codigoGrupo;
        bplamov.codigoEmpresa       = bpla.codigoEmpresa;
        bplamov.codigoPlanoDeContas = bpla.codigoPlanoDeContas.replace(".", "");
        int s = 0;
        for(int i = 1; i < 13; i++){
            sql = "select * from tb_planodecontasmovimentos where idEmpresa = " + bplamov.idEmpresa + " and dataPlanoDeContas between '" + bparcon.dataContabil.substring(4, 8) + fc.FormataCampo(String.valueOf(i), 2, 0) + "01' and '" + bparcon.dataContabil.substring(4, 8) + fc.FormataCampo(String.valueOf(i), 2, 0) + "31' and codigoPlanoDeContas = '" + bplamov.codigoPlanoDeContas + "';";
//            System.out.println(sql);
            dadosPlanoDeContasMovimentos.clear();
            dadosPlanoDeContasMovimentos = parametrosNS.dao.Consulta(sql);
            PegaDadosPlanoDeContasMovimentosNivel6();
            
            SomaValoresMensais(i);
            
            j = i + 2;
            if(bpla.nivelPlanoDeContas == 6){
                if(combo_tipoConta.getSelectedIndex() != 1){
                    Table_Balancete.setValueAt(TransStrDou.TransformaValorStringeDouble(String.valueOf(bpla.saldoNivel6), 0), Linha, j);
                }
            }
            
            if(s != i){
                if(nivelPlanoDeContas > bpla.nivelPlanoDeContas){
                    if(bpla.nivelPlanoDeContas == 5){
                        dadosSaldoNivel5.add(bpla.saldoNivel5);
                    }
                    if(bpla.nivelPlanoDeContas == 4){
                        dadosSaldoNivel5.add(bpla.saldoNivel5);
                        dadosSaldoNivel4.add(bpla.saldoNivel4);
                    }
                    if(bpla.nivelPlanoDeContas == 3){
                        dadosSaldoNivel5.add(bpla.saldoNivel5);
                        dadosSaldoNivel4.add(bpla.saldoNivel4);
                        dadosSaldoNivel3.add(bpla.saldoNivel3);
                    }
                    if(bpla.nivelPlanoDeContas == 2){
                        dadosSaldoNivel5.add(bpla.saldoNivel5);
                        dadosSaldoNivel4.add(bpla.saldoNivel4);
                        dadosSaldoNivel3.add(bpla.saldoNivel3);
                        dadosSaldoNivel2.add(bpla.saldoNivel2);
                    }
                    if(bpla.nivelPlanoDeContas == 1){
                        dadosSaldoNivel5.add(bpla.saldoNivel5);
                        dadosSaldoNivel4.add(bpla.saldoNivel4);
                        dadosSaldoNivel3.add(bpla.saldoNivel3);
                        dadosSaldoNivel2.add(bpla.saldoNivel2);
                        dadosSaldoNivel1.add(bpla.saldoNivel1);
                    }
                }
            }
            s = i;
        }
    }
    
    private void PegaDadosPlanoDeContasMovimentosNivel6(){
        bpla.saldoNivel6 = 0;
        for(int i = 0; i < dadosPlanoDeContasMovimentos.size(); i++){
            bplamov = new BeanPlanoDeContasMovimentos();
            if(dadosPlanoDeContasMovimentos.get(i).get(0) != null){bplamov.idPlanoDeContasMovimentos   = Integer.parseInt(  String.valueOf(dadosPlanoDeContasMovimentos.get(i).get(0)));}
            if(dadosPlanoDeContasMovimentos.get(i).get(1) != null){bplamov.idEmpresa                   = Integer.parseInt(  String.valueOf(dadosPlanoDeContasMovimentos.get(i).get(1)));}
            if(dadosPlanoDeContasMovimentos.get(i).get(2) != null){bplamov.codigoGrupo                 = Integer.parseInt(  String.valueOf(dadosPlanoDeContasMovimentos.get(i).get(2)));}
            if(dadosPlanoDeContasMovimentos.get(i).get(3) != null){bplamov.codigoEmpresa               = Integer.parseInt(  String.valueOf(dadosPlanoDeContasMovimentos.get(i).get(3)));}
            if(dadosPlanoDeContasMovimentos.get(i).get(4) != null){bplamov.codigoPlanoDeContas         =                    String.valueOf(dadosPlanoDeContasMovimentos.get(i).get(4));}
            if(dadosPlanoDeContasMovimentos.get(i).get(5) != null){bplamov.dataPlanoDeContas           =                    String.valueOf(dadosPlanoDeContasMovimentos.get(i).get(5));}
            if(dadosPlanoDeContasMovimentos.get(i).get(6) != null){bplamov.saldo                       = Double.parseDouble(String.valueOf(dadosPlanoDeContasMovimentos.get(i).get(6)));}
            
            bplamov.dataPlanoDeContas           = invdata.inverterData(bplamov.dataPlanoDeContas, 1);
            bpla.saldoNivel6                   += bplamov.saldo;
        }
    }
    
    private void AdicionaSaldoGrupo(){
        if(!dadosSaldoNivel5.isEmpty()){
            AdicionaSaldoNivel5();
        }
        if(!dadosSaldoNivel4.isEmpty()){
            AdicionaSaldoNivel4();
        }
        if(!dadosSaldoNivel3.isEmpty()){
            AdicionaSaldoNivel3();
        }
        if(!dadosSaldoNivel2.isEmpty()){
            AdicionaSaldoNivel2();
        }
        if(!dadosSaldoNivel1.isEmpty()){
            AdicionaSaldoNivel1();
        }
        if(!dadosSaldoEmpresa.isEmpty()){
            AdicionaSaldoEmpresa();
        }
        Linha = tabela_balancete.getRowCount();
        Table_Balancete.addRow(new Object [] {"TOTAIS DO GRUPO"});
        for(int i = 0; i < 12; i++)
            tabela_balancete.setValueAt(TransStrDou.TransformaValorStringeDouble(String.valueOf(dadosSaldoGrupo.get(i)), 0), Linha, i + 3);
        dadosSaldoGrupo.clear();
    }
    
    private void AdicionaSaldoEmpresa(){
        if(!dadosSaldoNivel5.isEmpty()){
            AdicionaSaldoNivel5();
        }
        if(!dadosSaldoNivel4.isEmpty()){
            AdicionaSaldoNivel4();
        }
        if(!dadosSaldoNivel3.isEmpty()){
            AdicionaSaldoNivel3();
        }
        if(!dadosSaldoNivel2.isEmpty()){
            AdicionaSaldoNivel2();
        }
        if(!dadosSaldoNivel1.isEmpty()){
            AdicionaSaldoNivel1();
        }
        Linha = tabela_balancete.getRowCount();
        Table_Balancete.addRow(new Object [] {"TOTAIS DA EMPRESA"});
        for(int i = 0; i < 12; i++)
            tabela_balancete.setValueAt(TransStrDou.TransformaValorStringeDouble(String.valueOf(dadosSaldoEmpresa.get(i)), 0), Linha, i + 3);
        dadosSaldoEmpresa.clear();
    }
    
    private void AdicionaSaldoNivel1(){
        if(!dadosSaldoNivel5.isEmpty()){
            AdicionaSaldoNivel5();
        }
        if(!dadosSaldoNivel4.isEmpty()){
            AdicionaSaldoNivel4();
        }
        if(!dadosSaldoNivel3.isEmpty()){
            AdicionaSaldoNivel3();
        }
        if(!dadosSaldoNivel2.isEmpty()){
            AdicionaSaldoNivel2();
        }
        Linha = tabela_balancete.getRowCount();
        Table_Balancete.addRow(new Object [] {"TOTAIS DA CLASSE"});
        for(int i = 0; i < 12; i++)
            tabela_balancete.setValueAt(TransStrDou.TransformaValorStringeDouble(String.valueOf(dadosSaldoNivel1.get(i)), 0), Linha, i + 3);
//        bpla.saldoNivel1 = 0;
        dadosSaldoNivel1.clear();
        bpla.saldoNivel101     = 0;
        bpla.saldoNivel102     = 0;
        bpla.saldoNivel103     = 0;
        bpla.saldoNivel104     = 0;
        bpla.saldoNivel105     = 0;
        bpla.saldoNivel106     = 0;
        bpla.saldoNivel107     = 0;
        bpla.saldoNivel108     = 0;
        bpla.saldoNivel109     = 0;
        bpla.saldoNivel110     = 0;
        bpla.saldoNivel111     = 0;
        bpla.saldoNivel112     = 0;
    }
    
    private void AdicionaSaldoNivel2(){
        if(!dadosSaldoNivel5.isEmpty()){
            AdicionaSaldoNivel5();
        }
        if(!dadosSaldoNivel4.isEmpty()){
            AdicionaSaldoNivel4();
        }
        if(!dadosSaldoNivel3.isEmpty()){
            AdicionaSaldoNivel3();
        }
        Linha = tabela_balancete.getRowCount();
        Table_Balancete.addRow(new Object [] {"TOTAIS DO GRUPO"});
        for(int i = 0; i < 12; i++)
            tabela_balancete.setValueAt(TransStrDou.TransformaValorStringeDouble(String.valueOf(dadosSaldoNivel2.get(i)), 0), Linha, i + 3);
//        bpla.saldoNivel2 = 0;
        dadosSaldoNivel2.clear();
        bpla.saldoNivel201     = 0;
        bpla.saldoNivel202     = 0;
        bpla.saldoNivel203     = 0;
        bpla.saldoNivel204     = 0;
        bpla.saldoNivel205     = 0;
        bpla.saldoNivel206     = 0;
        bpla.saldoNivel207     = 0;
        bpla.saldoNivel208     = 0;
        bpla.saldoNivel209     = 0;
        bpla.saldoNivel210     = 0;
        bpla.saldoNivel211     = 0;
        bpla.saldoNivel212     = 0;
    }
    
    private void AdicionaSaldoNivel3(){
        if(!dadosSaldoNivel5.isEmpty()){
            AdicionaSaldoNivel5();
        }
        if(!dadosSaldoNivel4.isEmpty()){
            AdicionaSaldoNivel4();
        }
        Linha = tabela_balancete.getRowCount();
        Table_Balancete.addRow(new Object [] {"TOTAIS DO SUBGRUPO"});
        for(int i = 0; i < 12; i++)
            tabela_balancete.setValueAt(TransStrDou.TransformaValorStringeDouble(String.valueOf(dadosSaldoNivel3.get(i)), 0), Linha, i + 3);
//        bpla.saldoNivel3 = 0;
        dadosSaldoNivel3.clear();
        bpla.saldoNivel301     = 0;
        bpla.saldoNivel302     = 0;
        bpla.saldoNivel303     = 0;
        bpla.saldoNivel304     = 0;
        bpla.saldoNivel305     = 0;
        bpla.saldoNivel306     = 0;
        bpla.saldoNivel307     = 0;
        bpla.saldoNivel308     = 0;
        bpla.saldoNivel309     = 0;
        bpla.saldoNivel310     = 0;
        bpla.saldoNivel311     = 0;
        bpla.saldoNivel312     = 0;
    }
    
    private void AdicionaSaldoNivel4(){
        if(!dadosSaldoNivel5.isEmpty()){
            AdicionaSaldoNivel5();
        }
        Linha = tabela_balancete.getRowCount();
        Table_Balancete.addRow(new Object [] {"TOTAIS DA CONTA"});
        for(int i = 0; i < 12; i++)
            tabela_balancete.setValueAt(TransStrDou.TransformaValorStringeDouble(String.valueOf(dadosSaldoNivel4.get(i)), 0), Linha, i + 3);
//        bpla.saldoNivel4 = 0;
        dadosSaldoNivel4.clear();
        bpla.saldoNivel401     = 0;
        bpla.saldoNivel402     = 0;
        bpla.saldoNivel403     = 0;
        bpla.saldoNivel404     = 0;
        bpla.saldoNivel405     = 0;
        bpla.saldoNivel406     = 0;
        bpla.saldoNivel407     = 0;
        bpla.saldoNivel408     = 0;
        bpla.saldoNivel409     = 0;
        bpla.saldoNivel410     = 0;
        bpla.saldoNivel411     = 0;
        bpla.saldoNivel412     = 0;
    }
    
    private void AdicionaSaldoNivel5(){
        Linha = tabela_balancete.getRowCount();
        Table_Balancete.addRow(new Object [] {"TOTAIS DA SUBCONTA"});
        for(int i = 0; i < 12; i++)
            tabela_balancete.setValueAt(TransStrDou.TransformaValorStringeDouble(String.valueOf(dadosSaldoNivel5.get(i)), 0), Linha, i + 3);
//        bpla.saldoNivel5 = 0;
        dadosSaldoNivel5.clear();
        bpla.saldoNivel501     = 0;
        bpla.saldoNivel502     = 0;
        bpla.saldoNivel503     = 0;
        bpla.saldoNivel504     = 0;
        bpla.saldoNivel505     = 0;
        bpla.saldoNivel506     = 0;
        bpla.saldoNivel507     = 0;
        bpla.saldoNivel508     = 0;
        bpla.saldoNivel509     = 0;
        bpla.saldoNivel510     = 0;
        bpla.saldoNivel511     = 0;
        bpla.saldoNivel512     = 0;
    }
    
}
