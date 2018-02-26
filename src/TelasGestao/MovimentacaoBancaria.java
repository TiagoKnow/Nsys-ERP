package TelasGestao;

import Beans.BeanBoletos;
import Beans.BeanBoletosInstrucoes;
import Beans.BeanClientes;
import Beans.BeanContaCorrente;
import Beans.BeanDespesas;
import Beans.BeanDespesasTipo;
import Beans.BeanIntervalos;
import Beans.BeanMovimentacaoBancaria;
import Beans.BeanOrdemServico;
import Beans.BeanParametros;
import Beans.BeanParametrosGestao;
import Beans.BeanRecibos;
import Beans.BeanRecibosDetalhes;
import Beans.BeanRecibosPagamentos;
import Beans.BeanServicos;
import Beans.BeanVendas;
import Beans.BeanVendasPagamentos;
import BeansNS.BeanBanco;
import FuncoesInternas.AjustarLarguraColunas;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.ConverteValorDigitadoEmDouble;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.TabelaZebra;
import FuncoesInternas.TestarData;
import FuncoesInternas.TransformaValorStringeDouble;
import Parametros.parametrosNS;
import groovy.inspect.swingui.TableSorter;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/*
 @author Paulo
 */
public class MovimentacaoBancaria extends javax.swing.JFrame {
    //String
    String sql                          = "";
    String sqlstate                     = "";
    String fatal                        = "";
    String mensagem                     = "";
    String modulo                       = "";
    String preenchimento                = "";
    String preenchimentoDespesa         = "";
    String preenchimentoBoletos         = "";
    String preenchimentoOrdemServico    = "";
    String valorTotalSaldoTexto         = "";
    String valorTotalSaldoAnteriorTexto = "";
    String nomeBancoOrigem              = "";
    String agenciaOrigem                = "";
    String contaCorrenteOrigem          = "";
    String nomeBancoDestino             = "";
    String agenciaDestino               = "";
    String descricaoTipoTransferencia   = "";
    
    //int
    int    codigoContaCorrente = 0;
    
    //Double
    double valorSaida              = 0;
    double valorEntrada            = 0;
    double valorTotalSaldoAnterior = 0;
    double valorTotalSaldo         = 0;
    
    //Beans
    BeanBanco                bb      = new BeanBanco();
    BeanBanco                bbo     = new BeanBanco();
    BeanBanco                bbd     = new BeanBanco();
    BeanBoletos              bbol    = new BeanBoletos();
    BeanBoletosInstrucoes    bbi     = new BeanBoletosInstrucoes();
    BeanClientes             bc      = new BeanClientes();
    BeanContaCorrente        bcc     = new BeanContaCorrente();
    BeanContaCorrente        bcco    = new BeanContaCorrente();
    BeanContaCorrente        bccd    = new BeanContaCorrente();
    BeanDespesas             bd      = new BeanDespesas();
    BeanDespesasTipo         bdt     = new BeanDespesasTipo();
    BeanIntervalos           binter  = new BeanIntervalos();
    BeanMovimentacaoBancaria bmb     = new BeanMovimentacaoBancaria();
    BeanOrdemServico         bos     = new BeanOrdemServico();
    BeanParametros           bpar    = new BeanParametros();
    BeanParametrosGestao     bparges = new BeanParametrosGestao();
    BeanRecibos              brec    = new BeanRecibos();
    BeanRecibosDetalhes      brecd   = new BeanRecibosDetalhes();
    BeanRecibosPagamentos    brecp   = new BeanRecibosPagamentos();
    BeanServicos             bser    = new BeanServicos();
    BeanVendas               bv      = new BeanVendas();
    BeanVendasPagamentos     bvp     = new BeanVendasPagamentos();
    
    //Vetores
    ArrayList<ArrayList> dadosMovimentacaoBancaria = new ArrayList();
    ArrayList<BeanMovimentacaoBancaria> ListMovimentacaoBancaria  = new ArrayList();
    ArrayList<BeanMovimentacaoBancaria> dadosJasper  = new ArrayList();
    
    ArrayList<ArrayList> dadosBanco             = new ArrayList();
    ArrayList<ArrayList> dadosBoletos           = new ArrayList();
    ArrayList<ArrayList> dadosDespesas          = new ArrayList();
    ArrayList<ArrayList> dadosContaCorrente     = new ArrayList();
    ArrayList<ArrayList> dadosDespesasTipo      = new ArrayList();
    ArrayList<ArrayList> dadosOrdemServico      = new ArrayList();
    ArrayList<ArrayList> dadosParametros        = new ArrayList();
    ArrayList<ArrayList> dadosParametrosGestao  = new ArrayList();
    ArrayList<ArrayList> dadosRecibos           = new ArrayList();
    ArrayList<ArrayList> dadosRecibosPagamentos = new ArrayList();
    ArrayList            dadosValores           = new ArrayList();
    ArrayList<ArrayList> dadosValoresCompletos  = new ArrayList();
    ArrayList<ArrayList> dadosVendas            = new ArrayList();
    
    //Especiais
    DefaultTableModel             TableMovimentacao;
    TableSorter                   sorter;
    FormataCampo                  fc      = new FormataCampo();
    TestarData                    Test    = new TestarData();
    TransformaValorStringeDouble  TransStrDou     = new TransformaValorStringeDouble();
    NumberFormat                  nf      = new DecimalFormat("R$ ###,##0.00");
    ConverteValorDigitadoEmDouble conv    = new ConverteValorDigitadoEmDouble();
    CapturarDataHora              cdh     = new CapturarDataHora();
    InverterData                  invdata = new InverterData();
    TabelaZebra                   TableZe = new TabelaZebra();
    
    //Especiais para Relatório
    String        jpv         = "";
    JasperPrint   jpp         = null;
    HashMap       hm          = new HashMap();
    
    //Especiais
    BufferedImage buffImg;
    ImageIcon     imgIcon;
    Image         img;
    
    public MovimentacaoBancaria(){
        initComponents();
    }
    
    private void InicializaCampos(){
        txt_dataInicial.setText(fc.FormataCampo("", 8, 0));
        txt_dataFinal  .setText(cdh.CapturarData());
        
        combo_tipo.setSelectedIndex(0);
        
        bt_processa.setEnabled(false);
        
        TableMovimentacao = (DefaultTableModel)tabela_movimentacaoDespesa.getModel();
        TableMovimentacao.setNumRows(0);
        
//        PegaParametros();
        PegaParametrosGestao();
        
        PegaContaCorrente("");
    }
    
//    private void PegaParametros(){
//        sql = "select * from tb_parametros where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
//        dadosParametros.clear();
//        dadosParametros = parametrosNS.dao.Consulta(sql);
//        if(dadosParametros.isEmpty()){
//            bt_imprimir.setVisible(false);
//            return;
//        }
//        PegaDadosParametros();
//    }
//    
//    private void PegaDadosParametros(){
//        for(int i = 0; i < dadosParametros.size(); i++){
//            bpar.idParametros       = Integer.parseInt(String.valueOf(dadosParametros.get(i).get(0)));
//            bpar.idEmpresa          = Integer.parseInt(String.valueOf(dadosParametros.get(i).get(1)));
//            bpar.codigoGrupo        = Integer.parseInt(String.valueOf(dadosParametros.get(i).get(2)));
//            bpar.codigoEmpresa      = Integer.parseInt(String.valueOf(dadosParametros.get(i).get(3)));
//            bpar.pastaRelatorios    =                  String.valueOf(dadosParametros.get(i).get(4));
//        }
//    }
    
    private void PegaParametrosGestao(){
        sql = "select * from tb_parametrosgestao where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosParametrosGestao.clear();
        dadosParametrosGestao = parametrosNS.dao.Consulta(sql);
        if(dadosParametrosGestao.isEmpty()){
            mensagem = "Não foram encontrados parâmetros para gestão administrativa!";
            mostraMensagem();
            return;
        }
        PegaDadosParametrosGestao();
    }
    
    private void PegaDadosParametrosGestao(){
        for(int i = 0; i < dadosParametrosGestao.size(); i++){
            if(dadosParametrosGestao.get(i).get(0) != null){bparges.idParametrosGestao              = Integer.parseInt(String.valueOf(dadosParametrosGestao.get(i).get(0)));}
            if(dadosParametrosGestao.get(i).get(1) != null){bparges.idEmpresa                       = Integer.parseInt(String.valueOf(dadosParametrosGestao.get(i).get(1)));}
            if(dadosParametrosGestao.get(i).get(2) != null){bparges.codigoGrupo                     = Integer.parseInt(String.valueOf(dadosParametrosGestao.get(i).get(2)));}
            if(dadosParametrosGestao.get(i).get(3) != null){bparges.codigoEmpresa                   = Integer.parseInt(String.valueOf(dadosParametrosGestao.get(i).get(3)));}
            if(dadosParametrosGestao.get(i).get(4) != null){bparges.dataGestao                      =                  String.valueOf(dadosParametrosGestao.get(i).get(4));}
            if(dadosParametrosGestao.get(i).get(5) != null){bparges.codigoContaCorrenteBoleto       = Integer.parseInt(String.valueOf(dadosParametrosGestao.get(i).get(5)));}
            if(dadosParametrosGestao.get(i).get(6) != null){bparges.codigoContaCorrenteOrdemServico = Integer.parseInt(String.valueOf(dadosParametrosGestao.get(i).get(6)));}
            if(dadosParametrosGestao.get(i).get(7) != null){bparges.codigoContaCorrenteRecibo       = Integer.parseInt(String.valueOf(dadosParametrosGestao.get(i).get(7)));}
            if(dadosParametrosGestao.get(i).get(8) != null){bparges.codigoContaCorrenteVenda        = Integer.parseInt(String.valueOf(dadosParametrosGestao.get(i).get(8)));}
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_dataInicial = new javax.swing.JFormattedTextField();
        txt_dataFinal = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        combo_tipo = new javax.swing.JComboBox<>();
        combo_contaCorrente = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_movimentacaoDespesa = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txt_saldoAnterior = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_saldoFinal = new javax.swing.JTextField();
        bt_processa = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        bt_imprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movimentação Bancária");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Intervalos de Pesquisa");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Conta Corrente:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Datas:");

        try {
            txt_dataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Inicial");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Final");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Tipo:");

        combo_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ambas", "Despesas", "Transferências" }));

        combo_contaCorrente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_contaCorrenteItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_dataInicial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_dataFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(combo_contaCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, jLabel5, txt_dataFinal, txt_dataInicial});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(combo_contaCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(combo_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {combo_tipo, jLabel3, jLabel4, jLabel5, jLabel7, txt_dataFinal, txt_dataInicial});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {combo_contaCorrente, jLabel2});

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Movimentos");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_movimentacaoDespesa.setAutoCreateRowSorter(true);
        tabela_movimentacaoDespesa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_movimentacaoDespesa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Codigo", "Módulo", "Descrição/Cliente", "Pagamento", "Tipo/Detalhes/Serviços", "", "Banco de Origem", "Origem", "Banco de Destino", "Destino", "Valor de Entrada", "Valor de Saída", "Saldo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_movimentacaoDespesa.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_movimentacaoDespesa.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabela_movimentacaoDespesa);

        jLabel8.setText("Saldo Inicial:");

        txt_saldoAnterior.setEditable(false);
        txt_saldoAnterior.setFocusable(false);

        jLabel9.setText("Saldo Final:");

        txt_saldoFinal.setEditable(false);
        txt_saldoFinal.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1400, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_saldoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txt_saldoAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_saldoAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_saldoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel8, txt_saldoAnterior});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel9, txt_saldoFinal});

        bt_processa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/1280454766_system-software-update.png"))); // NOI18N
        bt_processa.setText("Processa");
        bt_processa.setEnabled(false);
        bt_processa.setFocusable(false);
        bt_processa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_processaActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        jButton3.setText("Sair");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        bt_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/print.png"))); // NOI18N
        bt_imprimir.setText("Imprimir");
        bt_imprimir.setEnabled(false);
        bt_imprimir.setFocusable(false);
        bt_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_processa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_imprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
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
                    .addComponent(bt_processa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(bt_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_imprimir, bt_processa, jButton3});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        InicializaCampos();
    }//GEN-LAST:event_formWindowOpened

    private void bt_processaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_processaActionPerformed
        RemoveRegistrosUltimaConsulta();
    }//GEN-LAST:event_bt_processaActionPerformed

    private void txt_dataInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataInicialFocusGained
        txt_dataInicial.setSelectionStart(0);
        txt_dataInicial.setSelectionEnd  (txt_dataInicial.getText().length());
    }//GEN-LAST:event_txt_dataInicialFocusGained

    private void txt_dataInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataInicialFocusLost
        txt_dataInicial.setText(fc.FormataCampo(txt_dataInicial.getText(), 10, 2));
    }//GEN-LAST:event_txt_dataInicialFocusLost

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

    private void txt_dataFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataFinalFocusGained
        txt_dataFinal.setSelectionStart(0);
        txt_dataFinal.setSelectionEnd  (txt_dataFinal.getText().length());
    }//GEN-LAST:event_txt_dataFinalFocusGained

    private void txt_dataFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataFinalFocusLost
        txt_dataFinal.setText(fc.FormataCampo(txt_dataFinal.getText(), 10, 2));
    }//GEN-LAST:event_txt_dataFinalFocusLost

    private void txt_dataFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            combo_tipo.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataFinal.setText("99999999");
            combo_tipo.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataFinalKeyPressed

    private void combo_contaCorrenteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_contaCorrenteItemStateChanged
        TableMovimentacao.setNumRows  (0);
        bt_imprimir      .setEnabled  (false);
        bt_imprimir      .setFocusable(false);
        if(combo_contaCorrente.getSelectedIndex() == 0)
            return;
        if(combo_contaCorrente.getSelectedIndex() == 1){
            codigoContaCorrente = 0;
            bb  = new BeanBanco();
            bcc = new BeanContaCorrente();
            bt_processa.setEnabled(true);
            return;
        }
        bcc.codigoContaCorrente = Integer.parseInt(String.valueOf(combo_contaCorrente.getSelectedItem()).substring(0, 6));
        preenchimento   = " and cc.codigoContaCorrente = " + bcc.codigoContaCorrente;
        PegaContaCorrente("Z");
    }//GEN-LAST:event_combo_contaCorrenteItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void bt_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimirActionPerformed
        ImprimirRelatorioMovimentacaoBancaria();
    }//GEN-LAST:event_bt_imprimirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_imprimir;
    private javax.swing.JButton bt_processa;
    private javax.swing.JComboBox<String> combo_contaCorrente;
    private javax.swing.JComboBox<String> combo_tipo;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_movimentacaoDespesa;
    private javax.swing.JFormattedTextField txt_dataFinal;
    private javax.swing.JFormattedTextField txt_dataInicial;
    private javax.swing.JTextField txt_saldoAnterior;
    private javax.swing.JTextField txt_saldoFinal;
    // End of variables declaration//GEN-END:variables
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    private void RemoveRegistrosUltimaConsulta(){
        sql = "delete from tb_movimentacaobancaria where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and codigoUsuario = " + parametrosNS.bu.codigoUsuario + ";";
        sqlstate = parametrosNS.dao.ExcluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao limpar tabela temporária.";
            mostraMensagem();
            fatal = "S";
            return;
        }
        PegaContaCorrente("P");
    }
    
    private void PegaContaCorrente(String tipo){
        if(!tipo.equals("") && !tipo.equals("P"))
            if(bcc.codigoContaCorrente == 0)
                return;
        sql = "select \n"
            + "   nsban.id, \n"
            + "   nsban.nomeBanco, \n"
            + "   nsban.codigoBanco, \n"
            + "   cc.idContaCorrente, \n"
            + "   cc.idEmpresa, \n"
            + "   cc.codigoGrupo, \n"
            + "   cc.codigoEmpresa, \n"
            + "   cc.codigoContaCorrente, \n"
            + "   cc.numeroAgencia, \n"
            + "   cc.digitoVerificadorAgencia, \n"
            + "   cc.numeroContaCorrente, \n"
            + "   cc.digitoVerificador, \n"
            + "   cc.descricao \n"
            + "from \n"
            + "   tb_contacorrente cc \n"
            + "   inner join ns_bancos nsban on (cc.idBanco = nsban.id) \n"
            + "      where cc.idEmpresa = " + parametrosNS.be.IdEmpresa + preenchimento + " order by cc.codigoContaCorrente asc;";
        dadosContaCorrente.clear();
        dadosContaCorrente = parametrosNS.dao.Consulta(sql);
        if(dadosContaCorrente.isEmpty()){
            if(tipo.equalsIgnoreCase("O"))
                mensagem = "Conta corrente de Origem não encontrada!";
            if(tipo.equalsIgnoreCase("D"))
                mensagem = "Conta corrente de Destino não encontrada!";
            if(tipo.equalsIgnoreCase("Z"))
                mensagem = "Conta corrente não encontrada!";
            if(!tipo.equals(""))
                new MostraMensagem(mensagem);
            return;
        }
        PegaDadosContaCorrente(tipo);
    }
    
    private void PegaDadosContaCorrente(String tipo){
        if(tipo.equalsIgnoreCase("O")){
            bbo     = new BeanBanco();
            bcco    = new BeanContaCorrente();
            if(dadosContaCorrente.get(0).get(0)  != null){bbo.idBanco                     = Integer.parseInt(String.valueOf(dadosContaCorrente.get(0).get(0)));}
            if(dadosContaCorrente.get(0).get(1)  != null){bbo.nomeBanco                   =                  String.valueOf(dadosContaCorrente.get(0).get(1));}
            if(dadosContaCorrente.get(0).get(2)  != null){bbo.codigoBanco                 =                  String.valueOf(dadosContaCorrente.get(0).get(2));}
            if(dadosContaCorrente.get(0).get(3)  != null){bcco.idContaCorrente            = Integer.parseInt(String.valueOf(dadosContaCorrente.get(0).get(3)));}
            if(dadosContaCorrente.get(0).get(4)  != null){bcco.idEmpresa                  = Integer.parseInt(String.valueOf(dadosContaCorrente.get(0).get(4)));}
            if(dadosContaCorrente.get(0).get(5)  != null){bcco.codigoGrupo                = Integer.parseInt(String.valueOf(dadosContaCorrente.get(0).get(5)));}
            if(dadosContaCorrente.get(0).get(6)  != null){bcco.codigoEmpresa              = Integer.parseInt(String.valueOf(dadosContaCorrente.get(0).get(6)));}
            if(dadosContaCorrente.get(0).get(7)  != null){bcco.codigoContaCorrente        = Integer.parseInt(String.valueOf(dadosContaCorrente.get(0).get(7)));}
            if(dadosContaCorrente.get(0).get(8)  != null){bcco.numeroAgencia              = Integer.parseInt(String.valueOf(dadosContaCorrente.get(0).get(8)));}
            if(dadosContaCorrente.get(0).get(9)  != null){bcco.digitoVerificadorAgencia   = Integer.parseInt(String.valueOf(dadosContaCorrente.get(0).get(9)));}
            if(dadosContaCorrente.get(0).get(10) != null){bcco.numeroContaCorrente        = Integer.parseInt(String.valueOf(dadosContaCorrente.get(0).get(10)));}
            if(dadosContaCorrente.get(0).get(11) != null){bcco.digitoVerificador          = Integer.parseInt(String.valueOf(dadosContaCorrente.get(0).get(11)));}
            if(dadosContaCorrente.get(0).get(12) != null){bcco.descricao                  =                  String.valueOf(dadosContaCorrente.get(0).get(12));}
            return;
        }
        if(tipo.equalsIgnoreCase("D")){
            bbd     = new BeanBanco();
            bccd    = new BeanContaCorrente();
            if(dadosContaCorrente.get(0).get(0)  != null){bbd.idBanco                     = Integer.parseInt(String.valueOf(dadosContaCorrente.get(0).get(0)));}
            if(dadosContaCorrente.get(0).get(1)  != null){bbd.nomeBanco                   =                  String.valueOf(dadosContaCorrente.get(0).get(1));}
            if(dadosContaCorrente.get(0).get(2)  != null){bbd.codigoBanco                 =                  String.valueOf(dadosContaCorrente.get(0).get(2));}
            if(dadosContaCorrente.get(0).get(3)  != null){bccd.idContaCorrente            = Integer.parseInt(String.valueOf(dadosContaCorrente.get(0).get(3)));}
            if(dadosContaCorrente.get(0).get(4)  != null){bccd.idEmpresa                  = Integer.parseInt(String.valueOf(dadosContaCorrente.get(0).get(4)));}
            if(dadosContaCorrente.get(0).get(5)  != null){bccd.codigoGrupo                = Integer.parseInt(String.valueOf(dadosContaCorrente.get(0).get(5)));}
            if(dadosContaCorrente.get(0).get(6)  != null){bccd.codigoEmpresa              = Integer.parseInt(String.valueOf(dadosContaCorrente.get(0).get(6)));}
            if(dadosContaCorrente.get(0).get(7)  != null){bccd.codigoContaCorrente        = Integer.parseInt(String.valueOf(dadosContaCorrente.get(0).get(7)));}
            if(dadosContaCorrente.get(0).get(8)  != null){bccd.numeroAgencia              = Integer.parseInt(String.valueOf(dadosContaCorrente.get(0).get(8)));}
            if(dadosContaCorrente.get(0).get(9)  != null){bccd.digitoVerificadorAgencia   = Integer.parseInt(String.valueOf(dadosContaCorrente.get(0).get(9)));}
            if(dadosContaCorrente.get(0).get(10) != null){bccd.numeroContaCorrente        = Integer.parseInt(String.valueOf(dadosContaCorrente.get(0).get(10)));}
            if(dadosContaCorrente.get(0).get(11) != null){bccd.digitoVerificador          = Integer.parseInt(String.valueOf(dadosContaCorrente.get(0).get(11)));}
            if(dadosContaCorrente.get(0).get(12) != null){bccd.descricao                  =                  String.valueOf(dadosContaCorrente.get(0).get(12));}
            return;
        }
        
        String nomeBanco     = "";
        String agencia       = "";
        String contaCorrente = "";
        
        if(tipo.equalsIgnoreCase("")){
            combo_contaCorrente.removeAllItems();
            combo_contaCorrente.addItem("----------");
            combo_contaCorrente.addItem("Todos");
        }
        for(int i = 0; i < dadosContaCorrente.size(); i++){
            bb  = new BeanBanco();
            bcc = new BeanContaCorrente();
            if(dadosContaCorrente.get(i).get(0)  != null){bb.idBanco                      = Integer.parseInt(String.valueOf(dadosContaCorrente.get(i).get(0)));}
            if(dadosContaCorrente.get(i).get(1)  != null){bb.nomeBanco                    =                  String.valueOf(dadosContaCorrente.get(i).get(1));}
            if(dadosContaCorrente.get(i).get(2)  != null){bb.codigoBanco                  =                  String.valueOf(dadosContaCorrente.get(i).get(2));}
            if(dadosContaCorrente.get(i).get(3)  != null){bcc.idContaCorrente             = Integer.parseInt(String.valueOf(dadosContaCorrente.get(i).get(3)));}
            if(dadosContaCorrente.get(i).get(4)  != null){bcc.idEmpresa                   = Integer.parseInt(String.valueOf(dadosContaCorrente.get(i).get(4)));}
            if(dadosContaCorrente.get(i).get(5)  != null){bcc.codigoGrupo                 = Integer.parseInt(String.valueOf(dadosContaCorrente.get(i).get(5)));}
            if(dadosContaCorrente.get(i).get(6)  != null){bcc.codigoEmpresa               = Integer.parseInt(String.valueOf(dadosContaCorrente.get(i).get(6)));}
            if(dadosContaCorrente.get(i).get(7)  != null){bcc.codigoContaCorrente         = Integer.parseInt(String.valueOf(dadosContaCorrente.get(i).get(7)));}
            if(dadosContaCorrente.get(i).get(8)  != null){bcc.numeroAgencia               = Integer.parseInt(String.valueOf(dadosContaCorrente.get(i).get(8)));}
            if(dadosContaCorrente.get(i).get(9)  != null){bcc.digitoVerificadorAgencia    = Integer.parseInt(String.valueOf(dadosContaCorrente.get(i).get(9)));}
            if(dadosContaCorrente.get(i).get(10) != null){bcc.numeroContaCorrente         = Integer.parseInt(String.valueOf(dadosContaCorrente.get(i).get(10)));}
            if(dadosContaCorrente.get(i).get(11) != null){bcc.digitoVerificador           = Integer.parseInt(String.valueOf(dadosContaCorrente.get(i).get(11)));}
            if(dadosContaCorrente.get(i).get(12) != null){bcc.descricao                   =                  String.valueOf(dadosContaCorrente.get(i).get(12));}
            
            if(!tipo.equalsIgnoreCase("") && !tipo.equalsIgnoreCase("P")){
                codigoContaCorrente = bcc.codigoContaCorrente;
            }
            if(tipo.equalsIgnoreCase("")){
                agencia           = fc.FormataCampo(String.valueOf(bcc.numeroAgencia), 4, 0);
                if(bcc.digitoVerificadorAgencia != 0){
                    agencia      += "-" + String.valueOf(bcc.digitoVerificadorAgencia);
                }
                contaCorrente     = fc.FormataCampo(String.valueOf(bcc.numeroContaCorrente), 5, 0) + "-" + String.valueOf(bcc.digitoVerificador);

                agencia   = agencia  + "   " + contaCorrente;
                nomeBanco = bb.codigoBanco  + " " + bb.nomeBanco;

                PegaBanco();
                
                combo_contaCorrente.addItem(fc.FormataCampo(String.valueOf(bcc.codigoContaCorrente), 6, 0) + " - " + nomeBanco + " - " + agencia + "  " + bcc.descricao);
            }
            if(tipo.equalsIgnoreCase("P")){
                PegaValores();
            }
        }
        if(!tipo.equalsIgnoreCase("")){
            bt_processa.setEnabled(true);
        }
    }
    
    private void PegaBanco(){
        sql = "select * from ns_bancos where id = " + bb.idBanco + ";";
        dadosBanco.clear();
        dadosBanco = parametrosNS.dao.Consulta(sql);
        if(dadosBanco.isEmpty()){
            mensagem = "Erro ao consultar o banco n°" + bb.codigoBanco + "!";
            new MostraMensagem(mensagem);
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
    
    private void PegaValores(){
        binter.dataInicial  = Test.Testa(txt_dataInicial.getText());
        binter.dataFinal    = Test.Testa(txt_dataFinal.getText());
        if(binter.dataInicial > binter.dataFinal){
            mensagem = "Data Inicial não pode ser maior do que a data Final!";
            mostraMensagem();
            return;
        }
        
        PegaSaldoAnterior();
    }
    
    private void PegaSaldoAnterior(){
        fatal = "N";
        valorTotalSaldoAnterior = 0;
//        PegaSaldoAnteriorDespesa();
//        if(combo_contaCorrente.getSelectedIndex() == 1){
//            PegaSaldoAnteriorBoletos();
//            PegaSaldoAnteriorOrdemServico();
//            PegaSaldoAnteriorRecibos();
//            PegaSaldoAnteriorVendas();
//        }
//        if(combo_contaCorrente.getSelectedIndex() > 1){
//            if(codigoContaCorrente == bparges.codigoContaCorrenteBoleto)      {PegaSaldoAnteriorBoletos();}
//            if(codigoContaCorrente == bparges.codigoContaCorrenteOrdemServico){PegaSaldoAnteriorOrdemServico();}
//            if(codigoContaCorrente == bparges.codigoContaCorrenteRecibo)      {PegaSaldoAnteriorRecibos();}
//            if(codigoContaCorrente == bparges.codigoContaCorrenteVenda)       {PegaSaldoAnteriorVendas();}
//        }
        
        PegaDespesas();
        if(fatal.equals("S")){return;}
        PegaBoletos();
        if(fatal.equals("S")){return;}
        PegaOrdemServico();
        if(fatal.equals("S")){return;}
        PegaRecibos();
        if(fatal.equals("S")){return;}
        PegaVendas();
        if(fatal.equals("S")){return;}
        
        valorTotalSaldoAnteriorTexto = TransStrDou.TransformaValorStringeDouble(String.valueOf(valorTotalSaldoAnterior), 0);
        if(valorTotalSaldoAnterior < 0){
            valorTotalSaldoAnterior  = valorTotalSaldoAnterior * (-1);
            valorTotalSaldoAnteriorTexto = "(-) " + nf.format(conv.ConverteValorDigitadoEmDouble(String.valueOf(valorTotalSaldoAnterior), "N"));
            valorTotalSaldoAnterior  = valorTotalSaldoAnterior * (-1);
        }
        txt_saldoAnterior.setText(valorTotalSaldoAnteriorTexto);
        
        valorTotalSaldoTexto = TransStrDou.TransformaValorStringeDouble(String.valueOf(valorTotalSaldo), 0);
        if(valorTotalSaldo < 0){
            valorTotalSaldo  = valorTotalSaldo * (-1);
            valorTotalSaldoTexto = "(-) " + nf.format(conv.ConverteValorDigitadoEmDouble(String.valueOf(valorTotalSaldo), "N"));
            valorTotalSaldo  = valorTotalSaldo * (-1);
        }
        txt_saldoFinal.setText(valorTotalSaldoTexto);
        
        if(tabela_movimentacaoDespesa.getRowCount() > 0){
            bt_imprimir.setEnabled  (true);
            bt_imprimir.setFocusable(true);
//            tabela_movimentacaoDespesa.getRowSorter().toggleSortOrder(5);
        }
        for(int i = 0; i < tabela_movimentacaoDespesa.getColumnCount(); i++){
            tabela_movimentacaoDespesa.getColumnModel().getColumn(i).setCellRenderer(new TabelaZebra());
        }
        tabela_movimentacaoDespesa.updateUI();
    }
    
//    private void PegaSaldoAnteriorDespesa(){
//        bd.codigoContaCorrente          = codigoContaCorrente;
//        bd.codigoContaCorrenteDestino   = codigoContaCorrente;
//        
//        preenchimentoDespesa = "";
//        if(combo_contaCorrente.getSelectedIndex() > 1){
//            preenchimentoDespesa = "(codigoContaCorrente = " + bd.codigoContaCorrente + " or codigoContaCorrenteDestino = " + bd.codigoContaCorrenteDestino + ") and ";
//        }
//        
//        sql = "select "
//            + "   valorPago \n"
//            + "from \n"
//            + "   tb_despesas where idEmpresa = " + parametrosNS.be.IdEmpresa + " and " + preenchimentoDespesa + "dataPagamento < '" + binter.dataInicial + "';";
//        dadosDespesas.clear();
//        dadosDespesas = parametrosNS.dao.Consulta(sql);
//        PegaDadosSaldoAnteriorDespesa();
//    }
    
//    private void PegaDadosSaldoAnteriorDespesa(){
//        double valorDespesaAnterior = 0;
//        double valorLucroAnterior   = 0;
//        
//        for(int i = 0; i < dadosDespesas.size(); i++){
//            bd = new BeanDespesas();
//            if(dadosDespesas.get(i).get(0) != null){
//                bd.valorPago                = Double.parseDouble(String.valueOf(dadosDespesas.get(i).get(0)));
//            }
//            
//            if(bd.codigoContaCorrente           == codigoContaCorrente){valorDespesaAnterior    = valorDespesaAnterior  - bd.valorPago;}
//            if(bd.codigoContaCorrenteDestino    == codigoContaCorrente){valorLucroAnterior      = valorLucroAnterior    + bd.valorPago;}
//        }
//        valorTotalSaldoAnterior     += valorLucroAnterior - valorDespesaAnterior;
//    }
//    
//    private void PegaSaldoAnteriorBoletos(){
//        bbol.codigoContaCorrente    = codigoContaCorrente;
//        
//        preenchimentoBoletos = "";
//        if(combo_contaCorrente.getSelectedIndex() > 1)
//            preenchimentoBoletos = " and bol.codigoContaCorrente = " + bbol.codigoContaCorrente;
//        
//        sql = "select \n" +
//              "  bol.valorPago \n" +
//              "from \n" +
//              "  tb_boletos bol \n" +
//              "  inner join tb_clientes cli on ((bol.idEmpresa = cli.idEmpresa) and (bol.codigoCliente = cli.codigoCliente)) \n" +
//              "  inner join tb_boletos_instrucoes bolin on ((bol.idEmpresa = bolin.idEmpresa) and (bol.codigoBoletoInstrucao = bolin.codigoBoletoInstrucao)) \n" +
//              "    where bol.idEmpresa = " + parametrosNS.be.IdEmpresa + preenchimentoBoletos + " and bol.dataDePagamento < '" + binter.dataInicial + "';";
//        dadosBoletos.clear();
//        dadosBoletos = parametrosNS.dao.Consulta(sql);
//        PegaDadosSaldoAnteriorBoletos();
//    }
//    
//    private void PegaDadosSaldoAnteriorBoletos(){
//        for(int i = 0; i < dadosBoletos.size(); i++){
//            if(dadosBoletos.get(i).get(0) != null){
//                bbol.valorPago              = Double.parseDouble(String.valueOf(dadosBoletos.get(i).get(0)));
//            }
//            
//            valorTotalSaldoAnterior = valorTotalSaldoAnterior + bbol.valorPago;
//        }
//    }
//    
//    private void PegaSaldoAnteriorOrdemServico(){
//        sql = "select \n" +
//              "  os.valorAdiantamento,\n" +
//              "  os.valorMaoDeObra,\n" +
//              "  os.valorPecas,\n" +
//              "  os.valorTerceiros,\n" +
//              "  os.valorOutros,\n" +
//              "  os.valorDeslocamento\n" +
//              "from\n" +
//              "  tb_os os\n" +
//              "  inner join tb_clientes cli on ((os.idEmpresa = cli.idEmpresa) and (os.codigoCliente = cli.codigoCliente))\n" +
//              "    where os.idEmpresa = " + parametrosNS.be.IdEmpresa + " and \n" +
//              "          (os.dataCadastro < '" + binter.dataInicial + "') and \n" +
//              "          (os.valorMaoDeObra <> 0 or os.valorPecas <> 0);";
//        dadosOrdemServico.clear();
//        dadosOrdemServico = parametrosNS.dao.Consulta(sql);
//        PegaDadosSaldoAnteriorOrdemServico();
//    }
//    
//    private void PegaDadosSaldoAnteriorOrdemServico(){
//        for(int i = 0; i < dadosOrdemServico.size(); i++){
//            if(dadosOrdemServico.get(i).get(0) != null){bos.valorAdiantamento = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(0)));}
//            if(dadosOrdemServico.get(i).get(1) != null){bos.valorMaoDeObra    = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(1)));}
//            if(dadosOrdemServico.get(i).get(2) != null){bos.valorPecas        = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(2)));}
//            if(dadosOrdemServico.get(i).get(3) != null){bos.valorTerceiros    = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(3)));}
//            if(dadosOrdemServico.get(i).get(4) != null){bos.valorOutros       = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(4)));}
//            if(dadosOrdemServico.get(i).get(5) != null){bos.valorDeslocamento = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(5)));}
//            
//            valorTotalSaldoAnterior   = bos.valorAdiantamento + bos.valorMaoDeObra + bos.valorPecas + bos.valorTerceiros + bos.valorOutros + bos.valorDeslocamento;
//        }
//    }
//    
//    private void PegaSaldoAnteriorRecibos(){
//        sql = "select \n" +
//              "  sum(recp.valorDoPagamento), \n" +
//              "  sum(recp.trocoDoPagamento) \n" +
//              "from \n" +
//              "	 tb_recibos rec \n" +
//              "  inner join tb_clientes cli on ((rec.idEmpresa = cli.idEmpresa) and (rec.codigoCliente = cli.codigoCliente)) \n" +
//              "  right join tb_recibos_pagamentos recp on ((rec.idEmpresa = recp.idEmpresa) and (rec.codigoRecibo = recp.codigoRecibo)) \n" +
//              "    where rec.idEmpresa = " + parametrosNS.be.IdEmpresa + " and status = 2 and rec.dataRecibo < '" + binter.dataInicial + "';";
//        dadosRecibos.clear();
//        dadosRecibos = parametrosNS.dao.Consulta(sql);
//        PegaDadosSaldoAnteriorRecibos();
//    }
//    
//    private void PegaDadosSaldoAnteriorRecibos(){
//        for(int i = 0; i < dadosRecibos.size(); i++){
//            if(dadosRecibos.get(i).get(0) != null){brecp.valorDoPagamento  = Double.parseDouble(String.valueOf(dadosRecibos.get(i).get(0)));}
//            if(dadosRecibos.get(i).get(1) != null){brecp.trocoDoPagamento  = Double.parseDouble(String.valueOf(dadosRecibos.get(i).get(1)));}
//            
//            valorTotalSaldoAnterior     = brecp.valorDoPagamento - brecp.trocoDoPagamento;
//        }
//    }
//    
//    private void PegaSaldoAnteriorVendas(){
//        sql = "select \n" +
//              "  sum(venp.valorDoPagamento), \n" +
//              "  sum(venp.trocoDoPagamento) \n" +
//              "from \n" +
//              "	 tb_vendas ven \n" +
//              "  inner join tb_clientes cli on ((ven.idEmpresa = cli.idEmpresa) and (ven.codigoCliente = cli.codigoCliente)) \n" +
//              "  inner join tb_vendas_pagamentos venp on ((ven.idEmpresa = venp.idEmpresa) and (ven.codigoVenda = venp.codigoVenda)) \n" +
//              "    where ven.idEmpresa = " + parametrosNS.be.IdEmpresa + " and ven.status = 2 and ven.dataVenda < '" + binter.dataInicial + "' \n" +
//              "      group by ven.idVenda asc \n" +
//              "      order by ven.idVenda asc;";
//        dadosVendas.clear();
//        dadosVendas = parametrosNS.dao.Consulta(sql);
//        PegaDadosSaldoAnteriorVendas();
//    }
//    
//    private void PegaDadosSaldoAnteriorVendas(){
//        for(int i = 0; i < dadosVendas.size(); i++){
//            if(dadosVendas.get(i).get(0) != null){bvp.valorDoPagamento    = Double.parseDouble(String.valueOf(dadosVendas.get(i).get(0)));}
//            if(dadosVendas.get(i).get(1) != null){bvp.trocoDoPagamento    = Double.parseDouble(String.valueOf(dadosVendas.get(i).get(1)));}
//            
//            valorTotalSaldoAnterior    += bvp.valorDoPagamento - bvp.trocoDoPagamento;
//        }
//    }
    
    private void IncluirRegistroMovimentacaoBancaria(){
        bmb.idEmpresa     = parametrosNS.be.IdEmpresa;
        bmb.codigoGrupo   = parametrosNS.bge.CodigoGrupo;
        bmb.codigoEmpresa = parametrosNS.be.CodigoEmpresa;
        bmb.codigoUsuario = parametrosNS.bu.codigoUsuario;
        
        sql = "insert into tb_movimentacaobancaria (idEmpresa, codigoGrupo, codigoEmpresa, codigoUsuario, idTabela, codigoTabela, modulo, descricaoTabela, dataFinalizouOuPagamento, descricaoTipo, descricaoTipoTransferencia, nomeBancoOrigem, agenciaOrigem, nomeBancoDestino, agenciaDestino, valorEntrada, valorSaida, valorTotalSaldo) "
            + "values (" + bmb.idEmpresa + ", " + bmb.codigoGrupo + ", " + bmb.codigoEmpresa + ", " + bmb.codigoUsuario + ", " + bmb.idTabela + ", " + bmb.codigoTabela + ", '" + bmb.modulo + "', '" + bmb.descricaoTabela + "', '" + bmb.dataFinalizouOuPagamento + "', '" + bmb.descricaoTipo + "', '" + bmb.descricaoTipoTransferencia + "', '" + bmb.nomeBancoOrigem + "', '" + bmb.agenciaOrigem + "', '" + bmb.nomeBancoDestino + "', '" + bmb.agenciaDestino + "', " + bmb.valorEntrada + ", " + bmb.valorSaida + ", " + bmb.valorTotalSaldo + ");";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao incluir registro n°" + bmb.codigoTabela + " de " + bmb.modulo + "!";
            mostraMensagem();
            fatal = "S";
            return;
        }
    }
    
    private void PegaDespesas(){
        bd.codigoContaCorrente          = codigoContaCorrente;
        bd.codigoContaCorrenteDestino   = codigoContaCorrente;
        
        preenchimentoDespesa = "";
        if(combo_tipo.getSelectedIndex() == 1){
            if(combo_contaCorrente.getSelectedIndex() > 1){
                preenchimentoDespesa = "and (codigoContaCorrente = " + bd.codigoContaCorrente + " or codigoContaCorrenteDestino = " + bd.codigoContaCorrenteDestino + ") and transferencia = 0;";
            }else{
                preenchimentoDespesa = "and transferencia = 0;";
            }
        }
        if(combo_tipo.getSelectedIndex() == 2){
            if(combo_contaCorrente.getSelectedIndex() > 1){
                preenchimentoDespesa = "and (codigoContaCorrente = " + bd.codigoContaCorrente + " or codigoContaCorrenteDestino = " + bd.codigoContaCorrenteDestino + ") and transferencia = 1;";
            }else{
                preenchimentoDespesa = "and transferencia = 1;";
            }
        }
        sql = "select "
            + "   idDespesa, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoDespesa, \n"
            + "   codigoDespesaTipo, \n"
            + "   descricaoDespesa, \n"
            + "   codigoContaCorrente, \n"
            + "   dataPagamento, \n"
            + "   valorPago, \n"
            + "   codigoContaCorrenteDestino, \n"
            + "   transferencia \n"
            + "from \n"
            + "   tb_despesas where idEmpresa = " + parametrosNS.be.IdEmpresa + " and dataPagamento < '" + binter.dataFinal + "' \n"
            + preenchimentoDespesa;
        dadosDespesas.clear();
        dadosDespesas = parametrosNS.dao.Consulta(sql);
        PegaDadosDespesas();
    }
    
    private void PegaDadosDespesas(){
        String contaCorrenteDestino = "";
        
        String valorSaidaTexto      = "";
        String valorEntradaTexto    = "";
        
        valorTotalSaldo = valorTotalSaldoAnterior;
        TableMovimentacao.setNumRows(0);
        int rpt = 0;
        modulo = "Despesas";
        dadosValoresCompletos = new ArrayList();
        for(int i = 0; i < dadosDespesas.size(); i++){
            dadosValores          = new ArrayList();
            
            valorSaida      = 0;
            valorEntrada    = 0;
            bd  = new BeanDespesas();
            bmb = new BeanMovimentacaoBancaria();
            if(dadosDespesas.get(i).get(0)  != null){bd.idDespesa                   = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(0)));}
            if(dadosDespesas.get(i).get(1)  != null){bd.idEmpresa                   = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(1)));}
            if(dadosDespesas.get(i).get(2)  != null){bd.codigoGrupo                 = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(2)));}
            if(dadosDespesas.get(i).get(3)  != null){bd.codigoEmpresa               = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(3)));}
            if(dadosDespesas.get(i).get(4)  != null){bd.codigoDespesa               = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(4)));}
            if(dadosDespesas.get(i).get(5)  != null){bd.codigoDespesaTipo           = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(5)));}
            if(dadosDespesas.get(i).get(6)  != null){bd.descricaoDespesa            =                    String.valueOf(dadosDespesas.get(i).get(6));}
            if(dadosDespesas.get(i).get(7)  != null){bd.codigoContaCorrente         = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(7)));}
            if(dadosDespesas.get(i).get(8)  != null){bd.dataPagamento               =                    String.valueOf(dadosDespesas.get(i).get(8));}
            if(dadosDespesas.get(i).get(9)  != null){bd.valorPago                   = Double.parseDouble(String.valueOf(dadosDespesas.get(i).get(9)));}
            if(dadosDespesas.get(i).get(10) != null){bd.codigoContaCorrenteDestino  = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(10)));}
            if(dadosDespesas.get(i).get(11) != null){bd.transferencia               = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(11)));}
            
            int codigoContaCorrente1 = 0;
            if(rpt == 0){
                bcco.codigoContaCorrente    = bd.codigoContaCorrente;
                bcc.codigoContaCorrente     = bcco.codigoContaCorrente;
                if(codigoContaCorrente != 0){
                    if(bcc.codigoContaCorrente == codigoContaCorrente){
                        codigoContaCorrente1 = codigoContaCorrente;
                        codigoContaCorrente  = 0;
                    }
                }
                if(codigoContaCorrente == 0){
                    preenchimento   = " and cc.codigoContaCorrente = " + bcc.codigoContaCorrente;
                    PegaContaCorrente("O");
                    valorSaida      = bd.valorPago;
                    if(codigoContaCorrente1 != 0){
                        codigoContaCorrente = codigoContaCorrente1;
                    }
                }
            }
            codigoContaCorrente1 = 0;
            if(rpt == 1){
                bccd.codigoContaCorrente    = bd.codigoContaCorrenteDestino;
                bcc.codigoContaCorrente     = bccd.codigoContaCorrente;
                if(codigoContaCorrente != 0){
                    if(bcc.codigoContaCorrente == codigoContaCorrente){
                        codigoContaCorrente1 = codigoContaCorrente;
                        codigoContaCorrente  = 0;
                    }
                }
                if(codigoContaCorrente == 0){
                    preenchimento   = " and cc.codigoContaCorrente = " + bcc.codigoContaCorrente;
                    PegaContaCorrente("D");
                    valorEntrada    = bd.valorPago;
                    if(codigoContaCorrente1 != 0){
                        codigoContaCorrente = codigoContaCorrente1;
                    }
                }
            }
            
            if(rpt == 0){
                if(codigoContaCorrente != 0){
                    if(bcc.codigoContaCorrente != codigoContaCorrente){
                        i = i - 1;
                        rpt = 1;
                        continue;
                    }
                }
            }
            if(rpt == 1)
                if(codigoContaCorrente != 0)
                    if(bcc.codigoContaCorrente != codigoContaCorrente){
                        rpt = 0;
                        continue;
                    }
            
            agenciaOrigem           = fc.FormataCampo(String.valueOf(bcco.numeroAgencia), 4, 0);
            if(bcco.digitoVerificadorAgencia != 0){
                agenciaOrigem      += "-" + String.valueOf(bcco.digitoVerificadorAgencia);
            }
            contaCorrenteOrigem     = fc.FormataCampo(String.valueOf(bcco.numeroContaCorrente), 5, 0) + "-" + String.valueOf(bcco.digitoVerificador);
            
            agenciaOrigem       = agenciaOrigem  + "   " + contaCorrenteOrigem;
            nomeBancoOrigem     = bbo.codigoBanco + "-" + bbo.nomeBanco;
            
            agenciaDestino          = fc.FormataCampo(String.valueOf(bccd.numeroAgencia), 4, 0);
            if(bccd.digitoVerificadorAgencia != 0){
                agenciaDestino     += "-" + String.valueOf(bccd.digitoVerificadorAgencia);
            }
            contaCorrenteDestino    = fc.FormataCampo(String.valueOf(bccd.numeroContaCorrente), 5, 0) + "-" + String.valueOf(bccd.digitoVerificador);
            
            agenciaDestino      = agenciaDestino + "   " + contaCorrenteDestino;
            nomeBancoDestino    = bbd.codigoBanco + "-" + bbd.nomeBanco;
            
            descricaoTipoTransferencia = "";
            bdt.codigoDespesaTipo       = bd.codigoDespesaTipo;
            PegaDespesasTipo();
            if(bd.transferencia == 0){
                if(bdt.codigoDespesaTipo != 0){
                    bdt.descricaoDespesaTipo    = fc.FormataCampo(String.valueOf(bdt.codigoDespesaTipo), 2, 0) + "-" + bdt.descricaoDespesaTipo;
                }
            }else{
                if(rpt == 0){
                    descricaoTipoTransferencia = "Saída";
                }else{
                    descricaoTipoTransferencia = "Entrada";
                }
                bdt.descricaoDespesaTipo        = "99-Transferência";
            }
            
            if(rpt == 0){
                agenciaDestino   = "";
                nomeBancoDestino = "";
            }
            if(rpt == 1){
                agenciaOrigem    = "";
                nomeBancoOrigem  = "";
                bd.transferencia = 0;
                rpt = 0;
            }
            if(bd.transferencia == 1){
                if(rpt == 0){
                    i = i - 1;
                    rpt = 1;
                }
            }
            
            PegaValoresDespesas();
        }
    }
    
    private void PegaValoresDespesas(){
        bmb.idTabela                   = bd.idDespesa;
        bmb.codigoTabela               = bd.codigoDespesa;
        bmb.modulo                     = modulo;
        bmb.descricaoTabela            = bd.descricaoDespesa;
        bmb.dataFinalizouOuPagamento   = bd.dataPagamento;
        bmb.descricaoTipo              = bdt.descricaoDespesaTipo;
        bmb.descricaoTipoTransferencia = descricaoTipoTransferencia;
        bmb.nomeBancoOrigem            = nomeBancoOrigem;
        bmb.agenciaOrigem              = agenciaOrigem;
        bmb.nomeBancoDestino           = nomeBancoDestino;
        bmb.agenciaDestino             = agenciaDestino;
        bmb.valorEntrada               = valorEntrada;
        bmb.valorSaida                 = valorSaida;
        bmb.valorTotalSaldo            = valorTotalSaldo;
        
        IncluirRegistroMovimentacaoBancaria();
    }
    
    private void PegaDespesasTipo(){
        bdt.descricaoDespesaTipo = "----------";
        if(bdt.codigoDespesaTipo == 0){
            return;
        }
        sql = "select idDespesaTipo, idEmpresa, codigoGrupo, codigoEmpresa, codigoDespesaTipo, descricaoDespesaTipo from tb_despesas_tipo where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoDespesaTipo = " + bdt.codigoDespesaTipo + ";";
        dadosDespesasTipo.clear();
        dadosDespesasTipo = parametrosNS.dao.Consulta(sql);
        if(dadosDespesasTipo.isEmpty()){
            mensagem = "Tipo de Despesa n°" + bdt.codigoDespesaTipo + " não encontrado!";
            new MostraMensagem(mensagem);
            return;
        }
        PegaDadosDespesasTipo();
    }
    
    private void PegaDadosDespesasTipo(){
        for(int i = 0; i < dadosDespesasTipo.size(); i++){
            bdt = new BeanDespesasTipo();
            if(dadosDespesasTipo.get(i).get(0) != null){bdt.idDespesaTipo         = Integer.parseInt(  String.valueOf(dadosDespesasTipo.get(i).get(0)));}
            if(dadosDespesasTipo.get(i).get(1) != null){bdt.idEmpresa             = Integer.parseInt(  String.valueOf(dadosDespesasTipo.get(i).get(1)));}
            if(dadosDespesasTipo.get(i).get(2) != null){bdt.codigoGrupo           = Integer.parseInt(  String.valueOf(dadosDespesasTipo.get(i).get(2)));}
            if(dadosDespesasTipo.get(i).get(3) != null){bdt.codigoEmpresa         = Integer.parseInt(  String.valueOf(dadosDespesasTipo.get(i).get(3)));}
            if(dadosDespesasTipo.get(i).get(4) != null){bdt.codigoDespesaTipo     = Integer.parseInt(  String.valueOf(dadosDespesasTipo.get(i).get(4)));}
            if(dadosDespesasTipo.get(i).get(0) != null){bdt.descricaoDespesaTipo  =                    String.valueOf(dadosDespesasTipo.get(i).get(5));}
        }
    }
    
    private void PegaBoletos(){
        bbol.codigoContaCorrente    = codigoContaCorrente;
        
        preenchimentoBoletos = "";
        if(combo_contaCorrente.getSelectedIndex() > 1){
            preenchimentoBoletos = " and bol.codigoContaCorrente = " + bbol.codigoContaCorrente;
        }
        sql = "select \n" +
              "  bol.idBoletos, \n" +
              "  bol.idEmpresa, \n" +
              "  bol.codigoGrupo, \n" +
              "  bol.codigoEmpresa, \n" +
              "  bol.codigoBoleto, \n" +
              "  bol.codigoCliente, \n" +
              "  cli.nome, \n" +
              "  bol.codigoContaCorrente, \n" +
              "  bol.codigoBoletoInstrucao, \n" +
              "  bolin.descricaoInstrucao, \n" +
              "  bol.dataDePagamento, \n" +
              "  bol.valorPago \n" +
              "from \n" +
              "  tb_boletos bol \n" +
              "  inner join tb_clientes cli on ((bol.idEmpresa = cli.idEmpresa) and (bol.codigoCliente = cli.codigoCliente)) \n" +
              "  inner join tb_boletos_instrucoes bolin on ((bol.idEmpresa = bolin.idEmpresa) and (bol.codigoBoletoInstrucao = bolin.codigoBoletoInstrucao)) \n" +
              "    where bol.idEmpresa = " + parametrosNS.be.IdEmpresa + preenchimentoBoletos + " and bol.valorPago <> null and bol.dataDePagamento < '" + binter.dataFinal + "';";
        dadosBoletos.clear();
        dadosBoletos = parametrosNS.dao.Consulta(sql);
        PegaDadosBoletos();
    }
    
    private void PegaDadosBoletos(){
        String contaCorrenteDestino = "";
        
        modulo = "Boletos";
        for(int i = 0; i < dadosBoletos.size(); i++){
            dadosValores          = new ArrayList();
            
            bc   = new BeanClientes();
            bcc  = new BeanContaCorrente();
            bbi  = new BeanBoletosInstrucoes();
            bbol = new BeanBoletos();
            if(dadosBoletos.get(i).get(0) != null){bbol.idBoletos              = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(0)));}
            if(dadosBoletos.get(i).get(1) != null){bbol.idEmpresa              = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(1)));}
            if(dadosBoletos.get(i).get(2) != null){bbol.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(2)));}
            if(dadosBoletos.get(i).get(3) != null){bbol.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(3)));}
            if(dadosBoletos.get(i).get(4) != null){bbol.codigoBoleto           = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(4)));}
            if(dadosBoletos.get(i).get(5) != null){bbol.codigoCliente          = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(5)));}
                
            bc.idEmpresa        = bbol.idEmpresa;
            bc.codigoGrupo      = bbol.codigoGrupo;
            bc.codigoEmpresa    = bbol.codigoEmpresa;
            bc.codigoCliente    = bbol.codigoCliente;
            bc.nome             = String.valueOf(dadosBoletos.get(i).get(6));

            bcc.idEmpresa       = bbol.idEmpresa;
            bcc.codigoGrupo     = bbol.codigoGrupo;
            bcc.codigoEmpresa   = bbol.codigoEmpresa;
            bbol.codigoContaCorrente    = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(7)));
            bcc.codigoContaCorrente     = bbol.codigoContaCorrente;
            preenchimento = " and cc.codigoContaCorrente = " + bcc.codigoContaCorrente;
            PegaContaCorrente("D");

            bbi.idEmpresa       = bbol.idEmpresa;
            bbi.codigoGrupo     = bbol.codigoGrupo;
            bbi.codigoEmpresa   = bbol.codigoEmpresa;
            bbi.codigoBoletoInstrucao  = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(8)));
            bbol.codigoBoletoInstrucao = bbi.codigoBoletoInstrucao;
            if(dadosBoletos.get(i).get(9) != null){bbi.descricaoInstrucao  =                    String.valueOf(dadosBoletos.get(i).get(9));}
            
            if(dadosBoletos.get(i).get(10) != null){bbol.dataDePagamento        =                    String.valueOf(dadosBoletos.get(i).get(10));}
            if(dadosBoletos.get(i).get(11) != null){bbol.valorPago              = Double.parseDouble(String.valueOf(dadosBoletos.get(i).get(11)));}
            
            agenciaDestino          = fc.FormataCampo(String.valueOf(bccd.numeroAgencia), 4, 0);
            if(bccd.digitoVerificadorAgencia != 0){
                agenciaDestino     += "-" + String.valueOf(bccd.digitoVerificadorAgencia);
            }
            contaCorrenteDestino    = fc.FormataCampo(String.valueOf(bccd.numeroContaCorrente), 5, 0) + "-" + String.valueOf(bccd.digitoVerificador);
            
            agenciaDestino      = agenciaDestino + "   " + contaCorrenteDestino;
            nomeBancoDestino    = bbd.codigoBanco + "-" + bbd.nomeBanco;
            
            valorEntrada        = bbol.valorPago;
            
            PegaValoresBoletos();
        }
    }
    
    private void PegaValoresBoletos(){
        bmb.idTabela                   = bbol.idBoletos;
        bmb.codigoTabela               = bbol.codigoBoleto;
        bmb.modulo                     = modulo;
        bmb.descricaoTabela            = parametrosNS.fc.FormataCampo(String.valueOf(bc.codigoCliente), 5, 0) + "-" + bc.nome;
        bmb.dataFinalizouOuPagamento   = bbol.dataDePagamento;
        bmb.descricaoTipo              = parametrosNS.fc.FormataCampo(String.valueOf(bbi.codigoBoletoInstrucao), 2, 0) + "-" + bbi.descricaoInstrucao;
        bmb.descricaoTipoTransferencia = "";
        bmb.nomeBancoOrigem            = "";
        bmb.agenciaOrigem              = "";
        bmb.nomeBancoDestino           = nomeBancoDestino;
        bmb.agenciaDestino             = agenciaDestino;
        bmb.valorEntrada               = valorEntrada;
        bmb.valorSaida                 = 0;
        bmb.valorTotalSaldo            = valorTotalSaldo;
        
        IncluirRegistroMovimentacaoBancaria();
    }
    
    private void PegaOrdemServico(){
        if(combo_contaCorrente.getSelectedIndex() > 1){
            if(codigoContaCorrente != bparges.codigoContaCorrenteOrdemServico){
                return;
            }
        }
        sql = "select \n" +
              "  os.idOrdemServico, \n" +
              "  os.idEmpresa, \n" +
              "  os.codigoGrupo, \n" +
              "  os.codigoEmpresa, \n" +
              "  os.codigoOrdemServico, \n" +
              "  os.codigoCliente, \n" +
              "  cli.nome, \n" +
              "  os.descricao, \n" +
              "  os.valorAdiantamento, \n" +
              "  os.valorMaoDeObra, \n" +
              "  os.valorPecas, \n" +
              "  os.valorTerceiros, \n" +
              "  os.valorOutros, \n" +
              "  os.valorDeslocamento, \n" +
              "  os.dataFinalizou \n" +
              "from \n" +
              "  tb_os os \n" +
              "  inner join tb_clientes cli on ((os.idEmpresa = cli.idEmpresa) and (os.codigoCliente = cli.codigoCliente))\n" +
              "    where os.idEmpresa = " + parametrosNS.be.IdEmpresa + " and \n" +
              "         (os.dataFinalizou < '" + binter.dataFinal + "') and \n" +
              "         (os.valorMaoDeObra <> 0 or os.valorPecas <> 0);";
        dadosOrdemServico.clear();
        dadosOrdemServico = parametrosNS.dao.Consulta(sql);
        PegaDadosOrdemservico();
    }
    
    private void PegaDadosOrdemservico(){
        String contaCorrenteDestino = "";
        
        modulo = "Ordem de Serviço";
        for(int i = 0; i < dadosOrdemServico.size(); i++){
            dadosValores = new ArrayList();
            
            if(dadosOrdemServico.get(i).get(0) != null){bos.idOrdemServico      = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(0)));}
            if(dadosOrdemServico.get(i).get(1) != null){bos.idEmpresa           = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(1)));}
            if(dadosOrdemServico.get(i).get(2) != null){bos.codigoGrupo         = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(2)));}
            if(dadosOrdemServico.get(i).get(3) != null){bos.codigoEmpresa       = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(3)));}
            if(dadosOrdemServico.get(i).get(4) != null){bos.codigoOrdemServico  = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(4)));}
            if(dadosOrdemServico.get(i).get(5) != null){bos.codigoCliente       = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(5)));}
            
            bc.idEmpresa        = bos.idEmpresa;
            bc.codigoGrupo      = bos.codigoGrupo;
            bc.codigoEmpresa    = bos.codigoEmpresa;
            bc.codigoCliente    = bos.codigoCliente;
            bc.nome             = String.valueOf(dadosOrdemServico.get(i).get(6));
            
            if(dadosOrdemServico.get(i).get(7) != null){
                bos.descricao           =                    String.valueOf(dadosOrdemServico.get(i).get(7));
            }
            
            if(dadosOrdemServico.get(i).get(8)  != null){bos.valorAdiantamento = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(8)));}
            if(dadosOrdemServico.get(i).get(9)  != null){bos.valorMaoDeObra    = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(9)));}
            if(dadosOrdemServico.get(i).get(10) != null){bos.valorPecas        = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(10)));}
            if(dadosOrdemServico.get(i).get(11) != null){bos.valorTerceiros    = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(11)));}
            if(dadosOrdemServico.get(i).get(12) != null){bos.valorOutros       = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(12)));}
            if(dadosOrdemServico.get(i).get(13) != null){bos.valorDeslocamento = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(13)));}
            if(dadosOrdemServico.get(i).get(14) != null){bos.dataFinalizou     =                    String.valueOf(dadosOrdemServico.get(i).get(14));}
            
            bcc.codigoContaCorrente = bparges.codigoContaCorrenteOrdemServico;
            preenchimento = " and cc.codigoContaCorrente = " + bcc.codigoContaCorrente;
            PegaContaCorrente("D");
            
            agenciaDestino          = fc.FormataCampo(String.valueOf(bccd.numeroAgencia), 4, 0);
            if(bccd.digitoVerificadorAgencia != 0){
                agenciaDestino     += "-" + String.valueOf(bccd.digitoVerificadorAgencia);
            }
            contaCorrenteDestino    = fc.FormataCampo(String.valueOf(bccd.numeroContaCorrente), 5, 0) + "-" + String.valueOf(bccd.digitoVerificador);
            
            agenciaDestino      = agenciaDestino + "   " + contaCorrenteDestino;
            nomeBancoDestino    = bbd.codigoBanco + "-" + bbd.nomeBanco;
            
            valorEntrada        = bos.valorAdiantamento + bos.valorMaoDeObra + bos.valorPecas + bos.valorTerceiros + bos.valorOutros + bos.valorDeslocamento;
            
            PgeaValoresOrdemServico();
        }
    }
    
    private void PgeaValoresOrdemServico(){
        bmb.idTabela                   = bos.idOrdemServico;
        bmb.codigoTabela               = bos.codigoOrdemServico;
        bmb.modulo                     = modulo;
        bmb.descricaoTabela            = parametrosNS.fc.FormataCampo(String.valueOf(bc.codigoCliente), 5, 0) + "-" + bc.nome;
        bmb.dataFinalizouOuPagamento   = bos.dataFinalizou;
        bmb.descricaoTipo              = bos.descricao;
        bmb.descricaoTipoTransferencia = "";
        bmb.nomeBancoOrigem            = "";
        bmb.agenciaOrigem              = "";
        bmb.nomeBancoDestino           = nomeBancoDestino;
        bmb.agenciaDestino             = agenciaDestino;
        bmb.valorEntrada               = valorEntrada;
        bmb.valorSaida                 = 0;
        bmb.valorTotalSaldo            = valorTotalSaldo;
        
        IncluirRegistroMovimentacaoBancaria();
    }
    
    private void PegaRecibos(){
        sql = "select \n" +
              "  rec.idRecibo, \n" +
              "  rec.idEmpresa, \n" +
              "  rec.codigoGrupo, \n" +
              "  rec.codigoEmpresa, \n" +
              "  rec.codigoRecibo, \n" +
              "  rec.codigoCliente, \n" +
              "  cli.nome, \n" +
              "  rec.dataRecibo, \n" +
              "  rec.horaRecibo, \n" +
              "  rec.status,\n" +
              "  sum(recp.valorDoPagamento), \n" +
              "  sum(recp.trocoDoPagamento) \n" +
//              "  recd.codigoServico, \n" +
//              "  ser.descricaoServico \n" +
              "from \n" +
              "	 tb_recibos rec \n" +
              "  inner join tb_clientes cli on ((rec.idEmpresa = cli.idEmpresa) and (rec.codigoCliente = cli.codigoCliente)) \n" +
              "  right join tb_recibos_pagamentos recp on ((rec.idEmpresa = recp.idEmpresa) and (rec.codigoRecibo = recp.codigoRecibo)) \n" +
//              "  inner join tb_recibos_detalhes recd on (rec.idRecibo = recd.idRecibo) \n" +
//              "  inner join tb_servicos ser on ((rec.idEmpresa = ser.idEmpresa) and (recd.codigoServico = ser.codigoServico)) \n" +
              "    where rec.idEmpresa = " + parametrosNS.be.IdEmpresa + " and status = 2 and rec.dataRecibo < '" + binter.dataFinal + "' \n" +
              "    group by rec.idRecibo asc \n" +
              "    order by rec.idRecibo asc;";
        dadosRecibos.clear();
        dadosRecibos = parametrosNS.dao.Consulta(sql);
        PegaDadosRecibos();
    }
    
    private void PegaDadosRecibos(){
        String contaCorrenteDestino = "";
        
        modulo = "Recibos";
        for(int i = 0; i < dadosRecibos.size(); i++){
            dadosValores = new ArrayList();
            
            if(dadosRecibos.get(i).get(0) != null){brec.idRecibo       = Integer.parseInt(String.valueOf(dadosRecibos.get(i).get(0)));}
            if(dadosRecibos.get(i).get(1) != null){brec.idEmpresa      = Integer.parseInt(String.valueOf(dadosRecibos.get(i).get(1)));}
            if(dadosRecibos.get(i).get(2) != null){brec.codigoGrupo    = Integer.parseInt(String.valueOf(dadosRecibos.get(i).get(2)));}
            if(dadosRecibos.get(i).get(3) != null){brec.codigoEmpresa  = Integer.parseInt(String.valueOf(dadosRecibos.get(i).get(3)));}
            if(dadosRecibos.get(i).get(4) != null){brec.codigoRecibo   = Integer.parseInt(String.valueOf(dadosRecibos.get(i).get(4)));}
            
            bc.idEmpresa        = brec.idEmpresa;
            bc.codigoGrupo      = brec.codigoGrupo;
            bc.codigoEmpresa    = brec.codigoEmpresa;
            brec.codigoCliente  = Integer.parseInt(String.valueOf(dadosRecibos.get(i).get(5)));
            bc.codigoCliente    = brec.codigoCliente;
            bc.nome             = String.valueOf(dadosRecibos.get(i).get(6));
            
            if(dadosRecibos.get(i).get(7) != null){brec.dataRecibo     = String.valueOf(dadosRecibos.get(i).get(7));}
            if(dadosRecibos.get(i).get(8) != null){brec.horaRecibo     = String.valueOf(dadosRecibos.get(i).get(8));}
            if(dadosRecibos.get(i).get(9) != null){brec.status         = Integer.parseInt(String.valueOf(dadosRecibos.get(i).get(9)));}
            
            brecp.idEmpresa     = brec.idEmpresa;
            brecp.codigoGrupo   = brec.codigoGrupo;
            brecp.codigoEmpresa = brec.codigoEmpresa;
            brecp.codigoRecibo  = brec.codigoRecibo;
            if(dadosRecibos.get(i).get(10) != null)brecp.valorDoPagamento  = Double.parseDouble(String.valueOf(dadosRecibos.get(i).get(10)));
            if(dadosRecibos.get(i).get(11) != null)brecp.trocoDoPagamento  = Double.parseDouble(String.valueOf(dadosRecibos.get(i).get(11)));
            
//            brecd.idRecibo      = brec.idRecibo;
//            if(dadosRecibos.get(i).get(12) != null)
//                brecd.codigoServico = Integer.parseInt(String.valueOf(dadosRecibos.get(i).get(12)));
//            
//            bser.idEmpresa          = brec.idEmpresa;
//            bser.codigoGrupo        = brec.codigoGrupo;
//            bser.codigoEmpresa      = brec.codigoEmpresa;
//            bser.codigoServico      = brecd.codigoServico;
//            
//            if(dadosRecibos.get(i).get(13) != null)
//                bser.descricaoServico   =                  String.valueOf(dadosRecibos.get(i).get(13));
            
            bcc.codigoContaCorrente = bparges.codigoContaCorrenteRecibo;
            preenchimento = " and cc.codigoContaCorrente = " + bcc.codigoContaCorrente;
            PegaContaCorrente("D");
            
            agenciaDestino          = fc.FormataCampo(String.valueOf(bccd.numeroAgencia), 4, 0);
            if(bccd.digitoVerificadorAgencia != 0){
                agenciaDestino     += "-" + String.valueOf(bccd.digitoVerificadorAgencia);
            }
            contaCorrenteDestino    = fc.FormataCampo(String.valueOf(bccd.numeroContaCorrente), 5, 0) + "-" + String.valueOf(bccd.digitoVerificador);
            
            agenciaDestino   = agenciaDestino + "   " + contaCorrenteDestino;
            nomeBancoDestino = bbd.codigoBanco + "-" + bbd.nomeBanco;
            
            valorEntrada     = brecp.valorDoPagamento - brecp.trocoDoPagamento;
            
            PegaValoresRecibos();
        }
    }
    
    private void PegaValoresRecibos(){
        bmb.idTabela                   = brec.idRecibo;
        bmb.codigoTabela               = brec.codigoRecibo;
        bmb.modulo                     = modulo;
        bmb.descricaoTabela            = parametrosNS.fc.FormataCampo(String.valueOf(bc.codigoCliente), 5, 0) + "-" + bc.nome;
        bmb.dataFinalizouOuPagamento   = brec.dataRecibo;
        bmb.descricaoTipo              = "";
        bmb.descricaoTipoTransferencia = "";
        bmb.nomeBancoOrigem            = "";
        bmb.agenciaOrigem              = "";
        bmb.nomeBancoDestino           = nomeBancoDestino;
        bmb.agenciaDestino             = agenciaDestino;
        bmb.valorEntrada               = valorEntrada;
        bmb.valorSaida                 = 0;
        bmb.valorTotalSaldo            = valorTotalSaldo;
        
        IncluirRegistroMovimentacaoBancaria();
    }
    
    private void PegaVendas(){
        sql = "select \n" +
              "  ven.idVenda, \n" +
              "  ven.idEmpresa, \n" +
              "  ven.codigoGrupo, \n" +
              "  ven.codigoEmpresa, \n" +
              "  ven.codigoVenda, \n" +
              "  ven.codigoCliente, \n" +
              "  cli.nome, \n" +
              "  ven.dataVenda, \n" +
              "  ven.horaVenda, \n" +
              "  ven.status, \n" +
              "  sum(venp.valorDoPagamento), \n" +
              "  sum(venp.trocoDoPagamento) \n" +
              "from \n" +
              "	 tb_vendas ven \n" +
              "  inner join tb_clientes cli on ((ven.idEmpresa = cli.idEmpresa) and (ven.codigoCliente = cli.codigoCliente)) \n" +
              "  inner join tb_vendas_pagamentos venp on ((ven.idEmpresa = venp.idEmpresa) and (ven.codigoVenda = venp.codigoVenda)) \n" +
              "    where ven.idEmpresa = " + parametrosNS.be.IdEmpresa + " and ven.status = 2 and ven.dataVenda < '" + binter.dataFinal + "' \n" +
              "      group by ven.idVenda asc \n" +
              "      order by ven.idVenda asc;";
        dadosVendas.clear();
        dadosVendas = parametrosNS.dao.Consulta(sql);
        PegaDadosVendas();
    }
    
    private void PegaDadosVendas(){
        String contaCorrenteDestino = "";
        
        modulo = "Vendas";
        for(int i = 0; i < dadosVendas.size(); i++){
            dadosValores = new ArrayList();
            
            if(dadosVendas.get(i).get(0) != null){bv.idVenda          = Integer.parseInt(String.valueOf(dadosVendas.get(i).get(0)));}
            if(dadosVendas.get(i).get(1) != null){bv.idEmpresa        = Integer.parseInt(String.valueOf(dadosVendas.get(i).get(1)));}
            if(dadosVendas.get(i).get(2) != null){bv.codigoGrupo      = Integer.parseInt(String.valueOf(dadosVendas.get(i).get(2)));}
            if(dadosVendas.get(i).get(3) != null){bv.codigoEmpresa    = Integer.parseInt(String.valueOf(dadosVendas.get(i).get(3)));}
            if(dadosVendas.get(i).get(4) != null){bv.codigoVenda      = Integer.parseInt(String.valueOf(dadosVendas.get(i).get(4)));}
            if(dadosVendas.get(i).get(5) != null){bv.codigoCliente    = Integer.parseInt(String.valueOf(dadosVendas.get(i).get(5)));}
            
            bc.idEmpresa        = bv.idEmpresa;
            bc.codigoGrupo      = bv.codigoGrupo;
            bc.codigoEmpresa    = bv.codigoEmpresa;
            bc.codigoCliente    = bv.codigoCliente;
            if(dadosVendas.get(i).get(6) != null){bc.nome         = String.valueOf(dadosVendas.get(i).get(6));}
            
            if(dadosVendas.get(i).get(7) != null){bv.dataVenda    = String.valueOf(dadosVendas.get(i).get(7));}
            if(dadosVendas.get(i).get(8) != null){bv.horaVenda    = String.valueOf(dadosVendas.get(i).get(8));}
            if(dadosVendas.get(i).get(9) != null){bv.status       = Integer.parseInt(String.valueOf(dadosVendas.get(i).get(9)));}
            
            bvp.idEmpresa       = bv.idEmpresa;
            bvp.codigoGrupo     = bv.codigoGrupo;
            bvp.codigoEmpresa   = bv.codigoEmpresa;
            bvp.codigoVenda     = bv.codigoVenda;
            if(dadosVendas.get(i).get(10) != null){bvp.valorDoPagamento    = Double.parseDouble(String.valueOf(dadosVendas.get(i).get(10)));}
            if(dadosVendas.get(i).get(11) != null){bvp.trocoDoPagamento    = Double.parseDouble(String.valueOf(dadosVendas.get(i).get(11)));}
            
            bcc.codigoContaCorrente = bparges.codigoContaCorrenteRecibo;
            preenchimento = " and cc.codigoContaCorrente = " + bcc.codigoContaCorrente;
            PegaContaCorrente("D");
            
            agenciaDestino          = fc.FormataCampo(String.valueOf(bccd.numeroAgencia), 4, 0);
            if(bccd.digitoVerificadorAgencia != 0){
                agenciaDestino     += "-" + String.valueOf(bccd.digitoVerificadorAgencia);
            }
            contaCorrenteDestino    = fc.FormataCampo(String.valueOf(bccd.numeroContaCorrente), 5, 0) + "-" + String.valueOf(bccd.digitoVerificador);
            
            agenciaDestino   = agenciaDestino + "   " + contaCorrenteDestino;
            nomeBancoDestino = bbd.codigoBanco + "-" + bbd.nomeBanco;
            
            valorEntrada     = bvp.valorDoPagamento - bvp.trocoDoPagamento;
            
            PegaValoresVendas();
        }
        PegaValoresMovimentacaoBancariaSaldoAnterior();
        PegaValoresMovimentacaoBancaria();
        new AjustarLarguraColunas(tabela_movimentacaoDespesa);
        
        tabela_movimentacaoDespesa.getColumnModel().getColumn(0).setResizable(false);
        tabela_movimentacaoDespesa.getColumnModel().getColumn(0).setMinWidth(0);
        tabela_movimentacaoDespesa.getColumnModel().getColumn(0).setMaxWidth(0);
        
        tabela_movimentacaoDespesa.getColumnModel().getColumn(1).setResizable(false);
        tabela_movimentacaoDespesa.getColumnModel().getColumn(1).setMinWidth(0);
        tabela_movimentacaoDespesa.getColumnModel().getColumn(1).setMaxWidth(0);
        tabela_movimentacaoDespesa.getColumnModel().getColumn(1).setCellRenderer(parametrosNS.tableDireita);
        
        tabela_movimentacaoDespesa.getColumnModel().getColumn(2).setCellRenderer(parametrosNS.tableDireita);
        
        tabela_movimentacaoDespesa.getColumnModel().getColumn(4).setCellRenderer(parametrosNS.tableCentralizado);
        
        tabela_movimentacaoDespesa.getColumnModel().getColumn(5).setResizable(true);
        
        tabela_movimentacaoDespesa.getColumnModel().getColumn(6).setResizable(false);
        tabela_movimentacaoDespesa.getColumnModel().getColumn(6).setCellRenderer(parametrosNS.tableCentralizado);
        
        tabela_movimentacaoDespesa.getColumnModel().getColumn(7).setResizable(true);
        
        tabela_movimentacaoDespesa.getColumnModel().getColumn(8).setResizable(true);
        
        tabela_movimentacaoDespesa.getColumnModel().getColumn(9).setResizable(true);
        
        tabela_movimentacaoDespesa.getColumnModel().getColumn(10).setResizable(true);
        
        tabela_movimentacaoDespesa.getColumnModel().getColumn(11).setCellRenderer(parametrosNS.tableDireita);
        tabela_movimentacaoDespesa.getColumnModel().getColumn(11).setResizable(true);
        
        tabela_movimentacaoDespesa.getColumnModel().getColumn(12).setCellRenderer(parametrosNS.tableDireita);
        tabela_movimentacaoDespesa.getColumnModel().getColumn(12).setResizable(true);
        
        tabela_movimentacaoDespesa.getColumnModel().getColumn(13).setCellRenderer(parametrosNS.tableDireita);
        tabela_movimentacaoDespesa.getColumnModel().getColumn(13).setResizable(true);
    }
    
    private void PegaValoresVendas(){
        bmb.idTabela                   = bv.idVenda;
        bmb.codigoTabela               = bv.codigoVenda;
        bmb.modulo                     = modulo;
        bmb.descricaoTabela            = parametrosNS.fc.FormataCampo(String.valueOf(bc.codigoCliente), 5, 0) + "-" + bc.nome;
        bmb.dataFinalizouOuPagamento   = bv.dataVenda;
        bmb.descricaoTipo              = "";
        bmb.descricaoTipoTransferencia = "";
        bmb.nomeBancoOrigem            = "";
        bmb.agenciaOrigem              = "";
        bmb.nomeBancoDestino           = nomeBancoDestino;
        bmb.agenciaDestino             = agenciaDestino;
        bmb.valorEntrada               = valorEntrada;
        bmb.valorSaida                 = 0;
        bmb.valorTotalSaldo            = valorTotalSaldo;
        
        IncluirRegistroMovimentacaoBancaria();
    }
    
    private void PegaValoresMovimentacaoBancariaSaldoAnterior(){
        sql = "select \n"
            + "   valorEntrada, \n"
            + "   valorSaida \n"
            + "from tb_movimentacaobancaria where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and codigoUsuario = " + parametrosNS.bu.codigoUsuario + " and dataFinalizouOuPagamento < '" + binter.dataInicial + "' order by dataFinalizouOuPagamento asc;";
        dadosMovimentacaoBancaria = new ArrayList();
        dadosMovimentacaoBancaria = parametrosNS.dao.Consulta(sql);
        PegaDadosValoresMovimentacaoBancariaSaldoAnterior();
    }
    
    private void PegaDadosValoresMovimentacaoBancariaSaldoAnterior(){
        valorTotalSaldoAnterior = 0;
        for(int i = 0; i < dadosMovimentacaoBancaria.size(); i++){
            bmb = new BeanMovimentacaoBancaria();
            if(dadosMovimentacaoBancaria.get(i).get(0) != null){bmb.valorEntrada = Double.parseDouble(String.valueOf(dadosMovimentacaoBancaria.get(i).get(0)));}
            if(dadosMovimentacaoBancaria.get(i).get(1) != null){bmb.valorSaida   = Double.parseDouble(String.valueOf(dadosMovimentacaoBancaria.get(i).get(1)));}
            
            valorTotalSaldoAnterior = valorTotalSaldoAnterior + bmb.valorEntrada;
            valorTotalSaldoAnterior = valorTotalSaldoAnterior - bmb.valorSaida;
        }
    }
    
    private void PegaValoresMovimentacaoBancaria(){
        sql = "select * from tb_movimentacaobancaria where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and codigoUsuario = " + parametrosNS.bu.codigoUsuario + " and (dataFinalizouOuPagamento between '" + binter.dataInicial + "' and '" + binter.dataFinal + "') order by dataFinalizouOuPagamento asc;";
        dadosMovimentacaoBancaria = new ArrayList();
        dadosMovimentacaoBancaria = parametrosNS.dao.Consulta(sql);
        if(dadosMovimentacaoBancaria.isEmpty()){
            mensagem = "Não foram encontrados registros da conta corrente selecionada!";
            mostraMensagem();
            return;
        }
        PegaDadosValoresMovimentacaoBancaria();
    }
    
    private void PegaDadosValoresMovimentacaoBancaria(){
        String valorEntradaTexto = "";
        String valorSaidaTexto   = "";
        bmb.valorTotalSaldo = valorTotalSaldoAnterior;
        for(int i = 0; i < dadosMovimentacaoBancaria.size(); i++){
            if(dadosMovimentacaoBancaria.get(i).get(0)  != null){bmb.idMovimentacaoBancaria     = Integer.parseInt(  String.valueOf(dadosMovimentacaoBancaria.get(i).get(0)));}
            if(dadosMovimentacaoBancaria.get(i).get(1)  != null){bmb.idEmpresa                  = Integer.parseInt(  String.valueOf(dadosMovimentacaoBancaria.get(i).get(1)));}
            if(dadosMovimentacaoBancaria.get(i).get(2)  != null){bmb.codigoGrupo                = Integer.parseInt(  String.valueOf(dadosMovimentacaoBancaria.get(i).get(2)));}
            if(dadosMovimentacaoBancaria.get(i).get(3)  != null){bmb.codigoEmpresa              = Integer.parseInt(  String.valueOf(dadosMovimentacaoBancaria.get(i).get(3)));}
            if(dadosMovimentacaoBancaria.get(i).get(4)  != null){bmb.codigoUsuario              = Integer.parseInt(  String.valueOf(dadosMovimentacaoBancaria.get(i).get(4)));}
            if(dadosMovimentacaoBancaria.get(i).get(5)  != null){bmb.idTabela                   = Integer.parseInt(  String.valueOf(dadosMovimentacaoBancaria.get(i).get(5)));}
            if(dadosMovimentacaoBancaria.get(i).get(6)  != null){bmb.codigoTabela               = Integer.parseInt(  String.valueOf(dadosMovimentacaoBancaria.get(i).get(6)));}
            if(dadosMovimentacaoBancaria.get(i).get(7)  != null){bmb.modulo                     =                    String.valueOf(dadosMovimentacaoBancaria.get(i).get(7));}
            if(dadosMovimentacaoBancaria.get(i).get(8)  != null){bmb.descricaoTabela            =                    String.valueOf(dadosMovimentacaoBancaria.get(i).get(8));}
            if(dadosMovimentacaoBancaria.get(i).get(9)  != null){bmb.dataFinalizouOuPagamento   =                    String.valueOf(dadosMovimentacaoBancaria.get(i).get(9));}
            if(dadosMovimentacaoBancaria.get(i).get(10) != null){bmb.descricaoTipo              =                    String.valueOf(dadosMovimentacaoBancaria.get(i).get(10));}
            if(dadosMovimentacaoBancaria.get(i).get(11) != null){bmb.descricaoTipoTransferencia =                    String.valueOf(dadosMovimentacaoBancaria.get(i).get(11));}
            if(dadosMovimentacaoBancaria.get(i).get(12) != null){bmb.nomeBancoOrigem            =                    String.valueOf(dadosMovimentacaoBancaria.get(i).get(12));}
            if(dadosMovimentacaoBancaria.get(i).get(13) != null){bmb.agenciaOrigem              =                    String.valueOf(dadosMovimentacaoBancaria.get(i).get(13));}
            if(dadosMovimentacaoBancaria.get(i).get(14) != null){bmb.nomeBancoDestino           =                    String.valueOf(dadosMovimentacaoBancaria.get(i).get(14));}
            if(dadosMovimentacaoBancaria.get(i).get(15) != null){bmb.agenciaDestino             =                    String.valueOf(dadosMovimentacaoBancaria.get(i).get(15));}
            if(dadosMovimentacaoBancaria.get(i).get(16) != null){bmb.valorEntrada               = Double.parseDouble(String.valueOf(dadosMovimentacaoBancaria.get(i).get(16)));}
            if(dadosMovimentacaoBancaria.get(i).get(17) != null){bmb.valorSaida                 = Double.parseDouble(String.valueOf(dadosMovimentacaoBancaria.get(i).get(17)));}
            
            bmb.dataFinalizouOuPagamento    = parametrosNS.invdata.inverterData(bmb.dataFinalizouOuPagamento, 1);
            
            bmb.valorTotalSaldo = bmb.valorTotalSaldo + bmb.valorEntrada;
            bmb.valorTotalSaldo = bmb.valorTotalSaldo - bmb.valorSaida;
            
            valorEntradaTexto    = TransStrDou.TransformaValorStringeDouble(String.valueOf(bmb.valorEntrada)   , 0);
            valorSaidaTexto      = TransStrDou.TransformaValorStringeDouble(String.valueOf(bmb.valorSaida)     , 0);
            valorTotalSaldoTexto = TransStrDou.TransformaValorStringeDouble(String.valueOf(bmb.valorTotalSaldo), 0);
            
            if(bmb.valorTotalSaldo < 0){
                bmb.valorTotalSaldo  = bmb.valorTotalSaldo * (-1);
                valorTotalSaldoTexto = "(-) " + nf.format(conv.ConverteValorDigitadoEmDouble(String.valueOf(bmb.valorTotalSaldo), "N"));
                bmb.valorTotalSaldo  = bmb.valorTotalSaldo * (-1);
            }
            
            if(bmb.valorEntrada == 0){
                valorEntradaTexto = "";
            }
            if(bmb.valorSaida   == 0){
                valorSaidaTexto   = "";
            }
            
            TableMovimentacao.addRow(new Object[] {bmb.idTabela, bmb.codigoTabela, bmb.modulo, bmb.descricaoTabela, bmb.dataFinalizouOuPagamento, bmb.descricaoTipo, bmb.descricaoTipoTransferencia, bmb.nomeBancoOrigem, bmb.agenciaOrigem, bmb.nomeBancoDestino, bmb.agenciaDestino, valorEntradaTexto, valorSaidaTexto, valorTotalSaldoTexto});
        }
        valorTotalSaldo = bmb.valorTotalSaldo;
    }
    
    private void ImprimirRelatorioMovimentacaoBancaria(){
        try{
            img = null;
            if(parametrosNS.be.ImagemLogotipoEmpresa != null){
                buffImg = ImageIO.read(new ByteArrayInputStream(parametrosNS.be.ImagemLogotipoEmpresa));
                imgIcon = new ImageIcon(buffImg);
                img     = imgIcon.getImage();
            }
            hm = new HashMap();
            hm.put("idEmpresa"         , parametrosNS.be.IdEmpresa);
            hm.put("codigoGrupo"       , parametrosNS.bge.CodigoGrupo);
            hm.put("codigoEmpresa"     , parametrosNS.be.CodigoEmpresa);
            hm.put("codigoUsuario"     , parametrosNS.bu.codigoUsuario);
            hm.put("idEmpresa"         , parametrosNS.be.IdEmpresa);
            hm.put("nomeEmpresa"       , parametrosNS.be.NomeEmpresa);
            hm.put("cnpjEmpresa"       , parametrosNS.be.CnpjEmpresa);
            hm.put("cidadeEmpresa"     , parametrosNS.be.CidadeEmpresa + ", " + parametrosNS.be.UfEmpresa);
            hm.put("enderecoEmpresa"   , parametrosNS.be.EnderecoEmpresa + ", " + parametrosNS.be.NumeroEmpresa + ", " + parametrosNS.be.bairroEmpresa);
            hm.put("cepEmpresa"        , parametrosNS.be.CepEmpresa);
            hm.put("telefoneEmpresa"   , parametrosNS.be.TelefoneEmpresa);
            if(img != null){
                hm.put("logotipoEmpresa", img);
            }else{
                hm.put("logotipoEmpresa", null);
            }
            if(combo_contaCorrente.getSelectedIndex() > 1){
                hm.put("nomeBanco", bb.codigoBanco + "-" + bb.nomeBanco);
            }
            if(combo_contaCorrente.getSelectedIndex() > 1){
                if(bb.codigoBanco .equals("033")){hm.put("agencia", bcc.numeroAgencia + "-" + bcc.digitoVerificadorAgencia);}
                if(bb.codigoBanco .equals("237")){hm.put("agencia", bcc.numeroAgencia + "-" + bcc.digitoVerificadorAgencia);}
                if(bb.codigoBanco .equals("341")){hm.put("agencia", bcc.numeroAgencia);}
                if(bb.codigoBanco .equals("399")){hm.put("agencia", bcc.numeroAgencia);}
            }
            
            if(combo_contaCorrente.getSelectedIndex() > 1){
                if(bb.codigoBanco .equals("033")){hm.put("contaCorrente", bcc.numeroContaCorrente);}
                if(bb.codigoBanco .equals("237")){hm.put("contaCorrente", bcc.numeroContaCorrente + "-" + bcc.digitoVerificador);}
                if(bb.codigoBanco .equals("341")){hm.put("contaCorrente", bcc.numeroContaCorrente + "-" + bcc.digitoVerificador);}
                if(bb.codigoBanco .equals("399")){hm.put("contaCorrente", bcc.numeroContaCorrente);}
            }
            
            if(combo_contaCorrente.getSelectedIndex() == 1){
                hm.put("nomeBanco"    , "Todos");
                hm.put("agencia"      , "Todos");
                hm.put("contaCorrente", "Todos");
            }
            
            if(binter.dataInicial == binter.dataFinal){
                hm.put("movimentacao", "Movimentos bancários do dia " + invdata.inverterData(String.valueOf(binter.dataFinal), 1) + ".");
            }else{
                if(binter.dataInicial == 0){
                    hm.put("movimentacao", "Movimentos bancários entre o dia 00/00/0000 e " + invdata.inverterData(String.valueOf(binter.dataFinal), 1) + ".");
                }else{
                    hm.put("movimentacao", "Movimentos bancários entre o dia " + invdata.inverterData(String.valueOf(binter.dataInicial), 1) + " e " + invdata.inverterData(String.valueOf(binter.dataFinal), 1) + ".");
                }
            }
            hm.put("saldoInicial", nf.format(conv.ConverteValorDigitadoEmDouble(String.valueOf(valorTotalSaldoAnterior), "N")));
            hm.put("saldoFinal"  , nf.format(conv.ConverteValorDigitadoEmDouble(String.valueOf(valorTotalSaldo), "N")));
            hm.put("dataInicial" , binter.dataInicial);
            hm.put("dataFinal"   , binter.dataFinal);
            
            jpv = "Relatorios/MovimentacaoBancaria.jasper";
            
            JasperPrint jpp = JasperFillManager.fillReport(jpv, hm, parametrosNS.con);
            JasperViewer.viewReport(jpp, false);
        }catch(Exception erro){
            mensagem = "Erro ao imprimir: " + erro.getMessage();
            mostraMensagem();
        }
    }
    
}
