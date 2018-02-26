package TelasProducao;

import Beans.*;
import FuncoesInternas.*;
import java.awt.event.KeyEvent;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import Parametros.parametrosNS;
import java.awt.event.MouseEvent;
/*
 @author Tiago e Paulo
 */
public class EfetuarPagamento extends javax.swing.JFrame {
    //String's
    String sql         = "";
    String fatal       = "N";
    String mensagem    = "";
    String sqlstate    = "";
    String nomeArquivo = "";
    String Tipo        = "";
    String CpfNaNota   = "N";
    String codigoPlanoDeContasRel = "";
    
    //int's
    int    linha                  = 0;
    int    Confirmacao            = 0;
    int    qtdDeParcelas          = 0;
    
    //Vetores
    ArrayList            parametros                     = new ArrayList();
    ArrayList            dadosPadroes                   = new ArrayList();
    ArrayList            dadosCupom                     = new ArrayList();
    ArrayList<ArrayList> dadosComandas                  = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosComandasItens             = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosCliente                   = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosProdutos                  = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosServicos                  = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosFormasPagamentos          = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosOrdemServico              = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosOrdemServicoItens         = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosRelacionamento            = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosVendasAssociativo         = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosVendas                    = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosVendasItens               = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosVendasPagamentos          = new ArrayList<ArrayList>();
    
    //Bean's
    BeanCupom                         bcu     = new BeanCupom();
    BeanComandas                      bcom    = new BeanComandas();
    BeanComandasItens                 bcomi   = new BeanComandasItens();
    BeanClientes                      bc      = new BeanClientes();
    BeanProdutos                      bp      = new BeanProdutos();
    BeanServicos                      bser    = new BeanServicos();
    BeanFormasPagamentos              bfp     = new BeanFormasPagamentos();
    BeanOrdemServico                  bos     = new BeanOrdemServico();
    BeanOrdemServicoItens             bosi    = new BeanOrdemServicoItens();
    BeanOrdemServicoPagamentos        bosp    = new BeanOrdemServicoPagamentos();
    BeanOrdemServicoPagamentosCredito bospc   = new BeanOrdemServicoPagamentosCredito();
    BeanPlanoDeContasRelacionamento   bplarel = new BeanPlanoDeContasRelacionamento();
    BeanPlanoDeContasMovimentos       bplamov = new BeanPlanoDeContasMovimentos();
    BeanVendas                        bv      = new BeanVendas();
    BeanVendasItens                   bvi     = new BeanVendasItens();
    BeanVendasPagamentos              bvp     = new BeanVendasPagamentos();
    BeanVendasPagamentosCredito       bvpc    = new BeanVendasPagamentosCredito();
    BeanUsuarios                      bu      = new BeanUsuarios();
    
    //Especiais
    InverterData                  invdata       = new InverterData();
    FormataCPFCNPJ                FCpfCnpj      = new FormataCPFCNPJ();
    FormataCampo                  fc            = new FormataCampo();
    FormataCampoCpfCnpj           FCampoCpfCnpj = new FormataCampoCpfCnpj();
    ValidarCpfCnpj                vcc           = new ValidarCpfCnpj();
    TransformaValorStringeDouble  TransStrDou   = new TransformaValorStringeDouble();
    NumberFormat                  nf            = new DecimalFormat("R$ ###,###,##0.00");
    ConverteValorDigitadoEmDouble conv          = new ConverteValorDigitadoEmDouble();
    DefaultTableModel             Table;
    DefaultTableModel             TablePagamento;
    
    //Outros
    ImprimeCupom        ic        = new ImprimeCupom();
    CapturarDataHora    cdh       = new CapturarDataHora();
    PegaProximoRegistro PegProReg = new PegaProximoRegistro();
    
    //Variaveis relacionadas a Tabela
    String  DescricaoProdutoServico         = "";
    double  PrecoTotalDosItens              = 0;
    double  ValorAPagar                     = 0;
    double  ValorRestante                   = 0;
    
    //Telas
    
    public EfetuarPagamento(ArrayList DadosPadroes, ArrayList DadosVendasAssociativo){
        dadosPadroes = DadosPadroes;
        dadosVendasAssociativo  = DadosVendasAssociativo;
        
        bos.idOrdemServico  = (int)     dadosPadroes.get(0);
        bv.codigoVenda      = (int)     dadosPadroes.get(1);
        bcom.codigoComanda  = (int)     dadosPadroes.get(2);
        bc.codigoCliente    = (int)     dadosPadroes.get(3);
        Tipo                = (String)  dadosPadroes.get(4);
        
        initComponents();
    }
    
    private void PegaRelacionamento(){
        sql = "select * from tb_planodecontasrelacionamento where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosRelacionamento.clear();
        dadosRelacionamento = parametrosNS.dao.Consulta(sql);
        if(dadosRelacionamento.isEmpty()){
//            mensagem = "Não foi encontrado Relacionamento Contábil!";
//            mostraMensagem();
            return;
        }
        PegaDadosRelacionamento();
    }
    
    private void PegaDadosRelacionamento(){
        for(int i = 0; i < dadosRelacionamento.size(); i++){
            if(dadosRelacionamento.get(i).get(0) != null){bplarel.idPlanoDeContasRelacionamento   = Integer.parseInt(String.valueOf(dadosRelacionamento.get(i).get(0)));}
            if(dadosRelacionamento.get(i).get(1) != null){bplarel.codigoGrupo                     = Integer.parseInt(String.valueOf(dadosRelacionamento.get(i).get(1)));}
            if(dadosRelacionamento.get(i).get(2) != null){bplarel.codigoEmpresa                   = Integer.parseInt(String.valueOf(dadosRelacionamento.get(i).get(2)));}
            if(dadosRelacionamento.get(i).get(3) != null){bplarel.codigoPlanoDeContasVendas       =                  String.valueOf(dadosRelacionamento.get(i).get(3));}
            if(dadosRelacionamento.get(i).get(4) != null){bplarel.codigoPlanoDeContasOS           =                  String.valueOf(dadosRelacionamento.get(i).get(4));}
            if(dadosRelacionamento.get(i).get(5) != null){bplarel.codigoPlanoDeContasBoletos      =                  String.valueOf(dadosRelacionamento.get(i).get(5));}
            if(dadosRelacionamento.get(i).get(6) != null){bplarel.codigoPlanoDeContasRecibos      =                  String.valueOf(dadosRelacionamento.get(i).get(6));}
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_limpar = new javax.swing.JMenuItem();
        bt_remover = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_detalhes = new javax.swing.JTable();
        txt_precoTotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_codigoCliente = new javax.swing.JFormattedTextField();
        label_nomeCliente = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        txt_cpfcnpj1 = new javax.swing.JFormattedTextField();
        txt_cpfcnpj2 = new javax.swing.JFormattedTextField();
        txt_cpfcnpj3 = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        combo_Pagamento = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_pagamento = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txt_valor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_valorAPagar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_valorRestante = new javax.swing.JTextField();
        bt_finalizar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair = new javax.swing.JMenuItem();

        bt_limpar.setText("Limpar Tabela de Pagamentos");
        bt_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_limparActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_limpar);

        bt_remover.setText("Remover Pagamento Selecionado");
        bt_remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_removerActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_remover);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
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
        jLabel1.setText("Detalhes Da compra");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_detalhes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_detalhes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Produto ou Serviço", "Preço Unitário", "Quantidade", "Valor Parcial", "Desconto", "Preço Total"
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
        tabela_detalhes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabela_detalhes);
        if (tabela_detalhes.getColumnModel().getColumnCount() > 0) {
            tabela_detalhes.getColumnModel().getColumn(0).setResizable(false);
            tabela_detalhes.getColumnModel().getColumn(0).setPreferredWidth(5);
            tabela_detalhes.getColumnModel().getColumn(1).setResizable(false);
            tabela_detalhes.getColumnModel().getColumn(1).setPreferredWidth(250);
            tabela_detalhes.getColumnModel().getColumn(2).setResizable(false);
            tabela_detalhes.getColumnModel().getColumn(2).setPreferredWidth(60);
            tabela_detalhes.getColumnModel().getColumn(3).setResizable(false);
            tabela_detalhes.getColumnModel().getColumn(3).setPreferredWidth(30);
            tabela_detalhes.getColumnModel().getColumn(4).setResizable(false);
            tabela_detalhes.getColumnModel().getColumn(5).setResizable(false);
            tabela_detalhes.getColumnModel().getColumn(6).setResizable(false);
            tabela_detalhes.getColumnModel().getColumn(6).setPreferredWidth(60);
        }

        txt_precoTotal.setEnabled(false);

        jLabel4.setText("Total dos itens");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_precoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_precoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel4, txt_precoTotal});

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Código");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_codigo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_codigo)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cliente");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_codigoCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoCliente.setEditable(false);
        try {
            txt_codigoCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoClienteFocusLost(evt);
            }
        });

        label_nomeCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_nomeClienteMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_codigoCliente)
                    .addComponent(label_nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        txt_cpfcnpj2.setEditable(false);
        try{
            txt_cpfcnpj2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cpfcnpj2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cpfcnpj2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_cpfcnpj2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cpfcnpj2FocusLost(evt);
            }
        });
        txt_cpfcnpj2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cpfcnpj2KeyPressed(evt);
            }
        });

        txt_cpfcnpj3.setEditable(false);
        try{
            txt_cpfcnpj3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cpfcnpj3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_cpfcnpj1, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cpfcnpj2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cpfcnpj3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cpfcnpj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cpfcnpj2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cpfcnpj3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Tipo de pagamento:");

        combo_Pagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        combo_Pagamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo_PagamentoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combo_PagamentoKeyReleased(evt);
            }
        });

        tabela_pagamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_pagamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pagamento", "Valor", "Troco"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_pagamento.getTableHeader().setReorderingAllowed(false);
        tabela_pagamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_pagamentoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabela_pagamento);
        if (tabela_pagamento.getColumnModel().getColumnCount() > 0) {
            tabela_pagamento.getColumnModel().getColumn(0).setResizable(false);
            tabela_pagamento.getColumnModel().getColumn(0).setPreferredWidth(165);
            tabela_pagamento.getColumnModel().getColumn(1).setResizable(false);
            tabela_pagamento.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Valor:");

        txt_valor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_valorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorFocusLost(evt);
            }
        });
        txt_valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_valorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_valorKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Valor a pagar:");

        txt_valorAPagar.setEditable(false);
        txt_valorAPagar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Valor restante:");

        txt_valorRestante.setEnabled(false);

        bt_finalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/vend.png"))); // NOI18N
        bt_finalizar.setText("Finalizar");
        bt_finalizar.setEnabled(false);
        bt_finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_finalizarActionPerformed(evt);
            }
        });
        bt_finalizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bt_finalizarKeyPressed(evt);
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_Pagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_valor)
                            .addComponent(txt_valorAPagar)
                            .addComponent(txt_valorRestante))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(combo_Pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_valorRestante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_valorAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {combo_Pagamento, jLabel5, jLabel6, jLabel8});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteFocusLost
        
    }//GEN-LAST:event_txt_codigoClienteFocusLost

    private void txt_cpfcnpj1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1FocusGained
        if(txt_cpfcnpj1.isEditable() == false){
            return;
        }
        txt_cpfcnpj1.setText("");
    }//GEN-LAST:event_txt_cpfcnpj1FocusGained

    private void txt_cpfcnpj1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1FocusLost
        if(txt_cpfcnpj1.isEditable() == false){
            return;
        }
        txt_cpfcnpj1.setText(fc.FormataCampo(txt_cpfcnpj1.getText(), 11, 2));
    }//GEN-LAST:event_txt_cpfcnpj1FocusLost

    private void txt_cpfcnpj2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj2FocusLost
        if(txt_cpfcnpj2.isEditable() == false){
            return;
        }
        txt_cpfcnpj2.setText(fc.FormataCampo(txt_cpfcnpj2.getText(), 4, 0));
    }//GEN-LAST:event_txt_cpfcnpj2FocusLost

    private void txt_cpfcnpj3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj3FocusLost
        if(txt_cpfcnpj3.isEditable() == false){
            return;
        }
        txt_cpfcnpj3.setText(fc.FormataCampo(txt_cpfcnpj3.getText(), 2, 0));
        bc.cpfCnpj1     = txt_cpfcnpj1.getText().replace(" ", "");
        bc.cpfCnpj2     = txt_cpfcnpj2.getText().replace(" ", "");
        if(Integer.parseInt(bc.cpfCnpj2) == 0){
            bc.cpfCnpj2 = "";
        }
        bc.cpfCnpj3     = txt_cpfcnpj3.getText().replace(" ", "");
        bc.cpfCnpj      = bc.cpfCnpj1 + bc.cpfCnpj2 + bc.cpfCnpj3;
        if(vcc.VALIDARCPFCNPJ(bc.cpfCnpj) == false){
            bt_finalizar.setEnabled(false);
            mensagem = "CPF/CNPJ Inválido!";
            mostraMensagem();
        }else{
            bt_finalizar.setEnabled(true);
            bt_finalizar.grabFocus();
        }
    }//GEN-LAST:event_txt_cpfcnpj3FocusLost

    private void txt_valorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorFocusGained
        if(!txt_valor.getText().equals(""))
            txt_valor.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valor.getText(), 1));
//            txt_valor.setText(String.valueOf(conv.ConverteValorDigitadoEmDouble(txt_valor.getText(), "S")));
//        System.out.println("Focus Gained Valor: " + txt_valor.getText());
        txt_valor.setSelectionStart(0);
        txt_valor.setSelectionEnd  (txt_valor.getText().length());
    }//GEN-LAST:event_txt_valorFocusGained

    private void bt_finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_finalizarActionPerformed
        Finalizar();
    }//GEN-LAST:event_bt_finalizarActionPerformed
    
    private void Finalizar(){
        if(Tipo.equalsIgnoreCase("OS")){
            codigoPlanoDeContasRel = bplarel.codigoPlanoDeContasOS;
            FinalizarOS();
        }else{
            codigoPlanoDeContasRel = bplarel.codigoPlanoDeContasVendas;
            FinalizarVenda();
        }
        IncluirMovimentoContabil();
    }
    
    private void tabela_pagamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_pagamentoMouseClicked
        linha   = tabela_pagamento.getSelectedRow();
        if(linha < 0){
            mensagem = "Item não selecionado!";
            mostraMensagem();
            return;
        }
        if(evt.getButton() == MouseEvent.BUTTON3){
            MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tabela_pagamentoMouseClicked

    private void txt_valorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valorKeyReleased
        
    }//GEN-LAST:event_txt_valorKeyReleased

    private void combo_PagamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_PagamentoKeyReleased
        
    }//GEN-LAST:event_combo_PagamentoKeyReleased

    private void txt_cpfcnpj2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj2FocusGained
        if(txt_cpfcnpj2.isEditable() == false){
            return;
        }
        txt_cpfcnpj2.setText("");
    }//GEN-LAST:event_txt_cpfcnpj2FocusGained

    private void txt_cpfcnpj3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj3FocusGained
        if(txt_cpfcnpj3.isEditable() == false){
            return;
        }
        txt_cpfcnpj3.setText("");
    }//GEN-LAST:event_txt_cpfcnpj3FocusGained

    private void txt_cpfcnpj1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_cpfcnpj2.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_cpfcnpj1KeyPressed

    private void txt_cpfcnpj2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cpfcnpj2KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_cpfcnpj3.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_cpfcnpj2KeyPressed

    private void txt_cpfcnpj3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cpfcnpj3KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            bt_finalizar.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_cpfcnpj3KeyPressed

    private void label_nomeClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_nomeClienteMouseEntered
        label_nomeCliente.setToolTipText(label_nomeCliente.getText());
    }//GEN-LAST:event_label_nomeClienteMouseEntered

    private void bt_finalizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bt_finalizarKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        Finalizar();
    }//GEN-LAST:event_bt_finalizarKeyPressed

    private void txt_valorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorFocusLost
        if(!txt_valor.getText().equals("")){
            txt_valor.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valor.getText(), 0));
        }
//            txt_valor.setText(nf.format(conv.ConverteValorDigitadoEmDouble(txt_valor.getText(), "N")));
//        System.out.println("Focus Lost Valor: " + txt_valor.getText());
    }//GEN-LAST:event_txt_valorFocusLost

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Table           = (DefaultTableModel)tabela_detalhes.getModel();
        TablePagamento  = (DefaultTableModel)tabela_pagamento.getModel();
        
        PegaRelacionamento();
        PegaFormasDePagamentos();
        
        if(Tipo.equalsIgnoreCase("OS")){
            txt_codigo      .setEditable (false);
            txt_codigo      .setFocusable(false);
            txt_codigo      .setText     (parametrosNS.fc.FormataCampo(String.valueOf(bcom.codigoComanda), 9, 0));
            bt_finalizar    .setText     ("Finalizar OS");
            PegaOrdemServico();
            return;
        }
        if(!Tipo.equalsIgnoreCase("OS")){
            txt_codigo      .setEditable    (false);
            txt_codigo      .setFocusable   (false);
            txt_codigo      .setText        (parametrosNS.fc.FormataCampo(String.valueOf(bv.codigoVenda), 9, 0));
            bt_finalizar    .setText        ("Finalizar Venda");
            if(Tipo.equalsIgnoreCase("Venda")){
//                if(bv.codigoVenda != 0)
//                    PegaVenda();
//                else{
                    PegaCliente();
                    PegaDadosArrayVendaAssociativo();
//                }
            }
            if(Tipo.equalsIgnoreCase("Comanda")){
                PegaCliente();
                PegaComanda();
            }
        }
    }//GEN-LAST:event_formWindowOpened
    
    private void PegaDadosArrayVendaAssociativo(){
        ValorAPagar = 0;
        String desconto = "";
        for(int i = 0; i < dadosVendasAssociativo.size(); i++){
            bvi.codigoVendaItem = Integer.parseInt(  String.valueOf(dadosVendasAssociativo.get(i).get(0)));
            bp.descricaoProduto =                    String.valueOf(dadosVendasAssociativo.get(i).get(1));
            bvi.valorUnitario   = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(dadosVendasAssociativo.get(i).get(2)), 1));
            bvi.quantidade      = Double.parseDouble(String.valueOf(dadosVendasAssociativo.get(i).get(3)));
            bvi.valorSubtotal   = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(dadosVendasAssociativo.get(i).get(4)), 1));
            desconto            = String.valueOf(dadosVendasAssociativo.get(i).get(5));
            bvi.valorTotal      = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(dadosVendasAssociativo.get(i).get(6)), 1));
            
            ValorAPagar = ValorAPagar + bvi.valorTotal;
            
            Table.addRow(new Object [] {fc.FormataCampo(String.valueOf(bvi.codigoVendaItem), 2, 0), bp.descricaoProduto, parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bvi.valorUnitario), 0), bvi.quantidade, parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bvi.valorSubtotal), 1), desconto, parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bvi.valorTotal), 0)});
        }
        PreencherCampos();
        txt_precoTotal.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorAPagar), 0));
    }
    
    private void bt_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_limparActionPerformed
        LimpaTabelaDePagamentos();
    }//GEN-LAST:event_bt_limparActionPerformed

    private void bt_removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_removerActionPerformed
        RemovePagamento();
    }//GEN-LAST:event_bt_removerActionPerformed

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowIconified

    private void txt_valorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valorKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        if(Tipo.equalsIgnoreCase("OS")){
            PagamentoOS();
            return;
        }
        PagamentosVenda();
    }//GEN-LAST:event_txt_valorKeyPressed

    private void combo_PagamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_PagamentoKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        txt_valor.grabFocus();
    }//GEN-LAST:event_combo_PagamentoKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JButton bt_finalizar;
    private javax.swing.JMenuItem bt_limpar;
    private javax.swing.JMenuItem bt_remover;
    private javax.swing.JMenuItem bt_sair;
    private javax.swing.JComboBox<String> combo_Pagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_nomeCliente;
    private javax.swing.JTable tabela_detalhes;
    private javax.swing.JTable tabela_pagamento;
    private javax.swing.JFormattedTextField txt_codigo;
    private javax.swing.JFormattedTextField txt_codigoCliente;
    private javax.swing.JFormattedTextField txt_cpfcnpj1;
    private javax.swing.JFormattedTextField txt_cpfcnpj2;
    private javax.swing.JFormattedTextField txt_cpfcnpj3;
    private javax.swing.JTextField txt_precoTotal;
    private javax.swing.JTextField txt_valor;
    private javax.swing.JTextField txt_valorAPagar;
    private javax.swing.JTextField txt_valorRestante;
    // End of variables declaration//GEN-END:variables
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    //Começa OS's
    private void PegaCliente(){
        fatal = "N";
        if(bc.codigoCliente == 0){
            return;
        }
        sql = "select idCliente, idEmpresa, codigoGrupo, codigoEmpresa, codigoCliente, cpfCnpj, nome from tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCliente = " + bc.codigoCliente + ";";
        dadosCliente.clear();
        dadosCliente = parametrosNS.dao.Consulta(sql);
        if(dadosCliente.isEmpty()){
            if(bc.codigoCliente == 99999){
                txt_codigoCliente.setText(parametrosNS.fc.FormataCampo(String.valueOf(bc.codigoCliente), 5, 0));
                label_nomeCliente.setText("Cliente padrão");
                bc.cpfCnpj = fc.FormataCampo("", 15, 0);
                SetaCPFouCNPJ();
                return;
            }
            mensagem = "Cliente " + bc.codigoCliente + " não encontrado!";
            mostraMensagem();
            fatal = "S";
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
        txt_codigoCliente.setText(parametrosNS.fc.FormataCampo(String.valueOf(bc.codigoCliente), 5, 0));
        label_nomeCliente.setText(bc.nome);
        SetaCPFouCNPJ();
    }
    
    private void SetaCPFouCNPJ(){
        bc.cpfCnpj  = FCampoCpfCnpj.FormataCampoCpfCnpj(bc.cpfCnpj);
        txt_cpfcnpj1.setText(bc.cpfCnpj.substring(0 , 9));
        txt_cpfcnpj2.setText(bc.cpfCnpj.substring(9 ,13));
        txt_cpfcnpj3.setText(bc.cpfCnpj.substring(13,15));
    }
    
    private void PegaOrdemServico(){
        sql = "select \n"
            + "   idOrdemServico, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoOrdemServico, \n"
            + "   codigoCliente, \n"
            + "   codigoUsuario, \n"
            + "   valorAdiantamento, \n"
            + "   valorDeslocamento, \n"
            + "   valorPecas, \n"
            + "   valorMaoDeObra, \n"
            + "   valorTerceiros, \n"
            + "   valorOutros \n"
            + "from \n"
            + "   tb_os where idOrdemServico = " + bos.idOrdemServico + ";";
        dadosOrdemServico.clear();
        dadosOrdemServico = parametrosNS.dao.Consulta(sql);
        if(dadosOrdemServico.isEmpty()){
            mensagem = "Ordem de Serviço não encontrada!";
            mostraMensagem();
            return;
        }
        PegaDadosOrdemServico();
    }
    
    private void PegaDadosOrdemServico(){
        ValorAPagar     = 0;
        for(int i = 0; i < dadosOrdemServico.size(); i++){
            bos     = new BeanOrdemServico();
            if(dadosOrdemServico.get(i).get(0) != null){
                bos.idOrdemServico          = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(0)));
            }
            if(dadosOrdemServico.get(i).get(1) != null){
                bos.idEmpresa               = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(1)));
            }
            if(dadosOrdemServico.get(i).get(2) != null){
                bos.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(2)));
            }
            if(dadosOrdemServico.get(i).get(3) != null){
                bos.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(3)));
            }
            if(dadosOrdemServico.get(i).get(4) != null){
                bos.codigoOrdemServico      = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(4)));
            }
            if(dadosOrdemServico.get(i).get(5) != null){
                bos.codigoCliente           = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(5)));
            }
            if(dadosOrdemServico.get(i).get(6) != null){
                bos.codigoUsuario           = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(6)));
            }
            if(dadosOrdemServico.get(i).get(7) != null){
                bos.valorAdiantamento       = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(7)));
            }
            if(dadosOrdemServico.get(i).get(8) != null){
                bos.valorDeslocamento       = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(8)));
            }
            if(dadosOrdemServico.get(i).get(9) != null){
                bos.valorPecas              = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(9)));
            }
            if(dadosOrdemServico.get(i).get(10) != null){
                bos.valorMaoDeObra          = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(10)));
            }
            if(dadosOrdemServico.get(i).get(11) != null){
                bos.valorTerceiros          = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(11)));
            }
            if(dadosOrdemServico.get(i).get(12) != null){
                bos.valorOutros             = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(12)));
            }
            
            bosi.idEmpresa          = bos.idEmpresa;
            bosi.codigoGrupo        = bos.codigoGrupo;
            bosi.codigoEmpresa      = bos.codigoEmpresa;
            bosi.codigoOrdemServico = bos.codigoOrdemServico;
            PegaItensOrdemServico();
            
            ValorAPagar = bos.valorDeslocamento + bos.valorTerceiros + bos.valorOutros + PrecoTotalDosItens;
        }
        txt_codigo.setText(fc.FormataCampo(String.valueOf(bos.codigoOrdemServico), 9, 0));
        
        PreencherCampos();
    }
    
    private void PreencherCampos(){
        txt_valor.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorAPagar), 0));
        ValorRestante = ValorAPagar;
        txt_valorRestante.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorRestante), 0));
        txt_valorAPagar.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorAPagar), 0));
        combo_Pagamento.grabFocus();
    }
    
    private void PegaItensOrdemServico(){
        sql = "select \n"
            + "   idOrdemServicoItem, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoOrdemServico, \n"
            + "   codigoOrdemServicoItem, \n"
            + "   valorUnitario, \n"
            + "   quantidade, \n"
            + "   valorTotal, \n"
            + "   codigoServico, \n"
            + "   codigoProduto \n"
            + "from \n"
            + "   tb_os_itens where idEmpresa = " + bosi.idEmpresa + " and codigoOrdemServico = " + bosi.codigoOrdemServico + ";";
        dadosOrdemServicoItens.clear();
        dadosOrdemServicoItens = parametrosNS.dao.Consulta(sql);
        if(dadosOrdemServicoItens.isEmpty()){
            mensagem = "Não existem itens cadastrados para a OS " + bos.codigoOrdemServico + "!";
            mostraMensagem();
            return;
        }
        PegaDadosItensOrdemServico();
    }
    
    private void PegaDadosItensOrdemServico(){
        for(int i = 0; i < dadosOrdemServicoItens.size(); i++){
            bosi = new BeanOrdemServicoItens();
            bp   = new BeanProdutos();
            bser = new BeanServicos();
            if(dadosOrdemServicoItens.get(i).get(0) != null){
                bosi.idOrdemServicoItem     = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(0)));
            }
            if(dadosOrdemServicoItens.get(i).get(1) != null){
                bosi.idEmpresa              = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(1)));
            }
            if(dadosOrdemServicoItens.get(i).get(2) != null){
                bosi.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(2)));
            }
            if(dadosOrdemServicoItens.get(i).get(3) != null){
                bosi.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(3)));
            }
            if(dadosOrdemServicoItens.get(i).get(4) != null){
                bosi.codigoOrdemServico     = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(4)));
            }
            if(dadosOrdemServicoItens.get(i).get(5) != null){
                bosi.codigoOrdemServicoItem = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(5)));
            }
            if(dadosOrdemServicoItens.get(i).get(6) != null){
                bosi.valorUnitario          = Double.parseDouble(String.valueOf(dadosOrdemServicoItens.get(i).get(6)));
            }
            if(dadosOrdemServicoItens.get(i).get(7) != null){
                bosi.quantidade             = Double.parseDouble(String.valueOf(dadosOrdemServicoItens.get(i).get(7)));
            }
            if(dadosOrdemServicoItens.get(i).get(8) != null){
                bosi.valorTotal             = Double.parseDouble(String.valueOf(dadosOrdemServicoItens.get(i).get(8)));
            }
            if(dadosOrdemServicoItens.get(i).get(9) != null){
                bosi.codigoServico          = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(9)));
            }
            if(dadosOrdemServicoItens.get(i).get(10) != null){
                bosi.codigoProduto          = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(10)));
            }
            
            bp.codigoProduto   = bosi.codigoProduto;
            if(bp.codigoProduto != 0){
                PegaProduto();
            }
            
            bser.codigoServico = bosi.codigoServico;
            if(bser.codigoServico != 0){
                PegaServico();
            }
            
            PrecoTotalDosItens      = PrecoTotalDosItens    + bosi.valorTotal;
            
            Table.addRow(new Object [] {fc.FormataCampo(String.valueOf(bosi.codigoOrdemServicoItem), 2, 0), DescricaoProdutoServico, parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bosi.valorUnitario), 0), String.valueOf(bosi.quantidade), parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bosi.valorTotal), 0)});
        }
        txt_precoTotal.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(PrecoTotalDosItens), 0));
    }
    
    private void PegaProduto(){
        sql = "select \n"
            + "   idProdutos, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoProduto, \n"
            + "   descricaoProduto, \n"
            + "   quantidadeMinima, \n"
            + "   quantidadeIdeal, \n"
            + "   quantidadeAtual \n"
            + "from \n"
            + "   tb_produtos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoProduto = " + bp.codigoProduto + ";";
        dadosProdutos.clear();
        dadosProdutos = parametrosNS.dao.Consulta(sql);
        if(dadosProdutos.isEmpty()){
            mensagem = "Produto " + bp.codigoProduto + " não encontrado!";
            mostraMensagem();
            DescricaoProdutoServico = "---------------------------";
            return;
        }
        PegaDadosProduto();
    }
    
    private void PegaDadosProduto(){
        for(int i = 0; i < dadosProdutos.size(); i++){
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
                bp.descricaoProduto         =                    String.valueOf(dadosProdutos.get(i).get(5));
            }
            if(dadosProdutos.get(i).get(6) != null){
                bp.quantidadeMinima         = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(6)));
            }
            if(dadosProdutos.get(i).get(7) != null){
                bp.quantidadeIdeal          = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(7)));
            }
            if(dadosProdutos.get(i).get(8) != null){
                bp.quantidadeAtual          = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(8)));
            }
        }
        DescricaoProdutoServico = bp.descricaoProduto;
    }
    
    private void PegaServico(){
        sql = "select \n"
            + "   idServico, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoServico, \n"
            + "   descricaoServico, \n"
            + "   valorServico \n"
            + "from \n"
            + "   tb_servicos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoServico = " + bser.codigoServico + ";";
        dadosServicos.clear();
        dadosServicos = parametrosNS.dao.Consulta(sql);
        if(dadosServicos.isEmpty()){
            mensagem = "Servico " + bser.codigoServico + " não encontrado!";
            mostraMensagem();
            DescricaoProdutoServico = "---------------------------";
            return;
        }
        PegaDadosServico();
    }
    
    private void PegaDadosServico(){
        for(int i = 0; i < dadosServicos.size(); i++){
            if(dadosServicos.get(i).get(0) != null){
                bser.idServico          = Integer.parseInt(  String.valueOf(dadosServicos.get(i).get(0)));
            }
            if(dadosServicos.get(i).get(1) != null){
                bser.idEmpresa          = Integer.parseInt(  String.valueOf(dadosServicos.get(i).get(1)));
            }
            if(dadosServicos.get(i).get(2) != null){
                bser.codigoGrupo        = Integer.parseInt(  String.valueOf(dadosServicos.get(i).get(2)));
            }
            if(dadosServicos.get(i).get(3) != null){
                bser.codigoEmpresa      = Integer.parseInt(  String.valueOf(dadosServicos.get(i).get(3)));
            }
            if(dadosServicos.get(i).get(4) != null){
                bser.codigoServico      = Integer.parseInt(  String.valueOf(dadosServicos.get(i).get(4)));
            }
            if(dadosServicos.get(i).get(5) != null){
                bser.descricaoServico   =                    String.valueOf(dadosServicos.get(i).get(5));
            }
            if(dadosServicos.get(i).get(6) != null){
                bser.valorServico       = Double.parseDouble(String.valueOf(dadosServicos.get(i).get(6)));
            }
        }
        DescricaoProdutoServico = bser.descricaoServico;
    }
    
    private void FinalizaOrdemServico(){
        bos.dataFinalizou          = invdata.inverterData(cdh.CapturarData(), 2);
        bos.horaFinalizou          = cdh.CapturaHora();
        bos.usuarioFinalizou       = parametrosNS.bu.codigoUsuario;
        bos.idEmpresaFinalizou     = parametrosNS.be.IdEmpresa;
        bos.computadorFinalizou    = parametrosNS.bcomp.codigoComputador;
        if(!sqlstate.equals("00000")){
            return;
        }
        sql = "update tb_os set statusOs = 2, "
                             + "pagamento = 1,"
                             + "dataFinalizou = '"      + bos.dataFinalizou       + "', "
                             + "horaFinalizou = '"      + bos.horaFinalizou       + "', "
                             + "usuarioFinalizou = "    + bos.usuarioFinalizou    + ", "
                             + "idEmpresaFinalizou = "  + bos.idEmpresaFinalizou  + ", "
                             + "computadorFinalizou = " + bos.computadorFinalizou + " "
                             + "where idOrdemServico = " + bos.idOrdemServico + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000")){
            return;
        }
        if(bosp.trocoDoPagamento > 0){
            mensagem = "Troco: " + parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bosp.trocoDoPagamento), 0);
            mostraMensagem();
        }
        mensagem = "Ordem de Serviço " + bos.codigoOrdemServico + " finalizada com êxito!";
        mostraMensagem();
        bcu.codigoOrdemVenda  = bos.codigoOrdemServico;
        //gerarCupom();
        dispose();
    }
    
    public String getRetornoFinaliza(){
        return sqlstate;
    }

    private void gerarCupom(){
        bcu.Tipo = "Venda";
        bcu.dataGerado          = cdh.CapturarData();
        bcu.horaGerado          = cdh.CapturaHora();
        bcu.dataGerado          = bcu.dataGerado.replace("/", "");
        bcu.dataGerado          = bcu.dataGerado.replace("-", "");
        bcu.horaGerado          = bcu.horaGerado.replace(":", "");
        bcu.cpfCnpj1            = txt_cpfcnpj1.getText().replace(" ", "");
        bcu.cpfCnpj2            = txt_cpfcnpj2.getText().replace(" ", "");
        if(CpfNaNota.equals("S")){
            if(Integer.parseInt(bcu.cpfCnpj2) == 0){
                bcu.cpfCnpj2    = "";
            }
        }
        bcu.cpfCnpj3            = txt_cpfcnpj3.getText().replace(" ", "");
        bcu.cpfCnpj             = bcu.cpfCnpj1 + bcu.cpfCnpj2 + bcu.cpfCnpj3;
        bcu.cpfCnpj             = FCpfCnpj.FormataCPFCNPJ(bcu.cpfCnpj);
        dadosCupom.clear();
        dadosCupom.add(bcu.Tipo);                   // 00 Tipo de Cupom
        dadosCupom.add(bcu.codigoOrdemVenda);       // 01 Código da OS
        dadosCupom.add(bcu.dataGerado);             // 02 Data
        dadosCupom.add(bcu.horaGerado);             // 03 Hora
        dadosCupom.add(bcu.cpfCnpj);
        nomeArquivo = "TEF" + fc.FormataCampo(String.valueOf(bos.codigoOrdemServico), 9, 0) + bcu.dataGerado + bcu.horaGerado.substring(0, 4);
        ic.gerarArquivo(dadosCupom, dadosOrdemServicoItens, nomeArquivo);
    }
    
    private void PegaDadosPagamentoOS(){
        String texto   = "";
        for(int linha = 0; linha < tabela_pagamento.getRowCount(); linha++){
            bosp.codigoPagamento    = Integer.parseInt(String.valueOf(tabela_pagamento.getValueAt(linha, 0)).substring(0, 2));
            bfp.descricaoPagamento  = String.valueOf(tabela_pagamento.getValueAt(linha, 0));
            bosp.valorDoPagamento   = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(tabela_pagamento.getValueAt(linha, 1)), 1));
            bosp.trocoDoPagamento   = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(tabela_pagamento.getValueAt(linha, 2)), 1));
            bosp.dataPagamento      = parametrosNS.invdata.inverterData(parametrosNS.cdh.CapturarData(), 2);
            
            sql = "insert into tb_os_pagamentos (idEmpresa, codigoGrupo, codigoEmpresa, codigoOrdemServico, codigoPagamento, valorDoPagamento, trocoDoPagamento, dataPagamento) "
                + "values (" + bosp.idEmpresa + ", " + bosp.codigoGrupo + ", " + bosp.codigoEmpresa + ", " + bosp.codigoOrdemServico + ", " + bosp.codigoPagamento + ", " + bosp.valorDoPagamento + ", " + bosp.trocoDoPagamento + ", '" + bosp.dataPagamento + "');";
            
            sqlstate = parametrosNS.dao.incluirRegistro(sql);
            if(!sqlstate.equals("00000")){
                mensagem = "Erro ao incluir pagamento " + bosp.codigoPagamento + " do valor " + parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bosp.valorDoPagamento), 0) + "!";
                mostraMensagem();
                return;
            }
            bfp.descricaoPagamento  = bfp.descricaoPagamento.substring(5) + " ";
            for(int i = 0; i < bfp.descricaoPagamento.length() - 7; i++){
                texto = bfp.descricaoPagamento.substring(i, i + 7);
                texto = texto.replace("é", "e");
                if(texto.equalsIgnoreCase("credito")){
                    PegaQtdParcelas();
                    IncluirPagamentoEmCreditoOS();
                    break;
                }
            }
        }
    }
    
    private void IncluirPagamentoEmCreditoOS(){
        bospc.idEmpresa             = parametrosNS.be.IdEmpresa;
        bospc.codigoGrupo           = parametrosNS.bge.CodigoGrupo;
        bospc.codigoEmpresa         = parametrosNS.be.CodigoEmpresa;
        bospc.codigoOrdemServico    = bos.codigoOrdemServico;
        bospc.codigoPagamento       = bosp.codigoPagamento;
        bospc.valorTotalDoPagamento = bosp.valorDoPagamento;
        bospc.qtdParcelas           = qtdDeParcelas;
        bospc.valorDasParcelas      = bospc.valorTotalDoPagamento / bospc.qtdParcelas;
        
        sql = "insert into tb_os_pagamentos_credito (idEmpresa, codigoGrupo, codigoEmpresa, codigoOrdemServico, codigoPagamento, valorTotalDoPagamento, qtdParcelas, valorDasParcelas) "
            + "values (" + bospc.idEmpresa + ", " + bospc.codigoGrupo + ", " + bospc.codigoEmpresa + ", " + bospc.codigoOrdemServico + ", " + bospc.codigoPagamento + ", " + bospc.valorTotalDoPagamento + ", " + bospc.qtdParcelas + ", " + bospc.valorDasParcelas + ");";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao incluir pagamento em crédito!";
            mostraMensagem();
        }
    }
    
    private void FinalizarOS(){
        bos.codigoOrdemServico = Integer.parseInt(txt_codigo.getText());
        if(JOptionPane.showConfirmDialog(null, "Desejá Finalizar a OS n° " + bos.codigoOrdemServico + "?", "", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION){
            return;
        }
        bosp.idEmpresa          = parametrosNS.be.IdEmpresa;
        bosp.codigoGrupo        = parametrosNS.bge.CodigoGrupo;
        bosp.codigoEmpresa      = parametrosNS.be.CodigoEmpresa;
        bosp.codigoOrdemServico = bos.codigoOrdemServico;
        PegaDadosPagamentoOS();
        if(!sqlstate.equals("00000")){
            return;
        }
        FinalizaOrdemServico();
    }
    
    private void PagamentoOS(){
        if(bosp.trocoDoPagamento >= 0.01){
            mensagem = "Valor Pago já bateu com Valor a Pagar!";
            mostraMensagem();
            return;
        }
        bosp.idEmpresa                  = parametrosNS.be.IdEmpresa;
        bosp.codigoPagamento            = Integer.parseInt(String.valueOf(combo_Pagamento.getSelectedItem()).substring(0, 2));
        bfp.descricaoPagamento          = String.valueOf(combo_Pagamento.getSelectedItem());
        bosp.valorDoPagamento           = Double.parseDouble(txt_valor.getText());
        if(bosp.valorDoPagamento == 0){
            mensagem = "Valor do Pagamento não pode ser Zero!";
            mostraMensagem();
            return;
        }
        ValorRestante                  -= bosp.valorDoPagamento;
        if(ValorRestante <= 0){
            if(ValorRestante < 0){
                bosp.trocoDoPagamento       = ValorRestante * (-1);
            }
            ValorRestante = 0;
            bt_finalizar.setEnabled(true);
            bt_finalizar.grabFocus();
        }else{
            bt_finalizar.setEnabled(false);
            combo_Pagamento.grabFocus();
        }
        txt_valor.setText(nf.format(conv.ConverteValorDigitadoEmDouble(String.valueOf(ValorRestante), "N")));
        txt_valorRestante.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorRestante), 0));
        TablePagamento.addRow(new Object[] {bfp.descricaoPagamento, parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bosp.valorDoPagamento), 0), parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bosp.trocoDoPagamento), 0)});
    }
    //Termina OS's
    
    //Pagamentos
    private void LimpaTabelaDePagamentos(){
        for(int i = 0; i < tabela_pagamento.getRowCount(); i++){
            bosp.valorDoPagamento   = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(tabela_pagamento.getValueAt(i, 1)), 1));
            bosp.trocoDoPagamento   = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(tabela_pagamento.getValueAt(i, 2)), 1));
            
            bosp.valorDoPagamento   = bosp.valorDoPagamento - bosp.trocoDoPagamento;
            
            ValorRestante = ValorRestante + bosp.valorDoPagamento;
        }
        bosp.valorDoPagamento = 0;
        bosp.trocoDoPagamento = 0;
        TablePagamento.setNumRows(0);
        ReiniciaPagamentos();
    }
    
    private void ReiniciaPagamentos(){
        txt_valor           .setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorRestante), 0));
        txt_valorRestante   .setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorRestante), 0));
        combo_Pagamento     .grabFocus();
        bt_finalizar        .setEnabled(false);
    }
    
    private void RemovePagamento(){
        if(linha < 0){
            mensagem = "Pagamento não selecionado!";
            mostraMensagem();
            return;
        }
        bosp.valorDoPagamento   = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(tabela_pagamento.getValueAt(linha, 1)), 1));
        bosp.trocoDoPagamento   = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(tabela_pagamento.getValueAt(linha, 2)), 1));
        bosp.valorDoPagamento   = bosp.valorDoPagamento - bosp.trocoDoPagamento;
        ValorRestante = ValorRestante + bosp.valorDoPagamento;
        ReiniciaPagamentos();
        TablePagamento.removeRow(linha);
        linha = -1;
    }
    
    private void PegaFormasDePagamentos(){
        sql = "select codigoPagamento, descricaoPagamento from tb_formaspagamentos where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosFormasPagamentos.clear();
        dadosFormasPagamentos = parametrosNS.dao.Consulta(sql);
        if(dadosFormasPagamentos.isEmpty()){
            mensagem = "Não foram encontrado formas de pagamentos cadastradas!";
            mostraMensagem();
            return;
        }
        PegaDadosFormasDePagamentos();
    }
    
    private void PegaDadosFormasDePagamentos(){
        combo_Pagamento.removeAllItems();
        combo_Pagamento.addItem("");
        for(int i = 0; i < dadosFormasPagamentos.size(); i++){
            bfp = new BeanFormasPagamentos();
//            bfp.idPagamento             = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(0)));
//            bfp.idEmpresa               = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(1)));
//            bfp.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(2)));
//            bfp.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(3)));
            bfp.codigoPagamento         = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(0)));
            bfp.descricaoPagamento      =                    String.valueOf(dadosFormasPagamentos.get(i).get(1));
            
            combo_Pagamento.addItem(fc.FormataCampo(String.valueOf(bfp.codigoPagamento), 2, 0) + " - " + bfp.descricaoPagamento);
        }
    }
    //Termina Pagamentos
    
    private void PegaQtdParcelas(){
        try{
            qtdDeParcelas = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Parcelas do cartão de crédito: "));
        }catch(Exception erro){
            mensagem = "Quantidade inválida!";
            mostraMensagem();
            PegaQtdParcelas();
        }
    }
    
    //Vendas
    private void PegaVenda(){
        txt_codigo.setText(fc.FormataCampo(txt_codigo.getText(), 9, 0));
        bv.codigoVenda = Integer.parseInt(txt_codigo.getText());
        if(bv.codigoVenda == 0){
            return;
        }
        sql = "select \n"
            + "   idVenda, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoVenda, \n"
            + "   codigoUsuario, \n"
            + "   codigoCliente, \n"
            + "   codigoComputador, \n"
            + "   dataVenda, \n"
            + "   horaVenda \n"
            + "from \n"
            + "   tb_vendas where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoVenda = " + bv.codigoVenda + ";";
        dadosVendas.clear();
        dadosVendas = parametrosNS.dao.Consulta(sql);
        if(dadosVendas.isEmpty()){
            mensagem = "Venda n°" + bv.codigoVenda + " não encontrada!";
            mostraMensagem();
            return;
        }
        PegaDadosVenda();
    }
    
    private void PegaDadosVenda(){
        for(int i = 0; i < dadosVendas.size(); i++){
            bv = new BeanVendas();
            bv.idVenda          = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(0)));
            bv.idEmpresa        = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(1)));
            bv.codigoGrupo      = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(2)));
            bv.codigoEmpresa    = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(3)));
            bv.codigoVenda      = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(4)));
            bv.codigoUsuario    = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(5)));
            bv.codigoCliente    = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(6)));
            bv.codigoComputador = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(7)));
            bv.dataVenda        =                    String.valueOf(dadosVendas.get(i).get(8));
            bv.horaVenda        =                    String.valueOf(dadosVendas.get(i).get(9));
        }
        
        bc.codigoCliente = bv.codigoCliente;
        PegaCliente();
        
        bvi.idEmpresa         = bv.idEmpresa;
        bvi.codigoGrupo       = bv.codigoGrupo;
        bvi.codigoEmpresa     = bv.codigoEmpresa;
        bvi.codigoVenda       = bv.codigoVenda;
        PegaItensVendas();
    }
    
    private void PegaItensVendas(){
        sql = "select * from tb_vendas_itens where idEmpresa = " + bvi.idEmpresa + " and codigoVenda = " + bvi.codigoVenda + ";";
        dadosVendasItens.clear();
        dadosVendasItens = parametrosNS.dao.Consulta(sql);
        if(dadosVendasItens.isEmpty()){
            mensagem = "Não foram encontrados itens para a venda n°" + bv.codigoVenda + "!";
            mostraMensagem();
            return;
        }
        PegaDadosItensVendas();
    }
    
    private void PegaDadosItensVendas(){
        Table.setNumRows(0);
        ValorAPagar     = 0;
        String desconto = "";
        for(int i = 0; i < dadosVendasItens.size(); i++){
            if(dadosVendasItens.get(i).get(0)  != null){bvi.idVendaItem         = Integer.parseInt(  String.valueOf(dadosVendasItens.get(i).get(0)));}
            if(dadosVendasItens.get(i).get(1)  != null){bvi.idEmpresa           = Integer.parseInt(  String.valueOf(dadosVendasItens.get(i).get(1)));}
            if(dadosVendasItens.get(i).get(2)  != null){bvi.codigoGrupo         = Integer.parseInt(  String.valueOf(dadosVendasItens.get(i).get(2)));}
            if(dadosVendasItens.get(i).get(3)  != null){bvi.codigoEmpresa       = Integer.parseInt(  String.valueOf(dadosVendasItens.get(i).get(3)));}
            if(dadosVendasItens.get(i).get(4)  != null){bvi.codigoVenda         = Integer.parseInt(  String.valueOf(dadosVendasItens.get(i).get(4)));}
            if(dadosVendasItens.get(i).get(5)  != null){bvi.codigoVendaItem     = Integer.parseInt(  String.valueOf(dadosVendasItens.get(i).get(5)));}
            if(dadosVendasItens.get(i).get(6)  != null){bvi.codigoProduto       = Integer.parseInt(  String.valueOf(dadosVendasItens.get(i).get(6)));}
            if(dadosVendasItens.get(i).get(7)  != null){bvi.valorUnitario       = Double.parseDouble(String.valueOf(dadosVendasItens.get(i).get(7)));}
            if(dadosVendasItens.get(i).get(8)  != null){bvi.quantidade          = Double.parseDouble(String.valueOf(dadosVendasItens.get(i).get(8)));}
            if(dadosVendasItens.get(i).get(9)  != null){bvi.valorSubtotal       = Double.parseDouble(String.valueOf(dadosVendasItens.get(i).get(9)));}
            if(dadosVendasItens.get(i).get(10) != null){bvi.tipoDesconto        = Integer.parseInt(  String.valueOf(dadosVendasItens.get(i).get(10)));}
            if(dadosVendasItens.get(i).get(11) != null){bvi.valorDesconto       = Double.parseDouble(String.valueOf(dadosVendasItens.get(i).get(11)));}
            if(dadosVendasItens.get(i).get(12) != null){bvi.valorTotal          = Double.parseDouble(String.valueOf(dadosVendasItens.get(i).get(12)));}
            
            bp.codigoProduto = bvi.codigoProduto;
            PegaProduto();
            
            ValorAPagar = ValorAPagar + bvi.valorTotal;
            
            if(bvi.tipoDesconto == 0){
                desconto = String.valueOf(bvi.valorDesconto * 100) + "%";
            }else{
                desconto = String.valueOf(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bvi.valorDesconto), 0));
            }
            
            Table.addRow(new Object [] {String.valueOf(fc.FormataCampo(String.valueOf(bvi.codigoVendaItem), 2, 0)), fc.FormataCampo(String.valueOf(bp.codigoProduto), 5, 0) + "-" + bp.descricaoProduto, parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bvi.valorUnitario), 0), String.valueOf(bvi.quantidade), parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bvi.valorSubtotal), 0), desconto, parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bvi.valorTotal), 0)});
        }
        PreencherCampos();
        txt_precoTotal.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorAPagar), 0));
    }
    
    private void FinalizarVenda(){
//        if(Long.parseLong(bc.cpfCnpj.replace(" ", "")) == 0){
//            if(JOptionPane.showConfirmDialog(null, "CPF na nota?") == JOptionPane.YES_OPTION){
//                CpfNaNota = "S";
//                txt_cpfcnpj1.setEditable    (true);
//                txt_cpfcnpj1.setFocusable   (true);
//                txt_cpfcnpj2.setEditable    (false);
//                txt_cpfcnpj2.setFocusable   (false);
//                txt_cpfcnpj3.setEditable    (true);
//                txt_cpfcnpj3.setFocusable   (true);
//                txt_cpfcnpj1.grabFocus();
//                return;
//            }
//        }
        if(JOptionPane.showConfirmDialog(null, "Deseja finalizar a Venda?", "", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION){
            return;
        }
        IncluirVenda();
        if(!sqlstate.equals("00000")){
            return;
        }
        IncluirItensVenda();
        if(!sqlstate.equals("00000")){
            return;
        }
        bvp.idEmpresa       = bv.idEmpresa;
        bvp.codigoGrupo     = bv.codigoGrupo;
        bvp.codigoEmpresa   = bv.codigoEmpresa;
        bvp.codigoVenda     = bv.codigoVenda;
        PegaDadosPagamentoVendas();
        if(!sqlstate.equals("00000")){
            return;
        }
        if(bvp.trocoDoPagamento > 0){
            mensagem = "Troco: " + parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bvp.trocoDoPagamento), 0);
            mostraMensagem();
        }
        mensagem = "Venda n°" + bv.codigoVenda + " finalizada com êxito!";
        mostraMensagem();
        dispose();
    }
    
    private void PegaValores(){
        fatal = "N";
        bv.idEmpresa        = parametrosNS.be.IdEmpresa;
        bv.codigoGrupo      = parametrosNS.bge.CodigoGrupo;
        bv.codigoEmpresa    = parametrosNS.be.CodigoEmpresa;
        bv.codigoVenda      = PegProReg.PegaProximoRegistro("tb_vendas", "codigoVenda", "");
        bv.codigoUsuario    = parametrosNS.bu.codigoUsuario;
        bv.codigoCliente    = bc.codigoCliente;
        if(bv.codigoCliente == 0){
            mensagem = "Cliente inválido!";
            mostraMensagem();
            fatal = "S";
            return;
        }
        bv.codigoComputador = parametrosNS.bcomp.codigoComputador;
        bv.dataVenda        = invdata.inverterData(cdh.CapturarData(), 2);
        bv.horaVenda        = cdh.CapturaHora();
        bv.status           = 2;
    }
    
    private void IncluirVenda(){
        PegaValores();
        if(fatal.equals("S")){
            return;
        }
        sql = "insert into tb_vendas (idEmpresa, codigoGrupo, codigoEmpresa, codigoVenda, codigoUsuario, codigoCliente, codigoComputador, dataVenda, horaVenda, status)"
            + " values (" + bv.idEmpresa + ", " + bv.codigoGrupo + ", " + bv.codigoEmpresa + ", " + bv.codigoVenda + ", " + bv.codigoUsuario + ", " + bv.codigoCliente + ", " + bv.codigoComputador + ", '" + bv.dataVenda + "', '" + bv.horaVenda + "', 2);";
        
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            fatal = "S";
            mensagem = "Erro ao incluir Venda n°" + bv.codigoVenda + "!";
            mostraMensagem();
            return;
        }
        sql = "select idVenda from tb_vendas where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoVenda = " + bv.codigoVenda + ";";
        dadosVendas.clear();
        dadosVendas = parametrosNS.dao.Consulta(sql);
        bv.idVenda  = Integer.parseInt(String.valueOf(dadosVendas.get(0).get(0)));
    }
    
    private void IncluirItensVenda(){
        bvi.idEmpresa     = bv.idEmpresa;
        bvi.codigoGrupo   = bv.codigoGrupo;
        bvi.codigoEmpresa = bv.codigoEmpresa;
        bvi.codigoVenda   = bv.codigoVenda;
        String desconto = "";
        for(int linha = 0; linha < tabela_detalhes.getRowCount(); linha++){
            bvi.codigoVendaItem     = Integer.parseInt(String.valueOf(tabela_detalhes.getValueAt(linha, 0)));
            bvi.codigoProduto       = Integer.parseInt(String.valueOf(tabela_detalhes.getValueAt(linha, 1)).substring(0, 5));
            bvi.valorUnitario       = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(tabela_detalhes.getValueAt(linha, 2)), 1));
            bvi.quantidade          = Double.parseDouble(String.valueOf(tabela_detalhes.getValueAt(linha, 3)));
            bvi.valorSubtotal       = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(tabela_detalhes.getValueAt(linha, 4)), 1));
            desconto                = String.valueOf(tabela_detalhes.getValueAt(linha, 5));
            bvi.valorTotal          = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(tabela_detalhes.getValueAt(linha, 6)), 1));
            
            if(desconto.substring(0, 2).equals("R$")){
                bvi.tipoDesconto    = 0;
                bvi.valorDesconto   = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(desconto, 1));
            }else{
                bvi.tipoDesconto    = 1;
                bvi.valorDesconto   = Double.parseDouble(desconto.replace("%", "")) / 100;
            }
            
            sql = "insert into tb_vendas_itens (idEmpresa, codigoGrupo, codigoEmpresa, codigoVenda, codigoVendaItem, codigoProduto, valorUnitario, quantidade, valorSubtotal, tipoDesconto, valorDesconto, valorTotal) "
                + "values (" + bvi.idEmpresa + ", " + bvi.codigoGrupo + ", " + bvi.codigoEmpresa + ", " + bvi.codigoVenda + ", " + bvi.codigoVendaItem + ", " + bvi.codigoProduto + ", " + bvi.valorUnitario + ", " + bvi.quantidade + ", " + bvi.valorSubtotal + ", " + bvi.tipoDesconto + ", " + bvi.valorDesconto + ", " + bvi.valorTotal + ");";
            
            sqlstate = parametrosNS.dao.incluirRegistro(sql);
            if(!sqlstate.equals("00000")){
                mensagem = "Erro ao incluir Item n°" + bvi.codigoVendaItem + " da venda n°" + bvi.codigoVenda + "!";
                mostraMensagem();
                return;
            }
            
            bp.codigoProduto = bvi.codigoProduto;
            PegaProduto();
            
            bp.quantidadeAtual = bp.quantidadeAtual - bvi.quantidade;
            if(bp.quantidadeAtual <= 0){
                bp.quantidadeAtual = 0;
            }
            AtualizaEstoque();
        }
    }
    
    private void AtualizaEstoque(){
        sql = "update tb_produtos set quantidadeAtual = " + bp.quantidadeAtual + " where idProdutos = " + bp.idProdutos + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(sqlstate.equals("00000")){
            return;
        }
        mensagem = "Erro ao atualizar estoque do produto " + bp.codigoProduto + "!";
        mostraMensagem();
    }
    
//    private void FinalizaVenda(){
//        sql = "update tb_vendas set status = 2 where idVenda = " + bv.idVenda + ";";
//        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
//        if(!sqlstate.equals("00000"))
//            return;
//        if(bvp.trocoDoPagamento > 0){
//            mensagem = "Troco: " + parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bvp.trocoDoPagamento), 0);
//            mostraMensagem();
//        }
//        sqlstate = "ok";
//        mensagem = "Venda n°" + bv.codigoVenda + " finalizada com êxito!";
//        mostraMensagem();
////        bcu.codigoOrdemVenda  = bv.codigoVenda;
////        gerarCupom();
//        dispose();
//    }
    
    private void PegaDadosPagamentoVendas(){
        String texto = "";
        for(int linha = 0; linha < tabela_pagamento.getRowCount(); linha++){
            bvp.codigoPagamento     = Integer.parseInt(String.valueOf(tabela_pagamento.getValueAt(linha, 0)).substring(0, 2));
            bfp.descricaoPagamento  = String.valueOf(tabela_pagamento.getValueAt(linha, 0));
            bvp.valorDoPagamento    = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(tabela_pagamento.getValueAt(linha, 1)), 1));
            bvp.trocoDoPagamento    = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(tabela_pagamento.getValueAt(linha, 2)), 1));
            
            sql = "insert into tb_vendas_pagamentos (idEmpresa, codigoGrupo, codigoEmpresa, codigoVenda, codigoPagamento, valorDoPagamento, trocoDoPagamento) "
                + "values (" + bvp.idEmpresa + ", " + bvp.codigoGrupo + ", " + bvp.codigoEmpresa + ", " + bvp.codigoVenda + ", " + bvp.codigoPagamento + ", " + bvp.valorDoPagamento + ", " + bvp.trocoDoPagamento + ");";
            sqlstate = parametrosNS.dao.incluirRegistro(sql);
            if(!sqlstate.equals("00000")){
                mensagem = "Erro ao incluir pagamento " + bosp.codigoPagamento + " do valor " + parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bosp.valorDoPagamento), 0) + "!";
                mostraMensagem();
                return;
            }
            bfp.descricaoPagamento  = bfp.descricaoPagamento.substring(5) + " ";
            for(int i = 0; i < bfp.descricaoPagamento.length() - 7; i++){
                texto = bfp.descricaoPagamento.substring(i, i + 7);
                texto = texto.replace("é", "e");
                if(texto.equalsIgnoreCase("credito")){
                    PegaQtdParcelas();
                    IncluirPagamentoEmCreditoVenda();
                    break;
                }
            }
        }
    }
    
    private void IncluirPagamentoEmCreditoVenda(){
        bvpc.idEmpresa             = bvp.idEmpresa;
        bvpc.codigoGrupo           = bvp.codigoGrupo;
        bvpc.codigoEmpresa         = bvp.codigoEmpresa;
        bvpc.codigoPagamento       = bvp.codigoPagamento;
        bvpc.valorTotalDoPagamento = bvp.valorDoPagamento;
        bvpc.qtdParcelas           = qtdDeParcelas;
        bvpc.valorDasParcelas      = bvpc.valorTotalDoPagamento / bvpc.qtdParcelas;
        
        sql = "insert into tb_vendas_pagamentos_credito (idEmpresa, codigoGrupo, codigoEmpresa, codigoPagamento, valorTotalDoPagamento, qtdParcelas, valorDasParcelas) "
            + "values (" + bvpc.idEmpresa + ", " + bvpc.codigoGrupo + ", " + bvpc.codigoEmpresa + ", " + bvpc.codigoPagamento + ", " + bvpc.valorTotalDoPagamento + ", " + bvpc.qtdParcelas + ", " + bvpc.valorDasParcelas + ");";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao incluir pagamento em crédito!";
            mostraMensagem();
        }
    }
    
    private void PagamentosVenda(){
        if(bvp.trocoDoPagamento >= 0.01){
            mensagem = "Valor Pago já bateu com Valor a Pagar!";
            mostraMensagem();
            return;
        }
        bvp.codigoPagamento             = Integer.parseInt(String.valueOf(combo_Pagamento.getSelectedItem()).substring(0, 2));
        bfp.descricaoPagamento          = String.valueOf(combo_Pagamento.getSelectedItem());
        bvp.valorDoPagamento            = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valor.getText(), 1));
        if(bvp.valorDoPagamento == 0){
            mensagem = "Valor do Pagamento não pode ser Zero!";
            mostraMensagem();
            return;
        }
        if(!bfp.descricaoPagamento.substring(5).replace(" ", "").equalsIgnoreCase("Dinheiro"))
            if(bvp.valorDoPagamento > ValorRestante){
                mensagem = "Valor incluso maior do que valor à pagar para a forma de pagamento selecionada!";
                mostraMensagem();
                return;
            }
        ValorRestante                   = ValorRestante - bvp.valorDoPagamento;
        if(ValorRestante < 0.03){
            if(ValorRestante < 0){
                bvp.trocoDoPagamento       = ValorRestante * (-1);
            }
            if(!bfp.descricaoPagamento.substring(5).replace(" ", "").equalsIgnoreCase("Dinheiro")){
                bvp.trocoDoPagamento = 0;
            }
            ValorRestante = 0;
            bt_finalizar.setEnabled(true);
        }else{
            bt_finalizar.setEnabled(false);
        }
        txt_valor.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorRestante), 0));
        txt_valorRestante.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorRestante), 0));
        TablePagamento.addRow(new Object[] {bfp.descricaoPagamento, parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bvp.valorDoPagamento), 0), parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bvp.trocoDoPagamento), 0)});
        if(ValorRestante <= 0){
            bt_finalizar.grabFocus();
        }else{
            combo_Pagamento.grabFocus();
        }
    }
    
    private void PegaComanda(){
        txt_codigo.setText(fc.FormataCampo(txt_codigo.getText(), 9, 0));
        if(bcom.codigoComanda == 0){
            return;
        }
        sql = "select * from tb_comandas where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoComanda = " + bcom.codigoComanda + ";";
        dadosComandas.clear();
        dadosComandas = parametrosNS.dao.Consulta(sql);
        if(dadosComandas.isEmpty()){
            mensagem = "Comanda n°" + bcom.codigoComanda + " não encontrada!;";
            mostraMensagem();
            return;
        }
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
        PegaComandaItens();
    }
    
    private void PegaComandaItens(){
        bcomi.idEmpresa     = bcom.idEmpresa;
        bcomi.codigoGrupo   = bcom.codigoGrupo;
        bcomi.codigoEmpresa = bcom.codigoEmpresa;
        bcomi.codigoComanda = bcom.codigoComanda;
        sql = "select * from tb_comandas_itens where idEmpresa = " + bcomi.idEmpresa + " and codigoComanda = " + bcomi.codigoComanda + ";";
        dadosComandasItens.clear();
        dadosComandasItens = parametrosNS.dao.Consulta(sql);
        if(dadosComandasItens.isEmpty()){
            mensagem = "Nõ foram encontrados itens cadastrados para a comanda n°" + bcom.codigoComanda + "!";
            mostraMensagem();
            return;
        }
        PegaDadosComandaItens();
    }
    
    private void PegaDadosComandaItens(){
        Table.setNumRows(0);
        ValorAPagar     = 0;
        for(int i = 0; i < dadosComandasItens.size(); i++){
            if(dadosComandasItens.get(i).get(0)  != null){bcomi.idComandaItem         = Integer.parseInt(  String.valueOf(dadosComandasItens.get(i).get(0)));}
            if(dadosComandasItens.get(i).get(1)  != null){bcomi.idEmpresa             = Integer.parseInt(  String.valueOf(dadosComandasItens.get(i).get(1)));}
            if(dadosComandasItens.get(i).get(2)  != null){bcomi.codigoGrupo           = Integer.parseInt(  String.valueOf(dadosComandasItens.get(i).get(2)));}
            if(dadosComandasItens.get(i).get(3)  != null){bcomi.codigoEmpresa         = Integer.parseInt(  String.valueOf(dadosComandasItens.get(i).get(3)));}
            if(dadosComandasItens.get(i).get(4)  != null){bcomi.codigoComanda         = Integer.parseInt(  String.valueOf(dadosComandasItens.get(i).get(4)));}
            if(dadosComandasItens.get(i).get(5)  != null){bcomi.codigoComandaItem     = Integer.parseInt(  String.valueOf(dadosComandasItens.get(i).get(5)));}
            if(dadosComandasItens.get(i).get(6)  != null){bcomi.codigoProduto         = Integer.parseInt(  String.valueOf(dadosComandasItens.get(i).get(6)));}
            if(dadosComandasItens.get(i).get(7)  != null){bcomi.codigoUsuario         = Integer.parseInt(  String.valueOf(dadosComandasItens.get(i).get(7)));}
            if(dadosComandasItens.get(i).get(8)  != null){bcomi.valorUnitario         = Double.parseDouble(String.valueOf(dadosComandasItens.get(i).get(8)));}
            if(dadosComandasItens.get(i).get(9)  != null){bcomi.quantidade            = Double.parseDouble(String.valueOf(dadosComandasItens.get(i).get(9)));}
            if(dadosComandasItens.get(i).get(10) != null){bcomi.valorTotal            = Double.parseDouble(String.valueOf(dadosComandasItens.get(i).get(10)));}
            
            bp.codigoProduto = bcomi.codigoProduto;
            PegaProduto();
            
            ValorAPagar = ValorAPagar + bcomi.valorTotal;
            
            Table.addRow(new Object [] {String.valueOf(fc.FormataCampo(String.valueOf(bcomi.codigoComandaItem), 2, 0)), fc.FormataCampo(String.valueOf(bp.codigoProduto), 5, 0) + "-" + bp.descricaoProduto, parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bcomi.valorUnitario), 0), String.valueOf(bcomi.quantidade), parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bcomi.valorTotal), 0)});
        }
        PreencherCampos();
        txt_precoTotal.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorAPagar), 0));
    }
    
    private void IncluirMovimentoContabil(){
        if(codigoPlanoDeContasRel.equals("")){
            return;
        }
        bplamov.idEmpresa           = parametrosNS.be.IdEmpresa;
        bplamov.codigoGrupo         = parametrosNS.bge.CodigoGrupo;
        bplamov.codigoEmpresa       = parametrosNS.be.CodigoEmpresa;
        bplamov.codigoPlanoDeContas = codigoPlanoDeContasRel;
        bplamov.dataPlanoDeContas   = invdata.inverterData(cdh.CapturarData(), 2);
        bplamov.saldo               = ValorAPagar;
        sql = "insert into tb_planodecontasmovimentos (idEmpresa, codigoGrupo, codigoEmpresa, codigoPlanoDeContas, dataPlanoDeContas, saldo) "
            + "values (" + bplamov.idEmpresa + ", " + bplamov.codigoGrupo + ", " + bplamov.codigoEmpresa + ", " + bplamov.codigoPlanoDeContas + ", '" + bplamov.dataPlanoDeContas + "', " + bplamov.saldo + ");";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao incluir Venda no registro contábil!";
            mostraMensagem();
//            return;
        }
    }
    
}
