package Telas;

import Parametros.parametrosNS;
import Parametros.Parametros;
import Beans.*;
import BeansNS.BeanEmpresas;
import TelasDeConfiguracoes.*;
import FuncoesInternas.*;
import Main.BarraInicial;
import Main.ProcessoInicial;
import MenusPrincipais.MenuCRM;
import MenusPrincipais.MenuCompras;
import MenusPrincipais.MenuContabil;
import MenusPrincipais.MenuContasAPagar;
import MenusPrincipais.MenuContasAReceber;
import MenusPrincipais.MenuContasCorrentes;
import MenusPrincipais.MenuEstoque;
import MenusPrincipais.MenuFaturamento;
import MenusPrincipais.MenuFiscal;
import MenusPrincipais.MenuGestao;
import MenusPrincipais.MenuProducao;
import MenusPrincipais.MenuRecebimento;
import MenusPrincipais.MenuRecursosHumanos;
import MenusPrincipais.MenuVendas;
import daoConexao.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
/*
 @author Tiago e Paulo
 */
public class MenuPrincipal extends javax.swing.JFrame {
    //String's
    String Rodape        = "";
    String Rodape1       = "";
    String sql           = "";
    String sqlstate      = "";
    String Mensagem      = "";
    String gsLarguraLogo = "";
    String gsAlturaLogo  = "";
    String ip            = "";
    String Pasta         = "";
    String servidor      = "";
    
    //int
    int aux = 0;
    int add = 0;
    
    //ArrayList's
    ArrayList            parametros      = new ArrayList();
    ArrayList            dadosParametros = new ArrayList();
    ArrayList<ArrayList> dadosConexao    = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosLogAcesso  = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosEmpresas   = new ArrayList<ArrayList>();
    
    //Bean's
    BeanEmpresas    be   = new BeanEmpresas();
    BeanParametros  bpar = new BeanParametros();
    BeanLogAcesso   bla  = new BeanLogAcesso();
    BeanUsuarios    bu   = new BeanUsuarios();
    
    //Telas
    BarraInicial            Bar;
    ProcessoInicial         ProIni;
    DepartamentosCadastro   DepCad;
    InformarSenhaSistema    InfSenSis;
    Login                   Lg;
    LogAcesso               LogAce;
    MenuFaturamento         MF    = null;
    MenuVendas              MV    = null;
    MenuEstoque             ME    = null;
    MenuContasAReceber      MCAR  = null;
    MenuContasAPagar        MCAP  = null;
    MenuProducao            MP    = null;
    MenuGestao              MG    = null;
    MenuCompras             MCom  = null;
    MenuRecebimento         MRec  = null;
    MenuCRM                 MCRM  = null;
    MenuContasCorrentes     MCC   = null;
    MenuContabil            MCont = null;
    MenuFiscal              MFis  = null;
    MenuContasAPagar        MCaP  = null;
    MenuContasAReceber      MCaR  = null;
    MenuRecursosHumanos     MRH   = null;
    MudarEmpresaAtual       MudEmpAtu;
    GerenciadorDeConexoes   GerCon;
    BuscaAvancada           BusAvan;
    Parametros              Param;
    ComputadoresCadastro    CompCad;
    UsuariosCadastro        UsuCad;
    
    //Outros
    FormataCampo        fc          = new FormataCampo();
    CapturarDataHora    cdh         = new CapturarDataHora();
    JLocaleChooser      jl;
    
    //Timer
    public Timer Tempo        = null;
    public Timer TempoCluster = null;
    
    //Especiais
    BufferedImage           BuffImg;
    ByteArrayOutputStream   BytesImg;
    ImageIcon               ImgIcon;
    Image                   Img;
    
    //int
    int    giLarguraLogo   = 0;
    int    giAlturaLogo    = 0;
    int    giPainelLargura = 0;
    int    giPainelAltura  = 0;
    
    //double
    double gdLarguraLogo   = 0;
    double gdAlturaLogo    = 0;
    double gdLarguraPadrao = 100;
    double gdAlturaPadrao  = 100;
    
    public MenuPrincipal(){
        initComponents();
        
        IniciaComponentes();
    }
    
    private void IniciaComponentes(){
        if(Tempo != null)Tempo.stop();
        VerificaEspecificacoesDoUsuario();
        MontaModulosEmpresa();
        VerificaConexao();
        CarregarInformacoes();
//        IniciaCarregamentoClusterBancoDeDados();
        setTitle("Empresa: " + fc.FormataCampo(String.valueOf(parametrosNS.bge.CodigoGrupo), 2, 0) + "." + parametrosNS.bge.NomeGrupo + "   " + fc.FormataCampo(String.valueOf(parametrosNS.be.CodigoEmpresa), 3, 0) + "." + parametrosNS.be.NomeEmpresa);
        if(aux == 0){
            PegaEmpresas("N");
        }
        aux = 1;
    }
    
    private void VerificaEspecificacoesDoUsuario(){
        if(parametrosNS.bu.podeMudarEmpresa == 0){
            bt_mudarEmpresaAtual .setVisible(false);
            combo_empresasDoGrupo.setEnabled(false);
        }
        if(parametrosNS.bu.nivelUsuario < 9){
            bt_cadastroUsuarios     .setVisible(false);
            bt_cadastroDepartamentos.setVisible(false);
            bt_acessos              .setVisible(false);
            bt_configuracoes        .setVisible(false);
            bt_gerenciadorDeConexoes.setVisible(false);
        }
    }
    
    private void MontaModulosEmpresa(){
        bt_faturamento   .setVisible(true);
        bt_vendas        .setVisible(true);
        bt_estoque       .setVisible(true);
        bt_contabilidade .setVisible(true);
        bt_contabil      .setVisible(true);
        bt_fiscal        .setVisible(true);
        bt_financeiro    .setVisible(true);
        bt_ContasAPagar  .setVisible(true);
        bt_ContasAReceber.setVisible(true);
        bt_producao      .setVisible(true);
        bt_gestao        .setVisible(true);
        bt_compras       .setVisible(true);
        bt_recebimento   .setVisible(true);
        bt_crm           .setVisible(true);
        bt_cc            .setVisible(true);
        bt_rh            .setVisible(true);
        
        if(parametrosNS.bma.moduloFaturamento        == 0)bt_faturamento     .setVisible(false);
        if(parametrosNS.bma.moduloVendas             == 0)bt_vendas          .setVisible(false);
        if(parametrosNS.bma.moduloEstoque            == 0)bt_estoque         .setVisible(false);
        if(parametrosNS.bma.moduloContabil           == 0 & parametrosNS.bma.moduloFiscal       == 0)bt_contabilidade.setVisible(false);
            if(parametrosNS.bma.moduloContabil       == 0)bt_contabil        .setVisible(false);
            if(parametrosNS.bma.moduloFiscal         == 0)bt_fiscal          .setVisible(false);
        if(parametrosNS.bma.moduloContasAReceber     == 0 & parametrosNS.bma.moduloContasAPagar == 0)bt_financeiro.setVisible(false);
            if(parametrosNS.bma.moduloContasAPagar   == 0)bt_ContasAPagar    .setVisible(false);
            if(parametrosNS.bma.moduloContasAReceber == 0)bt_ContasAReceber  .setVisible(false);
        if(parametrosNS.bma.moduloProducao           == 0)bt_producao        .setVisible(false);
        if(parametrosNS.bma.moduloGestao             == 0)bt_gestao          .setVisible(false);
        if(parametrosNS.bma.moduloCompras            == 0)bt_compras         .setVisible(false);
        if(parametrosNS.bma.moduloRecebimento        == 0)bt_recebimento     .setVisible(false);
        if(parametrosNS.bma.moduloCRM                == 0)bt_crm             .setVisible(false);
        if(parametrosNS.bma.moduloCC                 == 0)bt_cc              .setVisible(false);
        if(parametrosNS.bma.moduloRH                 == 0)bt_rh              .setVisible(false);
        
        MontaModulos();
    }
    
    private void MontaModulos(){
        if(parametrosNS.bm.moduloFaturamento         == 0)bt_faturamento.setVisible(false);
        if(parametrosNS.bm.moduloVendas              == 0)bt_vendas.setVisible(false);
        if(parametrosNS.bm.moduloEstoque             == 0)bt_estoque.setVisible(false);
        if(parametrosNS.bm.moduloContabil            == 0 & parametrosNS.bm.moduloFiscal       == 0)bt_contabilidade.setVisible(false);
            if(parametrosNS.bm.moduloContabil        == 0)bt_contabil.setVisible(false);
            if(parametrosNS.bm.moduloFiscal          == 0)bt_fiscal  .setVisible(false);
        if(parametrosNS.bm.moduloContasAReceber      == 0 & parametrosNS.bm.moduloContasAPagar == 0)bt_financeiro.setVisible(false);
            if(parametrosNS.bm.moduloContasAPagar    == 0)bt_ContasAPagar    .setVisible(false);
            if(parametrosNS.bm.moduloContasAReceber  == 0)bt_ContasAReceber  .setVisible(false);
        if(parametrosNS.bm.moduloProducao            == 0)bt_producao.setVisible(false);
        if(parametrosNS.bm.moduloGestao              == 0)bt_gestao.setVisible(false);
        if(parametrosNS.bm.moduloCompras             == 0)bt_compras.setVisible(false);
        if(parametrosNS.bm.moduloRecebimento         == 0)bt_recebimento.setVisible(false);
        if(parametrosNS.bm.moduloCRM                 == 0)bt_crm.setVisible(false);
        if(parametrosNS.bm.moduloCC                  == 0)bt_cc.setVisible(false);
        if(parametrosNS.bm.moduloRH                  == 0)bt_rh.setVisible(false);
    }
    
    private void PegaEmpresas(String Emp){
        if(Emp.equals("N")){
            add = 0;
        }
        sql = "select * from ns_empresas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + ";";
        if(Emp.equals("S")){
            be.codigoEmpresa = Integer.parseInt(String.valueOf(combo_empresasDoGrupo.getSelectedItem()).substring(0, 3));
            sql = "select * from ns_empresas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + be.codigoEmpresa + ";";
        }
        dadosEmpresas = new ArrayList();
        dadosEmpresas = parametrosNS.dao.Consulta(sql);
        if(dadosEmpresas.isEmpty()){
            return;
        }
        PegaDadosEmpresas(Emp);
    }
    
    private void PegaDadosEmpresas(String Emp){
        if(Emp.equals("N")){
            combo_empresasDoGrupo.removeAllItems();
        }
        for(int i = 0; i < dadosEmpresas.size(); i++){
            be.idEmpresa                = Integer.parseInt(  String.valueOf(dadosEmpresas.get(i).get(0)));
            be.codigoGrupo              = Integer.parseInt(  String.valueOf(dadosEmpresas.get(i).get(1)));
            be.codigoEmpresa            = Integer.parseInt(  String.valueOf(dadosEmpresas.get(i).get(2)));
            be.idBancoDados             = Integer.parseInt(  String.valueOf(dadosEmpresas.get(i).get(3)));
            be.nomeEmpresa              =                    String.valueOf(dadosEmpresas.get(i).get(4));
            be.nomeFantasia             =                    String.valueOf(dadosEmpresas.get(i).get(5));
            be.cnpjEmpresa              =                    String.valueOf(dadosEmpresas.get(i).get(6));
            be.inscricaoEstadual        =                    String.valueOf(dadosEmpresas.get(i).get(7));
            be.regimeTributario         =                    String.valueOf(dadosEmpresas.get(i).get(8));
            be.cepEmpresa               =                    String.valueOf(dadosEmpresas.get(i).get(9));
            be.cidadeEmpresa            =                    String.valueOf(dadosEmpresas.get(i).get(10));
            be.bairroEmpresa            =                    String.valueOf(dadosEmpresas.get(i).get(11));
            be.enderecoEmpresa          =                    String.valueOf(dadosEmpresas.get(i).get(12));
            be.numeroEmpresa            =                    String.valueOf(dadosEmpresas.get(i).get(13));
            be.ufEmpresa                =                    String.valueOf(dadosEmpresas.get(i).get(14));
            be.telefoneEmpresa          =                    String.valueOf(dadosEmpresas.get(i).get(15));
            be.pastaImagemUsuario       =                    String.valueOf(dadosEmpresas.get(i).get(16));
            be.extensaoImagemUsuario    =                    String.valueOf(dadosEmpresas.get(i).get(17));
            be.dataValidade             =                    String.valueOf(dadosEmpresas.get(i).get(18));
            
            if(Emp.equals("N")){
                combo_empresasDoGrupo.addItem(parametrosNS.fc.FormataCampo(String.valueOf(be.codigoEmpresa), 3, 0) + "-" + be.nomeFantasia);
            }
        }
        if(Emp.equals("N")){
            return;
        }
        parametrosNS.be.IdEmpresa               = be.idEmpresa;
        parametrosNS.be.CodigoGrupo             = be.codigoGrupo;
        parametrosNS.be.CodigoEmpresa           = be.codigoEmpresa;
        parametrosNS.be.IdBancoDados            = be.idBancoDados;
        parametrosNS.be.NomeEmpresa             = be.nomeEmpresa;
        parametrosNS.be.NomeFantasia            = be.nomeFantasia;
        parametrosNS.be.CnpjEmpresa             = be.cnpjEmpresa;
        parametrosNS.be.InscricaoEstadual       = be.inscricaoEstadual;
        parametrosNS.be.RegimeTributario        = be.regimeTributario;
        parametrosNS.be.CepEmpresa              = be.cepEmpresa;
        parametrosNS.be.CidadeEmpresa           = be.cidadeEmpresa;
        parametrosNS.be.BairroEmpresa           = be.bairroEmpresa;
        parametrosNS.be.EnderecoEmpresa         = be.enderecoEmpresa;
        parametrosNS.be.NumeroEmpresa           = be.numeroEmpresa;
        parametrosNS.be.UfEmpresa               = be.ufEmpresa;
        parametrosNS.be.TelefoneEmpresa         = be.telefoneEmpresa;
        parametrosNS.be.PastaImagemUsuario      = be.pastaImagemUsuario;
        parametrosNS.be.ExtensaoImagemUsuario   = be.extensaoImagemUsuario;
        parametrosNS.be.DataValidade            = be.dataValidade;
        PegaLogotipoEmpresa();
        
        parametrosNS.PegaUsuario("");
        
        IniciaComponentes();
        MontaImagem();
    }
    
    private void PegaLogotipoEmpresa(){
        sql = "select imagemLogotipoEmpresa from ns_empresas where codigoGrupo = " + parametrosNS.bge.codigoGrupo + " and codigoEmpresa = " + be.codigoEmpresa + ";";
        parametrosNS.be.ImagemLogotipoEmpresa = parametrosNS.dao.ConsultaLogotipo(sql, "imagemLogotipoEmpresa");
        if(parametrosNS.bu.codigoUsuario == 999){
            parametrosNS.be.imagemLogotipoEmpresa = parametrosNS.be.ImagemLogotipoEmpresa;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopupContabilidade = new javax.swing.JPopupMenu();
        bt_contabil = new javax.swing.JMenuItem();
        bt_fiscal = new javax.swing.JMenuItem();
        PopupFinanceiro = new javax.swing.JPopupMenu();
        bt_ContasAPagar = new javax.swing.JMenuItem();
        bt_ContasAReceber = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        txt_rodape = new javax.swing.JLabel();
        txt_diasrestantes = new javax.swing.JLabel();
        combo_empresasDoGrupo = new javax.swing.JComboBox<>();
        Painel_Logo = new javax.swing.JLabel();
        bt_faturamento = new javax.swing.JButton();
        bt_producao = new javax.swing.JButton();
        bt_estoque = new javax.swing.JButton();
        bt_vendas = new javax.swing.JButton();
        bt_contabilidade = new javax.swing.JButton();
        bt_financeiro = new javax.swing.JButton();
        bt_gestao = new javax.swing.JButton();
        bt_crm = new javax.swing.JButton();
        bt_compras = new javax.swing.JButton();
        bt_recebimento = new javax.swing.JButton();
        bt_cc = new javax.swing.JButton();
        bt_rh = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        painel_atualizacaoBancoDeDados = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        barra_tabelas = new javax.swing.JProgressBar();
        label_processamentoTabelas = new javax.swing.JLabel();
        barra_processoAtual = new javax.swing.JProgressBar();
        label_contadorProcessoAtual = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_cadastroUsuarios = new javax.swing.JMenuItem();
        bt_cadastroDepartamentos = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        bt_MudarUsuarioAtual = new javax.swing.JMenuItem();
        bt_mudarEmpresaAtual = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        bt_acessos = new javax.swing.JMenu();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem30 = new javax.swing.JMenuItem();
        bt_senhaDoSistema = new javax.swing.JMenuItem();
        bt_configuracoes = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        bt_gerenciadorDeConexoes = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        bt_contabil.setText("Contabilidade");
        bt_contabil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_contabilActionPerformed(evt);
            }
        });
        PopupContabilidade.add(bt_contabil);

        bt_fiscal.setText("Fiscal");
        bt_fiscal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_fiscalActionPerformed(evt);
            }
        });
        PopupContabilidade.add(bt_fiscal);

        bt_ContasAPagar.setText("Contas à Pagar");
        bt_ContasAPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ContasAPagarActionPerformed(evt);
            }
        });
        PopupFinanceiro.add(bt_ContasAPagar);

        bt_ContasAReceber.setText("Contas à Receber");
        bt_ContasAReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ContasAReceberActionPerformed(evt);
            }
        });
        PopupFinanceiro.add(bt_ContasAReceber);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1024, 768));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
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
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_rodape.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_rodape.setForeground(new java.awt.Color(255, 255, 255));

        txt_diasrestantes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_diasrestantes.setForeground(new java.awt.Color(255, 255, 255));
        txt_diasrestantes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        combo_empresasDoGrupo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        combo_empresasDoGrupo.setMaximumRowCount(100);
        combo_empresasDoGrupo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        combo_empresasDoGrupo.setLightWeightPopupEnabled(false);
        combo_empresasDoGrupo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_empresasDoGrupoItemStateChanged(evt);
            }
        });
        combo_empresasDoGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_empresasDoGrupoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txt_rodape, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_diasrestantes, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_empresasDoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_rodape, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_diasrestantes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_empresasDoGrupo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        Painel_Logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Painel_Logo.setToolTipText("");

        bt_faturamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Statistics.png"))); // NOI18N
        bt_faturamento.setText("        Faturamento");
        bt_faturamento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bt_faturamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_faturamentoActionPerformed(evt);
            }
        });

        bt_producao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/engrenagem.png"))); // NOI18N
        bt_producao.setText("     Produção");
        bt_producao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bt_producao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_producaoActionPerformed(evt);
            }
        });

        bt_estoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/estoq.png"))); // NOI18N
        bt_estoque.setText("        Estoque");
        bt_estoque.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bt_estoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_estoqueActionPerformed(evt);
            }
        });

        bt_vendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/vend.png"))); // NOI18N
        bt_vendas.setText("        Vendas");
        bt_vendas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bt_vendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_vendasActionPerformed(evt);
            }
        });

        bt_contabilidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Calculator.png"))); // NOI18N
        bt_contabilidade.setText("        Contabilidade");
        bt_contabilidade.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bt_contabilidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_contabilidadeMouseClicked(evt);
            }
        });

        bt_financeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/financeiro.png"))); // NOI18N
        bt_financeiro.setText("    Financeiro");
        bt_financeiro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bt_financeiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_financeiroMouseClicked(evt);
            }
        });

        bt_gestao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Friends.png"))); // NOI18N
        bt_gestao.setText("       Gestão Administrativa");
        bt_gestao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bt_gestao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_gestaoActionPerformed(evt);
            }
        });

        bt_crm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/cliente.png"))); // NOI18N
        bt_crm.setText("CRM");
        bt_crm.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bt_crm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_crmActionPerformed(evt);
            }
        });

        bt_compras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Wallet.png"))); // NOI18N
        bt_compras.setText("        Compras");
        bt_compras.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bt_compras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_comprasActionPerformed(evt);
            }
        });

        bt_recebimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Payment.png"))); // NOI18N
        bt_recebimento.setText("        Recebimento");
        bt_recebimento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bt_recebimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_recebimentoActionPerformed(evt);
            }
        });

        bt_cc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/boletos.png"))); // NOI18N
        bt_cc.setText("     Contas Correntes");
        bt_cc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bt_cc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ccActionPerformed(evt);
            }
        });

        bt_rh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/User group.png"))); // NOI18N
        bt_rh.setText("        Recursos Humanos");
        bt_rh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bt_rh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_rhActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        painel_atualizacaoBancoDeDados.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Atualização");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        label_processamentoTabelas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        label_contadorProcessoAtual.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout painel_atualizacaoBancoDeDadosLayout = new javax.swing.GroupLayout(painel_atualizacaoBancoDeDados);
        painel_atualizacaoBancoDeDados.setLayout(painel_atualizacaoBancoDeDadosLayout);
        painel_atualizacaoBancoDeDadosLayout.setHorizontalGroup(
            painel_atualizacaoBancoDeDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(painel_atualizacaoBancoDeDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_atualizacaoBancoDeDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barra_tabelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(barra_processoAtual, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_atualizacaoBancoDeDadosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(painel_atualizacaoBancoDeDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_processamentoTabelas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_contadorProcessoAtual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        painel_atualizacaoBancoDeDadosLayout.setVerticalGroup(
            painel_atualizacaoBancoDeDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_atualizacaoBancoDeDadosLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_processamentoTabelas, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(barra_tabelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_contadorProcessoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(barra_processoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painel_atualizacaoBancoDeDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painel_atualizacaoBancoDeDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Application.png"))); // NOI18N
        jMenu1.setText("Sistema");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        bt_cadastroUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/User group.png"))); // NOI18N
        bt_cadastroUsuarios.setText(":: Cadastro de Usuários");
        bt_cadastroUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastroUsuariosActionPerformed(evt);
            }
        });
        jMenu1.add(bt_cadastroUsuarios);

        bt_cadastroDepartamentos.setText(":: Cadastro de Departamentos");
        bt_cadastroDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastroDepartamentosActionPerformed(evt);
            }
        });
        jMenu1.add(bt_cadastroDepartamentos);
        jMenu1.add(jSeparator2);

        bt_MudarUsuarioAtual.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        bt_MudarUsuarioAtual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Left-right.png"))); // NOI18N
        bt_MudarUsuarioAtual.setText(":: Mudar Usuário Atual");
        bt_MudarUsuarioAtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_MudarUsuarioAtualActionPerformed(evt);
            }
        });
        jMenu1.add(bt_MudarUsuarioAtual);

        bt_mudarEmpresaAtual.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        bt_mudarEmpresaAtual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Left-right.png"))); // NOI18N
        bt_mudarEmpresaAtual.setText(":: Mudar Empresa Atual");
        bt_mudarEmpresaAtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_mudarEmpresaAtualActionPerformed(evt);
            }
        });
        jMenu1.add(bt_mudarEmpresaAtual);
        jMenu1.add(jSeparator1);

        bt_acessos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/List.png"))); // NOI18N
        bt_acessos.setText(":: Acessos");

        jMenuItem22.setText(":: Consulta logs de acesso");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        bt_acessos.add(jMenuItem22);

        jMenuItem30.setText(":: Imprime log de acesso");
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        bt_acessos.add(jMenuItem30);

        jMenu1.add(bt_acessos);

        bt_senhaDoSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Key.png"))); // NOI18N
        bt_senhaDoSistema.setText(":: Senha do Sistema");
        bt_senhaDoSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_senhaDoSistemaActionPerformed(evt);
            }
        });
        jMenu1.add(bt_senhaDoSistema);

        bt_configuracoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Pinion.png"))); // NOI18N
        bt_configuracoes.setText(":: Configurações");

        jMenuItem7.setText(":: Parâmetros de Diretórios");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        bt_configuracoes.add(jMenuItem7);

        jMenuItem9.setText(":: Cadastro de Computadores");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        bt_configuracoes.add(jMenuItem9);

        jMenuItem1.setText(":: Atualizador Banco de Dados");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        bt_configuracoes.add(jMenuItem1);

        jMenu1.add(bt_configuracoes);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Search.png"))); // NOI18N
        jMenuItem8.setText(":: Busca Avançada");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        bt_gerenciadorDeConexoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Database.png"))); // NOI18N
        bt_gerenciadorDeConexoes.setText(":: Gerenciador de Conexões");
        bt_gerenciadorDeConexoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_gerenciadorDeConexoesActionPerformed(evt);
            }
        });
        jMenu1.add(bt_gerenciadorDeConexoes);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        jMenuItem2.setText(":: Sair");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_contabilidade, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(bt_financeiro, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(bt_gestao, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(bt_crm, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(bt_compras, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(bt_recebimento, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(bt_cc, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(bt_faturamento, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(bt_producao, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(bt_estoque, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(bt_vendas, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(bt_rh, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Painel_Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_cc, bt_compras, bt_contabilidade, bt_crm, bt_estoque, bt_faturamento, bt_financeiro, bt_gestao, bt_producao, bt_recebimento, bt_rh, bt_vendas});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_faturamento, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(bt_producao, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(bt_estoque, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(bt_vendas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(bt_contabilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(bt_financeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(bt_gestao, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(bt_crm, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(bt_compras, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(bt_recebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(bt_cc, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(bt_rh, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Painel_Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_cc, bt_compras, bt_contabilidade, bt_crm, bt_estoque, bt_faturamento, bt_financeiro, bt_gestao, bt_producao, bt_recebimento, bt_vendas});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_MudarUsuarioAtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_MudarUsuarioAtualActionPerformed
        TrocarUsuario();
    }//GEN-LAST:event_bt_MudarUsuarioAtualActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        FecharSistema();
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    
    private void FecharSistema(){
        LogaSaida();
        EncerraConexoes();
        System.exit(0);
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        painel_atualizacaoBancoDeDados.setVisible(false);
        if(parametrosNS.gsAlert.equals("S")){
            Lg = new Login(null);
            Lg.setVisible(true);
            this.dispose();
            return;
        }
        MontaImagem();
        if(parametrosNS.bcomp.funcaoComputador.equalsIgnoreCase("pdv")){
            MenuVendas();
        }
        add = 1;
    }//GEN-LAST:event_formWindowOpened
    
    private void bt_mudarEmpresaAtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_mudarEmpresaAtualActionPerformed
        MudarEmpresaAtual();
    }//GEN-LAST:event_bt_mudarEmpresaAtualActionPerformed

    private void bt_senhaDoSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_senhaDoSistemaActionPerformed
        if(InfSenSis != null)if(InfSenSis.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        InfSenSis = new InformarSenhaSistema("Menu");
        InfSenSis.setVisible(true);
    }//GEN-LAST:event_bt_senhaDoSistemaActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if(Param != null)if(Param.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        Param = new Parametros();
        Param.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        if(BusAvan != null)if(BusAvan.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        BusAvan = new BuscaAvancada();
        BusAvan.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        if(LogAce != null)if(LogAce.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        LogAce = new LogAcesso();
        LogAce.setVisible(true);
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        if(CompCad != null)if(CompCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        CompCad = new ComputadoresCadastro("");
        CompCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void bt_gerenciadorDeConexoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_gerenciadorDeConexoesActionPerformed
        if(CompCad != null)if(CompCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        GerCon = new GerenciadorDeConexoes();
        GerCon.setVisible(true);
    }//GEN-LAST:event_bt_gerenciadorDeConexoesActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
//        if(parametrosNS.bcomp.funcaoComputador.equals("logout")){
//            TrocarUsuario();
//        }
//        IniciaComponentes();
    }//GEN-LAST:event_formWindowGainedFocus

    private void bt_faturamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_faturamentoActionPerformed
        MenuFaturamento();
    }//GEN-LAST:event_bt_faturamentoActionPerformed

    private void bt_producaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_producaoActionPerformed
        MenuProducao();
    }//GEN-LAST:event_bt_producaoActionPerformed

    private void bt_estoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_estoqueActionPerformed
        MenuEstoque();
    }//GEN-LAST:event_bt_estoqueActionPerformed

    private void bt_vendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_vendasActionPerformed
        MenuVendas();
    }//GEN-LAST:event_bt_vendasActionPerformed

    private void bt_gestaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_gestaoActionPerformed
        MenuGestao();
    }//GEN-LAST:event_bt_gestaoActionPerformed

    private void bt_crmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_crmActionPerformed
        MenuCRM();
    }//GEN-LAST:event_bt_crmActionPerformed

    private void bt_comprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_comprasActionPerformed
        MenuCompras();
    }//GEN-LAST:event_bt_comprasActionPerformed

    private void bt_recebimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_recebimentoActionPerformed
        MenuRecebimento();
    }//GEN-LAST:event_bt_recebimentoActionPerformed

    private void bt_ccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ccActionPerformed
        MenuContasCorrentes();
    }//GEN-LAST:event_bt_ccActionPerformed

    private void bt_contabilidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_contabilidadeMouseClicked
        PopupContabilidade.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_bt_contabilidadeMouseClicked

    private void bt_financeiroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_financeiroMouseClicked
        PopupFinanceiro.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_bt_financeiroMouseClicked

    private void bt_cadastroUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastroUsuariosActionPerformed
        if(UsuCad != null)if(UsuCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add("");
        parametros.add(0);
        UsuCad = new UsuariosCadastro(parametros);
        UsuCad.setVisible(true);
    }//GEN-LAST:event_bt_cadastroUsuariosActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(MudEmpAtu == null)
            if(parametrosNS.con  != null){
                LogaSaida();
                EncerraConexoes();
                System.exit(0);
            }
    }//GEN-LAST:event_formWindowClosing

    private void bt_contabilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_contabilActionPerformed
        MenuContabilidade();
    }//GEN-LAST:event_bt_contabilActionPerformed

    private void bt_fiscalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fiscalActionPerformed
        MenuFiscal();
    }//GEN-LAST:event_bt_fiscalActionPerformed

    private void bt_ContasAPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ContasAPagarActionPerformed
        MenuContasAPagar();
    }//GEN-LAST:event_bt_ContasAPagarActionPerformed

    private void bt_ContasAReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ContasAReceberActionPerformed
        MenuContasAReceber();
    }//GEN-LAST:event_bt_ContasAReceberActionPerformed

    private void bt_rhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_rhActionPerformed
        MenuRecursosHumanos();
    }//GEN-LAST:event_bt_rhActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Sair();
    }//GEN-LAST:event_formWindowClosed
    
    private void Sair(){
        if(DepCad   != null)DepCad   .dispose();
        if(InfSenSis!= null)InfSenSis.dispose();
        if(LogAce   != null)LogAce   .dispose();
        if(MF       != null)MF       .dispose();
        if(MV       != null)MV       .dispose();
        if(ME       != null)ME       .dispose();
        if(MCAR     != null)MCAR     .dispose();
        if(MCAP     != null)MCAP     .dispose();
        if(MP       != null)MP       .dispose();
        if(MG       != null)MG       .dispose();
        if(MCom     != null)MCom     .dispose();
        if(MRec     != null)MRec     .dispose();
        if(MCRM     != null)MCRM     .dispose();
        if(MCC      != null)MCC      .dispose();
        if(MCont    != null)MCont    .dispose();
        if(MFis     != null)MFis     .dispose();
        if(MCaP     != null)MCaP     .dispose();
        if(MCaR     != null)MCaR     .dispose();
        if(MRH      != null)MRH      .dispose();
        if(GerCon   != null)GerCon   .dispose();
        if(BusAvan  != null)BusAvan  .dispose();
        if(Param    != null)Param    .dispose();
        if(CompCad  != null)CompCad  .dispose();
        if(UsuCad   != null)UsuCad   .dispose();
    }
    
    private void bt_cadastroDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastroDepartamentosActionPerformed
        if(DepCad != null)if(DepCad.isVisible()){
            Mensagem = "Tela já Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add("");
        parametros.add(0);
        DepCad = new DepartamentosCadastro(parametros);
        DepCad.setVisible(true);
    }//GEN-LAST:event_bt_cadastroDepartamentosActionPerformed

    private void combo_empresasDoGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_empresasDoGrupoActionPerformed
    }//GEN-LAST:event_combo_empresasDoGrupoActionPerformed

    private void combo_empresasDoGrupoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_empresasDoGrupoItemStateChanged
        if(combo_empresasDoGrupo.isEnabled() == false){
            return;
        }
        if(combo_empresasDoGrupo.getItemCount() < 0){
            return;
        }
        if(add == 0){
            return;
        }
        PegaEmpresas("S");
    }//GEN-LAST:event_combo_empresasDoGrupoItemStateChanged

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        MontaImagem();
    }//GEN-LAST:event_formComponentResized

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        AtualizadorCluster AtuClu = new AtualizadorCluster(this);
        AtuClu.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Painel_Logo;
    private javax.swing.JPopupMenu PopupContabilidade;
    private javax.swing.JPopupMenu PopupFinanceiro;
    public javax.swing.JProgressBar barra_processoAtual;
    public javax.swing.JProgressBar barra_tabelas;
    private javax.swing.JMenuItem bt_ContasAPagar;
    private javax.swing.JMenuItem bt_ContasAReceber;
    private javax.swing.JMenuItem bt_MudarUsuarioAtual;
    private javax.swing.JMenu bt_acessos;
    private javax.swing.JMenuItem bt_cadastroDepartamentos;
    private javax.swing.JMenuItem bt_cadastroUsuarios;
    private javax.swing.JButton bt_cc;
    private javax.swing.JButton bt_compras;
    private javax.swing.JMenu bt_configuracoes;
    private javax.swing.JMenuItem bt_contabil;
    private javax.swing.JButton bt_contabilidade;
    private javax.swing.JButton bt_crm;
    private javax.swing.JButton bt_estoque;
    private javax.swing.JButton bt_faturamento;
    private javax.swing.JButton bt_financeiro;
    private javax.swing.JMenuItem bt_fiscal;
    private javax.swing.JMenuItem bt_gerenciadorDeConexoes;
    private javax.swing.JButton bt_gestao;
    private javax.swing.JMenuItem bt_mudarEmpresaAtual;
    private javax.swing.JButton bt_producao;
    private javax.swing.JButton bt_recebimento;
    private javax.swing.JButton bt_rh;
    private javax.swing.JMenuItem bt_senhaDoSistema;
    private javax.swing.JButton bt_vendas;
    private javax.swing.JComboBox<String> combo_empresasDoGrupo;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    public javax.swing.JLabel label_contadorProcessoAtual;
    public javax.swing.JLabel label_processamentoTabelas;
    private javax.swing.JPanel painel_atualizacaoBancoDeDados;
    private javax.swing.JLabel txt_diasrestantes;
    private javax.swing.JLabel txt_rodape;
    // End of variables declaration//GEN-END:variables
    
    public void CarregarInformacoes(){
        ip       = parametrosNS.bcomp.ipv4;
        Pasta    = parametrosNS.PastaSistema;
        servidor = parametrosNS.bbd.servidor;
        Rodape1  = "L: " + parametrosNS.bu.usuario + " | U: " + parametrosNS.bcomp.usuarioMachine + " | Term.: " + parametrosNS.bcomp.nomeComputador + " | Dir: " + Pasta + " | " + parametrosNS.bcomp.ipv4 + " | H: " + servidor;
        if(parametrosNS.PastaSistema.length() > 17){
            Pasta = parametrosNS.PastaSistema.substring(0, 17) + "...";
        }
        if(parametrosNS.bbd.servidor.length() > 7){
            servidor = parametrosNS.bbd.servidor.substring(0, 7) + "...";
        }
        if(parametrosNS.bcomp.ipv4.length() > 7){
            ip   = parametrosNS.bcomp.ipv4.substring(0, 7) + "...";
        }
        Rodape = "L: " + parametrosNS.bu.usuario + " | U: " + parametrosNS.bcomp.usuarioMachine + " | Term.: " + parametrosNS.bcomp.nomeComputador + " | Dir: " + Pasta + " | " + parametrosNS.bcomp.ipv4 + " | H: " + servidor;
        txt_rodape.setText(Rodape);
        txt_rodape.setToolTipText(Rodape1);
        txt_diasrestantes.setText("Dias restantes: " + parametrosNS.Dias);
        
        if(parametrosNS.Dias > 10){
            return;
        }
        if(parametrosNS.Dias == 1){
            Mensagem = "Falta "  + parametrosNS.Dias + " dia para expirar o sistema!!!";
        }
        if(parametrosNS.Dias > 1){
            Mensagem = "Faltam " + parametrosNS.Dias + " dias para expirar o sistema!!!";
        }
        new MostraMensagem(Mensagem);
    }
    
    public void EncerraConexoes(){
        Tempo.stop();
        if(!fabricaConexaoMySQL.fecharConexao(parametrosNS.con).equalsIgnoreCase("OK")){
            Mensagem = "Erro ao encerrar conexão com o banco de dados!!!\nEntre em contato com o Suporte!!!";
            new MostraMensagem(Mensagem);
            return;
        }
    }
    
    public void TrocarUsuario(){
        dispose();
        LogaSaida();
        EncerraConexoes();
        Lg = new Login(null);
        Lg.setVisible(true);
//        BarraInicial    bar     = new BarraInicial();
//        ProcessoInicial ProIni  = new ProcessoInicial(bar);
    }
    
    public void LogaSaida(){
        if(parametrosNS.bu.usuario.equalsIgnoreCase("ns3")){
            return;
        }
        bla.idEmpresa       = parametrosNS.be.idEmpresa;
        bla.codigoGrupo     = parametrosNS.be.codigoGrupo;
        bla.codigoEmpresa   = parametrosNS.be.codigoEmpresa;
        bla.codigoUsuario   = parametrosNS.bu.codigoUsuario;
        sql = "select max(idLogAcesso) from tb_logacesso where idEmpresa = " + bla.idEmpresa + " and codigoUsuario = " + bla.codigoUsuario + ";";
        dadosLogAcesso = parametrosNS.dao.Consulta(sql);
        bla.idLogAcesso = Integer.parseInt(  String.valueOf(dadosLogAcesso.get(0).get(0)));
        sql = "update tb_logacesso set horaSaida = '" + cdh.CapturaHora() + "' where idEmpresa = " + bla.idEmpresa + " and idLogAcesso = " + bla.idLogAcesso + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        bu.idEmpresa     = bla.idEmpresa;
        bu.codigoGrupo   = bla.codigoGrupo;
        bu.codigoEmpresa = bla.codigoEmpresa;
        bu.codigoUsuario = bla.codigoUsuario;
        sql = "update tb_usuarios set nomeConexao = null where idEmpresa = " + bu.idEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";" ;
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
    }
    
    public void MudarEmpresaAtual(){
        Tempo.stop();
        dispose();
        MudEmpAtu = new MudarEmpresaAtual();
        MudEmpAtu.setVisible(true);
    }
    
    public void MontaImagem(){
        if(parametrosNS.be.ImagemLogotipoEmpresa == null){
            Painel_Logo.setIcon(null);
            return;
        }
        try{
            BuffImg = ImageIO.read(new ByteArrayInputStream(parametrosNS.be.ImagemLogotipoEmpresa));
        }catch(IOException e){
            
        }
        ImgIcon = new ImageIcon(BuffImg);
        Img     = ImgIcon.getImage();
        
        ConfiguraImagem();
        
        gsLarguraLogo   = String.valueOf(gdLarguraLogo);
        gsAlturaLogo    = String.valueOf(gdAlturaLogo);
        
        giLarguraLogo = Integer.parseInt(gsLarguraLogo.substring(0, gsLarguraLogo.lastIndexOf(".")));
        giAlturaLogo  = Integer.parseInt(gsAlturaLogo .substring(0, gsAlturaLogo .lastIndexOf(".")));
        
        Img   = Img.getScaledInstance(giLarguraLogo , giAlturaLogo, Img.SCALE_DEFAULT);
        Painel_Logo.setIcon(new ImageIcon(Img));
    }
    
    private void ConfiguraImagem(){
        giPainelLargura = Painel_Logo.getWidth();
        giPainelAltura  = Painel_Logo.getHeight();
        
        gdLarguraLogo = ImgIcon.getIconWidth();
        gdLarguraLogo = gdLarguraLogo * (gdLarguraPadrao / 100);
        gdAlturaLogo  = ImgIcon.getIconHeight();
        gdAlturaLogo  = gdAlturaLogo  * (gdAlturaPadrao  / 100);
        if(gdLarguraLogo > giPainelLargura){
            gdLarguraPadrao = gdLarguraPadrao - 10;
            ConfiguraImagem();
            return;
        }
        if(gdAlturaLogo > giPainelAltura){
            gdAlturaPadrao  = gdAlturaPadrao  - 10;
            ConfiguraImagem();
            return;
        }
    }
    
    private void VerificaConexao(){
        if(Tempo != null){
            Tempo.stop();
        }
        ActionListener action = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ConsultaStatusConexao();
            }
        };
        Tempo = new Timer(5000, action);
        Tempo.start();
    }
    
    private void IniciaCarregamentoClusterBancoDeDados(){
        if(TempoCluster != null){
            TempoCluster.stop();
        }
        ActionListener action = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                IniciaCarregamentoClusterBancoDeDados2();
            }
        };
//        TempoCluster = new Timer(1200000, action);
        TempoCluster = new Timer(60000, action);
        TempoCluster.start();
    }
    
    private void IniciaCarregamentoClusterBancoDeDados2(){
//        painel_atualizacaoBancoDeDados.setVisible(true);
        TempoCluster.stop();
        new AtualizadorDeBancoDeDados(this, null, "Mp");
        TempoCluster.start();
//        painel_atualizacaoBancoDeDados.setVisible(false);
    }
    
    private void ConsultaStatusConexao(){
        if(parametrosNS.bu.usuario.equalsIgnoreCase("NS3")){
            return;
        }
        sql = "select nomeConexao from tb_usuarios where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoUsuario = " + parametrosNS.bu.codigoUsuario + ";";
        dadosConexao.clear();
        dadosConexao = parametrosNS.dao.Consulta(sql);
        PegaStatusConexao();
        if(!parametrosNS.bu.nomeConexao.equals("")){
            return;
        }
        Mensagem = "Conexão com Banco de Dados foi Encerrada!!!";
        new MostraMensagem(Mensagem);
        LogaSaida();
        System.exit(0);
    }
    
    private void PegaStatusConexao(){
        for(int i = 0; i < dadosConexao.size(); i++){
            if(dadosConexao.get(i).get(0) != null){
                parametrosNS.bu.nomeConexao = String.valueOf(dadosConexao.get(i).get(0));
            }else{
                parametrosNS.bu.nomeConexao = "";
            }
        }
    }
    
    //Daqui para baixo só para Abertura de Menus...
    private void MenuFaturamento(){
        if(MF != null){
            if(MF.isVisible()){
                MF.setState(JFrame.NORMAL);
                return;
            }
        }
        MF = new MenuFaturamento(this);
        MF.setVisible(true);
    }
    
    private void MenuProducao(){
        if(MP != null){
            if(MP.isVisible()){
                MP.setState(JFrame.NORMAL);
                return;
            }
        }
        MP = new MenuProducao(this);
        MP.setExtendedState(JFrame.MAXIMIZED_BOTH);
        MP.setVisible(true);
    }
    
    private void MenuContabilidade(){
        if(MCont != null){
            if(MCont.isVisible()){
                MCont.setState(JFrame.NORMAL);
                return;
            }
        }
        MCont = new MenuContabil(this);
        MCont.setVisible(true);
    }
    
    private void MenuFiscal(){
        if(MFis != null){
            if(MFis.isVisible()){
                MFis.setState(JFrame.NORMAL);
                return;
            }
        }
        MFis = new MenuFiscal(this);
        MFis.setVisible(true);
    }
    
    private void MenuContasAPagar(){
        if(MCaP != null){
            if(MCaP.isVisible()){
                MCaP.setState(JFrame.NORMAL);
                return;
            }
        }
        MCaP = new MenuContasAPagar(this);
        MCaP.setVisible(true);
    }
    
    private void MenuContasAReceber(){
        if(MCaR != null){
            if(MCaR.isVisible()){
                MCaR.setState(JFrame.NORMAL);
                return;
            }
        }
        MCaR = new MenuContasAReceber(this);
        MCaR.setVisible(true);
    }
    
    private void MenuEstoque(){
        if(ME != null){
            if(ME.isVisible()){
                ME.setState(JFrame.NORMAL);
                return;
            }
        }
        ME = new MenuEstoque(this);
        ME.setVisible(true);
    }
    
    private void MenuVendas(){
        if(MV != null){
            if(MV.isVisible()){
                MV.setState(JFrame.NORMAL);
                return;
            }
        }
        MV = new MenuVendas(this);
        MV.setVisible(true);
    }
    
    private void MenuGestao(){
        if(MG != null){
            if(MG.isVisible()){
                MG.setState(JFrame.NORMAL);
                return;
            }
        }
        MG = new MenuGestao(this);
        MG.setVisible(true);
    }
    
    private void MenuCompras(){
        if(MCom != null){
            if(MCom.isVisible()){
                MCom.setState(JFrame.NORMAL);
                return;
            }
        }
        MCom = new MenuCompras(this);
        MCom.setVisible(true);
    }
    
    private void MenuRecebimento(){
        if(MRec != null){
            if(MRec.isVisible()){
                MRec.setState(JFrame.NORMAL);
                return;
            }
        }
        MRec = new MenuRecebimento(this);
        MRec.setVisible(true);
    }
    
    private void MenuCRM(){
        if(MCRM != null){
            if(MCRM.isVisible()){
                MCRM.setState(JFrame.NORMAL);
                return;
            }
        }
        MCRM = new MenuCRM(this);
        MCRM.setVisible(true);
    }
    
    private void MenuContasCorrentes(){
        if(MCC != null){
            if(MCC.isVisible()){
                MCC.setState(JFrame.NORMAL);
                return;
            }
        }
        MCC = new MenuContasCorrentes(this);
        MCC.setVisible(true);
    }
    
    private void MenuRecursosHumanos(){
        if(MRH != null){
            if(MRH.isVisible()){
                MRH.setState(JFrame.NORMAL);
                return;
            }
        }
        MRH = new MenuRecursosHumanos(this);
        MRH.setVisible(true);
    }
    
}
