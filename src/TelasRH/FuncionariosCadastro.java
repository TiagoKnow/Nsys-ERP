package TelasRH;

import Beans.BeanDepartamento;
import Beans.BeanFuncionarios;
import Beans.BeanUsuarios;
import BeansNS.BeanCEP;
import BeansNS.BeanEmpresas;
import BeansNS.BeanEstados;
import BeansNS.BeanPais;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.PegaProximoRegistro;
import FuncoesInternas.ValidarCpfCnpj;
import FuncoesInternas.ValidarData;
import Parametros.parametrosNS;
import Telas.CodigoEnderecamentoPostalConsulta;
import TelasDeConfiguracoes.EmpresasConsulta;
import Telas.DepartamentosConsulta;
import Telas.PaisesConsulta;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * @author Tiago
 */
public class FuncionariosCadastro extends javax.swing.JFrame {
    //String
    String sql                    = "";
    String sqlstate               = "";
    String fatal                  = "";
    String somostra               = "";
    String mensagem               = "";
    String operacao               = "";
    String retorno                = "";
    String ValidaData             = "";
    String pastaImagemFuncionario = "";
    
    //int
    int abriuCEP          = 0;
    int abriuDepartamento = 0;
    int abriuEmpresa      = 0;
    int abriuFuncionario  = 0;
    int abriuPais         = 0;
    
    //boolean
    boolean validadorCpfCnpj;
    boolean validadorDataAdmissao;
    boolean ValidaRG;
    
    //Vetores
    ArrayList            parametros         = new ArrayList();
    ArrayList<ArrayList> dadosCEP           = new ArrayList();
    ArrayList<ArrayList> dadosDepartamentos = new ArrayList();
    ArrayList<ArrayList> dadosEmpresas      = new ArrayList();
    ArrayList<ArrayList> dadosEstados       = new ArrayList();
    ArrayList<ArrayList> dadosFuncionarios  = new ArrayList();
    ArrayList<ArrayList> dadosPaises        = new ArrayList();
    ArrayList<ArrayList> dadosUsuarios      = new ArrayList();
    
    //Bean
    BeanCEP          bcep  = new BeanCEP();
    BeanDepartamento bd    = new BeanDepartamento();
    BeanEmpresas     be    = new BeanEmpresas();
    BeanEstados      best  = new BeanEstados();
    BeanFuncionarios bfunc = new BeanFuncionarios();
    BeanPais         bpais = new BeanPais();
    BeanUsuarios     bu    = new BeanUsuarios();
    
    //Outros
    CapturarDataHora    cdh          = new CapturarDataHora();
    PegaProximoRegistro PegProReg    = new PegaProximoRegistro();
    FormataCampo        fc           = new FormataCampo();
    ValidarCpfCnpj      Vcc          = new ValidarCpfCnpj();
    ValidarData         ValData      = new ValidarData();
    JFileChooser        seletor      = new JFileChooser();
    File                arquivoPasta = null;
    
    //Telas
    CodigoEnderecamentoPostalConsulta CodEndPosCon;
    DepartamentosConsulta             DepCon;
    EmpresasConsulta                  EmpCon;
    FuncionariosConsulta              FunCon;
    PaisesConsulta                    PaiCon;
    
    //Especiais
    BufferedImage                   BuffImg;
    ByteArrayOutputStream           BytesImg;
    ImageIcon                       imgIcon;
    Image                           img;
    
    public FuncionariosCadastro(String Somostra, int idFuncionario){
        somostra            = Somostra;
        bfunc.idFuncionario = idFuncionario;
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_rg = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        combo_estadoCivil = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        combo_sexo = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        txt_profissao = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txt_dataNascimento = new javax.swing.JFormattedTextField();
        jLabel24 = new javax.swing.JLabel();
        txt_nacionalidade = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txt_naturalidade = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        combo_UFnaturalidade = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txt_endereco = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_cep = new javax.swing.JFormattedTextField();
        jLabel27 = new javax.swing.JLabel();
        txt_complemento = new javax.swing.JTextField();
        txt_numero = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txt_bairro = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txt_telefone = new javax.swing.JFormattedTextField();
        jLabel32 = new javax.swing.JLabel();
        txt_celular = new javax.swing.JFormattedTextField();
        jLabel33 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_observacoes = new javax.swing.JTextArea();
        bt_pesquisaCep = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        combo_UF = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txt_codigoDepartamento = new javax.swing.JFormattedTextField();
        bt_pesquisaDepartamento = new javax.swing.JButton();
        label_descricaoDepartamento = new javax.swing.JLabel();
        txt_dataAdmissao = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_cidade = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_municipio = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_codigoPais = new javax.swing.JFormattedTextField();
        bt_pesquisaPais = new javax.swing.JButton();
        label_pais = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        bt_novo = new javax.swing.JButton();
        txt_codigoFuncionario = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        txt_cpf = new javax.swing.JFormattedTextField();
        radio_Fisica = new javax.swing.JRadioButton();
        radio_Juridica = new javax.swing.JRadioButton();
        txt_cnpj = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_dataCadastro = new javax.swing.JFormattedTextField();
        bt_incluir = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_pesquisa = new javax.swing.JButton();
        bt_imprimir = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        label_imagem = new javax.swing.JLabel();
        bt_selecionarImagem = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        bt_pesquisaEmpresa = new javax.swing.JButton();
        label_nomeEmpresa = new javax.swing.JLabel();
        txt_codigoEmpresa = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        check_bloqueado = new javax.swing.JCheckBox();
        jLabel35 = new javax.swing.JLabel();
        label_alteracao = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Funcionários");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowIconified(java.awt.event.WindowEvent evt) {
                formWindowIconified(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Informações do funcionário");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Nome completo:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("RG:");

        try {
            txt_rg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_rg.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_rg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_rgFocusLost(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Estado civil:");

        combo_estadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----------", "Solteiro (a)", "Casado (a)", "Viúvo (a)", "Divorciado (a)", "União Estável" }));

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Sexo:");

        combo_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----------", "Masculino", "Feminino" }));

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Profissão:");

        txt_profissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_profissaoActionPerformed(evt);
            }
        });

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Nascimento:");

        try {
            txt_dataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataNascimento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataNascimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataNascimentoFocusLost(evt);
            }
        });

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Nacionalidade:");

        txt_nacionalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nacionalidadeActionPerformed(evt);
            }
        });

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Naturalidade:");

        jLabel26.setText("UF:");

        combo_UFnaturalidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--" }));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Endereço:");

        txt_endereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_enderecoActionPerformed(evt);
            }
        });

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Complemento:");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("CEP:");

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

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Cidade:");

        txt_complemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_complementoActionPerformed(evt);
            }
        });

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Número:");

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Bairro:");

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("Telefone:");

        try {
            txt_telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefoneActionPerformed(evt);
            }
        });

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel32.setText("Celular:");

        try {
            txt_celular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_celular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_celularActionPerformed(evt);
            }
        });

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("E-mail:");

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("Observacoes:");

        txt_observacoes.setColumns(20);
        txt_observacoes.setRows(5);
        jScrollPane1.setViewportView(txt_observacoes);

        bt_pesquisaCep.setText("...");
        bt_pesquisaCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaCepActionPerformed(evt);
            }
        });

        jLabel5.setText("UF:");

        combo_UF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--" }));
        combo_UF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_UFActionPerformed(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Departamento:");

        try {
            txt_codigoDepartamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoDepartamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoDepartamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoDepartamentoFocusLost(evt);
            }
        });

        bt_pesquisaDepartamento.setText("...");
        bt_pesquisaDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaDepartamentoActionPerformed(evt);
            }
        });

        try {
            txt_dataAdmissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataAdmissao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataAdmissao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataAdmissaoFocusLost(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Data de admissão:");

        txt_cidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cidadeActionPerformed(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Munícipio:");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("País:");

        try {
            txt_codigoPais.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoPais.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoPais.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoPaisFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoPaisFocusLost(evt);
            }
        });

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
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_rg))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(261, 261, 261)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(combo_estadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_nacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(7, 7, 7)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_naturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_municipio, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_profissao)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_pesquisaCep, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_dataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_dataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(txt_codigoDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_pesquisaDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label_descricaoDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_endereco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txt_bairro, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                                .addComponent(txt_numero)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)))
                                    .addComponent(combo_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_codigoPais, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(bt_pesquisaPais, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(label_pais, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_complemento, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(combo_UFnaturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(combo_UF, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_telefone)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_celular, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel16, jLabel18, jLabel21, jLabel23, jLabel29, jLabel30, jLabel33, jLabel34, jLabel7, jLabel8});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel24, jLabel6});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel12, jLabel17, jLabel31});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {combo_UF, combo_UFnaturalidade});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel11, jLabel22, jLabel25});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_descricaoDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_profissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_estadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_naturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_UFnaturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaCep, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_municipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_complemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_UF, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaPais, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_pais, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {combo_UF, combo_UFnaturalidade, combo_estadoCivil, combo_sexo, jLabel16, jLabel17, jLabel18, jLabel21, jLabel22, jLabel23, jLabel24, jLabel25, jLabel26, jLabel29, jLabel30, jLabel33, jLabel34, jLabel5, jLabel6, jLabel7, jLabel8, txt_complemento, txt_dataNascimento, txt_endereco, txt_nacionalidade, txt_naturalidade, txt_profissao});

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Funcionário");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bt_novo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        try {
            txt_codigoFuncionario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoFuncionario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoFuncionario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoFuncionarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoFuncionarioFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_codigoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_novo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, txt_codigoFuncionario});

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cpf.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_cpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cpfFocusLost(evt);
            }
        });
        txt_cpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cpfKeyPressed(evt);
            }
        });

        buttonGroup1.add(radio_Fisica);
        radio_Fisica.setSelected(true);
        radio_Fisica.setText("Física");
        radio_Fisica.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radio_FisicaItemStateChanged(evt);
            }
        });
        radio_Fisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_FisicaActionPerformed(evt);
            }
        });

        buttonGroup1.add(radio_Juridica);
        radio_Juridica.setText("Jurídica");
        radio_Juridica.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radio_JuridicaItemStateChanged(evt);
            }
        });

        txt_cnpj.setEditable(false);
        try {
            txt_cnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cnpj.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_cnpj.setFocusable(false);
        txt_cnpj.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cnpjFocusLost(evt);
            }
        });
        txt_cnpj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cnpjKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(radio_Juridica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radio_Fisica, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_cpf)
                    .addComponent(txt_cnpj))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radio_Fisica, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radio_Juridica, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {radio_Fisica, radio_Juridica, txt_cpf});

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Data de cadastro");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_dataCadastro.setEditable(false);
        try {
            txt_dataCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataCadastro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataCadastro.setFocusable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_dataCadastro)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_dataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bt_incluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_incluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_incluir.setText("Incluir");
        bt_incluir.setEnabled(false);
        bt_incluir.setFocusable(false);
        bt_incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_incluirActionPerformed(evt);
            }
        });

        bt_alterar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Save.png"))); // NOI18N
        bt_alterar.setText("Alterar");
        bt_alterar.setEnabled(false);
        bt_alterar.setFocusable(false);
        bt_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterarActionPerformed(evt);
            }
        });

        bt_pesquisa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_pesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/View.png"))); // NOI18N
        bt_pesquisa.setText("Pesquisa");
        bt_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaActionPerformed(evt);
            }
        });

        bt_imprimir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/print.png"))); // NOI18N
        bt_imprimir.setText("Imprimir");
        bt_imprimir.setEnabled(false);
        bt_imprimir.setFocusable(false);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Foto 3 x 4");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        label_imagem.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bt_selecionarImagem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_selecionarImagem.setText("Selecionar Imagem");
        bt_selecionarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_selecionarImagemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_imagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_selecionarImagem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_imagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_selecionarImagem)
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Empresa");
        jLabel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bt_pesquisaEmpresa.setText("...");
        bt_pesquisaEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaEmpresaActionPerformed(evt);
            }
        });

        label_nomeEmpresa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        try {
            txt_codigoEmpresa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoEmpresa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoEmpresa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoEmpresaFocusLost(evt);
            }
        });
        txt_codigoEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoEmpresaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(txt_codigoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_pesquisaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_nomeEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_codigoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nomeEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaEmpresa, label_nomeEmpresa, txt_codigoEmpresa});

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        check_bloqueado.setText("Bloqueado");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Status");
        jLabel35.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(check_bloqueado, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check_bloqueado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        label_alteracao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_incluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(label_alteracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_alterar, bt_incluir});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_pesquisa, jButton1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bt_pesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_alteracao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_alterar, bt_imprimir, bt_incluir, bt_pesquisa, jButton1});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HabilitaCampos(false);
        
        txt_dataCadastro.setText(cdh.CapturarData());
        PegaUF();
        if(somostra.equals("S")){
            bt_novo                 .setEnabled  (false);
            bt_novo                 .setFocusable(false);
            bt_pesquisaEmpresa      .setEnabled  (false);
            bt_pesquisaDepartamento .setEnabled  (false);
            bt_pesquisaCep          .setEnabled  (false);
            bt_pesquisaPais         .setEnabled  (false);
            bt_incluir              .setVisible  (false);
            bt_alterar              .setVisible  (false);
            bt_imprimir             .setVisible  (false);
            bt_pesquisa             .setVisible  (false);
            bt_selecionarImagem     .setEnabled  (false);
            bt_selecionarImagem     .setFocusable(false);
        }
        if(bfunc.idFuncionario != 0){
            txt_codigoFuncionario.setEditable (false);
            txt_codigoFuncionario.setFocusable(false);
            sql = "select * from tb_funcionarios where idFuncionario = " + bfunc.idFuncionario + ";";
            PegaFuncionarios();
            if(somostra.equals("SN")){
                txt_codigoFuncionario   .setEditable (false);
                txt_codigoFuncionario   .setFocusable(false);
                bt_novo                 .setEnabled  (false);
                bt_novo                 .setFocusable(false);
                bt_pesquisaEmpresa      .setEnabled  (false);
                bt_pesquisaDepartamento .setEnabled  (false);
                bt_pesquisaCep          .setEnabled  (false);
                bt_pesquisaPais         .setEnabled  (false);
                bt_incluir              .setVisible  (false);
                bt_alterar              .setVisible  (false);
                bt_imprimir             .setVisible  (false);
                bt_pesquisa             .setVisible  (false);
                bt_selecionarImagem     .setEnabled  (false);
                bt_selecionarImagem     .setFocusable(false);
            }
        }else{
            txt_codigoEmpresa.setText(String.valueOf(parametrosNS.be.CodigoEmpresa));
            PegaEmpresa();
        }
        if(somostra.equals("SN"))
            bt_pesquisa.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        ReiniciaCampos();
        HabilitaCampos(true);
        HabilitaCampos();
        
        bfunc.codigoFuncionario = PegProReg.PegaProximoRegistro("tb_funcionarios", "codigoFuncionario", "");
        txt_codigoFuncionario.setText(fc.FormataCampo(String.valueOf(bfunc.codigoFuncionario), 6, 0));
        
        operacao = "I";
        HabilitaBotoes();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void bt_pesquisaEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaEmpresaActionPerformed
        if(EmpCon != null)if(EmpCon.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        abriuEmpresa = 1;
        if(parametrosNS.bu.codigoUsuario != 999)
            EmpCon = new EmpresasConsulta(parametrosNS.be.codigoEmpresa);
        else
            EmpCon = new EmpresasConsulta(parametrosNS.be.CodigoEmpresa);
        EmpCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaEmpresaActionPerformed

    private void radio_FisicaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radio_FisicaItemStateChanged
        HabilitaCampos();
    }//GEN-LAST:event_radio_FisicaItemStateChanged

    private void radio_JuridicaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radio_JuridicaItemStateChanged
        HabilitaCampos();
    }//GEN-LAST:event_radio_JuridicaItemStateChanged

    private void txt_cpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cpfKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            txt_dataAdmissao.grabFocus();
        if(evt.getKeyCode() == KeyEvent.VK_DOWN)
            radio_Juridica.setSelected(true);
    }//GEN-LAST:event_txt_cpfKeyPressed

    private void txt_cnpjKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cnpjKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            txt_dataAdmissao.grabFocus();
        if(evt.getKeyCode() == KeyEvent.VK_UP)
            radio_Fisica.setSelected(true);
    }//GEN-LAST:event_txt_cnpjKeyPressed

    private void txt_cpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfFocusLost
        ValidaCPFCNPJ();
    }//GEN-LAST:event_txt_cpfFocusLost

    private void txt_cnpjFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cnpjFocusLost
        ValidaCPFCNPJ();
    }//GEN-LAST:event_txt_cnpjFocusLost

    private void txt_codigoFuncionarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFuncionarioFocusGained
        if(txt_codigoFuncionario.isEditable() == false)
            return;
        if(txt_codigoFuncionario.getText().replace(" ", "").equals(""))
            return;
        operacao = "";
        ReiniciaTela(false);
    }//GEN-LAST:event_txt_codigoFuncionarioFocusGained

    private void txt_codigoFuncionarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFuncionarioFocusLost
        if(txt_codigoFuncionario.isEditable() == false)
            return;
        if(txt_codigoFuncionario.getText().replace(" ", "").equals(""))
            return;
        bfunc.codigoFuncionario = Integer.parseInt(fc.FormataCampo(txt_codigoFuncionario.getText(), 6, 0));
        if(bfunc.codigoFuncionario == 0)
            return;
        sql = "select * from tb_funcionarios where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoFuncionario = " + bfunc.codigoFuncionario + ";";
        PegaFuncionarios();
    }//GEN-LAST:event_txt_codigoFuncionarioFocusLost

    private void txt_dataAdmissaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataAdmissaoFocusLost
        String Data = txt_dataAdmissao.getText();
        Data = Data.replace(" ", " ");
        Data = Data.replace("/", " ");
        if(Data.equals(""))
        return;
        bt_incluir.setEnabled(false);
        bt_alterar.setEnabled(false);
        ValidaData = ValData.ValidaData(Data);
        if(ValidaData.equals("N"))
            return;
        HabilitaBotoes();
    }//GEN-LAST:event_txt_dataAdmissaoFocusLost

    private void bt_pesquisaDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaDepartamentoActionPerformed
        if(DepCon != null)if(DepCon.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        abriuDepartamento = 1;
        DepCon = new DepartamentosConsulta("N");
        DepCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaDepartamentoActionPerformed

    private void txt_codigoDepartamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoDepartamentoFocusLost
        if(txt_codigoDepartamento.isEditable() == false)
            return;
        if(txt_codigoDepartamento.getText().replace(" ", "").equals(""))
            return;
        PegaDepartamento();
    }//GEN-LAST:event_txt_codigoDepartamentoFocusLost

    private void txt_dataNascimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataNascimentoFocusLost
        String Data = txt_dataNascimento.getText();
        Data = Data.replace(" ", "");
        Data = Data.replace("/", "");
        if(Data.equals(""))
            return;
        ValidaData = ValData.ValidaData(Data);
        if(ValidaData.equals("S"))
            return;
        mensagem = "Data de nascimento inválida!";
        mostraMensagem();
        txt_dataNascimento.setText("");
    }//GEN-LAST:event_txt_dataNascimentoFocusLost

    private void txt_rgFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_rgFocusLost
        if(txt_rg.isEditable() == false)
            return;
        //        if(somostra.equals("N"))
        //            return;
        ValidaRG = parametrosNS.ValRG.ValidarRG(txt_rg.getText());
        if(ValidaRG == true)
            return;
        mensagem = "RG invalido!";
        new MostraMensagem(mensagem);
    }//GEN-LAST:event_txt_rgFocusLost

    private void bt_pesquisaCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaCepActionPerformed
        if(CodEndPosCon != null)if(CodEndPosCon.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        abriuCEP = 1;
        CodEndPosCon = new CodigoEnderecamentoPostalConsulta();
        CodEndPosCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaCepActionPerformed

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        IncluirFuncionario();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void bt_selecionarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_selecionarImagemActionPerformed
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
        pastaImagemFuncionario = arquivoPasta.getPath();
        CarregaImagem();
    }//GEN-LAST:event_bt_selecionarImagemActionPerformed

    public void CarregaImagem(){
        imgIcon = null;
        imgIcon = new ImageIcon(pastaImagemFuncionario);
        img     = imgIcon.getImage();
        img     = img.getScaledInstance(label_imagem.getWidth() - 5, label_imagem.getHeight() - 5, img.SCALE_DEFAULT);
        label_imagem.setIcon(new ImageIcon(img));
    }
    
    private void txt_cepFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cepFocusGained
        if(txt_cep.isEditable() == false)
            return;
//        if(somostra.equals("S"))
//            return;
        txt_cep.setSelectionStart(0);
        txt_cep.setSelectionEnd  (txt_cep.getText().length());
    }//GEN-LAST:event_txt_cepFocusGained

    private void txt_cepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cepFocusLost
        if(txt_cep.isEditable() == false)
            return;
//        if(somostra.equals("S"))
//            return;
        PegaCep();
    }//GEN-LAST:event_txt_cepFocusLost

    private void txt_codigoPaisFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPaisFocusGained
        if(txt_codigoPais.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        txt_codigoPais.setSelectionStart(0);
        txt_codigoPais.setSelectionEnd  (txt_codigoPais.getText().length());
    }//GEN-LAST:event_txt_codigoPaisFocusGained

    private void txt_codigoPaisFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPaisFocusLost
        if(txt_codigoPais.isEditable() == false)
            return;
        if(txt_codigoPais.getText().replace(" ", "").equals(""))
            return;
        PegaPais();
    }//GEN-LAST:event_txt_codigoPaisFocusLost

    private void bt_pesquisaPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaPaisActionPerformed
        if(PaiCon != null)if(PaiCon.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        abriuPais = 1;
        PaiCon = new PaisesConsulta();
        PaiCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaPaisActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuEmpresa == 0){
            AbreDepartamento();
            return;
        }
        abriuEmpresa = 0;
        retorno = EmpCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoEmpresa.setText(retorno);
        PegaEmpresa();
    }//GEN-LAST:event_formWindowGainedFocus

    private void AbreDepartamento(){
        if(abriuDepartamento == 0){
            AbreCEP();
            return;
        }
        abriuDepartamento = 0;
        retorno = DepCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoDepartamento.setText(retorno);
        PegaDepartamento();
    }
    
    private void AbreCEP(){
        if(abriuCEP == 0){
            AbrePais();
            return;
        }
        abriuCEP = 0;
        retorno = CodEndPosCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_cep.setText(retorno);
        PegaCep();
    }
    
    private void AbrePais(){
        if(abriuPais == 0){
            AbreFuncionarios();
            return;
        }
        abriuPais = 0;
        retorno = PaiCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoPais.setText(retorno);
        PegaPais();
    }
    
    private void AbreFuncionarios(){
        if(abriuFuncionario == 0)
            return;
        abriuFuncionario = 0;
        retorno = FunCon.getRetorno();
        if(retorno.equals(""))
            return;
        bfunc.idFuncionario = Integer.parseInt(retorno);
        sql = "select * from tb_funcionarios where idFuncionario = " + bfunc.idFuncionario + ";";
        PegaFuncionarios();
    }
    
    private void txt_codigoEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoEmpresaActionPerformed

    private void txt_codigoEmpresaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoEmpresaFocusLost
        if(txt_codigoEmpresa.isEditable() == false)
            return;
        if(txt_codigoEmpresa.getText().replace(" ", "").equals(""))
            return;
        PegaEmpresa();
    }//GEN-LAST:event_txt_codigoEmpresaFocusLost

    private void txt_cidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cidadeActionPerformed

    private void combo_UFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_UFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_UFActionPerformed

    private void txt_complementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_complementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_complementoActionPerformed

    private void txt_celularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_celularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_celularActionPerformed

    private void txt_enderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_enderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_enderecoActionPerformed

    private void txt_telefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefoneActionPerformed

    private void txt_nacionalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nacionalidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nacionalidadeActionPerformed

    private void txt_profissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_profissaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_profissaoActionPerformed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        AlterarFuncionario();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        if(FunCon != null)if(FunCon.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        abriuFuncionario = 1;
        FunCon = new FuncionariosConsulta("S");
        FunCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void radio_FisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_FisicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radio_FisicaActionPerformed

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowIconified
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_imprimir;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisa;
    private javax.swing.JButton bt_pesquisaCep;
    private javax.swing.JButton bt_pesquisaDepartamento;
    private javax.swing.JButton bt_pesquisaEmpresa;
    private javax.swing.JButton bt_pesquisaPais;
    private javax.swing.JButton bt_selecionarImagem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox check_bloqueado;
    private javax.swing.JComboBox<String> combo_UF;
    private javax.swing.JComboBox<String> combo_UFnaturalidade;
    private javax.swing.JComboBox<String> combo_estadoCivil;
    private javax.swing.JComboBox<String> combo_sexo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
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
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_alteracao;
    private javax.swing.JLabel label_descricaoDepartamento;
    private javax.swing.JLabel label_imagem;
    private javax.swing.JLabel label_nomeEmpresa;
    private javax.swing.JLabel label_pais;
    private javax.swing.JRadioButton radio_Fisica;
    private javax.swing.JRadioButton radio_Juridica;
    private javax.swing.JTextField txt_bairro;
    private javax.swing.JFormattedTextField txt_celular;
    private javax.swing.JFormattedTextField txt_cep;
    private javax.swing.JTextField txt_cidade;
    private javax.swing.JFormattedTextField txt_cnpj;
    private javax.swing.JFormattedTextField txt_codigoDepartamento;
    private javax.swing.JFormattedTextField txt_codigoEmpresa;
    private javax.swing.JFormattedTextField txt_codigoFuncionario;
    private javax.swing.JFormattedTextField txt_codigoPais;
    private javax.swing.JTextField txt_complemento;
    private javax.swing.JFormattedTextField txt_cpf;
    private javax.swing.JFormattedTextField txt_dataAdmissao;
    private javax.swing.JFormattedTextField txt_dataCadastro;
    private javax.swing.JFormattedTextField txt_dataNascimento;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_endereco;
    private javax.swing.JTextField txt_municipio;
    private javax.swing.JTextField txt_nacionalidade;
    private javax.swing.JTextField txt_naturalidade;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_numero;
    private javax.swing.JTextArea txt_observacoes;
    private javax.swing.JTextField txt_profissao;
    private javax.swing.JFormattedTextField txt_rg;
    private javax.swing.JFormattedTextField txt_telefone;
    // End of variables declaration//GEN-END:variables
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_incluir      .setEnabled     (true);
            bt_incluir      .setFocusable   (true);
            bt_alterar      .setEnabled     (false);
            bt_alterar      .setFocusable   (false);
//            bt_contratos    .setEnabled     (false);
//            bt_contratos    .setFocusable   (false);
//            bt_historico    .setEnabled     (false);
//            bt_historico    .setFocusable   (false);
            return;
        }
        if(operacao.equals("A")){
            bt_incluir      .setEnabled     (false);
            bt_incluir      .setFocusable   (false);
            bt_alterar      .setEnabled     (true);
            bt_alterar      .setFocusable   (true);
//            bt_contratos    .setEnabled     (true);
//            bt_contratos    .setFocusable   (true);
//            bt_historico    .setEnabled     (true);
//            bt_historico    .setFocusable   (true);
            return;
        }
        bt_incluir          .setEnabled     (false);
        bt_incluir          .setFocusable   (false);
        bt_alterar          .setEnabled     (false);
        bt_alterar          .setFocusable   (false);
//        bt_contratos        .setEnabled     (false);
//        bt_contratos        .setFocusable   (false);
//        bt_historico        .setEnabled     (false);
//        bt_historico        .setFocusable   (false);
    }
    
    private void ReiniciaTela(boolean Habilita){
        txt_codigoFuncionario.setText("");
        ReiniciaCampos();
        HabilitaCampos(Habilita);
        HabilitaBotoes();
    }
    
    private void ReiniciaCampos(){
        check_bloqueado         .setSelected(false);
        txt_dataAdmissao        .setText("");
        txt_dataCadastro        .setText(parametrosNS.cdh.CapturarData());
        radio_Fisica            .setSelected(true);
        txt_cpf                 .setText(null);
        radio_Juridica          .setSelected(false);
        txt_cnpj                .setText(null);
        txt_codigoDepartamento  .setText("");
        txt_nome                .setText("");
        txt_rg                  .setText("");
        combo_sexo              .setSelectedIndex(0);
        combo_estadoCivil       .setSelectedIndex(0);
        txt_profissao           .setText("");
        txt_dataNascimento      .setText("");
        txt_nacionalidade       .setText("");
        txt_naturalidade        .setText("");
        combo_UFnaturalidade    .setSelectedIndex(0);
        txt_cep                 .setText("");
        txt_cidade              .setText("");
        txt_municipio           .setText("");
        txt_endereco            .setText("");
        txt_complemento         .setText("");
        txt_bairro              .setText("");
        txt_codigoPais          .setText("");
        txt_numero              .setText("");
        combo_UF                .setSelectedIndex(0);
        txt_telefone            .setText("");
        txt_celular             .setText("");
        txt_email               .setText("");
        txt_observacoes         .setText("");
        label_imagem            .setIcon(null);
        label_alteracao         .setText("");
    }
    
    private void HabilitaCampos(boolean Habilita){
        txt_codigoEmpresa       .setEditable (false);
        txt_codigoEmpresa       .setFocusable(false);
        bt_pesquisaEmpresa      .setEnabled  (false);
        bt_pesquisaEmpresa      .setFocusable(false);
        if(parametrosNS.bu.codigoUsuario == 999){
            txt_codigoEmpresa       .setEditable (true);
            txt_codigoEmpresa       .setFocusable(true);
            bt_pesquisaEmpresa      .setEnabled  (true);
            bt_pesquisaEmpresa      .setFocusable(true);
        }
        check_bloqueado         .setEnabled  (Habilita);
        check_bloqueado         .setFocusable(Habilita);
        txt_dataAdmissao        .setEditable (Habilita);
        txt_dataAdmissao        .setFocusable(Habilita);
        radio_Fisica            .setEnabled  (Habilita);
        radio_Fisica            .setFocusable(Habilita);
        txt_cpf                 .setEditable (Habilita);
        txt_cpf                 .setFocusable(Habilita);
        radio_Juridica          .setEnabled  (Habilita);
        radio_Juridica          .setFocusable(Habilita);
        txt_cnpj                .setEditable (Habilita);
        txt_cnpj                .setFocusable(Habilita);
        txt_codigoDepartamento  .setEditable (Habilita);
        txt_codigoDepartamento  .setFocusable(Habilita);
        bt_pesquisaDepartamento .setEnabled  (Habilita);
        bt_pesquisaDepartamento .setFocusable(Habilita);
        txt_nome                .setEditable (Habilita);
        txt_nome                .setFocusable(Habilita);
        txt_rg                  .setEditable (Habilita);
        txt_rg                  .setFocusable(Habilita);
        combo_sexo              .setEnabled  (Habilita);
        combo_sexo              .setFocusable(Habilita);
        combo_estadoCivil       .setEnabled  (Habilita);
        combo_estadoCivil       .setFocusable(Habilita);
        txt_profissao           .setEditable (Habilita);
        txt_profissao           .setFocusable(Habilita);
        txt_dataNascimento      .setEditable (Habilita);
        txt_dataNascimento      .setFocusable(Habilita);
        txt_nacionalidade       .setEditable (Habilita);
        txt_nacionalidade       .setFocusable(Habilita);
        txt_naturalidade        .setEditable (Habilita);
        txt_naturalidade        .setFocusable(Habilita);
        combo_UFnaturalidade    .setEnabled  (Habilita);
        combo_UFnaturalidade    .setFocusable(Habilita);
        txt_cep                 .setEditable (Habilita);
        txt_cep                 .setFocusable(Habilita);
        bt_pesquisaCep          .setEnabled  (Habilita);
        bt_pesquisaCep          .setFocusable(Habilita);
        txt_cidade              .setEditable (Habilita);
        txt_cidade              .setFocusable(Habilita);
        txt_municipio           .setEditable (Habilita);
        txt_municipio           .setFocusable(Habilita);
        txt_endereco            .setEditable (Habilita);
        txt_endereco            .setFocusable(Habilita);
        txt_complemento         .setEditable (Habilita);
        txt_complemento         .setFocusable(Habilita);
        txt_bairro              .setEditable (Habilita);
        txt_bairro              .setFocusable(Habilita);
        txt_numero              .setEditable (Habilita);
        txt_numero              .setFocusable(Habilita);
        txt_codigoPais          .setEditable (Habilita);
        txt_codigoPais          .setFocusable(Habilita);
        bt_pesquisaPais         .setEnabled  (Habilita);
        bt_pesquisaPais         .setFocusable(Habilita);
        combo_UF                .setEnabled  (Habilita);
        combo_UF                .setFocusable(Habilita);
        txt_telefone            .setEditable (Habilita);
        txt_telefone            .setFocusable(Habilita);
        txt_celular             .setEditable (Habilita);
        txt_celular             .setFocusable(Habilita);
        txt_email               .setEditable (Habilita);
        txt_email               .setFocusable(Habilita);
        txt_observacoes         .setEditable (Habilita);
        txt_observacoes         .setFocusable(Habilita);
        bt_selecionarImagem     .setEnabled  (Habilita);
        bt_selecionarImagem     .setFocusable(Habilita);
        if(somostra.equals("S")){
            bt_pesquisaDepartamento .setEnabled  (false);
            bt_pesquisaCep          .setEnabled  (false);
            bt_pesquisaCep          .setFocusable(false);
            bt_pesquisaDepartamento .setFocusable(false);
            bt_pesquisaPais         .setEnabled  (false);
            bt_pesquisaPais         .setFocusable(false);
            bt_selecionarImagem     .setEnabled  (false);
            bt_selecionarImagem     .setFocusable(false);
        }
    }

    private void PegaUF() {
        combo_UF            .removeAllItems();
        combo_UF            .addItem("--");
        combo_UFnaturalidade.removeAllItems();
        combo_UFnaturalidade.addItem("--");
        sql = "select uf from ns_estados;";
        dadosEstados.clear();
        dadosEstados = parametrosNS.dao.Consulta(sql);
        if(dadosEstados.isEmpty()){
            mensagem = "Unidades federativas não encontradas!";
            mostraMensagem();
            return;
        }
        PegaDadosUF();
    }
    
    private void PegaDadosUF(){
        for(int i = 0; i < dadosEstados.size(); i++){
            best.uf = String.valueOf(dadosEstados.get(i).get(0));
            combo_UF            .addItem(best.uf);
            combo_UFnaturalidade.addItem(best.uf);
        }
    }
    
    private void PegaFuncionarios(){
        dadosFuncionarios.clear();
        dadosFuncionarios = parametrosNS.dao.Consulta(sql);
        if(dadosFuncionarios.isEmpty()){
            mensagem = "Funcionário de código n°" + bfunc.codigoFuncionario + "!";
            mostraMensagem();
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        HabilitaCampos(true);
        PegaDadosFuncionarios();
    }
    
    private void PegaDadosFuncionarios(){
        for(int i = 0; i < dadosFuncionarios.size(); i++){
            bfunc = new BeanFuncionarios();
            if(dadosFuncionarios.get(i).get(0) != null)
                bfunc.idFuncionario         = Integer.parseInt(String.valueOf(dadosFuncionarios.get(i).get(0)));
            if(dadosFuncionarios.get(i).get(1) != null)
                bfunc.idEmpresa             = Integer.parseInt(String.valueOf(dadosFuncionarios.get(i).get(1)));
            if(dadosFuncionarios.get(i).get(2) != null)
                bfunc.codigoGrupo           = Integer.parseInt(String.valueOf(dadosFuncionarios.get(i).get(2)));
            if(dadosFuncionarios.get(i).get(3) != null)
                bfunc.codigoEmpresa         = Integer.parseInt(String.valueOf(dadosFuncionarios.get(i).get(3)));
            if(dadosFuncionarios.get(i).get(4) != null)
                bfunc.codigoFuncionario     = Integer.parseInt(String.valueOf(dadosFuncionarios.get(i).get(4)));
            if(dadosFuncionarios.get(i).get(5) != null)
                bfunc.codigoDepartamento    = Integer.parseInt(String.valueOf(dadosFuncionarios.get(i).get(5)));
            if(dadosFuncionarios.get(i).get(6) != null)
                bfunc.statusFuncionario     = Integer.parseInt(String.valueOf(dadosFuncionarios.get(i).get(6)));
                bfunc.dataCadastro          =                  String.valueOf(dadosFuncionarios.get(i).get(7));
            if(dadosFuncionarios.get(i).get(8) != null)
                bfunc.tipoPessoa            = Integer.parseInt(String.valueOf(dadosFuncionarios.get(i).get(8)));
                bfunc.cpfCnpj               =                  String.valueOf(dadosFuncionarios.get(i).get(9));
                bfunc.dataAdmissao          =                  String.valueOf(dadosFuncionarios.get(i).get(10));
                bfunc.nomeFuncionario       =                  String.valueOf(dadosFuncionarios.get(i).get(11));
                bfunc.rg                    =                  String.valueOf(dadosFuncionarios.get(i).get(12));
            if(dadosFuncionarios.get(i).get(13) != null)
                bfunc.sexo                  = Integer.parseInt(String.valueOf(dadosFuncionarios.get(i).get(13)));
            if(dadosFuncionarios.get(i).get(14) != null)
                bfunc.estadoCivil           = Integer.parseInt(String.valueOf(dadosFuncionarios.get(i).get(14)));
                bfunc.profissao             =                  String.valueOf(dadosFuncionarios.get(i).get(15));
                bfunc.dataNascimento        =                  String.valueOf(dadosFuncionarios.get(i).get(16));
                bfunc.nacionalidade         =                  String.valueOf(dadosFuncionarios.get(i).get(17));
                bfunc.naturalidade          =                  String.valueOf(dadosFuncionarios.get(i).get(18));
                bfunc.ufNaturalidade        =                  String.valueOf(dadosFuncionarios.get(i).get(19));
                bfunc.cep                   =                  String.valueOf(dadosFuncionarios.get(i).get(20));
                bfunc.cidade                =                  String.valueOf(dadosFuncionarios.get(i).get(21));
                bfunc.municipio             =                  String.valueOf(dadosFuncionarios.get(i).get(22));
                bfunc.endereco              =                  String.valueOf(dadosFuncionarios.get(i).get(23));
                bfunc.complemento           =                  String.valueOf(dadosFuncionarios.get(i).get(24));
                bfunc.bairro                =                  String.valueOf(dadosFuncionarios.get(i).get(25));
                bfunc.numero                =                  String.valueOf(dadosFuncionarios.get(i).get(26));
                bfunc.uf                    =                  String.valueOf(dadosFuncionarios.get(i).get(27));
                bfunc.codigoPais            = Integer.parseInt(String.valueOf(dadosFuncionarios.get(i).get(28)));
                bfunc.telefone              =                  String.valueOf(dadosFuncionarios.get(i).get(29));
                bfunc.celular               =                  String.valueOf(dadosFuncionarios.get(i).get(30));
                bfunc.email                 =                  String.valueOf(dadosFuncionarios.get(i).get(31));
                bfunc.observacoes           =                  String.valueOf(dadosFuncionarios.get(i).get(32));
                bfunc.dataAlterou           =                  String.valueOf(dadosFuncionarios.get(i).get(33));
                bfunc.horaAlterou           =                  String.valueOf(dadosFuncionarios.get(i).get(34));
            if(dadosFuncionarios.get(i).get(35) != null)
                bfunc.usuarioAlterou        = Integer.parseInt(String.valueOf(dadosFuncionarios.get(i).get(35)));
            if(dadosFuncionarios.get(i).get(36) != null)
                bfunc.idEmpresaAlterou      = Integer.parseInt(String.valueOf(dadosFuncionarios.get(i).get(36)));
            if(dadosFuncionarios.get(i).get(37) != null)
                bfunc.codigoGrupoAlterou    = Integer.parseInt(String.valueOf(dadosFuncionarios.get(i).get(37)));
            if(dadosFuncionarios.get(i).get(38) != null)
                bfunc.codigoEmpresaAlterou  = Integer.parseInt(String.valueOf(dadosFuncionarios.get(i).get(38)));
        }
        ValidaRG         = true;
        validadorCpfCnpj = true;
        txt_codigoFuncionario.setText(fc.FormataCampo(String.valueOf(bfunc.codigoFuncionario), 6, 0));
        
        be.idEmpresa     = bfunc.idEmpresa;
        be.codigoGrupo   = bfunc.codigoGrupo;
        be.codigoEmpresa = bfunc.codigoEmpresa;
        txt_codigoEmpresa.setText(String.valueOf(be.codigoEmpresa));
        PegaEmpresa();
        
        bfunc.dataCadastro = parametrosNS.invdata.inverterData(bfunc.dataCadastro, 1);
        txt_dataCadastro.setText(bfunc.dataCadastro);
        
        if(bfunc.tipoPessoa == 0){
            radio_Fisica.setSelected(true);
            txt_cpf .setText(bfunc.cpfCnpj);
        }else{
            radio_Juridica.setSelected(true);
            txt_cnpj.setText(bfunc.cpfCnpj.substring(1, bfunc.cpfCnpj.length()));
        }
        
        bfunc.dataAdmissao    = parametrosNS.invdata.inverterData(bfunc.dataAdmissao, 1);
        txt_dataAdmissao.setText(bfunc.dataAdmissao);
        
        bd.codigoDepartamento = bfunc.codigoDepartamento;
        txt_codigoDepartamento.setText(String.valueOf(bd.codigoDepartamento));
        PegaDepartamento();
        
        txt_nome            .setText(bfunc.nomeFuncionario);
        txt_rg              .setText(bfunc.rg);
        combo_sexo          .setSelectedIndex(bfunc.sexo);
        combo_estadoCivil   .setSelectedIndex(bfunc.estadoCivil);
        txt_profissao       .setText(bfunc.profissao);
        
        bfunc.dataNascimento = parametrosNS.invdata.inverterData(bfunc.dataNascimento, 1);
        txt_dataNascimento  .setText(bfunc.dataNascimento);
        
        txt_nacionalidade   .setText(bfunc.nacionalidade);
        txt_naturalidade    .setText(bfunc.naturalidade);
        
        combo_UFnaturalidade.setSelectedItem(bfunc.ufNaturalidade);
        txt_cep             .setText(bfunc.cep);
        PegaCep();
        if(dadosCEP.isEmpty()){
            txt_cep     .setText(bfunc.cep);
            txt_cidade  .setText(bfunc.cidade);
            txt_endereco.setText(bfunc.endereco);
            txt_bairro  .setText(bfunc.bairro);
            combo_UF    .setSelectedItem(bfunc.uf);
        }
        
        txt_codigoPais  .setText(fc.FormataCampo(String.valueOf(bfunc.codigoPais), 4, 0));
        PegaPais();
        
        txt_municipio   .setText(bfunc.municipio);
        txt_complemento .setText(bfunc.complemento);
        txt_numero      .setText(bfunc.numero);
        txt_telefone    .setText(bfunc.telefone);
        txt_celular     .setText(bfunc.celular);
        txt_email       .setText(bfunc.email);
        
        txt_observacoes .setText(bfunc.observacoes);
        
        if(bfunc.usuarioAlterou != 0){
            bu   .usuario      = "NS3";
            bfunc.dataAlterou  = parametrosNS.invdata.inverterData(bfunc.dataAlterou, 1);
            if(parametrosNS.bu.codigoUsuario != 999){
                bu.idEmpresa       = bfunc.idEmpresaAlterou;
                bu.codigoGrupo     = bfunc.codigoGrupoAlterou;
                bu.codigoEmpresa   = bfunc.codigoEmpresaAlterou;
                bu.codigoUsuario   = bfunc.usuarioAlterou;
                PegaUsuario();
            }
            label_alteracao.setText("Última alteração feita em " + bfunc.dataAlterou + " às " + bfunc.horaAlterou + " por " + bu.usuario);
        }
        
        PegaImagemFuncionario();
        if(bfunc.imagemFuncionario == null)
            return;
        try{
            BuffImg = ImageIO.read(new ByteArrayInputStream(bfunc.imagemFuncionario));
            imgIcon = new ImageIcon(BuffImg);
            img     = imgIcon.getImage();
            img     = img.getScaledInstance(label_imagem.getWidth() - 5, label_imagem.getHeight() - 5, img.SCALE_DEFAULT);
            
            label_imagem.setIcon(new ImageIcon(img));
        }catch(IOException e){
            
        }
    }
    
    private void PegaUsuario(){
        sql = "select usuario from tb_usuarios where codigoGrupo = " + bu.codigoGrupo + " and codigoEmpresa = " + bu.codigoEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
        dadosUsuarios.clear();
        dadosUsuarios = parametrosNS.dao.Consulta(sql);
        if(dadosUsuarios.isEmpty()){
            mensagem = "Usuario " + bu.codigoUsuario + " não encontrado!!!";
            new MostraMensagem(mensagem);
            bu.usuario = "";
            return;
        }
        PegaDadosUsuario();
    }
    
    private void PegaDadosUsuario(){
        for(int i = 0; i < dadosUsuarios.size(); i++)
            bu.usuario = String.valueOf(dadosUsuarios.get(i).get(0));
    }
    
    private void PegaImagemFuncionario(){
        sql = "select imagemFuncionario from tb_funcionarios where idFuncionario = " + bfunc.idFuncionario + ";";
        bfunc.imagemFuncionario = parametrosNS.dao.ConsultaLogotipo(sql, "imagemFuncionario");
    }
    
    private void PegaEmpresa(){
        be.codigoEmpresa = Integer.parseInt(fc.FormataCampo(txt_codigoEmpresa.getText(), 3, 0));
        sql = "select idEmpresa, codigoGrupo, codigoEmpresa, nomeEmpresa, nomeFantasia from ns_empresas where codigoGrupo = " + parametrosNS.bge.codigoGrupo + " and codigoEmpresa = " + be.codigoEmpresa + ";";
        if(parametrosNS.bu.codigoUsuario == 999)
            sql = "select idEmpresa, codigoGrupo, codigoEmpresa, nomeEmpresa, nomeFantasia from ns_empresas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + be.codigoEmpresa + ";";
        dadosEmpresas.clear();
        dadosEmpresas = parametrosNS.dao.Consulta(sql);
        if(dadosEmpresas.isEmpty()){
            mensagem = "Empresas n°" + be.codigoEmpresa + " não encontrada!";
            mostraMensagem();
            return;
        }
        PegaDadosEmpresa();
    }
    
    private void PegaDadosEmpresa(){
        for(int i = 0; i < dadosEmpresas.size(); i++){
            be.idEmpresa     = Integer.parseInt(String.valueOf(dadosEmpresas.get(i).get(0)));
            be.codigoGrupo   = Integer.parseInt(String.valueOf(dadosEmpresas.get(i).get(1)));
            be.codigoEmpresa = Integer.parseInt(String.valueOf(dadosEmpresas.get(i).get(2)));
            be.nomeEmpresa   =                  String.valueOf(dadosEmpresas.get(i).get(3));
            be.nomeFantasia  =                  String.valueOf(dadosEmpresas.get(i).get(4));
        }
        txt_codigoEmpresa.setText(fc.FormataCampo(String.valueOf(be.codigoEmpresa), 3, 0));
        label_nomeEmpresa.setText(be.nomeEmpresa);
        if(radio_Fisica  .isSelected())
            txt_cpf .grabFocus();
        if(radio_Juridica.isSelected())
            txt_cnpj.grabFocus();
    }
    
    private void HabilitaCampos(){
        validadorCpfCnpj = false;
        txt_cpf          .setText     (null);
        txt_cpf          .setEditable (false);
        txt_cpf          .setFocusable(false);
        txt_cnpj         .setText     (null);
        txt_cnpj         .setEditable (false);
        txt_cnpj         .setFocusable(false);
        combo_sexo       .setSelectedIndex(0);
        combo_estadoCivil.setSelectedIndex(0);
        if(radio_Fisica.isSelected()){
            ValidaRG         = false;
            txt_rg           .setText     (null);
            txt_rg           .setEditable (true);
            txt_rg           .setFocusable(true);
            combo_estadoCivil.setEnabled  (true);
            combo_estadoCivil.setFocusable(true);
            combo_sexo       .setEnabled  (true);
            combo_sexo       .setFocusable(true);
            txt_cpf          .setEditable (true);
            txt_cpf          .setFocusable(true);
            txt_cpf          .grabFocus();
            return;
        }
        if(radio_Juridica.isSelected()){
            ValidaRG         = true;
            txt_rg           .setText     (null);
            txt_rg           .setEditable (false);
            txt_rg           .setFocusable(false);
            combo_estadoCivil.setEnabled  (false);
            combo_estadoCivil.setFocusable(false);
            combo_sexo       .setEnabled  (false);
            combo_sexo       .setFocusable(false);
            txt_cnpj         .setEditable (true);
            txt_cnpj         .setFocusable(true);
            txt_cnpj         .grabFocus();
            return;
        }
    }
    
    private void ValidaCPFCNPJ(){
        if(radio_Fisica.isSelected()){
            bfunc.cpfCnpj  = txt_cpf.getText();
            mensagem = "CPF  inválido!";
        }else{
            bfunc.cpfCnpj  = txt_cnpj.getText();
            mensagem = "CNPJ inválido!";
        }
        bfunc.cpfCnpj  = bfunc.cpfCnpj.replace(" ", "");
        bfunc.cpfCnpj  = bfunc.cpfCnpj.replace(".", "");
        bfunc.cpfCnpj  = bfunc.cpfCnpj.replace("/", "");
        bfunc.cpfCnpj  = bfunc.cpfCnpj.replace("-", "");
        if(bfunc.cpfCnpj.equals(""))
            return;
        validadorCpfCnpj = Vcc.VALIDARCPFCNPJ(bfunc.cpfCnpj);
        if(validadorCpfCnpj == false){
            mostraMensagem();
            if(radio_Fisica.isSelected())
                txt_cpf.grabFocus();
            else
                txt_cnpj.grabFocus();
            return;
        }
        txt_dataAdmissao.grabFocus();
    }
    
    private void PegaDepartamento(){
        bd.codigoDepartamento = Integer.parseInt(fc.FormataCampo(txt_codigoDepartamento.getText(), 2, 0));
        if(bd.codigoDepartamento == 0)
            return;
        sql = "select * from tb_departamento where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoDepartamento = " + bd.codigoDepartamento + ";";
        dadosDepartamentos.clear();
        dadosDepartamentos = parametrosNS.dao.Consulta(sql);
        if(dadosDepartamentos.isEmpty()){
            mensagem = "Não foi encontrado o departamento n°" + bd.codigoDepartamento + "!";
            mostraMensagem();
            return;
        }
        PegaDadosDepartamento();
    }
    
    private void PegaDadosDepartamento(){
        for(int i = 0; i < dadosDepartamentos.size(); i++){
            bd.idDepartamento        = Integer.parseInt(String.valueOf(dadosDepartamentos.get(i).get(0)));
            bd.idEmpresa             = Integer.parseInt(String.valueOf(dadosDepartamentos.get(i).get(1)));
            bd.codigoGrupo           = Integer.parseInt(String.valueOf(dadosDepartamentos.get(i).get(2)));
            bd.codigoEmpresa         = Integer.parseInt(String.valueOf(dadosDepartamentos.get(i).get(3)));
            bd.codigoDepartamento    = Integer.parseInt(String.valueOf(dadosDepartamentos.get(i).get(4)));
            bd.descricaoDepartamento =                  String.valueOf(dadosDepartamentos.get(i).get(5));
        }
        txt_codigoDepartamento.setText(fc.FormataCampo(String.valueOf(bd.codigoDepartamento), 2, 0));
        label_descricaoDepartamento.setText(bd.descricaoDepartamento);
    }
    
    private void PegaCep(){
        bfunc.cep = txt_cep.getText();
        bfunc.cep = bfunc.cep.replace(" ", "");
        bfunc.cep = bfunc.cep.replace("-", "");
        if(bfunc.cep.equals(""))
            return;
        sql = "select * from ns_cep where cep = " + bfunc.cep + ";";
        dadosCEP.clear();
        dadosCEP = parametrosNS.dao.Consulta(sql);
        if(dadosCEP.isEmpty()){
            mensagem = "CEP não encontrado!";
            mostraMensagem();
            return;
        }
        PegaDadosCep();
    }
    
    private void PegaDadosCep(){
        for(int i = 0; i < dadosCEP.size(); i++){
            bcep.cep        = String.valueOf(dadosCEP.get(i).get(0));
            bcep.endereco   = String.valueOf(dadosCEP.get(i).get(1));
            bcep.cidade     = String.valueOf(dadosCEP.get(i).get(2));
            bcep.bairro     = String.valueOf(dadosCEP.get(i).get(3));
            bcep.uf         = String.valueOf(dadosCEP.get(i).get(4));
        }
        txt_cep         .setText(bcep.cep);
        txt_cidade      .setText(bcep.cidade);
        txt_endereco    .setText(bcep.endereco);
        txt_bairro      .setText(bcep.bairro);
        combo_UF        .setSelectedItem(bcep.uf);
        txt_municipio   .grabFocus();
        txt_codigoPais  .setText("1058");
        PegaPais();
    }
    
    private void PegaPais(){
        if(abriuCEP == 1)
            return;
        bpais.codigoPais = Integer.parseInt(fc.FormataCampo(txt_codigoPais.getText(), 4, 0));
        if(bpais.codigoPais == 0)
            return;
        sql = "select * from ns_paises where codigoPais = " + bpais.codigoPais + ";";
        dadosPaises.clear();
        dadosPaises = parametrosNS.dao.Consulta(sql);
        if(dadosPaises.isEmpty()){
            mensagem = "Pais " + bpais.codigoPais + " não encontrado!";
            mostraMensagem();
            return;
        }
        PegaDadosPais();
    }
    
    private void PegaDadosPais(){
        for(int i = 0; i < dadosPaises.size(); i++){
            bpais.codigoPais = Integer.parseInt(String.valueOf(dadosPaises.get(i).get(0)));
            bpais.nomePais   =                  String.valueOf(dadosPaises.get(i).get(1));
        }
        txt_codigoPais.setText(fc.FormataCampo(String.valueOf(bpais.codigoPais), 4, 0));
        label_pais    .setText(bpais.nomePais);
    }
    
    private void PegaValores(){
        fatal = "N";
        bfunc.idEmpresa          = be.idEmpresa;
        bfunc.codigoGrupo        = be.codigoGrupo;
        bfunc.codigoEmpresa      = be.codigoEmpresa;
        if(bfunc.idEmpresa == 0 || bfunc.codigoGrupo == 0 || bfunc.codigoEmpresa == 0){
            fatal = "S";
            mensagem = "Empresa inválida!";
            mostraMensagem();
            return;
        }
        bfunc.codigoFuncionario  = Integer.parseInt(fc.FormataCampo(txt_codigoFuncionario.getText() , 6, 0));
        bfunc.codigoDepartamento = Integer.parseInt(fc.FormataCampo(txt_codigoDepartamento.getText(), 2, 0));
        if(bfunc.codigoDepartamento == 0){
            fatal = "S";
            mensagem = "Departamento inválido!";
            mostraMensagem();
            return;
        }
        if(check_bloqueado.isSelected() == false)
            bfunc.statusFuncionario = 0;
        else
            bfunc.statusFuncionario = 1;
        
        bfunc.dataCadastro      = parametrosNS.invdata.inverterData(txt_dataCadastro.getText(), 2);
        
        if(radio_Fisica  .isSelected())bfunc.tipoPessoa = 0;
        if(radio_Juridica.isSelected())bfunc.tipoPessoa = 1;
        
        bfunc.cpfCnpj = txt_cpf.getText() + txt_cnpj.getText();
        bfunc.cpfCnpj = bfunc.cpfCnpj.replace(" ", "");
        bfunc.cpfCnpj = bfunc.cpfCnpj.replace(".", "");
        bfunc.cpfCnpj = bfunc.cpfCnpj.replace("/", "");
        bfunc.cpfCnpj = bfunc.cpfCnpj.replace("-", "");
        
        if(bfunc.tipoPessoa == 0)
            bfunc.cpfCnpj = fc.FormataCampo(bfunc.cpfCnpj, 11, 0);
        if(bfunc.tipoPessoa == 1)
            bfunc.cpfCnpj = fc.FormataCampo(bfunc.cpfCnpj, 15, 0);
        
        bfunc.dataAdmissao    = txt_dataAdmissao.getText();
        bfunc.dataAdmissao    = parametrosNS.invdata.inverterData(bfunc.dataAdmissao, 2);
        if(!bfunc.dataAdmissao.equals(""))
            bfunc.dataAdmissao = "'" + bfunc.dataAdmissao + "'";
        else
            bfunc.dataAdmissao = null;
        
        bfunc.nomeFuncionario = txt_nome.getText();
        if(bfunc.nomeFuncionario.equals("")){
            fatal = "S";
            mensagem = "Nome inválido!";
            mostraMensagem();
            return;
        }
        
        if(ValidaRG == false)
            if(bfunc.tipoPessoa == 0){
                fatal = "S";
                mensagem = "RG inválido!";
                mostraMensagem();
                return;
            }
        bfunc.rg = txt_rg.getText();
        bfunc.rg = bfunc.rg.replace(" ", "");
        bfunc.rg = bfunc.rg.replace(".", "");
        bfunc.rg = bfunc.rg.replace("-", "");
        if(!bfunc.rg.equals(""))
            bfunc.rg = "'" + bfunc.rg + "'";
        else
            bfunc.rg = null;
        
        if(bfunc.tipoPessoa == 0)
            if(combo_sexo.getSelectedIndex() == 0){
                fatal = "S";
                mensagem = "Sexo inválido!";
                mostraMensagem();
                return;
            }
        bfunc.sexo           = combo_sexo.getSelectedIndex();
        if(bfunc.tipoPessoa == 0)
            if(combo_estadoCivil.getSelectedIndex() == 0){
                fatal = "S";
                mensagem = "Estado civil inválido!";
                mostraMensagem();
                return;
            }
        bfunc.estadoCivil    = combo_estadoCivil.getSelectedIndex();
        bfunc.profissao      = txt_profissao.getText();
        bfunc.dataNascimento = txt_dataNascimento.getText();
        bfunc.dataNascimento = bfunc.dataNascimento.replace(" ", "");
        bfunc.dataNascimento = bfunc.dataNascimento.replace("/", "");
        if(!bfunc.dataNascimento.equals(""))
            bfunc.dataNascimento = "'" + parametrosNS.invdata.inverterData(bfunc.dataNascimento, 2) + "'";
        else
            bfunc.dataNascimento = null;
        
        bfunc.nacionalidade  = txt_nacionalidade.getText();
        bfunc.naturalidade   = txt_naturalidade .getText();
        
        if(combo_UFnaturalidade.getSelectedIndex() > 0)
            bfunc.ufNaturalidade = "'" + String.valueOf(combo_UFnaturalidade.getSelectedItem()) + "'";
        else
            bfunc.ufNaturalidade = null;
        
        bfunc.cep     = txt_cep.getText();
        bfunc.cep     = bfunc.cep.replace(" ", "");
        bfunc.cep     = bfunc.cep.replace("-", "");
        if(!bfunc.cep.equals(""))
            bfunc.cep = "'" + bfunc.cep + "'";
        else
            bfunc.cep = null;
        
        bfunc.cidade        = txt_cidade.getText();
        bfunc.municipio     = txt_municipio.getText();
        bfunc.endereco      = txt_endereco.getText();
        bfunc.complemento   = txt_complemento.getText();
        bfunc.bairro        = txt_bairro.getText();
        bfunc.numero        = txt_numero.getText();
        
        if(combo_UF.getSelectedIndex() > 0)
            bfunc.uf = "'" + String.valueOf(combo_UF.getSelectedItem()) + "'";
        else
            bfunc.uf = null;
        
        bfunc.codigoPais = Integer.parseInt(fc.FormataCampo(txt_codigoPais.getText(), 4, 0));
        
        bfunc.telefone  = txt_telefone.getText();
        bfunc.telefone  = bfunc.telefone.replace(" ", "");
        bfunc.telefone  = bfunc.telefone.replace("(", "");
        bfunc.telefone  = bfunc.telefone.replace(")", "");
        bfunc.telefone  = bfunc.telefone.replace("-", "");
        if(!bfunc.telefone.equals(("")))
            bfunc.telefone = "'" + bfunc.telefone + "'";
        else
            bfunc.telefone = null;
        
        bfunc.celular   = txt_celular.getText();
        bfunc.celular   = bfunc.celular.replace(" ", "");
        bfunc.celular   = bfunc.celular.replace("(", "");
        bfunc.celular   = bfunc.celular.replace(")", "");
        bfunc.celular   = bfunc.celular.replace("-", "");
        if(!bfunc.celular.equals(""))
            bfunc.celular  = "'" + bfunc.celular  + "'";
        else
            bfunc.celular  = null;
        
        bfunc.email     = txt_email.getText();
        
        bfunc.observacoes = txt_observacoes.getText();
        bfunc.dataAlterou          = parametrosNS.cdh.CapturarData();
        bfunc.dataAlterou          = parametrosNS.invdata.inverterData(bfunc.dataAlterou, 2);
        bfunc.horaAlterou          = parametrosNS.cdh.CapturaHora();
        bfunc.usuarioAlterou       = parametrosNS.bu.codigoUsuario;
        bfunc.idEmpresaAlterou     = parametrosNS.be.IdEmpresa;
        bfunc.codigoGrupoAlterou   = parametrosNS.bge.CodigoGrupo;
        bfunc.codigoEmpresaAlterou = parametrosNS.be.CodigoEmpresa;
        
        try{
            BuffImg  = ImageIO.read(new File(pastaImagemFuncionario));
            BytesImg = new ByteArrayOutputStream();
            
            ImageIO.write((BufferedImage)BuffImg, "jpg", BytesImg);
            BytesImg.flush();
            
            bfunc.imagemFuncionario    = BytesImg.toByteArray();
            BytesImg.close();
            bfunc.setimagemFuncionario(bfunc.imagemFuncionario);
        }catch(Exception erro){
            
        }
    }
    
    private void IncluirFuncionario(){
        PegaValores();
        if(fatal.equals("S"))
            return;
        sql = "insert into tb_funcionarios (idEmpresa, codigoGrupo, codigoEmpresa, codigoFuncionario, codigoDepartamento, statusFuncionario, dataCadastro, tipoPessoa, cpfCnpj, dataAdmissao, nomeFuncionario, rg, sexo, estadoCivil, profissao, dataNascimento, nacionalidade, naturalidade, ufNaturalidade, cep, cidade, municipio, endereco, complemento, bairro, numero, uf, codigoPais, telefone, celular, email, observacoes) "
            + "values (" + bfunc.idEmpresa + ", " + bfunc.codigoGrupo + ", " + bfunc.codigoEmpresa + ", " + bfunc.codigoFuncionario + ", " + bfunc.codigoDepartamento + ", " + bfunc.statusFuncionario + ", '" + bfunc.dataCadastro + "', " + bfunc.tipoPessoa + ", '" + bfunc.cpfCnpj + "', " + bfunc.dataAdmissao + ", '" + bfunc.nomeFuncionario + "', " + bfunc.rg + ", " + bfunc.sexo + ", " + bfunc.estadoCivil + ", '" + bfunc.profissao + "', " + bfunc.dataNascimento + ", '" + bfunc.nacionalidade + "', '" + bfunc.naturalidade + "', " + bfunc.ufNaturalidade + ", " + bfunc.cep + ", '" + bfunc.cidade + "', '" + bfunc.municipio + "', '" + bfunc.endereco + "', '" + bfunc.complemento + "', '" + bfunc.bairro + "', '" + bfunc.numero + "', " + bfunc.uf + ", " + bfunc.codigoPais + ", " + bfunc.telefone + ", " + bfunc.celular + ", '" + bfunc.email + "', '" + bfunc.observacoes + "');";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao incluir funcionário!";
            mostraMensagem();
            return;
        }
        AtualizaImagemFuncionario();
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao incluir imagem do funcionário!";
            mostraMensagem();
            return;
        }
        mensagem = "Registro incluído com sucesso!";
        mostraMensagem();
        txt_codigoFuncionario.grabFocus();
    }
    
    private void AlterarFuncionario(){
        PegaValores();
        if(fatal.equals("S"))
            return;
        
        sql = "update tb_funcionarios set idEmpresa = "             + bfunc.idEmpresa            + ", \n" +
                                         "codigoEmpresa = "         + bfunc.codigoEmpresa        + ", \n" +
                                         "codigoDepartamento = "    + bfunc.codigoDepartamento   + ", \n" +
                                         "statusFuncionario = "     + bfunc.statusFuncionario    + ", \n" +
                                         "tipoPessoa = "            + bfunc.tipoPessoa           + ", \n" +
                                         "cpfCnpj = '"              + bfunc.cpfCnpj              + "', \n" +
                                         "dataAdmissao = "          + bfunc.dataAdmissao         + ", \n" +
                                         "nomeFuncionario = '"      + bfunc.nomeFuncionario      + "', \n" +
                                         "rg = "                    + bfunc.rg                   + ", \n" +
                                         "sexo = "                  + bfunc.sexo                 + ", \n" +
                                         "estadoCivil = "           + bfunc.estadoCivil          + ", \n" +
                                         "profissao = '"            + bfunc.profissao            + "', \n" +
                                         "dataNascimento = "        + bfunc.dataNascimento       + ", \n" +
                                         "nacionalidade = '"        + bfunc.nacionalidade        + "', \n" +
                                         "naturalidade = '"         + bfunc.naturalidade         + "', \n" +
                                         "ufNaturalidade = "        + bfunc.ufNaturalidade       + ", \n" +
                                         "cep = "                   + bfunc.cep                  + ", \n" +
                                         "cidade = '"               + bfunc.cidade               + "', \n" +
                                         "municipio = '"            + bfunc.municipio            + "', \n" +
                                         "endereco = '"             + bfunc.endereco             + "', \n" +
                                         "complemento = '"          + bfunc.complemento          + "', \n" +
                                         "bairro = '"               + bfunc.bairro               + "', \n" +
                                         "numero = '"               + bfunc.numero               + "', \n" +
                                         "uf = "                    + bfunc.uf                   + ", \n" +
                                         "codigoPais = "            + bfunc.codigoPais           + ", \n" +
                                         "telefone = "              + bfunc.telefone             + ", \n" +
                                         "celular = "               + bfunc.celular              + ", \n" +
                                         "email = '"                + bfunc.email                + "', \n" +
                                         "observacoes = '"          + bfunc.observacoes          + "', \n" +
                                         "dataAlterou = '"          + bfunc.dataAlterou          + "', \n" +
                                         "horaAlterou = '"          + bfunc.horaAlterou          + "', \n" +
                                         "usuarioAlterou = "        + bfunc.usuarioAlterou       + ", \n" +
                                         "idEmpresaAlterou = "      + bfunc.idEmpresaAlterou     + ", \n" +
                                         "codigoGrupoAlterou = "    + bfunc.codigoGrupoAlterou   + ", \n" +
                                         "codigoEmpresaAlterou = "  + bfunc.codigoEmpresaAlterou + " \n" +
                                         "where idFuncionario = " + bfunc.idFuncionario + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao alterar funcionário!";
            mostraMensagem();
            return;
        }
        AtualizaImagemFuncionario();
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao alterar a imagem do funcionário!";
            mostraMensagem();
            return;
        }
        mensagem = "Resgistro alterado com sucesso!";
        mostraMensagem();
        txt_codigoFuncionario.grabFocus();
    }
    
    private void AtualizaImagemFuncionario(){
        sql = "update tb_funcionarios set imagemFuncionario = ? where idEmpresa = " + bfunc.idEmpresa + " and codigoFuncionario = " + bfunc.codigoFuncionario + ";";
        sqlstate = parametrosNS.dao.atualizarImagens(sql, bfunc.getimagemFuncionario());
    }
    
}
