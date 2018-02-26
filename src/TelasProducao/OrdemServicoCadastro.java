package TelasProducao;

import FuncoesInternas.InverterData;
import Beans.*;
import FuncoesInternas.*;
import TelasFaturamento.ClientesConsulta;
import Parametros.parametrosNS;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.text.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
/*
 @author Tiago e Paulo
 */
public class OrdemServicoCadastro extends javax.swing.JFrame {
    //String's
    String sql              = "";
    String sqlstate         = "";
    String mensagem         = "";
    String somostra         = "";
    String operacao         = "";
    String retorno          = "";
    String valorFormatado   = "";
    String fatal            = "";
    String tipoItem         = "";
    String descricaoItem    = "";
    String usuarioItem      = "";
    String ValidaData       = "";
    
    //Date's
    Date   Data     = new Date();
    
    //int's
    int    abriuCliente             = 0;
    int    abriuItemOrdemServico    = 0;
    int    abriuOrdemServico        = 0;
    int    abriuSituacao            = 0;
    int    linha                    = 0;
    int    User                     = 0;
    int    FinalizaOrdemServico     = 0;
    int    CancelaOrdemServico      = 0;
    
    //Vetores
    ArrayList            Jasper                  = new ArrayList();
    ArrayList            parametros              = new ArrayList();
    ArrayList            dadosPadroes            = new ArrayList();
    ArrayList<ArrayList> dadosCliente            = new ArrayList();
    ArrayList<ArrayList> dadosOrdemServico       = new ArrayList();
    ArrayList<ArrayList> dadosOrdemServicoItens  = new ArrayList();
    ArrayList<ArrayList> dadosUsuario            = new ArrayList();
    ArrayList<ArrayList> dadosProdutos           = new ArrayList();
    ArrayList<ArrayList> dadosSituacoes          = new ArrayList();
    ArrayList<ArrayList> dadosParametros         = new ArrayList();
    ArrayList<ArrayList> dadosParametrosProducao = new ArrayList();
    ArrayList<ArrayList> dadosServicos           = new ArrayList();
    
    //Beans
    BeanClientes           bc      = new BeanClientes();
    BeanOrdemServico       bos     = new BeanOrdemServico();
    BeanOrdemServicoItens  bosi    = new BeanOrdemServicoItens();
    BeanSituacoes          bsit    = new BeanSituacoes();
    BeanProdutos           bp      = new BeanProdutos();
    BeanParametros         bpar    = new BeanParametros();
    BeanParametrosProducao bparpro = new BeanParametrosProducao();
    BeanServicos           bser    = new BeanServicos();
    BeanUsuarios           bu      = new BeanUsuarios();
    
    //Outros
    DefaultTableModel       Table;
    
    //Telas
    ClientesConsulta                CliCon;
    EmailMontagem                   EmaMon;
    OrdemServicoItemCadastro        OrdSerIteCad;
    OrdemServicoConsultaEManutencao OrdSerConMan;
    OrdemServicoFinalizar           FinalizaOS;
    OrdemServicoCancelar            OrdSerCan;
    SituacoesCadastro               SitCad;
    
    //Relatórios
    String        jpv         = "";
    JasperPrint   jpp         = null;
    HashMap       hm          = new HashMap();
    
    //Especiais
    BufferedImage buffImg;
    ImageIcon     imgIcon;
    Image         img;
    
    public OrdemServicoCadastro(String Somostra, int IdOrdemServico){
        somostra           = Somostra;
        bos.idOrdemServico = IdOrdemServico;
        
        initComponents();
    }
    
    private void DesabilitaAcoes(){
        bt_incluir              .setVisible (false);
        bt_alterar              .setVisible (false);
        txt_codigoCliente       .setEditable(false);
        bt_pesquisaCliente      .setEnabled (false);
        bt_cancelarOrdemServico .setVisible (false);
        bt_finalizarOrdemServico.setVisible (false);
        bt_incluirItem          .setVisible (false);
        bt_alterarItem          .setVisible (false);
        bt_excluirItem          .setVisible (false);
        bt_detalhesItem         .setVisible (true);
    }
    
//    private void PegaParametros(){
//        sql = "select * from tb_parametros where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
//        dadosParametros.clear();
//        dadosParametros = parametrosNS.dao.Consulta(sql);
//        if(dadosParametros.isEmpty()){
//            bt_imprimirOrdemServico.setVisible(false);
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
    
    private void PegaParametrosProducao(){
        sql = "select \n"
            + "   idParametrosProducao, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   impressaoDoLaudo, \n"
            + "   termoDeRecebimento \n"
            + " from tb_parametrosproducao where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosParametrosProducao.clear();
        dadosParametrosProducao = parametrosNS.dao.Consulta(sql);
        if(dadosParametrosProducao.isEmpty())
            return;
        PegaDadosParametrosContabil();
    }
    
    private void PegaDadosParametrosContabil(){
        for(int i = 0; i < dadosParametrosProducao.size(); i++){
            bparpro = new BeanParametrosProducao();
            if(dadosParametrosProducao.get(i).get(0) != null)
                bparpro.idParametrosProducao = Integer.parseInt(String.valueOf(dadosParametrosProducao.get(i).get(0)));
            if(dadosParametrosProducao.get(i).get(1) != null)
                bparpro.idEmpresa            = Integer.parseInt(String.valueOf(dadosParametrosProducao.get(i).get(1)));
            if(dadosParametrosProducao.get(i).get(2) != null)
                bparpro.codigoGrupo          = Integer.parseInt(String.valueOf(dadosParametrosProducao.get(i).get(2)));
            if(dadosParametrosProducao.get(i).get(3) != null)
                bparpro.codigoEmpresa        = Integer.parseInt(String.valueOf(dadosParametrosProducao.get(i).get(3)));
            if(dadosParametrosProducao.get(i).get(4) != null)
                bparpro.impressaoDoLaudo     = Integer.parseInt(String.valueOf(dadosParametrosProducao.get(i).get(4)));
            if(dadosParametrosProducao.get(i).get(5) != null)
                bparpro.termoDeRecebimento   =                  String.valueOf(dadosParametrosProducao.get(i).get(5));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_impressaoCompleta = new javax.swing.JMenuItem();
        bt_impressaoPorVia = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bt_novo = new javax.swing.JButton();
        txt_codigoOrdemServico = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        bt_pesquisaCliente = new javax.swing.JButton();
        txt_codigoCliente = new javax.swing.JFormattedTextField();
        label_nomeCliente = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_dataDeCadastro = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_descricao = new javax.swing.JTextField();
        txt_modelo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_marca = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_serie = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_patriomonio = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_acessorio = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_defeito = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txt_numeroNF = new javax.swing.JFormattedTextField();
        bt_incluir = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_finalizarOrdemServico = new javax.swing.JButton();
        bt_cancelarOrdemServico = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_laudo = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        combo_Situacao = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_observacoes = new javax.swing.JTextField();
        combo_aprovacao = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        combo_prioridade = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        txt_horaSaida = new javax.swing.JFormattedTextField();
        txt_horaEntrada = new javax.swing.JFormattedTextField();
        jLabel31 = new javax.swing.JLabel();
        txt_dataEntrada = new javax.swing.JFormattedTextField();
        txt_dataSaida = new javax.swing.JFormattedTextField();
        txt_dataGarantia = new javax.swing.JFormattedTextField();
        txt_dataPrevista = new javax.swing.JFormattedTextField();
        jLabel36 = new javax.swing.JLabel();
        txt_dataFinalizou = new javax.swing.JFormattedTextField();
        txt_horaFinalizou = new javax.swing.JFormattedTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_valorMaoDeObra = new javax.swing.JTextField();
        txt_valorPecas = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_valorDeslocamento = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_valorTerceiros = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txt_valorOutros = new javax.swing.JTextField();
        txt_valorAdiantamento = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        bt_imprimirOrdemServico = new javax.swing.JButton();
        bt_pesquisa = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabela_detalhesOrdemServico = new javax.swing.JTable();
        bt_incluirItem = new javax.swing.JButton();
        bt_excluirItem = new javax.swing.JButton();
        bt_alterarItem = new javax.swing.JButton();
        bt_detalhesItem = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        label_nomeUsuarioDigitou = new javax.swing.JLabel();
        txt_codigoUsuarioDigitou = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        label_nomeUsuarioFinalizou = new javax.swing.JLabel();
        txt_codigoUsuarioFinalizou = new javax.swing.JFormattedTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txt_codigoUsuarioCancelou = new javax.swing.JFormattedTextField();
        label_nomeUsuarioCancelou = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        txt_cpfcnpj1 = new javax.swing.JFormattedTextField();
        txt_cpfcnpj2 = new javax.swing.JFormattedTextField();
        txt_cpfcnpj3 = new javax.swing.JFormattedTextField();
        jPanel6 = new javax.swing.JPanel();
        label_alteracao = new javax.swing.JLabel();
        bt_imprimirCupom = new javax.swing.JButton();
        bt_email = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        bt_sair = new javax.swing.JMenuItem();

        bt_impressaoCompleta.setText("Impressão Completa");
        bt_impressaoCompleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_impressaoCompletaActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_impressaoCompleta);

        bt_impressaoPorVia.setText("Impressão em 2 vias");
        bt_impressaoPorVia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_impressaoPorViaActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_impressaoPorVia);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro - Ordens de Serviço");
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
        jLabel1.setText("Ordem de Serviço");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        try {
            txt_codigoOrdemServico.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        try {
            txt_codigoOrdemServico.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoOrdemServico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoOrdemServico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoOrdemServicoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoOrdemServicoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_codigoOrdemServico, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_novo, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_novo)
                    .addComponent(txt_codigoOrdemServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, txt_codigoOrdemServico});

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cliente");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bt_pesquisaCliente.setText("...");
        bt_pesquisaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaClienteActionPerformed(evt);
            }
        });

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
        txt_codigoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoClienteActionPerformed(evt);
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
                .addComponent(bt_pesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_nomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_pesquisaCliente)
                    .addComponent(txt_codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nomeCliente))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaCliente, label_nomeCliente, txt_codigoCliente});

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Data de Cadastro");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_dataDeCadastro.setEditable(false);
        try {
            txt_dataDeCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataDeCadastro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataDeCadastro.setFocusable(false);
        txt_dataDeCadastro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataDeCadastroFocusLost(evt);
            }
        });
        txt_dataDeCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dataDeCadastroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_dataDeCadastro)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(txt_dataDeCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Descrição do Serviço/Equipamento");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Descrição: ");

        txt_descricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_descricaoActionPerformed(evt);
            }
        });

        txt_modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_modeloActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Modelo: ");

        txt_marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_marcaActionPerformed(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Marca: ");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Série: ");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Patrimônio: ");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Número NF: ");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Acessório: ");

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Defeito: ");

        try{
            txt_numeroNF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_numeroNF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_numeroNFFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel2)
                    .addComponent(jLabel12)
                    .addComponent(jLabel4)
                    .addComponent(jLabel13)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_modelo)
                        .addComponent(txt_acessorio)
                        .addComponent(txt_serie)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(txt_patriomonio, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txt_descricao)
                        .addComponent(txt_defeito))
                    .addComponent(txt_numeroNF, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel12, jLabel13, jLabel2, jLabel22, jLabel4});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_acessorio, txt_modelo, txt_patriomonio, txt_serie});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_patriomonio, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_numeroNF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_serie, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_acessorio, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_defeito, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel12, jLabel13, jLabel2, jLabel22, jLabel4, jLabel8, txt_acessorio, txt_defeito, txt_descricao, txt_marca, txt_modelo, txt_numeroNF, txt_patriomonio, txt_serie});

        bt_incluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_incluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_incluir.setText("Incluir");
        bt_incluir.setEnabled(false);
        bt_incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_incluirActionPerformed(evt);
            }
        });

        bt_alterar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Save.png"))); // NOI18N
        bt_alterar.setText("Alterar");
        bt_alterar.setEnabled(false);
        bt_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterarActionPerformed(evt);
            }
        });

        bt_finalizarOrdemServico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_finalizarOrdemServico.setText("Finalizar OS");
        bt_finalizarOrdemServico.setEnabled(false);
        bt_finalizarOrdemServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_finalizarOrdemServicoActionPerformed(evt);
            }
        });

        bt_cancelarOrdemServico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_cancelarOrdemServico.setText("Cancelar OS");
        bt_cancelarOrdemServico.setEnabled(false);
        bt_cancelarOrdemServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarOrdemServicoActionPerformed(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Laudo Técnico");
        jLabel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_laudo.setColumns(20);
        txt_laudo.setRows(5);
        jScrollPane1.setViewportView(txt_laudo);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Status/ Situação da Ordem de Serviços");
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Aprovação: ");

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Situação: ");

        combo_Situacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_SituacaoActionPerformed(evt);
            }
        });

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Garantia: ");

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Data de Saída: ");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Observações: ");

        txt_observacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_observacoesMouseEntered(evt);
            }
        });

        combo_aprovacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        combo_aprovacao.setSelectedIndex(1);

        jLabel32.setText("Prioridade: ");

        combo_prioridade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não definido", "Alta", "Urgente" }));
        combo_prioridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_prioridadeActionPerformed(evt);
            }
        });

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("Data de Entrada: ");

        try {
            txt_horaSaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_horaSaida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_horaSaida.setText("  :  ");

        try {
            txt_horaEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_horaEntrada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_horaEntrada.setText("  :  ");

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Prevista: ");

        try {
            txt_dataEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataEntrada.setText("  /  /    ");
        txt_dataEntrada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataEntradaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataEntradaFocusLost(evt);
            }
        });

        try {
            txt_dataSaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataSaida.setText("  /  /    ");
        txt_dataSaida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataSaidaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataSaidaFocusLost(evt);
            }
        });

        try {
            txt_dataGarantia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataGarantia.setText("  /  /    ");
        txt_dataGarantia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataGarantiaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataGarantiaFocusLost(evt);
            }
        });

        try {
            txt_dataPrevista.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataPrevista.setText("  /  /    ");
        txt_dataPrevista.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataPrevistaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataPrevistaFocusLost(evt);
            }
        });

        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("Data do Pagamento:");

        try {
            txt_dataPrevista.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataFinalizou.setText("  /  /    ");
        txt_dataFinalizou.setEnabled(false);

        try {
            txt_horaFinalizou.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_horaFinalizou.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_horaFinalizou.setText("  :  ");
        txt_horaFinalizou.setEnabled(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_dataGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_dataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_dataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_dataFinalizou, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_horaFinalizou, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_horaSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_horaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_dataPrevista, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(txt_observacoes)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(combo_aprovacao, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_prioridade, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(combo_Situacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel14, jLabel26, jLabel27, jLabel28, jLabel33, jLabel36, jLabel6});

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel31, txt_horaEntrada, txt_horaFinalizou, txt_horaSaida});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(combo_Situacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_dataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_horaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_dataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_horaSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_dataGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_dataPrevista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_dataFinalizou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_horaFinalizou, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_observacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_aprovacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_prioridade, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {combo_Situacao, combo_aprovacao, combo_prioridade, jLabel14, jLabel26, jLabel27, jLabel28, jLabel31, jLabel32, jLabel33, jLabel36, jLabel6, txt_dataEntrada, txt_dataFinalizou, txt_dataGarantia, txt_dataPrevista, txt_dataSaida, txt_horaEntrada, txt_horaFinalizou, txt_horaSaida, txt_observacoes});

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Valores OS");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Mão de Obra: ");

        txt_valorMaoDeObra.setEditable(false);
        txt_valorMaoDeObra.setText("R$ 0,00");
        txt_valorMaoDeObra.setFocusable(false);

        txt_valorPecas.setEditable(false);
        txt_valorPecas.setText("R$ 0,00");
        txt_valorPecas.setFocusable(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Peças: ");

        txt_valorDeslocamento.setText("R$ 0,00");
        txt_valorDeslocamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_valorDeslocamentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorDeslocamentoFocusLost(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Deslocamento: ");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Serviços Terceiros: ");

        txt_valorTerceiros.setText("R$ 0,00");
        txt_valorTerceiros.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_valorTerceirosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorTerceirosFocusLost(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Outros: ");

        txt_valorOutros.setText("R$ 0,00");
        txt_valorOutros.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_valorOutrosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorOutrosFocusLost(evt);
            }
        });

        txt_valorAdiantamento.setText("R$ 0,00");
        txt_valorAdiantamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_valorAdiantamentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorAdiantamentoFocusLost(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Adiantamento: ");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_valorDeslocamento)
                    .addComponent(txt_valorAdiantamento, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_valorPecas, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_valorMaoDeObra, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_valorTerceiros, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(txt_valorOutros))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel20, jLabel23});

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel17, jLabel18});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel25)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel19))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(txt_valorPecas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_valorMaoDeObra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18)
                                .addComponent(txt_valorAdiantamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel17))
                        .addComponent(txt_valorDeslocamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txt_valorTerceiros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txt_valorOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel20, jLabel23, txt_valorOutros, txt_valorTerceiros});

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel17, jLabel18, txt_valorMaoDeObra, txt_valorPecas});

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel19, jLabel25, txt_valorAdiantamento, txt_valorDeslocamento});

        bt_imprimirOrdemServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/print.png"))); // NOI18N
        bt_imprimirOrdemServico.setText("Imprimir OS");
        bt_imprimirOrdemServico.setEnabled(false);
        bt_imprimirOrdemServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_imprimirOrdemServicoMouseClicked(evt);
            }
        });
        bt_imprimirOrdemServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imprimirOrdemServicoActionPerformed(evt);
            }
        });

        bt_pesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/View.png"))); // NOI18N
        bt_pesquisa.setText("Pesquisa");
        bt_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaActionPerformed(evt);
            }
        });

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Detalhes");
        jLabel30.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_detalhesOrdemServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Tipo", "Descrição", "Valor Unitário", "Quantidade", "Valor Total", "Técnico/Usuário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tabela_detalhesOrdemServico.getTableHeader().setReorderingAllowed(false);
        tabela_detalhesOrdemServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_detalhesOrdemServicoMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabela_detalhesOrdemServico);
        if (tabela_detalhesOrdemServico.getColumnModel().getColumnCount() > 0) {
            tabela_detalhesOrdemServico.getColumnModel().getColumn(0).setResizable(false);
            tabela_detalhesOrdemServico.getColumnModel().getColumn(0).setPreferredWidth(60);
            tabela_detalhesOrdemServico.getColumnModel().getColumn(1).setResizable(false);
            tabela_detalhesOrdemServico.getColumnModel().getColumn(1).setPreferredWidth(80);
            tabela_detalhesOrdemServico.getColumnModel().getColumn(2).setResizable(false);
            tabela_detalhesOrdemServico.getColumnModel().getColumn(2).setPreferredWidth(300);
            tabela_detalhesOrdemServico.getColumnModel().getColumn(3).setResizable(false);
            tabela_detalhesOrdemServico.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabela_detalhesOrdemServico.getColumnModel().getColumn(4).setResizable(false);
            tabela_detalhesOrdemServico.getColumnModel().getColumn(5).setResizable(false);
            tabela_detalhesOrdemServico.getColumnModel().getColumn(6).setResizable(false);
            tabela_detalhesOrdemServico.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        bt_incluirItem.setText("Incluir");
        bt_incluirItem.setEnabled(false);
        bt_incluirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_incluirItemActionPerformed(evt);
            }
        });

        bt_excluirItem.setText("Excluir");
        bt_excluirItem.setEnabled(false);
        bt_excluirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluirItemActionPerformed(evt);
            }
        });

        bt_alterarItem.setText("Alterar");
        bt_alterarItem.setEnabled(false);
        bt_alterarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterarItemActionPerformed(evt);
            }
        });

        bt_detalhesItem.setText("Detalhes");
        bt_detalhesItem.setEnabled(false);
        bt_detalhesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_detalhesItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(bt_incluirItem, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_alterarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_excluirItem, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_detalhesItem)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_alterarItem, bt_excluirItem, bt_incluirItem});

        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_excluirItem)
                        .addComponent(bt_detalhesItem))
                    .addComponent(bt_alterarItem)
                    .addComponent(bt_incluirItem, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_alterarItem, bt_detalhesItem, bt_excluirItem, bt_incluirItem});

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_codigoUsuarioDigitou.setEditable(false);
        try {
            txt_codigoUsuarioDigitou.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoUsuarioDigitou.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoUsuarioDigitou.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoUsuarioDigitouFocusLost(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Digitado por:");

        txt_codigoUsuarioFinalizou.setEditable(false);
        try {
            txt_codigoUsuarioFinalizou.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoUsuarioFinalizou.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Finalizada por:");

        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel38.setText("Cancelada por:");

        txt_codigoUsuarioCancelou.setEditable(false);
        try {
            txt_codigoUsuarioCancelou.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoUsuarioCancelou.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel38)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_codigoUsuarioDigitou, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(txt_codigoUsuarioFinalizou, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(txt_codigoUsuarioCancelou))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(label_nomeUsuarioFinalizou, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                        .addComponent(label_nomeUsuarioDigitou, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(label_nomeUsuarioCancelou))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel24, jLabel38, jLabel9});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {label_nomeUsuarioCancelou, label_nomeUsuarioDigitou, label_nomeUsuarioFinalizou});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_codigoUsuarioDigitou, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nomeUsuarioDigitou, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_codigoUsuarioFinalizou, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nomeUsuarioFinalizou, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txt_codigoUsuarioCancelou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nomeUsuarioCancelou))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel24, jLabel38, jLabel9, label_nomeUsuarioCancelou, label_nomeUsuarioDigitou, label_nomeUsuarioFinalizou, txt_codigoUsuarioDigitou, txt_codigoUsuarioFinalizou});

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("CPF ou CNPJ");
        jLabel35.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_cpfcnpj1.setEditable(false);
        try{
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

        try {
            txt_cpfcnpj2.setEditable(false);
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

        try{
            txt_cpfcnpj3.setEditable(false);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cpfcnpj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cpfcnpj2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cpfcnpj3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        label_alteracao.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_alteracao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_alteracao, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
        );

        bt_imprimirCupom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/print.png"))); // NOI18N
        bt_imprimirCupom.setText("Imprimir Cupom");
        bt_imprimirCupom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imprimirCupomActionPerformed(evt);
            }
        });

        bt_email.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Mail.png"))); // NOI18N
        bt_email.setText("E-mail");
        bt_email.setEnabled(false);
        bt_email.setFocusable(false);
        bt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_emailActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        jMenu2.setText("Cadastros");

        jMenuItem1.setText("Cadastros de Situações");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenu1.add(jMenu2);

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_finalizarOrdemServico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_cancelarOrdemServico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_pesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_imprimirCupom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_imprimirOrdemServico, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_alterar, bt_incluir});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel4, jPanel8});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_imprimirCupom, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_finalizarOrdemServico)
                    .addComponent(bt_cancelarOrdemServico)
                    .addComponent(bt_imprimirOrdemServico, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(bt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel1, jPanel2, jPanel3});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel5, jPanel7});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_alterar, bt_cancelarOrdemServico, bt_email, bt_finalizarOrdemServico, bt_imprimirCupom, bt_imprimirOrdemServico, bt_incluir, bt_pesquisa});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel10, jPanel4});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel12, jPanel8});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_dataDeCadastroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataDeCadastroFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dataDeCadastroFocusLost

    private void txt_dataDeCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dataDeCadastroActionPerformed
        
    }//GEN-LAST:event_txt_dataDeCadastroActionPerformed

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        sql = "insert into tb_os (idEmpresa, codigoGrupo, codigoEmpresa, codigoOrdemServico, codigoCliente, codigoUsuario, dataCadastro, horaCadastro, dataEntrada, horaEntrada, dataSaida, horaSaida, dataGarantia, dataPrevista, codigoSituacao, valorAdiantamento, valorMaoDeObra, valorPecas, valorTerceiros, valorOutros, valorDeslocamento, descricao, marca, modelo, serie, patrimonio, numeroNF, acessorio, defeito, observacoes, laudo, prioridade, statusOs, aprovacao, pagamento) "
            + "values (" + bos.idEmpresa + ", " + bos.codigoGrupo + ", " + bos.codigoEmpresa + ", " + bos.codigoOrdemServico + ", '" + bos.codigoCliente+ "', '" + parametrosNS.bu.codigoUsuario + "', '" + bos.dataCadastro + "', '" + bos.horaCadastro + "', " + bos.dataEntrada + ", " + bos.horaEntrada + ", " + bos.dataSaida + ", " + bos.horaSaida + ", " + bos.dataGarantia + ", " + bos.dataPrevista + ", '" + bos.codigoSituacao + "', '" + bos.valorAdiantamento + "', '" + bos.valorMaoDeObra + "', '" + bos.valorPecas + "', '" + bos.valorTerceiros + "', '" + bos.valorOutros + "', '" + bos.valorDeslocamento + "', '" + bos.descricao + "', '" + bos.marca + "', '" + bos.modelo + "', '" + bos.serie + "', '" + bos.patrimonio + "', '" + bos.numeroNF + "', '" + bos.acessorio + "', '" + bos.defeito + "', '" + bos.observacoes + "', '" + bos.laudo + "', '" + bos.prioridade + "', '" + bos.statusOs + "', '" + bos.aprovacao + "', '" + bos.pagamento + "');";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        if(OrdSerIteCad != null)if(OrdSerIteCad.isVisible()){
            OrdSerIteCad.setState(JFrame.NORMAL);
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        bt_incluirItem.setEnabled(true);
        abriuItemOrdemServico = 1;
        parametros.clear();
        parametros.add("N");
        parametros.add("I");
        parametros.add(bos.codigoOrdemServico);
        parametros.add(0);
        OrdSerIteCad = new OrdemServicoItemCadastro(parametros);
        OrdSerIteCad.setVisible(true);
    }//GEN-LAST:event_bt_incluirActionPerformed
    
    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        sql = "update tb_os set codigoCliente = "                   + bos.codigoCliente         + ", " +
                               "dataEntrada = "                     + bos.dataEntrada           + ", " +
                               "horaEntrada = "                     + bos.horaEntrada           + ", " +
                               "dataSaida = "                       + bos.dataSaida             + ", " +
                               "horaSaida = "                       + bos.horaSaida             + ", " +
                               "dataGarantia = "                    + bos.dataGarantia          + ", " +
                               "dataPrevista = "                    + bos.dataPrevista          + ", " +
                               "codigoSituacao = "                  + bos.codigoSituacao        + ", " +
                               "valorAdiantamento = "               + bos.valorAdiantamento     + ", " +
                               "valorDeslocamento = "               + bos.valorDeslocamento     + ", " +
                               "valorPecas = "                      + bos.valorPecas            + ", " +
                               "valorMaoDeObra = "                  + bos.valorMaoDeObra        + ", " +
                               "valorTerceiros = "                  + bos.valorTerceiros        + ", " +
                               "valorOutros = "                     + bos.valorOutros           + ", " +
                               "descricao = '"                      + bos.descricao             + "', " +
                               "patrimonio = '"                     + bos.patrimonio            + "', " +
                               "marca = '"                          + bos.marca                 + "', " +
                               "modelo = '"                         + bos.modelo                + "', " +
                               "numeroNF= "                         + bos.numeroNF              + ", " +
                               "serie = '"                          + bos.serie                 + "', " +
                               "acessorio = '"                      + bos.acessorio             + "', " +
                               "defeito = '"                        + bos.defeito               + "', " +
                               "observacoes = '"                    + bos.observacoes           + "', " +
                               "laudo = '"                          + bos.laudo                 + "', " +
                               "prioridade = "                      + bos.prioridade            + ", " +
                               "statusOs = "                        + bos.statusOs              + ", " +
                               "aprovacao = "                       + bos.aprovacao             + ", " +
                               "pagamento = "                       + bos.pagamento             + ", " +
                               "idEmpresaAlterou = "                + bos.idEmpresaAlterou      + ", " +
                               "codigoGrupoAlterou = "              + bos.codigoGrupoAlterou    + ", " +
                               "codigoEmpresaAlterou = "            + bos.codigoEmpresaAlterou  + ", " +
                               "dataAlterou = '"                    + bos.dataAlterou           + "', " +
                               "horaAlterou = '"                    + bos.horaAlterou           + "', " +
                               "usuarioAlterou = "                  + bos.usuarioAlterou        + " "  +
                               "where idOrdemServico = "    + bos.idOrdemServico    + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        mensagem = "Ordem de serviço n°" + bos.codigoOrdemServico + " alterada com êxito!";
        mostraMensagem();
        txt_codigoOrdemServico.grabFocus();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void txt_codigoClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteFocusLost
        if(txt_codigoCliente.isEnabled() == false)
            return;
        if(txt_codigoCliente.getText().replace(" ", "").equals(""))
            return;
        PegaCliente();
    }//GEN-LAST:event_txt_codigoClienteFocusLost

    private void txt_codigoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoClienteActionPerformed

    private void txt_descricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_descricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descricaoActionPerformed

    private void combo_SituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_SituacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_SituacaoActionPerformed

    private void txt_marcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_marcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_marcaActionPerformed

    private void txt_modeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_modeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_modeloActionPerformed

    private void bt_incluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirItemActionPerformed
        if(OrdSerIteCad != null)if(OrdSerIteCad.isVisible()){
            OrdSerIteCad.setState(JFrame.NORMAL);
            return;
        }
        abriuItemOrdemServico = 1;
        parametros.clear();
        parametros.add("N");
        parametros.add("I");
        parametros.add(bos.codigoOrdemServico);
        parametros.add(0);
        OrdSerIteCad = new OrdemServicoItemCadastro(parametros);
        OrdSerIteCad.setVisible(true);
    }//GEN-LAST:event_bt_incluirItemActionPerformed

    private void txt_codigoUsuarioDigitouFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoUsuarioDigitouFocusLost
        
    }//GEN-LAST:event_txt_codigoUsuarioDigitouFocusLost

    private void txt_codigoOrdemServicoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoOrdemServicoFocusLost
        if(txt_codigoOrdemServico.isEditable() == false)
            return;
        if(txt_codigoOrdemServico.getText().replace(" ", "").equals(""))
            return;
        bos.codigoOrdemServico = Integer.parseInt(txt_codigoOrdemServico.getText().replace(" ", ""));
        if(bos.codigoOrdemServico == 0)
            return;
        sql = "select * from tb_os where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoOrdemServico = " + bos.codigoOrdemServico + ";";
        PegaOrdemServico();
    }//GEN-LAST:event_txt_codigoOrdemServicoFocusLost

    private void combo_prioridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_prioridadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_prioridadeActionPerformed

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

    private void txt_valorAdiantamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorAdiantamentoFocusLost
        if(!txt_valorAdiantamento.getText().equals(""))
            txt_valorAdiantamento.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorAdiantamento.getText(), 0));
    }//GEN-LAST:event_txt_valorAdiantamentoFocusLost

    private void txt_valorDeslocamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorDeslocamentoFocusLost
        if(!txt_valorDeslocamento.getText().equals(""))
            txt_valorDeslocamento.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(txt_valorDeslocamento.getText()), 0));
    }//GEN-LAST:event_txt_valorDeslocamentoFocusLost

    private void txt_valorTerceirosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorTerceirosFocusLost
        if(!txt_valorTerceiros.getText().equals(""))
            txt_valorTerceiros.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(txt_valorTerceiros.getText()), 0));
    }//GEN-LAST:event_txt_valorTerceirosFocusLost

    private void txt_valorOutrosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorOutrosFocusLost
        if(!txt_valorOutros.getText().equals(""))
            txt_valorOutros.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(txt_valorOutros.getText()), 0));
    }//GEN-LAST:event_txt_valorOutrosFocusLost

    private void txt_codigoOrdemServicoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoOrdemServicoFocusGained
        if(txt_codigoOrdemServico.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        operacao = "";
        HabilitaBotoes();
        txt_codigoOrdemServico.setText("");
        ReiniciaCampos();
        txt_dataEntrada.setText("");
        txt_horaEntrada.setText("");
    }//GEN-LAST:event_txt_codigoOrdemServicoFocusGained

    private void bt_imprimirOrdemServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimirOrdemServicoActionPerformed
        
    }//GEN-LAST:event_bt_imprimirOrdemServicoActionPerformed
    
    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        ReiniciaCampos();
        
        bos.codigoOrdemServico = parametrosNS.PegProReg.PegaProximoRegistro("tb_os", "codigoOrdemServico", "");
        txt_codigoOrdemServico.setText(parametrosNS.fc.FormataCampo(String.valueOf(bos.codigoOrdemServico), 9, 0));
        
        operacao = "I";
        HabilitaBotoes();
        txt_codigoCliente.grabFocus();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void txt_numeroNFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_numeroNFFocusLost
        txt_numeroNF.setText(parametrosNS.fc.FormataCampo(txt_numeroNF.getText(), 6, 0));
    }//GEN-LAST:event_txt_numeroNFFocusLost

    private void bt_pesquisaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaClienteActionPerformed
        if(CliCon != null)if(CliCon.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        abriuCliente = 1;
        CliCon = new ClientesConsulta("N");
        CliCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaClienteActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuCliente == 0){
            AbreItemOrdemServico();
            return;
        }
        abriuCliente = 0;
        retorno = CliCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoCliente.setText(retorno);
        PegaCliente();
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbreItemOrdemServico(){
        if(abriuItemOrdemServico == 0){
            AbreOrdemServico();
            return;
        }
        abriuItemOrdemServico = 0;
        PegaOrdemServicoItem();
    }
    
    private void AbreOrdemServico(){
        if(abriuOrdemServico == 0){
            AbreFinalizaOrdemServico();
            return;
        }
        abriuOrdemServico = 0;
        retorno = OrdSerConMan.getRetorno();
        if(retorno.equals(""))
            return;
        operacao = "A";
        bos.idOrdemServico = Integer.parseInt(retorno);
        sql = "select * from tb_os where idOrdemServico = " + bos.idOrdemServico + ";";
        PegaOrdemServico();
    }
    
    private void AbreFinalizaOrdemServico(){
        if(FinalizaOrdemServico == 0){
            AbreCancelaOrdemServico();
            return;
        }
        FinalizaOrdemServico = 0;
        sqlstate = FinalizaOS.getRetornoFinalizaOrdemServico();
        if(!sqlstate.equals("00000"))
            if(!sqlstate.equals("ok"))
                return;
        txt_codigoOrdemServico.grabFocus();
    }
    
    private void AbreCancelaOrdemServico(){
        if(CancelaOrdemServico == 0){
            AbreSituacoes();
            return;
        }
        CancelaOrdemServico = 0;
        sqlstate = OrdSerCan.getRetornoCancelaOrdemServico();
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoOrdemServico.grabFocus();
    }
    
    private void AbreSituacoes(){
        if(abriuSituacao == 0)
            return;
        abriuSituacao = 0;
        PegaSituacoes();
    }
    
    private void bt_alterarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarItemActionPerformed
        if(OrdSerIteCad != null)if(OrdSerIteCad.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        abriuItemOrdemServico = 1;
        parametros.clear();
        parametros.add("N");
        parametros.add("A");
        parametros.add(bos.codigoOrdemServico);
        parametros.add(bosi.codigoOrdemServicoItem);
        OrdSerIteCad = new OrdemServicoItemCadastro(parametros);
        OrdSerIteCad.setVisible(true);
    }//GEN-LAST:event_bt_alterarItemActionPerformed
    
    private void tabela_detalhesOrdemServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_detalhesOrdemServicoMouseClicked
        bt_detalhesItem.setEnabled(true);
        if(bos.statusOs != 0)
            return;
        linha = tabela_detalhesOrdemServico.getSelectedRow();
        if(linha < 0)
            return;
        bosi.codigoOrdemServicoItem = Integer.parseInt(String.valueOf(tabela_detalhesOrdemServico.getValueAt(linha, 0)));
        bt_alterarItem .setEnabled(true);
        bt_excluirItem .setEnabled(true);
    }//GEN-LAST:event_tabela_detalhesOrdemServicoMouseClicked

    private void bt_excluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluirItemActionPerformed
        linha = tabela_detalhesOrdemServico.getSelectedRow();
        if(linha < 0){
            mensagem = "Item não selecionado!";
            mostraMensagem();
            return;
        }
        bosi.idEmpresa          = bos.idEmpresa;
        bosi.codigoGrupo        = bos.codigoGrupo;
        bosi.codigoEmpresa      = bos.codigoEmpresa;
        bosi.codigoOrdemServico = bos.codigoOrdemServico;
        bosi.codigoOrdemServicoItem = Integer.parseInt(String.valueOf(tabela_detalhesOrdemServico.getValueAt(linha, 0)));
        if(JOptionPane.showConfirmDialog(null, "Deseja excluir o item n°" + bosi.codigoOrdemServicoItem + " da OS n°" + bos.codigoOrdemServico + "?", "", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION)
            return;
        bosi.codigoServicoProduto   = Integer.parseInt(String.valueOf(tabela_detalhesOrdemServico.getValueAt(linha, 2)).substring(0, 6));
        bosi.quantidade             = Double.parseDouble(String.valueOf(tabela_detalhesOrdemServico.getValueAt(linha, 4)));
        
        sql = "delete from tb_os_itens where idEmpresa = " + bosi.idEmpresa + " and codigoOrdemServico = " + bosi.codigoOrdemServico + " and codigoOrdemServicoItem = " + bosi.codigoOrdemServicoItem + ";";
        sqlstate = parametrosNS.dao.ExcluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        AtualizaEstoque();
        if(!sqlstate.equals("00000"))
            return;
        int codigoOrdemServicoItem = 0;
        for(int i = linha; i < tabela_detalhesOrdemServico.getRowCount(); i++){
            bosi.codigoOrdemServicoItem = Integer.parseInt(String.valueOf(tabela_detalhesOrdemServico.getValueAt(i, 0)));
            codigoOrdemServicoItem = bosi.codigoOrdemServicoItem + 1;
            sql = "update tb_os_itens set codigoOrdemServicoItem = " + bosi.codigoOrdemServicoItem + " where idEmpresa = " + bosi.idEmpresa + " and codigoOrdemServico = " + bosi.codigoOrdemServico + " and codigoOrdemServicoItem = " + codigoOrdemServicoItem + ";";
            parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        }
        PegaOrdemServicoItem();
    }//GEN-LAST:event_bt_excluirItemActionPerformed

    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        if(OrdSerConMan != null)if(OrdSerConMan.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        abriuOrdemServico = 1;
        OrdSerConMan = new OrdemServicoConsultaEManutencao("S", "N");
        OrdSerConMan.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void bt_detalhesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesItemActionPerformed
        if(OrdSerIteCad != null)if(OrdSerIteCad.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        parametros.clear();
        parametros.add("S");
        parametros.add("");
        parametros.add(bos.idOrdemServico);
        parametros.add(bosi.codigoOrdemServicoItem);
        OrdSerIteCad = new OrdemServicoItemCadastro(parametros);
        OrdSerIteCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesItemActionPerformed

    private void bt_finalizarOrdemServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_finalizarOrdemServicoActionPerformed
        if(FinalizaOS != null)if(FinalizaOS.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        FinalizaOrdemServico = 1;
        FinalizaOS = new OrdemServicoFinalizar(bos.idOrdemServico);
        FinalizaOS.setVisible(true);
    }//GEN-LAST:event_bt_finalizarOrdemServicoActionPerformed

    private void txt_dataEntradaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataEntradaFocusLost
        String Data = txt_dataEntrada.getText();
        Data = Data.replace(" ", "");
        Data = Data.replace("/", "");
        if(Data.equals(""))
            return;
        bt_incluir.setEnabled(false);
        bt_alterar.setEnabled(false);
        if(parametrosNS.ValData.ValidaData(txt_dataEntrada.getText()).equals("N"))
            return;
        HabilitaBotoes();
    }//GEN-LAST:event_txt_dataEntradaFocusLost

    private void txt_dataSaidaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataSaidaFocusLost
        String Data = txt_dataSaida.getText();
        Data = Data.replace(" ", "");
        Data = Data.replace("/", "");
        if(Data.equals(""))
            return;
        bt_incluir.setEnabled(false);
        bt_alterar.setEnabled(false);
        if(parametrosNS.ValData.ValidaData(txt_dataSaida.getText()).equals("N"))
            return;
        HabilitaBotoes();
    }//GEN-LAST:event_txt_dataSaidaFocusLost

    private void txt_dataGarantiaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataGarantiaFocusLost
        String Data = txt_dataGarantia.getText();
        Data = Data.replace(" ", "");
        Data = Data.replace("/", "");
        if(Data.equals(""))
            return;
        bt_incluir.setEnabled(false);
        bt_alterar.setEnabled(false);
        if(parametrosNS.ValData.ValidaData(txt_dataGarantia.getText()).equals("N"))
            return;
        HabilitaBotoes();
    }//GEN-LAST:event_txt_dataGarantiaFocusLost

    private void txt_dataPrevistaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataPrevistaFocusLost
        String Data = txt_dataPrevista.getText();
        Data = Data.replace(" ", "");
        Data = Data.replace("/", "");
        if(Data.equals(""))
            return;
        bt_incluir.setEnabled(false);
        bt_alterar.setEnabled(false);
        if(parametrosNS.ValData.ValidaData(txt_dataPrevista.getText()).equals("N"))
            return;
        HabilitaBotoes();
    }//GEN-LAST:event_txt_dataPrevistaFocusLost

    private void txt_dataEntradaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataEntradaFocusGained
        new SelecaoDeCampo(null, txt_dataEntrada);
    }//GEN-LAST:event_txt_dataEntradaFocusGained

    private void txt_dataSaidaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataSaidaFocusGained
        new SelecaoDeCampo(null, txt_dataSaida);
    }//GEN-LAST:event_txt_dataSaidaFocusGained

    private void txt_dataGarantiaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataGarantiaFocusGained
        new SelecaoDeCampo(null, txt_dataGarantia);
    }//GEN-LAST:event_txt_dataGarantiaFocusGained

    private void txt_dataPrevistaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataPrevistaFocusGained
        new SelecaoDeCampo(null, txt_dataPrevista);
    }//GEN-LAST:event_txt_dataPrevistaFocusGained

    private void bt_cancelarOrdemServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarOrdemServicoActionPerformed
        if(OrdSerCan != null)if(OrdSerCan.isVisible()){
            mensagem = "Tela já Aberta!";
            mostraMensagem();
            return;
        }
        CancelaOrdemServico = 1;
        OrdSerCan = new OrdemServicoCancelar(bos.idOrdemServico);
        OrdSerCan.setVisible(true);
    }//GEN-LAST:event_bt_cancelarOrdemServicoActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Table = (DefaultTableModel)tabela_detalhesOrdemServico.getModel();
        
        PegaSituacoes();
        PegaParametrosProducao();
//        PegaParametros();
        
        bt_detalhesItem.setVisible(false);
        if(bos.idOrdemServico != 0){
            txt_codigoOrdemServico  .setEditable (false);
            txt_codigoOrdemServico  .setFocusable(false);
            bt_novo                 .setEnabled  (false);
            sql = "select * from tb_os where idOrdemServico = " + bos.idOrdemServico + ";";
            operacao = "A";
            PegaOrdemServico();
        }
        if(somostra.equals("S")){
            txt_codigoOrdemServico  .setEditable(false);
            bt_novo                 .setEnabled (false);
            bt_pesquisa             .setVisible (false);
            DesabilitaAcoes();
        }
        if(somostra.equals("SN")){
            bt_pesquisa             .setVisible (false);
        }
        if(bos.codigoOrdemServico != 0){
            VerificaSeEstaFinalizada();
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(OrdSerIteCad    != null)OrdSerIteCad.dispose();
        if(CliCon          != null)CliCon      .dispose();
        if(OrdSerConMan    != null)OrdSerConMan.dispose();
        if(FinalizaOS      != null)FinalizaOS  .dispose();
        if(OrdSerCan       != null)OrdSerCan   .dispose();
    }//GEN-LAST:event_formWindowClosed

    private void bt_imprimirCupomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimirCupomActionPerformed
        jpv = "Relatorios/CupomOrdemServico.jasper";
        ImprimeCupom();
    }//GEN-LAST:event_bt_imprimirCupomActionPerformed

    private void bt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_emailActionPerformed
        if(EmaMon != null)if(EmaMon.isVisible()){
            mensagem = "Tela já Aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        parametros.clear();
        parametros.add(Integer.parseInt(txt_codigoCliente.getText()));
        EmaMon = new EmailMontagem(parametros);
        EmaMon.setVisible(true);
    }//GEN-LAST:event_bt_emailActionPerformed

    private void txt_valorAdiantamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorAdiantamentoFocusGained
        if(!txt_valorAdiantamento.getText().equals(""))
            txt_valorAdiantamento.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorAdiantamento.getText(), 1));
        txt_valorAdiantamento.setSelectionStart(0);
        txt_valorAdiantamento.setSelectionEnd  (txt_valorAdiantamento.getText().length());
    }//GEN-LAST:event_txt_valorAdiantamentoFocusGained

    private void txt_valorTerceirosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorTerceirosFocusGained
        if(!txt_valorTerceiros.getText().equals(""))
            txt_valorTerceiros.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorTerceiros.getText(), 1));
        txt_valorTerceiros.setSelectionStart(0);
        txt_valorTerceiros.setSelectionEnd  (txt_valorTerceiros.getText().length());
    }//GEN-LAST:event_txt_valorTerceirosFocusGained

    private void txt_valorDeslocamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorDeslocamentoFocusGained
        if(!txt_valorDeslocamento.getText().equals(""))
            txt_valorDeslocamento.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorDeslocamento.getText(), 1));
        txt_valorDeslocamento.setSelectionStart(0);
        txt_valorDeslocamento.setSelectionEnd  (txt_valorDeslocamento.getText().length());
    }//GEN-LAST:event_txt_valorDeslocamentoFocusGained

    private void txt_valorOutrosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorOutrosFocusGained
        if(!txt_valorOutros.getText().equals(""))
            txt_valorOutros.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorOutros.getText(), 1));
        txt_valorOutros.setSelectionStart(0);
        txt_valorOutros.setSelectionEnd  (txt_valorOutros.getText().length());
    }//GEN-LAST:event_txt_valorOutrosFocusGained

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(SitCad != null)
            if(SitCad.isVisible()){
                SitCad.setState(JFrame.NORMAL);
                return;
            }
        abriuSituacao = 1;
        AbrirCadastroSituacoes();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void bt_imprimirOrdemServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_imprimirOrdemServicoMouseClicked
        MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_bt_imprimirOrdemServicoMouseClicked

    private void bt_impressaoCompletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_impressaoCompletaActionPerformed
        bos.codigoOrdemServico  = Integer.parseInt(txt_codigoOrdemServico.getText());
        try{
            img = null;
            if(parametrosNS.be.ImagemLogotipoEmpresa != null){
                buffImg = ImageIO.read(new ByteArrayInputStream(parametrosNS.be.ImagemLogotipoEmpresa));
                imgIcon = new ImageIcon(buffImg);
                img     = imgIcon.getImage();
            }
            hm.clear();
            hm.put("idEmpresa"         , parametrosNS.be.IdEmpresa);
            hm.put("nomeEmpresa"       , parametrosNS.be.NomeEmpresa);
            hm.put("cnpjEmpresa"       , parametrosNS.be.CnpjEmpresa.substring(1));
            hm.put("cidadeEmpresa"     , parametrosNS.be.CidadeEmpresa + ", " + parametrosNS.be.UfEmpresa);
            hm.put("enderecoEmpresa"   , parametrosNS.be.EnderecoEmpresa + ", " + parametrosNS.be.NumeroEmpresa + ", " + parametrosNS.be.bairroEmpresa);
            hm.put("cepEmpresa"        , parametrosNS.be.CepEmpresa);
            hm.put("telefoneEmpresa"   , parametrosNS.be.TelefoneEmpresa);
            if(img != null)
                hm.put("logotipoEmpresa", img);
            else
                hm.put("logotipoEmpresa", null);
            hm.put("codigoOrdemServico", bos.codigoOrdemServico);
            hm.put("impressaoDoLaudo"  , bparpro.impressaoDoLaudo);
            hm.put("termoDeRecebimento", bparpro.termoDeRecebimento);
            
            jpv = "Relatorios/RelatorioOrdemServicoUnitario.jasper";
            
            jpp = JasperFillManager.fillReport(jpv, hm, parametrosNS.con);
            JasperViewer.viewReport(jpp, false);
        }catch(Exception erro){
            mensagem = "Erro ao imprimir: " + erro.getMessage();
            mostraMensagem();
        }
    }//GEN-LAST:event_bt_impressaoCompletaActionPerformed

    private void bt_impressaoPorViaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_impressaoPorViaActionPerformed
        bos.codigoOrdemServico  = Integer.parseInt(txt_codigoOrdemServico.getText());
        try{
            img = null;
            if(parametrosNS.be.ImagemLogotipoEmpresa != null){
                buffImg = ImageIO.read(new ByteArrayInputStream(parametrosNS.be.ImagemLogotipoEmpresa));
                imgIcon = new ImageIcon(buffImg);
                img     = imgIcon.getImage();
            }
            hm.clear();
            hm.put("idEmpresa"         , parametrosNS.be.IdEmpresa);
            hm.put("nomeEmpresa"       , parametrosNS.be.NomeEmpresa);
            hm.put("cnpjEmpresa"       , parametrosNS.be.CnpjEmpresa.substring(1));
            hm.put("cidadeEmpresa"     , parametrosNS.be.CidadeEmpresa + ", " + parametrosNS.be.UfEmpresa);
            hm.put("enderecoEmpresa"   , parametrosNS.be.EnderecoEmpresa + ", " + parametrosNS.be.NumeroEmpresa + ", " + parametrosNS.be.bairroEmpresa);
            hm.put("cepEmpresa"        , parametrosNS.be.CepEmpresa);
            hm.put("telefoneEmpresa"   , parametrosNS.be.TelefoneEmpresa);
            if(img != null)
                hm.put("logotipoEmpresa", img);
            else
                hm.put("logotipoEmpresa", null);
            hm.put("codigoOrdemServico", bos.codigoOrdemServico);
            hm.put("impressaoDoLaudo"  , bparpro.impressaoDoLaudo);
            hm.put("termoDeRecebimento", bparpro.termoDeRecebimento);
            
            jpv = "Relatorios/RelatorioOrdemServicoUnitarioPorVia2.jasper";
            
            jpp = JasperFillManager.fillReport(jpv, hm, parametrosNS.con);
            JasperViewer.viewReport(jpp, false);
        }catch(Exception erro){
            mensagem = "Erro ao imprimir: " + erro.getMessage();
            mostraMensagem();
        }
    }//GEN-LAST:event_bt_impressaoPorViaActionPerformed

    private void txt_observacoesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_observacoesMouseEntered
        txt_observacoes.setToolTipText(txt_observacoes.getText());
    }//GEN-LAST:event_txt_observacoesMouseEntered
    
    private void AbrirCadastroSituacoes(){
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        SitCad = new SituacoesCadastro(parametros);
        SitCad.setVisible(true);
    }
    
    private void ImprimeCupom() {
        try {
            jpp = null;
            
            hm.clear();
            hm.put("codigoOrdemServico", bos.codigoOrdemServico);
            
            hm.put("nomeEmpresa",       parametrosNS.be.NomeEmpresa);
            hm.put("enderecoEmpresa",   parametrosNS.be.EnderecoEmpresa + ", " + parametrosNS.be.NumeroEmpresa);
            hm.put("cepEmpresa",        parametrosNS.be.CepEmpresa);
            hm.put("cidadeEmpresa",     parametrosNS.be.CidadeEmpresa + ", " + parametrosNS.be.UfEmpresa);
            hm.put("bairroEmpresa",     parametrosNS.be.BairroEmpresa);
            //hm.put("logotipoEmpresa",   parametrosNS.bge.PastaImagemLogotipo + "/LOGOTIPO." + parametrosNS.bge.ExtensaoImagemLogotipo);
            hm.put("telefoneEmpresa",   parametrosNS.be.TelefoneEmpresa);
            hm.put("cnpjEmpresa"    ,       parametrosNS.be.CnpjEmpresa);
            
            hm.put("usuarioSistema", parametrosNS.bu.usuario);
            hm.put("terminal",       parametrosNS.bcomp.nomeComputador);

            try{
                jpp = JasperFillManager.fillReport(jpv, hm, parametrosNS.con);
            }catch(Exception e){
                mensagem = "visualizar solicitar relatorios " + e + jpv;
                mostraMensagem();
                mensagem = e.getMessage();
                mostraMensagem();
            }
            JasperViewer.viewReport(jpp, false);
            //dispose();

        } catch (Exception e) {
            mensagem = "O erro foi no solicitar relatorios: " + e + jpv;
            mostraMensagem();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_alterarItem;
    private javax.swing.JButton bt_cancelarOrdemServico;
    private javax.swing.JButton bt_detalhesItem;
    private javax.swing.JButton bt_email;
    private javax.swing.JButton bt_excluirItem;
    private javax.swing.JButton bt_finalizarOrdemServico;
    private javax.swing.JMenuItem bt_impressaoCompleta;
    private javax.swing.JMenuItem bt_impressaoPorVia;
    private javax.swing.JButton bt_imprimirCupom;
    private javax.swing.JButton bt_imprimirOrdemServico;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_incluirItem;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisa;
    private javax.swing.JButton bt_pesquisaCliente;
    private javax.swing.JMenuItem bt_sair;
    private javax.swing.JComboBox<String> combo_Situacao;
    private javax.swing.JComboBox<String> combo_aprovacao;
    private javax.swing.JComboBox<String> combo_prioridade;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel label_alteracao;
    private javax.swing.JLabel label_nomeCliente;
    private javax.swing.JLabel label_nomeUsuarioCancelou;
    private javax.swing.JLabel label_nomeUsuarioDigitou;
    private javax.swing.JLabel label_nomeUsuarioFinalizou;
    private javax.swing.JTable tabela_detalhesOrdemServico;
    private javax.swing.JTextField txt_acessorio;
    private javax.swing.JFormattedTextField txt_codigoCliente;
    private javax.swing.JFormattedTextField txt_codigoOrdemServico;
    private javax.swing.JFormattedTextField txt_codigoUsuarioCancelou;
    private javax.swing.JFormattedTextField txt_codigoUsuarioDigitou;
    private javax.swing.JFormattedTextField txt_codigoUsuarioFinalizou;
    private javax.swing.JFormattedTextField txt_cpfcnpj1;
    private javax.swing.JFormattedTextField txt_cpfcnpj2;
    private javax.swing.JFormattedTextField txt_cpfcnpj3;
    private javax.swing.JFormattedTextField txt_dataDeCadastro;
    private javax.swing.JFormattedTextField txt_dataEntrada;
    private javax.swing.JFormattedTextField txt_dataFinalizou;
    private javax.swing.JFormattedTextField txt_dataGarantia;
    private javax.swing.JFormattedTextField txt_dataPrevista;
    private javax.swing.JFormattedTextField txt_dataSaida;
    private javax.swing.JTextField txt_defeito;
    private javax.swing.JTextField txt_descricao;
    private javax.swing.JFormattedTextField txt_horaEntrada;
    private javax.swing.JFormattedTextField txt_horaFinalizou;
    private javax.swing.JFormattedTextField txt_horaSaida;
    private javax.swing.JTextArea txt_laudo;
    private javax.swing.JTextField txt_marca;
    private javax.swing.JTextField txt_modelo;
    private javax.swing.JFormattedTextField txt_numeroNF;
    private javax.swing.JTextField txt_observacoes;
    private javax.swing.JTextField txt_patriomonio;
    private javax.swing.JTextField txt_serie;
    private javax.swing.JTextField txt_valorAdiantamento;
    private javax.swing.JTextField txt_valorDeslocamento;
    private javax.swing.JTextField txt_valorMaoDeObra;
    private javax.swing.JTextField txt_valorOutros;
    private javax.swing.JTextField txt_valorPecas;
    private javax.swing.JTextField txt_valorTerceiros;
    // End of variables declaration//GEN-END:variables
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    private void PegaSituacoes(){
        combo_Situacao.removeAllItems();
        combo_Situacao.addItem("----------");
        sql = "select * from tb_situacoes where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosSituacoes.clear();
        dadosSituacoes = parametrosNS.dao.Consulta(sql);
        if(dadosSituacoes.isEmpty()){
            if(JOptionPane.showConfirmDialog(null, "Não foram encontradas situações cadastradas! Deseja cadastrar?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
                return;
            dispose();
            AbrirCadastroSituacoes();
            return;
        }
        PegaDadosSituacoes();
    }
    
    private void PegaDadosSituacoes(){
        for(int i = 0; i < dadosSituacoes.size(); i++){
            bsit.idSituacao         = Integer.parseInt(  String.valueOf(dadosSituacoes.get(i).get(0)));
            bsit.idEmpresa          = Integer.parseInt(  String.valueOf(dadosSituacoes.get(i).get(1)));
            bsit.codigoGrupo        = Integer.parseInt(  String.valueOf(dadosSituacoes.get(i).get(2)));
            bsit.codigoEmpresa      = Integer.parseInt(  String.valueOf(dadosSituacoes.get(i).get(3)));
            bsit.codigoSituacao     = Integer.parseInt(  String.valueOf(dadosSituacoes.get(i).get(4)));
            bsit.descricaoSituacao  =                    String.valueOf(dadosSituacoes.get(i).get(5));
            
            combo_Situacao.addItem(bsit.descricaoSituacao);
        }
    }
    
    private void PegaOrdemServico(){
        fatal = "N";
        dadosOrdemServico.clear();
        dadosOrdemServico = parametrosNS.dao.Consulta(sql);
        if(dadosOrdemServico.isEmpty()){
            mensagem = "Ordem de Serviço " + bos.codigoOrdemServico + " não encontrada!\nPara incluir pressione Novo!";
            mostraMensagem();
            fatal = "S";
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        PegaDadosOrdemServico();
    }
    
    private void PegaDadosOrdemServico(){
        for(int i = 0; i < dadosOrdemServico.size(); i++){
            bos     = new BeanOrdemServico();
            if(dadosOrdemServico.get(i).get(0)  != null){bos.idOrdemServico                 = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(0)));}
            if(dadosOrdemServico.get(i).get(1)  != null){bos.idEmpresa                      = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(1)));}
            if(dadosOrdemServico.get(i).get(2)  != null){bos.codigoGrupo                    = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(2)));}
            if(dadosOrdemServico.get(i).get(3)  != null){bos.codigoEmpresa                  = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(3)));}
            if(dadosOrdemServico.get(i).get(4)  != null){bos.codigoOrdemServico             = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(4)));}
            if(dadosOrdemServico.get(i).get(5)  != null){bos.codigoCliente                  = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(5)));}
            if(dadosOrdemServico.get(i).get(6)  != null){bos.codigoUsuario                  = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(6)));}
            if(dadosOrdemServico.get(i).get(7)  != null){bos.dataCadastro                   =                    String.valueOf(dadosOrdemServico.get(i).get(7));}
            if(dadosOrdemServico.get(i).get(8)  != null){bos.dataEntrada                    =                    String.valueOf(dadosOrdemServico.get(i).get(8));}
            if(dadosOrdemServico.get(i).get(9)  != null){bos.horaEntrada                    =                    String.valueOf(dadosOrdemServico.get(i).get(9));}
            if(dadosOrdemServico.get(i).get(10) != null){bos.dataSaida                      =                    String.valueOf(dadosOrdemServico.get(i).get(10));}
            if(dadosOrdemServico.get(i).get(11) != null){bos.horaSaida                      =                    String.valueOf(dadosOrdemServico.get(i).get(11));}
            if(dadosOrdemServico.get(i).get(12) != null){bos.dataGarantia                   =                    String.valueOf(dadosOrdemServico.get(i).get(12));}
            if(dadosOrdemServico.get(i).get(13) != null){bos.dataPrevista                   =                    String.valueOf(dadosOrdemServico.get(i).get(13));}
            if(dadosOrdemServico.get(i).get(14) != null){bos.codigoSituacao                 = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(14)));}
            if(dadosOrdemServico.get(i).get(15) != null){bos.valorAdiantamento              = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(15)));}
            if(dadosOrdemServico.get(i).get(16) != null){bos.valorDeslocamento              = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(16)));}
            if(dadosOrdemServico.get(i).get(17) != null){bos.valorPecas                     = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(17)));}
            if(dadosOrdemServico.get(i).get(18) != null){bos.valorMaoDeObra                 = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(18)));}
            if(dadosOrdemServico.get(i).get(19) != null){bos.valorTerceiros                 = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(19)));}
            if(dadosOrdemServico.get(i).get(20) != null){bos.valorOutros                    = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(20)));}
            if(dadosOrdemServico.get(i).get(21) != null){bos.descricao                      =                    String.valueOf(dadosOrdemServico.get(i).get(21));}
            if(dadosOrdemServico.get(i).get(22) != null){bos.marca                          =                    String.valueOf(dadosOrdemServico.get(i).get(22));}
            if(dadosOrdemServico.get(i).get(23) != null){bos.modelo                         =                    String.valueOf(dadosOrdemServico.get(i).get(23));}
            if(dadosOrdemServico.get(i).get(24) != null){bos.serie                          =                    String.valueOf(dadosOrdemServico.get(i).get(24));}
            if(dadosOrdemServico.get(i).get(25) != null){bos.patrimonio                     =                    String.valueOf(dadosOrdemServico.get(i).get(25));}
            if(dadosOrdemServico.get(i).get(26) != null){bos.numeroNF                       = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(26)));}
            if(dadosOrdemServico.get(i).get(27) != null){bos.acessorio                      =                    String.valueOf(dadosOrdemServico.get(i).get(27));}
            if(dadosOrdemServico.get(i).get(28) != null){bos.defeito                        =                    String.valueOf(dadosOrdemServico.get(i).get(28));}
            if(dadosOrdemServico.get(i).get(29) != null){bos.observacoes                    =                    String.valueOf(dadosOrdemServico.get(i).get(29));}
            if(dadosOrdemServico.get(i).get(30) != null){bos.laudo                          =                    String.valueOf(dadosOrdemServico.get(i).get(30));}
            if(dadosOrdemServico.get(i).get(31) != null){bos.prioridade                     = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(31)));}
            if(dadosOrdemServico.get(i).get(32) != null){bos.statusOs                       = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(32)));}
            if(dadosOrdemServico.get(i).get(33) != null){bos.aprovacao                      = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(33)));}
            if(dadosOrdemServico.get(i).get(34) != null){bos.pagamento                      = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(34)));}
            if(dadosOrdemServico.get(i).get(35) != null){bos.dataAlterou                    =                    String.valueOf(dadosOrdemServico.get(i).get(35));}
            if(dadosOrdemServico.get(i).get(36) != null){bos.horaAlterou                    =                    String.valueOf(dadosOrdemServico.get(i).get(36));}
            if(dadosOrdemServico.get(i).get(37) != null){bos.usuarioAlterou                 = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(37)));}
            if(dadosOrdemServico.get(i).get(38) != null){bos.idEmpresaAlterou               = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(38)));}
            if(dadosOrdemServico.get(i).get(39) != null){bos.codigoGrupoAlterou             = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(39)));}
            if(dadosOrdemServico.get(i).get(40) != null){bos.codigoEmpresaAlterou           = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(40)));}
            if(dadosOrdemServico.get(i).get(41) != null){bos.horaCadastro                   =                    String.valueOf(dadosOrdemServico.get(i).get(41));}
            if(dadosOrdemServico.get(i).get(42) != null){bos.detalhesCancelamento           =                    String.valueOf(dadosOrdemServico.get(i).get(42));}
            if(dadosOrdemServico.get(i).get(43) != null){bos.detalhesCancelamento           =                    String.valueOf(dadosOrdemServico.get(i).get(43));}
            if(dadosOrdemServico.get(i).get(44) != null){bos.dataCancelou                   =                    String.valueOf(dadosOrdemServico.get(i).get(44));}
            if(dadosOrdemServico.get(i).get(45) != null){bos.horaCancelou                   =                    String.valueOf(dadosOrdemServico.get(i).get(45));}
            if(dadosOrdemServico.get(i).get(46) != null){bos.usuarioCancelou                = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(46)));}
            if(dadosOrdemServico.get(i).get(47) != null){bos.idEmpresaCancelou              = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(47)));}
            if(dadosOrdemServico.get(i).get(48) != null){bos.computadorCancelou             = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(48)));}
            if(dadosOrdemServico.get(i).get(49) != null){bos.dataFinalizou                  =                    String.valueOf(dadosOrdemServico.get(i).get(49));}
            if(dadosOrdemServico.get(i).get(50) != null){bos.horaFinalizou                  =                    String.valueOf(dadosOrdemServico.get(i).get(50));}
            if(dadosOrdemServico.get(i).get(51) != null){bos.usuarioFinalizou               = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(51)));}
            if(dadosOrdemServico.get(i).get(52) != null){bos.idEmpresaFinalizou             = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(52)));}
            if(dadosOrdemServico.get(i).get(53) != null){bos.computadorFinalizou            = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(53)));}
            if(dadosOrdemServico.get(i).get(54) != null){bos.codigoCancelamentoSemSolucao   = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(54)));}
            if(dadosOrdemServico.get(i).get(55) != null){bos.detalhesCancelamentoSemSolucao =                    String.valueOf(dadosOrdemServico.get(i).get(55));}
            if(dadosOrdemServico.get(i).get(56) != null){bos.dataSemSolucao                 =                    String.valueOf(dadosOrdemServico.get(i).get(56));}
            if(dadosOrdemServico.get(i).get(57) != null){bos.horaSemSolucao                 =                    String.valueOf(dadosOrdemServico.get(i).get(57));}
            if(dadosOrdemServico.get(i).get(58) != null){bos.usuarioSemSolucao              = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(58)));}
            if(dadosOrdemServico.get(i).get(59) != null){bos.idEmpresaSemSolucao            = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(59)));}
            if(dadosOrdemServico.get(i).get(60) != null){bos.computadorSemSolucao           = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(60)));}
        }
        txt_codigoOrdemServico.setText(parametrosNS.fc.FormataCampo(String.valueOf(bos.codigoOrdemServico), 9, 0));
        
        bc.codigoCliente    = bos.codigoCliente;
        txt_codigoCliente.setText(String.valueOf(bc.codigoCliente));
        PegaCliente();
        
        bu.codigoUsuario = bos.codigoUsuario;
        txt_codigoUsuarioDigitou.setText(parametrosNS.fc.FormataCampo(String.valueOf(bu.codigoUsuario), 3, 0));
        PegaUsuario("N");
        label_nomeUsuarioDigitou.setText(bu.usuario);
        
        if(bos.statusOs == 2)
            if(bos.usuarioFinalizou != 0){
                bu.usuario      = "NS3";
                if(bos.usuarioFinalizou != 999){
                    bu.idEmpresa     = bos.idEmpresaFinalizou;
                    bu.codigoUsuario = bos.usuarioFinalizou;
                    txt_codigoUsuarioFinalizou.setText(parametrosNS.fc.FormataCampo(String.valueOf(bu.codigoUsuario), 3, 0));
                    PegaUsuario("S");
                }
                label_nomeUsuarioFinalizou.setText(bu.usuario);
            }
        
        if(bos.statusOs == 2)
            if(bos.usuarioFinalizou == 0){
                if(bos.usuarioSemSolucao != 0){
                    bu.usuario      = "NS3";
                    if(bos.usuarioSemSolucao != 999){
                        bu.idEmpresa     = bos.idEmpresaSemSolucao;
                        bu.codigoUsuario = bos.usuarioSemSolucao;
                        txt_codigoUsuarioFinalizou.setText(parametrosNS.fc.FormataCampo(String.valueOf(bu.codigoUsuario), 3, 0));
                        PegaUsuario("N");
                    }
                    label_nomeUsuarioFinalizou.setText(bu.usuario);
                }
            }
        
        if(bos.statusOs == 1)
            if(bos.usuarioCancelou != 0){
                bu.usuario      = "NS3";
                if(bos.usuarioCancelou != 999){
                    bu.idEmpresa     = bos.idEmpresaCancelou;
                    bu.codigoUsuario = bos.usuarioCancelou;
                    txt_codigoUsuarioCancelou.setText(parametrosNS.fc.FormataCampo(String.valueOf(bu.codigoUsuario), 3, 0));
                    PegaUsuario("S");
                }
                label_nomeUsuarioCancelou.setText(bu.usuario);
            }
        
        txt_dataDeCadastro.setText(parametrosNS.invdata.inverterData(bos.dataCadastro, 1));
        combo_Situacao.setSelectedIndex(bos.codigoSituacao);
        
        if(bos.dataEntrada    != null){
            bos.dataEntrada     = parametrosNS.invdata.inverterData(bos.dataEntrada, 1);
            txt_dataEntrada     .setText(bos.dataEntrada);
            txt_horaEntrada     .setText(bos.horaEntrada);
        }
        if(bos.dataSaida      != null){
            bos.dataSaida       = parametrosNS.invdata.inverterData(bos.dataSaida, 1);
            txt_dataSaida       .setText(bos.dataEntrada);
            txt_horaSaida       .setText(bos.horaSaida);
        }else{
            txt_dataSaida.setText(parametrosNS.cdh.CapturarData());
            txt_horaSaida.setText(parametrosNS.cdh.CapturaHora().substring(0, 5));
        }
        if(bos.dataGarantia   != null){
            bos.dataGarantia    = parametrosNS.invdata.inverterData(bos.dataGarantia, 1);
            txt_dataGarantia    .setText(bos.dataGarantia);
        }
        if(bos.dataPrevista   != null){
            bos.dataPrevista    = parametrosNS.invdata.inverterData(bos.dataPrevista, 1);
            txt_dataPrevista    .setText(bos.dataPrevista);
        }
        if(bos.dataFinalizou != null && !bos.dataFinalizou.equals("")){
            bos.dataFinalizou  = parametrosNS.invdata.inverterData(bos.dataFinalizou, 1);
            txt_dataFinalizou   .setText(bos.dataFinalizou);
            txt_horaFinalizou   .setText(bos.horaFinalizou);
        }else{
            if(bos.dataSemSolucao != null && !bos.dataSemSolucao.equals("")){
                bos.dataSemSolucao = parametrosNS.invdata.inverterData(bos.dataSemSolucao, 1);
                txt_dataFinalizou.setText(bos.dataSemSolucao);
                txt_horaFinalizou.setText(bos.horaSemSolucao);
            }
        }
        
        txt_observacoes .setText(bos.observacoes);
        combo_aprovacao.setSelectedIndex(bos.aprovacao);
        combo_prioridade.setSelectedIndex(bos.prioridade);
        
        txt_descricao.setText(bos.descricao);
        txt_patriomonio.setText(bos.patrimonio);
        txt_marca.setText(bos.marca);
        txt_modelo.setText(bos.modelo);
        txt_numeroNF.setText(parametrosNS.fc.FormataCampo(String.valueOf(bos.numeroNF), 6, 0));
        txt_serie.setText(bos.serie);
        txt_acessorio.setText(bos.acessorio);
        txt_defeito.setText(bos.defeito);
        
        txt_laudo.setText(bos.laudo);
        
        txt_valorAdiantamento.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bos.valorAdiantamento), 0));
        txt_valorDeslocamento.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bos.valorDeslocamento), 0));
        txt_valorPecas       .setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bos.valorPecas)       , 0));
        txt_valorMaoDeObra   .setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bos.valorMaoDeObra)   , 0));
        txt_valorTerceiros   .setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bos.valorTerceiros)   , 0));
        txt_valorOutros      .setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bos.valorOutros)      , 0));
        
        if(bos.usuarioAlterou != 0){
            bu.usuario      = "NS3";
            bos.dataAlterou = parametrosNS.invdata.inverterData(bos.dataAlterou, 1);
            if(parametrosNS.bu.codigoUsuario != 999){
                bu.idEmpresa        = bos.idEmpresaAlterou;
                bu.codigoGrupo      = bos.codigoGrupoAlterou;
                bu.codigoEmpresa    = bos.codigoEmpresaAlterou;
                bu.codigoUsuario    = bos.usuarioAlterou;
                PegaUsuario("S");
            }
            label_alteracao.setText("Última alteração feita em " + bos.dataAlterou + " às " + bos.horaAlterou + " por " + bu.usuario);
        }
        
        PegaOrdemServicoItem();
        VerificaSeEstaFinalizada();
    }
    
    private void PegaOrdemServicoItem(){
        Table.setNumRows(0);
        bosi.idEmpresa          = bos.idEmpresa;
        bosi.codigoGrupo        = bos.codigoGrupo;
        bosi.codigoEmpresa      = bos.codigoEmpresa;
        bosi.codigoOrdemServico = bos.codigoOrdemServico;
        sql = "select \n"
            + "   idOrdemServicoItem, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoOrdemServico, \n"
            + "   codigoOrdemServicoItem, \n"
            + "   codigoUsuario, \n"
            + "   valorUnitario, \n"
            + "   quantidade, \n"
            + "   valorTotal, \n"
            + "   codigoServico, \n"
            + "   codigoProduto \n"
            + "from \n"
            + "   tb_os_itens where idEmpresa = " + bosi.idEmpresa + " and codigoOrdemServico = " + bosi.codigoOrdemServico + " and codigoOrdemServico = " + bosi.codigoOrdemServico + ";";
        dadosOrdemServicoItens.clear();
        dadosOrdemServicoItens = parametrosNS.dao.Consulta(sql);
        if(dadosOrdemServicoItens.isEmpty()){
            mensagem = "Não foram encontrados itens para a OS N°" + bos.codigoOrdemServico + "!";
            mostraMensagem();
            return;
        }
        PegaDadosOrdemServicoItem();
    }
    
    private void PegaDadosOrdemServicoItem(){
        bos.valorPecas      = 0;
        bos.valorMaoDeObra  = 0;
        for(int i = 0; i < dadosOrdemServicoItens.size(); i++){
            tipoItem = "";
            bosi = new BeanOrdemServicoItens();
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
                bosi.codigoUsuario          = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(6)));
            }
            if(dadosOrdemServicoItens.get(i).get(7) != null){
                bosi.valorUnitario          = Double.parseDouble(String.valueOf(dadosOrdemServicoItens.get(i).get(7)));
            }
            if(dadosOrdemServicoItens.get(i).get(8) != null){
                bosi.quantidade             = Double.parseDouble(String.valueOf(dadosOrdemServicoItens.get(i).get(8)));
            }
            if(dadosOrdemServicoItens.get(i).get(9) != null){
                bosi.valorTotal             = Double.parseDouble(String.valueOf(dadosOrdemServicoItens.get(i).get(9)));
            }
            if(dadosOrdemServicoItens.get(i).get(10) != null){
                bosi.codigoServico          = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(10)));
            }
            if(dadosOrdemServicoItens.get(i).get(11) != null){
                bosi.codigoProduto          = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(11)));
            }
        
            if(bosi.codigoProduto != 0){
                tipoItem = "Produto";
                bp.codigoProduto    = bosi.codigoProduto;
                PegaProdutos();
                bos.valorPecas      = bos.valorPecas + bosi.valorTotal;
                descricaoItem = parametrosNS.fc.FormataCampo(String.valueOf(bosi.codigoProduto), 6, 0) + "-" + bp.descricaoProduto;
            }
            if(bosi.codigoServico != 0){
                tipoItem = "Serviço";
                bser.codigoServico  = bosi.codigoServico;
                PegaServicos();
                bos.valorMaoDeObra  = bos.valorMaoDeObra + bosi.valorTotal;
                descricaoItem = parametrosNS.fc.FormataCampo(String.valueOf(bosi.codigoServico), 6, 0) + "-" + bser.descricaoServico;
            }
            bu.codigoUsuario = bosi.codigoUsuario;
            PegaUsuario("N");
            
            Table.addRow(new Object [] {parametrosNS.fc.FormataCampo(String.valueOf(bosi.codigoOrdemServicoItem), 2, 0), tipoItem, descricaoItem, parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bosi.valorUnitario), 0), String.valueOf(bosi.quantidade), parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bosi.valorTotal), 0), parametrosNS.fc.FormataCampo(String.valueOf(bu.codigoUsuario), 3, 0) + "-" + bu.usuario});
        }
        bt_imprimirOrdemServico.setEnabled(true);
        txt_valorMaoDeObra.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bos.valorMaoDeObra)  , 0));
        txt_valorPecas    .setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bos.valorPecas)      , 0));
    }
    
    private void VerificaSeEstaFinalizada(){
        if(bos.statusOs == 1){
            operacao = "";
            HabilitaBotoes();
            mensagem = "Ordem de Serviço n°" + bos.codigoOrdemServico + " está Cancelada!";
            mostraMensagem();
            return;
        }
        if(bos.statusOs == 2){
            operacao = "";
            HabilitaBotoes();
            mensagem = "Ordem de Serviço n°" + bos.codigoOrdemServico + " está Finalizada!";
            mostraMensagem();
            return;
        }
        if(bos.statusOs == 3){
            operacao = "";
            HabilitaBotoes();
            mensagem = "Ordem de Serviço n°" + bos.codigoOrdemServico + " está Finalizada sem Solução!";
            mostraMensagem();
            return;
        }
        if(bos.statusOs == 4){
            operacao = "";
            HabilitaBotoes();
            mensagem = "Ordem de Serviço n°" + bos.codigoOrdemServico + " está Faturada!";
            mostraMensagem();
            return;
        }
        int diasRestantes = 0;
        diasRestantes = parametrosNS.Test.Testa(bos.dataPrevista) - parametrosNS.Test.Testa(parametrosNS.cdh.CapturarData());
        if(!bos.dataPrevista.equals("")){
            if(diasRestantes < 1){
                return;
            }
            if(diasRestantes < 10){
                mensagem = "Restam " + diasRestantes + " para passar a data prevista da OS!";
                mostraMensagem();
                return;
            }
        }
    }
    
    private void PegaProdutos(){
        sql = "select \n"
            + "   idProdutos, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoProduto, \n"
            + "   descricaoProduto, \n"
            + "   valorDeCompra, \n"
            + "   valorDeVenda, \n"
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
            fatal = "S";
            return;
        }
        PegaDadosProdutos();
    }
    
    private void PegaDadosProdutos(){
        for (int i = 0; i < dadosProdutos.size(); i++) {
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
                bp.descricaoProduto         =                    String.valueOf(dadosProdutos.get(i).get(5));
            if(dadosProdutos.get(i).get(6) != null)
                bp.valorDeCompra            = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(6)));
            if(dadosProdutos.get(i).get(7) != null)
                bp.valorDeVenda             = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(7)));
            if(dadosProdutos.get(i).get(8) != null)
                bp.quantidadeMinima         = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(8)));
            if(dadosProdutos.get(i).get(9) != null)
                bp.quantidadeIdeal          = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(9)));
            if(dadosProdutos.get(i).get(10) != null)
                bp.quantidadeAtual          = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(10)));
        }
    }
    
    private void PegaServicos(){
        sql = "select * from tb_servicos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoServico = " + bser.codigoServico + ";";
        dadosServicos.clear();
        dadosServicos = parametrosNS.dao.Consulta(sql);
        if(dadosServicos.isEmpty()){
            mensagem = "Serviço código " + bser.codigoServico + " não encontrado!";
            mostraMensagem();
            fatal = "S";
            return;
        }
        PegaDadosServicos();
    }
    
    private void PegaDadosServicos(){
        for(int i = 0; i < dadosServicos.size(); i++){
            if(dadosServicos.get(i).get(0) != null)
                bser.idServico          = Integer.parseInt(  String.valueOf(dadosServicos.get(i).get(0)));
            if(dadosServicos.get(i).get(1) != null)
                bser.idEmpresa          = Integer.parseInt(  String.valueOf(dadosServicos.get(i).get(1)));
            if(dadosServicos.get(i).get(2) != null)
                bser.codigoGrupo        = Integer.parseInt(  String.valueOf(dadosServicos.get(i).get(2)));
            if(dadosServicos.get(i).get(3) != null)
                bser.codigoEmpresa      = Integer.parseInt(  String.valueOf(dadosServicos.get(i).get(3)));
            if(dadosServicos.get(i).get(4) != null)
                bser.codigoServico      = Integer.parseInt(  String.valueOf(dadosServicos.get(i).get(4)));
                bser.descricaoServico   =                    String.valueOf(dadosServicos.get(i).get(5));
            if(dadosServicos.get(i).get(6) != null)
                bser.valorServico       = Double.parseDouble(String.valueOf(dadosServicos.get(i).get(6)));
        }
    }
    
    private void PegaCliente(){
        fatal = "N";
        txt_codigoCliente.setText(parametrosNS.fc.FormataCampo(txt_codigoCliente.getText(), 5, 0));
        bc.codigoCliente = Integer.parseInt(txt_codigoCliente.getText());
        if(bc.codigoCliente == 0){
            fatal = "S";
            return;
        }
        sql = "select idCliente, idEmpresa, codigoGrupo, codigoEmpresa, codigoCliente, nome, cpfCnpj, cep, cidade, endereco, numero, bairro, uf from tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCliente = '" + bc.codigoCliente + "';";
        dadosCliente.clear();
        dadosCliente = parametrosNS.dao.Consulta(sql);
        if(dadosCliente.isEmpty()){
            mensagem = "Cliente " + bc.codigoCliente + " não encontrado!";
            mostraMensagem();
            fatal = "S";
            bt_incluir.setEnabled(false);
            bt_alterar.setEnabled(false);
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
            bc.nome                 =                    String.valueOf(dadosCliente.get(i).get(5));
            bc.cpfCnpj              =                    String.valueOf(dadosCliente.get(i).get(6));
            bc.cep                  =                    String.valueOf(dadosCliente.get(i).get(7));
            bc.cidade               =                    String.valueOf(dadosCliente.get(i).get(8));
            bc.endereco             =                    String.valueOf(dadosCliente.get(i).get(9));
            bc.numero               =                    String.valueOf(dadosCliente.get(i).get(10));
            bc.bairro               =                    String.valueOf(dadosCliente.get(i).get(11));
            bc.uf                   =                    String.valueOf(dadosCliente.get(i).get(12));
            
        }
        label_nomeCliente.setText(bc.nome);
        bc.cpfCnpj = parametrosNS.FCampoCpfCnpj.FormataCampoCpfCnpj(bc.cpfCnpj);
        txt_cpfcnpj1.setText(bc.cpfCnpj.substring(0 , 9));
        txt_cpfcnpj2.setText(bc.cpfCnpj.substring(9 ,13));
        txt_cpfcnpj3.setText(bc.cpfCnpj.substring(13,15));
    }
    
    private void PegaUsuario(String Alterou){
        bu.usuario = "----------";
        if(bu.codigoUsuario == 0)
            return;
        sql = "select usuario from tb_usuarios where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
        if(Alterou.equals("S"))
            sql = "select usuario from tb_usuarios where idEmpresa = " + bu.idEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
        dadosUsuario.clear();
        dadosUsuario = parametrosNS.dao.Consulta(sql);
        if(dadosUsuario.isEmpty()){
            mensagem = "Usuário " + bu.codigoUsuario + " não encontrado!";
            mostraMensagem();
            return;
        }
        PegaDadosUsuarios();
    }
    
    private void PegaDadosUsuarios(){
        for(int i = 0; i < dadosUsuario.size(); i++){
            bu.usuario = String.valueOf(dadosUsuario.get(i).get(0));
        }
    }
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_incluir              .setEnabled(true);
            bt_alterar              .setEnabled(false);
            bt_incluirItem          .setEnabled(false);
            bt_alterarItem          .setEnabled(false);
            bt_excluirItem          .setEnabled(false);
            bt_finalizarOrdemServico.setEnabled(false);
            bt_cancelarOrdemServico .setEnabled(false);
            return;
        }
        if(operacao.equals("A")){
            bt_incluir              .setEnabled(false);
            bt_alterar              .setEnabled(true);
            bt_incluirItem          .setEnabled(true);
            bt_alterarItem          .setEnabled(false);
            bt_excluirItem          .setEnabled(false);
            bt_finalizarOrdemServico.setEnabled(true);
            bt_cancelarOrdemServico .setEnabled(true);
            return;
        }
        bt_incluir                  .setEnabled(false);
        bt_alterar                  .setEnabled(false);
        bt_incluirItem              .setEnabled(false);
        bt_alterarItem              .setEnabled(false);
        bt_excluirItem              .setEnabled(false);
        bt_finalizarOrdemServico    .setEnabled(false);
        bt_cancelarOrdemServico     .setEnabled(false);
    }
    
    private void ReiniciaCampos(){
        txt_codigoCliente           .setText("");
        label_nomeCliente           .setText("");
        txt_cpfcnpj1                .setText("");
        txt_cpfcnpj2                .setText("");
        txt_cpfcnpj3                .setText("");
        txt_dataEntrada             .setText(parametrosNS.cdh.CapturarData());
        txt_horaEntrada             .setText(parametrosNS.cdh.CapturaHora().substring(0, 5));
        
        txt_codigoUsuarioDigitou    .setText("");
        label_nomeUsuarioDigitou    .setText("");
        txt_codigoUsuarioFinalizou  .setText("");
        label_nomeUsuarioFinalizou  .setText("");
        txt_codigoUsuarioCancelou   .setText("");
        label_nomeUsuarioCancelou   .setText("");
        
        txt_dataDeCadastro          .setText(parametrosNS.cdh.CapturarData());
        combo_Situacao              .setSelectedIndex(0);
        txt_dataSaida               .setText("");
        txt_horaSaida               .setText("");
        txt_dataGarantia            .setText("");
        txt_dataPrevista            .setText("");
        txt_dataFinalizou           .setText("");
        txt_horaFinalizou           .setText("");
        txt_observacoes             .setText("");
        combo_aprovacao             .setSelectedIndex(0);
        combo_prioridade            .setSelectedIndex(0);
        txt_descricao               .setText("");
        txt_patriomonio             .setText("");
        txt_marca                   .setText("");
        txt_modelo                  .setText("");
        txt_numeroNF                .setText("");
        txt_serie                   .setText("");
        txt_acessorio               .setText("");
        txt_defeito                 .setText("");
        txt_laudo                   .setText("");
        Table.setNumRows(0);
        txt_valorAdiantamento       .setText("");
        txt_valorDeslocamento       .setText("");
        txt_valorPecas              .setText("");
        txt_valorMaoDeObra          .setText("");
        txt_valorTerceiros          .setText("");
        txt_valorOutros             .setText("");
        bt_imprimirOrdemServico     .setEnabled(false);
    }
    
    private void PegaValores(){
        fatal = "N";
        bos.idEmpresa           = parametrosNS.be.IdEmpresa;
        bos.codigoGrupo         = parametrosNS.bge.CodigoGrupo;
        bos.codigoEmpresa       = parametrosNS.be.CodigoEmpresa;
        bos.codigoOrdemServico  = Integer.parseInt(txt_codigoOrdemServico.getText());
        if(txt_codigoCliente.getText().replace(" ", "").equals("")){
            mensagem = "Cliente inválido!";
            mostraMensagem();
            fatal = "S";
            return;
        }
        bos.codigoCliente   = Integer.parseInt(txt_codigoCliente.getText());
        bos.codigoUsuario   = User;
        bos.dataCadastro    = parametrosNS.invdata.inverterData(parametrosNS.cdh.CapturarData(), 2);
        bos.horaCadastro    = parametrosNS.cdh.CapturaHora();
        bos.codigoSituacao  = combo_Situacao.getSelectedIndex();
        
        bos.dataEntrada     = txt_dataEntrada.getText();
        bos.dataEntrada     = bos.dataEntrada.replace(" ", "");
        bos.dataEntrada     = bos.dataEntrada.replace("/", "");
        if(!bos.dataEntrada.equals("")){
            bos.dataEntrada = "'" + parametrosNS.invdata.inverterData(bos.dataEntrada, 2) + "'";
        }else{
            bos.dataEntrada = null;
        }
        
        bos.horaEntrada     = txt_horaEntrada.getText();
        bos.horaEntrada     = bos.horaEntrada.replace(" ", "");
        bos.horaEntrada     = bos.horaEntrada.replace(":", "");
        if(!bos.horaEntrada.equals("")){
            bos.horaEntrada = "'" + txt_horaEntrada.getText() + "'";
        }else{
            bos.horaEntrada = null;
        }
        
        bos.dataSaida       = txt_dataSaida.getText();
        bos.dataSaida       = bos.dataSaida.replace(" ", "");
        bos.dataSaida       = bos.dataSaida.replace("/", "");
        if(!bos.dataSaida.equals("")){
            bos.dataSaida   = "'" + parametrosNS.invdata.inverterData(bos.dataSaida, 2) + "'";
        }else{
            bos.dataSaida   = null;
        }
        
        bos.horaSaida       = txt_horaSaida.getText();
        bos.horaSaida       = bos.horaSaida.replace(" ", "");
        bos.horaSaida       = bos.horaSaida.replace(":", "");
        if(!bos.horaSaida.equals("")){
            bos.horaSaida   = "'" + txt_horaSaida.getText() + "'";
        }else{
            bos.horaSaida   = null;
        }
        
        bos.dataGarantia    = txt_dataGarantia.getText();
        bos.dataGarantia    = bos.dataGarantia.replace(" ", "");
        bos.dataGarantia    = bos.dataGarantia.replace("/", "");
        if(!bos.dataGarantia.equals("")){
            bos.dataGarantia= "'" + parametrosNS.invdata.inverterData(bos.dataGarantia, 2) + "'";
        }else{
            bos.dataGarantia= null;
        }
        
        bos.dataPrevista    = txt_dataPrevista.getText();
        bos.dataPrevista    = bos.dataPrevista.replace(" ", "");
        bos.dataPrevista    = bos.dataPrevista.replace("/", "");
        if(!bos.dataPrevista.equals("")){
            bos.dataPrevista= "'" + parametrosNS.invdata.inverterData(bos.dataPrevista, 2) + "'";
        }else{
            bos.dataPrevista= null;
        }
        
        bos.observacoes     = txt_observacoes.getText();
        bos.aprovacao       = combo_aprovacao.getSelectedIndex();
        bos.prioridade      = combo_prioridade.getSelectedIndex();
        bos.descricao       = txt_descricao.getText();
        bos.patrimonio      = txt_patriomonio.getText();
        bos.marca           = txt_marca.getText();
        bos.modelo          = txt_modelo.getText();
        if(!txt_numeroNF.getText().replace(" ", "").equals("")){
            bos.numeroNF    = Integer.parseInt(txt_numeroNF.getText());
        }
        bos.serie           = txt_serie.getText();
        bos.acessorio       = txt_acessorio.getText();
        bos.defeito         = txt_defeito.getText();
        bos.laudo           = txt_laudo.getText();
        if(!txt_valorAdiantamento.getText().equals("")){
            bos.valorAdiantamento   = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorAdiantamento.getText(), 1));
        }
        if(!txt_valorDeslocamento.getText().equals("")){
            bos.valorDeslocamento   = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorDeslocamento.getText(), 1));
        }
        if(!txt_valorPecas.getText().equals("")){
            bos.valorPecas          = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorPecas.getText()       , 1));
        }
        if(!txt_valorMaoDeObra.getText().equals("")){
            bos.valorMaoDeObra      = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorMaoDeObra.getText()   , 1));
        }
        if(!txt_valorTerceiros.getText().equals("")){
            bos.valorTerceiros      = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorTerceiros.getText()   , 1));
        }
        if(!txt_valorOutros.getText().equals("")){
            bos.valorOutros         = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorOutros.getText()      , 1));
        }
        
        bos.idEmpresaAlterou        = parametrosNS.be.idEmpresa;
        bos.codigoGrupoAlterou      = parametrosNS.be.codigoGrupo;
        bos.codigoEmpresaAlterou    = parametrosNS.be.codigoEmpresa;
        bos.dataAlterou             = parametrosNS.invdata.inverterData(parametrosNS.cdh.CapturarData(), 2);
        bos.horaAlterou             = parametrosNS.cdh.CapturaHora();
        bos.usuarioAlterou          = parametrosNS.bu.codigoUsuario;
    }
    
    private void AtualizaEstoque(){
        if(bosi.tipo != 1)
            return;
        bp.codigoProduto = bosi.codigoServicoProduto;
        PegaProdutos();
        
        bp.quantidadeAtual = bp.quantidadeAtual + bosi.quantidade;
        
        sql = "update tb_produtos set quantidadeAtual = " + bp.quantidadeAtual + " where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoProduto = " + bp.codigoProduto + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(sqlstate.equals("00000"))
            return;
        mensagem = "Erro ao atualizar estoque do produto " + bp.codigoProduto + "!";
        mostraMensagem();
    }
    
}
