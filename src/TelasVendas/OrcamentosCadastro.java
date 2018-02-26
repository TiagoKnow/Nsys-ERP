package TelasVendas;

import Beans.BeanClientes;
import Beans.BeanOrcamentos;
import Beans.BeanOrcamentosItens;
import Beans.BeanProdutos;
import Beans.BeanServicos;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.FormataCampoCpfCnpj;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.PegaProximoRegistro;
import FuncoesInternas.TransformaValorStringeDouble;
import TelasFaturamento.ClientesConsulta;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/*
 @author Tiago e Paulo
 */
public class OrcamentosCadastro extends javax.swing.JFrame {
    //String's
    String sql                                      = "";
    String sqlstate                                 = "";
    String somostra                                 = "";
    String retorno                                  = "";
    String Mensagem                                 = "";
    String fatal                                    = "";
    String operacao                                 = "";
    
    //int's
    int    abriuCliente                             = 0;
    
    //Vetores
    ArrayList            parametros                            = new ArrayList();
    ArrayList            dadosPadroes                          = new ArrayList();
    ArrayList<ArrayList> dadosCount                            = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosCliente                          = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosOrcamentos                       = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosOrcamentosItens                  = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosServicoProdutos                  = new ArrayList<ArrayList>();
    
    //Bean's
    BeanClientes                    bc              = new BeanClientes();
    BeanOrcamentos                  borc            = new BeanOrcamentos();
    BeanOrcamentosItens             borci           = new BeanOrcamentosItens();
    BeanProdutos                    bp              = new BeanProdutos();
    BeanServicos                    bser            = new BeanServicos();
    
    //Especiais
    FormataCampo                    fc              = new FormataCampo();
    FormataCampoCpfCnpj             FCampopfCnpj    = new FormataCampoCpfCnpj();
    CapturarDataHora                cdh             = new CapturarDataHora();
    InverterData                    invdata         = new InverterData();
    PegaProximoRegistro             PegProReg       = new PegaProximoRegistro();
    TransformaValorStringeDouble    TransStrDou     = new TransformaValorStringeDouble();
    DefaultTableModel               TableOrcamentos;
    
    //Telas
    ClientesConsulta                CliCon;
    
    public OrcamentosCadastro(ArrayList DadosPadroes){
        dadosPadroes                                = DadosPadroes;
        
        somostra                                    = (String)  dadosPadroes.get(0);
        borc.codigoOrcamento                        = (int)     dadosPadroes.get(1);
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        bt_novo = new javax.swing.JButton();
        txt_codigoOrcamento = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txt_codigoCliente = new javax.swing.JFormattedTextField();
        label_cliente = new javax.swing.JLabel();
        bt_pesquisaCliente = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        txt_cpfcnpj1 = new javax.swing.JFormattedTextField();
        txt_cpfcnpj2 = new javax.swing.JFormattedTextField();
        txt_cpfcnpj3 = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_codigoUsuarioVendedor = new javax.swing.JFormattedTextField();
        label_nomeVendedor = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        bt_pesquisaProduto = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_valortotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        label_descricaoProduto = new javax.swing.JLabel();
        txt_codigoServicoProduto = new javax.swing.JTextField();
        bt_adicionar = new javax.swing.JButton();
        txt_quantidade = new javax.swing.JFormattedTextField();
        txt_valorUnitario = new javax.swing.JFormattedTextField();
        combo_tipo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_itensorcamentos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        bt_finalizar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Orçamentos");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("N° Orçamento");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        try {
            txt_codigoOrcamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoOrcamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoOrcamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoOrcamentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoOrcamentoFocusLost(evt);
            }
        });
        txt_codigoOrcamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoOrcamentoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_codigoOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_novo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, txt_codigoOrcamento});

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Cliente");
        jLabel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_codigoCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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
        txt_codigoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoClienteKeyReleased(evt);
            }
        });

        label_cliente.setFocusable(false);
        label_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_clienteMouseEntered(evt);
            }
        });

        bt_pesquisaCliente.setText("...");
        bt_pesquisaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_pesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_codigoCliente)
                        .addComponent(bt_pesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(label_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("CPF ou CNPJ");
        jLabel35.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_cpfcnpj1.setEditable(false);
        try {
            txt_cpfcnpj1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("### ### ###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cpfcnpj1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cpfcnpj1.setFocusable(false);
        txt_cpfcnpj1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_cpfcnpj1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cpfcnpj1FocusLost(evt);
            }
        });
        txt_cpfcnpj1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cpfcnpj1ActionPerformed(evt);
            }
        });
        txt_cpfcnpj1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cpfcnpj1KeyReleased(evt);
            }
        });

        txt_cpfcnpj2.setEditable(false);
        try {
            txt_cpfcnpj2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cpfcnpj2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cpfcnpj2.setFocusable(false);
        txt_cpfcnpj2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cpfcnpj2FocusLost(evt);
            }
        });
        txt_cpfcnpj2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cpfcnpj2ActionPerformed(evt);
            }
        });

        txt_cpfcnpj3.setEditable(false);
        try {
            txt_cpfcnpj3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cpfcnpj3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cpfcnpj3.setFocusable(false);
        txt_cpfcnpj3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cpfcnpj3FocusLost(evt);
            }
        });
        txt_cpfcnpj3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cpfcnpj3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_cpfcnpj1, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cpfcnpj2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cpfcnpj3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_cpfcnpj2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_cpfcnpj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_cpfcnpj3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Vendedor");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_codigoUsuarioVendedor.setEditable(false);
        try {
            txt_codigoUsuarioVendedor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoUsuarioVendedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoUsuarioVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoUsuarioVendedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_codigoUsuarioVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_nomeVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_codigoUsuarioVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                    .addComponent(label_nomeVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Código:");

        bt_pesquisaProduto.setText("...");
        bt_pesquisaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaProdutoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Quantidade:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Valor unitário:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Valor total: ");

        txt_valortotal.setEditable(false);
        txt_valortotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_valortotal.setFocusable(false);
        txt_valortotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valortotalFocusLost(evt);
            }
        });
        txt_valortotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_valortotalKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Produtos ou Serviços");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_codigoServicoProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoServicoProdutoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoServicoProdutoFocusLost(evt);
            }
        });
        txt_codigoServicoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoServicoProdutoActionPerformed(evt);
            }
        });
        txt_codigoServicoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoServicoProdutoKeyReleased(evt);
            }
        });

        bt_adicionar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_adicionar.setText("Adicionar");
        bt_adicionar.setEnabled(false);
        bt_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_adicionarActionPerformed(evt);
            }
        });
        bt_adicionar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bt_adicionarKeyPressed(evt);
            }
        });

        txt_quantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txt_quantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_quantidadeFocusLost(evt);
            }
        });
        txt_quantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_quantidadeKeyPressed(evt);
            }
        });

        txt_valorUnitario.setEditable(false);
        txt_valorUnitario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txt_valorUnitario.setFocusable(false);
        txt_valorUnitario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorUnitarioFocusLost(evt);
            }
        });

        combo_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----------", "Produto", "Serviço" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Tipo:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_codigoServicoProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(txt_valorUnitario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_valortotal, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(bt_pesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_descricaoProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(combo_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel12, jLabel5, jLabel6});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_descricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoServicoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(bt_pesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_valortotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_adicionar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_quantidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_valorUnitario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaProduto, jLabel6, label_descricaoProduto, txt_codigoServicoProduto});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_adicionar, jLabel10, jLabel12, jLabel13, txt_quantidade, txt_valorUnitario, txt_valortotal});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {combo_tipo, jLabel5});

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Itens do Orçamento");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_itensorcamentos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabela_itensorcamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Tipo", "Descrição", "Código de Barras", "Preço Unitário", "Qtd", "Preço Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_itensorcamentos.setAutoscrolls(false);
        tabela_itensorcamentos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabela_itensorcamentos);
        if (tabela_itensorcamentos.getColumnModel().getColumnCount() > 0) {
            tabela_itensorcamentos.getColumnModel().getColumn(0).setResizable(false);
            tabela_itensorcamentos.getColumnModel().getColumn(1).setResizable(false);
            tabela_itensorcamentos.getColumnModel().getColumn(2).setResizable(false);
            tabela_itensorcamentos.getColumnModel().getColumn(3).setResizable(false);
            tabela_itensorcamentos.getColumnModel().getColumn(4).setResizable(false);
            tabela_itensorcamentos.getColumnModel().getColumn(5).setResizable(false);
            tabela_itensorcamentos.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel7.setText("Total de Itens: ");

        jTextField1.setEditable(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        txt_total.setEditable(false);
        txt_total.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txt_total.setForeground(new java.awt.Color(51, 51, 51));
        txt_total.setText("R$ 0,00");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Total:");

        bt_finalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/vend.png"))); // NOI18N
        bt_finalizar.setText("Finalizar");
        bt_finalizar.setEnabled(false);
        bt_finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_finalizarActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_finalizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_finalizar, jLabel19, txt_total});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel1, jPanel10, jPanel2, jPanel4});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        ReiniciaCampos();
        
        borc.codigoOrcamento        = PegProReg.PegaProximoRegistro("tb_orcamentos", "codigoOrcamento", "");
        txt_codigoOrcamento.setText(fc.FormataCampo(String.valueOf(borc.codigoOrcamento), 6, 0));
        
        operacao = "I";
        txt_codigoCliente.grabFocus();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void txt_codigoOrcamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoOrcamentoFocusGained
        if(somostra.equals("S"))
            return;
        bt_finalizar        .setEnabled(false);
        txt_codigoOrcamento .setText("");
        ReiniciaCampos();
    }//GEN-LAST:event_txt_codigoOrcamentoFocusGained

    private void txt_codigoOrcamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoOrcamentoFocusLost
        if(txt_codigoOrcamento.getText().replace(" ", "").equals(""))
            return;
        if(somostra.equals("S"))
            return;
        PegaOrcamento();
    }//GEN-LAST:event_txt_codigoOrcamentoFocusLost

    private void txt_codigoOrcamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoOrcamentoKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        if(somostra.equals("S"))
            return;
        if(txt_codigoOrcamento.getText().replace(" ", "").equals(""))
            return;
        PegaOrcamento();
    }//GEN-LAST:event_txt_codigoOrcamentoKeyPressed

    private void txt_codigoClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteFocusGained
        label_cliente   .setText("");
        txt_cpfcnpj1    .setText("");
        txt_cpfcnpj2    .setText("");
        txt_cpfcnpj3    .setText("");
    }//GEN-LAST:event_txt_codigoClienteFocusGained

    private void txt_codigoClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteFocusLost
        if(txt_codigoCliente.getText().replace(" ", "").equals(""))
            return;
        if(somostra.equals("S"))
            return;
        PegaCliente();
    }//GEN-LAST:event_txt_codigoClienteFocusLost

    private void txt_codigoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoClienteActionPerformed
        
    }//GEN-LAST:event_txt_codigoClienteActionPerformed

    private void txt_codigoClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoClienteKeyReleased
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        txt_codigoServicoProduto.grabFocus();
    }//GEN-LAST:event_txt_codigoClienteKeyReleased

    private void label_clienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_clienteMouseEntered
        label_cliente.setToolTipText(label_cliente.getText());
    }//GEN-LAST:event_label_clienteMouseEntered

    private void bt_pesquisaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaClienteActionPerformed
        LocalizarCliente();
    }//GEN-LAST:event_bt_pesquisaClienteActionPerformed

    private void txt_cpfcnpj1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1FocusGained
        txt_cpfcnpj1.setText("");
    }//GEN-LAST:event_txt_cpfcnpj1FocusGained

    private void txt_cpfcnpj1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1FocusLost

    }//GEN-LAST:event_txt_cpfcnpj1FocusLost

    private void txt_cpfcnpj1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cpfcnpj1ActionPerformed

    private void txt_cpfcnpj1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cpfcnpj1KeyReleased

    private void txt_cpfcnpj2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj2FocusLost

    }//GEN-LAST:event_txt_cpfcnpj2FocusLost

    private void txt_cpfcnpj2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cpfcnpj2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cpfcnpj2ActionPerformed

    private void txt_cpfcnpj3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj3FocusLost

    }//GEN-LAST:event_txt_cpfcnpj3FocusLost

    private void txt_cpfcnpj3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cpfcnpj3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cpfcnpj3ActionPerformed

    private void txt_codigoUsuarioVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoUsuarioVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoUsuarioVendedorActionPerformed

    private void bt_pesquisaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaProdutoActionPerformed
        
    }//GEN-LAST:event_bt_pesquisaProdutoActionPerformed

    private void txt_valortotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valortotalFocusLost

    }//GEN-LAST:event_txt_valortotalFocusLost

    private void txt_valortotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valortotalKeyReleased

    }//GEN-LAST:event_txt_valortotalKeyReleased

    private void txt_codigoServicoProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoServicoProdutoFocusGained
        txt_codigoServicoProduto.setText("");
        label_descricaoProduto.setText("");
        txt_valorUnitario.setText("");
        txt_quantidade.setText("");
        txt_valortotal.setText("");
        bt_adicionar.setEnabled(false);
    }//GEN-LAST:event_txt_codigoServicoProdutoFocusGained

    private void txt_codigoServicoProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoServicoProdutoFocusLost
        if(txt_codigoServicoProduto.getText().equals(""))
            return;
        if(somostra.equals("S"))
            return;
        PegaServicoOuProduto();
    }//GEN-LAST:event_txt_codigoServicoProdutoFocusLost

    private void txt_codigoServicoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoServicoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoServicoProdutoActionPerformed

    private void txt_codigoServicoProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoServicoProdutoKeyReleased
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        txt_quantidade.grabFocus();
    }//GEN-LAST:event_txt_codigoServicoProdutoKeyReleased

    private void bt_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_adicionarActionPerformed
        if(somostra.equalsIgnoreCase("S"))
            return;
        if(operacao.equals("I")){
            IncluirOrcamento();
            if(fatal.equals("S"))return;
        }
        IncluirOrcamentoItem();
    }//GEN-LAST:event_bt_adicionarActionPerformed

    private void bt_adicionarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bt_adicionarKeyPressed
        if(somostra.equals("S"))
            return;
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        IncluirOrcamentoItem();
    }//GEN-LAST:event_bt_adicionarKeyPressed

    private void txt_quantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantidadeFocusLost
        if(somostra.equals("S"))
            return;
        if(txt_valorUnitario.getText().replace(" ", "").equals(""))
            return;
        if(txt_quantidade.getText().replace(" ", "").equals("")){
            borci.quantidade = 0;
            return;
        }
        try{
            borci.quantidade            = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_quantidade.getText(), 1));
        }catch(Exception erro){
            Mensagem = "Quantidade inválida!";
            new MostraMensagem(Mensagem);
            return;
        }
        if(combo_tipo.getSelectedIndex() == 1){
            if(borci.quantidade > bp.quantidadeAtual){
                Mensagem = "Quantidade incluida maior do que em estoque!";
                new MostraMensagem(Mensagem);
                return;
            }
        }
        borci.valorUnitario             = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_valorUnitario.getText(), 1));
        borci.valorTotal                = borci.valorUnitario * borci.quantidade;
        txt_valortotal.setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(borci.valorTotal), 0));
        bt_adicionar.setEnabled(true);
        bt_adicionar.grabFocus();
    }//GEN-LAST:event_txt_quantidadeFocusLost

    private void txt_quantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_quantidadeKeyPressed
        if(txt_valorUnitario.getText().replace(" ", "").equals(""))
            return;
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        bt_adicionar.grabFocus();
    }//GEN-LAST:event_txt_quantidadeKeyPressed

    private void txt_valorUnitarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorUnitarioFocusLost
        if(!txt_valorUnitario.getText().equals(""))
            return;
        bp.valorDeVenda = 0;
    }//GEN-LAST:event_txt_valorUnitarioFocusLost

    private void bt_finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_finalizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_finalizarActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        TableOrcamentos = (DefaultTableModel)tabela_itensorcamentos.getModel();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(CliCon   != null)CliCon.dispose();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_adicionar;
    private javax.swing.JButton bt_finalizar;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisaCliente;
    private javax.swing.JButton bt_pesquisaProduto;
    private javax.swing.JMenuItem bt_sair;
    private javax.swing.JComboBox<String> combo_tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel label_cliente;
    private javax.swing.JLabel label_descricaoProduto;
    private javax.swing.JLabel label_nomeVendedor;
    private javax.swing.JTable tabela_itensorcamentos;
    private javax.swing.JFormattedTextField txt_codigoCliente;
    private javax.swing.JFormattedTextField txt_codigoOrcamento;
    private javax.swing.JTextField txt_codigoServicoProduto;
    private javax.swing.JFormattedTextField txt_codigoUsuarioVendedor;
    private javax.swing.JFormattedTextField txt_cpfcnpj1;
    private javax.swing.JFormattedTextField txt_cpfcnpj2;
    private javax.swing.JFormattedTextField txt_cpfcnpj3;
    private javax.swing.JFormattedTextField txt_quantidade;
    private javax.swing.JTextField txt_total;
    private javax.swing.JFormattedTextField txt_valorUnitario;
    private javax.swing.JTextField txt_valortotal;
    // End of variables declaration//GEN-END:variables
    
    private void LocalizarCliente() {
        if(CliCon != null)if(CliCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuCliente = 1;
        CliCon = new ClientesConsulta("N");
        CliCon.setVisible(true);
    }
    
    private void ReiniciaCampos(){
        txt_codigoCliente           .setText("");
        label_cliente               .setText("");
        combo_tipo                  .setSelectedIndex(0);
        txt_codigoServicoProduto    .setText("");
        label_descricaoProduto      .setText("");
        txt_valorUnitario           .setText("");
        txt_quantidade              .setText("");
        txt_valortotal              .setText("");
        bt_adicionar                .setEnabled(false);
        TableOrcamentos             .setNumRows(0);
        bt_finalizar                .setEnabled(false);
    }
    
    private void PegaOrcamento(){
        txt_codigoOrcamento.setText(fc.FormataCampo(txt_codigoOrcamento.getText(), 6, 0));
        borc.codigoOrcamento    = Integer.parseInt(txt_codigoOrcamento.getText());
        if(borc.codigoOrcamento == 0)
            return;
        sql = "select * from tb_orcamentos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoOrcamento = " + borc.codigoOrcamento + ";";
        dadosOrcamentos.clear();
        dadosOrcamentos = parametrosNS.dao.Consulta(sql);
        if(dadosOrcamentos.isEmpty()){
            Mensagem = "Orçamento n°" + borc.codigoOrcamento + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        operacao = "A";
        PegaDadosOrcamento();
    }
    
    private void PegaDadosOrcamento(){
        for(int i = 0; i < dadosOrcamentos.size(); i++){
            borc = new BeanOrcamentos();
        if(dadosOrcamentos.get(i).get(0) != null)
            borc.idOrcamento            = Integer.parseInt(  String.valueOf(dadosOrcamentos.get(i).get(0)));
        if(dadosOrcamentos.get(i).get(1) != null)
            borc.idEmpresa              = Integer.parseInt(  String.valueOf(dadosOrcamentos.get(i).get(1)));
        if(dadosOrcamentos.get(i).get(2) != null)
            borc.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosOrcamentos.get(i).get(2)));
        if(dadosOrcamentos.get(i).get(3) != null)
            borc.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosOrcamentos.get(i).get(3)));
        if(dadosOrcamentos.get(i).get(4) != null)
            borc.codigoOrcamento        = Integer.parseInt(  String.valueOf(dadosOrcamentos.get(i).get(4)));
        if(dadosOrcamentos.get(i).get(5) != null)
            borc.codigoCliente          = Integer.parseInt(  String.valueOf(dadosOrcamentos.get(i).get(5)));
        if(dadosOrcamentos.get(i).get(6) != null)
            borc.codigoUsuario          = Integer.parseInt(  String.valueOf(dadosOrcamentos.get(i).get(6)));
            borc.dataOrcamento          =                    String.valueOf(dadosOrcamentos.get(i).get(7));
            borc.horaOrcamento          =                    String.valueOf(dadosOrcamentos.get(i).get(8));
        if(dadosOrcamentos.get(i).get(9) != null)
            borc.statusOrcamento        = Integer.parseInt(  String.valueOf(dadosOrcamentos.get(i).get(9)));
            borc.observacao             =                    String.valueOf(dadosOrcamentos.get(i).get(10));
            borc.dataAlterou            =                    String.valueOf(dadosOrcamentos.get(i).get(11));
            borc.horaAlterou            =                    String.valueOf(dadosOrcamentos.get(i).get(12));
        if(dadosOrcamentos.get(i).get(13) != null)
            borc.usuarioAlterou         = Integer.parseInt(  String.valueOf(dadosOrcamentos.get(i).get(13)));
        if(dadosOrcamentos.get(i).get(14) != null)
            borc.idEmpresaAlterou       = Integer.parseInt(  String.valueOf(dadosOrcamentos.get(i).get(14)));
        if(dadosOrcamentos.get(i).get(15) != null)
            borc.codigoGrupoAlterou     = Integer.parseInt(  String.valueOf(dadosOrcamentos.get(i).get(15)));
        if(dadosOrcamentos.get(i).get(16) != null)
            borc.codigoEmpresaAlterou   = Integer.parseInt(  String.valueOf(dadosOrcamentos.get(i).get(16)));
            
            txt_codigoCliente.setText(String.valueOf(borc.codigoCliente));
            PegaCliente();
            
            borci.idEmpresa         = borc.idEmpresa;
            borci.codigoGrupo       = borc.codigoGrupo;
            borci.codigoEmpresa     = borc.codigoEmpresa;
            borci.codigoOrcamento   = borc.codigoOrcamento;
            PegaOrcamentoItens();
        }
    }
    
    private void PegaCliente(){
        bc.nome = "--------------------";
        txt_codigoCliente.setText(fc.FormataCampo(txt_codigoCliente.getText(), 5, 0));
        bc.codigoCliente            = Integer.parseInt(txt_codigoCliente.getText());
        if(bc.codigoCliente != 0)
            sql = "select idCliente, idEmpresa, codigoGrupo, codigoEmpresa, codigoCliente, cpfCnpj, nome from tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCliente = " + bc.codigoCliente + ";";
        dadosCliente.clear();
        dadosCliente = parametrosNS.dao.Consulta(sql);
        if(dadosCliente.isEmpty()){
            Mensagem = "Cliente " + bc.codigoCliente + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosCliente();
    }
    
    private void PegaDadosCliente(){
        for(int i = 0; i < dadosCliente.size(); i++){
            bc = new BeanClientes();
            bc.idCliente            = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(0)));
            bc.idEmpresa            = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(1)));
            bc.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(2)));
            bc.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(3)));
            bc.codigoCliente        = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(4)));
            bc.cpfCnpj              =                    String.valueOf(dadosCliente.get(i).get(5));
            bc.nome                 =                    String.valueOf(dadosCliente.get(i).get(6));
        }
        label_cliente.setText(bc.nome);
        bc.cpfCnpj  = FCampopfCnpj.FormataCampoCpfCnpj(bc.cpfCnpj);
        txt_cpfcnpj1.setText(bc.cpfCnpj.substring(0 , 9));
        txt_cpfcnpj2.setText(bc.cpfCnpj.substring(9 ,13));
        txt_cpfcnpj3.setText(bc.cpfCnpj.substring(13,15));
    }
    
    private void PegaOrcamentoItens(){
        sql = "select * from tb_orcamentos_itens where idEmpresa = " + borci.idEmpresa + " and codigoOrcamento = " + borci.codigoOrcamento + ";";
        dadosOrcamentosItens.clear();
        dadosOrcamentosItens = parametrosNS.dao.Consulta(sql);
        if(dadosOrcamentosItens.isEmpty()){
            Mensagem = "Não foram encontrados itens para o Orçamento n°" + borc.codigoOrcamento + "!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosOrcamentoItens();
    }
    
    private void PegaDadosOrcamentoItens(){
        TableOrcamentos.setNumRows(0);
        tabela_itensorcamentos.getColumnModel().getColumn(0).setResizable(false);
        tabela_itensorcamentos.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabela_itensorcamentos.getColumnModel().getColumn(1).setResizable(false);
        tabela_itensorcamentos.getColumnModel().getColumn(1).setPreferredWidth(50);
        tabela_itensorcamentos.getColumnModel().getColumn(2).setResizable(false);
        tabela_itensorcamentos.getColumnModel().getColumn(2).setPreferredWidth(300);
        tabela_itensorcamentos.getColumnModel().getColumn(3).setResizable(false);
        tabela_itensorcamentos.getColumnModel().getColumn(3).setPreferredWidth(200);
        tabela_itensorcamentos.getColumnModel().getColumn(4).setResizable(false);
        tabela_itensorcamentos.getColumnModel().getColumn(4).setPreferredWidth(45);
        tabela_itensorcamentos.getColumnModel().getColumn(5).setResizable(false);
        tabela_itensorcamentos.getColumnModel().getColumn(5).setPreferredWidth(25);
        tabela_itensorcamentos.getColumnModel().getColumn(6).setResizable(false);
        tabela_itensorcamentos.getColumnModel().getColumn(6).setPreferredWidth(45);
        
        String ProdutoOuServico             = "";
        String DescricaoProdutoOuServico    = "";
        for(int i = 0; i < dadosOrcamentosItens.size(); i++){
            if(dadosOrcamentosItens.get(i).get(0)  != null){borci.idOrcamentoItem       = Integer.parseInt(  String.valueOf(dadosOrcamentosItens.get(i).get(0)));}
            if(dadosOrcamentosItens.get(i).get(1)  != null){borci.idEmpresa             = Integer.parseInt(  String.valueOf(dadosOrcamentosItens.get(i).get(1)));}
            if(dadosOrcamentosItens.get(i).get(2)  != null){borci.codigoGrupo           = Integer.parseInt(  String.valueOf(dadosOrcamentosItens.get(i).get(2)));}
            if(dadosOrcamentosItens.get(i).get(3)  != null){borci.codigoEmpresa         = Integer.parseInt(  String.valueOf(dadosOrcamentosItens.get(i).get(3)));}
            if(dadosOrcamentosItens.get(i).get(4)  != null){borci.codigoOrcamento       = Integer.parseInt(  String.valueOf(dadosOrcamentosItens.get(i).get(4)));}
            if(dadosOrcamentosItens.get(i).get(5)  != null){borci.codigoOrcamentoItem   = Integer.parseInt(  String.valueOf(dadosOrcamentosItens.get(i).get(5)));}
            if(dadosOrcamentosItens.get(i).get(6)  != null){borci.codigoServicoProduto  = Integer.parseInt(  String.valueOf(dadosOrcamentosItens.get(i).get(6)));}
            if(dadosOrcamentosItens.get(i).get(7)  != null){borci.dataCadastro          =                    String.valueOf(dadosOrcamentosItens.get(i).get(7));}
            if(dadosOrcamentosItens.get(i).get(8)  != null){borci.horaCadastro          =                    String.valueOf(dadosOrcamentosItens.get(i).get(8));}
            if(dadosOrcamentosItens.get(i).get(9)  != null){borci.tipo                  = Integer.parseInt(  String.valueOf(dadosOrcamentosItens.get(i).get(9)));}
            if(dadosOrcamentosItens.get(i).get(10) != null){borci.valorUnitario         = Double.parseDouble(String.valueOf(dadosOrcamentosItens.get(i).get(10)));}
            if(dadosOrcamentosItens.get(i).get(11) != null){borci.quantidade            = Double.parseDouble(String.valueOf(dadosOrcamentosItens.get(i).get(11)));}
            if(dadosOrcamentosItens.get(i).get(12) != null){borci.valorTotal            = Double.parseDouble(String.valueOf(dadosOrcamentosItens.get(i).get(12)));}
            
            bp.codigoProduto            = borci.codigoServicoProduto;
            bser.codigoServico          = borci.codigoServicoProduto;
            switch(borci.tipo){
                case 1: sql = "select * from tb_produtos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoProduto = " + bp.codigoProduto + ";";
                        PegaProduto(); 
                        ProdutoOuServico = "Produto"; 
                        DescricaoProdutoOuServico = fc.FormataCampo(String.valueOf(bp.codigoProduto),   6, 0) + "-" + bp.descricaoProduto;  break;
                case 2: PegaServico(); 
                        ProdutoOuServico = "Serviço"; 
                        DescricaoProdutoOuServico = fc.FormataCampo(String.valueOf(bser.codigoServico), 2, 0) + "-" + bser.descricaoServico;
                        bp.codigoDeBarras = ""; break;
            }
            
            TableOrcamentos.addRow(new Object[] {fc.FormataCampo(String.valueOf(borc.codigoOrcamento), 6, 0) + "-" + fc.FormataCampo(String.valueOf(borci.codigoOrcamentoItem), 2, 0), fc.FormataCampo(String.valueOf(borci.tipo), 2, 0) + "-" + ProdutoOuServico, DescricaoProdutoOuServico, bp.codigoDeBarras, TransStrDou.TransformaValorStringeDouble(String.valueOf(borci.valorUnitario), 0), borci.quantidade, TransStrDou.TransformaValorStringeDouble(String.valueOf(borci.valorTotal), 0)});
        }
    }
    
    private void PegaServicoOuProduto(){
        if(combo_tipo.getSelectedIndex() == 0){
            Mensagem = "Tipo não selecionado!";
            new MostraMensagem(Mensagem);
            txt_codigoServicoProduto.setText("");
            return;
        }
        bp.codigoDeBarras   = txt_codigoServicoProduto.getText();
        bser.codigoServico  = Integer.parseInt(txt_codigoServicoProduto.getText());
        switch(combo_tipo.getSelectedIndex()){
            case 1: sql = "select * from tb_produtos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoDeBarras = '" + bp.codigoDeBarras + "';";
                    PegaProduto();
                    label_descricaoProduto.setText(bp.descricaoProduto);
                    txt_valorUnitario.setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(bp.valorDeVenda), 0));     break;
            case 2: PegaServico();
                    label_descricaoProduto.setText(bser.descricaoServico);
                    txt_valorUnitario.setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(bser.valorServico), 0));   break;
        }
        txt_quantidade.grabFocus();
    }
    
    private void PegaProduto(){
        dadosServicoProdutos.clear();
        dadosServicoProdutos = parametrosNS.dao.Consulta(sql);
        if(dadosServicoProdutos.isEmpty()){
            Mensagem = "Produto não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosProdutos();
    }
    
    private void PegaDadosProdutos(){
        for(int i = 0; i < dadosServicoProdutos.size(); i++){
            if(dadosServicoProdutos.get(i).get(0) != null)
                bp.idProdutos               = Integer.parseInt(  String.valueOf(dadosServicoProdutos.get(i).get(0)));
            if(dadosServicoProdutos.get(i).get(1) != null)
                bp.idEmpresa                = Integer.parseInt(  String.valueOf(dadosServicoProdutos.get(i).get(1)));
            if(dadosServicoProdutos.get(i).get(2) != null)
                bp.codigoGrupo              = Integer.parseInt(  String.valueOf(dadosServicoProdutos.get(i).get(2)));
            if(dadosServicoProdutos.get(i).get(3) != null)
                bp.codigoEmpresa            = Integer.parseInt(  String.valueOf(dadosServicoProdutos.get(i).get(3)));
            if(dadosServicoProdutos.get(i).get(4) != null)
                bp.codigoProduto            = Integer.parseInt(  String.valueOf(dadosServicoProdutos.get(i).get(4)));
                bp.codigoDeBarras           =                    String.valueOf(dadosServicoProdutos.get(i).get(9));
                bp.descricaoProduto         =                    String.valueOf(dadosServicoProdutos.get(i).get(8));
            if(dadosServicoProdutos.get(i).get(12) != null)
                bp.valorDeVenda             = Double.parseDouble(String.valueOf(dadosServicoProdutos.get(i).get(12)));
            if(dadosServicoProdutos.get(i).get(19) != null)
                bp.quantidadeAtual          = Double.parseDouble(String.valueOf(dadosServicoProdutos.get(i).get(19)));
        }
    }
    
    private void PegaServico(){
        sql = "select * from tb_servicos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoServico = " + bser.codigoServico + ";";
        dadosServicoProdutos.clear();
        dadosServicoProdutos = parametrosNS.dao.Consulta(sql);
        if(dadosServicoProdutos.isEmpty()){
            Mensagem = "Serviço " + bser.codigoServico + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosServicos();
    }
    
    private void PegaDadosServicos(){
        for(int i = 0; i < dadosServicoProdutos.size(); i++){
            if(dadosServicoProdutos.get(i).get(0) != null)
                bser.idServico          = Integer.parseInt(  String.valueOf(dadosServicoProdutos.get(i).get(0)));
            if(dadosServicoProdutos.get(i).get(1) != null)
                bser.idEmpresa          = Integer.parseInt(  String.valueOf(dadosServicoProdutos.get(i).get(1)));
            if(dadosServicoProdutos.get(i).get(2) != null)
                bser.codigoGrupo        = Integer.parseInt(  String.valueOf(dadosServicoProdutos.get(i).get(2)));
            if(dadosServicoProdutos.get(i).get(3) != null)
                bser.codigoEmpresa      = Integer.parseInt(  String.valueOf(dadosServicoProdutos.get(i).get(3)));
            if(dadosServicoProdutos.get(i).get(4) != null)
                bser.codigoServico      = Integer.parseInt(  String.valueOf(dadosServicoProdutos.get(i).get(4)));
                bser.descricaoServico   =                    String.valueOf(dadosServicoProdutos.get(i).get(5));
            if(dadosServicoProdutos.get(i).get(6) != null)
                bser.valorServico       = Double.parseDouble(String.valueOf(dadosServicoProdutos.get(i).get(6)));
        }
    }
    
    private void PegaValoresOrcamento(){
        fatal = "N";
        borc.idEmpresa                  = parametrosNS.be.IdEmpresa;
        borc.codigoGrupo                = parametrosNS.bge.CodigoGrupo;
        borc.codigoEmpresa              = parametrosNS.be.CodigoEmpresa;
        borc.codigoOrcamento            = Integer.parseInt(txt_codigoOrcamento.getText());
        if(txt_codigoCliente.getText().replace(" ", sql).equals("")){
            Mensagem = "Cliente Inválido!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        borc.codigoCliente              = Integer.parseInt(txt_codigoCliente.getText());
        borc.codigoUsuario              = parametrosNS.bu.codigoUsuario;
        borc.dataOrcamento              = invdata.inverterData(cdh.CapturarData(), 2);
        borc.horaOrcamento              = cdh.CapturaHora();
        borc.statusOrcamento            = 0;
        borc.observacao                 = "";
        
        borc.idEmpresaAlterou           = parametrosNS.be.idEmpresa;
        borc.codigoGrupoAlterou         = parametrosNS.bge.codigoGrupo;
        borc.codigoEmpresaAlterou       = parametrosNS.be.codigoEmpresa;
        borc.dataAlterou                = invdata.inverterData(cdh.CapturarData(), 2);
        borc.horaAlterou                = cdh.CapturaHora();
        borc.usuarioAlterou             = parametrosNS.bu.codigoUsuario;
    }
    
    private void IncluirOrcamento(){
        PegaValoresOrcamento();
        if(fatal.equals("S"))return;
        
        sql = "insert into tb_orcamentos (idEmpresa, codigoGrupo, codigoEmpresa, codigoOrcamento, codigoCliente, codigoUsuario, dataOrcamento, horaOrcamento, statusOrcamento, observacao) "
            + "values (" + borc.idEmpresa + ", " + borc.codigoGrupo + ", " + borc.codigoEmpresa + ", " + borc.codigoOrcamento + ", " + borc.codigoCliente + ", " + borc.codigoUsuario + ", '" + borc.dataOrcamento + "', '" + borc.horaOrcamento + "', " + borc.statusOrcamento + ", '" + borc.observacao + "');";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            Mensagem = "Erro ao Incluir Orçamento!";
            new MostraMensagem(Mensagem);
            fatal = "S";
        }
        sql = "select idOrcamento from tb_orcamentos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoOrcamento = " + borc.codigoOrcamento + ";";
        dadosOrcamentos.clear();
        dadosOrcamentos     = parametrosNS.dao.Consulta(sql);
        borc.idOrcamento    = Integer.parseInt(String.valueOf(dadosOrcamentos.get(0).get(0)));
    }
    
    private void PegaValoresOrcamentoItem(){
        borci.idEmpresa                 = parametrosNS.be.IdEmpresa;
        borci.codigoGrupo               = parametrosNS.bge.CodigoGrupo;
        borci.codigoEmpresa             = parametrosNS.be.CodigoEmpresa;
        borci.codigoOrcamento           = borc.codigoOrcamento;
        sql = "select count(*) from tb_orcamentos_itens where idEmpresa = " + borci.idEmpresa + " and codigoOrcamento = " + borci.codigoOrcamento + ";";
        dadosCount.clear();
        dadosCount = parametrosNS.dao.Consulta(sql);
        borci.codigoOrcamentoItem       = Integer.parseInt(String.valueOf(dadosCount.get(0).get(0))) + 1;
        borci.dataCadastro              = invdata.inverterData(cdh.CapturarData(), 2);
        borci.horaCadastro              = cdh.CapturaHora();
        borci.tipo                      = combo_tipo.getSelectedIndex();
        if(borci.tipo == 1)
            borci.codigoServicoProduto  = bp.codigoProduto;
        else
            borci.codigoServicoProduto  = bser.codigoServico;
        borci.valorUnitario             = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_valorUnitario.getText(), 1));
        borci.quantidade                = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_quantidade.getText(), 1));
        borci.valorTotal                = borci.valorUnitario * borci.quantidade;
    }
    
    private void IncluirOrcamentoItem(){
        PegaValoresOrcamentoItem();
        
        sql = "insert into tb_orcamentos_itens (idEmpresa, codigoGrupo, codigoEmpresa, codigoOrcamento, codigoOrcamentoItem, codigoServicoProduto, dataCadastro, horaCadastro, tipo, valorUnitario, quantidade, valorTotal) "
            + "values (" + borci.idEmpresa + ", " + borci.codigoGrupo + ", " + borci.codigoEmpresa + ", " + borci.codigoOrcamento + ", " + borci.codigoOrcamentoItem + ", " + borci.codigoServicoProduto + ", '" + borci.dataCadastro + "', '" + borci.horaCadastro + "', " + borci.tipo + ", " + borci.valorUnitario + ", " + borci.quantidade + ", " + borci.valorTotal + ");";
        
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        PegaOrcamentoItens();
    }
    
}
