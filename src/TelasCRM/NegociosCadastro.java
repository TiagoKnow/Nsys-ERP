package TelasCRM;

import Beans.BeanNegocios;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import FuncoesInternas.*;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
/**
 * @author Tiago 18/09/2017 14:40
 */

public class NegociosCadastro extends javax.swing.JFrame {       
    //Int
    int totalRegistros = 0;
    
    //String
    String sql            = "";
    String mensagem       = "";
    String operacao       = "";
    String sqlstate       = "";

    //Beans
    BeanNegocios bn = new BeanNegocios();
    
    //Vetores 
    ArrayList<ArrayList> dadosNegocio = new ArrayList();
    ArrayList<ArrayList> dadosCEP     = new ArrayList();
       
    //DefaultTableModel
    DefaultTableModel tb0;
    DefaultTableModel tb1;
    
    //Funções
    dataAtual                     dt = new dataAtual();
    ajustarData                   aj = new ajustarData();
    converterCampoFormatadoDouble cv = new converterCampoFormatadoDouble();
    //formatarNumeros                f = new formatarNumeros();
    NumberFormat                  nf = new DecimalFormat("R$ ###,##0.00");
    FormataCPFCNPJ                fc = new FormataCPFCNPJ();
    
    //Telas
    
    //Tabela
    int    linha   = 0;
    Object coluna  = null;
    Object posicao = null;
   
    public NegociosCadastro() {
        //super(parent, modal);
        initComponents();
        tb0 = (DefaultTableModel)tabela_negocios.getModel();
        tb1 = (DefaultTableModel)tabelaHistorico.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoBotoes_quadroBuscar = new javax.swing.ButtonGroup();
        jLabel7 = new javax.swing.JLabel();
        txt_totalRegistros = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        bt_novo = new javax.swing.JButton();
        bt_editar = new javax.swing.JButton();
        bt_salvar = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        bt_excluir = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        radio_Fisica = new javax.swing.JRadioButton();
        radio_Juridica = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        txt_nomeNegocio = new javax.swing.JTextField();
        txt_contato = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        bt_pesquisaeCEP = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txt_cidade = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txt_endereco = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txt_numero2 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txt_bairro = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        combo_UF = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txt_telefone1 = new javax.swing.JTextField();
        txt_telefone2 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        txt_site = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_observacoes = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txt_codigoNegocio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_dataCadastro = new javax.swing.JFormattedTextField();
        txt_cnpj = new javax.swing.JFormattedTextField();
        txt_cpf = new javax.swing.JFormattedTextField();
        txt_cep = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaHistorico = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabela_negocios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_pesquisa = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menu_novo = new javax.swing.JMenuItem();
        menu_editar = new javax.swing.JMenuItem();
        menu_salvar = new javax.swing.JMenuItem();
        menu_sair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro e gestão de negócios NCRM 1.0.0");
        setBounds(new java.awt.Rectangle(100, 100, 0, 0));
        setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        setResizable(false);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel7.setText("Total de Registros: ");

        txt_totalRegistros.setEditable(false);
        txt_totalRegistros.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Funções");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bt_novo.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        bt_novo.setText("Novo (F3)");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        bt_editar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        bt_editar.setText("Editar (F4)");
        bt_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editarActionPerformed(evt);
            }
        });

        bt_salvar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        bt_salvar.setText("Salvar (F5)");
        bt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarActionPerformed(evt);
            }
        });

        bt_cancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        bt_cancelar.setText("Desfazer");
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        bt_sair.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        bt_sair.setText("Sair (ESC)");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        bt_excluir.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        bt_excluir.setText("Excluir");
        bt_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_novo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_editar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_salvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_cancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_excluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_sair)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_cancelar, bt_editar, bt_excluir, bt_novo, bt_sair, bt_salvar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_novo)
                    .addComponent(bt_editar)
                    .addComponent(bt_salvar)
                    .addComponent(bt_cancelar)
                    .addComponent(bt_sair)
                    .addComponent(bt_excluir))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jTabbedPane1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        radio_Fisica.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        radio_Fisica.setText("Física");
        radio_Fisica.setFocusable(false);
        radio_Fisica.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radio_FisicaItemStateChanged(evt);
            }
        });
        radio_Fisica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                radio_FisicaKeyPressed(evt);
            }
        });

        radio_Juridica.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        radio_Juridica.setText("Jurídica");
        radio_Juridica.setFocusable(false);
        radio_Juridica.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radio_JuridicaItemStateChanged(evt);
            }
        });
        radio_Juridica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                radio_JuridicaKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel11.setText("Negócio: ");

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel12.setText("Contato: ");

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel13.setText("Tipo de registro: ");

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("CEP: ");

        bt_pesquisaeCEP.setText("...");
        bt_pesquisaeCEP.setEnabled(false);
        bt_pesquisaeCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaeCEPActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Cidade: ");

        jLabel20.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Endereço: ");

        txt_endereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_enderecoActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Número: ");

        jLabel19.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Bairro: ");

        jLabel21.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("UF: ");

        combo_UF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        combo_UF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo_UFFocusLost(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel16.setText("Telefone 1: ");

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel17.setText("Telefone 1: ");

        jLabel23.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel23.setText("Email: ");

        jLabel24.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel24.setText("Site: ");

        jLabel25.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel25.setText("Observações: ");

        txt_observacoes.setColumns(20);
        txt_observacoes.setRows(5);
        jScrollPane1.setViewportView(txt_observacoes);

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setText("Código: ");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel5.setText("Data de cadastro: ");

        try {
            txt_dataCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataCadastro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataCadastroFocusLost(evt);
            }
        });

        try {
            txt_cnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cnpj.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_cnpjFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cnpjFocusLost(evt);
            }
        });

        try {
            txt_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_cpfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cpfFocusLost(evt);
            }
        });

        try {
            txt_cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_cepFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cepFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel22)
                    .addComponent(jLabel16)
                    .addComponent(jLabel25)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txt_numero2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(bt_pesquisaeCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18))
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txt_bairro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo_UF, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_dataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txt_site, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txt_telefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_telefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24))
                            .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_codigoNegocio)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(radio_Fisica, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radio_Juridica)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(txt_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_nomeNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_contato, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_nomeNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txt_contato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_codigoNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radio_Fisica)
                    .addComponent(radio_Juridica)
                    .addComponent(jLabel13)
                    .addComponent(txt_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_pesquisaeCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_numero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22)
                        .addComponent(jLabel19)
                        .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_dataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(combo_UF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txt_telefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txt_telefone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(txt_site, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(0, 84, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Dados cadastrais", jPanel4);

        jButton2.setText("Cadastrar novo");

        tabelaHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"7162", "01/01/2017", "Em contato com o cliente, analisando"},
                {"7627", "05/01/2017", "Contrado firmado com o cliente"},
                {"7654", "06/01/2017", "Cliente solicitou visita para treinamento"}
            },
            new String [] {
                "Registro", "Data", "Assunto"
            }
        ));
        jScrollPane2.setViewportView(tabelaHistorico);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(822, Short.MAX_VALUE)
                .addComponent(jButton2))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jButton2))
        );

        jTabbedPane1.addTab("Histório", jPanel5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 929, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Tickets de suporte", jPanel6);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 929, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Clientes", jPanel3);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 929, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Contratos", jPanel8);

        tabela_negocios.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tabela_negocios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "1", "ECO Games", "Priscila", "Contrato fechado", "Tiago", "18/09/2017"},
                {null, "2", "V-Couros LTDA", "Emilia", "Contrato fechado", "Tiago", "18/09/2017"},
                {null, "3", "Verlup", "--", "Pesquisando", "Tiago", "18/09/2017"},
                {null, "4", "Petshop - casa", "Camila", "Aguardando resposta (Proposta)", "Tiago", "18/09/2017"},
                {null, "5", "Marcon", "--", "Pesquisando", "Tiago", "18/09/2017"},
                {null, "6", "Papelaria os Irmãos", "Hercules", "Aguardando resposta do cliente", "Tiago", "18/09/2017"}
            },
            new String [] {
                "id", "Codigo", "Nome negocio", "Contato", "Status", "Usuário", "Data de cadastro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_negocios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_negocios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_negociosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabela_negocios);
        if (tabela_negocios.getColumnModel().getColumnCount() > 0) {
            tabela_negocios.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel1.setText("Pesquisar: ");

        txt_pesquisa.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        jMenu1.setText("Arquivo");
        jMenu1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        menu_novo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        menu_novo.setText("Novo");
        menu_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_novoActionPerformed(evt);
            }
        });
        jMenu1.add(menu_novo);

        menu_editar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        menu_editar.setText("Editar");
        menu_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_editarActionPerformed(evt);
            }
        });
        jMenu1.add(menu_editar);

        menu_salvar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        menu_salvar.setText("Salvar");
        menu_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_salvarActionPerformed(evt);
            }
        });
        jMenu1.add(menu_salvar);

        menu_sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        menu_sair.setText("Sair");
        menu_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_sairActionPerformed(evt);
            }
        });
        jMenu1.add(menu_sair);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_totalRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_totalRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        habilitarControles(false);
        carregaTabelaNegocios();
    }//GEN-LAST:event_formWindowOpened
    
    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        novo();
        txt_codigoNegocio.setText("");
        operacao = "I";
    }//GEN-LAST:event_bt_novoActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        habilitarControles(false);
        //bt_imprimir.setEnabled(true);
        bt_salvar.setEnabled(false);
        bt_cancelar.setEnabled(false);
        txt_pesquisa.setEnabled(true);
        bt_novo.setEnabled(true);
        tabela_negocios.setEnabled(true);
        
        try{
            int a = Integer.parseInt(txt_codigoNegocio.getText());
            bt_editar.setEnabled(true);
            // se for possível fazer o parse é sinal que há um código e é edição e não novo registro
        }catch (Exception e) {
            limparCampos(); 
        }
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed
        pegaValores();
        if(operacao.equals("I")){
            salvarRegistro();
        }else if(operacao.equals("E")){
            editarRegistro();
        }
        System.out.println(sql);

    }//GEN-LAST:event_bt_salvarActionPerformed

    private void bt_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editarActionPerformed
        operacao = "E";
        editar();
        txt_nomeNegocio.setText("");
    }//GEN-LAST:event_bt_editarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged

    }//GEN-LAST:event_formWindowStateChanged

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void menu_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_novoActionPerformed
        novo();
        txt_codigoNegocio.setText("");
        operacao = "I";
    }//GEN-LAST:event_menu_novoActionPerformed

    private void menu_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_editarActionPerformed
        editar();        
    }//GEN-LAST:event_menu_editarActionPerformed

    private void menu_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_salvarActionPerformed
        //salvar();
        pegaValores();
        if(operacao.equals("I")){
            salvarRegistro();
        }else if(operacao.equals("E")){
            editarRegistro();
        }
    }//GEN-LAST:event_menu_salvarActionPerformed

    private void menu_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_sairActionPerformed
        dispose();
    }//GEN-LAST:event_menu_sairActionPerformed

    private void bt_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluirActionPerformed

    }//GEN-LAST:event_bt_excluirActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
//        int id = busca.getResultado();
//        String desc = busca.getResultado2();
//        String v = "";
//        int cod = 0;
//        if(id != 0){
//            //mensagem = "teste: " + id + " - " + desc;
//            //mostraMensagem();
//            cod = id;
//            id = 0;
//            
//            v = id + " - " + desc;
//            
//            System.out.println(v);
//            
//            combo_destino.setSelectedItem(cod + " - " + desc);
//            
//            //selecionaEmpresa(codEmpresa);
//            busca = new LocalizarTipoSaidas();
//        }
//        
//        String res1 = busca2.getResultado();
//        String res2 = busca2.getResultado2();
//        
//        String cod2 = "";
//        String v2 = "";
//        
//        if(res1 != null){
//            //mensagem = "teste: " + id + " - " + desc;
//            //mostraMensagem();
//            cod2 = res1;
//            res1 = "";
//            
//            v2 = cod2 + " - " + res2;
//            
//            System.out.println(v2);
//            
//            combo_fornecedor.setSelectedItem(cod2 + " - " + res2);
//            
//            //selecionaEmpresa(codEmpresa);
//            busca2 = new LocalizarFornecedores();
//        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void radio_FisicaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radio_FisicaItemStateChanged
        
    }//GEN-LAST:event_radio_FisicaItemStateChanged

    private void radio_FisicaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_radio_FisicaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_cpf.grabFocus();
        }
        
        if(evt.getKeyCode() == KeyEvent.VK_DOWN){
            radio_Juridica.setSelected(true);
        }
    }//GEN-LAST:event_radio_FisicaKeyPressed

    private void radio_JuridicaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radio_JuridicaItemStateChanged
        
    }//GEN-LAST:event_radio_JuridicaItemStateChanged

    private void radio_JuridicaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_radio_JuridicaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_cnpj.grabFocus();
        }
        
        if(evt.getKeyCode() == KeyEvent.VK_UP){
            radio_Fisica.setSelected(true);
        }
    }//GEN-LAST:event_radio_JuridicaKeyPressed

    private void bt_pesquisaeCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaeCEPActionPerformed
//        if(CodEndPosCon != null)if(CodEndPosCon.isVisible()){
//            mensagem = "Tela já aberta!";
//            new MostraMensagem(mensagem);
//            return;
//        }
//        abriuCep = 1;
//        CodEndPosCon = new CodigoEnderecamentoPostalConsulta();
//        CodEndPosCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaeCEPActionPerformed

    private void txt_enderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_enderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_enderecoActionPerformed

    private void combo_UFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo_UFFocusLost

    }//GEN-LAST:event_combo_UFFocusLost

    private void txt_dataCadastroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataCadastroFocusLost
        
    }//GEN-LAST:event_txt_dataCadastroFocusLost

    private void tabela_negociosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_negociosMouseClicked
        atualizar();
    }//GEN-LAST:event_tabela_negociosMouseClicked

    private void txt_cnpjFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cnpjFocusGained
        //txt_CNPJ.setBackground(Color.lightGray);
    }//GEN-LAST:event_txt_cnpjFocusGained

    private void txt_cnpjFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cnpjFocusLost
        //txt_CNPJ.setBackground(Color.white);
    }//GEN-LAST:event_txt_cnpjFocusLost

    private void txt_cpfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cpfFocusGained

    private void txt_cpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cpfFocusLost

    private void txt_cepFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cepFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cepFocusGained

    private void txt_cepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cepFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cepFocusLost
   
    public void habilitarControles(Boolean b){
        txt_codigoNegocio.setEnabled(b);
        txt_nomeNegocio.setEnabled(b);
        txt_contato.setEnabled(b);
        radio_Fisica.setEnabled(b);
        radio_Juridica.setEnabled(b);
        txt_cpf.setEnabled(b);
        txt_cnpj.setEnabled(b);
        txt_cep.setEnabled(b);
        txt_endereco.setEnabled(b);
        txt_cidade.setEnabled(b);
        txt_numero2.setEnabled(b);
        txt_bairro.setEnabled(b);
        combo_UF.setEnabled(b);
        txt_dataCadastro.setEnabled(b);
        txt_telefone1.setEnabled(b);
        txt_telefone2.setEnabled(b);
        txt_email.setEnabled(b);
        txt_site.setEnabled(b);
        txt_observacoes.setEnabled(b);
    }

    public void limparCampos(){
        txt_codigoNegocio.setText("");
        txt_nomeNegocio.setText("");
        txt_contato.setText("");
        radio_Fisica.setSelected(false);
        radio_Juridica.setSelected(false);
        txt_cpf.setText(null);
        txt_cnpj.setText(null);
        txt_cep.setText("");
        txt_endereco.setText("");
        txt_cidade.setText("");
        txt_numero2.setText("");
        txt_bairro.setText("");
        combo_UF.setSelectedItem("SP");
        txt_dataCadastro.setText(null);
        txt_telefone1.setText("");
        txt_telefone2.setText("");
        txt_email.setText("");
        txt_site.setText("");
        txt_observacoes.setText("");
    }
    
    public void carregaTexto(){
        txt_codigoNegocio.setText(String.valueOf(bn.codigoNegocio));
        txt_nomeNegocio.setText(bn.nomeNegocio);
        txt_contato.setText(bn.contato);
        
        if(bn.tipoFJ.equals("F")){
            radio_Fisica.setSelected(true);
            txt_cpf.setText(bn.nDocumento);
        }else{
            radio_Juridica.setSelected(false);
            txt_cnpj.setText(null);
        }
        
        if(bn.tipoFJ.equals("J")){
            radio_Fisica.setSelected(false);
            txt_cpf.setText(null);
        }else{
            radio_Juridica.setSelected(true);
            txt_cnpj.setText(bn.nDocumento);
        }
        
        txt_cep.setText(bn.cep);
        txt_endereco.setText(bn.endereco);
        txt_cidade.setText(bn.cidade);
        txt_numero2.setText(bn.numero);
        txt_bairro.setText(bn.bairro);
        combo_UF.setSelectedItem(bn.uf);
        txt_dataCadastro.setText(bn.dataCadastro);
        txt_telefone1.setText(bn.telefone1);
        txt_telefone2.setText(bn.telefone2);
        txt_email.setText(bn.email);
        txt_site.setText(bn.site);
        txt_observacoes.setText(bn.observacoes);
    }
    
    public Float converteValorDigitadoemFloat(String valor) {
        String formatoFloat = valor;
        formatoFloat = formatoFloat.replace(".", "");
        formatoFloat = formatoFloat.replace(",", ".");
        formatoFloat = formatoFloat.replace("R$ ", "");
        Float val = Float.parseFloat(formatoFloat);
        return val;
    }

    public void novo(){
        habilitarControles(true);
        txt_nomeNegocio.requestFocus();
        bt_salvar.setEnabled(true);
        bt_cancelar.setEnabled(true);
        bt_novo.setEnabled(false);
        bt_editar.setEnabled(false);
        limparCampos();
    }
    public void editar(){
        habilitarControles(true);
        txt_nomeNegocio.requestFocus();
        //bt_imprimir.setEnabled(false);
        bt_salvar.setEnabled(true);
        bt_cancelar.setEnabled(true);
        txt_pesquisa.setEnabled(false);
        //bt_buscar.setEnabled(false);
        bt_novo.setEnabled(false);
        bt_editar.setEnabled(false);
        tabelaHistorico.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoBotoes_quadroBuscar;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_editar;
    private javax.swing.JButton bt_excluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisaeCEP;
    private javax.swing.JButton bt_sair;
    private javax.swing.JButton bt_salvar;
    private javax.swing.JComboBox<String> combo_UF;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem menu_editar;
    private javax.swing.JMenuItem menu_novo;
    private javax.swing.JMenuItem menu_sair;
    private javax.swing.JMenuItem menu_salvar;
    private javax.swing.JRadioButton radio_Fisica;
    private javax.swing.JRadioButton radio_Juridica;
    private javax.swing.JTable tabelaHistorico;
    private javax.swing.JTable tabela_negocios;
    private javax.swing.JTextField txt_bairro;
    private javax.swing.JFormattedTextField txt_cep;
    private javax.swing.JTextField txt_cidade;
    private javax.swing.JFormattedTextField txt_cnpj;
    private javax.swing.JTextField txt_codigoNegocio;
    private javax.swing.JTextField txt_contato;
    private javax.swing.JFormattedTextField txt_cpf;
    private javax.swing.JFormattedTextField txt_dataCadastro;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_endereco;
    private javax.swing.JTextField txt_nomeNegocio;
    private javax.swing.JTextField txt_numero2;
    private javax.swing.JTextArea txt_observacoes;
    private javax.swing.JTextField txt_pesquisa;
    private javax.swing.JTextField txt_site;
    private javax.swing.JTextField txt_telefone1;
    private javax.swing.JTextField txt_telefone2;
    private javax.swing.JTextField txt_totalRegistros;
    // End of variables declaration//GEN-END:variables
    public void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }

    private void preencherTabela() {
        
    }

    private void salvarRegistro() {
        sql = "insert into tb_negocios (codigoNegocio, codigoGrupo, codigoEmpresa, nomeNegocio, contato, tipoFJ, nDocumento, dataCadastro, cep, endereco, numero, cidade, bairro, uf, telefone1, telefone2, email, site, observacoes, usuarioCadastrou) values "
                + "              ('"+bn.codigoNegocio+"', '"+bn.codigoGrupo+"', '"+bn.codigoEmpresa+"', '"+bn.nomeNegocio+"', '"+bn.contato+"', '"+bn.tipoFJ+"', '"+bn.nDocumento+"', '"+bn.dataCadastro+"', '"+bn.cep +"', '"+bn.endereco+"', '"+bn.numero+"', '"+bn.cidade+"', '"+bn.bairro+"', '"+bn.uf+"', '"+bn.telefone1+"', '"+bn.telefone2+"', '"+bn.email+"', '"+bn.site+"', '"+bn.observacoes+"', '"+bn.usuarioCadastrou+"')";
        System.out.println(sql);
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(sqlstate.equals("00000")){
            mensagem = "Registro inserido com sucesso!";
            mostraMensagem();
            habilitarControles(false);
            bt_novo.setEnabled(true);
            bt_editar.setEnabled(true);           
        }else{
            mensagem = "Erro ao inserir registro";
            mostraMensagem();
            bt_novo.setEnabled(true);
        }
        carregaTabelaNegocios();
    }

    private void editarRegistro() {
        sql = "update tb_negocios set nomeNegocio = '"+bn.nomeNegocio+"', contato = '"+bn.contato+"', tipoFJ = '"+bn.tipoFJ+"', nDocumento = '"+bn.nDocumento+"', cep = '"+bn.cep+"', endereco = '"+bn.endereco+"', numero = '"+bn.numero+"', cidade = '"+bn.cidade+"', bairro = '"+bn.bairro+"', uf = '"+bn.uf+"', telefone1 = '"+bn.telefone1+"', telefone2 = '"+bn.telefone2+"', email = '"+bn.email+"', site = '"+bn.site+"', observacoes = '"+bn.observacoes+"' where idNegocios = '"+bn.idNegocios+"'";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(sqlstate.equals("00000")){
            mensagem = "Registro alterado com sucesso!";
            mostraMensagem();
            habilitarControles(false);
            bt_novo.setEnabled(true);
            bt_editar.setEnabled(true);           
        }else{
            mensagem = "Erro ao alterar registro";
            mostraMensagem();
            bt_novo.setEnabled(true);
            //return;
        }
        carregaTabelaNegocios();
    }

    private void atualizar(){
        bt_editar.setEnabled(true);
        bt_excluir.setEnabled(true);
        linha    = tabela_negocios.getSelectedRow();
        coluna   = tabela_negocios.getSelectedColumn(); 
        posicao  = tabela_negocios.getValueAt(linha, 0);
        bn.idNegocios  = (Integer.parseInt(posicao.toString()));
                
        sql = "select * from tb_negocios where idNegocios = '"+bn.idNegocios+"'";
        dadosNegocio.clear();
        dadosNegocio = parametrosNS.dao.Consulta(sql);
        if(dadosNegocio.isEmpty()){
            //mensagem = "Saída nº " + Integer.parseInt(txt_codigo.getText()) + " da unidade " + parametros.codigoEmpresa + parametros.nomeUnidade + "";
            //mostraMensagem();
            //return;
        }
        carregaTexto();
    }

    private void pegaCEP() {
        dadosCEP.clear();
        
        String cep      = "";
        String endereco = "";
        String cidade   = "";
        String bairro   = "";
        String uf       = "";
        
        cep = txt_cep.getText();
        
        cep = cep.replace("-", "");
        
        sql = "select * from ns_cep where cep = '" + cep + "'";
        
        dadosCEP = parametrosNS.dao.Consulta(sql);
        
        if(dadosCEP.isEmpty()){
            mensagem = "Cep não localizado!, favor digitar as informações manualmente.";
            mostraMensagem();
        }else{

          //cep      = (String)    dadosCEP.get(0).get(0);
            endereco = (String)    dadosCEP.get(0).get(1);
            cidade   = (String)    dadosCEP.get(0).get(2);
            bairro   = (String)    dadosCEP.get(0).get(3);
            uf       = (String)    dadosCEP.get(0).get(4);

            txt_endereco.setText(endereco);
            txt_cidade.setText(cidade);
            txt_bairro.setText(bairro);
            combo_UF.setSelectedItem(uf);
        }
    }
    
    private void pegaValores(){
        try{
            bn = new BeanNegocios();
            //bn.idNegocios = 0; //AI
            bn.codigoNegocio = 0; // já faço  
            bn.codigoGrupo = parametrosNS.bge.CodigoGrupo;
            bn.codigoEmpresa = parametrosNS.be.CodigoEmpresa;
            bn.nomeNegocio = txt_nomeNegocio.getText();    
            bn.contato = txt_contato.getText();
            
            if(radio_Fisica.isSelected()){
                bn.tipoFJ = "F"; // Fisica
            }else{
                bn.tipoFJ = "J"; // Jurídica
            }
            
            if(radio_Juridica.isSelected()){
                bn.tipoFJ = "J";
            }else{
                bn.tipoFJ = "F";
            }
            
            if(bn.tipoFJ.equals("J")){
                bn.nDocumento = txt_cnpj.getText();
            }else{
                bn.nDocumento = txt_cpf.getText();
            }
            
            bn.dataCadastro = dt.pegarDataAtualUS();
            bn.cep = txt_cep.getText();
            bn.endereco         = txt_endereco.getText();
            bn.numero         = txt_numero2.getText(); 
            bn.cidade        = txt_cidade.getText();  
            bn.bairro          = txt_bairro.getText();
            bn.uf              = String.valueOf(combo_UF.getSelectedItem());
            bn.telefone1       = txt_telefone1.getText();
            bn.telefone2       = txt_telefone2.getText();
            bn.email           = txt_email.getText();
            bn.site            = txt_site.getText();
            bn.observacoes     = txt_observacoes.getText();
            bn.usuarioCadastrou = parametrosNS.bu.codigoUsuario;
            
        }catch(Exception erro){
            mensagem = "Erro: " + erro.getMessage();
            mostraMensagem();
            return;
        }
    }

    private void carregaTabelaNegocios() {
        tb0.setNumRows(0);
        sql = "select * from tb_negocios order by idNegocios desc";
        dadosNegocio.clear();
        dadosNegocio = parametrosNS.dao.Consulta(sql);
        
        bn = new BeanNegocios();
        
        if(dadosNegocio.isEmpty()){
            mensagem = "vazia";
            mostraMensagem();
        }else{
            for (int i = 0; i < dadosNegocio.size(); i ++){
                bn.idNegocios       = Integer.parseInt((String)    dadosNegocio.get(i).get(0));   
                bn.codigoNegocio    = Integer.parseInt((String)    dadosNegocio.get(i).get(1));
                bn.codigoGrupo      = Integer.parseInt((String)    dadosNegocio.get(i).get(2));
                bn.codigoEmpresa    = Integer.parseInt((String)    dadosNegocio.get(i).get(3));
                bn.nomeNegocio      = (String) dadosNegocio.get(i).get(4);
                bn.contato          = (String) dadosNegocio.get(i).get(5);
                bn.tipoFJ           = (String) dadosNegocio.get(i).get(6);
                bn.nDocumento       = (String) dadosNegocio.get(i).get(7);
                bn.cep              = (String) dadosNegocio.get(i).get(8);
                bn.dataCadastro     = (String) dadosNegocio.get(i).get(9);
                bn.endereco         = (String) dadosNegocio.get(i).get(10);
                bn.numero           = (String) dadosNegocio.get(i).get(11);
                bn.cidade           = (String) dadosNegocio.get(i).get(12);
                bn.bairro           = (String) dadosNegocio.get(i).get(13);         
                bn.uf               = (String) dadosNegocio.get(i).get(14);
                bn.telefone1        = (String) dadosNegocio.get(i).get(15);
                bn.telefone2        = (String) dadosNegocio.get(i).get(16);
                bn.email            = (String) dadosNegocio.get(i).get(17);
                bn.site             = (String) dadosNegocio.get(i).get(18);
                bn.observacoes      = (String) dadosNegocio.get(i).get(19);
                bn.usuarioCadastrou = Integer.parseInt((String)    dadosNegocio.get(i).get(20));
                
                tb0.addRow(new Object [] {bn.idNegocios, bn.codigoNegocio, bn.nomeNegocio, bn.contato, "teste", bn.usuarioCadastrou, bn.dataCadastro});
                new AjustarLarguraColunas(tabela_negocios);
            }
        }
        
    }
}
