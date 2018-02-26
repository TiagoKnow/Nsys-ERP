package TelasContabil;

import BeansNS.BeanEmpresas;
import BeansNS.BeanGrupoEmpresa;
import Beans.BeanPlanoReferencial;
import Dao.DaoMySQL;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.FormataCampoADireita;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.ArrayList;

/*
 @author Tiago e Paulo
 */
public class PlanoReferencialCadastro extends javax.swing.JFrame {
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
    
    //Vetores
    ArrayList            dadosPadroes                  = new ArrayList();
    ArrayList<ArrayList> dadosPlanoReferencial         = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosCount                    = new ArrayList<ArrayList>();
    
    //Bean's
    BeanGrupoEmpresa                bge     = new BeanGrupoEmpresa();
    BeanEmpresas                    be      = new BeanEmpresas();
    BeanPlanoReferencial            bpref   = new BeanPlanoReferencial();
    
    //Especiais
    FormataCampo                    fc      = new FormataCampo();
    FormataCampoADireita            fcad    = new FormataCampoADireita();
    InverterData                    invdata = new InverterData();
    CapturarDataHora                cdh     = new CapturarDataHora();
    
    //Telas
    
    public PlanoReferencialCadastro(ArrayList DadosPadroes){
        dadosPadroes                        = DadosPadroes;
        
        somostra                            = (String)  dadosPadroes.get(0);
        bpref.codigoPlanoReferencial        = (String)  dadosPadroes.get(1);
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigoPlanoReferencial1 = new javax.swing.JFormattedTextField();
        txt_codigoPlanoReferencial2 = new javax.swing.JFormattedTextField();
        txt_codigoPlanoReferencial3 = new javax.swing.JFormattedTextField();
        txt_codigoPlanoReferencial4 = new javax.swing.JFormattedTextField();
        txt_codigoPlanoReferencial5 = new javax.swing.JFormattedTextField();
        txt_codigoPlanoReferencial6 = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_descricaoPlanoReferencial = new javax.swing.JTextField();
        bt_novo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_dataInicial = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_dataFinal = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_tipoPlanoReferencial = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_codigoPlanoReferencialSuperior = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_nivel = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_natureza = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_orientacoes = new javax.swing.JTextArea();
        bt_incluir = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        bt_pesquisa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Plano de Contas Referencial");
        setResizable(false);
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
        jLabel1.setText("Plano de Contas Referencial");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Plano Referencial:");

        try {
            txt_codigoPlanoReferencial1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoPlanoReferencial1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoPlanoReferencial1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoReferencial1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoReferencial1FocusLost(evt);
            }
        });
        txt_codigoPlanoReferencial1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoPlanoReferencial1KeyReleased(evt);
            }
        });

        txt_codigoPlanoReferencial2.setEditable(false);
        try {
            txt_codigoPlanoReferencial2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoPlanoReferencial2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoPlanoReferencial2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoReferencial2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoReferencial2FocusLost(evt);
            }
        });
        txt_codigoPlanoReferencial2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoPlanoReferencial2KeyReleased(evt);
            }
        });

        txt_codigoPlanoReferencial3.setEditable(false);
        try {
            txt_codigoPlanoReferencial3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoPlanoReferencial3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoPlanoReferencial3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoReferencial3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoReferencial3FocusLost(evt);
            }
        });
        txt_codigoPlanoReferencial3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoPlanoReferencial3KeyReleased(evt);
            }
        });

        txt_codigoPlanoReferencial4.setEditable(false);
        try {
            txt_codigoPlanoReferencial4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoPlanoReferencial4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoPlanoReferencial4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoReferencial4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoReferencial4FocusLost(evt);
            }
        });
        txt_codigoPlanoReferencial4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoPlanoReferencial4KeyReleased(evt);
            }
        });

        txt_codigoPlanoReferencial5.setEditable(false);
        try {
            txt_codigoPlanoReferencial5.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoPlanoReferencial5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoPlanoReferencial5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoReferencial5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoReferencial5FocusLost(evt);
            }
        });
        txt_codigoPlanoReferencial5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoPlanoReferencial5KeyReleased(evt);
            }
        });

        txt_codigoPlanoReferencial6.setEditable(false);
        try {
            txt_codigoPlanoReferencial6.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoPlanoReferencial6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoPlanoReferencial6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoReferencial6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoReferencial6FocusLost(evt);
            }
        });
        txt_codigoPlanoReferencial6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoPlanoReferencial6KeyReleased(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Descrição:");

        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Data Inicial:");

        txt_dataInicial.setEditable(false);
        try {
            txt_dataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataInicial.setText("00/00/0000");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Data Final:");

        txt_dataFinal.setEditable(false);
        try {
            txt_dataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Tipo:");

        txt_tipoPlanoReferencial.setEditable(false);
        try {
            txt_tipoPlanoReferencial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("*")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_tipoPlanoReferencial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_tipoPlanoReferencial.setToolTipText("(A) - Analítica   (S) - Sintética");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Conta Superior:");

        txt_codigoPlanoReferencialSuperior.setEditable(false);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Nível:");

        txt_nivel.setEditable(false);
        try {
            txt_nivel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_nivel.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Natureza:");

        txt_natureza.setEditable(false);
        try {
            txt_natureza.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_natureza.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Orientações:");

        txt_orientacoes.setEditable(false);
        txt_orientacoes.setColumns(20);
        txt_orientacoes.setLineWrap(true);
        txt_orientacoes.setRows(5);
        txt_orientacoes.setFocusable(false);
        jScrollPane1.setViewportView(txt_orientacoes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_descricaoPlanoReferencial)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_codigoPlanoReferencial1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_codigoPlanoReferencial2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_codigoPlanoReferencial3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_codigoPlanoReferencial4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_codigoPlanoReferencial5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_codigoPlanoReferencial6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bt_novo))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_dataFinal, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_dataInicial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_nivel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_tipoPlanoReferencial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_codigoPlanoReferencialSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_natureza, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 108, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel8});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel7, jLabel9});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_codigoPlanoReferencial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoPlanoReferencial2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoPlanoReferencial3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoPlanoReferencial4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoPlanoReferencial5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoPlanoReferencial6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_descricaoPlanoReferencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_tipoPlanoReferencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_codigoPlanoReferencialSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_nivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txt_natureza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 145, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, jLabel10, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, txt_codigoPlanoReferencial1, txt_codigoPlanoReferencial2, txt_codigoPlanoReferencial3, txt_codigoPlanoReferencial4, txt_codigoPlanoReferencial5, txt_codigoPlanoReferencial6, txt_codigoPlanoReferencialSuperior, txt_dataFinal, txt_dataInicial, txt_descricaoPlanoReferencial, txt_nivel, txt_tipoPlanoReferencial});

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
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_incluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_alterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_pesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_sair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_alterar, bt_incluir, bt_pesquisa, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        ReiniciaCampos();
        HabilitaCampos(true);
        if(Integer.parseInt(fc.FormataCampo(txt_codigoPlanoReferencial1.getText(), 1, 0)) != 0){
            PegaPlanoReferencial("N");
            if(dadosPlanoReferencial.isEmpty()){return;}
        }
        
        PegaNovoPlanoReferencial();
        
        if(bpref.nivel > 1){
            PegaPlanoReferencial("SN");
        }
        
        operacao = "I";
        txt_orientacoes.setEditable(true);
        dadosCount.clear();
        dadosCount = parametrosNS.dao.Consulta(sql);
        bpref.codigoPlanoReferencial = bpref.codigoPlanoReferencial.replace(".", "");
        switch(bpref.nivel){
            case 1: bpref.codigoPlanoReferencial1   = String.valueOf(Integer.parseInt(String.valueOf(dadosCount.get(0).get(0))) + 1);
                    if(bpref.codigoPlanoReferencial1.length() > 1){
                        Mensagem = "Impossível cadastrar novo Plano de Contas nível 1!\nLimite excedido!";
                        new MostraMensagem(Mensagem);
                        return;
                    }
                    txt_codigoPlanoReferencial1     .setText(fc.FormataCampo(String.valueOf(bpref.codigoPlanoReferencial1), 1, 0));
                    txt_descricaoPlanoReferencial   .grabFocus();
                    HabilitaBotoes(); break;
                    
            case 2: bpref.codigoPlanoReferencial2   = String.valueOf(Integer.parseInt(String.valueOf(dadosCount.get(dadosCount.size() - 1).get(2)).replace(".", "").substring(1, 3)) + 1);
                    if(bpref.codigoPlanoReferencial2.length() > 2){
                        Mensagem = "Impossível cadastrar novo Plano de Contas Nível 2!\nLimite excedido!";
                        new MostraMensagem(Mensagem);
                        return;
                    }
                    txt_codigoPlanoReferencial2     .setText(fc.FormataCampo(String.valueOf(bpref.codigoPlanoReferencial2), 2, 0));
                    txt_descricaoPlanoReferencial   .grabFocus();
                    txt_codigoPlanoReferencial2     .setEditable(true); 
                    HabilitaBotoes(); break;
                    
            case 3: bpref.codigoPlanoReferencial3   = String.valueOf(Integer.parseInt(  String.valueOf(dadosCount.get(dadosCount.size() - 1).get(2)).replace(".", "").substring(3, 5)) + 1);
                    if(bpref.codigoPlanoReferencial3.length() > 2){
                        Mensagem = "Impossível cadastrar novo Plano de Contas Nível 3!\nLimite excedido!";
                        new MostraMensagem(Mensagem);
                        return;
                    }
                    txt_codigoPlanoReferencial3     .setText(fc.FormataCampo(String.valueOf(bpref.codigoPlanoReferencial3), 2, 0));
                    txt_descricaoPlanoReferencial   .grabFocus();
                    txt_codigoPlanoReferencial3     .setEditable(true); 
                    HabilitaBotoes(); break;
                    
            case 4: bpref.codigoPlanoReferencial4   = String.valueOf(Integer.parseInt(  String.valueOf(dadosCount.get(dadosCount.size() - 1).get(2)).replace(".", "").substring(5, 7)) + 1);
                    if(bpref.codigoPlanoReferencial4.length() > 2){
                        Mensagem = "Impossível cadastrar novo Plano de Contas Nível 4!\nLimite excedido!";
                        new MostraMensagem(Mensagem);
                        return;
                    }
                    txt_codigoPlanoReferencial4     .setText(fc.FormataCampo(String.valueOf(bpref.codigoPlanoReferencial4), 2, 0));
                    txt_descricaoPlanoReferencial   .grabFocus();
                    txt_codigoPlanoReferencial4     .setEditable(true); 
                    HabilitaBotoes(); break;
                    
            case 5: bpref.codigoPlanoReferencial5   = String.valueOf(Integer.parseInt(  String.valueOf(dadosCount.get(dadosCount.size() - 1).get(2)).replace(".", "").substring(7, 9)) + 1);
                    if(bpref.codigoPlanoReferencial5.length() > 2){
                        Mensagem = "Impossível cadastrar novo Plano de Contas Nível 5!\nLimite excedido!";
                        new MostraMensagem(Mensagem);
                        return;
                    }
                    txt_codigoPlanoReferencial5     .setText(fc.FormataCampo(String.valueOf(bpref.codigoPlanoReferencial5), 2, 0));
                    txt_descricaoPlanoReferencial   .grabFocus();
                    txt_codigoPlanoReferencial5     .setEditable(true); 
                    HabilitaBotoes(); break;
                    
            case 6: bpref.codigoPlanoReferencial6   = String.valueOf(Integer.parseInt(  String.valueOf(dadosCount.get(dadosCount.size() - 1).get(2)).replace(".", "").substring(9, 11)) + 1);
                    if(bpref.codigoPlanoReferencial6.length() > 2){
                        Mensagem = "Impossível cadastrar novo Plano de Contas Nível 6!\nLimite excedido!";
                        new MostraMensagem(Mensagem);
                        return;
                    }
                    txt_codigoPlanoReferencial6     .setText(fc.FormataCampo(String.valueOf(bpref.codigoPlanoReferencial6), 2, 0));
                    txt_descricaoPlanoReferencial   .grabFocus();
                    txt_codigoPlanoReferencial6     .setEditable(true); 
                    HabilitaBotoes(); break;
        }
    }//GEN-LAST:event_bt_novoActionPerformed

    private void txt_codigoPlanoReferencial1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoReferencial1FocusGained
        if(txt_codigoPlanoReferencial1.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        operacao = "";
        HabilitaBotoes();
        txt_codigoPlanoReferencial2 .setText("");
        txt_codigoPlanoReferencial2 .setEditable(false);
        txt_codigoPlanoReferencial3 .setText("");
        txt_codigoPlanoReferencial3 .setEditable(false);
        txt_codigoPlanoReferencial4 .setText("");
        txt_codigoPlanoReferencial4 .setEditable(false);
        txt_codigoPlanoReferencial5 .setText("");
        txt_codigoPlanoReferencial5 .setEditable(false);
        txt_codigoPlanoReferencial6 .setText("");
        txt_codigoPlanoReferencial6 .setEditable(false);
        ReiniciaCampos();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoPlanoReferencial1FocusGained

    private void txt_codigoPlanoReferencial1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoReferencial1FocusLost
        if(txt_codigoPlanoReferencial1.isEditable() == false)
            return;
        if(txt_codigoPlanoReferencial1.getText().replace(" ", "").equals(""))
            return;
        if(Integer.parseInt(fc.FormataCampo(txt_codigoPlanoReferencial1.getText(), 1, 0)) == 0)
            return;
        txt_codigoPlanoReferencial1.setText(fc.FormataCampo(txt_codigoPlanoReferencial1.getText().replace(" ", ""), 1, 0));
    }//GEN-LAST:event_txt_codigoPlanoReferencial1FocusLost

    private void txt_codigoPlanoReferencial1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoPlanoReferencial1KeyReleased
        if(txt_codigoPlanoReferencial1.isEditable() == false)
            return;
        if(txt_codigoPlanoReferencial1.getText().replace(" ", "").equals(""))
            return;
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            PegaPlanoReferencial("S");
            txt_descricaoPlanoReferencial.grabFocus();
            return;
        }
        if(Integer.parseInt(fc.FormataCampo(txt_codigoPlanoReferencial1.getText(), 1, 0)) == 0)
            return;
        PegaPlanoReferencial("N");
        if(dadosPlanoReferencial.isEmpty())return;
        txt_codigoPlanoReferencial2.setEditable(true);
        txt_codigoPlanoReferencial2.setText("");
        txt_codigoPlanoReferencial2.grabFocus();
    }//GEN-LAST:event_txt_codigoPlanoReferencial1KeyReleased

    private void txt_codigoPlanoReferencial2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoReferencial2FocusGained
        if(txt_codigoPlanoReferencial2.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        operacao = "";
        HabilitaBotoes();
        txt_codigoPlanoReferencial3 .setText("");
        txt_codigoPlanoReferencial3 .setEditable(false);
        txt_codigoPlanoReferencial4 .setText("");
        txt_codigoPlanoReferencial4 .setEditable(false);
        txt_codigoPlanoReferencial5 .setText("");
        txt_codigoPlanoReferencial5 .setEditable(false);
        txt_codigoPlanoReferencial6 .setText("");
        txt_codigoPlanoReferencial6 .setEditable(false);
        ReiniciaCampos();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoPlanoReferencial2FocusGained

    private void txt_codigoPlanoReferencial2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoReferencial2FocusLost
        if(txt_codigoPlanoReferencial2.isEditable() == false)
            return;
        if(txt_codigoPlanoReferencial2.getText().replace(" ", "").equals(""))
            return;
        if(Integer.parseInt(fc.FormataCampo(txt_codigoPlanoReferencial2.getText(), 2, 0)) == 0)
            return;
        txt_codigoPlanoReferencial2.setText(fc.FormataCampo(txt_codigoPlanoReferencial2.getText().replace(" ", ""), 2, 0));
    }//GEN-LAST:event_txt_codigoPlanoReferencial2FocusLost

    private void txt_codigoPlanoReferencial2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoPlanoReferencial2KeyReleased
        if(txt_codigoPlanoReferencial2.isEditable() == false)
            return;
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            PegaPlanoReferencial("S");
            txt_descricaoPlanoReferencial.grabFocus();
            return;
        }
        if(txt_codigoPlanoReferencial2.getText().replace(" ", "").length() < 2)
            return;
        if(Integer.parseInt(fc.FormataCampo(txt_codigoPlanoReferencial2.getText(), 2, 0)) == 0)
            return;
        PegaPlanoReferencial("N");
        if(dadosPlanoReferencial.isEmpty())return;
        txt_codigoPlanoReferencial3.setEditable(true);
        txt_codigoPlanoReferencial3.setText("");
        txt_codigoPlanoReferencial3.grabFocus();
    }//GEN-LAST:event_txt_codigoPlanoReferencial2KeyReleased

    private void txt_codigoPlanoReferencial3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoReferencial3FocusGained
        if(txt_codigoPlanoReferencial3.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        operacao = "";
        HabilitaBotoes();
        txt_codigoPlanoReferencial4 .setText("");
        txt_codigoPlanoReferencial4 .setEditable(false);
        txt_codigoPlanoReferencial5 .setText("");
        txt_codigoPlanoReferencial5 .setEditable(false);
        txt_codigoPlanoReferencial6 .setText("");
        txt_codigoPlanoReferencial6 .setEditable(false);
        ReiniciaCampos();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoPlanoReferencial3FocusGained

    private void txt_codigoPlanoReferencial3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoReferencial3FocusLost
        if(txt_codigoPlanoReferencial3.isEditable() == false)
            return;
        if(txt_codigoPlanoReferencial3.getText().replace(" ", "").equals(""))
            return;
        if(Integer.parseInt(fc.FormataCampo(txt_codigoPlanoReferencial3.getText(), 2, 0)) == 0)
            return;
        txt_codigoPlanoReferencial3.setText(fc.FormataCampo(txt_codigoPlanoReferencial3.getText().replace(" ", ""), 2, 0));
    }//GEN-LAST:event_txt_codigoPlanoReferencial3FocusLost

    private void txt_codigoPlanoReferencial3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoPlanoReferencial3KeyReleased
        if(txt_codigoPlanoReferencial3.isEditable() == false)
            return;
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            PegaPlanoReferencial("S");
            txt_descricaoPlanoReferencial.grabFocus();
            return;
        }
        if(txt_codigoPlanoReferencial3.getText().replace(" ", "").length() < 2)
            return;
        if(Integer.parseInt(fc.FormataCampo(txt_codigoPlanoReferencial3.getText(), 2, 0)) == 0)
            return;
        PegaPlanoReferencial("N");
        if(dadosPlanoReferencial.isEmpty())return;
        txt_codigoPlanoReferencial4.setEditable(true);
        txt_codigoPlanoReferencial4.setText("");
        txt_codigoPlanoReferencial4.grabFocus();
    }//GEN-LAST:event_txt_codigoPlanoReferencial3KeyReleased

    private void txt_codigoPlanoReferencial4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoReferencial4FocusGained
        if(txt_codigoPlanoReferencial4.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        operacao = "";
        HabilitaBotoes();
        txt_codigoPlanoReferencial5 .setText("");
        txt_codigoPlanoReferencial5 .setEditable(false);
        txt_codigoPlanoReferencial6 .setText("");
        txt_codigoPlanoReferencial6 .setEditable(false);
        ReiniciaCampos();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoPlanoReferencial4FocusGained

    private void txt_codigoPlanoReferencial4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoReferencial4FocusLost
        if(txt_codigoPlanoReferencial4.isEditable() == false)
            return;
        if(txt_codigoPlanoReferencial4.getText().replace(" ", "").equals(""))
            return;
        if(Integer.parseInt(fc.FormataCampo(txt_codigoPlanoReferencial4.getText(), 2, 0)) == 0)
            return;
        txt_codigoPlanoReferencial4.setText(fc.FormataCampo(txt_codigoPlanoReferencial4.getText().replace(" ", ""), 2, 0));
    }//GEN-LAST:event_txt_codigoPlanoReferencial4FocusLost

    private void txt_codigoPlanoReferencial4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoPlanoReferencial4KeyReleased
        if(txt_codigoPlanoReferencial4.isEditable() == false)
            return;
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            PegaPlanoReferencial("S");
            txt_descricaoPlanoReferencial.grabFocus();
            return;
        }
        if(txt_codigoPlanoReferencial4.getText().replace(" ", "").length() < 2)
            return;
        if(Integer.parseInt(fc.FormataCampo(txt_codigoPlanoReferencial4.getText(), 2, 0)) == 0)
            return;
        PegaPlanoReferencial("N");
        if(dadosPlanoReferencial.isEmpty())return;
        txt_codigoPlanoReferencial5.setEditable(true);
        txt_codigoPlanoReferencial5.setText("");
        txt_codigoPlanoReferencial5.grabFocus();
    }//GEN-LAST:event_txt_codigoPlanoReferencial4KeyReleased

    private void txt_codigoPlanoReferencial5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoReferencial5FocusGained
        if(txt_codigoPlanoReferencial5.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        operacao = "";
        HabilitaBotoes();
        txt_codigoPlanoReferencial6 .setText("");
        txt_codigoPlanoReferencial6 .setEditable(false);
        ReiniciaCampos();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoPlanoReferencial5FocusGained

    private void txt_codigoPlanoReferencial5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoReferencial5FocusLost
        if(txt_codigoPlanoReferencial5.isEditable() == false)
            return;
        if(txt_codigoPlanoReferencial5.getText().replace(" ", "").equals(""))
            return;
        if(Integer.parseInt(fc.FormataCampo(txt_codigoPlanoReferencial5.getText(), 2, 0)) == 0)
            return;
        txt_codigoPlanoReferencial5.setText(fc.FormataCampo(txt_codigoPlanoReferencial5.getText().replace(" ", ""), 2, 0));
    }//GEN-LAST:event_txt_codigoPlanoReferencial5FocusLost

    private void txt_codigoPlanoReferencial5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoPlanoReferencial5KeyReleased
        if(txt_codigoPlanoReferencial5.isEditable() == false)
            return;
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            PegaPlanoReferencial("S");
            txt_descricaoPlanoReferencial.grabFocus();
            return;
        }
        if(txt_codigoPlanoReferencial5.getText().replace(" ", "").length() < 2)
            return;
        if(Integer.parseInt(fc.FormataCampo(txt_codigoPlanoReferencial5.getText(), 2, 0)) == 0)
            return;
        PegaPlanoReferencial("N");
        if(Integer.parseInt(String.valueOf(dadosPlanoReferencial.get(0).get(8))) == 5){
            if(String.valueOf(dadosPlanoReferencial.get(0).get(6)).equals("A")){
                PegaPlanoReferencial("S");
                txt_descricaoPlanoReferencial.grabFocus();
                return;
            }
        }
        if(dadosPlanoReferencial.isEmpty())return;
        txt_codigoPlanoReferencial6.setEditable(true);
        txt_codigoPlanoReferencial6.setText("");
        txt_codigoPlanoReferencial6.grabFocus();
    }//GEN-LAST:event_txt_codigoPlanoReferencial5KeyReleased

    private void txt_codigoPlanoReferencial6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoReferencial6FocusGained
        if(txt_codigoPlanoReferencial6.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        operacao = "";
        HabilitaBotoes();
        ReiniciaCampos();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoPlanoReferencial6FocusGained

    private void txt_codigoPlanoReferencial6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoReferencial6FocusLost
        if(txt_codigoPlanoReferencial6.isEditable() == false)
            return;
        PegaPlanoReferencial("S");
    }//GEN-LAST:event_txt_codigoPlanoReferencial6FocusLost

    private void txt_codigoPlanoReferencial6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoPlanoReferencial6KeyReleased
        if(txt_codigoPlanoReferencial6.isEditable() == false)
            return;
        if(txt_codigoPlanoReferencial6.getText().replace(" ", "").length() < 2)
            if(evt.getKeyCode() != KeyEvent.VK_ENTER)
                return;
        txt_descricaoPlanoReferencial.grabFocus();
    }//GEN-LAST:event_txt_codigoPlanoReferencial6KeyReleased

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "insert into ns_plano_referencial (codigoGrupo, codigoPlanoReferencial, descricaoPlanoReferencial, dataInicial, dataFinal, tipoPlanoReferencial, codigoPlanoReferencialSuperior, nivel, natureza, orientacoes) "
            + "values (" + bpref.codigoGrupo + ", '" + bpref.codigoPlanoReferencial + "', '" + bpref.descricaoPlanoReferencial + "', '" + bpref.dataInicial + "', " + bpref.dataFinal + ", '" + bpref.tipoPlanoReferencial + "', '" + bpref.codigoPlanoReferencialSuperior + "', " + bpref.nivel + ", " + bpref.natureza + ", '" + bpref.orientacoes + "');";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            Mensagem = "Erro ao incluir Plano Referencial n°" + bpref.codigoPlanoReferencial + "!";
            new MostraMensagem(Mensagem);
            return;
        }
        txt_codigoPlanoReferencial1.grabFocus();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql =  "update ns_plano_referencial set descricaoPlanoReferencial = '"              + bpref.descricaoPlanoReferencial       + "', "
                                                            + "orientacoes = '"             + bpref.orientacoes                     + "' "
                                                            + "where idPlanoReferencial = " + bpref.idPlanoReferencial              + " and "
                                                            + "codigoGrupo = "              + bpref.codigoGrupo     + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000")){
            Mensagem = "Erro ao alterar Plano Referencial n°" + bpref.codigoPlanoReferencial + "!";
            new MostraMensagem(Mensagem);
            return;
        }
        txt_codigoPlanoReferencial1.grabFocus();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ReiniciaCampos();
        HabilitaCampos(false);
        txt_codigoPlanoReferencial1.grabFocus();
        if(somostra.equals("S")){
            txt_codigoPlanoReferencial1 .setEditable(false);
            bt_novo                     .setEnabled (false);
            bt_incluir                  .setVisible (false);
            bt_alterar                  .setVisible (false);
            bt_pesquisa                 .setVisible (false);
        }
        if(somostra.equals("SN"))bt_pesquisa.setVisible(false);
        if(!bpref.codigoPlanoReferencial.equals("")){
            bpref.RecarregaCodigosPlanoReferencial();
            txt_codigoPlanoReferencial1 .setText(fc.FormataCampo(bpref.codigoPlanoReferencial1, 1, 0));
            if(!bpref.codigoPlanoReferencial2.equals("")){txt_codigoPlanoReferencial2 .setText(fc.FormataCampo(bpref.codigoPlanoReferencial2, 2, 0));}
            if(!bpref.codigoPlanoReferencial3.equals("")){txt_codigoPlanoReferencial3 .setText(fc.FormataCampo(bpref.codigoPlanoReferencial3, 2, 0));}
            if(!bpref.codigoPlanoReferencial4.equals("")){txt_codigoPlanoReferencial4 .setText(fc.FormataCampo(bpref.codigoPlanoReferencial4, 2, 0));}
            if(!bpref.codigoPlanoReferencial5.equals("")){txt_codigoPlanoReferencial5 .setText(fc.FormataCampo(bpref.codigoPlanoReferencial5, 2, 0));}
            if(!bpref.codigoPlanoReferencial6.equals("")){txt_codigoPlanoReferencial6 .setText(fc.FormataCampo(bpref.codigoPlanoReferencial6, 2, 0));}
            PegaPlanoReferencial("S");
        }
    }//GEN-LAST:event_formWindowOpened

    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
    }//GEN-LAST:event_formWindowGainedFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisa;
    private javax.swing.JButton bt_sair;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField txt_codigoPlanoReferencial1;
    private javax.swing.JFormattedTextField txt_codigoPlanoReferencial2;
    private javax.swing.JFormattedTextField txt_codigoPlanoReferencial3;
    private javax.swing.JFormattedTextField txt_codigoPlanoReferencial4;
    private javax.swing.JFormattedTextField txt_codigoPlanoReferencial5;
    private javax.swing.JFormattedTextField txt_codigoPlanoReferencial6;
    private javax.swing.JTextField txt_codigoPlanoReferencialSuperior;
    private javax.swing.JFormattedTextField txt_dataFinal;
    private javax.swing.JFormattedTextField txt_dataInicial;
    private javax.swing.JTextField txt_descricaoPlanoReferencial;
    private javax.swing.JFormattedTextField txt_natureza;
    private javax.swing.JFormattedTextField txt_nivel;
    private javax.swing.JTextArea txt_orientacoes;
    private javax.swing.JFormattedTextField txt_tipoPlanoReferencial;
    // End of variables declaration//GEN-END:variables
    
    private void ReiniciaCampos(){
        txt_descricaoPlanoReferencial       .setText("");
        txt_dataInicial                     .setText(cdh.CapturarData());
        txt_dataFinal                       .setText("");
        txt_tipoPlanoReferencial            .setText("");
        txt_codigoPlanoReferencialSuperior  .setText("");
        txt_nivel                           .setText("");
        txt_natureza                        .setText("");
        txt_orientacoes                     .setText("");
    }
    
    private void HabilitaCampos(boolean Habilita){
        txt_descricaoPlanoReferencial       .setEditable    (Habilita);
        txt_descricaoPlanoReferencial       .setFocusable   (Habilita);
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
    
    private void PegaNovoPlanoReferencial(){
        bpref.codigoPlanoReferencial1   = txt_codigoPlanoReferencial1.getText().replace(" ", "");
        bpref.codigoPlanoReferencial2   = txt_codigoPlanoReferencial2.getText().replace(" ", "");
        bpref.codigoPlanoReferencial3   = txt_codigoPlanoReferencial3.getText().replace(" ", "");
        bpref.codigoPlanoReferencial4   = txt_codigoPlanoReferencial4.getText().replace(" ", "");
        bpref.codigoPlanoReferencial5   = txt_codigoPlanoReferencial5.getText().replace(" ", "");
        bpref.codigoPlanoReferencial6   = txt_codigoPlanoReferencial6.getText().replace(" ", "");
        bpref.RecarregaPlanoReferencial();
        bpref.codigoPlanoReferencial    = bpref.codigoPlanoReferencial.replace(".", "");
        
        if(bpref.codigoPlanoReferencial1.equals("")){
            bpref.nivel = 1;
            sql = "select count(*) from ns_plano_referencial where (codigoGrupo = 0 or codigoGrupo = " + parametrosNS.bge.CodigoGrupo + ") and nivel = " + bpref.nivel + " and codigoPlanoReferencialSuperior is null order by codigoPlanoReferencial asc;";
            return;
        }
        if(bpref.codigoPlanoReferencial2.equals("")){
            bpref.nivel = 2;
            bpref.codigoPlanoReferencial            = bpref.codigoPlanoReferencial.substring(0, 1);
            sql = "select * from ns_plano_referencial where (codigoGrupo = 0 or codigoGrupo = " + parametrosNS.bge.CodigoGrupo + ") and nivel = " + bpref.nivel + " and replace(substring(codigoPlanoReferencial, 1, 1), '.','') = " + bpref.codigoPlanoReferencial + " order by codigoPlanoReferencial asc;" ;
            return;
        }
        if(bpref.codigoPlanoReferencial3.equals("")){
            bpref.nivel = 3;
            bpref.codigoPlanoReferencial            = bpref.codigoPlanoReferencial.substring(0, 3);
            sql = "select * from ns_plano_referencial where (codigoGrupo = 0 or codigoGrupo = " + parametrosNS.bge.CodigoGrupo + ") and nivel = " + bpref.nivel + " and replace(substring(codigoPlanoReferencial, 1, 4), '.','') = " + bpref.codigoPlanoReferencial + " order by codigoPlanoReferencial asc;" ;
            return;
        }
        if(bpref.codigoPlanoReferencial4.equals("")){
            bpref.nivel = 4;
            bpref.codigoPlanoReferencial            = bpref.codigoPlanoReferencial.substring(0, 5);
            sql = "select * from ns_plano_referencial where (codigoGrupo = 0 or codigoGrupo = " + parametrosNS.bge.CodigoGrupo + ") and nivel = " + bpref.nivel + " and replace(substring(codigoPlanoReferencial, 1, 7), '.','') = " + bpref.codigoPlanoReferencial + " order by codigoPlanoReferencial asc;" ;
            return;
        }
        if(bpref.codigoPlanoReferencial5.equals("")){
            bpref.nivel = 5;
            bpref.codigoPlanoReferencial            = bpref.codigoPlanoReferencial.substring(0, 7);
            sql = "select * from ns_plano_referencial where (codigoGrupo = 0 or codigoGrupo = " + parametrosNS.bge.CodigoGrupo + ") and nivel = " + bpref.nivel + " and replace(substring(codigoPlanoReferencial, 1,10), '.','') = " + bpref.codigoPlanoReferencial + " order by codigoPlanoReferencial asc;" ;
            return;
        }
        if(bpref.codigoPlanoReferencial6.equals("")){
            bpref.nivel = 6;
            bpref.codigoPlanoReferencial            = bpref.codigoPlanoReferencial.substring(0, 9);
            sql = "select * from ns_plano_referencial where (codigoGrupo = 0 or codigoGrupo = " + parametrosNS.bge.CodigoGrupo + ") and nivel = " + bpref.nivel + " and replace(substring(codigoPlanoReferencial, 1,13), '.','') = " + bpref.codigoPlanoReferencial + " order by codigoPlanoReferencial asc;" ;
            return;
        }
    }
    
    private void PegaPlanoReferencial(String Mostra){
        bpref.codigoPlanoReferencial1   = txt_codigoPlanoReferencial1.getText().replace(" ", "");
        bpref.codigoPlanoReferencial2   = txt_codigoPlanoReferencial2.getText().replace(" ", "");
        bpref.codigoPlanoReferencial3   = txt_codigoPlanoReferencial3.getText().replace(" ", "");
        bpref.codigoPlanoReferencial4   = txt_codigoPlanoReferencial4.getText().replace(" ", "");
        bpref.codigoPlanoReferencial5   = txt_codigoPlanoReferencial5.getText().replace(" ", "");
        bpref.codigoPlanoReferencial6   = txt_codigoPlanoReferencial6.getText().replace(" ", "");
        
        if(!Mostra.equals("SN")){
            bpref.nivel = 6;
            if(bpref.codigoPlanoReferencial6.equals(""))bpref.nivel = 5;
            if(bpref.codigoPlanoReferencial5.equals(""))bpref.nivel = 4;
            if(bpref.codigoPlanoReferencial4.equals(""))bpref.nivel = 3;
            if(bpref.codigoPlanoReferencial3.equals(""))bpref.nivel = 2;
            if(bpref.codigoPlanoReferencial2.equals(""))bpref.nivel = 1;
            bpref.RecarregaPlanoReferencial();
        }
        
        if(bpref.codigoPlanoReferencial1.equals(""))Mostra = "S";
        if(bpref.codigoPlanoReferencial2.equals("")){txt_codigoPlanoReferencial2.setEditable(false);txt_codigoPlanoReferencial2.setText("");}
        if(bpref.codigoPlanoReferencial3.equals("")){txt_codigoPlanoReferencial3.setEditable(false);txt_codigoPlanoReferencial3.setText("");}
        if(bpref.codigoPlanoReferencial4.equals("")){txt_codigoPlanoReferencial4.setEditable(false);txt_codigoPlanoReferencial4.setText("");}
        if(bpref.codigoPlanoReferencial5.equals("")){txt_codigoPlanoReferencial5.setEditable(false);txt_codigoPlanoReferencial5.setText("");}
        if(bpref.codigoPlanoReferencial6.equals("")){txt_codigoPlanoReferencial6.setEditable(false);txt_codigoPlanoReferencial6.setText("");}
        
//        sql = "select * from ns_plano_referencial where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and replace(codigoPlanoReferencial, '.', '') = '" + bpref.codigoPlanoReferencial + "';";
        if(!Mostra.equals("SN")){
            sql = "select * from ns_plano_referencial where (codigoGrupo = 0 or codigoGrupo = " + parametrosNS.bge.CodigoGrupo + ") and codigoPlanoReferencial = '" + bpref.codigoPlanoReferencial + "';";
        }
        dadosPlanoReferencial.clear();
        dadosPlanoReferencial = parametrosNS.dao.Consulta(sql);
        if(Mostra.equals("N"))return;
        if(dadosPlanoReferencial.isEmpty()){
            Mensagem = "Plano De Contas Referencial n°" + bpref.codigoPlanoReferencial + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        HabilitaCampos(true);
        PegaDadosPlanoReferencial(Mostra);
    }
    
    private void PegaDadosPlanoReferencial(String Mostra){
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
        if(Mostra.equals("SN"))return;
        txt_descricaoPlanoReferencial       .setText(bpref.descricaoPlanoReferencial);
        txt_dataInicial                     .setText(invdata.inverterData(bpref.dataInicial, 1));
        txt_dataFinal                       .setText(invdata.inverterData(bpref.dataFinal  , 1));
        txt_tipoPlanoReferencial            .setText(bpref.tipoPlanoReferencial);
        bpref.RecarregaCodigosPlanoReferencialSuperior();
        bpref.RecarregaPlanoReferencialSuperior();
        txt_codigoPlanoReferencialSuperior  .setText(bpref.codigoPlanoReferencialSuperior);
        txt_nivel                           .setText(fc.FormataCampo(String.valueOf(bpref.nivel), 1, 0));
        txt_natureza                        .setText(fc.FormataCampo(String.valueOf(bpref.natureza), 1, 0));
        if(bpref.codigoGrupo == parametrosNS.bge.CodigoGrupo)
            txt_orientacoes.setEditable(true);
        else
            txt_orientacoes.setEditable(false);
        txt_orientacoes                     .setText(bpref.orientacoes);
        if(bpref.codigoGrupo == 0)return;
        operacao = "A";
        HabilitaBotoes();
    }
    
    private void PegaValores(){
        bpref.codigoGrupo = parametrosNS.bge.CodigoGrupo;
        
        bpref.codigoPlanoReferencial1               = txt_codigoPlanoReferencial1.getText().replace(" ", "");
        bpref.codigoPlanoReferencial2               = txt_codigoPlanoReferencial2.getText().replace(" ", "");
        bpref.codigoPlanoReferencial3               = txt_codigoPlanoReferencial3.getText().replace(" ", "");
        bpref.codigoPlanoReferencial4               = txt_codigoPlanoReferencial4.getText().replace(" ", "");
        bpref.codigoPlanoReferencial5               = txt_codigoPlanoReferencial5.getText().replace(" ", "");
        bpref.codigoPlanoReferencial6               = txt_codigoPlanoReferencial6.getText().replace(" ", "");
        
        bpref.nivel = 6;
        if(bpref.codigoPlanoReferencial6.equals(""))bpref.nivel = 5;
        if(bpref.codigoPlanoReferencial5.equals(""))bpref.nivel = 4;
        if(bpref.codigoPlanoReferencial4.equals(""))bpref.nivel = 3;
        if(bpref.codigoPlanoReferencial3.equals(""))bpref.nivel = 2;
        if(bpref.codigoPlanoReferencial2.equals(""))bpref.nivel = 1;
        bpref.RecarregaPlanoReferencial();
        bpref.RecarregaPlanoReferencialSuperior();
        
        if(bpref.codigoPlanoReferencialSuperior.equals(""))
            bpref.codigoPlanoReferencialSuperior = null;
        
        if(Integer.parseInt(bpref.codigoPlanoReferencial.replace(".", "").substring(0, 1)) < 3){
            if(bpref.codigoPlanoReferencial.replace(".", "").length() <  8)bpref.tipoPlanoReferencial = "S";
            if(bpref.codigoPlanoReferencial.replace(".", "").length() >  7)bpref.tipoPlanoReferencial = "A";
        }else{
            if(bpref.codigoPlanoReferencial.replace(".", "").length() < 10)bpref.tipoPlanoReferencial = "S";
            if(bpref.codigoPlanoReferencial.replace(".", "").length() >  9)bpref.tipoPlanoReferencial = "A";
        }
        bpref.descricaoPlanoReferencial             = txt_descricaoPlanoReferencial.getText();
        if(bpref.descricaoPlanoReferencial.equals("")){
            Mensagem = "Descrição do Plano Referencial Inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bpref.dataInicial                           = invdata.inverterData(txt_dataInicial.getText(), 2);
        bpref.dataFinal                             = null;
        bpref.natureza                              = 0;
        bpref.orientacoes                           = txt_orientacoes.getText();
    }
    
}
