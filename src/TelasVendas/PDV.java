package TelasVendas;

import TelasFaturamento.ClientesConsulta;
import Beans.*;
import FuncoesInternas.*;
import TelasEstoque.ProdutosConsulta;
import TelasProducao.EfetuarPagamento;
import Parametros.parametrosNS;
import Telas.LoginPDV;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/*
 @author Tiago e Paulo
 */
public class PDV extends javax.swing.JFrame {
    //String
    String sql           = "";
    String fatal         = "";
    String sqlstate      = "";
    String mensagem      = "";
    String somostra      = "";
    String retorno       = "";
    String operacao      = "";
    String UltimaVenda   = "";
    String FatalAbertura = "N";
    String preenchimento = "";
    String Tipo          = "";
    String Tipo2         = "";
    
    public String Modo   = "";
    
    //int
    int linha              = 0;
    int UltimoRegistro     = 0;
    int abriuCliente       = 0;
    int abriuVenda         = 0;
    int abriuPesquisaVenda = 0;
    int abriuProdutos      = 0;
    int abriuLoginPDV      = 0;
    int abriuTela          = 0;
    
    int    codigoCliente = 0;
    String cpfCnpj       = "";
    
    //Float
    double ValorTotal                   = 0;
//    BigInteger ValorTotal = 0;
    
    //Beans
    private BeanUsuarios         bu      = new BeanUsuarios();
    public  BeanClientes         bc      = new BeanClientes();
    private BeanVendas           bv      = new BeanVendas();
    private BeanVendasItens      bvi     = new BeanVendasItens();
    private BeanProdutos         bp      = new BeanProdutos();
    private BeanParametros       bpar    = new BeanParametros();
    private BeanParametrosVendas bparven = new BeanParametrosVendas();
    private BeanCaixaAbertura    bca     = new BeanCaixaAbertura();
    private BeanComandas         bcom    = new BeanComandas();
    private BeanComandasItens    bcomi   = new BeanComandasItens();
    
    //Vetores
    ArrayList            parametros                = new ArrayList();
    ArrayList            dadosPadroes              = new ArrayList();
    ArrayList<ArrayList> dadosCliente              = new ArrayList();
    ArrayList<ArrayList> dadosUsuarios             = new ArrayList();
    ArrayList<ArrayList> dadosProdutos             = new ArrayList();
    ArrayList<ArrayList> dadosVendasAssociativo    = new ArrayList();
    ArrayList<ArrayList> dadosVendas               = new ArrayList();
    ArrayList<ArrayList> dadosVendasItens          = new ArrayList();
    ArrayList<ArrayList> dadosParametros           = new ArrayList();
    ArrayList<ArrayList> dadosParametrosVendas     = new ArrayList();
    ArrayList<ArrayList> dadosCaixa                = new ArrayList();
    ArrayList<ArrayList> dadosComandas             = new ArrayList();
    ArrayList<ArrayList> dadosComandasItens        = new ArrayList();
    ArrayList<ArrayList> dadosCount                = new ArrayList();
    
    //Telas
    AberturaDeCaixa                 AberDeCaixa;
    ClientesConsulta                CliCon;
    EfetuarPagamento                EfePag;
    ProdutosConsulta                ProCon;
    VendasConsultaEManutencao       VenConMan;
    LoginPDV                        lgPdv;
    
    //Funções
    DefaultTableModel Table;
    InformarCPFouCNPJ InfCPFouCNPJ;
    
    //Outros
    PreparedStatement               stmt;
    ResultSet                       rs;
    JRResultSetDataSource           js;
    
    //Funções para Relatórios
    String                  jpv         = "";
    JasperPrint             jpp         = null;
    HashMap                 hm          = new HashMap();
    JRPrintPage             jrp         = null;
    List                    QtdPages    = null;
    
    //Telas
    
    //Jasper
    String         arquivoJasper = "";
    JasperPrint    rel           = null;
    HashMap        map           = new HashMap();
    
    public PDV(ArrayList DadosPadroes){
        dadosPadroes        = DadosPadroes;
        
        somostra            = (String)  dadosPadroes.get(0);
        bv.idVenda          = (int)     dadosPadroes.get(1);
        bcom.codigoComanda  = (int)     dadosPadroes.get(2);
        codigoCliente       = (int)     dadosPadroes.get(3);
        cpfCnpj             = (String)  dadosPadroes.get(4);
        
        initComponents();
    }
    
//    private void PegaParametros(){
//        sql = "select * from tb_parametros where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
//        dadosParametros.clear();
//        dadosParametros = parametrosNS.dao.Consulta(sql);
//        if(dadosParametros.isEmpty()){
//            bt_imprimir.setVisible(false);
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
    
    private void PegaParametrosVendas(){
        sql = "select * from tb_parametrosvendas where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosParametrosVendas.clear();
        dadosParametrosVendas = parametrosNS.dao.Consulta(sql);
        if(dadosParametrosVendas.isEmpty()){
//            mensagem = "Parâmetros de Vendas não encontrados!";
//            new MostraMensagem(mensagem);
            return;
        }
        PegaDadosParametrosVendas();
    }
    
    private void PegaDadosParametrosVendas(){
        for(int i = 0; i < dadosParametrosVendas.size(); i++){
            if(dadosParametrosVendas.get(i).get(0) != null){
                bparven.idParametrosVendas  = Integer.parseInt(String.valueOf(dadosParametrosVendas.get(i).get(0)));
            }
            if(dadosParametrosVendas.get(i).get(1) != null){
                bparven.idEmpresa           = Integer.parseInt(String.valueOf(dadosParametrosVendas.get(i).get(1)));
            }
            if(dadosParametrosVendas.get(i).get(2) != null){
                bparven.codigoGrupo         = Integer.parseInt(String.valueOf(dadosParametrosVendas.get(i).get(2)));
            }
            if(dadosParametrosVendas.get(i).get(3) != null){
                bparven.codigoEmpresa       = Integer.parseInt(String.valueOf(dadosParametrosVendas.get(i).get(3)));
            }
            if(dadosParametrosVendas.get(i).get(4) != null){
                bparven.infQtdMenor         = Integer.parseInt(String.valueOf(dadosParametrosVendas.get(i).get(4)));
            }
        }
    }
    
    private void VerificaCaixaFechado(){
        fatal = "N";
        bca.dataAbertura        = parametrosNS.invdata.inverterData(parametrosNS.cdh.CapturarData(), 2);
        sql = "select * from tb_caixa_abertura where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosCaixa.clear();
        dadosCaixa = parametrosNS.dao.Consulta(sql);
        if(dadosCaixa.isEmpty()){
            return;
        }
        sql = "select * from tb_caixa_abertura where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoComputador = " + parametrosNS.bcomp.codigoComputador + " and dataAbertura = '" + bca.dataAbertura + "' and status = 'Z';";
        dadosCaixa.clear();
        dadosCaixa = parametrosNS.dao.Consulta(sql);
        if(dadosCaixa.isEmpty()){
            return;
        }
        fatal = "S";
        mensagem = "Caixa Fechado com Redução Z!";
        new MostraMensagem(mensagem);
        bt_finalizar        .setVisible (false);
        bt_pesquisaVenda    .setEnabled (false);
        txt_codigoProduto   .setEditable(false);
        bt_pesquisaProduto  .setEnabled (false);
    }
    
    private void VerificaCaixaAberto(){
        FatalAbertura = "N";
        bca.codigoComputador    = parametrosNS.bcomp.codigoComputador;
        bca.dataAbertura        = parametrosNS.invdata.inverterData(parametrosNS.cdh.CapturarData(), 2);
        sql = "select * from tb_caixa_abertura where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoComputador = " + bca.codigoComputador + " and status = 'A';";
        dadosCaixa.clear();
        dadosCaixa = parametrosNS.dao.Consulta(sql);
        if(!dadosCaixa.isEmpty()){
            return;
        }
        FatalAbertura = "S";
        if(JOptionPane.showConfirmDialog(null, "Não foi encontrado Caixa Aberto para esse Terminal, deseja abri-lo?", "", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION){
            dispose();
            return;
        }
        AberDeCaixa = new AberturaDeCaixa();
        AberDeCaixa.setVisible(true);
        dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_limpar = new javax.swing.JMenuItem();
        bt_remover = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        combo_usuarios = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        bt_pesquisaProduto = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_valortotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_codigoProduto = new javax.swing.JTextField();
        bt_adicionar = new javax.swing.JButton();
        txt_quantidade = new javax.swing.JFormattedTextField();
        txt_valorUnitario = new javax.swing.JFormattedTextField();
        label_descricaoProduto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_valorParcial = new javax.swing.JTextField();
        txt_valorDesconto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        combo_tipoDesconto = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        label_alteracao = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        label_cliente = new javax.swing.JLabel();
        txt_cpfcnpj1 = new javax.swing.JFormattedTextField();
        txt_cpfcnpj2 = new javax.swing.JFormattedTextField();
        txt_cpfcnpj3 = new javax.swing.JFormattedTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        bt_iniciarVenda = new javax.swing.JButton();
        bt_localizarCliente = new javax.swing.JButton();
        bt_localizarProduto = new javax.swing.JButton();
        bt_finalizarVenda = new javax.swing.JButton();
        bt_alterarValorUnitario = new javax.swing.JButton();
        bt_selecionarItem = new javax.swing.JButton();
        bt_removerTodosItens = new javax.swing.JButton();
        bt_removerItem = new javax.swing.JButton();
        bt_sair1 = new javax.swing.JButton();
        bt_incluirDesconto = new javax.swing.JButton();
        txt_total = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        bt_finalizar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_itens_vendas = new javax.swing.JTable();
        bt_pesquisaVenda = new javax.swing.JButton();
        bt_imprimir = new javax.swing.JButton();
        bt_imprimirCupom = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        bt_sair = new javax.swing.JMenuItem();

        bt_limpar.setText("Limpar Tabela de Itens");
        bt_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_limparActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_limpar);

        bt_remover.setText("Remover Item Selecionado");
        bt_remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_removerActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_remover);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(":: Ponto de Vendas (PDV)");
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
            public void windowIconified(java.awt.event.WindowEvent evt) {
                formWindowIconified(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Atendente");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        combo_usuarios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_usuariosItemStateChanged(evt);
            }
        });
        combo_usuarios.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo_usuariosFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(combo_usuarios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(combo_usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Código: ");

        bt_pesquisaProduto.setText("...");
        bt_pesquisaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaProdutoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Quantidade:");

        jLabel12.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Valor unitário:");

        jLabel13.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Valor total:");

        txt_valortotal.setEditable(false);
        txt_valortotal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
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

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Produto");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_codigoProduto.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
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

        bt_adicionar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        bt_adicionar.setText("Adicionar");
        bt_adicionar.setEnabled(false);
        bt_adicionar.setFocusable(false);
        bt_adicionar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bt_adicionarFocusGained(evt);
            }
        });
        bt_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_adicionarActionPerformed(evt);
            }
        });
        bt_adicionar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bt_adicionarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bt_adicionarKeyReleased(evt);
            }
        });

        txt_quantidade.setEditable(false);
        txt_quantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txt_quantidade.setFocusable(false);
        txt_quantidade.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txt_quantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_quantidadeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_quantidadeFocusLost(evt);
            }
        });
        txt_quantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_quantidadeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_quantidadeKeyReleased(evt);
            }
        });

        txt_valorUnitario.setEditable(false);
        txt_valorUnitario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txt_valorUnitario.setFocusable(false);
        txt_valorUnitario.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txt_valorUnitario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_valorUnitarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorUnitarioFocusLost(evt);
            }
        });
        txt_valorUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_valorUnitarioKeyPressed(evt);
            }
        });

        label_descricaoProduto.setEditable(false);
        label_descricaoProduto.setBackground(new java.awt.Color(51, 51, 51));
        label_descricaoProduto.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        label_descricaoProduto.setForeground(new java.awt.Color(255, 255, 255));
        label_descricaoProduto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        label_descricaoProduto.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Valor do desconto:");

        jLabel7.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Valor Subtotal:");

        txt_valorParcial.setEditable(false);
        txt_valorParcial.setFocusable(false);

        txt_valorDesconto.setEditable(false);
        txt_valorDesconto.setFocusable(false);
        txt_valorDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_valorDescontoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorDescontoFocusLost(evt);
            }
        });
        txt_valorDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_valorDescontoKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Tipo de desconto:");

        combo_tipoDesconto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Real", "Porcentagem" }));
        combo_tipoDesconto.setEnabled(false);
        combo_tipoDesconto.setFocusable(false);
        combo_tipoDesconto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_tipoDescontoItemStateChanged(evt);
            }
        });
        combo_tipoDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo_tipoDescontoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label_descricaoProduto)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_codigoProduto)
                    .addComponent(txt_valorUnitario)
                    .addComponent(combo_tipoDesconto, 0, 96, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_valorDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bt_pesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_valortotal, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_valorParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_adicionar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel13, jLabel7});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(label_descricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_pesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_codigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(txt_valorParcial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_valorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_valortotal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_valorDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(combo_tipoDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_adicionar, bt_pesquisaProduto, combo_tipoDesconto, jLabel10, jLabel12, jLabel13, jLabel2, jLabel6, jLabel7, jLabel9, txt_codigoProduto, txt_quantidade, txt_valorDesconto, txt_valorParcial, txt_valorUnitario, txt_valortotal});

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        label_alteracao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_alteracao.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_alteracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_alteracao, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Cliente");
        jLabel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        label_cliente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        label_cliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_cliente.setText("Nome do cliente");
        label_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_clienteMouseEntered(evt);
            }
        });

        txt_cpfcnpj1.setEditable(false);
        try {
            txt_cpfcnpj1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("### ### ###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cpfcnpj1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cpfcnpj1.setFocusable(false);
        txt_cpfcnpj1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
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
        txt_cpfcnpj2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
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
        txt_cpfcnpj3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_cliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txt_cpfcnpj1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cpfcnpj2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cpfcnpj3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_cpfcnpj2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cpfcnpj3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cpfcnpj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Funções");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bt_iniciarVenda.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        bt_iniciarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconesPDV/Carrinho.png"))); // NOI18N
        bt_iniciarVenda.setText("   F1 - Inicia nova venda");
        bt_iniciarVenda.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        bt_iniciarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_iniciarVendaActionPerformed(evt);
            }
        });

        bt_localizarCliente.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        bt_localizarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconesPDV/Pessoa.png"))); // NOI18N
        bt_localizarCliente.setText("   F2 - Localizar Cliente");
        bt_localizarCliente.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        bt_localizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_localizarClienteActionPerformed(evt);
            }
        });

        bt_localizarProduto.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        bt_localizarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconesPDV/Caixa.png"))); // NOI18N
        bt_localizarProduto.setText("   F3 - Localizar Produto");
        bt_localizarProduto.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        bt_localizarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_localizarProdutoActionPerformed(evt);
            }
        });

        bt_finalizarVenda.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        bt_finalizarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconesPDV/Cartao.png"))); // NOI18N
        bt_finalizarVenda.setText("   F4 - Finalizar a Venda");
        bt_finalizarVenda.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        bt_finalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_finalizarVendaActionPerformed(evt);
            }
        });

        bt_alterarValorUnitario.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        bt_alterarValorUnitario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconesPDV/Editar.png"))); // NOI18N
        bt_alterarValorUnitario.setText("   F5 - Alterar Valor Unitário");
        bt_alterarValorUnitario.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        bt_alterarValorUnitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterarValorUnitarioActionPerformed(evt);
            }
        });

        bt_selecionarItem.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        bt_selecionarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconesPDV/Alvo.png"))); // NOI18N
        bt_selecionarItem.setText("   F6 - Selecionar Item");
        bt_selecionarItem.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        bt_selecionarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_selecionarItemActionPerformed(evt);
            }
        });

        bt_removerTodosItens.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        bt_removerTodosItens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconesPDV/Cancelar.png"))); // NOI18N
        bt_removerTodosItens.setText("   F7 - Remover todos itens");
        bt_removerTodosItens.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        bt_removerTodosItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_removerTodosItensActionPerformed(evt);
            }
        });

        bt_removerItem.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        bt_removerItem.setText("DEL - Remover item");
        bt_removerItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_removerItemActionPerformed(evt);
            }
        });

        bt_sair1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        bt_sair1.setText("ESC - Sair/Cancelar");
        bt_sair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sair1ActionPerformed(evt);
            }
        });

        bt_incluirDesconto.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        bt_incluirDesconto.setText("F8 - Incluir Desconto");
        bt_incluirDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_incluirDescontoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_sair1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_removerItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_iniciarVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addComponent(bt_localizarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addComponent(bt_localizarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addComponent(bt_finalizarVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addComponent(bt_alterarValorUnitario, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addComponent(bt_selecionarItem, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addComponent(bt_removerTodosItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_incluirDesconto, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_alterarValorUnitario, bt_finalizarVenda, bt_incluirDesconto, bt_iniciarVenda, bt_localizarCliente, bt_localizarProduto, bt_removerTodosItens, bt_selecionarItem});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(bt_iniciarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(bt_localizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_localizarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_finalizarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_alterarValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_selecionarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_removerItem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_removerTodosItens, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_incluirDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_sair1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_alterarValorUnitario, bt_finalizarVenda, bt_incluirDesconto, bt_iniciarVenda, bt_localizarCliente, bt_localizarProduto, bt_removerTodosItens, bt_selecionarItem});

        txt_total.setEditable(false);
        txt_total.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        txt_total.setForeground(new java.awt.Color(51, 51, 51));
        txt_total.setText("R$ 0,00");
        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Verdana", 1, 26)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Total:");

        bt_finalizar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
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

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setMaximumSize(new java.awt.Dimension(99999, 99999));

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Itens / Detalhes");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_itens_vendas.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tabela_itens_vendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Descrição", "Código de Barras", "Valor Unitário", "Qtd", "Valor Parcial", "Valor de Desconto", "Preço Total"
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
        tabela_itens_vendas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_itens_vendas.getTableHeader().setReorderingAllowed(false);
        tabela_itens_vendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_itens_vendasMouseClicked(evt);
            }
        });
        tabela_itens_vendas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabela_itens_vendasKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_itens_vendas);
        if (tabela_itens_vendas.getColumnModel().getColumnCount() > 0) {
            tabela_itens_vendas.getColumnModel().getColumn(0).setResizable(false);
            tabela_itens_vendas.getColumnModel().getColumn(3).setResizable(false);
            tabela_itens_vendas.getColumnModel().getColumn(4).setResizable(false);
            tabela_itens_vendas.getColumnModel().getColumn(5).setResizable(false);
            tabela_itens_vendas.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        bt_pesquisaVenda.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bt_pesquisaVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/View.png"))); // NOI18N
        bt_pesquisaVenda.setText("Pesquisa");
        bt_pesquisaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaVendaActionPerformed(evt);
            }
        });

        bt_imprimir.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bt_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/print.png"))); // NOI18N
        bt_imprimir.setText("Imprimir");
        bt_imprimir.setEnabled(false);
        bt_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imprimirActionPerformed(evt);
            }
        });

        bt_imprimirCupom.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bt_imprimirCupom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/print.png"))); // NOI18N
        bt_imprimirCupom.setText("Imprimir Cupom");
        bt_imprimirCupom.setEnabled(false);
        bt_imprimirCupom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imprimirCupomActionPerformed(evt);
            }
        });

        jMenu1.setText("Funções");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem1.setText("Iniciar Nova Venda");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem2.setText("Localizar Cliente");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem3.setText("Localizar Produto");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem4.setText("Finalizar Venda");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem6.setText("Alterar Valor Unitário");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuItem5.setText("Selecionar Item");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        jMenuItem7.setText("Remover todos itens");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        jMenuItem9.setText("Aplicar Desconto");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);
        jMenu1.add(jSeparator2);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        jMenuItem8.setText("Remover Item");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

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
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_imprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisaVenda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_imprimirCupom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_finalizar, bt_imprimir, bt_pesquisaVenda});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel2, jPanel4, jPanel6});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_imprimirCupom, javax.swing.GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(bt_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(bt_pesquisaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(bt_finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_finalizar, bt_imprimir, bt_imprimirCupom, bt_pesquisaVenda, jLabel19});

        txt_total.getAccessibleContext().setAccessibleName("");
        jLabel19.getAccessibleContext().setAccessibleName("");
        bt_finalizar.getAccessibleContext().setAccessibleName("");
        bt_pesquisaVenda.getAccessibleContext().setAccessibleName("");
        bt_imprimir.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void txt_cpfcnpj1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cpfcnpj1ActionPerformed

    private void txt_cpfcnpj1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1FocusGained
        txt_cpfcnpj1.setText("");
    }//GEN-LAST:event_txt_cpfcnpj1FocusGained

    private void txt_cpfcnpj1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1FocusLost

    }//GEN-LAST:event_txt_cpfcnpj1FocusLost

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

    private void txt_valortotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valortotalFocusLost
        
    }//GEN-LAST:event_txt_valortotalFocusLost

    private void txt_valortotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valortotalKeyReleased
        
    }//GEN-LAST:event_txt_valortotalKeyReleased

    private void bt_pesquisaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaProdutoActionPerformed
        LocalizarProduto();
    }//GEN-LAST:event_bt_pesquisaProdutoActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        AbreCliente();
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbreCliente(){
        if(abriuCliente == 0){
            AbreProdutos();
            return;
        }
        abriuCliente = 0;
        preenchimento = "";
        retorno = "99999";
        if(parametrosNS.codigoCliente != 0){
            if(parametrosNS.codigoCliente != 99999){
                parametrosNS.cpfCnpj = "";
                retorno = String.valueOf(parametrosNS.codigoCliente);
            }
        }
        if(!parametrosNS.cpfCnpj.equals("")){
            cpfCnpj = parametrosNS.FCampoCpfCnpj.FormataCampoCpfCnpj(parametrosNS.cpfCnpj).replace(" ", "");
            preenchimento = "cpfCnpj = '" + cpfCnpj + "'";
        }
        if(parametrosNS.codigoCliente == 0){
            if(parametrosNS.cpfCnpj.equals("")){
                cpfCnpj = parametrosNS.fc.FormataCampo("", 15, 0);
            }
        }
        codigoCliente = Integer.parseInt(retorno);
        if(preenchimento.equals("")){
            bc.codigoCliente = codigoCliente;
            preenchimento = "codigoCliente = " + bc.codigoCliente;
        }
        sql = "select idCliente, idEmpresa, codigoGrupo, codigoEmpresa, codigoCliente, nome, cpfCnpj from tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and " + preenchimento + ";";
        PegaCliente();
    }
    
    private void AbreProdutos(){
        if(abriuProdutos == 0){
            AbreFinalizaVenda();
            return;
        }
        abriuProdutos = 0;
        if(bv.status != 0){
            return;
        }
        retorno = ProCon.getRetorno();
        if(retorno.equals("")){
            txt_codigoProduto.grabFocus();
            return;
        }
        txt_codigoProduto.setText(retorno);
        Tipo2 = "cdb";
        PegaCodigoDeBarras();
    }
    
    private void AbreFinalizaVenda(){
        if(abriuVenda == 0){
            AbrePesquisaVenda();
            return;
        }
        abriuVenda = 0;
        sqlstate = EfePag.getRetornoFinaliza();
        if(!sqlstate.equals("ok") & !sqlstate.equals("00000"))
            return;
        if(Tipo.equalsIgnoreCase("Comanda")){
            IncluirVenda();
            if(!sqlstate.equals("00000")){
                return;
            }
            IncluirItensVenda();
            if(!sqlstate.equals("00000")){
                return;
            }
            sql = "update tb_vendas set status = 2 where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoVenda = " + bv.codigoVenda + ";";
            sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
            if(!sqlstate.equals("00000")){
                return;
            }
        }
        if(bcom.codigoComanda == 0){
            ReiniciaCampos();
            return;
        }
        retorno = "ok";
        dispose();
    }
    
    private void AbrePesquisaVenda(){
        if(abriuPesquisaVenda == 0){
            AbreLoginPdv();
            return;
        }
        abriuPesquisaVenda = 0;
        retorno = VenConMan.getRetorno();
        if(retorno.equals("")){
            return;
        }
        bv.codigoVenda = Integer.parseInt(retorno);
        PegaVenda();
    }
    
    private void AbreLoginPdv(){
        if(abriuLoginPDV == 0){
            return;
        }
        abriuLoginPDV = 0;
        retorno = lgPdv.getRetorno();
        if(retorno.equals("")){
            combo_usuarios.setSelectedItem(parametrosNS.fc.FormataCampo(String.valueOf(parametrosNS.bu.codigoUsuario), 3, 0) + " - " + parametrosNS.bu.usuario);
            return;
        }
        lgPdv = null;
        parametrosNS.bu.codigoUsuario = Integer.parseInt(String.valueOf(combo_usuarios.getSelectedItem()).substring(0, 3));
        parametrosNS.PegaUsuario("");
    }
    
    private void txt_codigoProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoProdutoFocusLost
        if(txt_codigoProduto.getText().replace(" ", "").equals("")){
            return;
        }
        if(somostra.equals("S")){
            return;
        }
        if(bv.status != 0){
            return;
        }
        Tipo2 = "cdb";
        PegaCodigoDeBarras();
    }//GEN-LAST:event_txt_codigoProdutoFocusLost
    
    private void txt_codigoProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoProdutoFocusGained
        bp = new BeanProdutos();
        
        txt_codigoProduto     .setText("");
        label_descricaoProduto.setText("");
        txt_valorUnitario     .setText("");
        txt_valorUnitario     .setEditable(false);
        txt_valorUnitario     .setFocusable(false);
        txt_quantidade        .setText("");
        txt_quantidade        .setEditable(false);
        txt_quantidade        .setFocusable(false);
        txt_valorParcial      .setText("");
        combo_tipoDesconto    .setSelectedIndex(0);
        combo_tipoDesconto    .setEnabled  (false);
        combo_tipoDesconto    .setFocusable(false);
        txt_valorDesconto     .setText("");
        txt_valorDesconto     .setEditable (false);
        txt_valorDesconto     .setFocusable(false);
        txt_valortotal        .setText("");
        bt_adicionar          .grabFocus();
    }//GEN-LAST:event_txt_codigoProdutoFocusGained

    private void bt_finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_finalizarActionPerformed
        FinalizarVenda();
    }//GEN-LAST:event_bt_finalizarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HabilitaCampos(false);
        
        Table   = (DefaultTableModel)tabela_itens_vendas.getModel();
        
//        abriuTela = 1;
        abriuLoginPDV = 0;
        PegaUsuario("", "S");
        
//        PegaParametros();
        PegaParametrosVendas();

        if(somostra.equalsIgnoreCase("N")){
            VerificaCaixaFechado();
            if(fatal.equals("S")){
                return;
            }
            VerificaCaixaAberto();
            if(FatalAbertura.equals("S")){
                return;
            }
        }
        Tipo = "Venda";
        if(bv.idVenda != 0){
            PegaVenda();
        }else{
            NovaVenda();/*{
            if(codigoCliente != 0){
                if(codigoCliente != 99999){
                    sql = "select idCliente, idEmpresa, codigoGrupo, codigoEmpresa, codigoCliente, nome, cpfCnpj from tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCliente = " + codigoCliente + ";";
                    PegaCliente();
                }
            }
            if(!cpfCnpj.equals("")){
                sql = "select idCliente, idEmpresa, codigoGrupo, codigoEmpresa, codigoCliente, nome, cpfCnpj from tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and cpfCnpj = '" + cpfCnpj + "';";
                PegaCliente();
            }*/
        }
        if(bcom.codigoComanda != 0){
            txt_codigoProduto   .setEditable (false);
            txt_codigoProduto   .setFocusable(false);
            bt_pesquisaVenda    .setVisible  (false);
            bt_pesquisaProduto  .setEnabled  (false);
            bt_pesquisaProduto  .setFocusable(false);
            txt_valorUnitario   .setEditable (false);
            txt_valorUnitario   .setFocusable(false);
            txt_quantidade      .setEditable (false);
            txt_quantidade      .setFocusable(false);
            Tipo = "Comanda";
            PegaComanda();
        }
        if(somostra.equals("SN")){
            bt_pesquisaVenda    .setVisible (false);
        }
        if(somostra.equals("S")){
            bt_pesquisaProduto     .setEnabled (false);
            bt_pesquisaVenda       .setVisible (false);
            txt_codigoProduto      .setEditable(false);
            bt_finalizar           .setVisible (false);
            bt_adicionar           .setEnabled (false);
            bt_iniciarVenda        .setEnabled (false);
            bt_localizarCliente    .setEnabled (false);
            bt_localizarProduto    .setEnabled (false);
            bt_finalizarVenda      .setEnabled (false);
            bt_alterarValorUnitario.setEnabled (false);
            bt_selecionarItem      .setEnabled (false);
            bt_removerItem         .setEnabled (false);
            bt_removerTodosItens   .setEnabled (false);
            bt_incluirDesconto     .setEnabled (false);
            bt_sair1               .setEnabled (false);
        }
        
        tabela_itens_vendas.getColumnModel().getColumn(0).setPreferredWidth(9);     //Item
        tabela_itens_vendas.getColumnModel().getColumn(1).setPreferredWidth(230);   //Descrição
        tabela_itens_vendas.getColumnModel().getColumn(2).setPreferredWidth(65);    //Código de Barras
        tabela_itens_vendas.getColumnModel().getColumn(3).setPreferredWidth(60);    //Preço Unitário
        tabela_itens_vendas.getColumnModel().getColumn(4).setPreferredWidth(20);    //Quantidade
        tabela_itens_vendas.getColumnModel().getColumn(5).setPreferredWidth(60);    //Total
        
        if(FatalAbertura.equals("S")){dispose();}
    }//GEN-LAST:event_formWindowOpened

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(somostra.equalsIgnoreCase("S")){
            return;
        }
        NovaVenda();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if(somostra.equalsIgnoreCase("S")){
            return;
        }
        LocalizarCliente();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if(txt_codigoProduto.isEditable() == false){
            return;
        }
        if(somostra.equalsIgnoreCase("S")){
            return;
        }
        txt_quantidade.grabFocus();
        LocalizarProduto();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if(bt_finalizar.isEnabled() == false){
            return;
        }
        if(somostra.equalsIgnoreCase("S")){
            return;
        }
        FinalizarVenda();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void bt_pesquisaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaVendaActionPerformed
        if(VenConMan != null)if(VenConMan.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        abriuPesquisaVenda = 1;
        parametros.clear();
        parametros.add("S");
        parametros.add("N");
        VenConMan = new VendasConsultaEManutencao(parametros);
        VenConMan.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaVendaActionPerformed

    private void bt_adicionarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bt_adicionarKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        IncluirItemjTable();
    }//GEN-LAST:event_bt_adicionarKeyPressed
    
    private void IncluirItemjTable(){
        bvi.codigoVendaItem = tabela_itens_vendas.getRowCount() + 1;
        ValorTotal = ValorTotal + bvi.valorTotal;
        txt_total.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotal), 0));
        
        String desconto = "";
        if(bvi.tipoDesconto == 0){
            desconto = String.valueOf(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bvi.valorDesconto), 0));
        }else{
            desconto = String.valueOf(bvi.valorDesconto * 100) + "%";
        }
        Table.addRow(new Object[] {parametrosNS.fc.FormataCampo(String.valueOf(bvi.codigoVendaItem), 2, 0), parametrosNS.fc.FormataCampo(String.valueOf(bp.codigoProduto), 5, 0) + "-" + bp.descricaoProduto, bp.codigoDeBarras, parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bvi.valorUnitario), 0), bvi.quantidade, parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bvi.valorSubtotal), 0), desconto, parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bvi.valorTotal), 0)});
        if(tabela_itens_vendas.getRowCount() > 0){
            bt_finalizar.setEnabled(true);
            new AjustarLarguraColunas(tabela_itens_vendas);
        }
        bvi.valorUnitario = 0;
        bvi.quantidade    = 0;
        bvi.valorSubtotal = 0;
        bvi.tipoDesconto  = 0;
        bvi.valorDesconto = 0;
        bvi.valorTotal    = 0;
        txt_codigoProduto.grabFocus();
        bt_adicionar.setEnabled(false);
        bt_adicionar.setFocusable(false);
    }
    
//    private void IncluirVendaeVendaItem(){
//        if(somostra.equals("S"))
//            return;
//        if(txt_valortotal.getText().equals(""))
//            return;
//        if(operacao.equals("I")){
//            IncluirVenda();
//            if(fatal.equals("S"))return;
//        }
//        IncluirVendaItem();
//    }
    
    private void bt_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_adicionarActionPerformed
//        IncluirVendaeVendaItem();
        IncluirItemjTable();
    }//GEN-LAST:event_bt_adicionarActionPerformed

    private void label_clienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_clienteMouseEntered
        label_cliente.setToolTipText(label_cliente.getText());
    }//GEN-LAST:event_label_clienteMouseEntered

    private void txt_quantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantidadeFocusLost
        if(somostra.equals("S")){return;}
        if(bv.status != 0){return;}
        if(txt_quantidade.getText().replace(" ", "").equals("")){
            bvi.quantidade = 0;
            return;
        }
        combo_usuarios.setFocusable(false);
        try{
            bvi.quantidade              = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_quantidade.getText(), 1));
        }catch(Exception erro){
            mensagem = "Quantidade inválida!";
            new MostraMensagem(mensagem);
            return;
        }
        if(bparven.infQtdMenor == 1){
            if(bvi.quantidade > bp.quantidadeAtual){
                mensagem = "Quantidade incluida maior do que em estoque!";
                new MostraMensagem(mensagem);
                return;
            }
        }
        bvi.valorUnitario   = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorUnitario.getText(), 1));
        bvi.valorSubtotal   = bvi.valorUnitario * bvi.quantidade;
        bvi.valorTotal      = bvi.valorSubtotal;
        txt_valorParcial.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bvi.valorSubtotal), 0));
        txt_valortotal  .setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bvi.valorTotal)   , 0));
        bt_adicionar.setEnabled  (true);
        bt_adicionar.setFocusable(true);
        bt_adicionar.grabFocus();
    }//GEN-LAST:event_txt_quantidadeFocusLost

    private void txt_quantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_quantidadeKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        if(bv.status != 0){
            return;
        }
        if(txt_quantidade.getText().equals("")){
            return;
        }
        bt_adicionar.setEnabled  (true);
        bt_adicionar.setFocusable(true);
        bt_adicionar.grabFocus();
    }//GEN-LAST:event_txt_quantidadeKeyPressed

    private void txt_valorUnitarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorUnitarioFocusLost
        if(txt_valorUnitario.getText().equals("")){
            bp.valorDeVenda = 0;
            return;
        }
        txt_valorUnitario.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble((txt_valorUnitario.getText()), 0));
    }//GEN-LAST:event_txt_valorUnitarioFocusLost

    private void bt_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimirActionPerformed
        bv.codigoCliente    = bc.codigoCliente;
        sql = "select "
            + "   * "
            + "from "
            + "    tb_vendas ven "
            + "    inner join tb_vendas_itens venIte on venIte.codigoVenda = " + bv.codigoVenda + " "
            + "    inner join tb_produtos pro on pro.codigoProduto = venIte.codigoProduto "
            + "    inner join tb_clientes cli on cli.codigoCliente = " + bv.codigoCliente + " "
            + "    where ven.idEmpresa = " + parametrosNS.be.IdEmpresa + " and ven.codigoVenda = " + bv.codigoVenda + ";";
        Imprimir();
    }//GEN-LAST:event_bt_imprimirActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void tabela_itens_vendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_itens_vendasMouseClicked
        linha = tabela_itens_vendas.getSelectedRow();
        if(linha < 0){
            mensagem = "Item não selecionado!";
            new MostraMensagem(mensagem);
            return;
        }
        if(evt.getButton() == MouseEvent.BUTTON3){
            if(somostra.equalsIgnoreCase("N")){
                if(!Tipo.equalsIgnoreCase("Comanda")){
                    MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
                }
            }
        }
    }//GEN-LAST:event_tabela_itens_vendasMouseClicked

    private void bt_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_limparActionPerformed
        LimpaTabelaDeItens();
    }//GEN-LAST:event_bt_limparActionPerformed

    private void bt_removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_removerActionPerformed
        RemoverPagamento();
    }//GEN-LAST:event_bt_removerActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
//        if(AberDeCaixa  != null){AberDeCaixa .dispose();}
        if(CliCon       != null){CliCon      .dispose();}
        if(EfePag       != null){EfePag      .dispose();}
        if(ProCon       != null){ProCon      .dispose();}
        if(VenConMan    != null){VenConMan   .dispose();}
    }//GEN-LAST:event_formWindowClosed

    private void bt_imprimirCupomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimirCupomActionPerformed
        ImprimeCupom();
    }//GEN-LAST:event_bt_imprimirCupomActionPerformed

    private void txt_valorUnitarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorUnitarioFocusGained
        if(txt_valorUnitario.getText().equals("")){
            return;
        }
        txt_quantidade.setText("");
        txt_valorUnitario.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble((txt_valorUnitario.getText()), 1));
    }//GEN-LAST:event_txt_valorUnitarioFocusGained

    private void txt_valorUnitarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valorUnitarioKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_quantidade.grabFocus();
        }
    }//GEN-LAST:event_txt_valorUnitarioKeyPressed

    private void bt_adicionarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bt_adicionarKeyReleased
        
    }//GEN-LAST:event_bt_adicionarKeyReleased

    private void txt_codigoProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoProdutoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(txt_codigoProduto.getText().equals("")){
                bt_finalizar.grabFocus();
            }else{
                txt_quantidade.setEditable (true);
                txt_quantidade.setFocusable(true);
                txt_quantidade.grabFocus();
            }
        }
    }//GEN-LAST:event_txt_codigoProdutoKeyPressed

    private void tabela_itens_vendasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabela_itens_vendasKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_CONTEXT_MENU){
            if(somostra.equalsIgnoreCase("N")){
                if(!Tipo.equalsIgnoreCase("Comanda")){
                    MenuPopup.show(evt.getComponent(), tabela_itens_vendas.getX(), tabela_itens_vendas.getY());
                }
            }
        }
        if(evt.getKeyCode() == KeyEvent.VK_DELETE){
            RemoverPagamento();
        }
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            bt_finalizar.grabFocus();
        }
    }//GEN-LAST:event_tabela_itens_vendasKeyPressed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        tabela_itens_vendas.grabFocus();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void bt_finalizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bt_finalizarKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        FinalizarVenda();
    }//GEN-LAST:event_bt_finalizarKeyPressed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        txt_valorUnitario.setFocusable(true);
        txt_valorUnitario.setEditable (true);
        txt_valorUnitario.grabFocus();
        txt_valorUnitario.setSelectionStart(0);
        txt_valorUnitario.setSelectionEnd  (txt_valorUnitario.getText().length());
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void txt_quantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_quantidadeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantidadeKeyReleased

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        LimpaTabelaDeItens();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        RemoverPagamento();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowLostFocus

    private void bt_iniciarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_iniciarVendaActionPerformed
        if(somostra.equalsIgnoreCase("S")){
            return;
        }
        NovaVenda();
    }//GEN-LAST:event_bt_iniciarVendaActionPerformed

    private void bt_localizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_localizarClienteActionPerformed
        if(somostra.equalsIgnoreCase("S")){
            return;
        }
        LocalizarCliente();
    }//GEN-LAST:event_bt_localizarClienteActionPerformed

    private void bt_localizarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_localizarProdutoActionPerformed
        if(txt_codigoProduto.isEditable() == false){
            return;
        }
        if(somostra.equalsIgnoreCase("S")){
            return;
        }
        txt_quantidade.grabFocus();
        LocalizarProduto();
    }//GEN-LAST:event_bt_localizarProdutoActionPerformed

    private void bt_finalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_finalizarVendaActionPerformed
        if(bt_finalizar.isEnabled() == false){
            return;
        }
        if(somostra.equalsIgnoreCase("S")){
            return;
        }
        FinalizarVenda();
    }//GEN-LAST:event_bt_finalizarVendaActionPerformed

    private void bt_alterarValorUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarValorUnitarioActionPerformed
        txt_valorUnitario.setFocusable(true);
        txt_valorUnitario.setEditable (true);
        txt_valorUnitario.grabFocus();
        txt_valorUnitario.setSelectionStart(0);
        txt_valorUnitario.setSelectionEnd  (txt_valorUnitario.getText().length());
    }//GEN-LAST:event_bt_alterarValorUnitarioActionPerformed

    private void bt_selecionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_selecionarItemActionPerformed
        tabela_itens_vendas.grabFocus();
    }//GEN-LAST:event_bt_selecionarItemActionPerformed

    private void bt_removerTodosItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_removerTodosItensActionPerformed
        LimpaTabelaDeItens();
    }//GEN-LAST:event_bt_removerTodosItensActionPerformed

    private void bt_removerItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_removerItemActionPerformed
        RemoverPagamento();
    }//GEN-LAST:event_bt_removerItemActionPerformed

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void txt_valorDescontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valorDescontoKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER){
            return;
        }
        if(bv.status != 0){
            return;
        }
        bt_adicionar.setEnabled(true);
        bt_adicionar.setFocusable(true);
        bt_adicionar.grabFocus();
    }//GEN-LAST:event_txt_valorDescontoKeyPressed

    private void txt_valorDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorDescontoFocusLost
        if(somostra.equals("S")){return;}
        if(bv.status != 0){return;}
        try{
            if(txt_valorDesconto.getText().equals("")){
                txt_valorDesconto.setText("0");
                combo_tipoDesconto.setSelectedIndex(0);
            }
            bvi.tipoDesconto    = combo_tipoDesconto.getSelectedIndex();
            if(bvi.tipoDesconto == 0){
                bvi.valorDesconto = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorDesconto.getText(), 1));
                txt_valorDesconto.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bvi.valorDesconto), 0));
            }else{
                if(!txt_valorDesconto.getText().substring(txt_valorDesconto.getText().length() - 1, txt_valorDesconto.getText().length()).equals("%")){
                    txt_valorDesconto.setText(txt_valorDesconto.getText() + "%");
                }
                bvi.valorDesconto = Double.parseDouble(txt_valorDesconto.getText().replace("%", "")) / 100;
            }
        }catch(Exception erro){
            mensagem = "Quantidade inválida!";
            new MostraMensagem(mensagem);
            return;
        }
        if(bvi.tipoDesconto == 0){
            bvi.valorTotal  = bvi.valorSubtotal - bvi.valorDesconto;
        }else{
            bvi.valorTotal  = bvi.valorSubtotal - (bvi.valorSubtotal * bvi.valorDesconto);
        }
        txt_valortotal.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bvi.valorTotal), 0));
        bt_adicionar.setEnabled(true);
        bt_adicionar.setFocusable(true);
        bt_adicionar.grabFocus();
    }//GEN-LAST:event_txt_valorDescontoFocusLost

    private void combo_tipoDescontoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_tipoDescontoItemStateChanged
        txt_valorDesconto   .setText("");
        txt_valortotal      .setText("");
        bt_adicionar        .setEnabled  (false);
        bt_adicionar        .setFocusable(false);
        txt_valorDesconto.grabFocus();
    }//GEN-LAST:event_combo_tipoDescontoItemStateChanged

    private void txt_quantidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantidadeFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantidadeFocusGained

    private void combo_tipoDescontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_tipoDescontoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_valorDesconto.grabFocus();
        }
    }//GEN-LAST:event_combo_tipoDescontoKeyPressed

    private void bt_incluirDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirDescontoActionPerformed
        if(somostra.equals("S")){
            return;
        }
        AplicarDesconto();
    }//GEN-LAST:event_bt_incluirDescontoActionPerformed
    
    private void AplicarDesconto(){
        combo_tipoDesconto.setEnabled  (true);
        combo_tipoDesconto.setFocusable(true);
        txt_valorDesconto .setEditable (true);
        txt_valorDesconto .setFocusable(true);
        combo_tipoDesconto.grabFocus();
    }
    
    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        if(somostra.equals("S")){
            return;
        }
        AplicarDesconto();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void combo_usuariosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo_usuariosFocusLost
        if(combo_usuarios.isEnabled() == false){
            return;
        }
//        if(abriuTela == 1){
//            abriuTela = 0;
//            return;
//        }
        if(abriuLoginPDV == 1){
            abriuLoginPDV = 0;
            return;
        }
        if(lgPdv != null){
            if(lgPdv.isVisible()){
                return;
            }
        }
        abriuLoginPDV = 1;
        lgPdv = new LoginPDV(Integer.parseInt(String.valueOf(combo_usuarios.getSelectedItem()).substring(0, 3)));
        lgPdv.setVisible(true);
    }//GEN-LAST:event_combo_usuariosFocusLost

    private void combo_usuariosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_usuariosItemStateChanged
        txt_codigoProduto.grabFocus();
    }//GEN-LAST:event_combo_usuariosItemStateChanged

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowIconified

    private void txt_valorDescontoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorDescontoFocusGained
        if(txt_valorDesconto.isEditable() == false){
            return;
        }
        bvi.valorDesconto = 0;
    }//GEN-LAST:event_txt_valorDescontoFocusGained

    private void bt_adicionarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bt_adicionarFocusGained
        combo_usuarios.setFocusable(true);
    }//GEN-LAST:event_bt_adicionarFocusGained
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JButton bt_adicionar;
    private javax.swing.JButton bt_alterarValorUnitario;
    private javax.swing.JButton bt_finalizar;
    private javax.swing.JButton bt_finalizarVenda;
    private javax.swing.JButton bt_imprimir;
    private javax.swing.JButton bt_imprimirCupom;
    private javax.swing.JButton bt_incluirDesconto;
    private javax.swing.JButton bt_iniciarVenda;
    private javax.swing.JMenuItem bt_limpar;
    private javax.swing.JButton bt_localizarCliente;
    private javax.swing.JButton bt_localizarProduto;
    private javax.swing.JButton bt_pesquisaProduto;
    private javax.swing.JButton bt_pesquisaVenda;
    private javax.swing.JMenuItem bt_remover;
    private javax.swing.JButton bt_removerItem;
    private javax.swing.JButton bt_removerTodosItens;
    private javax.swing.JMenuItem bt_sair;
    private javax.swing.JButton bt_sair1;
    private javax.swing.JButton bt_selecionarItem;
    private javax.swing.JComboBox<String> combo_tipoDesconto;
    private javax.swing.JComboBox<String> combo_usuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel label_alteracao;
    private javax.swing.JLabel label_cliente;
    private javax.swing.JTextField label_descricaoProduto;
    private javax.swing.JTable tabela_itens_vendas;
    private javax.swing.JTextField txt_codigoProduto;
    private javax.swing.JFormattedTextField txt_cpfcnpj1;
    private javax.swing.JFormattedTextField txt_cpfcnpj2;
    private javax.swing.JFormattedTextField txt_cpfcnpj3;
    private javax.swing.JFormattedTextField txt_quantidade;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_valorDesconto;
    private javax.swing.JTextField txt_valorParcial;
    private javax.swing.JFormattedTextField txt_valorUnitario;
    private javax.swing.JTextField txt_valortotal;
    // End of variables declaration//GEN-END:variables
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    public String getRetorno(){
        return retorno;
    }
    
    private void Imprimir(){
        try{
            stmt = parametrosNS.con.prepareStatement(sql);
            rs   = stmt.executeQuery();
            js   = new JRResultSetDataSource(rs);
            
            hm.put("nomeEmpresa", parametrosNS.be.nomeEmpresa);
            hm.put("enderecoEmpresa", parametrosNS.be.enderecoEmpresa + ", " + parametrosNS.be.numeroEmpresa);
            hm.put("cnpjEmpresa", parametrosNS.FCpfCnpj.FormataCPFCNPJ(parametrosNS.be.cnpjEmpresa));
            hm.put("logotipoEmpresa", parametrosNS.bge.pastaImagemLogotipo + "/LOGOTIPO." + parametrosNS.bge.extensaoImagemLogotipo);
            hm.put("bairroEmpresa", parametrosNS.be.cidadeEmpresa + ", " + parametrosNS.be.ufEmpresa + ", " + parametrosNS.be.bairroEmpresa);
            hm.put("cepEmpresa", parametrosNS.be.cepEmpresa);
            hm.put("codigoVenda", bv.codigoVenda);
            hm.put("cpfCnpjCliente", parametrosNS.FCpfCnpj.FormataCPFCNPJ(bc.cpfCnpj));
            
            jpv     = bpar.pastaRelatorios + "/RelatorioDeVendasUnitario.jasper";
            
            jpp     = JasperFillManager.fillReport(jpv, hm, js);
            JasperViewer.viewReport(jpp, false);
        }catch(Exception erro){
            mensagem = "Erro ao imprimir: " + erro.getMessage();
            new MostraMensagem(mensagem);
        }
    }
    
    private void LimpaTabelaDeItens(){
//        double quantidade       = 0;
//        bvi.idVenda             = bv.idVenda;
//        for(int i = 0; i < tabela_itens_vendas.getRowCount(); i++){
//            bvi.codigoItemVenda = Integer.parseInt  (String.valueOf(tabela_itens_vendas.getValueAt(i, 0)));
//            bp.codigoProduto    = Integer.parseInt  (String.valueOf(tabela_itens_vendas.getValueAt(i, 1)).substring(0, 5));
//            sql = "select \n"
//                + "idProdutos, \n"
//                + "idEmpresa, \n"
//                + "codigoGrupo, \n"
//                + "codigoEmpresa, \n"
//                + "codigoProduto, \n"
//                + "produtoInativo, \n"
//                + "descricaoProduto, \n"
//                + "valorDeCompra, \n"
//                + "valorDeVenda, \n"
//                + "quantidadeMinima, \n"
//                + "quantidadeIdeal, \n"
//                + "quantidadeAtual \n"
//            + "from \n"
//            + "   tb_produtos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoProduto = " + bp.codigoProduto + ";";
//            PegaProduto("N");
//            quantidade          = Double.parseDouble(String.valueOf(tabela_itens_vendas.getValueAt(i, 4)));
//            
//            bp.quantidadeAtual  = bp.quantidadeAtual + quantidade;
//            
//            sql = "update tb_produtos set quantidadeAtual = " + bp.quantidadeAtual + " where idProdutos = " + bp.idProdutos + ";";
//            sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
//            if(!sqlstate.equals("00000")){
//                mensagem = "Erro ao Atualizar estoque do produto n°" + bp.codigoProduto + "!";
//                new MostraMensagem(mensagem);
//                return;
//            }
//            
//            sql = "delete from tb_vendas_itens where bvi.idVenda = " + bvi.idVenda + " and codigoItemVenda = " + bvi.codigoItemVenda + ";";
//            sqlstate = parametrosNS.dao.ExcluirRegistro(sql);
//            if(!sqlstate.equals("00000"))
//                return;
//        }
        ValorTotal = 0;
        Table           .setNumRows(0);
        bt_finalizar    .setEnabled(false);
        txt_total       .setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotal), 0));
    }
    
    private void RemoverPagamento(){
        if(Tipo.equalsIgnoreCase("Comanda")){
            return;
        }
        if(linha < 0){
            mensagem = "Item não selecionado!";
            new MostraMensagem(mensagem);
            return;
        }
        if(tabela_itens_vendas.getRowCount() < 1){
            return;
        }
        int codigoItemVenda = 0;
        for(int i = linha; i < tabela_itens_vendas.getRowCount(); i++){
            if(i + 1 == tabela_itens_vendas.getRowCount()){
                continue;
            }
            if(i == linha){
                codigoItemVenda = Integer.parseInt(String.valueOf(tabela_itens_vendas.getValueAt(i, 0)));
            }else{
                codigoItemVenda++;
            }
            tabela_itens_vendas.setValueAt(parametrosNS.fc.FormataCampo(String.valueOf(codigoItemVenda), 2, 0), i + 1, 0);
        }
        bvi.valorTotal = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(tabela_itens_vendas.getValueAt(linha, 5)), 1));
        ValorTotal = ValorTotal - bvi.valorTotal;
        txt_total.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotal), 0));
        Table.removeRow(linha);
        if(tabela_itens_vendas.getRowCount() < 0){
            bt_finalizar.setEnabled(false);
        }
//        bvi.codigoItemVenda     = Integer.parseInt(String.valueOf(tabela_itens_vendas.getValueAt(linha, 0)));
//        bp.codigoProduto        = Integer.parseInt(String.valueOf(tabela_itens_vendas.getValueAt(linha, 1)).substring(0, 5));
//        sql = "select \n"
//                + "idProdutos, \n"
//                + "idEmpresa, \n"
//                + "codigoGrupo, \n"
//                + "codigoEmpresa, \n"
//                + "codigoProduto, \n"
//                + "produtoInativo, \n"
//                + "descricaoProduto, \n"
//                + "codigoDeBarras, \n"
//                + "valorDeCompra, \n"
//                + "valorDeVenda, \n"
//                + "quantidadeMinima, \n"
//                + "quantidadeIdeal, \n"
//                + "quantidadeAtual \n"
//            + "from \n"
//            + "   tb_produtos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoProduto = " + bp.codigoProduto + ";";
//        PegaProduto("N");
//        double quantidade       = Double.parseDouble(String.valueOf(tabela_itens_vendas.getValueAt(linha, 4)));
//        
//        bp.quantidadeAtual      = bp.quantidadeAtual + quantidade;
//        
//        sql = "update tb_produtos set quantidadeAtual = " + bp.quantidadeAtual + " where idProdutos = " + bp.idProdutos + ";";
//        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
//        if(!sqlstate.equals("00000")){
//            mensagem = "Erro ao Atualizar estoque do produto n°" + bp.codigoProduto + "!";
//            new MostraMensagem(mensagem);
//            return;
//        }
//        
//        sql = "delete from tb_vendas_itens where idVenda = " + bvi.idVenda + " and codigoItemVenda = " + bvi.codigoItemVenda + ";";
//        sqlstate = parametrosNS.dao.ExcluirRegistro(sql);
//        if(!sqlstate.equals("00000"))
//            return;
//        int codigoItemVenda     = 0;
//        for(int i = linha; i < tabela_itens_vendas.getRowCount(); i++){
//            bvi.codigoItemVenda     = Integer.parseInt(String.valueOf(tabela_itens_vendas.getValueAt(i, 0)));
//            codigoItemVenda         = bvi.codigoItemVenda + 1;
//            
//            sql = "update tb_vendas_itens set codigoItemVenda = " + bvi.codigoItemVenda + " where idVenda = " + bvi.idVenda + " and codigoItemVenda = " +  codigoItemVenda + ";";
//            sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
//        }
//        PegaVendaItens();
    }
    
    private void PegaVenda(){
        if(abriuVenda == 1){
            return;
        }
        sql = "select * from tb_vendas where idEmpresa = " + parametrosNS.be.IdEmpresa + " and idVenda = " + bv.idVenda + ";";
        dadosVendas.clear();
        dadosVendas = parametrosNS.dao.Consulta(sql);
        if(dadosVendas.isEmpty()){
//            mensagem = "Venda n°" + bv.codigoVenda + " não encontrada!";
//            new MostraMensagem(mensagem);
            return;
        }
        operacao = "A";
        HabilitaCampos(true);
        PegaDadosVenda();
    }
    
    private void PegaDadosVenda(){
        for(int i = 0; i < dadosVendas.size(); i++){
            bv = new BeanVendas();
            bv.idVenda              = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(0)));
            bv.idEmpresa            = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(1)));
            bv.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(2)));
            bv.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(3)));
            bv.codigoVenda          = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(4)));
            bv.codigoUsuario        = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(5)));
            bv.codigoCliente        = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(6)));
            bv.codigoComputador     = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(7)));
        if(dadosVendas.get(i).get(8)  != null)
            bv.dataVenda            =                    String.valueOf(dadosVendas.get(i).get(8));
        if(dadosVendas.get(i).get(9)  != null)
            bv.horaVenda            =                    String.valueOf(dadosVendas.get(i).get(9));
        if(dadosVendas.get(i).get(10) != null)
            bv.status               = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(10)));
        if(dadosVendas.get(i).get(11) != null)
            bv.dataAlterou          =                    String.valueOf(dadosVendas.get(i).get(11));
        if(dadosVendas.get(i).get(12) != null)
            bv.horaAlterou          =                    String.valueOf(dadosVendas.get(i).get(12));
        if(dadosVendas.get(i).get(13) != null)
            bv.usuarioAlterou       = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(13)));
        if(dadosVendas.get(i).get(14) != null)
            bv.idEmpresaAlterou     = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(14)));
        if(dadosVendas.get(i).get(15) != null)
            bv.codigoGrupoAlterou   = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(15)));
        if(dadosVendas.get(i).get(16) != null)
            bv.codigoEmpresaAlterou = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(16)));
        }
        codigoCliente    = bv.codigoCliente;
        bc.codigoCliente = bv.codigoCliente;
        if(bc.codigoCliente != 0){
            sql = "select idCliente, idEmpresa, codigoGrupo, codigoEmpresa, codigoCliente, nome, cpfCnpj from tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCliente = " + bc.codigoCliente + ";";
            PegaCliente();
        }else{
            codigoCliente    = 99999;
            bc.codigoCliente = 99999;
            label_cliente.setText("Cliente Padrão");
        }
        
        bu.codigoUsuario = bv.codigoUsuario;
        PegaUsuario("N", "N");
        
        if(bv.usuarioAlterou != 0){
            bu.usuario      = "NS3";
            bv.dataAlterou  = parametrosNS.invdata.inverterData(bv.dataAlterou, 1);
            if(bv.usuarioAlterou != 999){
                bu.idEmpresa        = bv.idEmpresaAlterou;
                bu.codigoGrupo      = bv.codigoGrupoAlterou;
                bu.codigoEmpresa    = bv.codigoEmpresaAlterou;
                bu.codigoUsuario    = bv.usuarioAlterou;
                PegaUsuario("S", "N");
            }
            label_alteracao.setText("Última alteração feita em " + bv.dataAlterou + " às " + bv.horaAlterou + " por " + bu.usuario);
        }
        
        switch(bv.status){
            case  0:    bt_imprimir.setEnabled(false);  bt_imprimirCupom.setEnabled(false); break;
            default:    bt_imprimir.setEnabled(true);   bt_imprimirCupom.setEnabled(true);
        }
        
        if(somostra.equalsIgnoreCase("S")){
            switch(bv.status){
                case  0:bt_finalizar.setEnabled(true); break;
                default:bt_finalizar.setEnabled(false);
            }
        }
        
        bvi.idEmpresa       = bv.idEmpresa;
        bvi.codigoGrupo     = bv.codigoGrupo;
        bvi.codigoEmpresa   = bv.codigoEmpresa;
        bvi.codigoVenda     = bv.codigoVenda;
        PegaVendaItens();
    }
    
    private void PegaVendaItens(){
        sql = "select * from tb_vendas_itens where idEmpresa = " + bvi.idEmpresa + " and codigoVenda = " + bvi.codigoVenda + ";";
        dadosVendasItens.clear();
        dadosVendasItens = parametrosNS.dao.Consulta(sql);
        if(dadosVendasItens.isEmpty()){
            bt_finalizar.setEnabled(false);
            mensagem = "Não foram encontrados itens para a Venda n°" + bv.codigoVenda + "!";
            new MostraMensagem(mensagem);
            return;
        }
        PegaDadosVendaItens();
    }
    
    private void PegaDadosVendaItens(){
        Table.setNumRows(0);
        ValorTotal      = 0;
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
            bp.codigoProduto    = bvi.codigoProduto;
            sql = "select \n"
                + "idProdutos, \n"
                + "idEmpresa, \n"
                + "codigoGrupo, \n"
                + "codigoEmpresa, \n"
                + "codigoProduto, \n"
                + "produtoInativo, \n"
                + "descricaoProduto, \n"
                + "codigoDeBarras, \n"
                + "valorDeCompra, \n"
                + "valorDeVenda, \n"
                + "quantidadeMinima, \n"
                + "quantidadeIdeal, \n"
                + "quantidadeAtual \n"
            + "from \n"
            + "   tb_produtos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoProduto = " + bp.codigoProduto + ";";
            PegaProduto("S");
            
            if(bvi.tipoDesconto == 0){
                desconto = String.valueOf(bvi.valorDesconto * 100) + "%";
            }else{
                desconto = String.valueOf(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bvi.valorDesconto), 0));
            }
            
            ValorTotal     += bvi.valorTotal;
            
            Table.addRow(new Object[] {parametrosNS.fc.FormataCampo(String.valueOf(bvi.codigoVendaItem), 2, 0), parametrosNS.fc.FormataCampo(String.valueOf(bvi.codigoProduto), 5, 0) + " - " + bp.descricaoProduto, bp.codigoDeBarras, parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bvi.valorUnitario), 0), bvi.quantidade, parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bvi.valorSubtotal), 1), desconto, parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bvi.valorTotal), 0)});
            new AjustarLarguraColunas(tabela_itens_vendas);
        }
        if(tabela_itens_vendas.getRowCount() > 0){
            if(bv.status == 0){
                bt_finalizar.setEnabled(true);
            }
        }
        txt_total.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble((String.valueOf(ValorTotal)), 0));
        txt_codigoProduto.grabFocus();
        bt_adicionar.setEnabled(false);
        bt_adicionar.setFocusable(false);
    }
    
    private void PegaCliente(){
        dadosCliente.clear();
        dadosCliente = parametrosNS.dao.Consulta(sql);
        if(dadosCliente.isEmpty()){
            if(codigoCliente == 99999){
                bc.cpfCnpj = cpfCnpj;
                SetaCPFouCNPJ();
                label_cliente.setText("Cliente Padrão");
                return;
            }
            mensagem = "Cliente " + bc.codigoCliente + " não encontrado!";
            new MostraMensagem(mensagem);
            return;
        }
//        HabilitaBotoes();
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
            bc.nome                 =                    String.valueOf(dadosCliente.get(i).get(5));
            bc.cpfCnpj              =                    String.valueOf(dadosCliente.get(i).get(6));
        }
        SetaCPFouCNPJ();
        label_cliente.setText(bc.nome);
        txt_codigoProduto.grabFocus();
        if(Tipo.equalsIgnoreCase("Comanda")){
            bt_finalizar.setEnabled(true);
        }
    }
    
    private void SetaCPFouCNPJ(){
        bc.cpfCnpj      = parametrosNS.FCampoCpfCnpj.FormataCampoCpfCnpj(bc.cpfCnpj);
        bc.cpfCnpj1     = bc.cpfCnpj.substring(0 , 9);
        bc.cpfCnpj2     = bc.cpfCnpj.substring(9 ,13);
        bc.cpfCnpj3     = bc.cpfCnpj.substring(13,15);
        txt_cpfcnpj1.setText(bc.cpfCnpj1);
        txt_cpfcnpj2.setText(bc.cpfCnpj2);
        txt_cpfcnpj3.setText(bc.cpfCnpj3);
    }
    
    private void PegaCodigoDeBarras(){
        bp.codigoDeBarras = txt_codigoProduto.getText().replace(" ", "");
        if(bp.codigoDeBarras.equals("")){
            return;
        }
        sql = "select \n"
            + "   idProdutos, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoProduto, \n"
            + "   produtoInativo, \n"
            + "   descricaoProduto, \n"
            + "   codigoDeBarras, \n"
            + "   valorDeCompra, \n"
            + "   valorDeVenda, \n"
            + "   quantidadeMinima, \n"
            + "   quantidadeIdeal, \n"
            + "   quantidadeAtual \n"
            + "from \n"
            + "   tb_produtos where idEmpresa = " + parametrosNS.be.IdEmpresa;
        if(Tipo2.equals("cdb")){
            sql += " and codigoDeBarras = '" + bp.codigoDeBarras + "';";
        }else{
            bp.codigoProduto = Integer.parseInt(bp.codigoDeBarras);
            sql += " and codigoProduto = '"  + bp.codigoProduto + "';";
        }
        PegaProduto("S");
    }
    
    private void PegaProduto(String Mostra){
        dadosProdutos.clear();
        dadosProdutos = parametrosNS.dao.Consulta(sql);
        if(dadosProdutos.isEmpty()){
            if(Tipo2.equals("cdb")){
                Tipo2 = "";
                PegaCodigoDeBarras();
                return;
            }
            if(Mostra.equals("N")){return;}
            if(bp.codigoProduto != 0){
                bp.codigoDeBarras = String.valueOf(bp.codigoProduto);
            }
            mensagem = "Código " + bp.codigoDeBarras + " não encontrado!";
            new MostraMensagem(mensagem);
            txt_codigoProduto.setText("");
            txt_codigoProduto.grabFocus();
            return;
        }
        PegaDadosProduto(Mostra);
    }
    
    private void PegaDadosProduto(String Mostra){
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
                bp.descricaoProduto         =                    String.valueOf(dadosProdutos.get(i).get(6));
            }
            if(dadosProdutos.get(i).get(7) != null){
                bp.codigoDeBarras           =                    String.valueOf(dadosProdutos.get(i).get(7));
            }
            if(dadosProdutos.get(i).get(8) != null){
                bp.valorDeCompra            = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(8)));
            }
            if(dadosProdutos.get(i).get(9) != null){
                bp.valorDeVenda             = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(9)));
            }
            if(dadosProdutos.get(i).get(10) != null){
                bp.quantidadeMinima         = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(10)));
            }
            if(dadosProdutos.get(i).get(11) != null){
                bp.quantidadeIdeal          = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(11)));
            }
            if(dadosProdutos.get(i).get(12) != null){
                bp.quantidadeAtual          = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(12)));
            }
        }
        if(Mostra.equals("N")){return;}
        if(bparven.infQtdMenor == 1){
            if(bp.quantidadeAtual <= 0){
                mensagem = "Quantidade atual está zerada!";
                new MostraMensagem(mensagem);
                return;
            }else if(bp.quantidadeAtual < bp.quantidadeMinima){
                mensagem = "Quantidade atual em estoque do produto n°" + bp.codigoProduto + " está abaixo do limite!";
                new MostraMensagem(mensagem);
                return;
            }
        }
        label_descricaoProduto.setText(bp.descricaoProduto);
        txt_valorUnitario.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bp.valorDeVenda), 0));
        txt_quantidade.setText("");
        txt_quantidade.setEditable (true);
        txt_quantidade.setFocusable(true);
        txt_quantidade.grabFocus();
    }
    
    private void PegaUsuario(String Alterou, String AddCombo){
        if(!Alterou.equals("")){
            if(bu.codigoUsuario == 0){
                return;
            }
        }
        sql = "select \n"
                + "   idUsuario, \n"
                + "   idEmpresa, \n"
                + "   codigoGrupo, \n"
                + "   codigoEmpresa, \n"
                + "   codigoUsuario, \n"
                + "   nome, \n"
                + "   usuario \n"
                + "from tb_usuarios ";
        if(Alterou.equals("N")){
            sql += "where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
        }
        if(Alterou.equals("S")){
            sql += "where codigoGrupo = " + bu.codigoGrupo + " and codigoEmpresa = " + bu.codigoEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
        }
        if(Alterou.equals("")){
            sql += "where idEmpresa = " + parametrosNS.be.IdEmpresa + " order by codigoUsuario asc;";
        }
        dadosUsuarios.clear();
        dadosUsuarios = parametrosNS.dao.Consulta(sql);
        if(dadosUsuarios.isEmpty()){
            mensagem = "Usuário " + bu.codigoUsuario + " não encontrado!";
            new MostraMensagem(mensagem);
            return;
        }
        PegaDadosUsuario(Alterou, AddCombo);
    }
    
    private void PegaDadosUsuario(String Alterou, String AddCombo){
        if(AddCombo.equals("S")){
            abriuTela = 1;
            abriuLoginPDV = 0;
            combo_usuarios.removeAllItems();
        }
        for(int i = 0; i < dadosUsuarios.size(); i++){
            if(dadosUsuarios.get(i).get(0) != null){
                bu.idUsuario            = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(0)));
            }
            if(dadosUsuarios.get(i).get(1) != null){
                bu.idEmpresa            = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(1)));
            }
            if(dadosUsuarios.get(i).get(2) != null){
                bu.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(2)));
            }
            if(dadosUsuarios.get(i).get(3) != null){
                bu.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(3)));
            }
            if(dadosUsuarios.get(i).get(4) != null){
                bu.codigoUsuario        = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(4)));
            }
            if(dadosUsuarios.get(i).get(5) != null){
                bu.nome                 =                    String.valueOf(dadosUsuarios.get(i).get(5));
            }
            if(dadosUsuarios.get(i).get(6) != null){
                bu.usuario              =                    String.valueOf(dadosUsuarios.get(i).get(6));
            }
            if(AddCombo.equals("S")){
                abriuTela = 1;
                abriuLoginPDV = 0;
                combo_usuarios.addItem(parametrosNS.fc.FormataCampo(String.valueOf(bu.codigoUsuario), 3, 0) + " - " + bu.usuario);
            }
        }
        if(AddCombo.equals("S")){
            abriuTela = 1;
            abriuLoginPDV = 0;
            combo_usuarios.setSelectedItem(parametrosNS.fc.FormataCampo(String.valueOf(parametrosNS.bu.codigoUsuario), 3, 0) + " - " + parametrosNS.bu.usuario);
            return;
        }
        abriuTela = 1;
        abriuLoginPDV = 0;
        combo_usuarios.setSelectedItem(parametrosNS.fc.FormataCampo(String.valueOf(bu.codigoUsuario), 3, 0) + " - " + bu.usuario);
        if(Alterou.equals("")){
            parametrosNS.bu.codigoUsuario = bu.codigoUsuario;
            parametrosNS.PegaUsuario("");
        }
    }
    
    private void ReiniciaCampos(){
        bv = new BeanVendas();
        label_cliente.setText("");
        txt_cpfcnpj1.setText("");
        txt_cpfcnpj2.setText("");
        txt_cpfcnpj3.setText("");
        txt_codigoProduto.setText("");
        label_descricaoProduto.setText("");
        txt_valorUnitario.setText("");
        txt_quantidade.setText("");
        txt_valortotal.setText("");
        bt_adicionar.setEnabled(false);
        Table.setNumRows(0);
        ValorTotal = 0;
        bt_finalizar.setEnabled(false);
        txt_total.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble((String.valueOf(ValorTotal)), 0));
    }
    
    private void HabilitaCampos(boolean Habilita){
        txt_codigoProduto           .setEditable    (Habilita);
        txt_codigoProduto           .setFocusable   (Habilita);
        bt_pesquisaProduto          .setEnabled     (Habilita);
        bt_pesquisaProduto          .setFocusable   (Habilita);
        txt_quantidade              .setEditable    (Habilita);
        txt_quantidade              .setFocusable   (Habilita);
    }
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_finalizar    .setEnabled (true);
            bt_imprimir     .setEnabled (false);
            return;
        }
        if(operacao.equals("A")){
            bt_finalizar    .setEnabled (false);
            bt_imprimir     .setEnabled (true);
            return;
        }
        bt_finalizar        .setEnabled (false);
        bt_imprimir         .setEnabled (false);
    }
    
    private void PegaValores(){
        fatal = "N";
        bv.idEmpresa        = parametrosNS.be.IdEmpresa;
        bv.codigoGrupo      = parametrosNS.bge.CodigoGrupo;
        bv.codigoEmpresa    = parametrosNS.be.CodigoEmpresa;
        bv.codigoUsuario    = parametrosNS.bu.codigoUsuario;
        bv.codigoCliente    = codigoCliente;
        if(bv.codigoCliente == 0){
            mensagem = "Cliente inválido!";
            new MostraMensagem(mensagem);
            fatal = "S";
            return;
        }
        bv.codigoCliente    = bc.codigoCliente;
        bv.codigoComputador = parametrosNS.bcomp.codigoComputador;
        bv.dataVenda        = parametrosNS.invdata.inverterData(parametrosNS.cdh.CapturarData(), 2);
        bv.horaVenda        = parametrosNS.cdh.CapturaHora();
    }
    
    private void IncluirVenda(){
        PegaValores();
        if(fatal.equals("S")){
            return;
        }
        sql = "insert into tb_vendas (idEmpresa, codigoGrupo, codigoEmpresa, codigoVenda, codigoUsuario, codigoCliente, codigoComputador, dataVenda, horaVenda, status)"
            + " values (" + bv.idEmpresa + ", " + bv.codigoGrupo + ", " + bv.codigoEmpresa + ", " + bv.codigoVenda + ", " + bv.codigoUsuario + ", " + bv.codigoCliente + ", " + bv.codigoComputador + ", '" + bv.dataVenda + "', '" + bv.horaVenda + "', 0);";
        
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            fatal = "S";
            mensagem = "Erro ao incluir Venda n°" + bv.codigoVenda + "!";
            new MostraMensagem(mensagem);
            return;
        }
        sql = "select idVenda from tb_vendas where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoVenda = " + bv.codigoVenda + ";";
        dadosVendas.clear();
        dadosVendas = parametrosNS.dao.Consulta(sql);
        bv.idVenda  = Integer.parseInt(String.valueOf(dadosVendas.get(0).get(0)));
        operacao    = "A";
    }
    
//    private void IncluirVendaItem(){
//        bvi.idVenda                 = bv.idVenda;
//        sql = "select count(*) from tb_vendas_itens where idVenda = " + bvi.idVenda + ";";
//        dadosCount.clear();
//        dadosCount = parametrosNS.dao.Consulta(sql);
//        bvi.codigoItemVenda         = Integer.parseInt(  String.valueOf(dadosCount.get(0).get(0))) + 1;
//        bvi.codigoProduto           = bp.codigoProduto;
//        bvi.valorUnitario           = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorUnitario.getText(), 1));
//        bvi.quantidade              = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_quantidade.getText()   , 1));
//        bvi.valorTotal              = bvi.valorUnitario * bvi.quantidade;
//        
//        sql = "insert into tb_vendas_itens (idVenda, codigoItemVenda, codigoProduto, valorUnitario, quantidade, valorTotal) "
//            + "values (" + bvi.idVenda + ", " + bvi.codigoItemVenda + ", " + bvi.codigoProduto + ", " + bvi.valorUnitario + ", " + bvi.quantidade + ", " + bvi.valorTotal + ");";
//        
//        sqlstate = parametrosNS.dao.incluirRegistro(sql);
//        if(!sqlstate.equals("00000")){
//            mensagem = "Erro ao incluir Item " + bvi.codigoItemVenda + "1";
//            new MostraMensagem(mensagem);
//            return;
//        }
//        
//        bp.codigoProduto = bvi.codigoProduto;
//        sql = "select \n"
//                + "idProdutos, \n"
//                + "idEmpresa, \n"
//                + "codigoGrupo, \n"
//                + "codigoEmpresa, \n"
//                + "codigoProduto, \n"
//                + "produtoInativo, \n"
//                + "descricaoProduto, \n"
//                + "codigoDeBarras, \n"
//                + "valorDeCompra, \n"
//                + "valorDeVenda, \n"
//                + "quantidadeMinima, \n"
//                + "quantidadeIdeal, \n"
//                + "quantidadeAtual \n"
//            + "from \n"
//            + "   tb_produtos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoProduto = " + bp.codigoProduto + ";";
//        PegaProduto("S");
//
//        bp.quantidadeAtual = bp.quantidadeAtual - bvi.quantidade;
//        AtualizaEstoque();
//        
//        PegaVendaItens();
//    }
    
    private void IncluirItensVenda(){
        bvi.idEmpresa               = bv.idEmpresa;
        bvi.codigoGrupo             = bv.codigoGrupo;
        bvi.codigoEmpresa           = bv.codigoEmpresa;
        bvi.codigoVenda             = bv.codigoVenda;
        for(int linha = 0; linha < tabela_itens_vendas.getRowCount(); linha++){
            bvi.codigoVendaItem     = Integer.parseInt(String.valueOf(tabela_itens_vendas.getValueAt(linha, 0)));
            bvi.codigoProduto       = Integer.parseInt(String.valueOf(tabela_itens_vendas.getValueAt(linha, 1)).substring(0, 5));
            bvi.valorUnitario       = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(tabela_itens_vendas.getValueAt(linha, 3)), 1));
            bvi.quantidade          = Double.parseDouble(String.valueOf(tabela_itens_vendas.getValueAt(linha, 4)));
            bvi.valorSubtotal       = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(tabela_itens_vendas.getValueAt(linha, 5)), 1));
            bvi.valorDesconto       = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(tabela_itens_vendas.getValueAt(linha, 6)), 1));
            bvi.valorTotal          = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(tabela_itens_vendas.getValueAt(linha, 7)), 1));
            
            sql = "insert into tb_vendas_itens (idEmpresa, codigoGrupo, codigoEmpresa, codigoVenda, codigoVendaItem, codigoProduto, valorUnitario, quantidade, valorParcial, tipoDesconto, valorDesconto, valorTotal) "
                + "values (" + bvi.idEmpresa + ", " + bvi.codigoGrupo + ", " + bvi.codigoEmpresa + ", " + bvi.codigoVenda + ", " + bvi.codigoVendaItem + ", " + bvi.codigoProduto + ", " + bvi.valorUnitario + ", " + bvi.quantidade + ", " + bvi.valorSubtotal + ", " + bvi.tipoDesconto + ", " + bvi.valorDesconto + ", " + bvi.valorTotal + ");";
            
            sqlstate = parametrosNS.dao.incluirRegistro(sql);
            if(!sqlstate.equals("00000")){
                mensagem = "Erro ao incluir item n°" + bvi.codigoVendaItem + " da venda n°" + bvi.codigoVenda + "!";
                new MostraMensagem(mensagem);
                return;
            }
            
            bp.codigoProduto = bvi.codigoProduto;
            sql = "select \n"
                + "    idProdutos, \n"
                + "    idEmpresa, \n"
                + "    codigoGrupo, \n"
                + "    codigoEmpresa, \n"
                + "    codigoProduto, \n"
                + "    produtoInativo, \n"
                + "    descricaoProduto, \n"
                + "    codigoDeBarras, \n"
                + "    valorDeCompra, \n"
                + "    valorDeVenda, \n"
                + "    quantidadeMinima, \n"
                + "    quantidadeIdeal, \n"
                + "    quantidadeAtual \n"
                + "from \n"
                + "   tb_produtos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoProduto = " + bp.codigoProduto + ";";
            PegaProduto("S");
        }
    }

    private void NovaVenda(){
        operacao = "I";
        bc      = new BeanClientes();
        bcom    = new BeanComandas();
        bcomi   = new BeanComandasItens();
        bp      = new BeanProdutos();
        bv      = new BeanVendas();
        bvi     = new BeanVendasItens();
        bu      = new BeanUsuarios();
        
        ReiniciaCampos();
        HabilitaCampos(true);
        
        abriuCliente = 1;
        if(!Modo.equals("")){
            parametrosNS.codigoCliente  = 0;
            parametrosNS.cpfCnpj        = "";
            AbreCliente();
        }else{
            AbreInformaCPFouCNPJ();
        }
        
        bv.codigoVenda = parametrosNS.PegProReg.PegaProximoRegistro("tb_vendas", "codigoVenda", "");
        txt_codigoProduto.grabFocus();
    }

    private void LocalizarCliente(){
        if(InfCPFouCNPJ != null)if(InfCPFouCNPJ.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        abriuCliente = 1;
        AbreInformaCPFouCNPJ();
    }
    
    private void AbreInformaCPFouCNPJ(){
        ReiniciaCampos();
        InfCPFouCNPJ = new InformarCPFouCNPJ();
        InfCPFouCNPJ.setVisible(true);
    }

    private void LocalizarProduto(){
        if(ProCon != null)if(ProCon.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        txt_quantidade.grabFocus();
        abriuProdutos = 1;
        parametros.clear();
        parametros.add("N");
        parametros.add("cdb");//retorna o codigo de barras
        ProCon = new ProdutosConsulta(parametros);
        ProCon.setVisible(true);
    }

    private void FinalizarVenda(){
        if(EfePag != null)if(EfePag.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        abriuVenda = 1;
        parametros.clear();
        parametros.add(0);//idOrdemServico
        if(Tipo.equalsIgnoreCase("Venda")){
            parametros.add(bv.codigoVenda);//Venda
            parametros.add(0);//Comanda
            CarregaVetorVendas();
        }
        if(Tipo.equalsIgnoreCase("Comanda")){
            parametros.add(0);//Venda
            parametros.add(bcom.codigoComanda);//Comanda
        }
        parametros.add(bc.codigoCliente);
        parametros.add(Tipo);
        EfePag = new EfetuarPagamento(parametros, dadosVendasAssociativo);
        EfePag.setVisible(true);
    }
    
    private void CarregaVetorVendas(){
        ArrayList DadosVendasAssociativo = new ArrayList();
        dadosVendasAssociativo.clear();
        for(int i = 0; i < tabela_itens_vendas.getRowCount(); i++){
            DadosVendasAssociativo = new ArrayList();
            for(int j = 0; j < tabela_itens_vendas.getColumnCount(); j++){
                if(j == 2){continue;}
                DadosVendasAssociativo.add(String.valueOf(tabela_itens_vendas.getValueAt(i, j)));
            }
            dadosVendasAssociativo.add(DadosVendasAssociativo);
        }
    }
    
    private void AtualizaEstoque(){
        sql = "update tb_produtos set quantidadeAtual = " + bp.quantidadeAtual + " where idProdutos = " + bp.idProdutos + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(sqlstate.equals("00000")){
            return;
        }
        mensagem = "Erro ao atualizar estoque do produto " + bp.codigoProduto + "!";
        new MostraMensagem(mensagem);
    }
    
    private void PegaComanda(){
        sql = "select * from tb_comandas where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoComanda = " + bcom.codigoComanda + ";";
        dadosComandas.clear();
        dadosComandas = parametrosNS.dao.Consulta(sql);
        if(dadosComandas.isEmpty()){
            mensagem = "Comanda n°" + bcom.codigoComanda + " não cadastrada no Sistema!";
            new MostraMensagem(mensagem);
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
        bcomi.idEmpresa     = bcom.idEmpresa;
        bcomi.codigoGrupo   = bcom.codigoGrupo;
        bcomi.codigoEmpresa = bcom.codigoEmpresa;
        bcomi.codigoComanda = bcom.codigoComanda;
        PegaComandasItens();
    }
    
    private void PegaComandasItens(){
        sql = "select * from tb_comandas_itens where idEmpresa = " + bcomi.idEmpresa + " and codigoComanda = " + bcomi.codigoComanda + ";";
        dadosComandasItens.clear();
        dadosComandasItens = parametrosNS.dao.Consulta(sql);
        if(dadosComandasItens.isEmpty()){
            mensagem = "Não foram encontrados itens para Comanda " + bcom.codigoBarrasComanda + "!";
            new MostraMensagem(mensagem);
            return;
        }
        PegaDadosComandasItens();
    }
    
    private void PegaDadosComandasItens(){
        Table.setNumRows(0);
        ValorTotal = 0;
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
            sql = "select \n"
                + "   idProdutos, \n"
                + "   idEmpresa, \n"
                + "   codigoGrupo, \n"
                + "   codigoEmpresa, \n"
                + "   codigoProduto, \n"
                + "   produtoInativo, \n"
                + "   descricaoProduto, \n"
                + "   codigoDeBarras, \n"
                + "   valorDeCompra, \n"
                + "   valorDeVenda, \n"
                + "   quantidadeMinima, \n"
                + "   quantidadeIdeal, \n"
                + "   quantidadeAtual \n"
                + "from \n"
                + "   tb_produtos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoProduto = " + bp.codigoProduto + ";";
            PegaProduto("S");
            
            ValorTotal  += bcomi.valorTotal;
            
            Table.addRow(new Object[] {parametrosNS.fc.FormataCampo(String.valueOf(bcomi.codigoComandaItem), 2, 0), parametrosNS.fc.FormataCampo(String.valueOf(bcomi.codigoProduto), 5, 0) + " - " + bp.descricaoProduto, bp.codigoDeBarras, parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bcomi.valorUnitario), 0), bcomi.quantidade, parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bcomi.valorTotal), 0)});
            new AjustarLarguraColunas(tabela_itens_vendas);
        }
        if(tabela_itens_vendas.getRowCount() > 0){
            bt_finalizar.setEnabled(true);
        }
        txt_total.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble((String.valueOf(ValorTotal)), 0));
    }

    private void ImprimeCupom() {
        try {
            rel = null;

            map = new HashMap();

            map.put("codigoVenda", bv.codigoVenda);
            
            map.put("nomeEmpresa",       parametrosNS.be.nomeEmpresa);
            map.put("enderecoEmpresa",   parametrosNS.be.enderecoEmpresa + ", " + parametrosNS.be.numeroEmpresa);
            map.put("cepEmpresa",        parametrosNS.be.cepEmpresa);
            map.put("cidadeEmpresa",     parametrosNS.be.cidadeEmpresa + ", " + parametrosNS.be.ufEmpresa);
            map.put("bairroEmpresa",     parametrosNS.be.bairroEmpresa);
            //map.put("logotipoEmpresa",   parametrosNS.bge.pastaImagemLogotipo + "/LOGOTIPO." + parametrosNS.bge.extensaoImagemLogotipo);
            map.put("telefoneEmpresa",   parametrosNS.be.telefoneEmpresa);
            map.put("cnpjEmpresa",       parametrosNS.FCpfCnpj.FormataCPFCNPJ(parametrosNS.be.cnpjEmpresa));
            
            map.put("usuarioSistema", parametrosNS.bu.usuario);
            map.put("terminal",       parametrosNS.bcomp.nomeComputador);
            
            arquivoJasper = "Relatorios/CupomPedidoVenda.jasper";
            
            try{
                rel = JasperFillManager.fillReport(arquivoJasper, map, parametrosNS.con);
            }catch(Exception e){
                mensagem = "visualizar solicitar relatorios " + e + arquivoJasper;
                new MostraMensagem(mensagem);
                mensagem = e.getMessage();
                new MostraMensagem(mensagem);
            }
            JasperViewer.viewReport(rel, false);
            //dispose();

        } catch (Exception e) {
            mensagem = "O erro foi no solicitar relatorios: " + e + arquivoJasper;
            new MostraMensagem(mensagem);
        }
    }

}
