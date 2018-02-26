package TelasFinanceiro;

import Beans.BeanContaCorrente;
import Beans.BeanDespesas;
import Beans.BeanDespesasTipo;
import Beans.BeanIntervalos;
import Beans.BeanUsuarios;
import BeansNS.BeanBanco;
import FuncoesInternas.AjustarLarguraColunas;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.TestarData;
import FuncoesInternas.TransformaValorStringeDouble;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/*
 @author Tiago e Paulo
 */
public class DespesasConsulta extends javax.swing.JFrame {
    //int
    int    Linha          = 0;
    int    abriuDespesa   = 0;
    int    dataVencimento = 0;
    int    dataPagamento  = 0;
    
    //String
    String sql                  = "";
    String mensagem             = "";
    String somostra             = "";
    String retorno              = "";
    String preenchimento        = "";
    
    //double
    double SomaValorDespesa = 0;
    double SomaValorPago    = 0;
    
    //Vetores
    ArrayList            parametros         = new ArrayList();
//    ArrayList            dadosPadroes       = new ArrayList();
    ArrayList<ArrayList> dadosDespesas      = new ArrayList();
    ArrayList<ArrayList> dadosDespesasTipo  = new ArrayList();
    ArrayList<ArrayList> dadosContaCorrente = new ArrayList();
    ArrayList<ArrayList> dadosUsuarios      = new ArrayList();
    
    //Beans
    BeanBanco           bb      = new BeanBanco();
    BeanBanco           bbo     = new BeanBanco();
    BeanBanco           bbd     = new BeanBanco();
    BeanDespesas        bd      = new BeanDespesas();
    BeanDespesasTipo    bdt     = new BeanDespesasTipo();
    BeanContaCorrente   bcc     = new BeanContaCorrente();
    BeanContaCorrente   bcco    = new BeanContaCorrente();
    BeanContaCorrente   bccd    = new BeanContaCorrente();
    BeanIntervalos      binter  = new BeanIntervalos();
    BeanUsuarios        bu      = new BeanUsuarios();
    
    //Funções
    DefaultTableModel               TableDespesa;
    FormataCampo                    fc          = new FormataCampo();
    InverterData                    invdata     = new InverterData();
    TestarData                      Test        = new TestarData();
    TransformaValorStringeDouble    TransStrDou = new TransformaValorStringeDouble();
    
    //Telas
    DespesasCadastro                    DesCad;
    DespesasTipoCadastro                DesTipoCad;
    
    public DespesasConsulta(String Somostra){
        somostra     = Somostra;
        
        initComponents();
    }
    
    private void InicializaCampos(){
        txt_codigoDespesaInicial        .setText(fc.FormataCampo("", 6, 0));
        txt_codigoDespesaFinal          .setText("999999");
        txt_dataVencimentoInicial       .setText(fc.FormataCampo("", 10, 2));
        txt_dataVencimentoFinal         .setText("99999999");
        txt_dataPagamentoInicial        .setText(fc.FormataCampo("", 10, 2));
        txt_dataPagamentoFinal          .setText("99999999");
        txt_descricaoDespesa            .setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_detalhes = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_descricaoDespesa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_dataVencimentoInicial = new javax.swing.JFormattedTextField();
        txt_dataVencimentoFinal = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_dataPagamentoInicial = new javax.swing.JFormattedTextField();
        txt_dataPagamentoFinal = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_codigoDespesaInicial = new javax.swing.JFormattedTextField();
        txt_codigoDespesaFinal = new javax.swing.JFormattedTextField();
        bt_sair = new javax.swing.JButton();
        bt_processa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_despesa = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        check_IgnorarTransferencias = new javax.swing.JCheckBox();
        jMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        bt_cadastrarDespesas = new javax.swing.JMenuItem();
        bt_cadastroDespesasTipo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        bt_sair1 = new javax.swing.JMenuItem();

        bt_detalhes.setText("Detalhes");
        bt_detalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_detalhesActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_detalhes);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de despesas e transferencias");
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
        jLabel1.setText("Intervalos de Consultas  F11[Geral]");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Descrição despesa:");

        txt_descricaoDespesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_descricaoDespesaKeyPressed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Data de vencimento:");

        try {
            txt_dataVencimentoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataVencimentoInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Inicial");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Final");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Inicial");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Final");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Data de pagamento:");

        try {
            txt_dataPagamentoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataPagamentoInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Código da despesa:");

        try {
            txt_codigoDespesaInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoDespesaInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoDespesaInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoDespesaInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoDespesaInicialFocusLost(evt);
            }
        });
        txt_codigoDespesaInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoDespesaInicialKeyPressed(evt);
            }
        });

        try {
            txt_codigoDespesaFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoDespesaFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoDespesaFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoDespesaFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoDespesaFinalFocusLost(evt);
            }
        });
        txt_codigoDespesaFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoDespesaFinalKeyPressed(evt);
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
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoDespesaInicial)
                    .addComponent(txt_dataPagamentoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_dataPagamentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_descricaoDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txt_codigoDespesaFinal)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_dataVencimentoInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_dataVencimentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(361, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, jLabel5, jLabel7, jLabel8, txt_codigoDespesaFinal, txt_codigoDespesaInicial, txt_dataPagamentoFinal, txt_dataPagamentoInicial, txt_dataVencimentoFinal, txt_dataVencimentoInicial});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoDespesaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoDespesaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txt_dataVencimentoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dataVencimentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_dataPagamentoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dataPagamentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txt_descricaoDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, jLabel2, jLabel3, jLabel7, jLabel8, jLabel9, txt_descricaoDespesa});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel4, txt_codigoDespesaInicial, txt_dataPagamentoInicial, txt_dataVencimentoInicial});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel5, txt_codigoDespesaFinal, txt_dataPagamentoFinal, txt_dataVencimentoFinal});

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        bt_processa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/1280454766_system-software-update.png"))); // NOI18N
        bt_processa.setText("Processa");
        bt_processa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_processaActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Despesas (Saídas e transferências)");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_despesa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_despesa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Código", "Tipo", "Descrição", "Valor devido", "Vencimento", "Número doc", "Banco de Origem", "Origem", "Banco de Destino", "Destino", "Pagamento", "Valor pago"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_despesa.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_despesa.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_despesa.getTableHeader().setReorderingAllowed(false);
        tabela_despesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_despesaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_despesa);
        if (tabela_despesa.getColumnModel().getColumnCount() > 0) {
            tabela_despesa.getColumnModel().getColumn(0).setResizable(false);
            tabela_despesa.getColumnModel().getColumn(1).setResizable(false);
            tabela_despesa.getColumnModel().getColumn(4).setResizable(false);
            tabela_despesa.getColumnModel().getColumn(5).setResizable(false);
            tabela_despesa.getColumnModel().getColumn(6).setResizable(false);
            tabela_despesa.getColumnModel().getColumn(7).setResizable(false);
            tabela_despesa.getColumnModel().getColumn(9).setResizable(false);
            tabela_despesa.getColumnModel().getColumn(11).setResizable(false);
            tabela_despesa.getColumnModel().getColumn(12).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addGap(11, 11, 11))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        check_IgnorarTransferencias.setText("Ignorar transfêrencias");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(check_IgnorarTransferencias)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(check_IgnorarTransferencias)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jMenu1.setText("Arquivo");

        jMenu2.setText("Cadastro");

        bt_cadastrarDespesas.setText("Despesas");
        bt_cadastrarDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastrarDespesasActionPerformed(evt);
            }
        });
        jMenu2.add(bt_cadastrarDespesas);

        bt_cadastroDespesasTipo.setText("Tipo de Despesas");
        bt_cadastroDespesasTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastroDespesasTipoActionPerformed(evt);
            }
        });
        jMenu2.add(bt_cadastroDespesasTipo);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bt_processa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_sair))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_sair)
                    .addComponent(bt_processa, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_processa, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_processaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_processaActionPerformed
        PegaValores();
    }//GEN-LAST:event_bt_processaActionPerformed

    private void txt_codigoDespesaInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoDespesaInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoDespesaFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoDespesaInicial.setText(fc.FormataCampo("", 6, 0));
            txt_codigoDespesaFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoDespesaInicialKeyPressed

    private void txt_codigoDespesaFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoDespesaFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataVencimentoInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoDespesaFinal.setText("999999");
            txt_dataVencimentoInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoDespesaFinalKeyPressed

    private void txt_dataVencimentoInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataVencimentoInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataVencimentoFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataVencimentoInicial.setText(fc.FormataCampo("", 10, 2));
            txt_dataVencimentoFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataVencimentoInicialKeyPressed

    private void txt_dataVencimentoFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataVencimentoFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataPagamentoInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataVencimentoFinal.setText("99999999");
            txt_dataPagamentoInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataVencimentoFinalKeyPressed

    private void txt_descricaoDespesaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descricaoDespesaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            bt_processa.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_descricaoDespesa.setText("");
            bt_processa.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_descricaoDespesaKeyPressed

    private void txt_dataPagamentoInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataPagamentoInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataPagamentoFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataPagamentoInicial.setText(fc.FormataCampo("", 10, 2));
            txt_dataPagamentoFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataPagamentoInicialKeyPressed

    private void txt_dataPagamentoFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataPagamentoFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_descricaoDespesa.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataPagamentoFinal.setText("99999999");
            txt_descricaoDespesa.grabFocus();
        }
    }//GEN-LAST:event_txt_dataPagamentoFinalKeyPressed

    private void txt_codigoDespesaInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoDespesaInicialFocusLost
        txt_codigoDespesaInicial.setText(fc.FormataCampo(txt_codigoDespesaInicial.getText(), 6, 0));
    }//GEN-LAST:event_txt_codigoDespesaInicialFocusLost

    private void txt_codigoDespesaFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoDespesaFinalFocusLost
        txt_codigoDespesaFinal.setText(fc.FormataCampo(txt_codigoDespesaFinal.getText(), 6, 0));
    }//GEN-LAST:event_txt_codigoDespesaFinalFocusLost

    private void txt_dataVencimentoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVencimentoInicialFocusLost
        txt_dataVencimentoInicial.setText(fc.FormataCampo(txt_dataVencimentoInicial.getText(),10, 2));
    }//GEN-LAST:event_txt_dataVencimentoInicialFocusLost

    private void txt_dataVencimentoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVencimentoFinalFocusLost
        txt_dataVencimentoFinal.setText(fc.FormataCampo(txt_dataVencimentoFinal.getText(),10, 2));
    }//GEN-LAST:event_txt_dataVencimentoFinalFocusLost

    private void txt_dataPagamentoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataPagamentoInicialFocusLost
        txt_dataPagamentoInicial.setText(fc.FormataCampo(txt_dataPagamentoInicial.getText(),10, 2));
    }//GEN-LAST:event_txt_dataPagamentoInicialFocusLost

    private void txt_dataPagamentoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataPagamentoFinalFocusLost
        txt_dataPagamentoFinal.setText(fc.FormataCampo(txt_dataPagamentoFinal.getText(),10, 2));
    }//GEN-LAST:event_txt_dataPagamentoFinalFocusLost

    private void tabela_despesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_despesaMouseClicked
        Linha = tabela_despesa.getSelectedRow();
        if(Linha < 0){
            mensagem = "Item não selecionado!";
            new MostraMensagem(mensagem);
            return;
        }
        if(Linha == tabela_despesa.getRowCount() - 1)
            return;
        if(evt.getButton() == MouseEvent.BUTTON3)
            if(somostra.equals("N"))
                MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
        retorno = String.valueOf(Integer.parseInt(String.valueOf(tabela_despesa.getValueAt(Linha, 0))));
        if(evt.getClickCount() < 2)
            return;
        dispose();
    }//GEN-LAST:event_tabela_despesaMouseClicked

    private void bt_detalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesActionPerformed
        if(DesCad != null)if(DesCad.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        DesCad = new DespesasCadastro("S", Integer.parseInt(retorno));
        DesCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesActionPerformed

    private void bt_cadastrarDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastrarDespesasActionPerformed
        if(DesCad != null)if(DesCad.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        abriuDespesa = 0;
        DesCad = new DespesasCadastro("SN", 0);
        DesCad.setVisible(true);
    }//GEN-LAST:event_bt_cadastrarDespesasActionPerformed

    private void bt_cadastroDespesasTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastroDespesasTipoActionPerformed
        if(DesTipoCad != null)if(DesTipoCad.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        DesTipoCad = new DespesasTipoCadastro(parametros);
        DesTipoCad.setVisible(true);
    }//GEN-LAST:event_bt_cadastroDespesasTipoActionPerformed

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        TableDespesa        = (DefaultTableModel)tabela_despesa.getModel();
        
        InicializaCampos();
        PegaValores();
        if(parametrosNS.bu.nivelUsuario  < 4 | somostra.equals("S"))
            jMenu.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(DesCad      != null)DesCad       .dispose();
        if(DesTipoCad  != null)DesTipoCad   .dispose();
    }//GEN-LAST:event_formWindowClosed

    private void txt_codigoDespesaInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoDespesaInicialFocusGained
        txt_codigoDespesaInicial.setSelectionStart(0);
        txt_codigoDespesaInicial.setSelectionEnd  (txt_codigoDespesaFinal.getText().length());
    }//GEN-LAST:event_txt_codigoDespesaInicialFocusGained

    private void txt_codigoDespesaFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoDespesaFinalFocusGained
        txt_codigoDespesaFinal.setSelectionStart(0);
        txt_codigoDespesaFinal.setSelectionEnd  (txt_codigoDespesaFinal.getText().length());
    }//GEN-LAST:event_txt_codigoDespesaFinalFocusGained

    private void txt_dataVencimentoInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVencimentoInicialFocusGained
        txt_dataVencimentoInicial.setSelectionStart(0);
        txt_dataVencimentoInicial.setSelectionEnd  (txt_dataVencimentoInicial.getText().length());
    }//GEN-LAST:event_txt_dataVencimentoInicialFocusGained

    private void txt_dataVencimentoFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVencimentoFinalFocusGained
        txt_dataVencimentoFinal.setSelectionStart(0);
        txt_dataVencimentoFinal.setSelectionEnd  (txt_dataVencimentoFinal.getText().length());
    }//GEN-LAST:event_txt_dataVencimentoFinalFocusGained

    private void txt_dataPagamentoInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataPagamentoInicialFocusGained
        txt_dataPagamentoInicial.setSelectionStart(0);
        txt_dataPagamentoInicial.setSelectionEnd  (txt_dataPagamentoInicial.getText().length());
    }//GEN-LAST:event_txt_dataPagamentoInicialFocusGained

    private void txt_dataPagamentoFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataPagamentoFinalFocusGained
        txt_dataPagamentoFinal.setSelectionStart(0);
        txt_dataPagamentoFinal.setSelectionEnd  (txt_dataPagamentoFinal.getText().length());
    }//GEN-LAST:event_txt_dataPagamentoFinalFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_cadastrarDespesas;
    private javax.swing.JMenuItem bt_cadastroDespesasTipo;
    private javax.swing.JMenuItem bt_detalhes;
    private javax.swing.JButton bt_processa;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JCheckBox check_IgnorarTransferencias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable tabela_despesa;
    private javax.swing.JFormattedTextField txt_codigoDespesaFinal;
    private javax.swing.JFormattedTextField txt_codigoDespesaInicial;
    private javax.swing.JFormattedTextField txt_dataPagamentoFinal;
    private javax.swing.JFormattedTextField txt_dataPagamentoInicial;
    private javax.swing.JFormattedTextField txt_dataVencimentoFinal;
    private javax.swing.JFormattedTextField txt_dataVencimentoInicial;
    private javax.swing.JTextField txt_descricaoDespesa;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
    private void PegaValores(){
        binter.codigoDespesaInicial         = Integer.parseInt(txt_codigoDespesaInicial.getText());
        binter.codigoDespesaFinal           = Integer.parseInt(txt_codigoDespesaFinal.getText());
        if(binter.codigoDespesaInicial  > binter.codigoDespesaFinal){
            mensagem = "Código de Despesa Inicial não pode ser maior do que o código de Despesa Final!";
            new MostraMensagem(mensagem);
            return;
        }
        
        binter.dataVencimentoInicial        = Test.Testa(txt_dataVencimentoInicial.getText());
        binter.dataVencimentoFinal          = Test.Testa(txt_dataVencimentoFinal.getText());
        if(binter.dataVencimentoInicial > binter.dataVencimentoFinal){
            mensagem = "Data de Vencimento Inicial não pode ser maior do que a data de Vencimento Final!";
            new MostraMensagem(mensagem);
            return;
        }
        preenchimento = "";
        if(binter.dataVencimentoInicial != 0 || binter.dataVencimentoFinal != 99999999){
            preenchimento += "\n and ";
            preenchimento += "(dataVencimento between " + binter.dataVencimentoInicial + " and " + binter.dataVencimentoFinal + " \n";
        }
        
        binter.dataPagamentoInicial         = Test.Testa(txt_dataPagamentoInicial.getText());
        binter.dataPagamentoFinal           = Test.Testa(txt_dataPagamentoFinal.getText());
        if(binter.dataPagamentoInicial  > binter.dataPagamentoFinal){
            mensagem = "Data de Pagamento Inicial não pode ser maior do que a data de Pagamento Final!";
            new MostraMensagem(mensagem);
            return;
        }
        if(binter.dataPagamentoInicial != 0 || binter.dataPagamentoFinal != 99999999){
            if(!preenchimento.equals("")){
                preenchimento += "\n or ";
                preenchimento += "dataPagamento between " + binter.dataPagamentoInicial + " and " + binter.dataPagamentoFinal + ") \n";
            }else{
                preenchimento += "\n and (";
                preenchimento += "dataPagamento between " + binter.dataPagamentoInicial + " and " + binter.dataPagamentoFinal + ") \n";
            }
        }else
            if(!preenchimento.equals(""))
                preenchimento   += ") \n";
        
        binter.descricaoDespesa             = txt_descricaoDespesa.getText();
        if(!binter.descricaoDespesa.equals(""))
            preenchimento += " and descricaoDespesa like '%" + binter.descricaoDespesa + "%' \n";
        
        if(check_IgnorarTransferencias.isSelected())
            preenchimento += " and transferencia = 0 \n";
        
        PegaDespesas();
    }
    
    private void PegaDespesas(){
        sql = "select \n"
            + "   idDespesa, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoDespesa, \n"
            + "   descricaoDespesa, \n"
            + "   transferencia, \n"
            + "   codigoDespesaTipo, \n"
            + "   valorDespesa, \n"
            + "   dataVencimento, \n"
            + "   codigoDeBarras, \n"
            + "   idContaCorrente, \n"
            + "   idContaCorrenteDestino, \n"
            + "   dataPagamento, \n"
            + "   valorPago \n"
            + "from tb_despesas where idEmpresa = " + parametrosNS.be.IdEmpresa + "\n"
            + preenchimento
            + "   order by idDespesa desc;";
//        System.out.println(sql);
        dadosDespesas.clear();
        dadosDespesas = parametrosNS.dao.Consulta(sql);
        PegaDadosDespesas();
    }
    
    private void PegaDadosDespesas(){
        //Largura
        tabela_despesa.getColumnModel().getColumn(1).setPreferredWidth(55);  //Codigo
        tabela_despesa.getColumnModel().getColumn(3).setPreferredWidth(160); //Tipo
        tabela_despesa.getColumnModel().getColumn(2).setPreferredWidth(170); //Descrição
        tabela_despesa.getColumnModel().getColumn(4).setPreferredWidth(70);  //Valor devido
        tabela_despesa.getColumnModel().getColumn(5).setPreferredWidth(80);  //Vencimento
        tabela_despesa.getColumnModel().getColumn(6).setPreferredWidth(100); //Número doc
        tabela_despesa.getColumnModel().getColumn(7).setPreferredWidth(150); //Banco de origem
        tabela_despesa.getColumnModel().getColumn(8).setPreferredWidth(100); //Conta origem
        tabela_despesa.getColumnModel().getColumn(9).setPreferredWidth(150); //Banco de  destino
        tabela_despesa.getColumnModel().getColumn(10).setPreferredWidth(100); //Conta destino
        tabela_despesa.getColumnModel().getColumn(11).setPreferredWidth(80);  //Pagamento
        tabela_despesa.getColumnModel().getColumn(12).setPreferredWidth(70);  //Valor pago
        
        //Redimensionavel
//        tabela_despesa.getColumnModel().getColumn(0).setResizable(false);
//        tabela_despesa.getColumnModel().getColumn(1).setResizable(false);
//        tabela_despesa.getColumnModel().getColumn(2).setResizable(false);
//        tabela_despesa.getColumnModel().getColumn(3).setResizable(false);
//        tabela_despesa.getColumnModel().getColumn(4).setResizable(false);
//        tabela_despesa.getColumnModel().getColumn(5).setResizable(false);
//        tabela_despesa.getColumnModel().getColumn(6).setResizable(false);
//        tabela_despesa.getColumnModel().getColumn(7).setResizable(false);
//        tabela_despesa.getColumnModel().getColumn(8).setResizable(false);

        tabela_despesa.getColumnModel().getColumn(0).setPreferredWidth(0);  //id
        tabela_despesa.getColumnModel().getColumn(0).setMaxWidth(0);  //Ocultar a CI de controle 25/04/2017
        tabela_despesa.getColumnModel().getColumn(0).setMinWidth(0);  
        tabela_despesa.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);  
        tabela_despesa.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0); 
        
        TableDespesa.setNumRows(0);
        
        SomaValorDespesa    = 0;
        SomaValorPago       = 0;
        
        String nomeBancoOrigem      = "";
        String agenciaOrigem        = "";
        String contaCorrenteOrigem  = "";
        String nomeBancoDestino     = "";
        String agenciaDestino       = "";
        String contaCorrenteDestino = "";
        String valorDespesa         = "";
        for(int i = 0; i < dadosDespesas.size(); i++){
            bd = new BeanDespesas();
            
            bd.idDespesa            = Integer.parseInt  ((String) dadosDespesas.get(i).get(0));
            bd.idEmpresa            = Integer.parseInt  ((String) dadosDespesas.get(i).get(1));
            bd.codigoGrupo          = Integer.parseInt  ((String) dadosDespesas.get(i).get(2));
            bd.codigoEmpresa        = Integer.parseInt  ((String) dadosDespesas.get(i).get(3));
            bd.codigoDespesa        = Integer.parseInt  ((String) dadosDespesas.get(i).get(4));
            bd.descricaoDespesa     =                    (String) dadosDespesas.get(i).get(5);
            bd.transferencia        = Integer.parseInt  ((String) dadosDespesas.get(i).get(6));
            
            if(bd.transferencia == 0){
                bd.codigoDespesaTipo    = Integer.parseInt  ((String) dadosDespesas.get(i).get(7));
            }else{
                bd.codigoDespesaTipo    = 0;
            }
            
            if(bd.transferencia == 0){
                bd.valorDespesa     = Double.parseDouble((String) dadosDespesas.get(i).get(8));
            }else{
                bd.valorDespesa     = 0;
            }
            
            if(bd.transferencia == 0){
                bd.dataVencimento   =                    (String) dadosDespesas.get(i).get(9);
            }else{
                bd.dataVencimento   = "----------";
            }
            bd.codigoDeBarras       =                    (String) dadosDespesas.get(i).get(10);
            bd.codigoContaCorrente  = Integer.parseInt  ((String) dadosDespesas.get(i).get(11));
            
            if(bd.transferencia == 0){
                bd.codigoContaCorrenteDestino = 0;// Se não tiver conta corrente
            }else{
                bd.codigoContaCorrenteDestino = Integer.parseInt  ((String) dadosDespesas.get(i).get(12));
            }
            
            bd.dataPagamento        =                    (String) dadosDespesas.get(i).get(13);
            if(dadosDespesas.get(i).get(10) != null){
                bd.valorPago            = Double.parseDouble((String) dadosDespesas.get(i).get(14));
            }
            
            if(!bd.dataVencimento.replace("-", "").equals("")){
                bd.dataVencimento   = invdata.inverterData(bd.dataVencimento, 1);
            }
            if(bd.dataPagamento != null){
                bd.dataPagamento    = invdata.inverterData(bd.dataPagamento, 1);
            }else{
                bd.dataPagamento    = "----------";
            }
            
            if(bd.valorDespesa == 0){
                valorDespesa    = "----------";
            }else{
                valorDespesa    = TransStrDou.TransformaValorStringeDouble(String.valueOf(bd.valorDespesa), 0);
            }
            
            bdt.codigoDespesaTipo       = bd.codigoDespesaTipo;
            PegaDespesasTipo();
            if(bd.transferencia == 0){
                if(bdt.codigoDespesaTipo != 0){
                    bdt.descricaoDespesaTipo    = fc.FormataCampo(String.valueOf(bdt.codigoDespesaTipo), 2, 0) + "-" + bdt.descricaoDespesaTipo;
                }
            }else{
                bdt.descricaoDespesaTipo        = "99-Transferência";
            }
                
            bcco.codigoContaCorrente = bd.codigoContaCorrente;
            bcc.idEmpresa            = bd.idEmpresa;
            bcc.codigoGrupo          = bd.codigoGrupo;
            bcc.codigoEmpresa        = bd.codigoEmpresa;
            bcc.codigoContaCorrente  = bcco.codigoContaCorrente;
            PegaContaCorrente("O");
            
            bccd.codigoContaCorrente = bd.codigoContaCorrenteDestino;
            bcc.idEmpresa            = bd.idEmpresa;
            bcc.codigoGrupo          = bd.codigoGrupo;
            bcc.codigoEmpresa        = bd.codigoEmpresa;
            bcc.codigoContaCorrente  = bccd.codigoContaCorrente;
            PegaContaCorrente("D");
            
            if(bd.codigoDeBarras == null){
                bd.codigoDeBarras = "---------------";
            }
            if(bd.codigoDeBarras.equals("")){
                bd.codigoDeBarras = "---------------";
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
            
            if(bd.transferencia == 0){
                agenciaDestino      = "---------------";
                nomeBancoDestino    = "---------------";
            }
            
            SomaValorDespesa       += bd.valorDespesa;
            SomaValorPago          += bd.valorPago;
            
            TableDespesa.addRow(new Object[] {fc.FormataCampo(String.valueOf(bd.idDespesa), 9, 0), fc.FormataCampo(String.valueOf(bd.codigoDespesa), 6, 0), bdt.descricaoDespesaTipo, bd.descricaoDespesa, valorDespesa, bd.dataVencimento, bd.codigoDeBarras, nomeBancoOrigem, agenciaOrigem, nomeBancoDestino, agenciaDestino, bd.dataPagamento, TransStrDou.TransformaValorStringeDouble(String.valueOf(bd.valorPago), 0)});
        }
        if(TableDespesa.getRowCount() > 0)
            TableDespesa.addRow(new Object[] {"", "", "TOTAIS", "", TransStrDou.TransformaValorStringeDouble(String.valueOf(SomaValorDespesa), 0), "", "", "", "", "", "", "", TransStrDou.TransformaValorStringeDouble(String.valueOf(SomaValorPago), 0)});
        new AjustarLarguraColunas(tabela_despesa);
    }
    
    private void PegaContaCorrente(String tipo){
        if(bcc.idContaCorrente == 0){
            return;
        }
        sql = "select "
                + "nsban.id, "
                + "nsban.nomeBanco, "
                + "nsban.codigoBanco, "
                + "cc.numeroAgencia, "
                + "cc.digitoVerificadorAgencia, "
                + "cc.numeroContaCorrente, "
                + "cc.digitoVerificador, "
                + "cc.descricao "
                + "from "
                    + "tb_contacorrente cc "
                    + "inner join ns_bancos nsban on (cc.idBanco = nsban.id)"
                    + " where cc.idEmpresa = " + bcc.idEmpresa + " and cc.codigoContaCorrente = " + bcc.codigoContaCorrente + ";";
        dadosContaCorrente.clear();
        dadosContaCorrente = parametrosNS.dao.Consulta(sql);
        if(dadosContaCorrente.isEmpty()){
            if(tipo.equalsIgnoreCase("O"))
                mensagem = "Conta corrente de Origem não encontrada!";
            else
                mensagem = "Conta corrente de Destino não encontrada!";
            new MostraMensagem(mensagem);
            return;
        }
        PegaDadosContaCorrente(tipo);
    }
    
    private void PegaDadosContaCorrente(String tipo){
        bbd     = new BeanBanco();
        bccd    = new BeanContaCorrente();
        if(tipo.equalsIgnoreCase("O")){
            bbo.idBanco                     = Integer.parseInt  (String.valueOf(dadosContaCorrente.get(0).get(0)));
            bbo.nomeBanco                   = String.valueOf    (dadosContaCorrente.get(0).get(1));
            bbo.codigoBanco                 = String.valueOf    (dadosContaCorrente.get(0).get(2));
            bcco.numeroAgencia              = Integer.parseInt  (String.valueOf(dadosContaCorrente.get(0).get(3)));
            if(dadosContaCorrente.get(0).get(4) != null)
                bcco.digitoVerificadorAgencia   = Integer.parseInt  (String.valueOf(dadosContaCorrente.get(0).get(4)));
            bcco.numeroContaCorrente        = Integer.parseInt  (String.valueOf(dadosContaCorrente.get(0).get(5)));
            bcco.digitoVerificador          = Integer.parseInt  (String.valueOf(dadosContaCorrente.get(0).get(6)));
            bcco.descricao                  = String.valueOf    (dadosContaCorrente.get(0).get(7));
            return;
        }
        bbd.idBanco                     = Integer.parseInt  (String.valueOf(dadosContaCorrente.get(0).get(0)));
        bbd.nomeBanco                   = String.valueOf    (dadosContaCorrente.get(0).get(1));
        bbd.codigoBanco                 = String.valueOf    (dadosContaCorrente.get(0).get(2));
        bccd.numeroAgencia              = Integer.parseInt  (String.valueOf(dadosContaCorrente.get(0).get(3)));
        if(dadosContaCorrente.get(0).get(4) != null)
            bccd.digitoVerificadorAgencia   = Integer.parseInt  (String.valueOf(dadosContaCorrente.get(0).get(4)));
        bccd.numeroContaCorrente        = Integer.parseInt  (String.valueOf(dadosContaCorrente.get(0).get(5)));
        bccd.digitoVerificador          = Integer.parseInt  (String.valueOf(dadosContaCorrente.get(0).get(6)));
        bccd.descricao                  = String.valueOf    (dadosContaCorrente.get(0).get(7));
    }

    private void PegaUsuario() {
        sql = "select usuario from tb_usuarios where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
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
        for(int i = 0; i < dadosUsuarios.size(); i++)
            bu.usuario = String.valueOf(dadosUsuarios.get(i).get(0));
    }
    
    private void PegaDespesasTipo(){
        bdt.descricaoDespesaTipo = "----------";
        if(bdt.idDespesaTipo == 0)
            return;
        sql = "select idDespesaTipo, idEmpresa, codigoGrupo, codigoEmpresa, codigoDespesaTipo, descricaoDespesaTipo from tb_despesas_tipo where idDespesaTipo = " + bdt.idDespesaTipo + ";";
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
            bdt.idDespesaTipo         = Integer.parseInt(  String.valueOf(dadosDespesasTipo.get(i).get(0)));
            bdt.idEmpresa             = Integer.parseInt(  String.valueOf(dadosDespesasTipo.get(i).get(1)));
            bdt.codigoGrupo           = Integer.parseInt(  String.valueOf(dadosDespesasTipo.get(i).get(2)));
            bdt.codigoEmpresa         = Integer.parseInt(  String.valueOf(dadosDespesasTipo.get(i).get(3)));
            bdt.codigoDespesaTipo     = Integer.parseInt(  String.valueOf(dadosDespesasTipo.get(i).get(4)));
            bdt.descricaoDespesaTipo  =                    String.valueOf(dadosDespesasTipo.get(i).get(5));
        }
    }
    
}
