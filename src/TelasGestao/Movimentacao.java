package TelasGestao;

import Beans.BeanBoletos;
import Beans.BeanCaixaAbertura;
import Beans.BeanCaixaSaida;
import Beans.BeanClientes;
import Beans.BeanDespesas;
import Beans.BeanIntervalos;
import Beans.BeanOrdemServico;
import Beans.BeanOrdemServicoItens;
import Beans.BeanParametrosGestao;
import Beans.BeanRecibos;
import Beans.BeanRecibosDetalhes;
import Beans.BeanRecibosPagamentos;
import Beans.BeanVendas;
import Beans.BeanVendasItens;
import Beans.BeanVendasPagamentos;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.TestarData;
import FuncoesInternas.TransformaValorStringeDouble;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/*
 @author Tiago e Paulo 31/10/2016 19:30
 */
public class Movimentacao extends javax.swing.JFrame {
    //String's
    String sql          = "";
    String sqlstate     = "";
    String Mensagem     = "";
    String somostra     = "";
    String Tipo         = "";
    String Lancamento   = "";
    String ValorTexto   = "";
    String DataRegistro = "";
    String dataInicial  = "";
    String dataFinal    = "";
    String NomeModulo   = "";
    String NomeCliente  = "";
    
    //int's
    int    Linha        = 0;
    int    TotalDaBarra = 0;
    int    contador     = 0;
    int    CodigoModulo = 0;
    
    //double's
    double Valor                        = 0;
    double ValorTotal                   = 0;
    double ValorTotalModulos            = 0;
    double ValorTotalEntradas           = 0;
    double ValorTotalSaidas             = 0;
    double ValorTotalDetalhes           = 0;
    double ValorTotalMensaisEntradas    = 0;
    double ValorTotalMensaisSaidas      = 0;
    double ValorTotalMensaisGeral       = 0;
    double ValorTotalSomaGeralEntradas  = 0;
    double ValorTotalSomaGeralSaidas    = 0;
    double ValorTotalSomaGeral          = 0;
    
    //Vetores
    //Vetores De Lucros
    ArrayList            parametros             = new ArrayList();
    ArrayList            dadosPadroes           = new ArrayList();
    ArrayList            dadosMensagens         = new ArrayList();
    ArrayList<ArrayList> dadosCliente           = new ArrayList();
    ArrayList<ArrayList> dadosParametrosGestao  = new ArrayList();
    ArrayList<ArrayList> dadosBoletos           = new ArrayList();
    ArrayList<ArrayList> dadosOrdemServico      = new ArrayList();
    ArrayList<ArrayList> dadosOrdemServicoItens = new ArrayList();
    ArrayList<ArrayList> dadosVendas            = new ArrayList();
    ArrayList<ArrayList> dadosVendasItens       = new ArrayList();
    ArrayList<ArrayList> dadosVendasPagamentos  = new ArrayList();
    ArrayList<ArrayList> dadosRecibos           = new ArrayList();
    ArrayList<ArrayList> dadosRecibosDetalhes   = new ArrayList();
    ArrayList<ArrayList> dadosRecibosPagamentos = new ArrayList();
    //Vetores de Despesas
    ArrayList<ArrayList> dadosAberturaCaixa     = new ArrayList();
    ArrayList<ArrayList> dadosSaidaCaixa        = new ArrayList();
    ArrayList<ArrayList> dadosDespesas          = new ArrayList();
    
    //Bean's
    BeanClientes                    bc      = new BeanClientes();
    BeanBoletos                     bbol    = new BeanBoletos();
    BeanParametrosGestao            bparges = new BeanParametrosGestao();
    BeanOrdemServico                bos     = new BeanOrdemServico();
    BeanOrdemServicoItens           bosi    = new BeanOrdemServicoItens();
    BeanVendas                      bv      = new BeanVendas();
    BeanVendasItens                 bvi     = new BeanVendasItens();
    BeanVendasPagamentos            bvp     = new BeanVendasPagamentos();
    BeanRecibos                     br      = new BeanRecibos();
    BeanRecibosDetalhes             brd     = new BeanRecibosDetalhes();
    BeanRecibosPagamentos           brp     = new BeanRecibosPagamentos();
    BeanCaixaAbertura               bca     = new BeanCaixaAbertura();
    BeanCaixaSaida                  bcs     = new BeanCaixaSaida();
    BeanDespesas                    bdes    = new BeanDespesas();
    BeanIntervalos                  binter  = new BeanIntervalos();
    
    //Especiais
    FormataCampo                    fc      = new FormataCampo();
    TestarData                      Test    = new TestarData();
    InverterData                    invdata = new InverterData();
    DefaultTableModel               TableModulos;
    DefaultTableModel               TableDetalhesModulos;
    DefaultTableModel               TableCompetencia;
    CapturarDataHora                cdh     = new CapturarDataHora();
    TransformaValorStringeDouble    TransStrDou = new TransformaValorStringeDouble();
    
    //Telas
    
    public Movimentacao(ArrayList DadosPadroes){
        dadosPadroes                    = DadosPadroes;
        
        somostra                        = (String)  dadosPadroes.get(0);
        
        initComponents();
    }
    
    private void InicializaCampos(){
        txt_diaInicial      .setText(fc.FormataCampo("", 2, 0));
        txt_mesInicial      .setText(fc.FormataCampo("", 2, 0));
        txt_anoInicial      .setText(fc.FormataCampo("", 4, 0));
        txt_diaFinal        .setText("31");
        txt_mesFinal        .setText("12");
        txt_anoFinal        .setText(cdh.CapturarData().substring(6, 10));
    }
    
    private void PegaParametrosGestao(){
        sql = "select * from tb_parametrosgestao where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosParametrosGestao.clear();
        dadosParametrosGestao = parametrosNS.dao.Consulta(sql);
        if(dadosParametrosGestao.isEmpty()){
            bparges.dataGestao  = cdh.CapturarData();
            return;
        }
        PegaDadosParametrosGestao();
    }
    
    private void PegaDadosParametrosGestao(){
        for(int i = 0; i < dadosParametrosGestao.size(); i++){
            bparges.idParametrosGestao  = Integer.parseInt(  String.valueOf(dadosParametrosGestao.get(i).get(0)));
            bparges.idEmpresa           = Integer.parseInt(  String.valueOf(dadosParametrosGestao.get(i).get(1)));
            bparges.codigoGrupo         = Integer.parseInt(  String.valueOf(dadosParametrosGestao.get(i).get(2)));
            bparges.codigoEmpresa       = Integer.parseInt(  String.valueOf(dadosParametrosGestao.get(i).get(3)));
            bparges.dataGestao          =                    String.valueOf(dadosParametrosGestao.get(i).get(4));
        }
        bparges.dataGestao      = invdata.inverterData(bparges.dataGestao, 1);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_diaInicial = new javax.swing.JFormattedTextField();
        txt_diaFinal = new javax.swing.JFormattedTextField();
        txt_mesInicial = new javax.swing.JFormattedTextField();
        txt_mesFinal = new javax.swing.JFormattedTextField();
        txt_anoFinal = new javax.swing.JFormattedTextField();
        txt_anoInicial = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        check_entradas = new javax.swing.JCheckBox();
        check_saidas = new javax.swing.JCheckBox();
        bt_processa = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_movimentacao = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_detalhes = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabela_competencia = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        barra_progresso = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movimentacao");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Intervalos de Consulta     F11[Geral]");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Intervalo de datas: ");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Inicial:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Final:");

        try {
            txt_diaInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_diaInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_diaInicial.setText("00");
        txt_diaInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_diaInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_diaInicialFocusLost(evt);
            }
        });
        txt_diaInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_diaInicialKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_diaInicialKeyReleased(evt);
            }
        });

        try {
            txt_diaFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_diaFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_diaFinal.setText("99");
        txt_diaFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_diaFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_diaFinalFocusLost(evt);
            }
        });
        txt_diaFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_diaFinalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_diaFinalKeyReleased(evt);
            }
        });

        try {
            txt_mesInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_mesInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_mesInicial.setText("00");
        txt_mesInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_mesInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_mesInicialFocusLost(evt);
            }
        });
        txt_mesInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_mesInicialKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_mesInicialKeyReleased(evt);
            }
        });

        try {
            txt_mesFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_mesFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_mesFinal.setText("99");
        txt_mesFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_mesFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_mesFinalFocusLost(evt);
            }
        });
        txt_mesFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_mesFinalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_mesFinalKeyReleased(evt);
            }
        });

        try {
            txt_anoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_anoFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_anoFinal.setText("9999");
        txt_anoFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_anoFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_anoFinalFocusLost(evt);
            }
        });
        txt_anoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_anoFinalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_anoFinalKeyReleased(evt);
            }
        });

        try {
            txt_anoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_anoInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_anoInicial.setText("0000");
        txt_anoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_anoInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_anoInicialFocusLost(evt);
            }
        });
        txt_anoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_anoInicialKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_anoInicialKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_diaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_diaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_mesInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_anoInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(txt_anoFinal)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_diaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_mesInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_anoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_diaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_mesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_anoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel5, jLabel6, txt_diaFinal, txt_diaInicial});

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        check_entradas.setText("Somente Entradas");

        check_saidas.setText("Somente Saídas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(check_entradas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check_saidas)
                .addContainerGap(925, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(check_entradas)
                    .addComponent(check_saidas))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {check_entradas, check_saidas});

        bt_processa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/1280454766_system-software-update.png"))); // NOI18N
        bt_processa.setText("Processa");
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

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Totais");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_movimentacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_movimentacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seq", "Módulos", "Valor"
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
        tabela_movimentacao.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_movimentacao.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_movimentacao.getTableHeader().setReorderingAllowed(false);
        tabela_movimentacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_movimentacaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_movimentacao);
        if (tabela_movimentacao.getColumnModel().getColumnCount() > 0) {
            tabela_movimentacao.getColumnModel().getColumn(0).setResizable(false);
            tabela_movimentacao.getColumnModel().getColumn(1).setResizable(false);
            tabela_movimentacao.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Detalhes por Módulo");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_detalhes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_detalhes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seq", "Nome do Cliente", "Descrição", "Código Lançamento", "Valor", "Data do Registro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_detalhes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_detalhes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_detalhes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabela_detalhes);
        if (tabela_detalhes.getColumnModel().getColumnCount() > 0) {
            tabela_detalhes.getColumnModel().getColumn(0).setResizable(false);
            tabela_detalhes.getColumnModel().getColumn(1).setResizable(false);
            tabela_detalhes.getColumnModel().getColumn(2).setResizable(false);
            tabela_detalhes.getColumnModel().getColumn(3).setResizable(false);
            tabela_detalhes.getColumnModel().getColumn(4).setResizable(false);
            tabela_detalhes.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Mês de Competência (Analítico - Anual)");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_competencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_competencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mês", "Ano", "(+) Entradas", "(-) Saídas", "Lucro - Geral", "Diferença"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_competencia.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_competencia.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_competencia.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabela_competencia);
        if (tabela_competencia.getColumnModel().getColumnCount() > 0) {
            tabela_competencia.getColumnModel().getColumn(0).setResizable(false);
            tabela_competencia.getColumnModel().getColumn(1).setResizable(false);
            tabela_competencia.getColumnModel().getColumn(2).setResizable(false);
            tabela_competencia.getColumnModel().getColumn(3).setResizable(false);
            tabela_competencia.getColumnModel().getColumn(4).setResizable(false);
            tabela_competencia.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Totais por forma de pagamento");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_processa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(barra_progresso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barra_progresso, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_processa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_processaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_processaActionPerformed
        IniciaCarregamento();
    }//GEN-LAST:event_bt_processaActionPerformed

    private void txt_diaInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_diaInicialFocusGained
        txt_diaInicial.setText("");
    }//GEN-LAST:event_txt_diaInicialFocusGained

    private void txt_mesInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_mesInicialFocusGained
        txt_mesInicial.setText("");
    }//GEN-LAST:event_txt_mesInicialFocusGained

    private void txt_anoInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_anoInicialFocusGained
        txt_anoInicial.setText("");
    }//GEN-LAST:event_txt_anoInicialFocusGained

    private void txt_diaFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_diaFinalFocusGained
        txt_diaFinal.setText("");
    }//GEN-LAST:event_txt_diaFinalFocusGained

    private void txt_mesFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_mesFinalFocusGained
        txt_mesFinal.setText("");
    }//GEN-LAST:event_txt_mesFinalFocusGained

    private void txt_anoFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_anoFinalFocusGained
        txt_anoFinal.setText("");
    }//GEN-LAST:event_txt_anoFinalFocusGained

    private void txt_diaInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_diaInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_mesInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_diaInicial.setText(fc.FormataCampo("", 2, 0));
            txt_mesInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_diaInicialKeyPressed

    private void txt_mesInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mesInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_anoInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_mesInicial.setText(fc.FormataCampo("", 2, 0));
            txt_anoInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_mesInicialKeyPressed

    private void txt_anoInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_anoInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_diaFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_anoInicial.setText(fc.FormataCampo("", 4, 0));
            txt_diaFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_anoInicialKeyPressed

    private void txt_diaFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_diaFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_mesFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_diaFinal.setText("31");
            txt_mesFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_diaFinalKeyPressed

    private void txt_mesFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mesFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_anoFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_mesFinal.setText("12");
            txt_anoFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_mesFinalKeyPressed

    private void txt_anoFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_anoFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            check_entradas.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_anoFinal.setText(cdh.CapturarData().substring(6, 10));
            check_entradas.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_anoFinalKeyPressed

    private void txt_diaInicialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_diaInicialKeyReleased
        if(txt_diaInicial.getText().replace(" ", "").length() > 1)
            txt_mesInicial.grabFocus();
    }//GEN-LAST:event_txt_diaInicialKeyReleased

    private void txt_mesInicialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mesInicialKeyReleased
        if(txt_mesInicial.getText().replace(" ", "").length() > 1)
            txt_anoInicial.grabFocus();
    }//GEN-LAST:event_txt_mesInicialKeyReleased

    private void txt_anoInicialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_anoInicialKeyReleased
        if(txt_anoInicial.getText().replace(" ", "").length() > 3)
            txt_diaFinal.grabFocus();
    }//GEN-LAST:event_txt_anoInicialKeyReleased

    private void txt_diaFinalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_diaFinalKeyReleased
        if(txt_diaFinal.getText().replace(" ", "").length() > 1)
            txt_mesFinal.grabFocus();
    }//GEN-LAST:event_txt_diaFinalKeyReleased

    private void txt_mesFinalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mesFinalKeyReleased
        if(txt_mesFinal.getText().replace(" ", "").length() > 1)
            txt_anoFinal.grabFocus();
    }//GEN-LAST:event_txt_mesFinalKeyReleased

    private void txt_anoFinalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_anoFinalKeyReleased
        if(txt_anoFinal.getText().replace(" ", "").length() > 3)
            check_entradas.grabFocus();
    }//GEN-LAST:event_txt_anoFinalKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        InicializaCampos();
        PegaParametrosGestao();
        txt_diaInicial.setText(fc.FormataCampo("1" , 2, 0));
        txt_diaFinal  .setText(fc.FormataCampo("31", 2, 0));
        txt_mesInicial.setText(fc.FormataCampo("1" , 2, 0));
        txt_mesFinal  .setText(fc.FormataCampo("12", 2, 0));
        txt_anoInicial.setText(fc.FormataCampo(bparges.dataGestao.substring(6, 10), 4, 0));
        txt_anoFinal  .setText(fc.FormataCampo(bparges.dataGestao.substring(6, 10), 4, 0));
        txt_anoInicial.setEditable(false);
        txt_anoFinal  .setEditable(false);
        txt_anoInicial.setFocusable(false);
        txt_anoFinal  .setFocusable(false);
        TableModulos        = (DefaultTableModel)tabela_movimentacao.getModel();
        TableModulos.setNumRows(0);
        TableDetalhesModulos= (DefaultTableModel)tabela_detalhes.getModel();
        TableDetalhesModulos.setNumRows(0);
        TableCompetencia    = (DefaultTableModel)tabela_competencia.getModel();
        TableCompetencia.setNumRows(0);
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_diaInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_diaInicialFocusLost
        txt_diaInicial.setText(fc.FormataCampo(txt_diaInicial.getText().replace(" ", ""), 2, 0));
    }//GEN-LAST:event_txt_diaInicialFocusLost

    private void txt_mesInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_mesInicialFocusLost
        txt_mesInicial.setText(fc.FormataCampo(txt_mesInicial.getText().replace(" ", ""), 2, 0));
    }//GEN-LAST:event_txt_mesInicialFocusLost

    private void txt_anoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_anoInicialFocusLost
        txt_anoInicial.setText(fc.FormataCampo(txt_anoInicial.getText().replace(" ", ""), 4, 0));
    }//GEN-LAST:event_txt_anoInicialFocusLost

    private void txt_diaFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_diaFinalFocusLost
        if(!txt_diaFinal.getText().replace(" ", "").equals("")){
            txt_diaFinal  .setText(fc.FormataCampo(txt_diaFinal.getText().replace(" ", ""), 2, 0));
        }else{
            txt_diaFinal  .setText("31");
        }
    }//GEN-LAST:event_txt_diaFinalFocusLost

    private void txt_mesFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_mesFinalFocusLost
        if(!txt_mesFinal.getText().replace(" ", "").equals("")){
            txt_mesFinal  .setText(fc.FormataCampo(txt_mesFinal.getText().replace(" ", ""), 2, 0));
        }else{
            txt_mesFinal  .setText("12");
        }
    }//GEN-LAST:event_txt_mesFinalFocusLost

    private void txt_anoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_anoFinalFocusLost
        if(!txt_anoFinal.getText().replace(" ", "").equals("")){
            txt_anoFinal  .setText(fc.FormataCampo(txt_anoFinal.getText().replace(" ", ""), 4, 0));
        }else{
            txt_anoFinal  .setText(cdh.CapturarData().substring(6, 10));
        }
    }//GEN-LAST:event_txt_anoFinalFocusLost

    private void tabela_movimentacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_movimentacaoMouseClicked
        if(evt.getClickCount() < 2)
            return;
        Linha           = tabela_movimentacao.getSelectedRow();
        if(Linha == tabela_movimentacao.getRowCount() - 1)
            return;
        CodigoModulo    = Integer.parseInt(String.valueOf(tabela_movimentacao.getValueAt(Linha, 1)).substring(0, 2));
        
        binter.dataInicial  = Test.Testa(fc.FormataCampo(txt_diaInicial.getText().replace(" ", ""), 2, 0) + fc.FormataCampo(txt_mesInicial.getText().replace(" ", ""), 2, 0) + fc.FormataCampo(txt_anoInicial.getText().replace(" ", ""), 4, 0));
        binter.dataFinal    = Test.Testa(fc.FormataCampo(txt_diaFinal  .getText().replace(" ", ""), 2, 0) + fc.FormataCampo(txt_mesFinal  .getText().replace(" ", ""), 2, 0) + fc.FormataCampo(txt_anoFinal  .getText().replace(" ", ""), 4, 0));
        if(binter.dataInicial > binter.dataFinal){
            Mensagem = "Data Inicial não pode ser maior do que a Data Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        dataInicial         = String.valueOf(binter.dataInicial);
        dataFinal           = String.valueOf(binter.dataFinal);
        
        ValorTotalEntradas  = 0;
        ValorTotalSaidas    = 0;
        TotalDaBarra        = 0;
        
        if(CodigoModulo == 13) PegaBoletos();
        if(CodigoModulo ==  8) PegaOrdemServico();
        if(CodigoModulo == 11) PegaRecibos();
        if(CodigoModulo ==  2) PegaVendas();    PegaAberturaCaixa();    PegaSaidaCaixa();
        if(CodigoModulo ==  7) PegaDespesas();
        
        if(CodigoModulo == 13) PegaDadosBoletos("S");
        if(CodigoModulo ==  8) PegaDadosOrdemServico("S");
        if(CodigoModulo == 11) PegaDadosRecibos("S");
        if(CodigoModulo ==  2){TableDetalhesModulos.setNumRows(0);barra_progresso.setMaximum(0);contador = 0;PegaDadosVendas("S");PegaDadosAberturaCaixa("S");PegaDadosSaidaCaixa("S");}
        if(CodigoModulo ==  7) PegaDadosDespesas("S");
        
        ValorTotalDetalhes  = ValorTotalEntradas - ValorTotalSaidas  ;
        ValorTexto          = TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotalDetalhes), 0);
        if(ValorTotalDetalhes < 0){
            ValorTexto      = "(-) " + TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotalDetalhes), 0);
        }
        
        TableDetalhesModulos.addRow(new Object [] {"", "Totais", "", "", ValorTexto, ""});
    }//GEN-LAST:event_tabela_movimentacaoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barra_progresso;
    private javax.swing.JButton bt_processa;
    private javax.swing.JCheckBox check_entradas;
    private javax.swing.JCheckBox check_saidas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabela_competencia;
    private javax.swing.JTable tabela_detalhes;
    private javax.swing.JTable tabela_movimentacao;
    private javax.swing.JFormattedTextField txt_anoFinal;
    private javax.swing.JFormattedTextField txt_anoInicial;
    private javax.swing.JFormattedTextField txt_diaFinal;
    private javax.swing.JFormattedTextField txt_diaInicial;
    private javax.swing.JFormattedTextField txt_mesFinal;
    private javax.swing.JFormattedTextField txt_mesInicial;
    // End of variables declaration//GEN-END:variables
    
    private void IniciaCarregamento(){
        tabela_movimentacao .getColumnModel().getColumn(0).setResizable(false);
        tabela_movimentacao .getColumnModel().getColumn(0).setPreferredWidth(30);
        tabela_movimentacao .getColumnModel().getColumn(1).setResizable(false);
        tabela_movimentacao .getColumnModel().getColumn(1).setPreferredWidth(250);
        tabela_movimentacao .getColumnModel().getColumn(2).setResizable(false);
        tabela_movimentacao .getColumnModel().getColumn(2).setPreferredWidth(250);
        
        tabela_detalhes     .getColumnModel().getColumn(0).setResizable(false);
        tabela_detalhes     .getColumnModel().getColumn(0).setPreferredWidth(30);
        tabela_detalhes     .getColumnModel().getColumn(1).setResizable(false);
        tabela_detalhes     .getColumnModel().getColumn(1).setPreferredWidth(225);
        tabela_detalhes     .getColumnModel().getColumn(2).setResizable(false);
        tabela_detalhes     .getColumnModel().getColumn(2).setPreferredWidth(165);
        tabela_detalhes     .getColumnModel().getColumn(3).setResizable(false);
        tabela_detalhes     .getColumnModel().getColumn(3).setPreferredWidth(100);
        tabela_detalhes     .getColumnModel().getColumn(4).setResizable(false);
        tabela_detalhes     .getColumnModel().getColumn(4).setPreferredWidth(120);
        tabela_detalhes     .getColumnModel().getColumn(5).setResizable(false);
        tabela_detalhes     .getColumnModel().getColumn(5).setPreferredWidth(120);
        
        tabela_competencia  .getColumnModel().getColumn(0).setResizable(false);
        tabela_competencia  .getColumnModel().getColumn(0).setPreferredWidth(90);
        tabela_competencia  .getColumnModel().getColumn(1).setResizable(false);
        tabela_competencia  .getColumnModel().getColumn(1).setPreferredWidth(50);
        tabela_competencia  .getColumnModel().getColumn(2).setResizable(false);
        tabela_competencia  .getColumnModel().getColumn(2).setPreferredWidth(100);
        tabela_competencia  .getColumnModel().getColumn(3).setResizable(false);
        tabela_competencia  .getColumnModel().getColumn(3).setPreferredWidth(100);
        tabela_competencia  .getColumnModel().getColumn(4).setResizable(false);
        tabela_competencia  .getColumnModel().getColumn(4).setPreferredWidth(100);
        tabela_competencia  .getColumnModel().getColumn(5).setResizable(false);
        
        binter.dataInicial  = Test.Testa(fc.FormataCampo(txt_diaInicial.getText().replace(" ", ""), 2, 0) + fc.FormataCampo(txt_mesInicial.getText().replace(" ", ""), 2, 0) + fc.FormataCampo(txt_anoInicial.getText().replace(" ", ""), 4, 0));
        binter.dataFinal    = Test.Testa(fc.FormataCampo(txt_diaFinal  .getText().replace(" ", ""), 2, 0) + fc.FormataCampo(txt_mesFinal  .getText().replace(" ", ""), 2, 0) + fc.FormataCampo(txt_anoFinal  .getText().replace(" ", ""), 4, 0));
        
        if(binter.dataInicial > binter.dataFinal){
            Mensagem = "Data Inicial não pode ser maior do que a Data Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        
        dataInicial         = String.valueOf(binter.dataInicial);
        dataFinal           = String.valueOf(binter.dataFinal);
//        dataInicial         = invdata.inverterData(invdata.inverterData(fc.FormataCampo(String.valueOf(binter.dataInicial), 8, 0), 1), 2);
//        dataFinal           = invdata.inverterData(invdata.inverterData(fc.FormataCampo(String.valueOf(binter.dataFinal  ), 8, 0), 1), 2);
        
        contador            = 0;
        ValorTotal          = 0;
        ValorTotalSaidas    = 0;
        ValorTotalEntradas  = 0;
        TotalDaBarra        = 0;
        TableModulos        .setNumRows(0);
        TableDetalhesModulos.setNumRows(0);
        dadosMensagens      .clear();
        
        if(parametrosNS.bma.moduloCC             == 1 || parametrosNS.bm.moduloCC             == 1)if(check_saidas    .isSelected() == false)PegaBoletos();
        if(parametrosNS.bma.moduloProducao       == 1 || parametrosNS.bm.moduloProducao       == 1)if(check_saidas    .isSelected() == false)PegaOrdemServico();
        if(parametrosNS.bma.moduloVendas         == 1 || parametrosNS.bm.moduloVendas         == 1)if(check_saidas    .isSelected() == false)PegaVendas();
        if(parametrosNS.bma.moduloRecebimento    == 1 || parametrosNS.bm.moduloRecebimento    == 1)if(check_saidas    .isSelected() == false)PegaRecibos();
        if(parametrosNS.bma.moduloVendas         == 1 || parametrosNS.bm.moduloVendas         == 1)if(check_entradas  .isSelected() == false)PegaAberturaCaixa();
        if(parametrosNS.bma.moduloVendas         == 1 || parametrosNS.bm.moduloVendas         == 1)if(check_entradas  .isSelected() == false)PegaSaidaCaixa();
        if(parametrosNS.bma.moduloContasAPagar   == 1 || parametrosNS.bm.moduloContasAPagar   == 1)if(check_entradas  .isSelected() == false)PegaDespesas();
        
        barra_progresso.setMaximum(TotalDaBarra);
        
        if(parametrosNS.bma.moduloCC             == 1 || parametrosNS.bm.moduloCC             == 1)if(check_saidas    .isSelected() == false)PegaDadosBoletos("N");
        if(parametrosNS.bma.moduloProducao       == 1 || parametrosNS.bm.moduloProducao       == 1)if(check_saidas    .isSelected() == false)PegaDadosOrdemServico("N");
        if(parametrosNS.bma.moduloVendas         == 1 || parametrosNS.bm.moduloVendas         == 1)if(check_saidas    .isSelected() == false)PegaDadosVendas("N");
        if(parametrosNS.bma.moduloRecebimento    == 1 || parametrosNS.bm.moduloRecebimento    == 1)if(check_saidas    .isSelected() == false)PegaDadosRecibos("N");
        if(parametrosNS.bma.moduloVendas         == 1 || parametrosNS.bm.moduloVendas         == 1)if(check_entradas  .isSelected() == false)PegaDadosAberturaCaixa("N");
        if(parametrosNS.bma.moduloVendas         == 1 || parametrosNS.bm.moduloVendas         == 1)if(check_entradas  .isSelected() == false)PegaDadosSaidaCaixa("N");
        if(parametrosNS.bma.moduloContasAPagar   == 1 || parametrosNS.bm.moduloContasAPagar   == 1)if(check_entradas  .isSelected() == false)PegaDadosDespesas("N");
        
        TableModulos.addRow(new Object [] {"", "Totais", TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotal), 0)});
        
        IniciaCarregamentoTabelaMensal();
    }
    
    private void SetaBarra(){
        barra_progresso.setValue(contador);
        barra_progresso.repaint();
    }
    
    private void MostraMensagens(){
        for(int i = 0; i < dadosMensagens.size(); i++){
            Mensagem    = String.valueOf(dadosMensagens.get(i));
            new MostraMensagem(Mensagem);
        }
    }
    
    //Inicia Tabela de Lucros
    private void PegaBoletos(){
        TotalDaBarra++;
        sql = "select "
            + "   idBoletos, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoBoleto, \n"
            + "   codigoCliente, \n"
            + "   codigoContaCorrente, \n"
            + "   valorPago, \n"
            + "   dataDePagamento, \n"
            + "   Instrucao1 \n"
            + "from tb_boletos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and dataDePagamento between " + dataInicial + " and " + dataFinal + ";";
        dadosBoletos.clear();
        dadosBoletos = parametrosNS.dao.Consulta(sql);
        if(dadosBoletos.isEmpty()){
            Mensagem = "Não foram encontrado Boletos para o intervalo selecionado!";
            dadosMensagens.add(Mensagem);
            return;
        }
    }
    
    private void PegaDadosBoletos(String Mostra){
        Valor               = 0;
        NomeModulo          = "13-Contas Correntes";
        ValorTotalModulos   = 0;
        int Tam             = 0;
        if(dadosBoletos.size() < 2){Tam = dadosBoletos.size();}else{Tam = dadosBoletos.size() - 1;}
        if(Mostra.equals("S")){barra_progresso.setMaximum(Tam);contador = 0;TableDetalhesModulos.setNumRows(0);}
        if(!Mostra.equals("S"))contador++;
        for(int i = 0; i < dadosBoletos.size(); i++){
            if(Mostra.equals("S"))contador++;
            bbol = new BeanBoletos();
            bbol = new BeanBoletos();
            if(dadosBoletos.get(i).get(0) != null){bbol.idBoletos              = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(0)));}
            if(dadosBoletos.get(i).get(1) != null){bbol.idEmpresa              = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(1)));}
            if(dadosBoletos.get(i).get(2) != null){bbol.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(2)));}
            if(dadosBoletos.get(i).get(3) != null){bbol.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(3)));}
            if(dadosBoletos.get(i).get(4) != null){bbol.codigoBoleto           = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(4)));}
            if(dadosBoletos.get(i).get(5) != null){bbol.codigoCliente          = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(5)));}
            if(dadosBoletos.get(i).get(6) != null){bbol.codigoContaCorrente    = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(6)));}
            if(dadosBoletos.get(i).get(7) != null){bbol.valorPago              = Double.parseDouble(String.valueOf(dadosBoletos.get(i).get(7)));}
            if(dadosBoletos.get(i).get(8) != null){bbol.dataDePagamento        =                    String.valueOf(dadosBoletos.get(i).get(8));}
            if(dadosBoletos.get(i).get(9) != null){bbol.Instrucao1             =                    String.valueOf(dadosBoletos.get(i).get(9));}
            
            Valor                       = bbol.valorPago;
            SetaBarra();
            
            if(!Mostra.equals("S")){
                ValorTotalModulos           += Valor;
                ValorTotalMensaisEntradas   += Valor;
                continue;
            }
            
            bc.codigoCliente            = bbol.codigoCliente;
            PegaCliente();
            NomeCliente                 = fc.FormataCampo(String.valueOf(bc.codigoCliente), 5, 0) + "-" + bc.nome;
            
            ValorTotalEntradas         += Valor;
            ValorTotal                 += Valor;
            
            Tipo            = fc.FormataCampo("13", 2, 0) + "-Boletos";
            Lancamento      = fc.FormataCampo(String.valueOf(bbol.codigoBoleto), 8, 0);
            ValorTexto      = "(+) " + TransStrDou.TransformaValorStringeDouble(String.valueOf(Valor), 0);
            DataRegistro    = invdata.inverterData(bbol.dataDePagamento, 1);
            
            TableDetalhesModulos.addRow(new Object [] {contador, NomeCliente, bbol.Instrucao1, fc.FormataCampo(String.valueOf(bbol.codigoBoleto), 8, 0), ValorTexto, DataRegistro});
        }
        SetaBarra();
        if(!Mostra.equals("N"))return;
        ValorTexto  = "(+) " + TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotalModulos), 0);
        TableModulos.addRow(new Object[] {contador, NomeModulo, ValorTexto});
    }
    
    private void PegaOrdemServico(){
        TotalDaBarra++;
        sql = "select \n"
            + "   idOrdemServico, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoOrdemServico, \n"
            + "   codigoCliente, \n"
            + "   codigoUsuario, \n"
            + "   dataCadastro, \n"
            + "   valorAdiantamento, \n"
            + "   valorDeslocamento, \n"
            + "   valorPecas, \n"
            + "   valorMaoDeObra, \n"
            + "   valorTerceiros, \n"
            + "   valorOutros \n"
            + "from tb_os where idEmpresa = " + parametrosNS.be.IdEmpresa + " and (statusOs = 2) and dataCadastro between '" + dataInicial + "' and '" + dataFinal + "';";
        dadosOrdemServico.clear();
        dadosOrdemServico = parametrosNS.dao.Consulta(sql);
        if(dadosOrdemServico.isEmpty()){
            Mensagem = "Não foram encontradas Ordens de Serviços para o Intervalo selecionado!";
            dadosMensagens.add(Mensagem);
            return;
        }
    }
    
    private void PegaDadosOrdemServico(String Mostra){
        Valor               = 0;
        NomeModulo          = "08-Produção";
        ValorTotalModulos   = 0;
        int Tam             = 0;
        if(dadosOrdemServico.size() < 2){Tam = dadosOrdemServico.size();}else{Tam = dadosOrdemServico.size() - 1;}
        if(Mostra.equals("S")){barra_progresso.setMaximum(Tam);contador = 0;TableDetalhesModulos.setNumRows(0);}
        if(!Mostra.equals("S"))contador++;
        for(int i = 0; i < dadosOrdemServico.size(); i++){
            if(Mostra.equals("S"))contador++;
            bos     = new BeanOrdemServico();
            if(dadosOrdemServico.get(i).get(0)  != null){bos.idOrdemServico          = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(0)));}
            if(dadosOrdemServico.get(i).get(1)  != null){bos.idEmpresa               = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(1)));}
            if(dadosOrdemServico.get(i).get(2)  != null){bos.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(2)));}
            if(dadosOrdemServico.get(i).get(3)  != null){bos.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(3)));}
            if(dadosOrdemServico.get(i).get(4)  != null){bos.codigoOrdemServico      = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(4)));}
            if(dadosOrdemServico.get(i).get(5)  != null){bos.codigoCliente           = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(5)));}
            if(dadosOrdemServico.get(i).get(6)  != null){bos.codigoUsuario           = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(6)));}
            if(dadosOrdemServico.get(i).get(7)  != null){bos.dataCadastro            =                    String.valueOf(dadosOrdemServico.get(i).get(7));}
            if(dadosOrdemServico.get(i).get(8)  != null){bos.valorAdiantamento       = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(8)));}
            if(dadosOrdemServico.get(i).get(9)  != null){bos.valorDeslocamento       = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(9)));}
            if(dadosOrdemServico.get(i).get(10) != null){bos.valorPecas              = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(10)));}
            if(dadosOrdemServico.get(i).get(11) != null){bos.valorMaoDeObra          = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(11)));}
            if(dadosOrdemServico.get(i).get(12) != null){bos.valorTerceiros          = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(12)));}
            if(dadosOrdemServico.get(i).get(13) != null){bos.valorOutros             = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(13)));}
            
            bosi.idEmpresa          = bos.idEmpresa;
            bosi.codigoGrupo        = bos.codigoGrupo;
            bosi.codigoEmpresa      = bos.codigoEmpresa;
            bosi.codigoOrdemServico = bos.codigoOrdemServico;
            PegaOrdemServicoItens();
            
            SetaBarra();
            
            Valor                      += bos.valorAdiantamento + bos.valorDeslocamento + bos.valorPecas + bos.valorMaoDeObra + bos.valorTerceiros + bos.valorOutros;
            if(!Mostra.equals("S")){
                ValorTotalModulos           += Valor;
                ValorTotalMensaisEntradas   += Valor;
                continue;
            }
            
            bc.codigoCliente            = bos.codigoCliente;
            PegaCliente();
            NomeCliente                 = fc.FormataCampo(String.valueOf(bc.codigoCliente), 5, 0) + "-" + bc.nome;
            
            ValorTotalEntradas         += Valor;
            ValorTotal                 += Valor;
            
            Tipo            = fc.FormataCampo("8", 2, 0) + "-Ordem de Serviço";
            Lancamento      = fc.FormataCampo(String.valueOf(bos.codigoOrdemServico), 9, 0);
            ValorTexto      = "(+) " + TransStrDou.TransformaValorStringeDouble(String.valueOf(Valor), 0);
            DataRegistro    = invdata.inverterData(bos.dataCadastro, 1);
            
            TableDetalhesModulos.addRow(new Object[] {contador, NomeCliente, Tipo, Lancamento, ValorTexto, DataRegistro});
        }
        SetaBarra();
        if(!Mostra.equals("N"))return;
        ValorTexto  = "(+) " + TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotalModulos), 0);
        TableModulos.addRow(new Object[] {contador, NomeModulo, ValorTexto});
    }
    
    private void PegaOrdemServicoItens(){
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
            + "from tb_os_itens where idEmpresa = " + bosi.idEmpresa + " and codigoOrdemServico = " + bosi.codigoOrdemServico + ";";
        dadosOrdemServicoItens.clear();
        dadosOrdemServicoItens = parametrosNS.dao.Consulta(sql);
        if(dadosOrdemServicoItens.isEmpty()){
            Mensagem = "Não foram encontrados itens cadastrados para a Ordem de Serviço n°" + bos.codigoOrdemServico + "!";
            dadosMensagens.add(Mensagem);
            return;
        }
        PegaDadosOrdemServicoItens();
    }
    
    private void PegaDadosOrdemServicoItens(){
        Valor = 0;
        for(int i = 0; i < dadosOrdemServicoItens.size(); i++){
            if(dadosOrdemServicoItens.get(i).get(0) != null){bosi.idOrdemServicoItem     = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(0)));}
            if(dadosOrdemServicoItens.get(i).get(1) != null){bosi.idEmpresa              = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(1)));}
            if(dadosOrdemServicoItens.get(i).get(2) != null){bosi.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(2)));}
            if(dadosOrdemServicoItens.get(i).get(3) != null){bosi.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(3)));}
            if(dadosOrdemServicoItens.get(i).get(4) != null){bosi.codigoOrdemServico     = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(4)));}
            if(dadosOrdemServicoItens.get(i).get(5) != null){bosi.codigoOrdemServicoItem = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(5)));}
            if(dadosOrdemServicoItens.get(i).get(6) != null){bosi.codigoUsuario          = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(6)));}
            if(dadosOrdemServicoItens.get(i).get(7) != null){bosi.valorUnitario          = Double.parseDouble(String.valueOf(dadosOrdemServicoItens.get(i).get(7)));}
            if(dadosOrdemServicoItens.get(i).get(8) != null){bosi.quantidade             = Double.parseDouble(String.valueOf(dadosOrdemServicoItens.get(i).get(8)));}
            if(dadosOrdemServicoItens.get(i).get(9) != null){bosi.valorTotal             = Double.parseDouble(String.valueOf(dadosOrdemServicoItens.get(i).get(9)));}
            
            Valor += bosi.valorTotal;
        }
    }
    
    private void PegaVendas(){
        TotalDaBarra++;
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
            + "   horaVenda \n"
            + "from tb_vendas where idEmpresa = " + parametrosNS.be.IdEmpresa + " and (status = 2) and dataVenda between " + dataInicial + " and " + dataFinal + ";";
        dadosVendas.clear();
        dadosVendas = parametrosNS.dao.Consulta(sql);
        if(dadosVendas.isEmpty()){
            Mensagem = "Não foram encontradas Vendas para o Intervalo selecionado!";
            dadosMensagens.add(Mensagem);
            return;
        }
    }
    
    private void PegaDadosVendas(String Mostra){
        Valor               = 0;
        NomeModulo          = "02-Vendas";
        ValorTotalModulos   = 0;
        int Tam             = 0;
        if(dadosVendas.size() < 2){Tam = dadosVendas.size();}else{Tam = dadosVendas.size() - 1;}
        if(Mostra.equals("S")){barra_progresso.setMaximum(Tam + barra_progresso.getMaximum() - 1);}
        if(!Mostra.equals("S"))contador++;
        for(int i = 0; i < dadosVendas.size(); i++){
            if(Mostra.equals("S"))contador++;
            bv = new BeanVendas();
            if(dadosVendas.get(i).get(0) != null){bv.idVenda          = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(0)));}
            if(dadosVendas.get(i).get(1) != null){bv.idEmpresa        = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(1)));}
            if(dadosVendas.get(i).get(2) != null){bv.codigoGrupo      = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(2)));}
            if(dadosVendas.get(i).get(3) != null){bv.codigoEmpresa    = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(3)));}
            if(dadosVendas.get(i).get(4) != null){bv.codigoVenda      = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(4)));}
            if(dadosVendas.get(i).get(5) != null){bv.codigoUsuario    = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(5)));}
            if(dadosVendas.get(i).get(6) != null){bv.codigoCliente    = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(6)));}
            if(dadosVendas.get(i).get(7) != null){bv.codigoComputador = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(7)));}
            if(dadosVendas.get(i).get(8) != null){bv.dataVenda        =                    String.valueOf(dadosVendas.get(i).get(8));}
            if(dadosVendas.get(i).get(9) != null){bv.horaVenda        =                    String.valueOf(dadosVendas.get(i).get(9));}
            
            bvp.idEmpresa       = bv.idEmpresa;
            bvp.codigoGrupo     = bv.codigoGrupo;
            bvp.codigoEmpresa   = bv.codigoEmpresa;
            bvp.codigoVenda     = bv.codigoVenda;
            PegaVendasPagamentos();
            
            SetaBarra();
            
            if(!Mostra.equals("S")){
                ValorTotalModulos           += Valor;
                ValorTotalMensaisEntradas   += Valor;
                continue;
            }
            
            bc.codigoCliente            = bv.codigoCliente;
            PegaCliente();
            NomeCliente                 = fc.FormataCampo(String.valueOf(bc.codigoCliente), 5, 0) + "-" + bc.nome;
            
            bvi.idEmpresa         = bv.idEmpresa;
            bvi.codigoGrupo       = bv.codigoGrupo;
            bvi.codigoEmpresa     = bv.codigoEmpresa;
            bvi.codigoVenda       = bv.codigoVenda;
            PegaVendasItens();
            
            ValorTotalEntradas += Valor;
            ValorTotal         += Valor;
            
            Tipo            = fc.FormataCampo("2", 2, 0) + "-Vendas";
            Lancamento      = fc.FormataCampo(String.valueOf(bv.codigoVenda), 9, 0);
            ValorTexto      = "(+) " + TransStrDou.TransformaValorStringeDouble(String.valueOf(Valor), 0);
            DataRegistro    = invdata.inverterData(bv.dataVenda, 1);
            
            TableDetalhesModulos.addRow(new Object[] {contador, NomeCliente, Tipo, Lancamento, ValorTexto, DataRegistro});
        }
        SetaBarra();
        if(!Mostra.equals("N"))return;
        ValorTexto  = "(+) " + TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotalModulos), 0);
        TableModulos.addRow(new Object[] {contador, NomeModulo, ValorTexto});
    }
    
    private void PegaVendasItens(){
        sql = "select * from tb_vendas_itens where idEmpresa = " + bvi.idEmpresa + " and codigoVenda = " + bvi.codigoVenda + ";";
        dadosVendasItens.clear();
        dadosVendasItens = parametrosNS.dao.Consulta(sql);
        if(dadosVendasItens.isEmpty()){
            Mensagem = "Não foram encontrados itens para a venda n°" + bv.codigoVenda + "!";
            dadosMensagens.add(Mensagem);
            return;
        }
        PegaDadosVendasItens();
    }
    
    private void PegaDadosVendasItens(){
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
            if(dadosVendasItens.get(i).get(11) != null){bvi.valorTotal          = Double.parseDouble(String.valueOf(dadosVendasItens.get(i).get(11)));}
            if(dadosVendasItens.get(i).get(12) != null){bvi.valorTotal          = Double.parseDouble(String.valueOf(dadosVendasItens.get(i).get(12)));}
        }
    }
    
    private void PegaVendasPagamentos(){
        sql = "select * from tb_vendas_pagamentos where idEmpresa = " + bvi.idEmpresa + " and codigoVenda = " + bvp.codigoVenda + ";";
        dadosVendasPagamentos.clear();
        dadosVendasPagamentos = parametrosNS.dao.Consulta(sql);
        if(dadosVendasPagamentos.isEmpty()){
            Mensagem = "Não foram encontrados pagamentos efetuados para a venda n°" + bv.codigoVenda + "!";
            dadosMensagens.add(Mensagem);
            return;
        }
        PegaDadosVendasPagamentos();
    }
    
    private void PegaDadosVendasPagamentos(){
        Valor = 0;
        for(int i = 0; i < dadosVendasPagamentos.size(); i++){
            bvp = new BeanVendasPagamentos();
            if(dadosVendasPagamentos.get(i).get(0) != null){bvp.idPagamento         = Integer.parseInt(  String.valueOf(dadosVendasPagamentos.get(i).get(0)));}
            if(dadosVendasPagamentos.get(i).get(1) != null){bvp.idEmpresa           = Integer.parseInt(  String.valueOf(dadosVendasPagamentos.get(i).get(1)));}
            if(dadosVendasPagamentos.get(i).get(2) != null){bvp.codigoGrupo         = Integer.parseInt(  String.valueOf(dadosVendasPagamentos.get(i).get(2)));}
            if(dadosVendasPagamentos.get(i).get(3) != null){bvp.codigoEmpresa       = Integer.parseInt(  String.valueOf(dadosVendasPagamentos.get(i).get(3)));}
            if(dadosVendasPagamentos.get(i).get(4) != null){bvp.codigoVenda         = Integer.parseInt(  String.valueOf(dadosVendasPagamentos.get(i).get(4)));}
            if(dadosVendasPagamentos.get(i).get(5) != null){bvp.codigoPagamento     = Integer.parseInt(  String.valueOf(dadosVendasPagamentos.get(i).get(5)));}
            if(dadosVendasPagamentos.get(i).get(6) != null){bvp.valorDoPagamento    = Double.parseDouble(String.valueOf(dadosVendasPagamentos.get(i).get(6)));}
            if(dadosVendasPagamentos.get(i).get(7) != null){bvp.trocoDoPagamento    = Double.parseDouble(String.valueOf(dadosVendasPagamentos.get(i).get(7)));}
            
            Valor                  += bvp.valorDoPagamento - bvp.trocoDoPagamento;
        }
    }
    
    private void PegaRecibos(){
        TotalDaBarra++;
        sql = "select * from tb_recibos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and (status = 2) and dataRecibo between " + dataInicial + " and " + dataFinal + ";";
        dadosRecibos.clear();
        dadosRecibos = parametrosNS.dao.Consulta(sql);
        if(dadosRecibos.isEmpty()){
            Mensagem = "Não foram encontradas Vendas para o Intervalo " + invdata.inverterData(dataInicial, 1) + " e " + invdata.inverterData(dataFinal, 1) + "!";
            dadosMensagens.add(Mensagem);
            return;
        }
    }
    
    private void PegaDadosRecibos(String Mostra){
        Valor               = 0;
        NomeModulo          = "11-Recebimento";
        ValorTotalModulos   = 0;
        int Tam             = 0;
        if(dadosRecibos.size() < 2){Tam = dadosRecibos.size();}else{Tam = dadosRecibos.size() - 1;}
        if(Mostra.equals("S")){barra_progresso.setMaximum(Tam);contador = 0;TableDetalhesModulos.setNumRows(0);}
        if(!Mostra.equals("S"))contador++;
        for(int i = 0; i < dadosRecibos.size(); i++){
            if(Mostra.equals("S"))contador++;
            br = new BeanRecibos();
            if(dadosRecibos.get(i).get(0)  != null){br.idRecibo             = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(0)));}
            if(dadosRecibos.get(i).get(1)  != null){br.idEmpresa            = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(1)));}
            if(dadosRecibos.get(i).get(2)  != null){br.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(2)));}
            if(dadosRecibos.get(i).get(3)  != null){br.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(3)));}
            if(dadosRecibos.get(i).get(4)  != null){br.codigoRecibo         = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(4)));}
            if(dadosRecibos.get(i).get(5)  != null){br.codigoCliente        = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(5)));}
            if(dadosRecibos.get(i).get(6)  != null){br.codigoUsuario        = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(6)));}
            if(dadosRecibos.get(i).get(7)  != null){br.dataRecibo           =                    String.valueOf(dadosRecibos.get(i).get(7));}
            if(dadosRecibos.get(i).get(8)  != null){br.horaRecibo           =                    String.valueOf(dadosRecibos.get(i).get(8));}
            if(dadosRecibos.get(i).get(9)  != null){br.status               = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(9)));}
            if(dadosRecibos.get(i).get(10) != null){br.observacoes          =                    String.valueOf(dadosRecibos.get(i).get(10));}
            if(dadosRecibos.get(i).get(11) != null){br.ocorrenciaRecibo     = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(11)));}
            if(dadosRecibos.get(i).get(12) != null){br.dataEmissaoLote      =                    String.valueOf(dadosRecibos.get(i).get(12));}
            
                
            brp.idEmpresa       = br.idEmpresa;
            brp.codigoGrupo     = br.codigoGrupo;
            brp.codigoEmpresa   = br.codigoEmpresa;
            brp.codigoRecibo    = br.codigoRecibo;
            PegaRecibosPagamentos();
            
            SetaBarra();
            
            if(!Mostra.equals("S")){
                ValorTotalModulos           += Valor;
                ValorTotalMensaisEntradas   += Valor;
                continue;
            }
            
            bc.codigoCliente            = br.codigoCliente;
            PegaCliente();
            NomeCliente                 = fc.FormataCampo(String.valueOf(bc.codigoCliente), 5, 0) + "-" + bc.nome;
            
            ValorTotalEntradas += Valor;
            ValorTotal         += Valor;
            
            Tipo            = fc.FormataCampo("11", 2, 0) + "-Recibos";
            Lancamento      = fc.FormataCampo(String.valueOf(br.codigoRecibo), 9, 0);
            ValorTexto      = "(+) " + TransStrDou.TransformaValorStringeDouble(String.valueOf(Valor), 0);
            DataRegistro    = invdata.inverterData(br.dataRecibo, 1);
            
            TableDetalhesModulos.addRow(new Object[] {contador, NomeCliente, Tipo, Lancamento, ValorTexto, DataRegistro});
        }
        SetaBarra();
        if(!Mostra.equals("N"))return;
        ValorTexto  = "(+) " + TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotalModulos), 0);
        TableModulos.addRow(new Object[] {contador, NomeModulo, ValorTexto});
    }
    
    private void PegaRecibosDetalhes(){
        brd.idEmpresa        = br.idEmpresa;
        brd.codigoGrupo      = br.codigoGrupo;
        brd.codigoEmpresa    = br.codigoEmpresa;
        brd.codigoRecibo     = br.codigoRecibo;
        sql = "select * from tb_recibos_detalhes where idEmpresa = " + brd.idEmpresa + " and codigoRecibo = " + brd.codigoRecibo + ";";
        dadosRecibosDetalhes.clear();
        dadosRecibosDetalhes = parametrosNS.dao.Consulta(sql);
        if(dadosRecibosDetalhes.isEmpty()){
            Mensagem = "Não foram encontrados itens para o recibo n°" + br.codigoRecibo + "!";
            dadosMensagens.add(Mensagem);
            return;
        }
        PegaDadosRecibosDetalhes();
    }
    
    private void PegaDadosRecibosDetalhes(){
        for(int i = 0; i < dadosRecibosDetalhes.size(); i++){
            brd = new BeanRecibosDetalhes();
            if(dadosRecibosDetalhes.get(i).get(0) != null){brd.idReciboDetalhes = Integer.parseInt(  String.valueOf(dadosRecibosDetalhes.get(i).get(0)));}
            if(dadosRecibosDetalhes.get(i).get(1) != null){brd.idEmpresa        = Integer.parseInt(  String.valueOf(dadosRecibosDetalhes.get(i).get(1)));}
            if(dadosRecibosDetalhes.get(i).get(2) != null){brd.codigoGrupo      = Integer.parseInt(  String.valueOf(dadosRecibosDetalhes.get(i).get(2)));}
            if(dadosRecibosDetalhes.get(i).get(3) != null){brd.codigoEmpresa    = Integer.parseInt(  String.valueOf(dadosRecibosDetalhes.get(i).get(3)));}
            if(dadosRecibosDetalhes.get(i).get(4) != null){brd.codigoRecibo     = Integer.parseInt(  String.valueOf(dadosRecibosDetalhes.get(i).get(4)));}
            if(dadosRecibosDetalhes.get(i).get(5) != null){brd.codigoReciboItem = Integer.parseInt(  String.valueOf(dadosRecibosDetalhes.get(i).get(5)));}
            if(dadosRecibosDetalhes.get(i).get(6) != null){brd.codigoServico    = Integer.parseInt(  String.valueOf(dadosRecibosDetalhes.get(i).get(6)));}
            if(dadosRecibosDetalhes.get(i).get(7) != null){brd.valorServico     = Double.parseDouble(String.valueOf(dadosRecibosDetalhes.get(i).get(7)));}
            if(dadosRecibosDetalhes.get(i).get(8) != null){brd.quantidade       = Integer.parseInt(  String.valueOf(dadosRecibosDetalhes.get(i).get(8)));}
            if(dadosRecibosDetalhes.get(i).get(9) != null){brd.valorTotal       = Double.parseDouble(String.valueOf(dadosRecibosDetalhes.get(i).get(9)));}
        }
    }
    
    private void PegaRecibosPagamentos(){
        sql = "select * from tb_recibos_pagamentos where idEmpresa = " + brp.idEmpresa + " and codigoRecibo = " + brd.codigoRecibo + ";";
        dadosRecibosPagamentos.clear();
        dadosRecibosPagamentos = parametrosNS.dao.Consulta(sql);
        if(dadosRecibosPagamentos.isEmpty()){
            Mensagem = "Não foram encontrados pagamentos efetuados para o recibo n°" + br.codigoRecibo + "!";
            dadosMensagens.add(Mensagem);
            return;
        }
        PegaDadosRecibosPagamentos();
    }
    
    private void PegaDadosRecibosPagamentos(){
        Valor = 0;
        for(int i = 0; i < dadosRecibosPagamentos.size(); i++){
            brp = new BeanRecibosPagamentos();
            if(dadosRecibosPagamentos.get(i).get(0) != null){brp.idRecibosPagamento  = Integer.parseInt(  String.valueOf(dadosRecibosPagamentos.get(i).get(0)));}
            if(dadosRecibosPagamentos.get(i).get(1) != null){brp.idEmpresa           = Integer.parseInt(  String.valueOf(dadosRecibosPagamentos.get(i).get(1)));}
            if(dadosRecibosPagamentos.get(i).get(2) != null){brp.codigoGrupo         = Integer.parseInt(  String.valueOf(dadosRecibosPagamentos.get(i).get(2)));}
            if(dadosRecibosPagamentos.get(i).get(3) != null){brp.codigoEmpresa       = Integer.parseInt(  String.valueOf(dadosRecibosPagamentos.get(i).get(3)));}
            if(dadosRecibosPagamentos.get(i).get(4) != null){brp.codigoRecibo        = Integer.parseInt(  String.valueOf(dadosRecibosPagamentos.get(i).get(4)));}
            if(dadosRecibosPagamentos.get(i).get(5) != null){brp.codigoPagamento     = Integer.parseInt(  String.valueOf(dadosRecibosPagamentos.get(i).get(5)));}
            if(dadosRecibosPagamentos.get(i).get(6) != null){brp.valorDoPagamento    = Double.parseDouble(String.valueOf(dadosRecibosPagamentos.get(i).get(6)));}
            if(dadosRecibosPagamentos.get(i).get(7) != null){brp.trocoDoPagamento    = Double.parseDouble(String.valueOf(dadosRecibosPagamentos.get(i).get(7)));}
            
            Valor                  += brp.valorDoPagamento - brp.trocoDoPagamento;
        }
    }
    //Termina Tabelas de Lucros
    
    //Inicia Tabelas de Despesas
    private void PegaAberturaCaixa(){
        TotalDaBarra++;
        sql = "select * from tb_caixa_abertura where idEmpresa = " + parametrosNS.be.IdEmpresa + " and dataAbertura between " + dataInicial + " and " + dataFinal + ";";
        dadosAberturaCaixa.clear();
        dadosAberturaCaixa = parametrosNS.dao.Consulta(sql);
        if(dadosAberturaCaixa.isEmpty()){
            Mensagem = "Não foram encontradas Aberturas de Caixa para o Intervalo selecionado!";
            dadosMensagens.add(Mensagem);
            return;
        }
    }
    
    private void PegaDadosAberturaCaixa(String Mostra){
        Valor               = 0;
        NomeModulo          = "02-Vendas";
        ValorTotalModulos   = 0;
        int Tam             = 0;
        if(dadosAberturaCaixa.size() < 2){Tam = dadosAberturaCaixa.size();}else{Tam = dadosAberturaCaixa.size() - 1;}
        if(Mostra.equals("S")){barra_progresso.setMaximum(Tam + barra_progresso.getMaximum() - 1);}
        if(!Mostra.equals("S"))contador++;
        for(int i = 0; i < dadosAberturaCaixa.size(); i++){
            if(Mostra.equals("S"))contador++;
            bca = new BeanCaixaAbertura();
            bca.idAbertura              = Integer.parseInt(  String.valueOf(dadosAberturaCaixa.get(i).get(0)));
            bca.idEmpresa               = Integer.parseInt(  String.valueOf(dadosAberturaCaixa.get(i).get(1)));
            bca.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosAberturaCaixa.get(i).get(2)));
            bca.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosAberturaCaixa.get(i).get(3)));
            bca.codigoAbertura          = Integer.parseInt(  String.valueOf(dadosAberturaCaixa.get(i).get(4)));
            bca.codigoComputador        = Integer.parseInt(  String.valueOf(dadosAberturaCaixa.get(i).get(5)));
            bca.codigoUsuario           = Integer.parseInt(  String.valueOf(dadosAberturaCaixa.get(i).get(6)));
            bca.dataAbertura            =                    String.valueOf(dadosAberturaCaixa.get(i).get(7));
            bca.horaAbertura            =                    String.valueOf(dadosAberturaCaixa.get(i).get(8));
            bca.valorDoCaixa            = Double.parseDouble(String.valueOf(dadosAberturaCaixa.get(i).get(9)));
            
            Valor                       = bca.valorDoCaixa;
            SetaBarra();
            
            if(!Mostra.equals("S")){
                ValorTotalModulos      += Valor;
                ValorTotalMensaisSaidas     += Valor;
                continue;
            }
            
            NomeCliente                 = "------------------------------";
            
            ValorTotalSaidas           += Valor;
            ValorTotal                 -= Valor;
            
            Tipo            = fc.FormataCampo("2", 2, 0) + "-Abertura de Caixa";
            Lancamento      = fc.FormataCampo(String.valueOf(bca.codigoAbertura), 9, 0);
            ValorTexto      = "(-) " + TransStrDou.TransformaValorStringeDouble(String.valueOf(Valor), 0);
            DataRegistro    = invdata.inverterData(bca.dataAbertura, 1);
            
            TableDetalhesModulos.addRow(new Object[] {contador, NomeCliente, Tipo, Lancamento, ValorTexto, DataRegistro});
        }
        SetaBarra();
        if(!Mostra.equals("N"))return;
        ValorTexto  = "(-) " + TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotalModulos), 0);
        TableModulos.addRow(new Object[] {contador, NomeModulo, ValorTexto});
    }
    
    private void PegaSaidaCaixa(){
        TotalDaBarra++;
        sql = "select idCaixaSaida, idEmpresa, codigoGrupo, codigoEmpresa, codigoCaixaSaida, codigoComputador, codigoAbertura, codigoMotivoSaida, codigoUsuario, dataSaidaCaixa, valorDeSaida from tb_caixa_saida where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoComputador = " + parametrosNS.bcomp.codigoComputador + " and dataSaidaCaixa between " + dataInicial + " and " + dataFinal + ";";
        dadosSaidaCaixa.clear();
        dadosSaidaCaixa = parametrosNS.dao.Consulta(sql);
        if(dadosSaidaCaixa.isEmpty()){
            Mensagem = "Não foram encontrado Saída de Caixa para o Intervalo selecionado!";
            dadosMensagens.add(Mensagem);
            return;
        }
    }
    
    private void PegaDadosSaidaCaixa(String Mostra){
        Valor               = 0;
        NomeModulo          = "02-Vendas";
        ValorTotalModulos   = 0;
        int Tam             = 0;
        if(dadosSaidaCaixa.size() < 2){Tam = dadosSaidaCaixa.size();}else{Tam = dadosSaidaCaixa.size() - 1;}
        if(Mostra.equals("S")){barra_progresso.setMaximum(Tam + barra_progresso.getMaximum() - 1);}
        if(!Mostra.equals("S"))contador++;
        for(int i = 0; i < dadosSaidaCaixa.size(); i++){
            if(Mostra.equals("S"))contador++;
            bcs = new BeanCaixaSaida();
            bcs.idCaixaSaida            = Integer.parseInt(  String.valueOf(dadosSaidaCaixa.get(i).get(0)));
            bcs.idEmpresa               = Integer.parseInt(  String.valueOf(dadosSaidaCaixa.get(i).get(1)));
            bcs.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosSaidaCaixa.get(i).get(2)));
            bcs.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosSaidaCaixa.get(i).get(3)));
            bcs.codigoCaixaSaida        = Integer.parseInt(  String.valueOf(dadosSaidaCaixa.get(i).get(4)));
            bcs.codigoComputador        = Integer.parseInt(  String.valueOf(dadosSaidaCaixa.get(i).get(5)));
            bcs.codigoAbertura          = Integer.parseInt(  String.valueOf(dadosSaidaCaixa.get(i).get(6)));
            bcs.codigoMotivoSaida       = Integer.parseInt(  String.valueOf(dadosSaidaCaixa.get(i).get(7)));
            bcs.codigoUsuario           = Integer.parseInt(  String.valueOf(dadosSaidaCaixa.get(i).get(8)));
            bcs.dataSaidaCaixa          =                    String.valueOf(dadosSaidaCaixa.get(i).get(9));
            bcs.valorDeSaida            = Double.parseDouble(String.valueOf(dadosSaidaCaixa.get(i).get(10)));
            
            Valor                       = bcs.valorDeSaida;
            SetaBarra();
            
            if(!Mostra.equals("S")){
                ValorTotalModulos      += Valor;
                ValorTotalMensaisSaidas     += Valor;
                continue;
            }
            
            NomeCliente                 = "------------------------------";
            
            ValorTotalSaidas           += Valor;
            ValorTotal                 -= Valor;
            
            Tipo            = fc.FormataCampo("2", 2, 0) + "-Saida de Caixa";
            Lancamento      = fc.FormataCampo(String.valueOf(bcs.codigoCaixaSaida), 6, 0);
            ValorTexto      = "(-) " + TransStrDou.TransformaValorStringeDouble(String.valueOf(Valor), 0);
            DataRegistro    = invdata.inverterData(bcs.dataSaidaCaixa, 1);
            
            TableDetalhesModulos.addRow(new Object[] {contador, NomeCliente, Tipo, Lancamento, ValorTexto, DataRegistro});
        }
        SetaBarra();
        if(!Mostra.equals("N"))return;
        ValorTexto  = "(-) " + TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotalModulos), 0);
        TableModulos.addRow(new Object[] {contador, NomeModulo, ValorTexto});
    }
    
    private void PegaDespesas(){
        TotalDaBarra++;
        sql = "select  \n"
              + "   idDespesa, \n"
              + "   idEmpresa, \n"
              + "   codigoGrupo, \n"
              + "   codigoEmpresa, \n"
              + "   codigoDespesa, \n"
              + "   codigoDespesaTipo, \n"
              + "   descricaoDespesa, \n"
              + "   valorDespesa, \n"
              + "   codigoUsuario, \n"
              + "   dataCadastro, \n"
              + "   horaCadastro, \n"
              + "   codigoDeBarras, \n"
              + "   qtdMeses, \n"
              + "   dataVencimento, \n"
              + "   codigoContaCorrente, \n"
              + "   dataPagamento, \n"
              + "   valorPago, \n"
              + "   codigoContaCorrenteDestino, \n"
              + "   transferencia \n"
              + "from \n"
              + "   tb_despesas where idEmpresa = " + parametrosNS.be.IdEmpresa + " and \n"
              + "   dataPagamento between " + dataInicial + " and " + dataFinal + ";";
        dadosDespesas.clear();
        dadosDespesas = parametrosNS.dao.Consulta(sql);
        if(dadosDespesas.isEmpty()){
            Mensagem = "Não foram encontradas despesas para o Intervalo selecionado!";
            dadosMensagens.add(Mensagem);
            return;
        }
    }
    
    private void PegaDadosDespesas(String Mostra){
        Valor               = 0;
        NomeModulo          = "07-Contas à Pagar";
        ValorTotalModulos   = 0;
        int Tam             = 0;
        if(dadosDespesas.size() < 2){Tam = dadosDespesas.size();}else{Tam = dadosDespesas.size() - 1;}
        if(Mostra.equals("S")){barra_progresso.setMaximum(Tam);contador = 0;TableDetalhesModulos.setNumRows(0);}
        if(!Mostra.equals("S"))contador++;
        for(int i = 0; i < dadosDespesas.size(); i++){
            if(Mostra.equals("S"))contador++;
            bdes = new BeanDespesas();
            if(dadosDespesas.get(i).get(0) != null)
                bdes.idDespesa               = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(0)));
            if(dadosDespesas.get(i).get(1) != null)
                bdes.idEmpresa               = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(1)));
            if(dadosDespesas.get(i).get(2) != null)
                bdes.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(2)));
            if(dadosDespesas.get(i).get(3) != null)
                bdes.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(3)));
            if(dadosDespesas.get(i).get(4) != null)
                bdes.codigoDespesa           = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(4)));
            if(dadosDespesas.get(i).get(5) != null)
                bdes.codigoDespesaTipo       = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(5)));
                bdes.descricaoDespesa        =                    String.valueOf(dadosDespesas.get(i).get(6));
            if(dadosDespesas.get(i).get(7) != null)
                bdes.valorDespesa            = Double.parseDouble(String.valueOf(dadosDespesas.get(i).get(7)));
            if(dadosDespesas.get(i).get(8) != null)
                bdes.codigoUsuario           = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(8)));
                bdes.dataCadastro            =                    String.valueOf(dadosDespesas.get(i).get(9));
                bdes.horaCadastro            =                    String.valueOf(dadosDespesas.get(i).get(10));
                bdes.codigoDeBarras          =                    String.valueOf(dadosDespesas.get(i).get(11));
            if(dadosDespesas.get(i).get(12) != null)
                bdes.qtdMeses                = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(12)));
                bdes.dataVencimento          =                    String.valueOf(dadosDespesas.get(i).get(13));
            if(dadosDespesas.get(i).get(14) != null)
                bdes.codigoContaCorrente     = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(14)));
                bdes.dataPagamento           =                    String.valueOf(dadosDespesas.get(i).get(15));
            if(dadosDespesas.get(i).get(16) != null)
                bdes.valorPago               = Double.parseDouble(String.valueOf(dadosDespesas.get(i).get(16)));
            if(dadosDespesas.get(i).get(17) != null)
                bdes.codigoContaCorrenteDestino  = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(17)));
            if(dadosDespesas.get(i).get(18) != null)
                bdes.transferencia           = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(18)));
            
            SetaBarra();
            Valor                       = bdes.valorPago;
            
            if(!Mostra.equals("S")){
                ValorTotalModulos           += Valor;
                ValorTotalMensaisSaidas     += Valor;
                continue;
            }
            
            NomeCliente                 = bdes.descricaoDespesa;
            
            ValorTotalSaidas           += Valor;
            ValorTotal                 -= Valor;
            
            Tipo            = fc.FormataCampo("7", 2, 0) + "-Despesas";
            Lancamento      = fc.FormataCampo(String.valueOf(bdes.codigoDespesa), 6, 0);
            ValorTexto      = "(-) " + TransStrDou.TransformaValorStringeDouble(String.valueOf(Valor), 0);
            DataRegistro    = invdata.inverterData(bdes.dataPagamento, 1);
            
            TableDetalhesModulos.addRow(new Object[] {contador, NomeCliente, Tipo, Lancamento, ValorTexto, DataRegistro});
        }
        SetaBarra();
        if(!Mostra.equals("N"))return;
        ValorTexto  = "(-) " + TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotalModulos), 0);
        TableModulos.addRow(new Object[] {contador, NomeModulo, ValorTexto});
    }
    
    private void PegaCliente(){
        bc.nome     = "----------";
        sql = "select idCliente, idEmpresa, codigoGrupo, codigoEmpresa, codigoCliente, nome from tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCliente = " + bc.codigoCliente + ";";
        dadosCliente.clear();
        dadosCliente = parametrosNS.dao.Consulta(sql);
        if(dadosCliente.isEmpty())return;
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
    
    private void IniciaCarregamentoTabelaMensal(){
        TableCompetencia.setNumRows(0);
        String Mes  = "";
        ValorTotalSomaGeralEntradas = 0;
        ValorTotalSomaGeralSaidas   = 0;
        ValorTotalSomaGeral         = 0;
        dadosMensagens      .clear();
        for(int i = 1; i < 13; i++){
            TotalDaBarra        = 0;
            binter.dataInicial  = Test.Testa("01" + fc.FormataCampo(String.valueOf(i), 2, 0) + fc.FormataCampo(txt_anoInicial.getText().replace(" ", ""), 4, 0));
            binter.dataFinal    = Test.Testa("31" + fc.FormataCampo(String.valueOf(i), 2, 0) + fc.FormataCampo(txt_anoFinal  .getText().replace(" ", ""), 4, 0));
            dataInicial         = String.valueOf(binter.dataInicial);
            dataFinal           = String.valueOf(binter.dataFinal);
            
            if(parametrosNS.bma.moduloCC             == 1 || parametrosNS.bm.moduloCC             == 1)if(check_saidas    .isSelected() == false)PegaBoletos();
            if(parametrosNS.bma.moduloProducao       == 1 || parametrosNS.bm.moduloProducao       == 1)if(check_saidas    .isSelected() == false)PegaOrdemServico();
            if(parametrosNS.bma.moduloVendas         == 1 || parametrosNS.bm.moduloVendas         == 1)if(check_saidas    .isSelected() == false)PegaVendas();
            if(parametrosNS.bma.moduloRecebimento    == 1 || parametrosNS.bm.moduloRecebimento    == 1)if(check_saidas    .isSelected() == false)PegaRecibos();
            if(parametrosNS.bma.moduloVendas         == 1 || parametrosNS.bm.moduloVendas         == 1)if(check_entradas  .isSelected() == false)PegaAberturaCaixa();
            if(parametrosNS.bma.moduloVendas         == 1 || parametrosNS.bm.moduloVendas         == 1)if(check_entradas  .isSelected() == false)PegaSaidaCaixa();
            if(parametrosNS.bma.moduloContasAPagar   == 1 || parametrosNS.bm.moduloContasAPagar   == 1)if(check_entradas  .isSelected() == false)PegaDespesas();
            
            barra_progresso.setMaximum(TotalDaBarra);
            
            ValorTotalMensaisEntradas   = 0;
            ValorTotalMensaisSaidas     = 0;
            ValorTotalMensaisGeral      = 0;
            contador                    = 0;
            if(parametrosNS.bma.moduloCC             == 1 || parametrosNS.bm.moduloCC             == 1)if(check_saidas    .isSelected() == false)PegaDadosBoletos      ("SN");
            if(parametrosNS.bma.moduloProducao       == 1 || parametrosNS.bm.moduloProducao       == 1)if(check_saidas    .isSelected() == false)PegaDadosOrdemServico ("SN");
            if(parametrosNS.bma.moduloVendas         == 1 || parametrosNS.bm.moduloVendas         == 1)if(check_saidas    .isSelected() == false)PegaDadosVendas       ("SN");
            if(parametrosNS.bma.moduloRecebimento    == 1 || parametrosNS.bm.moduloRecebimento    == 1)if(check_saidas    .isSelected() == false)PegaDadosRecibos      ("SN");
            if(parametrosNS.bma.moduloVendas         == 1 || parametrosNS.bm.moduloVendas         == 1)if(check_entradas  .isSelected() == false)PegaDadosAberturaCaixa("SN");
            if(parametrosNS.bma.moduloVendas         == 1 || parametrosNS.bm.moduloVendas         == 1)if(check_entradas  .isSelected() == false)PegaDadosSaidaCaixa   ("SN");
            if(parametrosNS.bma.moduloContasAPagar   == 1 || parametrosNS.bm.moduloContasAPagar   == 1)if(check_entradas  .isSelected() == false)PegaDadosDespesas     ("SN");
            
            switch(i){
                case  1: Mes = fc.FormataCampo(String.valueOf(i), 2, 0) + "-Janeiro";   break;
                case  2: Mes = fc.FormataCampo(String.valueOf(i), 2, 0) + "-Fevereiro"; break;
                case  3: Mes = fc.FormataCampo(String.valueOf(i), 2, 0) + "-Março";     break;
                case  4: Mes = fc.FormataCampo(String.valueOf(i), 2, 0) + "-Abril";     break;
                case  5: Mes = fc.FormataCampo(String.valueOf(i), 2, 0) + "-Maio";      break;
                case  6: Mes = fc.FormataCampo(String.valueOf(i), 2, 0) + "-Junho";     break;
                case  7: Mes = fc.FormataCampo(String.valueOf(i), 2, 0) + "-Julho";     break;
                case  8: Mes = fc.FormataCampo(String.valueOf(i), 2, 0) + "-Agosto";    break;
                case  9: Mes = fc.FormataCampo(String.valueOf(i), 2, 0) + "-Setembro";  break;
                case 10: Mes = fc.FormataCampo(String.valueOf(i), 2, 0) + "-Outubro";   break;
                case 11: Mes = fc.FormataCampo(String.valueOf(i), 2, 0) + "-Novembro";  break;
                case 12: Mes = fc.FormataCampo(String.valueOf(i), 2, 0) + "-Dezembro";  break;
            }
            
            ValorTotalSomaGeralEntradas    += ValorTotalMensaisEntradas ;
            ValorTotalSomaGeralSaidas      += ValorTotalMensaisSaidas   ;
            
            ValorTotalMensaisGeral   = ValorTotalMensaisEntradas - ValorTotalMensaisSaidas  ;
            ValorTexto = TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotalMensaisGeral), 0);
            if(ValorTotalMensaisGeral < 0){
                ValorTotalMensaisGeral     *= (-1);
                ValorTexto = "(-) " + TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotalMensaisGeral), 0);
            }
            
            TableCompetencia.addRow(new Object[] {Mes, fc.FormataCampo(bparges.dataGestao.substring(6, 10), 4, 0), TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotalMensaisEntradas), 0), TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotalMensaisSaidas  ), 0), });
        }
        ValorTotalSomaGeral                 = ValorTotalSomaGeralEntradas - ValorTotalSomaGeralSaidas  ;
        ValorTexto  = TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotalMensaisGeral), 0);
        if(ValorTotalSomaGeral < 0){
            ValorTotalSomaGeral         *= (-1);
            ValorTexto = "(-) " + TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotalSomaGeral), 0);
        }
        TableCompetencia.addRow(new Object[]{"", "Totais", TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotalSomaGeralEntradas), 0), TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotalSomaGeralSaidas  ), 0), ValorTexto});
    }
    
}
