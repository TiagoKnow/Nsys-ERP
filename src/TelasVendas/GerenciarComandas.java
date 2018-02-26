package TelasVendas;

import Beans.BeanComandas;
import Beans.BeanComandasItens;
import Beans.BeanProdutos;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.TransformaValorStringeDouble;
import TelasEstoque.ProdutosConsulta;
import Parametros.parametrosNS;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/*
 @author Tiago e Paulo 19/08/2016 at 15:30
 */
public class GerenciarComandas extends javax.swing.JFrame {
    //String's
    String sql      = "";
    String sqlstate = "";
    String Mensagem = "";
    String somostra = "";
    String retorno  = "";
    
    //int's
    int    Linha                    = 0;
    int    QtdPessoas               = 0;
    int    abriuComanda             = 0;
    int    abriuProduto             = 0;
    int    abriuComandaFinalizada   = 0;
    
    //Double's
    double ValorTotal           = 0;
    double ValorTotalADividir   = 0;
    
    //ArrayList's
    ArrayList            parametros             = new ArrayList();
    ArrayList            dadosPadroes           = new ArrayList();
    ArrayList<ArrayList> dadosComandas          = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosComandasItens     = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosProdutos          = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosCount             = new ArrayList<ArrayList>();
    
    //Bean's
    BeanComandas                    bcom    = new BeanComandas();
    BeanComandasItens               bcomi   = new BeanComandasItens();
    BeanProdutos                    bp      = new BeanProdutos();
    
    //Especiais
    FormataCampo                    fc          = new FormataCampo();
    DefaultTableModel               TableItensComadas;
    TransformaValorStringeDouble    TransStrDou = new TransformaValorStringeDouble();
    
    //Telas
    PDV                     Pdv;
    ComandasConsulta        ComCon;
    ProdutosConsulta        ProCon;
    
    public GerenciarComandas(ArrayList DadosPadroes){
        dadosPadroes                            = DadosPadroes;
        
        somostra                                = (String)  dadosPadroes.get(0);
        bcom.codigoBarrasComanda                = (String)  dadosPadroes.get(1);
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_limpar = new javax.swing.JMenuItem();
        bt_remover = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_codigoBarrasComanda = new javax.swing.JTextField();
        bt_pesquisarComanda = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        bt_pesquisaProduto = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_valortotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        label_descricaoProduto = new javax.swing.JLabel();
        txt_codigoBarrasProduto = new javax.swing.JTextField();
        bt_adicionar = new javax.swing.JButton();
        txt_quantidade = new javax.swing.JFormattedTextField();
        txt_valorUnitario = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        label_statusComanda = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_itens_comandas = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_qtdDePessoas = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_valoradividir = new javax.swing.JTextField();
        bt_finalizar = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair1 = new javax.swing.JMenuItem();

        bt_limpar.setText("Limpar tabela de Itens");
        bt_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_limparActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_limpar);

        bt_remover.setText("Remover Item selecionado");
        bt_remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_removerActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_remover);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciador de Comandas");
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Localizar Comanda");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_codigoBarrasComanda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoBarrasComandaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoBarrasComandaFocusLost(evt);
            }
        });
        txt_codigoBarrasComanda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoBarrasComandaKeyPressed(evt);
            }
        });

        bt_pesquisarComanda.setText("...");
        bt_pesquisarComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisarComandaActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Código de barras: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_codigoBarrasComanda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_pesquisarComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoBarrasComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisarComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisarComanda, jLabel2, txt_codigoBarrasComanda});

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Produtos para Venda");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_codigoBarrasProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoBarrasProdutoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoBarrasProdutoFocusLost(evt);
            }
        });
        txt_codigoBarrasProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoBarrasProdutoActionPerformed(evt);
            }
        });
        txt_codigoBarrasProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoBarrasProdutoKeyPressed(evt);
            }
        });

        bt_adicionar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_adicionar.setText("Adicionar");
        bt_adicionar.setEnabled(false);
        bt_adicionar.setFocusable(false);
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

        txt_quantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_codigoBarrasProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(txt_valorUnitario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(bt_pesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_descricaoProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_quantidade, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_valortotal, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(8, 8, 8)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_descricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txt_codigoBarrasProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_pesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_valortotal, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13)
                    .addComponent(bt_adicionar)
                    .addComponent(txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_valorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaProduto, jLabel6, label_descricaoProduto, txt_codigoBarrasProduto});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_adicionar, jLabel10, jLabel12, jLabel13, txt_quantidade, txt_valorUnitario, txt_valortotal});

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Status da Comanda");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        label_statusComanda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label_statusComanda.setForeground(new java.awt.Color(0, 204, 0));
        label_statusComanda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_statusComanda.setText("Livre");
        label_statusComanda.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        label_statusComanda.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_statusComanda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_statusComanda, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Itens da Comanda");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_itens_comandas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_itens_comandas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Descrição", "Valor Unitário", "Quantidade", "Valor Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_itens_comandas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_itens_comandas.getTableHeader().setReorderingAllowed(false);
        tabela_itens_comandas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_itens_comandasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabela_itens_comandas);
        tabela_itens_comandas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tabela_itens_comandas.getColumnModel().getColumnCount() > 0) {
            tabela_itens_comandas.getColumnModel().getColumn(0).setResizable(false);
            tabela_itens_comandas.getColumnModel().getColumn(1).setResizable(false);
            tabela_itens_comandas.getColumnModel().getColumn(2).setResizable(false);
            tabela_itens_comandas.getColumnModel().getColumn(3).setResizable(false);
            tabela_itens_comandas.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Funções de Atalho");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("F6 - Seleciona item");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("DEL - Exclui item");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("Esc - Sair/Cancelar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel24))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel20, jLabel21, jLabel24});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel20, jLabel21, jLabel24});

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Totais da Comanda");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_total.setEditable(false);
        txt_total.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_total.setForeground(new java.awt.Color(51, 51, 51));
        txt_total.setText("R$ 0,00");
        txt_total.setFocusable(false);
        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Total:");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Valor Total dividido em ");

        try {
            txt_qtdDePessoas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_qtdDePessoas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_qtdDePessoas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_qtdDePessoasFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_qtdDePessoasFocusLost(evt);
            }
        });
        txt_qtdDePessoas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_qtdDePessoasKeyPressed(evt);
            }
        });

        jLabel11.setText("pessoas");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Valor Parcial:");

        txt_valoradividir.setEditable(false);
        txt_valoradividir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_valoradividir.setFocusable(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel14))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txt_qtdDePessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11))
                    .addComponent(txt_valoradividir, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel14, jLabel19, jLabel9});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_qtdDePessoas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_valoradividir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel11, jLabel14, jLabel9, txt_qtdDePessoas, txt_valoradividir});

        bt_finalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/vend.png"))); // NOI18N
        bt_finalizar.setText("Finalizar");
        bt_finalizar.setEnabled(false);
        bt_finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_finalizarActionPerformed(evt);
            }
        });

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        jMenu1.setText("Funções");

        bt_sair1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        bt_sair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair1.setText("Sair");
        bt_sair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sair1ActionPerformed(evt);
            }
        });
        jMenu1.add(bt_sair1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_finalizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_sair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_finalizar, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoBarrasProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoBarrasProdutoFocusGained
        txt_codigoBarrasProduto .setText("");
        label_descricaoProduto  .setText("");
        txt_valorUnitario       .setText("");
        txt_quantidade          .setText("");
        txt_valortotal          .setText("");
        bt_adicionar            .setEnabled  (false);
        bt_adicionar            .setFocusable(false);
    }//GEN-LAST:event_txt_codigoBarrasProdutoFocusGained

    private void txt_codigoBarrasProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoBarrasProdutoFocusLost
        if(somostra.equals("S"))
            return;
        if(bcom.statusComanda == 2)
            return;
        bp.codigoDeBarras   = txt_codigoBarrasProduto.getText();
        if(bp.codigoDeBarras.equals(""))
            return;
        sql = "select " +
              "   idProdutos, \n" +
              "   idEmpresa, \n" +
              "   codigoGrupo, \n" +
              "   codigoEmpresa, \n" +
              "   codigoProduto, \n" +
              "   produtoInativo, \n" +
              "   descricaoProduto, \n" +
              "   valorDeCompra, \n" +
              "   valorDeVenda, \n" +
              "   quantidadeMinima, \n" +
              "   quantidadeIdeal, \n" +
              "   quantidadeAtual " +
              "from tb_produtos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoDeBarras = '" + bp.codigoDeBarras + "';";
        PegaProduto("S");
        label_descricaoProduto.setText(bp.descricaoProduto);
        txt_valorUnitario.setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(bp.valorDeVenda), 0));
        txt_quantidade.grabFocus();
    }//GEN-LAST:event_txt_codigoBarrasProdutoFocusLost

    private void bt_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_adicionarActionPerformed
        if(somostra.equalsIgnoreCase("S"))
            return;
        IncluirItemComanda();
    }//GEN-LAST:event_bt_adicionarActionPerformed

    private void bt_adicionarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bt_adicionarKeyPressed
        if(somostra.equals("S"))
            return;
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            IncluirItemComanda();
    }//GEN-LAST:event_bt_adicionarKeyPressed

    private void txt_quantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantidadeFocusLost
        if(somostra.equals("S"))
            return;
        if(bcom.statusComanda == 2)
            return;
        if(txt_valorUnitario.getText().replace(" ", "").equals(""))
            return;
        if(txt_quantidade.getText().replace(" ", "").equals("")){
            bcomi.quantidade = 0;
            return;
        }
        try{
            bcomi.quantidade              = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_quantidade.getText(), 1));
        }catch(Exception erro){
            Mensagem = "Quantidade inválida!";
            new MostraMensagem(Mensagem);
            return;
        }
        if(bcomi.quantidade > bp.quantidadeAtual){
            Mensagem = "Quantidade incluida maior do que em estoque!";
            new MostraMensagem(Mensagem);
//            return;
        }
        bcomi.valorUnitario             = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_valorUnitario.getText(), 1));
        bcomi.valorTotal                = bcomi.valorUnitario * bcomi.quantidade;
        txt_valortotal.setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(bcomi.valorTotal), 0));
        bt_adicionar.setFocusable(true);
        bt_adicionar.setEnabled(true);
        bt_adicionar.grabFocus();
    }//GEN-LAST:event_txt_quantidadeFocusLost

    private void txt_quantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_quantidadeKeyPressed
        if(txt_valorUnitario.getText().replace(" ", "").equals(""))
            return;
        if(somostra.equals("S"))
            return;
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            bt_adicionar.setFocusable(true);
            bt_adicionar.grabFocus();
        }
    }//GEN-LAST:event_txt_quantidadeKeyPressed

    private void tabela_itens_comandasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_itens_comandasMouseClicked
        Linha   = tabela_itens_comandas.getSelectedRow();
        if(Linha < 0){
            Mensagem = "Item não selecionado!";
            new MostraMensagem(Mensagem);
            return;
        }
        if(evt.getButton() == MouseEvent.BUTTON3)
            MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_tabela_itens_comandasMouseClicked

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void txt_codigoBarrasComandaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoBarrasComandaFocusLost
        if(txt_codigoBarrasComanda.isEditable() == false)
            return;
        if(txt_codigoBarrasComanda.getText().equals(""))
            return;
        PegaComanda();
    }//GEN-LAST:event_txt_codigoBarrasComandaFocusLost

    private void txt_qtdDePessoasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_qtdDePessoasKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(txt_qtdDePessoas.getText().replace(" ", "").equals("")){
                bt_finalizar.grabFocus();
                return;
            }
            txt_valoradividir.grabFocus();
            txt_qtdDePessoas.grabFocus();
        }
    }//GEN-LAST:event_txt_qtdDePessoasKeyPressed

    private void txt_qtdDePessoasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_qtdDePessoasFocusLost
        if(txt_qtdDePessoas.getText().replace(" ", "").equals(""))
            return;
        txt_qtdDePessoas.setText(fc.FormataCampo(txt_qtdDePessoas.getText(), 3, 0));
        ValorTotal              = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_total.getText(), 1));
        QtdPessoas              = Integer.parseInt(txt_qtdDePessoas.getText());
        ValorTotalADividir      = ValorTotal / QtdPessoas;
        txt_valoradividir.setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotalADividir), 0));
    }//GEN-LAST:event_txt_qtdDePessoasFocusLost

    private void txt_qtdDePessoasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_qtdDePessoasFocusGained
        txt_qtdDePessoas.setSelectionStart(0);
        txt_qtdDePessoas.setSelectionEnd  (txt_qtdDePessoas.getText().length());
    }//GEN-LAST:event_txt_qtdDePessoasFocusGained

    private void bt_finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_finalizarActionPerformed
        if(Pdv != null)if(Pdv.isVisible()){
            Mensagem = "Tela já Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuComandaFinalizada = 1;
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        parametros.add(bcom.codigoComanda);
        parametros.add(0);
        parametros.add(0);
        Pdv = new PDV(parametros);
        Pdv.setVisible(true);
    }//GEN-LAST:event_bt_finalizarActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuComanda == 0){
            AbreProdutos();
            return;
        }
        abriuComanda = 0;
        retorno = ComCon.getRetornoComanda();
        if(retorno.equals(""))
            return;
        txt_codigoBarrasComanda.setText(retorno);
        PegaComanda();
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbreProdutos(){
        if(abriuProduto == 0){
            AbreComandaFinalizada();
            return;
        }
        abriuProduto = 0;
        retorno = ProCon.getRetorno();
        if(retorno.equals(""))
            return;
        bp.codigoDeBarras   = retorno;
        txt_codigoBarrasProduto.setText(bp.codigoDeBarras);
        sql = "select " +
              "   idProdutos, \n" +
              "   idEmpresa, \n" +
              "   codigoGrupo, \n" +
              "   codigoEmpresa, \n" +
              "   codigoProduto, \n" +
              "   produtoInativo, \n" +
              "   descricaoProduto, \n" +
              "   valorDeCompra, \n" +
              "   valorDeVenda, \n" +
              "   quantidadeMinima, \n" +
              "   quantidadeIdeal, \n" +
              "   quantidadeAtual " +
              "from tb_produtos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoDeBarras = '" + bp.codigoDeBarras + "';";
        PegaProduto("S");
        label_descricaoProduto.setText(bp.descricaoProduto);
        txt_valorUnitario.setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(bp.valorDeVenda), 0));
        txt_quantidade.grabFocus();
    }
    
    private void AbreComandaFinalizada(){
        if(abriuComandaFinalizada == 0)
            return;
        sqlstate = Pdv.getRetorno();
        if(!sqlstate.equalsIgnoreCase("ok"))
            return;
        abriuComandaFinalizada = 0;
        sql = "delete from tb_comandas_itens where idComanda = " + bcom.idComanda + ";";
        sqlstate = parametrosNS.dao.ExcluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        sql = "update tb_comandas set statusComanda = 0 where idComanda = " + bcom.idComanda + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoBarrasComanda.grabFocus();
    }
    
    private void bt_pesquisaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaProdutoActionPerformed
        if(ProCon != null)if(ProCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuProduto = 1;
        parametros.clear();
        parametros.add("N");
        parametros.add("cdb");
        ProCon = new ProdutosConsulta(parametros);
        ProCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaProdutoActionPerformed

    private void bt_pesquisarComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisarComandaActionPerformed
        if(ComCon != null)if(ComCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuComanda = 1;
        parametros.clear();
        parametros.add("S");
        parametros.add("CDB");
        ComCon = new ComandasConsulta(parametros);
        ComCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisarComandaActionPerformed

    private void txt_codigoBarrasComandaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoBarrasComandaFocusGained
        if(txt_codigoBarrasComanda.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        ReiniciaCampos();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoBarrasComandaFocusGained

    private void txt_codigoBarrasComandaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoBarrasComandaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            bt_pesquisarComanda.grabFocus();
    }//GEN-LAST:event_txt_codigoBarrasComandaKeyPressed

    private void txt_codigoBarrasProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoBarrasProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoBarrasProdutoActionPerformed

    private void txt_codigoBarrasProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoBarrasProdutoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(txt_codigoBarrasProduto.getText().equals("")){
                txt_qtdDePessoas.grabFocus();
                return;
            }
            txt_quantidade.grabFocus();
        }
    }//GEN-LAST:event_txt_codigoBarrasProdutoKeyPressed

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HabilitaCampos(false);
        TableItensComadas   = (DefaultTableModel)tabela_itens_comandas.getModel();
        
        if(somostra.equals("S")){
            bt_pesquisarComanda     .setEnabled(false);
            bt_pesquisaProduto      .setEnabled(false);
            bt_finalizar            .setVisible(false);
        }
        if(!bcom.codigoBarrasComanda.equals("")){
            txt_codigoBarrasComanda .setEditable(false);
            txt_codigoBarrasComanda .setText(bcom.codigoBarrasComanda);
            PegaComanda();
        }
    }//GEN-LAST:event_formWindowOpened

    private void bt_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_limparActionPerformed
        LimpaTabelaDeItens();
    }//GEN-LAST:event_bt_limparActionPerformed

    private void bt_removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_removerActionPerformed
        RemoverItem();
    }//GEN-LAST:event_bt_removerActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(Pdv      != null)Pdv     .dispose();
        if(ComCon   != null)ComCon  .dispose();
        if(ProCon   != null)ProCon  .dispose();
    }//GEN-LAST:event_formWindowClosed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JButton bt_adicionar;
    private javax.swing.JButton bt_finalizar;
    private javax.swing.JMenuItem bt_limpar;
    private javax.swing.JButton bt_pesquisaProduto;
    private javax.swing.JButton bt_pesquisarComanda;
    private javax.swing.JMenuItem bt_remover;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_descricaoProduto;
    private javax.swing.JLabel label_statusComanda;
    private javax.swing.JTable tabela_itens_comandas;
    private javax.swing.JTextField txt_codigoBarrasComanda;
    private javax.swing.JTextField txt_codigoBarrasProduto;
    private javax.swing.JFormattedTextField txt_qtdDePessoas;
    private javax.swing.JFormattedTextField txt_quantidade;
    private javax.swing.JTextField txt_total;
    private javax.swing.JFormattedTextField txt_valorUnitario;
    private javax.swing.JTextField txt_valoradividir;
    private javax.swing.JTextField txt_valortotal;
    // End of variables declaration//GEN-END:variables
    
    private void ReiniciaCampos(){
        label_statusComanda     .setText("Livre");
        label_statusComanda     .setForeground(new Color(0,204,0)); //Verde
        txt_codigoBarrasProduto .setText("");
        label_descricaoProduto  .setText("");
        txt_valorUnitario       .setText("");
        txt_quantidade          .setText("");
        txt_valortotal          .setText("");
        bt_adicionar            .setFocusable(false);
        bt_adicionar            .setEnabled(false);
        TableItensComadas       .setNumRows(0);
        ValorTotal = 0;
        txt_total               .setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotal), 0));
        txt_qtdDePessoas        .setText("");
        txt_valoradividir       .setText("");
        bt_finalizar            .setEnabled(false);
    }
    
    private void HabilitaCampos(boolean Habilita){
        txt_codigoBarrasProduto         .setEditable    (Habilita);
        txt_codigoBarrasProduto         .setFocusable   (Habilita);
        bt_pesquisaProduto              .setEnabled     (Habilita);
        bt_pesquisaProduto              .setFocusable   (Habilita);
        txt_quantidade                  .setEditable    (Habilita);
        txt_quantidade                  .setFocusable   (Habilita);
    }
    
    private void LimpaTabelaDeItens(){
        double quantidade           = 0;
        bcomi.idEmpresa             = bcom.idEmpresa;
        bcomi.codigoGrupo           = bcom.codigoGrupo;
        bcomi.codigoEmpresa         = bcom.codigoEmpresa;
        bcomi.codigoComanda         = bcom.codigoComanda;
        for(int i = 0; i < tabela_itens_comandas.getRowCount(); i++){
            bcomi.codigoComandaItem = Integer.parseInt  (String.valueOf(tabela_itens_comandas.getValueAt(i, 0)));
            bp.codigoProduto        = Integer.parseInt  (String.valueOf(tabela_itens_comandas.getValueAt(i, 1)).substring(0, 5));
            sql = "select " +
                  "   idProdutos, \n" +
                  "   idEmpresa, \n" +
                  "   codigoGrupo, \n" +
                  "   codigoEmpresa, \n" +
                  "   codigoProduto, \n" +
                  "   produtoInativo, \n" +
                  "   descricaoProduto, \n" +
                  "   valorDeCompra, \n" +
                  "   valorDeVenda, \n" +
                  "   quantidadeMinima, \n" +
                  "   quantidadeIdeal, \n" +
                  "   quantidadeAtual " +
                  "from tb_produtos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoProduto = " + bp.codigoProduto + ";";
            PegaProduto("N");
            quantidade              = Double.parseDouble(String.valueOf(tabela_itens_comandas.getValueAt(i, 3)));
            
            bp.quantidadeAtual      = bp.quantidadeAtual + quantidade;
            
            sql = "update tb_produtos set quantidadeAtual = " + bp.quantidadeAtual + " where idProdutos = " + bp.idProdutos + ";";
            sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
            if(!sqlstate.equals("00000")){
                Mensagem = "Erro ao Atualizar estoque do produto n°" + bp.codigoProduto + "!";
                new MostraMensagem(Mensagem);
                return;
            }
            sql = "delete from tb_comandas_itens where idEmpresa = " + bcomi.idEmpresa + " and codigoComanda = " + bcomi.codigoComanda + " and codigoComandaItem = " + bcomi.codigoComandaItem + ";";
            sqlstate = parametrosNS.dao.ExcluirRegistro(sql);
            if(!sqlstate.equals("00000"))
                return;
        }
        TableItensComadas   .setNumRows(0);
        bt_finalizar        .setEnabled(false);
        txt_total           .setText(TransStrDou.TransformaValorStringeDouble("0", 0));
        PegaComanda();
        if(tabela_itens_comandas.getRowCount() < 1){
            sql = "update tb_comandas set statusComanda = 0 where idComanda = " + bcom.idComanda + ";";
            parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "N");
        }
        PegaComanda();
    }
    
    private void RemoverItem(){
        if(Linha < 0){
            Mensagem = "Item nao selecionado!";
            new MostraMensagem(Mensagem);
            return;
        }
        bcomi.idEmpresa             = bcom.idEmpresa;
        bcomi.codigoGrupo           = bcom.codigoGrupo;
        bcomi.codigoEmpresa         = bcom.codigoEmpresa;
        bcomi.codigoComanda         = bcom.codigoComanda;
        bcomi.codigoComandaItem     = Integer.parseInt  (String.valueOf(tabela_itens_comandas.getValueAt(Linha, 0)));
        bp.codigoProduto            = Integer.parseInt  (String.valueOf(tabela_itens_comandas.getValueAt(Linha, 1)).substring(0, 5));
        sql = "select " +
              "idProdutos, \n" +
              "idEmpresa, \n" +
              "codigoGrupo, \n" +
              "codigoEmpresa, \n" +
              "codigoProduto, \n" +
              "produtoInativo, \n" +
              "descricaoProduto, \n" +
              "valorDeCompra, \n" +
              "valorDeVenda, \n" +
              "quantidadeMinima, \n" +
              "quantidadeIdeal, \n" +
              "quantidadeAtual " +
              "from tb_produtos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoProduto = " + bp.codigoProduto + ";";
        PegaProduto("N");
        double quantidade           = Double.parseDouble(String.valueOf(tabela_itens_comandas.getValueAt(Linha, 3)));
        
        bp.quantidadeAtual          = bp.quantidadeAtual + quantidade;
        
        sql = "update tb_produtos set quantidadeAtual = " + bp.quantidadeAtual + " where idProdutos = " + bp.idProdutos + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000")){
            Mensagem = "Erro ao Atualizar estoque do produto n°" + bp.codigoProduto + "!";
            new MostraMensagem(Mensagem);
            return;
        }
        
        sql = "delete from tb_comandas_itens where idEmpresa = " + bcomi.idEmpresa + " and codigoComanda = " + bcomi.codigoComanda + " and codigoComandaItem = " + bcomi.codigoComandaItem + ";";
        sqlstate = parametrosNS.dao.ExcluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        int codigoComandaItem   = 0;
        for(int i = Linha; i < tabela_itens_comandas.getRowCount(); i++){
            bcomi.codigoComandaItem = Integer.parseInt(String.valueOf(tabela_itens_comandas.getValueAt(i, 0)));
            codigoComandaItem       = bcomi.codigoComandaItem + 1;
            
            sql = "update tb_comandas_itens set codigoComandaItem = " + bcomi.codigoComandaItem + " where idEmpresa = " + bcomi.idEmpresa + " and codigoComanda = " + bcomi.codigoComanda + " and codigoComandaItem = " + codigoComandaItem + ";";
            sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        }
        PegaComanda();
        if(tabela_itens_comandas.getRowCount() < 1){
            sql = "update tb_comandas set statusComanda = 0 where idComanda = " + bcom.idComanda + ";";
            parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "N");
        }
        PegaComanda();
    }
    
    private void PegaProduto(String Mostra){
        dadosProdutos.clear();
        dadosProdutos = parametrosNS.dao.Consulta(sql);
        if(dadosProdutos.isEmpty()){
            if(Mostra.equals("N"))return;
            if(bp.codigoProduto != 0)
                bp.codigoDeBarras = String.valueOf(bp.codigoProduto);
            Mensagem = "Código de Barras " + bp.codigoDeBarras + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosProdutos(Mostra);
    }
    
    private void PegaDadosProdutos(String Mostra){
        for(int i = 0; i < dadosProdutos.size(); i++){
            bp  = new BeanProdutos();
            if(dadosProdutos.get(i).get(0)  != null){bp.idProdutos       = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(0)));}
            if(dadosProdutos.get(i).get(1)  != null){bp.idEmpresa        = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(1)));}
            if(dadosProdutos.get(i).get(2)  != null){bp.codigoGrupo      = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(2)));}
            if(dadosProdutos.get(i).get(3)  != null){bp.codigoEmpresa    = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(3)));}
            if(dadosProdutos.get(i).get(4)  != null){bp.codigoProduto    = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(4)));}
            if(dadosProdutos.get(i).get(5)  != null){bp.produtoInativo   = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(5)));}
            if(dadosProdutos.get(i).get(6)  != null){bp.descricaoProduto =                    String.valueOf(dadosProdutos.get(i).get(6));}
            if(dadosProdutos.get(i).get(7)  != null){bp.valorDeCompra    = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(7)));}
            if(dadosProdutos.get(i).get(8)  != null){bp.valorDeVenda     = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(8)));}
            if(dadosProdutos.get(i).get(9)  != null){bp.quantidadeMinima = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(9)));}
            if(dadosProdutos.get(i).get(10) != null){bp.quantidadeIdeal  = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(10)));}
            if(dadosProdutos.get(i).get(11) != null){bp.quantidadeAtual  = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(11)));}
        }
        if(Mostra.equals("N"))return;
        if(bp.quantidadeAtual < bp.quantidadeMinima){
            Mensagem = "Quantidade atual em estoque do produto n°" + bp.codigoProduto + " está abaixo do limite!";
            new MostraMensagem(Mensagem);
//            return;
        }
    }
    
    private void PegaValoresItemComanda(){
        bcomi.idEmpresa                 = bcom.idEmpresa;
        bcomi.codigoGrupo               = bcom.codigoGrupo;
        bcomi.codigoEmpresa             = bcom.codigoEmpresa;
        bcomi.codigoComanda             = bcom.codigoComanda;
        sql = "select count(*) from tb_comandas_itens where idEmpresa = " + bcomi.idEmpresa + " and codigoComanda = " + bcomi.codigoComanda + ";";
        dadosCount.clear();
        dadosCount = parametrosNS.dao.Consulta(sql);
        bcomi.codigoComandaItem         = Integer.parseInt(  String.valueOf(dadosCount.get(0).get(0))) + 1;
        bcomi.codigoProduto             = bp.codigoProduto;
        bcomi.codigoUsuario             = parametrosNS.bu.codigoUsuario;
        bcomi.valorUnitario             = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_valorUnitario.getText(), 1));
        bcomi.quantidade                = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_quantidade.getText(), 1));
        bcomi.valorTotal                = bcomi.valorUnitario * bcomi.quantidade;
        
        bp.quantidadeAtual      = bp.quantidadeAtual - bcomi.quantidade;
    }
    
    private void IncluirItemComanda(){
        PegaValoresItemComanda();
        
        sql = "insert into tb_comandas_itens (idEmpresa, codigoGrupo, codigoEmpresa, codigoComanda, codigoComandaItem, codigoProduto, codigoUsuario, valorUnitario, quantidade, valorTotal) "
            + "values (" + bcomi.idEmpresa + ", " + bcomi.codigoGrupo + ", " + bcomi.codigoEmpresa + ", " + bcomi.codigoComanda + ", " + bcomi.codigoComandaItem + ", " + bcomi.codigoProduto + ", " + bcomi.codigoUsuario + ", " + bcomi.valorUnitario + ", " + bcomi.quantidade + ", " + bcomi.valorTotal + ");";
        
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        sql = "update tb_comandas set statusComanda = 1 where idComanda = " + bcom.idComanda + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        sql = "update tb_produtos set quantidadeAtual = " + bp.quantidadeAtual + " where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoProduto = " + bp.codigoProduto + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        PegaComanda();
    }
    
    private void PegaComanda(){
        label_statusComanda     .setText("Livre");
        label_statusComanda     .setForeground(new Color(0,204,0)); //Verde
        bt_finalizar.setEnabled(false);
        bcom.codigoBarrasComanda    = txt_codigoBarrasComanda.getText();
        if(bcom.codigoBarrasComanda.equals(""))
            return;
        sql = "select * from tb_comandas where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoBarrasComanda = '" + bcom.codigoBarrasComanda + "';";
        dadosComandas.clear();
        dadosComandas = parametrosNS.dao.Consulta(sql);
        if(dadosComandas.isEmpty()){
            Mensagem = "Comanda " + bcom.codigoBarrasComanda + " não encontrada!";
            new MostraMensagem(Mensagem);
            return;
        }
        HabilitaCampos(true);
        PegaDadosComanda();
    }
    
    private void PegaDadosComanda(){
        for(int i = 0; i < dadosComandas.size(); i++){
            bcom = new BeanComandas();
            bcom.idComanda              = Integer.parseInt(  String.valueOf(dadosComandas.get(i).get(0)));
            bcom.idEmpresa              = Integer.parseInt(  String.valueOf(dadosComandas.get(i).get(1)));
            bcom.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosComandas.get(i).get(2)));
            bcom.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosComandas.get(i).get(3)));
            bcom.codigoComanda          = Integer.parseInt(  String.valueOf(dadosComandas.get(i).get(4)));
            bcom.codigoBarrasComanda    =                    String.valueOf(dadosComandas.get(i).get(5));
            bcom.statusComanda          = Integer.parseInt(  String.valueOf(dadosComandas.get(i).get(6)));
        }
        switch(bcom.statusComanda){
            case 0: label_statusComanda.setText("Livre");
                    label_statusComanda.setForeground(new Color(0,204,0)); break;   //Verde
            case 1: label_statusComanda.setText("Ocupada");
                    label_statusComanda.setForeground(new Color(204,0,0)); break;   //Amarela
            case 2: label_statusComanda.setText("Inativa");
                    label_statusComanda.setForeground(new Color(204,0,0)); break;   //Vermelha
        }
        if(bcom.statusComanda == 2){
            Mensagem = "Comanda se encontra Inativa!";
            new MostraMensagem(Mensagem);
            return;
        }
        
        bcomi.idEmpresa     = bcom.idEmpresa;
        bcomi.codigoGrupo   = bcom.codigoGrupo;
        bcomi.codigoEmpresa = bcom.codigoEmpresa;
        bcomi.codigoComanda = bcom.codigoComanda;
        PegaItensComandas();
        txt_codigoBarrasProduto.grabFocus();
    }
    
    private void PegaItensComandas(){
        TableItensComadas.setNumRows(0);
        ValorTotal          = 0;
        ValorTotalADividir  = 0;
        sql = "select * from tb_comandas_itens where idEmpresa = " + bcomi.idEmpresa + " and codigoComanda = " + bcomi.codigoComanda + ";";
        dadosComandasItens.clear();
        dadosComandasItens = parametrosNS.dao.Consulta(sql);
        PegaDadosItensComandas();
    }
    
    private void PegaDadosItensComandas(){
        tabela_itens_comandas.getColumnModel().getColumn(0).setResizable(false);
        tabela_itens_comandas.getColumnModel().getColumn(0).setPreferredWidth(75);
        tabela_itens_comandas.getColumnModel().getColumn(1).setResizable(false);
        tabela_itens_comandas.getColumnModel().getColumn(1).setPreferredWidth(300);
        tabela_itens_comandas.getColumnModel().getColumn(2).setResizable(false);
        tabela_itens_comandas.getColumnModel().getColumn(2).setPreferredWidth(125);
        tabela_itens_comandas.getColumnModel().getColumn(3).setResizable(false);
        tabela_itens_comandas.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabela_itens_comandas.getColumnModel().getColumn(4).setResizable(false);
        tabela_itens_comandas.getColumnModel().getColumn(4).setPreferredWidth(125);
        
        ValorTotal = 0;
        for(int i = 0; i < dadosComandasItens.size(); i++){
            bcomi = new BeanComandasItens();
            if(dadosComandasItens.get(i).get(0)  != null){bcomi.idComandaItem     = Integer.parseInt(  String.valueOf(dadosComandasItens.get(i).get(0)));}
            if(dadosComandasItens.get(i).get(1)  != null){bcomi.idEmpresa         = Integer.parseInt(  String.valueOf(dadosComandasItens.get(i).get(1)));}
            if(dadosComandasItens.get(i).get(2)  != null){bcomi.codigoGrupo       = Integer.parseInt(  String.valueOf(dadosComandasItens.get(i).get(2)));}
            if(dadosComandasItens.get(i).get(3)  != null){bcomi.codigoEmpresa     = Integer.parseInt(  String.valueOf(dadosComandasItens.get(i).get(3)));}
            if(dadosComandasItens.get(i).get(4)  != null){bcomi.codigoComanda     = Integer.parseInt(  String.valueOf(dadosComandasItens.get(i).get(4)));}
            if(dadosComandasItens.get(i).get(5)  != null){bcomi.codigoComandaItem = Integer.parseInt(  String.valueOf(dadosComandasItens.get(i).get(5)));}
            if(dadosComandasItens.get(i).get(6)  != null){bcomi.codigoProduto     = Integer.parseInt(  String.valueOf(dadosComandasItens.get(i).get(6)));}
            if(dadosComandasItens.get(i).get(7)  != null){bcomi.codigoUsuario     = Integer.parseInt(  String.valueOf(dadosComandasItens.get(i).get(7)));}
            if(dadosComandasItens.get(i).get(8)  != null){bcomi.valorUnitario     = Double.parseDouble(String.valueOf(dadosComandasItens.get(i).get(8)));}
            if(dadosComandasItens.get(i).get(9)  != null){bcomi.quantidade        = Double.parseDouble(String.valueOf(dadosComandasItens.get(i).get(9)));}
            if(dadosComandasItens.get(i).get(10) != null){bcomi.valorTotal        = Double.parseDouble(String.valueOf(dadosComandasItens.get(i).get(10)));}
            
            bp.codigoProduto    = bcomi.codigoProduto;
            sql = "select " +
                  "   idProdutos, \n" +
                  "   idEmpresa, \n" +
                  "   codigoGrupo, \n" +
                  "   codigoEmpresa, \n" +
                  "   codigoProduto, \n" +
                  "   produtoInativo, \n" +
                  "   descricaoProduto, \n" +
                  "   valorDeCompra, \n" +
                  "   valorDeVenda, \n" +
                  "   quantidadeMinima, \n" +
                  "   quantidadeIdeal, \n" +
                  "   quantidadeAtual " +
                  "from tb_produtos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoProduto = " + bp.codigoProduto + ";";
            PegaProduto("S");
            
            ValorTotal         += bcomi.valorTotal;
            
            TableItensComadas.addRow(new Object [] {fc.FormataCampo(String.valueOf(bcomi.codigoComandaItem), 2, 0), fc.FormataCampo(String.valueOf(bcomi.codigoProduto), 5, 0) + "-" + bp.descricaoProduto, TransStrDou.TransformaValorStringeDouble(String.valueOf(bcomi.valorUnitario), 0), bcomi.quantidade, TransStrDou.TransformaValorStringeDouble(String.valueOf(bcomi.valorTotal), 0)});
        }
        txt_total.setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotal), 0));
        bt_finalizar.setEnabled(true);
        txt_codigoBarrasProduto.grabFocus();
    }
    
}
