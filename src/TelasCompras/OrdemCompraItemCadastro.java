package TelasCompras;

import Beans.BeanOrdemCompra;
import Beans.BeanOrdemCompraItens;
import Beans.BeanProdutos;
import Beans.BeanUsuarios;
import BeansNS.BeanEmpresas;
import Parametros.parametrosNS;
import TelasEstoque.ProdutosConsulta;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/*
 @author Tiago e Paulo em 22/09/2017 as 15:34
 */
public class OrdemCompraItemCadastro extends javax.swing.JFrame {
    //String
    String sql          = "";
    String sqlstate     = "";
    String fatal        = "";
    String mensagem     = "";
    String somostra     = "";
    String operacao     = "";
    String retorno      = "";
    
    //int
    int    ultimoRegistroItem = 0;
    int    abriuProduto       = 0;
    
    //Vetores
    ArrayList            parametros             = new ArrayList();
    ArrayList            dadosPadroes           = new ArrayList();
    ArrayList<ArrayList> dadosCount             = new ArrayList();
    ArrayList<ArrayList> dadosEmpresas          = new ArrayList();
    ArrayList<ArrayList> dadosOrdemCompra       = new ArrayList();
    ArrayList<ArrayList> dadosOrdemCompraItens  = new ArrayList();
    ArrayList<ArrayList> dadosProdutos          = new ArrayList();
    ArrayList<ArrayList> dadosUsuarios          = new ArrayList();
    
    //Bean
    BeanEmpresas         be     = new BeanEmpresas();
    BeanOrdemCompra      boc    = new BeanOrdemCompra();
    BeanOrdemCompraItens boci   = new BeanOrdemCompraItens();
    BeanProdutos         bp     = new BeanProdutos();
    BeanUsuarios         bu     = new BeanUsuarios();
    
    //Telas
    ProdutosConsulta    ProCon;
    
    public OrdemCompraItemCadastro(ArrayList DadosPadroes){
        dadosPadroes = DadosPadroes;
        
        somostra                    = (String)  dadosPadroes.get(0);
        operacao                    = (String)  dadosPadroes.get(1);
        boci.codigoOrdemCompra      = (int)     dadosPadroes.get(2);
        boci.codigoOrdemCompraItem  = (int)     dadosPadroes.get(3);
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_codigoOrdemCompra = new javax.swing.JFormattedTextField();
        txt_codigoOrdemCompraItem = new javax.swing.JFormattedTextField();
        bt_novo = new javax.swing.JButton();
        label_nomeCliente = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigoEmpresa = new javax.swing.JFormattedTextField();
        label_nomeEmpresa = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_codigoProduto = new javax.swing.JFormattedTextField();
        bt_pesquisaProduto = new javax.swing.JButton();
        label_descricaoProduto = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_valorUnitario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_quantidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_valortotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        combo_tipoDesconto = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txt_valorDesconto = new javax.swing.JTextField();
        txt_valorSubtotal = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_codigoUsuario = new javax.swing.JFormattedTextField();
        label_nomeUsuario = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_dataCadastro = new javax.swing.JFormattedTextField();
        txt_horaCadastro = new javax.swing.JFormattedTextField();
        bt_incluir = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_imprimir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        label_alteracao = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        jLabel1.setText("Ordem de Compra");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_codigoOrdemCompra.setEditable(false);
        try {
            txt_codigoOrdemCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoOrdemCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoOrdemCompra.setEnabled(false);

        try {
            txt_codigoOrdemCompraItem.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoOrdemCompraItem.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoOrdemCompraItem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoOrdemCompraItemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoOrdemCompraItemFocusLost(evt);
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
                .addComponent(txt_codigoOrdemCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_codigoOrdemCompraItem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_novo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoOrdemCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoOrdemCompraItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, txt_codigoOrdemCompra, txt_codigoOrdemCompraItem});

        label_nomeCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Empresa Compradora");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_codigoEmpresa.setEditable(false);
        try {
            txt_codigoEmpresa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoEmpresa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoEmpresa.setFocusable(false);

        javax.swing.GroupLayout label_nomeClienteLayout = new javax.swing.GroupLayout(label_nomeCliente);
        label_nomeCliente.setLayout(label_nomeClienteLayout);
        label_nomeClienteLayout.setHorizontalGroup(
            label_nomeClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(label_nomeClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_codigoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_nomeEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        label_nomeClienteLayout.setVerticalGroup(
            label_nomeClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(label_nomeClienteLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(label_nomeClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nomeEmpresa))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        label_nomeClienteLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {label_nomeEmpresa, txt_codigoEmpresa});

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Itens");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Produto:");

        try {
            txt_codigoProduto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoProduto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoProdutoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoProdutoFocusLost(evt);
            }
        });
        txt_codigoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoProdutoKeyPressed(evt);
            }
        });

        bt_pesquisaProduto.setText("...");
        bt_pesquisaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaProdutoActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Valor unitário:");

        txt_valorUnitario.setEditable(false);
        txt_valorUnitario.setFocusable(false);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Quantidade: ");

        txt_quantidade.setEditable(false);
        txt_quantidade.setFocusable(false);
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

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Valor total: ");

        txt_valortotal.setEditable(false);
        txt_valortotal.setFocusable(false);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Valor Subtotal:");

        jLabel12.setText("Tipo de desconto:");

        combo_tipoDesconto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Real", "Porcentagem" }));
        combo_tipoDesconto.setEnabled(false);
        combo_tipoDesconto.setFocusable(false);
        combo_tipoDesconto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_tipoDescontoItemStateChanged(evt);
            }
        });
        combo_tipoDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo_tipoDescontoFocusLost(evt);
            }
        });
        combo_tipoDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo_tipoDescontoKeyPressed(evt);
            }
        });

        jLabel13.setText("Valor do desconto:");

        txt_valorDesconto.setEditable(false);
        txt_valorDesconto.setFocusable(false);
        txt_valorDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorDescontoFocusLost(evt);
            }
        });
        txt_valorDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_valorDescontoKeyPressed(evt);
            }
        });

        txt_valorSubtotal.setEditable(false);
        txt_valorSubtotal.setFocusable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txt_codigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_descricaoProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combo_tipoDesconto, 0, 110, Short.MAX_VALUE)
                            .addComponent(txt_valorUnitario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_valorDesconto)
                            .addComponent(txt_quantidade, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_valorSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_valortotal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel12, jLabel5, jLabel6});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel13, jLabel7});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_codigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_descricaoProduto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_valorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_valorSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_valortotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(combo_tipoDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txt_valorDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaProduto, jLabel12, jLabel13, jLabel3, jLabel5, jLabel6, jLabel7, jLabel8, label_descricaoProduto, txt_codigoProduto, txt_quantidade, txt_valorUnitario, txt_valortotal});

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Informações");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Digitado por:");

        txt_codigoUsuario.setEditable(false);
        try {
            txt_codigoUsuario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoUsuario.setFocusable(false);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Data do Cadastro:");

        txt_dataCadastro.setEditable(false);
        try {
            txt_dataCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataCadastro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataCadastro.setFocusable(false);

        txt_horaCadastro.setEditable(false);
        try {
            txt_horaCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_horaCadastro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_horaCadastro.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_codigoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_dataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_horaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(359, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_codigoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nomeUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_dataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_horaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, jLabel11, label_nomeUsuario, txt_codigoUsuario});

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

        bt_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Save.png"))); // NOI18N
        bt_alterar.setText("Alterar");
        bt_alterar.setEnabled(false);
        bt_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterarActionPerformed(evt);
            }
        });

        bt_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/print.png"))); // NOI18N
        bt_imprimir.setText("Imprimir OS");
        bt_imprimir.setEnabled(false);

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        label_alteracao.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_alteracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_alteracao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
        );

        jMenu1.setText("Arquivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        jMenuItem1.setText("Sair");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_nomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_incluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_alterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_imprimir)))
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_nomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txt_codigoOrdemCompra   .setText(parametrosNS.fc.FormataCampo(String.valueOf(boc.codigoOrdemCompra), 9, 0));
        txt_dataCadastro      .setText(parametrosNS.cdh.CapturarData());
        
        PegaOrdemCompra();
        if(operacao.equals("I")){NovoRegistro();}else{CarregaRegistro();}
        if(somostra.equals("S")){
            bt_incluir                  .setVisible (false);
            bt_alterar                  .setVisible (false);
            txt_codigoOrdemCompraItem   .setEditable(false);
            bt_novo                     .setEnabled (false);
            bt_pesquisaProduto          .setEnabled (false);
        }
    }//GEN-LAST:event_formWindowOpened

    private void txt_codigoOrdemCompraItemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoOrdemCompraItemFocusGained
        txt_codigoOrdemCompraItem.setSelectionStart(0);
        txt_codigoOrdemCompraItem.setSelectionEnd  (txt_codigoOrdemCompraItem.getText().length());
    }//GEN-LAST:event_txt_codigoOrdemCompraItemFocusGained

    private void txt_codigoOrdemCompraItemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoOrdemCompraItemFocusLost
        if(txt_codigoOrdemCompraItem.getText().replace(" ", "").equals(""))
            return;
        if(somostra.equals("S"))
            return;
        if(operacao.equals("I"))
            return;
        PegaOrdemCompraItem();
    }//GEN-LAST:event_txt_codigoOrdemCompraItemFocusLost

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        NovoRegistro();
    }//GEN-LAST:event_bt_novoActionPerformed
    
    private void NovoRegistro(){
        ReiniciaCampos();
        HabilitaCampos(true);
        
        operacao = "I";
        HabilitaBotoes();
        
        VerificaUltimoRegistro();
        boci.codigoOrdemCompraItem = ultimoRegistroItem + 1;
        txt_codigoOrdemCompraItem.setText(parametrosNS.fc.FormataCampo(String.valueOf(boci.codigoOrdemCompraItem), 2, 0));
    }
    
    private void CarregaRegistro(){
        bt_novo.setEnabled  (false);
        bt_novo.setFocusable(false);
        txt_codigoOrdemCompraItem.setEnabled  (false);
        txt_codigoOrdemCompraItem.setFocusable(false);
        txt_codigoOrdemCompraItem.setText(String.valueOf(boci.codigoOrdemCompraItem));
        PegaOrdemCompraItem();
    }
    
    private void VerificaUltimoRegistro(){
        sql = "select count(*) from tb_oc_itens where idOrdemCompra = " + boc.idOrdemCompra + ";";
        dadosCount.clear();
        dadosCount = parametrosNS.dao.Consulta(sql);
        ultimoRegistroItem = Integer.parseInt(  String.valueOf(dadosCount.get(0).get(0)));
    }
    
    private void txt_codigoProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoProdutoFocusGained
        ReiniciaCampos();
    }//GEN-LAST:event_txt_codigoProdutoFocusGained

    private void txt_codigoProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoProdutoFocusLost
        if(txt_codigoProduto.isEditable() == false)
            return;
        if(txt_codigoProduto.getText().replace(" ", "").equals(""))
            return;
        PegaProdutos();
    }//GEN-LAST:event_txt_codigoProdutoFocusLost

    private void txt_quantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantidadeFocusLost
        if(txt_quantidade.getText().equals(""))
            return;
        try{
            CalculaValores();
        }catch(Exception erro){
            mensagem = "Erro ao calcular valor total!";
            mostraMensagem();
        }
    }//GEN-LAST:event_txt_quantidadeFocusLost

    private void txt_quantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_quantidadeKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        combo_tipoDesconto.setEnabled  (true);
        combo_tipoDesconto.setFocusable(true);
        combo_tipoDesconto.grabFocus();
    }//GEN-LAST:event_txt_quantidadeKeyPressed

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        IncluirRegistro();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void txt_codigoProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoProdutoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            if(txt_codigoProduto.getText().equals("")){
                bt_incluir.grabFocus();
            }else{
                txt_quantidade.setEditable (true);
                txt_quantidade.setFocusable(true);
                txt_quantidade.grabFocus();
            }
    }//GEN-LAST:event_txt_codigoProdutoKeyPressed

    private void combo_tipoDescontoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_tipoDescontoItemStateChanged
        
    }//GEN-LAST:event_combo_tipoDescontoItemStateChanged

    private void combo_tipoDescontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_tipoDescontoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            bt_pesquisaProduto.grabFocus();
        }
    }//GEN-LAST:event_combo_tipoDescontoKeyPressed

    private void txt_valorDescontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valorDescontoKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
//        if(bv.status != 0)
//            return;
        bt_incluir.grabFocus();
    }//GEN-LAST:event_txt_valorDescontoKeyPressed

    private void txt_valorDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorDescontoFocusLost
        if(somostra.equals("S")){return;}
        try{
            if(txt_valorDesconto.getText().equals("")){
                txt_valorDesconto.setText("0");
                combo_tipoDesconto.setSelectedIndex(0);
            }
            boci.tipoDesconto    = combo_tipoDesconto.getSelectedIndex();
            if(boci.tipoDesconto == 0){
                boci.valorDesconto   = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorDesconto.getText(), 1));
                txt_valorDesconto.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(boci.valorDesconto), 0));
            }else{
                if(!txt_valorDesconto.getText().substring(txt_valorDesconto.getText().length() - 1, txt_valorDesconto.getText().length()).equals("%")){
                    txt_valorDesconto.setText(txt_valorDesconto.getText().replace(",", ".") + "%");
                }
                boci.valorDesconto = Double.parseDouble(txt_valorDesconto.getText().replace("%", "")) / 100;
            }
        }catch(Exception erro){
            mensagem = "Quantidade inválida!";
            mostraMensagem();
            return;
        }
        if(boci.tipoDesconto == 0){
            boci.valorTotal  = boci.valorSubtotal - boci.valorDesconto;
        }else{
            boci.valorTotal  = boci.valorSubtotal - (boci.valorSubtotal * boci.valorDesconto);
        }
        txt_valortotal.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(boci.valorTotal), 0));
        bt_incluir.grabFocus();
    }//GEN-LAST:event_txt_valorDescontoFocusLost

    private void combo_tipoDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo_tipoDescontoFocusLost
        txt_valorDesconto   .setEditable (true);
        txt_valorDesconto   .setFocusable(true);
        txt_valorDesconto   .setText("");
        txt_valortotal      .setText("");
        txt_valorDesconto.grabFocus();
    }//GEN-LAST:event_combo_tipoDescontoFocusLost

    private void bt_incluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bt_incluirKeyPressed
        IncluirRegistro();
    }//GEN-LAST:event_bt_incluirKeyPressed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        AlterarRegistro();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void bt_pesquisaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaProdutoActionPerformed
        if(ProCon != null){
            if(ProCon.isVisible()){
                ProCon.setState(JFrame.NORMAL);
                return;
            }
        }
        abriuProduto = 1;
        parametros.clear();
        parametros.add("N");
        parametros.add("Codigo");
        ProCon = new ProdutosConsulta(parametros);
        ProCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaProdutoActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuProduto == 0){
            return;
        }
        retorno = ProCon.getRetorno();
        if(retorno.equals(""))
            return;
        abriuProduto = 0;
        txt_codigoProduto.setText(parametrosNS.fc.FormataCampo(retorno, 6, 0));
        bp.codigoProduto = Integer.parseInt(txt_codigoProduto.getText());
        PegaProdutos();
    }//GEN-LAST:event_formWindowGainedFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_imprimir;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisaProduto;
    private javax.swing.JComboBox<String> combo_tipoDesconto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel label_alteracao;
    private javax.swing.JLabel label_descricaoProduto;
    private javax.swing.JPanel label_nomeCliente;
    private javax.swing.JLabel label_nomeEmpresa;
    private javax.swing.JLabel label_nomeUsuario;
    private javax.swing.JFormattedTextField txt_codigoEmpresa;
    private javax.swing.JFormattedTextField txt_codigoOrdemCompra;
    private javax.swing.JFormattedTextField txt_codigoOrdemCompraItem;
    private javax.swing.JFormattedTextField txt_codigoProduto;
    private javax.swing.JFormattedTextField txt_codigoUsuario;
    private javax.swing.JFormattedTextField txt_dataCadastro;
    private javax.swing.JFormattedTextField txt_horaCadastro;
    private javax.swing.JTextField txt_quantidade;
    private javax.swing.JTextField txt_valorDesconto;
    private javax.swing.JTextField txt_valorSubtotal;
    private javax.swing.JTextField txt_valorUnitario;
    private javax.swing.JTextField txt_valortotal;
    // End of variables declaration//GEN-END:variables
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    private void ReiniciaCampos(){
        txt_codigoProduto     .setText("");
        label_descricaoProduto.setText("");
        txt_valorUnitario     .setText("");
        txt_quantidade        .setText("");
        txt_valortotal        .setText("");
    }
    
    private void HabilitaCampos(boolean Habilita){
        txt_codigoProduto   .setEditable (Habilita);
        txt_codigoProduto   .setFocusable(Habilita);
        bt_pesquisaProduto  .setEnabled  (Habilita);
        bt_pesquisaProduto  .setFocusable(Habilita);
//        txt_valorUnitario   .setEditable (Habilita);
//        txt_valorUnitario   .setFocusable(Habilita);
        txt_quantidade      .setEditable (Habilita);
        txt_quantidade      .setFocusable(Habilita);
        txt_valorSubtotal   .setEditable (Habilita);
        txt_valorSubtotal   .setFocusable(Habilita);
        combo_tipoDesconto  .setEnabled  (Habilita);
        combo_tipoDesconto  .setFocusable(Habilita);
        txt_valorDesconto   .setEditable (Habilita);
        txt_valorDesconto   .setFocusable(Habilita);
//        txt_valorTotal      .setEditable (Habilita);
//        txt_valorTotal      .setFocusable(Habilita);
    }
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_incluir.setEnabled(true);
            bt_alterar.setEnabled(false);
            return;
        }
        if(operacao.equals("A")){
            bt_incluir.setEnabled(false);
            bt_alterar.setEnabled(true);
            return;
        }
        bt_incluir.setEnabled(false);
        bt_alterar.setEnabled(false);
    }
    
    private void PegaOrdemCompra(){
        boc.idEmpresa           = parametrosNS.be.IdEmpresa;
        boc.codigoGrupo         = parametrosNS.bge.CodigoGrupo;
        boc.codigoEmpresa       = parametrosNS.be.CodigoEmpresa;
        boc.codigoOrdemCompra   = boci.codigoOrdemCompra;
        sql = "select \n"
            + "   idOrdemCompra, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoOrdemCompra, \n"
            + "   codigoComprador \n"
            + "from tb_oc where idOrdemCompra = " + boc.idOrdemCompra + ";";
        dadosOrdemCompra.clear();
        dadosOrdemCompra = parametrosNS.dao.Consulta(sql);
        if(dadosOrdemCompra.isEmpty()){
            mensagem = "Ordem de Compra não encontrada!";
            mostraMensagem();
            return;
        }
        PegaDadosCompra();
    }
    
    private void PegaDadosCompra(){
        for(int i = 0; i < dadosOrdemCompra.size(); i++){
            if(dadosOrdemCompra.get(i).get(0) != null)
                boc.idOrdemCompra     = Integer.parseInt(String.valueOf(dadosOrdemCompra.get(i).get(0)));
            if(dadosOrdemCompra.get(i).get(1) != null)
                boc.idEmpresa         = Integer.parseInt(String.valueOf(dadosOrdemCompra.get(i).get(1)));
            if(dadosOrdemCompra.get(i).get(2) != null)
                boc.codigoGrupo       = Integer.parseInt(String.valueOf(dadosOrdemCompra.get(i).get(2)));
            if(dadosOrdemCompra.get(i).get(3) != null)
                boc.codigoEmpresa     = Integer.parseInt(String.valueOf(dadosOrdemCompra.get(i).get(3)));
            if(dadosOrdemCompra.get(i).get(4) != null)
                boc.codigoOrdemCompra = Integer.parseInt(String.valueOf(dadosOrdemCompra.get(i).get(4)));
            if(dadosOrdemCompra.get(i).get(5) != null)
                boc.codigoComprador   = Integer.parseInt(String.valueOf(dadosOrdemCompra.get(i).get(5)));
        }
        txt_codigoOrdemCompra.setText(parametrosNS.fc.FormataCampo(String.valueOf(boc.codigoOrdemCompra), 9, 0));
        
        be.idEmpresa        = boc.idEmpresa;
        be.codigoGrupo      = boc.codigoGrupo;
        be.codigoEmpresa    = boc.codigoEmpresa;
        txt_codigoEmpresa.setText(String.valueOf(be.codigoEmpresa));
        PegaEmpresa();
    }
    
    private void PegaOrdemCompraItem(){
        boci.idEmpresa          = boc.idEmpresa;
        boci.codigoGrupo        = boc.codigoGrupo;
        boci.codigoEmpresa      = boc.codigoEmpresa;
        boci.codigoOrdemCompra  = boc.codigoOrdemCompra;
        boci.codigoOrdemCompraItem = Integer.parseInt(txt_codigoOrdemCompraItem.getText().replace(" ", ""));
        if(boci.codigoOrdemCompraItem == 0)
            return;
        sql = "select * from tb_oc_itens where idEmpresa = " + boci.idEmpresa + " and codigoOrdemCompra = " + boci.codigoOrdemCompra + " and codigoOrdemCompraItem = " + boci.codigoOrdemCompraItem + ";";
        dadosOrdemCompraItens.clear();
        dadosOrdemCompraItens = parametrosNS.dao.Consulta(sql);
        if(dadosOrdemCompraItens.isEmpty()){
            mensagem = "Item " + boci.codigoOrdemCompraItem + " não encontrado para a OC n°" + boci.codigoOrdemCompraItem + ";";
            mostraMensagem();
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        HabilitaCampos(true);
        PegaDadosOrdemCompraItem();
    }
    
    private void PegaDadosOrdemCompraItem(){
        String desconto = "";
        for(int i = 0; i < dadosOrdemCompraItens.size(); i++){
            desconto = "";
            if(dadosOrdemCompraItens.get(i).get(0)  != null){boci.idOrdemCompraItem      = Integer.parseInt(  String.valueOf(dadosOrdemCompraItens.get(i).get(0)));}
            if(dadosOrdemCompraItens.get(i).get(1)  != null){boci.idEmpresa              = Integer.parseInt(  String.valueOf(dadosOrdemCompraItens.get(i).get(1)));}
            if(dadosOrdemCompraItens.get(i).get(2)  != null){boci.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosOrdemCompraItens.get(i).get(2)));}
            if(dadosOrdemCompraItens.get(i).get(3)  != null){boci.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosOrdemCompraItens.get(i).get(3)));}
            if(dadosOrdemCompraItens.get(i).get(4)  != null){boci.codigoOrdemCompra      = Integer.parseInt(  String.valueOf(dadosOrdemCompraItens.get(i).get(4)));}
            if(dadosOrdemCompraItens.get(i).get(5)  != null){boci.codigoOrdemCompraItem  = Integer.parseInt(  String.valueOf(dadosOrdemCompraItens.get(i).get(5)));}
            if(dadosOrdemCompraItens.get(i).get(6)  != null){boci.codigoUsuario          = Integer.parseInt(  String.valueOf(dadosOrdemCompraItens.get(i).get(6)));}
            if(dadosOrdemCompraItens.get(i).get(7)  != null){boci.codigoProduto          = Integer.parseInt(  String.valueOf(dadosOrdemCompraItens.get(i).get(7)));}
            if(dadosOrdemCompraItens.get(i).get(8)  != null){boci.dataCadastro           =                    String.valueOf(dadosOrdemCompraItens.get(i).get(8));}
            if(dadosOrdemCompraItens.get(i).get(9)  != null){boci.horaCadastro           =                    String.valueOf(dadosOrdemCompraItens.get(i).get(9));}
            if(dadosOrdemCompraItens.get(i).get(10) != null){boci.valorUnitario          = Double.parseDouble(String.valueOf(dadosOrdemCompraItens.get(i).get(10)));}
            if(dadosOrdemCompraItens.get(i).get(11) != null){boci.quantidade             = Double.parseDouble(String.valueOf(dadosOrdemCompraItens.get(i).get(11)));}
            if(dadosOrdemCompraItens.get(i).get(12) != null){boci.valorSubtotal          = Double.parseDouble(String.valueOf(dadosOrdemCompraItens.get(i).get(12)));}
            if(dadosOrdemCompraItens.get(i).get(13) != null){boci.tipoDesconto           = Integer.parseInt(  String.valueOf(dadosOrdemCompraItens.get(i).get(13)));}
            if(dadosOrdemCompraItens.get(i).get(14) != null){boci.valorDesconto          = Double.parseDouble(String.valueOf(dadosOrdemCompraItens.get(i).get(14)));}
            if(dadosOrdemCompraItens.get(i).get(15) != null){boci.valorTotal             = Double.parseDouble(String.valueOf(dadosOrdemCompraItens.get(i).get(15)));}
            if(dadosOrdemCompraItens.get(i).get(16) != null){boci.dataAlterou            =                    String.valueOf(dadosOrdemCompraItens.get(i).get(16));}
            if(dadosOrdemCompraItens.get(i).get(17) != null){boci.horaAlterou            =                    String.valueOf(dadosOrdemCompraItens.get(i).get(17));}
            if(dadosOrdemCompraItens.get(i).get(18) != null){boci.usuarioAlterou         = Integer.parseInt(  String.valueOf(dadosOrdemCompraItens.get(i).get(18)));}
            if(dadosOrdemCompraItens.get(i).get(19) != null){boci.idEmpresaAlterou       = Integer.parseInt(  String.valueOf(dadosOrdemCompraItens.get(i).get(19)));}
            if(dadosOrdemCompraItens.get(i).get(20) != null){boci.codigoGrupoAlterou     = Integer.parseInt(  String.valueOf(dadosOrdemCompraItens.get(i).get(20)));}
            if(dadosOrdemCompraItens.get(i).get(21) != null){boci.codigoEmpresaAlterou   = Integer.parseInt(  String.valueOf(dadosOrdemCompraItens.get(i).get(21)));}
        }
        txt_codigoOrdemCompraItem.setText(parametrosNS.fc.FormataCampo(txt_codigoOrdemCompraItem.getText(), 2, 0));
        
        txt_codigoProduto.setText(String.valueOf(boci.codigoProduto));
        PegaProdutos();
        
        txt_quantidade    .setText(String.valueOf(boci.quantidade));
        txt_valorSubtotal .setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(boci.valorSubtotal), 0));
        combo_tipoDesconto.setSelectedIndex(boci.tipoDesconto);
        if(boci.tipoDesconto == 0){
            desconto = String.valueOf(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(boci.valorDesconto), 0));
        }else{
            boci.valorDesconto = boci.valorDesconto * 100;
            desconto = parametrosNS.FcPor.FormataPorcentagem(boci.valorDesconto);
        }
        txt_valorDesconto .setText(desconto);
        txt_valortotal    .setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(boci.valorTotal), 0));
        
        bu.idEmpresa      = parametrosNS.be.IdEmpresa;
        bu.codigoGrupo    = parametrosNS.bge.CodigoGrupo;
        bu.codigoEmpresa  = parametrosNS.be.CodigoEmpresa;
        bu.codigoUsuario  = boci.codigoUsuario;
        txt_codigoUsuario.setText(parametrosNS.fc.FormataCampo(String.valueOf(bu.codigoUsuario), 3, 0));
        PegaUsuario();
        label_nomeUsuario.setText(bu.usuario);
        
        txt_dataCadastro.setText(parametrosNS.invdata.inverterData(boci.dataCadastro, 1));
        txt_horaCadastro.setText(boci.horaCadastro);
        
        if(boci.usuarioAlterou != 0){
            bu.usuario          = "NS3";
            boci.dataAlterou    = parametrosNS.invdata.inverterData(boci.dataAlterou, 1);
            if(parametrosNS.bu.codigoUsuario != 999){
                bu.idEmpresa        = boci.idEmpresaAlterou;
                bu.codigoGrupo      = boci.codigoGrupoAlterou;
                bu.codigoEmpresa    = boci.codigoEmpresaAlterou;
                bu.codigoUsuario    = boci.usuarioAlterou;
                PegaUsuario();
            }
            label_alteracao.setText("Última alteração feita em " + boci.dataAlterou + " às " + boci.horaAlterou + " por " + bu.usuario + ".");
        }
    }
    
    private void PegaEmpresa(){
        be.codigoEmpresa = Integer.parseInt(txt_codigoEmpresa.getText().replace(" ", ""));
        if(be.codigoEmpresa == 0)
            return;
        sql = "select idEmpresa, codigoGrupo, codigoEmpresa, nomeEmpresa from ns_empresas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + be.codigoEmpresa + ";";
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
        }
        txt_codigoEmpresa.setText(parametrosNS.fc.FormataCampo(String.valueOf(be.codigoEmpresa), 3, 0));
        label_nomeEmpresa.setText(be.nomeEmpresa);
    }
    
    private void PegaProdutos(){
        bp.codigoProduto = Integer.parseInt(parametrosNS.fc.FormataCampo(txt_codigoProduto.getText(), 6, 0));
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
        for(int i = 0; i < dadosProdutos.size(); i++){
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
        txt_codigoProduto.setText(parametrosNS.fc.FormataCampo(String.valueOf(bp.codigoProduto), 6, 0));
        label_descricaoProduto.setText(bp.descricaoProduto);
        txt_valorUnitario.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bp.valorDeVenda), 0));
        txt_quantidade.setText("");
        txt_quantidade.setEditable (true);
        txt_quantidade.setFocusable(true);
        txt_quantidade.grabFocus();
    }
    
    private void PegaUsuario(){
        bu.usuario = "---------";
        if(bu.codigoUsuario == 0)
            return;
        sql = "select usuario from tb_usuarios where idEmpresa = " + bu.idEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
        dadosUsuarios.clear();
        dadosUsuarios = parametrosNS.dao.Consulta(sql);
        if(dadosUsuarios.isEmpty()){
            mensagem = "Usuário " + bu.codigoUsuario + " não encontrato!";
            mostraMensagem();
            return;
        }
        PegaDadosUsuario();
    }
    
    private void PegaDadosUsuario(){
        for(int i = 0; i < dadosUsuarios.size(); i++){
            bu.usuario = String.valueOf(dadosUsuarios.get(i).get(0));
        }
    }
    
    private void CalculaValores(){
        boci.valorUnitario  = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorUnitario.getText(), 1));
        boci.quantidade     = Double.parseDouble(txt_quantidade.getText());
        boci.valorSubtotal  = boci.valorUnitario * boci.quantidade;
        txt_valorSubtotal.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(boci.valorSubtotal), 0));
    }
    
    private void PegaValores(){
        fatal = "N";
        boci.idEmpresa              = parametrosNS.be.IdEmpresa;
        boci.codigoGrupo            = parametrosNS.bge.CodigoGrupo;
        boci.codigoEmpresa          = parametrosNS.be.CodigoEmpresa;
        boci.codigoOrdemCompra      = boc.codigoOrdemCompra;
        boci.codigoOrdemCompraItem  = Integer.parseInt(parametrosNS.fc.FormataCampo(txt_codigoOrdemCompraItem.getText(), 2, 0));
        boci.codigoUsuario          = parametrosNS.bu.codigoUsuario;
        boci.codigoProduto          = Integer.parseInt(parametrosNS.fc.FormataCampo(txt_codigoProduto.getText(), 6, 0));
        if(boci.codigoProduto == 0){
            mensagem = "Produto inválido!";
            mostraMensagem();
            fatal = "S";
            return;
        }
        boci.dataCadastro           = parametrosNS.invdata.inverterData(parametrosNS.cdh.CapturarData(), 2);
        boci.horaCadastro           = parametrosNS.cdh.CapturaHora();
        
        if(!txt_valorUnitario.getText().equals("")){
            boci.valorUnitario      = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorUnitario.getText(), 1));
        }
        if(!txt_quantidade.getText().equals("")){
            boci.quantidade         = Double.parseDouble(txt_quantidade.getText());
        }
        if(!txt_valorSubtotal.getText().equals("")){
            boci.valorSubtotal      = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorSubtotal.getText(), 1));
        }
        
        boci.tipoDesconto   = combo_tipoDesconto.getSelectedIndex();
        if(boci.tipoDesconto == 0){
            boci.valorDesconto  = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorDesconto.getText(), 1));
        }else{
            boci.valorDesconto  = Double.parseDouble(txt_valorDesconto.getText().replace("%", "")) / 100;
        }
        if(!txt_valortotal.getText().equals("")){
            boci.valorTotal     = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valortotal.getText(), 1));
        }
        
        boci.dataAlterou          = parametrosNS.invdata.inverterData(parametrosNS.cdh.CapturarData(), 2);
        boci.horaAlterou          = parametrosNS.cdh.CapturaHora();
        boci.usuarioAlterou       = parametrosNS.bu.codigoUsuario;
        boci.idEmpresaAlterou     = parametrosNS.be.idEmpresa;
        boci.codigoGrupoAlterou   = parametrosNS.bge.codigoGrupo;
        boci.codigoEmpresaAlterou = parametrosNS.be.codigoEmpresa;
    }
    
    private void IncluirRegistro(){
        PegaValores();
        if(fatal.equals("S")){
            return;
        }
        sql = "insert into tb_oc_itens (idEmpresa, codigoGrupo, codigoEmpresa, codigoOrdemCompra, codigoOrdemCompraItem, codigoUsuario, codigoProduto, dataCadastro, horaCadastro, valorUnitario, quantidade, valorSubtotal, tipoDesconto, valorDesconto, valorTotal) "
            + "values (" + boci.idEmpresa + ", " + boci.codigoGrupo + ", " + boci.codigoEmpresa + ", " + boci.codigoOrdemCompra + ", " + boci.codigoOrdemCompraItem + ", " + boci.codigoUsuario + ", " + boci.codigoProduto + ", '" + boci.dataCadastro + "', '" + boci.horaCadastro + "', " + boci.valorUnitario + ", " + boci.quantidade + ", " + boci.valorSubtotal + ", " + boci.tipoDesconto + ", " + boci.valorDesconto + ", " + boci.valorTotal + ");";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao incluir registro!";
            mostraMensagem();
            return;
        }
        AtualizaEstoque();
        if(fatal.equals("S"))
            return;
        mensagem = "Registro incluído com sucesso!";
        mostraMensagem();
        NovoRegistro();
    }
    
    private void AlterarRegistro(){
        AtualizaEstoque();
        if(fatal.equals("S")){return;}
        PegaValores();
        if(fatal.equals("S")){return;}
        sql = "update tb_oc_itens set codigoProduto = "             + boci.codigoProduto        + ", "  + 
                                     "valorUnitario = "             + boci.valorUnitario        + ", "  +
                                     "quantidade = "                + boci.quantidade           + ", "  +
                                     "valorSubtotal = "             + boci.valorSubtotal        + ", "  +
                                     "tipoDesconto = "              + boci.tipoDesconto         + ", "  +
                                     "valorDesconto = "             + boci.valorDesconto        + ", "  +
                                     "valorTotal = "                + boci.valorTotal           + ", "  +
                                     "dataAlterou = '"              + boci.dataAlterou          + "', " +
                                     "horaAlterou = '"              + boci.horaAlterou          + "', " +
                                     "usuarioAlterou = "            + boci.usuarioAlterou       + ", "  +
                                     "idEmpresaAlterou = "          + boci.idEmpresaAlterou     + ", "  +
                                     "codigoGrupoAlterou = "        + boci.codigoGrupoAlterou   + ", "  +
                                     "codigoEmpresaAlterou = "      + boci.codigoEmpresaAlterou + " "   +
                                     "where idOrdemCompraItem = " + boci.idOrdemCompraItem + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "N");
        if(!sqlstate.equals("00000")){
            return;
        }
        operacao = "I";
        AtualizaEstoque();
        dispose();
    }
    
    private void AtualizaEstoque(){
        bp.codigoProduto    = boci.codigoProduto;
        PegaProdutos();
        if(fatal.equals("S"))return;
        PegaDadosProdutos();
        if(operacao.equals("I")){
            bp.quantidadeAtual = bp.quantidadeAtual - boci.quantidade;
        }else{
            bp.quantidadeAtual = bp.quantidadeAtual + boci.quantidade;
        }
        
        sql = "update tb_produtos set quantidadeAtual = " + bp.quantidadeAtual + " where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoProduto = " + bp.codigoProduto + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(sqlstate.equals("00000"))
            return;
        mensagem = "Erro ao atualizar estoque do produto n°" + bp.codigoProduto + "!";
        mostraMensagem();
        fatal = "S";
    }
    
}
