package TelasFaturamento;

import BeansNS.BeanEstados;
import BeansNS.BeanCEP;
import BeansNS.BeanPais;
import FuncoesInternas.InverterData;
import Beans.*;
import FuncoesInternas.*;
import Telas.CodigoEnderecamentoPostalConsulta;
import Telas.PaisesConsulta;
import Parametros.parametrosNS;
import TelasVendas.PDV;
import java.awt.event.KeyEvent;
import java.text.*;
import java.util.*;
/*
 @author Paulo e Tiago
 */
public class ClientesCadastro extends javax.swing.JFrame {
    //String's
    String  somostra            = "";
    String  mensagem            = "";
    String  sql                 = "";
    String  sqlstate            = "";
    String  operacao            = "";
    String  fatal               = "N";
    String  retorno             = "";
    String  pegouCodigoCliente  = "";
    
    public  String  Modo = "";
    
    //boolean's
    boolean ValidadorCpfCnpj    = false;
    boolean ValidadorIE         = false;
    
    //int's
    int    UltimoRegistro   = 0;
    int    length           = 0;
    int    abriuCep         = 0;
    int    abriuPais        = 0;
    int    abriuBanco       = 0;
    int    abriuCliente     = 0;
    
    //ArrayList's
    ArrayList            parametros             = new ArrayList();
//    ArrayList            dadosPadroes           = new ArrayList();
    ArrayList<ArrayList> dadosCEP               = new ArrayList();
    ArrayList<ArrayList> dadosEstados           = new ArrayList();
    ArrayList<ArrayList> dadosPaises            = new ArrayList();
    ArrayList<ArrayList> dadosCliente           = new ArrayList();
    ArrayList<ArrayList> dadosUsuario           = new ArrayList();
    ArrayList<ArrayList> dadosAutoIncremento    = new ArrayList();
    
    //Bean's
    BeanClientes    bc      = new BeanClientes();
    BeanCEP         bcep    = new BeanCEP();
    BeanPais        bpais   = new BeanPais();
    BeanUsuarios    bu      = new BeanUsuarios();
    BeanEstados     best    = new BeanEstados();
    
    //Especiais
    CapturarDataHora                cdh         = new CapturarDataHora();
    ValidarCpfCnpj                  Vcc         = new ValidarCpfCnpj();
    ValidarIE                       VIE         = new ValidarIE();
    FormataCampo                    fc          = new FormataCampo();
    FormataCampoCpfCnpj             FCpfCnpj    = new FormataCampoCpfCnpj();
    InverterData                    invdata     = new InverterData();
    PegaProximoRegistro             PegProReg   = new PegaProximoRegistro();
    TransformaValorStringeDouble    TransStrDou = new TransformaValorStringeDouble();
    
    //Telas
    ContratosCadastro                 ConCad;
    PaisesConsulta                    ConPaises;
    ClientesConsulta                  CliCon;
    CodigoEnderecamentoPostalConsulta CodEndPosCon;
    HistoricoCadastro                 Cdh;
    PDV                               Pdv;
    
    public ClientesCadastro(String Somostra, int CodigoCliente){
        somostra                = Somostra;
        bc.codigoCliente        = CodigoCliente;
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_observacoes = new javax.swing.JTextArea();
        jLabel26 = new javax.swing.JLabel();
        bt_pesquisa = new javax.swing.JButton();
        bt_incluir = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_ultimo = new javax.swing.JButton();
        bt_proximo = new javax.swing.JButton();
        bt_anterior = new javax.swing.JButton();
        bt_primeiro = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        label_alteracao = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        bt_novo = new javax.swing.JButton();
        txt_codigoCliente = new javax.swing.JFormattedTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        check_bloqueado = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        combo_pessoa = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        txt_cpfcnpj1 = new javax.swing.JFormattedTextField();
        txt_cpfcnpj2 = new javax.swing.JFormattedTextField();
        txt_cpfcnpj3 = new javax.swing.JFormattedTextField();
        chech_NaoInformar = new javax.swing.JCheckBox();
        jPanel10 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        txt_nascimento = new javax.swing.JFormattedTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        txt_dataCadastro = new javax.swing.JFormattedTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_profissao = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_contato = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_celular = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_telefone = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_site = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txt_contrato = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txt_cei = new javax.swing.JTextField();
        combo_sexo = new javax.swing.JComboBox<>();
        combo_estadoCivil = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        combo_UF = new javax.swing.JComboBox<>();
        txt_bairro = new javax.swing.JTextField();
        bt_pesquisaeCEP = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        txt_numero = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_codigoPais = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        label_pais = new javax.swing.JLabel();
        txt_cep = new javax.swing.JFormattedTextField();
        txt_endereco = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_cidade = new javax.swing.JTextField();
        bt_pesquisaPais = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_inscricaoEstadual = new javax.swing.JFormattedTextField();
        MenuCadastroClientes = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        bt_historico = new javax.swing.JMenuItem();
        bt_contratos = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        bt_sair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(":: Cadastro de Clientes ");
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
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_observacoes.setColumns(20);
        txt_observacoes.setRows(5);
        jScrollPane1.setViewportView(txt_observacoes);

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Observações");
        jLabel26.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel26)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addContainerGap())
        );

        bt_pesquisa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_pesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/View.png"))); // NOI18N
        bt_pesquisa.setText("Pesquisa");
        bt_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaActionPerformed(evt);
            }
        });

        bt_incluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_incluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_incluir.setText("Incluir");
        bt_incluir.setEnabled(false);
        bt_incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_incluirActionPerformed(evt);
            }
        });

        bt_alterar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Save.png"))); // NOI18N
        bt_alterar.setText("Alterar");
        bt_alterar.setEnabled(false);
        bt_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterarActionPerformed(evt);
            }
        });

        bt_ultimo.setText(">>");
        bt_ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ultimoActionPerformed(evt);
            }
        });

        bt_proximo.setText(">");
        bt_proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_proximoActionPerformed(evt);
            }
        });

        bt_anterior.setText("<");
        bt_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_anteriorActionPerformed(evt);
            }
        });

        bt_primeiro.setText("<<");
        bt_primeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_primeiroActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(102, 102, 102));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        label_alteracao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label_alteracao.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(label_alteracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_alteracao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Codigo");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        try {
            txt_codigoCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoCliente.setText("     ");
        txt_codigoCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoClienteFocusLost(evt);
            }
        });
        txt_codigoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_novo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, txt_codigoCliente});

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Status do Cliente");
        jLabel31.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        check_bloqueado.setText("Bloqueado");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(check_bloqueado, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check_bloqueado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Pessoa");
        jLabel32.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        combo_pessoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jurídica", "Física" }));
        combo_pessoa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_pessoaItemStateChanged(evt);
            }
        });
        combo_pessoa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                combo_pessoaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo_pessoaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(combo_pessoa, 0, 92, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(combo_pessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("CPF ou CNPJ");
        jLabel33.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_cpfcnpj1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("### ### ###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cpfcnpj1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cpfcnpj1.setText("000 000 000");
        txt_cpfcnpj1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_cpfcnpj1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cpfcnpj1FocusLost(evt);
            }
        });
        txt_cpfcnpj1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cpfcnpj1KeyPressed(evt);
            }
        });

        try {
            txt_cpfcnpj2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cpfcnpj2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cpfcnpj2.setText("0000");
        txt_cpfcnpj2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_cpfcnpj2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cpfcnpj2FocusLost(evt);
            }
        });
        txt_cpfcnpj2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cpfcnpj2ActionPerformed(evt);
            }
        });
        txt_cpfcnpj2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cpfcnpj2KeyPressed(evt);
            }
        });

        try{
            txt_cpfcnpj3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cpfcnpj3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cpfcnpj3.setText("00");
        txt_cpfcnpj3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_cpfcnpj3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cpfcnpj3FocusLost(evt);
            }
        });
        txt_cpfcnpj3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cpfcnpj3KeyPressed(evt);
            }
        });

        chech_NaoInformar.setText("Não informar");
        chech_NaoInformar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        chech_NaoInformar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chech_NaoInformarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_cpfcnpj1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cpfcnpj2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cpfcnpj3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chech_NaoInformar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(chech_NaoInformar, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cpfcnpj1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cpfcnpj2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cpfcnpj3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {chech_NaoInformar, jLabel33});

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Nasc. ou Abert.");
        jLabel34.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_nascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_nascimento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nascimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_nascimentoFocusLost(evt);
            }
        });
        txt_nascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nascimentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_nascimento)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Data de Cadastro");
        jLabel35.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_dataCadastro.setEditable(false);
        try {
            txt_dataCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataCadastro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataCadastro.setEnabled(false);
        txt_dataCadastro.setFocusable(false);
        txt_dataCadastro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataCadastroFocusLost(evt);
            }
        });
        txt_dataCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dataCadastroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_dataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_dataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nome:");

        txt_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nomeActionPerformed(evt);
            }
        });

        jLabel4.setText("Sexo:");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Profissão:");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Estavo civil:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Contato:");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("E-mail: ");

        jLabel6.setText("Celular: ");

        try {
            txt_celular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## #########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        try {
            txt_celular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_celular.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_celularFocusGained(evt);
            }
        });

        jLabel8.setText("Telefone: ");

        try {
            txt_telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## ########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        try {
            txt_telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)  ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_telefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_telefoneFocusGained(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Site: ");

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Contrato:");

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("CEI/INT:");

        txt_cei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ceiActionPerformed(evt);
            }
        });

        combo_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----------", "Masculino", "Feminino" }));
        combo_sexo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_sexoItemStateChanged(evt);
            }
        });
        combo_sexo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo_sexoFocusLost(evt);
            }
        });

        combo_estadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----------", "Solteiro (a)", "Casado (a)", "Viúvo (a)", "Divorciado (a)", "União Estável" }));
        combo_estadoCivil.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_estadoCivilItemStateChanged(evt);
            }
        });
        combo_estadoCivil.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo_estadoCivilFocusLost(evt);
            }
        });

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Bairro: ");

        combo_UF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        combo_UF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo_UFFocusLost(evt);
            }
        });

        bt_pesquisaeCEP.setText("...");
        bt_pesquisaeCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaeCEPActionPerformed(evt);
            }
        });

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Número:");

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("UF:");

        jLabel3.setText("Pais:");

        try {
            txt_codigoPais.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoPais.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoPaisFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoPaisFocusLost(evt);
            }
        });
        txt_codigoPais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_codigoPaisMouseClicked(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("CEP:");

        try {
            txt_cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cep.setText("     -   ");
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
        txt_cep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cepKeyReleased(evt);
            }
        });

        txt_endereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_enderecoActionPerformed(evt);
            }
        });

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Cidade: ");

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Endereço:");

        bt_pesquisaPais.setText("...");
        bt_pesquisaPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaPaisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_sexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_contato))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_profissao)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                            .addComponent(txt_site)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_cep)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_pesquisaeCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cei, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_celular))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_estadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_telefone))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(combo_UF, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_codigoPais, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bt_pesquisaPais, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label_pais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addGap(11, 11, 11))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel6, jLabel8});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel20, jLabel21, jLabel29, jLabel30, jLabel9});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {combo_estadoCivil, txt_cei, txt_contrato});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel7});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel11, jLabel13, jLabel22, jLabel5});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel1)
                    .addComponent(combo_estadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txt_celular, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_contato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(txt_cei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_profissao, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_site, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addComponent(jLabel29)
                    .addComponent(txt_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18)
                                .addComponent(bt_pesquisaeCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel22)
                                .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(label_pais, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txt_codigoPais, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bt_pesquisaPais, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19)
                                .addComponent(jLabel21)
                                .addComponent(combo_UF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {combo_estadoCivil, combo_sexo, jLabel1, jLabel10, jLabel11, jLabel29, jLabel30, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, txt_cei, txt_celular, txt_contato, txt_contrato, txt_email, txt_nome, txt_profissao, txt_site, txt_telefone});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaPais, bt_pesquisaeCEP, combo_UF, jLabel13, jLabel18, jLabel19, jLabel20, jLabel21, jLabel22, jLabel3, label_pais, txt_bairro, txt_cep, txt_cidade, txt_codigoPais, txt_endereco, txt_numero});

        jTabbedPane1.addTab("Informações Pessoais e Cadastrais", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Inscrição Estadual");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_inscricaoEstadual)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_inscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jMenu1.setText("Acessos");

        jMenuItem1.setText("Atendimentos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Serviços");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Financeiro");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        bt_historico.setText("Historico");
        bt_historico.setEnabled(false);
        bt_historico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_historicoActionPerformed(evt);
            }
        });
        jMenu1.add(bt_historico);

        bt_contratos.setText("Contratos");
        bt_contratos.setEnabled(false);
        bt_contratos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_contratosActionPerformed(evt);
            }
        });
        jMenu1.add(bt_contratos);
        jMenu1.add(jSeparator1);

        bt_sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });
        jMenu1.add(bt_sair);

        MenuCadastroClientes.add(jMenu1);

        setJMenuBar(MenuCadastroClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_primeiro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_anterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_proximo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_ultimo))
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_alterar, bt_incluir});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_alterar)
                    .addComponent(bt_ultimo)
                    .addComponent(bt_proximo)
                    .addComponent(bt_anterior)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_primeiro)
                        .addComponent(bt_pesquisa))
                    .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_alterar, bt_anterior, bt_incluir, bt_pesquisa, bt_primeiro, bt_proximo, bt_ultimo});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel10, jPanel11, jPanel2, jPanel4, jPanel6, jPanel7, jPanel9});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cpfcnpj1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1FocusLost
        txt_cpfcnpj1.setText(fc.FormataCampo(txt_cpfcnpj1.getText(), 11, 2));
        if(txt_cpfcnpj2.isEditable() == true){
            txt_cpfcnpj2.setText("");
        }
    }//GEN-LAST:event_txt_cpfcnpj1FocusLost

    private void txt_cpfcnpj2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj2FocusLost
        if(txt_cpfcnpj2.isEditable()== false)
            return;
        txt_cpfcnpj2.setText(fc.FormataCampo(txt_cpfcnpj2.getText(), 4, 0));
    }//GEN-LAST:event_txt_cpfcnpj2FocusLost

    private void txt_cpfcnpj2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cpfcnpj2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cpfcnpj2ActionPerformed

    private void txt_cpfcnpj3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj3FocusLost
        txt_cpfcnpj3.setText(fc.FormataCampo(txt_cpfcnpj3.getText(), 2, 0));
        ValidaCPFCNPJ();
    }//GEN-LAST:event_txt_cpfcnpj3FocusLost

    private void txt_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomeActionPerformed

    private void txt_nascimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nascimentoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nascimentoFocusLost

    private void txt_nascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nascimentoActionPerformed

    private void txt_dataCadastroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataCadastroFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dataCadastroFocusLost

    private void txt_dataCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dataCadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dataCadastroActionPerformed

    private void txt_cepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cepKeyReleased
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        txt_numero.grabFocus();
    }//GEN-LAST:event_txt_cepKeyReleased

    private void txt_cepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_cepMouseClicked
        
    }//GEN-LAST:event_txt_cepMouseClicked

    private void txt_cepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cepFocusLost
        if(txt_cep.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        PegaCEP();
    }//GEN-LAST:event_txt_cepFocusLost

    private void txt_cepFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cepFocusGained

    }//GEN-LAST:event_txt_cepFocusGained

    private void txt_enderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_enderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_enderecoActionPerformed

    private void combo_pessoaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo_pessoaFocusLost
        
    }//GEN-LAST:event_combo_pessoaFocusLost

    private void txt_codigoPaisFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPaisFocusLost
        if(txt_codigoPais.getText().replace(" ", "").equals(""))
            return;
        PegaPais();
    }//GEN-LAST:event_txt_codigoPaisFocusLost

    private void txt_codigoPaisFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPaisFocusGained
        txt_codigoPais.setSelectionStart(0);
        txt_codigoPais.setSelectionEnd  (txt_codigoPais.getText().length());
    }//GEN-LAST:event_txt_codigoPaisFocusGained

    private void combo_UFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo_UFFocusLost
        
    }//GEN-LAST:event_combo_UFFocusLost

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        ReiniciaCampos();
        HabilitaCampos(true);
        check_bloqueado.grabFocus();
        
        bc.codigoCliente = PegProReg.PegaProximoRegistro("tb_clientes", "codigoCliente", "");
        txt_codigoCliente.setText(fc.FormataCampo(String.valueOf(bc.codigoCliente), 5, 0));
        
        operacao = "I";
        HabilitaBotoes();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S"))
            return;
        
        sql = "insert into tb_clientes(idEmpresa, codigoGrupo, codigoEmpresa, codigoCliente, statusCliente, fisicaJuridica, cpfCnpjNaoInformado, cpfCnpj, InscricaoEstadual, dataNascAber, dataCadastro, nome, sexo, estadoCivil, telefone, contato, email, cei, celular, profissao, site, contrato, cep, cidade, bairro, endereco, numero, uf, codigoPais, observacoes) "
            + "values (" + bc.idEmpresa + ", " + bc.codigoGrupo + ", " + bc.codigoEmpresa + ", " + bc.codigoCliente + ", " + bc.statusCliente + ", " + bc.fisicaJuridica + ", " + bc.cpfCnpjNaoInformado + ", '" + bc.cpfCnpj + "', '" + bc.InscricaoEstadual + "', " + bc.dataNascAber + ", '" + bc.dataCadastro + "', '" + bc.nome + "', '" + bc.sexo + "', '" + bc.estadoCivil + "', " + bc.telefone + ", '" + bc.contato + "', '" + bc.email + "', '" + bc.cei + "', " + bc.celular + ", '" + bc.profissao + "', '" + bc.site + "', '" + bc.contrato + "', " + bc.cep + ", '" + bc.cidade + "', '" + bc.bairro + "', '" + bc.endereco + "', '" + bc.numero + "', '" + bc.uf + "', '" + bc.codigoPais + "', '" + bc.observacoes + "');";
//        System.out.println(sql);
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        mensagem = "Registro incluído com sucesso!";
        new MostraMensagem(mensagem);
        VerificaUltimoRegistro();
        txt_codigoCliente.grabFocus();
        if(Modo.equals("Venda"))
            dispose();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S"))
            return;
        
        sql = "update tb_clientes set statusCliente = "         + bc.statusCliente      + ", " +
                                      "fisicaJuridica = "       + bc.fisicaJuridica     + ", " +
                                      "cpfCnpjNaoInformado = "  + bc.cpfCnpjNaoInformado+ ", " +
                                      "InscricaoEstadual = '"   + bc.InscricaoEstadual  + "', " +
                                      "cpfCnpj = '"             + bc.cpfCnpj            + "', " +
                                      "dataNascAber = "         + bc.dataNascAber       + ", "  +
                                      "dataCadastro = '"        + bc.dataCadastro       + "', " +
                                      "nome = '"                + bc.nome               + "', " +
                                      "sexo = '"                + bc.sexo               + "', " +
                                      "estadoCivil = "          + bc.estadoCivil        + ", " +
                                      "telefone = "             + bc.telefone           + ", " +
                                      "contato = '"             + bc.contato            + "', " +
                                      "email = '"               + bc.email              + "', " +
                                      "cei = '"                 + bc.cei                + "', " +
                                      "celular = "              + bc.celular            + ", " +
                                      "profissao = '"           + bc.profissao          + "', " +
                                      "site = '"                + bc.site               + "', " +
                                      "contrato = '"            + bc.contrato           + "', " +
                                      "cep = "                  + bc.cep                + ", " +
                                      "cidade = '"              + bc.cidade             + "', " +
                                      "endereco = '"            + bc.endereco           + "', " +
                                      "numero = '"              + bc.numero             + "', " +
                                      "bairro = '"              + bc.bairro             + "', " +
                                      "uf = '"                  + bc.uf                 + "', " +
                                      "codigoPais = "           + bc.codigoPais         + ", " +
                                      "observacoes = '"         + bc.observacoes        + "', " +
                                      "dataAlterou = '"         + bc.dataAlterou        + "', " +
                                      "horaAlterou = '"         + bc.horaAlterou        + "', " +
                                      "usuarioAlterou = "   + bc.usuarioAlterou     + " "  +
                                      "where idCliente = "  + bc.idCliente          + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        mensagem = "Registro alterado com sucesso!";
        new MostraMensagem(mensagem);
        VerificaUltimoRegistro();
        txt_codigoCliente.grabFocus();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void bt_primeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_primeiroActionPerformed
        bc.codigoCliente = 1;
        pegouCodigoCliente = "N";
        txt_codigoCliente.setText(String.valueOf(bc.codigoCliente));
        PegaCliente();
    }//GEN-LAST:event_bt_primeiroActionPerformed

    private void bt_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_anteriorActionPerformed
        if(Integer.parseInt(txt_codigoCliente.getText()) == 1){
            mensagem = "Não existe registro anterior!";
            new MostraMensagem(mensagem);
            return;
        }
        if(txt_codigoCliente.getText().replace(" ", "").equals("")){
            txt_codigoCliente.setText(fc.FormataCampo("2", 5, 0));
        }
        bc.codigoCliente = Integer.parseInt(txt_codigoCliente.getText()) - 1;
        if(bc.codigoCliente > UltimoRegistro){
            bc.codigoCliente = UltimoRegistro - 1;
        }
        do{
            pegouCodigoCliente = "";
            txt_codigoCliente.setText(String.valueOf(bc.codigoCliente));
            PegaCliente();
            if(pegouCodigoCliente.equals("N")){
                bc.codigoCliente = bc.codigoCliente - 1;
            }
        }while(pegouCodigoCliente.equals("N"));
    }//GEN-LAST:event_bt_anteriorActionPerformed

    private void bt_proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_proximoActionPerformed
        if(txt_codigoCliente.getText().replace(" ", "").equals("")){
            txt_codigoCliente.setText(fc.FormataCampo("", 5, 0));
        }
        bc.codigoCliente = Integer.parseInt(txt_codigoCliente.getText().replace(" ", "")) + 1;
        if(bc.codigoCliente == UltimoRegistro){
            bc.codigoCliente = bc.codigoCliente - 1;
            mensagem = "Esse é o último registro!";
            new MostraMensagem(mensagem);
            return;
        }
        if(bc.codigoCliente > UltimoRegistro){
            bc.codigoCliente = UltimoRegistro - 1;
        }
        do{
            pegouCodigoCliente = "";
            txt_codigoCliente.setText(String.valueOf(bc.codigoCliente));
            PegaCliente();
            if(pegouCodigoCliente.equals("N")){
                bc.codigoCliente = bc.codigoCliente + 1;
            }
        }while(pegouCodigoCliente.equals("N"));
    }//GEN-LAST:event_bt_proximoActionPerformed

    private void bt_ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ultimoActionPerformed
        bc.codigoCliente = UltimoRegistro - 1;
        pegouCodigoCliente = "N";
        txt_codigoCliente.setText(String.valueOf(bc.codigoCliente));
        PegaCliente();
    }//GEN-LAST:event_bt_ultimoActionPerformed
    
    private void txt_telefoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_telefoneFocusGained
        txt_telefone.setSelectionStart(0);
        txt_telefone.setSelectionEnd(txt_telefone.getText().length());
    }//GEN-LAST:event_txt_telefoneFocusGained

    private void txt_celularFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_celularFocusGained
        txt_celular.setSelectionStart(0);
        txt_celular.setSelectionEnd(txt_celular.getText().length());
    }//GEN-LAST:event_txt_celularFocusGained

    private void txt_codigoPaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_codigoPaisMouseClicked
        
    }//GEN-LAST:event_txt_codigoPaisMouseClicked

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
        if(abriuCliente == 0){
            AbrePais();
            return;
        }
        abriuCliente = 0;
        retorno = CliCon.getRetorno();
        if(retorno.equals(""))
          return;
        txt_codigoCliente.setText(retorno);
        PegaCliente();
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbrePais(){
        if(abriuPais == 0){
            AbreCep();
            return;
        }
        abriuPais = 0;
        retorno = ConPaises.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoPais.setText(retorno);
        PegaPais();
    }
    
    private void AbreCep(){
        if(abriuCep == 0)
            return;
        abriuCep = 0;
        retorno = CodEndPosCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_cep.setText(retorno);
        PegaCEP();
    }
    
    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        if(CliCon != null)if(CliCon.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        abriuCliente = 1;
        CliCon = new ClientesConsulta("S");
        CliCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void txt_cpfcnpj1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1FocusGained
        if(txt_cpfcnpj1.isEditable() == false)
            return;
        txt_cpfcnpj1.setText("");
    }//GEN-LAST:event_txt_cpfcnpj1FocusGained

    private void txt_ceiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ceiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ceiActionPerformed

    private void combo_sexoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo_sexoFocusLost
        if(operacao.equals(""))return;
        VerificaSexo();
    }//GEN-LAST:event_combo_sexoFocusLost

    private void combo_estadoCivilFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo_estadoCivilFocusLost
        if(operacao.equals(""))return;
        VerificaEstadoCivil();
    }//GEN-LAST:event_combo_estadoCivilFocusLost

    private void combo_pessoaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_pessoaItemStateChanged
        VerificaTipoPessoa();
    }//GEN-LAST:event_combo_pessoaItemStateChanged

    private void combo_sexoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_sexoItemStateChanged
        
    }//GEN-LAST:event_combo_sexoItemStateChanged

    private void combo_estadoCivilItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_estadoCivilItemStateChanged
        
    }//GEN-LAST:event_combo_estadoCivilItemStateChanged

    private void txt_codigoClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteFocusLost
        if(txt_codigoCliente.isEditable() == false)
            return;
        if(txt_codigoCliente.getText().replace(" ", "").equals(""))
            return;
        PegaCliente();
    }//GEN-LAST:event_txt_codigoClienteFocusLost

    private void txt_codigoClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteFocusGained
        if(txt_codigoCliente.isEditable() == false)
            return;
        txt_codigoCliente.setText("");
        operacao = "";
        HabilitaBotoes();
        ReiniciaTela(false);
    }//GEN-LAST:event_txt_codigoClienteFocusGained

    private void bt_historicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_historicoActionPerformed
        parametros.clear();
        parametros.add(Integer.parseInt(txt_codigoCliente.getText()));
        Cdh = new HistoricoCadastro(parametros);
        Cdh.setVisible(true);
    }//GEN-LAST:event_bt_historicoActionPerformed

    private void combo_pessoaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo_pessoaFocusGained
        txt_cpfcnpj1.setText("");
        txt_cpfcnpj2.setText("");
        txt_cpfcnpj3.setText("");
    }//GEN-LAST:event_combo_pessoaFocusGained

    private void chech_NaoInformarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chech_NaoInformarActionPerformed
        if(chech_NaoInformar.isSelected() == true){
            combo_pessoa.setEnabled(false);
            txt_cpfcnpj1.setText(fc.FormataCampo("", 9, 0));
            txt_cpfcnpj2.setText(fc.FormataCampo("", 4, 0));
            txt_cpfcnpj3.setText(fc.FormataCampo("", 2, 0));
            txt_cpfcnpj1.setEditable(false);
            txt_cpfcnpj2.setEditable(false);
            txt_cpfcnpj3.setEditable(false);
            ValidadorCpfCnpj = true;
            return;
        }
        combo_pessoa.setEnabled(true);
        txt_cpfcnpj1.setText("");
        txt_cpfcnpj2.setText("");
        txt_cpfcnpj3.setText("");
        txt_cpfcnpj1.setEditable(true);
        txt_cpfcnpj2.setEditable(true);
        txt_cpfcnpj3.setEditable(true);
        ValidadorCpfCnpj = false;
    }//GEN-LAST:event_chech_NaoInformarActionPerformed

    private void txt_cpfcnpj2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj2FocusGained
        if(txt_cpfcnpj2.isEditable() == false)
            return;
        txt_cpfcnpj2.setText("");
    }//GEN-LAST:event_txt_cpfcnpj2FocusGained

    private void txt_cpfcnpj3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj3FocusGained
        if(txt_cpfcnpj3.isEditable() == false)
            return;
        txt_cpfcnpj3.setText("");
    }//GEN-LAST:event_txt_cpfcnpj3FocusGained

    private void bt_pesquisaeCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaeCEPActionPerformed
        if(CodEndPosCon != null)if(CodEndPosCon.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        abriuCep = 1;
        CodEndPosCon = new CodigoEnderecamentoPostalConsulta();
        CodEndPosCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaeCEPActionPerformed

    private void txt_cpfcnpj1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(txt_cpfcnpj2.isFocusable()){txt_cpfcnpj2.grabFocus();}else{txt_cpfcnpj3.grabFocus();}
        }
    }//GEN-LAST:event_txt_cpfcnpj1KeyPressed

    private void txt_cpfcnpj2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cpfcnpj2KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_cpfcnpj3.grabFocus();
        }
    }//GEN-LAST:event_txt_cpfcnpj2KeyPressed

    private void txt_cpfcnpj3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cpfcnpj3KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_nascimento.grabFocus();
        }
    }//GEN-LAST:event_txt_cpfcnpj3KeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void bt_contratosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_contratosActionPerformed
        parametros.clear();
        parametros.add(somostra);
        parametros.add(Integer.parseInt(txt_codigoCliente.getText()));
        parametros.add(0);
        if(ConCad != null)if(ConCad.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        ConCad = new ContratosCadastro(parametros);
        ConCad.setVisible(true);
    }//GEN-LAST:event_bt_contratosActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HabilitaCampos(false);
        
        txt_dataCadastro.setText(cdh.CapturarData());
        PegaUF();
        VerificaUltimoRegistro();
        VerificaTipoPessoa();
        
        if(somostra.equals("S")){
            MenuCadastroClientes.setVisible (false);
            bt_novo             .setEnabled (false);
            txt_codigoCliente   .setEditable(false);
            bt_pesquisaeCEP     .setEnabled (false);
            bt_pesquisaPais     .setEnabled (false);
            bt_incluir          .setVisible (false);
            bt_alterar          .setVisible (false);
            bt_pesquisa         .setVisible (false);
            bt_primeiro         .setVisible (false);
            bt_anterior         .setVisible (false);
            bt_proximo          .setVisible (false);
            bt_ultimo           .setVisible (false);
        }
        if(bc.codigoCliente != 0){
            pegouCodigoCliente = "N";
            txt_codigoCliente   .setText(String.valueOf(bc.codigoCliente));
            check_bloqueado     .grabFocus();
            PegaCliente();
            if(somostra.equals("SN")){
                txt_codigoCliente.setEditable (false);
                txt_codigoCliente.setFocusable(false);
                bt_novo          .setEnabled  (false);
                bt_primeiro      .setEnabled  (false);
                bt_anterior      .setEnabled  (false);
                bt_proximo       .setEnabled  (false);
                bt_ultimo        .setEnabled  (false);
                bt_pesquisa      .setVisible  (false);
            }
        }
        if(somostra.equals("SN"))
            bt_pesquisa         .setVisible (false);
    }//GEN-LAST:event_formWindowOpened

    private void txt_inscricaoEstadualFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_inscricaoEstadualFocusLost
        if(txt_inscricaoEstadual.isEditable() == false)
            return;
        bc.InscricaoEstadual    = txt_inscricaoEstadual.getText().replace(" ", "");
        ValidadorIE = VIE.ValidadorDeIE(bc.InscricaoEstadual);
        HabilitaBotoes();
        if(ValidadorIE == false){
            bt_incluir  .setEnabled(false);
            bt_alterar  .setEnabled(false);
            if(!bc.InscricaoEstadual.equals("")){
                mensagem = "Inscrição Estadual Inválida!";
                new MostraMensagem(mensagem);
            }
        }
    }//GEN-LAST:event_txt_inscricaoEstadualFocusLost

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(ConCad          != null)ConCad          .dispose();
        if(ConPaises       != null)ConPaises       .dispose();
        if(CliCon          != null)CliCon          .dispose();
        if(CodEndPosCon    != null)CodEndPosCon    .dispose();
    }//GEN-LAST:event_formWindowClosed
    
    private void bt_pesquisaPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaPaisActionPerformed
        if(ConPaises != null)if(ConPaises.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        abriuPais = 1;
        ConPaises = new PaisesConsulta();
        ConPaises.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaPaisActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(Modo.equals("Venda")){
            parametrosNS.codigoCliente = bc.codigoCliente;
            parametrosNS.cpfCnpj       = "";
        }
    }//GEN-LAST:event_formWindowClosing

    private void txt_codigoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoClienteActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuCadastroClientes;
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_anterior;
    private javax.swing.JMenuItem bt_contratos;
    private javax.swing.JMenuItem bt_historico;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisa;
    private javax.swing.JButton bt_pesquisaPais;
    private javax.swing.JButton bt_pesquisaeCEP;
    private javax.swing.JButton bt_primeiro;
    private javax.swing.JButton bt_proximo;
    private javax.swing.JMenuItem bt_sair;
    private javax.swing.JButton bt_ultimo;
    private javax.swing.JCheckBox chech_NaoInformar;
    private javax.swing.JCheckBox check_bloqueado;
    private javax.swing.JComboBox<String> combo_UF;
    private javax.swing.JComboBox<String> combo_estadoCivil;
    private javax.swing.JComboBox<String> combo_pessoa;
    private javax.swing.JComboBox<String> combo_sexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel label_alteracao;
    private javax.swing.JLabel label_pais;
    private javax.swing.JTextField txt_bairro;
    private javax.swing.JTextField txt_cei;
    private javax.swing.JFormattedTextField txt_celular;
    private javax.swing.JFormattedTextField txt_cep;
    private javax.swing.JTextField txt_cidade;
    private javax.swing.JFormattedTextField txt_codigoCliente;
    private javax.swing.JFormattedTextField txt_codigoPais;
    private javax.swing.JTextField txt_contato;
    private javax.swing.JTextField txt_contrato;
    private javax.swing.JFormattedTextField txt_cpfcnpj1;
    private javax.swing.JFormattedTextField txt_cpfcnpj2;
    private javax.swing.JFormattedTextField txt_cpfcnpj3;
    private javax.swing.JFormattedTextField txt_dataCadastro;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_endereco;
    private javax.swing.JFormattedTextField txt_inscricaoEstadual;
    private javax.swing.JFormattedTextField txt_nascimento;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_numero;
    private javax.swing.JTextArea txt_observacoes;
    private javax.swing.JTextField txt_profissao;
    private javax.swing.JTextField txt_site;
    private javax.swing.JFormattedTextField txt_telefone;
    // End of variables declaration//GEN-END:variables
    
    private void ValidaCPFCNPJ(){
        bc.cpfCnpj1 = txt_cpfcnpj1.getText().replace(" ", "");
        bc.cpfCnpj2 = txt_cpfcnpj2.getText().replace(" ", "");
        bc.cpfCnpj3 = txt_cpfcnpj3.getText().replace(" ", "");
        
        bc.cpfCnpj = bc.cpfCnpj1 + bc.cpfCnpj2 + bc.cpfCnpj3;
        ValidadorCpfCnpj = Vcc.VALIDARCPFCNPJ(bc.cpfCnpj);
        if(ValidadorCpfCnpj != false){
            HabilitaBotoes();
            return;
        }
        bt_incluir.setEnabled(false);
        bt_alterar.setEnabled(false);
        if(combo_pessoa.getSelectedIndex() == 0){
            mensagem = "CNPJ Inválido!";
        }else{
            mensagem = "CPF Inválido!";
        }
        new MostraMensagem(mensagem);
    }
    
    private void PegaCliente(){
        if(abriuCliente == 1)
            return;
        txt_codigoCliente.setText(fc.FormataCampo(txt_codigoCliente.getText(), 5, 0));
        bc.codigoCliente = Integer.parseInt(txt_codigoCliente.getText());
        sql = "select * from tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCliente = " + bc.codigoCliente + ";";
        dadosCliente.clear();
        dadosCliente = parametrosNS.dao.Consulta(sql);
        if(dadosCliente.isEmpty()){
            if(pegouCodigoCliente.equals("")){
                pegouCodigoCliente = "N";
                return;
            }
            mensagem = "Cliente " + bc.codigoCliente + " não encontrado!\nPara incluir um cliente Pressione NOVO!";
            new MostraMensagem(mensagem);
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        HabilitaCampos(true);
        PreencherCliente();
    }
    
    private void PreencherCliente() {
        for(int i = 0; i < dadosCliente.size(); i++){
            bc = new BeanClientes();
            if(dadosCliente.get(i).get(0) != null) {bc.idCliente            = Integer.parseInt(String.valueOf(dadosCliente.get(i).get(0)));}
            if(dadosCliente.get(i).get(1) != null) {bc.idEmpresa            = Integer.parseInt(String.valueOf(dadosCliente.get(i).get(1)));}
            if(dadosCliente.get(i).get(2) != null) {bc.codigoGrupo          = Integer.parseInt(String.valueOf(dadosCliente.get(i).get(2)));}
            if(dadosCliente.get(i).get(3) != null) {bc.codigoEmpresa        = Integer.parseInt(String.valueOf(dadosCliente.get(i).get(3)));}
            if(dadosCliente.get(i).get(4) != null) {bc.codigoCliente        = Integer.parseInt(String.valueOf(dadosCliente.get(i).get(4)));}
            if(dadosCliente.get(i).get(5) != null) {bc.statusCliente        = Integer.parseInt(String.valueOf(dadosCliente.get(i).get(5)));}
            if(dadosCliente.get(i).get(6) != null) {bc.fisicaJuridica       = Integer.parseInt(String.valueOf(dadosCliente.get(i).get(6)));}
            if(dadosCliente.get(i).get(7) != null) {bc.cpfCnpjNaoInformado  = Integer.parseInt(String.valueOf(dadosCliente.get(i).get(7)));}
            if(dadosCliente.get(i).get(8) != null) {bc.cpfCnpj              =                  String.valueOf(dadosCliente.get(i).get(8));}
            if(dadosCliente.get(i).get(9) != null) {bc.InscricaoEstadual    =                  String.valueOf(dadosCliente.get(i).get(9));}
            if(dadosCliente.get(i).get(10) != null){bc.dataNascAber         =                  String.valueOf(dadosCliente.get(i).get(10));}
            if(dadosCliente.get(i).get(11) != null){bc.dataCadastro         =                  String.valueOf(dadosCliente.get(i).get(11));}
            if(dadosCliente.get(i).get(12) != null){bc.nome                 =                  String.valueOf(dadosCliente.get(i).get(12));}
            if(dadosCliente.get(i).get(13) != null){bc.sexo                 = Integer.parseInt(String.valueOf(dadosCliente.get(i).get(13)));}
            if(dadosCliente.get(i).get(14) != null){bc.estadoCivil          = Integer.parseInt(String.valueOf(dadosCliente.get(i).get(14)));}
            if(dadosCliente.get(i).get(15) != null){bc.telefone             =                  String.valueOf(dadosCliente.get(i).get(15));}
            if(dadosCliente.get(i).get(16) != null){bc.contato              =                  String.valueOf(dadosCliente.get(i).get(16));}
            if(dadosCliente.get(i).get(17) != null){bc.email                =                  String.valueOf(dadosCliente.get(i).get(17));}
            if(dadosCliente.get(i).get(18) != null){bc.cei                  =                  String.valueOf(dadosCliente.get(i).get(18));}
            if(dadosCliente.get(i).get(19) != null){bc.celular              =                  String.valueOf(dadosCliente.get(i).get(19));}
            if(dadosCliente.get(i).get(20) != null){bc.profissao            =                  String.valueOf(dadosCliente.get(i).get(20));}
            if(dadosCliente.get(i).get(21) != null){bc.site                 =                  String.valueOf(dadosCliente.get(i).get(21));}
            if(dadosCliente.get(i).get(22) != null){bc.contrato             =                  String.valueOf(dadosCliente.get(i).get(22));}
            if(dadosCliente.get(i).get(23) != null){bc.cep                  =                  String.valueOf(dadosCliente.get(i).get(23));}
            if(dadosCliente.get(i).get(24) != null){bc.cidade               =                  String.valueOf(dadosCliente.get(i).get(24));}
            if(dadosCliente.get(i).get(25) != null){bc.endereco             =                  String.valueOf(dadosCliente.get(i).get(25));}
            if(dadosCliente.get(i).get(26) != null){bc.numero               =                  String.valueOf(dadosCliente.get(i).get(26));}
            if(dadosCliente.get(i).get(27) != null){bc.bairro               =                  String.valueOf(dadosCliente.get(i).get(27));}
            if(dadosCliente.get(i).get(28) != null){bc.uf                   =                  String.valueOf(dadosCliente.get(i).get(28));}
            if(dadosCliente.get(i).get(29) != null){bc.codigoPais           = Integer.parseInt(String.valueOf(dadosCliente.get(i).get(29)));}
            if(dadosCliente.get(i).get(30) != null){bc.observacoes          =                  String.valueOf(dadosCliente.get(i).get(30));}
            if(dadosCliente.get(i).get(31) != null){bc.dataAlterou          =                  String.valueOf(dadosCliente.get(i).get(31));}
            if(dadosCliente.get(i).get(32) != null){bc.horaAlterou          =                  String.valueOf(dadosCliente.get(i).get(32));}
            if(dadosCliente.get(i).get(33) != null){bc.usuarioAlterou       = Integer.parseInt(String.valueOf(dadosCliente.get(i).get(33)));}
            if(dadosCliente.get(i).get(34) != null){bc.idEmpresaAlterou     = Integer.parseInt(String.valueOf(dadosCliente.get(i).get(34)));}
            if(dadosCliente.get(i).get(35) != null){bc.codigoGrupoAlterou   = Integer.parseInt(String.valueOf(dadosCliente.get(i).get(35)));}
            if(dadosCliente.get(i).get(36) != null){bc.codigoEmpresaAlterou = Integer.parseInt(String.valueOf(dadosCliente.get(i).get(36)));}
        }
        if(bc.statusCliente == 1){
            check_bloqueado.setSelected(true);
        }else{
            check_bloqueado.setSelected(false);
        }
        combo_pessoa.setSelectedIndex(bc.fisicaJuridica);
        if(bc.cpfCnpjNaoInformado == 0){
            combo_pessoa.setEnabled(true);
            chech_NaoInformar.setSelected(false);
            txt_cpfcnpj2.setEditable(false);
            if(bc.cpfCnpj.length() > 11){
                txt_cpfcnpj2.setEditable(true);
            }
            txt_cpfcnpj1.setEditable(true);
            txt_cpfcnpj3.setEditable(true);
        }else{
            combo_pessoa.setSelectedIndex(0);
            combo_pessoa.setEnabled(false);
            chech_NaoInformar.setSelected(true);
            txt_cpfcnpj1.setEditable(false);
            txt_cpfcnpj2.setEditable(false);
            txt_cpfcnpj3.setEditable(false);
        }
        bc.cpfCnpj = FCpfCnpj.FormataCampoCpfCnpj(bc.cpfCnpj);
        txt_cpfcnpj1.setText(bc.cpfCnpj.substring(0 , 9));
        txt_cpfcnpj2.setText(bc.cpfCnpj.substring(9 ,13));
        txt_cpfcnpj3.setText(bc.cpfCnpj.substring(13,15));
        ValidadorCpfCnpj    = true;
        txt_inscricaoEstadual   .setText(bc.InscricaoEstadual);
        ValidadorIE         = true;
        if(bc.dataNascAber != null){
            txt_nascimento.setText(invdata.inverterData(bc.dataNascAber, 1));
        }
        txt_dataCadastro.setText(invdata.inverterData(bc.dataCadastro, 1));
        txt_nome.setText(bc.nome);
        combo_sexo.setSelectedIndex(bc.sexo);
        VerificaSexo();
        combo_estadoCivil.setSelectedIndex(bc.estadoCivil);
        VerificaEstadoCivil();
        txt_telefone.setText(bc.telefone);
        txt_contato.setText(bc.contato);
        txt_email.setText(bc.email);
        txt_cei.setText(bc.cei);
        txt_celular.setText(bc.celular);
        txt_profissao.setText(bc.profissao);
        txt_site.setText(bc.site);
        txt_contrato.setText(bc.contrato);
        txt_cep.setText(bc.cep);
        txt_numero.setText(bc.numero);
        if(bc.usuarioAlterou != 0){
            bu.usuario      = "NS3";
            bc.dataAlterou  = invdata.inverterData(bc.dataAlterou, 1);
            if(bc.usuarioAlterou != 999){
                bu.idEmpresa            = bc.idEmpresaAlterou;
                bu.codigoGrupo          = bc.codigoGrupoAlterou;
                bu.codigoEmpresa        = bc.codigoEmpresaAlterou;
                bu.codigoUsuario        = bc.usuarioAlterou;
                PegaUsuario();
            }
            label_alteracao.setText("Última alteração em " + bc.dataAlterou + " às " + bc.horaAlterou + " por " + bu.usuario);
        }
        PegaCEP();
        if(dadosCEP.isEmpty()){
            txt_cep     .setText(bc.cep);
            txt_cidade  .setText(bc.cidade);
            txt_endereco.setText(bc.endereco);
            txt_bairro  .setText(bc.bairro);
            combo_UF    .setSelectedItem(bc.uf);
        }
        if(bc.codigoPais != 0){
            txt_codigoPais.setText(String.valueOf(bc.codigoPais));
            PegaPais();
        }
    }
    
    private void PegaCEP(){
        bc.cep = txt_cep.getText();
        bc.cep = bc.cep.replace(" ", "");
        bc.cep = bc.cep.replace("-", "");
        if(bc.cep.equals(""))
            return;
        sql = "select * from ns_cep where cep = " + bc.cep + ";";
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
        combo_UF.setSelectedItem(bcep.uf);
        txt_numero.grabFocus();
        txt_codigoPais.setText("1058");
        PegaPais();
    }

    private void PegaUF() {
        combo_UF.removeAllItems();
        combo_UF.addItem("");
        sql = "select uf from ns_estados;";
        dadosEstados.clear();
        dadosEstados = parametrosNS.dao.Consulta(sql);
        if(dadosEstados.isEmpty()){
            mensagem = "Unidades Federativas Não encontradas!";
            new MostraMensagem(mensagem);
            return;
        }
        PegaDadosUF();
    }
    
    private void PegaDadosUF(){
        for(int i = 0; i < dadosEstados.size(); i++){
            best.uf = String.valueOf(dadosEstados.get(i).get(0));
            combo_UF.addItem(best.uf);
        }
    }
    
    private void PegaPais(){
        if(abriuPais == 1)
            return;
        bpais.codigoPais = Integer.parseInt(fc.FormataCampo(txt_codigoPais.getText(), 4, 0));
        if(bpais.codigoPais == 0){
            HabilitaBotoes();
            return;
        }
        sql = "select * from ns_paises where codigoPais = '" + bpais.codigoPais + "';";
        //System.out.println(sql);
        dadosPaises.clear();
        dadosPaises = parametrosNS.dao.Consulta(sql);
        if(dadosPaises.isEmpty()){
            label_pais.setText("Não Existe");
            return;
        }
        PegaDadosPais();
    }
    
    private void PegaDadosPais(){
        for(int i = 0; i < dadosPaises.size(); i++){
            bpais.codigoPais = Integer.parseInt(  String.valueOf(dadosPaises.get(i).get(0)));
            bpais.nomePais   =                    String.valueOf(dadosPaises.get(i).get(1));
        }
        txt_codigoPais.setText(fc.FormataCampo(txt_codigoPais.getText(), 4, 0));
        label_pais.setText(bpais.nomePais);
    }
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_incluir      .setEnabled     (true);
            bt_incluir      .setFocusable   (true);
            bt_alterar      .setEnabled     (false);
            bt_alterar      .setFocusable   (false);
            bt_contratos    .setEnabled     (false);
            bt_contratos    .setFocusable   (false);
            bt_historico    .setEnabled     (false);
            bt_historico    .setFocusable   (false);
            return;
        }
        if(operacao.equals("A")){
            bt_incluir      .setEnabled     (false);
            bt_incluir      .setFocusable   (false);
            bt_alterar      .setEnabled     (true);
            bt_alterar      .setFocusable   (true);
            bt_contratos    .setEnabled     (true);
            bt_contratos    .setFocusable   (true);
            bt_historico    .setEnabled     (true);
            bt_historico    .setFocusable   (true);
            return;
        }
        bt_incluir          .setEnabled     (false);
        bt_incluir          .setFocusable   (false);
        bt_alterar          .setEnabled     (false);
        bt_alterar          .setFocusable   (false);
        bt_contratos        .setEnabled     (false);
        bt_contratos        .setFocusable   (false);
        bt_historico        .setEnabled     (false);
        bt_historico        .setFocusable   (false);
    }
    
    private void VerificaUltimoRegistro(){
        sql = "select max(codigoCliente) from tb_clientes where codigoGrupo = " + parametrosNS.bge.codigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + ";";
        dadosAutoIncremento.clear();
        dadosAutoIncremento = parametrosNS.dao.Consulta(sql);
        if(!dadosAutoIncremento.isEmpty())
            if(dadosAutoIncremento.get(0).get(0) != null)
                UltimoRegistro = Integer.parseInt(String.valueOf(dadosAutoIncremento.get(0).get(0)));
    }
    
    private void ReiniciaTela(boolean Habilita){
        ReiniciaCampos();
        HabilitaCampos(Habilita);
        bt_incluir.setEnabled(false);
        bt_alterar.setEnabled(false);
    }
    
    private void ReiniciaCampos(){
        bc      = new BeanClientes();
        bcep    = new BeanCEP();
        bpais   = new BeanPais();
        bu      = new BeanUsuarios();
        combo_pessoa            .setSelectedIndex(0);
        txt_cpfcnpj1            .setText(fc.FormataCampo("", 9, 0));
        txt_cpfcnpj2            .setText(fc.FormataCampo("", 4, 0));
        txt_cpfcnpj3            .setText(fc.FormataCampo("", 2, 0));
        txt_inscricaoEstadual   .setText("");
        txt_nascimento          .setText("");
        txt_dataCadastro      .setText(cdh.CapturarData());
        txt_nome                .setText("");
        combo_sexo              .setSelectedIndex(0);
        combo_estadoCivil       .setSelectedIndex(0);
        txt_telefone            .setText("");
        txt_contato             .setText("");
        txt_email               .setText("");
        txt_cei                 .setText("");
        txt_celular             .setText("");
        txt_profissao           .setText("");
        txt_site                .setText("");
        txt_contrato            .setText("");
        txt_cep                 .setText("");
        txt_cidade              .setText("");
        txt_endereco            .setText("");
        txt_numero              .setText("");
        txt_bairro              .setText("");
        combo_UF                .setSelectedIndex(0);
        txt_codigoPais          .setText("");
        label_pais              .setText("");
        txt_observacoes         .setText("");
        label_alteracao         .setText("");
    }
    
    private void HabilitaCampos(boolean Habilita){
        check_bloqueado         .setEnabled     (Habilita);
        check_bloqueado         .setFocusable   (Habilita);
        combo_pessoa            .setEnabled     (Habilita);
        combo_pessoa            .setFocusable   (Habilita);
        chech_NaoInformar       .setEnabled     (Habilita);
        chech_NaoInformar       .setFocusable   (Habilita);
        txt_cpfcnpj1            .setEditable    (Habilita);
        txt_cpfcnpj1            .setFocusable   (Habilita);
        txt_cpfcnpj2            .setEditable    (Habilita);
        txt_cpfcnpj2            .setFocusable   (Habilita);
        txt_cpfcnpj3            .setEditable    (Habilita);
        txt_cpfcnpj3            .setFocusable   (Habilita);
        txt_inscricaoEstadual   .setEditable    (Habilita);
        txt_inscricaoEstadual   .setFocusable   (Habilita);
        txt_nascimento          .setEditable    (Habilita);
        txt_nascimento          .setFocusable   (Habilita);
//        txt_dataDeCadastro      .setEditable    (Habilita);
//        txt_dataDeCadastro      .setFocusable   (Habilita);
        jTabbedPane1            .setEnabled     (Habilita);
        jTabbedPane1            .setFocusable   (Habilita);
        txt_nome                .setEditable    (Habilita);
        txt_nome                .setFocusable   (Habilita);
        combo_sexo              .setEnabled     (Habilita);
        combo_sexo              .setFocusable   (Habilita);
        combo_estadoCivil       .setEnabled     (Habilita);
        combo_estadoCivil       .setFocusable   (Habilita);
        txt_telefone            .setEditable    (Habilita);
        txt_telefone            .setFocusable   (Habilita);
        txt_contato             .setEditable    (Habilita);
        txt_contato             .setFocusable   (Habilita);
        txt_email               .setEditable    (Habilita);
        txt_email               .setFocusable   (Habilita);
        txt_cei                 .setEditable    (Habilita);
        txt_cei                 .setFocusable   (Habilita);
        txt_celular             .setEditable    (Habilita);
        txt_celular             .setFocusable   (Habilita);
        txt_profissao           .setEditable    (Habilita);
        txt_profissao           .setFocusable   (Habilita);
        txt_site                .setEditable    (Habilita);
        txt_site                .setFocusable   (Habilita);
        txt_contrato            .setEditable    (Habilita);
        txt_contrato            .setFocusable   (Habilita);
        txt_cep                 .setEditable    (Habilita);
        txt_cep                 .setFocusable   (Habilita);
        bt_pesquisaeCEP         .setEnabled     (Habilita);
        bt_pesquisaeCEP         .setFocusable   (Habilita);
        txt_cidade              .setEditable    (Habilita);
        txt_cidade              .setFocusable   (Habilita);
        txt_endereco            .setEditable    (Habilita);
        txt_endereco            .setFocusable   (Habilita);
        txt_numero              .setEditable    (Habilita);
        txt_numero              .setFocusable   (Habilita);
        txt_bairro              .setEditable    (Habilita);
        txt_bairro              .setFocusable   (Habilita);
        combo_UF                .setEnabled     (Habilita);
        combo_UF                .setFocusable   (Habilita);
        txt_codigoPais          .setEditable    (Habilita);
        txt_codigoPais          .setFocusable   (Habilita);
        bt_pesquisaPais         .setEnabled     (Habilita);
        bt_pesquisaPais         .setFocusable   (Habilita);
        label_pais              .setEnabled     (Habilita);
        label_pais              .setFocusable   (Habilita);
        txt_observacoes         .setEditable    (Habilita);
        txt_observacoes         .setFocusable   (Habilita);
    }
    
    private void PegaValores(){
        fatal = "N";
        bc.idEmpresa        = parametrosNS.be.IdEmpresa;
        bc.codigoGrupo      = parametrosNS.bge.CodigoGrupo;
        bc.codigoEmpresa    = parametrosNS.be.CodigoEmpresa;
        bc.codigoCliente    = Integer.parseInt(txt_codigoCliente.getText());
        if(check_bloqueado.isSelected() == false)
            bc.statusCliente    = 0;
        else
            bc.statusCliente    = 1;
        bc.fisicaJuridica   = combo_pessoa.getSelectedIndex();
        if(chech_NaoInformar.isSelected() == false)
            bc.cpfCnpjNaoInformado = 0;
        else
            bc.cpfCnpjNaoInformado = 1;
        if(ValidadorCpfCnpj == false){
            mensagem = "CPF ou CNPJ inválido!";
            new MostraMensagem(mensagem);
            fatal = "S";
            return;
        }
        bc.cpfCnpj1 = txt_cpfcnpj1.getText().replace(" ", "");
        bc.cpfCnpj2 = txt_cpfcnpj2.getText().replace(" ", "");
        bc.cpfCnpj3 = txt_cpfcnpj3.getText().replace(" ", "");
        bc.cpfCnpj = bc.cpfCnpj1 + bc.cpfCnpj2 + bc.cpfCnpj3;
        if(bc.cpfCnpj.equals(""))
            bc.cpfCnpj = fc.FormataCampo("", 15, 0);
        if(ValidadorIE == false){
            mensagem = "Inscrição Estadual Inválida!";
            new MostraMensagem(mensagem);
            fatal = "S";
            return;
        }
        bc.InscricaoEstadual        = txt_inscricaoEstadual.getText().replace(" ", "").toUpperCase();
        if(!bc.InscricaoEstadual.equalsIgnoreCase("ISENTO")){
            bc.InscricaoEstadual        = bc.InscricaoEstadual.replace(".", "");
            bc.InscricaoEstadual1       = bc.InscricaoEstadual.substring(0, 3);
            bc.InscricaoEstadual2       = bc.InscricaoEstadual.substring(3, 6);
            bc.InscricaoEstadual3       = bc.InscricaoEstadual.substring(6, 9);
            bc.InscricaoEstadual4       = bc.InscricaoEstadual.substring(9,12);
            bc.RecarregaInscricaoEstadual();
        }
        bc.dataNascAber         = txt_nascimento.getText();
        bc.dataNascAber         = bc.dataNascAber.replace(" ", "");
        bc.dataNascAber         = bc.dataNascAber.replace("/", "");
        if(!bc.dataNascAber.equals("") & Integer.parseInt(parametrosNS.fc.FormataCampo(bc.dataNascAber, 8, 0)) != 0)
            bc.dataNascAber     = "'" + invdata.inverterData(bc.dataNascAber, 2) + "'";
        else
            bc.dataNascAber     = null;
        bc.dataCadastro         = invdata.inverterData(txt_dataCadastro.getText(), 2);
        bc.nome                 = txt_nome.getText();
        bc.sexo                 = combo_sexo.getSelectedIndex();
        bc.estadoCivil          = combo_estadoCivil.getSelectedIndex();
        bc.telefone             = txt_telefone.getText();
        bc.telefone             = bc.telefone.replace("(", "");
        bc.telefone             = bc.telefone.replace(")", "");
        bc.telefone             = bc.telefone.replace(" ", "");
        bc.telefone             = bc.telefone.replace("-", "");
        if(!bc.telefone.equals(""))
            bc.telefone     = "'" + bc.telefone + "'";
        else
            bc.telefone     = null;
        bc.contato              = txt_contato.getText();
        bc.email                = txt_email.getText();
        bc.cei                  = txt_cei.getText();
        bc.celular              = txt_celular.getText();
        bc.celular              = bc.celular.replace("(", "");
        bc.celular              = bc.celular.replace(")", "");
        bc.celular              = bc.celular.replace(" ", "");
        bc.celular              = bc.celular.replace("-", "");
        if(!bc.celular.equals(""))
            bc.celular      = "'" + bc.celular + "'";
        else
            bc.celular      = null;
        bc.profissao            = txt_profissao.getText();
        bc.site                 = txt_site.getText();
        bc.contrato             = txt_contrato.getText();
        bc.cep                  = txt_cep.getText();
        bc.cep                  = bc.cep.replace(" ", "");
        bc.cep                  = bc.cep.replace("-", "");
        if(!bc.cep.equals(""))
            bc.cep  = "'" + txt_cep.getText() + "'";
        else
            bc.cep  = null;
        bc.cidade               = txt_cidade.getText();
        bc.bairro               = txt_bairro.getText();
        bc.endereco             = txt_endereco.getText();
        bc.numero               = txt_numero.getText();
        bc.uf                   = String.valueOf(combo_UF.getSelectedItem());
        bc.codigoPais           = Integer.parseInt(fc.FormataCampo(txt_codigoPais.getText(), 4, 0));
        bc.observacoes          = txt_observacoes.getText();
        
        bc.idEmpresaAlterou     = parametrosNS.be.idEmpresa;
        bc.codigoGrupoAlterou   = parametrosNS.bge.codigoGrupo;
        bc.codigoEmpresaAlterou = parametrosNS.be.codigoEmpresa;
        bc.dataAlterou          = invdata.inverterData(cdh.CapturarData(), 2);
        bc.horaAlterou          = cdh.CapturaHora();
        bc.usuarioAlterou       = parametrosNS.bu.codigoUsuario;
    }
    
    private void PegaUsuario(){
        bu.usuario = "----------";
        sql = "select usuario from tb_usuarios where codigoGrupo = " + bu.codigoGrupo + " and codigoEmpresa = " + bu.codigoEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
        dadosUsuario.clear();
        dadosUsuario = parametrosNS.dao.Consulta(sql);
        if(dadosUsuario.isEmpty()){
            mensagem = "Usuario " + bc.usuarioAlterou + " não encontrado!";
            new MostraMensagem(mensagem);
            return;
        }
        PegaDadosUsuario();
    }
    
    private void PegaDadosUsuario(){
        for(int i = 0; i < dadosUsuario.size(); i++)
            bu.usuario              = String.valueOf(dadosUsuario.get(i).get(0));
    }
    
    private void VerificaSexo(){
        if(bc.fisicaJuridica == 0){
            HabilitaBotoes();
            return;
        }
        bc.sexo = combo_sexo.getSelectedIndex();
        if(bc.sexo == 0){
            mensagem = "Sexo inválido!";
            new MostraMensagem(mensagem);
            bt_incluir.setEnabled(false);
            bt_alterar.setEnabled(false);
            return;
        }
        if(ValidadorCpfCnpj == false)return;
        if(ValidadorIE      == false)return;
        HabilitaBotoes();
    }

    private void VerificaEstadoCivil() {
        if(bc.fisicaJuridica == 0){
            HabilitaBotoes();
            return;
        }
        bc.estadoCivil = combo_estadoCivil.getSelectedIndex();
        if(bc.estadoCivil == 0){
            mensagem = "Estado Civil inválido!";
            new MostraMensagem(mensagem);
            combo_estadoCivil.grabFocus();
            bt_incluir.setEnabled(false);
            bt_alterar.setEnabled(false);
            return;
        }
        if(ValidadorCpfCnpj == false)return;
        if(ValidadorIE      == false)return;
        HabilitaBotoes();
    }
    
    private void VerificaTipoPessoa(){
        txt_cpfcnpj1.setText("");
        txt_cpfcnpj2.setText("");
        txt_cpfcnpj3.setText("");
        if(combo_pessoa.getSelectedIndex() == 1){
            txt_cpfcnpj2.setEditable(false);
            txt_cpfcnpj2.setFocusable(false);
            combo_sexo.setEnabled(true);
            combo_estadoCivil.setEnabled(true);
            return;
        }
        txt_cpfcnpj2.setEditable(true);
        txt_cpfcnpj2.setFocusable(true);
        combo_sexo.setEnabled(false);
        combo_estadoCivil.setEnabled(false);
    }
    
}
