package TelasVendas;

import Beans.BeanVendas;
import Beans.BeanUsuarios;
import Beans.BeanClientes;
import Beans.BeanIntervalos;
import Beans.BeanParametros;
import Beans.BeanProdutos;
import Beans.BeanVendasItens;
import FuncoesInternas.InverterData;
import FuncoesInternas.FormataCampo;
import java.util.ArrayList;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.TestarData;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.ColorirTabelaOSeVendaseBoletos;
import FuncoesInternas.ExportarParaExcel;
import FuncoesInternas.FormataCPFCNPJ;
import FuncoesInternas.TransformaValorStringeDouble;
import Telas.UsuariosConsulta;
import TelasFaturamento.ClientesConsulta;
import TelasProducao.EfetuarPagamento;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/*
 @author Tiago e Paulo
 */
public class VendasConsultaEManutencao extends javax.swing.JFrame {
    //String
    String sql                  = "";
    String sqlstate             = "";
    String fatal                = "";
    String Mensagem             = "";
    String somostra             = "";
    String fazManutencao        = "";
    String retorno              = "";
    String StatusVenda          = "";
    String Campo                = "";
    
    //int
    int    linha                = 0;
    int    abriuCancelarVenda   = 0;
    int    abriuVendedor        = 0;
    int    abriuCliente         = 0;
    int    QtdDeVendas          = 0;
    int    QtdCancelados        = 0;
    int    QtdDeItens           = 0;
    int    QtdTotalDeItens      = 0;
    
    //Floats
    double ValorDaVenda         = 0;
    double ValorTotalDasVendas  = 0;
    
    //Variaveis de Intervalo
    
    //Vetores
    ArrayList            parametros         = new ArrayList();
    ArrayList            dadosPadroes       = new ArrayList();
    ArrayList<ArrayList> dadosCliente       = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosProdutos      = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosParametros    = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosUsuarios      = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosVendas        = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosVendasItens   = new ArrayList<ArrayList>();
    
    //Beans
    BeanClientes            bc      = new BeanClientes();
    BeanUsuarios            bu      = new BeanUsuarios();
    BeanProdutos            bp      = new BeanProdutos();
    BeanVendas              bv      = new BeanVendas();
    BeanVendasItens         bvi     = new BeanVendasItens();
    BeanIntervalos          binter  = new BeanIntervalos();
    BeanParametros          bpar    = new BeanParametros();
    
    //Funcoes
    CapturarDataHora                cdh             = new CapturarDataHora();
    FormataCampo                    fc              = new FormataCampo();
    FormataCPFCNPJ                  FCpfCnpj        = new FormataCPFCNPJ();
    InverterData                    invdata         = new InverterData();
    TestarData                      Test            = new TestarData();
    TransformaValorStringeDouble    TransStrDou     = new TransformaValorStringeDouble();
    ColorirTabelaOSeVendaseBoletos  ConvTabOSeVenBol= new ColorirTabelaOSeVendaseBoletos();
    
    //Telas
    CancelarVenda       CanVen;
    ClientesConsulta    CliCon;
    EfetuarPagamento    EfePag;
    PDV                 Pdv;
    UsuariosConsulta    UsuCon;
    
    //Especiais para Excportação em Excel
    JFileChooser                    SeletorExcel;
    String                          NomeArquivoExcel    = "";
    String                          LocalArquivo        = "";
    int                             SalvarExcel         = 0;
    
    //Outros
    DefaultTableModel               tbVendas;
    PreparedStatement               stmt;
    ResultSet                       rs;
    JRResultSetDataSource           js;
    
    //Especiais para Relatórios
    String                  jpv         = "";
    JasperPrint             jpp         = null;
    HashMap                 hm          = new HashMap();
    JRPrintPage             jrp         = null;
    List                    QtdPages    = null;
    
    public VendasConsultaEManutencao(ArrayList DadosPadroes){
        dadosPadroes                = DadosPadroes;
        
        somostra                    = (String)  dadosPadroes.get(0);
        fazManutencao               = (String)  dadosPadroes.get(1);
        
        initComponents();
    }
    
    private void PegaParametros(){
        sql = "select * from tb_parametros where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosParametros.clear();
        dadosParametros = parametrosNS.dao.Consulta(sql);
        if(dadosParametros.isEmpty()){
            bt_imprimir.setEnabled(false);
            return;
        }
        PegaDadosParametros();
    }
    
    private void PegaDadosParametros(){
        for(int i = 0; i < dadosParametros.size(); i++){
            bpar.idParametros       = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(0)));
            bpar.idEmpresa          = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(1)));
            bpar.codigoGrupo        = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(2)));
            bpar.codigoEmpresa      = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(3)));
            bpar.pastaRelatorios    =                    String.valueOf(dadosParametros.get(i).get(4));
        }
    }
    
    private void InicializaCampos(){
        txt_vendaInicial        .setText(fc.FormataCampo("", 9, 0));
        txt_vendaFinal          .setText("999999999");
        txt_vendedorInicial     .setText(fc.FormataCampo("", 3, 0));
        txt_vendedorFinal       .setText("999");
        txt_dataInicial         .setText(fc.FormataCampo("", 10, 2));
        txt_dataFinal           .setText(cdh.CapturarData());
        txt_clienteInicial      .setText(fc.FormataCampo("", 5, 0));
        txt_clienteFinal        .setText("99999");
    }
    
    public void ColorirTabelaOSeVendas(){
        new ColorirTabelaOSeVendaseBoletos().numeroDaColuna = 5;
        for(int i = 0; i < tabela_vendas.getColumnCount(); i++){;
            tabela_vendas.getColumnModel().getColumn(i).setCellRenderer(new ColorirTabelaOSeVendaseBoletos());
        }
        tabela_vendas.updateUI();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPopupMenu();
        bt_cancelarVenda = new javax.swing.JMenuItem();
        bt_efetuarPagamento = new javax.swing.JMenuItem();
        bt_detalhesItem = new javax.swing.JMenuItem();
        jLabel4 = new javax.swing.JLabel();
        txt_totalCanceladas = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_qtdItensVenda = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_valorTotalVendas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_qtdVendas = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_vendas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_vendaInicial = new javax.swing.JFormattedTextField();
        txt_vendaFinal = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_vendedorInicial = new javax.swing.JFormattedTextField();
        txt_vendedorFinal = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_dataInicial = new javax.swing.JFormattedTextField();
        txt_dataFinal = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_clienteInicial = new javax.swing.JFormattedTextField();
        txt_clienteFinal = new javax.swing.JFormattedTextField();
        bt_pesquisaVendedorInicial = new javax.swing.JButton();
        bt_pesquisaClienteInicial = new javax.swing.JButton();
        bt_pesquisaVendedorFinal = new javax.swing.JButton();
        bt_pesquisClienteFinal = new javax.swing.JButton();
        bt_processa = new javax.swing.JButton();
        bt_exportar = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        check_IgnorarCanceladas = new javax.swing.JCheckBox();
        check_IgnorarFinalizadas = new javax.swing.JCheckBox();
        bt_imprimir = new javax.swing.JButton();
        jMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        bt_sair1 = new javax.swing.JMenuItem();

        bt_cancelarVenda.setText("Cancelar Venda");
        bt_cancelarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarVendaActionPerformed(evt);
            }
        });
        menu.add(bt_cancelarVenda);

        bt_efetuarPagamento.setText("Efetuar Pagamento");
        bt_efetuarPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_efetuarPagamentoActionPerformed(evt);
            }
        });
        menu.add(bt_efetuarPagamento);

        bt_detalhesItem.setText("Detalhes da Venda");
        bt_detalhesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_detalhesItemActionPerformed(evt);
            }
        });
        menu.add(bt_detalhesItem);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Total de vendas: ");

        txt_totalCanceladas.setEditable(false);
        txt_totalCanceladas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 0));
        jLabel7.setText("Canceladas: ");

        txt_qtdItensVenda.setEditable(false);
        txt_qtdItensVenda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Total de itens vendidos: ");

        txt_valorTotalVendas.setEditable(false);
        txt_valorTotalVendas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Valor total das vendas: ");

        txt_qtdVendas.setEditable(false);
        txt_qtdVendas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Vendas");
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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vendas");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_vendas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_vendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Venda n°", "Vendedor", "Cliente", "Data", "Hora", "Status", "Qtd de Itens", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_vendas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_vendas.setAutoscrolls(false);
        tabela_vendas.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tabela_vendas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_vendas.getTableHeader().setReorderingAllowed(false);
        tabela_vendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_vendasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_vendas);
        if (tabela_vendas.getColumnModel().getColumnCount() > 0) {
            tabela_vendas.getColumnModel().getColumn(0).setResizable(false);
            tabela_vendas.getColumnModel().getColumn(1).setResizable(false);
            tabela_vendas.getColumnModel().getColumn(2).setResizable(false);
            tabela_vendas.getColumnModel().getColumn(3).setResizable(false);
            tabela_vendas.getColumnModel().getColumn(4).setResizable(false);
            tabela_vendas.getColumnModel().getColumn(5).setResizable(false);
            tabela_vendas.getColumnModel().getColumn(6).setResizable(false);
            tabela_vendas.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Intervalos de Consulta        F11 [Geral]");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Venda:");

        try {
            txt_vendaInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_vendaInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_vendaInicial.setText("000000000");
        txt_vendaInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_vendaInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_vendaInicialFocusLost(evt);
            }
        });
        txt_vendaInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_vendaInicialKeyPressed(evt);
            }
        });

        try {
            txt_vendaFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_vendaFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_vendaFinal.setText("999999999");
        txt_vendaFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_vendaFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_vendaFinalFocusLost(evt);
            }
        });
        txt_vendaFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_vendaFinalKeyPressed(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Inicial");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Final");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Vendedor:");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Final");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Inicial");

        try {
            txt_vendedorInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_vendedorInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_vendedorInicial.setText("000");
        txt_vendedorInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_vendedorInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_vendedorInicialFocusLost(evt);
            }
        });
        txt_vendedorInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_vendedorInicialKeyPressed(evt);
            }
        });

        try {
            txt_vendedorFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_vendedorFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_vendedorFinal.setText("999");
        txt_vendedorFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_vendedorFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_vendedorFinalFocusLost(evt);
            }
        });
        txt_vendedorFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_vendedorFinalKeyPressed(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Data da Venda:");

        try {
            txt_dataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataInicial.setText("00/00/0000");
        txt_dataInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataInicialFocusLost(evt);
            }
        });
        txt_dataInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataInicialKeyPressed(evt);
            }
        });

        try {
            txt_dataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataFinal.setText("99/99/9999");
        txt_dataFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataFinalFocusLost(evt);
            }
        });
        txt_dataFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataFinalKeyPressed(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Cliente:");

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
        txt_clienteFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_clienteFinal.setText("99999");
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

        bt_pesquisaVendedorInicial.setText("...");
        bt_pesquisaVendedorInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaVendedorInicialActionPerformed(evt);
            }
        });

        bt_pesquisaClienteInicial.setText("...");
        bt_pesquisaClienteInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaClienteInicialActionPerformed(evt);
            }
        });

        bt_pesquisaVendedorFinal.setText("...");
        bt_pesquisaVendedorFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaVendedorFinalActionPerformed(evt);
            }
        });

        bt_pesquisClienteFinal.setText("...");
        bt_pesquisClienteFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisClienteFinalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_vendaInicial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_vendaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_dataInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_dataFinal)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_clienteInicial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bt_pesquisaClienteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_vendedorInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bt_pesquisaVendedorInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_vendedorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisaVendedorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_clienteFinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisClienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel8, jLabel9, txt_dataFinal, txt_dataInicial, txt_vendaFinal, txt_vendaInicial});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel11, jLabel12, txt_clienteFinal, txt_clienteInicial, txt_vendedorFinal, txt_vendedorInicial});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel14});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_vendaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_vendaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txt_vendedorInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_vendedorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaVendedorInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaVendedorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txt_clienteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_clienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaClienteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisClienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisClienteFinal, bt_pesquisaClienteInicial, bt_pesquisaVendedorFinal, bt_pesquisaVendedorInicial, jLabel10, jLabel11, jLabel12, jLabel13, jLabel14, jLabel3, jLabel8, jLabel9, txt_clienteFinal, txt_clienteInicial, txt_dataFinal, txt_dataInicial, txt_vendaFinal, txt_vendaInicial, txt_vendedorFinal, txt_vendedorInicial});

        bt_processa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/1280454766_system-software-update.png"))); // NOI18N
        bt_processa.setText("Processa");
        bt_processa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_processaActionPerformed(evt);
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

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        check_IgnorarCanceladas.setText("Ignorar Canceladas");
        check_IgnorarCanceladas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_IgnorarCanceladasActionPerformed(evt);
            }
        });

        check_IgnorarFinalizadas.setText("Ignorar Finalizadas");
        check_IgnorarFinalizadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_IgnorarFinalizadasActionPerformed(evt);
            }
        });
        check_IgnorarFinalizadas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                check_IgnorarFinalizadasKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(check_IgnorarCanceladas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check_IgnorarFinalizadas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(check_IgnorarCanceladas)
                    .addComponent(check_IgnorarFinalizadas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bt_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Print.png"))); // NOI18N
        bt_imprimir.setText("Imprimir");
        bt_imprimir.setEnabled(false);
        bt_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imprimirActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        jMenu2.setText("Cadastro");

        jMenuItem1.setText("PDV");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenu1.add(jMenu2);
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

        jMenu.add(jMenu1);

        setJMenuBar(jMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_processa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_exportar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_imprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_sair))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_exportar, bt_imprimir, bt_processa});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_processa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_exportar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_exportar, bt_imprimir, bt_processa});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tbVendas = (DefaultTableModel)tabela_vendas.getModel();
        
        if(parametrosNS.bu.nivelUsuario  < 4 | somostra.equals("S")){
            jMenu.setVisible(false);
        }
        
        PegaParametros();
        
        InicializaCampos();
        PegaValores();
    }//GEN-LAST:event_formWindowOpened

    private void bt_processaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_processaActionPerformed
        PegaValores();
    }//GEN-LAST:event_bt_processaActionPerformed

    private void tabela_vendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_vendasMouseClicked
        linha = tabela_vendas.getSelectedRow();
        if(linha < 0){
            Mensagem = "Item não selecionado!";
            new MostraMensagem(Mensagem);
            return;
        }
        if(evt.getButton() == MouseEvent.BUTTON3){ // botão direito do mouse
            if(fazManutencao.equalsIgnoreCase("N")){
                bt_cancelarVenda.setVisible(false);
                bt_efetuarPagamento.setVisible(false);
            }
            if(somostra.equalsIgnoreCase("S")){
                bt_detalhesItem.setVisible(false);
            }
            StatusVenda = String.valueOf(tabela_vendas.getValueAt(linha, 5));
            switch(StatusVenda){
                case "Cancelada"    : bt_cancelarVenda      .setEnabled(false);
                                      bt_efetuarPagamento   .setEnabled(false);  break;
                case "Finalizada"   : bt_cancelarVenda      .setEnabled(true);
                                      bt_efetuarPagamento   .setEnabled(false);  break;
                default             : bt_cancelarVenda      .setEnabled(true);
                                      bt_efetuarPagamento   .setEnabled(true);
            }
            bv.codigoVenda  = Integer.parseInt(String.valueOf(tabela_vendas.getValueAt(linha, 0)));
            sql = "select idVenda from tb_vendas where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoVenda = " + bv.codigoVenda + ";";
            dadosVendas.clear();
            dadosVendas = parametrosNS.dao.Consulta(sql);
            bv.idVenda = Integer.parseInt(String.valueOf(dadosVendas.get(0).get(0)));
            menu.show(evt.getComponent(), evt.getX(), evt.getY());
            return;
        }
        if(evt.getClickCount() > 1){
            retorno = String.valueOf(bv.idVenda);
            dispose();
        }
    }//GEN-LAST:event_tabela_vendasMouseClicked

    private void txt_vendaInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_vendaInicialFocusGained
        txt_vendaInicial.setSelectionStart(0);
        txt_vendaInicial.setSelectionEnd  (txt_vendaInicial.getText().length());
    }//GEN-LAST:event_txt_vendaInicialFocusGained

    private void txt_vendaFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_vendaFinalFocusGained
        txt_vendaFinal.setSelectionStart(0);
        txt_vendaFinal.setSelectionEnd  (txt_vendaFinal.getText().length());
    }//GEN-LAST:event_txt_vendaFinalFocusGained

    private void txt_vendedorInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_vendedorInicialFocusGained
        txt_vendedorInicial.setSelectionStart(0);
        txt_vendedorInicial.setSelectionEnd  (txt_vendedorInicial.getText().length());
    }//GEN-LAST:event_txt_vendedorInicialFocusGained

    private void txt_vendedorFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_vendedorFinalFocusGained
        txt_vendedorFinal.setSelectionStart(0);
        txt_vendedorFinal.setSelectionEnd  (txt_vendedorFinal.getText().length());
    }//GEN-LAST:event_txt_vendedorFinalFocusGained

    private void txt_dataInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataInicialFocusGained
        txt_dataInicial.setSelectionStart(0);
        txt_dataInicial.setSelectionEnd  (txt_dataInicial.getText().length());
    }//GEN-LAST:event_txt_dataInicialFocusGained

    private void txt_dataFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataFinalFocusGained
        txt_dataFinal.setSelectionStart(0);
        txt_dataFinal.setSelectionEnd  (txt_dataFinal.getText().length());
    }//GEN-LAST:event_txt_dataFinalFocusGained

    private void txt_clienteInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_clienteInicialFocusGained
        txt_clienteInicial.setSelectionStart(0);
        txt_clienteInicial.setSelectionEnd  (txt_clienteInicial.getText().length());
    }//GEN-LAST:event_txt_clienteInicialFocusGained

    private void txt_clienteFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_clienteFinalFocusGained
        txt_clienteFinal.setSelectionStart(0);
        txt_clienteFinal.setSelectionEnd  (txt_clienteFinal.getText().length());
    }//GEN-LAST:event_txt_clienteFinalFocusGained

    private void txt_vendaInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_vendaInicialFocusLost
        txt_vendaInicial.setText(fc.FormataCampo(txt_vendaInicial.getText(), 9, 0));
    }//GEN-LAST:event_txt_vendaInicialFocusLost

    private void txt_vendaFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_vendaFinalFocusLost
        txt_vendaFinal.setText(fc.FormataCampo(txt_vendaFinal.getText(), 9, 0));
    }//GEN-LAST:event_txt_vendaFinalFocusLost

    private void txt_vendedorInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_vendedorInicialFocusLost
        txt_vendedorInicial.setText(fc.FormataCampo(txt_vendedorInicial.getText(), 3, 0));
    }//GEN-LAST:event_txt_vendedorInicialFocusLost

    private void txt_vendedorFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_vendedorFinalFocusLost
        txt_vendedorFinal.setText(fc.FormataCampo(txt_vendedorFinal.getText(), 3, 0));
    }//GEN-LAST:event_txt_vendedorFinalFocusLost

    private void txt_dataInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataInicialFocusLost
        txt_dataInicial.setText(fc.FormataCampo(txt_dataInicial.getText(), 10, 2));
    }//GEN-LAST:event_txt_dataInicialFocusLost

    private void txt_dataFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataFinalFocusLost
        txt_dataFinal.setText(fc.FormataCampo(txt_dataFinal.getText(), 10, 2));
    }//GEN-LAST:event_txt_dataFinalFocusLost

    private void txt_clienteInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_clienteInicialFocusLost
        txt_clienteInicial.setText(fc.FormataCampo(txt_clienteInicial.getText(), 5, 0));
    }//GEN-LAST:event_txt_clienteInicialFocusLost

    private void txt_clienteFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_clienteFinalFocusLost
        txt_clienteFinal.setText(fc.FormataCampo(txt_clienteFinal.getText(), 5, 0));
    }//GEN-LAST:event_txt_clienteFinalFocusLost

    private void txt_vendaInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_vendaInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_vendaFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_vendaInicial.setText(fc.FormataCampo("", 9, 0));
            txt_vendaFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_vendaInicialKeyPressed

    private void txt_vendaFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_vendaFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_vendedorInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_vendaFinal.setText("999999999");
            txt_vendedorInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_vendaFinalKeyPressed

    private void txt_vendedorInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_vendedorInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_vendedorFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_vendedorInicial.setText(fc.FormataCampo("", 3, 0));
            txt_vendedorFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_vendedorInicialKeyPressed

    private void txt_vendedorFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_vendedorFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_vendedorFinal.setText("999");
            txt_dataInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_vendedorFinalKeyPressed

    private void txt_dataInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataInicial.setText(fc.FormataCampo("", 8, 0));
            txt_dataFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataInicialKeyPressed

    private void txt_dataFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_clienteInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataFinal.setText("99999999");
            txt_clienteInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataFinalKeyPressed

    private void txt_clienteInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_clienteInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_clienteFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_clienteInicial.setText(fc.FormataCampo("", 5, 0));
            txt_clienteFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_clienteInicialKeyPressed

    private void txt_clienteFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_clienteFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            bt_processa.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_clienteFinal.setText("99999");
            bt_processa.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_clienteFinalKeyPressed

    private void bt_cancelarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarVendaActionPerformed
        if(CanVen != null)if(CanVen.isVisible()){
            Mensagem = "Tela já Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuCancelarVenda = 1;
        CanVen = new CancelarVenda(bv.idVenda);
        CanVen.setVisible(true);
    }//GEN-LAST:event_bt_cancelarVendaActionPerformed

    private void bt_efetuarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_efetuarPagamentoActionPerformed
        if(EfePag != null)if(EfePag.isVisible()){
            Mensagem = "Tela já Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add(0);
        parametros.add(bv.codigoVenda);
        parametros.add(0);
        parametros.add(0);
        parametros.add("Venda");
        EfePag = new EfetuarPagamento(parametros, null);
        EfePag.setVisible(true);
    }//GEN-LAST:event_bt_efetuarPagamentoActionPerformed

    private void bt_detalhesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesItemActionPerformed
        if(Pdv != null)if(Pdv.isVisible()){
            Mensagem = "Tela já Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("S");
        parametros.add(bv.idVenda);
        parametros.add(0);
        parametros.add(0);
        parametros.add("");
        Pdv = new PDV(parametros);
        Pdv.setVisible(true);
    }//GEN-LAST:event_bt_detalhesItemActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuCancelarVenda == 0){
            AbriuVendedor();
            return;
        }
        abriuCancelarVenda = 0;
        sqlstate = CanVen.getRetorno();
        if(!sqlstate.equals("00000")){
            return;
        }
        PegaVendaItens("S");
        if(!sqlstate.equals("00000")){
            return;
        }
        PegaValores();
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbriuVendedor(){
        if(abriuVendedor == 0){
            AbriuCliente();
            return;
        }
        abriuVendedor = 0;
        retorno = UsuCon.getRetorno();
        if(retorno.equals("")){
            return;
        }
        if(Campo.equals("I")){
            txt_vendedorInicial.setText(fc.FormataCampo(retorno, 3, 0));
            return;
        }
        txt_vendedorFinal.setText(fc.FormataCampo(retorno, 3, 0));
    }
    
    private void AbriuCliente(){
        if(abriuCliente == 0){
            return;
        }
        abriuCliente = 0;
        retorno = CliCon.getRetorno();
        if(retorno.equals("")){
            return;
        }
        if(Campo.equals("I")){
            txt_clienteInicial.setText(fc.FormataCampo(retorno, 5, 0));
            return;
        }
        txt_clienteFinal.setText(fc.FormataCampo(retorno, 5, 0));
    }
    
    private void bt_exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_exportarActionPerformed
        SeletorExcel = new JFileChooser();
        SalvarExcel = SeletorExcel.showSaveDialog(tabela_vendas);
        if(SalvarExcel != JFileChooser.APPROVE_OPTION){
            return;
        }
        NomeArquivoExcel    = SeletorExcel.getSelectedFile().getName();
        LocalArquivo        = SeletorExcel.getSelectedFile().getParentFile().getPath();
        String Extensao = "";
        if(NomeArquivoExcel.length() > 4) {
            Extensao = NomeArquivoExcel.substring(NomeArquivoExcel.length() - 4, NomeArquivoExcel.length());
        }
        if(Extensao.equals(".xls")) {
            LocalArquivo = LocalArquivo + "\\" + NomeArquivoExcel;
        }else{
            LocalArquivo = LocalArquivo + "\\" + NomeArquivoExcel + ".xls";
        }
        try {
            new ExportarParaExcel(tabela_vendas, new File(LocalArquivo), 0, 0, 0);
        } catch (IOException erro) {
            Mensagem = "Erro: " + erro.getMessage();
            new MostraMensagem(Mensagem);
        }
    }//GEN-LAST:event_bt_exportarActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimirActionPerformed
        binter.osInicial    = Integer.parseInt(String.valueOf(tabela_vendas.getValueAt(0, 0)));
        binter.osFinal      = Integer.parseInt(String.valueOf(tabela_vendas.getValueAt(tabela_vendas.getRowCount() - 2, 0)));
        sql = "select * from tb_vendas ven "
            + "inner join tb_vendas_itens venIte on venIte.codigoVenda = ven.codigoVenda "
            + "inner join tb_produtos pro on pro.codigoProduto = venIte.codigoProduto "
            + "inner join tb_clientes cli on cli.codigoCliente = ven.codigoCliente "
            + "where ven.codigoGrupo = " + parametrosNS.bge.codigoGrupo + " and ven.codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and "
            + "ven.codigoVenda between " + binter.osInicial + " and " + binter.osFinal + ";";
        Imprimir();
    }//GEN-LAST:event_bt_imprimirActionPerformed

    private void check_IgnorarFinalizadasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_check_IgnorarFinalizadasKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            bt_processa.grabFocus();
    }//GEN-LAST:event_check_IgnorarFinalizadasKeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(Pdv != null)if(Pdv.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("SN");
        parametros.add(0);
        parametros.add(0);
        parametros.add(0);
        parametros.add(0);
        Pdv = new PDV(parametros);
        Pdv.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(CanVen   != null)CanVen  .dispose();
        if(CliCon   != null)CliCon  .dispose();
        if(EfePag   != null)EfePag  .dispose();
        if(Pdv      != null)Pdv     .dispose();
        if(UsuCon   != null)UsuCon  .dispose();
    }//GEN-LAST:event_formWindowClosed

    private void bt_pesquisaVendedorInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaVendedorInicialActionPerformed
        Campo   = "I";
        PesquisaVendedor();
    }//GEN-LAST:event_bt_pesquisaVendedorInicialActionPerformed
    
    private void PesquisaVendedor(){
        if(UsuCon != null)if(UsuCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuVendedor = 1;
        parametros.clear();
        parametros.add("N");
        UsuCon = new UsuariosConsulta(parametros);
        UsuCon.setVisible(true);
    }
    
    private void bt_pesquisaVendedorFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaVendedorFinalActionPerformed
        Campo   = "F";
        PesquisaVendedor();
    }//GEN-LAST:event_bt_pesquisaVendedorFinalActionPerformed

    private void bt_pesquisaClienteInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaClienteInicialActionPerformed
        Campo   = "I";
        PesquisaCliente();
    }//GEN-LAST:event_bt_pesquisaClienteInicialActionPerformed
    
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
    
    private void bt_pesquisClienteFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisClienteFinalActionPerformed
        Campo   = "F";
        PesquisaCliente();
    }//GEN-LAST:event_bt_pesquisClienteFinalActionPerformed

    private void check_IgnorarCanceladasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_IgnorarCanceladasActionPerformed
        PegaValores();
    }//GEN-LAST:event_check_IgnorarCanceladasActionPerformed

    private void check_IgnorarFinalizadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_IgnorarFinalizadasActionPerformed
        PegaValores();
    }//GEN-LAST:event_check_IgnorarFinalizadasActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem bt_cancelarVenda;
    private javax.swing.JMenuItem bt_detalhesItem;
    private javax.swing.JMenuItem bt_efetuarPagamento;
    private javax.swing.JButton bt_exportar;
    private javax.swing.JButton bt_imprimir;
    private javax.swing.JButton bt_pesquisClienteFinal;
    private javax.swing.JButton bt_pesquisaClienteInicial;
    private javax.swing.JButton bt_pesquisaVendedorFinal;
    private javax.swing.JButton bt_pesquisaVendedorInicial;
    private javax.swing.JButton bt_processa;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JCheckBox check_IgnorarCanceladas;
    private javax.swing.JCheckBox check_IgnorarFinalizadas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu menu;
    private javax.swing.JTable tabela_vendas;
    private javax.swing.JFormattedTextField txt_clienteFinal;
    private javax.swing.JFormattedTextField txt_clienteInicial;
    private javax.swing.JFormattedTextField txt_dataFinal;
    private javax.swing.JFormattedTextField txt_dataInicial;
    private javax.swing.JTextField txt_qtdItensVenda;
    private javax.swing.JTextField txt_qtdVendas;
    private javax.swing.JTextField txt_totalCanceladas;
    private javax.swing.JTextField txt_valorTotalVendas;
    private javax.swing.JFormattedTextField txt_vendaFinal;
    private javax.swing.JFormattedTextField txt_vendaInicial;
    private javax.swing.JFormattedTextField txt_vendedorFinal;
    private javax.swing.JFormattedTextField txt_vendedorInicial;
    // End of variables declaration//GEN-END:variables
    
    private void PegaValores(){
        binter = new BeanIntervalos();
        binter.VendaInicial        = Integer.parseInt(txt_vendaInicial.getText());
        binter.VendaFinal          = Integer.parseInt(txt_vendaFinal.getText());
        if(binter.VendaInicial > binter.VendaFinal){
            Mensagem = "Venda Inicial não pode ser maior do que Venda Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        binter.VendedorInicial     = Integer.parseInt(txt_vendedorInicial.getText());
        binter.VendedorFinal       = Integer.parseInt(txt_vendedorFinal.getText());
        if(binter.VendedorInicial > binter.VendedorFinal){
            Mensagem = "Vendedor Inicial não pode ser maior do que Vendedor Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        binter.dataVendaInicial    = Test.Testa(txt_dataInicial.getText());
        binter.dataVendaFinal      = Test.Testa(txt_dataFinal.getText());
        if(binter.dataVendaInicial > binter.dataVendaFinal){
            Mensagem = "Data Inicial não pode ser maior do que a Data Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        binter.clienteInicial      = Integer.parseInt(txt_clienteInicial.getText());
        binter.clienteFinal        = Integer.parseInt(txt_clienteFinal.getText());
        if(binter.clienteInicial > binter.clienteFinal){
            Mensagem = "Cliente Inicial não pode ser maior do que Cliente Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaVenda();
    }
    
    private void PegaVenda(){
        sql = "select \n"
            + "   idVenda, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoVenda, \n"
            + "   codigoUsuario, \n"
            + "   codigoCliente, \n"
            + "   codigoComputador, \n"
            + "   dataVenda, \n"
            + "   horaVenda, \n"
            + "   status \n"
            + "from \n"
            + "   tb_vendas where idEmpresa = " + parametrosNS.be.IdEmpresa + " and "
            + "codigoVenda between "        + binter.VendaInicial       + " and "   + binter.VendaFinal     + " and "
            + "codigoUsuario between "      + binter.VendedorInicial    + " and "   + binter.VendedorFinal  + " and "
            + "codigoCliente between "      + binter.clienteInicial     + " and "   + binter.clienteFinal   + " and "
            + "dataVenda between "          + binter.dataVendaInicial   + " and "   + binter.dataVendaFinal + ";";
        tbVendas.setNumRows(0);
        dadosVendas.clear();
        dadosVendas = parametrosNS.dao.Consulta(sql);
        PreencherTabelaVendas();
    }
    
    private void PreencherTabelaVendas(){
        tabela_vendas.getColumnModel().getColumn(0).setPreferredWidth(80);   //codigo da venda
        tabela_vendas.getColumnModel().getColumn(1).setPreferredWidth(90);   //nome do usuário
        tabela_vendas.getColumnModel().getColumn(2).setPreferredWidth(280);  //nome e código do cliente
        tabela_vendas.getColumnModel().getColumn(3).setPreferredWidth(135);  //data da venda
        tabela_vendas.getColumnModel().getColumn(4).setPreferredWidth(90);   //hora da venda
        tabela_vendas.getColumnModel().getColumn(5).setPreferredWidth(80);  //status da venda
        tabela_vendas.getColumnModel().getColumn(6).setPreferredWidth(80);   //quantidade de itens
        tabela_vendas.getColumnModel().getColumn(7).setPreferredWidth(120);  //soma do valor total dos itens
        
        QtdDeVendas         = 0;
        QtdCancelados       = 0;
        ValorTotalDasVendas = 0;
        QtdTotalDeItens     = 0;
        
        for(int i = 0; i < dadosVendas.size(); i++){
            bv = new BeanVendas();
            if(dadosVendas.get(i).get(0) != null){
                bv.idVenda          = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(0)));
            }
            if(dadosVendas.get(i).get(1) != null){
                bv.idEmpresa        = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(1)));
            }
            if(dadosVendas.get(i).get(2) != null){
                bv.codigoGrupo      = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(2)));
            }
            if(dadosVendas.get(i).get(3) != null){
                bv.codigoEmpresa    = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(3)));
            }
            if(dadosVendas.get(i).get(4) != null){
                bv.codigoVenda      = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(4)));
            }
            if(dadosVendas.get(i).get(5) != null){
                bv.codigoUsuario    = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(5)));
            }
            if(dadosVendas.get(i).get(6) != null){
                bv.codigoCliente    = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(6)));
            }
            if(dadosVendas.get(i).get(7) != null){
                bv.codigoComputador = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(7)));
            }
            if(dadosVendas.get(i).get(8) != null){
                bv.dataVenda        =                    String.valueOf(dadosVendas.get(i).get(8));
            }
            if(dadosVendas.get(i).get(9) != null){
                bv.horaVenda        =                    String.valueOf(dadosVendas.get(i).get(9));
            }
            if(dadosVendas.get(i).get(10) != null){
                bv.status           = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(10)));
            }
            
            if(check_IgnorarCanceladas  .isSelected()){if(bv.status == 1){QtdDeVendas = QtdDeVendas - 1;continue;}}
            if(check_IgnorarFinalizadas .isSelected()){if(bv.status == 2){QtdDeVendas = QtdDeVendas - 1;continue;}}
            
            bu.codigoUsuario = bv.codigoUsuario;
            PegaUsuario();
            
            bc.codigoCliente = bv.codigoCliente;
            PegaCliente();
            
            switch(bv.status){
                case 0: StatusVenda = "Pendente"  ; break;
                case 1: StatusVenda = "Cancelada" ; QtdCancelados = QtdCancelados + 1; break;
                case 2: StatusVenda = "Finalizada"; break;
            }
            
            bvi.idEmpresa       = bv.idEmpresa;
            bvi.codigoGrupo     = bv.codigoGrupo;
            bvi.codigoEmpresa   = bv.codigoEmpresa;
            bvi.codigoVenda     = bv.codigoVenda;
            PegaVendaItens("N");
            
            ValorTotalDasVendas = ValorTotalDasVendas   + ValorDaVenda;
            QtdTotalDeItens     = QtdTotalDeItens       + QtdDeItens;
            
            QtdDeVendas         = QtdDeVendas + 1;
            
            bv.dataVenda        = invdata.inverterData(bv.dataVenda, 1);
            
            tbVendas.addRow(new Object [] {fc.FormataCampo(String.valueOf(bv.codigoVenda), 9, 0), bu.codigoUsuario + "-" + bu.usuario, fc.FormataCampo(String.valueOf(bv.codigoCliente), 5, 0) + " - " + bc.nome, bv.dataVenda, bv.horaVenda, StatusVenda, QtdDeItens, TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorDaVenda), 0)});
        }
//        bt_imprimir.setEnabled(false);
        bt_exportar.setEnabled(false);
        if(tabela_vendas.getRowCount() > 0){
            ConvTabOSeVenBol.numeroDaColuna = 5;
            for(int i = 0; i < tabela_vendas.getColumnCount(); i++){
                tabela_vendas.getColumnModel().getColumn(i).setCellRenderer(ConvTabOSeVenBol);
            }
            tabela_vendas.updateUI();
            
//            bt_imprimir.setEnabled(true);
            bt_exportar.setEnabled(true);
            tbVendas.addRow(new Object[] {"", "Totais", "", "", "", "", String.valueOf(QtdTotalDeItens), TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotalDasVendas), 0)});
        }
        txt_qtdVendas.setText(String.valueOf(QtdDeVendas));
        txt_qtdItensVenda.setText(String.valueOf(QtdTotalDeItens));
        txt_valorTotalVendas.setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotalDasVendas), 0));
        txt_totalCanceladas.setText(String.valueOf(QtdCancelados));
    }
    
    private void PegaVendaItens(String AtualizaEstoque){
        sql = "select * from tb_vendas_itens where idEmpresa = " + bvi.idEmpresa + " and codigoVenda = " + bvi.codigoVenda + ";";
        dadosVendasItens.clear();
        dadosVendasItens = parametrosNS.dao.Consulta(sql);
        if(dadosVendasItens.isEmpty()){
            Mensagem = "Não foram encontrados itens para a Venda n°" + bv.codigoVenda + "!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosVendaItens(AtualizaEstoque);
    }
    
    private void PegaDadosVendaItens(String AtualizaEstoque){
        if(AtualizaEstoque.equals("N")){
            QtdDeItens              = 0;
            ValorDaVenda            = 0;
        }
        for(int i = 0; i < dadosVendasItens.size(); i++){
            bvi = new BeanVendasItens();
            if(dadosVendasItens.get(i).get(0)  != null){bvi.idVendaItem         = Integer.parseInt(  String.valueOf(dadosVendasItens.get(i).get(0)));}
            if(dadosVendasItens.get(i).get(1)  != null){bvi.idEmpresa           = Integer.parseInt(  String.valueOf(dadosVendasItens.get(i).get(1)));}
            if(dadosVendasItens.get(i).get(2)  != null){bvi.codigoGrupo         = Integer.parseInt(  String.valueOf(dadosVendasItens.get(i).get(2)));}
            if(dadosVendasItens.get(i).get(3)  != null){bvi.codigoEmpresa       = Integer.parseInt(  String.valueOf(dadosVendasItens.get(i).get(3)));}
            if(dadosVendasItens.get(i).get(4)  != null){bvi.codigoVenda         = Integer.parseInt(  String.valueOf(dadosVendasItens.get(i).get(4)));}
            if(dadosVendasItens.get(i).get(5)  != null){bvi.codigoVendaItem     = Integer.parseInt(  String.valueOf(dadosVendasItens.get(i).get(5)));}
            if(dadosVendasItens.get(i).get(6)  != null){bvi.codigoProduto       = Integer.parseInt(  String.valueOf(dadosVendasItens.get(i).get(6)));}
            if(dadosVendasItens.get(i).get(7)  != null){bvi.valorUnitario       = Double.parseDouble(String.valueOf(dadosVendasItens.get(i).get(7)));}
            if(dadosVendasItens.get(i).get(8)  != null){bvi.quantidade          = Double.parseDouble(String.valueOf(dadosVendasItens.get(i).get(8)));}
            if(dadosVendasItens.get(i).get(9)  != null){bvi.valorSubtotal       = Double.parseDouble(String.valueOf(dadosVendasItens.get(i).get(9)));}
            if(dadosVendasItens.get(i).get(10) != null){bvi.tipoDesconto        = Integer.parseInt(  String.valueOf(dadosVendasItens.get(i).get(10)));}
            if(dadosVendasItens.get(i).get(11) != null){bvi.valorDesconto       = Double.parseDouble(String.valueOf(dadosVendasItens.get(i).get(11)));}
            if(dadosVendasItens.get(i).get(12) != null){bvi.valorTotal          = Double.parseDouble(String.valueOf(dadosVendasItens.get(i).get(12)));}
            
            ValorDaVenda        = ValorDaVenda          + bvi.valorTotal;
            QtdDeItens          = QtdDeItens            + 1;
            
            if(AtualizaEstoque.equals("N")){continue;}
            
            bp.codigoProduto = bvi.codigoProduto;
            PegaProduto();
            
            bp.quantidadeAtual = bp.quantidadeAtual + bvi.quantidade;
            AtualizaEstoque();
        }
    }

    private void PegaUsuario(){
        bu.usuario = "";
        sql = "select usuario from tb_usuarios where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
        dadosUsuarios.clear();
        dadosUsuarios = parametrosNS.dao.Consulta(sql);
        if(dadosUsuarios.isEmpty()){
            Mensagem = "Usuario " + bu.codigoUsuario + " não encontrato!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosUsuario();
    }
    
    private void PegaDadosUsuario(){
        for(int i = 0; i < dadosUsuarios.size(); i++){
            bu.usuario = String.valueOf(dadosUsuarios.get(i).get(0));
        }
    }
    
    private void PegaCliente(){
        if(bc.codigoCliente == 99999){
            bc.nome = "Cliente Padrão";
            return;
        }
        bc.nome = "";
        sql = "select idCliente, idEmpresa, codigoGrupo, codigoEmpresa, codigoCliente, nome from tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCliente = " + bc.codigoCliente + "";
        dadosCliente.clear();
        dadosCliente = parametrosNS.dao.Consulta(sql);
        if(dadosCliente.isEmpty()){
            Mensagem = "Cliente " + bc.codigoCliente + " não encontrato!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosCliente();
    }
    
    private void PegaDadosCliente(){
        for(int i = 0; i < dadosCliente.size(); i++){
            bc = new BeanClientes();
            bc.idCliente            = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(0)));
            bc.idEmpresa            = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(1)));
            bc.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(2)));
            bc.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(3)));
            bc.codigoCliente        = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(4)));
            bc.nome                 =                    String.valueOf(dadosCliente.get(i).get(5));
        }
    }
    
    public String getRetorno(){
        return retorno;
    }
    
    private void PegaProduto(){
        sql = "select \n"
            + "   idProdutos, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoProduto, \n"
            + "   descricaoProduto, \n"
            + "   valorDeCompra, \n"
            + "   valorDeVenda, \n"
            + "   codigoFabricante, \n"
            + "   quantidadeMinima, \n"
            + "   quantidadeIdeal, \n"
            + "   quantidadeAutal \n"
            + "from \n"
            + "   tb_produtos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoProduto = " + bp.codigoProduto + ";";
        dadosProdutos.clear();
        dadosProdutos = parametrosNS.dao.Consulta(sql);
        if(dadosProdutos.isEmpty()){
            Mensagem = "Produto de código " + bp.codigoProduto + " relacionado a venda n°" + bv.codigoVenda + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosProdutos();
    }
    
    private void PegaDadosProdutos(){
        for (int i = 0; i < dadosProdutos.size(); i++) {
            bp  = new BeanProdutos();
            if(dadosProdutos.get(i).get(0) != null){
                bp.idProdutos               = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(0)));
            }
            if(dadosProdutos.get(i).get(1) != null){
                bp.idEmpresa                = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(1)));
            }
            if(dadosProdutos.get(i).get(2) != null){
                bp.codigoGrupo              = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(2)));
            }
            if(dadosProdutos.get(i).get(3) != null){
                bp.codigoEmpresa            = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(3)));
            }
            if(dadosProdutos.get(i).get(4) != null){
                bp.codigoProduto            = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(4)));
            }
            if(dadosProdutos.get(i).get(4) != null){
                bp.descricaoProduto         =                    String.valueOf(dadosProdutos.get(i).get(5));
            }
            if(dadosProdutos.get(i).get(6) != null){
                bp.valorDeCompra            = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(6)));
            }
            if(dadosProdutos.get(i).get(7) != null){
                bp.valorDeVenda             = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(7)));
            }
            if(dadosProdutos.get(i).get(8) != null){
                bp.codigoFabricante         = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(8)));
            }
            if(dadosProdutos.get(i).get(9) != null){
                bp.quantidadeMinima         = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(9)));
            }
            if(dadosProdutos.get(i).get(10) != null){
                bp.quantidadeIdeal          = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(10)));
            }
            if(dadosProdutos.get(i).get(11) != null){
                bp.quantidadeAtual          = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(11)));
            }
        }
    }
    
    private void AtualizaEstoque(){
        sql = "update tb_produtos set quantidadeAtual = " + bp.quantidadeAtual + " where idProdutos = " + bp.idProdutos + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(sqlstate.equals("00000")){
            return;
        }
        Mensagem = "Erro ao atualizar estoque do produto " + bp.codigoProduto + "!";
        new MostraMensagem(Mensagem);
    }
    
    private void Imprimir(){
        try{
            stmt = parametrosNS.con.prepareStatement(sql);
            rs   = stmt.executeQuery();
            js   = new JRResultSetDataSource(rs);
            
            hm.put("nomeEmpresa", parametrosNS.be.nomeEmpresa);
            hm.put("enderecoEmpresa", parametrosNS.be.enderecoEmpresa + ", " + parametrosNS.be.numeroEmpresa);
            hm.put("cnpjEmpresa", FCpfCnpj.FormataCPFCNPJ(parametrosNS.be.cnpjEmpresa));
            hm.put("logotipoEmpresa", parametrosNS.bge.pastaImagemLogotipo + "/LOGOTIPO." + parametrosNS.bge.extensaoImagemLogotipo);
            hm.put("bairroEmpresa", parametrosNS.be.cidadeEmpresa + ", " + parametrosNS.be.ufEmpresa + ", " + parametrosNS.be.bairroEmpresa);
            hm.put("cepEmpresa", parametrosNS.be.cepEmpresa);
            hm.put("codigoVenda", bv.codigoVenda);
            
            jpv     = bpar.pastaRelatorios + "/RelatorioDeVendasGeral.jasper";
            
            jpp     = JasperFillManager.fillReport(jpv, hm, js);
            JasperViewer.viewReport(jpp, false);
        }catch(Exception erro){
            Mensagem = "Erro ao imprimir: " + erro.getMessage();
            new MostraMensagem(Mensagem);
        }
    }
    
    
}
