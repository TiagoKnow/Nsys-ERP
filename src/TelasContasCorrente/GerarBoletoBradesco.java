package TelasContasCorrente;

import BeansNS.BeanBanco;
import Beans.BeanBoletos;
import Beans.BeanBoletosInstrucoes;
import Beans.BeanClientes;
import Beans.BeanContaCorrente;
import Beans.BeanFormasPagamentos;
import Beans.BeanParametros;
import Beans.BeanParametrosCC;
import Beans.BeanRemessaItau;
import Beans.BeanUsuarios;
import FuncoesInternas.CalculaDataDeVencimento;
import FuncoesInternas.CalcularDAC;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.FormataCPFCNPJ;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.PegaProximoRegistro;
import FuncoesInternas.TransformaValorStringeDouble;
import TelasFaturamento.ClientesConsulta;
import Parametros.parametrosNS;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/*
 @author Tiago e Paulo
 */
public class GerarBoletoBradesco extends javax.swing.JFrame {
    //String's
    String  sql                     = "";
    String  fatal                   = "";
    String  sqlstate                = "";
    String  Mensagem                = "";
    String  somostra                = "";
    String  operacao                = "";
    String  retorno                 = "";
    String  CarregarComboInstrucoes = "";
    String  SetaNumeroCarteira      = "";
    String  TipoDeFaturamento       = "";
    
    //int's Para laços for
    int     j   = 0;
    int     i   = 0;
    
    //int's
    int     abriuBoleto         = 0;
    int     abriuCliente        = 0;
    int     Index               = 0;
    int     JOption             = 0;
    int     SequenciaBoleto     = 0;
    int     UltimoBoleto        = 0;
    int     UltimoBoleto1       = 0;
    
    //Long's
    long    DiferencaDeDias     = 0;
    
    //Date's
    Date    DataFatorVencimento = new Date();
    Date    DataDeVencimento    = new Date();
    
    //Vetores
    ArrayList            parametros                 = new ArrayList();
    ArrayList            dadosPadroes               = new ArrayList();
    ArrayList<ArrayList> dadosBanco                 = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosBoletos               = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosBoletosInstrucoes     = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosCliente               = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosParametros            = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosParametrosCC          = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosAgenciaEContaCorrente = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosUsuario               = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosFormasPagamentos      = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosCount                 = new ArrayList<ArrayList>();
    
    //Bean's
    BeanBanco                       bb          = new BeanBanco();
    BeanBoletos                     bbol        = new BeanBoletos();
    BeanBoletosInstrucoes           bbi         = new BeanBoletosInstrucoes();
    BeanClientes                    bc          = new BeanClientes();
    BeanContaCorrente               bcc         = new BeanContaCorrente();
    BeanFormasPagamentos            bfp         = new BeanFormasPagamentos();
    BeanParametros                  bpar        = new BeanParametros();
    BeanParametrosCC                bparcc      = new BeanParametrosCC();
    BeanRemessaItau                     brem        = new BeanRemessaItau();
    BeanUsuarios                    bu          = new BeanUsuarios();
      
    //Outros  
    FormataCampo                    fc          = new FormataCampo();
    FormataCPFCNPJ                  FCpfCnpj    = new FormataCPFCNPJ();
    CapturarDataHora                cdh         = new CapturarDataHora();
    InverterData                    invdata     = new InverterData();
    CalcularDAC                     CalDac      = new CalcularDAC();
    CalculaDataDeVencimento         CalVen      = new CalculaDataDeVencimento();
    PegaProximoRegistro             PegProReg   = new PegaProximoRegistro();
    TransformaValorStringeDouble    TransStrDou = new TransformaValorStringeDouble();
    
    //Telas
    ClientesConsulta    CliCon;
    BoletosConsulta     BolCon;
    
    //Especiais Para Boletos
    String                jpv     = "";
    JasperPrint           jpp     = null;
    HashMap               hm      = new HashMap();
    
    //Especiais
    BufferedImage                   BuffImg;
    ByteArrayOutputStream           BytesImg;
    ImageIcon                       imgIcon;
    Image                           img;
    
    public GerarBoletoBradesco(ArrayList DadosPadroes){
        dadosPadroes                            = DadosPadroes;
        
        somostra                                = (String)  dadosPadroes.get(0);
        bbol.codigoBoleto                       = (int)     dadosPadroes.get(1);
        bc.codigoCliente                        = (int)     dadosPadroes.get(2);
        TipoDeFaturamento                       = (String)  dadosPadroes.get(3);
        
        initComponents();
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
    
    private void PegaParametrosCC(){
        sql = "select * from tb_parametroscc where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosParametrosCC.clear();
        dadosParametrosCC = parametrosNS.dao.Consulta(sql);
        if(dadosParametrosCC.isEmpty()){
            bt_novo.setEnabled(false);
            operacao = "";
            HabilitaBotoes();
            return;
        }
        PegadadosParametrosCC();
    }
    
    private void PegadadosParametrosCC(){
        for(int i = 0; i < dadosParametrosCC.size(); i++){
            bparcc.idParametrosCC           = Integer.parseInt(  String.valueOf(dadosParametrosCC.get(i).get(0)));
            bparcc.idEmpresa                = Integer.parseInt(  String.valueOf(dadosParametrosCC.get(i).get(1)));
            bparcc.codigoGrupo              = Integer.parseInt(  String.valueOf(dadosParametrosCC.get(i).get(2)));
            bparcc.codigoEmpresa            = Integer.parseInt(  String.valueOf(dadosParametrosCC.get(i).get(3)));
        }
        PegaImagemBoletos();
    }
    
    private void PegaImagemBoletos(){
        sql = "select imagemBoletos from tb_parametroscc where codigoGrupo = " + bparcc.codigoGrupo + " and codigoEmpresa = " + bparcc.codigoEmpresa + ";";
        bparcc.imagemBoletos = parametrosNS.dao.ConsultaLogotipo(sql, "imagemBoletos");
    }
    
    private void PegaInstrucoes(){
        dadosBoletosInstrucoes.clear();
        dadosBoletosInstrucoes = parametrosNS.dao.Consulta(sql);
        if(CarregarComboInstrucoes.equalsIgnoreCase("S")){
            combo_Instrucoes.removeAllItems();
            combo_Instrucoes.addItem("");
        }
        if(dadosBoletosInstrucoes.isEmpty()){
            txt_codigoBoleto    .setEditable    (false);
            txt_codigoBoleto    .setFocusable   (false);
            bt_novo             .setEnabled     (false);
            bt_gerar            .setEnabled     (false);
            bt_alterar          .setEnabled     (false);
            bt_pesquisa         .setEnabled     (false);
            bt_imprimir         .setEnabled     (false);
            bt_pesquisaCliente  .setEnabled     (false);
            Mensagem = "Não foram encontradas Instruções de Boletos cadastradas!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosInstrucoes();
    }
    
    private void PegaDadosInstrucoes(){
        for(int i = 0; i < dadosBoletosInstrucoes.size(); i++){
            bbi.idBoletoInstrucao       = Integer.parseInt(  String.valueOf(dadosBoletosInstrucoes.get(i).get(0)));
            bbi.idEmpresa               = Integer.parseInt(  String.valueOf(dadosBoletosInstrucoes.get(i).get(1)));
            bbi.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosBoletosInstrucoes.get(i).get(2)));
            bbi.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosBoletosInstrucoes.get(i).get(3)));
            bbi.codigoBoletoInstrucao   = Integer.parseInt(  String.valueOf(dadosBoletosInstrucoes.get(i).get(4)));
            bbi.descricaoInstrucao      =                    String.valueOf(dadosBoletosInstrucoes.get(i).get(5));
            bbi.primeiraInstrucao       =                    String.valueOf(dadosBoletosInstrucoes.get(i).get(6));
            bbi.segundaInstrucao        =                    String.valueOf(dadosBoletosInstrucoes.get(i).get(7));
            bbi.terceiraInstrucao       =                    String.valueOf(dadosBoletosInstrucoes.get(i).get(8));
            
            if(CarregarComboInstrucoes.equalsIgnoreCase("S"))
                combo_Instrucoes.addItem(fc.FormataCampo(String.valueOf(bbi.codigoBoletoInstrucao), 2, 0) + "-" + bbi.descricaoInstrucao);
        }
    }
    
    private void PegaBancoBradesco(){
        bb.codigoBanco  = "237";
        if(bb.codigoBanco.equals(""))
            return;
        sql = "select * from ns_bancos where codigoBanco = '" + bb.codigoBanco + "';";
        dadosBanco.clear();
        dadosBanco = parametrosNS.dao.Consulta(sql);
        if(dadosBanco.isEmpty()){
            txt_codigoBoleto    .setEditable    (false);
            txt_codigoBoleto    .setFocusable   (false);
            bt_novo             .setEnabled     (false);
            bt_gerar            .setEnabled     (false);
            bt_alterar          .setEnabled     (false);
            bt_pesquisa         .setEnabled     (false);
            bt_imprimir         .setEnabled     (false);
            bt_pesquisaCliente  .setEnabled     (false);
            Mensagem = "Banco " + bb.codigoBanco + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        HabilitaBotoes();
        PegaDadosBancoBradesco();
    }
    
    private void PegaDadosBancoBradesco(){
        for(int i = 0; i < dadosBanco.size(); i++){
            bb.idBanco          = Integer.parseInt(  String.valueOf(dadosBanco.get(i).get(0)));
            bb.nomeBanco        =                    String.valueOf(dadosBanco.get(i).get(1));
            bb.codigoBanco      =                    String.valueOf(dadosBanco.get(i).get(2));
        }
        bcc.idBanco         = bb.idBanco;
        sql = "select * from tb_contacorrente where idBanco = " + bcc.idBanco + " and contaCorrentePadrao = 1;";
        PegaAgenciaEContaCorrentePadraoBradesco();
    }
    
    private void PegaAgenciaEContaCorrentePadraoBradesco(){
        dadosAgenciaEContaCorrente.clear();
        dadosAgenciaEContaCorrente = parametrosNS.dao.Consulta(sql);
        if(dadosAgenciaEContaCorrente.isEmpty()){
            txt_codigoBoleto    .setEditable    (false);
            txt_codigoBoleto    .setFocusable   (false);
            bt_novo             .setEnabled     (false);
            bt_gerar            .setEnabled     (false);
            bt_alterar          .setEnabled     (false);
            bt_pesquisa         .setEnabled     (false);
            bt_imprimir         .setEnabled     (false);
            bt_pesquisaCliente  .setEnabled     (false);
            Mensagem = "Não foi encontrada Conta Corrente Padrão para o Banco: " + bb.nomeBanco + "!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosAgenciaEContaCorrentePadraoBradesco();
        if(!bb.codigoBanco.equals("237")){
            txt_codigoBoleto.grabFocus();
            Mensagem = "Boleto Selecionado não pertence ao Itáu!";
            new MostraMensagem(Mensagem);
            return;
        }
        HabilitaBotoes();
    }
    
    private void PegaDadosAgenciaEContaCorrentePadraoBradesco(){
        for(int i = 0; i < dadosAgenciaEContaCorrente.size(); i++){
            bcc = new BeanContaCorrente();
            bcc.idContaCorrente             = Integer.parseInt(  String.valueOf(dadosAgenciaEContaCorrente.get(i).get(0)));
            bcc.idEmpresa                   = Integer.parseInt(  String.valueOf(dadosAgenciaEContaCorrente.get(i).get(1)));
            bcc.codigoGrupo                 = Integer.parseInt(  String.valueOf(dadosAgenciaEContaCorrente.get(i).get(2)));
            bcc.codigoEmpresa               = Integer.parseInt(  String.valueOf(dadosAgenciaEContaCorrente.get(i).get(3)));
            bcc.codigoContaCorrente         = Integer.parseInt(  String.valueOf(dadosAgenciaEContaCorrente.get(i).get(4)));
            bcc.idBanco                     = Integer.parseInt(  String.valueOf(dadosAgenciaEContaCorrente.get(i).get(5)));
            bcc.numeroAgencia               = Integer.parseInt(  String.valueOf(dadosAgenciaEContaCorrente.get(i).get(6)));
            bcc.digitoVerificadorAgencia    = Integer.parseInt(  String.valueOf(dadosAgenciaEContaCorrente.get(i).get(7)));
            bcc.numeroContaCorrente         = Integer.parseInt(  String.valueOf(dadosAgenciaEContaCorrente.get(i).get(8)));
            bcc.digitoVerificador           = Integer.parseInt(  String.valueOf(dadosAgenciaEContaCorrente.get(i).get(9)));
            bcc.contaCorrentePadrao         = Integer.parseInt(  String.valueOf(dadosAgenciaEContaCorrente.get(i).get(10)));
            bcc.numeroDaCarteira            =                    String.valueOf(dadosAgenciaEContaCorrente.get(i).get(11));
            bcc.especieDoDocumento          =                    String.valueOf(dadosAgenciaEContaCorrente.get(i).get(12));
            bcc.AceiteOuNaoAceite           =                    String.valueOf(dadosAgenciaEContaCorrente.get(i).get(13));
        }
        if(bcc.numeroDaCarteira == null)
            bcc.numeroDaCarteira    = "";
        if(SetaNumeroCarteira.equals("S"))
            txt_numeroDaCarteira.setText(fc.FormataCampo(bcc.numeroDaCarteira, 3, 0));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_codigoBoleto = new javax.swing.JFormattedTextField();
        bt_novo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigoCliente = new javax.swing.JFormattedTextField();
        bt_pesquisaCliente = new javax.swing.JButton();
        label_nomeCliente = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_qtdParcelas = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_parcelaAtual = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_dataDeVencimento = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_dataDeEmissao = new javax.swing.JFormattedTextField();
        combo_vencimentoDasParcelas = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txt_valorDevido = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_valorParcelas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_numeroDaCarteira = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_numeroDocumento = new javax.swing.JFormattedTextField();
        check_VencimentoDiasUteis = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        combo_Instrucoes = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_primeiraInstrucao = new javax.swing.JTextField();
        txt_segundaInstrucao = new javax.swing.JTextField();
        txt_terceiraInstrucao = new javax.swing.JTextField();
        label_alteracao = new javax.swing.JLabel();
        bt_gerar = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        bt_imprimir = new javax.swing.JButton();
        bt_baixaManual = new javax.swing.JButton();
        bt_pesquisa = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerar Boleto Bradesco");
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
        jLabel1.setText("Número do Boleto");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_codigoBoleto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoBoleto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoBoleto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoBoletoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoBoletoFocusLost(evt);
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
                .addComponent(txt_codigoBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(txt_codigoBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, txt_codigoBoleto});

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cliente/Sacado");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        bt_pesquisaCliente.setText("...");
        bt_pesquisaCliente.setFocusable(false);
        bt_pesquisaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_pesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_nomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nomeCliente))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaCliente, label_nomeCliente, txt_codigoCliente});

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Bradesco.jpg"))); // NOI18N
        jLabel3.setFocusable(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Informações do Boleto");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Qtd de Parcelas:");

        try {
            txt_qtdParcelas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_qtdParcelas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_qtdParcelas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_qtdParcelasFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_qtdParcelasFocusLost(evt);
            }
        });
        txt_qtdParcelas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_qtdParcelasKeyPressed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Parcela Atual:");

        txt_parcelaAtual.setEditable(false);
        try {
            txt_parcelaAtual.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_parcelaAtual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_parcelaAtual.setFocusable(false);
        txt_parcelaAtual.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_parcelaAtualFocusLost(evt);
            }
        });
        txt_parcelaAtual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_parcelaAtualKeyPressed(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Data de Vencimento:");

        try {
            txt_dataDeVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataDeVencimento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataDeVencimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataDeVencimentoKeyPressed(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Data de Emissão:");

        txt_dataDeEmissao.setEditable(false);
        try {
            txt_dataDeEmissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataDeEmissao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataDeEmissao.setFocusable(false);
        txt_dataDeEmissao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataDeEmissaoKeyPressed(evt);
            }
        });

        combo_vencimentoDasParcelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "01", "05", "10", "15", "20", "25", "30" }));
        combo_vencimentoDasParcelas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo_vencimentoDasParcelasKeyPressed(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Vencimento das Próximas Parcelas:");

        txt_valorDevido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_valorDevidoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorDevidoFocusLost(evt);
            }
        });
        txt_valorDevido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_valorDevidoKeyPressed(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Valor Devido:");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Valor das Parcelas:");

        txt_valorParcelas.setEditable(false);
        txt_valorParcelas.setFocusable(false);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("N° da Carteira:");

        txt_numeroDaCarteira.setEditable(false);
        try {
            txt_numeroDaCarteira.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_numeroDaCarteira.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_numeroDaCarteira.setFocusable(false);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Numero do Documento:");

        txt_numeroDocumento.setEditable(false);
        try {
            txt_numeroDocumento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**********")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_numeroDocumento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_numeroDocumento.setFocusable(false);

        check_VencimentoDiasUteis.setSelected(true);
        check_VencimentoDiasUteis.setText("Vencimento somente em dias úteis");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel12)
                        .addComponent(jLabel11)
                        .addComponent(jLabel15))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_dataDeEmissao, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(txt_dataDeVencimento))
                                .addGap(37, 37, 37)
                                .addComponent(jLabel13))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_valorDevido, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_qtdParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_parcelaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(combo_vencimentoDasParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(check_VencimentoDiasUteis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_numeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_numeroDaCarteira, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(txt_valorParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel12, jLabel14, jLabel15, jLabel9});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_valorDevido, txt_valorParcelas});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_parcelaAtual, txt_qtdParcelas});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_dataDeEmissao, txt_dataDeVencimento});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel13, jLabel4, jLabel5});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_valorDevido, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_numeroDaCarteira, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_qtdParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_numeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_parcelaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dataDeVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_vencimentoDasParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_VencimentoDiasUteis, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dataDeEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_valorParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {check_VencimentoDiasUteis, combo_vencimentoDasParcelas, jLabel10, jLabel11, jLabel12, jLabel13, jLabel14, jLabel15, jLabel4, jLabel5, jLabel9, txt_dataDeEmissao, txt_dataDeVencimento, txt_numeroDaCarteira, txt_numeroDocumento, txt_parcelaAtual, txt_qtdParcelas, txt_valorDevido, txt_valorParcelas});

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Instruções do Boleto");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Instruções Cadastradas:");

        combo_Instrucoes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_InstrucoesItemStateChanged(evt);
            }
        });
        combo_Instrucoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_InstrucoesActionPerformed(evt);
            }
        });
        combo_Instrucoes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo_InstrucoesKeyPressed(evt);
            }
        });

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("1ª Instrução:");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("2ª Instruçao:");

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("3ª Instrução:");

        txt_primeiraInstrucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_primeiraInstrucaoKeyPressed(evt);
            }
        });

        txt_segundaInstrucao.setEditable(false);
        txt_segundaInstrucao.setFocusable(false);

        txt_terceiraInstrucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_terceiraInstrucaoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_primeiraInstrucao)
                    .addComponent(txt_segundaInstrucao)
                    .addComponent(txt_terceiraInstrucao)
                    .addComponent(combo_Instrucoes, 0, 346, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {combo_Instrucoes, txt_primeiraInstrucao, txt_segundaInstrucao, txt_terceiraInstrucao});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel17, jLabel18, jLabel19, jLabel20});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_Instrucoes, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_primeiraInstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_segundaInstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_terceiraInstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {combo_Instrucoes, jLabel17, jLabel18, jLabel19, jLabel20, txt_primeiraInstrucao, txt_segundaInstrucao, txt_terceiraInstrucao});

        label_alteracao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bt_gerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_gerar.setText("Gerar");
        bt_gerar.setEnabled(false);
        bt_gerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_gerarActionPerformed(evt);
            }
        });
        bt_gerar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bt_gerarKeyPressed(evt);
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

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        bt_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Print.png"))); // NOI18N
        bt_imprimir.setText("Imprimir");
        bt_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imprimirActionPerformed(evt);
            }
        });

        bt_baixaManual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Modify.png"))); // NOI18N
        bt_baixaManual.setText("Baixa Manual");
        bt_baixaManual.setEnabled(false);
        bt_baixaManual.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bt_baixaManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_baixaManualActionPerformed(evt);
            }
        });

        bt_pesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/View.png"))); // NOI18N
        bt_pesquisa.setText("Pesquisa");
        bt_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaActionPerformed(evt);
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
            .addComponent(label_alteracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_gerar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_baixaManual, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_imprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_alterar, bt_baixaManual, bt_gerar, bt_imprimir, bt_pesquisa, bt_sair});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_gerar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_baixaManual, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_alteracao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_alterar, bt_baixaManual, bt_gerar, bt_imprimir, bt_pesquisa, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void txt_codigoBoletoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoBoletoFocusGained
        if(txt_codigoBoleto.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        operacao = "";
        ReiniciaCampos(false);
        HabilitaBotoes();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoBoletoFocusGained

    private void txt_codigoBoletoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoBoletoFocusLost
        if(txt_codigoBoleto.isEditable() == false)
            return;
        if(txt_codigoBoleto.getText().replace(" ", "").equals(""))
            return;
        PegaBoleto();
    }//GEN-LAST:event_txt_codigoBoletoFocusLost

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        NovoBoleto();
    }//GEN-LAST:event_bt_novoActionPerformed
    
    private void NovoBoleto(){
        ReiniciaCampos(true);
        HabilitaCampos(true);
        
        bbol.codigoBoleto   = PegProReg.PegaProximoRegistro("tb_boletos", "codigoBoleto", " and substring(CodigoDeBarras, 1, 3) = 237");
        txt_codigoBoleto.setText(fc.FormataCampo(String.valueOf(bbol.codigoBoleto), 8, 0));
        
        operacao = "I";
        HabilitaBotoes();
        txt_codigoCliente.grabFocus();
    }
    
    private void txt_codigoClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteFocusGained
        if(txt_codigoBoleto.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        label_nomeCliente.setText("");
    }//GEN-LAST:event_txt_codigoClienteFocusGained

    private void txt_codigoClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteFocusLost
        if(txt_codigoCliente.isEditable() == false)
            return;
        if(txt_codigoCliente.getText().replace(" ", "").equals(""))
            return;
        txt_codigoCliente.setText(fc.FormataCampo(txt_codigoCliente.getText(), 5, 0));
        bc.codigoCliente    = Integer.parseInt(txt_codigoCliente.getText());
        PegaCliente();
        if(fatal.equals("N"))
            label_nomeCliente.setText(bc.nome);
    }//GEN-LAST:event_txt_codigoClienteFocusLost

    private void bt_pesquisaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaClienteActionPerformed
        if(CliCon != null)if(CliCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuCliente = 1;
    CliCon = new ClientesConsulta("N");
        CliCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaClienteActionPerformed

    private void txt_qtdParcelasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_qtdParcelasFocusGained
        txt_qtdParcelas     .setText("");
        txt_valorParcelas   .setText("");
    }//GEN-LAST:event_txt_qtdParcelasFocusGained

    private void txt_qtdParcelasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_qtdParcelasFocusLost
        if(txt_qtdParcelas.getText().replace(" ", "").equals(""))
            return;
        if(txt_valorDevido.getText().equals(""))
            return;
        txt_qtdParcelas.setText(fc.FormataCampo(txt_qtdParcelas.getText(), 3, 0));

        bbol.valorDevido        = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_valorDevido.getText(), 1));
        bbol.TotalDeParcelas    = Integer.parseInt(txt_qtdParcelas.getText());

        bbol.ValorDeCadaParcela = bbol.valorDevido / bbol.TotalDeParcelas;
        txt_valorParcelas.setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(bbol.ValorDeCadaParcela), 0));
    }//GEN-LAST:event_txt_qtdParcelasFocusLost

    private void txt_qtdParcelasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_qtdParcelasKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataDeVencimento.grabFocus();
        }
    }//GEN-LAST:event_txt_qtdParcelasKeyPressed

    private void txt_parcelaAtualFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_parcelaAtualFocusLost

    }//GEN-LAST:event_txt_parcelaAtualFocusLost

    private void txt_parcelaAtualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_parcelaAtualKeyPressed

    }//GEN-LAST:event_txt_parcelaAtualKeyPressed

    private void txt_dataDeVencimentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataDeVencimentoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            combo_vencimentoDasParcelas.grabFocus();
        }
    }//GEN-LAST:event_txt_dataDeVencimentoKeyPressed

    private void txt_dataDeEmissaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataDeEmissaoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            combo_Instrucoes.requestFocus();
        }
    }//GEN-LAST:event_txt_dataDeEmissaoKeyPressed

    private void combo_vencimentoDasParcelasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_vencimentoDasParcelasKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            combo_Instrucoes.requestFocus();
        }
    }//GEN-LAST:event_combo_vencimentoDasParcelasKeyPressed

    private void txt_valorDevidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorDevidoFocusGained
        if(!txt_valorDevido.getText().equals(""))
            txt_valorDevido.setText(TransStrDou.TransformaValorStringeDouble(txt_valorDevido.getText(), 1));
        txt_valorParcelas.setText("");
    }//GEN-LAST:event_txt_valorDevidoFocusGained

    private void txt_valorDevidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorDevidoFocusLost
        if(!txt_valorDevido.getText().equals(""))
            txt_valorDevido.setText(TransStrDou.TransformaValorStringeDouble(txt_valorDevido.getText(), 0));
        if(operacao.equals("A")){
            bbol.valorDevido        = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_valorDevido.getText(), 1));
            txt_valorParcelas.setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(bbol.valorDevido), 0));
        }
    }//GEN-LAST:event_txt_valorDevidoFocusLost

    private void txt_valorDevidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valorDevidoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_qtdParcelas.requestFocus();
        }
    }//GEN-LAST:event_txt_valorDevidoKeyPressed

    private void combo_InstrucoesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_InstrucoesItemStateChanged
        Index = combo_Instrucoes.getSelectedIndex();
        if(Index == 0){
            txt_primeiraInstrucao   .setText("");
            txt_segundaInstrucao    .setText("");
            txt_terceiraInstrucao   .setText("");
            return;
        }
        bbi.codigoBoletoInstrucao  = Integer.parseInt(String.valueOf(combo_Instrucoes.getSelectedItem()).substring(0, 2));
        sql = "select * from tb_boletos_instrucoes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoBoletoInstrucao = " + bbi.codigoBoletoInstrucao + ";";
        CarregarComboInstrucoes = "N";
        PegaInstrucoes();
        if(CarregarComboInstrucoes.equals("N")){
            txt_primeiraInstrucao   .setText(bbi.primeiraInstrucao);
            txt_segundaInstrucao    .setText(bbi.segundaInstrucao);
            txt_terceiraInstrucao   .setText(bbi.terceiraInstrucao);
        }
    }//GEN-LAST:event_combo_InstrucoesItemStateChanged

    private void combo_InstrucoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_InstrucoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_InstrucoesActionPerformed

    private void combo_InstrucoesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_InstrucoesKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            txt_primeiraInstrucao.requestFocus();
    }//GEN-LAST:event_combo_InstrucoesKeyPressed

    private void txt_primeiraInstrucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_primeiraInstrucaoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            txt_terceiraInstrucao.requestFocus();
    }//GEN-LAST:event_txt_primeiraInstrucaoKeyPressed

    private void txt_terceiraInstrucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_terceiraInstrucaoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            bt_gerar.requestFocus();
    }//GEN-LAST:event_txt_terceiraInstrucaoKeyPressed

    private void bt_gerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_gerarActionPerformed
        GerarBoleto();
    }//GEN-LAST:event_bt_gerarActionPerformed

    private void bt_gerarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bt_gerarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            GerarBoleto();
    }//GEN-LAST:event_bt_gerarKeyPressed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "update tb_boletos set valorDevido = "            + bbol.valorDevido              + ", "
                                  + "dataDeVencimento = '"      + bbol.dataDeVencimento         + "', "
                                  + "codigoBoletoInstrucao = "  + bbol.codigoBoletoInstrucao    + ", "
                                  + "Instrucao1 = '"            + bbol.Instrucao1               + "', "
                                  + "Instrucao3 = '"            + bbol.Instrucao3               + "', "
                                  + "idEmpresaAlterou = "       + bbol.idEmpresaAlterou         + ", "
                                  + "codigoGrupoAlterou = "     + bbol.codigoGrupoAlterou       + ", "
                                  + "codigoEmpresaAlterou = "   + bbol.codigoEmpresaAlterou     + ", "
                                  + "dataAlterou = '"           + bbol.dataAlterou              + "', "
                                  + "horaAlterou = '"           + bbol.horaAlterou              + "', "
                                  + "usuarioAlterou = "         + bbol.usuarioAlterou           + " "
                                  + "where idBoletos = "    + bbol.idBoletos    + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoBoleto.grabFocus();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimirActionPerformed
        JOption = 0;
        bc.codigoCliente    = Integer.parseInt(txt_codigoCliente.getText());
        PegaCliente();
        bbol.codigoBoleto   = Integer.parseInt(txt_codigoBoleto.getText());
        UltimoBoleto1       = bbol.codigoBoleto;
        ImprimirBoleto();
    }//GEN-LAST:event_bt_imprimirActionPerformed

    private void bt_baixaManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_baixaManualActionPerformed

    }//GEN-LAST:event_bt_baixaManualActionPerformed

    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        if(BolCon != null)if(BolCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuBoleto = 1;
        parametros.clear();
        parametros.add("S");
        parametros.add("N");
        parametros.add("");
        parametros.add("237");
        BolCon = new BoletosConsulta(parametros);
        BolCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HabilitaCampos(false);
//        PegaParametros();
        PegaParametrosCC();
        
        CarregarComboInstrucoes = "S";
        sql = "select * from tb_boletos_instrucoes where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        PegaInstrucoes();
        SetaNumeroCarteira = "S";
        PegaBancoBradesco();
        
        if(bbol.codigoBoleto == 0)
            if(bc.codigoCliente != 0){
                NovoBoleto();
                txt_codigoCliente.setText(fc.FormataCampo(String.valueOf(bc.codigoCliente), 5, 0));
                PegaCliente();
                if(fatal.equals("N"))
                    label_nomeCliente.setText(bc.nome);
                txt_codigoBoleto        .setEditable(false);
                bt_novo                 .setEnabled (false);
                txt_codigoCliente       .setEditable(false);
                bt_pesquisaCliente      .setEnabled (false);
                bt_alterar              .setVisible (false);
                bt_imprimir             .setVisible (false);
                bt_baixaManual          .setVisible (false);
                bt_pesquisa             .setVisible (false);
                bbol.valorDevido = (double) dadosPadroes.get(4);
                txt_valorDevido.setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(bbol.valorDevido), 0));
                txt_qtdParcelas.grabFocus();
            }
        if(bc.codigoCliente == 0)
            if(bbol.codigoBoleto != 0){
                txt_codigoBoleto.setText(String.valueOf(bbol.codigoBoleto));
                PegaBoleto();
                HabilitaCampos(false);
                txt_codigoBoleto        .setEditable(false);
                bt_novo                 .setEnabled (false);
                bt_gerar                .setVisible (false);
                bt_alterar              .setVisible (false);
                bt_baixaManual          .setVisible (false);
                bt_pesquisa             .setVisible (false);
            }
        if(somostra.equalsIgnoreCase("SN"))
            bt_pesquisa             .setVisible (false);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
    }//GEN-LAST:event_formWindowGainedFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_baixaManual;
    private javax.swing.JButton bt_gerar;
    private javax.swing.JButton bt_imprimir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisa;
    private javax.swing.JButton bt_pesquisaCliente;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JCheckBox check_VencimentoDiasUteis;
    private javax.swing.JComboBox<String> combo_Instrucoes;
    private javax.swing.JComboBox<String> combo_vencimentoDasParcelas;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel label_alteracao;
    private javax.swing.JLabel label_nomeCliente;
    private javax.swing.JFormattedTextField txt_codigoBoleto;
    private javax.swing.JFormattedTextField txt_codigoCliente;
    private javax.swing.JFormattedTextField txt_dataDeEmissao;
    private javax.swing.JFormattedTextField txt_dataDeVencimento;
    private javax.swing.JFormattedTextField txt_numeroDaCarteira;
    private javax.swing.JFormattedTextField txt_numeroDocumento;
    private javax.swing.JFormattedTextField txt_parcelaAtual;
    private javax.swing.JTextField txt_primeiraInstrucao;
    private javax.swing.JFormattedTextField txt_qtdParcelas;
    private javax.swing.JTextField txt_segundaInstrucao;
    private javax.swing.JTextField txt_terceiraInstrucao;
    private javax.swing.JTextField txt_valorDevido;
    private javax.swing.JTextField txt_valorParcelas;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_gerar        .setEnabled (true);
            bt_alterar      .setEnabled (false);
            bt_baixaManual  .setEnabled (false);
            return;
        }
        if(operacao.equals("A")){
            bt_gerar        .setEnabled (false);
            bt_alterar      .setEnabled (true);
            bt_baixaManual  .setEnabled (true);
            return;
        }
        bt_gerar            .setEnabled (false);
        bt_alterar          .setEnabled (false);
        bt_baixaManual      .setEnabled (false);
    }
    
    private void ReiniciaCampos(boolean Habilita){
        i = 0;
        j = 0;
        txt_codigoBoleto            .setText("");
        txt_codigoCliente           .setText("");
        txt_codigoCliente           .setEditable(Habilita);
        bt_pesquisaCliente          .setEnabled (Habilita);
        label_nomeCliente           .setText("");
        txt_valorDevido             .setText("");
        txt_numeroDaCarteira        .setText("");
        txt_numeroDocumento         .setText("");
        txt_qtdParcelas             .setText("");
        txt_qtdParcelas             .setEditable (Habilita);
        txt_qtdParcelas             .setFocusable(Habilita);
        txt_parcelaAtual            .setText(fc.FormataCampo("1", 3, 0));
        txt_dataDeVencimento        .setText("");
        txt_dataDeEmissao           .setText(cdh.CapturarData());
        combo_vencimentoDasParcelas .setSelectedIndex(0);
        combo_vencimentoDasParcelas .setEnabled  (Habilita);
        txt_valorParcelas           .setText("");
        combo_Instrucoes             .setSelectedIndex(0);
        txt_primeiraInstrucao       .setText("");
        txt_segundaInstrucao        .setText("");
        txt_terceiraInstrucao       .setText("");
        label_alteracao             .setText("");
    }
    
    private void HabilitaCampos(boolean Habilita){
        txt_codigoCliente           .setEditable    (Habilita);
        txt_codigoCliente           .setFocusable   (Habilita);
        bt_pesquisaCliente          .setEnabled     (Habilita);
        bt_pesquisaCliente          .setFocusable   (Habilita);
        txt_valorDevido             .setEditable    (Habilita);
        txt_valorDevido             .setFocusable   (Habilita);
        txt_qtdParcelas             .setEditable    (Habilita);
        txt_qtdParcelas             .setFocusable   (Habilita);
        txt_dataDeVencimento        .setEditable    (Habilita);
        txt_dataDeVencimento        .setFocusable   (Habilita);
        combo_vencimentoDasParcelas .setEnabled     (Habilita);
        combo_vencimentoDasParcelas .setFocusable   (Habilita);
        combo_Instrucoes            .setEnabled     (Habilita);
        combo_Instrucoes            .setFocusable   (Habilita);
        txt_primeiraInstrucao       .setEditable    (Habilita);
        txt_primeiraInstrucao       .setFocusable   (Habilita);
        txt_terceiraInstrucao       .setEditable    (Habilita);
        txt_terceiraInstrucao       .setFocusable   (Habilita);
    }
    
    private void PegaBoleto(){
        txt_codigoBoleto.setText(fc.FormataCampo(txt_codigoBoleto.getText(), 8, 0));
        bbol.codigoBoleto   = Integer.parseInt(txt_codigoBoleto.getText());
        if(bbol.codigoBoleto == 0)
            return;
        txt_qtdParcelas             .setEditable (false);
        txt_qtdParcelas             .setFocusable(false);
        combo_vencimentoDasParcelas .setEnabled  (false);
        sql = "select * from tb_boletos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoBoleto = " + bbol.codigoBoleto + ";";
        dadosBoletos.clear();
        dadosBoletos = parametrosNS.dao.Consulta(sql);
        if(dadosBoletos.isEmpty()){
            Mensagem = "Boleto n°" + bbol.codigoBoleto + " não encontrado!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        operacao = "A";
        txt_valorDevido.grabFocus();
        HabilitaCampos(true);
        PegaDadosBoleto();
    }
    
    private void PegaDadosBoleto(){
        for(int i = 0; i < dadosBoletos.size(); i++){
            bbol = new BeanBoletos();
            if(dadosBoletos.get(i).get(0) != null)
                bbol.idBoletos              = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(0)));
            if(dadosBoletos.get(i).get(1) != null)
                bbol.idEmpresa              = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(1)));
            if(dadosBoletos.get(i).get(2) != null)
                bbol.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(2)));
            if(dadosBoletos.get(i).get(3) != null)
                bbol.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(3)));
            if(dadosBoletos.get(i).get(4) != null)
                bbol.codigoBoleto           = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(4)));
            if(dadosBoletos.get(i).get(5) != null)
                bbol.codigoCliente          = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(5)));
            if(dadosBoletos.get(i).get(6) != null)
                bbol.codigoContaCorrente    = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(6)));
            if(dadosBoletos.get(i).get(7) != null)
                bbol.codigoBoletoInstrucao  = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(7)));
            if(dadosBoletos.get(i).get(8) != null)
                bbol.codigoUsuario          = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(8)));
            if(dadosBoletos.get(i).get(9) != null)
                bbol.codigoPagamento        = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(9)));
                bbol.tipoDeFaturamento      =                    String.valueOf(dadosBoletos.get(i).get(10));
                bbol.nossoNumero            =                    String.valueOf(dadosBoletos.get(i).get(11));
                bbol.dataEmissao            =                    String.valueOf(dadosBoletos.get(i).get(12));
                bbol.numeroDocumento        =                    String.valueOf(dadosBoletos.get(i).get(13));
                bbol.numeroDAC              =                    String.valueOf(dadosBoletos.get(i).get(14));
            if(dadosBoletos.get(i).get(15) != null)
                bbol.valorDevido            = Double.parseDouble(String.valueOf(dadosBoletos.get(i).get(15)));
                bbol.dataDeVencimento       =                    String.valueOf(dadosBoletos.get(i).get(16));
            if(dadosBoletos.get(i).get(17) != null)
                bbol.valorPago              = Double.parseDouble(String.valueOf(dadosBoletos.get(i).get(17)));
                bbol.dataDePagamento        =                    String.valueOf(dadosBoletos.get(i).get(18));
                bbol.Instrucao1             =                    String.valueOf(dadosBoletos.get(i).get(19));
                bbol.Instrucao3             =                    String.valueOf(dadosBoletos.get(i).get(20));
                bbol.CodigoDeBarras1        =                    String.valueOf(dadosBoletos.get(i).get(21));
                bbol.CodigoDeBarras2        =                    String.valueOf(dadosBoletos.get(i).get(22));
                bbol.CodigoDeBarras3        =                    String.valueOf(dadosBoletos.get(i).get(23));
                bbol.CodigoDeBarras4        =                    String.valueOf(dadosBoletos.get(i).get(24));
                bbol.CodigoDeBarras5        =                    String.valueOf(dadosBoletos.get(i).get(25));
                bbol.CodigoDeBarras         =                    String.valueOf(dadosBoletos.get(i).get(26));
            if(dadosBoletos.get(i).get(27) != null)
                bbol.ocorrenciaRemessa      = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(27)));
            if(dadosBoletos.get(i).get(28) != null)
                bbol.ocorrenciaRetorno      = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(28)));
            if(dadosBoletos.get(i).get(29) != null)
                bbol.ParcelaAtual           = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(29)));
            if(dadosBoletos.get(i).get(30) != null)
                bbol.TotalDeParcelas        = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(30)));
            if(dadosBoletos.get(i).get(31) != null)
                bbol.statusBoleto           = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(31)));
                bbol.dataAlterou            =                    String.valueOf(dadosBoletos.get(i).get(32));
                bbol.horaAlterou            =                    String.valueOf(dadosBoletos.get(i).get(33));
            if(dadosBoletos.get(i).get(34) != null)
                bbol.usuarioAlterou         = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(34)));
            if(dadosBoletos.get(i).get(35) != null)
                bbol.idEmpresaAlterou       = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(35)));
            if(dadosBoletos.get(i).get(36) != null)
                bbol.codigoGrupoAlterou     = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(36)));
            if(dadosBoletos.get(i).get(37) != null)
                bbol.codigoEmpresaAlterou   = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(37)));
            
            bcc.idEmpresa           = bbol.idEmpresa;
            bcc.codigoGrupo         = bbol.codigoGrupo;
            bcc.codigoEmpresa       = bbol.codigoEmpresa;
            bcc.codigoContaCorrente = bbol.codigoContaCorrente;
            sql = "select * from tb_contacorrente where idEmpresa = " + bcc.idEmpresa + " and codigoContaCorrente = " + bcc.codigoContaCorrente + ";";
            PegaAgenciaEContaCorrentePadraoBradesco();
            
            if(!bb.codigoBanco.equals("237"))return;
            
            bc.codigoCliente            = bbol.codigoCliente;
            PegaCliente();
            
            bbi.codigoBoletoInstrucao   = bbol.codigoBoletoInstrucao;
            sql = "select * from tb_boletos_instrucoes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoBoletoInstrucao = " + bbi.codigoBoletoInstrucao + ";";
            CarregarComboInstrucoes     = "N";
            PegaInstrucoes();
            
//            bu.codigoUsuario            = bbol.codigoUsuario;
//            PegaUsuario();
            
//            bfp.codigoPagamento         = bbol.codigoPagamento;
//            PegaPagamento();
        }
        if(bbol.ocorrenciaRetorno != 6)HabilitaBotoes();
        txt_codigoCliente           .setText(fc.FormataCampo(String.valueOf(bc.codigoCliente), 5, 0));
        txt_codigoCliente           .setEditable(false);
        bt_pesquisaCliente          .setEnabled (false);
        label_nomeCliente           .setText(bc.nome);
        if(bbol.usuarioAlterou == 0)
            txt_valorDevido             .setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(bbol.valorDevido * bbol.TotalDeParcelas), 0));
        txt_numeroDaCarteira        .setText(fc.FormataCampo(bcc.numeroDaCarteira, 3, 0));
        txt_numeroDocumento         .setText(bbol.numeroDocumento);
        txt_qtdParcelas             .setText(fc.FormataCampo(String.valueOf(bbol.TotalDeParcelas), 3, 0));
        txt_qtdParcelas             .setEditable (false);
        txt_qtdParcelas             .setFocusable(false);
        txt_parcelaAtual            .setText(fc.FormataCampo(String.valueOf(bbol.ParcelaAtual), 3, 0));
        txt_dataDeVencimento        .setText(invdata.inverterData(bbol.dataDeVencimento, 1));
        combo_vencimentoDasParcelas .setSelectedIndex(0);
        combo_vencimentoDasParcelas .setEnabled  (false);
        txt_dataDeEmissao           .setText(invdata.inverterData(bbol.dataEmissao, 1));
        txt_valorParcelas           .setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(bbol.valorDevido), 0));
        combo_Instrucoes            .setSelectedItem(fc.FormataCampo(String.valueOf(bbol.codigoBoletoInstrucao), 2, 0) + "-" + bbi.descricaoInstrucao);
        txt_primeiraInstrucao       .setText(bbol.Instrucao1);
        txt_segundaInstrucao        .setText(bbol.Instrucao3);
        if(bbol.usuarioAlterou != 0){
            bu.usuario          = "NS3";
            bbol.dataAlterou    = invdata.inverterData(bbol.dataAlterou, 1);
            if(bbol.usuarioAlterou != 999){
                bu.idEmpresa            = bbol.idEmpresaAlterou;
                bu.codigoGrupo          = bbol.codigoGrupoAlterou;
                bu.codigoEmpresa        = bbol.codigoEmpresaAlterou;
                bu.codigoUsuario        = bbol.usuarioAlterou;
                PegaUsuario();
            }
            label_alteracao.setText("Última alteração feira em " + bbol.dataAlterou + " as " + bbol.horaAlterou + " por " + bu.usuario);
        }
    }
    
    private void PegaUsuario(){
        sql = "select usuario from tb_usuarios where codigoGrupo = " + bu.codigoGrupo + " and codigoEmpresa = " + bu.codigoEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
        dadosUsuario.clear();
        dadosUsuario = parametrosNS.dao.Consulta(sql);
        if(dadosUsuario.isEmpty()){
            Mensagem = "Usuário " + bu.codigoUsuario + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosUsuario();
    }
    
    private void PegaDadosUsuario(){
        for(int i = 0; i < dadosUsuario.size(); i++)
            bu.usuario = String.valueOf(  dadosUsuario.get(i).get(0));
    }
    
    private void PegaCliente(){
        fatal           = "N";
        bc.nome         = "";
        if(bc.codigoCliente == 0)
            return;
        sql = "select idCliente, codigoGrupo, codigoEmpresa, codigoCliente, cpfCnpj, nome from tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCliente = " + bc.codigoCliente + ";";
        dadosCliente.clear();
        dadosCliente = parametrosNS.dao.Consulta(sql);
        if(dadosCliente.isEmpty()){
            bt_gerar.setEnabled(false);
            bt_alterar.setEnabled(false);
            Mensagem = "Cliente Inválido!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        HabilitaBotoes();
        PegaDadosCliente();
    }
    
    private void PegaDadosCliente(){
        for(int i = 0; i < dadosCliente.size(); i++){
            bc.idCliente            = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(0)));
            bc.idEmpresa            = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(1)));
            bc.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(2)));
            bc.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(3)));
            bc.codigoCliente        = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(4)));
            bc.cpfCnpj              =                    String.valueOf(dadosCliente.get(i).get(5));
            bc.nome                 =                    String.valueOf(dadosCliente.get(i).get(6));
        }
    }
    
    private void PegaValores(){
        fatal = "N";
        bbol.idEmpresa                  = parametrosNS.be.IdEmpresa;
        bbol.codigoGrupo                = parametrosNS.bge.CodigoGrupo;
        bbol.codigoEmpresa              = parametrosNS.be.CodigoEmpresa;
        bbol.codigoBoleto               = Integer.parseInt(txt_codigoBoleto.getText()) + i;
        bbol.codigoCliente              = Integer.parseInt(txt_codigoCliente.getText());
        if(bcc.codigoContaCorrente == 0){
            Mensagem = "Código da Conta Corrente Inválido!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bbol.codigoContaCorrente        = bcc.codigoContaCorrente;
        if(combo_Instrucoes.getSelectedIndex() != 0){
            bbol.codigoBoletoInstrucao  = Integer.parseInt(String.valueOf(combo_Instrucoes.getSelectedItem()).substring(0, 2));
        }
        bbol.codigoUsuario              = parametrosNS.bu.codigoUsuario;
        bbol.codigoPagamento            = 0;
        bbol.tipoDeFaturamento          = TipoDeFaturamento;
        sql = "select count(*) from tb_boletos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and substring(CodigoDeBarras, 1, 3) = '237';";
        dadosCount.clear();
        dadosCount = parametrosNS.dao.Consulta(sql);
        bbol.nossoNumero                = fc.FormataCampo(String.valueOf(Integer.parseInt(String.valueOf(dadosCount.get(0).get(0))) + 1), 11, 0);
        bbol.dataEmissao                = invdata.inverterData(txt_dataDeEmissao.getText(), 2);
        //Numero Do Documento está no Final desse método
        bbol.numeroDAC                  = CalDac.CalculaNossoNumeroBradesco(bcc.numeroDaCarteira + bbol.nossoNumero);
        if(txt_valorParcelas.getText().equals("")){
            Mensagem = "Valor das Parcelas Inválido!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bbol.valorDevido                = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_valorParcelas.getText(), 1));
        bbol.dataDeVencimento           = txt_dataDeVencimento.getText();
        bbol.dataDeVencimento           = bbol.dataDeVencimento.replace(" ", "");
        bbol.dataDeVencimento           = bbol.dataDeVencimento.replace("/", "");
        if(bbol.dataDeVencimento.equals("")){
            Mensagem = "Data de Vencimento Inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bbol.dataDeVencimento           = invdata.inverterData(bbol.dataDeVencimento, 2);
        if(i > 0)
            bbol.dataDeVencimento   = bbol.dataDeVencimento.substring(0, 8) + String.valueOf(combo_vencimentoDasParcelas.getSelectedItem());
            if(check_VencimentoDiasUteis.isSelected() == false)
                bbol.dataDeVencimento   = CalVen.CalculaDataDeVencimento(bbol.dataDeVencimento, i, 0);
            else
                bbol.dataDeVencimento   = CalVen.CalculaDataDeVencimento(bbol.dataDeVencimento, i, 1);
        bbol.valorPago                  = 0;
        bbol.dataDePagamento            = null;
        bbol.Instrucao1                 = txt_primeiraInstrucao.getText();
        bbol.Instrucao3                 = txt_terceiraInstrucao.getText();
        
        //Primero Campo do Código de Barras
        bbol.codigoDeBarras11           = "237";    //Numero Do Banco Na Camara de Compensação
        bbol.codigoDeBarras12           = "9";      //Código do R$
        bbol.codigoDeBarras13           = fc.FormataCampo(String.valueOf(bcc.numeroAgencia), 4, 0).substring(0, 1) + "." + fc.FormataCampo(String.valueOf(bcc.numeroDaCarteira), 4, 0).substring(1, 4);
        bbol.codigoDeBarras14           = fc.FormataCampo(bcc.numeroDaCarteira, 2, 0).substring(0, 1);
        bbol.codigoDeBarras15           = CalDac.CalcularDACCampo1(bbol.codigoDeBarras11 + bbol.codigoDeBarras12 + bbol.codigoDeBarras13 + bbol.codigoDeBarras14);
        bbol.CodigoDeBarras1            = bbol.codigoDeBarras11 + bbol.codigoDeBarras12 + bbol.codigoDeBarras13 + bbol.codigoDeBarras14 + bbol.codigoDeBarras15;
        
        //Segundo Campo do Código de Barras
        bbol.codigoDeBarras21           = fc.FormataCampo(bcc.numeroDaCarteira, 2, 0).substring(1, 2);
        bbol.codigoDeBarras22           = bbol.nossoNumero.substring(0, 4) + ".";
        bbol.codigoDeBarras23           = bbol.nossoNumero.substring(4, 9);
        bbol.codigoDeBarras24           = CalDac.CalcularDACCampo2e3(bbol.codigoDeBarras21 + bbol.codigoDeBarras22 + bbol.codigoDeBarras23);
        bbol.CodigoDeBarras2            = bbol.codigoDeBarras21 + bbol.codigoDeBarras22 + bbol.codigoDeBarras23 + bbol.codigoDeBarras24;
        
        //Terceiro Campo do Código De Barras
        bbol.codigoDeBarras31           = bbol.nossoNumero.substring(9, 11);
        bbol.codigoDeBarras32           = fc.FormataCampo(String.valueOf(bcc.numeroContaCorrente), 7, 0).substring(0, 3) + "." + fc.FormataCampo(String.valueOf(bcc.numeroContaCorrente), 7, 0).substring(3, 7);
        bbol.codigoDeBarras33           = "0";
        bbol.codigoDeBarras34           = CalDac.CalcularDACCampo2e3(bbol.codigoDeBarras31 + bbol.codigoDeBarras32 + bbol.codigoDeBarras33);
        bbol.CodigoDeBarras3            = bbol.codigoDeBarras31 + bbol.codigoDeBarras32 + bbol.codigoDeBarras33 + bbol.codigoDeBarras34;
        
        //Quinto Campo do Código De Barras
        DataFatorVencimento             = new Date(new InverterData().inverterData("07/10/1997", 2).replace("-", "/"));
        DataDeVencimento                = new Date(bbol.dataDeVencimento.replace("-", "/"));
        DiferencaDeDias                 = DataFatorVencimento.getTime() - DataDeVencimento.getTime();
        DiferencaDeDias                 = DiferencaDeDias / 1000;   //Milesimos para Segundos
        DiferencaDeDias                 = DiferencaDeDias / 60;     //Segundos para Minutos
        DiferencaDeDias                 = DiferencaDeDias / 60;     //Minutos para Horas
        DiferencaDeDias                 = DiferencaDeDias / 24;     //Horas para Dias
        DiferencaDeDias                *= -1;
        
        bbol.CodigoDeBarras5            = String.valueOf(fc.FormataCampo(String.valueOf(DiferencaDeDias), 4, 0));
        bbol.CodigoDeBarras51           = String.valueOf(bbol.valorDevido);
        if(bbol.CodigoDeBarras51.substring(String.valueOf(bbol.valorDevido).length() - 2, String.valueOf(bbol.valorDevido).length() - 1).equals(".")){
            bbol.CodigoDeBarras51       = bbol.CodigoDeBarras51.replace(".", "");
            bbol.CodigoDeBarras51       = bbol.CodigoDeBarras51 + "0";
        }else{
            bbol.CodigoDeBarras51       = bbol.CodigoDeBarras51.replace(".", "");
        }
        bbol.CodigoDeBarras5           += fc.FormataCampo(bbol.CodigoDeBarras51, 10, 0);
        
        //Função Para Gerar o Código De Barras Completo
        bbol.CodigoDeBarras             = "237";
        bbol.CodigoDeBarras            += "9";
        bbol.CodigoDeBarras            += bbol.CodigoDeBarras5;
        bbol.CodigoDeBarras            += fc.FormataCampo(String.valueOf(bcc.numeroAgencia), 4, 0) + fc.FormataCampo(bcc.numeroDaCarteira, 2, 0) + bbol.nossoNumero;
        bbol.CodigoDeBarras            += fc.FormataCampo(String.valueOf(bcc.numeroContaCorrente), 7, 0);
        bbol.CodigoDeBarras            += "0";
        
        //Quarto Campo Do Código de Barras
        bbol.CodigoDeBarras4            = new CalcularDAC().CalcularDACCodigoDeBarras(bbol.CodigoDeBarras);
        
        bbol.CodigoDeBarras             = bbol.CodigoDeBarras.substring(0, 4) + bbol.CodigoDeBarras4 + bbol.CodigoDeBarras.substring(4, bbol.CodigoDeBarras.length());
        
        bbol.ocorrenciaRemessa          = 1;
        bbol.ocorrenciaRetorno          = 0;
//        if(operacao.equals("A")){
//            if(brem.DIdentificacaoDaOcorrencia != 1)
//                bbol.Ocorrencia             = 31;
//        }
        bbol.ParcelaAtual               = j;
        bbol.TotalDeParcelas            = Integer.parseInt(txt_qtdParcelas.getText());
        bbol.statusBoleto               = 0;
        bbol.numeroDocumento            = fc.FormataCampo(String.valueOf(bbol.codigoCliente), 5, 0) + "NS3" + fc.FormataCampo(String.valueOf(bbol.ParcelaAtual), 2, 0);
        
        bbol.idEmpresaAlterou           = parametrosNS.be.idEmpresa;
        bbol.codigoGrupoAlterou         = parametrosNS.bge.codigoGrupo;
        bbol.codigoEmpresaAlterou       = parametrosNS.be.codigoEmpresa;
        bbol.dataAlterou                = invdata.inverterData(cdh.CapturarData(), 2);
        bbol.horaAlterou                = cdh.CapturaHora();
        bbol.usuarioAlterou             = parametrosNS.bu.codigoUsuario;
    }
    
    private void IncluirBoleto(){
        j = 0;
        for(i = 0; i < bbol.TotalDeParcelas; i++){
            j = i + 1;
            PegaValores();
            if(fatal.equals("S"))return;
            
            sql =   "insert into tb_boletos (idEmpresa, codigoGrupo, codigoEmpresa, codigoBoleto, codigoCliente, codigoContaCorrente, codigoBoletoInstrucao, codigoUsuario, codigoPagamento, tipoDeFaturamento, nossoNumero, dataEmissao, numeroDocumento, numeroDAC, valorDevido, dataDeVencimento, valorPago, dataDePagamento, Instrucao1, Instrucao3, CodigoDeBarras1, CodigoDeBarras2, CodigoDeBarras3, CodigoDeBarras4, CodigoDeBarras5, CodigoDeBarras, ocorrenciaRemessa, ocorrenciaRetorno, ParcelaAtual, TotalDeParcelas, statusBoleto) \n" +
                    "values (" + bbol.idEmpresa + ", " + bbol.codigoGrupo + ", " + bbol.codigoEmpresa + ", " + bbol.codigoBoleto + ", " + bbol.codigoCliente + ", " + bbol.codigoContaCorrente + ", " + bbol.codigoBoletoInstrucao + ", " + bbol.codigoUsuario + ", " + bbol.codigoPagamento + ", '" + bbol.tipoDeFaturamento + "', '" + bbol.nossoNumero + "', '" + bbol.dataEmissao + "', '" + bbol.numeroDocumento + "', " + bbol.numeroDAC + ", " + bbol.valorDevido + ", '" + bbol.dataDeVencimento + "', " + bbol.valorPago + ", " + bbol.dataDePagamento + ", '" + bbol.Instrucao1 + "', '" + bbol.Instrucao3 + "', '" + bbol.CodigoDeBarras1 + "', '" + bbol.CodigoDeBarras2 + "', '" + bbol.CodigoDeBarras3 + "', '" + bbol.CodigoDeBarras4 + "', '" + bbol.CodigoDeBarras5 + "', '" + bbol.CodigoDeBarras + "', " + bbol.ocorrenciaRemessa + ", " + bbol.ocorrenciaRetorno + ", " + bbol.ParcelaAtual + ", " + bbol.TotalDeParcelas + ", " + bbol.statusBoleto + ");";
            
            sqlstate = parametrosNS.dao.incluirRegistro(sql);
            if(sqlstate.equals("00000")){
//                Mensagem = "Parcela " + j + " de " + bbol.TotalDeParcelas + " Inclusa!";
//                new MostraMensagem(Mensagem);
                continue;
            }
            Mensagem = "Parcela " + j + " de " + bbol.TotalDeParcelas + " já Inclusa no Sistema!";
            new MostraMensagem(Mensagem);
        }
    }

    private void GerarBoleto() {
        bbol.TotalDeParcelas    = Integer.parseInt(txt_qtdParcelas.getText().replace(" ", ""));
        if(bbol.TotalDeParcelas == 0){
            Mensagem = "Quantidade de Parcelas Inválidas!";
            new MostraMensagem(Mensagem);
            return;
        }
        if(bbol.TotalDeParcelas > 1){
            if(combo_vencimentoDasParcelas.getSelectedIndex() == 0){
                Mensagem = "Vencimento das próximas parcelas Inválido!";
                new MostraMensagem(Mensagem);
                return;
            }
            JOption = JOptionPane.showConfirmDialog(null, "Deseja imprimir todos os Boletos em 1 Arquivo?");
            if(JOption == 2)
                return;
        }
        IncluirBoleto();
        if(fatal.equals("S"))return;
        bc.codigoCliente    = Integer.parseInt(txt_codigoCliente.getText());
        PegaCliente();
        
        SequenciaBoleto = Integer.parseInt(txt_codigoBoleto.getText());
        UltimoBoleto    = SequenciaBoleto + bbol.TotalDeParcelas;
        if(JOption == 1){
            for(SequenciaBoleto = Integer.parseInt(txt_codigoBoleto.getText()); SequenciaBoleto < UltimoBoleto; SequenciaBoleto++){
                bbol.codigoBoleto   = SequenciaBoleto;
                UltimoBoleto1       = bbol.codigoBoleto;
                ImprimirBoleto();
            }
        }
        if(JOption == 0){
            bbol.codigoBoleto = SequenciaBoleto;
            UltimoBoleto1 = UltimoBoleto - 1;
            ImprimirBoleto();
        }
    }
    
    private void PegaPagamento(){
        if(bfp.codigoPagamento == 0)
            return;
        sql = "select * from tb_formaspagamentos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoPagamento = " + bfp.codigoPagamento + ";";
        dadosFormasPagamentos.clear();
        dadosFormasPagamentos = parametrosNS.dao.Consulta(sql);
        if(dadosFormasPagamentos.isEmpty()){
            Mensagem = "Forma de Pagamento código " + bfp.codigoPagamento + " não encontrado, para incluir pressione Novo!";
            new MostraMensagem(Mensagem);
            return;
        }
        PreencherCamposFormaPagamento();
    }
    
    private void PreencherCamposFormaPagamento(){
        for(int i = 0; i < dadosFormasPagamentos.size(); i++){
            bfp = new BeanFormasPagamentos();
            bfp.idPagamento             = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(0)));
            bfp.idEmpresa               = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(1)));
            bfp.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(2)));
            bfp.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(3)));
            bfp.codigoPagamento         = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(4)));
            bfp.descricaoPagamento      =                    String.valueOf(dadosFormasPagamentos.get(i).get(5));
        }
    }
    
    private void ImprimirBoleto(){
        try{
            if(bparcc.imagemBoletos != null){
                BuffImg = ImageIO.read(new ByteArrayInputStream(bparcc.imagemBoletos));
                imgIcon = new ImageIcon(BuffImg);
                img     = imgIcon.getImage();
            }
            
            hm.clear();
            hm.put("idEmpresa"  ,       parametrosNS.be.IdEmpresa);
            hm.put("nomeEmpresa",       parametrosNS.be.NomeEmpresa.toUpperCase());
            hm.put("cnpjEmpresa",       parametrosNS.be.CnpjEmpresa);
            
            if(bparcc.imagemBoletos != null)
                hm.put("logoEmpresa",img);
            else
                hm.put("logoEmpresa",null);
            
            hm.put("codigoBoletoInicial"  , bbol.codigoBoleto);
            hm.put("codigoBoletoFinal"    , UltimoBoleto1);
            hm.put("codigoClienteInicial" , bc.codigoCliente);
            hm.put("codigoClienteFinal"   , bc.codigoCliente);
            
            jpv     = bpar.pastaRelatorios + "/BoletoBradesco.jasper";
            
            retorno = "ok";
            
            jpp     = JasperFillManager.fillReport(jpv, hm, parametrosNS.con);
            JasperViewer.viewReport(jpp, false);
        }catch(Exception erro){
            Mensagem = "Erro ao imprimir: " + erro.getMessage();
            new MostraMensagem(Mensagem);
        }
    }
    
}
