package Telas;

import BeansNS.BeanBancoDados;
import BeansNS.BeanEmpresas;
import Beans.*;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.TestarData;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/*
 @author Paulo e Tiago
 */
public class UsuariosConsulta extends javax.swing.JFrame {
    //String's
    String valorLogin                   = "";
    String Tipo                         = "";
    String retorno                      = "";
    String sql                          = "";
    String sqlstate                     = "";
    String Mensagem                     = "";
    String texto                        = "";
    String Campo                        = "";
    String somostra                     = "";
    String NivelUsuario                 = "";
    
    //Vetores
    ArrayList            parametros                = new ArrayList();
    ArrayList            dadosPadroes              = new ArrayList();
    ArrayList<ArrayList> dadosDepartamentos        = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosUsuario              = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosUsuarioEmail         = new ArrayList<ArrayList>();
    
    //Bean's
    BeanBancoDados          bbd         = new BeanBancoDados();
    BeanDepartamento        bd          = new BeanDepartamento();
    BeanEmpresas            be          = new BeanEmpresas();
    BeanIntervalos          binter      = new BeanIntervalos();
    BeanUsuarios            bu          = new BeanUsuarios();
    BeanUsuariosEmail       bue         = new BeanUsuariosEmail();
    
    //int's
    int      linha                      = 0;
    int      index                      = 0;
    int      User                       = 0;
    int      nivelusuario               = 0;
    int      abriuDepartamento          = 0;
    
    //Outros
    DefaultTableModel Table;
    
    //Especiais
    FormataCampo            fc          = new FormataCampo();
    CapturarDataHora        cdh         = new CapturarDataHora();
    TestarData              Test        = new TestarData();
    InverterData            invdata     = new InverterData();
    
    //Telas
    UsuariosCadastro            CadUsu;
    DepartamentosConsulta       ConDep;
    
    public UsuariosConsulta(ArrayList DadosPadroes){
        dadosPadroes                    = DadosPadroes;
        
        somostra                        = (String)  dadosPadroes.get(0);
        
        initComponents();
    }
    
    private void InicializaCampos(){
        txt_codigoInicial       .setText(fc.FormataCampo("", 3, 0));
        txt_codigoFinal         .setText("999");
        txt_dataCadastroInicial .setText(fc.FormataCampo("", 10, 2));
        txt_dataCadastroFinal   .setText("99999999");
        combo_nivelInicial      .setSelectedIndex(0);
        combo_nivelFinal        .setSelectedIndex(4);
        txt_departamentoInicial .setText(fc.FormataCampo("", 2, 0));
        txt_departamentoFinal   .setText("99");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_detalhesItem = new javax.swing.JMenuItem();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_resultadoPesquisa = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        bt_sair = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_departamentoInicial = new javax.swing.JFormattedTextField();
        txt_departamentoFinal = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_dataCadastroInicial = new javax.swing.JFormattedTextField();
        txt_dataCadastroFinal = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        bt_pesquisaDepartamentoInicial = new javax.swing.JButton();
        bt_pesquisaDepartamentoFinal = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        combo_nivelInicial = new javax.swing.JComboBox();
        combo_nivelFinal = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txt_codigoInicial = new javax.swing.JFormattedTextField();
        txt_codigoFinal = new javax.swing.JFormattedTextField();
        bt_processa = new javax.swing.JButton();

        bt_detalhesItem.setText("Detalhes");
        bt_detalhesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_detalhesItemActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_detalhesItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("::Consultar Usuários");
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

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_resultadoPesquisa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_resultadoPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data de Cadastro", "Nome", "Departamento", "Telefone", "Nível de Usuário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_resultadoPesquisa.getTableHeader().setResizingAllowed(false);
        tabela_resultadoPesquisa.getTableHeader().setReorderingAllowed(false);
        tabela_resultadoPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_resultadoPesquisaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabela_resultadoPesquisa);
        if (tabela_resultadoPesquisa.getColumnModel().getColumnCount() > 0) {
            tabela_resultadoPesquisa.getColumnModel().getColumn(0).setResizable(false);
            tabela_resultadoPesquisa.getColumnModel().getColumn(1).setResizable(false);
            tabela_resultadoPesquisa.getColumnModel().getColumn(1).setPreferredWidth(150);
            tabela_resultadoPesquisa.getColumnModel().getColumn(2).setResizable(false);
            tabela_resultadoPesquisa.getColumnModel().getColumn(2).setPreferredWidth(300);
            tabela_resultadoPesquisa.getColumnModel().getColumn(3).setResizable(false);
            tabela_resultadoPesquisa.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabela_resultadoPesquisa.getColumnModel().getColumn(4).setResizable(false);
            tabela_resultadoPesquisa.getColumnModel().getColumn(4).setPreferredWidth(100);
            tabela_resultadoPesquisa.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Usuários");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Usuários cadastrados");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Inicial");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Final");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Departamento: ");

        try {
            txt_departamentoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_departamentoInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_departamentoInicial.setText("00");
        txt_departamentoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_departamentoInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_departamentoInicialFocusLost(evt);
            }
        });
        txt_departamentoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_departamentoInicialKeyPressed(evt);
            }
        });

        try {
            txt_departamentoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_departamentoFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_departamentoFinal.setText("99");
        txt_departamentoFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_departamentoFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_departamentoFinalFocusLost(evt);
            }
        });
        txt_departamentoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_departamentoFinalKeyPressed(evt);
            }
        });

        jLabel7.setText("Data de Cadastro: ");

        try {
            txt_dataCadastroInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataCadastroInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataCadastroInicial.setText("00/00/0000");
        txt_dataCadastroInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataCadastroInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataCadastroInicialFocusLost(evt);
            }
        });
        txt_dataCadastroInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataCadastroInicialKeyPressed(evt);
            }
        });

        try {
            txt_dataCadastroFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataCadastroFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataCadastroFinal.setText("99/99/9999");
        txt_dataCadastroFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataCadastroFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataCadastroFinalFocusLost(evt);
            }
        });
        txt_dataCadastroFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataCadastroFinalKeyPressed(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Inicial");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Final");

        bt_pesquisaDepartamentoInicial.setText("...");
        bt_pesquisaDepartamentoInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaDepartamentoInicialActionPerformed(evt);
            }
        });

        bt_pesquisaDepartamentoFinal.setText("...");
        bt_pesquisaDepartamentoFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaDepartamentoFinalActionPerformed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Nível: ");

        combo_nivelInicial.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1 - Comum", "2 - Chefe", "3 - Gerente", "4 - Diretor", "9 - Mestre" }));
        combo_nivelInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo_nivelInicialKeyPressed(evt);
            }
        });

        combo_nivelFinal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1 - Comum", "2 - Chefe", "3 - Gerente", "4 - Diretor", "9 - Mestre" }));
        combo_nivelFinal.setSelectedIndex(4);
        combo_nivelFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo_nivelFinalKeyPressed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Código: ");

        try {
            txt_codigoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoInicial.setText("000");
        txt_codigoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoInicialFocusLost(evt);
            }
        });
        txt_codigoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoInicialKeyPressed(evt);
            }
        });

        try {
            txt_codigoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoFinal.setText("999");
        txt_codigoFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoFinalFocusLost(evt);
            }
        });
        txt_codigoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoFinalKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_codigoInicial)
                    .addComponent(combo_nivelInicial, 0, 89, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combo_nivelFinal, 0, 89, Short.MAX_VALUE)
                    .addComponent(txt_codigoFinal)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_departamentoInicial)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_dataCadastroInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_pesquisaDepartamentoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_departamentoFinal)
                            .addComponent(txt_dataCadastroFinal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisaDepartamentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel7});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel8, jLabel9, txt_dataCadastroFinal, txt_dataCadastroInicial});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_codigoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(combo_nivelInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(txt_codigoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txt_dataCadastroInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_dataCadastroFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_nivelFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_departamentoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(bt_pesquisaDepartamentoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_departamentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bt_pesquisaDepartamentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaDepartamentoFinal, bt_pesquisaDepartamentoInicial, combo_nivelFinal, combo_nivelInicial, jLabel1, jLabel10, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, txt_codigoFinal, txt_codigoInicial, txt_dataCadastroFinal, txt_dataCadastroInicial, txt_departamentoFinal, txt_departamentoInicial});

        bt_processa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/1280454766_system-software-update.png"))); // NOI18N
        bt_processa.setText("Processa");
        bt_processa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_processaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_processa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_sair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_sair)
                    .addComponent(bt_processa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    void tabela_resultadoPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_resultadoPesquisaMouseClicked
        linha = tabela_resultadoPesquisa.getSelectedRow();
        retorno = String.valueOf(Integer.parseInt(String.valueOf(tabela_resultadoPesquisa.getValueAt(linha, 0))));
        if(evt.getButton() == MouseEvent.BUTTON3)
            if(somostra.equalsIgnoreCase("N"))
                MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
        if(evt.getClickCount() < 2)
            return;
        dispose();
    }//GEN-LAST:event_tabela_resultadoPesquisaMouseClicked

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_processaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_processaActionPerformed
        PegaValores();
    }//GEN-LAST:event_bt_processaActionPerformed

    private void txt_dataCadastroInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataCadastroInicialFocusLost
        txt_dataCadastroInicial.setText(fc.FormataCampo(txt_dataCadastroInicial.getText(), 10, 2));
    }//GEN-LAST:event_txt_dataCadastroInicialFocusLost

    private void txt_dataCadastroFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataCadastroFinalFocusLost
        txt_dataCadastroFinal.setText(fc.FormataCampo(txt_dataCadastroFinal.getText(), 10, 2));
    }//GEN-LAST:event_txt_dataCadastroFinalFocusLost

    private void txt_departamentoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_departamentoInicialFocusLost
        txt_departamentoInicial.setText(fc.FormataCampo(txt_departamentoInicial.getText(), 2, 0));
    }//GEN-LAST:event_txt_departamentoInicialFocusLost

    private void txt_departamentoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_departamentoFinalFocusLost
        txt_departamentoFinal.setText(fc.FormataCampo(txt_departamentoFinal.getText(), 2, 0));
    }//GEN-LAST:event_txt_departamentoFinalFocusLost

    private void txt_dataCadastroInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataCadastroInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataCadastroFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataCadastroInicial.setText(fc.FormataCampo("", 10, 2));
            txt_dataCadastroFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataCadastroInicialKeyPressed

    private void txt_dataCadastroFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataCadastroFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            combo_nivelInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataCadastroFinal.setText(cdh.CapturarData());
            combo_nivelInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataCadastroFinalKeyPressed

    private void txt_departamentoInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_departamentoInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_departamentoFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_departamentoInicial.setText(fc.FormataCampo("", 2, 0));
            txt_departamentoFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_departamentoInicialKeyPressed

    private void txt_departamentoFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_departamentoFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            bt_processa.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_departamentoFinal.setText("99");
            bt_processa.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_departamentoFinalKeyPressed

    private void combo_nivelInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_nivelInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            combo_nivelFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            combo_nivelInicial.setSelectedIndex(0);
            combo_nivelFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_combo_nivelInicialKeyPressed

    private void combo_nivelFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_nivelFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_departamentoInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            combo_nivelFinal.setSelectedIndex(combo_nivelFinal.getItemCount());
            txt_departamentoInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_combo_nivelFinalKeyPressed

    private void bt_detalhesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesItemActionPerformed
        if(CadUsu != null)if(CadUsu.isVisible()){
            Mensagem = "Tela já Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("S");
        parametros.add("");
        parametros.add(Integer.parseInt(retorno));
        CadUsu = new UsuariosCadastro(parametros);
        CadUsu.setVisible(true);
    }//GEN-LAST:event_bt_detalhesItemActionPerformed

    private void txt_dataCadastroInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataCadastroInicialFocusGained
        txt_dataCadastroInicial.setSelectionStart(0);
        txt_dataCadastroInicial.setSelectionEnd  (txt_dataCadastroInicial.getText().length());
    }//GEN-LAST:event_txt_dataCadastroInicialFocusGained

    private void txt_dataCadastroFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataCadastroFinalFocusGained
        txt_dataCadastroFinal.setSelectionStart(0);
        txt_dataCadastroFinal.setSelectionEnd  (txt_dataCadastroFinal.getText().length());
    }//GEN-LAST:event_txt_dataCadastroFinalFocusGained

    private void txt_departamentoInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_departamentoInicialFocusGained
        txt_departamentoInicial.setSelectionStart(0);
        txt_departamentoInicial.setSelectionEnd  (txt_departamentoInicial.getText().length());
    }//GEN-LAST:event_txt_departamentoInicialFocusGained

    private void txt_departamentoFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_departamentoFinalFocusGained
        txt_departamentoFinal.setSelectionStart(0);
        txt_departamentoFinal.setSelectionEnd  (txt_departamentoFinal.getText().length());
    }//GEN-LAST:event_txt_departamentoFinalFocusGained

    private void txt_codigoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoInicialFocusLost
        txt_codigoInicial.setText(fc.FormataCampo(txt_codigoInicial.getText(), 3, 0));
    }//GEN-LAST:event_txt_codigoInicialFocusLost

    private void txt_codigoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFinalFocusLost
        txt_codigoFinal.setText(fc.FormataCampo(txt_codigoFinal.getText(), 3, 0));
    }//GEN-LAST:event_txt_codigoFinalFocusLost

    private void txt_codigoInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoInicial.setText(fc.FormataCampo("", 3, 0));
            txt_codigoFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoInicialKeyPressed

    private void txt_codigoFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataCadastroInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoFinal.setText("999");
            txt_dataCadastroInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoFinalKeyPressed

    private void txt_codigoInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoInicialFocusGained
        txt_codigoInicial.setSelectionStart(0);
        txt_codigoInicial.setSelectionEnd  (txt_codigoInicial.getText().length());
    }//GEN-LAST:event_txt_codigoInicialFocusGained

    private void txt_codigoFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFinalFocusGained
        txt_codigoFinal.setSelectionStart(0);
        txt_codigoFinal.setSelectionEnd  (txt_codigoFinal.getText().length());
    }//GEN-LAST:event_txt_codigoFinalFocusGained

    private void bt_pesquisaDepartamentoInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaDepartamentoInicialActionPerformed
        abriuDepartamento = 1;
        Campo = "I";
        AbreDepartamento();
    }//GEN-LAST:event_bt_pesquisaDepartamentoInicialActionPerformed

    private void bt_pesquisaDepartamentoFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaDepartamentoFinalActionPerformed
        abriuDepartamento = 1;
        Campo = "F";
        AbreDepartamento();
    }//GEN-LAST:event_bt_pesquisaDepartamentoFinalActionPerformed
    
    private void AbreDepartamento(){
        ConDep = new DepartamentosConsulta("S");
        ConDep.setVisible(true);
    }
    
    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
        if(abriuDepartamento == 0)
            return;
        abriuDepartamento = 0;
        retorno = ConDep.getRetorno();
        if(retorno.equals(""))
            return;
        if(Campo.equalsIgnoreCase("I")){
            txt_departamentoInicial.setText(fc.FormataCampo(retorno, 2, 0));
            return;
        }
        txt_departamentoFinal.setText(fc.FormataCampo(retorno, 2, 0));
    }//GEN-LAST:event_formWindowGainedFocus

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Table   = (DefaultTableModel)tabela_resultadoPesquisa.getModel();
        InicializaCampos();
        PegaValores();
    }//GEN-LAST:event_formWindowOpened
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_detalhesItem;
    private javax.swing.JButton bt_pesquisaDepartamentoFinal;
    private javax.swing.JButton bt_pesquisaDepartamentoInicial;
    private javax.swing.JButton bt_processa;
    private javax.swing.JButton bt_sair;
    private javax.swing.JComboBox combo_nivelFinal;
    private javax.swing.JComboBox combo_nivelInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabela_resultadoPesquisa;
    private javax.swing.JFormattedTextField txt_codigoFinal;
    private javax.swing.JFormattedTextField txt_codigoInicial;
    private javax.swing.JFormattedTextField txt_dataCadastroFinal;
    private javax.swing.JFormattedTextField txt_dataCadastroInicial;
    private javax.swing.JFormattedTextField txt_departamentoFinal;
    private javax.swing.JFormattedTextField txt_departamentoInicial;
    // End of variables declaration//GEN-END:variables

    public String getRetorno(){
        return retorno;
    }
    
    private void PegaValores(){
        binter.usuarioInicial           = Integer.parseInt(txt_codigoInicial.getText());
        binter.usuarioFinal             = Integer.parseInt(txt_codigoFinal.getText());
        if(binter.usuarioInicial > binter.usuarioFinal){
            Mensagem = "Usuário Inicial não pode ser maior do que Usuário Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        
        binter.dataCadastroInicial      = Test.Testa(txt_dataCadastroInicial.getText());
        binter.dataCadastroFinal        = Test.Testa(txt_dataCadastroFinal.getText());
        if(binter.dataCadastroInicial > binter.dataCadastroFinal){
            Mensagem = "Cadastro Inicial não pode ser maior do que Cadastrado Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        
        binter.departamentoInicial      = Integer.parseInt(txt_departamentoInicial.getText());
        binter.departamentoFinal        = Integer.parseInt(txt_departamentoFinal.getText());
        if(binter.departamentoInicial > binter.departamentoFinal){
            Mensagem = "Departamento Inicial não pode ser maior do que Departamento Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        
        binter.nivelInicial             = Integer.parseInt(String.valueOf(combo_nivelInicial.getSelectedItem()).substring(0, 1));
        binter.nivelFinal               = Integer.parseInt(String.valueOf(combo_nivelFinal.getSelectedItem()).substring(0, 1));
        if(binter.nivelInicial > binter.nivelFinal){
            Mensagem = "Nível Inicial não pode ser maior do que o Nível Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaUsuario();
    }
    
    private void PegaUsuario(){
        sql = "select \n"
            + "   idUsuario, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoUsuario, \n"
            + "   dataCriacao, \n"
            + "   nome, \n"
            + "   usuario, \n"
            + "   senha, \n"
            + "   telefone, \n"
            + "   codigoDepartamento, \n"
            + "   nivelUsuario, \n"
            + "   podeMudarEmpresa \n"
            + "from \n"
            + "   tb_usuarios where codigoGrupo = " + parametrosNS.bge.codigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and "
            + "      codigoUsuario between "              + binter.usuarioInicial         + " and "   + binter.usuarioFinal       + " and "
            + "      dataCriacao between "                + binter.dataCadastroInicial    + " and "   + binter.dataCadastroFinal  + " and "
            + "      codigodepartamento between "         + binter.departamentoInicial    + " and "   + binter.departamentoFinal  + " and "
            + "      nivelUsuario between "               + binter.nivelInicial           + " and "   + binter.nivelFinal         + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(sqlstate.equals("42S02")){
            dispose();
            return;
        }
        dadosUsuario.clear();
        dadosUsuario = parametrosNS.dao.Consulta(sql);
//        bt_exportar.setEnabled(true);
//        if(dadosUsuario.isEmpty())
//            bt_exportar.setEnabled(false);
        PegaDadosUsuario();
    }
             
    public void PegaDadosUsuario(){
        Table.setNumRows(0);
        for(int i = 0; i < dadosUsuario.size(); i++){
            bu = new BeanUsuarios();
            bu.idUsuario            = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(0)));
            bu.idEmpresa            = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(1)));
            bu.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(2)));
            bu.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(3)));
            bu.codigoUsuario        = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(4)));
            bu.dataCriacao          =                    String.valueOf(dadosUsuario.get(i).get(5));
            bu.nome                 =                    String.valueOf(dadosUsuario.get(i).get(6));
            bu.usuario              =                    String.valueOf(dadosUsuario.get(i).get(7));
            bu.senha                =                    String.valueOf(dadosUsuario.get(i).get(8));
            bu.telefone             =                    String.valueOf(dadosUsuario.get(i).get(9));
        if(dadosUsuario.get(i).get(10) != null)
            bu.codigoDepartamento   = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(10)));
        if(dadosUsuario.get(i).get(11) != null)
            bu.nivelUsuario         = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(11)));
        if(dadosUsuario.get(i).get(12) != null)
            bu.podeMudarEmpresa     = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(12)));
            
            bu.dataCriacao          = invdata.inverterData(bu.dataCriacao, 1);
            
            bd.codigoDepartamento   = bu.codigoDepartamento;
            PegaDepartamento();
            
            switch(bu.nivelUsuario){
                case 1: NivelUsuario = "1 - Comum"  ; break;
                case 2: NivelUsuario = "2 - Chefe"  ; break;
                case 3: NivelUsuario = "3 - Gerente"; break;
                case 4: NivelUsuario = "4 - Diretor"; break;
                case 9: NivelUsuario = "9 - Mestre" ; break;
            }
            
//            bue.idEmpresa       = bu.idEmpresa;
//            bue.codigoGrupo     = bu.codigoGrupo;
//            bue.codigoEmpresa   = bu.codigoEmpresa;
//            bue.codigoUsuario   = bu.codigoUsuario;
//            PegaUsuarioEmail();
            
            Table.addRow(new Object [] {fc.FormataCampo(String.valueOf(bu.codigoUsuario), 3, 0), bu.dataCriacao, bu.nome, fc.FormataCampo(String.valueOf(bu.codigoDepartamento), 2, 0) + " - " + bd.descricaoDepartamento, bu.telefone, bu.nivelUsuario + " - " + NivelUsuario});
        }
    }
    
    private void PegaUsuarioEmail(){
        sql = "select * from tb_usuarios_email where idEmpresa = " + bue.idEmpresa + " and codigoUsuario = " + bue.codigoUsuario + ";";
        dadosUsuarioEmail.clear();
        dadosUsuarioEmail = parametrosNS.dao.Consulta(sql);
        if(dadosUsuarioEmail.isEmpty())
            return;
        PegaDadosUsuarioEmail();
    }
    
    private void PegaDadosUsuarioEmail(){
        for(int i = 0; i < dadosUsuarioEmail.size(); i++){
            if(dadosUsuarioEmail.get(i).get(0)  != null){bue.idUsuarioEmail       = Integer.parseInt(  String.valueOf(dadosUsuarioEmail.get(i).get(0)));}
            if(dadosUsuarioEmail.get(i).get(1)  != null){bue.idEmpresa            = Integer.parseInt(  String.valueOf(dadosUsuarioEmail.get(i).get(1)));}
            if(dadosUsuarioEmail.get(i).get(2)  != null){bue.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosUsuarioEmail.get(i).get(2)));}
            if(dadosUsuarioEmail.get(i).get(3)  != null){bue.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosUsuarioEmail.get(i).get(3)));}
            if(dadosUsuarioEmail.get(i).get(4)  != null){bue.codigoUsuario        = Integer.parseInt(  String.valueOf(dadosUsuarioEmail.get(i).get(4)));}
            if(dadosUsuarioEmail.get(i).get(5)  != null){bue.servidorEmail        =                    String.valueOf(dadosUsuarioEmail.get(i).get(5));}
            if(dadosUsuarioEmail.get(i).get(6)  != null){bue.portaEmail           = Integer.parseInt(  String.valueOf(dadosUsuarioEmail.get(i).get(6)));}
            if(dadosUsuarioEmail.get(i).get(7)  != null){bue.usuarioServidorEmail =                    String.valueOf(dadosUsuarioEmail.get(i).get(7));}
            if(dadosUsuarioEmail.get(i).get(8)  != null){bue.senhaServidorEmail   =                    String.valueOf(dadosUsuarioEmail.get(i).get(8));}
            if(dadosUsuarioEmail.get(i).get(9)  != null){bue.email                =                    String.valueOf(dadosUsuarioEmail.get(i).get(9));}
            if(dadosUsuarioEmail.get(i).get(10) != null){bue.autenticacaoSSL      = Integer.parseInt(  String.valueOf(dadosUsuarioEmail.get(i).get(10)));}
        }
    }
    
    private void PegaDepartamento(){
        bd.descricaoDepartamento = "----------";
        sql = "select * from tb_departamento where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoDepartamento = " + bd.codigoDepartamento + ";";
        dadosDepartamentos.clear();
        dadosDepartamentos = parametrosNS.dao.Consulta(sql);
        if(dadosDepartamentos.isEmpty())
            return;
        PegaDadosDepartamento();
    }
    
    private void PegaDadosDepartamento(){
        for(int i = 0; i < dadosDepartamentos.size(); i++){
            bd = new BeanDepartamento();
            bd.idDepartamento           = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(0)));
            bd.idEmpresa                = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(1)));
            bd.codigoGrupo              = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(2)));
            bd.codigoEmpresa            = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(3)));
            bd.codigoDepartamento       = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(4)));
            bd.descricaoDepartamento    =                    String.valueOf(dadosDepartamentos.get(i).get(5));
        }
    }
    
}
