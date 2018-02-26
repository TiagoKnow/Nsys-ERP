package TelasContabil;

import Beans.BeanPlanoDeContas;
import Beans.BeanPlanoDeContasMovimentos;
import Beans.BeanPlanoReferencial;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.FormataCampoADireita;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.TransformaValorStringeDouble;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
/*
 @author Paulo 
*/
public class PlanoDeContasCadastro extends javax.swing.JFrame {
    //String's
    String sql                              = "";
    String sqlstate                         = "";
    String fatal                            = "";
    String Mensagem                         = "";
    String somostra                         = "";
    String operacao                         = "";
    String retorno                          = "";
    
    //int's
    int    User                             = 0;
    int    abriuPesquisaPlanoDeContas       = 0;
    int    abriuPesquisaPlanoReferencial    = 0;
    
    //Vetores
    ArrayList            parametros                    = new ArrayList();
    ArrayList            dadosPadroes                  = new ArrayList();
    ArrayList<ArrayList> dadosPlanoDeContas            = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosPlanoReferencial         = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosCount                    = new ArrayList<ArrayList>();
    
    //Bean's
    BeanPlanoDeContas               bpla    = new BeanPlanoDeContas();
    BeanPlanoReferencial            bpref   = new BeanPlanoReferencial();
    BeanPlanoDeContasMovimentos     bplamov = new BeanPlanoDeContasMovimentos();
    
    //Especiais
    FormataCampo                    fc          = new FormataCampo();
    FormataCampoADireita            fcad        = new FormataCampoADireita();
    CapturarDataHora                cdh         = new CapturarDataHora();
    TransformaValorStringeDouble    TransStrDou = new TransformaValorStringeDouble();
    InverterData                    invdata     = new InverterData();
    
    //Telas
    PlanoDeContasConsulta           PlaDeConCon;
    PlanoReferencialConsulta        PlaRefCon;
    
    public PlanoDeContasCadastro(ArrayList DadosPadroes){
        dadosPadroes                        = DadosPadroes;
        
        somostra                            = (String)  dadosPadroes.get(0);
        bpla.codigoPlanoDeContas            = (String)  dadosPadroes.get(1);
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigoPlanoDeContas1 = new javax.swing.JFormattedTextField();
        txt_codigoPlanoDeContas2 = new javax.swing.JFormattedTextField();
        txt_codigoPlanoDeContas3 = new javax.swing.JFormattedTextField();
        txt_codigoPlanoDeContas4 = new javax.swing.JFormattedTextField();
        txt_codigoPlanoDeContas5 = new javax.swing.JFormattedTextField();
        txt_codigoPlanoDeContas6 = new javax.swing.JFormattedTextField();
        bt_novo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_tipoPlanoDeContas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_codigoPlanoDeContasSuperior = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_nivelPlanoDeContas = new javax.swing.JTextField();
        txt_descricaoPlanoDeContas = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_saldoDeAbertura = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txt_codigoPlanoReferencial = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descricaoPlanoReferencial = new javax.swing.JTextArea();
        bt_pesquisaPlanoReferencial = new javax.swing.JButton();
        bt_incluir = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        bt_pesquisa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Plano de Contas");
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
        jLabel1.setText("Plano de Contas");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Plano de Contas:");

        try {
            txt_codigoPlanoDeContas1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoPlanoDeContas1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoPlanoDeContas1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoDeContas1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoDeContas1FocusLost(evt);
            }
        });
        txt_codigoPlanoDeContas1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoPlanoDeContas1KeyReleased(evt);
            }
        });

        txt_codigoPlanoDeContas2.setEditable(false);
        try {
            txt_codigoPlanoDeContas2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoPlanoDeContas2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoPlanoDeContas2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoDeContas2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoDeContas2FocusLost(evt);
            }
        });
        txt_codigoPlanoDeContas2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoPlanoDeContas2KeyReleased(evt);
            }
        });

        txt_codigoPlanoDeContas3.setEditable(false);
        try {
            txt_codigoPlanoDeContas3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoPlanoDeContas3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoPlanoDeContas3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoDeContas3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoDeContas3FocusLost(evt);
            }
        });
        txt_codigoPlanoDeContas3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoPlanoDeContas3KeyReleased(evt);
            }
        });

        txt_codigoPlanoDeContas4.setEditable(false);
        try {
            txt_codigoPlanoDeContas4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoPlanoDeContas4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoPlanoDeContas4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoDeContas4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoDeContas4FocusLost(evt);
            }
        });
        txt_codigoPlanoDeContas4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoPlanoDeContas4KeyReleased(evt);
            }
        });

        txt_codigoPlanoDeContas5.setEditable(false);
        try {
            txt_codigoPlanoDeContas5.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoPlanoDeContas5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoPlanoDeContas5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoDeContas5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoDeContas5FocusLost(evt);
            }
        });
        txt_codigoPlanoDeContas5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoPlanoDeContas5KeyReleased(evt);
            }
        });

        txt_codigoPlanoDeContas6.setEditable(false);
        try {
            txt_codigoPlanoDeContas6.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoPlanoDeContas6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoPlanoDeContas6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoDeContas6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoDeContas6FocusLost(evt);
            }
        });
        txt_codigoPlanoDeContas6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoPlanoDeContas6KeyReleased(evt);
            }
        });

        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Descrição:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Tipo:");

        txt_tipoPlanoDeContas.setEditable(false);
        txt_tipoPlanoDeContas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_tipoPlanoDeContas.setToolTipText("(A) - Analítica   (S) - Sintética");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Conta Superior:");

        txt_codigoPlanoDeContasSuperior.setEditable(false);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Nível:");

        txt_nivelPlanoDeContas.setEditable(false);
        txt_nivelPlanoDeContas.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setText("Saldo de Abertura:");

        txt_saldoDeAbertura.setEditable(false);
        txt_saldoDeAbertura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_saldoDeAberturaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_saldoDeAberturaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoPlanoDeContas1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_codigoPlanoDeContas2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_codigoPlanoDeContas3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_codigoPlanoDeContas4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_codigoPlanoDeContas5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_codigoPlanoDeContas6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_novo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_descricaoPlanoDeContas)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_codigoPlanoDeContasSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_saldoDeAbertura)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tipoPlanoDeContas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nivelPlanoDeContas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(357, 357, 357))))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_codigoPlanoDeContas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_codigoPlanoDeContas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_codigoPlanoDeContas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_codigoPlanoDeContas4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_codigoPlanoDeContas5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_codigoPlanoDeContas6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_descricaoPlanoDeContas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tipoPlanoDeContas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nivelPlanoDeContas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_codigoPlanoDeContasSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(txt_saldoDeAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel5, jLabel8, txt_codigoPlanoDeContasSuperior});

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Plano Referencial:");

        txt_codigoPlanoReferencial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoReferencialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoReferencialFocusLost(evt);
            }
        });
        txt_codigoPlanoReferencial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoPlanoReferencialKeyPressed(evt);
            }
        });

        txt_descricaoPlanoReferencial.setColumns(20);
        txt_descricaoPlanoReferencial.setLineWrap(true);
        txt_descricaoPlanoReferencial.setRows(5);
        jScrollPane1.setViewportView(txt_descricaoPlanoReferencial);

        bt_pesquisaPlanoReferencial.setText("...");
        bt_pesquisaPlanoReferencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaPlanoReferencialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_codigoPlanoReferencial, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisaPlanoReferencial, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_codigoPlanoReferencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaPlanoReferencial, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaPlanoReferencial, jLabel7, txt_codigoPlanoReferencial});

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

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        bt_pesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/View.png"))); // NOI18N
        bt_pesquisa.setText("Pesquisa");
        bt_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_alterar, bt_incluir, bt_pesquisa, bt_sair});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_alterar, bt_incluir, bt_pesquisa, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoPlanoDeContas1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContas1FocusGained
        if(txt_codigoPlanoDeContas1.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        bpla = new BeanPlanoDeContas();
        operacao = "";
        HabilitaBotoes();
        txt_codigoPlanoDeContas2    .setText("0");
        txt_codigoPlanoDeContas2    .setEditable(false);
        txt_codigoPlanoDeContas3    .setText("0");
        txt_codigoPlanoDeContas3    .setEditable(false);
        txt_codigoPlanoDeContas4    .setText("00");
        txt_codigoPlanoDeContas4    .setEditable(false);
        txt_codigoPlanoDeContas5    .setText("00");
        txt_codigoPlanoDeContas5    .setEditable(false);
        txt_codigoPlanoDeContas6    .setText("0000");
        txt_codigoPlanoDeContas6    .setEditable(false);
        ReiniciaCampos();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoPlanoDeContas1FocusGained

    private void txt_codigoPlanoDeContas1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContas1FocusLost
        if(txt_codigoPlanoDeContas1.isEditable() == false)
            return;
        if(txt_codigoPlanoDeContas1.getText().replace(" ", "").equals(""))
            return;
        if(Integer.parseInt(fc.FormataCampo(txt_codigoPlanoDeContas1.getText(), 1, 0)) == 0)
            return;
        txt_codigoPlanoDeContas1.setText(fc.FormataCampo(txt_codigoPlanoDeContas1.getText(), 1, 0));
    }//GEN-LAST:event_txt_codigoPlanoDeContas1FocusLost

    private void txt_codigoPlanoDeContas2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContas2FocusGained
        if(txt_codigoPlanoDeContas2.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        operacao = "";
        HabilitaBotoes();
        txt_codigoPlanoDeContas3    .setText("0");
        txt_codigoPlanoDeContas3    .setEditable(false);
        txt_codigoPlanoDeContas4    .setText("00");
        txt_codigoPlanoDeContas4    .setEditable(false);
        txt_codigoPlanoDeContas5    .setText("00");
        txt_codigoPlanoDeContas5    .setEditable(false);
        txt_codigoPlanoDeContas6    .setText("0000");
        txt_codigoPlanoDeContas6    .setEditable(false);
        ReiniciaCampos();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoPlanoDeContas2FocusGained

    private void txt_codigoPlanoDeContas2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContas2FocusLost
        if(txt_codigoPlanoDeContas2.isEditable() == false)
            return;
        if(txt_codigoPlanoDeContas2.getText().replace(" ", "").equals(""))
            return;
        if(Integer.parseInt(fc.FormataCampo(txt_codigoPlanoDeContas2.getText(), 1, 0)) == 0)
            return;
        txt_codigoPlanoDeContas2.setText(fc.FormataCampo(txt_codigoPlanoDeContas2.getText(), 1, 0));
    }//GEN-LAST:event_txt_codigoPlanoDeContas2FocusLost

    private void txt_codigoPlanoDeContas3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContas3FocusGained
        if(txt_codigoPlanoDeContas3.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        operacao = "";
        HabilitaBotoes();
        txt_codigoPlanoDeContas4    .setText("00");
        txt_codigoPlanoDeContas4    .setEditable(false);
        txt_codigoPlanoDeContas5    .setText("00");
        txt_codigoPlanoDeContas5    .setEditable(false);
        txt_codigoPlanoDeContas6    .setText("0000");
        txt_codigoPlanoDeContas6    .setEditable(false);
        ReiniciaCampos();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoPlanoDeContas3FocusGained

    private void txt_codigoPlanoDeContas3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContas3FocusLost
        if(txt_codigoPlanoDeContas3.isEditable() == false)
            return;
        if(txt_codigoPlanoDeContas3.getText().replace(" ", "").equals(""))
            return;
        if(Integer.parseInt(fc.FormataCampo(txt_codigoPlanoDeContas3.getText(), 1, 0)) == 0)
            return;
        txt_codigoPlanoDeContas3.setText(fc.FormataCampo(txt_codigoPlanoDeContas3.getText(), 1, 0));
    }//GEN-LAST:event_txt_codigoPlanoDeContas3FocusLost

    private void txt_codigoPlanoDeContas4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContas4FocusGained
        if(txt_codigoPlanoDeContas4.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        operacao = "";
        HabilitaBotoes();
        txt_codigoPlanoDeContas5    .setText("00");
        txt_codigoPlanoDeContas5    .setEditable(false);
        txt_codigoPlanoDeContas6    .setText("0000");
        txt_codigoPlanoDeContas6    .setEditable(false);
        ReiniciaCampos();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoPlanoDeContas4FocusGained

    private void txt_codigoPlanoDeContas4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContas4FocusLost
        if(txt_codigoPlanoDeContas4.isEditable() == false)
            return;
        if(txt_codigoPlanoDeContas4.getText().replace(" ", "").equals(""))
            return;
        if(Integer.parseInt(fc.FormataCampo(txt_codigoPlanoDeContas4.getText(), 2, 0)) == 0)
            return;
        txt_codigoPlanoDeContas4.setText(fc.FormataCampo(txt_codigoPlanoDeContas4.getText(), 2, 0));
    }//GEN-LAST:event_txt_codigoPlanoDeContas4FocusLost

    private void txt_codigoPlanoDeContas5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContas5FocusGained
        if(txt_codigoPlanoDeContas5.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        operacao = "";
        HabilitaBotoes();
        txt_codigoPlanoDeContas6    .setText("0000");
        txt_codigoPlanoDeContas6    .setEditable(false);
        ReiniciaCampos();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoPlanoDeContas5FocusGained

    private void txt_codigoPlanoDeContas5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContas5FocusLost
        if(txt_codigoPlanoDeContas5.isEditable() == false)
            return;
        if(txt_codigoPlanoDeContas5.getText().replace(" ", "").equals(""))
            return;
        if(Integer.parseInt(fc.FormataCampo(txt_codigoPlanoDeContas5.getText(), 2, 0)) == 0)
            return;
        txt_codigoPlanoDeContas5.setText(fc.FormataCampo(txt_codigoPlanoDeContas5.getText(), 2, 0));
    }//GEN-LAST:event_txt_codigoPlanoDeContas5FocusLost

    private void txt_codigoPlanoDeContas6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContas6FocusGained
        if(txt_codigoPlanoDeContas6.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        operacao = "";
        HabilitaBotoes();
        ReiniciaCampos();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoPlanoDeContas6FocusGained

    private void txt_codigoPlanoDeContas6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContas6FocusLost
        if(txt_codigoPlanoDeContas6.isEditable() == false)
            return;
        if(txt_codigoPlanoDeContas6.getText().replace(" ", "").equals(""))
            return;
        if(Integer.parseInt(fc.FormataCampo(txt_codigoPlanoDeContas6.getText(), 4, 0)) == 0)
            return;
        PegaPlanoDeContas("S");
        txt_codigoPlanoDeContas6.setText(fc.FormataCampo(txt_codigoPlanoDeContas6.getText(), 4, 0));
    }//GEN-LAST:event_txt_codigoPlanoDeContas6FocusLost

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ReiniciaCampos();
        HabilitaCampos(false);
        txt_codigoPlanoDeContas1        .grabFocus();
        if(somostra.equals("S")){
            txt_codigoPlanoDeContas1    .setEditable(false);
            bt_novo                     .setEnabled (false);
            bt_incluir                  .setVisible (false);
            bt_alterar                  .setVisible (false);
            bt_pesquisa                 .setVisible (false);
            bt_pesquisaPlanoReferencial .setEnabled (false);
            txt_codigoPlanoReferencial  .setEditable(false);
        }
        if(somostra.equals("SN"))bt_pesquisa.setVisible(false);
        if(!bpla.codigoPlanoDeContas.equals("")){
            bpla.RecarregaCodigosPlanosDeContas();
            txt_codigoPlanoDeContas1    .setText(fc.FormataCampo(bpla.codigoPlanoDeContas1, 1, 0));
            txt_codigoPlanoDeContas2    .setText(fc.FormataCampo(bpla.codigoPlanoDeContas2, 1, 0));
            txt_codigoPlanoDeContas3    .setText(fc.FormataCampo(bpla.codigoPlanoDeContas3, 1, 0));
            txt_codigoPlanoDeContas4    .setText(fc.FormataCampo(bpla.codigoPlanoDeContas4, 2, 0));
            txt_codigoPlanoDeContas5    .setText(fc.FormataCampo(bpla.codigoPlanoDeContas5, 2, 0));
            txt_codigoPlanoDeContas6    .setText(fc.FormataCampo(bpla.codigoPlanoDeContas6, 4, 0));
            PegaPlanoDeContas("S");
        }
    }//GEN-LAST:event_formWindowOpened

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        ReiniciaCampos();
        HabilitaCampos(true);
        if(Integer.parseInt(fc.FormataCampo(txt_codigoPlanoDeContas1.getText(), 1, 0)) != 0){
            PegaPlanoDeContas("N");
            if(dadosPlanoDeContas.isEmpty())return;
        }
        
        PegaNovoPlanoDeContas();
        
        operacao = "I";
        HabilitaBotoes();
        
        dadosCount.clear();
        dadosCount = parametrosNS.dao.Consulta(sql);
        bpla.idPlanoDeContas    = Integer.parseInt(  String.valueOf(dadosCount.get(0).get(0)));
        switch(bpla.nivelPlanoDeContas){
            case 1: bpla.idPlanoDeContas += 1;
                    txt_codigoPlanoDeContas1    .setText(fc.FormataCampo(String.valueOf(bpla.idPlanoDeContas), 1, 0));
                    txt_descricaoPlanoDeContas  .grabFocus();       break;
                    
            case 2: txt_codigoPlanoDeContas2    .setText(fc.FormataCampo(String.valueOf(bpla.idPlanoDeContas), 1, 0));
                    txt_descricaoPlanoDeContas  .grabFocus();
                    txt_codigoPlanoDeContas2    .setEditable(true); break;
                    
            case 3: txt_codigoPlanoDeContas3    .setText(fc.FormataCampo(String.valueOf(bpla.idPlanoDeContas), 1, 0));
                    txt_descricaoPlanoDeContas  .grabFocus();
                    txt_codigoPlanoDeContas3    .setEditable(true); break;
                    
            case 4: txt_codigoPlanoDeContas4    .setText(fc.FormataCampo(String.valueOf(bpla.idPlanoDeContas), 2, 0));
                    txt_descricaoPlanoDeContas  .grabFocus();
                    txt_codigoPlanoDeContas4    .setEditable(true); break;
                    
            case 5: txt_codigoPlanoDeContas5    .setText(fc.FormataCampo(String.valueOf(bpla.idPlanoDeContas), 2, 0));
                    txt_descricaoPlanoDeContas  .grabFocus();
                    txt_codigoPlanoDeContas5    .setEditable(true); break;
                    
            case 6: txt_codigoPlanoDeContas6    .setText(fc.FormataCampo(String.valueOf(bpla.idPlanoDeContas), 4, 0));
                    txt_descricaoPlanoDeContas  .grabFocus();
                    txt_codigoPlanoDeContas6    .setEditable(true);
                    txt_saldoDeAbertura         .setEditable(true); break;
        }
    }//GEN-LAST:event_bt_novoActionPerformed

    private void txt_saldoDeAberturaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_saldoDeAberturaFocusGained
        if(!txt_saldoDeAbertura.getText().equals(""))
            txt_saldoDeAbertura.setText(TransStrDou.TransformaValorStringeDouble(txt_saldoDeAbertura.getText(), 1));
        txt_saldoDeAbertura.setSelectionStart(0);
        txt_saldoDeAbertura.setSelectionEnd  (txt_saldoDeAbertura.getText().length());
    }//GEN-LAST:event_txt_saldoDeAberturaFocusGained

    private void txt_saldoDeAberturaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_saldoDeAberturaFocusLost
        if(!txt_saldoDeAbertura.getText().equals(""))
            txt_saldoDeAbertura.setText(TransStrDou.TransformaValorStringeDouble(txt_saldoDeAbertura.getText(), 0));
    }//GEN-LAST:event_txt_saldoDeAberturaFocusLost

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        String saldoDeAbertura = "'" + String.valueOf(bpla.saldoDeAbertura) + "'";
        if(bpla.nivelPlanoDeContas < 6)if(bpla.saldoDeAbertura == 0)saldoDeAbertura = null;
        
        IncluiPlanoDeContasMovimento();
        if(!sqlstate.equals("00000"))
            return;
        sql = "insert into tb_planodecontas (idEmpresa, codigoGrupo, codigoEmpresa, codigoPlanoDeContas, descricaoPlanoDeContas, tipoPlanoDeContas, saldoDeAbertura, codigoPlanoDeContasSuperior, nivelPlanoDeContas, idPlanoReferencial) "
            + "values (" + bpla.idEmpresa + ", " + bpla.codigoGrupo + ", " + bpla.codigoEmpresa + ", '" + bpla.codigoPlanoDeContas + "', '" + bpla.descricaoPlanoDeContas + "', '" + bpla.tipoPlanoDeContas + "', " + saldoDeAbertura + ", '" + bpla.codigoPlanoDeContasSuperior + "', " + bpla.nivelPlanoDeContas + ", " + bpla.idPlanoReferencial + ");";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoPlanoDeContas1.grabFocus();
        txt_codigoPlanoDeContas1.setText("");
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "update tb_planodecontas set descricaoPlanoDeContas = '"         + bpla.descricaoPlanoDeContas       + "', ";
        if(bpla.nivelPlanoDeContas > 5)
            sql +="saldoDeAbertura = '"             + bpla.saldoDeAbertura              + "', ";
        sql += "idPlanoReferencial = "              + bpla.idPlanoReferencial           + " "
             + "where idPlanoDeContas = "           + bpla.idPlanoDeContas              + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoPlanoDeContas1.grabFocus();
        txt_codigoPlanoDeContas1.setText("");
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void txt_codigoPlanoDeContas1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContas1KeyReleased
        if(txt_codigoPlanoDeContas1.isEditable() == false)
            return;
        if(txt_codigoPlanoDeContas1.getText().replace(" ", "").equals(""))
            return;
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            PegaPlanoDeContas("S");
            txt_descricaoPlanoDeContas.grabFocus();
            return;
        }
        if(Integer.parseInt(fc.FormataCampo(txt_codigoPlanoDeContas1.getText(), 1, 0)) == 0)
            return;
        PegaPlanoDeContas("N");
        if(dadosPlanoDeContas.isEmpty())return;
        txt_codigoPlanoDeContas2.setEditable(true);
        txt_codigoPlanoDeContas2.setText("");
        txt_codigoPlanoDeContas2.grabFocus();
    }//GEN-LAST:event_txt_codigoPlanoDeContas1KeyReleased

    private void txt_codigoPlanoDeContas2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContas2KeyReleased
        if(txt_codigoPlanoDeContas2.isEditable() == false)
            return;
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            PegaPlanoDeContas("S");
            txt_descricaoPlanoDeContas.grabFocus();
            return;
        }
        if(Integer.parseInt(fc.FormataCampo(txt_codigoPlanoDeContas2.getText(), 1, 0)) == 0)
            return;
        PegaPlanoDeContas("N");
        if(dadosPlanoDeContas.isEmpty())return;
        txt_codigoPlanoDeContas3.setEditable(true);
        txt_codigoPlanoDeContas3.setText("");
        txt_codigoPlanoDeContas3.grabFocus();
    }//GEN-LAST:event_txt_codigoPlanoDeContas2KeyReleased

    private void txt_codigoPlanoDeContas3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContas3KeyReleased
        if(txt_codigoPlanoDeContas3.isEditable() == false)
            return;
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            PegaPlanoDeContas("S");
            txt_descricaoPlanoDeContas.grabFocus();
            return;
        }
        if(Integer.parseInt(fc.FormataCampo(txt_codigoPlanoDeContas3.getText(), 1, 0)) == 0)
            return;
        PegaPlanoDeContas("N");
        if(dadosPlanoDeContas.isEmpty())return;
        txt_codigoPlanoDeContas4.setEditable(true);
        txt_codigoPlanoDeContas4.setText("");
        txt_codigoPlanoDeContas4.grabFocus();
    }//GEN-LAST:event_txt_codigoPlanoDeContas3KeyReleased

    private void txt_codigoPlanoDeContas4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContas4KeyReleased
        if(txt_codigoPlanoDeContas4.isEditable() == false)
            return;
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            PegaPlanoDeContas("S");
            txt_descricaoPlanoDeContas.grabFocus();
            return;
        }
        if(txt_codigoPlanoDeContas4.getText().replace(" ", "").length() < 2)
            return;
        if(Integer.parseInt(fc.FormataCampo(txt_codigoPlanoDeContas4.getText(), 1, 0)) == 0)
            return;
        PegaPlanoDeContas("N");
        if(dadosPlanoDeContas.isEmpty())return;
        txt_codigoPlanoDeContas5.setEditable(true);
        txt_codigoPlanoDeContas5.setText("");
        txt_codigoPlanoDeContas5.grabFocus();
    }//GEN-LAST:event_txt_codigoPlanoDeContas4KeyReleased

    private void txt_codigoPlanoDeContas5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContas5KeyReleased
        if(txt_codigoPlanoDeContas5.isEditable() == false)
            return;
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            PegaPlanoDeContas("S");
            txt_descricaoPlanoDeContas.grabFocus();
            return;
        }
        if(txt_codigoPlanoDeContas5.getText().replace(" ", "").length() < 2)
            return;
        if(Integer.parseInt(fc.FormataCampo(txt_codigoPlanoDeContas5.getText(), 1, 0)) == 0)
            return;
        PegaPlanoDeContas("N");
        if(dadosPlanoDeContas.isEmpty())return;
        txt_codigoPlanoDeContas6.setEditable(true);
        txt_codigoPlanoDeContas6.setText("");
        txt_codigoPlanoDeContas6.grabFocus();
    }//GEN-LAST:event_txt_codigoPlanoDeContas5KeyReleased

    private void txt_codigoPlanoDeContas6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContas6KeyReleased
        if(txt_codigoPlanoDeContas6.isEditable() == false)
            return;
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        txt_descricaoPlanoDeContas.grabFocus();
    }//GEN-LAST:event_txt_codigoPlanoDeContas6KeyReleased

    private void txt_codigoPlanoReferencialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoReferencialFocusGained
        txt_codigoPlanoReferencial.setSelectionStart(0);
        txt_codigoPlanoReferencial.setSelectionEnd  (txt_codigoPlanoReferencial.getText().length());
    }//GEN-LAST:event_txt_codigoPlanoReferencialFocusGained

    private void txt_codigoPlanoReferencialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoReferencialFocusLost
        if(txt_codigoPlanoReferencial.isEditable() == false)
            return;
        if(txt_codigoPlanoReferencial.getText().equals("")){
            txt_descricaoPlanoReferencial.setText("");
            return;
        }
        bpref.codigoPlanoReferencial = txt_codigoPlanoReferencial.getText().replace(".", "");
        sql = "select * from ns_plano_referencial where replace(codigoPlanoReferencial, '.', '') = '" + bpref.codigoPlanoReferencial + "';";
        PegaPlanoReferencial();
    }//GEN-LAST:event_txt_codigoPlanoReferencialFocusLost

    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        if(PlaDeConCon != null)if(PlaDeConCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuPesquisaPlanoDeContas = 1;
        parametros.clear();
        parametros.add("S");
        PlaDeConCon = new PlanoDeContasConsulta(parametros);
        PlaDeConCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void bt_pesquisaPlanoReferencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaPlanoReferencialActionPerformed
        if(PlaRefCon != null)if(PlaRefCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuPesquisaPlanoReferencial = 1;
        parametros.clear();
        parametros.add("N");
        PlaRefCon = new PlanoReferencialConsulta(parametros);
        PlaRefCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaPlanoReferencialActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
        if(abriuPesquisaPlanoDeContas == 0){
            AbrePlanoReferencial();
            return;
        }
        abriuPesquisaPlanoDeContas = 0;
        retorno = PlaDeConCon.getRetorno();
        if(retorno.equals(""))
            return;
        bpla.codigoPlanoDeContas = retorno;
        bpla.RecarregaCodigosPlanosDeContas();
        txt_codigoPlanoDeContas1.setText(fc.FormataCampo(bpla.codigoPlanoDeContas1, 1, 0));
        txt_codigoPlanoDeContas2.setText(fc.FormataCampo(bpla.codigoPlanoDeContas2, 1, 0));
        txt_codigoPlanoDeContas3.setText(fc.FormataCampo(bpla.codigoPlanoDeContas3, 1, 0));
        txt_codigoPlanoDeContas4.setText(fc.FormataCampo(bpla.codigoPlanoDeContas4, 2, 0));
        txt_codigoPlanoDeContas5.setText(fc.FormataCampo(bpla.codigoPlanoDeContas5, 2, 0));
        txt_codigoPlanoDeContas6.setText(fc.FormataCampo(bpla.codigoPlanoDeContas6, 4, 0));
        PegaPlanoDeContas("S");
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbrePlanoReferencial(){
        if(abriuPesquisaPlanoReferencial == 0)
            return;
        abriuPesquisaPlanoReferencial = 0;
        retorno = PlaRefCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoPlanoReferencial.setText(retorno);
        bpref.codigoPlanoReferencial = txt_codigoPlanoReferencial.getText().replace(".", "");
        sql = "select * from ns_plano_referencial where replace(codigoPlanoReferencial, '.', '') = '" + bpref.codigoPlanoReferencial + "';";
        PegaPlanoReferencial();
    }
    
    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void txt_codigoPlanoReferencialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoPlanoReferencialKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        txt_descricaoPlanoReferencial.grabFocus();
    }//GEN-LAST:event_txt_codigoPlanoReferencialKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(PlaDeConCon != null)PlaDeConCon  .dispose();
        if(PlaRefCon   != null)PlaRefCon    .dispose();
    }//GEN-LAST:event_formWindowClosed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisa;
    private javax.swing.JButton bt_pesquisaPlanoReferencial;
    private javax.swing.JButton bt_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField txt_codigoPlanoDeContas1;
    private javax.swing.JFormattedTextField txt_codigoPlanoDeContas2;
    private javax.swing.JFormattedTextField txt_codigoPlanoDeContas3;
    private javax.swing.JFormattedTextField txt_codigoPlanoDeContas4;
    private javax.swing.JFormattedTextField txt_codigoPlanoDeContas5;
    private javax.swing.JFormattedTextField txt_codigoPlanoDeContas6;
    private javax.swing.JTextField txt_codigoPlanoDeContasSuperior;
    private javax.swing.JTextField txt_codigoPlanoReferencial;
    private javax.swing.JTextField txt_descricaoPlanoDeContas;
    private javax.swing.JTextArea txt_descricaoPlanoReferencial;
    private javax.swing.JTextField txt_nivelPlanoDeContas;
    private javax.swing.JTextField txt_saldoDeAbertura;
    private javax.swing.JTextField txt_tipoPlanoDeContas;
    // End of variables declaration//GEN-END:variables
    
    private void ReiniciaCampos(){
        txt_descricaoPlanoDeContas      .setText("");
        txt_tipoPlanoDeContas           .setText("");
        txt_nivelPlanoDeContas          .setText("");
        txt_codigoPlanoDeContasSuperior .setText("");
        txt_saldoDeAbertura             .setText("");
        txt_saldoDeAbertura             .setEditable(false);
        txt_codigoPlanoReferencial      .setText("");
        txt_descricaoPlanoReferencial   .setText("");
    }
    private void HabilitaCampos(boolean Habilita){
        txt_descricaoPlanoDeContas      .setEditable    (Habilita);
        txt_descricaoPlanoDeContas      .setFocusable   (Habilita);
        txt_codigoPlanoReferencial      .setEditable    (Habilita);
        txt_codigoPlanoReferencial      .setFocusable   (Habilita);
        bt_pesquisaPlanoReferencial     .setEnabled     (Habilita);
        bt_pesquisaPlanoReferencial     .setFocusable   (Habilita);
        txt_descricaoPlanoReferencial   .setEditable    (Habilita);
        txt_descricaoPlanoReferencial   .setFocusable   (Habilita);
    }
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_incluir  .setEnabled(true);
            bt_alterar  .setEnabled(false);
            return;
        }
        if(operacao.equals("A")){
            bt_incluir  .setEnabled(false);
            bt_alterar  .setEnabled(true);
            return;
        }
        bt_incluir      .setEnabled(false);
        bt_alterar      .setEnabled(false);
    }
    
    private void PegaNovoPlanoDeContas(){
        bpla.codigoPlanoDeContas1   = fc.FormataCampo(txt_codigoPlanoDeContas1.getText().replace(" ", ""), 1, 0);
        bpla.codigoPlanoDeContas2   = fc.FormataCampo(txt_codigoPlanoDeContas2.getText().replace(" ", ""), 1, 0);
        bpla.codigoPlanoDeContas3   = fc.FormataCampo(txt_codigoPlanoDeContas3.getText().replace(" ", ""), 1, 0);
        bpla.codigoPlanoDeContas4   = fc.FormataCampo(txt_codigoPlanoDeContas4.getText().replace(" ", ""), 2, 0);
        bpla.codigoPlanoDeContas5   = fc.FormataCampo(txt_codigoPlanoDeContas5.getText().replace(" ", ""), 2, 0);
        bpla.codigoPlanoDeContas6   = fc.FormataCampo(txt_codigoPlanoDeContas6.getText().replace(" ", ""), 4, 0);
        bpla.codigoPlanoDeContas    = bpla.codigoPlanoDeContas1 + bpla.codigoPlanoDeContas2 + bpla.codigoPlanoDeContas3 + bpla.codigoPlanoDeContas4 + bpla.codigoPlanoDeContas5 + bpla.codigoPlanoDeContas6;
        
        if(Integer.parseInt(bpla.codigoPlanoDeContas1) == 0){
            bpla.nivelPlanoDeContas = 1;
            sql = "select count(*) from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and nivelPlanoDeContas = 1";
            return;
        }
        if(Integer.parseInt(bpla.codigoPlanoDeContas2) == 0){
            bpla.nivelPlanoDeContas = 2;
            bpla.codigoPlanoDeContasrestante    = bpla.codigoPlanoDeContas.substring(2, bpla.codigoPlanoDeContas.length());
            bpla.codigoPlanoDeContas            = bpla.codigoPlanoDeContas.substring(0, 1);
            sql = "select count(*) from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and substring(codigoPlanoDeContas, 1, 1) = '" + bpla.codigoPlanoDeContas + "' and substring(codigoPlanoDeContas, 3) = '" + bpla.codigoPlanoDeContasrestante + "';";
            return;
        }
        if(Integer.parseInt(bpla.codigoPlanoDeContas3) == 0){
            bpla.nivelPlanoDeContas = 3;
            bpla.codigoPlanoDeContasrestante    = bpla.codigoPlanoDeContas.substring(3, bpla.codigoPlanoDeContas.length());
            bpla.codigoPlanoDeContas            = bpla.codigoPlanoDeContas.substring(0, 2);
            sql = "select count(*) from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and substring(codigoPlanoDeContas, 1, 2) = '" + bpla.codigoPlanoDeContas + "' and substring(codigoPlanoDeContas, 4) = '" + bpla.codigoPlanoDeContasrestante + "';";
            return;
        }
        if(Integer.parseInt(bpla.codigoPlanoDeContas4) == 0){
            bpla.nivelPlanoDeContas = 4;
            bpla.codigoPlanoDeContasrestante    = bpla.codigoPlanoDeContas.substring(5, bpla.codigoPlanoDeContas.length());
            bpla.codigoPlanoDeContas            = bpla.codigoPlanoDeContas.substring(0, 3);
            sql = "select count(*) from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and substring(codigoPlanoDeContas, 1, 3) = '" + bpla.codigoPlanoDeContas + "' and substring(codigoPlanoDeContas, 6) = '" + bpla.codigoPlanoDeContasrestante + "';";
            return;
        }
        if(Integer.parseInt(bpla.codigoPlanoDeContas5) == 0){
            bpla.nivelPlanoDeContas = 5;
            bpla.codigoPlanoDeContasrestante    = bpla.codigoPlanoDeContas.substring(7, bpla.codigoPlanoDeContas.length());
            bpla.codigoPlanoDeContas            = bpla.codigoPlanoDeContas.substring(0, 5);
            sql = "select count(*) from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and substring(codigoPlanoDeContas, 1, 5) = '" + bpla.codigoPlanoDeContas + "' and substring(codigoPlanoDeContas, 8) = '" + bpla.codigoPlanoDeContasrestante + "';";
            return;
        }
        if(Integer.parseInt(bpla.codigoPlanoDeContas6) == 0){
            bpla.nivelPlanoDeContas = 6;
            bpla.codigoPlanoDeContas            = bpla.codigoPlanoDeContas.substring(0, 7);
            sql = "select count(*) from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and substring(codigoPlanoDeContas, 1, 7) = '" + bpla.codigoPlanoDeContas + "';";
            return;
        }
    }
    
    private void PegaPlanoDeContas(String Mostra){
        bpla.codigoPlanoDeContas1   = fc.FormataCampo(txt_codigoPlanoDeContas1.getText().replace(" ", ""), 1, 0);
        bpla.codigoPlanoDeContas2   = fc.FormataCampo(txt_codigoPlanoDeContas2.getText().replace(" ", ""), 1, 0);
        bpla.codigoPlanoDeContas3   = fc.FormataCampo(txt_codigoPlanoDeContas3.getText().replace(" ", ""), 1, 0);
        bpla.codigoPlanoDeContas4   = fc.FormataCampo(txt_codigoPlanoDeContas4.getText().replace(" ", ""), 2, 0);
        bpla.codigoPlanoDeContas5   = fc.FormataCampo(txt_codigoPlanoDeContas5.getText().replace(" ", ""), 2, 0);
        bpla.codigoPlanoDeContas6   = fc.FormataCampo(txt_codigoPlanoDeContas6.getText().replace(" ", ""), 4, 0);
        bpla.codigoPlanoDeContas    = bpla.codigoPlanoDeContas1 + bpla.codigoPlanoDeContas2 + bpla.codigoPlanoDeContas3 + bpla.codigoPlanoDeContas4 + bpla.codigoPlanoDeContas5 + bpla.codigoPlanoDeContas6;
        
        if(Integer.parseInt(bpla.codigoPlanoDeContas1) == 0)Mostra = "S";
        if(Integer.parseInt(bpla.codigoPlanoDeContas2) == 0){txt_codigoPlanoDeContas2.setEditable(false);txt_codigoPlanoDeContas2.setText(fc.FormataCampo("", 1, 0));}
        if(Integer.parseInt(bpla.codigoPlanoDeContas3) == 0){txt_codigoPlanoDeContas3.setEditable(false);txt_codigoPlanoDeContas3.setText(fc.FormataCampo("", 1, 0));}
        if(Integer.parseInt(bpla.codigoPlanoDeContas4) == 0){txt_codigoPlanoDeContas4.setEditable(false);txt_codigoPlanoDeContas4.setText(fc.FormataCampo("", 2, 0));}
        if(Integer.parseInt(bpla.codigoPlanoDeContas5) == 0){txt_codigoPlanoDeContas5.setEditable(false);txt_codigoPlanoDeContas5.setText(fc.FormataCampo("", 2, 0));}
        if(Integer.parseInt(bpla.codigoPlanoDeContas6) == 0){txt_codigoPlanoDeContas6.setEditable(false);txt_codigoPlanoDeContas6.setText(fc.FormataCampo("", 4, 0));}
        
        sql = "select * from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and codigoPlanoDeContas = '" + bpla.codigoPlanoDeContas + "';";
        dadosPlanoDeContas.clear();
        dadosPlanoDeContas = parametrosNS.dao.Consulta(sql);
        if(Mostra.equals("N"))return;
        if(dadosPlanoDeContas.isEmpty()){
            bpla.codigoPlanoDeContas    = bpla.codigoPlanoDeContas.substring(0, 7) + "." + bpla.codigoPlanoDeContas.substring(7);
            Mensagem = "Não foi encontrado Plano de Contas para o código n°" + bpla.codigoPlanoDeContas + "!";
            new MostraMensagem(Mensagem);
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        HabilitaCampos(true);
        PegaDadosPlanoDeContas();
    }
    
    private void PegaDadosPlanoDeContas(){
        for(int i = 0; i < dadosPlanoDeContas.size(); i++){
            if(dadosPlanoDeContas.get(i).get(0) != null)
                bpla.idPlanoDeContas                = Integer.parseInt(  String.valueOf(dadosPlanoDeContas.get(i).get(0)));
            if(dadosPlanoDeContas.get(i).get(1) != null)
                bpla.idEmpresa                      = Integer.parseInt(  String.valueOf(dadosPlanoDeContas.get(i).get(1)));
            if(dadosPlanoDeContas.get(i).get(2) != null)
                bpla.codigoGrupo                    = Integer.parseInt(  String.valueOf(dadosPlanoDeContas.get(i).get(2)));
            if(dadosPlanoDeContas.get(i).get(3) != null)
                bpla.codigoEmpresa                  = Integer.parseInt(  String.valueOf(dadosPlanoDeContas.get(i).get(3)));
                bpla.codigoPlanoDeContas            =                    String.valueOf(dadosPlanoDeContas.get(i).get(4));
                bpla.descricaoPlanoDeContas         =                    String.valueOf(dadosPlanoDeContas.get(i).get(5));
                bpla.tipoPlanoDeContas              =                    String.valueOf(dadosPlanoDeContas.get(i).get(6));
            if(dadosPlanoDeContas.get(i).get(7) != null)
                bpla.saldoDeAbertura                = Double.parseDouble(String.valueOf(dadosPlanoDeContas.get(i).get(7)));
                bpla.codigoPlanoDeContasSuperior    =                    String.valueOf(dadosPlanoDeContas.get(i).get(8));
            if(dadosPlanoDeContas.get(i).get(9) != null)
                bpla.nivelPlanoDeContas             = Integer.parseInt(  String.valueOf(dadosPlanoDeContas.get(i).get(9)));
            if(dadosPlanoDeContas.get(i).get(10) != null)
                bpla.idPlanoReferencial             = Integer.parseInt(  String.valueOf(dadosPlanoDeContas.get(i).get(10)));
        }
        txt_descricaoPlanoDeContas      .setText(bpla.descricaoPlanoDeContas);
        txt_tipoPlanoDeContas           .setText(bpla.tipoPlanoDeContas);
        txt_nivelPlanoDeContas          .setText(String.valueOf(bpla.nivelPlanoDeContas));
        bpla.RecarregaCodigosPlanosDeContasSuperior();
        bpla.RecarregaPlanoDeContasSuperior("S");
        txt_codigoPlanoDeContasSuperior .setText(bpla.codigoPlanoDeContasSuperior);
        if(bpla.saldoDeAbertura != 0)
            txt_saldoDeAbertura             .setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(bpla.saldoDeAbertura), 0));
        
        if(bpla.nivelPlanoDeContas >= 2)
            txt_codigoPlanoDeContas2.setEditable(true);
        if(bpla.nivelPlanoDeContas >= 3)
            txt_codigoPlanoDeContas3.setEditable(true);
        if(bpla.nivelPlanoDeContas >= 4)
            txt_codigoPlanoDeContas4.setEditable(true);
        if(bpla.nivelPlanoDeContas >= 5)
            txt_codigoPlanoDeContas5.setEditable(true);
        if(bpla.nivelPlanoDeContas >= 6)
            txt_codigoPlanoDeContas6.setEditable(true);
        
        bpref = new BeanPlanoReferencial();
        bpref.idPlanoReferencial        = bpla.idPlanoReferencial;
        
        if(bpref.idPlanoReferencial != 0){
            sql = "select * from ns_plano_referencial where idPlanoReferencial = " + bpref.idPlanoReferencial + ";";
            PegaPlanoReferencial();
        }
    }
    
    private void PegaPlanoReferencial(){
        dadosPlanoReferencial.clear();
        dadosPlanoReferencial = parametrosNS.dao.Consulta(sql);
        if(dadosPlanoReferencial.isEmpty()){
            Mensagem = "Plano Referencial n°" + bpref.codigoPlanoReferencial + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosPlanoReferencial();
    }
    
    private void PegaDadosPlanoReferencial(){
        for(int i = 0; i < dadosPlanoReferencial.size(); i++){
            if(dadosPlanoReferencial.get(i).get(0) != null)
                bpref.idPlanoReferencial                = Integer.parseInt(  String.valueOf(dadosPlanoReferencial.get(i).get(0)));
            if(dadosPlanoReferencial.get(i).get(1) != null)
                bpref.codigoGrupo                       = Integer.parseInt(  String.valueOf(dadosPlanoReferencial.get(i).get(1)));
                bpref.codigoPlanoReferencial            =                    String.valueOf(dadosPlanoReferencial.get(i).get(2));
                bpref.descricaoPlanoReferencial         =                    String.valueOf(dadosPlanoReferencial.get(i).get(3));
                bpref.dataInicial                       =                    String.valueOf(dadosPlanoReferencial.get(i).get(4));
                bpref.dataFinal                         =                    String.valueOf(dadosPlanoReferencial.get(i).get(5));
                bpref.tipoPlanoReferencial              =                    String.valueOf(dadosPlanoReferencial.get(i).get(6));
                bpref.codigoPlanoReferencialSuperior    =                    String.valueOf(dadosPlanoReferencial.get(i).get(7));
            if(dadosPlanoReferencial.get(i).get(9) != null)
                bpref.nivel                             = Integer.parseInt(  String.valueOf(dadosPlanoReferencial.get(i).get(8)));
            if(dadosPlanoReferencial.get(i).get(10) != null)
                bpref.natureza                          = Integer.parseInt(  String.valueOf(dadosPlanoReferencial.get(i).get(9)));
                bpref.orientacoes                       =                    String.valueOf(dadosPlanoReferencial.get(i).get(10));
        }
        txt_codigoPlanoReferencial      .setText(bpref.codigoPlanoReferencial);
        txt_descricaoPlanoReferencial   .setText(bpref.descricaoPlanoReferencial);
    }
    
    private void PegaValores(){
        bpla.idEmpresa                  = parametrosNS.be.IdEmpresa;
        bpla.codigoGrupo                = parametrosNS.bge.CodigoGrupo;
        bpla.codigoEmpresa              = parametrosNS.be.CodigoEmpresa;
        bpla.codigoPlanoDeContas1       = fc.FormataCampo(txt_codigoPlanoDeContas1.getText().replace(" ", ""), 1, 0);
        bpla.codigoPlanoDeContas2       = fc.FormataCampo(txt_codigoPlanoDeContas2.getText().replace(" ", ""), 1, 0);
        bpla.codigoPlanoDeContas3       = fc.FormataCampo(txt_codigoPlanoDeContas3.getText().replace(" ", ""), 1, 0);
        bpla.codigoPlanoDeContas4       = fc.FormataCampo(txt_codigoPlanoDeContas4.getText().replace(" ", ""), 2, 0);
        bpla.codigoPlanoDeContas5       = fc.FormataCampo(txt_codigoPlanoDeContas5.getText().replace(" ", ""), 2, 0);
        bpla.codigoPlanoDeContas6       = fc.FormataCampo(txt_codigoPlanoDeContas6.getText().replace(" ", ""), 4, 0);
        bpla.codigoPlanoDeContas        = bpla.codigoPlanoDeContas1 + bpla.codigoPlanoDeContas2 + bpla.codigoPlanoDeContas3 + bpla.codigoPlanoDeContas4 + bpla.codigoPlanoDeContas5 + bpla.codigoPlanoDeContas6;
        
        bpla.descricaoPlanoDeContas     = txt_descricaoPlanoDeContas.getText();
        if(bpla.descricaoPlanoDeContas.equals("")){
            Mensagem = "Descrição Inváida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        
        if(!txt_saldoDeAbertura.getText().equals(""))
            bpla.saldoDeAbertura        = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_saldoDeAbertura.getText(), 1));
        else
            bpla.saldoDeAbertura        = 0;
        
        bpla.tipoPlanoDeContas  = "S";
        if(Integer.parseInt(bpla.codigoPlanoDeContas1) != 0){
            bpla.nivelPlanoDeContas = 1;
            bpla.codigoPlanoDeContasSuperior = "";
        }
        if(Integer.parseInt(bpla.codigoPlanoDeContas2) != 0){
            bpla.nivelPlanoDeContas = 2;
            bpla.codigoPlanoDeContasSuperior = fcad.FormataCampoADireita(bpla.codigoPlanoDeContas.substring(0, 1), 7, 0);
        }
        if(Integer.parseInt(bpla.codigoPlanoDeContas3) != 0){
            bpla.nivelPlanoDeContas = 3;
            bpla.codigoPlanoDeContasSuperior = fcad.FormataCampoADireita(bpla.codigoPlanoDeContas.substring(0, 2), 7, 0);
        }
        if(Integer.parseInt(bpla.codigoPlanoDeContas4) != 0){
            bpla.nivelPlanoDeContas = 4;
            bpla.codigoPlanoDeContasSuperior = fcad.FormataCampoADireita(bpla.codigoPlanoDeContas.substring(0, 3), 7, 0);
        }
        if(Integer.parseInt(bpla.codigoPlanoDeContas5) != 0){
            bpla.nivelPlanoDeContas = 5;
            bpla.codigoPlanoDeContasSuperior = fcad.FormataCampoADireita(bpla.codigoPlanoDeContas.substring(0, 5), 7, 0);
        }
        if(Integer.parseInt(bpla.codigoPlanoDeContas6) != 0){
            bpla.tipoPlanoDeContas  = "A";
            bpla.nivelPlanoDeContas = 6;
            bpla.codigoPlanoDeContasSuperior = fcad.FormataCampoADireita(bpla.codigoPlanoDeContas.substring(0, 7), 7, 0);
        }
        
        bpla.idPlanoReferencial     = bpref.idPlanoReferencial;
    }
    
    private void IncluiPlanoDeContasMovimento(){
        if(bpla.nivelPlanoDeContas < 6){
            sqlstate = "00000";
            return;
        }
        bplamov.idEmpresa             = parametrosNS.be.IdEmpresa;
        bplamov.codigoGrupo           = parametrosNS.bge.CodigoGrupo;
        bplamov.codigoEmpresa         = parametrosNS.be.CodigoEmpresa;
        bplamov.codigoPlanoDeContas   = bpla.codigoPlanoDeContas;
        bplamov.dataPlanoDeContas     = invdata.inverterData(cdh.CapturarData(), 2);
        bplamov.saldo                 = bpla.saldoDeAbertura;
        
        sql = "insert into tb_planodecontasmovimentos (idEmpresa, codigoGrupo, codigoEmpresa, codigoPlanoDeContas, dataPlanoDeContas, saldo) "
            + "values (" + bplamov.idEmpresa + ", " + bplamov.codigoGrupo + ", " + bplamov.codigoEmpresa + ", " + bplamov.codigoPlanoDeContas + ", '" + bplamov.dataPlanoDeContas + "', " + bplamov.saldo + ");";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
    }
    
}
