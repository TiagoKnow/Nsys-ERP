package TelasFaturamento;

import Beans.BeanClientes;
import Beans.BeanContratos;
import Beans.BeanIntervalos;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.TestarData;
import FuncoesInternas.TransformaValorStringeDouble;
import TelasContasCorrente.GerarBoletoBradesco;
import TelasContasCorrente.GerarBoletoHsbc;
import TelasContasCorrente.GerarBoletoItau;
import TelasContasCorrente.GerarBoletoSantander;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/*
 @author Tiago e Paulo
 */
public class ContratosCobranca extends javax.swing.JFrame {
    //String's
    String sql              = "";
    String sqlstate         = "";
    String Mensagem         = "";
    String retorno          = "";
    String Campo            = "";
    String StatusContrato   = "";
    
    //int's
    int    Linha        = 0;
    int    abriuCliente = 0;
    
    //Vetores
    ArrayList            parametros     = new ArrayList();
    ArrayList<ArrayList> dadosContratos = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosCliente   = new ArrayList<ArrayList>();
    
    //Bean's
    BeanClientes                    bc      = new BeanClientes();
    BeanContratos                   bcon    = new BeanContratos();
    BeanIntervalos                  binter  = new BeanIntervalos();
    
    //Especiais
    DefaultTableModel               TableContratos;
    FormataCampo                    fc          = new FormataCampo();
    TestarData                      Test        = new TestarData();
    InverterData                    invdata     = new InverterData();
    TransformaValorStringeDouble    TransStrDou = new TransformaValorStringeDouble();
    
    //Telas
    GerarBoletoItau                     GerBolItau;
    GerarBoletoHsbc                     GerBolHsbc;
    GerarBoletoSantander                GerBolSant;
    GerarBoletoBradesco                 GerBolBrad;
    ClientesConsulta                    CliCon;
    
    public ContratosCobranca(){
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        jMenu1 = new javax.swing.JMenu();
        bt_boletoitau = new javax.swing.JMenuItem();
        bt_boletohsbc = new javax.swing.JMenuItem();
        bt_boletosantander = new javax.swing.JMenuItem();
        bt_boletobradesco = new javax.swing.JMenuItem();
        bt_consultarContratosFaturados = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_contratos = new javax.swing.JTable();
        bt_imprimir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_MesAnoInicial = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_MesAnoFinal = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_codigoClienteInicial = new javax.swing.JFormattedTextField();
        txt_codigoClienteFinal = new javax.swing.JFormattedTextField();
        bt_pesquisaClienteInicial = new javax.swing.JButton();
        bt_pesquisaClienteFinal = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_codigoContratoInicial = new javax.swing.JFormattedTextField();
        txt_codigoContratoFinal = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        bt_processa = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();

        jMenu1.setText("Gerar Boleto");

        bt_boletoitau.setText("Itaú");
        bt_boletoitau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_boletoitauActionPerformed(evt);
            }
        });
        jMenu1.add(bt_boletoitau);

        bt_boletohsbc.setText("HSBC");
        bt_boletohsbc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_boletohsbcActionPerformed(evt);
            }
        });
        jMenu1.add(bt_boletohsbc);

        bt_boletosantander.setText("Santander");
        bt_boletosantander.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_boletosantanderActionPerformed(evt);
            }
        });
        jMenu1.add(bt_boletosantander);

        bt_boletobradesco.setText("Bradesco");
        bt_boletobradesco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_boletobradescoActionPerformed(evt);
            }
        });
        jMenu1.add(bt_boletobradesco);

        MenuPopup.add(jMenu1);

        bt_consultarContratosFaturados.setText("Consulta Contratos Farurados");
        bt_consultarContratosFaturados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_consultarContratosFaturadosActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_consultarContratosFaturados);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta e Manutenção - Contratos");
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
        jLabel1.setText("Contratos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_contratos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_contratos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seq", "Descrição do Contrato", "Cliente", "Data do Contrato", "Data de Reajuste", "Valor Contrato", "Status do Contrato"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_contratos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_contratos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_contratos.getTableHeader().setReorderingAllowed(false);
        tabela_contratos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_contratosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_contratos);
        if (tabela_contratos.getColumnModel().getColumnCount() > 0) {
            tabela_contratos.getColumnModel().getColumn(0).setResizable(false);
            tabela_contratos.getColumnModel().getColumn(0).setPreferredWidth(30);
            tabela_contratos.getColumnModel().getColumn(1).setPreferredWidth(225);
            tabela_contratos.getColumnModel().getColumn(2).setPreferredWidth(250);
            tabela_contratos.getColumnModel().getColumn(3).setResizable(false);
            tabela_contratos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabela_contratos.getColumnModel().getColumn(4).setResizable(false);
            tabela_contratos.getColumnModel().getColumn(4).setPreferredWidth(100);
            tabela_contratos.getColumnModel().getColumn(5).setResizable(false);
            tabela_contratos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tabela_contratos.getColumnModel().getColumn(6).setResizable(false);
            tabela_contratos.getColumnModel().getColumn(6).setPreferredWidth(120);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addContainerGap())
        );

        bt_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/print.png"))); // NOI18N
        bt_imprimir.setText("Imprimir");
        bt_imprimir.setEnabled(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Competência");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Mês/Ano:");

        try {
            txt_MesAnoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_MesAnoInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_MesAnoInicial.setText("00/0000");
        txt_MesAnoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_MesAnoInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_MesAnoInicialFocusLost(evt);
            }
        });
        txt_MesAnoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_MesAnoInicialKeyPressed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Inicial");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Final");

        try {
            txt_MesAnoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_MesAnoFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_MesAnoFinal.setText("99/9999");
        txt_MesAnoFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_MesAnoFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_MesAnoFinalFocusLost(evt);
            }
        });
        txt_MesAnoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_MesAnoFinalKeyPressed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Cliente:");

        try {
            txt_codigoClienteInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoClienteInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoClienteInicial.setText("00000");
        txt_codigoClienteInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoClienteInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoClienteInicialFocusLost(evt);
            }
        });
        txt_codigoClienteInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoClienteInicialKeyPressed(evt);
            }
        });

        try {
            txt_codigoClienteFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoClienteFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoClienteFinal.setText("99999");
        txt_codigoClienteFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoClienteFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoClienteFinalFocusLost(evt);
            }
        });
        txt_codigoClienteFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoClienteFinalKeyPressed(evt);
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

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Contrato:");

        try {
            txt_codigoContratoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoContratoInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoContratoInicial.setText("000000000");
        txt_codigoContratoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoContratoInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoContratoInicialFocusLost(evt);
            }
        });
        txt_codigoContratoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoContratoInicialKeyPressed(evt);
            }
        });

        try {
            txt_codigoContratoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoContratoFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoContratoFinal.setText("999999999");
        txt_codigoContratoFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoContratoFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoContratoFinalFocusLost(evt);
            }
        });
        txt_codigoContratoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoContratoFinalKeyPressed(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Inicial");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Final");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_MesAnoInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(txt_codigoClienteInicial)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addComponent(bt_pesquisaClienteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_codigoClienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisaClienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_MesAnoFinal)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_codigoContratoInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_codigoContratoFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(416, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel5, txt_MesAnoFinal});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, jLabel6});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_MesAnoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_MesAnoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_codigoContratoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoContratoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_codigoClienteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoClienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaClienteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaClienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaClienteFinal, bt_pesquisaClienteInicial, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, txt_MesAnoFinal, txt_MesAnoInicial, txt_codigoClienteFinal, txt_codigoClienteInicial});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel8, jLabel9, txt_codigoContratoFinal, txt_codigoContratoInicial});

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bt_processa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_sair))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_imprimir, bt_processa});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_processa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_imprimir, bt_processa, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_pesquisaClienteInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaClienteInicialActionPerformed
        Campo = "I";
        AbrePesquisaClientes();
    }//GEN-LAST:event_bt_pesquisaClienteInicialActionPerformed
    
    private void AbrePesquisaClientes(){
        if(CliCon   != null)if(CliCon.isVisible()){
            Mensagem = "Tela já Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuCliente = 1;
        CliCon = new ClientesConsulta("N");
        CliCon.setVisible(true);
    }
    
    private void bt_pesquisaClienteFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaClienteFinalActionPerformed
        Campo = "F";
        AbrePesquisaClientes();
    }//GEN-LAST:event_bt_pesquisaClienteFinalActionPerformed

    private void txt_MesAnoInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_MesAnoInicialFocusGained
        txt_MesAnoInicial.setSelectionStart(0);
        txt_MesAnoInicial.setSelectionEnd  (txt_MesAnoInicial.getText().length());
    }//GEN-LAST:event_txt_MesAnoInicialFocusGained

    private void txt_MesAnoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_MesAnoInicialFocusLost
        txt_MesAnoInicial.setText(fc.FormataCampo(txt_MesAnoInicial.getText(), 6, 0));
    }//GEN-LAST:event_txt_MesAnoInicialFocusLost

    private void txt_MesAnoInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_MesAnoInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_MesAnoFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_MesAnoInicial.setText(fc.FormataCampo("", 6, 0));
            txt_MesAnoFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_MesAnoInicialKeyPressed

    private void txt_MesAnoFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_MesAnoFinalFocusGained
        txt_MesAnoFinal.setSelectionStart(0);
        txt_MesAnoFinal.setSelectionEnd  (txt_MesAnoFinal.getText().length());
    }//GEN-LAST:event_txt_MesAnoFinalFocusGained

    private void txt_MesAnoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_MesAnoFinalFocusLost
        txt_MesAnoFinal.setText(fc.FormataCampo(txt_MesAnoFinal.getText(), 6, 0));
    }//GEN-LAST:event_txt_MesAnoFinalFocusLost

    private void txt_MesAnoFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_MesAnoFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoContratoInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_MesAnoFinal.setText("999999");
            txt_codigoContratoInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_MesAnoFinalKeyPressed

    private void txt_codigoContratoInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoContratoInicialFocusGained
        txt_codigoContratoInicial.setSelectionStart(0);
        txt_codigoContratoInicial.setSelectionEnd  (txt_codigoContratoInicial.getText().length());
    }//GEN-LAST:event_txt_codigoContratoInicialFocusGained

    private void txt_codigoContratoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoContratoInicialFocusLost
        txt_codigoContratoInicial.setText(fc.FormataCampo(txt_codigoContratoInicial.getText(), 9, 0));
    }//GEN-LAST:event_txt_codigoContratoInicialFocusLost

    private void txt_codigoContratoInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoContratoInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoContratoFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoContratoInicial.setText(fc.FormataCampo("", 9, 0));
            txt_codigoContratoFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoContratoInicialKeyPressed

    private void txt_codigoContratoFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoContratoFinalFocusGained
        txt_codigoContratoFinal.setSelectionStart(0);
        txt_codigoContratoFinal.setSelectionEnd  (txt_codigoContratoFinal.getText().length());
    }//GEN-LAST:event_txt_codigoContratoFinalFocusGained

    private void txt_codigoContratoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoContratoFinalFocusLost
        txt_codigoContratoFinal.setText(fc.FormataCampo(txt_codigoContratoFinal.getText(), 9, 0));
    }//GEN-LAST:event_txt_codigoContratoFinalFocusLost

    private void txt_codigoContratoFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoContratoFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoClienteInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoContratoFinal.setText("999999999");
            txt_codigoClienteInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoContratoFinalKeyPressed

    private void txt_codigoClienteInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteInicialFocusGained
        txt_codigoClienteInicial.setSelectionStart(0);
        txt_codigoClienteInicial.setSelectionEnd  (txt_codigoClienteInicial.getText().length());
    }//GEN-LAST:event_txt_codigoClienteInicialFocusGained

    private void txt_codigoClienteInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteInicialFocusLost
        txt_codigoClienteInicial.setText(fc.FormataCampo(txt_codigoClienteInicial.getText(), 5, 0));
    }//GEN-LAST:event_txt_codigoClienteInicialFocusLost

    private void txt_codigoClienteInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoClienteInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoClienteFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoClienteInicial.setText(fc.FormataCampo("", 5, 0));
            txt_codigoClienteFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoClienteInicialKeyPressed

    private void txt_codigoClienteFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteFinalFocusGained
        txt_codigoClienteFinal.setSelectionStart(0);
        txt_codigoClienteFinal.setSelectionEnd  (txt_codigoClienteFinal.getText().length());
    }//GEN-LAST:event_txt_codigoClienteFinalFocusGained

    private void txt_codigoClienteFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteFinalFocusLost
        txt_codigoClienteFinal.setText(fc.FormataCampo(txt_codigoClienteFinal.getText(), 5, 0));
    }//GEN-LAST:event_txt_codigoClienteFinalFocusLost

    private void txt_codigoClienteFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoClienteFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            bt_processa.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoClienteFinal.setText("99999");
            bt_processa.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoClienteFinalKeyPressed

    private void bt_processaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_processaActionPerformed
        PegaValores();
    }//GEN-LAST:event_bt_processaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        TableContratos  = (DefaultTableModel)tabela_contratos.getModel();
        PegaValores();
    }//GEN-LAST:event_formWindowOpened

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void tabela_contratosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_contratosMouseClicked
        Linha = tabela_contratos.getSelectedRow();
        if(Linha < 0){
            Mensagem = "Item não selecionado!";
            new MostraMensagem(Mensagem);
            return;
        }
        if(evt.getButton() == MouseEvent.BUTTON3){
            if(Integer.parseInt(String.valueOf(tabela_contratos.getValueAt(Linha, 6)).substring(0, 1)) != 0)
                return;
            MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tabela_contratosMouseClicked

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuCliente == 0)
            return;
        abriuCliente = 0;
        retorno = CliCon.getRetorno();
        if(retorno.equals(""))
            return;
        if(Campo.equals("I")){
            txt_codigoClienteInicial.setText(fc.FormataCampo(retorno, 5, 0));
            return;
        }
        txt_codigoClienteFinal.setText(fc.FormataCampo(retorno, 5, 0));
    }//GEN-LAST:event_formWindowGainedFocus

    private void bt_consultarContratosFaturadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_consultarContratosFaturadosActionPerformed
        
    }//GEN-LAST:event_bt_consultarContratosFaturadosActionPerformed

    private void bt_boletoitauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_boletoitauActionPerformed
        if(GerBolItau != null)if(GerBolItau.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("SN");
        parametros.add(0);
        parametros.add(Integer.parseInt(String.valueOf(tabela_contratos.getValueAt(Linha, 2)).substring(0, 5)));
        parametros.add("Contratos");
        parametros.add(TransStrDou.TransformaValorStringeDouble(String.valueOf(tabela_contratos.getValueAt(Linha, 5)), 1));
        GerBolItau = new GerarBoletoItau(parametros);
        GerBolItau.setVisible(true);
    }//GEN-LAST:event_bt_boletoitauActionPerformed

    private void bt_boletohsbcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_boletohsbcActionPerformed
        
    }//GEN-LAST:event_bt_boletohsbcActionPerformed

    private void bt_boletosantanderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_boletosantanderActionPerformed
        if(GerBolSant != null)if(GerBolSant.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("SN");
        parametros.add(0);
        parametros.add(Integer.parseInt(String.valueOf(tabela_contratos.getValueAt(Linha, 2)).substring(0, 5)));
        parametros.add("Contratos");
        parametros.add(TransStrDou.TransformaValorStringeDouble(String.valueOf(tabela_contratos.getValueAt(Linha, 5)), 1));
        GerBolSant = new GerarBoletoSantander(parametros);
        GerBolSant.setVisible(true);
    }//GEN-LAST:event_bt_boletosantanderActionPerformed

    private void bt_boletobradescoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_boletobradescoActionPerformed
        if(GerBolBrad != null)if(GerBolBrad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("SN");
        parametros.add(0);
        parametros.add(Integer.parseInt(String.valueOf(tabela_contratos.getValueAt(Linha, 2)).substring(0, 5)));
        parametros.add("Contratos");
        parametros.add(TransStrDou.TransformaValorStringeDouble(String.valueOf(tabela_contratos.getValueAt(Linha, 5)), 1));
        GerBolBrad = new GerarBoletoBradesco(parametros);
        GerBolBrad.setVisible(true);
    }//GEN-LAST:event_bt_boletobradescoActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_boletobradesco;
    private javax.swing.JMenuItem bt_boletohsbc;
    private javax.swing.JMenuItem bt_boletoitau;
    private javax.swing.JMenuItem bt_boletosantander;
    private javax.swing.JMenuItem bt_consultarContratosFaturados;
    private javax.swing.JButton bt_imprimir;
    private javax.swing.JButton bt_pesquisaClienteFinal;
    private javax.swing.JButton bt_pesquisaClienteInicial;
    private javax.swing.JButton bt_processa;
    private javax.swing.JButton bt_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_contratos;
    private javax.swing.JFormattedTextField txt_MesAnoFinal;
    private javax.swing.JFormattedTextField txt_MesAnoInicial;
    private javax.swing.JFormattedTextField txt_codigoClienteFinal;
    private javax.swing.JFormattedTextField txt_codigoClienteInicial;
    private javax.swing.JFormattedTextField txt_codigoContratoFinal;
    private javax.swing.JFormattedTextField txt_codigoContratoInicial;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
    private void PegaValores(){
        binter.dataContratoInicial      = Test.Testa("00/" + txt_MesAnoInicial.getText());
        binter.dataContratoFinal        = Test.Testa("99/" + txt_MesAnoFinal.getText());
        if(binter.dataContratoInicial > binter.dataContratoFinal){
            Mensagem = "Data inicial não pode ser maior do q a Data final!";
            new MostraMensagem(Mensagem);
            return;
        }
        
        binter.codigoContratoInicial    = Integer.parseInt(txt_codigoContratoInicial.getText());
        binter.codigoContratoFinal      = Integer.parseInt(txt_codigoContratoFinal.getText());
        if(binter.codigoContratoInicial > binter.codigoContratoFinal){
            Mensagem = "Codigo contrato inicial não pode ser maior do que o contrato final!";
            new MostraMensagem(Mensagem);
            return;
        }
        
        binter.clienteInicial           = Integer.parseInt(txt_codigoClienteInicial.getText());
        binter.clienteFinal             = Integer.parseInt(txt_codigoClienteFinal.getText());
        if(binter.clienteInicial > binter.clienteFinal){
            Mensagem = "Codigo cliente inicial não pode ser maior do que o cliente final!";
            new MostraMensagem(Mensagem);
            return;
        }
        MontaSQL();
    }
    
    private void MontaSQL(){
        sql = "select \n"
              + "   idContrato, \n"
              + "   idEmpresa, \n"
              + "   codigoGrupo, \n"
              + "   codigoEmpresa, \n"
              + "   codigoContrato, \n"
              + "   codigoCliente, \n"
              + "   codigoUsuario, \n"
              + "   valorContrato, \n"
              + "   dataCadastro, \n"
              + "   dataContrato, \n"
              + "   dataVencimento, \n"
              + "   dataReajuste, \n"
              + "   descricaoContrato, \n"
              + "   statusContrato \n"
              + "from tb_contratos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and \n"
              + "   dataCadastro between "   + binter.dataContratoInicial    + " and " + binter.dataContratoFinal    + " and \n"
              + "   codigoContrato between " + binter.codigoContratoInicial  + " and " + binter.codigoContratoFinal  + " and \n"
              + "   codigoCliente between "  + binter.clienteInicial         + " and " + binter.clienteFinal         + " \n"
              + "       order by idContrato desc;";
        dadosContratos.clear();
        dadosContratos = parametrosNS.dao.Consulta(sql);
        PegaDadosContratos();
    }
    
    private void PegaDadosContratos(){
        TableContratos.setNumRows(0);
        for(int i = 0; i < dadosContratos.size(); i++){
            bcon = new BeanContratos();
            if(dadosContratos.get(i).get(0) != null)
                bcon.idContrato         = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(0)));
            if(dadosContratos.get(i).get(1) != null)
                bcon.idEmpresa          = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(1)));
            if(dadosContratos.get(i).get(2) != null)
                bcon.codigoGrupo        = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(2)));
            if(dadosContratos.get(i).get(3) != null)
                bcon.codigoEmpresa      = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(3)));
            if(dadosContratos.get(i).get(4) != null)
                bcon.codigoContrato     = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(4)));
            if(dadosContratos.get(i).get(5) != null)
                bcon.codigoCliente      = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(5)));
            if(dadosContratos.get(i).get(6) != null)
                bcon.codigoUsuario      = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(6)));
            if(dadosContratos.get(i).get(7) != null)
                bcon.valorContrato      = Double.parseDouble(String.valueOf(dadosContratos.get(i).get(7)));
                bcon.dataCadastro       =                    String.valueOf(dadosContratos.get(i).get(8));
                bcon.dataContrato       =                    String.valueOf(dadosContratos.get(i).get(9));
                bcon.dataVencimento     =                    String.valueOf(dadosContratos.get(i).get(10));
                bcon.dataReajuste       =                    String.valueOf(dadosContratos.get(i).get(11));
                bcon.descricaoContrato  =                    String.valueOf(dadosContratos.get(i).get(12));
            if(dadosContratos.get(i).get(13) != null)
                bcon.statusContrato     = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(13)));
            
            bc.codigoCliente        = bcon.codigoCliente;
            PegaCliente();
            
            bcon.dataContrato       = invdata.inverterData(bcon.dataContrato, 1);
            bcon.dataReajuste       = invdata.inverterData(bcon.dataReajuste, 1);
            
            switch(bcon.statusContrato){
                case 0: StatusContrato = "0 - Pendente";    break;
                case 1: StatusContrato = "1 - Cancelado";   break;
                case 2: StatusContrato = "2 - Pago";        break;
            }
            
            TableContratos.addRow(new Object[] {fc.FormataCampo(String.valueOf(i + 1), 2, 0), fc.FormataCampo(String.valueOf(bcon.codigoContrato), 9, 0) + "-" + bcon.descricaoContrato, fc.FormataCampo(String.valueOf(bc.codigoCliente), 5, 0) + "-" + bc.nome, bcon.dataContrato, bcon.dataReajuste, TransStrDou.TransformaValorStringeDouble(String.valueOf(bcon.valorContrato), 0), StatusContrato});
        }
    }
    
    private void PegaCliente(){
        bc.nome     = "----------";
        if(bc.codigoCliente == 0)return;
        sql = "select idCliente, idEmpresa, codigoGrupo, codigoEmpresa, codigoCliente, nome from tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCliente = " + bc.codigoCliente + ";";
        dadosCliente.clear();
        dadosCliente = parametrosNS.dao.Consulta(sql);
        if(dadosCliente.isEmpty()){
            Mensagem = "Cliente n°" + bc.codigoCliente + " não encontrado!";
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
    
}
