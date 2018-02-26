package TelasFaturamento;

import BeansNS.BeanBancoDados;
import Beans.BeanIntervalos;
import Beans.BeanParametros;
import Beans.BeanUsuarios;
import FuncoesInternas.InverterData;
import FuncoesInternas.*;
import Telas.CodigoEnderecamentoPostalConsulta;
import Parametros.parametrosNS;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;
/*
 @author Tiago e Paulo
 */
public class RelatorioDeCliente extends javax.swing.JFrame {
    //String 
    String sql                      = "";
    String preenchimento            = "";
    
    //int's
    int    abriuCliente             = 0;
    int    abriuCEP                 = 0;
    int    StatusCliente            = 0;
    int    FisicaJuridica           = 0;
    
    //Bean's
    BeanBancoDados          bbd     = new BeanBancoDados();
    BeanUsuarios            bu      = new BeanUsuarios();
    BeanParametros          bpar    = new BeanParametros();
    BeanIntervalos          binter  = new BeanIntervalos();
    
    //String's
    String Mensagem                 = "";
    String Campo                    = "";
    String retorno                  = "";
    
    //ArrayList's
    ArrayList            parametros            = new ArrayList();
    ArrayList<ArrayList> dadosParametros       = new ArrayList<ArrayList>();
    
    //Especiais
    InverterData        desp        = new InverterData();
    FormataCampo        fc          = new FormataCampo();
    CapturarDataHora    cdh         = new CapturarDataHora();
    FormataCPFCNPJ      FCpfCnpj    = new FormataCPFCNPJ();
    TestarData          Test        = new TestarData();
    
    //Outros
    PreparedStatement   stmt;
    ResultSet             rs;
    JRResultSetDataSource js;
    
    //Especiais para Relatórios
    String      jpv                 = "";
    JasperPrint jpp                 = null;
    HashMap     hm                  = new HashMap();
    
    //Telas
    ClientesConsulta                    ConCli;
    CodigoEnderecamentoPostalConsulta   ConCodEndPos;
    
    public RelatorioDeCliente(){
        initComponents();
    }
    
    private void InicializaCampos(){
        txt_clienteInicial      .setText(fc.FormataCampo("", 5, 0));
        txt_clienteFinal        .setText("99999");
        combo_Status            .setSelectedIndex(0);
        combo_pessoa            .setSelectedIndex(0);
        txt_nascimentoInicial   .setText(fc.FormataCampo("", 10, 2));
        txt_nascimentoFinal     .setText("99999999");
        txt_cadastroInicial     .setText(fc.FormataCampo("", 10, 2));
        txt_cadastroFinal       .setText("99999999");
        txt_cepInicial          .setText(fc.FormataCampo("", 9, 1));
        txt_cepFinal            .setText("99999999");
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_clienteInicial = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_clienteFinal = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_nascimentoInicial = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_nascimentoFinal = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        combo_Status = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txt_cadastroInicial = new javax.swing.JFormattedTextField();
        txt_cadastroFinal = new javax.swing.JFormattedTextField();
        combo_pessoa = new javax.swing.JComboBox<>();
        txt_cepFinal = new javax.swing.JFormattedTextField();
        txt_cepInicial = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        bt_pesquisaCepInicial = new javax.swing.JButton();
        bt_pesquisaClienteInicial = new javax.swing.JButton();
        bt_pesquisaCepFinal = new javax.swing.JButton();
        bt_pesquisaClienteFinal = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        bt_imprimir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair = new javax.swing.JMenuItem();

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
        jLabel1.setText("Intervalos de Seleção");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_clienteInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_clienteInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_clienteInicial.setText("00000");
        txt_clienteInicial.setToolTipText("F11 - Geral ou 2 Cliques para Pesquisa");
        txt_clienteInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_clienteInicialFocusLost(evt);
            }
        });
        txt_clienteInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_clienteInicialKeyPressed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Clientes:");

        try {
            txt_clienteFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_clienteFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_clienteFinal.setText("99999");
        txt_clienteFinal.setToolTipText("F11 - Geral ou 2 Cliques para Pesquisa");
        txt_clienteFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_clienteFinalFocusLost(evt);
            }
        });
        txt_clienteFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_clienteFinalKeyPressed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Pessoa:");

        try {
            txt_nascimentoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_nascimentoInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nascimentoInicial.setText("00/00/0000");
        txt_nascimentoInicial.setToolTipText("F11 - Geral");
        txt_nascimentoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_nascimentoInicialFocusLost(evt);
            }
        });
        txt_nascimentoInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nascimentoInicialActionPerformed(evt);
            }
        });
        txt_nascimentoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nascimentoInicialKeyPressed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Data de abertura ou Nascimento:");

        try {
            txt_nascimentoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_nascimentoFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nascimentoFinal.setText("99/99/9999");
        txt_nascimentoFinal.setToolTipText("F11 - Geral");
        txt_nascimentoFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_nascimentoFinalFocusLost(evt);
            }
        });
        txt_nascimentoFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nascimentoFinalActionPerformed(evt);
            }
        });
        txt_nascimentoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nascimentoFinalKeyPressed(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Status do Cliente:");

        combo_Status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ambos", "Ativos", "Bloqueados" }));
        combo_Status.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo_StatusKeyPressed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Data de Cadastro:");

        try {
            txt_cadastroInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cadastroInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cadastroInicial.setText("00/00/0000");
        txt_cadastroInicial.setToolTipText("F11 - Geral");
        txt_cadastroInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cadastroInicialFocusLost(evt);
            }
        });
        txt_cadastroInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cadastroInicialActionPerformed(evt);
            }
        });
        txt_cadastroInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cadastroInicialKeyPressed(evt);
            }
        });

        try {
            txt_cadastroFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cadastroFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cadastroFinal.setText("99/99/9999");
        txt_cadastroFinal.setToolTipText("F11 - Geral");
        txt_cadastroFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cadastroFinalFocusLost(evt);
            }
        });
        txt_cadastroFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cadastroFinalActionPerformed(evt);
            }
        });
        txt_cadastroFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cadastroFinalKeyPressed(evt);
            }
        });

        combo_pessoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ambos", "Jurídica", "Física" }));
        combo_pessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo_pessoaKeyPressed(evt);
            }
        });

        try {
            txt_cepFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cepFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cepFinal.setText("99999-999");
        txt_cepFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cepFinalKeyPressed(evt);
            }
        });

        try {
            txt_cepInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cepInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cepInicial.setText("00000-000");
        txt_cepInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cepInicialKeyPressed(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Inicial");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Final");

        bt_pesquisaCepInicial.setText("...");
        bt_pesquisaCepInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaCepInicialActionPerformed(evt);
            }
        });

        bt_pesquisaClienteInicial.setText("...");
        bt_pesquisaClienteInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaClienteInicialActionPerformed(evt);
            }
        });

        bt_pesquisaCepFinal.setText("...");
        bt_pesquisaCepFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaCepFinalActionPerformed(evt);
            }
        });

        bt_pesquisaClienteFinal.setText("...");
        bt_pesquisaClienteFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaClienteFinalActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("CEP:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(209, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(287, 287, 287))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nascimentoInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(txt_cadastroInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(txt_clienteInicial)
                            .addComponent(txt_cepInicial))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_pesquisaClienteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_pesquisaCepInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_cepFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_pesquisaCepFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_clienteFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_pesquisaClienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_cadastroFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(txt_nascimentoFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combo_pessoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combo_Status, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {combo_Status, combo_pessoa, jLabel12, jLabel13, txt_cadastroFinal, txt_cadastroInicial, txt_cepFinal, txt_cepInicial, txt_clienteFinal, txt_clienteInicial, txt_nascimentoFinal, txt_nascimentoInicial});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel2, jLabel4, jLabel5, jLabel7, jLabel9});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_pesquisaClienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_clienteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txt_clienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaClienteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(combo_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(combo_pessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_nascimentoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_nascimentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_cadastroInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_cadastroFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_pesquisaCepFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaCepInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cepFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cepInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaCepFinal, bt_pesquisaCepInicial, bt_pesquisaClienteFinal, bt_pesquisaClienteInicial, combo_Status, jLabel12, jLabel13, jLabel2, jLabel4, jLabel5, jLabel9, txt_cepFinal, txt_cepInicial, txt_clienteFinal, txt_clienteInicial, txt_nascimentoFinal, txt_nascimentoInicial});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, jLabel7, txt_cadastroFinal, txt_cadastroInicial});

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        bt_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/print.png"))); // NOI18N
        bt_imprimir.setText("Imprimir");
        bt_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imprimirActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        bt_sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });
        jMenu1.add(bt_sair);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_imprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_imprimir, jButton2});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nascimentoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nascimentoInicialFocusLost
        txt_nascimentoInicial.setText(fc.FormataCampo(txt_nascimentoInicial.getText(), 10, 2));
    }//GEN-LAST:event_txt_nascimentoInicialFocusLost

    private void txt_nascimentoInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nascimentoInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nascimentoInicialActionPerformed

    private void txt_nascimentoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nascimentoFinalFocusLost
        txt_nascimentoFinal.setText(fc.FormataCampo(txt_nascimentoFinal.getText(), 10, 2));
    }//GEN-LAST:event_txt_nascimentoFinalFocusLost

    private void txt_nascimentoFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nascimentoFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nascimentoFinalActionPerformed

    private void bt_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimirActionPerformed
        PegaValores();
    }//GEN-LAST:event_bt_imprimirActionPerformed

    private void txt_cadastroInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cadastroInicialFocusLost
        txt_cadastroInicial.setText(fc.FormataCampo(txt_cadastroInicial.getText(), 10, 2));
    }//GEN-LAST:event_txt_cadastroInicialFocusLost

    private void txt_cadastroInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cadastroInicialActionPerformed
        
    }//GEN-LAST:event_txt_cadastroInicialActionPerformed

    private void txt_cadastroFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cadastroFinalFocusLost
        txt_cadastroFinal.setText(fc.FormataCampo(txt_cadastroFinal.getText(), 10, 2));
    }//GEN-LAST:event_txt_cadastroFinalFocusLost

    private void txt_cadastroFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cadastroFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cadastroFinalActionPerformed

    private void txt_clienteFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_clienteFinalFocusLost
        txt_clienteFinal.setText(fc.FormataCampo(txt_clienteFinal.getText(), 5, 0));
    }//GEN-LAST:event_txt_clienteFinalFocusLost

    private void txt_clienteInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_clienteInicialFocusLost
        txt_clienteInicial.setText(fc.FormataCampo(txt_clienteInicial.getText(), 5, 0));
    }//GEN-LAST:event_txt_clienteInicialFocusLost

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
            combo_Status.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_clienteFinal.setText("99999");
            combo_Status.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_clienteFinalKeyPressed

    private void txt_nascimentoInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nascimentoInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_nascimentoFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_nascimentoInicial.setText(fc.FormataCampo("", 10, 2));
            txt_nascimentoFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_nascimentoInicialKeyPressed

    private void txt_nascimentoFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nascimentoFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_cadastroInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_nascimentoFinal.setText("99999999");
            txt_cadastroInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_nascimentoFinalKeyPressed

    private void txt_cadastroInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cadastroInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_cadastroFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_cadastroInicial.setText(fc.FormataCampo("", 10, 2));
            txt_cadastroFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_cadastroInicialKeyPressed

    private void txt_cadastroFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cadastroFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_cepInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_cadastroFinal.setText("99999999");
            txt_cepInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_cadastroFinalKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuCliente == 0){
            AbreCEP();
            return;
        }
        abriuCliente = 0;
        retorno = ConCli.getRetorno();
        if(retorno.equals(""))
            return;
        if(Campo.equals("I")){
            txt_clienteInicial.setText(fc.FormataCampo(retorno, 5, 0));
            return;
        }
        txt_clienteFinal.setText(fc.FormataCampo(retorno, 5, 0));
    }//GEN-LAST:event_formWindowGainedFocus

    private void combo_StatusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_StatusKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            combo_pessoa.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            combo_Status.setSelectedIndex(0);
            combo_pessoa.grabFocus();
            return;
        }
    }//GEN-LAST:event_combo_StatusKeyPressed

    private void combo_pessoaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_pessoaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_nascimentoInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            combo_pessoa.setSelectedIndex(0);
            txt_nascimentoInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_combo_pessoaKeyPressed

    private void txt_cepInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cepInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_cepFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_cepInicial.setText(fc.FormataCampo("", 8, 0));
            txt_cepFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_cepInicialKeyPressed

    private void txt_cepFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cepFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            bt_imprimir.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_cepFinal.setText(fc.FormataCampo("", 8, 0));
            bt_imprimir.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_cepFinalKeyPressed
    
    private void AbreCEP(){
        if(abriuCEP == 0)
            return;
        abriuCEP = 0;
        retorno = ConCodEndPos.getRetorno();
        if(retorno.equals(""))
            return;
        if(Campo.equals("I")){
            txt_cepInicial.setText(retorno);
            return;
        }
        txt_cepFinal.setText(retorno);
    }
    
    private void bt_pesquisaClienteInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaClienteInicialActionPerformed
        Campo = "I";
        PesquisaCliente();
    }//GEN-LAST:event_bt_pesquisaClienteInicialActionPerformed
    
    private void PesquisaCliente(){
        if(ConCli != null)if(ConCli.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuCliente = 1;
        ConCli = new ClientesConsulta("N");
        ConCli.setVisible(true);
    }
    
    private void bt_pesquisaClienteFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaClienteFinalActionPerformed
        Campo = "F";
        PesquisaCliente();
    }//GEN-LAST:event_bt_pesquisaClienteFinalActionPerformed

    private void bt_pesquisaCepInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaCepInicialActionPerformed
        Campo = "I";
        PesquisaCEP();
    }//GEN-LAST:event_bt_pesquisaCepInicialActionPerformed
    
    private void PesquisaCEP(){
        if(ConCodEndPos != null)if(ConCodEndPos.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuCEP = 1;
        ConCodEndPos = new CodigoEnderecamentoPostalConsulta();
        ConCodEndPos.setVisible(true);
    }
    
    private void bt_pesquisaCepFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaCepFinalActionPerformed
        Campo = "F";
        PesquisaCEP();
    }//GEN-LAST:event_bt_pesquisaCepFinalActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        InicializaCampos();
        PegaParametros();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(ConCli          != null)ConCli       .dispose();
        if(ConCodEndPos    != null)ConCodEndPos .dispose();
    }//GEN-LAST:event_formWindowClosed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_imprimir;
    private javax.swing.JButton bt_pesquisaCepFinal;
    private javax.swing.JButton bt_pesquisaCepInicial;
    private javax.swing.JButton bt_pesquisaClienteFinal;
    private javax.swing.JButton bt_pesquisaClienteInicial;
    private javax.swing.JMenuItem bt_sair;
    private javax.swing.JComboBox<String> combo_Status;
    private javax.swing.JComboBox<String> combo_pessoa;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txt_cadastroFinal;
    private javax.swing.JFormattedTextField txt_cadastroInicial;
    private javax.swing.JFormattedTextField txt_cepFinal;
    private javax.swing.JFormattedTextField txt_cepInicial;
    private javax.swing.JFormattedTextField txt_clienteFinal;
    private javax.swing.JFormattedTextField txt_clienteInicial;
    private javax.swing.JFormattedTextField txt_nascimentoFinal;
    private javax.swing.JFormattedTextField txt_nascimentoInicial;
    // End of variables declaration//GEN-END:variables
    
    private void PegaValores(){
        binter.clienteInicial       = Integer.parseInt(txt_clienteInicial.getText());
        binter.clienteFinal         = Integer.parseInt(txt_clienteFinal.getText());
        if(binter.clienteInicial > binter.clienteFinal){
            Mensagem = "Cliente Inicial não pode ser maior do que Cliente Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        
        preenchimento               = "";
        StatusCliente               = combo_Status.getSelectedIndex();
        if(StatusCliente != 0){
            StatusCliente = StatusCliente - 1;
            preenchimento = preenchimento + "statusCliente = " + StatusCliente + " and ";
        }
        
        FisicaJuridica              = combo_pessoa.getSelectedIndex();
        if(FisicaJuridica != 0){
            FisicaJuridica = FisicaJuridica - 1;
            preenchimento = preenchimento + "fisicaJuridica = " + FisicaJuridica + " and ";
        }
        
        binter.dataAberturaInicial  = Test.Testa(txt_nascimentoInicial.getText());
        binter.dataAberturaFinal    = Test.Testa(txt_nascimentoFinal.getText());
        if(binter.dataAberturaInicial > binter.dataAberturaFinal){
            Mensagem = "Data de Abertura Inicial não pode ser maior do que Data de Abertura Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        
        binter.dataCadastroInicial  = Test.Testa(txt_cadastroInicial.getText());
        binter.dataCadastroFinal    = Test.Testa(txt_cadastroFinal.getText());
        if(binter.dataCadastroInicial > binter.dataCadastroFinal){
            Mensagem = "Data de Cadastro Inicial não pode ser maior do que Data de Cadastro Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        binter.cepInicial          = Integer.parseInt(txt_cepInicial.getText().replace("-", ""));
        binter.cepFinal            = Integer.parseInt(txt_cepFinal.getText().replace("-", ""));
        if(binter.cepInicial > binter.cepFinal){
            Mensagem = "Cep Inicial não pode ser maior do que o Cep Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        MontaSQL();
    }
    
    private void MontaSQL(){
        sql = "select * from tb_clientes where "
            + preenchimento
            + "codigoCliente between "  + binter.clienteInicial         + " and " + binter.clienteFinal         + " and "
            + "dataNascAber between "   + binter.dataAberturaInicial    + " and " + binter.dataAberturaFinal    + " and "
            + "dataCadastro between "   + binter.dataCadastroInicial    + " and " + binter.dataCadastroFinal    + " and "
            + "cep between "            + binter.cepInicial             + " and " + binter.cepFinal             + ";";
        Imprime();
    }
    
    private void Imprime(){
        try{
            stmt = parametrosNS.con.prepareStatement(sql);
            rs   = stmt.executeQuery();
            js = new JRResultSetDataSource(rs);
            
            hm.put("nomeEmpresa",       parametrosNS.be.nomeEmpresa);
            hm.put("enderecoEmpresa",   parametrosNS.be.enderecoEmpresa + ", " + parametrosNS.be.numeroEmpresa);
            hm.put("cepEmpresa",        parametrosNS.be.cepEmpresa);
            hm.put("cidadeEmpresa",     parametrosNS.be.cidadeEmpresa + ", " + parametrosNS.be.ufEmpresa);
            hm.put("bairroEmpresa",     parametrosNS.be.bairroEmpresa);
            hm.put("logotipoEmpresa",   parametrosNS.bge.pastaImagemLogotipo + "/LOGOTIPO." + parametrosNS.bge.extensaoImagemLogotipo);
            hm.put("telefoneEmpresa",   parametrosNS.be.telefoneEmpresa);
            hm.put("cnpjEmpresa",       FCpfCnpj.FormataCPFCNPJ(parametrosNS.be.cnpjEmpresa));
            
            jpv = bpar.pastaRelatorios + "/RelatoriosClientes.jasper";
            
            jpp = JasperFillManager.fillReport(jpv, hm, js);
            JasperViewer.viewReport(jpp, false);
        }catch(Exception erro){
            Mensagem = "Erro ao imprimir: " + erro.getMessage();
            new MostraMensagem(Mensagem);
        }
    }
    
}
