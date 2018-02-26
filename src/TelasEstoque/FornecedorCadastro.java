package TelasEstoque;

import BeansNS.BeanEstados;
import BeansNS.BeanCEP;
import BeansNS.BeanPais;
import FuncoesInternas.InverterData;
import Beans.*;
import java.util.ArrayList;
import FuncoesInternas.*;
import Telas.CodigoEnderecamentoPostalConsulta;
import Telas.PaisesConsulta;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
/*
 @author Tiago e Paulo
 */
public class FornecedorCadastro extends javax.swing.JFrame {
    //String
    String sql                  = "";
    String sqlstate             = "";
    String fatal                = "";
    String Mensagem             = "";
    String operacao             = "";
    String retorno              = "";
    String valorFormatado       = "";
    String somostra             = "";
    
    //boolean's
    boolean validadorCnpj;
    
    //int's
    int    UltimoRegistro       = 0;
    int    abriuPais            = 0;
    int    abriuCep             = 0;
    int    abriuFornecedor      = 0;
    
    //ArrayList's
    ArrayList            parametros                    = new ArrayList();
//    ArrayList            dadosPadroes                  = new ArrayList();
    ArrayList<ArrayList> dadosCEP                      = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosEstados                  = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosPaises                   = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosFornecedor               = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosUsuario                  = new ArrayList<ArrayList>();
    
    //Bean's
    BeanUsuarios                bu          = new BeanUsuarios();
    BeanFornecedor              bfor        = new BeanFornecedor();
    BeanCEP                     bcep        = new BeanCEP();
    BeanPais                    bpais       = new BeanPais();
    BeanEstados                 best        = new BeanEstados();
    
    //Especiais
    CapturarDataHora            cdh         = new CapturarDataHora();
    FormataCampo                fc          = new FormataCampo();
    ValidarCpfCnpj              vcc         = new ValidarCpfCnpj();
    InverterData                invdata     = new InverterData();
    PegaProximoRegistro         PegProReg   = new PegaProximoRegistro();
    
    //Telas
    FornecedorConsulta                  ForCon;
    CodigoEnderecamentoPostalConsulta   ConCodEndPos;
    PaisesConsulta                      ConPaises;
    
    public FornecedorCadastro(String Somostra, int CodigoFornecedor){
        somostra                = Somostra;
        bfor.codigoFornecedor   = CodigoFornecedor;
        
        initComponents();
    }

    private void PegaUF(){
        sql = "select uf from ns_estados;";
        dadosEstados.clear();
        dadosEstados = parametrosNS.dao.Consulta(sql);
        if(dadosEstados.isEmpty()){
            Mensagem = "Unidades Federativas Não encontradas!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosUF();
    }
    
    private void PegaDadosUF(){
        combo_uf.removeAllItems();
        combo_uf.addItem("");
        for(int i = 0; i < dadosEstados.size(); i++){
            best.uf = String.valueOf(dadosEstados.get(i).get(0));
            combo_uf.addItem(best.uf);
        }
        combo_uf.addItem("ZZ");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        bt_novo = new javax.swing.JButton();
        txt_codigoFornecedor = new javax.swing.JFormattedTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        check_bloqueado = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txt_dataCadastro = new javax.swing.JFormattedTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_contato = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        txt_telefone = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_cidade = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txt_bairro = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txt_numero = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_codigoPais = new javax.swing.JFormattedTextField();
        label_pais = new javax.swing.JLabel();
        txt_endereco = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        combo_uf = new javax.swing.JComboBox<>();
        txt_cep = new javax.swing.JFormattedTextField();
        bt_pesquisaCep = new javax.swing.JButton();
        bt_pesquisaPais = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        txt_cnpj1 = new javax.swing.JFormattedTextField();
        txt_cnpj2 = new javax.swing.JFormattedTextField();
        txt_cnpj3 = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_observacoes = new javax.swing.JTextArea();
        jLabel26 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        label_alteracao = new javax.swing.JLabel();
        bt_ultimo = new javax.swing.JButton();
        bt_proximo = new javax.swing.JButton();
        bt_anterior = new javax.swing.JButton();
        bt_primeiro = new javax.swing.JButton();
        bt_pesquisa = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_incluir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Fornecedores");
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

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Codigo do Fornecedor");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        try {
            txt_codigoFornecedor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoFornecedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoFornecedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoFornecedorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoFornecedorFocusLost(evt);
            }
        });
        txt_codigoFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoFornecedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_codigoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_codigoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, txt_codigoFornecedor});

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Status Fornecedor");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        check_bloqueado.setText("Bloqueado");
        check_bloqueado.setToolTipText("Produtos inativos ou não vendidos");
        check_bloqueado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(check_bloqueado, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check_bloqueado)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Data de Cadastro");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_dataCadastro.setEditable(false);
        try {
            txt_dataCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataCadastro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataCadastro.setFocusable(false);
        txt_dataCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dataCadastroActionPerformed(evt);
            }
        });
        txt_dataCadastro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataCadastroKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_dataCadastro)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_dataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Dados do Fornecedor");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Nome: ");

        jLabel4.setText("Contato: ");

        jLabel6.setText("Telefone: ");

        jLabel3.setText("Email: ");

        try {
            txt_telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nome)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txt_contato, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(1, 1, 1)
                        .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_email)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_contato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("CEP:");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Cidade:");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Bairro:");

        txt_bairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bairroActionPerformed(evt);
            }
        });

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Número: ");

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("UF: ");

        jLabel5.setText("Pais:");

        try {
            txt_codigoPais.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
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
        txt_codigoPais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_codigoPaisMouseClicked(evt);
            }
        });

        label_pais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_paisMouseEntered(evt);
            }
        });

        txt_endereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_enderecoActionPerformed(evt);
            }
        });

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Endereço:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Dados Cadastrais");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        combo_uf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        combo_uf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo_ufFocusLost(evt);
            }
        });

        try {
            txt_cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        try {
            txt_cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cep.addFocusListener(new java.awt.event.FocusAdapter() {
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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cepKeyPressed(evt);
            }
        });

        bt_pesquisaCep.setText("...");
        bt_pesquisaCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaCepActionPerformed(evt);
            }
        });

        bt_pesquisaPais.setText("...");
        bt_pesquisaPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaPaisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_cep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisaCep, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_uf, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_codigoPais, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(bt_pesquisaPais, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_pais, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_endereco))
                .addContainerGap())
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {combo_uf, jLabel20});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel20)
                            .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel22))
                            .addComponent(label_pais, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21)
                                .addComponent(combo_uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(txt_codigoPais, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bt_pesquisaPais, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(bt_pesquisaCep, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaCep, bt_pesquisaPais, combo_uf, jLabel13, jLabel18, jLabel19, jLabel20, jLabel21, jLabel22, jLabel5, label_pais, txt_bairro, txt_cep, txt_cidade, txt_codigoPais, txt_endereco, txt_numero});

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("CNPJ");
        jLabel33.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
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

        try {
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

        try {
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

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_cnpj1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cnpj2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cnpj3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel33)
                .addGap(9, 9, 9)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cnpj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cnpj2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cnpj3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_observacoes.setColumns(20);
        txt_observacoes.setRows(5);
        jScrollPane1.setViewportView(txt_observacoes);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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

        jPanel10.setBackground(new java.awt.Color(102, 102, 102));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        label_alteracao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label_alteracao.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_alteracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_alteracao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );

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

        bt_pesquisa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_pesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/View.png"))); // NOI18N
        bt_pesquisa.setText("Pesquisa");
        bt_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaActionPerformed(evt);
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

        bt_incluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_incluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_incluir.setText("Incluir");
        bt_incluir.setEnabled(false);
        bt_incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_incluirActionPerformed(evt);
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
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_pesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_primeiro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_anterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_proximo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_ultimo))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_alterar, bt_incluir});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_ultimo)
                    .addComponent(bt_proximo)
                    .addComponent(bt_anterior)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_alterar)
                        .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_primeiro)
                        .addComponent(bt_pesquisa)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_alterar, bt_anterior, bt_incluir, bt_pesquisa, bt_primeiro, bt_proximo, bt_ultimo});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void txt_codigoFornecedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFornecedorFocusGained
        if(txt_codigoFornecedor.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        txt_codigoFornecedor.setText("");
        operacao = "";
        ReiniciaTela();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoFornecedorFocusGained

    private void txt_codigoFornecedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFornecedorFocusLost
        if(txt_codigoFornecedor.isEditable() == false)
            return;
        if(txt_codigoFornecedor.getText().replace(" ", "").equals(""))
            return;
        PegaFornecedor();
    }//GEN-LAST:event_txt_codigoFornecedorFocusLost

    private void txt_codigoFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoFornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoFornecedorActionPerformed

    private void txt_dataCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dataCadastroActionPerformed

    }//GEN-LAST:event_txt_dataCadastroActionPerformed

    private void txt_dataCadastroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataCadastroKeyPressed
        
    }//GEN-LAST:event_txt_dataCadastroKeyPressed

    private void txt_codigoPaisFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPaisFocusGained
        txt_codigoPais.setSelectionStart(0);
        txt_codigoPais.setSelectionEnd  (txt_codigoPais.getText().length());
    }//GEN-LAST:event_txt_codigoPaisFocusGained

    private void txt_codigoPaisFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPaisFocusLost
        if(somostra.equals("S"))
            return;
        if(txt_codigoPais.getText().replace(" ", "").equals(""))
            return;
        PegaPais();
    }//GEN-LAST:event_txt_codigoPaisFocusLost

    private void txt_codigoPaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_codigoPaisMouseClicked
        
    }//GEN-LAST:event_txt_codigoPaisMouseClicked

    private void txt_enderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_enderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_enderecoActionPerformed

    private void combo_ufFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo_ufFocusLost
       
    }//GEN-LAST:event_combo_ufFocusLost

    private void bt_ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ultimoActionPerformed
        
    }//GEN-LAST:event_bt_ultimoActionPerformed

    private void bt_proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_proximoActionPerformed
       
    }//GEN-LAST:event_bt_proximoActionPerformed

    private void bt_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_anteriorActionPerformed
        
    }//GEN-LAST:event_bt_anteriorActionPerformed

    private void bt_primeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_primeiroActionPerformed
        
    }//GEN-LAST:event_bt_primeiroActionPerformed

    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        if(ForCon != null)if(ForCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuFornecedor = 1;
        ForCon = new FornecedorConsulta("S");
        ForCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S"))
            return;
        sql = "update tb_fornecedor set statusFornecedor = "        + bfor.statusFornecedor     + ", " +
                                       "cnpj = '"                   + bfor.cnpj                 + "', " +
                                       "dataCadastro = '"           + bfor.dataCadastro         + "', " +
                                       "nome = '"                   + bfor.nome                 + "', " +
                                       "contato = '"                + bfor.contato              + "', " +
                                       "telefone = "                + bfor.telefone             + ", " +
                                       "email = '"                  + bfor.email                + "', " +
                                       "cep = '"                    + bfor.cep                  + "', " +
                                       "cidade = '"                 + bfor.cidade               + "', " +
                                       "endereco = '"               + bfor.endereco             + "', " +
                                       "numero = '"                 + bfor.numero               + "', " +
                                       "bairro = '"                 + bfor.bairro               + "', " +
                                       "uf = '"                     + bfor.uf                   + "', " +
                                       "codigoPais = "              + bfor.codigoPais           + ", " +
                                       "observacoes = '"            + bfor.observacoes          + "', " +
                                       "idEmpresaAlterou = "        + bfor.idEmpresaAlterou     + ", " +
                                       "codigoGrupoAlterou = "      + bfor.codigoGrupoAlterou   + ", " +
                                       "codigoEmpresaAlterou = "    + bfor.codigoEmpresaAlterou + ", " +
                                       "dataAlterou = '"            + bfor.dataAlterou          + "', " +
                                       "horaAlterou = '"            + bfor.horaAlterou          + "', " +
                                       "usuarioAlterou = "          + bfor.usuarioAlterou       + " " +
                                       "where idFornecedor = "  + bfor.idFornecedor + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoFornecedor.grabFocus();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S"))
            return;
        sql = "insert into tb_fornecedor (idEmpresa, codigoGrupo, codigoEmpresa, codigoFornecedor, statusFornecedor, cnpj, dataCadastro, nome, contato, telefone, email, cep, cidade, endereco, numero, bairro, uf, codigoPais, observacoes) "
            + "values (" + bfor.idEmpresa + ", " + bfor.codigoGrupo + ", " + bfor.codigoEmpresa + ", " + bfor.codigoFornecedor + ", " + bfor.statusFornecedor + ", '" + bfor.cnpj + "', '" + bfor.dataCadastro + "', '" + bfor.nome + "', '" + bfor.contato + "', " + bfor.telefone + ", '" + bfor.email + "', '" + bfor.cep + "', '" + bfor.cidade + "', '" + bfor.endereco + "', '" + bfor.numero + "', '" + bfor.bairro + "', '" + bfor.uf + "', '" + bfor.codigoPais + "', '" + bfor.observacoes + "');";
        
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoFornecedor.grabFocus();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        ReiniciaCampos();
        HabilitaCampos(true);
        
        bfor.codigoFornecedor = PegProReg.PegaProximoRegistro("tb_fornecedor", "codigoFornecedor", "");
        txt_codigoFornecedor.setText(fc.FormataCampo(String.valueOf(bfor.codigoFornecedor), 5, 0));
        
        operacao = "I";
        HabilitaBotoes();
        txt_cnpj1.grabFocus();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void txt_cnpj1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cnpj1FocusGained
        txt_cnpj1.setText("");
    }//GEN-LAST:event_txt_cnpj1FocusGained

    private void txt_cnpj1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cnpj1FocusLost
        txt_cnpj1.setText(fc.FormataCampo(txt_cnpj1.getText(), 11, 2));
    }//GEN-LAST:event_txt_cnpj1FocusLost

    private void txt_cnpj1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cnpj1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cnpj1ActionPerformed

    private void txt_cnpj2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cnpj2FocusGained
        txt_cnpj2.setText("");
    }//GEN-LAST:event_txt_cnpj2FocusGained

    private void txt_cnpj2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cnpj2FocusLost
        txt_cnpj2.setText(fc.FormataCampo(txt_cnpj2.getText(), 4, 0));
    }//GEN-LAST:event_txt_cnpj2FocusLost

    private void txt_cnpj2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cnpj2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cnpj2ActionPerformed

    private void txt_cnpj3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cnpj3FocusGained
        txt_cnpj3.setText("");
    }//GEN-LAST:event_txt_cnpj3FocusGained

    private void txt_cnpj3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cnpj3FocusLost
        txt_cnpj3.setText(fc.FormataCampo(txt_cnpj3.getText(), 2, 0));
        ValidaCNPJ();
    }//GEN-LAST:event_txt_cnpj3FocusLost

    private void txt_cnpj3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cnpj3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cnpj3ActionPerformed

    private void txt_bairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bairroActionPerformed

    private void txt_cepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cepFocusLost
        if(somostra.equals("S"))
            return;
        PegaCep();
        txt_numero.grabFocus();
    }//GEN-LAST:event_txt_cepFocusLost

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
        if(abriuFornecedor == 0){
            AbriuCep();
            return;
        }
        abriuFornecedor = 0;
        retorno = ForCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoFornecedor.setText(fc.FormataCampo(retorno, 5, 0));
        PegaFornecedor();
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbriuCep(){
        if(abriuCep == 0){
            AbriuPais();
            return;
        }
        retorno = ConCodEndPos.getRetorno();
        if(retorno.equals(""))
            return;
        txt_cep.setText(retorno);
        PegaCep();
    }
    
    private void AbriuPais(){
        if(abriuPais == 0)
            return;
        retorno = ConPaises.getRetorno();
        if(retorno.equals(""))
            return;
        abriuPais = 0;
        txt_codigoPais.setText(fc.FormataCampo(retorno, 4, 0));
        PegaPais();
    }
    
    private void txt_cepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_cepMouseClicked
        
    }//GEN-LAST:event_txt_cepMouseClicked

    private void txt_cepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cepKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        txt_numero.grabFocus();
    }//GEN-LAST:event_txt_cepKeyPressed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HabilitaCampos(false);
        PegaUF();
        if(somostra.equals("SN"))
            bt_pesquisa.setVisible (false);
        if(bfor.codigoFornecedor != 0){
            txt_codigoFornecedor.setText(String.valueOf(bfor.codigoFornecedor));
            PegaFornecedor();
        }
        if(somostra.equals("S")){
            txt_codigoFornecedor.setEditable(false);
            bt_novo             .setEnabled (false);
            bt_incluir          .setVisible (false);
            bt_alterar          .setVisible (false);
            bt_pesquisa         .setVisible (false);
            bt_pesquisaCep      .setEnabled (false);
            combo_uf            .setEnabled (false);
            bt_pesquisaPais     .setEnabled (false);
            bt_primeiro         .setVisible (false);
            bt_anterior         .setVisible (false);
            bt_proximo          .setVisible (false);
            bt_ultimo           .setVisible (false);
        }
    }//GEN-LAST:event_formWindowOpened

    private void bt_pesquisaCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaCepActionPerformed
        if(ConCodEndPos != null)if(ConCodEndPos.isVisible()){
            Mensagem = "Tela já Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuCep = 1;
        ConCodEndPos = new CodigoEnderecamentoPostalConsulta();
        ConCodEndPos.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaCepActionPerformed

    private void bt_pesquisaPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaPaisActionPerformed
        if(ConPaises != null)if(ConPaises.isVisible()){
            Mensagem = "Tela já Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuPais = 1;
        ConPaises = new PaisesConsulta();
        ConPaises.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaPaisActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(ForCon      != null)ForCon       .dispose();
        if(ConCodEndPos!= null)ConCodEndPos .dispose();
        if(ConPaises   != null)ConPaises    .dispose();
    }//GEN-LAST:event_formWindowClosed

    private void label_paisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_paisMouseEntered
        if(!label_pais.getText().equals(""))
            label_pais.setToolTipText(label_pais.getText());
    }//GEN-LAST:event_label_paisMouseEntered
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_anterior;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisa;
    private javax.swing.JButton bt_pesquisaCep;
    private javax.swing.JButton bt_pesquisaPais;
    private javax.swing.JButton bt_primeiro;
    private javax.swing.JButton bt_proximo;
    private javax.swing.JMenuItem bt_sair;
    private javax.swing.JButton bt_ultimo;
    private javax.swing.JCheckBox check_bloqueado;
    private javax.swing.JComboBox<String> combo_uf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_alteracao;
    private javax.swing.JLabel label_pais;
    private javax.swing.JTextField txt_bairro;
    private javax.swing.JFormattedTextField txt_cep;
    private javax.swing.JTextField txt_cidade;
    private javax.swing.JFormattedTextField txt_cnpj1;
    private javax.swing.JFormattedTextField txt_cnpj2;
    private javax.swing.JFormattedTextField txt_cnpj3;
    private javax.swing.JFormattedTextField txt_codigoFornecedor;
    private javax.swing.JFormattedTextField txt_codigoPais;
    private javax.swing.JTextField txt_contato;
    private javax.swing.JFormattedTextField txt_dataCadastro;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_endereco;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_numero;
    private javax.swing.JTextArea txt_observacoes;
    private javax.swing.JFormattedTextField txt_telefone;
    // End of variables declaration//GEN-END:variables
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_incluir.setEnabled(true);
            bt_alterar.setEnabled(false);
            return;
        }
        bt_incluir.setEnabled(false);
        bt_alterar.setEnabled(true);
    }

    public void ReiniciaTela() {
        ReiniciaCampos();
        bt_incluir.setEnabled(false);
        bt_alterar.setEnabled(false);
    }
    
    private void ReiniciaCampos(){
        bfor = new BeanFornecedor();
        check_bloqueado .setSelected(false);
        txt_cnpj1       .setText("");
        txt_cnpj2       .setText("");
        txt_cnpj3       .setText("");
        txt_dataCadastro.setText(cdh.CapturarData());
        txt_nome        .setText("");
        txt_contato     .setText("");
        txt_telefone    .setText("");
        txt_email       .setText("");
        txt_cep         .setText("");
        txt_cidade      .setText("");
        txt_endereco    .setText("");
        txt_numero      .setText("");
        txt_bairro      .setText("");
        txt_codigoPais  .setText("");
        label_pais      .setText("");
        combo_uf        .setSelectedIndex(26);
        txt_observacoes .setText("");
        label_alteracao .setText("");
    }
    
    private void HabilitaCampos(boolean Habilita){
        check_bloqueado     .setEnabled     (Habilita);
        check_bloqueado     .setFocusable   (Habilita);
        txt_cnpj1           .setEditable    (Habilita);
        txt_cnpj1           .setFocusable   (Habilita);
        txt_cnpj2           .setEditable    (Habilita);
        txt_cnpj2           .setFocusable   (Habilita);
        txt_cnpj3           .setEditable    (Habilita);
        txt_cnpj3           .setFocusable   (Habilita);
        txt_nome            .setEditable    (Habilita);
        txt_nome            .setFocusable   (Habilita);
        txt_contato         .setEditable    (Habilita);
        txt_contato         .setFocusable   (Habilita);
        txt_telefone        .setEditable    (Habilita);
        txt_telefone        .setFocusable   (Habilita);
        txt_email           .setEditable    (Habilita);
        txt_email           .setFocusable   (Habilita);
        txt_cep             .setEditable    (Habilita);
        txt_cep             .setFocusable   (Habilita);
        bt_pesquisaCep      .setEnabled     (Habilita);
        bt_pesquisaCep      .setFocusable   (Habilita);
        txt_cidade          .setEditable    (Habilita);
        txt_cidade          .setFocusable   (Habilita);
        txt_endereco        .setEditable    (Habilita);
        txt_endereco        .setFocusable   (Habilita);
        txt_numero          .setEditable    (Habilita);
        txt_numero          .setFocusable   (Habilita);
        txt_bairro          .setEditable    (Habilita);
        txt_bairro          .setFocusable   (Habilita);
        combo_uf            .setEnabled     (Habilita);
        combo_uf            .setFocusable   (Habilita);
        txt_codigoPais      .setEditable    (Habilita);
        txt_codigoPais      .setFocusable   (Habilita);
        bt_pesquisaPais     .setEnabled     (Habilita);
        bt_pesquisaPais     .setFocusable   (Habilita);
        txt_observacoes     .setEditable    (Habilita);
        txt_observacoes     .setFocusable   (Habilita);
    }
    
    private void PegaValores(){
        fatal = "N";
        bfor.idEmpresa          = parametrosNS.be.IdEmpresa;
        bfor.codigoGrupo        = parametrosNS.bge.CodigoGrupo;
        bfor.codigoEmpresa      = parametrosNS.be.CodigoEmpresa;
        bfor.codigoFornecedor   = Integer.parseInt(txt_codigoFornecedor.getText());
        if(check_bloqueado.isSelected())
            bfor.statusFornecedor = 1;
        else
            bfor.statusFornecedor = 0;
        bfor.cnpj1 = txt_cnpj1.getText().replace(" ", "");
        bfor.cnpj2 = txt_cnpj2.getText();
        bfor.cnpj3 = txt_cnpj3.getText();
        bfor.cnpj               = bfor.cnpj1 + bfor.cnpj2 + bfor.cnpj3;
        bfor.dataCadastro       = invdata.inverterData(txt_dataCadastro.getText(), 2);
        bfor.nome               = txt_nome.getText();
        if(bfor.nome.equals("")){
            Mensagem = "Fornecedor inválido!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bfor.contato            = txt_contato.getText();
        bfor.telefone           = txt_telefone.getText();
        bfor.telefone           = bfor.telefone.replace("(", "");
        bfor.telefone           = bfor.telefone.replace(")", "");
        bfor.telefone           = bfor.telefone.replace(" ", "");
        bfor.telefone           = bfor.telefone.replace("-", "");
        if(!bfor.telefone.equals(""))
            bfor.telefone   = "'" + bfor.telefone + "'";
        else
            bfor.telefone   = null;
        bfor.email              = txt_email.getText();
        bfor.cep                = txt_cep.getText();
        bfor.RecarregaCEPs();
        bfor.cep                = bfor.cep.replace(" ", "");
        if(bfor.cep.equals("")){
            bcep.cep            = fc.FormataCampo("", 8, 0);
            bfor.RecarregaCEPs();
        }
        bfor.cidade             = txt_cidade.getText();
        bfor.endereco           = txt_endereco.getText();
        bfor.numero             = txt_numero.getText();
        bfor.bairro             = txt_bairro.getText();
        if(combo_uf.getSelectedIndex() == 0){
            Mensagem = "Unidade Federativa inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bfor.uf                 = String.valueOf(combo_uf.getSelectedItem());
        bfor.codigoPais         = Integer.parseInt(fc.FormataCampo(txt_codigoPais.getText(), 4, 0));
        bfor.observacoes        = txt_observacoes.getText();
        
        bfor.idEmpresaAlterou       = parametrosNS.be.idEmpresa;
        bfor.codigoGrupoAlterou     = parametrosNS.bge.codigoGrupo;
        bfor.codigoEmpresaAlterou   = parametrosNS.be.codigoEmpresa;
        bfor.dataAlterou            = invdata.inverterData(cdh.CapturarData(), 2);
        bfor.horaAlterou            = cdh.CapturaHora();
        bfor.usuarioAlterou         = parametrosNS.bu.codigoUsuario;
    }
    
    private void ValidaCNPJ(){
        bfor.cnpj1 = txt_cnpj1.getText().replace(" ", "");
        bfor.cnpj2 = txt_cnpj2.getText().replace(" ", "");
        bfor.cnpj3 = txt_cnpj3.getText().replace(" ", "");
        
        if(bfor.cnpj1.equals(""))return;
        if(bfor.cnpj2.equals(""))return;
        if(bfor.cnpj3.equals(""))return;
        
        bfor.cnpj = bfor.cnpj1 + bfor.cnpj2 + bfor.cnpj3;
        validadorCnpj = vcc.VALIDARCPFCNPJ(bfor.cnpj);
        if(validadorCnpj == true){
            HabilitaBotoes();
            return;
        }
        Mensagem = "CNPJ Inválido!";
        new MostraMensagem(Mensagem);
        bt_incluir.setEnabled(false);
        bt_alterar.setEnabled(false);
    }
    
    private void PegaFornecedor(){
        txt_codigoFornecedor.setText(fc.FormataCampo(txt_codigoFornecedor.getText(), 5, 0));
        bfor.codigoFornecedor = Integer.parseInt(txt_codigoFornecedor.getText());
        if(bfor.codigoFornecedor == 0)
            return;
        sql = "select * from tb_fornecedor where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoFornecedor = " + bfor.codigoFornecedor + ";";
        dadosFornecedor.clear();
        dadosFornecedor = parametrosNS.dao.Consulta(sql);
        if(dadosFornecedor.isEmpty()){
            Mensagem = "Fornecedor " + bfor.codigoFornecedor + " não encontrado, para incluir pressione NOVO!";
            new MostraMensagem(Mensagem);
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        HabilitaCampos(true);
        PreencherCamposFornecedor();
    }
    
    private void PreencherCamposFornecedor(){
        for(int i = 0; i < dadosFornecedor.size(); i++){
            if(dadosFornecedor.get(i).get(0) != null)
                bfor.idFornecedor           = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(0)));
            if(dadosFornecedor.get(i).get(1) != null)
                bfor.idEmpresa              = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(1)));
            if(dadosFornecedor.get(i).get(2) != null)
                bfor.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(2)));
            if(dadosFornecedor.get(i).get(3) != null)
                bfor.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(3)));
            if(dadosFornecedor.get(i).get(4) != null)
                bfor.codigoFornecedor       = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(4)));
            if(dadosFornecedor.get(i).get(5) != null)
                bfor.statusFornecedor       = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(5)));
                bfor.dataCadastro           =                    String.valueOf(dadosFornecedor.get(i).get(6));
                bfor.cnpj                   =                    String.valueOf(dadosFornecedor.get(i).get(7));
                bfor.nome                   =                    String.valueOf(dadosFornecedor.get(i).get(8));
                bfor.contato                =                    String.valueOf(dadosFornecedor.get(i).get(9));
                bfor.telefone               =                    String.valueOf(dadosFornecedor.get(i).get(10));
                bfor.email                  =                    String.valueOf(dadosFornecedor.get(i).get(11));
                bfor.cep                    =                    String.valueOf(dadosFornecedor.get(i).get(12));
                bfor.cidade                 =                    String.valueOf(dadosFornecedor.get(i).get(13));
                bfor.endereco               =                    String.valueOf(dadosFornecedor.get(i).get(14));
                bfor.numero                 =                    String.valueOf(dadosFornecedor.get(i).get(15));
                bfor.bairro                 =                    String.valueOf(dadosFornecedor.get(i).get(16));
                bfor.uf                     =                    String.valueOf(dadosFornecedor.get(i).get(17));
            if(dadosFornecedor.get(i).get(18) != null)
                bfor.codigoPais             = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(18)));
                bfor.observacoes            =                    String.valueOf(dadosFornecedor.get(i).get(19));
                bfor.dataAlterou            =                    String.valueOf(dadosFornecedor.get(i).get(20));
                bfor.horaAlterou            =                    String.valueOf(dadosFornecedor.get(i).get(21));
            if(dadosFornecedor.get(i).get(22) != null)
                bfor.usuarioAlterou         = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(22)));
            if(dadosFornecedor.get(i).get(23) != null)
                bfor.idEmpresaAlterou       = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(23)));
            if(dadosFornecedor.get(i).get(24) != null)
                bfor.codigoGrupoAlterou     = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(24)));
            if(dadosFornecedor.get(i).get(25) != null)
                bfor.codigoEmpresaAlterou   = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(25)));
        }
        if(bfor.statusFornecedor == 1)
            check_bloqueado.setSelected(true);
        else
            check_bloqueado.setSelected(false);
        
        bfor.cnpj1 = bfor.cnpj.substring(0, 9);
        bfor.cnpj2 = bfor.cnpj.substring(9, 13);
        bfor.cnpj3 = bfor.cnpj.substring(13, 15);
        txt_cnpj1.setText(bfor.cnpj1);
        txt_cnpj2.setText(bfor.cnpj2);
        txt_cnpj3.setText(bfor.cnpj3);
        
        txt_dataCadastro.setText(invdata.inverterData(bfor.dataCadastro, 1));
        txt_nome        .setText(bfor.nome);
        txt_contato     .setText(bfor.contato);
        txt_telefone    .setText(bfor.telefone);
        txt_email       .setText(bfor.email);
        txt_cep         .setText(bfor.cep);
        txt_observacoes .setText(bfor.observacoes);
        
        txt_codigoPais  .setText(fc.FormataCampo(String.valueOf(bfor.codigoPais), 4, 0));
        PegaPais();
        
        if(bfor.endereco.equals("")){
            PegaCep();
            bfor.endereco   = bcep.endereco;
            bfor.cidade     = bcep.cidade;
            bfor.bairro     = bcep.bairro;
            bfor.uf         = bcep.uf;
        }
        combo_uf        .setSelectedItem(bfor.uf);
        txt_cidade      .setText(bfor.cidade);
        txt_bairro      .setText(bfor.bairro);
        txt_endereco    .setText(bfor.endereco);
        txt_numero      .setText(bfor.numero);
        
        if(bfor.usuarioAlterou != 0){
            bu.usuario          = "NS3";
            bfor.dataAlterou    = invdata.inverterData(bfor.dataAlterou, 1);
            if(parametrosNS.bu.codigoUsuario != 999){
                bu.idEmpresa        = bfor.idEmpresaAlterou;
                bu.codigoGrupo      = bfor.codigoGrupoAlterou;
                bu.codigoEmpresa    = bfor.codigoEmpresaAlterou;
                bu.codigoUsuario    = bfor.usuarioAlterou;
                PegaUsuario();
            }
            label_alteracao.setText("Última alteração feita em " + bfor.dataAlterou + " às " + bfor.horaAlterou + " por " + bu.usuario);
        }
    }
    
    private void PegaUsuario(){
        bu.usuario  = "----------";
        sql = "select usuario from tb_usuarios where codigoGrupo = " + bu.codigoGrupo + " and codigoEmpresa = " + bu.codigoEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
        dadosUsuario.clear();
        dadosUsuario = parametrosNS.dao.Consulta(sql);
        if(dadosUsuario.isEmpty()){
            Mensagem = "Usuario " + bu.codigoUsuario + " não encontrado!!!";
            new MostraMensagem(Mensagem);
            bu.usuario = "";
            return;
        }
        PegaDadosUsuarios();
    }
    
    private void PegaDadosUsuarios(){
        for(int i = 0; i < dadosUsuario.size(); i++)
            bu.usuario      = String.valueOf(dadosUsuario.get(i).get(0));
    }
    
    private void PegaCep(){
        bfor.cep = txt_cep.getText();
        bfor.cep = bfor.cep.replace(" ", "");
        bfor.cep = bfor.cep.replace("-", "");
        if(bfor.cep.equals(""))
            return;
        if(Integer.parseInt(bfor.cep) == 0)
            return;
        sql = "select * from ns_cep where cep = '" + bfor.cep + "';";
        dadosCEP.clear();
        dadosCEP = parametrosNS.dao.Consulta(sql);
        if(dadosCEP.isEmpty()){
            Mensagem = "CEP " + bfor.cep + " não encontrado!";
            new MostraMensagem(Mensagem);
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
        txt_cep         .setText(bcep.cep);
        txt_cidade      .setText(bcep.cidade);
        txt_endereco    .setText(bcep.endereco);
        txt_bairro      .setText(bcep.bairro);
        combo_uf        .setSelectedItem(bcep.uf);
        txt_codigoPais  .setText("1058");
        PegaPais();
    }
    
    private void PegaPais(){
        if(abriuPais == 1)
            return;
        txt_codigoPais.setText(fc.FormataCampo(txt_codigoPais.getText(), 4, 0));
        bfor.codigoPais = Integer.parseInt(fc.FormataCampo(txt_codigoPais.getText(), 4, 0));
        if(bfor.codigoPais == 0)
            return;
        if(String.valueOf(combo_uf.getSelectedItem()).equals("ZZ"))
            if(bfor.codigoPais == 1058)
                return;
        sql = "select * from ns_paises where codigoPais = '" + bfor.codigoPais + "';";
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
        label_pais.setText(bpais.nomePais);
    }
    
}

