package TelasDeConfiguracoes;


import Parametros.parametrosNS;
import BeansNS.BeanCEP;
import BeansNS.BeanEmpresas;
import BeansNS.BeanGrupoEmpresa;
import FuncoesInternas.InverterData;
import FuncoesInternas.TransformarSenhaSistemaEmData;
import FuncoesInternas.TransformarDataSistemaEmSenha;
import java.io.*;
import java.util.*;
import javax.swing.*;
//import FabricaConexao.*;
import FuncoesInternas.*;
import Main.BarraInicial;
import Main.ProcessoInicial;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
/*
 @author Tiago e Paulo
 */
public class EmpresasCadastro extends javax.swing.JFrame {
    //String's
    String ValorFormatado           = "";
    String mensagem                 = "";
    String fatal                    = "N";
    String retorno                  = "";
    String sql                      = "";
    String sqlstate                 = "00000";
    String operacao                 = "";
    String operacaoBancoDados       = "";
    String pastaImagemLogotipo      = "";
    
    //boolean
    boolean ValidadorCnpj   = false;
    boolean ValidadorIE     = false;
    
    //int's
    int     AbriuCodigo             = 0;
    int     abriuEmpresas           = 0;
    
    //ArrayList's
    ArrayList            parametros                            = new ArrayList();
    ArrayList<ArrayList> dadosGrupos                           = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosEmpresas                         = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosCEP                              = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosCount                            = new ArrayList<ArrayList>();
    
    //bean's
    BeanGrupoEmpresa                bge             = new BeanGrupoEmpresa();
    BeanEmpresas                    be              = new BeanEmpresas();
    BeanCEP                         bcep            = new BeanCEP();
    
    //Outros
    FormataCampo                    fc              = new FormataCampo();
    Criptografia                    crpt            = new Criptografia();
    TransformarSenhaSistemaEmData   TSSED           = new TransformarSenhaSistemaEmData();
    TransformarDataSistemaEmSenha    TDSES           = new TransformarDataSistemaEmSenha();
    JFileChooser                    seletor         = new JFileChooser();
    ValidarCpfCnpj                  Vcc             = new ValidarCpfCnpj();
    ValidarIE                       VIE             = new ValidarIE();
    File                            arquivoPasta    = null;
    InverterData                    invdata         = new InverterData();
    
    //Telas
    BarraInicial                    Bar;
    ProcessoInicial                 ProIni;
    EmpresasConsulta                EmpCon;
    GruposCadastro                  CadGru;
    GruposConsulta                  ConGru;
    SalvarBancoDeDados              SavBdD;
    
    //Especiais
    BufferedImage                   BuffImg;
    ByteArrayOutputStream           BytesImg;
    ImageIcon                       imgIcon;
    Image                           img;
    
    public EmpresasCadastro(){
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_empresa = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        label_NomeGrupo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_fantasia = new javax.swing.JTextField();
        txt_codigoGrupo = new javax.swing.JFormattedTextField();
        txt_codigoEmpresa = new javax.swing.JFormattedTextField();
        bt_novo = new javax.swing.JButton();
        bt_pesquisagrupo = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        txt_cnpj3 = new javax.swing.JFormattedTextField();
        txt_cnpj1 = new javax.swing.JFormattedTextField();
        txt_cnpj2 = new javax.swing.JFormattedTextField();
        bt_pesquisaempresas = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txt_inscricaoEstadual = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        combo_regimeTributario = new javax.swing.JComboBox<>();
        bt_confirma = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        txt_cep = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_endereco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_cidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_bairro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_numero = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_uf = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txt_telefone = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        label_imagem = new javax.swing.JLabel();
        bt_imagem = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        bt_sair1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(":: Cadastro de Empresas");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel11.setText(":: Empresa");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11))
        );

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Grupo: ");

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Codigo: ");

        txt_empresa.setEditable(false);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Nome empresa:");

        label_NomeGrupo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel5.setText("Nome Fantasia: ");

        txt_fantasia.setEditable(false);
        txt_fantasia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        try {
            txt_codigoGrupo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoGrupo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoGrupo.setText("00");
        txt_codigoGrupo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoGrupoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoGrupoFocusLost(evt);
            }
        });
        txt_codigoGrupo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoGrupoKeyPressed(evt);
            }
        });

        try {
            txt_codigoEmpresa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoEmpresa.setEditable(false);
        txt_codigoEmpresa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoEmpresa.setText("000");
        txt_codigoEmpresa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoEmpresaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoEmpresaFocusLost(evt);
            }
        });
        txt_codigoEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoEmpresaActionPerformed(evt);
            }
        });

        bt_novo.setText("Novo");
        bt_novo.setEnabled(false);
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        bt_pesquisagrupo.setText("...");
        bt_pesquisagrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisagrupoActionPerformed(evt);
            }
        });

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("C.N.P.J:");

        try{
            txt_cnpj3.setEditable(false);
            txt_cnpj3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cnpj3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cnpj3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_cnpj3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cnpj3FocusLost(evt);
            }
        });
        txt_cnpj3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cnpj3ActionPerformed(evt);
            }
        });

        try{
            txt_cnpj1.setEditable(false);
            txt_cnpj1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("### ### ###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cnpj1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cnpj1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_cnpj1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cnpj1FocusLost(evt);
            }
        });
        txt_cnpj1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cnpj1ActionPerformed(evt);
            }
        });
        txt_cnpj1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cnpj1KeyReleased(evt);
            }
        });

        try {
            txt_cnpj2.setEditable(false);
            txt_cnpj2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cnpj2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cnpj2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_cnpj2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cnpj2FocusLost(evt);
            }
        });
        txt_cnpj2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cnpj2ActionPerformed(evt);
            }
        });

        bt_pesquisaempresas.setText("...");
        bt_pesquisaempresas.setEnabled(false);
        bt_pesquisaempresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaempresasActionPerformed(evt);
            }
        });

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("IE:");

        txt_inscricaoEstadual.setEditable(false);
        try {
            txt_inscricaoEstadual.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("***************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_inscricaoEstadual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_inscricaoEstadual.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_inscricaoEstadualFocusLost(evt);
            }
        });

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Regime Tributário:");

        combo_regimeTributario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----------------------------------------", "Simples Nacional", "Simples Nacional - excesso de sublimite de receita bruta", "Regime Normal" }));
        combo_regimeTributario.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_codigoEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(txt_codigoGrupo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt_pesquisagrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_NomeGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bt_pesquisaempresas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17))
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_empresa)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_cnpj1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_cnpj2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_cnpj3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(combo_regimeTributario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_inscricaoEstadual)
                            .addComponent(txt_fantasia))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel17, jLabel20});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel18, jLabel5});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bt_pesquisagrupo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_NomeGrupo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(txt_codigoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_empresa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bt_pesquisaempresas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_fantasia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoEmpresa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_novo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txt_cnpj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cnpj2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cnpj3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(txt_inscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(combo_regimeTributario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisagrupo, jLabel15, label_NomeGrupo, txt_codigoGrupo});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, bt_pesquisaempresas, combo_regimeTributario, jLabel16, jLabel17, jLabel18, jLabel19, jLabel20, jLabel5, txt_cnpj1, txt_cnpj2, txt_cnpj3, txt_codigoEmpresa, txt_empresa, txt_fantasia, txt_inscricaoEstadual});

        bt_confirma.setText("Confirma");
        bt_confirma.setEnabled(false);
        bt_confirma.setFocusPainted(false);
        bt_confirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmaActionPerformed(evt);
            }
        });

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setVerifyInputWhenFocusTarget(false);

        jPanel2.setDoubleBuffered(false);
        jPanel2.setEnabled(false);
        jPanel2.setFocusable(false);
        jPanel2.setRequestFocusEnabled(false);
        jPanel2.setVerifyInputWhenFocusTarget(false);

        txt_cep.setEditable(false);
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
        txt_cep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_cepMouseClicked(evt);
            }
        });
        txt_cep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cepActionPerformed(evt);
            }
        });
        txt_cep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cepKeyReleased(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("CEP: ");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Endereço:");

        txt_endereco.setEditable(false);

        jLabel3.setText("Cidade:");

        txt_cidade.setEditable(false);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Bairro: ");

        txt_bairro.setEditable(false);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Numero: ");

        txt_numero.setEditable(false);

        jLabel9.setText("Unidade Federativa: ");

        txt_uf.setEditable(false);
        txt_uf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_ufFocusLost(evt);
            }
        });

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Telefone:");

        try {
            txt_telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## ########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_telefone.setEditable(false);
        try {
            txt_telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## #########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_telefone.setText("00 000000000");
        txt_telefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_telefoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_telefoneFocusLost(evt);
            }
        });
        txt_telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_cidade, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
                            .addComponent(txt_endereco))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_uf, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                            .addComponent(txt_bairro)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel21});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_cep, txt_telefone});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txt_uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel21, jLabel3, jLabel6, jLabel7, txt_bairro, txt_cep, txt_cidade, txt_endereco, txt_telefone});

        jTabbedPane1.addTab("Dados Cadastrais", jPanel2);

        jPanel3.setDoubleBuffered(false);
        jPanel3.setEnabled(false);
        jPanel3.setFocusable(false);
        jPanel3.setRequestFocusEnabled(false);
        jPanel3.setVerifyInputWhenFocusTarget(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Logotipo da Empresa:");

        label_imagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_imagem.setToolTipText("");
        label_imagem.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bt_imagem.setText("Buscar imagem");
        bt_imagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imagemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_imagem, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_imagem)
                .addGap(263, 263, 263))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_imagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_imagem, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 191, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Informações da Empresa", jPanel3);

        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivos");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Cadastrar Grupos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Gravar Banco de Dados");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
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
                        .addComponent(bt_confirma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_sair))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_confirma, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoGrupoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoGrupoFocusGained
        txt_codigoGrupo.setSelectionStart(0);
        txt_codigoGrupo.setSelectionEnd(txt_codigoGrupo.getText().length());
        label_NomeGrupo.setText("");
        bt_confirma.setEnabled(false);
        ReiniciaCodigo(false);
        bt_pesquisaempresas.setEnabled(false);
    }//GEN-LAST:event_txt_codigoGrupoFocusGained

    private void txt_codigoGrupoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoGrupoFocusLost
        if(txt_codigoGrupo.isEditable() == false)
            return;
        if(txt_codigoGrupo.getText().replace(" ", "").equals(""))
            return;
        PegaGrupo();
    }//GEN-LAST:event_txt_codigoGrupoFocusLost
    
    private void txt_codigoGrupoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoGrupoKeyPressed

    }//GEN-LAST:event_txt_codigoGrupoKeyPressed

    private void txt_codigoEmpresaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoEmpresaFocusGained
        ReiniciaTela(false);
        txt_codigoEmpresa.setText("");
    }//GEN-LAST:event_txt_codigoEmpresaFocusGained

    private void txt_codigoEmpresaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoEmpresaFocusLost
        if(txt_codigoEmpresa.getText().replace(" ", "").equals(""))
            return;
        PegaCodigoEmpresa("S");
    }//GEN-LAST:event_txt_codigoEmpresaFocusLost

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        operacao = "I";
        operacaoBancoDados = "I";
        PegaProximaEmpresa();
        
        txt_codigoEmpresa.setText(fc.FormataCampo(String.valueOf(be.codigoEmpresa), 3, 0));
        ReiniciaTela(true);
        txt_empresa.grabFocus();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void bt_pesquisagrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisagrupoActionPerformed
        AbriuCodigo = 1;
        ConGru = new GruposConsulta();
        ConGru.setVisible(true);
    }//GEN-LAST:event_bt_pesquisagrupoActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
        if(AbriuCodigo == 0){
            abriuEmpresas();
            return;
        }
        retorno = ConGru.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoGrupo.setText(retorno);
        AbriuCodigo = 0;
        PegaGrupo();
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void abriuEmpresas(){
        if(abriuEmpresas == 0)
            return;
        retorno = EmpCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoEmpresa.setText(retorno);
        abriuEmpresas = 0;
        PegaCodigoEmpresa("S");
    }
    
    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        Sair();
    }//GEN-LAST:event_bt_sairActionPerformed
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        AbreCadastroGrupo();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void txt_cnpj3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cnpj3FocusLost
        txt_cnpj3.setText(fc.FormataCampo(txt_cnpj3.getText(), 2, 0));
        ValidaCPFCNPJ();
    }//GEN-LAST:event_txt_cnpj3FocusLost

    private void txt_cnpj3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cnpj3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cnpj3ActionPerformed

    private void txt_cnpj1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cnpj1FocusGained
        txt_cnpj1.setSelectionStart(0);
        txt_cnpj1.setSelectionEnd  (txt_cnpj1.getText().length());
    }//GEN-LAST:event_txt_cnpj1FocusGained

    private void txt_cnpj1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cnpj1FocusLost
        txt_cnpj1.setText(fc.FormataCampo(txt_cnpj1.getText(), 11, 2));
    }//GEN-LAST:event_txt_cnpj1FocusLost

    private void txt_cnpj1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cnpj1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cnpj1ActionPerformed

    private void txt_cnpj1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cnpj1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cnpj1KeyReleased

    private void txt_cnpj2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cnpj2FocusLost
        txt_cnpj2.setText(fc.FormataCampo(txt_cnpj2.getText(), 4, 0));
    }//GEN-LAST:event_txt_cnpj2FocusLost

    private void txt_cnpj2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cnpj2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cnpj2ActionPerformed

    private void bt_pesquisaempresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaempresasActionPerformed
        if(EmpCon != null)if(EmpCon.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        abriuEmpresas = 1;
        EmpCon = new EmpresasConsulta(Integer.parseInt(txt_codigoGrupo.getText()));
        EmpCon.setVisible(true); 
    }//GEN-LAST:event_bt_pesquisaempresasActionPerformed

    private void txt_cnpj2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cnpj2FocusGained
        txt_cnpj2.setSelectionStart(0);
        txt_cnpj2.setSelectionEnd  (txt_cnpj2.getText().length());
    }//GEN-LAST:event_txt_cnpj2FocusGained

    private void txt_cnpj3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cnpj3FocusGained
        txt_cnpj3.setSelectionStart(0);
        txt_cnpj3.setSelectionEnd  (txt_cnpj3.getText().length());
    }//GEN-LAST:event_txt_cnpj3FocusGained

    private void txt_codigoEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoEmpresaActionPerformed

    private void bt_confirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmaActionPerformed
        if(operacao.equals("I")){
            IncluirEmpresa();
            return;
        }
        AlterarEmpresa();
    }//GEN-LAST:event_bt_confirmaActionPerformed

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        Sair();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if(SavBdD != null)if(SavBdD.isVisible()){
            mensagem = "Tela já Aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        SavBdD = new SalvarBancoDeDados("");
        SavBdD.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txt_inscricaoEstadualFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_inscricaoEstadualFocusLost
        if(txt_inscricaoEstadual.isEditable() == false)
            return;
        be.InscricaoEstadual    = txt_inscricaoEstadual.getText().replace(" ", "");
        ValidadorIE = VIE.ValidadorDeIE(be.InscricaoEstadual);
        bt_confirma.setEnabled(true);
        if(ValidadorIE == false){
            bt_confirma.setEnabled(false);
            if(!be.InscricaoEstadual.equals("")){
                mensagem = "Inscrição Estadual Inválida!";
                new MostraMensagem(mensagem);
            }
        }
    }//GEN-LAST:event_txt_inscricaoEstadualFocusLost

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(EmpCon       != null)EmpCon  .dispose();
        if(CadGru       != null)CadGru  .dispose();
        if(ConGru       != null)ConGru  .dispose();
        if(SavBdD       != null)SavBdD  .dispose();
    }//GEN-LAST:event_formWindowClosed

    private void txt_telefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefoneActionPerformed

    private void txt_telefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_telefoneFocusLost
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_txt_telefoneFocusLost

    private void txt_telefoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_telefoneFocusGained
        txt_telefone.setSelectionStart(0);
        txt_telefone.setSelectionEnd(txt_telefone.getText().length());
    }//GEN-LAST:event_txt_telefoneFocusGained

    private void txt_ufFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_ufFocusLost
        //        jTabbedPane1.setSelectedIndex(1);
        //        txt_pastausuario.grabFocus();
    }//GEN-LAST:event_txt_ufFocusLost

    private void txt_cepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cepKeyReleased

    }//GEN-LAST:event_txt_cepKeyReleased

    private void txt_cepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cepActionPerformed

    private void txt_cepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_cepMouseClicked

    }//GEN-LAST:event_txt_cepMouseClicked

    private void txt_cepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cepFocusLost
        PegaCEP();
    }//GEN-LAST:event_txt_cepFocusLost

    private void txt_cepFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cepFocusGained

    }//GEN-LAST:event_txt_cepFocusGained

    private void bt_imagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imagemActionPerformed
        if(operacao.equals(""))
            return;
        seletor = new JFileChooser("C:/"); 
        seletor.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = seletor.showOpenDialog(null);
        if(i == 1)
            return;
        arquivoPasta = seletor.getSelectedFile();
        if(arquivoPasta.getPath().equals(""))
            return;
        pastaImagemLogotipo = arquivoPasta.getPath();
        CarregaImagem();
    }//GEN-LAST:event_bt_imagemActionPerformed
    
    public void CarregaImagem(){
        imgIcon = null;
        imgIcon = new ImageIcon(pastaImagemLogotipo);
        img     = imgIcon.getImage();
        img     = img.getScaledInstance(label_imagem.getWidth() - 1, label_imagem.getHeight() - 1, img.SCALE_DEFAULT);
        label_imagem.setIcon(new ImageIcon(img));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_confirma;
    private javax.swing.JButton bt_imagem;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisaempresas;
    private javax.swing.JButton bt_pesquisagrupo;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JComboBox<String> combo_regimeTributario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel label_NomeGrupo;
    private javax.swing.JLabel label_imagem;
    private javax.swing.JTextField txt_bairro;
    private javax.swing.JFormattedTextField txt_cep;
    private javax.swing.JTextField txt_cidade;
    private javax.swing.JFormattedTextField txt_cnpj1;
    private javax.swing.JFormattedTextField txt_cnpj2;
    private javax.swing.JFormattedTextField txt_cnpj3;
    private javax.swing.JFormattedTextField txt_codigoEmpresa;
    private javax.swing.JFormattedTextField txt_codigoGrupo;
    private javax.swing.JTextField txt_empresa;
    private javax.swing.JTextField txt_endereco;
    private javax.swing.JTextField txt_fantasia;
    private javax.swing.JFormattedTextField txt_inscricaoEstadual;
    private javax.swing.JTextField txt_numero;
    private javax.swing.JFormattedTextField txt_telefone;
    private javax.swing.JTextField txt_uf;
    // End of variables declaration//GEN-END:variables
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    public void ReiniciaCodigo(boolean Habilita){
        txt_codigoEmpresa              .setText    ("000");
        txt_codigoEmpresa              .setEditable(Habilita);
        bt_pesquisaempresas     .setEnabled (Habilita);
        txt_empresa             .setEditable(Habilita);
        txt_fantasia            .setEditable(Habilita);
        ReiniciaTela(Habilita);
    }
    
    public void ReiniciaTela(boolean Habilita){
        txt_empresa           .setText     ("");
        txt_fantasia          .setText     ("");
        txt_cnpj1             .setText     ("");
        txt_cnpj1             .setEditable (Habilita);
        txt_cnpj2             .setText     ("");
        txt_cnpj2             .setEditable (Habilita);
        txt_cnpj3             .setText     ("");
        txt_cnpj3             .setEditable (Habilita);
        txt_inscricaoEstadual .setText     ("");
        txt_inscricaoEstadual .setEditable (Habilita);
        combo_regimeTributario.setSelectedIndex(0);
        combo_regimeTributario.setEnabled  (Habilita);
        txt_cep               .setText     ("");
        txt_cep               .setEditable (Habilita);
        txt_cidade            .setText     ("");
        txt_cidade            .setEditable (Habilita);
        txt_bairro            .setText     ("");
        txt_bairro            .setEditable (Habilita);
        txt_endereco          .setText     ("");
        txt_endereco          .setEditable (Habilita);
        txt_numero            .setText     ("");
        txt_numero            .setEditable (Habilita);
        txt_uf                .setText     ("");
        txt_uf                .setEditable (Habilita);
        txt_telefone          .setText     ("");
        txt_telefone          .setEditable (Habilita);
        bt_confirma           .setEnabled  (Habilita);
        bt_confirma           .setFocusable(Habilita);
        label_imagem          .setIcon     (null);
        bt_imagem             .setEnabled  (Habilita);
        bt_imagem             .setFocusable(Habilita);
    }
    
    private void PegaCEP(){
        bcep.cep = txt_cep.getText();
        bcep.cep = bcep.cep.replace(" ", "");
        bcep.cep = bcep.cep.replace("-", "");
        if(bcep.cep.equals(""))
            return;
        sql = "select * from ns_cep where cep = " + bcep.cep + ";";
        dadosCEP.clear();
        dadosCEP = parametrosNS.dao.Consulta(sql);
        if(dadosCEP.isEmpty()){
            mensagem = "Cep não encontrado!";
            new MostraMensagem(mensagem);
            return;
        }
        PreencherCEP();
    }
    
    private void PreencherCEP(){
        for(int i = 0; i < dadosCEP.size(); i++){
            bcep.cep        = String.valueOf(dadosCEP.get(i).get(0));
            bcep.endereco   = String.valueOf(dadosCEP.get(i).get(1));
            bcep.cidade     = String.valueOf(dadosCEP.get(i).get(2));
            bcep.bairro     = String.valueOf(dadosCEP.get(i).get(3));
            bcep.uf         = String.valueOf(dadosCEP.get(i).get(4));
        }
        txt_cep.setText(bcep.cep);
        txt_cidade.setText(bcep.cidade);
        txt_endereco.setText(bcep.endereco);
        txt_bairro.setText(bcep.bairro);
        txt_numero.grabFocus();
    }
    
    private void AbreCadastroGrupo(){
        CadGru = new GruposCadastro("");
        CadGru.setVisible(true);
    }
    
    private void PegaProximaEmpresa(){
        be.codigoGrupo = Integer.parseInt(fc.FormataCampo(txt_codigoGrupo.getText(), 2, 0));
        sql = "select count(*) from ns_empresas where codigoGrupo = " + be.codigoGrupo + ";";
        dadosCount.clear();
        dadosCount = parametrosNS.dao.Consulta(sql);
        be.codigoEmpresa = Integer.parseInt(  String.valueOf(dadosCount.get(0).get(0))) + 1;
    }
    
    private void PegaGrupo(){
        fatal = "N";
        txt_codigoGrupo.setText(fc.FormataCampo(txt_codigoGrupo.getText(), 2, 0));
        bge.codigoGrupo = Integer.parseInt(txt_codigoGrupo.getText());
        if(bge.codigoGrupo == 0){
            fatal = "S";
            return;
        }
        sql = "select * from ns_grupoempresa where codigoGrupo = " + bge.codigoGrupo + ";";
        dadosGrupos.clear();
        dadosGrupos = parametrosNS.dao.Consulta(sql);
        if(dadosGrupos.isEmpty()){
            mensagem = "Grupo não encontrado!";
            new MostraMensagem(mensagem);
            fatal = "S";
            return;
        }
        ReiniciaCodigo(true);
        PegaDadosGrupo();
        bt_novo.setEnabled(true);
        bt_pesquisaempresas.setEnabled(true);
    }
    
    private void PegaDadosGrupo(){
        for(int i = 0; i < dadosGrupos.size(); i++){
            bge.codigoGrupo             = Integer.parseInt( String.valueOf(dadosGrupos.get(i).get(0)));
            bge.nomeGrupo               =                   String.valueOf(dadosGrupos.get(i).get(1));
            bge.pastaImagemLogotipo     =                   String.valueOf(dadosGrupos.get(i).get(2));
            bge.extensaoImagemLogotipo  =                   String.valueOf(dadosGrupos.get(i).get(3));
            bge.limiteUsuarios          = Integer.parseInt( String.valueOf(dadosGrupos.get(i).get(4)));
        }
        label_NomeGrupo.setText(bge.nomeGrupo);
        txt_codigoEmpresa.grabFocus();
    }
    
    private void PegaCodigoEmpresa(String Mostra){
        fatal = "N";
        be.codigoGrupo  = bge.codigoGrupo;
        txt_codigoEmpresa.setText(fc.FormataCampo(txt_codigoEmpresa.getText(), 3, 0));
        be.codigoEmpresa = Integer.parseInt(txt_codigoEmpresa.getText());
        if(be.codigoEmpresa == 0){
            fatal = "S";
            return;
        }
        sql = "select * from ns_empresas where codigoGrupo = " + be.codigoGrupo + " and codigoEmpresa = " + be.codigoEmpresa + ";";
        dadosEmpresas.clear();
        dadosEmpresas = parametrosNS.dao.Consulta(sql);
        if(dadosEmpresas.isEmpty()){
            if(Mostra.equals("N"))return;
            mensagem = "Empresa Código: " + be.codigoEmpresa + ", pertencente ao Grupo: " + be.codigoGrupo + ",  não está cadastrada!";
            new MostraMensagem(mensagem);
            fatal = "S";
            return;
        }
        if(Mostra.equals("S")){
            operacao = "A";
            ReiniciaTela(true);
        }
        PegaDadosCodigoEmpresa(Mostra);
    }
    
    private void PegaDadosCodigoEmpresa(String Mostra){
        be.idEmpresa                = Integer.parseInt(  String.valueOf(dadosEmpresas.get(0).get(0)));
        be.codigoGrupo              = Integer.parseInt(  String.valueOf(dadosEmpresas.get(0).get(1)));
        be.codigoEmpresa            = Integer.parseInt(  String.valueOf(dadosEmpresas.get(0).get(2)));
        be.idBancoDados             = Integer.parseInt(  String.valueOf(dadosEmpresas.get(0).get(3)));
        be.nomeEmpresa              =                    String.valueOf(dadosEmpresas.get(0).get(4));
        be.nomeFantasia             =                    String.valueOf(dadosEmpresas.get(0).get(5));
        be.cnpjEmpresa              =                    String.valueOf(dadosEmpresas.get(0).get(6));
        be.InscricaoEstadual        =                    String.valueOf(dadosEmpresas.get(0).get(7));
        be.RegimeTributario         =                    String.valueOf(dadosEmpresas.get(0).get(8));
        be.cepEmpresa               =                    String.valueOf(dadosEmpresas.get(0).get(9));
        be.cidadeEmpresa            =                    String.valueOf(dadosEmpresas.get(0).get(10));
        be.bairroEmpresa            =                    String.valueOf(dadosEmpresas.get(0).get(11));
        be.enderecoEmpresa          =                    String.valueOf(dadosEmpresas.get(0).get(12));
        be.numeroEmpresa            =                    String.valueOf(dadosEmpresas.get(0).get(13));
        be.ufEmpresa                =                    String.valueOf(dadosEmpresas.get(0).get(14));
        be.telefoneEmpresa          =                    String.valueOf(dadosEmpresas.get(0).get(15));
        be.pastaImagemUsuario       =                    String.valueOf(dadosEmpresas.get(0).get(16));
        be.extensaoImagemUsuario    =                    String.valueOf(dadosEmpresas.get(0).get(17));
        be.dataValidade             =                    String.valueOf(dadosEmpresas.get(0).get(18));
        
        if(Mostra.equals("N"))
            return;
        be.cnpjEmpresa1 = be.cnpjEmpresa.substring(0 , 9);
        be.cnpjEmpresa2 = be.cnpjEmpresa.substring(9 ,13);
        be.cnpjEmpresa3 = be.cnpjEmpresa.substring(13,15);
        txt_cnpj1.setText(be.cnpjEmpresa1);
        txt_cnpj2.setText(be.cnpjEmpresa2);
        txt_cnpj3.setText(be.cnpjEmpresa3);
        ValidadorCnpj = true;
        txt_inscricaoEstadual   .setText(be.InscricaoEstadual);
        ValidadorIE   = true;
        combo_regimeTributario  .setSelectedItem(be.RegimeTributario);
        txt_empresa             .setText(be.nomeEmpresa);
        txt_fantasia            .setText(be.nomeFantasia);
        txt_cep                 .setText(be.cepEmpresa);
        txt_cidade              .setText(be.cidadeEmpresa);
        txt_bairro              .setText(be.bairroEmpresa);
        txt_endereco            .setText(be.enderecoEmpresa);
        txt_numero              .setText(String.valueOf(be.numeroEmpresa));
        txt_uf                  .setText(be.ufEmpresa);
        txt_telefone            .setText(be.telefoneEmpresa);
        
        PegaImagemEmpresa();
        if(be.imagemLogotipoEmpresa == null)
            return;
        try{
            BuffImg = ImageIO.read(new ByteArrayInputStream(be.imagemLogotipoEmpresa));
            imgIcon = new ImageIcon(BuffImg);
            img     = imgIcon.getImage();
            img     = img.getScaledInstance(label_imagem.getWidth() - 1, label_imagem.getHeight() - 1, img.SCALE_DEFAULT);
            
            label_imagem.setIcon(new ImageIcon(img));
        }catch(IOException e){
            
        }
    }
    
    private void PegaImagemEmpresa(){
        sql = "select imagemLogotipoEmpresa from ns_empresas where codigoGrupo = " + be.codigoGrupo + " and codigoEmpresa = " + be.codigoEmpresa + ";";
        be.imagemLogotipoEmpresa = parametrosNS.dao.ConsultaLogotipo(sql, "imagemLogotipoEmpresa");
    }
    
    private void ValidaCPFCNPJ(){
        be.cnpjEmpresa1 = txt_cnpj1.getText().replace(" ", "");
        be.cnpjEmpresa2 = txt_cnpj2.getText().replace(" ", "");
        be.cnpjEmpresa3 = txt_cnpj3.getText().replace(" ", "");
        
        if(be.cnpjEmpresa1.equals(""))return;
        if(be.cnpjEmpresa2.equals(""))return;
        if(be.cnpjEmpresa3.equals(""))return;
        
        be.cnpjEmpresa = be.cnpjEmpresa1 + be.cnpjEmpresa2 + be.cnpjEmpresa3;
        ValidadorCnpj = Vcc.VALIDARCPFCNPJ(be.cnpjEmpresa);
        if(ValidadorCnpj == true)
            return;
        mensagem = "CNPJ inválido!";
        new MostraMensagem(mensagem);
        bt_confirma.setEnabled(false);
    }
    
    public void PegaValoresEmpresa(){
        fatal = "N";
        be.codigoGrupo = Integer.parseInt(fc.FormataCampo(txt_codigoGrupo.getText(), 2, 0));
        if(be.codigoGrupo == 0){
            mensagem = "Grupo Inválido!";
            new MostraMensagem(mensagem);
            fatal = "S";
            return;
        }
        be.codigoEmpresa = Integer.parseInt(fc.FormataCampo(txt_codigoEmpresa.getText(), 3, 0));
        if(be.codigoEmpresa == 0){
            mensagem = "Código Inválido!";
            new MostraMensagem(mensagem);
            fatal = "S";
            return;
        }
//        be.idBancoDados     = parametrosNS.dao.ConsultaAutoIncremento("ns_bancodados");
        be.idBancoDados     = 0;
        be.nomeEmpresa    = txt_empresa.getText();
        if(be.nomeEmpresa.equals("")){
            mensagem = "Empresa Inválida!!!";
            new MostraMensagem(mensagem);
            fatal = "S";
            return;
        }
        if(ValidadorCnpj == false){
            mensagem = "CNPJ inválido!";
            new MostraMensagem(mensagem);
            fatal = "S";
            return;
        }
        if(ValidadorIE == false){
            mensagem = "Inscrição Estadual Inválida!";
            new MostraMensagem(mensagem);
            fatal = "S";
            return;
        }
        be.InscricaoEstadual    = txt_inscricaoEstadual.getText().replace(" ", "");
        if(combo_regimeTributario.getSelectedIndex() == 0){
            mensagem = "Regime Tributário Inválido!";
            new MostraMensagem(mensagem);
            fatal = "S";
            return;
        }
        be.RegimeTributario     = String.valueOf(combo_regimeTributario.getSelectedItem());
        be.nomeFantasia = txt_fantasia.getText();
        if(be.nomeFantasia.equals("")){
            mensagem = "Nome Fantasia Inválido!!!";
            new MostraMensagem(mensagem);
            fatal = "S";
            return;
        }
        be.cepEmpresa   = txt_cep.getText();
        be.cepEmpresa   = be.cepEmpresa.replace("-", "");
        be.cepEmpresa   = be.cepEmpresa.replace(" ", "");
        if(be.cepEmpresa.equals("")){
            mensagem = "CEP Inválido!!!";
            new MostraMensagem(mensagem);
            fatal = "S";
            jTabbedPane1.setSelectedIndex(0);
            return;
        }
        be.cepEmpresa      = txt_cep.getText();
        be.cidadeEmpresa   = txt_cidade.getText();
        if(be.cidadeEmpresa.equals("")){
            mensagem = "Cidade Inválida!!!";
            new MostraMensagem(mensagem);
            fatal = "S";
            jTabbedPane1.setSelectedIndex(0);
            return;
        }
        be.bairroEmpresa   = txt_bairro.getText();
        if(be.bairroEmpresa.equals("")){
            mensagem = "Bairro Inválida!!!";
            new MostraMensagem(mensagem);
            fatal = "S";
            jTabbedPane1.setSelectedIndex(0);
            return;
        }
        be.enderecoEmpresa = txt_endereco.getText();
        if(be.enderecoEmpresa.equals("")){
            mensagem = "Endereco Inválido!!!";
            new MostraMensagem(mensagem);
            fatal = "S";
            jTabbedPane1.setSelectedIndex(0);
            return;
        }
        be.numeroEmpresa = txt_numero.getText();
        if(be.numeroEmpresa.equals("")){
            mensagem = "Número Inválido!!!";
            new MostraMensagem(mensagem);
            fatal = "S";
            jTabbedPane1.setSelectedIndex(0);
            return;
        }
        be.ufEmpresa     = txt_uf.getText();
        if(be.ufEmpresa.equals("")){
            mensagem = "UF Inválida!!!";
            new MostraMensagem(mensagem);
            fatal = "S";
            jTabbedPane1.setSelectedIndex(0);
            return;
        }
        be.telefoneEmpresa = txt_telefone.getText();
        be.telefoneEmpresa = be.telefoneEmpresa.replace(" ", "");
        if(be.telefoneEmpresa.equals("")){
            mensagem = "Telefone inválido!";
            new MostraMensagem(mensagem);
            fatal = "S";
            return;
        }
        be.telefoneEmpresa = txt_telefone.getText();
        be.pastaImagemUsuario       = "";
        be.extensaoImagemUsuario    = "";
        
        try{
            BuffImg  = ImageIO.read(new File(pastaImagemLogotipo));
            BytesImg = new ByteArrayOutputStream();
            
            ImageIO.write((BufferedImage)BuffImg, "jpg", BytesImg);
            BytesImg.flush();
            
            be.imagemLogotipoEmpresa    = BytesImg.toByteArray();
            BytesImg.close();
            be.setimagemLogotipoEmpresa(be.imagemLogotipoEmpresa);
        }catch(Exception erro){
            
        }
    }
    
    private void IncluirEmpresa(){
        PegaValoresEmpresa();
        if(fatal.equals("S"))
            return;
        
        sql = "insert into ns_empresas (codigoGrupo, codigoEmpresa, idBancoDados, nomeEmpresa, nomeFantasia, cnpjEmpresa, InscricaoEstadual, RegimeTributario, cepEmpresa, cidadeEmpresa, bairroEmpresa, enderecoEmpresa, numeroEmpresa, ufEmpresa, telefoneEmpresa, pastaImagemUsuario, extensaoImagemUsuario, dataValidade) "
            + "values (" + be.codigoGrupo + ", " + be.codigoEmpresa + ", " + be.idBancoDados + ", '" + be.nomeEmpresa + "', '" + be.nomeFantasia + "', '" + be.cnpjEmpresa + "', '" + be.InscricaoEstadual + "', '" + be.RegimeTributario + "', '" + be.cepEmpresa + "', '" + be.cidadeEmpresa + "', '" + be.bairroEmpresa + "', '" + be.enderecoEmpresa + "', '" + be.numeroEmpresa + "', '" + be.ufEmpresa + "', '" + be.telefoneEmpresa + "', '" + be.pastaImagemUsuario + "', '" + be.extensaoImagemUsuario + "', null);";
        
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao incluir Empresa!";
            new MostraMensagem(mensagem);
            return;
        }
        AtualizarImagens();
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao incluir Logotipo!";
            new MostraMensagem(mensagem);
            return;
        }
        mensagem = "Registro incluido com Sucesso!";
        new MostraMensagem(mensagem);
        txt_codigoGrupo.grabFocus();
    }
    
    private void AlterarEmpresa(){
        PegaValoresEmpresa();
        if(fatal.equals("S"))return;
        
        sql = "update ns_empresas set nomeEmpresa = '"           + be.nomeEmpresa            + "', " +
                                     "nomeFantasia = '"          + be.nomeFantasia           + "', " +
                                     "cnpjEmpresa = '"           + be.cnpjEmpresa            + "', " +
                                     "InscricaoEstadual = '"     + be.InscricaoEstadual      + "', " +
                                     "RegimeTributario = '"      + be.RegimeTributario       + "', " +
                                     "cepEmpresa = '"            + be.cepEmpresa             + "', " +
                                     "cidadeEmpresa = '"         + be.cidadeEmpresa          + "', " +
                                     "bairroEmpresa = '"         + be.bairroEmpresa          + "', " +
                                     "enderecoEmpresa = '"       + be.enderecoEmpresa        + "', " +
                                     "numeroEmpresa = '"         + be.numeroEmpresa          + "', " +
                                     "ufEmpresa = '"             + be.ufEmpresa              + "', " +
                                     "telefoneEmpresa = '"       + be.telefoneEmpresa        + "' " +
                                     "where codigoGrupo = "      + be.codigoGrupo            + " " +
                                     "and codigoEmpresa = "      + be.codigoEmpresa          + ";";
        
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equalsIgnoreCase("00000")){
            mensagem = "Erro ao alterar Empresa!";
            new MostraMensagem(mensagem);
            return;
        }
        AtualizarImagens();
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao alterar logotipo!";
            new MostraMensagem(mensagem);
            return;
        }
        mensagem = "Registro alterado com sucesso!";
        new MostraMensagem(mensagem);
        txt_codigoGrupo.grabFocus();
    }
    
    private void AtualizarImagens(){
        sql = "update ns_empresas set imagemLogotipoEmpresa = ? where codigoGrupo = " + be.codigoGrupo + " and codigoEmpresa = " + be.codigoEmpresa + ";";
        sqlstate = parametrosNS.dao.atualizarImagens(sql, be.getimagemLogotipoEmpresa());
    }
    
    private void Sair(){
        dispose();
        Bar     = new BarraInicial();
        ProIni  = new ProcessoInicial(Bar);
    }
    
}

