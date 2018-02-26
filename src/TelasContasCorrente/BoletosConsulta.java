package TelasContasCorrente;

import BeansNS.BeanBanco;
import Beans.BeanBoletos;
import Beans.BeanClientes;
import Beans.BeanIntervalos;
import Beans.BeanUsuarios;
import FuncoesInternas.ArquivoRemessaItau;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.ColorirTabelaOSeVendaseBoletos;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.TestarData;
import Telas.UsuariosConsulta;
import TelasFaturamento.ClientesConsulta;
import FuncoesInternas.AjustarLarguraColunas;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/*
 @author Tiago e Paulo 05/08/2016 as 23:00
 */
public class BoletosConsulta extends javax.swing.JFrame {
    //String
    String Mensagem                             = "";
    String somostra                             = "";
    String retorno                              = "";
    String fazManutencao                        = "";
    String sql                                  = "";
    String Campo                                = "";
    String ocorrencia                           = "";
    String preenchimento                        = "";
    String TipoDeFaturamento                    = "";
    
    //int's
    int    Linha                                = 0;
    int    TotalBoletos                         = 0;
    int    TotalBoletosPendentes                = 0;
    int    TotalBoletosPagos                    = 0;
    int    abriuCliente                         = 0;
    int    abriuDigitadoUsuario                 = 0;
    int    dataAtual                            = 0;
    
    //Float
    double ValorTotalBoletos                    = 0;
    double ValorTotalBoletosPagos               = 0;
    double ValorTotalBoletosPendentes           = 0;
    double ValorTotalPendentes2                 = 0;
    
    //Beans
    BeanBanco                       bb          = new BeanBanco();
    BeanBoletos                     bbol        = new BeanBoletos();
    BeanClientes                    bc          = new BeanClientes();
    BeanUsuarios                    bu          = new BeanUsuarios();
    BeanIntervalos                  binter      = new BeanIntervalos();
    
    //Vetores
    ArrayList            parametros                        = new ArrayList();
    ArrayList            dadosPadroes                      = new ArrayList();
    ArrayList<ArrayList> dadosBanco                        = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosBoletos                      = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosCliente                      = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosUsuario                      = new ArrayList<ArrayList>();
    ArrayList            dadosRegistro                     = new ArrayList();
    
    //Funções
    InverterData                    invdata         = new InverterData();
    NumberFormat                    nf              = new DecimalFormat("R$ ###,##0.00");
    FormataCampo                    fc              = new FormataCampo();
    TestarData                      Test            = new TestarData();
    CapturarDataHora                cdh             = new CapturarDataHora();
    ArquivoRemessaItau              GerarRemessa    = new ArquivoRemessaItau();
    ColorirTabelaOSeVendaseBoletos  ConvTabOSeVenBol= new ColorirTabelaOSeVendaseBoletos();
    
    //DefaultTableModel
    DefaultTableModel   tbBoletos;
    
    //Telas
    GerarBoletoItau     GerBolItau;
    ClientesConsulta    CliCon;
    UsuariosConsulta    UsuCon;
    
    public BoletosConsulta(ArrayList DadosPadroes){
        dadosPadroes                            = DadosPadroes;
        
        somostra                                = (String)  dadosPadroes.get(0);
        fazManutencao                           = (String)  dadosPadroes.get(1);
        TipoDeFaturamento                       = (String)  dadosPadroes.get(2);
        bb.codigoBanco                          = (String)  dadosPadroes.get(3);
        
        initComponents();
    }
    
    private void InicializaCampos(){
        txt_codigoBoletoInicial     .setText(parametrosNS.fc.FormataCampo("", 8, 0));
        txt_codigoBoletoFinal       .setText("99999999");
        txt_usuarioInicial          .setText(parametrosNS.fc.FormataCampo("", 3, 0));
        txt_usuarioFinal            .setText("999");
        txt_dataEmissaoInicial      .setText(parametrosNS.fc.FormataCampo("",10, 2));
        txt_dataEmissaoFinal        .setText("99999999");
        txt_clienteInicial          .setText(parametrosNS.fc.FormataCampo("", 5, 0));
        txt_clienteFinal            .setText("99999");
        txt_dataVencimentoInicial   .setText(parametrosNS.fc.FormataCampo("",10, 2));
        txt_dataVencimentoFinal     .setText("99999999");
        txt_dataPagamentoInicial    .setText(parametrosNS.fc.FormataCampo("",10, 2));
        txt_dataPagamentoFinal      .setText("99999999");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_detalhes = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_boletos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_ValorTotalBoletosPendentes2 = new javax.swing.JTextField();
        txt_totalBoletos = new javax.swing.JTextField();
        txt_totalBoletosPendentes = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_ValorTotalBoletosPendentes = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_valorTotalBoletosPagos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_totalBoletosPagos = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txt_codigoBoletoInicial = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_codigoBoletoFinal = new javax.swing.JFormattedTextField();
        txt_usuarioInicial = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_usuarioFinal = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_clienteInicial = new javax.swing.JFormattedTextField();
        txt_clienteFinal = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        bt_pesquisaUsuarioInicialDigitado = new javax.swing.JButton();
        bt_pesquisaUsuarioFinalDigitado = new javax.swing.JButton();
        bt_pesquisaClienteInicial = new javax.swing.JButton();
        bt_pesquisaClienteFinal = new javax.swing.JButton();
        txt_dataEmissaoInicial = new javax.swing.JFormattedTextField();
        txt_dataEmissaoFinal = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_dataVencimentoInicial = new javax.swing.JFormattedTextField();
        txt_dataVencimentoFinal = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        txt_dataPagamentoInicial = new javax.swing.JFormattedTextField();
        txt_dataPagamentoFinal = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_codigoBancoInicial = new javax.swing.JFormattedTextField();
        bt_pesquisaBancoInicial = new javax.swing.JButton();
        txt_codigoBancoFinal = new javax.swing.JFormattedTextField();
        bt_pesquisaBancoFinal = new javax.swing.JButton();
        bt_processa = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        check_BoletosPagos = new javax.swing.JCheckBox();
        check_BoletosVencidos = new javax.swing.JCheckBox();
        check_BoletosAVencer = new javax.swing.JCheckBox();
        check_boletosParcial = new javax.swing.JCheckBox();
        check_BoletosBaixados = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair1 = new javax.swing.JMenuItem();

        bt_detalhes.setText("Detalhes");
        bt_detalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_detalhesActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_detalhes);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Boletos");
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

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Boletos do Sistema");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_boletos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_boletos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Boleto", "Cliente", "Tipo Faturamento", "Banco", "Data de Emissão", "Descrição", "Valor Devido", "Data de Vencimento", "Valor Pago", "Data de Pagamento", "Parcela", "Usuário", "Ocorrência de Remessa", "Tipo de Pagamento", "Status"
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
        tabela_boletos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_boletos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_boletos.getTableHeader().setReorderingAllowed(false);
        tabela_boletos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_boletosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_boletos);
        if (tabela_boletos.getColumnModel().getColumnCount() > 0) {
            tabela_boletos.getColumnModel().getColumn(0).setResizable(false);
            tabela_boletos.getColumnModel().getColumn(1).setResizable(false);
            tabela_boletos.getColumnModel().getColumn(2).setResizable(false);
            tabela_boletos.getColumnModel().getColumn(3).setResizable(false);
            tabela_boletos.getColumnModel().getColumn(4).setResizable(false);
            tabela_boletos.getColumnModel().getColumn(5).setResizable(false);
            tabela_boletos.getColumnModel().getColumn(6).setResizable(false);
            tabela_boletos.getColumnModel().getColumn(7).setResizable(false);
            tabela_boletos.getColumnModel().getColumn(8).setResizable(false);
            tabela_boletos.getColumnModel().getColumn(9).setResizable(false);
            tabela_boletos.getColumnModel().getColumn(10).setResizable(false);
            tabela_boletos.getColumnModel().getColumn(11).setResizable(false);
            tabela_boletos.getColumnModel().getColumn(12).setResizable(false);
            tabela_boletos.getColumnModel().getColumn(13).setResizable(false);
            tabela_boletos.getColumnModel().getColumn(14).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Total de Boletos Listados: ");

        txt_ValorTotalBoletosPendentes2.setEditable(false);
        txt_ValorTotalBoletosPendentes2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        txt_totalBoletos.setEditable(false);
        txt_totalBoletos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        txt_totalBoletosPendentes.setEditable(false);
        txt_totalBoletosPendentes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Total de Boletos Pendentes: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Valor total de Boletos gerados: ");

        txt_ValorTotalBoletosPendentes.setEditable(false);
        txt_ValorTotalBoletosPendentes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Valor total de boletos pagos: ");

        txt_valorTotalBoletosPagos.setEditable(false);
        txt_valorTotalBoletosPagos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Total de Boletos Pagos: ");

        txt_totalBoletosPagos.setEditable(false);
        txt_totalBoletosPagos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Valor total de boletos pendentes: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_totalBoletosPendentes)
                            .addComponent(txt_totalBoletos, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_totalBoletosPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2))
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_ValorTotalBoletosPendentes2)
                            .addComponent(txt_ValorTotalBoletosPendentes)
                            .addComponent(txt_valorTotalBoletosPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel9});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel4, jLabel6});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_totalBoletos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ValorTotalBoletosPendentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_totalBoletosPendentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_valorTotalBoletosPagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_ValorTotalBoletosPendentes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txt_totalBoletosPagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel6, jLabel9, txt_ValorTotalBoletosPendentes, txt_ValorTotalBoletosPendentes2, txt_totalBoletos, txt_totalBoletosPagos, txt_totalBoletosPendentes, txt_valorTotalBoletosPagos});

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_codigoBoletoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoBoletoInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoBoletoInicial.setText("00000000");
        txt_codigoBoletoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoBoletoInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoBoletoInicialFocusLost(evt);
            }
        });
        txt_codigoBoletoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoBoletoInicialKeyPressed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Boleto:");

        try {
            txt_codigoBoletoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoBoletoFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoBoletoFinal.setText("99999999");
        txt_codigoBoletoFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoBoletoFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoBoletoFinalFocusLost(evt);
            }
        });
        txt_codigoBoletoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoBoletoFinalKeyPressed(evt);
            }
        });

        try {
            txt_usuarioInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        try {
            txt_usuarioInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_usuarioInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_usuarioInicial.setText("000");
        txt_usuarioInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_usuarioInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usuarioInicialFocusLost(evt);
            }
        });
        txt_usuarioInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usuarioInicialKeyPressed(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Usuário:");

        try {
            txt_usuarioFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        try {
            txt_usuarioFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_usuarioFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_usuarioFinal.setText("999");
        txt_usuarioFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_usuarioFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usuarioFinalFocusLost(evt);
            }
        });
        txt_usuarioFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usuarioFinalKeyPressed(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Inicial");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Final");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Final");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Inicial");

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Cliente:");

        try {
            txt_clienteInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        try {
            txt_clienteInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_clienteInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_clienteInicial.setText("00000");
        txt_clienteInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_clienteInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_clienteInicialFocusLost(evt);
            }
        });
        txt_clienteInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_clienteInicialKeyPressed(evt);
            }
        });

        try {
            txt_clienteFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        try {
            txt_clienteFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_clienteFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_clienteFinal.setText("99999  ");
        txt_clienteFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_clienteFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_clienteFinalFocusLost(evt);
            }
        });
        txt_clienteFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_clienteFinalKeyPressed(evt);
            }
        });

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Data de Emissao:");

        bt_pesquisaUsuarioInicialDigitado.setText("...");
        bt_pesquisaUsuarioInicialDigitado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaUsuarioInicialDigitadoActionPerformed(evt);
            }
        });

        bt_pesquisaUsuarioFinalDigitado.setText("...");
        bt_pesquisaUsuarioFinalDigitado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaUsuarioFinalDigitadoActionPerformed(evt);
            }
        });

        bt_pesquisaClienteInicial.setText("...");
        bt_pesquisaClienteInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaClienteInicialActionPerformed(evt);
            }
        });

        bt_pesquisaClienteFinal.setText("...");
        bt_pesquisaClienteFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaClienteFinalActionPerformed(evt);
            }
        });

        try {
            txt_dataEmissaoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataEmissaoInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataEmissaoInicial.setText("00/00/0000");
        txt_dataEmissaoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataEmissaoInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataEmissaoInicialFocusLost(evt);
            }
        });
        txt_dataEmissaoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataEmissaoInicialKeyPressed(evt);
            }
        });

        try {
            txt_dataEmissaoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataEmissaoFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataEmissaoFinal.setText("99/99/9999");
        txt_dataEmissaoFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataEmissaoFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataEmissaoFinalFocusLost(evt);
            }
        });
        txt_dataEmissaoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataEmissaoFinalKeyPressed(evt);
            }
        });

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Data de Vencimento:");

        try {
            txt_dataVencimentoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataVencimentoInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataVencimentoInicial.setText("00/00/0000");
        txt_dataVencimentoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataVencimentoInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataVencimentoInicialFocusLost(evt);
            }
        });
        txt_dataVencimentoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataVencimentoInicialKeyPressed(evt);
            }
        });

        try {
            txt_dataVencimentoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataVencimentoFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataVencimentoFinal.setText("99/99/9999");
        txt_dataVencimentoFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataVencimentoFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataVencimentoFinalFocusLost(evt);
            }
        });
        txt_dataVencimentoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataVencimentoFinalKeyPressed(evt);
            }
        });

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Data de Pagamento:");

        try {
            txt_dataPagamentoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataPagamentoInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataPagamentoInicial.setText("00/00/0000");
        txt_dataPagamentoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataPagamentoInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataPagamentoInicialFocusLost(evt);
            }
        });
        txt_dataPagamentoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataPagamentoInicialKeyPressed(evt);
            }
        });

        try {
            txt_dataPagamentoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataPagamentoFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataPagamentoFinal.setText("99/99/9999");
        txt_dataPagamentoFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataPagamentoFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataPagamentoFinalFocusLost(evt);
            }
        });
        txt_dataPagamentoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataPagamentoFinalKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Intervalos de Consulta        F11 [Geral]");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Banco:");

        try {
            txt_codigoBancoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoBancoInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoBancoInicial.setText("000");
        txt_codigoBancoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoBancoInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoBancoInicialFocusLost(evt);
            }
        });
        txt_codigoBancoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoBancoInicialKeyPressed(evt);
            }
        });

        bt_pesquisaBancoInicial.setText("...");

        try {
            txt_codigoBancoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoBancoFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoBancoFinal.setText("999");
        txt_codigoBancoFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoBancoFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoBancoFinalFocusLost(evt);
            }
        });
        txt_codigoBancoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoBancoFinalKeyPressed(evt);
            }
        });

        bt_pesquisaBancoFinal.setText("...");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_dataEmissaoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dataVencimentoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dataPagamentoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoBoletoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(txt_dataVencimentoFinal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_dataEmissaoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_codigoBoletoFinal))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(txt_usuarioInicial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_pesquisaUsuarioInicialDigitado, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(txt_clienteInicial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bt_pesquisaClienteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(txt_codigoBancoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_pesquisaBancoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_codigoBancoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_clienteFinal)
                                    .addComponent(txt_usuarioFinal))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bt_pesquisaBancoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bt_pesquisaClienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bt_pesquisaUsuarioFinalDigitado, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)))
                    .addComponent(txt_dataPagamentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(256, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel14, jLabel15, txt_clienteFinal, txt_clienteInicial, txt_codigoBancoFinal, txt_codigoBancoInicial, txt_usuarioFinal, txt_usuarioInicial});

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel17, jLabel18, jLabel19, jLabel7});

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel13, txt_codigoBoletoFinal, txt_dataEmissaoFinal, txt_dataPagamentoFinal, txt_dataVencimentoFinal});

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel12, txt_codigoBoletoInicial, txt_dataEmissaoInicial, txt_dataPagamentoInicial, txt_dataVencimentoInicial});

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel16, jLabel8});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(6, 6, 6)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_codigoBoletoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txt_dataEmissaoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txt_dataVencimentoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txt_dataPagamentoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(txt_codigoBoletoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_dataEmissaoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16))))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(txt_usuarioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txt_clienteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bt_pesquisaClienteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(bt_pesquisaUsuarioInicialDigitado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(txt_usuarioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txt_clienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bt_pesquisaClienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(bt_pesquisaUsuarioFinalDigitado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_dataVencimentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txt_codigoBancoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_pesquisaBancoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_codigoBancoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_pesquisaBancoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_dataPagamentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaBancoFinal, bt_pesquisaBancoInicial, bt_pesquisaClienteFinal, bt_pesquisaClienteInicial, bt_pesquisaUsuarioFinalDigitado, bt_pesquisaUsuarioInicialDigitado, jLabel10, jLabel14, jLabel15, jLabel16, jLabel8, txt_clienteFinal, txt_clienteInicial, txt_codigoBancoFinal, txt_codigoBancoInicial, txt_usuarioFinal, txt_usuarioInicial});

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel12, jLabel13, jLabel17, jLabel18, jLabel19, jLabel7, txt_codigoBoletoFinal, txt_codigoBoletoInicial, txt_dataEmissaoFinal, txt_dataEmissaoInicial, txt_dataPagamentoFinal, txt_dataPagamentoInicial, txt_dataVencimentoFinal, txt_dataVencimentoInicial});

        bt_processa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/1280454766_system-software-update.png"))); // NOI18N
        bt_processa.setText("Processa");
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

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        check_BoletosPagos.setText("Ignorar Boletos Pagos");

        check_BoletosVencidos.setText("Ignorar Vencidos");

        check_BoletosAVencer.setText("Ignorar Boletos À Vencer");

        check_boletosParcial.setText("Ignorar Pagamentos Parciais");

        check_BoletosBaixados.setText("Ignorar Boletos Baixados");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(check_BoletosPagos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(check_boletosParcial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(check_BoletosVencidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(check_BoletosAVencer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check_BoletosBaixados)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(check_BoletosPagos)
                    .addComponent(check_BoletosVencidos)
                    .addComponent(check_BoletosAVencer)
                    .addComponent(check_boletosParcial)
                    .addComponent(check_BoletosBaixados))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(bt_processa, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_sair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_processa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_processa, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tbBoletos = (DefaultTableModel)tabela_boletos.getModel();
        InicializaCampos();
        if(!bb.codigoBanco.equals("")){
            txt_codigoBancoInicial  .setText(parametrosNS.fc.FormataCampo(bb.codigoBanco, 3, 0));
            txt_codigoBancoInicial  .setEditable    (false);
            txt_codigoBancoInicial  .setFocusable   (false);
            bt_pesquisaBancoInicial .setEnabled     (false);
            bt_pesquisaBancoInicial .setFocusable   (false);
            txt_codigoBancoFinal    .setText(parametrosNS.fc.FormataCampo(bb.codigoBanco, 3, 0));
            txt_codigoBancoFinal    .setEditable    (false);
            txt_codigoBancoFinal    .setFocusable   (false);
            bt_pesquisaBancoFinal   .setEnabled     (false);
            bt_pesquisaBancoFinal   .setFocusable   (false);
        }
        PegaValores();
    }//GEN-LAST:event_formWindowOpened

    private void txt_codigoBoletoInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoBoletoInicialFocusGained
        txt_codigoBoletoInicial.setSelectionStart(0);
        txt_codigoBoletoInicial.setSelectionEnd  (txt_codigoBoletoInicial.getText().length());
    }//GEN-LAST:event_txt_codigoBoletoInicialFocusGained

    private void txt_codigoBoletoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoBoletoInicialFocusLost
        txt_codigoBoletoInicial.setText(parametrosNS.fc.FormataCampo(txt_codigoBoletoInicial.getText(), 9, 0));
    }//GEN-LAST:event_txt_codigoBoletoInicialFocusLost

    private void txt_codigoBoletoInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoBoletoInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoBoletoFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoBoletoInicial.setText(parametrosNS.fc.FormataCampo("", 9, 0));
            txt_codigoBoletoFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoBoletoInicialKeyPressed

    private void txt_codigoBoletoFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoBoletoFinalFocusGained
        txt_codigoBoletoFinal.setSelectionStart(0);
        txt_codigoBoletoFinal.setSelectionEnd  (txt_codigoBoletoFinal.getText().length());
    }//GEN-LAST:event_txt_codigoBoletoFinalFocusGained

    private void txt_codigoBoletoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoBoletoFinalFocusLost
        if(txt_codigoBoletoFinal.getText().replace(" ", "").equals("")){
            txt_codigoBoletoFinal.setText("999999999");
            return;
        }
        txt_codigoBoletoFinal.setText(parametrosNS.fc.FormataCampo(txt_codigoBoletoFinal.getText(), 9, 0));
    }//GEN-LAST:event_txt_codigoBoletoFinalFocusLost

    private void txt_codigoBoletoFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoBoletoFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_usuarioInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoBoletoFinal.setText("999999999");
            txt_usuarioInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoBoletoFinalKeyPressed

    private void txt_usuarioInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usuarioInicialFocusGained
        txt_usuarioInicial.setSelectionStart(0);
        txt_usuarioInicial.setSelectionEnd  (txt_usuarioInicial.getText().length());
    }//GEN-LAST:event_txt_usuarioInicialFocusGained

    private void txt_usuarioInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usuarioInicialFocusLost
        txt_usuarioInicial.setText(parametrosNS.fc.FormataCampo(txt_usuarioInicial.getText(), 3, 0));
    }//GEN-LAST:event_txt_usuarioInicialFocusLost

    private void txt_usuarioInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_usuarioFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_usuarioInicial.setText(parametrosNS.fc.FormataCampo("", 3, 0));
            txt_usuarioFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_usuarioInicialKeyPressed

    private void txt_usuarioFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usuarioFinalFocusGained
        txt_usuarioFinal.setSelectionStart(0);
        txt_usuarioFinal.setSelectionEnd  (txt_usuarioFinal.getText().length());
    }//GEN-LAST:event_txt_usuarioFinalFocusGained

    private void txt_usuarioFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usuarioFinalFocusLost
        if(txt_usuarioFinal.getText().replace(" ", "").equals("")){
            txt_usuarioFinal.setText("999");
            return;
        }
        txt_usuarioFinal.setText(parametrosNS.fc.FormataCampo(txt_usuarioFinal.getText(), 3, 0));
    }//GEN-LAST:event_txt_usuarioFinalFocusLost

    private void txt_usuarioFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataEmissaoInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_usuarioFinal.setText("999");
            txt_dataEmissaoInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_usuarioFinalKeyPressed

    private void txt_clienteInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_clienteInicialFocusGained
        txt_clienteInicial.setSelectionStart(0);
        txt_clienteInicial.setSelectionEnd  (txt_clienteInicial.getText().length());
    }//GEN-LAST:event_txt_clienteInicialFocusGained

    private void txt_clienteInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_clienteInicialFocusLost
        txt_clienteInicial.setText(parametrosNS.fc.FormataCampo(txt_clienteInicial.getText(), 5, 0));
    }//GEN-LAST:event_txt_clienteInicialFocusLost

    private void txt_clienteInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_clienteInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_clienteFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_clienteInicial.setText(parametrosNS.fc.FormataCampo("", 5, 0));
            txt_clienteFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_clienteInicialKeyPressed

    private void txt_clienteFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_clienteFinalFocusGained
        txt_clienteFinal.setSelectionStart(0);
        txt_clienteFinal.setSelectionEnd  (txt_clienteFinal.getText().length());
    }//GEN-LAST:event_txt_clienteFinalFocusGained

    private void txt_clienteFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_clienteFinalFocusLost
        if(txt_clienteFinal.getText().replace(" ", "").equals("")){
            txt_clienteFinal.setText("99999");
            return;
        }
        txt_clienteFinal.setText(parametrosNS.fc.FormataCampo(txt_clienteFinal.getText(), 5, 0));
    }//GEN-LAST:event_txt_clienteFinalFocusLost

    private void txt_clienteFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_clienteFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataVencimentoInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_clienteFinal.setText("99999");
            txt_dataVencimentoInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_clienteFinalKeyPressed

    private void bt_pesquisaClienteInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaClienteInicialActionPerformed
        Campo = "I";
        PesquisaCliente();
    }//GEN-LAST:event_bt_pesquisaClienteInicialActionPerformed

    private void bt_pesquisaUsuarioInicialDigitadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaUsuarioInicialDigitadoActionPerformed
        Campo = "I";
        abriuDigitadoUsuario = 1;
        PesquisaUsuarios();
    }//GEN-LAST:event_bt_pesquisaUsuarioInicialDigitadoActionPerformed

    private void bt_pesquisaUsuarioFinalDigitadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaUsuarioFinalDigitadoActionPerformed
        Campo = "F";
        abriuDigitadoUsuario = 1;
        PesquisaUsuarios();
    }//GEN-LAST:event_bt_pesquisaUsuarioFinalDigitadoActionPerformed

    private void bt_pesquisaClienteFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaClienteFinalActionPerformed
        Campo = "F";
        PesquisaCliente();
    }//GEN-LAST:event_bt_pesquisaClienteFinalActionPerformed

    private void txt_dataEmissaoInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataEmissaoInicialFocusGained
        txt_dataEmissaoInicial.setSelectionStart(0);
        txt_dataEmissaoInicial.setSelectionEnd  (txt_dataEmissaoInicial.getText().length());
    }//GEN-LAST:event_txt_dataEmissaoInicialFocusGained

    private void txt_dataEmissaoInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataEmissaoInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataEmissaoFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataEmissaoInicial.setText(parametrosNS.fc.FormataCampo("", 8, 0));
            txt_dataEmissaoFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataEmissaoInicialKeyPressed

    private void txt_dataEmissaoFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataEmissaoFinalFocusGained
        txt_dataEmissaoFinal.setSelectionStart(0);
        txt_dataEmissaoFinal.setSelectionEnd  (txt_dataEmissaoFinal.getText().length());
    }//GEN-LAST:event_txt_dataEmissaoFinalFocusGained

    private void txt_dataEmissaoFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataEmissaoFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_clienteInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataEmissaoFinal.setText("99999999");
            txt_clienteInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataEmissaoFinalKeyPressed

    private void txt_dataVencimentoInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVencimentoInicialFocusGained
        txt_dataVencimentoInicial.setSelectionStart(0);
        txt_dataVencimentoInicial.setSelectionEnd  (txt_dataVencimentoInicial.getText().length());
    }//GEN-LAST:event_txt_dataVencimentoInicialFocusGained

    private void txt_dataVencimentoInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataVencimentoInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataVencimentoFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataVencimentoInicial.setText(parametrosNS.fc.FormataCampo("", 8, 0));
            txt_dataVencimentoFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataVencimentoInicialKeyPressed

    private void txt_dataVencimentoFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVencimentoFinalFocusGained
        txt_dataVencimentoFinal.setSelectionStart(0);
        txt_dataVencimentoFinal.setSelectionEnd  (txt_dataVencimentoFinal.getText().length());
    }//GEN-LAST:event_txt_dataVencimentoFinalFocusGained

    private void txt_dataVencimentoFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataVencimentoFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoBancoInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataVencimentoFinal.setText("99999999");
            txt_codigoBancoInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataVencimentoFinalKeyPressed

    private void txt_dataPagamentoInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataPagamentoInicialFocusGained
        txt_dataPagamentoInicial.setSelectionStart(0);
        txt_dataPagamentoInicial.setSelectionEnd  (txt_dataPagamentoInicial.getText().length());
    }//GEN-LAST:event_txt_dataPagamentoInicialFocusGained

    private void txt_dataPagamentoInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataPagamentoInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataPagamentoFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataPagamentoInicial.setText(parametrosNS.fc.FormataCampo("", 8, 0));
            txt_dataPagamentoFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataPagamentoInicialKeyPressed

    private void txt_dataPagamentoFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataPagamentoFinalFocusGained
        txt_dataPagamentoFinal.setSelectionStart(0);
        txt_dataPagamentoFinal.setSelectionEnd  (txt_dataPagamentoFinal.getText().length());
    }//GEN-LAST:event_txt_dataPagamentoFinalFocusGained

    private void txt_dataPagamentoFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataPagamentoFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            bt_processa.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataPagamentoFinal.setText("99999999");
            bt_processa.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataPagamentoFinalKeyPressed

    private void bt_processaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_processaActionPerformed
        PegaValores();
    }//GEN-LAST:event_bt_processaActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_detalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesActionPerformed
        if(GerBolItau   != null)if(GerBolItau.isVisible()){
            Mensagem = "Tela ja Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add(Integer.parseInt(retorno));
        parametros.add(0);
        parametros.add("Boleto");
        GerBolItau = new GerarBoletoItau(parametros);
        GerBolItau.setVisible(true);
    }//GEN-LAST:event_bt_detalhesActionPerformed

    private void tabela_boletosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_boletosMouseClicked
        Linha = tabela_boletos.getSelectedRow();
        if(Linha < 0){
            Mensagem = "Item não selecionado!";
            new MostraMensagem(Mensagem);
            return;
        }
        if(tabela_boletos.getRowCount() - Linha == 1)
            return;
        if(evt.getButton() == MouseEvent.BUTTON3)
            if(somostra.equals("N"))
                MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
        retorno = String.valueOf(Integer.parseInt(String.valueOf(tabela_boletos.getValueAt(Linha, 0))));
        if(evt.getClickCount() < 2)
            return;
        dispose();
    }//GEN-LAST:event_tabela_boletosMouseClicked

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed
    
    private void AbreCliente(){
        if(abriuCliente == 0)
            return;
        abriuCliente = 0;
        retorno = CliCon.getRetorno();
        if(retorno.equals(""))
            return;
        if(Campo.equals("I")){
            txt_clienteInicial.setText(parametrosNS.fc.FormataCampo(retorno, 5, 0));
            return;
        }
        txt_clienteFinal.setText(parametrosNS.fc.FormataCampo(retorno, 5, 0));
    }
    
    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
        if(abriuDigitadoUsuario == 0){
            AbreCliente();
            return;
        }
        abriuDigitadoUsuario = 0;
        retorno = UsuCon.getRetorno();
        if(retorno.equals(""))
            return;
        if(Campo.equals("I")){
            txt_usuarioInicial.setText(parametrosNS.fc.FormataCampo(retorno, 3, 0));
            return;
        }
        txt_usuarioFinal.setText(parametrosNS.fc.FormataCampo(retorno, 3, 0));
    }//GEN-LAST:event_formWindowGainedFocus

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(GerBolItau   != null)GerBolItau  .dispose();
        if(CliCon       != null)CliCon      .dispose();
        if(UsuCon       != null)UsuCon      .dispose();
    }//GEN-LAST:event_formWindowClosed

    private void txt_dataEmissaoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataEmissaoInicialFocusLost
        txt_dataEmissaoInicial.setText(parametrosNS.fc.FormataCampo(txt_dataEmissaoInicial.getText(), 10, 2));
    }//GEN-LAST:event_txt_dataEmissaoInicialFocusLost

    private void txt_dataEmissaoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataEmissaoFinalFocusLost
        txt_dataEmissaoFinal.setText(parametrosNS.fc.FormataCampo(txt_dataEmissaoFinal.getText(), 10, 2));
    }//GEN-LAST:event_txt_dataEmissaoFinalFocusLost

    private void txt_dataVencimentoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVencimentoInicialFocusLost
        txt_dataVencimentoInicial.setText(parametrosNS.fc.FormataCampo(txt_dataVencimentoInicial.getText(), 10, 2));
    }//GEN-LAST:event_txt_dataVencimentoInicialFocusLost

    private void txt_dataVencimentoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVencimentoFinalFocusLost
        txt_dataVencimentoFinal.setText(parametrosNS.fc.FormataCampo(txt_dataVencimentoFinal.getText(), 10, 2));
    }//GEN-LAST:event_txt_dataVencimentoFinalFocusLost

    private void txt_dataPagamentoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataPagamentoInicialFocusLost
        txt_dataPagamentoInicial.setText(parametrosNS.fc.FormataCampo(txt_dataPagamentoInicial.getText(), 10, 2));
    }//GEN-LAST:event_txt_dataPagamentoInicialFocusLost

    private void txt_dataPagamentoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataPagamentoFinalFocusLost
        txt_dataPagamentoFinal.setText(parametrosNS.fc.FormataCampo(txt_dataPagamentoFinal.getText(), 10, 2));
    }//GEN-LAST:event_txt_dataPagamentoFinalFocusLost

    private void txt_codigoBancoInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoBancoInicialFocusGained
        if(txt_codigoBancoInicial.isEditable() == false)
            return;
        txt_codigoBancoInicial.setSelectionStart(0);
        txt_codigoBancoInicial.setSelectionEnd  (txt_codigoBancoInicial.getText().length());
    }//GEN-LAST:event_txt_codigoBancoInicialFocusGained

    private void txt_codigoBancoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoBancoInicialFocusLost
        txt_codigoBancoInicial.setText(parametrosNS.fc.FormataCampo(txt_codigoBancoInicial.getText(), 3, 0));
    }//GEN-LAST:event_txt_codigoBancoInicialFocusLost

    private void txt_codigoBancoInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoBancoInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoBancoFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoBancoInicial.setText(parametrosNS.fc.FormataCampo("", 3, 0));
            txt_codigoBancoFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoBancoInicialKeyPressed

    private void txt_codigoBancoFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoBancoFinalFocusGained
        if(txt_codigoBancoFinal.isEditable() == false)
            return;
        txt_codigoBancoFinal.setSelectionStart(0);
        txt_codigoBancoFinal.setSelectionEnd  (txt_codigoBancoFinal.getText().length());
    }//GEN-LAST:event_txt_codigoBancoFinalFocusGained

    private void txt_codigoBancoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoBancoFinalFocusLost
        txt_codigoBancoInicial.setText(parametrosNS.fc.FormataCampo(txt_codigoBancoInicial.getText(), 3, 0));
    }//GEN-LAST:event_txt_codigoBancoFinalFocusLost

    private void txt_codigoBancoFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoBancoFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataPagamentoInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoBancoFinal.setText("999");
            txt_dataPagamentoInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoBancoFinalKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_detalhes;
    private javax.swing.JButton bt_pesquisaBancoFinal;
    private javax.swing.JButton bt_pesquisaBancoInicial;
    private javax.swing.JButton bt_pesquisaClienteFinal;
    private javax.swing.JButton bt_pesquisaClienteInicial;
    private javax.swing.JButton bt_pesquisaUsuarioFinalDigitado;
    private javax.swing.JButton bt_pesquisaUsuarioInicialDigitado;
    private javax.swing.JButton bt_processa;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JCheckBox check_BoletosAVencer;
    private javax.swing.JCheckBox check_BoletosBaixados;
    private javax.swing.JCheckBox check_BoletosPagos;
    private javax.swing.JCheckBox check_BoletosVencidos;
    private javax.swing.JCheckBox check_boletosParcial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_boletos;
    private javax.swing.JTextField txt_ValorTotalBoletosPendentes;
    private javax.swing.JTextField txt_ValorTotalBoletosPendentes2;
    private javax.swing.JFormattedTextField txt_clienteFinal;
    private javax.swing.JFormattedTextField txt_clienteInicial;
    private javax.swing.JFormattedTextField txt_codigoBancoFinal;
    private javax.swing.JFormattedTextField txt_codigoBancoInicial;
    private javax.swing.JFormattedTextField txt_codigoBoletoFinal;
    private javax.swing.JFormattedTextField txt_codigoBoletoInicial;
    private javax.swing.JFormattedTextField txt_dataEmissaoFinal;
    private javax.swing.JFormattedTextField txt_dataEmissaoInicial;
    private javax.swing.JFormattedTextField txt_dataPagamentoFinal;
    private javax.swing.JFormattedTextField txt_dataPagamentoInicial;
    private javax.swing.JFormattedTextField txt_dataVencimentoFinal;
    private javax.swing.JFormattedTextField txt_dataVencimentoInicial;
    private javax.swing.JTextField txt_totalBoletos;
    private javax.swing.JTextField txt_totalBoletosPagos;
    private javax.swing.JTextField txt_totalBoletosPendentes;
    private javax.swing.JFormattedTextField txt_usuarioFinal;
    private javax.swing.JFormattedTextField txt_usuarioInicial;
    private javax.swing.JTextField txt_valorTotalBoletosPagos;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
    private void PegaCliente(){
        bc.nome = "----------";
        sql = "select idCliente, idEmpresa, codigoGrupo, codigoEmpresa, codigoCliente, nome from tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCliente = " + bc.codigoCliente + ";";
        dadosCliente.clear();
        dadosCliente = parametrosNS.dao.Consulta(sql);
        if(dadosCliente.isEmpty()){
            Mensagem = "Erro ao consultar o cliente: " + bc.codigoCliente + "";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosCliente();
    }
    
    private void PegaDadosCliente(){
        for(int i = 0; i < dadosCliente.size(); i++){
            bc.idCliente            = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(0)));
            bc.idEmpresa            = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(1)));
            bc.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(2)));
            bc.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(3)));
            bc.codigoCliente        = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(4)));
            bc.nome                 =                    String.valueOf(dadosCliente.get(i).get(5));
        }
    }
    
    private void PegaUsuarios() {
        sql = "select usuario from tb_usuarios where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
        dadosUsuario.clear();
        dadosUsuario = parametrosNS.dao.Consulta(sql);
        if(dadosUsuario.isEmpty()){
            Mensagem = "Erro ao consultar o cliente: " + bu.codigoUsuario + "";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosUsuario();
    }
    
    private void PegaDadosUsuario(){
        for(int i = 0; i < dadosUsuario.size(); i++)
            bu.usuario = String.valueOf(dadosUsuario.get(i).get(0));
    }
    
    private void PegaBanco(){
        bb.codigoBanco  = bbol.CodigoDeBarras.substring(0, 3);
        bb.nomeBanco    = "----------";
        sql = "select * from ns_bancos where codigoBanco = '" + bb.codigoBanco + "';";
        dadosBanco.clear();
        dadosBanco = parametrosNS.dao.Consulta(sql);
        if(dadosBanco.isEmpty()){
            Mensagem = "Banco n°" + bb.codigoBanco + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosBanco();
    }
    
    private void PegaDadosBanco(){
       for(int i = 0; i < dadosBanco.size(); i++){
            bb.idBanco          = Integer.parseInt(  String.valueOf(dadosBanco.get(i).get(0)));
            bb.nomeBanco        =                    String.valueOf(dadosBanco.get(i).get(1));
            bb.codigoBanco      =                    String.valueOf(dadosBanco.get(i).get(2));
       }
    }
    
    private void PesquisaCliente(){
        if(CliCon != null)if(CliCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuCliente = 1;
        CliCon = new ClientesConsulta("N");
        CliCon.setVisible(true);
    }
    
    private void PesquisaUsuarios(){
        abriuDigitadoUsuario = 1;
        parametros.clear();
        parametros.add("S");
        UsuCon = new UsuariosConsulta(parametros);
        UsuCon.setVisible(true);
    }
    
    private void PegaValores(){
        binter.codigoBoletoInicial          = Integer.parseInt(txt_codigoBoletoInicial.getText());
        binter.codigoBoletoFinal            = Integer.parseInt(txt_codigoBoletoFinal.getText());
        if(binter.codigoBoletoInicial > binter.codigoBoletoFinal){
            Mensagem = "Código do boleto Inicial não pode ser maior do que o Código Final";
            new MostraMensagem(Mensagem);
            return;
        }
        
        binter.usuarioInicial               = Integer.parseInt(txt_usuarioInicial.getText());
        binter.usuarioFinal                 = Integer.parseInt(txt_usuarioFinal.getText());
        if(binter.usuarioInicial > binter.usuarioFinal){
            Mensagem = "Código do Usuário Inicial não pode ser maior do que o Código Final";
            new MostraMensagem(Mensagem);
            return;
        }
        
        binter.dataEmissaoInicial           = Test.Testa(txt_dataEmissaoInicial.getText());
        binter.dataEmissaoFinal             = Test.Testa(txt_dataEmissaoFinal.getText());
        if(binter.dataEmissaoInicial > binter.dataEmissaoFinal){
            Mensagem = "Data de Emissão Inicial não pode ser maior do que o Data de Emissão Final";
            new MostraMensagem(Mensagem);
            return;
        }
        
        binter.clienteInicial               = Integer.parseInt(txt_clienteInicial.getText());
        binter.clienteFinal                 = Integer.parseInt(txt_clienteFinal.getText());
        if(binter.clienteInicial > binter.clienteInicial){
            Mensagem = "Código do Cliente Inicial não pode ser maior do que o Código Final";
            new MostraMensagem(Mensagem);
            return;
        }
        
        binter.dataVencimentoInicial        = Test.Testa(txt_dataVencimentoInicial.getText());
        binter.dataVencimentoFinal          = Test.Testa(txt_dataVencimentoFinal.getText());
        if(binter.dataVencimentoInicial > binter.dataVencimentoFinal){
            Mensagem = "Data de Vencimento Inicial não pode ser maior do que o Data de Venci,ento Final";
            new MostraMensagem(Mensagem);
            return;
        }
        
        binter.dataPagamentoInicial         = Test.Testa(txt_dataPagamentoInicial.getText());
        binter.dataPagamentoFinal           = Test.Testa(txt_dataPagamentoFinal.getText());
        if(binter.dataPagamentoInicial > binter.dataPagamentoFinal){
            Mensagem = "Data de Saida Inicial não pode ser maior do que o Data de Cadastro Final";
            new MostraMensagem(Mensagem);
            return;
        }
        
        binter.codigoBancoInicial           = Integer.parseInt(txt_codigoBancoInicial.getText());
        binter.codigoBancoFinal             = Integer.parseInt(txt_codigoBancoFinal.getText());
        if(binter.codigoBancoInicial > binter.codigoBancoFinal){
            Mensagem = "Código do Banco Inicial não pode ser maior do que o Código do Banco Final";
            new MostraMensagem(Mensagem);
            return;
        }
        
        preenchimento = "";
        if(!TipoDeFaturamento.equals("")){
            bbol.tipoDeFaturamento  = TipoDeFaturamento;
            preenchimento = "tipoDeFaturamento = '" + bbol.tipoDeFaturamento + "' and ";
        }
        MontaSQL();
    }
    
    private void MontaSQL(){
        sql =   "select * from tb_boletos where "
                + preenchimento
                + "codigoBoleto between "                       + binter.codigoBoletoInicial    + " and " + binter.codigoBoletoFinal        + " and "
                + "codigoCliente between "                      + binter.clienteInicial         + " and " + binter.clienteFinal             + " and "
                + "codigoUsuario between "                      + binter.usuarioInicial         + " and " + binter.usuarioFinal             + " and "
                + "substring(CodigoDeBarras, 1, 3) between "    + binter.codigoBancoInicial     + " and " + binter.codigoBancoFinal         + " and "
                + "idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
//        System.out.println(sql);
//        bt_gerar.setEnabled(false);
        dadosBoletos.clear();
        dadosBoletos = parametrosNS.dao.Consulta(sql);
        PegaBoletos();
    }
    
    private void PegaBoletos(){
//        tabela_boletos.getColumnModel().getColumn(0) .setPreferredWidth(90);    //codigoBoleto    
//        tabela_boletos.getColumnModel().getColumn(1) .setPreferredWidth(300);   //Cliente     
//        tabela_boletos.getColumnModel().getColumn(2) .setPreferredWidth(80);    //tipo de fatura   
//        tabela_boletos.getColumnModel().getColumn(3) .setPreferredWidth(225);   //Banco
//        tabela_boletos.getColumnModel().getColumn(4) .setPreferredWidth(125);   //data de emissao
//        tabela_boletos.getColumnModel().getColumn(5) .setPreferredWidth(300);   //descricao
//        tabela_boletos.getColumnModel().getColumn(6) .setPreferredWidth(150);   //valor devido
//        tabela_boletos.getColumnModel().getColumn(7) .setPreferredWidth(150);   //data de vencimento
//        tabela_boletos.getColumnModel().getColumn(8) .setPreferredWidth(125);   //valor pago
//        tabela_boletos.getColumnModel().getColumn(9) .setPreferredWidth(100);   //data de pagamento
//        tabela_boletos.getColumnModel().getColumn(10).setPreferredWidth(80);    //parcela
//        tabela_boletos.getColumnModel().getColumn(11).setPreferredWidth(150);   //usuario
//        tabela_boletos.getColumnModel().getColumn(12).setPreferredWidth(175);   //ocorrencia de Remessa
//        tabela_boletos.getColumnModel().getColumn(13).setPreferredWidth(175);   //ocorrencia de Retorno
//        tabela_boletos.getColumnModel().getColumn(14).setPreferredWidth(150);   //tipo de pagamento
//        tabela_boletos.getColumnModel().getColumn(15).setPreferredWidth(150);   //Status
        
        tabela_boletos.setVisible(false);
        tbBoletos.setNumRows(0);
        TotalBoletos                = 0;
        TotalBoletosPendentes       = 0;
        TotalBoletosPagos           = 0;
        ValorTotalBoletos           = 0;
        ValorTotalBoletosPendentes  = 0;
        ValorTotalBoletosPagos      = 0;
        
        dataAtual = Test.Testa(cdh.CapturarData());
        String Status       = "";
        String NomeBanco    = "";
        for(int i = 0; i < dadosBoletos.size(); i++){
            Status = "";
            bbol = new BeanBoletos();
            if(dadosBoletos.get(i).get(0)  != null){bbol.idBoletos              = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(0)));}
            if(dadosBoletos.get(i).get(1)  != null){bbol.idEmpresa              = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(1)));}
            if(dadosBoletos.get(i).get(2)  != null){bbol.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(2)));}
            if(dadosBoletos.get(i).get(3)  != null){bbol.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(3)));}
            if(dadosBoletos.get(i).get(4)  != null){bbol.codigoBoleto           = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(4)));}
            if(dadosBoletos.get(i).get(5)  != null){bbol.codigoCliente          = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(5)));}
            if(dadosBoletos.get(i).get(6)  != null){bbol.codigoContaCorrente    = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(6)));}
            if(dadosBoletos.get(i).get(7)  != null){bbol.codigoBoletoInstrucao  = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(7)));}
            if(dadosBoletos.get(i).get(8)  != null){bbol.codigoUsuario          = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(8)));}
            if(dadosBoletos.get(i).get(9)  != null){bbol.codigoPagamento        = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(9)));}
            if(dadosBoletos.get(i).get(10) != null){bbol.tipoDeFaturamento      =                    String.valueOf(dadosBoletos.get(i).get(10));}
            if(dadosBoletos.get(i).get(11) != null){bbol.nossoNumero            =                    String.valueOf(dadosBoletos.get(i).get(11));}
            if(dadosBoletos.get(i).get(12) != null){bbol.dataEmissao            =                    String.valueOf(dadosBoletos.get(i).get(12));}
            if(dadosBoletos.get(i).get(13) != null){bbol.numeroDocumento        =                    String.valueOf(dadosBoletos.get(i).get(13));}
            if(dadosBoletos.get(i).get(14) != null){bbol.numeroDAC              =                    String.valueOf(dadosBoletos.get(i).get(14));}
            if(dadosBoletos.get(i).get(15) != null){bbol.valorDevido            = Double.parseDouble(String.valueOf(dadosBoletos.get(i).get(15)));}
            if(dadosBoletos.get(i).get(16) != null){bbol.dataDeVencimento       =                    String.valueOf(dadosBoletos.get(i).get(16));}
            if(dadosBoletos.get(i).get(17) != null){bbol.valorPago              = Double.parseDouble(String.valueOf(dadosBoletos.get(i).get(17)));}
            if(dadosBoletos.get(i).get(18) != null){bbol.dataDePagamento        =                    String.valueOf(dadosBoletos.get(i).get(18));}
            if(dadosBoletos.get(i).get(19) != null){bbol.Instrucao1             =                    String.valueOf(dadosBoletos.get(i).get(19));}
            if(dadosBoletos.get(i).get(20) != null){bbol.Instrucao3             =                    String.valueOf(dadosBoletos.get(i).get(20));}
            if(dadosBoletos.get(i).get(21) != null){bbol.CodigoDeBarras1        =                    String.valueOf(dadosBoletos.get(i).get(21));}
            if(dadosBoletos.get(i).get(22) != null){bbol.CodigoDeBarras2        =                    String.valueOf(dadosBoletos.get(i).get(22));}
            if(dadosBoletos.get(i).get(23) != null){bbol.CodigoDeBarras3        =                    String.valueOf(dadosBoletos.get(i).get(23));}
            if(dadosBoletos.get(i).get(24) != null){bbol.CodigoDeBarras4        =                    String.valueOf(dadosBoletos.get(i).get(24));}
            if(dadosBoletos.get(i).get(25) != null){bbol.CodigoDeBarras5        =                    String.valueOf(dadosBoletos.get(i).get(25));}
            if(dadosBoletos.get(i).get(26) != null){bbol.CodigoDeBarras         =                    String.valueOf(dadosBoletos.get(i).get(26));}
            if(dadosBoletos.get(i).get(27) != null){bbol.ocorrenciaRemessa      = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(27)));}
            if(dadosBoletos.get(i).get(28) != null){bbol.ocorrenciaRetorno      = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(28)));}
            if(dadosBoletos.get(i).get(29) != null){bbol.ParcelaAtual           = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(29)));}
            if(dadosBoletos.get(i).get(30) != null){bbol.TotalDeParcelas        = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(30)));}
            if(dadosBoletos.get(i).get(31) != null){bbol.statusBoleto           = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(31)));}
            
            binter.dataVerificadora = Test.Testa(bbol.dataEmissao);
            if(binter.dataVerificadora  < binter.dataEmissaoInicial)continue;
            if(binter.dataVerificadora  > binter.dataEmissaoFinal)  continue;
            
            if(!bbol.dataDePagamento.equals("null")){
                if(bbol.dataDePagamento != null){
                    binter.dataVerificadora = Test.Testa(bbol.dataDePagamento);
                    if(binter.dataVerificadora  < binter.dataPagamentoInicial)  continue;
                    if(binter.dataVerificadora  > binter.dataPagamentoFinal)    continue;
                }
            }
            
            binter.dataVerificadora = Test.Testa(bbol.dataDeVencimento);
            if(binter.dataVerificadora  < binter.dataVencimentoInicial) continue;
            if(binter.dataVerificadora  > binter.dataVencimentoFinal)   continue;
            
            bbol.dataEmissao        = invdata.inverterData(bbol.dataEmissao, 1);
            bbol.dataDeVencimento   = invdata.inverterData(bbol.dataDeVencimento, 1);
            
            Status = "Pendente";
            if(dataAtual > binter.dataVerificadora)
                if(bbol.valorPago <  bbol.valorDevido)
                    Status = "Vencido";
            if(binter.dataVerificadora - dataAtual > 0 && binter.dataVerificadora - dataAtual <= 5)
                if(bbol.valorPago <  bbol.valorDevido){
                    Status = "À Vencer";
                    Mensagem = "Boleto n°" + bbol.codigoBoleto + " irá vencer em " + bbol.dataDeVencimento + "!";
                    new MostraMensagem(Mensagem);
                }
            if(bbol.valorPago >= bbol.valorDevido)
                Status = "Pago";
            if(bbol.valorPago >  0 && bbol.valorPago < bbol.valorDevido)
                Status = "Pagamento Parcial";
            if(bbol.ocorrenciaRetorno == 6 && bbol.valorPago == 0)
                Status = "Baixado";
            
            switch(Status){
                case "Vencido"          : if(check_BoletosVencidos  .isSelected())continue; break;
                case "À Vencer"         : if(check_BoletosAVencer   .isSelected())continue; break;
                case "Pago"             : if(check_BoletosPagos     .isSelected())continue; break;
                case "Pagamento Parcial": if(check_boletosParcial   .isSelected())continue; break;
                case "Baixado"          : if(check_BoletosBaixados  .isSelected())continue; break;
                default: Status = "";
            }
            
            bc.codigoCliente        = bbol.codigoCliente;
            PegaCliente();
            
            bu.codigoUsuario        = bbol.codigoUsuario;
            PegaUsuarios();
            
            switch(bbol.ocorrenciaRemessa){
                case  1: ocorrencia = bbol.ocorrenciaRemessa + " - Remessa";                            TotalBoletosPendentes   ++; break;
                case  2: ocorrencia = bbol.ocorrenciaRemessa + " - Solicitado Baixa";                   TotalBoletosPendentes   ++; break;
                case  6: ocorrencia = bbol.ocorrenciaRemessa + " - Solicitado Alteração de Vencimento"; TotalBoletosPendentes   ++; break;
                case  9: ocorrencia = bbol.ocorrenciaRemessa + " - Solicitado protesto";                break;
                case 10: ocorrencia = bbol.ocorrenciaRemessa + " - Solicitado não protesto";            break;
                case 18: ocorrencia = bbol.ocorrenciaRemessa + " - Solicitado susteio de protesto";     break;
                case 31: ocorrencia = bbol.ocorrenciaRemessa + " - Solicitado alteração de dados";      break;
                default: ocorrencia = "--------------------";
            }
            
            switch(bbol.ocorrenciaRetorno){
                case  2: ocorrencia = bbol.ocorrenciaRetorno + " - Entrada confirmada";                 TotalBoletosPendentes   ++; break;
                case  3: ocorrencia = bbol.ocorrenciaRetorno + " - Entrada rejeitada";                  TotalBoletosPendentes   ++; break;
                case  4: ocorrencia = bbol.ocorrenciaRetorno + " - Alteração/Exclusão de dados acatada";TotalBoletosPendentes   ++; break;
                case  5: ocorrencia = bbol.ocorrenciaRetorno + " - Alteração de dados - Baixa";         TotalBoletosPendentes   ++; break;
                case  6: ocorrencia = bbol.ocorrenciaRetorno + " - Liquidado (L)";                      TotalBoletosPagos       ++; break;
                case  8: ocorrencia = bbol.ocorrenciaRetorno + " - Liquidado (L) - Cartório";           TotalBoletosPagos       ++; break;
                case  9: ocorrencia = bbol.ocorrenciaRetorno + " - Baixado";                            break;
                case 14: ocorrencia = bbol.ocorrenciaRetorno + " - Vencimento Alterado";                break;
            }
            
            bb.codigoBanco  = bbol.CodigoDeBarras.substring(0, 3);
            PegaBanco();
            NomeBanco       = bb.codigoBanco + " - " + bb.nomeBanco;
            
            if(bbol.dataDePagamento == null || bbol.dataDePagamento.equals("null") || bbol.dataDePagamento.equals("")){
                bbol.dataDePagamento    = "---------------";
            }else{
                bbol.dataDePagamento    = parametrosNS.invdata.inverterData(bbol.dataDePagamento, 1);
            }
            
            TotalBoletos                = i                          + 1;
            ValorTotalBoletos           = ValorTotalBoletos          + bbol.valorDevido;
            ValorTotalBoletosPendentes  = ValorTotalBoletosPendentes + bbol.valorDevido;
            ValorTotalBoletosPagos      = ValorTotalBoletosPagos     + bbol.valorPago;
            
            tbBoletos.addRow(new Object[]{parametrosNS.fc.FormataCampo(String.valueOf(bbol.codigoBoleto), 8, 0), parametrosNS.fc.FormataCampo(String.valueOf(bbol.codigoCliente), 5, 0) + " - " + bc.nome, bbol.tipoDeFaturamento, NomeBanco, bbol.dataEmissao, bbol.Instrucao1, nf.format(bbol.valorDevido), bbol.dataDeVencimento, nf.format(bbol.valorPago), bbol.dataDePagamento, parametrosNS.fc.FormataCampo(String.valueOf(bbol.ParcelaAtual), 2, 0) + " de " + parametrosNS.fc.FormataCampo(String.valueOf(bbol.TotalDeParcelas), 2, 0), parametrosNS.fc.FormataCampo(String.valueOf(bbol.codigoUsuario), 3, 0)+ " - " + bu.usuario, ocorrencia, bbol.codigoPagamento, Status});
        }
        ValorTotalPendentes2 = ValorTotalBoletosPendentes - ValorTotalBoletosPagos;
        if(tabela_boletos.getRowCount() > 0){
            ConvTabOSeVenBol.numeroDaColuna = 14;
            for(int i = 0; i < tabela_boletos.getColumnCount(); i++){
                tabela_boletos.getColumnModel().getColumn(i).setCellRenderer(ConvTabOSeVenBol);
            }
            tabela_boletos.updateUI();
            
            tbBoletos.addRow(new Object[]{"", "Totais: ", "", "", "", "", nf.format(ValorTotalBoletos), "", nf.format(ValorTotalBoletosPagos), "", "", "", "", "", ""});
        }
        tabela_boletos.setVisible(true);
        txt_totalBoletos.setText(String.valueOf(TotalBoletos));
        txt_totalBoletosPendentes.setText(String.valueOf(TotalBoletosPendentes));
        txt_ValorTotalBoletosPendentes.setText(String.valueOf(nf.format(ValorTotalBoletosPendentes)));
        txt_valorTotalBoletosPagos.setText(nf.format(ValorTotalBoletosPagos));
        txt_totalBoletosPagos.setText(String.valueOf(TotalBoletosPagos));
        txt_ValorTotalBoletosPendentes2.setText(String.valueOf(nf.format(ValorTotalPendentes2)));
        new AjustarLarguraColunas(tabela_boletos);
    }
}
