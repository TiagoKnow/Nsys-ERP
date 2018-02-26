package TelasVendas;

import Beans.BeanIntervalos;
import Beans.BeanParametros;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.FormataCPFCNPJ;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.TestarData;
import TelasFaturamento.ClientesConsulta;
import Parametros.parametrosNS;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/*
 @author Tiago e Paulo
 */
public class RelatorioDeVendas extends javax.swing.JFrame {
    //String's
    String  sql         = "";
    String  Mensagem    = "";
    String  retorno     = "";
    String  Campo       = "";
    String  Texto       = "";
    String  ValorTexto  = "";
    
    public  String Modo  = "";
    
    //int's
    int     abriuVenda          = 0;
    int     abriuCliente        = 0;
    int     abriuFormaPagamento = 0;
    int     index               = 0;
    int     status1             = 0;
    int     status2             = 0;
    
    //Vetores ArrayList's
    ArrayList            parametros            = new ArrayList();
    ArrayList<ArrayList> dadosParametros       = new ArrayList();
    
    //Bean's
    BeanParametros      bpar        = new BeanParametros();
    BeanIntervalos      binter      = new BeanIntervalos();
    
    //Especiais
    InverterData        desp        = new InverterData();
    FormataCPFCNPJ      FCpfCnpj    = new FormataCPFCNPJ();
    TestarData          Test        = new TestarData();
    
    //Especiais para Relatórios
    String      jpv         = "";
    JasperPrint jpp         = null;
    HashMap     hm          = new HashMap();
    
    //Especiais
    BufferedImage   buffImg;
    ImageIcon       imgIcon;
    Image           img;
    
    //Telas
    ClientesConsulta                CliCon;
    VendasConsultaEManutencao       VenConMan;
    FormasDePagamentoConsulta       ForPagCon;
    
    public RelatorioDeVendas(){
        initComponents();
    }
    
    private void InicializaCampos(){
        txt_VendaInicial               .setText(parametrosNS.fc.FormataCampo("", 9, 0));
        txt_VendaFinal                 .setText("999999999");
        txt_dataVendaInicial           .setText(parametrosNS.fc.FormataCampo("", 10, 2));
        txt_dataVendaFinal             .setText(parametrosNS.cdh.CapturarData());
        txt_clienteInicial             .setText(parametrosNS.fc.FormataCampo("", 5, 0));
        txt_clienteFinal               .setText("99999");
        txt_codigoFormaPagamentoInicial.setText(parametrosNS.fc.FormataCampo("", 2, 0));
        txt_codigoFormaPagamentoFinal  .setText("99");
        
//        PegaParametros();
        VerificaTipoDeImpressao();
    }
    
//    private void PegaParametros(){
//        sql = "select * from tb_parametros where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
//        dadosParametros.clear();
//        dadosParametros = parametrosNS.dao.Consulta(sql);
//        if(dadosParametros.isEmpty())
//            return;
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
    
    private void VerificaTipoDeImpressao(){
        if(Modo.equals("VPP") || Modo.equals("CPP") || Modo.equals("GPPP") || Modo.equals("DPPP")){//Venda por Periodo
            label_cliente            .setVisible  (false);
            label_cliente            .setFocusable(false);
            txt_clienteInicial       .setVisible  (false);
            txt_clienteInicial       .setFocusable(false);
            bt_pesquisaClienteInicial.setVisible  (false);
            bt_pesquisaClienteInicial.setFocusable(false);
            txt_clienteFinal         .setVisible  (false);
            txt_clienteFinal         .setFocusable(false);
            bt_pesquisaClienteFinal  .setVisible  (false);
            bt_pesquisaClienteFinal  .setFocusable(false);
        }
        if(Modo.equals("GPPP") || Modo.equals("DPPP")){
            label_vendas            .setVisible  (false);
            label_vendas            .setFocusable(false);
            txt_VendaInicial        .setVisible  (false);
            txt_VendaInicial        .setFocusable(false);
            bt_pesquisaVendaInicial .setVisible  (false);
            bt_pesquisaVendaInicial .setFocusable(false);
            txt_VendaFinal          .setVisible  (false);
            txt_VendaFinal          .setFocusable(false);
            bt_pesquisaVendaFinal   .setVisible  (false);
            bt_pesquisaVendaFinal   .setFocusable(false);
        }
        if(Modo.equals("VPP") || Modo.equals("DPPP")){
            if(Modo.equals("VPP")){
                label_formaPagamento            .setVisible  (false);
                label_formaPagamento            .setFocusable(false);
            }
            if(Modo.equals("VPP")){
                txt_codigoFormaPagamentoInicial .setVisible  (false);
                txt_codigoFormaPagamentoInicial .setFocusable(false);
            }
            if(Modo.equals("VPP")){
                bt_pesquisaFormaPagamentoInicial.setVisible  (false);
                bt_pesquisaFormaPagamentoInicial.setFocusable(false);
            }
            if(Modo.equals("DPPP"))
                txt_codigoFormaPagamentoInicial .setText("99");
            txt_codigoFormaPagamentoFinal   .setVisible  (false);
            txt_codigoFormaPagamentoFinal   .setFocusable(false);
            bt_pesquisaFormaPagamentoFinal  .setVisible  (false);
            bt_pesquisaFormaPagamentoFinal  .setFocusable(false);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        label_vendas = new javax.swing.JLabel();
        txt_VendaInicial = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_VendaFinal = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        label_dataVenda = new javax.swing.JLabel();
        txt_dataVendaInicial = new javax.swing.JFormattedTextField();
        txt_dataVendaFinal = new javax.swing.JFormattedTextField();
        label_cliente = new javax.swing.JLabel();
        txt_clienteInicial = new javax.swing.JFormattedTextField();
        txt_clienteFinal = new javax.swing.JFormattedTextField();
        bt_pesquisaVendaInicial = new javax.swing.JButton();
        bt_pesquisaClienteInicial = new javax.swing.JButton();
        bt_pesquisaVendaFinal = new javax.swing.JButton();
        bt_pesquisaClienteFinal = new javax.swing.JButton();
        label_status = new javax.swing.JLabel();
        combo_status = new javax.swing.JComboBox<>();
        label_formaPagamento = new javax.swing.JLabel();
        txt_codigoFormaPagamentoInicial = new javax.swing.JFormattedTextField();
        bt_pesquisaFormaPagamentoInicial = new javax.swing.JButton();
        txt_codigoFormaPagamentoFinal = new javax.swing.JFormattedTextField();
        bt_pesquisaFormaPagamentoFinal = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bt_imprimir = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de Vendas");
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

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Relatório de Vendas    F11 [Geral]");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        label_vendas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_vendas.setText("Vendas: ");

        try {
            txt_VendaInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_VendaInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_VendaInicial.setText("000000000");
        txt_VendaInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_VendaInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_VendaInicialFocusLost(evt);
            }
        });
        txt_VendaInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_VendaInicialKeyPressed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Inicial");

        try {
            txt_VendaFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_VendaFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_VendaFinal.setText("999999999");
        txt_VendaFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_VendaFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_VendaFinalFocusLost(evt);
            }
        });
        txt_VendaFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_VendaFinalKeyPressed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Final");

        label_dataVenda.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_dataVenda.setText("Data da Venda: ");

        try {
            txt_dataVendaInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataVendaInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataVendaInicial.setText("00/00/0000");
        txt_dataVendaInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataVendaInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataVendaInicialFocusLost(evt);
            }
        });
        txt_dataVendaInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataVendaInicialKeyPressed(evt);
            }
        });

        try {
            txt_dataVendaFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataVendaFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataVendaFinal.setText("99/99/9999");
        txt_dataVendaFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataVendaFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataVendaFinalFocusLost(evt);
            }
        });
        txt_dataVendaFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataVendaFinalKeyPressed(evt);
            }
        });

        label_cliente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_cliente.setText("Cliente: ");

        try {
            txt_clienteInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_clienteInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_clienteInicial.setText("00000");
        txt_clienteInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_clienteInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_clienteInicialFocusLost(evt);
            }
        });
        txt_clienteInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_clienteInicialKeyPressed(evt);
            }
        });

        try {
            txt_clienteFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_clienteFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_clienteFinal.setText("99999");
        txt_clienteFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_clienteFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_clienteFinalFocusLost(evt);
            }
        });
        txt_clienteFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_clienteFinalKeyPressed(evt);
            }
        });

        bt_pesquisaVendaInicial.setText("...");
        bt_pesquisaVendaInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaVendaInicialActionPerformed(evt);
            }
        });

        bt_pesquisaClienteInicial.setText("...");
        bt_pesquisaClienteInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaClienteInicialActionPerformed(evt);
            }
        });

        bt_pesquisaVendaFinal.setText("...");
        bt_pesquisaVendaFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaVendaFinalActionPerformed(evt);
            }
        });

        bt_pesquisaClienteFinal.setText("...");
        bt_pesquisaClienteFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaClienteFinalActionPerformed(evt);
            }
        });

        label_status.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_status.setText("Status:");

        combo_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Cancelada", "Finalizada" }));
        combo_status.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo_statusKeyPressed(evt);
            }
        });

        label_formaPagamento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_formaPagamento.setText("Forma de pagamento:");

        try {
            txt_codigoFormaPagamentoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoFormaPagamentoInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoFormaPagamentoInicial.setText("00");
        txt_codigoFormaPagamentoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoFormaPagamentoInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoFormaPagamentoInicialFocusLost(evt);
            }
        });
        txt_codigoFormaPagamentoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoFormaPagamentoInicialKeyPressed(evt);
            }
        });

        bt_pesquisaFormaPagamentoInicial.setText("jButton1");
        bt_pesquisaFormaPagamentoInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaFormaPagamentoInicialActionPerformed(evt);
            }
        });

        try {
            txt_codigoFormaPagamentoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoFormaPagamentoFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoFormaPagamentoFinal.setText("99");
        txt_codigoFormaPagamentoFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoFormaPagamentoFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoFormaPagamentoFinalFocusLost(evt);
            }
        });
        txt_codigoFormaPagamentoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoFormaPagamentoFinalKeyPressed(evt);
            }
        });

        bt_pesquisaFormaPagamentoFinal.setText("jButton2");
        bt_pesquisaFormaPagamentoFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaFormaPagamentoFinalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_dataVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(label_vendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_cliente)
                    .addComponent(label_formaPagamento)
                    .addComponent(label_status))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_codigoFormaPagamentoInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(txt_clienteInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(txt_VendaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(txt_dataVendaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_pesquisaVendaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_pesquisaClienteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_pesquisaFormaPagamentoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(txt_dataVendaFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(txt_VendaFinal)
                            .addComponent(txt_clienteFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(txt_codigoFormaPagamentoFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_pesquisaFormaPagamentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_pesquisaClienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_pesquisaVendaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(combo_status, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {label_cliente, label_dataVenda, label_formaPagamento, label_status, label_vendas});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, txt_VendaInicial, txt_clienteInicial, txt_codigoFormaPagamentoInicial, txt_dataVendaInicial});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_pesquisaClienteInicial, bt_pesquisaFormaPagamentoInicial, bt_pesquisaVendaInicial, jLabel2});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_pesquisaClienteFinal, bt_pesquisaVendaFinal, jLabel5});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, txt_clienteFinal, txt_codigoFormaPagamentoFinal, txt_dataVendaFinal});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(label_dataVenda)
                        .addComponent(txt_dataVendaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_dataVendaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(label_vendas)
                        .addComponent(txt_VendaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_VendaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_pesquisaVendaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_pesquisaVendaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_cliente)
                    .addComponent(txt_clienteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_clienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaClienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaClienteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_formaPagamento)
                    .addComponent(txt_codigoFormaPagamentoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaFormaPagamentoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoFormaPagamentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaFormaPagamentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combo_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_status))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaClienteFinal, bt_pesquisaClienteInicial, bt_pesquisaFormaPagamentoFinal, bt_pesquisaFormaPagamentoInicial, bt_pesquisaVendaFinal, bt_pesquisaVendaInicial, combo_status, jLabel2, jLabel3, jLabel4, jLabel5, label_cliente, label_dataVenda, label_formaPagamento, label_status, label_vendas, txt_VendaFinal, txt_VendaInicial, txt_clienteFinal, txt_clienteInicial, txt_codigoFormaPagamentoFinal, txt_codigoFormaPagamentoInicial, txt_dataVendaFinal, txt_dataVendaInicial});

        bt_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Print.png"))); // NOI18N
        bt_imprimir.setText("Imprimir");
        bt_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imprimirActionPerformed(evt);
            }
        });

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");

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
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_imprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_sair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void txt_VendaInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_VendaInicialFocusLost
        txt_VendaInicial.setText(parametrosNS.fc.FormataCampo(txt_VendaInicial.getText(), 9, 0));
    }//GEN-LAST:event_txt_VendaInicialFocusLost

    private void txt_VendaFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_VendaFinalFocusLost
        txt_VendaFinal.setText(parametrosNS.fc.FormataCampo(txt_VendaFinal.getText(), 9, 0));
    }//GEN-LAST:event_txt_VendaFinalFocusLost

    private void txt_dataVendaInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVendaInicialFocusLost
        txt_dataVendaInicial.setText(parametrosNS.fc.FormataCampo(txt_dataVendaInicial.getText(), 8, 0));
    }//GEN-LAST:event_txt_dataVendaInicialFocusLost

    private void txt_dataVendaFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVendaFinalFocusLost
        txt_dataVendaFinal.setText(parametrosNS.fc.FormataCampo(txt_dataVendaFinal.getText(), 8, 2));
    }//GEN-LAST:event_txt_dataVendaFinalFocusLost

    private void txt_clienteInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_clienteInicialFocusLost
        txt_clienteInicial.setText(parametrosNS.fc.FormataCampo(txt_clienteInicial.getText(), 5, 0));
    }//GEN-LAST:event_txt_clienteInicialFocusLost

    private void txt_clienteFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_clienteFinalFocusLost
        txt_clienteFinal.setText(parametrosNS.fc.FormataCampo(txt_clienteFinal.getText(), 5, 0));
    }//GEN-LAST:event_txt_clienteFinalFocusLost

    private void txt_VendaInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_VendaInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_VendaFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_VendaInicial.setText(parametrosNS.fc.FormataCampo("", 9, 0));
            txt_VendaFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_VendaInicialKeyPressed

    private void txt_VendaFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_VendaFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataVendaInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_VendaFinal.setText("999999999");
            txt_dataVendaInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_VendaFinalKeyPressed

    private void txt_dataVendaInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataVendaInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataVendaFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataVendaInicial.setText(parametrosNS.fc.FormataCampo("", 8, 0));
            txt_dataVendaFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataVendaInicialKeyPressed

    private void txt_dataVendaFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataVendaFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_clienteInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataVendaFinal.setText("99999999");
            txt_clienteInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataVendaFinalKeyPressed

    private void txt_clienteInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_clienteInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_clienteFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_clienteInicial.setText(parametrosNS.fc.FormataCampo("", 5, 0));
            txt_clienteFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_clienteInicialKeyPressed

    private void txt_clienteFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_clienteFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoFormaPagamentoFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_clienteFinal.setText("99999");
            txt_codigoFormaPagamentoFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_clienteFinalKeyPressed

    private void bt_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimirActionPerformed
        ImprimirRelatorioDeVendas();
    }//GEN-LAST:event_bt_imprimirActionPerformed

    private void bt_pesquisaVendaInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaVendaInicialActionPerformed
        Campo = "I";
        PesquisaVenda();
    }//GEN-LAST:event_bt_pesquisaVendaInicialActionPerformed
    
    private void PesquisaVenda(){
        if(VenConMan != null)if(VenConMan.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuVenda = 1;
        parametros.clear();
        parametros.add("N");
        parametros.add("N");
        VenConMan = new VendasConsultaEManutencao(parametros);
        VenConMan.setVisible(true);
    }
    
    private void bt_pesquisaVendaFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaVendaFinalActionPerformed
        Campo = "F";
        PesquisaVenda();
    }//GEN-LAST:event_bt_pesquisaVendaFinalActionPerformed

    private void bt_pesquisaClienteInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaClienteInicialActionPerformed
        Campo = "I";
        PesquisaCliente();
    }//GEN-LAST:event_bt_pesquisaClienteInicialActionPerformed
    
    private void PesquisaCliente(){
        if(CliCon != null)if(CliCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuCliente = 1;
        CliCon = new ClientesConsulta("N");
        CliCon.setVisible(true);
    }
    
    private void bt_pesquisaClienteFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaClienteFinalActionPerformed
        Campo = "F";
        PesquisaCliente();
    }//GEN-LAST:event_bt_pesquisaClienteFinalActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuVenda == 0){
            AbreCliente();
            return;
        }
        abriuVenda  = 0;
        retorno     = VenConMan.getRetorno();
        if(retorno.equals(""))
            return;
        if(Campo.equals("I")){
            txt_VendaInicial.setText(parametrosNS.fc.FormataCampo(retorno, 9, 0));
            return;
        }
        txt_VendaFinal.setText(parametrosNS.fc.FormataCampo(retorno, 9, 0));
    }//GEN-LAST:event_formWindowGainedFocus

    private void AbreCliente(){
        if(abriuCliente == 0){
            AbreFormaPagamento();
            return;
        }
        abriuCliente = 0;
        retorno = CliCon.getRetorno();
        if(retorno.equals(""))
            return;
        if(Campo.equals("I")){
            txt_clienteInicial.setText(parametrosNS.fc.FormataCampo(retorno, 5, 0));
            return;
        }
        txt_clienteFinal.setText(parametrosNS.fc.FormataCampo(retorno, 5, 0));
    }
    
    private void AbreFormaPagamento(){
        if(abriuFormaPagamento == 0)
            return;
        abriuFormaPagamento = 0;
        retorno = ForPagCon.getRetorno();
        if(retorno.equals(""))
            return;
        if(Campo.equals("I")){
            txt_codigoFormaPagamentoInicial.setText(parametrosNS.fc.FormataCampo(retorno, 2, 0));
            return;
        }
        txt_codigoFormaPagamentoFinal.setText(parametrosNS.fc.FormataCampo(retorno, 2, 0));
    }
    
    private void txt_VendaInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_VendaInicialFocusGained
        txt_VendaInicial.setSelectionStart(0);
        txt_VendaInicial.setSelectionEnd  (txt_VendaInicial.getText().length());
    }//GEN-LAST:event_txt_VendaInicialFocusGained

    private void txt_VendaFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_VendaFinalFocusGained
        txt_VendaFinal.setSelectionStart(0);
        txt_VendaFinal.setSelectionEnd  (txt_VendaFinal.getText().length());
    }//GEN-LAST:event_txt_VendaFinalFocusGained

    private void txt_dataVendaInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVendaInicialFocusGained
        txt_dataVendaInicial.setSelectionStart(0);
        txt_dataVendaInicial.setSelectionEnd  (txt_dataVendaInicial.getText().length());
    }//GEN-LAST:event_txt_dataVendaInicialFocusGained

    private void txt_dataVendaFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVendaFinalFocusGained
        txt_dataVendaFinal.setSelectionStart(0);
        txt_dataVendaFinal.setSelectionEnd  (txt_dataVendaFinal.getText().length());
    }//GEN-LAST:event_txt_dataVendaFinalFocusGained

    private void txt_clienteInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_clienteInicialFocusGained
        txt_clienteInicial.setSelectionStart(0);
        txt_clienteInicial.setSelectionEnd  (txt_clienteInicial.getText().length());
    }//GEN-LAST:event_txt_clienteInicialFocusGained

    private void txt_clienteFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_clienteFinalFocusGained
        txt_clienteFinal.setSelectionStart(0);
        txt_clienteFinal.setSelectionEnd  (txt_clienteFinal.getText().length());
    }//GEN-LAST:event_txt_clienteFinalFocusGained

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        InicializaCampos();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(CliCon      != null)CliCon   .dispose();
        if(VenConMan   != null)VenConMan.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void txt_codigoFormaPagamentoInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFormaPagamentoInicialFocusGained
        txt_codigoFormaPagamentoInicial.setSelectionStart(0);
        txt_codigoFormaPagamentoInicial.setSelectionEnd  (txt_codigoFormaPagamentoInicial.getText().length());
    }//GEN-LAST:event_txt_codigoFormaPagamentoInicialFocusGained

    private void txt_codigoFormaPagamentoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFormaPagamentoInicialFocusLost
        txt_codigoFormaPagamentoInicial.setText(parametrosNS.fc.FormataCampo(txt_codigoFormaPagamentoInicial.getText(), 2, 0));
    }//GEN-LAST:event_txt_codigoFormaPagamentoInicialFocusLost

    private void txt_codigoFormaPagamentoInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoFormaPagamentoInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoFormaPagamentoFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
//            if(Modo.equals(""))
            txt_codigoFormaPagamentoInicial.setText(parametrosNS.fc.FormataCampo("", 2, 0));
            txt_codigoFormaPagamentoFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoFormaPagamentoInicialKeyPressed

    private void txt_codigoFormaPagamentoFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFormaPagamentoFinalFocusGained
        txt_codigoFormaPagamentoFinal.setSelectionStart(0);
        txt_codigoFormaPagamentoFinal.setSelectionEnd  (txt_codigoFormaPagamentoFinal.getText().length());
    }//GEN-LAST:event_txt_codigoFormaPagamentoFinalFocusGained

    private void txt_codigoFormaPagamentoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFormaPagamentoFinalFocusLost
        txt_codigoFormaPagamentoFinal.setText(parametrosNS.fc.FormataCampo(txt_codigoFormaPagamentoFinal.getText(), 2, 0));
    }//GEN-LAST:event_txt_codigoFormaPagamentoFinalFocusLost

    private void txt_codigoFormaPagamentoFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoFormaPagamentoFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            combo_status.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoFormaPagamentoFinal.setText(parametrosNS.fc.FormataCampo("", 2, 0));
            combo_status.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoFormaPagamentoFinalKeyPressed

    private void combo_statusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_statusKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            bt_imprimir.grabFocus();
    }//GEN-LAST:event_combo_statusKeyPressed

    private void bt_pesquisaFormaPagamentoInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaFormaPagamentoInicialActionPerformed
        Campo = "I";
        PesquisaFormaDePagamento();
    }//GEN-LAST:event_bt_pesquisaFormaPagamentoInicialActionPerformed
    
    private void PesquisaFormaDePagamento(){
        if(ForPagCon != null)if(ForPagCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuFormaPagamento = 1;
        ForPagCon = new FormasDePagamentoConsulta("N");
        ForPagCon.setVisible(true);
    }
    
    private void bt_pesquisaFormaPagamentoFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaFormaPagamentoFinalActionPerformed
        Campo = "F";
        PesquisaFormaDePagamento();
    }//GEN-LAST:event_bt_pesquisaFormaPagamentoFinalActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_imprimir;
    private javax.swing.JButton bt_pesquisaClienteFinal;
    private javax.swing.JButton bt_pesquisaClienteInicial;
    private javax.swing.JButton bt_pesquisaFormaPagamentoFinal;
    private javax.swing.JButton bt_pesquisaFormaPagamentoInicial;
    private javax.swing.JButton bt_pesquisaVendaFinal;
    private javax.swing.JButton bt_pesquisaVendaInicial;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JComboBox<String> combo_status;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_cliente;
    private javax.swing.JLabel label_dataVenda;
    private javax.swing.JLabel label_formaPagamento;
    private javax.swing.JLabel label_status;
    private javax.swing.JLabel label_vendas;
    private javax.swing.JFormattedTextField txt_VendaFinal;
    private javax.swing.JFormattedTextField txt_VendaInicial;
    private javax.swing.JFormattedTextField txt_clienteFinal;
    private javax.swing.JFormattedTextField txt_clienteInicial;
    private javax.swing.JFormattedTextField txt_codigoFormaPagamentoFinal;
    private javax.swing.JFormattedTextField txt_codigoFormaPagamentoInicial;
    private javax.swing.JFormattedTextField txt_dataVendaFinal;
    private javax.swing.JFormattedTextField txt_dataVendaInicial;
    // End of variables declaration//GEN-END:variables
    
    private void ImprimirRelatorioDeVendas(){
        ValorTexto = "";
        index = combo_status.getSelectedIndex();
        Texto = String.valueOf(combo_status.getSelectedItem()) + " ";
        if(index == 0){
            status1 = 1;    //1 - Cancelada
            status2 = 2;    //2 - Finalizada
        }
        if(index == 1){
            status1 = 1;    //1 - Cancelada
            status2 = 1;    //1 - Cancelada
        }
        if(index == 2){
            status1 = 2;    //2 - Finalizada
            status2 = 2;    //2 - Finalizada
        }
        
        binter.VendaInicial     = Integer.parseInt(txt_VendaInicial.getText());
        binter.VendaFinal       = Integer.parseInt(txt_VendaFinal.getText());
        if(binter.VendaInicial > binter.VendaFinal){
            Mensagem = "Venda Inicial não pode ser maior do que a Venda Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        
        binter.dataVendaInicial = Test.Testa(txt_dataVendaInicial.getText());
        binter.dataVendaFinal   = Test.Testa(txt_dataVendaFinal.getText());
        if(binter.dataVendaInicial > binter.dataVendaFinal){
            Mensagem = "Data Inicial não pode ser maior do que a Data Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        
        binter.clienteInicial   = Integer.parseInt(txt_clienteInicial.getText());
        binter.clienteFinal     = Integer.parseInt(txt_clienteFinal.getText());
        if(binter.clienteInicial > binter.clienteFinal){
            Mensagem = "Cliente Inicial não pode ser maior do que Cliente Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        
        binter.codigoFormaPagamentoInicial  = Integer.parseInt(txt_codigoFormaPagamentoInicial.getText());
        binter.codigoFormaPagamentoFinal    = Integer.parseInt(txt_codigoFormaPagamentoFinal.getText());
        if(binter.codigoFormaPagamentoInicial > binter.codigoFormaPagamentoFinal){
            Mensagem = "Forma de pagamento inicial não pode ser maior do que forma de pagamento final!";
            new MostraMensagem(Mensagem);
            return;
        }
        if(Modo.equals("DPPP")){
            binter.codigoFormaPagamentoFinal = binter.codigoFormaPagamentoInicial;
            if(binter.codigoFormaPagamentoInicial == 99)
                binter.codigoFormaPagamentoInicial = 0;
        }
        try{
            img = null;
            if(parametrosNS.be.ImagemLogotipoEmpresa != null){
                buffImg = ImageIO.read(new ByteArrayInputStream(parametrosNS.be.ImagemLogotipoEmpresa));
                imgIcon = new ImageIcon(buffImg);
                img     = imgIcon.getImage();
            }
            hm.clear();
            hm.put("idEmpresa"      , parametrosNS.be.IdEmpresa);
            hm.put("nomeEmpresa"    , parametrosNS.be.NomeEmpresa);
            hm.put("cnpjEmpresa"    , parametrosNS.be.CnpjEmpresa);
            hm.put("cidadeEmpresa"  , parametrosNS.be.CidadeEmpresa + ", " + parametrosNS.be.UfEmpresa);
            hm.put("enderecoEmpresa", parametrosNS.be.EnderecoEmpresa + ", " + parametrosNS.be.NumeroEmpresa + ", " + parametrosNS.be.BairroEmpresa);
            hm.put("cepEmpresa"     , parametrosNS.be.CepEmpresa);
            hm.put("telefoneEmpresa", parametrosNS.be.TelefoneEmpresa);
            if(parametrosNS.be.ImagemLogotipoEmpresa != null){
                hm.put("logotipoEmpresa", img);
            }else{
                hm.put("logotipoEmpresa", null);
            }
            if(!Modo.equals("")){
                hm.put("intervaloSelecionado", "Intervalo selecionado entre os dias " + parametrosNS.invdata.inverterData(parametrosNS.fc.FormataCampo(String.valueOf(binter.dataVendaInicial), 8, 0), 1) + " à " + parametrosNS.invdata.inverterData(parametrosNS.fc.FormataCampo(String.valueOf(binter.dataVendaFinal), 8, 0), 1) + ".");
            }
            if(!Modo.equals("GPPP")){//Se for diferente de Relatório por Pagamento
                hm.put("codigoVendaInicial"  , binter.VendaInicial);
                hm.put("codigoVendaFinal"    , binter.VendaFinal);
            }
            hm.put("dataVendaInicial"    , binter.dataVendaInicial);
            hm.put("dataVendaFinal"      , binter.dataVendaFinal);
            
            if(Modo.equals("")){//Se for Relatório Geral
                hm.put("codigoClienteInicial", binter.clienteInicial);
                hm.put("codigoClienteFinal"  , binter.clienteFinal);
            }
            if(!Modo.equals("GPPP") && !Modo.equals("DPPP")){//Se for diferente de Relatório por Pagamento
                hm.put("status1"            , status1);
                hm.put("status2"            , status2);
            }
            if(Modo.equals("GPPP") || Modo.equals("DPPP")){
                hm.put("codigoPagamentoInicial", binter.codigoFormaPagamentoInicial);
                hm.put("codigoPagamentoFinal"  , binter.codigoFormaPagamentoFinal);
            }
            
            
            if(Modo.equals("")){
                jpv = "Relatorios/RelatorioDeVendas.jasper";
            }
            if(Modo.equals("VPP")){
                jpv = "Relatorios/RelatorioDeVendasPorPeriodo.jasper";
            }
            if(Modo.equals("GPPP")){
                jpv = "Relatorios/RelatorioGeralDePagamentosPorPeriodo.jasper";
            }
            if(Modo.equals("DPPP")){
                jpv = "Relatorios/RelatorioDiarioPorFormaDePagamento.jasper";
            }
            
            jpp = JasperFillManager.fillReport(jpv, hm, parametrosNS.con);
            JasperViewer.viewReport(jpp, false);
        }catch(Exception erro){
            Mensagem = "Erro ao imprimir: " + erro.getMessage();
            new MostraMensagem(Mensagem);
        }
    }
    
}
