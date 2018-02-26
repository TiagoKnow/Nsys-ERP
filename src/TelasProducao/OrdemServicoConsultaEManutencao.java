package TelasProducao;

import Beans.BeanClientes;
import Beans.BeanIntervalos;
import Beans.BeanOrdemServico;
import Beans.BeanOrdemServicoItens;
import Beans.BeanUsuarios;
import FuncoesInternas.InverterData;
import FuncoesInternas.*;
import TelasFaturamento.ClientesConsulta;
import Telas.UsuariosConsulta;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
/*
 @author Tiago e Paulo
 */
public class OrdemServicoConsultaEManutencao extends javax.swing.JFrame {
    //String's
    String sql              = "";
    String sql1             = "";
    String sqlComp          = "";
    String sqlstate         = "";
    String mensagem         = "";
    String somostra         = "";
    String fazManutencao    = "";
    String preenchimento    = "";
    String retorno          = "";
    String pronto           = "";
    String tabela           = "";
    String Campo            = "";
    String dataConsulta     = "";
    String fatal            = "";
    String Texto            = "";
    String ValorTexto       = "";
    String textoBusca       = "";
    
    //Int's
    int qtdRegistros           = 0;
    int totalRegistros         = 0;
    int abriuDigitadoUsuario   = 0;
    int abriuFinalizadoUsuario = 0;
    int abriuCanceladoUsuario  = 0;
    int abriuCliente           = 0;
    int abriuOrdemServico      = 0;
    int linha                  = 0;
    int dataCadastro           = 0;
    int dataEntrada            = 0;
    int dataSaida              = 0;
    int contador               = 0;
    int index                  = 0;
    int statusOs1              = 0;
    int statusOs2              = 0;
    int statusOs3              = 0;
    int statusOs4              = 0;
    int statusOs5              = 0;
    
    //Date's
    Date Data   = new Date();
    
    //double's
    double ValorOrdemServico      = 0;
    double ValorTotalOrdemServico = 0;
    
    //Vetores
    ArrayList            parametros                   = new ArrayList();
//    ArrayList            dadosPadroes                 = new ArrayList();
    ArrayList            dadosSituacao                = new ArrayList();
    ArrayList<ArrayList> dadosOrdemServico            = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosOrdemServicoSemSolucao  = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosOrdemServicoItens       = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosCliente                 = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosUsuarios                = new ArrayList<ArrayList>();
    
    //Beans
    BeanOrdemServico            bos    = new BeanOrdemServico();
    BeanOrdemServicoItens       bosi   = new BeanOrdemServicoItens();
    BeanUsuarios                bu     = new BeanUsuarios();
    BeanClientes                bc     = new BeanClientes();
    BeanIntervalos              binter = new BeanIntervalos();
    
    //Telas
    UsuariosConsulta            UsuCon;
    ClientesConsulta            CliCon;
    OrdemServicoCadastro        OrdSerCad;
    OrdemServicoFinalizar       FinalizarOS;
    OrdemServicoCancelar        OrdSerCan;
    
    //Especiais
    FormataCampo                    fc      = new FormataCampo();
    
    //Outros
    DefaultTableModel              Table;
    DateFormat                     dataFormato      = new SimpleDateFormat("dd/MM/yyyy");
    CapturarDataHora               cdh              = new CapturarDataHora();
    TestarData                     Test             = new TestarData();
    InverterData                   invdata          = new InverterData();
    TransformaValorStringeDouble   TransStrDou      = new TransformaValorStringeDouble();
    NumberFormat                   nf               = new DecimalFormat("R$ ###,###,###,##0.00");
    ConverteValorDigitadoEmDouble  conv             = new ConverteValorDigitadoEmDouble();
    ColorirTabelaOSeVendaseBoletos ConvTabOSeVenBol = new ColorirTabelaOSeVendaseBoletos();
    
    //Especiais para Excportação em Excel
    JFileChooser SeletorExcel;
    String       NomeArquivoExcel = "";
    String       LocalArquivo     = "";
    int          SalvarExcel      = 0;
    
    public OrdemServicoConsultaEManutencao(String Somostra, String FazManutencao){
        somostra      = Somostra;
        fazManutencao = FazManutencao;
        initComponents();
    }
    
    private void InicializaCampos(){
        txt_osInicial.setText(fc.FormataCampo("", 9, 0));
        txt_osFinal  .setText("999999999");
        txt_descricao.setText("");
        
        combo_statusPersonalizado.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_detalhesItem = new javax.swing.JMenuItem();
        bt_alterarOS = new javax.swing.JMenuItem();
        bt_cancelarOS = new javax.swing.JMenuItem();
        bt_finalizarOS = new javax.swing.JMenuItem();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_OrdemServico = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        txt_osInicial = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_osFinal = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_descricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        combo_status = new javax.swing.JComboBox<>();
        combo_statusPersonalizado = new javax.swing.JComboBox<>();
        txt_qtdRegistros = new javax.swing.JFormattedTextField();
        bt_processa = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        bt_exportar = new javax.swing.JButton();
        label_processando = new javax.swing.JLabel();
        label_totalOS = new javax.swing.JLabel();
        label_divisor = new javax.swing.JLabel();
        label_contador = new javax.swing.JLabel();
        barra_progresso = new javax.swing.JProgressBar();
        jMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        bt_sair = new javax.swing.JMenuItem();

        bt_detalhesItem.setText("Detalhes");
        bt_detalhesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_detalhesItemActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_detalhesItem);

        bt_alterarOS.setText("Alterar OS");
        bt_alterarOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterarOSActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_alterarOS);

        bt_cancelarOS.setText("Cancelar OS");
        bt_cancelarOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarOSActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_cancelarOS);

        bt_finalizarOS.setText("Finalizar OS");
        bt_finalizarOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_finalizarOSActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_finalizarOS);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta - Ordens de Serviço");
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

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Ordens de Serviços");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_OrdemServico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_OrdemServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Código", "Cliente", "Data de Cadastro", "Data de Entrada", "Data de Previsão", "Descrição", "Status", "Data de Finalização", "Hora de Finalização", "Digitada por", "Aprovado?", "Finalizado por", "Marca", "Modelo", "Data de Garantia", "Serviços", "Produtos", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_OrdemServico.setAutoResizeMode(tabela_OrdemServico.AUTO_RESIZE_OFF);
        tabela_OrdemServico.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tabela_OrdemServico.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_OrdemServico.getTableHeader().setReorderingAllowed(false);
        tabela_OrdemServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_OrdemServicoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_OrdemServico);
        if (tabela_OrdemServico.getColumnModel().getColumnCount() > 0) {
            tabela_OrdemServico.getColumnModel().getColumn(0).setMinWidth(0);
            tabela_OrdemServico.getColumnModel().getColumn(0).setPreferredWidth(0);
            tabela_OrdemServico.getColumnModel().getColumn(0).setMaxWidth(0);
            tabela_OrdemServico.getColumnModel().getColumn(1).setResizable(false);
            tabela_OrdemServico.getColumnModel().getColumn(3).setResizable(false);
            tabela_OrdemServico.getColumnModel().getColumn(4).setResizable(false);
            tabela_OrdemServico.getColumnModel().getColumn(5).setResizable(false);
            tabela_OrdemServico.getColumnModel().getColumn(7).setResizable(false);
            tabela_OrdemServico.getColumnModel().getColumn(8).setResizable(false);
            tabela_OrdemServico.getColumnModel().getColumn(9).setResizable(false);
            tabela_OrdemServico.getColumnModel().getColumn(10).setResizable(false);
            tabela_OrdemServico.getColumnModel().getColumn(11).setResizable(false);
            tabela_OrdemServico.getColumnModel().getColumn(15).setResizable(false);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_osInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_osInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_osInicial.setText("000000000");
        txt_osInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_osInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_osInicialFocusLost(evt);
            }
        });
        txt_osInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_osInicialKeyPressed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("OS:");

        try {
            txt_osInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_osFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_osFinal.setText("999999999");
        txt_osFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_osFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_osFinalFocusLost(evt);
            }
        });
        txt_osFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_osFinalKeyPressed(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Inicial");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Final");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Intervalos de Consulta        F11 [Geral]");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Descrição:");

        txt_descricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_descricaoKeyReleased(evt);
            }
        });

        jLabel2.setText("Mostrar os");

        jLabel3.setText("primeiros registros");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Status:");

        combo_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Pendentes", "Canceladas", "Finalizadas", "Sem solução", "Faturada", "Personalizada" }));
        combo_status.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_statusItemStateChanged(evt);
            }
        });

        combo_statusPersonalizado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendente e Cancelada", "Pendente e Finalizada", "Pendente e Sem Solução", "Pendente e Faturada", "Cancelada e Finalizada", "Cancelada e Sem Solução", "Cancelada e Faturada", "Finalizada e Sem Solução", "Finalizada e Faturada", "Sem solução e Faturada", "Pendente, Cancelada e Finalizada", "Pendente, Cancelada e Sem Solução", "Pendente, Cancelada e Faturada", "Pendente, Finalizada e Sem Solução", "Pendente, Finalizada e Faturada", "Pendente, Sem Solução e Faturada", "Cancelada, Finalizada e Sem Solução", "Cancelada, Finalizada e Faturada", "Cancelada, Sem Solução e Faturada", "Finalizada, Sem Solução e Faturada", "Pendente, Cancelada, Finalizada e Sem Solução", "Pendente, Cancelada, Finalizada e Faturada", "Pendente, Cancelada, Sem Solução e Faturada", "Pendente, Finalizada, Sem Solução e Faturada", "Cancelada, Finalizada, Sem Solução e Faturada" }));

        try {
            txt_qtdRegistros.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_qtdRegistros.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_qtdRegistros.setText("030");
        txt_qtdRegistros.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_qtdRegistrosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_qtdRegistrosFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(combo_status, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_statusPersonalizado, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_osInicial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_osFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_qtdRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addGap(146, 175, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel12, jLabel13, txt_osFinal});

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel5, jLabel8});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_osInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_osFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_qtdRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(combo_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_statusPersonalizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel12, jLabel13, jLabel5, txt_descricao, txt_osFinal, txt_osInicial});

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3});

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {combo_status, jLabel8});

        bt_processa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/1280454766_system-software-update.png"))); // NOI18N
        bt_processa.setText("Processa");
        bt_processa.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        bt_processa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_processaActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        bt_exportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Table.png"))); // NOI18N
        bt_exportar.setText("Exportar");
        bt_exportar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        bt_exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_exportarActionPerformed(evt);
            }
        });

        label_processando.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_processando.setText("Processando... Aguarde...");

        label_totalOS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_totalOS.setText("00000");

        label_divisor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_divisor.setText("/");

        label_contador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_contador.setText("00000");

        barra_progresso.setBorderPainted(false);

        jMenu1.setText("Arquivo");

        jMenu2.setText("Cadastro");

        jMenuItem1.setText("Ordens de Serviço");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenu1.add(jMenu2);
        jMenu1.add(jSeparator1);

        bt_sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });
        jMenu1.add(bt_sair);

        jMenu.add(jMenu1);

        setJMenuBar(jMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(barra_progresso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_contador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_divisor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_totalOS))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_processa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_exportar)
                        .addGap(132, 132, 132)
                        .addComponent(label_processando)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_exportar, bt_processa});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_contador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_divisor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_totalOS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(barra_progresso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_processa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_exportar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_processando, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_exportar, bt_processa, jButton1, label_processando});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {barra_progresso, label_contador, label_divisor, label_totalOS});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        AbriuOrdemServico();
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbriuOrdemServico(){
        if(abriuOrdemServico == 0)
            return;
        abriuOrdemServico = 0;
        PegaOrdemServico("S");
    }
    
    private void txt_osInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_osInicialFocusLost
        txt_osInicial.setText(fc.FormataCampo(txt_osInicial.getText(), 9, 0));
    }//GEN-LAST:event_txt_osInicialFocusLost

    private void txt_osFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_osFinalFocusLost
        if(txt_osFinal.getText().replace(" ", "").equals("")){
            txt_osFinal.setText("999999999");
            return;
        }
        txt_osFinal.setText(fc.FormataCampo(txt_osFinal.getText(), 9, 0));
    }//GEN-LAST:event_txt_osFinalFocusLost

    private void bt_processaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_processaActionPerformed
        bt_processa.setEnabled  (false);
        bt_processa.setFocusable(false);
//        new Thread(){
//            public void run(){
                PegaOrdemServico("S");
//            }
//        }.start();
        bt_processa.setEnabled  (true);
        bt_processa.setFocusable(true);
    }//GEN-LAST:event_bt_processaActionPerformed

    private void txt_osInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_osInicialFocusGained
        txt_osInicial.setSelectionStart(0);
        txt_osInicial.setSelectionEnd  (txt_osInicial.getText().length());
    }//GEN-LAST:event_txt_osInicialFocusGained

    private void txt_osFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_osFinalFocusGained
        txt_osFinal.setSelectionStart(0);
        txt_osFinal.setSelectionEnd  (txt_osFinal.getText().length());
    }//GEN-LAST:event_txt_osFinalFocusGained

    private void tabela_OrdemServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_OrdemServicoMouseClicked
        linha           = tabela_OrdemServico.getSelectedRow();
        if(linha < 0){
            mensagem = "Item não selecionado!";
            new MostraMensagem(mensagem);
            return;
        }
        bt_finalizarOS  .setEnabled(false);
        bt_cancelarOS   .setEnabled(false);
        bt_alterarOS    .setEnabled(false);
        if(linha == tabela_OrdemServico.getRowCount() - 1){
            bt_detalhesItem .setEnabled(false);
            return;
        }
        retorno             = String.valueOf(Integer.parseInt(String.valueOf(tabela_OrdemServico.getValueAt(linha, 0))));
        bos.idOrdemServico  = Integer.parseInt(retorno);
        PegaOrdemServico("N");
        
        bt_detalhesItem .setEnabled(true);
        bt_alterarOS    .setEnabled(true);
        bt_cancelarOS   .setEnabled(true);
        bt_finalizarOS  .setEnabled(true);
        if(bos.usuarioFinalizou != 0 || bos.usuarioCancelou != 0 || bos.usuarioSemSolucao != 0){
            bt_detalhesItem .setEnabled(true);
            bt_alterarOS    .setEnabled(false);
            bt_cancelarOS   .setEnabled(false);
            bt_finalizarOS  .setEnabled(false);
        }
        if(evt.getButton() == MouseEvent.BUTTON3)
            if(somostra.equalsIgnoreCase("N"))
                MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
        if(fazManutencao.equals("S"))
            return;
        if(evt.getClickCount() < 2)
            return;
        dispose();
    }//GEN-LAST:event_tabela_OrdemServicoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bt_exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_exportarActionPerformed
        SeletorExcel = new JFileChooser();
        SalvarExcel = SeletorExcel.showSaveDialog(tabela_OrdemServico);
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
        try{
            new ExportarParaExcel(tabela_OrdemServico, new File(LocalArquivo), 0, 0, 0);
        }catch (IOException erro) {
            mensagem = "Erro: " + erro.getMessage();
            new MostraMensagem(mensagem);
        }
    }//GEN-LAST:event_bt_exportarActionPerformed

    private void txt_osInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_osInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_osFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_osInicial.setText(fc.FormataCampo("", 9, 0));
            txt_osFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_osInicialKeyPressed

    private void txt_osFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_osFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_descricao.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_osFinal.setText("999999999");
            txt_descricao.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_osFinalKeyPressed

    private void bt_alterarOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarOSActionPerformed
        if(OrdSerCad != null)if(OrdSerCad.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        abriuOrdemServico = 1;
        OrdSerCad = new OrdemServicoCadastro("SN" ,Integer.parseInt(retorno));
        OrdSerCad.setVisible(true);
    }//GEN-LAST:event_bt_alterarOSActionPerformed

    private void bt_finalizarOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_finalizarOSActionPerformed
        if(FinalizarOS != null)if(FinalizarOS.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        abriuOrdemServico = 1;
        FinalizarOS = new OrdemServicoFinalizar(Integer.parseInt(retorno));
        FinalizarOS.setVisible(true);
    }//GEN-LAST:event_bt_finalizarOSActionPerformed

    private void bt_detalhesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesItemActionPerformed
        if(OrdSerCad != null)if(OrdSerCad.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        abriuOrdemServico = 1;
        OrdSerCad = new OrdemServicoCadastro("S", Integer.parseInt(retorno));
        OrdSerCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesItemActionPerformed

    private void bt_cancelarOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarOSActionPerformed
        if(OrdSerCan != null)if(OrdSerCan.isVisible()){
            mensagem = "Tela já Aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        abriuOrdemServico = 1;
        OrdSerCan = new OrdemServicoCancelar(bos.idOrdemServico);
        OrdSerCan.setVisible(true);
    }//GEN-LAST:event_bt_cancelarOSActionPerformed
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        abriuOrdemServico = 1;
        OrdSerCad = new OrdemServicoCadastro("SN", 0);
        OrdSerCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Table = (DefaultTableModel)tabela_OrdemServico.getModel();
        
        if(fazManutencao.equals("N")){
            bt_alterarOS    .setVisible(false);
            bt_cancelarOS   .setVisible(false);
            bt_finalizarOS  .setVisible(false);
            setTitle("Consulta Ordens de Serviço");
        }else{
            bt_alterarOS    .setVisible(true);
            bt_cancelarOS   .setVisible(true);
            bt_finalizarOS  .setVisible(true);
            setTitle("Manutenção Ordens de Serviço");
        }
        
        InicializaCampos();
        
        label_processando.setVisible(false);
//        new Thread(){
//            public void run(){
                PegaOrdemServico("S");
//            }
//        }.start();
        
        if(parametrosNS.bu.nivelUsuario  < 4 | somostra.equals("S"))
            jMenu.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(UsuCon      != null)UsuCon      .dispose();
        if(CliCon      != null)CliCon      .dispose();
        if(OrdSerCad   != null)OrdSerCad   .dispose();
        if(FinalizarOS != null)FinalizarOS .dispose();
        if(OrdSerCan   != null)OrdSerCan   .dispose();
    }//GEN-LAST:event_formWindowClosed

    private void combo_statusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_statusItemStateChanged
        if(combo_status.getSelectedIndex() < 6)
        combo_statusPersonalizado.setVisible(false);
        else
        combo_statusPersonalizado.setVisible(true);
    }//GEN-LAST:event_combo_statusItemStateChanged

    private void txt_descricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descricaoKeyReleased
        textoBusca = txt_descricao.getText();
        PegaOrdemServico("S");
    }//GEN-LAST:event_txt_descricaoKeyReleased

    private void txt_qtdRegistrosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_qtdRegistrosFocusGained
        txt_qtdRegistros.setSelectionStart(0);
        txt_qtdRegistros.setSelectionEnd  (txt_qtdRegistros.getText().length());
    }//GEN-LAST:event_txt_qtdRegistrosFocusGained

    private void txt_qtdRegistrosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_qtdRegistrosFocusLost
        txt_qtdRegistros.setText(parametrosNS.fc.FormataCampo(txt_qtdRegistros.getText(), 3, 0));
    }//GEN-LAST:event_txt_qtdRegistrosFocusLost
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JProgressBar barra_progresso;
    private javax.swing.JMenuItem bt_alterarOS;
    private javax.swing.JMenuItem bt_cancelarOS;
    private javax.swing.JMenuItem bt_detalhesItem;
    private javax.swing.JButton bt_exportar;
    private javax.swing.JMenuItem bt_finalizarOS;
    private javax.swing.JButton bt_processa;
    private javax.swing.JMenuItem bt_sair;
    private javax.swing.JComboBox<String> combo_status;
    private javax.swing.JComboBox<String> combo_statusPersonalizado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel label_contador;
    private javax.swing.JLabel label_divisor;
    private javax.swing.JLabel label_processando;
    private javax.swing.JLabel label_totalOS;
    private javax.swing.JTable tabela_OrdemServico;
    private javax.swing.JTextField txt_descricao;
    private javax.swing.JFormattedTextField txt_osFinal;
    private javax.swing.JFormattedTextField txt_osInicial;
    private javax.swing.JFormattedTextField txt_qtdRegistros;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
    private void PegaUsuario() {
        bu.usuario = "----------";
        if(bu.codigoUsuario == 0)
            return;
        sql = "select idUsuario, idEmpresa, codigoGrupo, codigoEmpresa, codigoUsuario, usuario from tb_usuarios where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
        dadosUsuarios.clear();
        dadosUsuarios = parametrosNS.dao.Consulta(sql);
        if(dadosUsuarios.isEmpty()){
            mensagem = "Usuario " + bu.codigoUsuario + " não encontrado!";
            new MostraMensagem(mensagem);
            return;
        }
        PegaDadosUsuario();
    }
    
    private void PegaDadosUsuario(){
        for(int i = 0; i < dadosUsuarios.size(); i++){
            bu = new BeanUsuarios();
            bu.idUsuario            = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(0)));
            bu.idEmpresa            = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(1)));
            bu.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(2)));
            bu.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(3)));
            bu.codigoUsuario        = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(4)));
            bu.usuario              =                    String.valueOf(dadosUsuarios.get(i).get(5));
        }
    }
    
    private void PegaValores(){
        fatal = "N";
        preenchimento = "";
        index = combo_status.getSelectedIndex();
        Texto = String.valueOf(combo_statusPersonalizado.getSelectedItem()) + " ";
        statusOs1 = -1;
        statusOs2 = -1;
        statusOs3 = -1;
        statusOs4 = -1;
        statusOs5 = -1;
        if(index == 0){ 
            statusOs1 = 0;  //0 - Pendente
            statusOs2 = 1;  //1 - Cancelada
            statusOs3 = 2;  //2 - Finalizada
            statusOs4 = 3;  //3 - Sem solução
            statusOs5 = 4;  //4 - Faturada
        }
        if(index == 1){
            statusOs1 = 0;  //0 - Pendente
            statusOs2 = 0;  //0 - Pendente
            statusOs3 = 0;  //0 - Pendente
            statusOs4 = 0;  //0 - Pendente
            statusOs5 = 0;  //0 - Pendente
            preenchimento = "\n and (statusOs = " + statusOs1 + " or statusOs = " + statusOs2 + " or statusOs = " + statusOs3 + " or statusOs = " + statusOs4 + " or statusOs = " + statusOs5 + ")";
        }
        if(index == 2){
            statusOs1 = 1;  //1 - Cancelada
            statusOs2 = 1;  //1 - Cancelada
            statusOs3 = 1;  //1 - Cancelada
            statusOs4 = 1;  //1 - Cancelada
            statusOs5 = 1;  //1 - Cancelada
            preenchimento = "\n and (statusOs = " + statusOs1 + " or statusOs = " + statusOs2 + " or statusOs = " + statusOs3 + " or statusOs = " + statusOs4 + " or statusOs = " + statusOs5 + ")";
        }
        if(index == 3){
            statusOs1 = 2;  //2 - Finalizada
            statusOs2 = 2;  //2 - Finalizada
            statusOs3 = 2;  //2 - Finalizada
            statusOs4 = 2;  //2 - Finalizada
            statusOs5 = 2;  //2 - Finalizada
            preenchimento = "\n and (statusOs = " + statusOs1 + " or statusOs = " + statusOs2 + " or statusOs = " + statusOs3 + " or statusOs = " + statusOs4 + " or statusOs = " + statusOs5 + ")";
        }
        if(index == 4){
            statusOs1 = 3;  //3 - Sem solução
            statusOs2 = 3;  //3 - Sem solução
            statusOs3 = 3;  //3 - Sem solução
            statusOs4 = 3;  //3 - Sem solução
            statusOs5 = 3;  //3 - Sem solução
            preenchimento = "\n and (statusOs = " + statusOs1 + " or statusOs = " + statusOs2 + " or statusOs = " + statusOs3 + " or statusOs = " + statusOs4 + " or statusOs = " + statusOs5 + ")";
        }
        if(index == 5){
            statusOs1 = 4;  //4 - Faturada
            statusOs2 = 4;  //4 - Faturada
            statusOs3 = 4;  //4 - Faturada
            statusOs4 = 4;  //4 - Faturada
            statusOs5 = 4;  //4 - Faturada
            preenchimento = "\n and (statusOs = " + statusOs1 + " or statusOs = " + statusOs2 + " or statusOs = " + statusOs3 + " or statusOs = " + statusOs4 + " or statusOs = " + statusOs5 + ")";
        }
        if(index == 6){
            for(int i = 0; i < Texto.length() - 8; i++){
                ValorTexto = Texto.substring(i, i + 8);
                if(ValorTexto.equalsIgnoreCase("Pendente")){
                    statusOs1 = 0;
                    if(statusOs2 != 1)
                        statusOs2 = statusOs1;
                    if(statusOs3 != 2)
                        statusOs3 = statusOs1;
                    if(statusOs4 != 3)
                        statusOs4 = statusOs1;
                    if(statusOs5 != 4)
                        statusOs5 = statusOs1;
                    break;
                }
            }
            for(int i = 0; i < Texto.length() - 9; i++){
                ValorTexto = Texto.substring(i, i + 9);
                if(ValorTexto.equalsIgnoreCase("Cancelada")){
                    statusOs2 = 1;
                    if(statusOs1 != 0)
                        statusOs1 = statusOs2;
                    if(statusOs3 != 2)
                        statusOs3 = statusOs2;
                    if(statusOs4 != 3)
                        statusOs4 = statusOs2;
                    if(statusOs5 != 4)
                        statusOs5 = statusOs2;
                    break;
                }
            }
            for(int i = 0; i < Texto.length() - 10; i++){
                ValorTexto = Texto.substring(i, i + 10);
                if(ValorTexto.equalsIgnoreCase("Finalizada")){
                    statusOs3 = 2;
                    if(statusOs1 != 0)
                        statusOs1 = statusOs3;
                    if(statusOs2 != 1)
                        statusOs2 = statusOs3;
                    if(statusOs4 != 3)
                        statusOs4 = statusOs3;
                    if(statusOs5 != 4)
                        statusOs5 = statusOs3;
                    break;
                }
            }
            for(int i = 0; i < Texto.length() - 11; i++){
                ValorTexto = Texto.substring(i, i + 11);
                if(ValorTexto.equalsIgnoreCase("Sem Solução")){
                    statusOs4 = 3;
                    if(statusOs1 != 0)
                        statusOs1 = statusOs4;
                    if(statusOs2 != 1)
                        statusOs2 = statusOs4;
                    if(statusOs3 != 2)
                        statusOs3 = statusOs4;
                    if(statusOs5 != 4)
                        statusOs5 = statusOs4;
                    break;
                }
            }
            for(int i = 0; i < Texto.length() - 8; i++){
                ValorTexto = Texto.substring(i, i + 8);
                if(ValorTexto.equalsIgnoreCase("Faturada")){
                    statusOs5 = 4;
                    if(statusOs1 != 0)
                        statusOs1 = statusOs5;
                    if(statusOs2 != 1)
                        statusOs2 = statusOs5;
                    if(statusOs3 != 2)
                        statusOs3 = statusOs5;
                    if(statusOs4 != 3)
                        statusOs4 = statusOs5;
                    break;
                }
            }
            preenchimento = "\n and (statusOs = " + statusOs1 + " or statusOs = " + statusOs2 + " or statusOs = " + statusOs3 + " or statusOs = " + statusOs4 + " or statusOs = " + statusOs5 + ")";
        }
        
        binter.osInicial = Integer.parseInt(txt_osInicial.getText());
        binter.osFinal   = Integer.parseInt(txt_osFinal.getText());
        if(binter.osInicial > binter.osFinal){
            mensagem = "OS inicial não pode ser maior do que OS Final!";
            new MostraMensagem(mensagem);
            fatal = "S";
            return;
        }
        if(binter.osInicial != 0 || binter.osFinal != 999999999){
            preenchimento += "\n and os.codigoOrdemServico between " + binter.osInicial + " and " + binter.osFinal + " ";
        }
        
        textoBusca   = txt_descricao.getText();
        qtdRegistros = Integer.parseInt(txt_qtdRegistros.getText());
    }
    
    private void PegaOrdemServico(String Mostra){
        if(Mostra.equals("S")){
            label_processando.setVisible(true);
        }
        PegaValores();
        if(fatal.equals("S")){
            return;
        }
        sql1 = "";
        sql = "select \n"
            + "   os.idOrdemServico, \n"
            + "   os.idEmpresa, \n"
            + "   os.codigoGrupo, \n"
            + "   os.codigoEmpresa, \n"
            + "   os.codigoOrdemServico, \n"
            + "   os.codigoCliente, \n"
            + "   cli.nome, \n"
            + "   os.dataCadastro, \n"
            + "   os.horaCadastro, \n"
            + "   os.dataEntrada, \n"
            + "   os.horaEntrada, \n"
            + "   os.dataPrevista, \n"
            + "   os.descricao, \n"
            + "   os.statusOs, \n"
            + "   os.codigoUsuario, \n"
            + "   usu.usuario, \n"
            + "   os.aprovacao, \n"
            + "   os.marca, \n"
            + "   os.modelo, \n"
            + "   os.dataGarantia, \n"
            + "   os.dataCancelou, \n"
            + "   os.horaCancelou, \n"
            + "   os.usuarioCancelou, \n"
            + "   os.idEmpresaCancelou, \n"
            + "   os.dataFinalizou, \n"
            + "   os.horaFinalizou, \n"
            + "   os.usuarioFinalizou, \n"
            + "   os.idEmpresaFinalizou, \n"
            + "   os.dataSemSolucao, \n"
            + "   os.horaSemSolucao, \n"
            + "   os.usuarioSemSolucao, \n"
            + "   os.idEmpresaSemSolucao \n"
            + "from \n"
            + "   tb_os os \n"
            + "   left join tb_usuarios usu on ((os.idEmpresa = usu.idEmpresa) and (os.codigoUsuario = usu.codigoUsuario)) \n"
            + "   left join tb_clientes cli on ((os.idEmpresa = cli.idEmpresa) and (os.codigoCliente = cli.codigoCliente)) ";
        if(Mostra.equals("S")){
            sql += "\n   where os.codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and os.codigoEmpresa = " + parametrosNS.be.CodigoEmpresa
                +  "\n and codigoOrdemServico between " + binter.osInicial + " and " + binter.osFinal + preenchimento;
            if(!textoBusca.equals("")){
                sql += "\n and os.";
                sql1 = " like '%" + textoBusca + "%'";
            }
            sql1 += " \n      order by os.codigoOrdemServico desc limit " + qtdRegistros + ";";
            if(textoBusca.equals("")){
                sql += sql1;
                sql1 = "";
            }
        }
        if(Mostra.equals("N")){
            sql += "\n where idOrdemServico = " + bos.idOrdemServico + ";";
        }
        dadosOrdemServico.clear();
        if( sql1.equals("")){dadosOrdemServico = parametrosNS.dao.Consulta(sql);}
        if(!sql1.equals("")){dadosOrdemServico = parametrosNS.PesqAvan.PesquisaAvancada(sql, sql1, "tb_os");}
        if(Mostra.equals("S")){
            barra_progresso.setValue(0);
            barra_progresso.setMaximum(dadosOrdemServico.size());
        }
        if(dadosOrdemServico.isEmpty()){
            if(Mostra.equals("S")){
                PegaOrdemServico("S");
                bt_exportar.setEnabled(false);
                return;
            }
            return;
        }
        if(Mostra.equals("S"))label_totalOS.setText(fc.FormataCampo(String.valueOf(dadosOrdemServico.size()), 5, 0));
        PreencherTabelaOrdemServico(Mostra);
        label_processando.setVisible(false);
    }
    
    @SuppressWarnings("SuspiciousIndentAfterControlStatement")
    private void PreencherTabelaOrdemServico(String Mostra){
        tabela_OrdemServico.getColumnModel().getColumn(0).setMinWidth(0);
        tabela_OrdemServico.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabela_OrdemServico.getColumnModel().getColumn(0).setMaxWidth(0);
        tabela_OrdemServico.getColumnModel().getColumn(1).setResizable(false);
        tabela_OrdemServico.getColumnModel().getColumn(3).setResizable(false);
        tabela_OrdemServico.getColumnModel().getColumn(4).setResizable(false);
        tabela_OrdemServico.getColumnModel().getColumn(5).setResizable(false);
        tabela_OrdemServico.getColumnModel().getColumn(6).setResizable(false);
        tabela_OrdemServico.getColumnModel().getColumn(8).setResizable(false);
        tabela_OrdemServico.getColumnModel().getColumn(9).setResizable(false);
        tabela_OrdemServico.getColumnModel().getColumn(10).setResizable(false);
        tabela_OrdemServico.getColumnModel().getColumn(11).setResizable(false);
        tabela_OrdemServico.getColumnModel().getColumn(12).setResizable(false);
        tabela_OrdemServico.getColumnModel().getColumn(16).setResizable(false);
        tabela_OrdemServico.getColumnModel().getColumn(17).setResizable(false);
        tabela_OrdemServico.getColumnModel().getColumn(18).setResizable(false);
        
        int diasRestantes = 0;
        
        if(Mostra.equals("S"))
            Table.setNumRows(0);
        String nomeCliente          = "";
        String usuarioDigitou       = "";
        
        String usuarioFinalizou     = "";
        String dataFinalizou        = "";
        String horaFinalizou        = "";
                
        String statusAprovacao      = "";
        String statusOrdemServico   = "";
        double Total                = 0;
        ValorTotalOrdemServico      = 0;
        contador = 0;
        
//        int posicao = 0;
        for(int i = 0; i < dadosOrdemServico.size(); i++){
            nomeCliente          = "";
            usuarioDigitou       = "";
            
            usuarioFinalizou     = "";
            dataFinalizou        = "";
            horaFinalizou        = "";
            
            statusAprovacao      = "";
            statusOrdemServico   = "";
//            try{new Thread().sleep(150);}catch(Exception e){}
            bos = new BeanOrdemServico();
            bc  = new BeanClientes();
            if(dadosOrdemServico.get(i).get(0) != null)
                bos.idOrdemServico      = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(0)));
            if(dadosOrdemServico.get(i).get(1) != null)
                bos.idEmpresa           = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(1)));
            if(dadosOrdemServico.get(i).get(2) != null)
                bos.codigoGrupo         = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(2)));
            if(dadosOrdemServico.get(i).get(3) != null)
                bos.codigoEmpresa       = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(3)));
            if(dadosOrdemServico.get(i).get(4) != null)
                bos.codigoOrdemServico  = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(4)));
            if(dadosOrdemServico.get(i).get(5) != null)
                bos.codigoCliente       = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(5)));
            
            bc.codigoCliente     = bos.codigoCliente;
            bc.nome              = String.valueOf(dadosOrdemServico.get(i).get(6));
            nomeCliente          = fc.FormataCampo(String.valueOf(bc.codigoCliente), 5, 0) + "-" + bc.nome;
            
                bos.dataCadastro        =                    String.valueOf(dadosOrdemServico.get(i).get(7));
                bos.horaCadastro        =                    String.valueOf(dadosOrdemServico.get(i).get(8));
                bos.dataEntrada         =                    String.valueOf(dadosOrdemServico.get(i).get(9));
                bos.horaEntrada         =                    String.valueOf(dadosOrdemServico.get(i).get(10));
            if(dadosOrdemServico.get(i).get(11) != null)
                bos.dataPrevista        =                    String.valueOf(dadosOrdemServico.get(i).get(11));
            if(dadosOrdemServico.get(i).get(12) != null)
                bos.descricao           =                    String.valueOf(dadosOrdemServico.get(i).get(12));
            if(dadosOrdemServico.get(i).get(13) != null)
                bos.statusOs            = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(13)));
            if(dadosOrdemServico.get(i).get(14) != null)
                bos.codigoUsuario       = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(14)));
            
            bu.codigoUsuario     = bos.codigoUsuario;
            bu.usuario           = String.valueOf(dadosOrdemServico.get(i).get(15));
            usuarioDigitou       = fc.FormataCampo(String.valueOf(bu.codigoUsuario), 3, 0) + "-" + bu.usuario;
            
            if(dadosOrdemServico.get(i).get(16) != null)
                bos.aprovacao           = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(16)));
                bos.marca               =                    String.valueOf(dadosOrdemServico.get(i).get(17));
                bos.modelo              =                    String.valueOf(dadosOrdemServico.get(i).get(18));
            if(dadosOrdemServico.get(i).get(19) != null)
                bos.dataGarantia        =                    String.valueOf(dadosOrdemServico.get(i).get(19));
                
            if(dadosOrdemServico.get(i).get(20) != null)
                bos.dataCancelou        =                    String.valueOf(dadosOrdemServico.get(i).get(20));
            if(dadosOrdemServico.get(i).get(21) != null)
                bos.horaCancelou        =                    String.valueOf(dadosOrdemServico.get(i).get(21));
            if(dadosOrdemServico.get(i).get(22) != null)
                bos.usuarioCancelou     = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(22)));
            if(dadosOrdemServico.get(i).get(23) != null)
                bos.idEmpresaCancelou   = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(23)));
            
            bu.codigoUsuario     = bos.usuarioCancelou;
            if(bu.codigoUsuario != 0){
                bu.idEmpresa     = bos.idEmpresaCancelou;
                PegaUsuario();
                usuarioFinalizou = fc.FormataCampo(String.valueOf(bu.codigoUsuario), 3, 0) + "-" + bu.usuario;
                dataFinalizou    = invdata.inverterData(bos.dataCancelou, 1);
                horaFinalizou    = bos.horaCancelou;
            }
            
            if(dadosOrdemServico.get(i).get(24) != null)
                bos.dataFinalizou       =                    String.valueOf(dadosOrdemServico.get(i).get(24));
            if(dadosOrdemServico.get(i).get(25) != null)
                bos.horaFinalizou       =                    String.valueOf(dadosOrdemServico.get(i).get(25));
            if(dadosOrdemServico.get(i).get(26) != null)
                bos.usuarioFinalizou    = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(26)));
            if(dadosOrdemServico.get(i).get(27) != null)
                bos.idEmpresaFinalizou  = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(27)));
            
            bu.codigoUsuario     = bos.usuarioFinalizou;
            if(bu.codigoUsuario != 0){
                bu.idEmpresa     = bos.idEmpresaFinalizou;
                PegaUsuario();
                usuarioFinalizou = fc.FormataCampo(String.valueOf(bu.codigoUsuario), 3, 0) + "-" + bu.usuario;
                dataFinalizou    = invdata.inverterData(bos.dataFinalizou, 1);
                horaFinalizou    = bos.horaFinalizou;
            }
            
            if(dadosOrdemServico.get(i).get(28) != null)
                bos.dataSemSolucao      =                    String.valueOf(dadosOrdemServico.get(i).get(28));
            if(dadosOrdemServico.get(i).get(29) != null)
                bos.horaSemSolucao      =                    String.valueOf(dadosOrdemServico.get(i).get(29));
            if(dadosOrdemServico.get(i).get(30) != null)
                bos.usuarioSemSolucao   = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(30)));
            if(dadosOrdemServico.get(i).get(31) != null)
                bos.idEmpresaSemSolucao = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(31)));
            
            bu.codigoUsuario     = bos.usuarioSemSolucao;
            if(bu.codigoUsuario != 0){
                bu.idEmpresa     = bos.idEmpresaSemSolucao;
                PegaUsuario();
                usuarioFinalizou = fc.FormataCampo(String.valueOf(bu.codigoUsuario), 3, 0) + "-" + bu.usuario;
                dataFinalizou    = invdata.inverterData(bos.dataSemSolucao, 1);
                horaFinalizou    = bos.horaSemSolucao;
            }
            
            if(Mostra.equals("N")){
                return;
            }
            
//            if(buscaPeloBotao.equals("N")){
//                posicao = txt_descricao.getText().length();
//                switch(index2){
//                    case 1: txt_descricao.setText(bos.descricao);
//                            txt_descricao.setSelectionStart(posicao);
//                            txt_descricao.setSelectionEnd  (txt_descricao.getText().length());
//                    case 2: txt_descricao.setText(bos.marca);
//                            txt_descricao.setSelectionStart(posicao);
//                            txt_descricao.setSelectionEnd  (txt_descricao.getText().length());
//                    case 3: txt_descricao.setText(bos.modelo);
//                            txt_descricao.setSelectionStart(posicao);
//                            txt_descricao.setSelectionEnd  (txt_descricao.getText().length());
//                }
//            }
            
            setaBarra();
            
            bosi.idEmpresa          = bos.idEmpresa;
            bosi.codigoGrupo        = bos.codigoGrupo;
            bosi.codigoEmpresa      = bos.codigoEmpresa;
            bosi.codigoOrdemServico = bos.codigoOrdemServico;
            PegaItensOrdemServico();
            
            ValorOrdemServico       = bos.valorPecas + bos.valorMaoDeObra + bos.valorDeslocamento + bos.valorOutros + bos.valorTerceiros;
            ValorTotalOrdemServico  = ValorTotalOrdemServico    + ValorOrdemServico;
            
            switch(bos.statusOs){
                case 0: statusOrdemServico  = "Pendente";   break;
                case 1: statusOrdemServico  = "Cancelada";  break;
                case 2: statusOrdemServico  = "Finalizada"; break;
                case 3: statusOrdemServico  = "Sem Solução";break;
                case 4: statusOrdemServico  = "Faturada";   break;
            }
            
            bos.dataCadastro = invdata.inverterData(bos.dataCadastro, 1) + "   " + bos.horaCadastro;
            bos.dataEntrada  = invdata.inverterData(bos.dataEntrada , 1) + "   " + bos.horaEntrada;
            bos.dataPrevista = invdata.inverterData(bos.dataPrevista, 1);
            bos.dataGarantia = invdata.inverterData(bos.dataGarantia, 1);
            
            if(bos.descricao.equals(""))
                bos.descricao   = "----------";
            
            switch(bos.aprovacao){
                case 0: statusAprovacao = "Não"; break;
                case 1: statusAprovacao = "Sim"; break;
            }
            
            if(bos.statusOs == 0){
                if(!bos.dataPrevista.equals("")){
                    diasRestantes = parametrosNS.Test.Testa(bos.dataPrevista) - parametrosNS.Test.Testa(cdh.CapturarData());
                    if(diasRestantes > 0 && diasRestantes < 10){
                        mensagem = "Restam " + diasRestantes + " para passar a data prevista da OS n°" + bos.codigoOrdemServico + "!";
                        new MostraMensagem(mensagem);
                    }
                }
            }
            
            Table.addRow(new Object [] {fc.FormataCampo(String.valueOf(bos.idOrdemServico), 9, 0), fc.FormataCampo(String.valueOf(bos.codigoOrdemServico), 9, 0), nomeCliente, bos.dataCadastro, bos.dataEntrada, bos.dataPrevista, bos.descricao, statusOrdemServico, dataFinalizou, horaFinalizou, usuarioDigitou, statusAprovacao, usuarioFinalizou, bos.marca, bos.modelo, bos.dataGarantia, TransStrDou.TransformaValorStringeDouble(String.valueOf(bos.valorMaoDeObra), 0), TransStrDou.TransformaValorStringeDouble(String.valueOf(bos.valorPecas), 0), TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorOrdemServico), 0)});
        }
        if(tabela_OrdemServico.getRowCount() > 0){
            ConvTabOSeVenBol.numeroDaColuna = 7;
            for(int i = 0; i < tabela_OrdemServico.getColumnCount(); i++){
                tabela_OrdemServico.getColumnModel().getColumn(i).setCellRenderer(ConvTabOSeVenBol);
            }
            tabela_OrdemServico.updateUI();
            bt_exportar.setEnabled(true);
            Table.addRow(new Object [] {"", "", "Totais", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotalOrdemServico), 0)});
        }
        new AjustarLarguraColunas(tabela_OrdemServico);
    }
    
    private void setaBarra(){
        contador++;
        barra_progresso.setValue(contador);
        barra_progresso.repaint();
        label_contador.setText(fc.FormataCampo(String.valueOf(contador), 5, 0));
//        if(totalRegistros == contador){
//            ini.mensagem = "Operação concluída com sucesso!";
//            mostraMensagem();
//        }
    }
    
    private void PegaItensOrdemServico(){
        sql = "select \n"
            + "   idOrdemServicoItem, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoOrdemServico, \n"
            + "   codigoOrdemServicoItem, \n"
            + "   codigoUsuario, \n"
            + "   valorUnitario, \n"
            + "   quantidade, \n"
            + "   valorTotal \n"
            + "from \n"
            + "   tb_os_itens where idEmpresa = " + bos.idEmpresa + " and codigoOrdemServico = " + bosi.codigoOrdemServico + ";";
        dadosOrdemServicoItens.clear();
        dadosOrdemServicoItens = parametrosNS.dao.Consulta(sql);
        if(dadosOrdemServicoItens.isEmpty())
            return;
        PegaDadosItensOrdemServico();
    }
    
    private void PegaDadosItensOrdemServico(){
        bos.valorPecas      = 0;
        bos.valorMaoDeObra  = 0;
        for(int i = 0; i < dadosOrdemServicoItens.size(); i++){
            bosi = new BeanOrdemServicoItens();
        if(dadosOrdemServicoItens.get(i).get(0) != null){
            bosi.idOrdemServicoItem     = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(0)));
        }
        if(dadosOrdemServicoItens.get(i).get(1) != null){
            bosi.idEmpresa              = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(1)));
        }
        if(dadosOrdemServicoItens.get(i).get(2) != null){
            bosi.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(2)));
        }
        if(dadosOrdemServicoItens.get(i).get(3) != null){
            bosi.codigoOrdemServico     = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(3)));
        }
        if(dadosOrdemServicoItens.get(i).get(4) != null){
            bosi.codigoOrdemServicoItem = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(4)));
        }
        if(dadosOrdemServicoItens.get(i).get(5) != null){
            bosi.codigoUsuario          = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(5)));
        }
        if(dadosOrdemServicoItens.get(i).get(6) != null){
            bosi.valorUnitario          = Double.parseDouble(String.valueOf(dadosOrdemServicoItens.get(i).get(6)));
        }
        if(dadosOrdemServicoItens.get(i).get(7) != null){
            bosi.quantidade             = Double.parseDouble(String.valueOf(dadosOrdemServicoItens.get(i).get(7)));
        }
        if(dadosOrdemServicoItens.get(i).get(8) != null){
            bosi.valorTotal             = Double.parseDouble(String.valueOf(dadosOrdemServicoItens.get(i).get(8)));
        }
            
            if(bosi.tipo == 1)
                bos.valorPecas      = bos.valorPecas        + bosi.valorTotal;
            else
                bos.valorMaoDeObra  = bos.valorMaoDeObra    + bosi.valorTotal;
        }
    }
    
//    private void PegaCliente(){
//        bc.nome = "----------";
//        if(bc.codigoCliente == 0)
//            return;
//        sql = "select * from tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCliente = " + bc.codigoCliente + ";";
//        dadosCliente.clear();
//        dadosCliente = parametrosNS.dao.Consulta(sql);
//        if(dadosCliente.isEmpty()){
//            mensagem = "Cliente " + bc.codigoCliente + " não encontrado!";
//            new MostraMensagem(mensagem);
//            return;
//        }
//        PegaDadosCliente();
//    }
//
//    private void PegaDadosCliente(){
//        for(int i = 0; i < dadosCliente.size(); i++){
//            bc.idCliente            = ((BeanClientes)(dadosCliente.get(i))).idCliente;
//            bc.codigoGrupo          = ((BeanClientes)(dadosCliente.get(i))).codigoGrupo;
//            bc.codigoEmpresa        = ((BeanClientes)(dadosCliente.get(i))).codigoEmpresa;
//            bc.nome                 = ((BeanClientes)(dadosCliente.get(i))).nome;
//        }
//    }
//    
//    private void PegaOrdemServicoCancelada(){
//        bosc.usuarioCancelou = 0;
//        sql = "select * from tb_os_canceladas where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoOrdemServico = " + bosc.codigoOrdemServico + ";";
//        dadosOrdemServicoCanceladas.clear();
//        dadosOrdemServicoCanceladas = parametrosNS.dao.ConsultaOrdemServicoCanceladas(sql);
//        if(dadosOrdemServicoCanceladas.isEmpty()){
//            bosc.usuarioCancelou        = 0;
//            return;
//        }
//        PegaDadosOrdermServicoCancelada();
//    }
//    
//    private void PegaDadosOrdermServicoCancelada(){
//        for(int i = 0; i < dadosOrdemServicoCanceladas.size(); i++){
//            bosc    = new BeanOrdemServicoCanceladas();
//            bosc.idOsCancelada          = ((BeanOrdemServicoCanceladas)(dadosOrdemServicoCanceladas.get(i))).idOsCancelada;
//            bosc.codigoGrupo            = ((BeanOrdemServicoCanceladas)(dadosOrdemServicoCanceladas.get(i))).codigoGrupo;
//            bosc.codigoEmpresa          = ((BeanOrdemServicoCanceladas)(dadosOrdemServicoCanceladas.get(i))).codigoEmpresa;
//            bosc.codigoOrdemServico     = ((BeanOrdemServicoCanceladas)(dadosOrdemServicoCanceladas.get(i))).codigoOrdemServico;
//            bosc.codigoCancelamento     = ((BeanOrdemServicoCanceladas)(dadosOrdemServicoCanceladas.get(i))).codigoCancelamento;
//            bosc.detalhesCancelamento   = ((BeanOrdemServicoCanceladas)(dadosOrdemServicoCanceladas.get(i))).detalhesCancelamento;
//            bosc.dataCancelou           = ((BeanOrdemServicoCanceladas)(dadosOrdemServicoCanceladas.get(i))).dataCancelou;
//            bosc.horaCancelou           = ((BeanOrdemServicoCanceladas)(dadosOrdemServicoCanceladas.get(i))).horaCancelou;
//            bosc.usuarioCancelou        = ((BeanOrdemServicoCanceladas)(dadosOrdemServicoCanceladas.get(i))).usuarioCancelou;
//            bosc.computadorCancelou     = ((BeanOrdemServicoCanceladas)(dadosOrdemServicoCanceladas.get(i))).computadorCancelou;
//        }
//    }
//    
//    private void PegaOrdemServicoFinalizada(){
//        bosf.usuarioFinalizou   = 0;
//        sql = "select * from tb_os_finalizadas where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoOrdemServico = " + bosf.codigoOrdemServico + ";";
//        dadosOrdemServicoFinalizadas.clear();
//        dadosOrdemServicoFinalizadas = parametrosNS.dao.ConsultaOrdemServicoFinalizadas(sql);
//        if(dadosOrdemServicoFinalizadas.isEmpty())
//            return;
//        PegaDadosOrdemServicoFinalizada();
//    }
//    
//    private void PegaDadosOrdemServicoFinalizada(){
//        for(int i = 0; i < dadosOrdemServicoFinalizadas.size(); i++){
//            bosf    = new BeanOrdemServicoFinalizadas();
//            bosf.idOsFinalizada         = ((BeanOrdemServicoFinalizadas)(dadosOrdemServicoFinalizadas.get(i))).idOsFinalizada;
//            bosf.codigoGrupo            = ((BeanOrdemServicoFinalizadas)(dadosOrdemServicoFinalizadas.get(i))).codigoGrupo;
//            bosf.codigoEmpresa          = ((BeanOrdemServicoFinalizadas)(dadosOrdemServicoFinalizadas.get(i))).codigoEmpresa;
//            bosf.codigoOrdemServico     = ((BeanOrdemServicoFinalizadas)(dadosOrdemServicoFinalizadas.get(i))).codigoOrdemServico;
//            bosf.dataFinalizou          = ((BeanOrdemServicoFinalizadas)(dadosOrdemServicoFinalizadas.get(i))).dataFinalizou;
//            bosf.horaFinalizou          = ((BeanOrdemServicoFinalizadas)(dadosOrdemServicoFinalizadas.get(i))).horaFinalizou;
//            bosf.usuarioFinalizou       = ((BeanOrdemServicoFinalizadas)(dadosOrdemServicoFinalizadas.get(i))).usuarioFinalizou;
//            bosf.computadorFinalizou    = ((BeanOrdemServicoFinalizadas)(dadosOrdemServicoFinalizadas.get(i))).computadorFinalizou;
//        }
//    }
//    
//    private void PegaOrdemServicoSemSolucao(){
//        bosss.usuarioSemSolucao = 0;
//        sql = "select * from tb_os_semsolucao where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoOrdemServico = " + bosss.codigoOrdemServico + ";";
//        dadosOrdemServicoSemSolucao.clear();
//        dadosOrdemServicoSemSolucao = parametrosNS.dao.ConsultaOrdemServicoSemSolucao(sql);
//        if(dadosOrdemServicoSemSolucao.isEmpty())
//            return;
//        PegaDadosOrdemServicoSemSolucao();
//    }
//    
//    private void PegaDadosOrdemServicoSemSolucao(){
//        for(int i = 0; i < dadosOrdemServicoSemSolucao.size(); i++){
//            bosss   = new BeanOrdemServicoSemSolucao();
//            bosss.idOsSemSolucao        = ((BeanOrdemServicoSemSolucao)(dadosOrdemServicoSemSolucao.get(i))).idOsSemSolucao;
//            bosss.codigoGrupo           = ((BeanOrdemServicoSemSolucao)(dadosOrdemServicoSemSolucao.get(i))).codigoGrupo;
//            bosss.codigoEmpresa         = ((BeanOrdemServicoSemSolucao)(dadosOrdemServicoSemSolucao.get(i))).codigoEmpresa;
//            bosss.codigoOrdemServico    = ((BeanOrdemServicoSemSolucao)(dadosOrdemServicoSemSolucao.get(i))).codigoOrdemServico;
//            bosss.codigoMotivo          = ((BeanOrdemServicoSemSolucao)(dadosOrdemServicoSemSolucao.get(i))).codigoMotivo;
//            bosss.detalhesMotivo        = ((BeanOrdemServicoSemSolucao)(dadosOrdemServicoSemSolucao.get(i))).detalhesMotivo;
//            bosss.dataSemSolucao        = ((BeanOrdemServicoSemSolucao)(dadosOrdemServicoSemSolucao.get(i))).dataSemSolucao;
//            bosss.horaSemSolucao        = ((BeanOrdemServicoSemSolucao)(dadosOrdemServicoSemSolucao.get(i))).horaSemSolucao;
//            bosss.usuarioSemSolucao     = ((BeanOrdemServicoSemSolucao)(dadosOrdemServicoSemSolucao.get(i))).usuarioSemSolucao;
//            bosss.computadorSemSolucao  = ((BeanOrdemServicoSemSolucao)(dadosOrdemServicoSemSolucao.get(i))).computadorSemSolucao;
//        }
//    }
    
}
