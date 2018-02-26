package TelasCompras;

import Beans.BeanFormasPagamentos;
import Beans.BeanFornecedor;
import Beans.BeanOrdemCompra;
import Beans.BeanOrdemCompraItens;
import Beans.BeanProdutos;
import Beans.BeanUsuarios;
import BeansNS.BeanCEP;
import BeansNS.BeanEmpresas;
import BeansNS.BeanEstados;
import BeansNS.BeanPais;
import FuncoesInternas.AjustarLarguraColunas;
import FuncoesInternas.MostraMensagem;
import Parametros.parametrosNS;
import Telas.CodigoEnderecamentoPostalConsulta;
import Telas.PaisesConsulta;
import TelasDeConfiguracoes.EmpresasConsulta;
import TelasEstoque.FornecedorConsulta;
import TelasVendas.FormasDePagamentoConsulta;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 @author Tiago e Paulo 13/09/2017 09:25
 */
public class OrdemCompraCadastro extends javax.swing.JFrame {
    //String
    String sql              = "";
    String sqlstate         = "";
    String fatal            = "";
    String somostra         = "";
    String mensagem         = "";
    String operacao         = "";
    String retorno          = "";
    
    //int
    int linha                    = 0;
    int abriuCEP                 = 0;
    int abriuEmpresa             = 0;
    int abriuFornecedor          = 0;
    int abriuFormaDePagamento    = 0;
    int abriuPais                = 0;
    int abriuOrdemCompraPesquisa = 0;
    int abriuItemOrdemCompra     = 0;
    
    //Vetores
    ArrayList            parametros             = new ArrayList();
    ArrayList<ArrayList> dadosCEP               = new ArrayList();
    ArrayList<ArrayList> dadosEmpresas          = new ArrayList();
    ArrayList<ArrayList> dadosEstados           = new ArrayList();
    ArrayList<ArrayList> dadosFormasPagamentos  = new ArrayList();
    ArrayList<ArrayList> dadosFornecedor        = new ArrayList();
    ArrayList<ArrayList> dadosOrdemCompra       = new ArrayList();
    ArrayList<ArrayList> dadosOrdemCompraItens  = new ArrayList();
    ArrayList<ArrayList> dadosPaises            = new ArrayList();
    ArrayList<ArrayList> dadosProdutos          = new ArrayList();
    ArrayList<ArrayList> dadosUsuarios          = new ArrayList();
    
    //Bean
    BeanCEP              bcep    = new BeanCEP();
    BeanEmpresas         be      = new BeanEmpresas();
    BeanEstados          best    = new BeanEstados();
    BeanFormasPagamentos bforp   = new BeanFormasPagamentos();
    BeanFornecedor       bfor    = new BeanFornecedor();
    BeanOrdemCompra      boc     = new BeanOrdemCompra();
    BeanOrdemCompraItens boci    = new BeanOrdemCompraItens();
    BeanPais             bpais   = new BeanPais();
    BeanProdutos         bp      = new BeanProdutos();
    BeanUsuarios         bu      = new BeanUsuarios();
    
    //Telas
    CodigoEnderecamentoPostalConsulta CodEndPosCon;
    EmpresasConsulta                EmpCon;
    FormasDePagamentoConsulta       ForDePagCon;
    FornecedorConsulta              ForCon;
    OrdemCompraItemCadastro         OrdComIteCad;
    OrdemCompraConsultaEManutencao  OrdCompConEMan;
    PaisesConsulta                  PaisCon;
    
    //Especiais
    DefaultTableModel Table;
    
    public OrdemCompraCadastro(String Somostra, int IdOrdemCompra){
        somostra          = Somostra;
        boc.idOrdemCompra = IdOrdemCompra;
        
        initComponents();
    }
    
    private void DesabilitaAcoes(){
        bt_incluir                  .setVisible  (false);
        bt_alterar                  .setVisible  (false);
        txt_codigoFornecedor        .setEditable (false);
        txt_codigoFornecedor        .setFocusable(false);
        bt_pesquisaFornecedor       .setEnabled  (false);
        bt_pesquisaFornecedor       .setEnabled  (false);
        bt_pesquisaFormaDePagamento .setEnabled  (false);
        bt_pesquisaCEP              .setEnabled  (false);
        bt_pesquisaPais             .setEnabled  (false);
//        bt_cancelarOrdemServico     .setVisible  (false);
//        bt_finalizarOrdemServico    .setVisible  (false);
        bt_incluirItem              .setVisible  (false);
        bt_alterarItem              .setVisible  (false);
        bt_excluirItem              .setVisible  (false);
        bt_detalhesItem             .setVisible  (true);
        bt_detalhesItem             .setEnabled  (false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_codigoOrdemCompra = new javax.swing.JFormattedTextField();
        bt_novo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigoEmpresa = new javax.swing.JFormattedTextField();
        bt_pesquisaEmpresa = new javax.swing.JButton();
        label_nomeEmpresa = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_dataCadastro = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_codigoFornecedor = new javax.swing.JFormattedTextField();
        bt_pesquisaFornecedor = new javax.swing.JButton();
        label_nomeFornecedor = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_cnpjFor1 = new javax.swing.JFormattedTextField();
        txt_cnpjFor2 = new javax.swing.JFormattedTextField();
        txt_cnpjFor3 = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        bt_pesquisaFormaDePagamento = new javax.swing.JButton();
        txt_dataDeCompra = new javax.swing.JFormattedTextField();
        label_descricaoPagamento = new javax.swing.JLabel();
        txt_horaDeCompra = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_valorDeCompra = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_codigoPagamento = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_dataDePagamento = new javax.swing.JFormattedTextField();
        txt_horaDePagamento = new javax.swing.JFormattedTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_dataDeRecebimento = new javax.swing.JFormattedTextField();
        txt_horaDeRecebimento = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_cepDeRecebimento = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_cidadeDeRecebimento = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_enderecoDeRecebimento = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txt_numeroDeRecebimento = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txt_bairroDeRecebimento = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        combo_uf = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        txt_codigoPais = new javax.swing.JFormattedTextField();
        bt_pesquisaPais = new javax.swing.JButton();
        label_nomePais = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txt_responsavelPeloRecebimento = new javax.swing.JTextField();
        bt_pesquisaCEP = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_observacoes = new javax.swing.JTextArea();
        txt_codigoUsuarioDigitou = new javax.swing.JFormattedTextField();
        label_nomeUsuarioDigitou = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        bt_incluir = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_cnpjEmp1 = new javax.swing.JFormattedTextField();
        txt_cnpjEmp2 = new javax.swing.JFormattedTextField();
        txt_cnpjEmp3 = new javax.swing.JFormattedTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_detalhesOrdemCompra = new javax.swing.JTable();
        bt_incluirItem = new javax.swing.JButton();
        bt_alterarItem = new javax.swing.JButton();
        bt_excluirItem = new javax.swing.JButton();
        bt_detalhesItem = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        label_alteracao1 = new javax.swing.JLabel();
        bt_pesquisa = new javax.swing.JButton();
        bt_imprimir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ordem de Compra");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
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
        jLabel1.setText("Ordem de Compra");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_codigoOrdemCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoOrdemCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoOrdemCompra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoOrdemCompraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoOrdemCompraFocusLost(evt);
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
                .addComponent(txt_codigoOrdemCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_novo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_novo)
                    .addComponent(txt_codigoOrdemCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, txt_codigoOrdemCompra});

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Empresa compradora");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        bt_pesquisaEmpresa.setText("...");
        bt_pesquisaEmpresa.setEnabled(false);
        bt_pesquisaEmpresa.setFocusable(false);
        bt_pesquisaEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaEmpresaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_codigoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_pesquisaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_nomeEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nomeEmpresa))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaEmpresa, label_nomeEmpresa, txt_codigoEmpresa});

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Data de Cadastro");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_dataCadastro.setEditable(false);
        try {
            txt_dataCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataCadastro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataCadastro.setFocusable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_dataCadastro)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_dataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Empresa beneficiária");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        bt_pesquisaFornecedor.setText("...");
        bt_pesquisaFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaFornecedorActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Fornecedor:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("CNPJ:");

        txt_cnpjFor1.setEditable(false);
        txt_cnpjFor1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cnpjFor1.setFocusable(false);

        txt_cnpjFor2.setEditable(false);
        txt_cnpjFor2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cnpjFor2.setFocusable(false);

        txt_cnpjFor3.setEditable(false);
        txt_cnpjFor3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cnpjFor3.setFocusable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_codigoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_pesquisaFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_nomeFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cnpjFor1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cnpjFor2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cnpjFor3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_codigoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_pesquisaFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_cnpjFor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cnpjFor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cnpjFor3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(label_nomeFornecedor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaFornecedor, jLabel5, jLabel6, label_nomeFornecedor, txt_codigoFornecedor});

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Dados da Compra");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Data da compra:");

        bt_pesquisaFormaDePagamento.setText("...");
        bt_pesquisaFormaDePagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaFormaDePagamentoActionPerformed(evt);
            }
        });

        try {
            txt_dataDeCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataDeCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        try {
            txt_horaDeCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_horaDeCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Valor da compra:");

        txt_valorDeCompra.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_valorDeCompra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_valorDeCompraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorDeCompraFocusLost(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Forma do pagamento:");

        try {
            txt_codigoPagamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoPagamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoPagamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoPagamentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoPagamentoFocusLost(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Data do pagamento:");

        try {
            txt_dataDePagamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataDePagamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        try {
            txt_horaDePagamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_horaDePagamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addGap(0, 4, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txt_dataDeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_horaDeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_valorDeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txt_dataDePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_horaDePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txt_codigoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisaFormaDePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_descricaoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel12, jLabel7, jLabel8, jLabel9});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_dataDeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_horaDeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_valorDeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bt_pesquisaFormaDePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_codigoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_dataDePagamento)
                                    .addComponent(txt_horaDePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(label_descricaoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaFormaDePagamento, jLabel12, jLabel7, jLabel8, jLabel9, label_descricaoPagamento, txt_codigoPagamento, txt_dataDeCompra, txt_dataDePagamento, txt_horaDeCompra, txt_horaDePagamento, txt_valorDeCompra});

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Dados do Recebimento");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Data:");

        try {
            txt_dataDeRecebimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataDeRecebimento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        try {
            txt_horaDeRecebimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_horaDeRecebimento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("CEP:");

        try {
            txt_cepDeRecebimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cepDeRecebimento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cepDeRecebimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_cepDeRecebimentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cepDeRecebimentoFocusLost(evt);
            }
        });

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Cidade:");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Endereço:");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Número:");

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Bairro:");

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("UF:");

        combo_uf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----" }));

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("País:");

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

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Reponsável:");

        bt_pesquisaCEP.setText("jButton1");
        bt_pesquisaCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaCEPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addComponent(txt_codigoPais, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisaPais, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_nomePais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_dataDeRecebimento, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                .addComponent(txt_cepDeRecebimento))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_horaDeRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bt_pesquisaCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_enderecoDeRecebimento, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                                .addComponent(txt_bairroDeRecebimento))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel19)
                                .addComponent(jLabel21))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_numeroDeRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(combo_uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(txt_cidadeDeRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_responsavelPeloRecebimento))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel19, jLabel21});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txt_dataDeRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_horaDeRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txt_cepDeRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txt_cidadeDeRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txt_enderecoDeRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txt_numeroDeRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txt_bairroDeRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(combo_uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txt_codigoPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaPais, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nomePais))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txt_responsavelPeloRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaCEP, bt_pesquisaPais, jLabel15, jLabel16, jLabel17, jLabel18, jLabel19, jLabel20, jLabel21, jLabel22, jLabel23, label_nomePais, txt_bairroDeRecebimento, txt_cepDeRecebimento, txt_cidadeDeRecebimento, txt_codigoPais, txt_dataDeRecebimento, txt_enderecoDeRecebimento, txt_numeroDeRecebimento});

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Observações");
        jLabel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_observacoes.setColumns(20);
        txt_observacoes.setRows(5);
        jScrollPane1.setViewportView(txt_observacoes);

        txt_codigoUsuarioDigitou.setEditable(false);
        try {
            txt_codigoUsuarioDigitou.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoUsuarioDigitou.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoUsuarioDigitou.setFocusable(false);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Digitado por:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_codigoUsuarioDigitou, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_nomeUsuarioDigitou, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_codigoUsuarioDigitou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nomeUsuarioDigitou))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel13, label_nomeUsuarioDigitou, txt_codigoUsuarioDigitou});

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

        bt_sair.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("CNPJ");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_cnpjEmp1.setEditable(false);
        try {
            txt_cnpjEmp1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("### ### ###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cnpjEmp1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cnpjEmp1.setFocusable(false);
        txt_cnpjEmp1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_cnpjEmp1FocusGained(evt);
            }
        });

        txt_cnpjEmp2.setEditable(false);
        txt_cnpjEmp2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cnpjEmp2.setFocusable(false);

        txt_cnpjEmp3.setEditable(false);
        try {
            txt_cnpjEmp3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cnpjEmp3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cnpjEmp3.setFocusable(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_cnpjEmp1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cnpjEmp2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cnpjEmp3, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cnpjEmp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cnpjEmp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cnpjEmp3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Detalhes");
        jLabel25.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_detalhesOrdemCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Descrição", "Valor Unitário", "Qtd", "Valor Subtotal", "Valor Desconto", "Valor Total", "Usuário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_detalhesOrdemCompra.getTableHeader().setReorderingAllowed(false);
        tabela_detalhesOrdemCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_detalhesOrdemCompraMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabela_detalhesOrdemCompra);
        if (tabela_detalhesOrdemCompra.getColumnModel().getColumnCount() > 0) {
            tabela_detalhesOrdemCompra.getColumnModel().getColumn(0).setResizable(false);
            tabela_detalhesOrdemCompra.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabela_detalhesOrdemCompra.getColumnModel().getColumn(1).setResizable(false);
            tabela_detalhesOrdemCompra.getColumnModel().getColumn(2).setResizable(false);
            tabela_detalhesOrdemCompra.getColumnModel().getColumn(3).setResizable(false);
            tabela_detalhesOrdemCompra.getColumnModel().getColumn(4).setResizable(false);
            tabela_detalhesOrdemCompra.getColumnModel().getColumn(5).setResizable(false);
            tabela_detalhesOrdemCompra.getColumnModel().getColumn(6).setResizable(false);
            tabela_detalhesOrdemCompra.getColumnModel().getColumn(7).setResizable(false);
        }

        bt_incluirItem.setText("Incluir Item");
        bt_incluirItem.setEnabled(false);
        bt_incluirItem.setFocusable(false);
        bt_incluirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_incluirItemActionPerformed(evt);
            }
        });

        bt_alterarItem.setText("Alterar Item");
        bt_alterarItem.setEnabled(false);
        bt_alterarItem.setFocusable(false);
        bt_alterarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterarItemActionPerformed(evt);
            }
        });

        bt_excluirItem.setText("Excluir Item");
        bt_excluirItem.setEnabled(false);
        bt_excluirItem.setFocusable(false);
        bt_excluirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluirItemActionPerformed(evt);
            }
        });

        bt_detalhesItem.setText("Detalhes");
        bt_detalhesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_detalhesItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 931, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(bt_incluirItem)
                        .addGap(1, 1, 1)
                        .addComponent(bt_alterarItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_excluirItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_detalhesItem)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_incluirItem)
                    .addComponent(bt_alterarItem)
                    .addComponent(bt_excluirItem)
                    .addComponent(bt_detalhesItem))
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));

        label_alteracao1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_alteracao1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_alteracao1, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
        );

        bt_pesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/View.png"))); // NOI18N
        bt_pesquisa.setText("Pesquisa");
        bt_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaActionPerformed(evt);
            }
        });

        bt_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/print.png"))); // NOI18N
        bt_imprimir.setText("Imprimir");
        bt_imprimir.setEnabled(false);
        bt_imprimir.setFocusable(false);
        bt_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imprimirActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(bt_incluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_alterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_imprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_sair))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_alterar, bt_imprimir, bt_incluir, bt_pesquisa, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        ReiniciaCampos();
        
        boc.codigoOrdemCompra = parametrosNS.PegProReg.PegaProximoRegistro("tb_oc", "codigoOrdemCompra", "");
        txt_codigoOrdemCompra.setText(parametrosNS.fc.FormataCampo(String.valueOf(boc.codigoOrdemCompra), 9, 0));
        
        operacao = "I";
        HabilitaBotoes();
        HabilitaCampos(true);
    }//GEN-LAST:event_bt_novoActionPerformed

    private void txt_cnpjEmp1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cnpjEmp1FocusGained
        txt_cnpjEmp1.setText("");
    }//GEN-LAST:event_txt_cnpjEmp1FocusGained

    private void txt_codigoEmpresaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoEmpresaFocusLost
        if(txt_codigoEmpresa.isEditable() == false)
            return;
        if(txt_codigoEmpresa.getText().replace(" ", "").equals(""))
            return;
        PegaEmpresa();
    }//GEN-LAST:event_txt_codigoEmpresaFocusLost

    private void txt_codigoEmpresaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoEmpresaFocusGained
        if(txt_codigoEmpresa.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        txt_codigoEmpresa .setText("");
        bt_pesquisaEmpresa.setEnabled  (true);
        bt_pesquisaEmpresa.setFocusable(true);
    }//GEN-LAST:event_txt_codigoEmpresaFocusGained

    private void bt_pesquisaEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaEmpresaActionPerformed
        if(bt_pesquisaEmpresa.isEnabled() == false){
            return;
        }
        if(bt_pesquisaEmpresa.isFocusable() == false){
            return;
        }
        if(EmpCon != null)
            if(EmpCon.isVisible()){
                EmpCon.setState(JFrame.NORMAL);
                return;
            }
        abriuEmpresa = 1;
        EmpCon = new EmpresasConsulta(parametrosNS.bge.CodigoGrupo);
        EmpCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaEmpresaActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuEmpresa == 0){
            AbreFornecedor();
            return;
        }
        abriuEmpresa = 0;
        retorno = EmpCon.getRetorno();
        if(retorno.equals("")){
            return;
        }
        txt_codigoEmpresa.setText(retorno);
        PegaEmpresa();
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbreFornecedor(){
        if(abriuFornecedor == 0){
            AbreFormaDePagamento();
            return;
        }
        abriuFornecedor = 0;
        retorno = ForCon.getRetorno();
        if(retorno.equals("")){
            return;
        }
        txt_codigoFornecedor.setText(retorno);
        PegaFornecedor();
    }
    
    private void AbreFormaDePagamento(){
        if(abriuFormaDePagamento == 0){
            AbreCEP();
            return;
        }
        abriuFormaDePagamento = 0;
        retorno = ForDePagCon.getRetorno();
        if(retorno.equals("")){
            return;
        }
        txt_codigoPagamento.setText(retorno);
        PegaFormaDePagamento();
    }
    
    private void AbreCEP(){
        if(abriuCEP == 0){
            AbrePais();
            return;
        }
        abriuCEP = 0;
        retorno = CodEndPosCon.getRetorno();
        if(retorno.equals("")){
            return;
        }
        txt_cepDeRecebimento.setText(retorno);
        PegaCEP();
    }
    
    private void AbrePais(){
        if(abriuPais == 0){
            AbreItemOrdemCompra();
            return;
        }
        abriuPais = 0;
        retorno = PaisCon.getRetorno();
        if(retorno.equals("")){
            return;
        }
        txt_codigoPais.setText(retorno);
        PegaPais();
    }
    
    private void AbreItemOrdemCompra(){
        if(abriuItemOrdemCompra == 0){
            AbreOrdemCompra();
            return;
        }
        abriuItemOrdemCompra = 0;
        PegaOrdemCompraItem();
    }
    
    private void AbreOrdemCompra(){
        if(abriuOrdemCompraPesquisa == 0){
            return;
        }
        abriuOrdemCompraPesquisa = 0;
        retorno = OrdCompConEMan.getRetorno();
        if(retorno.equals("")){
            return;
        }
        boc.idOrdemCompra = Integer.parseInt(retorno);
        sql = "select * from tb_oc where idOrdemCompra = " + boc.idOrdemCompra + ";";
        PegaOrdemCompra();
    }
    
    private void txt_codigoFornecedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFornecedorFocusGained
        if(txt_codigoFornecedor.isEditable() == false)
            return;
        if(somostra.equals(""))
            return;
        txt_codigoFornecedor.setText("");
        label_nomeFornecedor.setText("");
        txt_cnpjFor1        .setText("");
        txt_cnpjFor2        .setText("");
        txt_cnpjFor3        .setText("");
    }//GEN-LAST:event_txt_codigoFornecedorFocusGained

    private void txt_codigoFornecedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFornecedorFocusLost
        if(txt_codigoFornecedor.isEditable() == false)
            return;
        if(txt_codigoFornecedor.getText().replace(" ", "").equals(""))
            return;
        bfor.codigoFornecedor = Integer.parseInt(txt_codigoFornecedor.getText().replace(" ", ""));
        if(bfor.codigoFornecedor == 0){
            return;
        }
        PegaFornecedor();
    }//GEN-LAST:event_txt_codigoFornecedorFocusLost

    private void bt_pesquisaFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaFornecedorActionPerformed
        if(bt_pesquisaFornecedor.isEnabled() == false){
            return;
        }
        if(bt_pesquisaFornecedor.isFocusable() == false){
            return;
        }
        if(ForCon != null)
            if(ForCon.isVisible()){
                ForCon.setState(JFrame.NORMAL);
                return;
            }
        abriuFornecedor = 1;
        ForCon = new FornecedorConsulta("N");
        ForCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaFornecedorActionPerformed

    private void txt_codigoPagamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPagamentoFocusGained
        if(txt_codigoPagamento.isEditable() == false){
            return;
        }
        if(txt_codigoPagamento.getText().replace(" ", "").equals("")){
            return;
        }
        txt_codigoPagamento     .setText("");
        label_descricaoPagamento.setText("");
    }//GEN-LAST:event_txt_codigoPagamentoFocusGained

    private void txt_cepDeRecebimentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cepDeRecebimentoFocusGained
        txt_cepDeRecebimento.setSelectionStart(0);
        txt_cepDeRecebimento.setSelectionEnd  (txt_cepDeRecebimento.getText().length());
    }//GEN-LAST:event_txt_cepDeRecebimentoFocusGained

    private void txt_cepDeRecebimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cepDeRecebimentoFocusLost
        if(txt_cepDeRecebimento.isEditable() == false){
            return;
        }
        if(somostra.equals("S")){
            return;
        }
        PegaCEP();
    }//GEN-LAST:event_txt_cepDeRecebimentoFocusLost

    private void txt_codigoPaisFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPaisFocusGained
        if(txt_codigoPais.isEditable() == false){
            return;
        }
        if(somostra.equals("S")){
            return;
        }
        txt_codigoPais.setText("");
        label_nomePais.setText("");
    }//GEN-LAST:event_txt_codigoPaisFocusGained

    private void txt_codigoPaisFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPaisFocusLost
        if(txt_codigoPais.isEditable() == false){
            return;
        }
        if(txt_codigoPais.getText().replace(" ", "").equals("")){
            return;
        }
        PegaPais();
    }//GEN-LAST:event_txt_codigoPaisFocusLost

    private void txt_codigoOrdemCompraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoOrdemCompraFocusLost
        if(txt_codigoOrdemCompra.isEditable() == false){
            return;
        }
        if(txt_codigoOrdemCompra.getText().replace(" ", "").equals("")){
            return;
        }
        boc.codigoOrdemCompra = Integer.parseInt(txt_codigoOrdemCompra.getText().replace(" ", ""));
        if(boc.codigoOrdemCompra == 0){
            return;
        }
        sql = "select * from tb_oc where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoOrdemCompra = " + boc.codigoOrdemCompra + ";";
        PegaOrdemCompra();
    }//GEN-LAST:event_txt_codigoOrdemCompraFocusLost

    private void bt_pesquisaFormaDePagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaFormaDePagamentoActionPerformed
        if(bt_pesquisaFormaDePagamento.isEnabled() == false){
            return;
        }
        if(bt_pesquisaFormaDePagamento.isFocusable() == false){
            return;
        }
        if(ForDePagCon != null)
            if(ForDePagCon.isVisible()){
                ForDePagCon.setState(JFrame.NORMAL);
                return;
            }
        abriuFormaDePagamento = 1;
        ForDePagCon = new FormasDePagamentoConsulta("N");
        ForDePagCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaFormaDePagamentoActionPerformed

    private void bt_pesquisaCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaCEPActionPerformed
        if(bt_pesquisaCEP.isEnabled() == false){
            return;
        }
        if(bt_pesquisaCEP.isFocusable() == false){
            return;
        }
        if(CodEndPosCon != null)
            if(CodEndPosCon.isVisible()){
                CodEndPosCon.setState(JFrame.NORMAL);
                return;
            }
        abriuCEP = 1;
        CodEndPosCon = new CodigoEnderecamentoPostalConsulta();
        CodEndPosCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaCEPActionPerformed

    private void bt_pesquisaPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaPaisActionPerformed
        if(bt_pesquisaPais.isEnabled() == false){
            return;
        }
        if(bt_pesquisaPais.isFocusable() == false){
            return;
        }
        if(PaisCon != null)
            if(PaisCon.isVisible()){
                PaisCon.setState(JFrame.NORMAL);
                return;
            }
        abriuPais = 1;
        PaisCon = new PaisesConsulta();
        PaisCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaPaisActionPerformed

    private void txt_codigoPagamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPagamentoFocusLost
        if(txt_codigoPagamento.isEditable() == false){
            return;
        }
        if(txt_codigoPagamento.getText().replace(" ", "").equals("")){
            return;
        }
        PegaFormaDePagamento();
    }//GEN-LAST:event_txt_codigoPagamentoFocusLost

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S")){return;}
        
        sql = "insert into tb_oc (idEmpresa, codigoGrupo, codigoEmpresa, codigoOrdemCompra, codigoComprador, codigoFornecedor, codigoUsuario, dataCadastro, dataDeCompra, horaDeCompra, valorDeCompra, codigoPagamento, dataDePagamento, horaDePagamento, dataDeRecebimento, horaDeRecebimento, cepDeRecebimento, cidadeDeRecebimento, enderecoDeRecebimento, numeroDeRecebimento, bairroDeRecebimento, ufDeRecebimento, codigoPais, responsavelPeloRecebimento, observacoes) "
            + "values (" + boc.idEmpresa + ", " + boc.codigoGrupo + ", " + boc.codigoEmpresa + ", " + boc.codigoOrdemCompra + ", " + boc.codigoComprador + ", " + boc.codigoFornecedor + ", " + boc.codigoUsuario + ", '" + boc.dataCadastro + "', " + boc.dataDeCompra + ", " + boc.horaDeCompra + ", " + boc.valorDeCompra + ", " + boc.codigoPagamento + ", " + boc.dataDePagamento + ", " + boc.horaDePagamento + ", " + boc.dataDeRecebimento + ", " + boc.horaDeRecebimento + ", " + boc.cepDeRecebimento + ", " + boc.cidadeDeRecebimento + ", " + boc.enderecoDeRecebimento + ", " + boc.numeroDeRecebimento + ", " + boc.bairroDeRecebimento + ", " + boc.ufDeRecebimento + ", " + boc.codigoPais + ", " + boc.responsavelPeloRecebimento + ", '" + boc.observacoes + "');";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            return;
        }
        if(OrdComIteCad != null)if(OrdComIteCad.isVisible()){
            OrdComIteCad.setState(JFrame.NORMAL);
            return;
        }
        sql = "select idOrdemCompra from tb_oc where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoOrdemCompra = " + boc.codigoOrdemCompra + ";";
        dadosOrdemCompra.clear();
        dadosOrdemCompra = parametrosNS.dao.Consulta(sql);
        boc.idOrdemCompra = Integer.parseInt(String.valueOf(dadosOrdemCompra.get(0).get(0)));
        operacao = "A";
        HabilitaBotoes();
        bt_incluirItem.setEnabled(true);
        abriuItemOrdemCompra = 1;
        parametros.clear();
        parametros.add("N");
        parametros.add("I");
        parametros.add(boc.idOrdemCompra);
        parametros.add(0);
        OrdComIteCad = new OrdemCompraItemCadastro(parametros);
        OrdComIteCad.setVisible(true);
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S")){return;}
        
        sql = "update tb_oc set codigoComprador = "            + boc.codigoComprador            + ", "  + 
                               "codigoFornecedor = "           + boc.codigoFornecedor           + ", "  + 
                               "dataCadastro = '"              + boc.dataCadastro               + "', " + 
                               "dataDeCompra = "               + boc.dataDeCompra               + ", "  + 
                               "horaDeCompra = "               + boc.horaDeCompra               + ", "  + 
                               "valorDeCompra = "              + boc.valorDeCompra              + ", "  + 
                               "codigoPagamento = "            + boc.codigoPagamento            + ", "  + 
                               "dataDePagamento = "            + boc.dataDePagamento            + ", "  + 
                               "horaDePagamento = "            + boc.horaDePagamento            + ", "  + 
                               "dataDeRecebimento = "          + boc.dataDeRecebimento          + ", "  + 
                               "horaDeRecebimento = "          + boc.horaDeRecebimento          + ", "  + 
                               "cepDeRecebimento = "           + boc.cepDeRecebimento           + ", "  + 
                               "cidadeDeRecebimento = "        + boc.cidadeDeRecebimento        + ", "  + 
                               "enderecoDeRecebimento = "      + boc.enderecoDeRecebimento      + ", "  + 
                               "numeroDeRecebimento = "        + boc.numeroDeRecebimento        + ", "  + 
                               "bairroDeRecebimento = "        + boc.bairroDeRecebimento        + ", "  + 
                               "ufDeRecebimento = "            + boc.ufDeRecebimento            + ", "  + 
                               "codigoPais = "                 + boc.codigoPais                 + ", "  + 
                               "responsavelPeloRecebimento = " + boc.responsavelPeloRecebimento + ", "  + 
                               "observacoes = '"               + boc.observacoes                + "', " + 
                               "dataAlterou = '"               + boc.dataAlterou                + "', " + 
                               "horaAlterou = '"               + boc.horaAlterou                + "', " + 
                               "usuarioAlterou = "             + boc.usuarioAlterou             + ", "  + 
                               "idEmpresaAlterou = "           + boc.idEmpresaAlterou           + ", "  + 
                               "codigoGrupoAlterou = "         + boc.codigoGrupoAlterou         + ", "  + 
                               "codigoEmpresaAlterou = "       + boc.codigoEmpresaAlterou       + " "  + 
                               "where idOrdemCompra = "     + boc.idOrdemCompra + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000")){
            return;
        }
        mensagem = "Ordem de compra n°" + boc.codigoOrdemCompra + " alterada com êxito!";
        mostraMensagem();
        txt_codigoOrdemCompra.grabFocus();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HabilitaCampos(false);
        Table = (DefaultTableModel)tabela_detalhesOrdemCompra.getModel();
        
        txt_codigoUsuarioDigitou.setText(parametrosNS.fc.FormataCampo(String.valueOf(parametrosNS.bu.codigoUsuario), 3, 0));
        label_nomeUsuarioDigitou.setText(parametrosNS.bu.usuario);
        
        PegaUF();
        
        txt_dataCadastro .setText(parametrosNS.cdh.CapturarData());
        txt_codigoEmpresa.setText(String.valueOf(parametrosNS.be.CodigoEmpresa));
        PegaEmpresa();
        
        bt_detalhesItem.setVisible(false);
        if(boc.idOrdemCompra != 0){
            txt_codigoOrdemCompra       .setEditable (false);
            txt_codigoOrdemCompra       .setFocusable(false);
            bt_novo                     .setEnabled  (false);
            sql = "select * from tb_oc where idOrdemCompra = " + boc.idOrdemCompra + ";";
            operacao = "A";
            PegaOrdemCompra();
        }
        if(somostra.equals("S")){
            txt_codigoOrdemCompra.setEditable(false);
            bt_novo              .setEnabled (false);
//            bt_pesquisa          .setVisible (false);
            DesabilitaAcoes();
        }
    }//GEN-LAST:event_formWindowOpened

    private void txt_valorDeCompraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorDeCompraFocusGained
        if(!txt_valorDeCompra.getText().equals(""))
            txt_valorDeCompra.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorDeCompra.getText(), 1));
        txt_valorDeCompra.setSelectionStart(0);
        txt_valorDeCompra.setSelectionEnd  (txt_valorDeCompra.getText().length());
    }//GEN-LAST:event_txt_valorDeCompraFocusGained

    private void txt_valorDeCompraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorDeCompraFocusLost
        if(!txt_valorDeCompra.getText().equals(""))
            txt_valorDeCompra.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorDeCompra.getText(), 0));
    }//GEN-LAST:event_txt_valorDeCompraFocusLost

    private void bt_incluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirItemActionPerformed
        if(OrdComIteCad != null)if(OrdComIteCad.isVisible()){
            OrdComIteCad.setState(JFrame.NORMAL);
            return;
        }
        abriuItemOrdemCompra = 1;
        parametros.clear();
        parametros.add("N");
        parametros.add("I");
        parametros.add(boc.idOrdemCompra);
        parametros.add(0);
        OrdComIteCad = new OrdemCompraItemCadastro(parametros);
        OrdComIteCad.setVisible(true);
    }//GEN-LAST:event_bt_incluirItemActionPerformed

    private void txt_codigoOrdemCompraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoOrdemCompraFocusGained
        if(txt_codigoOrdemCompra.isEditable() == false){
            return;
        }
        if(somostra.equals("S")){
            return;
        }
        operacao = "";
        HabilitaBotoes();
        txt_codigoOrdemCompra.setText("");
        ReiniciaCampos();
    }//GEN-LAST:event_txt_codigoOrdemCompraFocusGained

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(OrdComIteCad != null)OrdComIteCad    .dispose();
    }//GEN-LAST:event_formWindowClosed

    private void tabela_detalhesOrdemCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_detalhesOrdemCompraMouseClicked
        linha = tabela_detalhesOrdemCompra.getSelectedRow();
        if(linha < 0)
            return;
        boci.codigoOrdemCompraItem = Integer.parseInt(String.valueOf(tabela_detalhesOrdemCompra.getValueAt(linha, 0)));
        bt_alterarItem .setEnabled(true);
        bt_excluirItem .setEnabled(true);
        bt_detalhesItem.setEnabled(true);
    }//GEN-LAST:event_tabela_detalhesOrdemCompraMouseClicked

    private void bt_alterarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarItemActionPerformed
        if(OrdComIteCad != null)
            if(OrdComIteCad.isVisible()){
                OrdComIteCad.setState(JFrame.NORMAL);
                return;
            }
        abriuItemOrdemCompra = 1;
        parametros.clear();
        parametros.add("N");
        parametros.add("A");
        parametros.add(boc.idOrdemCompra);
        parametros.add(boci.codigoOrdemCompraItem);
        OrdComIteCad = new OrdemCompraItemCadastro(parametros);
        OrdComIteCad.setVisible(true);
    }//GEN-LAST:event_bt_alterarItemActionPerformed

    private void bt_excluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluirItemActionPerformed
        linha = tabela_detalhesOrdemCompra.getSelectedRow();
        if(linha < 0){
            mensagem = "Item não selecionado!";
            mostraMensagem();
            return;
        }
        boci.idEmpresa          = boc.idEmpresa;
        boci.codigoGrupo        = boc.codigoGrupo;
        boci.codigoEmpresa      = boc.codigoEmpresa;
        boci.codigoOrdemCompra  = boc.codigoOrdemCompra;
        boci.codigoOrdemCompraItem = Integer.parseInt(String.valueOf(tabela_detalhesOrdemCompra.getValueAt(linha, 0)));
        if(JOptionPane.showConfirmDialog(null, "Deseja excluir o item n°" + boci.codigoOrdemCompraItem + "?", "", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION)
            return;
        boci.codigoProduto  = Integer.parseInt(String.valueOf(tabela_detalhesOrdemCompra.getValueAt(linha, 1)).substring(0, 6));
        boci.quantidade     = Double.parseDouble(String.valueOf(tabela_detalhesOrdemCompra.getValueAt(linha, 3)));
        
        
        sql = "delete from tb_oc_itens where idEmpresa = " + boci.idEmpresa + " and codigoOrdemCompra = " + boci.codigoOrdemCompra + " and codigoOrdemCompraItem = " + boci.codigoOrdemCompraItem + ";";
        sqlstate = parametrosNS.dao.ExcluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        AtualizaEstoque();
        if(!sqlstate.equals("00000"))
            return;
        int codigoOrdemCompraItem = 0;
        for(int i = 0; i < tabela_detalhesOrdemCompra.getRowCount(); i++){
            boci.codigoOrdemCompraItem = Integer.parseInt(String.valueOf(tabela_detalhesOrdemCompra.getValueAt(i, 0)));
            codigoOrdemCompraItem = boci.codigoOrdemCompraItem + 1;
            sql = "update tb_oc_itens set codigoOrdemCompraItem = " + boci.codigoOrdemCompraItem + " where idEmpresa = " + boci.idEmpresa + " and codigoOrdemCompra = " + boci.codigoOrdemCompra + " and codigoOrdemCompraItem = " + codigoOrdemCompraItem + ";";
            parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        }
        PegaOrdemCompraItem();
    }//GEN-LAST:event_bt_excluirItemActionPerformed

    private void bt_detalhesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesItemActionPerformed
        if(OrdComIteCad != null){
            if(OrdComIteCad.isVisible()){
                OrdComIteCad.setState(JFrame.NORMAL);
                return;
            }
        }
        parametros.clear();
        parametros.add("S");
        parametros.add("");
        parametros.add(boc.idOrdemCompra);
        parametros.add(boci.codigoOrdemCompraItem);
        OrdComIteCad = new OrdemCompraItemCadastro(parametros);
        OrdComIteCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesItemActionPerformed

    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        if(OrdCompConEMan != null){
            if(OrdCompConEMan.isVisible()){
                OrdCompConEMan.setState(JFrame.NORMAL);
                return;
            }
        }
        abriuOrdemCompraPesquisa = 1;
        OrdCompConEMan = new OrdemCompraConsultaEManutencao("S", "N");
        OrdCompConEMan.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowLostFocus

    private void bt_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimirActionPerformed
        
    }//GEN-LAST:event_bt_imprimirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_alterarItem;
    private javax.swing.JButton bt_detalhesItem;
    private javax.swing.JButton bt_excluirItem;
    private javax.swing.JButton bt_imprimir;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_incluirItem;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisa;
    private javax.swing.JButton bt_pesquisaCEP;
    private javax.swing.JButton bt_pesquisaEmpresa;
    private javax.swing.JButton bt_pesquisaFormaDePagamento;
    private javax.swing.JButton bt_pesquisaFornecedor;
    private javax.swing.JButton bt_pesquisaPais;
    private javax.swing.JButton bt_sair;
    private javax.swing.JComboBox<String> combo_uf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
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
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_alteracao1;
    private javax.swing.JLabel label_descricaoPagamento;
    private javax.swing.JLabel label_nomeEmpresa;
    private javax.swing.JLabel label_nomeFornecedor;
    private javax.swing.JLabel label_nomePais;
    private javax.swing.JLabel label_nomeUsuarioDigitou;
    private javax.swing.JTable tabela_detalhesOrdemCompra;
    private javax.swing.JTextField txt_bairroDeRecebimento;
    private javax.swing.JFormattedTextField txt_cepDeRecebimento;
    private javax.swing.JTextField txt_cidadeDeRecebimento;
    private javax.swing.JFormattedTextField txt_cnpjEmp1;
    private javax.swing.JFormattedTextField txt_cnpjEmp2;
    private javax.swing.JFormattedTextField txt_cnpjEmp3;
    private javax.swing.JFormattedTextField txt_cnpjFor1;
    private javax.swing.JFormattedTextField txt_cnpjFor2;
    private javax.swing.JFormattedTextField txt_cnpjFor3;
    private javax.swing.JFormattedTextField txt_codigoEmpresa;
    private javax.swing.JFormattedTextField txt_codigoFornecedor;
    private javax.swing.JFormattedTextField txt_codigoOrdemCompra;
    private javax.swing.JFormattedTextField txt_codigoPagamento;
    private javax.swing.JFormattedTextField txt_codigoPais;
    private javax.swing.JFormattedTextField txt_codigoUsuarioDigitou;
    private javax.swing.JFormattedTextField txt_dataCadastro;
    private javax.swing.JFormattedTextField txt_dataDeCompra;
    private javax.swing.JFormattedTextField txt_dataDePagamento;
    private javax.swing.JFormattedTextField txt_dataDeRecebimento;
    private javax.swing.JTextField txt_enderecoDeRecebimento;
    private javax.swing.JFormattedTextField txt_horaDeCompra;
    private javax.swing.JFormattedTextField txt_horaDePagamento;
    private javax.swing.JFormattedTextField txt_horaDeRecebimento;
    private javax.swing.JTextField txt_numeroDeRecebimento;
    private javax.swing.JTextArea txt_observacoes;
    private javax.swing.JTextField txt_responsavelPeloRecebimento;
    private javax.swing.JTextField txt_valorDeCompra;
    // End of variables declaration//GEN-END:variables
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    private void ReiniciaCampos(){
        txt_codigoOrdemCompra           .setText(null);
        txt_codigoEmpresa               .setText(String.valueOf(parametrosNS.be.CodigoEmpresa));
        PegaEmpresa();
        txt_dataCadastro                .setText(parametrosNS.cdh.CapturarData());
        txt_codigoFornecedor            .setText(null);
        label_nomeFornecedor            .setText(null);
        txt_dataDeCompra                .setText(null);
        txt_horaDeCompra                .setText(null);
        txt_valorDeCompra               .setText(null);
        txt_codigoPagamento             .setText(null);
        label_descricaoPagamento        .setText(null);
        txt_dataDePagamento             .setText(null);
        txt_horaDePagamento             .setText(null);
        txt_dataDeRecebimento           .setText(null);
        txt_horaDeRecebimento           .setText(null);
        txt_cepDeRecebimento            .setText(null);
        txt_cidadeDeRecebimento         .setText(null);
        txt_enderecoDeRecebimento       .setText(null);
        txt_numeroDeRecebimento         .setText(null);
        txt_bairroDeRecebimento         .setText(null);
        combo_uf                        .setSelectedIndex(0);
        txt_codigoPais                  .setText(null);
        label_nomePais                  .setText(null);
        txt_responsavelPeloRecebimento  .setText(null);
        
        Table.setNumRows(0);
        
        txt_observacoes                 .setText(null);
        txt_codigoUsuarioDigitou        .setText(null);
        label_nomeUsuarioDigitou        .setText(null);
    }
    
    private void HabilitaCampos(boolean Habilita){
        txt_codigoFornecedor          .setEditable (Habilita);
        txt_codigoFornecedor          .setFocusable(Habilita);
        bt_pesquisaFornecedor         .setEnabled  (Habilita);
        bt_pesquisaFornecedor         .setFocusable(Habilita);
        txt_dataDeCompra              .setEditable (Habilita);
        txt_dataDeCompra              .setFocusable(Habilita);
        txt_horaDeCompra              .setEditable (Habilita);
        txt_horaDeCompra              .setFocusable(Habilita);
        txt_valorDeCompra             .setEditable (Habilita);
        txt_valorDeCompra             .setFocusable(Habilita);
        txt_codigoPagamento           .setEditable (Habilita);
        txt_codigoPagamento           .setFocusable(Habilita);
        bt_pesquisaFormaDePagamento   .setEnabled  (Habilita);
        bt_pesquisaFormaDePagamento   .setFocusable(Habilita);
        txt_dataDePagamento           .setEditable (Habilita);
        txt_dataDePagamento           .setFocusable(Habilita);
        txt_horaDePagamento           .setEditable (Habilita);
        txt_horaDePagamento           .setFocusable(Habilita);
        txt_dataDeRecebimento         .setEditable (Habilita);
        txt_dataDeRecebimento         .setFocusable(Habilita);
        txt_horaDeRecebimento         .setEditable (Habilita);
        txt_horaDeRecebimento         .setFocusable(Habilita);
        txt_cepDeRecebimento          .setEditable (Habilita);
        txt_cepDeRecebimento          .setFocusable(Habilita);
        bt_pesquisaCEP                .setEnabled  (Habilita);
        bt_pesquisaCEP                .setFocusable(Habilita);
        txt_cidadeDeRecebimento       .setEditable (Habilita);
        txt_cidadeDeRecebimento       .setFocusable(Habilita);
        txt_enderecoDeRecebimento     .setEditable (Habilita);
        txt_enderecoDeRecebimento     .setFocusable(Habilita);
        txt_numeroDeRecebimento       .setEditable (Habilita);
        txt_numeroDeRecebimento       .setFocusable(Habilita);
        txt_bairroDeRecebimento       .setEditable (Habilita);
        txt_bairroDeRecebimento       .setFocusable(Habilita);
        txt_responsavelPeloRecebimento.setEditable (Habilita);
        txt_responsavelPeloRecebimento.setFocusable(Habilita);
        combo_uf                      .setEnabled  (Habilita);
        combo_uf                      .setFocusable(Habilita);
        txt_codigoPais                .setEditable (Habilita);
        txt_codigoPais                .setFocusable(Habilita);
        bt_pesquisaPais               .setEnabled  (Habilita);
        bt_pesquisaPais               .setFocusable(Habilita);
        txt_observacoes               .setEditable (Habilita);
        txt_observacoes               .setFocusable(Habilita);
    }
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_incluir              .setEnabled(true);
            bt_alterar              .setEnabled(false);
            bt_incluirItem          .setEnabled(false);
            bt_alterarItem          .setEnabled(false);
            bt_excluirItem          .setEnabled(false);
            bt_imprimir             .setEnabled(false);
//            bt_finalizarOrdemCompra .setEnabled(false);
//            bt_cancelarOrdemCompra  .setEnabled(false);
            return;
        }
        if(operacao.equals("A")){
            bt_incluir              .setEnabled(false);
            bt_alterar              .setEnabled(true);
            bt_incluirItem          .setEnabled(true);
            bt_alterarItem          .setEnabled(false);
            bt_excluirItem          .setEnabled(false);
            bt_imprimir             .setEnabled(true);
//            bt_finalizarOrdemCompra .setEnabled(true);
//            bt_cancelarOrdemCompra  .setEnabled(true);
            return;
        }
        bt_incluir                  .setEnabled(false);
        bt_alterar                  .setEnabled(false);
        bt_incluirItem              .setEnabled(false);
        bt_alterarItem              .setEnabled(false);
        bt_excluirItem              .setEnabled(false);
        bt_imprimir                 .setEnabled(false);
//        bt_finalizarOrdemCompra     .setEnabled(false);
//        bt_cancelarOrdemCompra      .setEnabled(false);
    }
    
    private void PegaUF() {
        combo_uf.removeAllItems();
        combo_uf.addItem("--");
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
            combo_uf.addItem(best.uf);
        }
    }
    
    private void PegaOrdemCompra(){
        dadosOrdemCompra.clear();
        dadosOrdemCompra = parametrosNS.dao.Consulta(sql);
        if(dadosOrdemCompra.isEmpty()){
            mensagem = "Ordem de compra n°" + boc.codigoOrdemCompra + " não encontrada!";
            mostraMensagem();
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        HabilitaCampos(true);
        PegaDadosOrdemCompra();
    }
    
    private void PegaDadosOrdemCompra(){
        for(int i = 0; i < dadosOrdemCompra.size(); i++){
            boc = new BeanOrdemCompra();
            if(dadosOrdemCompra.get(i).get(0) != null)
                boc.idOrdemCompra              = Integer.parseInt(  String.valueOf(dadosOrdemCompra.get(i).get(0)));
            if(dadosOrdemCompra.get(i).get(1) != null)
                boc.idEmpresa                  = Integer.parseInt(  String.valueOf(dadosOrdemCompra.get(i).get(1)));
            if(dadosOrdemCompra.get(i).get(2) != null)
                boc.codigoGrupo                = Integer.parseInt(  String.valueOf(dadosOrdemCompra.get(i).get(2)));
            if(dadosOrdemCompra.get(i).get(3) != null)
                boc.codigoEmpresa              = Integer.parseInt(  String.valueOf(dadosOrdemCompra.get(i).get(3)));
            if(dadosOrdemCompra.get(i).get(4) != null)
                boc.codigoOrdemCompra          = Integer.parseInt(  String.valueOf(dadosOrdemCompra.get(i).get(4)));
            if(dadosOrdemCompra.get(i).get(5) != null)
                boc.codigoComprador            = Integer.parseInt(  String.valueOf(dadosOrdemCompra.get(i).get(5)));
            if(dadosOrdemCompra.get(i).get(6) != null)
                boc.codigoFornecedor           = Integer.parseInt(  String.valueOf(dadosOrdemCompra.get(i).get(6)));
            if(dadosOrdemCompra.get(i).get(7) != null)
                boc.codigoUsuario              = Integer.parseInt(  String.valueOf(dadosOrdemCompra.get(i).get(7)));
            if(dadosOrdemCompra.get(i).get(8) != null)
                boc.dataCadastro               =                    String.valueOf(dadosOrdemCompra.get(i).get(8));
            if(dadosOrdemCompra.get(i).get(9) != null)
                boc.dataDeCompra               =                    String.valueOf(dadosOrdemCompra.get(i).get(9));
            if(dadosOrdemCompra.get(i).get(10) != null)
                boc.horaDeCompra               =                    String.valueOf(dadosOrdemCompra.get(i).get(10));
            if(dadosOrdemCompra.get(i).get(11) != null)
                boc.valorDeCompra              = Double.parseDouble(String.valueOf(dadosOrdemCompra.get(i).get(11)));
            if(dadosOrdemCompra.get(i).get(12) != null)
                boc.codigoPagamento            = Integer.parseInt(  String.valueOf(dadosOrdemCompra.get(i).get(12)));
            if(dadosOrdemCompra.get(i).get(13) != null)
                boc.dataDePagamento            =                    String.valueOf(dadosOrdemCompra.get(i).get(13));
            if(dadosOrdemCompra.get(i).get(14) != null)
                boc.horaDePagamento            =                    String.valueOf(dadosOrdemCompra.get(i).get(14));
            if(dadosOrdemCompra.get(i).get(15) != null)
                boc.dataDeRecebimento          =                    String.valueOf(dadosOrdemCompra.get(i).get(15));
            if(dadosOrdemCompra.get(i).get(16) != null)
                boc.horaDeRecebimento          =                    String.valueOf(dadosOrdemCompra.get(i).get(16));
            if(dadosOrdemCompra.get(i).get(17) != null)
                boc.cepDeRecebimento           =                    String.valueOf(dadosOrdemCompra.get(i).get(17));
            if(dadosOrdemCompra.get(i).get(18) != null)
                boc.cidadeDeRecebimento        =                    String.valueOf(dadosOrdemCompra.get(i).get(18));
            if(dadosOrdemCompra.get(i).get(19) != null)
                boc.enderecoDeRecebimento      =                    String.valueOf(dadosOrdemCompra.get(i).get(19));
            if(dadosOrdemCompra.get(i).get(20) != null)
                boc.numeroDeRecebimento        =                    String.valueOf(dadosOrdemCompra.get(i).get(20));
            if(dadosOrdemCompra.get(i).get(21) != null)
                boc.bairroDeRecebimento        =                    String.valueOf(dadosOrdemCompra.get(i).get(21));
            if(dadosOrdemCompra.get(i).get(22) != null)
                boc.ufDeRecebimento            =                    String.valueOf(dadosOrdemCompra.get(i).get(22));
            if(dadosOrdemCompra.get(i).get(23) != null)
                boc.codigoPais                 = Integer.parseInt(  String.valueOf(dadosOrdemCompra.get(i).get(23)));
            if(dadosOrdemCompra.get(i).get(24) != null)
                boc.responsavelPeloRecebimento =                    String.valueOf(dadosOrdemCompra.get(i).get(24));
            if(dadosOrdemCompra.get(i).get(25) != null)
                boc.observacoes                =                    String.valueOf(dadosOrdemCompra.get(i).get(25));
            if(dadosOrdemCompra.get(i).get(26) != null)
                boc.dataAlterou                =                    String.valueOf(dadosOrdemCompra.get(i).get(26));
            if(dadosOrdemCompra.get(i).get(27) != null)
                boc.horaAlterou                =                    String.valueOf(dadosOrdemCompra.get(i).get(27));
            if(dadosOrdemCompra.get(i).get(28) != null)
                boc.usuarioAlterou             = Integer.parseInt(  String.valueOf(dadosOrdemCompra.get(i).get(28)));
            if(dadosOrdemCompra.get(i).get(29) != null)
                boc.idEmpresaAlterou           = Integer.parseInt(  String.valueOf(dadosOrdemCompra.get(i).get(29)));
            if(dadosOrdemCompra.get(i).get(30) != null)
                boc.codigoGrupoAlterou         = Integer.parseInt(  String.valueOf(dadosOrdemCompra.get(i).get(30)));
            if(dadosOrdemCompra.get(i).get(31) != null)
                boc.codigoEmpresaAlterou       = Integer.parseInt(  String.valueOf(dadosOrdemCompra.get(i).get(31)));
        }
        txt_codigoOrdemCompra.setText(parametrosNS.fc.FormataCampo(String.valueOf(boc.codigoOrdemCompra), 9, 0));
        
        //Empresa Compradora
        txt_codigoEmpresa.setText(String.valueOf(boc.codigoEmpresa));
        PegaEmpresa();
        
        //Data de Cadastro
        boc.dataCadastro      = parametrosNS.invdata.inverterData(boc.dataCadastro, 1);
        txt_dataCadastro.setText(boc.dataCadastro);
        
        //Fornecedor
        bfor.codigoFornecedor = boc.codigoFornecedor;
        txt_codigoFornecedor.setText(String.valueOf(bfor.codigoFornecedor));
        PegaFornecedor();
        
        //Usuário
        bu.codigoUsuario      = boc.codigoUsuario;
        PegaUsuario();
        txt_codigoUsuarioDigitou.setText(parametrosNS.fc.FormataCampo(String.valueOf(bu.codigoUsuario), 3, 0));
        label_nomeUsuarioDigitou.setText(bu.usuario);
        
        //Dados de Compra
        boc.dataDeCompra    = parametrosNS.invdata.inverterData(boc.dataDeCompra, 1);
        txt_dataDeCompra .setText(boc.dataDeCompra);
        txt_horaDeCompra .setText(boc.horaDeCompra);
        txt_valorDeCompra.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(boc.valorDeCompra), 0));
        
        //Dados de Pagamento
        bforp.codigoPagamento = boc.codigoPagamento;
        txt_codigoPagamento.setText(String.valueOf(bforp.codigoPagamento));
        PegaFormaDePagamento();
        boc.dataDePagamento = parametrosNS.invdata.inverterData(boc.dataDePagamento, 1);
        txt_dataDePagamento .setText(boc.dataDePagamento);
        txt_horaDePagamento .setText(boc.horaDePagamento);
        
        //Dados de Recebimento
        boc.dataDeRecebimento = parametrosNS.invdata.inverterData(boc.dataDeRecebimento, 1);
        txt_dataDeRecebimento.setText(boc.dataDeRecebimento);
        txt_horaDeRecebimento.setText(boc.horaDeRecebimento);
        
        //Dados de Localização
        txt_cepDeRecebimento.setText(boc.cepDeRecebimento);
        PegaCEP();
        if(!boc.cepDeRecebimento.equals(""))
            txt_cepDeRecebimento     .setText        (boc.cepDeRecebimento);
        if(!boc.cidadeDeRecebimento.equals(""))
            txt_cidadeDeRecebimento  .setText        (boc.cidadeDeRecebimento);
        if(!boc.bairroDeRecebimento.equals(""))
            txt_bairroDeRecebimento  .setText        (boc.bairroDeRecebimento);
        if(!boc.enderecoDeRecebimento.equals(""))
            txt_enderecoDeRecebimento.setText        (boc.enderecoDeRecebimento);
        if(!boc.ufDeRecebimento.equals(""))
            combo_uf                 .setSelectedItem(boc.ufDeRecebimento);
        
        txt_numeroDeRecebimento  .setText        (boc.numeroDeRecebimento);
        txt_codigoPais           .setText        (String.valueOf(boc.codigoPais));
        PegaPais();
        
        //Responsável
        txt_responsavelPeloRecebimento.setText(boc.responsavelPeloRecebimento);
        
        boci.idEmpresa          = boc.idEmpresa;
        boci.codigoGrupo        = boc.codigoGrupo;
        boci.codigoEmpresa      = boc.codigoEmpresa;
        boci.codigoOrdemCompra  = boc.codigoOrdemCompra;
        PegaOrdemCompraItem();
        
        txt_observacoes.setText(boc.observacoes);
        txt_observacoes.grabFocus();
    }
    
    private void PegaOrdemCompraItem(){
        sql = "select \n"
            + "   idOrdemCompraItem, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoOrdemCompra, \n"
            + "   codigoOrdemCompraItem, \n"
            + "   codigoUsuario, \n"
            + "   codigoProduto, \n"
            + "   valorUnitario, \n"
            + "   quantidade, \n"
            + "   valorSubtotal, \n"
            + "   tipoDesconto, \n"
            + "   valorDesconto, \n"
            + "   valorTotal \n"
            + "from tb_oc_itens where idEmpresa = " + boci.idEmpresa + " and codigoOrdemCompra = " + boci.codigoOrdemCompra + ";";
        dadosOrdemCompraItens.clear();
        dadosOrdemCompraItens = parametrosNS.dao.Consulta(sql);
        if(dadosOrdemCompraItens.isEmpty()){
            mensagem = "Não foram encontrados itens para a ordem de compra n°" + boc.codigoOrdemCompra + "!";
            mostraMensagem();
            return;
        }
        HabilitaBotoes();
        PegaDadosOrdemCompraItem();
    }
    
    private void PegaDadosOrdemCompraItem(){
        String desconto = "";
        Table.setNumRows(0);
        
        tabela_detalhesOrdemCompra.getColumnModel().getColumn(0).setCellRenderer(parametrosNS.tableEsquerda);
        tabela_detalhesOrdemCompra.getColumnModel().getColumn(1).setCellRenderer(parametrosNS.tableEsquerda);
        tabela_detalhesOrdemCompra.getColumnModel().getColumn(2).setCellRenderer(parametrosNS.tableDireita);
        tabela_detalhesOrdemCompra.getColumnModel().getColumn(3).setCellRenderer(parametrosNS.tableCentralizado);
        tabela_detalhesOrdemCompra.getColumnModel().getColumn(4).setCellRenderer(parametrosNS.tableDireita);
        tabela_detalhesOrdemCompra.getColumnModel().getColumn(5).setCellRenderer(parametrosNS.tableDireita);
        tabela_detalhesOrdemCompra.getColumnModel().getColumn(6).setCellRenderer(parametrosNS.tableDireita);
        tabela_detalhesOrdemCompra.getColumnModel().getColumn(7).setCellRenderer(parametrosNS.tableEsquerda);
        
        for(int i = 0; i < dadosOrdemCompraItens.size(); i++){
            desconto = "";
            boci = new BeanOrdemCompraItens();
            if(dadosOrdemCompraItens.get(i).get(0)  != null){boci.idOrdemCompraItem      = Integer.parseInt(  String.valueOf(dadosOrdemCompraItens.get(i).get(0)));}
            if(dadosOrdemCompraItens.get(i).get(1)  != null){boci.idEmpresa              = Integer.parseInt(  String.valueOf(dadosOrdemCompraItens.get(i).get(1)));}
            if(dadosOrdemCompraItens.get(i).get(2)  != null){boci.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosOrdemCompraItens.get(i).get(2)));}
            if(dadosOrdemCompraItens.get(i).get(3)  != null){boci.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosOrdemCompraItens.get(i).get(3)));}
            if(dadosOrdemCompraItens.get(i).get(4)  != null){boci.codigoOrdemCompra      = Integer.parseInt(  String.valueOf(dadosOrdemCompraItens.get(i).get(4)));}
            if(dadosOrdemCompraItens.get(i).get(5)  != null){boci.codigoOrdemCompraItem  = Integer.parseInt(  String.valueOf(dadosOrdemCompraItens.get(i).get(5)));}
            if(dadosOrdemCompraItens.get(i).get(6)  != null){boci.codigoUsuario          = Integer.parseInt(  String.valueOf(dadosOrdemCompraItens.get(i).get(6)));}
            if(dadosOrdemCompraItens.get(i).get(7)  != null){boci.codigoProduto          = Integer.parseInt(  String.valueOf(dadosOrdemCompraItens.get(i).get(7)));}
            if(dadosOrdemCompraItens.get(i).get(8)  != null){boci.valorUnitario          = Double.parseDouble(String.valueOf(dadosOrdemCompraItens.get(i).get(8)));}
            if(dadosOrdemCompraItens.get(i).get(9)  != null){boci.quantidade             = Double.parseDouble(String.valueOf(dadosOrdemCompraItens.get(i).get(9)));}
            if(dadosOrdemCompraItens.get(i).get(10) != null){boci.valorSubtotal          = Double.parseDouble(String.valueOf(dadosOrdemCompraItens.get(i).get(10)));}
            if(dadosOrdemCompraItens.get(i).get(11) != null){boci.tipoDesconto           = Integer.parseInt(  String.valueOf(dadosOrdemCompraItens.get(i).get(11)));}
            if(dadosOrdemCompraItens.get(i).get(12) != null){boci.valorDesconto          = Double.parseDouble(String.valueOf(dadosOrdemCompraItens.get(i).get(12)));}
            if(dadosOrdemCompraItens.get(i).get(13) != null){boci.valorTotal             = Double.parseDouble(String.valueOf(dadosOrdemCompraItens.get(i).get(13)));}
            
            bp.codigoProduto    = boci.codigoProduto;
            PegaProdutos();
            
            bu.codigoUsuario    = boci.codigoUsuario;
            PegaUsuario();
            
            if(boci.tipoDesconto == 0){
                desconto = String.valueOf(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(boci.valorDesconto), 0));
            }else{
                boci.valorDesconto = boci.valorDesconto * 100;
                desconto = parametrosNS.FcPor.FormataPorcentagem(boci.valorDesconto);
            }
            
            Table.addRow(new Object[] {parametrosNS.fc.FormataCampo(String.valueOf(boci.codigoOrdemCompraItem), 2, 0), parametrosNS.fc.FormataCampo(String.valueOf(boci.codigoProduto), 6, 0) + "-" + bp.descricaoProduto, parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(boci.valorUnitario), 0), boci.quantidade, parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(boci.valorSubtotal), 0), desconto, parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(boci.valorTotal), 0), parametrosNS.fc.FormataCampo(String.valueOf(bu.codigoUsuario), 3, 0) + "-" + bu.usuario});
        }
        if(tabela_detalhesOrdemCompra.getRowCount() > 0){
            new AjustarLarguraColunas(tabela_detalhesOrdemCompra);
        }
    }
    
    private void PegaEmpresa(){
        be.codigoEmpresa = Integer.parseInt(txt_codigoEmpresa.getText().replace(" ", ""));
        if(be.codigoEmpresa == 0)
            return;
        sql = "select idEmpresa, codigoGrupo, codigoEmpresa, nomeEmpresa, cnpjEmpresa from ns_empresas where codigoGrupo = " + parametrosNS.be.CodigoGrupo + " and codigoEmpresa = " + be.codigoEmpresa + ";";
        dadosEmpresas.clear();
        dadosEmpresas = parametrosNS.dao.Consulta(sql);
        if(dadosEmpresas.isEmpty()){
            mensagem = "Empresa n°" + be.codigoEmpresa + " não encontrada!";
            mostraMensagem();
            return;
        }
        PegaDadosEmpresa();
    }
    
    private void PegaDadosEmpresa(){
        for(int i = 0; i < dadosEmpresas.size(); i++){
            if(dadosEmpresas.get(i).get(0) != null)
                be.idEmpresa        = Integer.parseInt(String.valueOf(dadosEmpresas.get(i).get(0)));
            if(dadosEmpresas.get(i).get(1) != null)
                be.codigoGrupo      = Integer.parseInt(String.valueOf(dadosEmpresas.get(i).get(1)));
            if(dadosEmpresas.get(i).get(2) != null)
                be.codigoEmpresa    = Integer.parseInt(String.valueOf(dadosEmpresas.get(i).get(2)));
            if(dadosEmpresas.get(i).get(3) != null)
                be.nomeEmpresa      =                  String.valueOf(dadosEmpresas.get(i).get(3));
            if(dadosEmpresas.get(i).get(4) != null)
                be.cnpjEmpresa      =                  String.valueOf(dadosEmpresas.get(i).get(4));
        }
        txt_codigoEmpresa.setText(parametrosNS.fc.FormataCampo(String.valueOf(be.codigoEmpresa), 3, 0));
        label_nomeEmpresa.setText(be.nomeEmpresa);
        be.cnpjEmpresa = parametrosNS.FCampoCpfCnpj.FormataCampoCpfCnpj(be.cnpjEmpresa);
        be.cnpjEmpresa1 = be.cnpjEmpresa.substring(0 , 9);
        be.cnpjEmpresa2 = be.cnpjEmpresa.substring(9 ,13);
        be.cnpjEmpresa3 = be.cnpjEmpresa.substring(13,15);
        txt_cnpjEmp1.setText(be.cnpjEmpresa1);
        txt_cnpjEmp2.setText(be.cnpjEmpresa2);
        txt_cnpjEmp3.setText(be.cnpjEmpresa3);
    }
    
    private void PegaFornecedor(){
        sql = "select idFornecedor, idEmpresa, codigoGrupo, codigoEmpresa, codigoFornecedor, nome, cnpj from tb_fornecedor where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoFornecedor = " + bfor.codigoFornecedor + ";";
        dadosFornecedor.clear();
        dadosFornecedor = parametrosNS.dao.Consulta(sql);
        if(dadosFornecedor.isEmpty()){
            mensagem = "Fornecedor n°" + bfor.codigoFornecedor + " não encontrado!";
            mostraMensagem();
            return;
        }
        PegaDadosFornecedor();
    }
    
    private void PegaDadosFornecedor(){
        for(int i = 0; i < dadosFornecedor.size(); i++){
            if(dadosFornecedor.get(i).get(0) != null)
                bfor.idFornecedor     = Integer.parseInt(String.valueOf(dadosFornecedor.get(i).get(0)));
            if(dadosFornecedor.get(i).get(1) != null)
                bfor.idEmpresa        = Integer.parseInt(String.valueOf(dadosFornecedor.get(i).get(1)));
            if(dadosFornecedor.get(i).get(2) != null)
                bfor.codigoGrupo      = Integer.parseInt(String.valueOf(dadosFornecedor.get(i).get(2)));
            if(dadosFornecedor.get(i).get(3) != null)
                bfor.codigoEmpresa    = Integer.parseInt(String.valueOf(dadosFornecedor.get(i).get(3)));
            if(dadosFornecedor.get(i).get(4) != null)
                bfor.codigoFornecedor = Integer.parseInt(String.valueOf(dadosFornecedor.get(i).get(4)));
            if(dadosFornecedor.get(i).get(5) != null)
                bfor.nome             =                  String.valueOf(dadosFornecedor.get(i).get(5));
            if(dadosFornecedor.get(i).get(6) != null)
                bfor.cnpj             =                  String.valueOf(dadosFornecedor.get(i).get(6));
        }
        txt_codigoFornecedor.setText(parametrosNS.fc.FormataCampo(String.valueOf(bfor.codigoFornecedor), 5, 0));
        label_nomeFornecedor.setText(bfor.nome);
        bfor.cnpj = parametrosNS.FCampoCpfCnpj.FormataCampoCpfCnpj(bfor.cnpj);
        txt_cnpjFor1.setText(bfor.cnpj.substring(0 , 9));
        txt_cnpjFor2.setText(bfor.cnpj.substring(9 ,13));
        txt_cnpjFor3.setText(bfor.cnpj.substring(13,15));
    }
    
    private void PegaUsuario(){
        bu.usuario  = "----------";
        sql = "select usuario from tb_usuarios where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
        dadosUsuarios.clear();
        dadosUsuarios = parametrosNS.dao.Consulta(sql);
        if(dadosUsuarios.isEmpty()){
            mensagem = "Usuário n°" + bu.codigoUsuario + " não encontrado!";
            mostraMensagem();
            return;
        }
        PegaDadosUsuarios();
    }
    
    private void PegaDadosUsuarios(){
        for(int i = 0; i < dadosUsuarios.size(); i++){
            if(dadosUsuarios.get(i).get(0) != null){
                bu.usuario  = String.valueOf(dadosUsuarios.get(i).get(0));
            }
        }
    }
    
    private void PegaFormaDePagamento(){
        bforp.codigoPagamento = Integer.parseInt(txt_codigoPagamento.getText().replace(" ", ""));
        if(bforp.codigoPagamento == 0){
            return;
        }
        sql = "select idPagamento, idEmpresa, codigoGrupo, codigoEmpresa, codigoPagamento, descricaoPagamento from tb_formaspagamentos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoPagamento = " + bforp.codigoPagamento + ";";
        dadosFormasPagamentos.clear();
        dadosFormasPagamentos = parametrosNS.dao.Consulta(sql);
        if(dadosFormasPagamentos.isEmpty()){
            mensagem = "Forma de pagamento n°" + bforp.codigoPagamento + " não enontrada!";
            mostraMensagem();
            return;
        }
        PegaDadosFormaDePagamento();
    }
    
    private void PegaDadosFormaDePagamento(){
        for(int i = 0; i < dadosFormasPagamentos.size(); i++){
            if(dadosFormasPagamentos.get(i).get(0) != null)
                bforp.idPagamento        = Integer.parseInt(String.valueOf(dadosFormasPagamentos.get(i).get(0)));
            if(dadosFormasPagamentos.get(i).get(1) != null)
                bforp.idEmpresa          = Integer.parseInt(String.valueOf(dadosFormasPagamentos.get(i).get(1)));
            if(dadosFormasPagamentos.get(i).get(2) != null)
                bforp.codigoGrupo        = Integer.parseInt(String.valueOf(dadosFormasPagamentos.get(i).get(2)));
            if(dadosFormasPagamentos.get(i).get(3) != null)
                bforp.codigoEmpresa      = Integer.parseInt(String.valueOf(dadosFormasPagamentos.get(i).get(3)));
            if(dadosFormasPagamentos.get(i).get(4) != null)
                bforp.codigoPagamento    = Integer.parseInt(String.valueOf(dadosFormasPagamentos.get(i).get(4)));
            if(dadosFormasPagamentos.get(i).get(5) != null)
                bforp.descricaoPagamento =                  String.valueOf(dadosFormasPagamentos.get(i).get(5));
        }
        txt_codigoPagamento     .setText(parametrosNS.fc.FormataCampo(String.valueOf(bforp.codigoPagamento), 2, 0));
        label_descricaoPagamento.setText(bforp.descricaoPagamento);
    }
    
    private void PegaCEP(){
        boc.cepDeRecebimento = txt_cepDeRecebimento.getText();
        boc.cepDeRecebimento = boc.cepDeRecebimento.replace(" ", "");
        boc.cepDeRecebimento = boc.cepDeRecebimento.replace("-", "");
        if(boc.cepDeRecebimento.equals("")){
            return;
        }
        sql = "select * from ns_cep where cep = " + boc.cepDeRecebimento + ";";
        dadosCEP.clear();
        dadosCEP = parametrosNS.dao.Consulta(sql);
        if(dadosCEP.isEmpty()){
            mensagem = "CEP " + boc.cepDeRecebimento + " não encontrado!";
            mostraMensagem();
            return;
        }
        PegaDadosCEP();
    }
    
    private void PegaDadosCEP(){
        for(int i = 0; i < dadosCEP.size(); i++){
            bcep.cep        = String.valueOf(dadosCEP.get(i).get(0));
            bcep.endereco   = String.valueOf(dadosCEP.get(i).get(1));
            bcep.cidade     = String.valueOf(dadosCEP.get(i).get(2));
            bcep.bairro     = String.valueOf(dadosCEP.get(i).get(3));
            bcep.uf         = String.valueOf(dadosCEP.get(i).get(4));
        }
        txt_cepDeRecebimento     .setText        (bcep.cep);
        txt_cidadeDeRecebimento  .setText        (bcep.cidade);
        txt_enderecoDeRecebimento.setText        (bcep.endereco);
        txt_bairroDeRecebimento  .setText        (bcep.bairro);
        combo_uf                 .setSelectedItem(bcep.uf);
        txt_numeroDeRecebimento.grabFocus();
    }
    
    private void PegaPais(){
        bpais.codigoPais    = Integer.parseInt(txt_codigoPais.getText().replace(" ", ""));
        if(bpais.codigoPais == 0){
            return;
        }
        sql = "select * from ns_paises where codigoPais = " + bpais.codigoPais + ";";
        dadosPaises.clear();
        dadosPaises = parametrosNS.dao.Consulta(sql);
        if(dadosPaises.isEmpty()){
            mensagem = "Código do Pais n°" + bpais.codigoPais + " não encontrado!";
            mostraMensagem();
            return;
        }
        PegaDadosPais();
    }
    
    private void PegaDadosPais(){
        for(int i = 0; i < dadosPaises.size(); i++){
            bpais.codigoPais    = Integer.parseInt(String.valueOf(dadosPaises.get(i).get(0)));
            bpais.nomePais      = String.valueOf(dadosPaises.get(i).get(1));
        }
        txt_codigoPais.setText(parametrosNS.fc.FormataCampo(String.valueOf(bpais.codigoPais), 4, 0));
        label_nomePais.setText(bpais.nomePais);
    }
    
    private void PegaProdutos(){
        bp.descricaoProduto = "----------";
        if(bp.codigoProduto == 0)
            return;
        sql = "select \n"
            + "   idProdutos, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoProduto, \n"
            + "   descricaoProduto, \n"
            + "   produtoInativo, \n"
            + "   valorDeVenda, \n"
            + "   quantidadeAtual \n"
            + "from \n"
            + "   tb_produtos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoProduto = " + bp.codigoProduto + ";";
        dadosProdutos.clear();
        dadosProdutos = parametrosNS.dao.Consulta(sql);
        if(dadosProdutos.isEmpty()){
            mensagem = "Produto n°" + bp.codigoProduto + " não encontrado!";
            mostraMensagem();
            return;
        }
        PegaDadosProdutos();
    }
    
    private void PegaDadosProdutos(){
        for (int i = 0; i < dadosProdutos.size(); i++) {
            bp  = new BeanProdutos();
            if(dadosProdutos.get(i).get(0) != null)
                bp.idProdutos               = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(0)));
            if(dadosProdutos.get(i).get(1) != null)
                bp.idEmpresa                = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(1)));
            if(dadosProdutos.get(i).get(2) != null)
                bp.codigoGrupo              = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(2)));
            if(dadosProdutos.get(i).get(3) != null)
                bp.codigoEmpresa            = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(3)));
            if(dadosProdutos.get(i).get(4) != null)
                bp.codigoProduto            = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(4)));
            if(dadosProdutos.get(i).get(5) != null)
                bp.descricaoProduto         =                    String.valueOf(dadosProdutos.get(i).get(5));
            if(dadosProdutos.get(i).get(6) != null)
                bp.produtoInativo           = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(6)));
            if(dadosProdutos.get(i).get(7) != null)
                bp.valorDeVenda             = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(7)));
            if(dadosProdutos.get(i).get(8) != null)
                bp.quantidadeAtual          = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(8)));
        }
        if(bp.produtoInativo == 1){
            mensagem = "Produto não está mais a venda!";
            mostraMensagem();
            return;
        }
    }
    
    private void AtualizaEstoque(){
        bp.codigoProduto = boci.codigoProduto;
        PegaProdutos();
        
        bp.quantidadeAtual = bp.quantidadeAtual + boci.quantidade;
        
        sql = "update tb_produtos set quantidadeAtual = " + bp.quantidadeAtual + " where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoProduto = " + bp.codigoProduto + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(sqlstate.equals("00000"))
            return;
        mensagem = "Erro ao atualizar estoque do produto " + bp.codigoProduto + "!";
        mostraMensagem();
    }
    
    private void PegaValores(){
        fatal = "N";
        boc.idEmpresa           = parametrosNS.be.IdEmpresa;
        boc.codigoGrupo         = parametrosNS.bge.CodigoGrupo;
        boc.codigoEmpresa       = parametrosNS.be.CodigoEmpresa;
        boc.codigoOrdemCompra   = Integer.parseInt(txt_codigoOrdemCompra.getText());
        boc.codigoComprador     = Integer.parseInt(parametrosNS.fc.FormataCampo(txt_codigoEmpresa.getText(), 3, 0));
        if(boc.codigoComprador == 0){
            mensagem = "Empresa compradora inválida!";
            mostraMensagem();
            fatal = "S";
            return;
        }
        boc.codigoFornecedor    = Integer.parseInt(parametrosNS.fc.FormataCampo(txt_codigoFornecedor.getText(), 5, 0));
        if(boc.codigoFornecedor == 0){
            mensagem = "Fornecedor inválido!";
            mostraMensagem();
            fatal = "S";
            return;
        }
        boc.codigoUsuario       = parametrosNS.bu.codigoUsuario;
        boc.dataCadastro        = parametrosNS.invdata.inverterData(txt_dataCadastro.getText(), 2);
        
        boc.dataDeCompra        = txt_dataDeCompra.getText();
        boc.dataDeCompra        = boc.dataDeCompra.replace(" ", "");
        boc.dataDeCompra        = boc.dataDeCompra.replace("/", "");
        if(!boc.dataDeCompra.equals("")){
            boc.dataDeCompra = "'" + parametrosNS.invdata.inverterData(boc.dataDeCompra, 2) + "'";
        }else{
            boc.dataDeCompra = null;
        }
        boc.horaDeCompra        = txt_horaDeCompra.getText();
        boc.horaDeCompra        = boc.horaDeCompra.replace(" ", "");
        boc.horaDeCompra        = boc.horaDeCompra.replace(":", "");
        if(!boc.horaDeCompra.equals("")){
            boc.horaDeCompra    = "'" + txt_horaDeCompra.getText() + "'";
        }else{
            boc.horaDeCompra    = null;
        }
        if(!txt_valorDeCompra.getText().equals("")){
            boc.valorDeCompra   = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorDeCompra.getText(), 1));
        }
        boc.codigoPagamento     = Integer.parseInt(parametrosNS.fc.FormataCampo(txt_codigoPagamento.getText(), 2, 0));
        if(boc.codigoPagamento == 0){
            mensagem = "Forma de pagamento inválida!";
            mostraMensagem();
            fatal = "S";
            return;
        }
        
        boc.dataDePagamento     = txt_dataDePagamento.getText();
        boc.dataDePagamento     = boc.dataDePagamento.replace(" ", "");
        boc.dataDePagamento     = boc.dataDePagamento.replace("/", "");
        if(!boc.dataDePagamento.equals("")){
            boc.dataDePagamento = "'" + parametrosNS.invdata.inverterData(boc.dataDePagamento, 2) + "'";
        }else{
            boc.dataDePagamento = null;
        }
        boc.horaDePagamento     = txt_horaDePagamento.getText();
        boc.horaDePagamento     = boc.horaDePagamento.replace(" ", "");
        boc.horaDePagamento     = boc.horaDePagamento.replace(":", "");
        if(!boc.horaDePagamento.equals("")){
            boc.horaDePagamento = "'" + txt_horaDePagamento.getText() + "'";
        }else{
            boc.horaDePagamento = null;
        }
        
        boc.dataDeRecebimento   = txt_dataDeRecebimento.getText();
        boc.dataDeRecebimento   = boc.dataDeRecebimento.replace(" ", "");
        boc.dataDeRecebimento   = boc.dataDeRecebimento.replace("/", "");
        if(!boc.dataDeRecebimento.equals("")){
            boc.dataDeRecebimento   = "'" + parametrosNS.invdata.inverterData(boc.dataDeRecebimento, 2) + "'";
        }else{
            boc.dataDeRecebimento   = null;
        }
        boc.horaDeRecebimento   = txt_horaDeRecebimento.getText();
        boc.horaDeRecebimento   = boc.horaDeRecebimento.replace(" ", "");
        boc.horaDeRecebimento   = boc.horaDeRecebimento.replace(":", "");
        if(!boc.horaDeRecebimento.equals("")){
            boc.horaDeRecebimento   = "'" + txt_horaDeRecebimento.getText() + "'";
        }else{
            boc.horaDeRecebimento   = null;
        }
        
        boc.cepDeRecebimento    = txt_cepDeRecebimento.getText();
        boc.cepDeRecebimento    = boc.cepDeRecebimento.replace(" ", "");
        boc.cepDeRecebimento    = boc.cepDeRecebimento.replace("-", "");
        if(!boc.cepDeRecebimento.equals("")){
            boc.cepDeRecebimento    = "'" + txt_cepDeRecebimento.getText() + "'";
        }else{
            boc.cepDeRecebimento    = null;
        }
        
        boc.cidadeDeRecebimento = "'" + txt_cidadeDeRecebimento.getText() + "'";
        if(boc.cidadeDeRecebimento.replace("'", "").equals("")){
            boc.cidadeDeRecebimento = null;
        }
        
        boc.enderecoDeRecebimento   = "'" + txt_enderecoDeRecebimento.getText() + "'";
        if(boc.enderecoDeRecebimento.replace("'", "").equals("")){
            boc.enderecoDeRecebimento = null;
        }
        
        boc.numeroDeRecebimento = "'" + txt_numeroDeRecebimento.getText() + "'";
        if(boc.numeroDeRecebimento.replace("'", "").equals("")){
            boc.cidadeDeRecebimento = null;
        }
        boc.bairroDeRecebimento = "'" + txt_bairroDeRecebimento.getText() + "'";
        if(boc.bairroDeRecebimento.replace("'", "").equals("")){
            boc.bairroDeRecebimento = null;
        }
        
        boc.ufDeRecebimento = "'" + String.valueOf(combo_uf.getSelectedItem()).replace("-", "") + "'";
        if(boc.ufDeRecebimento.replace("'", "").equals("")){
            boc.ufDeRecebimento = null;
        }
        
        boc.codigoPais  = Integer.parseInt(parametrosNS.fc.FormataCampo(txt_codigoPais.getText(), 4, 0));
        if(boc.codigoPais == 0){
            mensagem = "Pais inválido!";
            mostraMensagem();
            fatal = "S";
            return;
        }
        
        boc.responsavelPeloRecebimento  = "'" + txt_responsavelPeloRecebimento.getText() + "'";
        if(boc.responsavelPeloRecebimento.replace("'", "").equals("")){
            boc.responsavelPeloRecebimento = null;
        }
        boc.observacoes = txt_observacoes.getText();
        
        boc.dataAlterou          = parametrosNS.invdata.inverterData(parametrosNS.cdh.CapturarData(), 2);
        boc.horaAlterou          = parametrosNS.cdh.CapturaHora();
        boc.usuarioAlterou       = parametrosNS.bu.codigoUsuario;
        boc.idEmpresaAlterou     = parametrosNS.be.idEmpresa;
        boc.codigoGrupoAlterou   = parametrosNS.bge.codigoGrupo;
        boc.codigoEmpresaAlterou = parametrosNS.be.codigoEmpresa;
   }
    
}
