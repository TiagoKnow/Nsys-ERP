package TelasEstoque;

import FuncoesInternas.InverterData;
import BeansNS.BeanEmpresas;
import BeansNS.BeanBancoDados;
import FuncoesInternas.*;
import Beans.*;
import Parametros.parametrosNS;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
/*
 @author Tiago e Paulo
 */
public class ProdutosCadastro extends javax.swing.JFrame {
    //String's
    String Valor                = "";
    String sqlstate             = "";
    String sql                  = "";
    String operacao             = "";
    String fatal                = "N";
    String mensagem             = "";
    String DataAtual            = "";
    String HoraAtual            = "";
    String somostra             = "";
    String retorno              = "";
    String valorFormatado       = "";
    String PegouCodigoProduto   = "";
    String pastaImagem          = "";
    String leuImagem            = "";
    String mostraMensagem       = "";
    
    //Object's
    Object ValorTabela = "";
    
    //ArrayList's
//    ArrayList            dadosPadroes                  = new ArrayList();
    ArrayList<ArrayList> dadosProdutos                 = new ArrayList<ArrayList>();
    ArrayList            dadosProdutosDetalhes         = new ArrayList();
    ArrayList<ArrayList> dadosFornecedor               = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosFabricante               = new ArrayList<ArrayList>();
    ArrayList            parametros                    = new ArrayList();
    ArrayList<ArrayList> dadosGrupoProdutos            = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosSubGrupoProdutos         = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosUsuario                  = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosParametros               = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosParametrosEstoque        = new ArrayList<ArrayList>();
    ArrayList            dadosBarras                   = new ArrayList();

    //int's
    int Proximo                             = 0;
    int CodigoAlteracao                     = 0;
    int Confirmacao                         = 0;
    int coluna                              = 0;
    int abriuProduto                        = 0;
    int abriuFabricante                     = 0;
    int abriuFornecedor                     = 0;
    int Linha                               = 0;
    int UltimoRegistro                      = 0;
    int abriuGrupoProduto                   = 0;
    
    //bean's
    BeanEmpresas                    be      = new BeanEmpresas();
    BeanBancoDados                  bbd     = new BeanBancoDados();
    BeanUsuarios                    bu      = new BeanUsuarios();
    BeanProdutos                    bp      = new BeanProdutos();
    BeanProdutosDetalhes            bpd     = new BeanProdutosDetalhes();
    BeanGrupoProduto                bgp     = new BeanGrupoProduto();
    BeanSubGrupoProduto             bsgp    = new BeanSubGrupoProduto();
    BeanParametros                  bpar    = new BeanParametros();
    BeanParametrosEstoque           bpare   = new BeanParametrosEstoque();
    BeanFornecedor                  bfor    = new BeanFornecedor();
    BeanFabricante                  bfab    = new BeanFabricante();
    
    //Especiais
    ValidarData                     validador   = new ValidarData();
    CapturarDataHora                cdh         = new CapturarDataHora();
    TestarData                      Test        = new TestarData();
    FormataCampo                    fc          = new FormataCampo();
    FormataCPFCNPJ                  FCpfCnpj    = new FormataCPFCNPJ();
    InverterData                    invdata     = new InverterData();
    PegaProximoRegistro             PegProReg   = new PegaProximoRegistro();
    TransformaValorStringeDouble    TransStrDou = new TransformaValorStringeDouble();
    
    //Especiais Para Boletos
    PreparedStatement     stmt;
    ResultSet             rs;
    JRResultSetDataSource js;
    String                jpv     = "";
    JasperPrint           jpp     = null;
    HashMap               hm      = new HashMap();
    
    //Variaveis para Imagem
    File                arquivoPasta    = null;
    JFileChooser        seletor         = new JFileChooser();
    BufferedImage       lerImagem;
    ImageIcon           imgIcon;
    Image               img;
    
    //Telas
    ProdutosCadastro        ProCad;
    ProdutosConsulta        ProCon;
    FornecedorConsulta      ForCon;
    FornecedorCadastro      ForCad;
    FabricanteConsulta      FabCon;
    FabricanteCadastro      FabCad;
    GrupoProdutoCadastro    CadGruPro;
    SubGrupoProdutoCadastro CadSubGruPro;
    
    //Especiais
    BufferedImage                   BuffImg;
    ByteArrayOutputStream           BytesImg;
    ImageIcon                       ImgIcon;
    Image                           Img;
    
    public ProdutosCadastro(String Somostra, int CodigoProduto){
        somostra                    = Somostra;
        bp.codigoProduto            = CodigoProduto;
        
        initComponents();
    }
    
    public void AtualizarImagens(){
        sql = "update tb_produtos set imagemProduto = ? where codigoGrupo = " + bp.codigoGrupo + " and codigoEmpresa = " + bp.codigoEmpresa + " and codigoProduto = " + bp.codigoProduto + ";";
        sqlstate = parametrosNS.dao.atualizarImagens(sql, bp.getImagemProduto());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_descricaoProduto = new javax.swing.JTextField();
        txt_codigoDeBarras = new javax.swing.JTextField();
        combo_grupoProduto = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        txt_valorDeCompra = new javax.swing.JTextField();
        txt_quantidadeAtual = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_observacoes = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        txt_quantidadeIdeal = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_codigoFabricante = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_quantidadeMinima = new javax.swing.JFormattedTextField();
        txt_valorDeVenda = new javax.swing.JTextField();
        combo_subGrupoProduto = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        combo_tipoDeProduto = new javax.swing.JComboBox();
        txt_dataDeVencimento = new javax.swing.JFormattedTextField();
        label_fabricante = new javax.swing.JLabel();
        bt_pesquisaFabricante = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_incluir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        label_alteracao = new javax.swing.JLabel();
        bt_pesquisaProduto = new javax.swing.JButton();
        bt_anterior = new javax.swing.JButton();
        bt_proximo = new javax.swing.JButton();
        bt_primeiro = new javax.swing.JButton();
        bt_ultimo = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        bt_novo = new javax.swing.JButton();
        txt_codigoProduto = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        bt_pesquisaFornecedor = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_codigoFornecedor = new javax.swing.JFormattedTextField();
        label_nomeFornecedor = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txt_dataCadastro = new javax.swing.JFormattedTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        check_Ativo = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        label_imagemProd = new javax.swing.JLabel();
        bt_carregarImagem = new javax.swing.JButton();
        bt_imprimir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        bt_novoRegistro = new javax.swing.JMenuItem();
        bt_incluir_alterarRegistro = new javax.swing.JMenuItem();
        jMenuArquivo = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        bt_cadastroGrupoDeProdutos = new javax.swing.JMenuItem();
        bt_cadastroSubGrupoDeProdutos = new javax.swing.JMenuItem();
        bt_cadastroDeFornecedores = new javax.swing.JMenuItem();
        bt_cadastroDeFabricantes = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        bt_sair = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(":: Cadastro Produtos");
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
        jPanel1.setFocusable(false);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nome do Produto: ");
        jLabel3.setFocusable(false);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Código de Barras: ");
        jLabel6.setFocusable(false);

        txt_descricaoProduto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txt_descricaoProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_descricaoProdutoFocusLost(evt);
            }
        });
        txt_descricaoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_descricaoProdutoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_descricaoProdutoKeyReleased(evt);
            }
        });

        txt_codigoDeBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoDeBarrasActionPerformed(evt);
            }
        });
        txt_codigoDeBarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoDeBarrasKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoDeBarrasKeyReleased(evt);
            }
        });

        combo_grupoProduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        combo_grupoProduto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_grupoProdutoItemStateChanged(evt);
            }
        });
        combo_grupoProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                combo_grupoProdutoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo_grupoProdutoFocusLost(evt);
            }
        });
        combo_grupoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo_grupoProdutoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combo_grupoProdutoKeyReleased(evt);
            }
        });

        jLabel10.setText("Valor de Venda: ");
        jLabel10.setFocusable(false);

        txt_valorDeCompra.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_valorDeCompra.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_valorDeCompra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_valorDeCompraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorDeCompraFocusLost(evt);
            }
        });
        txt_valorDeCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_valorDeCompraActionPerformed(evt);
            }
        });
        txt_valorDeCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_valorDeCompraKeyReleased(evt);
            }
        });

        try {
            txt_quantidadeAtual.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_quantidadeAtual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_quantidadeAtual.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_quantidadeAtualFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_quantidadeAtualFocusLost(evt);
            }
        });
        txt_quantidadeAtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quantidadeAtualActionPerformed(evt);
            }
        });
        txt_quantidadeAtual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_quantidadeAtualKeyReleased(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Valor Compra: ");
        jLabel4.setFocusable(false);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Grupo: ");
        jLabel15.setFocusable(false);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Qtd Atual: ");
        jLabel17.setFocusable(false);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Qtd Mínima: ");
        jLabel19.setFocusable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Fabricante: ");
        jLabel1.setFocusable(false);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Observações: ");
        jLabel5.setFocusable(false);

        txt_observacoes.setColumns(20);
        txt_observacoes.setRows(5);
        txt_observacoes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_observacoesFocusLost(evt);
            }
        });
        txt_observacoes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_observacoesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txt_observacoes);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Sub Grupo: ");
        jLabel20.setFocusable(false);

        try {
            txt_quantidadeIdeal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_quantidadeIdeal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_quantidadeIdeal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_quantidadeIdealFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_quantidadeIdealFocusLost(evt);
            }
        });
        txt_quantidadeIdeal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_quantidadeIdealKeyReleased(evt);
            }
        });

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Qtd Ideal: ");
        jLabel21.setFocusable(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Detalhes do Produto");
        jLabel11.setToolTipText("");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel11.setFocusable(false);

        try {
            txt_codigoFabricante.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoFabricante.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoFabricanteFocusLost(evt);
            }
        });
        txt_codigoFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoFabricanteActionPerformed(evt);
            }
        });
        txt_codigoFabricante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoFabricanteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoFabricanteKeyReleased(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Tipo: ");
        jLabel14.setFocusable(false);

        try {
            txt_quantidadeMinima.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_quantidadeMinima.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_quantidadeMinima.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_quantidadeMinimaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_quantidadeMinimaFocusLost(evt);
            }
        });
        txt_quantidadeMinima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quantidadeMinimaActionPerformed(evt);
            }
        });
        txt_quantidadeMinima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_quantidadeMinimaKeyReleased(evt);
            }
        });

        txt_valorDeVenda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_valorDeVenda.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_valorDeVenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_valorDeVendaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorDeVendaFocusLost(evt);
            }
        });
        txt_valorDeVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_valorDeVendaActionPerformed(evt);
            }
        });
        txt_valorDeVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_valorDeVendaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_valorDeVendaKeyReleased(evt);
            }
        });

        combo_subGrupoProduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] {""}));
        combo_subGrupoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo_subGrupoProdutoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combo_subGrupoProdutoKeyReleased(evt);
            }
        });

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Vencimento: ");
        jLabel16.setFocusable(false);

        combo_tipoDeProduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---", "UN", "KG", "PC" }));
        combo_tipoDeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_tipoDeProdutoActionPerformed(evt);
            }
        });
        combo_tipoDeProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo_tipoDeProdutoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combo_tipoDeProdutoKeyReleased(evt);
            }
        });

        try {
            txt_dataDeVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataDeVencimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dataDeVencimentoActionPerformed(evt);
            }
        });
        txt_dataDeVencimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_dataDeVencimentoKeyReleased(evt);
            }
        });

        bt_pesquisaFabricante.setText("...");
        bt_pesquisaFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaFabricanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combo_grupoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_valorDeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combo_subGrupoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_valorDeVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(combo_tipoDeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_quantidadeMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_quantidadeIdeal, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_quantidadeAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_codigoFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(bt_pesquisaFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label_fabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_descricaoProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_dataDeVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_codigoDeBarras)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {combo_grupoProduto, combo_subGrupoProduto, txt_valorDeCompra, txt_valorDeVenda});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_codigoFabricante, txt_quantidadeMinima});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_quantidadeAtual, txt_quantidadeIdeal});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel20});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_codigoDeBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_descricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dataDeVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_valorDeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_valorDeVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_tipoDeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combo_grupoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_subGrupoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_fabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_codigoFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_pesquisaFabricante)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_quantidadeMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_quantidadeAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_quantidadeIdeal, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaFabricante, combo_grupoProduto, combo_subGrupoProduto, combo_tipoDeProduto, jLabel1, jLabel10, jLabel14, jLabel15, jLabel16, jLabel17, jLabel19, jLabel20, jLabel21, jLabel3, jLabel4, jLabel5, jLabel6, label_fabricante, txt_codigoDeBarras, txt_codigoFabricante, txt_dataDeVencimento, txt_descricaoProduto, txt_quantidadeAtual, txt_quantidadeIdeal, txt_quantidadeMinima, txt_valorDeCompra, txt_valorDeVenda});

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
        bt_incluir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bt_incluirKeyPressed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        label_alteracao.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_alteracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_alteracao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
        );

        bt_pesquisaProduto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_pesquisaProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/View.png"))); // NOI18N
        bt_pesquisaProduto.setText("Pesquisa");
        bt_pesquisaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaProdutoActionPerformed(evt);
            }
        });

        bt_anterior.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_anterior.setText("<");
        bt_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_anteriorActionPerformed(evt);
            }
        });

        bt_proximo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_proximo.setText(">");
        bt_proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_proximoActionPerformed(evt);
            }
        });

        bt_primeiro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_primeiro.setText("<<");
        bt_primeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_primeiroActionPerformed(evt);
            }
        });

        bt_ultimo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_ultimo.setText(">>");
        bt_ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ultimoActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Codigo do Produto (F1)");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setFocusable(false);

        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        try {
            txt_codigoProduto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        try {
            txt_codigoProduto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoProduto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoProduto.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                txt_codigoProdutoHierarchyChanged(evt);
            }
        });
        txt_codigoProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoProdutoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoProdutoFocusLost(evt);
            }
        });
        txt_codigoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoProdutoActionPerformed(evt);
            }
        });
        txt_codigoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoProdutoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_codigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_novo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, txt_codigoProduto});

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setFocusable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Fornecedor");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bt_pesquisaFornecedor.setText("...");
        bt_pesquisaFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaFornecedorActionPerformed(evt);
            }
        });

        try {
            txt_codigoFornecedor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
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
        txt_codigoFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoFornecedorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoFornecedorKeyReleased(evt);
            }
        });

        label_nomeFornecedor.setFocusable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(txt_codigoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_pesquisaFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_nomeFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_pesquisaFornecedor)
                    .addComponent(jLabel8)
                    .addComponent(txt_codigoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nomeFornecedor))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaFornecedor, label_nomeFornecedor, txt_codigoFornecedor});

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setFocusable(false);

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
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_dataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setFocusable(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Produto à Venda");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel12.setFocusable(false);

        check_Ativo.setText("Inativo");
        check_Ativo.setToolTipText("Produtos inativos ou não vendidos");
        check_Ativo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                check_AtivoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(check_Ativo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check_Ativo)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setFocusable(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Foto do Produto");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel13.setFocusable(false);

        label_imagemProd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_imagemProd.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bt_carregarImagem.setText("Carregar Imagem");
        bt_carregarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_carregarImagemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(label_imagemProd, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(bt_carregarImagem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_imagemProd, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_carregarImagem)
                .addContainerGap())
        );

        bt_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/print.png"))); // NOI18N
        bt_imprimir.setText("Imprimir");
        bt_imprimir.setEnabled(false);
        bt_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imprimirActionPerformed(evt);
            }
        });

        jMenu4.setText("Funções");

        bt_novoRegistro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        bt_novoRegistro.setText("Novo Registro");
        bt_novoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoRegistroActionPerformed(evt);
            }
        });
        jMenu4.add(bt_novoRegistro);

        bt_incluir_alterarRegistro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        bt_incluir_alterarRegistro.setText("Incluir Registro");
        bt_incluir_alterarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_incluir_alterarRegistroActionPerformed(evt);
            }
        });
        jMenu4.add(bt_incluir_alterarRegistro);

        jMenuBar1.add(jMenu4);

        jMenuArquivo.setText("Arquivo");

        jMenu3.setText("Cadastro");

        bt_cadastroGrupoDeProdutos.setText("Grupo de Produtos");
        bt_cadastroGrupoDeProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastroGrupoDeProdutosActionPerformed(evt);
            }
        });
        jMenu3.add(bt_cadastroGrupoDeProdutos);

        bt_cadastroSubGrupoDeProdutos.setText("Sub Grupo de Produtos");
        bt_cadastroSubGrupoDeProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastroSubGrupoDeProdutosActionPerformed(evt);
            }
        });
        jMenu3.add(bt_cadastroSubGrupoDeProdutos);

        bt_cadastroDeFornecedores.setText("Fornecedores");
        bt_cadastroDeFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastroDeFornecedoresActionPerformed(evt);
            }
        });
        jMenu3.add(bt_cadastroDeFornecedores);

        bt_cadastroDeFabricantes.setText("Fabricantes");
        bt_cadastroDeFabricantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastroDeFabricantesActionPerformed(evt);
            }
        });
        jMenu3.add(bt_cadastroDeFabricantes);

        jMenuArquivo.add(jMenu3);
        jMenuArquivo.add(jSeparator1);

        bt_sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });
        jMenuArquivo.add(bt_sair);

        jMenuBar1.add(jMenuArquivo);

        jMenu1.setText("Relatórios");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText(":: Relatório geral de produtos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem6.setText("Imprimir Etiqueta");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Etiquetas");

        jMenuItem2.setText("Imprimir código de barras");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_incluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_alterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_imprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_pesquisaProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_primeiro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_anterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_proximo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_ultimo)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_imprimir)
                    .addComponent(bt_alterar)
                    .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_ultimo)
                    .addComponent(bt_primeiro)
                    .addComponent(bt_pesquisaProduto)
                    .addComponent(bt_anterior)
                    .addComponent(bt_proximo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_alterar, bt_anterior, bt_imprimir, bt_incluir, bt_pesquisaProduto, bt_primeiro, bt_proximo, bt_ultimo});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel1, jPanel3});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        IncluirRegistro();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void txt_dataCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dataCadastroActionPerformed

    }//GEN-LAST:event_txt_dataCadastroActionPerformed
    
    public void PegaValores(){
        fatal = "N";
        bp.idEmpresa                = parametrosNS.be.IdEmpresa;
        bp.codigoGrupo              = parametrosNS.bge.CodigoGrupo;
        bp.codigoEmpresa            = parametrosNS.be.CodigoEmpresa;
        bp.codigoProduto            = Integer.parseInt(txt_codigoProduto.getText());
        if(check_Ativo.isSelected() == false){
            bp.produtoInativo = 0;
        }else{
            bp.produtoInativo = 1;
        }
        if(txt_codigoFornecedor.getText().replace(" ", "").equals("")){
            bp.codigoFornecedor = 0;
        }else{
            bp.codigoFornecedor = Integer.parseInt(txt_codigoFornecedor.getText());
        }
        bp.dataCadastro             = invdata.inverterData(txt_dataCadastro.getText(), 2);
        bp.descricaoProduto         = txt_descricaoProduto.getText();
        if(bp.descricaoProduto.equals("")){
            mensagem = "Descrição inválida!";
            new MostraMensagem(mensagem);
            fatal = "S";
            return;
        }
        bp.codigoDeBarras           = txt_codigoDeBarras.getText();
        bp.dataDeVencimento         = txt_dataDeVencimento.getText();
        bp.dataDeVencimento         = bp.dataDeVencimento.replace(" ", "");
        bp.dataDeVencimento         = bp.dataDeVencimento.replace("/", "");
        if(!bp.dataDeVencimento.equals("")){
            bp.dataDeVencimento = "'" + invdata.inverterData(bp.dataDeVencimento, 2) + "'";
        }else{
            bp.dataDeVencimento = null;
        }
        if(txt_valorDeCompra.getText().equals("")){
            bp.valorDeCompra    = 0;
        }else{
            bp.valorDeCompra    = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_valorDeCompra.getText(), 1));
        }
        if(txt_valorDeVenda.getText().equals("")){
            mensagem = "Valor de Venda inválido!";
            new MostraMensagem(mensagem);
            fatal = "S";
            return;
        }
        bp.valorDeVenda         = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_valorDeVenda.getText(), 1));
        if(combo_tipoDeProduto.getSelectedIndex() == 0){
            mensagem = "Tipo de produto inválido!";
            new MostraMensagem(mensagem);
            fatal = "S";
            return;
        }
        bp.tipoDeProduto            = String.valueOf(combo_tipoDeProduto.getSelectedItem());
        if(combo_grupoProduto.getSelectedIndex() == 0){
            bp.codigoGrupoProduto = 0;
        }else{
            bp.codigoGrupoProduto = Integer.parseInt(String.valueOf(combo_grupoProduto.getSelectedItem()).substring(0, 3));
        }
        if(combo_subGrupoProduto.getSelectedIndex() == 0){
            bp.codigoSubGrupoProduto = 0;
        }else{
            bp.codigoSubGrupoProduto = Integer.parseInt(String.valueOf(combo_subGrupoProduto.getSelectedItem()).substring(0, 3));
        }
        if(txt_codigoFabricante.getText().replace(" ", "").equals("")){
            bp.codigoFabricante = 0;
        }else{
            bp.codigoFabricante = Integer.parseInt(fc.FormataCampo(txt_codigoFabricante.getText(), 6, 0));
        }
        if(txt_quantidadeMinima.getText().replace(" ", "").equals("")){
            bp.quantidadeMinima = 0;
        }else{
            bp.quantidadeMinima = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_quantidadeMinima.getText(), 1));
        }
        if(txt_quantidadeIdeal.getText().replace(" ", "").equals("")){
            bp.quantidadeIdeal  = 0;
        }else{
            bp.quantidadeIdeal  = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_quantidadeIdeal.getText(), 1));
        }
        if(txt_quantidadeAtual.getText().replace(" ", "").equals("")){
            bp.quantidadeAtual  = 0;
        }else{
            bp.quantidadeAtual  = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_quantidadeAtual.getText(), 1));
        }
        bp.observacoes          = txt_observacoes.getText();
        
        bp.dataAlterou          = invdata.inverterData(cdh.CapturarData(), 2);
        bp.horaAlterou          = cdh.CapturaHora();
        bp.usuarioAlterou       = parametrosNS.bu.codigoUsuario;
        bp.idEmpresaAlterou     = parametrosNS.be.idEmpresa;
        bp.codigoGrupoAlterou   = parametrosNS.bge.codigoGrupo;
        bp.codigoEmpresaAlterou = parametrosNS.be.codigoEmpresa;
        
        try{
            BuffImg     = ImageIO.read(new File(pastaImagem));
            BytesImg    = new ByteArrayOutputStream();
            
            ImageIO.write((BufferedImage)BuffImg, "jpg", BytesImg);
            BytesImg.flush();
            
            bp.imagemProduto    = BytesImg.toByteArray();
            BytesImg.close();
            bp.setImagemProduto(bp.imagemProduto);
        }catch(Exception erro){
            
        }
    }

    public void ReiniciaTela() {
        ReiniciaCampos();
        bt_incluir  .setEnabled(false);
        bt_alterar  .setEnabled(false);
        bt_imprimir .setEnabled(false);
    }
    
    private void ReiniciaCampos(){
        bp = new BeanProdutos();
        txt_codigoProduto   .setText("");
        check_Ativo         .setSelected(false);
        txt_codigoFornecedor.setText("");
        label_nomeFornecedor.setText("");
        txt_dataCadastro    .setText(cdh.CapturarData());
        txt_descricaoProduto.setText("");
        txt_codigoDeBarras  .setText("");
        txt_dataDeVencimento.setText("");
        txt_valorDeVenda    .setText("");
        txt_valorDeCompra   .setText("");
        combo_tipoDeProduto .setSelectedIndex(1);
        txt_codigoFabricante.setText("");
        label_fabricante    .setText("");
        if(combo_grupoProduto      .getItemCount() > 0){combo_grupoProduto         .setSelectedIndex(0);}
        if(combo_subGrupoProduto   .getItemCount() > 0){combo_subGrupoProduto      .setSelectedIndex(0);}
        txt_quantidadeMinima.setText("");
        txt_quantidadeIdeal .setText("");
        txt_quantidadeAtual .setText("");
        txt_observacoes     .setText("");
        label_imagemProd    .setIcon(null);
        label_alteracao     .setText("");
    }
    
    private void HabilitaCampos(boolean Habilita){
        check_Ativo                 .setEnabled     (Habilita);
//        check_Ativo                 .setFocusable   (Habilita);
        txt_codigoFornecedor        .setEditable    (Habilita);
        txt_codigoFornecedor        .setFocusable   (Habilita);
        bt_pesquisaFornecedor       .setEnabled     (Habilita);
        bt_pesquisaFornecedor       .setFocusable   (Habilita);
        txt_descricaoProduto        .setEditable    (Habilita);
        txt_descricaoProduto        .setFocusable   (Habilita);
        txt_codigoDeBarras          .setEditable    (Habilita);
        txt_codigoDeBarras          .setFocusable   (Habilita);
        txt_dataDeVencimento        .setEditable    (Habilita);
        txt_dataDeVencimento        .setFocusable   (Habilita);
        txt_valorDeCompra           .setEditable    (Habilita);
        txt_valorDeCompra           .setFocusable   (Habilita);
        txt_valorDeVenda            .setEditable    (Habilita);
        txt_valorDeVenda            .setFocusable   (Habilita);
        combo_tipoDeProduto         .setEnabled     (Habilita);
        combo_tipoDeProduto         .setFocusable   (Habilita);
        combo_grupoProduto          .setEnabled     (Habilita);
        combo_grupoProduto          .setFocusable   (Habilita);
        combo_subGrupoProduto       .setEnabled     (Habilita);
        combo_subGrupoProduto       .setFocusable   (Habilita);
        txt_codigoFabricante        .setEditable    (Habilita);
        txt_codigoFabricante        .setFocusable   (Habilita);
        bt_pesquisaFabricante       .setEnabled     (Habilita);
        bt_pesquisaFabricante       .setFocusable   (Habilita);
        txt_quantidadeMinima        .setEditable    (Habilita);
        txt_quantidadeMinima        .setFocusable   (Habilita);
        txt_quantidadeIdeal         .setEditable    (Habilita);
        txt_quantidadeIdeal         .setFocusable   (Habilita);
        txt_quantidadeAtual         .setEditable    (Habilita);
        txt_quantidadeAtual         .setFocusable   (Habilita);
        txt_observacoes             .setEditable    (Habilita);
        txt_observacoes             .setFocusable   (Habilita);
        bt_carregarImagem           .setEnabled     (Habilita);
        bt_carregarImagem           .setFocusable   (Habilita);
    }
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            String arquivoJasper = null;
            String c = null;
            JasperPrint rel = null;
            // Connection con = fabricaConexao.tConexao();

            HashMap map = new HashMap();

//            map.put("dataInicial", dataInicial);
//            map.put("dataFinal", "" + dataFinal);
//
//            map.put("i", new ajustarData().inverterData(dataInicial, 1));
//            map.put("f", new ajustarData().inverterData(dataFinal, 1));
//              map.put("nomeEmpresa", be.NOMEEMPRESA);
//              map.put("nomeFantasia", be.NOMEFANTASIA);
              map.put("cnpj", "18.464.581/0001-88"); // por enquanto
              //map.put("nomeEmpresa", NOMEEMPRESA);
              
            arquivoJasper = "Relatorios/relatorioProdutos.jasper";

            try {
                rel = JasperFillManager.fillReport(arquivoJasper, map, parametrosNS.con);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "visualizar relatorioClientes" + e);
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            //JasperFillManager.fillReport(arquivoJasper, map, con);
            JasperViewer.viewReport(rel, false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "O erro foi no solicitarRelatorioClientes: " + e);
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HabilitaCampos(false);
        sql = "select * from tb_grupoproduto where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        PegaGruposProdutos("S");
        if(parametrosNS.bu.nivelUsuario  < 4 | somostra.equals("S")){
            jMenuArquivo.setVisible(false);
        }
        
        if(bp.codigoProduto != 0){
            txt_codigoProduto       .setText(String.valueOf(bp.codigoProduto));
            PegouCodigoProduto = "N";
            PegaProduto();
        }
        if(somostra.equals("SN")){
            bt_pesquisaProduto      .setVisible (false);
        }
        if(somostra.equals("S")){
            bt_novo                 .setEnabled (false);
            txt_codigoProduto       .setEditable(false);
            txt_codigoFornecedor    .setEditable(false);
            bt_incluir              .setVisible (false);
            bt_alterar              .setVisible (false);
            bt_carregarImagem       .setEnabled (false);
            bt_pesquisaProduto      .setVisible (false);
            bt_pesquisaFornecedor   .setEnabled (false);
            bt_pesquisaFabricante   .setEnabled (false);
            combo_tipoDeProduto     .setEnabled (false);
            combo_grupoProduto      .setEnabled (false);
            combo_subGrupoProduto   .setEnabled (false);
            bt_primeiro             .setVisible (false);
            bt_anterior             .setVisible (false);
            bt_proximo              .setVisible (false);
            bt_ultimo               .setVisible (false);
        }
        
    }//GEN-LAST:event_formWindowOpened
    
    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        AlterarRegistro();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        mostraMensagem = "S";
        NovoRegistro();
    }//GEN-LAST:event_bt_novoActionPerformed
    
    private void NovoRegistro(){
        check_Ativo.grabFocus();
        ReiniciaCampos();
        HabilitaCampos(true);
        
        operacao = "I";
        HabilitaBotoes();
        
        bp.codigoProduto = PegProReg.PegaProximoRegistro("tb_produtos", "codigoProduto", "");
        txt_codigoDeBarras.setText(String.valueOf(bp.codigoProduto));
        txt_codigoProduto.setText(fc.FormataCampo(String.valueOf(bp.codigoProduto), 6, 0));
    }
    
    private void bt_pesquisaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaProdutoActionPerformed
        abriuProduto = 1;
        parametros.clear();
        parametros.add("S");
        parametros.add("Codigo");
        ProCon = new ProdutosConsulta(parametros);
        ProCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaProdutoActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
        if(abriuProduto == 0){
            AbriuFornecedor();
            return;
        }
        retorno = ProCon.getRetorno();
        if(retorno.equals("")){
            return;
        }
        txt_codigoProduto.setText(retorno);
        abriuProduto = 0;
        PegouCodigoProduto = "N";
        PegaProduto();
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbriuFornecedor(){
        if(abriuFornecedor == 0){
            AbriuFabricante();
            return;
        }
        abriuFornecedor = 0;
        retorno = ForCon.getRetorno();
        if(retorno.equals("")){
            return;
        }
        txt_codigoFornecedor.setText(retorno);
        PegaFornecedor();
        label_nomeFornecedor.setText(bfor.nome);
    }
    
    private void AbriuFabricante(){
        if(abriuFabricante == 0){
            AbriuGrupoProduto();
            return;
        }
        abriuFabricante = 0;
        retorno = FabCon.getRetorno();
        if(retorno.equals("")){
            return;
        }
        txt_codigoFabricante.setText(retorno);
        PegaFabricante();
        label_fabricante.setText(bfab.nomeFabricante);
    }
    
    private void AbriuGrupoProduto(){
        if(abriuGrupoProduto == 0){
            return;
        }
        txt_codigoProduto.grabFocus();
        sql = "select * from tb_grupoproduto where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        PegaGruposProdutos("S");
    }
    
    private void txt_dataCadastroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataCadastroKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        txt_valorDeVenda.grabFocus();
    }//GEN-LAST:event_txt_dataCadastroKeyPressed

    private void bt_incluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bt_incluirKeyPressed
        
    }//GEN-LAST:event_bt_incluirKeyPressed

    private void bt_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_anteriorActionPerformed
        bp.codigoProduto = Integer.parseInt(fc.FormataCampo(txt_codigoProduto.getText(), 6, 0));
        if(bp.codigoProduto == 1) {
            mensagem = "Não existe registro anterior!!";
            new MostraMensagem(mensagem);
            return;
        }
        if(bp.codigoProduto == 0){
            bp.codigoProduto = 2;
        }
        if(bp.codigoProduto <= 999999){
            bp.codigoProduto = bp.codigoProduto - 1;
        }
        if(bp.codigoProduto > 999999){
            bp.codigoProduto = 999999;
        }
        txt_codigoProduto.setText(String.valueOf(bp.codigoProduto));
        PegaProduto();
        if(fatal.equals("S")){
            bp.codigoProduto = bp.codigoProduto + 1;
            txt_codigoProduto.setText(fc.FormataCampo(String.valueOf(bp.codigoProduto), 6, 0));
            return;
        }
    }//GEN-LAST:event_bt_anteriorActionPerformed

    private void bt_proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_proximoActionPerformed
        bp.codigoProduto = Integer.parseInt(fc.FormataCampo(txt_codigoProduto.getText(), 6, 0));
        if(bp.codigoProduto < 999999){
            bp.codigoProduto = bp.codigoProduto + 1;
        }
        if(bp.codigoProduto >= 999999){
            bp.codigoProduto = 999999;
        }
        txt_codigoProduto.setText(String.valueOf(bp.codigoProduto));
        PegaProduto();
        if(fatal.equals("S")){
            bp.codigoProduto = bp.codigoProduto - 1;
            txt_codigoProduto.setText(fc.FormataCampo(String.valueOf(bp.codigoProduto), 6, 0));
            return;
        }
    }//GEN-LAST:event_bt_proximoActionPerformed

    private void bt_primeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_primeiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_primeiroActionPerformed

    private void bt_ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ultimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_ultimoActionPerformed

    private void txt_quantidadeIdealFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantidadeIdealFocusLost
        txt_quantidadeIdeal.setText(fc.FormataCampo(txt_quantidadeIdeal.getText(), 6, 0));
    }//GEN-LAST:event_txt_quantidadeIdealFocusLost

    private void txt_quantidadeIdealFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantidadeIdealFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantidadeIdealFocusGained

    private void combo_subGrupoProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_subGrupoProdutoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_subGrupoProdutoKeyPressed

    private void txt_quantidadeMinimaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantidadeMinimaFocusLost
        txt_quantidadeMinima.setText(fc.FormataCampo(txt_quantidadeMinima.getText(), 6, 0));
    }//GEN-LAST:event_txt_quantidadeMinimaFocusLost

    private void txt_quantidadeMinimaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantidadeMinimaFocusGained
        txt_quantidadeMinima.setSelectionStart(0);
        txt_quantidadeMinima.setSelectionEnd(txt_quantidadeMinima.getText().length());
    }//GEN-LAST:event_txt_quantidadeMinimaFocusGained

    private void txt_quantidadeAtualFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantidadeAtualFocusLost
        txt_quantidadeAtual.setText(fc.FormataCampo(txt_quantidadeAtual.getText(), 6, 0));
    }//GEN-LAST:event_txt_quantidadeAtualFocusLost

    private void txt_quantidadeAtualFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantidadeAtualFocusGained
        txt_quantidadeAtual.setSelectionStart(0);
        txt_quantidadeAtual.setSelectionEnd(txt_quantidadeAtual.getText().length());
    }//GEN-LAST:event_txt_quantidadeAtualFocusGained

    private void txt_quantidadeAtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quantidadeAtualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantidadeAtualActionPerformed

    private void txt_valorDeCompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valorDeCompraKeyReleased
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        txt_valorDeVenda.grabFocus();
    }//GEN-LAST:event_txt_valorDeCompraKeyReleased

    private void txt_valorDeCompraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorDeCompraFocusLost
        if(txt_valorDeCompra.getText().equals("")){
            return;
        }
        txt_valorDeCompra.setText(TransStrDou.TransformaValorStringeDouble(txt_valorDeCompra.getText(), 0));
    }//GEN-LAST:event_txt_valorDeCompraFocusLost

    private void txt_valorDeCompraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorDeCompraFocusGained
        if(txt_valorDeCompra.getText().equals("")){
            return;
        }
        txt_valorDeCompra.setText(TransStrDou.TransformaValorStringeDouble(txt_valorDeCompra.getText(), 1));
    }//GEN-LAST:event_txt_valorDeCompraFocusGained

    private void txt_valorDeCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_valorDeCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_valorDeCompraActionPerformed

    private void txt_valorDeVendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valorDeVendaKeyReleased
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        combo_tipoDeProduto.grabFocus();
    }//GEN-LAST:event_txt_valorDeVendaKeyReleased

    private void txt_valorDeVendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valorDeVendaKeyPressed
        
    }//GEN-LAST:event_txt_valorDeVendaKeyPressed

    private void txt_valorDeVendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorDeVendaFocusLost
        if(txt_valorDeVenda.getText().equals("")){
            return;
        }
        txt_valorDeVenda.setText(TransStrDou.TransformaValorStringeDouble(txt_valorDeVenda.getText(), 0));
    }//GEN-LAST:event_txt_valorDeVendaFocusLost

    private void txt_valorDeVendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorDeVendaFocusGained
        if(txt_valorDeVenda.getText().equals("")){
            return;
        }
        txt_valorDeVenda.setText(TransStrDou.TransformaValorStringeDouble(txt_valorDeVenda.getText(), 1));
    }//GEN-LAST:event_txt_valorDeVendaFocusGained

    private void txt_valorDeVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_valorDeVendaActionPerformed
        // TODO add your handling code here:ValorUnitario
    }//GEN-LAST:event_txt_valorDeVendaActionPerformed

    private void combo_tipoDeProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_tipoDeProdutoKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        combo_grupoProduto.grabFocus();
    }//GEN-LAST:event_combo_tipoDeProdutoKeyPressed

    private void txt_dataDeVencimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dataDeVencimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dataDeVencimentoActionPerformed

    private void combo_grupoProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_grupoProdutoKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        bt_incluir.grabFocus();
    }//GEN-LAST:event_combo_grupoProdutoKeyPressed

    private void txt_codigoDeBarrasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoDeBarrasKeyPressed
        if(evt.getSource() == txt_codigoDeBarras){
            if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                txt_dataDeVencimento.grabFocus();
            }
        }
    }//GEN-LAST:event_txt_codigoDeBarrasKeyPressed

    private void txt_descricaoProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descricaoProdutoKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        txt_codigoDeBarras.grabFocus();
    }//GEN-LAST:event_txt_descricaoProdutoKeyPressed

    private void txt_codigoFornecedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoFornecedorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoFornecedorKeyPressed

    private void txt_codigoFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoFornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoFornecedorActionPerformed

    private void txt_codigoDeBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoDeBarrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoDeBarrasActionPerformed

    private void txt_codigoFornecedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFornecedorFocusLost
        if(txt_codigoProduto.isEditable()== false){
            return;
        }
        if(txt_codigoFornecedor.getText().replace(" ", "").equals("")){
            return;
        }
        PegaFornecedor();
        label_nomeFornecedor.setText(bfor.nome);
    }//GEN-LAST:event_txt_codigoFornecedorFocusLost

    private void txt_codigoFabricanteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFabricanteFocusLost
        if(txt_codigoFabricante.getText().replace(" ", "").equals("")){
            return;
        }
        PegaFabricante();
        label_fabricante.setText(bfab.nomeFabricante);
    }//GEN-LAST:event_txt_codigoFabricanteFocusLost

    private void txt_codigoFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoFabricanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoFabricanteActionPerformed

    private void txt_codigoFabricanteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoFabricanteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoFabricanteKeyPressed

    private void bt_carregarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_carregarImagemActionPerformed
        if(operacao.equals("")){
            return;
        }
        seletor = new JFileChooser();
        seletor.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = seletor.showSaveDialog(null); 
        if(i == 1){
            return;
        }
        arquivoPasta = seletor.getSelectedFile();
        if(arquivoPasta.getPath().equals("")){
            return;
        }
        pastaImagem = arquivoPasta.getPath();
        CarregaImagem();
    }//GEN-LAST:event_bt_carregarImagemActionPerformed

    public void CarregaImagem(){
        imgIcon = null;
        imgIcon = new ImageIcon(pastaImagem);
        img     = imgIcon.getImage();
        img     = img.getScaledInstance(label_imagemProd.getWidth() - 1, label_imagemProd.getHeight() - 1, img.SCALE_DEFAULT);
        label_imagemProd.setIcon(new ImageIcon(img));
    }
    
    private void combo_grupoProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo_grupoProdutoFocusLost
        
    }//GEN-LAST:event_combo_grupoProdutoFocusLost

    private void txt_quantidadeMinimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quantidadeMinimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantidadeMinimaActionPerformed

    private void combo_grupoProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo_grupoProdutoFocusGained
        combo_subGrupoProduto.removeAllItems();
        combo_subGrupoProduto.addItem("----------");
    }//GEN-LAST:event_combo_grupoProdutoFocusGained

    private void txt_codigoFornecedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFornecedorFocusGained
        if(txt_codigoProduto.isEditable()== false){
            return;
        }
        txt_codigoFornecedor.setText("");
        label_nomeFornecedor.setText("");
    }//GEN-LAST:event_txt_codigoFornecedorFocusGained

    private void combo_tipoDeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_tipoDeProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_tipoDeProdutoActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        bp.codigoDeBarras   = txt_codigoDeBarras.getText();
        bp.descricaoProduto = txt_descricaoProduto.getText();
        dadosBarras.clear();
        dadosBarras.add(bp.descricaoProduto);
        dadosBarras.add(bp.codigoDeBarras);
        GeraCodigoBarras dcb = new GeraCodigoBarras(dadosBarras);
        dcb.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void bt_pesquisaFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaFabricanteActionPerformed
        if(FabCon != null)if(FabCon.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        abriuFabricante = 1;
        FabCon = new FabricanteConsulta("N");
        FabCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaFabricanteActionPerformed

    private void bt_pesquisaFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaFornecedorActionPerformed
        if(ForCon != null)if(ForCon.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        abriuFornecedor = 1;
        ForCon = new FornecedorConsulta("N");
        ForCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaFornecedorActionPerformed

    private void txt_codigoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoProdutoActionPerformed

    private void txt_codigoProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoProdutoFocusLost
        if(txt_codigoProduto.getText().replace(" ", "").equals("")){
            return;
        }
        if(somostra.equals("S")){
            return;
        }
        PegaProduto();
    }//GEN-LAST:event_txt_codigoProdutoFocusLost

    private void txt_codigoProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoProdutoFocusGained
        if(somostra.equals("S")){
            return;
        }
        if(abriuGrupoProduto == 1){
            return;
        }
        txt_codigoProduto.setText("");
        operacao = "";
        ReiniciaTela();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoProdutoFocusGained

    private void combo_grupoProdutoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_grupoProdutoItemStateChanged
        if(combo_grupoProduto.isEnabled() == false){
            return;
        }
        if(combo_grupoProduto.getSelectedIndex() == 0){
            combo_subGrupoProduto.removeAllItems();
            combo_subGrupoProduto.addItem("----------");
            combo_subGrupoProduto.setSelectedIndex(0);
            return;
        }
        bgp.codigoGrupoProduto  = Integer.parseInt(String.valueOf(combo_grupoProduto.getSelectedItem()).substring(0, 3));
        sql = "select * from tb_grupoproduto where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoGrupoProduto = " + bgp.codigoGrupoProduto + " order by codigoGrupoProduto asc;";
        PegaGruposProdutos("N");
    }//GEN-LAST:event_combo_grupoProdutoItemStateChanged

    private void bt_cadastroGrupoDeProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastroGrupoDeProdutosActionPerformed
        if(CadGruPro != null)if(CadGruPro.isVisible()){
            mensagem = "Tela já Aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        abriuGrupoProduto = 1;
        CadGruPro = new GrupoProdutoCadastro("N", 0);
        CadGruPro.setVisible(true);
    }//GEN-LAST:event_bt_cadastroGrupoDeProdutosActionPerformed

    private void bt_cadastroSubGrupoDeProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastroSubGrupoDeProdutosActionPerformed
        if(CadSubGruPro != null)if(CadSubGruPro.isVisible()){
            mensagem = "Tela já Aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        CadSubGruPro = new SubGrupoProdutoCadastro("N", 0, 0);
        CadSubGruPro.setVisible(true);
    }//GEN-LAST:event_bt_cadastroSubGrupoDeProdutosActionPerformed

    private void bt_cadastroDeFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastroDeFornecedoresActionPerformed
        if(ForCad != null)if(ForCad.isVisible()){
            mensagem = "Tela já Aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        ForCad = new FornecedorCadastro("SN", 0);
        ForCad.setVisible(true);
    }//GEN-LAST:event_bt_cadastroDeFornecedoresActionPerformed

    private void bt_cadastroDeFabricantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastroDeFabricantesActionPerformed
        if(FabCad != null)if(FabCad.isVisible()){
            mensagem = "Tela já Aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        FabCad = new FabricanteCadastro("SN", 0);
        FabCad.setVisible(true);
    }//GEN-LAST:event_bt_cadastroDeFabricantesActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(ProCon   != null)ProCon.dispose();
        if(ForCon   != null)ForCon.dispose();
        if(FabCon   != null)FabCon.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void bt_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimirActionPerformed
        if(txt_codigoProduto.getText().replace(" ", "").equals("")){
            return;
        }
        ImprimirProduto();
    }//GEN-LAST:event_bt_imprimirActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        GeradorEtiquetas ger = new GeradorEtiquetas(txt_descricaoProduto.getText(), txt_codigoDeBarras.getText(), bp.valorDeVenda, txt_quantidadeAtual.getText());
        ger.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txt_descricaoProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descricaoProdutoKeyReleased
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        txt_codigoDeBarras.grabFocus();
    }//GEN-LAST:event_txt_descricaoProdutoKeyReleased

    private void txt_descricaoProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_descricaoProdutoFocusLost
        txt_descricaoProduto.setText(txt_descricaoProduto.getText().toUpperCase());
    }//GEN-LAST:event_txt_descricaoProdutoFocusLost

    private void txt_observacoesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_observacoesFocusLost
        txt_observacoes.setText(txt_observacoes.getText().toUpperCase());
    }//GEN-LAST:event_txt_observacoesFocusLost

    private void txt_codigoProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoProdutoKeyReleased
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        check_Ativo.grabFocus();
    }//GEN-LAST:event_txt_codigoProdutoKeyReleased

    private void check_AtivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_check_AtivoKeyReleased
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        txt_codigoFornecedor.grabFocus();
    }//GEN-LAST:event_check_AtivoKeyReleased

    private void txt_codigoFornecedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoFornecedorKeyReleased
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        txt_descricaoProduto.grabFocus();
    }//GEN-LAST:event_txt_codigoFornecedorKeyReleased

    private void txt_codigoDeBarrasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoDeBarrasKeyReleased
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        txt_dataDeVencimento.grabFocus();
    }//GEN-LAST:event_txt_codigoDeBarrasKeyReleased

    private void txt_dataDeVencimentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataDeVencimentoKeyReleased
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        txt_valorDeCompra.grabFocus();
    }//GEN-LAST:event_txt_dataDeVencimentoKeyReleased

    private void combo_tipoDeProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_tipoDeProdutoKeyReleased
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        combo_grupoProduto.grabFocus();
    }//GEN-LAST:event_combo_tipoDeProdutoKeyReleased

    private void combo_grupoProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_grupoProdutoKeyReleased
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        combo_subGrupoProduto.grabFocus();
    }//GEN-LAST:event_combo_grupoProdutoKeyReleased

    private void combo_subGrupoProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_subGrupoProdutoKeyReleased
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        txt_codigoFabricante.grabFocus();
    }//GEN-LAST:event_combo_subGrupoProdutoKeyReleased

    private void txt_codigoFabricanteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoFabricanteKeyReleased
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        txt_quantidadeMinima.grabFocus();
    }//GEN-LAST:event_txt_codigoFabricanteKeyReleased

    private void txt_quantidadeMinimaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_quantidadeMinimaKeyReleased
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        txt_quantidadeIdeal.grabFocus();
    }//GEN-LAST:event_txt_quantidadeMinimaKeyReleased

    private void txt_quantidadeIdealKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_quantidadeIdealKeyReleased
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        txt_quantidadeAtual.grabFocus();
    }//GEN-LAST:event_txt_quantidadeIdealKeyReleased

    private void txt_quantidadeAtualKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_quantidadeAtualKeyReleased
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        txt_observacoes.grabFocus();
    }//GEN-LAST:event_txt_quantidadeAtualKeyReleased

    private void txt_observacoesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_observacoesKeyReleased
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        if(operacao.equals("I")){
            bt_incluir.grabFocus();
        }else{
            bt_alterar.grabFocus();
        }
    }//GEN-LAST:event_txt_observacoesKeyReleased

    private void bt_novoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoRegistroActionPerformed
        mostraMensagem = "N";
        NovoRegistro();
    }//GEN-LAST:event_bt_novoRegistroActionPerformed

    private void bt_incluir_alterarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluir_alterarRegistroActionPerformed
        if(operacao.equals("I")){
            IncluirRegistro();
        }else{
            AlterarRegistro();
        }
    }//GEN-LAST:event_bt_incluir_alterarRegistroActionPerformed

    private void txt_codigoProdutoHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_txt_codigoProdutoHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoProdutoHierarchyChanged
    
    private void PegaProduto(){
        fatal = "N";
        txt_codigoProduto.setText(fc.FormataCampo(txt_codigoProduto.getText(), 6, 0));
        bp.codigoProduto = Integer.parseInt(txt_codigoProduto.getText());
        if(bp.codigoProduto == 0){
            return;
        }
        sql = "select * from tb_produtos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoProduto = " + bp.codigoProduto + ";";
        dadosProdutos.clear();
        dadosProdutos = parametrosNS.dao.Consulta(sql);
        if(dadosProdutos.isEmpty()){
            if(mostraMensagem.equals("N")){
                return;
            }
            mensagem = "Produto " + bp.codigoProduto + " não encontrado, para cadastrar pressione NOVO!";
            new MostraMensagem(mensagem);
            fatal = "S";
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        HabilitaCampos(true);
        PegaDadosProduto();
    }
    
    public void PegaDadosProduto(){
        bp = new BeanProdutos();
        if(dadosProdutos.get(0).get(0) != null){
            bp.idProdutos               = Integer.parseInt(  String.valueOf(dadosProdutos.get(0).get(0)));
        }
        if(dadosProdutos.get(0).get(1) != null){
            bp.idEmpresa                = Integer.parseInt(  String.valueOf(dadosProdutos.get(0).get(1)));
        }
        if(dadosProdutos.get(0).get(2) != null){
            bp.codigoGrupo              = Integer.parseInt(  String.valueOf(dadosProdutos.get(0).get(2)));
        }
        if(dadosProdutos.get(0).get(3) != null){
            bp.codigoEmpresa            = Integer.parseInt(  String.valueOf(dadosProdutos.get(0).get(3)));
        }
        if(dadosProdutos.get(0).get(4) != null){
            bp.codigoProduto            = Integer.parseInt(  String.valueOf(dadosProdutos.get(0).get(4)));
        }
        if(dadosProdutos.get(0).get(5) != null){
            bp.produtoInativo           = Integer.parseInt(  String.valueOf(dadosProdutos.get(0).get(5)));
        }
        if(dadosProdutos.get(0).get(6) != null){
            bp.codigoFornecedor         = Integer.parseInt(  String.valueOf(dadosProdutos.get(0).get(6)));
        }
        if(dadosProdutos.get(0).get(7) != null){
            bp.dataCadastro             =                    String.valueOf(dadosProdutos.get(0).get(7));
        }
        if(dadosProdutos.get(0).get(8) != null){
            bp.descricaoProduto         =                    String.valueOf(dadosProdutos.get(0).get(8));
        }
        if(dadosProdutos.get(0).get(9) != null){
            bp.codigoDeBarras           =                    String.valueOf(dadosProdutos.get(0).get(9));
        }
        if(dadosProdutos.get(0).get(10) != null){
            bp.dataDeVencimento         =                    String.valueOf(dadosProdutos.get(0).get(10));
        }
        if(dadosProdutos.get(0).get(11) != null){
            bp.valorDeCompra            = Double.parseDouble(String.valueOf(dadosProdutos.get(0).get(11)));
        }
        if(dadosProdutos.get(0).get(12) != null){
            bp.valorDeVenda             = Double.parseDouble(String.valueOf(dadosProdutos.get(0).get(12)));
        }
        if(dadosProdutos.get(0).get(13) != null){
            bp.tipoDeProduto            =                    String.valueOf(dadosProdutos.get(0).get(13));
        }
        if(dadosProdutos.get(0).get(14) != null){
            bp.codigoFabricante         = Integer.parseInt(  String.valueOf(dadosProdutos.get(0).get(14)));
        }
        if(dadosProdutos.get(0).get(15) != null){
            bp.codigoGrupoProduto       = Integer.parseInt(  String.valueOf(dadosProdutos.get(0).get(15)));
        }
        if(dadosProdutos.get(0).get(16) != null){
            bp.codigoSubGrupoProduto    = Integer.parseInt(  String.valueOf(dadosProdutos.get(0).get(16)));
        }
        if(dadosProdutos.get(0).get(17) != null){
            bp.quantidadeMinima         = Double.parseDouble(String.valueOf(dadosProdutos.get(0).get(17)));
        }
        if(dadosProdutos.get(0).get(18) != null){
            bp.quantidadeIdeal          = Double.parseDouble(String.valueOf(dadosProdutos.get(0).get(18)));
        }
        if(dadosProdutos.get(0).get(19) != null){
            bp.quantidadeAtual          = Double.parseDouble(String.valueOf(dadosProdutos.get(0).get(19)));
        }
        if(dadosProdutos.get(0).get(20) != null){
            bp.observacoes              =                    String.valueOf(dadosProdutos.get(0).get(20));
        }
        if(dadosProdutos.get(0).get(21) != null){
            bp.dataAlterou              =                    String.valueOf(dadosProdutos.get(0).get(21));
        }
        if(dadosProdutos.get(0).get(22) != null){
            bp.horaAlterou              =                    String.valueOf(dadosProdutos.get(0).get(22));
        }
        if(dadosProdutos.get(0).get(23) != null){
            bp.usuarioAlterou           = Integer.parseInt(  String.valueOf(dadosProdutos.get(0).get(23)));
        }
        if(dadosProdutos.get(0).get(24) != null){
            bp.idEmpresaAlterou         = Integer.parseInt(  String.valueOf(dadosProdutos.get(0).get(24)));
        }
        if(dadosProdutos.get(0).get(25) != null){
            bp.codigoGrupoAlterou       = Integer.parseInt(  String.valueOf(dadosProdutos.get(0).get(25)));
        }
        if(dadosProdutos.get(0).get(26) != null){
            bp.codigoEmpresaAlterou     = Integer.parseInt(  String.valueOf(dadosProdutos.get(0).get(26)));
        }
        
        bpd.valorDeCompra           = bp.valorDeCompra;
        bpd.valorDeVenda            = bp.valorDeVenda;
        bpd.quantidadeMinima        = bp.quantidadeMinima;
        bpd.quantidadeIdeal         = bp.quantidadeIdeal;
        bpd.quantidadeAtual         = bp.quantidadeAtual;
        if(bp.produtoInativo == 0){
            check_Ativo.setSelected(false);
        }else{
            check_Ativo.setSelected(true);
        }
        txt_codigoFornecedor.setText(String.valueOf(bp.codigoFornecedor));
        PegaFornecedor();
        label_nomeFornecedor.setText(bfor.nome);
        txt_dataCadastro.setText(invdata.inverterData(bp.dataCadastro, 1));
        txt_descricaoProduto.setText(bp.descricaoProduto);
        txt_codigoDeBarras.setText(String.valueOf(bp.codigoDeBarras));
        if(bp.dataDeVencimento != null){
            txt_dataDeVencimento.setText(invdata.inverterData(bp.dataDeVencimento, 1));
        }
        txt_valorDeCompra   .setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(bp.valorDeCompra), 0));
        txt_valorDeVenda    .setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(bp.valorDeVenda), 0));
        combo_tipoDeProduto.setSelectedItem(bp.tipoDeProduto);
        
        txt_codigoFabricante.setText(String.valueOf(bp.codigoFabricante));
        PegaFabricante();
        label_fabricante.setText(bfab.nomeFabricante);
        
        bgp.codigoGrupoProduto      = bp.codigoGrupoProduto;
        combo_grupoProduto.setSelectedIndex(bgp.codigoGrupoProduto);
        
        bsgp.idEmpresa              = bgp.idEmpresa;
        bsgp.codigoGrupo            = bgp.codigoGrupo;
        bsgp.codigoEmpresa          = bgp.codigoEmpresa;
        bsgp.codigoGrupoProduto     = bgp.codigoGrupoProduto;
        bsgp.codigoSubGrupoProduto  = bp.codigoSubGrupoProduto;
        sql = "select * from tb_subgrupoproduto where idEmpresa = " + bsgp.idEmpresa + " and codigoGrupoProduto = " + bsgp.codigoGrupoProduto + " and codigoSubGrupoProduto = " + bsgp.codigoSubGrupoProduto + ";";
        PegaSubGruposProdutos("N");
        
        txt_quantidadeMinima.setText(fc.FormataCampo(String.valueOf(bp.quantidadeMinima).substring(0, String.valueOf(bp.quantidadeMinima).length() - 2), 6, 0));
        txt_quantidadeIdeal .setText(fc.FormataCampo(String.valueOf(bp.quantidadeIdeal) .substring(0, String.valueOf(bp.quantidadeIdeal).length() - 2), 6, 0));
        txt_quantidadeAtual .setText(fc.FormataCampo(String.valueOf(bp.quantidadeAtual) .substring(0, String.valueOf(bp.quantidadeAtual).length() - 2), 6, 0));
        
        if(!bp.observacoes.equals("null")){
            txt_observacoes.setText(bp.observacoes);
        }
        
        label_alteracao.setText("");
        if(bp.usuarioAlterou != 0){
            bu.usuario      = "NS3";
            bp.dataAlterou  = invdata.inverterData(bp.dataAlterou, 1);
            if(bp.usuarioAlterou != 999){
                bu.idEmpresa        = bp.idEmpresaAlterou;
                bu.codigoGrupo      = bp.codigoGrupoAlterou;
                bu.codigoEmpresa    = bp.codigoEmpresaAlterou;
                bu.codigoUsuario    = bp.usuarioAlterou;
                PegaUsuario();
            }
            label_alteracao.setText("Ultima alteracao feita em " + bp.dataAlterou + " às " + bp.horaAlterou + " por " + bu.usuario + ".");
        }
        
        label_imagemProd.setIcon(null);
        PegaImagemProduto();
        if(bp.imagemProduto == null){
            return;
        }
        try{
            BuffImg = ImageIO.read(new ByteArrayInputStream(bp.imagemProduto));
            imgIcon = new ImageIcon(BuffImg);
            img     = imgIcon.getImage();
            img     = img.getScaledInstance(label_imagemProd.getWidth() - 5, label_imagemProd.getHeight() - 5, img.SCALE_DEFAULT);
            
            label_imagemProd.setIcon(new ImageIcon(img));
        }catch(IOException e){
            
        }
    }
    
    public void PegaImagemProduto(){
        sql = "select imagemProduto from tb_produtos where codigoGrupo = " + bp.codigoGrupo + " and codigoEmpresa = " + bp.codigoEmpresa + " and codigoProduto = " + bp.codigoProduto + ";";
        bp.imagemProduto = parametrosNS.dao.ConsultaLogotipo(sql, "imagemProduto");
    }
    
    private void PegaUsuario(){
        bu.usuario  = "----------";
        sql = "select usuario from tb_usuarios where codigoGrupo = " + bp.codigoGrupo + " and codigoEmpresa = " + bp.codigoEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
        dadosUsuario.clear();
        dadosUsuario = parametrosNS.dao.Consulta(sql);        
        if(dadosUsuario.isEmpty()){
            mensagem = "Codigo do Usuário " + bu.codigoUsuario + " não encontrado!!!";
            new MostraMensagem(mensagem);
            return;
        }
        PegaDadosUsuario();
    }
    
    private void PegaDadosUsuario(){
        for(int i = 0; i < dadosUsuario.size(); i++){
            bu.usuario              = String.valueOf(dadosUsuario.get(i).get(0));
        }
    }
    
//    private void PegaParametros(){
//        sql = "select * from tb_parametros where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
//        dadosParametros.clear();
//        dadosParametros = parametrosNS.dao.Consulta(sql);
//        if(dadosParametros.isEmpty()){
//            bt_novo.setEnabled(false);
//            operacao = "";
//            HabilitaBotoes();
//            return;
//        }
//        PegaDadosParametros();
//    }
//    
//    private void PegaDadosParametros(){
//        for(int i = 0; i < dadosParametros.size(); i++){
//            bpar.idParametros       = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(0)));
//            bpar.idEmpresa          = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(1)));
//            bpar.codigoGrupo        = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(2)));
//            bpar.codigoEmpresa      = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(3)));
//            bpar.pastaRelatorios    =                    String.valueOf(dadosParametros.get(i).get(4));
//        }
//    }
    
//    private void PegaParametrosEstoque(){
//        sql = "select * from tb_parametrosestoque where codigoGrupo = " + parametrosNS.bge.codigoGrupo + " and " + parametrosNS.be.CodigoEmpresa + ";";
//        dadosParametrosEstoque.clear();
//        dadosParametrosEstoque = parametrosNS.dao.Consulta(sql);
//        if(dadosParametrosEstoque.isEmpty())
//            return;
//        PegaDadosParametrosEstoque();
//    }
//    
//    private void PegaDadosParametrosEstoque(){
//        for(int i = 0; i < dadosParametrosEstoque.size(); i++){
//            bpare.idParametrosEstoque       = Integer.parseInt(  String.valueOf(dadosParametrosEstoque.get(i).get(0)));
//            bpare.idEmpresa                 = Integer.parseInt(  String.valueOf(dadosParametrosEstoque.get(i).get(1)));
//            bpare.codigoGrupo               = Integer.parseInt(  String.valueOf(dadosParametrosEstoque.get(i).get(2)));
//            bpare.codigoEmpresa             = Integer.parseInt(  String.valueOf(dadosParametrosEstoque.get(i).get(3)));
//        }
//    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_anterior;
    private javax.swing.JMenuItem bt_cadastroDeFabricantes;
    private javax.swing.JMenuItem bt_cadastroDeFornecedores;
    private javax.swing.JMenuItem bt_cadastroGrupoDeProdutos;
    private javax.swing.JMenuItem bt_cadastroSubGrupoDeProdutos;
    private javax.swing.JButton bt_carregarImagem;
    private javax.swing.JButton bt_imprimir;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JMenuItem bt_incluir_alterarRegistro;
    private javax.swing.JButton bt_novo;
    private javax.swing.JMenuItem bt_novoRegistro;
    private javax.swing.JButton bt_pesquisaFabricante;
    private javax.swing.JButton bt_pesquisaFornecedor;
    private javax.swing.JButton bt_pesquisaProduto;
    private javax.swing.JButton bt_primeiro;
    private javax.swing.JButton bt_proximo;
    private javax.swing.JMenuItem bt_sair;
    private javax.swing.JButton bt_ultimo;
    private javax.swing.JCheckBox check_Ativo;
    private javax.swing.JComboBox combo_grupoProduto;
    private javax.swing.JComboBox combo_subGrupoProduto;
    private javax.swing.JComboBox combo_tipoDeProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenuArquivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel label_alteracao;
    private javax.swing.JLabel label_fabricante;
    private javax.swing.JLabel label_imagemProd;
    private javax.swing.JLabel label_nomeFornecedor;
    private javax.swing.JTextField txt_codigoDeBarras;
    private javax.swing.JFormattedTextField txt_codigoFabricante;
    private javax.swing.JFormattedTextField txt_codigoFornecedor;
    private javax.swing.JFormattedTextField txt_codigoProduto;
    private javax.swing.JFormattedTextField txt_dataCadastro;
    private javax.swing.JFormattedTextField txt_dataDeVencimento;
    private javax.swing.JTextField txt_descricaoProduto;
    private javax.swing.JTextArea txt_observacoes;
    private javax.swing.JFormattedTextField txt_quantidadeAtual;
    private javax.swing.JFormattedTextField txt_quantidadeIdeal;
    private javax.swing.JFormattedTextField txt_quantidadeMinima;
    private javax.swing.JTextField txt_valorDeCompra;
    private javax.swing.JTextField txt_valorDeVenda;
    // End of variables declaration//GEN-END:variables

    public void MostraMensagem() {
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    private void HabilitaBotoes(){
        bt_incluir_alterarRegistro.setText   ("Incluir Registro");
        bt_incluir_alterarRegistro.setEnabled(true);
        if(operacao.equals("I")){
            bt_incluir  .setEnabled(true);
            bt_alterar  .setEnabled(false);
            bt_imprimir .setEnabled(false);
            return;
        }
        if(operacao.equals("A")){
            bt_incluir  .setEnabled(false);
            bt_alterar  .setEnabled(true);
            bt_imprimir .setEnabled(true);
            bt_incluir_alterarRegistro.setText("Alterar Registro");
            return;
        }
        bt_incluir_alterarRegistro.setEnabled(false);
        bt_incluir      .setEnabled(false);
        bt_alterar      .setEnabled(false);
        bt_imprimir     .setEnabled(false);
    }
    
    private void PegaFornecedor(){
        bfor.nome = "Não existe!";
        txt_codigoFornecedor.setText(fc.FormataCampo(txt_codigoFornecedor.getText(), 5, 0));
        bfor.codigoFornecedor = Integer.parseInt(txt_codigoFornecedor.getText());
        if(bfor.codigoFornecedor == 0){
            return;
        }
        sql = "select codigoFornecedor, nome from tb_fornecedor where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoFornecedor = '" + bfor.codigoFornecedor + "';";
        dadosFornecedor.clear();
        dadosFornecedor = parametrosNS.dao.Consulta(sql);
        if(dadosFornecedor.isEmpty()){
            bt_incluir.setEnabled(false);
            bt_alterar.setEnabled(false);
            mensagem = "Fornecedor " + bfor.codigoFornecedor + " não encontrado, para incluir pressione NOVO!";
            new MostraMensagem(mensagem);
            return;
        }
        HabilitaBotoes();
        PegaDadosFornecedor();
    }
    
    private void PegaDadosFornecedor(){
        for(int i = 0; i < dadosFornecedor.size(); i++){
//            bfor.idFornecedor       = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(0)));
//            bfor.idEmpresa          = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(1)));
//            bfor.codigoGrupo        = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(2)));
//            bfor.codigoEmpresa      = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(3)));
            bfor.codigoFornecedor   = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(0)));
            bfor.nome               =                    String.valueOf(dadosFornecedor.get(i).get(1));
        }
    }
    
    private void PegaFabricante(){
        bfab.nomeFabricante = "------------------------------";
        txt_codigoFabricante.setText(fc.FormataCampo(txt_codigoFabricante.getText(), 5, 0));
        bfab.codigoFabricante = Integer.parseInt(txt_codigoFabricante.getText());
        if(bfab.codigoFabricante == 0)
            return;
        sql = "select codigoFabricante, nomeFabricante, siteFabricante from tb_fabricante where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoFabricante = '" + bfab.codigoFabricante + "';";
        dadosFabricante.clear();
        dadosFabricante = parametrosNS.dao.Consulta(sql);
        if(dadosFabricante.isEmpty()){
            bt_incluir.setEnabled(false);
            bt_alterar.setEnabled(false);
            mensagem = "Fabricante " + bfab.codigoFabricante + " não encontrado!";
            new MostraMensagem(mensagem);
            return;
        }
        HabilitaBotoes();
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
    
    private void PegaGruposProdutos(String Add){
        if(Add.equalsIgnoreCase("S")){
            sql = "select * from tb_grupoproduto where idEmpresa = " + parametrosNS.be.IdEmpresa + " order by codigoGrupoProduto asc;";
            combo_grupoProduto     .removeAllItems();
            combo_grupoProduto     .addItem("----------");
            combo_subGrupoProduto  .removeAllItems();
            combo_subGrupoProduto  .addItem("----------");
        }
        dadosGrupoProdutos.clear();
        dadosGrupoProdutos = parametrosNS.dao.Consulta(sql);
        if(dadosGrupoProdutos.isEmpty()) {
//            mensagem = "Tabela de tipo de produtos está vazia!!!";
//            new MostraMensagem(mensagem);
            return;
        }
        PegaDadosGruposProdutos(Add);
    }
    
    private void PegaDadosGruposProdutos(String Add){
        for(int i = 0; i < dadosGrupoProdutos.size(); i++) {
            bgp.idGrupoProduto          = Integer.parseInt(  String.valueOf(dadosGrupoProdutos.get(i).get(0)));
            bgp.idEmpresa               = Integer.parseInt(  String.valueOf(dadosGrupoProdutos.get(i).get(1)));
            bgp.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosGrupoProdutos.get(i).get(2)));
            bgp.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosGrupoProdutos.get(i).get(3)));
            bgp.codigoGrupoProduto      = Integer.parseInt(  String.valueOf(dadosGrupoProdutos.get(i).get(4)));
            bgp.descricaoGrupo          =                    String.valueOf(dadosGrupoProdutos.get(i).get(5));
            
            if(Add.equalsIgnoreCase("S")){
                combo_grupoProduto.addItem(fc.FormataCampo(String.valueOf(bgp.codigoGrupoProduto), 3, 0) + "-" + bgp.descricaoGrupo);
            }
        }
        abriuGrupoProduto = 0;
        if(Add.equalsIgnoreCase("S")){
            combo_subGrupoProduto.removeAllItems();
            combo_subGrupoProduto.addItem("----------");
        }
        if(Add.equalsIgnoreCase("N")){
            bsgp.idEmpresa              = bgp.idEmpresa;
            bsgp.codigoGrupo            = bgp.codigoGrupo;
            bsgp.codigoEmpresa          = bgp.codigoEmpresa;
            bsgp.codigoGrupoProduto     = bgp.codigoGrupoProduto;
            sql = "select * from tb_subgrupoproduto where idEmpresa = " + bsgp.idEmpresa + " and codigoGrupoProduto = " + bsgp.codigoGrupoProduto + ";";
            PegaSubGruposProdutos("S");
        }
    }
    
    private void PegaSubGruposProdutos(String Add){
        fatal = "N";
        if(combo_grupoProduto.getSelectedIndex() == 0){
            return;
        }
        dadosSubGrupoProdutos.clear();
        dadosSubGrupoProdutos = parametrosNS.dao.Consulta(sql);
        if(dadosSubGrupoProdutos.isEmpty()){
//            mensagem = "Sub grupos não encontrados para o Grupo n°" + bgp.codigoGrupoProduto + "!";
//            new MostraMensagem(mensagem);
            return;
        }
        PegaDadosSubGrupoProdutos(Add);
    }
    
    private void PegaDadosSubGrupoProdutos(String Add){
        if(Add.equalsIgnoreCase("S")){
            combo_subGrupoProduto.removeAllItems();
            combo_subGrupoProduto.addItem("----------");
        }
        for(int i = 0; i < dadosSubGrupoProdutos.size(); i++){
            if(dadosSubGrupoProdutos.get(i).get(0) != null){bsgp.idSubGrupoProduto      = Integer.parseInt(  String.valueOf(dadosSubGrupoProdutos.get(i).get(0)));}
            if(dadosSubGrupoProdutos.get(i).get(1) != null){bsgp.idEmpresa              = Integer.parseInt(  String.valueOf(dadosSubGrupoProdutos.get(i).get(1)));}
            if(dadosSubGrupoProdutos.get(i).get(2) != null){bsgp.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosSubGrupoProdutos.get(i).get(2)));}
            if(dadosSubGrupoProdutos.get(i).get(3) != null){bsgp.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosSubGrupoProdutos.get(i).get(3)));}
            if(dadosSubGrupoProdutos.get(i).get(4) != null){bsgp.codigoGrupoProduto     = Integer.parseInt(  String.valueOf(dadosSubGrupoProdutos.get(i).get(4)));}
            if(dadosSubGrupoProdutos.get(i).get(5) != null){bsgp.codigoSubGrupoProduto  = Integer.parseInt(  String.valueOf(dadosSubGrupoProdutos.get(i).get(5)));}
            if(dadosSubGrupoProdutos.get(i).get(6) != null){bsgp.descricaoSubGrupo      =                    String.valueOf(dadosSubGrupoProdutos.get(i).get(6));}
            
            if(Add.equalsIgnoreCase("S")){
                combo_subGrupoProduto.addItem(fc.FormataCampo(String.valueOf(bsgp.codigoSubGrupoProduto), 3, 0) + "-" + bsgp.descricaoSubGrupo);
            }
        }
        if(Add.equalsIgnoreCase("N")){
            combo_subGrupoProduto.setSelectedItem(fc.FormataCampo(String.valueOf(bsgp.codigoSubGrupoProduto  ), 3, 0) + "-" + bsgp.descricaoSubGrupo);
        }
    }
    
    private void ImprimirProduto(){
        bp.codigoProduto    = Integer.parseInt(txt_codigoProduto.getText());
        sql = "select \n" +
                "   pro.codigoProduto               as codigoProduto,\n" +
                "   pro.produtoInativo              as produtoInativo,\n" +
                "   pro.codigoFornecedor            as codigoFornecedor,\n" +
                "   forn.nome                       as nomeFornecedor,\n" +
                "   pro.dataCadastro                as dataCadastro,\n" +
                "   pro.descricaoProduto            as descricaoProduto,\n" +
                "   pro.codigoDeBarras              as codigoDeBarras,\n" +
                "   pro.dataDeVencimento            as dataDeVencimento,\n" +
                "   pro.valorDeCompra               as valorDeCompra,\n" +
                "   pro.valorDeVenda                as valorDeVenda,\n" +
                "   pro.codigoFabricante            as codigoFabricante,\n" +
                "   fabr.nomeFabricante             as nomeFabricante,\n" +
                "   pro.codigoGrupoProduto          as codigoGrupoProduto,\n" +
                "   gru.descricaoGrupo              as descricaoGrupo,\n" +
                "   pro.codigoSubGrupoProduto       as codigoSubGrupoProduto,\n" +
                "   sub.descricaoSubGrupo           as descricaoSubGrupo,\n" +
                "   pro.quantidadeMinima            as quantidadeMinima,\n" +
                "   pro.quantidadeIdeal             as quantidadeIdeal,\n" +
                "   pro.quantidadeAtual             as quantidadeAtual,\n" +
                "   sum(veni.valorTotal)            as valorTotalVendas,\n" +
                "   sum(veni.quantidade)            as quantidadeTotalVendas,\n" +
                "   pro.observacoes                 as observacoes\n" +
                "from \n" +
                "   tb_produtos pro\n" +
                "   left join tb_vendas_itens veni on (pro.codigoProduto = veni.codigoProduto)\n" +
                "   left join tb_fornecedor forn on (pro.codigoFornecedor = forn.codigoFornecedor)\n" +
                "   left join tb_fabricante fabr on (pro.codigoFabricante = fabr.codigoFabricante)\n" +
                "   inner join tb_grupoproduto gru on (pro.codigoGrupoProduto = gru.codigoGrupoProduto)\n" +
                "   inner join tb_subgrupoproduto sub on (pro.codigoSubGrupoProduto = sub.codigoSubGrupoProduto)\n" +
                "   where pro.codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and pro.codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and \n" +
                "   pro.codigoProduto = " + bp.codigoProduto + " group by veni.codigoProduto asc;";
        try{
            stmt = parametrosNS.con.prepareStatement(sql);
            rs   = stmt.executeQuery();
            js   = new JRResultSetDataSource(rs);
            
            hm.put("nomeEmpresa"    , parametrosNS.be.nomeEmpresa);
            hm.put("enderecoEmpresa", parametrosNS.be.enderecoEmpresa + ", " + parametrosNS.be.numeroEmpresa);
            hm.put("cnpjEmpresa"    , FCpfCnpj.FormataCPFCNPJ(parametrosNS.be.cnpjEmpresa));
            hm.put("logotipoEmpresa", parametrosNS.bge.pastaImagemLogotipo + "/LOGOTIPO." + parametrosNS.bge.extensaoImagemLogotipo);
            hm.put("bairroEmpresa"  , parametrosNS.be.cidadeEmpresa + ", " + parametrosNS.be.ufEmpresa + ", " + parametrosNS.be.bairroEmpresa);
            hm.put("cepEmpresa"     , parametrosNS.be.cepEmpresa);
//            hm.put("ImagemProduto"  , bpare.pastaImagemProdutos + "/Produto_" + bp.codigoProduto + "." + bpare.extensaoImagemProdutos);
            
            jpv     = "Relatorios/RelatorioProdutoUnitario.jasper";
            
            retorno = "ok";
            
            jpp     = JasperFillManager.fillReport(jpv, hm, js);
            JasperViewer.viewReport(jpp, false);
        }catch(Exception erro){
            mensagem = "Erro ao imprimir: " + erro.getMessage();
            new MostraMensagem(mensagem);
        }
    }
    
    private void PegaValoresItens(){
        bpd.idEmpresa               = parametrosNS.be.IdEmpresa;
        bpd.codigoGrupo             = parametrosNS.bge.CodigoGrupo;
        bpd.codigoEmpresa           = parametrosNS.be.CodigoEmpresa;
        bpd.codigoProduto           = bp.codigoProduto;
        bpd.valorDeCompra           = bp.valorDeCompra;
        bpd.valorDeVenda            = bp.valorDeVenda;
        bpd.dataRegistro            = invdata.inverterData(cdh.CapturarData(), 2);
        bpd.horaRegistro            = cdh.CapturaHora();
    }
    
    private void IncluirProdutoDetalhes(){
        sqlstate = "00000";
        if(bpd.valorDeCompra == bp.valorDeCompra){
            if(bpd.valorDeVenda == bp.valorDeVenda){
                if(bpd.quantidadeMinima == bp.quantidadeMinima){
                    if(bpd.quantidadeIdeal == bp.quantidadeIdeal){
                        if(bpd.quantidadeAtual == bp.quantidadeAtual){
                            return;
                        }
                    }
                }
            }
        }
        
        if(bpd.quantidadeAtual == bp.quantidadeAtual){return;}
        if(bpd.quantidadeAtual >  bp.quantidadeAtual){
            mensagem = "Impossível atualizar quantidade Atual!";
            new MostraMensagem(mensagem);
            return;
        }
        
        Confirmacao = JOptionPane.showConfirmDialog(null, "Confirma atualização de Estoque?", "", JOptionPane.YES_NO_OPTION);
        if(Confirmacao != 0){
            return;
        }
        
        bpd.quantidadeMinima        = bp.quantidadeMinima;
        bpd.quantidadeIdeal         = bp.quantidadeIdeal;
        bpd.quantidadeAtual         = bp.quantidadeAtual - bpd.quantidadeAtual;
        
        PegaValoresItens();
        sql = "insert into tb_produtos_detalhes (idEmpresa, codigoGrupo, codigoEmpresa, codigoProduto, valorDeCompra, valorDeVenda, quantidadeMinima, quantidadeIdeal, quantidadeAtual, dataRegistro, horaRegistro) "
            + "values (" + bpd.idEmpresa + ", " + bpd.codigoGrupo + ", " + bpd.codigoEmpresa + ", " + bpd.codigoProduto + ", " + bpd.valorDeCompra + ", " + bpd.valorDeVenda + ", " + bpd.quantidadeMinima + ", " + bpd.quantidadeIdeal + ", " + bpd.quantidadeAtual + ", '" + bpd.dataRegistro + "', '" + bpd.horaRegistro + "');";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(sqlstate.equals("00000")){
            return;
        }
        mensagem = "Não foi possível atualizar Produto!";
        new MostraMensagem(mensagem);
    }
    
    private void IncluirRegistro(){
        PegaValores();
        if(fatal.equals("S")){return;}
        IncluirProdutoDetalhes();
        if(!sqlstate.equals("00000")){
            return;
        }
        
        sql = "insert into tb_produtos (idEmpresa, codigoGrupo, codigoEmpresa, codigoProduto, produtoInativo, codigoFornecedor, dataCadastro, descricaoProduto, codigoDeBarras, dataDeVencimento, valorDeCompra, valorDeVenda, tipoDeProduto, codigoFabricante, codigoGrupoProduto  , codigoSubGrupoProduto  , quantidadeMinima, quantidadeIdeal, quantidadeAtual, observacoes) "
            + "values (" + bp.idEmpresa + ", " + bp.codigoGrupo + ", " + bp.codigoEmpresa + ", " + bp.codigoProduto + ", '" + bp.produtoInativo + "', '" + bp.codigoFornecedor + "', '" + bp.dataCadastro + "', '" + bp.descricaoProduto + "', '" + bp.codigoDeBarras + "', " + bp.dataDeVencimento + ", '" + bp.valorDeCompra + "', '" + bp.valorDeVenda + "', '" + bp.tipoDeProduto + "', '" + bp.codigoFabricante + "', '" + bp.codigoGrupoProduto   + "', '" + bp.codigoSubGrupoProduto   + "', '" + bp.quantidadeMinima + "', '" + bp.quantidadeIdeal + "', '" + bp.quantidadeAtual + "', '" + bp.observacoes + "');";
        
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao incluir produto n°" + bp.codigoProduto + "!";
            new MostraMensagem(mensagem);
            return;
        }
        AtualizarImagens();
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao incluir imagem do produto!";
            new MostraMensagem(mensagem);
            return;
        }
        mensagem = "Registro Incluido com Sucesso!";
        new MostraMensagem(mensagem);
        txt_codigoProduto.grabFocus();
    }
    
    private void AlterarRegistro(){
        PegaValores();
        if(fatal.equals("S")){
            return;
        }
        IncluirProdutoDetalhes();
        if(!sqlstate.equals("00000")){
            return;
        }
        
        sql =   "update tb_produtos set produtoInativo = "              + bp.produtoInativo             + ", " +
                                        "codigoFornecedor = "           + bp.codigoFornecedor           + ", " +
                                        "dataCadastro = '"              + bp.dataCadastro               + "', " +
                                        "descricaoProduto = '"          + bp.descricaoProduto           + "', " +
                                        "codigoDeBarras = '"            + bp.codigoDeBarras             + "', " +
                                        "dataDeVencimento = "           + bp.dataDeVencimento           + ", "  +
                                        "valorDeCompra = "              + bp.valorDeCompra              + ", " +
                                        "valorDeVenda = "               + bp.valorDeVenda               + ", " +
                                        "tipoDeProduto = '"             + bp.tipoDeProduto              + "', " +
                                        "codigoFabricante = "           + bp.codigoFabricante           + ", " +
                                        "codigoGrupoProduto   = "       + bp.codigoGrupoProduto         + ", " +
                                        "codigoSubGrupoProduto   = "    + bp.codigoSubGrupoProduto      + ", " +
                                        "quantidadeMinima = "           + bp.quantidadeMinima           + ", " +
                                        "quantidadeIdeal = "            + bp.quantidadeIdeal            + ", " +
                                        "quantidadeAtual = "            + bp.quantidadeAtual            + ", " +
                                        "observacoes = '"               + bp.observacoes                + "', " +
                                        "idEmpresaAlterou = "           + bp.idEmpresaAlterou           + ", " +
                                        "codigoGrupoAlterou = "         + bp.codigoGrupoAlterou         + ", " +
                                        "codigoEmpresaAlterou = "       + bp.codigoEmpresaAlterou       + ", " +
                                        "dataAlterou = '"               + bp.dataAlterou                + "', " +
                                        "horaAlterou = '"               + bp.horaAlterou                + "', " +
                                        "usuarioAlterou = "             + bp.usuarioAlterou             + " " +
                                        "where idProdutos = "   + bp.idProdutos                 + ";";
        
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao alterar produto!";
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
        txt_codigoProduto.grabFocus();
    }
    
}
