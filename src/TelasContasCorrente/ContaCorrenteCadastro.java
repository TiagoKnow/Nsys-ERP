package TelasContasCorrente;

import BeansNS.BeanBanco;
import Beans.BeanContaCorrente;
import Beans.BeanUsuarios;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import Telas.BancosConsulta;
import BeansNS.BeanEmpresas;
import FuncoesInternas.PegaProximoRegistro;
import TelasDeConfiguracoes.EmpresasConsulta;
import TelasDeConfiguracoes.daoSQLITE;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/*
 @author Tiago
 */
public class ContaCorrenteCadastro extends javax.swing.JFrame {
    //int's
    int     abriuEmpresa                = 0;
    int     abriuBanco                  = 0;
    int     abriuConta                  = 0;
    
    //String's
    String  sql                         = "";
    String  sqlstate                    = "";
    String  fatal                       = "";
    String  mensagem                    = "";
    String  somostra                    = "";
    String  retorno                     = "";
    String  operacao                    = "";
    String  DigitoVerificadorAgencia    = "";
    String  DigitoVerificador           = "";
    
    //boolean's
    boolean Habilita                    = false;
    
    //Vetores
    ArrayList            parametros                = new ArrayList();
//    ArrayList            dadosPadroes              = new ArrayList();
    ArrayList<ArrayList> dadosEmpresas             = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosBanco                = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosContaCorrente        = new ArrayList<ArrayList>();
    
    //Bean's
    BeanBanco               bb          = new BeanBanco();
    BeanUsuarios            bu          = new BeanUsuarios();
    BeanEmpresas            be          = new BeanEmpresas();
    BeanContaCorrente       bcc         = new BeanContaCorrente();
    
    //Especiais
    PegaProximoRegistro     PegProReg   = new PegaProximoRegistro();
    
    //Telas
    EmpresasConsulta        EmpCon;
    BancosConsulta          BanCon;
    ContaCorrenteConsulta   ConCorCon;
    
    public ContaCorrenteCadastro(String Somostra, int CodigoContaCorrente){
        somostra                    = Somostra;
        bcc.codigoContaCorrente     = CodigoContaCorrente;
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_deletar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_codigoContaCorrente = new javax.swing.JFormattedTextField();
        bt_novo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_codigoEmpresa = new javax.swing.JFormattedTextField();
        bt_pesquisarEmpresa = new javax.swing.JButton();
        label_nomeEmpresa = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_codigoBanco = new javax.swing.JFormattedTextField();
        bt_pesquisarBanco = new javax.swing.JButton();
        label_nomeBanco = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_numeroAgencia = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_numeroContaCorrente = new javax.swing.JFormattedTextField();
        txt_digitoVerificador = new javax.swing.JFormattedTextField();
        check_contaCorrentePadrao = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_AceiteOuNaoAceite = new javax.swing.JFormattedTextField();
        txt_especieDoDocumento = new javax.swing.JFormattedTextField();
        txt_numeroDaCarteira = new javax.swing.JTextField();
        txt_digitoVerificadorAgencia = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_descricao = new javax.swing.JTextField();
        bt_incluir = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_pesquisaContaCorrente = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair1 = new javax.swing.JMenuItem();

        bt_deletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Delete.png"))); // NOI18N
        bt_deletar.setText("Deletar");
        bt_deletar.setEnabled(false);
        bt_deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deletarActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de contas correntes");
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
        jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Código");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_codigoContaCorrente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoContaCorrente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoContaCorrente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoContaCorrenteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoContaCorrenteFocusLost(evt);
            }
        });
        txt_codigoContaCorrente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoContaCorrenteKeyPressed(evt);
            }
        });

        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_codigoContaCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_novo)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_codigoContaCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Empresa");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_codigoEmpresa.setEditable(false);
        try {
            txt_codigoEmpresa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoEmpresa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoEmpresa.setFocusable(false);
        txt_codigoEmpresa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoEmpresaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoEmpresaFocusLost(evt);
            }
        });

        bt_pesquisarEmpresa.setText("...");
        bt_pesquisarEmpresa.setEnabled(false);
        bt_pesquisarEmpresa.setFocusable(false);
        bt_pesquisarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisarEmpresaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_codigoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_pesquisarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_nomeEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nomeEmpresa))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisarEmpresa, label_nomeEmpresa, txt_codigoEmpresa});

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Código Conta");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Banco:");

        try {
            txt_codigoBanco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("*****")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoBanco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoBanco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoBancoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoBancoFocusLost(evt);
            }
        });

        bt_pesquisarBanco.setText("...");
        bt_pesquisarBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisarBancoActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Agência:");

        try {
            txt_numeroAgencia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_numeroAgencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_numeroAgencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_numeroAgenciaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_numeroAgenciaFocusLost(evt);
            }
        });

        jLabel6.setText("Conta (Código):");

        try {
            txt_numeroContaCorrente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("***********")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_numeroContaCorrente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_numeroContaCorrente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_numeroContaCorrenteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_numeroContaCorrenteFocusLost(evt);
            }
        });

        try {
            txt_digitoVerificador.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_digitoVerificador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_digitoVerificador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_digitoVerificadorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_digitoVerificadorFocusLost(evt);
            }
        });

        check_contaCorrentePadrao.setText("Conta corrente padrão para o banco selecionado");
        check_contaCorrentePadrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_contaCorrentePadraoActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("N° da carteira:");

        jLabel8.setText("Espécie do doc.:");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Aceite:");

        try {
            txt_AceiteOuNaoAceite.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("*")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_AceiteOuNaoAceite.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_AceiteOuNaoAceite.setText("N");

        try {
            txt_especieDoDocumento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("***")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_especieDoDocumento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_especieDoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_especieDoDocumentoActionPerformed(evt);
            }
        });

        txt_numeroDaCarteira.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_numeroDaCarteira.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_numeroDaCarteiraFocusGained(evt);
            }
        });
        txt_numeroDaCarteira.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_numeroDaCarteiraKeyReleased(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Descrição:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_AceiteOuNaoAceite)
                            .addComponent(txt_codigoBanco)
                            .addComponent(txt_numeroDaCarteira)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txt_numeroAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_digitoVerificadorAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(bt_pesquisarBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_nomeBanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_numeroContaCorrente, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                    .addComponent(txt_especieDoDocumento))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_digitoVerificador, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(check_contaCorrentePadrao, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))))
                    .addComponent(txt_descricao))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel4, jLabel5, jLabel7, jLabel9});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel6, jLabel8});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_codigoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nomeBanco)
                    .addComponent(bt_pesquisarBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_numeroAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_numeroContaCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_digitoVerificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_contaCorrentePadrao, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_digitoVerificadorAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txt_especieDoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_numeroDaCarteira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_AceiteOuNaoAceite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisarBanco, check_contaCorrentePadrao, jLabel10, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, label_nomeBanco, txt_codigoBanco, txt_digitoVerificador, txt_numeroAgencia, txt_numeroContaCorrente});

        bt_incluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_incluir.setText("Incluir");
        bt_incluir.setEnabled(false);
        bt_incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_incluirActionPerformed(evt);
            }
        });

        bt_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Save.png"))); // NOI18N
        bt_alterar.setText("Alterar");
        bt_alterar.setEnabled(false);
        bt_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterarActionPerformed(evt);
            }
        });

        bt_pesquisaContaCorrente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/View.png"))); // NOI18N
        bt_pesquisaContaCorrente.setText("Pesquisa");
        bt_pesquisaContaCorrente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaContaCorrenteActionPerformed(evt);
            }
        });

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_incluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_alterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_pesquisaContaCorrente)
                        .addGap(4, 4, 4)
                        .addComponent(bt_sair)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_alterar, bt_incluir});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_pesquisaContaCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_alterar, bt_incluir, bt_pesquisaContaCorrente, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoContaCorrenteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoContaCorrenteFocusGained
        if(txt_codigoContaCorrente.isEditable() == false){
            return;
        }
        if(somostra.equals("S")){
            return;
        }
        operacao = "";
        HabilitaBotoes();
        ReiniciaCampos();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoContaCorrenteFocusGained

    private void txt_codigoContaCorrenteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoContaCorrenteFocusLost
        if(txt_codigoContaCorrente.isEditable() == false){
            return;
        }
        if(txt_codigoContaCorrente.getText().replace(" ", "").equals("")){
            return;
        }
        bcc.codigoContaCorrente = Integer.parseInt(txt_codigoContaCorrente.getText().replace(" ", ""));
        if(bcc.codigoContaCorrente == 0){
            return;
        }
        sql = "select * from tb_contacorrente where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and codigoContaCorrente = " + bcc.codigoContaCorrente + ";";
        PegaContaCorrente();
    }//GEN-LAST:event_txt_codigoContaCorrenteFocusLost

    private void txt_codigoContaCorrenteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoContaCorrenteKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        txt_codigoEmpresa.grabFocus();
    }//GEN-LAST:event_txt_codigoContaCorrenteKeyPressed

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        ReiniciaCampos();
        HabilitaCampos(true);
        
        bcc.codigoContaCorrente = PegProReg.PegaProximoRegistro("tb_contacorrente", "codigoContaCorrente", "");
        txt_codigoContaCorrente.setText(parametrosNS.fc.FormataCampo(String.valueOf(bcc.codigoContaCorrente), 6, 0));
        
        operacao = "I";
        HabilitaBotoes();
        txt_codigoEmpresa.grabFocus();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void txt_codigoEmpresaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoEmpresaFocusLost
        if(txt_codigoEmpresa.isEditable() == false){
            return;
        }
        if(txt_codigoEmpresa.getText().replace(" ", "").equals("")){
            return;
        }
        be.codigoGrupo = parametrosNS.bge.CodigoGrupo;
        PegaEmpresa();
    }//GEN-LAST:event_txt_codigoEmpresaFocusLost

    private void txt_codigoBancoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoBancoFocusGained
        if(txt_codigoBanco.isEditable() == false){
            return;
        }
        if(somostra.equals("S")){
            return;
        }
        txt_codigoBanco.setSelectionStart(0);
        txt_codigoBanco.setSelectionEnd  (txt_codigoBanco.getText().length());
        label_nomeBanco.setText("");
    }//GEN-LAST:event_txt_codigoBancoFocusGained

    private void txt_codigoBancoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoBancoFocusLost
        if(txt_codigoBanco.isEditable() == false){
            return;
        }
        if(txt_codigoBanco.getText().replace(" ", "").equals("")){
            return;
        }
        PegaBanco();
    }//GEN-LAST:event_txt_codigoBancoFocusLost

    private void txt_codigoEmpresaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoEmpresaFocusGained
        if(txt_codigoEmpresa.isEditable() == false){
            return;
        }
        if(somostra.equals("S")){
            return;
        }
        txt_codigoEmpresa.setSelectionStart(0);
        txt_codigoEmpresa.setSelectionEnd  (txt_codigoEmpresa.getText().length());
        label_nomeEmpresa.setText("");
    }//GEN-LAST:event_txt_codigoEmpresaFocusGained

    private void txt_numeroAgenciaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_numeroAgenciaFocusGained
        txt_numeroAgencia.setSelectionStart(0);
        txt_numeroAgencia.setSelectionEnd  (txt_numeroAgencia.getText().length());
    }//GEN-LAST:event_txt_numeroAgenciaFocusGained

    private void txt_numeroAgenciaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_numeroAgenciaFocusLost
        txt_numeroAgencia.setText(parametrosNS.fc.FormataCampo(txt_numeroAgencia.getText(), 4, 0));
    }//GEN-LAST:event_txt_numeroAgenciaFocusLost

    private void txt_numeroContaCorrenteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_numeroContaCorrenteFocusGained
        txt_numeroContaCorrente.setSelectionStart(0);
        txt_numeroContaCorrente.setSelectionEnd  (txt_numeroContaCorrente.getText().length());
    }//GEN-LAST:event_txt_numeroContaCorrenteFocusGained

    private void txt_numeroContaCorrenteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_numeroContaCorrenteFocusLost
//        txt_numeroContaCorrente.setText(parametrosNS.fc.FormataCampo(txt_numeroContaCorrente.getText(), 5, 0));
    }//GEN-LAST:event_txt_numeroContaCorrenteFocusLost

    private void txt_digitoVerificadorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_digitoVerificadorFocusGained
        txt_digitoVerificador.setSelectionStart(0);
        txt_digitoVerificador.setSelectionEnd  (txt_digitoVerificador.getText().length());
    }//GEN-LAST:event_txt_digitoVerificadorFocusGained

    private void txt_digitoVerificadorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_digitoVerificadorFocusLost
        
    }//GEN-LAST:event_txt_digitoVerificadorFocusLost

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
        if(abriuConta == 0){
            AbreEmpresa();
            return;
        }
        abriuConta = 0;
        retorno = ConCorCon.getRetornoContaCorrente();
        if(retorno.equals("")){
            return;
        }
        bcc.codigoContaCorrente = Integer.parseInt(retorno);
        sql = "select * from tb_contacorrente where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoContaCorrente = " + bcc.codigoContaCorrente + ";";
        PegaContaCorrente();
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbreEmpresa(){
        if(abriuEmpresa == 0){
            AbreBanco();
            return;
        }
        abriuEmpresa = 0;
        retorno = EmpCon.getRetorno();
        if(retorno.equals("")){
            return;
        }
        txt_codigoEmpresa.setText(retorno);
        PegaEmpresa();
    }
    
    private void AbreBanco(){
        if(abriuBanco == 0){
            return;
        }
        abriuBanco = 0;
        retorno = BanCon.getRetorno();
        if(retorno.equals("")){
            return;
        }
        txt_codigoBanco.setText(retorno);
        PegaBanco();
    }
    
    private void bt_pesquisarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisarEmpresaActionPerformed
        if(EmpCon != null)if(EmpCon.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        abriuEmpresa = 1;
        EmpCon = new EmpresasConsulta(parametrosNS.bge.CodigoGrupo);
        EmpCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisarEmpresaActionPerformed

    private void bt_pesquisarBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisarBancoActionPerformed
        abriuBanco = 1;
        BanCon = new BancosConsulta();
        BanCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisarBancoActionPerformed

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S")){return;}
        AtualizaContaCorrentePadrao();
        if(fatal.equals("S")){return;}
        
        sql = "insert into tb_contacorrente (idEmpresa, codigoGrupo, codigoEmpresa, codigoContaCorrente, idBanco, numeroAgencia, digitoVerificadorAgencia, numeroContaCorrente, digitoVerificador, contaCorrentePadrao, numeroDaCarteira, especieDoDocumento, AceiteOuNaoAceite, descricao) "
            + "values (" + bcc.idEmpresa + ", " + bcc.codigoGrupo + ", " + bcc.codigoEmpresa + ", " + bcc.codigoContaCorrente + ", '" + bcc.idBanco + "', " + bcc.numeroAgencia + ", " + bcc.digitoVerificadorAgencia + ", " + bcc.numeroContaCorrente + ", " + DigitoVerificador + ", " + bcc.contaCorrentePadrao + ", " + bcc.numeroDaCarteira + ", " + bcc.especieDoDocumento + ", " + bcc.AceiteOuNaoAceite + ", '" + bcc.descricao + "');";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            return;
        }
        txt_codigoContaCorrente.grabFocus();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S")){return;}
        AtualizaContaCorrentePadrao();
        if(fatal.equals("S")){return;}
        
        sql = "update tb_contacorrente set idBanco = '"                     + bcc.idBanco                  + "', "
                                        + "numeroAgencia = "                + bcc.numeroAgencia            + ", "
                                        + "digitoVerificadorAgencia = "     + bcc.digitoVerificadorAgencia + ", "
                                        + "numeroContaCorrente = "          + bcc.numeroContaCorrente      + ", "
                                        + "digitoVerificador = "            + DigitoVerificador            + ", "
                                        + "contaCorrentePadrao = "          + bcc.contaCorrentePadrao      + ", "
                                        + "numeroDaCarteira = "             + bcc.numeroDaCarteira         + ", "
                                        + "especieDoDocumento = "           + bcc.especieDoDocumento       + ", "
                                        + "AceiteOuNaoAceite = "            + bcc.AceiteOuNaoAceite        + ", "
                                        + "descricao = '"                   + bcc.descricao                + "' "
                                        + "where idContaCorrente = "    + bcc.idContaCorrente       + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000")){
            return;
        }
        txt_codigoContaCorrente.grabFocus();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void bt_pesquisaContaCorrenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaContaCorrenteActionPerformed
        if(ConCorCon   != null)if(ConCorCon.isVisible()){
            mensagem = "Tela ja Aberta!";
            mostraMensagem();
            return;
        }
        abriuConta = 1;
        ConCorCon = new ContaCorrenteConsulta("S");
        ConCorCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaContaCorrenteActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void check_contaCorrentePadraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_contaCorrentePadraoActionPerformed
        if(check_contaCorrentePadrao.isSelected() == true){
            if(JOptionPane.showConfirmDialog(null, "Deseja mesmo Alterar a conta Padão para o Banco: " + bb.nomeBanco + "?", "", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION){
                check_contaCorrentePadrao.setSelected(false);
            }
        }
    }//GEN-LAST:event_check_contaCorrentePadraoActionPerformed

    private void txt_numeroDaCarteiraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_numeroDaCarteiraFocusGained
        txt_numeroDaCarteira.setSelectionStart(0);
        txt_numeroDaCarteira.setSelectionEnd  (txt_numeroDaCarteira.getText().length());
    }//GEN-LAST:event_txt_numeroDaCarteiraFocusGained

    private void txt_numeroDaCarteiraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_numeroDaCarteiraKeyReleased
        if(txt_numeroDaCarteira.getText().length() > 10){
            txt_numeroDaCarteira.setText(txt_numeroDaCarteira.getText().substring(0, 10));
        }
    }//GEN-LAST:event_txt_numeroDaCarteiraKeyReleased

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HabilitaCampos(false);
        if(somostra.equals("S")){
            txt_codigoContaCorrente     .setEditable(false);
            bt_novo                     .setEnabled (false);
            txt_codigoEmpresa           .setEditable(false);
            bt_pesquisarEmpresa         .setEnabled (false);
            txt_codigoBanco             .setEditable(false);
            bt_pesquisarBanco           .setEnabled (false);
            check_contaCorrentePadrao   .setEnabled (false);
            bt_incluir                  .setVisible (false);
            bt_alterar                  .setVisible (false);
            bt_deletar                  .setVisible (false);
            bt_pesquisaContaCorrente    .setVisible (false);
        }
        if(bcc.codigoContaCorrente != 0){
            txt_codigoContaCorrente .setEditable (false);
            txt_codigoContaCorrente .setFocusable(false);
            sql = "select * from tb_contacorrente where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and codigoContaCorrente = " + bcc.codigoContaCorrente + ";";
            PegaContaCorrente();
            return;
        }
        txt_codigoEmpresa.setText(String.valueOf(parametrosNS.be.CodigoEmpresa));
        PegaEmpresa();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(EmpCon      != null){EmpCon   .dispose();}
        if(BanCon      != null){BanCon   .dispose();}
        if(ConCorCon   != null){ConCorCon.dispose();}
    }//GEN-LAST:event_formWindowClosed

    private void bt_deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deletarActionPerformed
        
    }//GEN-LAST:event_bt_deletarActionPerformed

    private void txt_especieDoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_especieDoDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_especieDoDocumentoActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_deletar;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisaContaCorrente;
    private javax.swing.JButton bt_pesquisarBanco;
    private javax.swing.JButton bt_pesquisarEmpresa;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JCheckBox check_contaCorrentePadrao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel label_nomeBanco;
    private javax.swing.JLabel label_nomeEmpresa;
    private javax.swing.JFormattedTextField txt_AceiteOuNaoAceite;
    private javax.swing.JFormattedTextField txt_codigoBanco;
    private javax.swing.JFormattedTextField txt_codigoContaCorrente;
    private javax.swing.JFormattedTextField txt_codigoEmpresa;
    private javax.swing.JTextField txt_descricao;
    private javax.swing.JFormattedTextField txt_digitoVerificador;
    private javax.swing.JFormattedTextField txt_digitoVerificadorAgencia;
    private javax.swing.JFormattedTextField txt_especieDoDocumento;
    private javax.swing.JFormattedTextField txt_numeroAgencia;
    private javax.swing.JFormattedTextField txt_numeroContaCorrente;
    private javax.swing.JTextField txt_numeroDaCarteira;
    // End of variables declaration//GEN-END:variables
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_incluir  .setEnabled(true);
            bt_alterar  .setEnabled(false);
            bt_deletar  .setEnabled(false);
            return;
        }
        if(operacao.equals("A")){
            bt_incluir  .setEnabled(false);
            bt_alterar  .setEnabled(true);
            bt_deletar  .setEnabled(true);
            return;
        }
        bt_incluir      .setEnabled(false);
        bt_alterar      .setEnabled(false);
        bt_deletar      .setEnabled(false);
    }
    
    private void ReiniciaCampos(){
        txt_codigoContaCorrente  .setText("");
//        txt_codigoEmpresa        .setText("");
//        label_nomeEmpresa        .setText("");
        txt_descricao            .setText("");
        txt_codigoBanco          .setText("");
        label_nomeBanco          .setText("");
        txt_numeroAgencia        .setText("");
        txt_numeroContaCorrente  .setText("");
        txt_digitoVerificador    .setText("");
        check_contaCorrentePadrao.setSelected(false);
        txt_numeroDaCarteira     .setText("");
        txt_especieDoDocumento   .setText("");
//        txt_AceiteOuNaoAceite     .setText("");
    }
    
    private void HabilitaCampos(boolean Habilita){
//        txt_codigoEmpresa           .setEditable (Habilita);
//        txt_codigoEmpresa           .setFocusable(Habilita);
//        bt_pesquisarEmpresa         .setEnabled  (Habilita);
//        bt_pesquisarEmpresa         .setFocusable(Habilita);
        txt_descricao               .setEditable (Habilita);
        txt_descricao               .setFocusable(Habilita);
        txt_codigoBanco             .setEditable (Habilita);
        txt_codigoBanco             .setFocusable(Habilita);
        bt_pesquisarBanco           .setEnabled  (Habilita);
        bt_pesquisarBanco           .setFocusable(Habilita);
        txt_numeroAgencia           .setEditable (Habilita);
        txt_numeroAgencia           .setFocusable(Habilita);
        txt_digitoVerificadorAgencia.setEditable (Habilita);
        txt_digitoVerificadorAgencia.setFocusable(Habilita);
        txt_numeroContaCorrente     .setEditable (Habilita);
        txt_numeroContaCorrente     .setFocusable(Habilita);
        txt_digitoVerificador       .setEditable (Habilita);
        txt_digitoVerificador       .setFocusable(Habilita);
        check_contaCorrentePadrao   .setEnabled  (Habilita);
        check_contaCorrentePadrao   .setFocusable(Habilita);
        txt_numeroDaCarteira        .setEditable (Habilita);
        txt_numeroDaCarteira        .setFocusable(Habilita);
        txt_especieDoDocumento      .setEditable (Habilita);
        txt_especieDoDocumento      .setFocusable(Habilita);
        txt_AceiteOuNaoAceite       .setEditable (Habilita);
        txt_AceiteOuNaoAceite       .setFocusable(Habilita);
    }
    
    private void PegaContaCorrente(){
        dadosContaCorrente.clear();
        dadosContaCorrente = parametrosNS.dao.Consulta(sql);
        if(dadosContaCorrente.isEmpty()){
            mensagem = "Conta corrente não encontrada!";
            mostraMensagem();
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        HabilitaCampos(true);
        PegaDadosContaCorrente();
    }
    
    private void PegaDadosContaCorrente(){
        for(int i = 0; i < dadosContaCorrente.size(); i++){
            bcc = new BeanContaCorrente();
            if(dadosContaCorrente.get(i).get(0) != null){
                bcc.idContaCorrente             = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(0)));
            }
            if(dadosContaCorrente.get(i).get(1) != null){
                bcc.idEmpresa                   = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(1)));
            }
            if(dadosContaCorrente.get(i).get(2) != null){
                bcc.codigoGrupo                 = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(2)));
            }
            if(dadosContaCorrente.get(i).get(3) != null){
                bcc.codigoEmpresa               = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(3)));
            }
            if(dadosContaCorrente.get(i).get(4) != null){
                bcc.codigoContaCorrente         = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(4)));
            }
            if(dadosContaCorrente.get(i).get(5) != null){
                bcc.idBanco                     = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(5)));
            }
            if(dadosContaCorrente.get(i).get(6) != null){
                bcc.numeroAgencia               = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(6)));
            }
            if(dadosContaCorrente.get(i).get(7) != null){
                bcc.digitoVerificadorAgencia    = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(7)));
            }
            if(dadosContaCorrente.get(i).get(8) != null){
                bcc.numeroContaCorrente         = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(8)));
            }
            if(dadosContaCorrente.get(i).get(9) != null){
                bcc.digitoVerificador           = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(9)));
            }
            if(dadosContaCorrente.get(i).get(10) != null){
                bcc.contaCorrentePadrao         = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(10)));
            }
            if(dadosContaCorrente.get(i).get(11) != null){
                bcc.numeroDaCarteira            =                    String.valueOf(dadosContaCorrente.get(i).get(11));
            }
            if(dadosContaCorrente.get(i).get(12) != null){
                bcc.especieDoDocumento          =                    String.valueOf(dadosContaCorrente.get(i).get(12));
            }
            if(dadosContaCorrente.get(i).get(13) != null){
                bcc.AceiteOuNaoAceite           =                    String.valueOf(dadosContaCorrente.get(i).get(13));
            }
            if(dadosContaCorrente.get(i).get(14) != null){
                bcc.descricao                   =                    String.valueOf(dadosContaCorrente.get(i).get(14));
            }
        }
        
        txt_codigoContaCorrente.setText(parametrosNS.fc.FormataCampo(String.valueOf(bcc.codigoContaCorrente), 6, 0));
        
        be.codigoGrupo  = bcc.codigoGrupo;
        txt_codigoEmpresa.setText(String.valueOf(bcc.codigoEmpresa));
        PegaEmpresa();
        
        bb.idBanco      = bcc.idBanco;
        sql = "select * from ns_bancos where id = " + bb.idBanco + ";";
        PegaBanco();
        
        txt_descricao.setText(bcc.descricao);
        txt_codigoBanco.setText(String.valueOf(bb.codigoBanco));
        if(bb.codigoBanco.equals("341")){//Itaú
            txt_numeroAgencia           .setText(parametrosNS.fc.FormataCampo(String.valueOf(bcc.numeroAgencia), 4, 0));
            txt_numeroContaCorrente     .setText(parametrosNS.fc.FormataCampo(String.valueOf(bcc.numeroContaCorrente), 5, 0));
            txt_digitoVerificador       .setText(String.valueOf(bcc.digitoVerificador));
        }
        if(bb.codigoBanco.equals("399")){//HSBC
            txt_numeroAgencia           .setText(parametrosNS.fc.FormataCampo(String.valueOf(bcc.numeroAgencia), 4, 0));
            txt_numeroContaCorrente     .setText(parametrosNS.fc.FormataCampo(String.valueOf(bcc.numeroContaCorrente), 7, 0));
        }
        if(bb.codigoBanco.equals("033")){//Santander
            txt_numeroAgencia           .setText(parametrosNS.fc.FormataCampo(String.valueOf(bcc.numeroAgencia), 4, 0));
            txt_digitoVerificadorAgencia.setText(String.valueOf(bcc.digitoVerificadorAgencia));
            txt_numeroContaCorrente     .setText(parametrosNS.fc.FormataCampo(String.valueOf(bcc.numeroContaCorrente), 7, 0));
        }
        if(bb.codigoBanco.equals("237")){//Bradesco
            txt_numeroAgencia           .setText(parametrosNS.fc.FormataCampo(String.valueOf(bcc.numeroAgencia), 4, 0));
            txt_digitoVerificadorAgencia.setText(String.valueOf(bcc.digitoVerificadorAgencia));
            txt_numeroContaCorrente     .setText(parametrosNS.fc.FormataCampo(String.valueOf(bcc.numeroContaCorrente), 7, 0));
            txt_digitoVerificador       .setText(String.valueOf(bcc.digitoVerificador));
        }
        switch(bcc.contaCorrentePadrao){
            case 0: check_contaCorrentePadrao.setSelected(false);break;
            case 1: check_contaCorrentePadrao.setSelected(true); break;
        }
        if(bcc.numeroDaCarteira == null){
            bcc.numeroDaCarteira    = "";
        }
        txt_numeroDaCarteira    .setText(parametrosNS.fc.FormataCampo(bcc.numeroDaCarteira, 3, 0));
        txt_especieDoDocumento  .setText(bcc.especieDoDocumento);
        txt_AceiteOuNaoAceite   .setText(bcc.AceiteOuNaoAceite);
    }
    
    private void PegaEmpresa(){
        txt_codigoEmpresa.setText(parametrosNS.fc.FormataCampo(txt_codigoEmpresa.getText(), 3, 0));
        be.codigoEmpresa = Integer.parseInt(txt_codigoEmpresa.getText());
        if(be.codigoEmpresa == 0){
            return;
        }
        sql = "select \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   nomeEmpresa, \n"
            + "   nomeFantasia, \n"
            + "   cnpjEmpresa \n"
            + "from ns_empresas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + be.codigoEmpresa + ";";
//        sql = "select * from ns_empresas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + ";";
        dadosEmpresas.clear();
        dadosEmpresas = parametrosNS.dao.Consulta(sql);
        if(dadosEmpresas.isEmpty()){
            bt_incluir.setEnabled(false);
            bt_alterar.setEnabled(false);
            mensagem = "Empresa " + be.codigoEmpresa + " não encontrada!";
            mostraMensagem();
            return;
        }
        HabilitaBotoes();
        PegaDadosEmpresa();
    }
    
    private void PegaDadosEmpresa(){
        be.NomeEmpresa  = "----------------------------------------";
        for(int i = 0; i < dadosEmpresas.size(); i++){
            if(dadosEmpresas.get(i).get(0) != null){
                be.idEmpresa        = Integer.parseInt(  String.valueOf(dadosEmpresas.get(i).get(0)));
            }
            if(dadosEmpresas.get(i).get(1) != null){
                be.CodigoGrupo      = Integer.parseInt(  String.valueOf(dadosEmpresas.get(i).get(1)));
            }
            if(dadosEmpresas.get(i).get(2) != null){
                be.CodigoEmpresa    = Integer.parseInt(  String.valueOf(dadosEmpresas.get(i).get(2)));
            }
            if(dadosEmpresas.get(i).get(3) != null){
                be.NomeEmpresa      =                    String.valueOf(dadosEmpresas.get(i).get(3));
            }
            if(dadosEmpresas.get(i).get(4) != null){
                be.NomeFantasia     =                    String.valueOf(dadosEmpresas.get(i).get(4));
            }
            if(dadosEmpresas.get(i).get(5) != null){
                be.CnpjEmpresa      =                    String.valueOf(dadosEmpresas.get(i).get(5));
            }
        }
        label_nomeEmpresa.setText(be.NomeEmpresa);
    }
    
    private void PegaBanco(){
        bb.codigoBanco = txt_codigoBanco.getText().replace(" ", "");
        if(bb.idBanco == 0){
            sql = "select * from ns_bancos where codigoBanco = '" + bb.codigoBanco + "';";
        }
        dadosBanco.clear();
        dadosBanco = parametrosNS.dao.Consulta(sql);
        if(dadosBanco.isEmpty()){
            bt_incluir.setEnabled(false);
            bt_alterar.setEnabled(false);
            mensagem = "Banco n°" + bb.codigoBanco + " não encontrado!";
            mostraMensagem();
            return;
        }
        HabilitaBotoes();
        PegaDadosBanco();
    }
    
    private void PegaDadosBanco(){
        Habilita = true;
        for(int i = 0; i < dadosBanco.size(); i++){
            bb.idBanco          = Integer.parseInt(  String.valueOf(dadosBanco.get(i).get(0)));
            bb.nomeBanco        =                    String.valueOf(dadosBanco.get(i).get(1));
            bb.codigoBanco      =                    String.valueOf(dadosBanco.get(i).get(2));
        }
        label_nomeBanco.setText(bb.nomeBanco);
        if(bb.codigoBanco.replace(" ", "").equals("999")){
            Habilita = false;
        }
        txt_numeroAgencia.setEnabled                (Habilita);
        txt_numeroAgencia.setEditable               (Habilita);
        txt_numeroAgencia.setFocusable              (Habilita);
        txt_digitoVerificadorAgencia.setEnabled     (Habilita);
        txt_digitoVerificadorAgencia.setEditable    (Habilita);
        txt_digitoVerificadorAgencia.setFocusable   (Habilita);
        txt_numeroContaCorrente.setEnabled          (Habilita);
        txt_numeroContaCorrente.setEditable         (Habilita);
        txt_numeroContaCorrente.setFocusable        (Habilita);
        txt_digitoVerificador.setEnabled            (Habilita);
        txt_digitoVerificador.setEditable           (Habilita);
        txt_digitoVerificador.setFocusable          (Habilita);
        txt_numeroDaCarteira.setEnabled             (Habilita);
        txt_numeroDaCarteira.setEditable            (Habilita);
        txt_numeroDaCarteira.setFocusable           (Habilita);
        txt_especieDoDocumento.setEnabled           (Habilita);
        txt_especieDoDocumento.setEditable          (Habilita);
        txt_especieDoDocumento.setFocusable         (Habilita);
        txt_AceiteOuNaoAceite.setEnabled            (Habilita);
        txt_AceiteOuNaoAceite.setEditable           (Habilita);
        txt_AceiteOuNaoAceite.setFocusable          (Habilita);
        if(!bb.codigoBanco.replace(" ", "").equals("999")){
            return;
        }
        txt_numeroAgencia.setText                   (parametrosNS.fc.FormataCampo("", 4, 0));
//        txt_digitoVerificadorAgencia.setText        (parametrosNS.fc.FormataCampo("", 1, 0));
        txt_numeroContaCorrente.setText             (parametrosNS.fc.FormataCampo("", 6, 0));
        txt_digitoVerificador.setText               (parametrosNS.fc.FormataCampo("", 2, 0));
        txt_especieDoDocumento.setText              ("");
        txt_numeroDaCarteira.setText                (parametrosNS.fc.FormataCampo("", 3, 0));
        txt_AceiteOuNaoAceite.setText               ("");
    }
    
    private void PegaValores(){
        fatal = "N";
        bcc.idEmpresa   = parametrosNS.be.IdEmpresa;
        bcc.codigoGrupo = parametrosNS.bge.CodigoGrupo;
        if(txt_codigoEmpresa.getText().replace(" ", "").equals("")){
            mensagem = "Código da Empresa Inválida!";
            mostraMensagem();
            fatal = "S";
            return;
        }
        bcc.codigoEmpresa       = Integer.parseInt(txt_codigoEmpresa.getText());
        bcc.codigoContaCorrente = Integer.parseInt(txt_codigoContaCorrente.getText());
        bcc.descricao           = txt_descricao.getText();
        if(bcc.descricao.equals("")){
            mensagem = "Descrição inválida!";
            mostraMensagem();
            fatal = "S";
            return;
        }
        bcc.idBanco             = bb.idBanco;
        if(bcc.idBanco == 0){
            mensagem = "Código do Banco Inválido!";
            mostraMensagem();
            fatal = "S";
            return;
        }
        if(!bb.codigoBanco.replace(" ", "").equals("999")){
            if(txt_numeroAgencia.getText().replace(" ", "").equals("")){
                mensagem = "Número da Agência Inválido!";
                mostraMensagem();
                fatal = "S";
                return;
            }
        }
        bcc.numeroAgencia               = Integer.parseInt(txt_numeroAgencia.getText().replace(" ", ""));
        if(!bb.codigoBanco.replace(" ", "").equals("999")){
            if(txt_numeroContaCorrente.getText().replace(" ", "").equals("")){
                mensagem = "Número da Conta Corrente Inválido!";
                mostraMensagem();
                fatal = "S";
                return;
            }
        }
        DigitoVerificadorAgencia        = txt_digitoVerificadorAgencia.getText().replace(" ", "");
        if(DigitoVerificadorAgencia.equals("")){
            DigitoVerificadorAgencia    = null;
        }
        if(txt_numeroContaCorrente.getText().replace(" ", "").equals("")){
            mensagem = "Conta corrente inválida!";
            mostraMensagem();
            fatal = "S";
            return;
        }
        if(bb.codigoBanco.equals("237")){//Conta Corrente Bradesco
            bcc.numeroContaCorrente = Integer.parseInt(parametrosNS.fc.FormataCampo(txt_numeroContaCorrente.getText().replace(" ", ""), 7, 0));
        }
        if(bb.codigoBanco.equals("399")){//Conta Corrente HSBC
            bcc.numeroContaCorrente = Integer.parseInt(parametrosNS.fc.FormataCampo(txt_numeroContaCorrente.getText().replace(" ", ""), 7, 0));
        }
        if(bb.codigoBanco.equals("341")){//Conta Corrente Itaú
            bcc.numeroContaCorrente = Integer.parseInt(parametrosNS.fc.FormataCampo(txt_numeroContaCorrente.getText().replace(" ", ""), 5, 0));
        }
        if(bb.codigoBanco.equals("033")){//Conta Corrente Santander
            bcc.numeroContaCorrente = Integer.parseInt(parametrosNS.fc.FormataCampo(txt_numeroContaCorrente.getText().replace(" ", ""), 7, 0));
        }
        if(bb.codigoBanco.equals("237")){//Dígito Verificador Bradesco
            bcc.digitoVerificador = Integer.parseInt(parametrosNS.fc.FormataCampo(txt_digitoVerificador.getText().replace(" ", ""), 1, 0));
        }
        if(bb.codigoBanco.equals("341")){//Dígito Verificador Itaú
            bcc.digitoVerificador = Integer.parseInt(parametrosNS.fc.FormataCampo(txt_digitoVerificador.getText().replace(" ", ""), 1, 0));
        }
        DigitoVerificador = String.valueOf(bcc.digitoVerificador);
        if(txt_digitoVerificador.getText().replace(" ", "").equals("")){
            DigitoVerificador = null;
        }
        if(!bb.codigoBanco.replace(" ", "").equals("999")){ 
            DigitoVerificador = null;
        }
        bcc.contaCorrentePadrao     = 0;
        if(!bb.codigoBanco.replace(" ", "").equals("999")){
            if(check_contaCorrentePadrao.isSelected() == false){
                bcc.contaCorrentePadrao     = 1;
            }
        }
        bcc.numeroDaCarteira            = txt_numeroDaCarteira.getText().replace(" ", "");
        if(!bcc.numeroDaCarteira.equals("")){
            bcc.numeroDaCarteira = "'" + bcc.numeroDaCarteira + "'";
        }else{
            bcc.numeroDaCarteira = null;
        }
        bcc.especieDoDocumento          = txt_especieDoDocumento.getText().replace(" ", "");
        if(bcc.especieDoDocumento.equals("")){
            bcc.especieDoDocumento = null;
        }else{
            bcc.especieDoDocumento = "'" + bcc.especieDoDocumento + "'";
        }
        bcc.AceiteOuNaoAceite           = txt_AceiteOuNaoAceite.getText().replace(" ", "");
        if(bcc.AceiteOuNaoAceite.equals("")){
            bcc.AceiteOuNaoAceite = null;
        }else{
            bcc.AceiteOuNaoAceite = "'" + bcc.AceiteOuNaoAceite + "'";
        }
    }
    
    private void AtualizaContaCorrentePadrao(){
        if(check_contaCorrentePadrao.isSelected() == true){
            sql = "update tb_contacorrente set contaCorrentePadrao = 0 where idBanco = " + bcc.idBanco + " and contaCorrentePadrao = 1;";
            sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
            if(!sqlstate.equals("00000")){
                fatal = "S";
            }
        }
    }
    
}
