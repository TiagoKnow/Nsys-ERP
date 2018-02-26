package TelasEstoque;

import FuncoesInternas.InverterData;
import Beans.*;
import FuncoesInternas.*;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/*
 @author Tiago e Paulo
 */
public class ProdutosConsulta extends javax.swing.JFrame {
    //int
    int    linha                = 0;
    int    index                = 0;
    int    AbriuFornecedor      = 0;
    int    AbriuFabricante      = 0;
    
    //Vetores
    ArrayList            parametros                     = new ArrayList();
    ArrayList            dadosPadroes                   = new ArrayList();
    ArrayList<ArrayList> dadosGrupoSubGrupoProdutos     = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosProdutos                  = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosFabricante                = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosFornecedor                = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosUsuarios                  = new ArrayList<ArrayList>();
    
    //Strings
    String sql                  = "";
    String sql1                 = "";
    String tipo                 = "";
    String sqlstate             = "";
    String mensagem             = "";
    String retorno              = "";
    String somostra             = "";
    String texto                = "";
    String Campo                = "";
    String textoBusca           = "";
    String preenchimento        = "";
    
    //Beans
    BeanFabricante                  bfab    = new BeanFabricante();
    BeanFornecedor                  bfor    = new BeanFornecedor();
    BeanGrupoProduto                bgp     = new BeanGrupoProduto();
    BeanIntervalos                  binter  = new BeanIntervalos();
    BeanProdutos                    bp      = new BeanProdutos();
    BeanSubGrupoProduto             bsgp    = new BeanSubGrupoProduto();
    BeanUsuarios                    bu      = new BeanUsuarios();
    
    //Especiais
    DefaultTableModel               Table;
    InverterData                    invdata             = new InverterData();
    TestarData                      Test                = new TestarData();
    CapturarDataHora                cdh                 = new CapturarDataHora();
    FormataCampo                    fc                  = new FormataCampo();
    TransformaValorStringeDouble    TransStrDou = new TransformaValorStringeDouble();
    
    //Especiais para Excportação em Excel
    JFileChooser                    SeletorExcel;
    String                          NomeArquivoExcel    = "";
    String                          LocalArquivo        = "";
    int                             SalvarExcel         = 0;
    
    //Telas
    ProdutosCadastro                ProCad;
    FornecedorConsulta              ForCon;
    FabricanteConsulta              FabCon;
    
    public ProdutosConsulta(ArrayList DadosPadroes){
        dadosPadroes                = DadosPadroes;
        
        somostra                    = (String)  dadosPadroes.get(0);
        tipo                        = (String)  dadosPadroes.get(1);
        
        initComponents();
    }
    
    private void InicializaCampos(){
        txt_codigoProdutoInicial    .setText(fc.FormataCampo("", 6, 0));
        txt_codigoProdutoFinal      .setText("999999");
        txt_fornecedorInicial       .setText(fc.FormataCampo("", 5, 0));
        txt_fornecedorFinal         .setText("99999");
        txt_dataCadastroInicial     .setText(fc.FormataCampo("", 10, 2));
        txt_dataCadastroFinal       .setText("99999999");
        txt_fabricanteInicial       .setText(fc.FormataCampo("", 5, 0));
        txt_fabricanteFinal         .setText("99999");
        txt_dataVencimentoInicial   .setText(fc.FormataCampo("", 10, 2));
        txt_dataVencimentoFinal     .setText("99999999");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_detalhesItem = new javax.swing.JMenuItem();
        bt_sair = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_produtos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_codigoProdutoInicial = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_codigoProdutoFinal = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_fornecedorInicial = new javax.swing.JFormattedTextField();
        txt_fornecedorFinal = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_dataCadastroInicial = new javax.swing.JFormattedTextField();
        txt_dataCadastroFinal = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_dataVencimentoInicial = new javax.swing.JFormattedTextField();
        txt_dataVencimentoFinal = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_fabricanteInicial = new javax.swing.JFormattedTextField();
        txt_fabricanteFinal = new javax.swing.JFormattedTextField();
        bt_pesquisaFornecedorInicial = new javax.swing.JButton();
        bt_pesquisaFornecedorFinal = new javax.swing.JButton();
        bt_pesquisaFabricanteInicial = new javax.swing.JButton();
        bt_pesquisaFabricanteFinal = new javax.swing.JButton();
        txt_descricao = new javax.swing.JTextField();
        bt_processa = new javax.swing.JButton();
        bt_exportar = new javax.swing.JButton();
        jMenu = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        bt_cadastrarProdutos = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        bt_sair1 = new javax.swing.JMenuItem();

        bt_detalhesItem.setText("Detalhes");
        bt_detalhesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_detalhesItemActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_detalhesItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_produtos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Status", "Cadastro", "Vencimento", "Descrição", "Fabricante", "Fornecedor", "Valor", "Quantidade em Estoque", "Código de Barras", "Grupo", "Sub Grupo", "Observações"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_produtos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_produtos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_produtos.getTableHeader().setResizingAllowed(false);
        tabela_produtos.getTableHeader().setReorderingAllowed(false);
        tabela_produtos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_produtosMouseClicked(evt);
            }
        });
        tabela_produtos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabela_produtosKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabela_produtos);
        if (tabela_produtos.getColumnModel().getColumnCount() > 0) {
            tabela_produtos.getColumnModel().getColumn(0).setResizable(false);
            tabela_produtos.getColumnModel().getColumn(1).setResizable(false);
            tabela_produtos.getColumnModel().getColumn(2).setResizable(false);
            tabela_produtos.getColumnModel().getColumn(3).setResizable(false);
            tabela_produtos.getColumnModel().getColumn(4).setResizable(false);
            tabela_produtos.getColumnModel().getColumn(5).setResizable(false);
            tabela_produtos.getColumnModel().getColumn(6).setResizable(false);
            tabela_produtos.getColumnModel().getColumn(7).setResizable(false);
            tabela_produtos.getColumnModel().getColumn(8).setResizable(false);
            tabela_produtos.getColumnModel().getColumn(9).setResizable(false);
            tabela_produtos.getColumnModel().getColumn(10).setResizable(false);
            tabela_produtos.getColumnModel().getColumn(11).setResizable(false);
            tabela_produtos.getColumnModel().getColumn(12).setResizable(false);
        }

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Produtos");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Intervalores de Seleção     F11 [Geral]");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Código:");

        try {
            txt_codigoProdutoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoProdutoInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoProdutoInicial.setText("000000");
        txt_codigoProdutoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoProdutoInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoProdutoInicialFocusLost(evt);
            }
        });
        txt_codigoProdutoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoProdutoInicialKeyPressed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Inicial");

        try {
            txt_codigoProdutoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoProdutoFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoProdutoFinal.setText("999999");
        txt_codigoProdutoFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoProdutoFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoProdutoFinalFocusLost(evt);
            }
        });
        txt_codigoProdutoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoProdutoFinalKeyPressed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Final");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Fornecedor:");

        try {
            txt_fornecedorInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fornecedorInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fornecedorInicial.setText("00000");
        txt_fornecedorInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_fornecedorInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_fornecedorInicialFocusLost(evt);
            }
        });
        txt_fornecedorInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_fornecedorInicialKeyPressed(evt);
            }
        });

        try {
            txt_fornecedorFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fornecedorFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fornecedorFinal.setText("99999");
        txt_fornecedorFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_fornecedorFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_fornecedorFinalFocusLost(evt);
            }
        });
        txt_fornecedorFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_fornecedorFinalKeyPressed(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Inicial");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Final");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Data de Cadastro:");

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
        });
        txt_dataCadastroFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataCadastroFinalKeyPressed(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Data de Vencimento:");

        try {
            txt_dataVencimentoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataVencimentoInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataVencimentoInicial.setText("00/00/0000");
        txt_dataVencimentoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataVencimentoInicialFocusGained(evt);
            }
        });
        txt_dataVencimentoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataVencimentoInicialKeyPressed(evt);
            }
        });

        try {
            txt_dataVencimentoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataVencimentoFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataVencimentoFinal.setText("99/99/9999");
        txt_dataVencimentoFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataVencimentoFinalFocusGained(evt);
            }
        });
        txt_dataVencimentoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataVencimentoFinalKeyPressed(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Fabricante:");

        try {
            txt_fabricanteInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fabricanteInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fabricanteInicial.setText("00000");
        txt_fabricanteInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_fabricanteInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_fabricanteInicialFocusLost(evt);
            }
        });
        txt_fabricanteInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_fabricanteInicialKeyPressed(evt);
            }
        });

        try {
            txt_fabricanteFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fabricanteFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fabricanteFinal.setText("99999");
        txt_fabricanteFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_fabricanteFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_fabricanteFinalFocusLost(evt);
            }
        });
        txt_fabricanteFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_fabricanteFinalKeyPressed(evt);
            }
        });

        bt_pesquisaFornecedorInicial.setText("...");
        bt_pesquisaFornecedorInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaFornecedorInicialActionPerformed(evt);
            }
        });

        bt_pesquisaFornecedorFinal.setText("...");
        bt_pesquisaFornecedorFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaFornecedorFinalActionPerformed(evt);
            }
        });

        bt_pesquisaFabricanteInicial.setText("...");
        bt_pesquisaFabricanteInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaFabricanteInicialActionPerformed(evt);
            }
        });

        bt_pesquisaFabricanteFinal.setText("...");
        bt_pesquisaFabricanteFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaFabricanteFinalActionPerformed(evt);
            }
        });

        txt_descricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_descricaoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_dataCadastroInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(txt_codigoProdutoInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dataVencimentoInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_dataCadastroFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_codigoProdutoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_fabricanteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_fornecedorInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_pesquisaFornecedorInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_pesquisaFabricanteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_fabricanteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_fornecedorFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_pesquisaFornecedorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_pesquisaFabricanteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_dataVencimentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(344, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel5, jLabel6, txt_codigoProdutoFinal, txt_codigoProdutoInicial, txt_dataCadastroFinal, txt_dataCadastroInicial, txt_dataVencimentoFinal, txt_dataVencimentoInicial});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel8, jLabel9, txt_fabricanteFinal, txt_fabricanteInicial, txt_fornecedorFinal, txt_fornecedorInicial});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel12, jLabel7});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel4});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_codigoProdutoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_codigoProdutoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)
                                .addComponent(txt_fornecedorInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bt_pesquisaFornecedorInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_fornecedorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bt_pesquisaFornecedorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_dataCadastroInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_dataCadastroFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txt_fabricanteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_pesquisaFabricanteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_fabricanteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_pesquisaFabricanteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_dataVencimentoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dataVencimentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel12, jLabel4, jLabel5, jLabel6, jLabel7, txt_codigoProdutoFinal, txt_codigoProdutoInicial, txt_dataCadastroFinal, txt_dataCadastroInicial, txt_dataVencimentoFinal, txt_dataVencimentoInicial});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel8, jLabel9, txt_fabricanteFinal, txt_fabricanteInicial, txt_fornecedorFinal, txt_fornecedorInicial});

        bt_processa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/1280454766_system-software-update_1.png"))); // NOI18N
        bt_processa.setText("Processa");
        bt_processa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bt_processa.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        bt_processa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_processaActionPerformed(evt);
            }
        });

        bt_exportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Table.png"))); // NOI18N
        bt_exportar.setText("Exportar");
        bt_exportar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bt_exportar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        bt_exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_exportarActionPerformed(evt);
            }
        });

        jMenu2.setText("Arquivo");

        jMenu1.setText("Cadastro");

        bt_cadastrarProdutos.setText("Produtos");
        bt_cadastrarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastrarProdutosActionPerformed(evt);
            }
        });
        jMenu1.add(bt_cadastrarProdutos);

        jMenu2.add(jMenu1);
        jMenu2.add(jSeparator1);

        bt_sair1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        bt_sair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair1.setText("Sair");
        bt_sair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sair1ActionPerformed(evt);
            }
        });
        jMenu2.add(bt_sair1);

        jMenu.add(jMenu2);

        setJMenuBar(jMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bt_processa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_exportar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_sair))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_sair)
                    .addComponent(bt_processa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_exportar))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName(":: Consulta Produtos");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void tabela_produtosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_produtosMouseClicked
        RetornaProduto();
        if(evt.getButton() == MouseEvent.BUTTON3)
            if(somostra.equals("N"))
                MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
        if(evt.getClickCount() < 2){
            return;
        }
        dispose();
    }//GEN-LAST:event_tabela_produtosMouseClicked

    private void bt_detalhesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesItemActionPerformed
        if(ProCad != null)if(ProCad.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        ProCad = new ProdutosCadastro("S", Integer.parseInt(retorno));
        ProCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesItemActionPerformed

    private void bt_pesquisaFornecedorInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaFornecedorInicialActionPerformed
        Campo = "I";
        PesquisaFornecedor();
    }//GEN-LAST:event_bt_pesquisaFornecedorInicialActionPerformed
    
    private void PesquisaFornecedor(){
        if(ForCon != null)if(ForCon.isVisible()){
            AbriuFornecedor = 0;
            mensagem = "Tela já Aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        AbriuFornecedor = 1;
        ForCon = new FornecedorConsulta("N");
        ForCon.setVisible(true);
    }
    
    private void bt_pesquisaFornecedorFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaFornecedorFinalActionPerformed
        Campo = "F";
        PesquisaFornecedor();
    }//GEN-LAST:event_bt_pesquisaFornecedorFinalActionPerformed

    private void bt_pesquisaFabricanteInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaFabricanteInicialActionPerformed
        Campo = "I";
        PesquisaFabricante();
    }//GEN-LAST:event_bt_pesquisaFabricanteInicialActionPerformed
    
    private void PesquisaFabricante(){
        if(FabCon != null)if(FabCon.isVisible()){
            AbriuFabricante = 0;
            mensagem = "Tela já Aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        AbriuFabricante = 1;
        FabCon = new FabricanteConsulta("N");
        FabCon.setVisible(true);
    }
    
    private void bt_pesquisaFabricanteFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaFabricanteFinalActionPerformed
        Campo = "F";
        PesquisaFabricante();
    }//GEN-LAST:event_bt_pesquisaFabricanteFinalActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();return;}
        if(AbriuFornecedor == 0){
            AbreFabricante();
            return;
        }
        AbriuFornecedor = 0;
        retorno = ForCon.getRetorno();
        if(retorno.equals("")){
            return;
        }
        if(Campo.equals("I")){
            txt_fornecedorInicial.setText(fc.FormataCampo(retorno, 5, 0));
            return;
        }
        txt_fornecedorFinal.setText(fc.FormataCampo(retorno, 5, 0));
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbreFabricante(){
        if(AbriuFabricante == 0){
            return;
        }
        AbriuFabricante = 0;
        retorno = FabCon.getRetorno();
        if(retorno.equals("")){
            return;
        }
        if(Campo.equals("I")){
            txt_fabricanteInicial.setText(fc.FormataCampo(retorno, 5, 0));
            return;
        }
        txt_fabricanteFinal.setText(fc.FormataCampo(retorno, 5, 0));
    }
    
    private void txt_codigoProdutoInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoProdutoInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoProdutoFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoProdutoInicial.setText(fc.FormataCampo("", 6, 0));
            txt_codigoProdutoFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoProdutoInicialKeyPressed

    private void txt_codigoProdutoFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoProdutoFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_fornecedorInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoProdutoFinal.setText("999999");
            txt_fornecedorInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoProdutoFinalKeyPressed

    private void txt_fornecedorInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fornecedorInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_fornecedorFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_fornecedorInicial.setText(fc.FormataCampo("", 5, 0));
            txt_fornecedorFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_fornecedorInicialKeyPressed

    private void txt_fornecedorFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fornecedorFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataCadastroInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_fornecedorFinal.setText("99999");
            txt_dataCadastroInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_fornecedorFinalKeyPressed

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
            txt_fabricanteInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataCadastroFinal.setText("99999999");
            txt_fabricanteInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataCadastroFinalKeyPressed

    private void txt_fabricanteInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fabricanteInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_fabricanteFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_fabricanteInicial.setText(fc.FormataCampo("", 5, 0));
            txt_fabricanteFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_fabricanteInicialKeyPressed

    private void txt_fabricanteFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fabricanteFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataVencimentoInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_fabricanteFinal.setText("99999");
            txt_dataVencimentoInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_fabricanteFinalKeyPressed

    private void txt_dataVencimentoInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataVencimentoInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataVencimentoFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataVencimentoInicial.setText(fc.FormataCampo("", 10, 2));
            txt_dataVencimentoFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataVencimentoInicialKeyPressed

    private void txt_dataVencimentoFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataVencimentoFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            tabela_produtos.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataVencimentoFinal.setText("99999999");
            tabela_produtos.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataVencimentoFinalKeyPressed

    private void bt_processaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_processaActionPerformed
        PegaValores();
    }//GEN-LAST:event_bt_processaActionPerformed

    private void txt_codigoProdutoInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoProdutoInicialFocusGained
        txt_codigoProdutoInicial.setSelectionStart(0);
        txt_codigoProdutoInicial.setSelectionEnd  (txt_codigoProdutoFinal.getText().length());
    }//GEN-LAST:event_txt_codigoProdutoInicialFocusGained

    private void txt_codigoProdutoFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoProdutoFinalFocusGained
        txt_codigoProdutoFinal.setSelectionStart(0);
        txt_codigoProdutoFinal.setSelectionEnd  (txt_codigoProdutoFinal.getText().length());
    }//GEN-LAST:event_txt_codigoProdutoFinalFocusGained

    private void txt_fornecedorInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_fornecedorInicialFocusGained
        txt_fornecedorInicial.setSelectionStart(0);
        txt_fornecedorInicial.setSelectionEnd  (txt_fornecedorInicial.getText().length());
    }//GEN-LAST:event_txt_fornecedorInicialFocusGained

    private void txt_fornecedorFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_fornecedorFinalFocusGained
        txt_fornecedorFinal.setSelectionStart(0);
        txt_fornecedorFinal.setSelectionEnd  (txt_fornecedorFinal.getText().length());
    }//GEN-LAST:event_txt_fornecedorFinalFocusGained

    private void txt_dataCadastroInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataCadastroInicialFocusGained
        txt_dataCadastroInicial.setSelectionStart(0);
        txt_dataCadastroInicial.setSelectionEnd  (txt_dataCadastroInicial.getText().length());
    }//GEN-LAST:event_txt_dataCadastroInicialFocusGained

    private void txt_dataCadastroFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataCadastroFinalFocusGained
        txt_dataCadastroFinal.setSelectionStart(0);
        txt_dataCadastroFinal.setSelectionEnd  (txt_dataCadastroFinal.getText().length());
    }//GEN-LAST:event_txt_dataCadastroFinalFocusGained

    private void txt_fabricanteInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_fabricanteInicialFocusGained
        txt_fabricanteInicial.setSelectionStart(0);
        txt_fabricanteInicial.setSelectionEnd  (txt_fabricanteInicial.getText().length());
    }//GEN-LAST:event_txt_fabricanteInicialFocusGained

    private void txt_fabricanteFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_fabricanteFinalFocusGained
        txt_fabricanteFinal.setSelectionStart(0);
        txt_fabricanteFinal.setSelectionEnd  (txt_fabricanteFinal.getText().length());
    }//GEN-LAST:event_txt_fabricanteFinalFocusGained

    private void txt_dataVencimentoInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVencimentoInicialFocusGained
        txt_dataVencimentoInicial.setSelectionStart(0);
        txt_dataVencimentoInicial.setSelectionEnd  (txt_dataVencimentoInicial.getText().length());
    }//GEN-LAST:event_txt_dataVencimentoInicialFocusGained

    private void txt_dataVencimentoFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVencimentoFinalFocusGained
        txt_dataVencimentoFinal.setSelectionStart(0);
        txt_dataVencimentoFinal.setSelectionEnd  (txt_dataVencimentoFinal.getText().length());
    }//GEN-LAST:event_txt_dataVencimentoFinalFocusGained

    private void txt_codigoProdutoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoProdutoInicialFocusLost
        txt_codigoProdutoInicial.setText(fc.FormataCampo(txt_codigoProdutoInicial.getText(), 6, 0));
    }//GEN-LAST:event_txt_codigoProdutoInicialFocusLost

    private void txt_codigoProdutoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoProdutoFinalFocusLost
        txt_codigoProdutoFinal.setText(fc.FormataCampo(txt_codigoProdutoFinal.getText(), 6, 0));
    }//GEN-LAST:event_txt_codigoProdutoFinalFocusLost

    private void txt_fornecedorInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_fornecedorInicialFocusLost
        txt_fornecedorInicial.setText(fc.FormataCampo(txt_fornecedorInicial.getText(), 5, 0));
    }//GEN-LAST:event_txt_fornecedorInicialFocusLost

    private void txt_fornecedorFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_fornecedorFinalFocusLost
        txt_fornecedorFinal.setText(fc.FormataCampo(txt_fornecedorFinal.getText(), 5, 0));
    }//GEN-LAST:event_txt_fornecedorFinalFocusLost

    private void txt_fabricanteInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_fabricanteInicialFocusLost
        txt_fabricanteInicial.setText(fc.FormataCampo(txt_fabricanteInicial.getText(), 5, 0));
    }//GEN-LAST:event_txt_fabricanteInicialFocusLost

    private void txt_fabricanteFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_fabricanteFinalFocusLost
        txt_fabricanteFinal.setText(fc.FormataCampo(txt_fabricanteFinal.getText(), 5, 0));
    }//GEN-LAST:event_txt_fabricanteFinalFocusLost

    private void bt_exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_exportarActionPerformed
        SeletorExcel = new JFileChooser();
        SalvarExcel = SeletorExcel.showSaveDialog(tabela_produtos);
        if(SalvarExcel != JFileChooser.APPROVE_OPTION){
            return;
        }
        NomeArquivoExcel    = SeletorExcel.getSelectedFile().getName();
        LocalArquivo        = SeletorExcel.getSelectedFile().getParentFile().getPath();
        String Extensao = "";
        if(NomeArquivoExcel.length() > 4){
            Extensao = NomeArquivoExcel.substring(NomeArquivoExcel.length() - 4, NomeArquivoExcel.length());
        }
        if(Extensao.equals(".xls")) {
            LocalArquivo = LocalArquivo + "/" + NomeArquivoExcel;
        }else{
            LocalArquivo = LocalArquivo + "/" + NomeArquivoExcel + ".xls";
        }
        try {
            new ExportarParaExcel(tabela_produtos, new File(LocalArquivo), 0, 0, 0);
        } catch (IOException erro) {
            mensagem = "Erro: " + erro.getMessage();
            new MostraMensagem(mensagem);
        }
    }//GEN-LAST:event_bt_exportarActionPerformed

    private void bt_cadastrarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastrarProdutosActionPerformed
        if(ProCad != null)if(ProCad.isVisible()){
            AbriuFabricante = 0;
            mensagem = "Tela já Aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        ProCad = new ProdutosCadastro("SN", 0);
        ProCad.setVisible(true);
    }//GEN-LAST:event_bt_cadastrarProdutosActionPerformed

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void txt_descricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descricaoKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            tabela_produtos.grabFocus();
            return;
        }
        textoBusca = txt_descricao.getText();
        if(textoBusca.replace(" ", "").equals("")){
            PegaValores();
            return;
        }
        PegaValores();
    }//GEN-LAST:event_txt_descricaoKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Table   = (DefaultTableModel)tabela_produtos.getModel();
        
        InicializaCampos();
        PegaValores();
        
        if(parametrosNS.bu.nivelUsuario < 4 | somostra.equals("S")){
            jMenu.setVisible(false);
        }
        txt_descricao.grabFocus();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(ProCad   != null){ProCad.dispose();}
        if(ForCon   != null){ForCon.dispose();}
        if(FabCon   != null){FabCon.dispose();}
    }//GEN-LAST:event_formWindowClosed

    private void tabela_produtosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabela_produtosKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        RetornaProduto();
        if(linha >= 0){
            dispose();
        }
    }//GEN-LAST:event_tabela_produtosKeyPressed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_cadastrarProdutos;
    private javax.swing.JMenuItem bt_detalhesItem;
    private javax.swing.JButton bt_exportar;
    private javax.swing.JButton bt_pesquisaFabricanteFinal;
    private javax.swing.JButton bt_pesquisaFabricanteInicial;
    private javax.swing.JButton bt_pesquisaFornecedorFinal;
    private javax.swing.JButton bt_pesquisaFornecedorInicial;
    private javax.swing.JButton bt_processa;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable tabela_produtos;
    private javax.swing.JFormattedTextField txt_codigoProdutoFinal;
    private javax.swing.JFormattedTextField txt_codigoProdutoInicial;
    private javax.swing.JFormattedTextField txt_dataCadastroFinal;
    private javax.swing.JFormattedTextField txt_dataCadastroInicial;
    private javax.swing.JFormattedTextField txt_dataVencimentoFinal;
    private javax.swing.JFormattedTextField txt_dataVencimentoInicial;
    private javax.swing.JTextField txt_descricao;
    private javax.swing.JFormattedTextField txt_fabricanteFinal;
    private javax.swing.JFormattedTextField txt_fabricanteInicial;
    private javax.swing.JFormattedTextField txt_fornecedorFinal;
    private javax.swing.JFormattedTextField txt_fornecedorInicial;
    // End of variables declaration//GEN-END:variables
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    public String getRetorno(){
        return retorno;
    }
    
    private void RetornaProduto(){
        linha = tabela_produtos.getSelectedRow();
        if(linha < 0){
            mensagem = "Item não selecionado!";
            mostraMensagem();
            return;
        }
        if(!tipo.equalsIgnoreCase("cdb")){
            retorno = String.valueOf(Integer.parseInt(String.valueOf(tabela_produtos.getValueAt(linha, 0))));
        }else{
            retorno = String.valueOf(tabela_produtos.getValueAt(linha, 9)).replace(" ", "");
        }
        if(retorno.equals("null")){
            retorno = "";
        }
        if(retorno.equals("")){
            retorno = String.valueOf(Integer.parseInt(String.valueOf(tabela_produtos.getValueAt(linha, 0))));
        }
    }
    
    private void PegaValores(){
        preenchimento = "";
        binter.produtoInicial           = Integer.parseInt(txt_codigoProdutoInicial.getText());
        binter.produtoFinal             = Integer.parseInt(txt_codigoProdutoFinal.getText());
        if(binter.produtoInicial > binter.produtoFinal){
            mensagem = "Protudo Inicial não pode ser maior do que Produto Final!";
            new MostraMensagem(mensagem);
            return;
        }
        if(binter.produtoInicial != 0 || binter.produtoFinal != 999999){
            if(preenchimento.equals("")){
                preenchimento  = "codigoProduto between " + binter.produtoInicial + " and " + binter.produtoFinal + " and \n";
            }else{
                preenchimento += "codigoProduto between " + binter.produtoInicial + " and " + binter.produtoFinal + " and \n";
            }
        }
        
        binter.fornecedorInicial        = Integer.parseInt(txt_fornecedorInicial.getText());
        binter.fornecedorFinal          = Integer.parseInt(txt_fornecedorFinal.getText());
        if(binter.fornecedorInicial > binter.fornecedorFinal){
            mensagem = "Fornecedor Inicial não pode ser maior do que Fornecedor Final!";
            new MostraMensagem(mensagem);
            return;
        }
        if(binter.fornecedorInicial != 0 || binter.fornecedorFinal != 99999){
            if(preenchimento.equals("")){
                preenchimento  = "codigoFornecedor between " + binter.fornecedorInicial  + " and " + binter.fornecedorFinal + " and \n";
            }else{
                preenchimento += "codigoFornecedor between " + binter.fornecedorInicial  + " and " + binter.fornecedorFinal + " and \n";
            }
        }
        
        binter.fabricanteInicial        = Integer.parseInt(txt_fabricanteInicial.getText());
        binter.fabricanteFinal          = Integer.parseInt(txt_fabricanteFinal.getText());
        if(binter.fabricanteInicial > binter.fabricanteFinal){
            mensagem = "Fabricante Inicial não pode ser maior do que Fabricante Final!";
            new MostraMensagem(mensagem);
            return;
        }
        if(binter.fabricanteInicial != 0 || binter.fabricanteFinal != 99999){
            if(preenchimento.equals("")){
                preenchimento  = "codigoFabricante between " + binter.fabricanteInicial + " and " + binter.fabricanteFinal + " and \n";
            }else{
                preenchimento += "codigoFabricante between " + binter.fabricanteInicial + " and " + binter.fabricanteFinal + " and \n";
            }
        }
        
        binter.dataCadastroInicial      = Test.Testa(txt_dataCadastroInicial.getText());
        binter.dataCadastroFinal        = Test.Testa(txt_dataCadastroFinal.getText());
        if(binter.dataCadastroInicial > binter.dataCadastroFinal){
            mensagem = "Cadasttro Inicial não pode ser maior do que Cadastro Final!";
            new MostraMensagem(mensagem);
            return;
        }
        if(binter.dataCadastroInicial != 0 || binter.dataCadastroFinal != 99999999){
            if(preenchimento.equals("")){
                preenchimento  = "dataCadastro between " + binter.dataCadastroInicial + " and " + binter.dataCadastroFinal;
            }else{
                preenchimento += "dataCadastro between " + binter.dataCadastroInicial + " and " + binter.dataCadastroFinal;
            }
        }
        
        binter.dataVencimentoInicial    = Test.Testa(txt_dataVencimentoInicial.getText());
        binter.dataVencimentoFinal      = Test.Testa(txt_dataVencimentoFinal.getText());
        if(binter.dataVencimentoInicial > binter.dataVencimentoFinal){
            mensagem = "Vencimento Inicial não pode ser maior do que Vencimento Final!";
            new MostraMensagem(mensagem);
            return;
        }
        if(binter.dataVencimentoInicial != 0 || binter.dataVencimentoFinal != 99999999){
            if(binter.dataCadastroInicial != 0 || binter.dataCadastroFinal != 99999999){
                if(preenchimento.equals("")){
                    preenchimento  = " or \ndataDeVencimento between " + binter.dataVencimentoInicial + " and " + binter.dataVencimentoFinal;
                }else{
                    preenchimento += " or \ndataDeVencimento between " + binter.dataVencimentoInicial + " and " + binter.dataVencimentoFinal;
                }
            }else{
                if(preenchimento.equals("")){
                    preenchimento  = " and \ndataDeVencimento between " + binter.dataVencimentoInicial + " and " + binter.dataVencimentoFinal;
                }else{
                    preenchimento += " and \ndataDeVencimento between " + binter.dataVencimentoInicial + " and " + binter.dataVencimentoFinal;
                }
            }
        }
        
        PegaProdutos();
    }
    
    private void PegaProdutos(){
        sql = "select \n"
/*0*/       + "   idProdutos, \n"
/*1*/       + "   idEmpresa, \n"
/*2*/       + "   codigoGrupo, \n"
/*3*/       + "   codigoEmpresa, \n"
/*4*/       + "   codigoProduto, \n"
/*5*/       + "   produtoInativo, \n"
/*6*/       + "   codigoFornecedor, \n"
/*7*/       + "   dataCadastro, \n"
/*8*/       + "   descricaoProduto, \n"
/*9*/       + "   codigoDeBarras, \n"
/*10*/      + "   dataDeVencimento, \n"
/*11*/      + "   valorDeCompra, \n"
/*12*/      + "   valorDeVenda, \n"
/*13*/      + "   tipoDeProduto, \n"
/*14*/      + "   codigoFabricante, \n"
/*15*/      + "   codigoGrupoProduto, \n"
/*16*/      + "   codigoSubGrupoProduto, \n"
/*17*/      + "   quantidadeMinima, \n"
/*18*/      + "   quantidadeIdeal, \n"
/*19*/      + "   quantidadeAtual, \n"
/*20*/      + "   observacoes \n"
            + "from \n"
            + "   tb_produtos where idEmpresa = " + parametrosNS.be.IdEmpresa;
        if(!textoBusca.equals("")){
            sql += "\n and ";
            sql1 = " like '%" + textoBusca + "%' ";
        }
        if(!preenchimento.equals(""))
            sql1 = " and " + sql1 + preenchimento;
        if(textoBusca.equals("")){
            sql += preenchimento;
            sql1 = "";
        }
        dadosProdutos = new ArrayList();
        if( sql1.equals("")){dadosProdutos = parametrosNS.dao.Consulta(sql);}
        if(!sql1.equals("")){dadosProdutos = parametrosNS.PesqAvan.PesquisaAvancada(sql, sql1, "tb_produtos");}
        bt_exportar.setEnabled(true);
        if(dadosProdutos.isEmpty()){
            bt_exportar.setEnabled(false);
            return;
        }
        PegaDadosProdutos();
    }
    
    private void PegaDadosProdutos(){
        tabela_produtos.getColumnModel().getColumn(0).setResizable(false);      //Código
        tabela_produtos.getColumnModel().getColumn(0).setCellRenderer(parametrosNS.tableDireita);
        
        tabela_produtos.getColumnModel().getColumn(1).setResizable(false);      //Status
        tabela_produtos.getColumnModel().getColumn(1).setCellRenderer(parametrosNS.tableCentralizado);
        
        tabela_produtos.getColumnModel().getColumn(2).setResizable(true);
        tabela_produtos.getColumnModel().getColumn(2).setCellRenderer(parametrosNS.tableCentralizado);
        
        tabela_produtos.getColumnModel().getColumn(3).setResizable(true);
        tabela_produtos.getColumnModel().getColumn(3).setCellRenderer(parametrosNS.tableCentralizado);
        
        tabela_produtos.getColumnModel().getColumn(4).setResizable(true);
        tabela_produtos.getColumnModel().getColumn(4).setCellRenderer(parametrosNS.tableEsquerda);
        
        tabela_produtos.getColumnModel().getColumn(5).setResizable(true);
        tabela_produtos.getColumnModel().getColumn(5).setCellRenderer(parametrosNS.tableEsquerda);
        
        tabela_produtos.getColumnModel().getColumn(6).setResizable(true);
        tabela_produtos.getColumnModel().getColumn(6).setCellRenderer(parametrosNS.tableEsquerda);
        
        tabela_produtos.getColumnModel().getColumn(7).setResizable(true);
        tabela_produtos.getColumnModel().getColumn(7).setCellRenderer(parametrosNS.tableDireita);
        
        tabela_produtos.getColumnModel().getColumn(8).setResizable(true);
        tabela_produtos.getColumnModel().getColumn(8).setCellRenderer(parametrosNS.tableCentralizado);
        
        tabela_produtos.getColumnModel().getColumn(9).setResizable(false);      //Código de Barras
        tabela_produtos.getColumnModel().getColumn(9).setCellRenderer(parametrosNS.tableEsquerda);
        
        tabela_produtos.getColumnModel().getColumn(10).setResizable(true);
        tabela_produtos.getColumnModel().getColumn(10).setCellRenderer(parametrosNS.tableEsquerda);
        
        tabela_produtos.getColumnModel().getColumn(11).setResizable(true);
        tabela_produtos.getColumnModel().getColumn(11).setCellRenderer(parametrosNS.tableEsquerda);
        
        Table.setNumRows(0);
        String statusProduto = "";
        for(int i = 0; i < dadosProdutos.size(); i++){
            bp  = new BeanProdutos();
            if(dadosProdutos.get(i).get(0) != null){
                bp.idProdutos               = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(0)));
            }
            if(dadosProdutos.get(i).get(1) != null){
                bp.idEmpresa                = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(1)));
            }
            if(dadosProdutos.get(i).get(2) != null){
                bp.codigoGrupo              = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(2)));
            }
            if(dadosProdutos.get(i).get(3) != null){
                bp.codigoEmpresa            = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(3)));
            }
            if(dadosProdutos.get(i).get(4) != null){
                bp.codigoProduto            = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(4)));
            }
            if(dadosProdutos.get(i).get(5) != null){
                bp.produtoInativo           = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(5)));
            }
            if(dadosProdutos.get(i).get(6) != null){
                bp.codigoFornecedor         = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(6)));
            }
            if(dadosProdutos.get(i).get(7) != null){
                bp.dataCadastro             =                    String.valueOf(dadosProdutos.get(i).get(7));
            }
            if(dadosProdutos.get(i).get(8) != null){
                bp.descricaoProduto         =                    String.valueOf(dadosProdutos.get(i).get(8));
            }
            if(dadosProdutos.get(i).get(9) != null){
                bp.codigoDeBarras           =                    String.valueOf(dadosProdutos.get(i).get(9));
            }
            if(dadosProdutos.get(i).get(10) != null){
                bp.dataDeVencimento         =                    String.valueOf(dadosProdutos.get(i).get(10));
            }
            if(dadosProdutos.get(i).get(11) != null){
                bp.valorDeCompra            = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(11)));
            }
            if(dadosProdutos.get(i).get(12) != null){
                bp.valorDeVenda             = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(12)));
            }
            if(dadosProdutos.get(i).get(13) != null){
                bp.tipoDeProduto            =                    String.valueOf(dadosProdutos.get(i).get(13));
            }
            if(dadosProdutos.get(i).get(14) != null){
                bp.codigoFabricante         = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(14)));
            }
            if(dadosProdutos.get(i).get(15) != null){
                bp.codigoGrupoProduto       = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(15)));
            }
            if(dadosProdutos.get(i).get(16) != null){
                bp.codigoSubGrupoProduto    = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(16)));
            }
            if(dadosProdutos.get(i).get(17) != null){
                bp.quantidadeMinima         = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(17)));
            }
            if(dadosProdutos.get(i).get(18) != null){
                bp.quantidadeIdeal          = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(18)));
            }
            if(dadosProdutos.get(i).get(19) != null){
                bp.quantidadeAtual          = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(19)));
            }
            if(dadosProdutos.get(i).get(20) != null){
                bp.observacoes              =                    String.valueOf(dadosProdutos.get(i).get(20));
            }
            
            if(bp.produtoInativo == 0){
                statusProduto = "À venda";
            }else{
                statusProduto = "Bloqueado";
            }
            
            if(bp.dataCadastro != null){
                bp.dataCadastro     = invdata.inverterData(bp.dataCadastro, 1);
            }else{
                bp.dataCadastro     = "";
            }
            
            if(bp.dataDeVencimento != null){
                bp.dataDeVencimento = invdata.inverterData(bp.dataDeVencimento, 1);
            }else{
                bp.dataDeVencimento = "";
            }
            
            bfab.codigoFabricante   = bp.codigoFabricante;
            PegaFabricante();
            
            bfor.codigoFornecedor   = bp.codigoFornecedor;
            PegaFornecedor();
            
            bgp .codigoGrupoProduto     = bp.codigoGrupoProduto;
            bsgp.codigoSubGrupoProduto  = bp.codigoSubGrupoProduto;
            PegaGrupoSubGrupoProdutos();
            bgp .descricaoGrupo         = fc.FormataCampo(String.valueOf(bgp.codigoGrupoProduto), 3, 0)     + " - " + bgp.descricaoGrupo;
            bsgp.descricaoSubGrupo      = fc.FormataCampo(String.valueOf(bsgp.codigoSubGrupoProduto), 3, 0) + " - " + bsgp.descricaoSubGrupo;
            
            if(bgp.codigoGrupoProduto == 0){
                bgp.descricaoGrupo      = "----------";
            }
            if(bsgp.codigoSubGrupoProduto == 0){
                bsgp.descricaoSubGrupo  = "----------";
            }
            
            Table.addRow(new Object [] {fc.FormataCampo(String.valueOf(bp.codigoProduto), 6, 0), statusProduto, bp.dataCadastro, bp.dataDeVencimento, bp.descricaoProduto, fc.FormataCampo(String.valueOf(bfab.codigoFabricante), 5, 0) + "-" + bfab.nomeFabricante, fc.FormataCampo(String.valueOf(bfor.codigoFornecedor), 5, 0) + "-" + bfor.nome, TransStrDou.TransformaValorStringeDouble(String.valueOf(bp.valorDeVenda), 0) , String.valueOf(bp.quantidadeAtual), bp.codigoDeBarras, bgp.descricaoGrupo, bsgp.descricaoSubGrupo, bp.observacoes});
        }
        new AjustarLarguraColunas(tabela_produtos);
    }
    
    private void PegaFabricante(){
        bfab.nomeFabricante = "----------";
        sql = "select codigoFabricante, nomeFabricante, siteFabricante from tb_fabricante where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoFabricante = " + bfab.codigoFabricante + ";";
        dadosFabricante.clear();
        dadosFabricante = parametrosNS.dao.Consulta(sql);
        if(dadosFabricante.isEmpty()){
            return;
        }
        PegaDadosFabricante();
    }
    
    private void PegaDadosFabricante(){
        for(int i = 0; i < dadosFabricante.size(); i++){
            bfab = new BeanFabricante();
//            bfab.idFabricante       = Integer.parseInt(  String.valueOf(dadosFabricante.get(i).get(0)));
//            bfab.idEmpresa          = Integer.parseInt(  String.valueOf(dadosFabricante.get(i).get(1)));
//            bfab.codigoGrupo        = Integer.parseInt(  String.valueOf(dadosFabricante.get(i).get(2)));
//            bfab.codigoEmpresa      = Integer.parseInt(  String.valueOf(dadosFabricante.get(i).get(3)));
            bfab.codigoFabricante   = Integer.parseInt(  String.valueOf(dadosFabricante.get(i).get(0)));
            bfab.nomeFabricante     =                    String.valueOf(dadosFabricante.get(i).get(1));
            bfab.siteFabricante     =                    String.valueOf(dadosFabricante.get(i).get(2));
        }
    }
    
    private void PegaFornecedor(){
        bfor.nome = "----------";
        sql = "select \n"
            + "   idFornecedor, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoFornecedor, \n"
            + "   nome \n"
            + "from \n"
            + "   tb_fornecedor where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoFornecedor = " + bfor.codigoFornecedor + ";";
        dadosFornecedor.clear();
        dadosFornecedor = parametrosNS.dao.Consulta(sql);
        if(dadosFornecedor.isEmpty()){
            return;
        }
        PegaDadosFornecedor();
    }
    
    private void PegaDadosFornecedor(){
        for(int i = 0; i < dadosFornecedor.size(); i++){
            bfor.idFornecedor       = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(0)));
            bfor.idEmpresa          = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(1)));
            bfor.codigoGrupo        = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(2)));
            bfor.codigoEmpresa      = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(3)));
            bfor.codigoFornecedor   = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(4)));
            bfor.nome               =                    String.valueOf(dadosFornecedor.get(i).get(5));
        }
    }
    
    private void PegaGrupoSubGrupoProdutos(){
        if(bgp.codigoGrupoProduto == 0){
            return;
        }
        if(bsgp.codigoSubGrupoProduto == 0){
            return;
        }
        sql = "select "
            + " grus.idSubGrupoProduto, "
            + " grus.idEmpresa, "
            + " grus.codigoGrupo, "
            + " grus.codigoEmpresa, "
            + " grus.codigoGrupoProduto, "
            + " grus.codigoSubGrupoProduto, "
            + " grus.descricaoSubGrupo, "
            + " gru.descricaoGrupo "
            + "from "
            + " tb_subgrupoproduto grus "
            + "	inner join tb_grupoproduto gru on ((gru.idEmpresa = grus.idEmpresa) and (gru.codigoGrupoProduto = grus.codigoGrupoProduto))"
            + "  where gru.codigoGrupo = " + parametrosNS.bge.codigoGrupo + " and gru.codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and gru.codigoGrupoProduto = " + bgp.codigoGrupoProduto + " and grus.codigoSubGrupoProduto = " + bsgp.codigoSubGrupoProduto + ";";
        dadosGrupoSubGrupoProdutos.clear();
        dadosGrupoSubGrupoProdutos = parametrosNS.dao.Consulta(sql);
        if(dadosGrupoSubGrupoProdutos.isEmpty()){
            mensagem = "Não foram encontrados grupos ou sub-grupos cadastrados para o produto n°: " + fc.FormataCampo(String.valueOf(bp.codigoProduto), 6, 0) + "-" + bp.descricaoProduto + "!";
            new MostraMensagem(mensagem);
            return;
        }
        PegaDadosGruposSubGrupoProdutos();
    }
    
    private void PegaDadosGruposSubGrupoProdutos(){
        for(int i = 0; i < dadosGrupoSubGrupoProdutos.size(); i++){
            bgp  = new BeanGrupoProduto();
            bsgp = new BeanSubGrupoProduto();
            
            if(dadosGrupoSubGrupoProdutos.get(i).get(0) != null){bsgp.idSubGrupoProduto          = Integer.parseInt(  String.valueOf(dadosGrupoSubGrupoProdutos.get(i).get(0)));}
            if(dadosGrupoSubGrupoProdutos.get(i).get(1) != null){bsgp.idEmpresa                  = Integer.parseInt(  String.valueOf(dadosGrupoSubGrupoProdutos.get(i).get(1)));}
            if(dadosGrupoSubGrupoProdutos.get(i).get(2) != null){bsgp.codigoGrupo                = Integer.parseInt(  String.valueOf(dadosGrupoSubGrupoProdutos.get(i).get(2)));}
            if(dadosGrupoSubGrupoProdutos.get(i).get(3) != null){bsgp.codigoEmpresa              = Integer.parseInt(  String.valueOf(dadosGrupoSubGrupoProdutos.get(i).get(3)));}
            if(dadosGrupoSubGrupoProdutos.get(i).get(4) != null){bsgp.codigoGrupoProduto         = Integer.parseInt(  String.valueOf(dadosGrupoSubGrupoProdutos.get(i).get(4)));}
            if(dadosGrupoSubGrupoProdutos.get(i).get(5) != null){bsgp.codigoSubGrupoProduto      = Integer.parseInt(  String.valueOf(dadosGrupoSubGrupoProdutos.get(i).get(5)));}
            if(dadosGrupoSubGrupoProdutos.get(i).get(6) != null){bsgp.descricaoSubGrupo          =                    String.valueOf(dadosGrupoSubGrupoProdutos.get(i).get(6));}
            
            bgp.idEmpresa          = bsgp.idEmpresa;
            bgp.codigoGrupo        = bsgp.codigoGrupo;
            bgp.codigoEmpresa      = bsgp.codigoEmpresa;
            bgp.codigoGrupoProduto = bsgp.codigoGrupoProduto;
            if(dadosGrupoSubGrupoProdutos.get(i).get(7) != null){bgp.descricaoGrupo              =                    String.valueOf(dadosGrupoSubGrupoProdutos.get(i).get(7));}
        }
    }
    
//    private void PegaUsuario(){
//        sql = "select usuario from tb_usuarios where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
//        dadosUsuarios.clear();
//        dadosUsuarios = parametrosNS.dao.Consulta(sql);        
//        if(dadosUsuarios.isEmpty()){
//            mensagem = "Codigo do Usuário " + bu.codigoUsuario + " não encontrado!!!";
//            new MostraMensagem(mensagem);
//            return;
//        }
//        PegaDadosUsuario();
//    }
//    
//    private void PegaDadosUsuario(){
//        for(int i = 0; i < dadosUsuarios.size(); i++)
//            bu.usuario              = String.valueOf(dadosUsuarios.get(i).get(0));
//    }
    
}
