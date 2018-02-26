package MenusPrincipais;

import Telas.MenuPrincipal;
import Beans.*;
import FuncoesInternas.*;
import TelasEstoque.ProdutosConsulta;
import TelasProducao.*;
import java.util.*;
import javax.swing.*;
import FuncoesInternas.InverterData;
import Parametros.parametrosNS;
import TelasFaturamento.ClientesCadastro;
import TelasFaturamento.ClientesConsulta;
import Parametros.ParametrosProducao;
import Telas.CancelamentosCadastro;
import Telas.CancelamentosConsulta;
import TelasContasCorrente.BoletosConsulta;
import TelasContasCorrente.ContaCorrenteCadastro;
import TelasContasCorrente.ContaCorrenteConsulta;
import TelasContasCorrente.GerarBoletoBradesco;
import TelasContasCorrente.GerarBoletoHsbc;
import TelasContasCorrente.GerarBoletoItau;
import TelasContasCorrente.GerarBoletoSantander;
import TelasContasCorrente.InstrucoesDeBoletosCadastro;
import TelasContasCorrente.InstrucoesDeBoletosConsulta;
import TelasEstoque.FabricanteCadastro;
import TelasEstoque.FabricanteConsulta;
import TelasEstoque.FornecedorCadastro;
import TelasEstoque.FornecedorConsulta;
import TelasEstoque.GrupoProdutoCadastro;
import TelasEstoque.GrupoProdutoConsulta;
import TelasEstoque.ProdutosCadastro;
import TelasEstoque.SubGrupoProdutoCadastro;
import TelasEstoque.SubGrupoProdutoConsulta;
import TelasVendas.FormasDePagamentoCadastro;
import TelasVendas.FormasDePagamentoConsulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/*
 @author Tiago e Paulo
 */
public class MenuProducao extends javax.swing.JFrame {
    //String's
    String sql      = "";
    String sqlstate = "";
    String Mensagem = "";
    
    //int's
    int    codigoOS                 = 0;
    int    total                    = 0;
    int    abriuDataProducao        = 0;
    int    QtdTotalDeOs             = 0;
    int    QtdTotalDeOsPendentes    = 0;
    int    QtdTotalDeOsFinalizadas  = 0;
    int    QtdTotalDeOsSemSolucao   = 0;
    int    QtdTotalDeOsCanceladas   = 0;
    int    QtdTotalDeOsFaturadas    = 0;
    
    //Bean's
    BeanModulos             bm      = new BeanModulos();
    BeanOrdemServico        bos     = new BeanOrdemServico();
    BeanParametrosProducao  bparpro = new BeanParametrosProducao();
    
    //ArrayList's padroes não alterar
    ArrayList               parametros              = new ArrayList();
    ArrayList<ArrayList>    dadosOrdemServico       = new ArrayList();
    ArrayList<ArrayList>    dadosParametrosProducao = new ArrayList();
    
    //Outros
    CapturarDataHora cdh     = new CapturarDataHora();
    FormataCampo     fc      = new FormataCampo();
    InverterData     invdata = new InverterData();
    
    //Telas
    JFrame                          Frame;
    MenuPrincipal                   MenPri;
    OrdemServicoCadastro            OrdSerCad;
    SituacoesCadastro               SitCad;
    SituacoesConsulta               SitCon;
    ClientesCadastro                CliCad;
    ClientesConsulta                CliCon;
    CancelamentosCadastro           CanCad;
    CancelamentosConsulta           CanCon;
    ServicoCadastro                 SerCad;
    ServicoConsulta                 SerCon;
    FornecedorCadastro              ForCad;
    FornecedorConsulta              ForCon;
    FabricanteCadastro              FabCad;
    FabricanteConsulta              FabCon;
    GrupoProdutoCadastro            GruProCad;
    GrupoProdutoConsulta            GruProCon;
    SubGrupoProdutoCadastro         SubGruProCad;
    SubGrupoProdutoConsulta         SubGruProCon;
    ProdutosCadastro                ProCad;
    ProdutosConsulta                ProCon;
    FormasDePagamentoCadastro       ForDePagCad;
    FormasDePagamentoConsulta       ForDePagCon;
    ContaCorrenteCadastro           ConCorCad;
    ContaCorrenteConsulta           ConCorCon;
    InstrucoesDeBoletosCadastro     InsBolCad;
    InstrucoesDeBoletosConsulta     InsBolCon;
    GerarBoletoBradesco             GerBolBrad;
    GerarBoletoHsbc                 GerBolHsbc;
    GerarBoletoItau                 GerBolItau;
    GerarBoletoSantander            GerBolSant;
    BoletosConsulta                 BolCon;
    OrdemServicoConsultaEManutencao OrdSerConEMan;
    RelatorioOrdensServicoGeral     RelOrdSerGer;
    ParametrosProducao              ParPro;
    SelecionarDataDoSistemaProducao SelDatDoSisPro;
    
    //Timer
    Timer                           Tempo;
    
    public MenuProducao(JFrame frame){
        initComponents();
        Frame       = frame;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    private void CarregarAbas(){
        bm.abasProducao     = parametrosNS.bm.abasProducao;
        bm.abaConsultas     = bm.abasProducao.substring(0, 1);
        bm.abaArquivo       = bm.abasProducao.substring(1, 2);
        bm.abaMovimentos    = bm.abasProducao.substring(2, 3);
        bm.abaRelatorios    = bm.abasProducao.substring(3, 4);
        bm.abaParametros    = bm.abasProducao.substring(4, 5);
        bm.abaEspeciais     = bm.abasProducao.substring(5, 6);
        VerificaAbas();
    }
    
    private void VerificaAbas(){
        if(bm.abaConsultas .equals("0"))bt_consultas .setVisible(false);
        if(bm.abaArquivo   .equals("0"))bt_arquivos  .setVisible(false);
        if(bm.abaMovimentos.equals("0"))bt_movimentos.setVisible(false);
        if(bm.abaRelatorios.equals("0"))bt_relatorios.setVisible(false);
        if(bm.abaParametros.equals("0"))bt_parametros.setVisible(false);
        if(bm.abaEspeciais .equals("0"))bt_especiais .setVisible(false);
    }
    
    private void PegaParametrosProducao(){
        sql = "select \n"
            + "   idParametrosProducao, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   dataProducao \n"
            + " from tb_parametrosproducao where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosParametrosProducao.clear();
        dadosParametrosProducao = parametrosNS.dao.Consulta(sql);
        if(dadosParametrosProducao.isEmpty()){
            bparpro.dataProducao    = cdh.CapturarData();
            txt_dataProducao.setText(bparpro.dataProducao);
            return;
        }
        PegaDadosParametrosContabil();
    }
    
    private void PegaDadosParametrosContabil(){
        for(int i = 0; i < dadosParametrosProducao.size(); i++){
            bparpro = new BeanParametrosProducao();
            if(dadosParametrosProducao.get(i).get(0) != null)
                bparpro.idParametrosProducao    = Integer.parseInt(  String.valueOf(dadosParametrosProducao.get(i).get(0)));
            if(dadosParametrosProducao.get(i).get(1) != null)
                bparpro.idEmpresa               = Integer.parseInt(  String.valueOf(dadosParametrosProducao.get(i).get(1)));
            if(dadosParametrosProducao.get(i).get(2) != null)
                bparpro.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosParametrosProducao.get(i).get(2)));
            if(dadosParametrosProducao.get(i).get(3) != null)
                bparpro.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosParametrosProducao.get(i).get(3)));
            if(dadosParametrosProducao.get(i).get(4) != null)
                bparpro.dataProducao            =                    String.valueOf(dadosParametrosProducao.get(i).get(4));
        }
        if(!bparpro.dataProducao.equals(""))
            bparpro.dataProducao = invdata.inverterData(bparpro.dataProducao, 1);
        if(bparpro.dataProducao.equals(""))
            bparpro.dataProducao = cdh.CapturarData();
        txt_dataProducao        .setText(bparpro.dataProducao);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_rodape = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_os_cadastradas = new javax.swing.JTextField();
        txt_os_finalizadas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_os_semSolucao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_os_pendentes = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_os_canceladas = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        txt_os_faturadas = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_dataProducao = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        bt_consultas = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenuItem34 = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem32 = new javax.swing.JMenuItem();
        bt_arquivos = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem33 = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        jMenuItem35 = new javax.swing.JMenuItem();
        bt_movimentos = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenu6 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem29 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem31 = new javax.swing.JMenuItem();
        bt_relatorios = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        bt_parametros = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();
        bt_especiais = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_rodape.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_rodape.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_rodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txt_rodape, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/logo-top.png"))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Total de OS Cadastradas: ");

        txt_os_cadastradas.setEditable(false);
        txt_os_cadastradas.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_os_finalizadas.setEditable(false);
        txt_os_finalizadas.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 204, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Total de OS Finalizadas: ");

        txt_os_semSolucao.setEditable(false);
        txt_os_semSolucao.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Total de OS Sem Solução: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Total de OS Pendentes: ");

        txt_os_pendentes.setEditable(false);
        txt_os_pendentes.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 114, 86));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Total de OS Canceladas: ");

        txt_os_canceladas.setEditable(false);
        txt_os_canceladas.setBackground(new java.awt.Color(255, 204, 204));
        txt_os_canceladas.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField6.setEditable(false);
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Total de Serviços em Operação: ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Total de OS Faturadas: ");

        txt_os_faturadas.setEditable(false);
        txt_os_faturadas.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_os_cadastradas)
                            .addComponent(txt_os_semSolucao)
                            .addComponent(txt_os_finalizadas)
                            .addComponent(txt_os_pendentes)
                            .addComponent(txt_os_canceladas, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(txt_os_faturadas))))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_os_cadastradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_os_pendentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_os_canceladas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_os_finalizadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_os_semSolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_os_faturadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(127, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jTextField6, txt_os_cadastradas, txt_os_canceladas, txt_os_finalizadas, txt_os_pendentes, txt_os_semSolucao});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel9, txt_os_faturadas});

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mudar [F11]");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Data Produção");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
        );

        txt_dataProducao.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txt_dataProducao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_dataProducao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_dataProducao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bt_consultas.setBackground(new java.awt.Color(255, 255, 255));
        bt_consultas.setText("Consultas");

        jMenuItem3.setText("Ordem de serviço");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        bt_consultas.add(jMenuItem3);

        jMenuItem9.setText("Situações de OS");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        bt_consultas.add(jMenuItem9);
        bt_consultas.add(jSeparator5);

        jMenu2.setText("Consultar");

        jMenuItem8.setText("Clientes");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuItem18.setText("Motivos de cancelamento");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem18);
        jMenu2.add(jSeparator4);

        jMenuItem6.setText("Serviços");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem15.setText("Fornecedores");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem15);

        jMenuItem16.setText("Fabricantes");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem16);

        jMenu5.setText("Grupos e sub-grupos de produtos");

        jMenuItem21.setText("Grupos de produtos");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem21);

        jMenuItem22.setText("Sub-grupos de produtos");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem22);

        jMenu2.add(jMenu5);

        jMenuItem4.setText("Produtos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);
        jMenu2.add(jSeparator7);

        jMenuItem34.setText("Formas de pagamento");
        jMenuItem34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem34ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem34);
        jMenu2.add(jSeparator11);

        jMenuItem26.setText("Conta corrente");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem26);

        jMenuItem27.setText("Instruções de boletos");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem27);
        jMenu2.add(jSeparator9);

        jMenuItem32.setText("Boletos");
        jMenuItem32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem32ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem32);

        bt_consultas.add(jMenu2);

        jMenuBar1.add(bt_consultas);

        bt_arquivos.setBackground(new java.awt.Color(255, 255, 255));
        bt_arquivos.setText("Arquivos");

        jMenuItem2.setText("Ordens de serviço");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        bt_arquivos.add(jMenuItem2);

        jMenuItem1.setText("Situações de OS");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        bt_arquivos.add(jMenuItem1);
        bt_arquivos.add(jSeparator2);

        jMenu1.setText("Cadastrar");

        jMenuItem11.setText("Clientes");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

        jMenuItem17.setText("Motivos de cancelamento");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem17);
        jMenu1.add(jSeparator3);

        jMenuItem7.setText("Serviços");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem12.setText("Fornecedores");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem12);

        jMenuItem14.setText("Fabricantes");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem14);

        jMenu3.setText("Grupos e sub-grupos de produtos");

        jMenuItem19.setText("Grupos de produtos");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem19);

        jMenuItem20.setText("Sub-grupos de produtos");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem20);

        jMenu1.add(jMenu3);

        jMenuItem13.setText("Produtos");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem13);
        jMenu1.add(jSeparator6);

        jMenuItem33.setText("Formas de pagamento");
        jMenuItem33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem33ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem33);
        jMenu1.add(jSeparator10);

        jMenuItem24.setText("Conta corrente");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem24);

        jMenuItem25.setText("Instruções de boletos");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem25);

        bt_arquivos.add(jMenu1);
        bt_arquivos.add(jSeparator12);

        jMenuItem35.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        jMenuItem35.setText("Mudar data Produção");
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        bt_arquivos.add(jMenuItem35);

        jMenuBar1.add(bt_arquivos);

        bt_movimentos.setBackground(new java.awt.Color(255, 255, 255));
        bt_movimentos.setText("Movimentos");

        jMenuItem10.setText("Manutenção OS");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        bt_movimentos.add(jMenuItem10);
        bt_movimentos.add(jSeparator8);

        jMenu6.setText("Boleto (Gerar)");

        jMenu4.setText("Itaú");

        jMenuItem28.setText("Cobrança 109 (Sem registro)");
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem28);

        jMenu6.add(jMenu4);

        jMenu7.setText("HSBC");

        jMenuItem29.setText("HSBC Cobrança");
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem29);

        jMenu6.add(jMenu7);

        jMenu8.setText("Santander");

        jMenuItem30.setText("Santander Cobrança");
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem30);

        jMenu6.add(jMenu8);

        jMenu9.setText("Bradesco");

        jMenuItem31.setText("Bradesco Cobrança");
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem31);

        jMenu6.add(jMenu9);

        bt_movimentos.add(jMenu6);

        jMenuBar1.add(bt_movimentos);

        bt_relatorios.setBackground(new java.awt.Color(255, 255, 255));
        bt_relatorios.setText("Relatórios");

        jMenuItem5.setText("Relatórios de ordens de serviços (Geral)");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        bt_relatorios.add(jMenuItem5);

        jMenuBar1.add(bt_relatorios);

        bt_parametros.setBackground(new java.awt.Color(255, 255, 255));
        bt_parametros.setText("Parâmetros");

        jMenuItem23.setText("Parâmetros ");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        bt_parametros.add(jMenuItem23);

        jMenuBar1.add(bt_parametros);

        bt_especiais.setBackground(new java.awt.Color(255, 255, 255));
        bt_especiais.setText("Especiais");
        jMenuBar1.add(bt_especiais);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if(OrdSerCad != null)if(OrdSerCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        OrdSerCad = new OrdemServicoCadastro("N", 0);
        OrdSerCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if(OrdSerConEMan != null)if(OrdSerConEMan.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        OrdSerConEMan = new OrdemServicoConsultaEManutencao("N", "N");
        OrdSerConEMan.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        if(SerCon != null)if(SerCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        SerCon = new ServicoConsulta(parametros);
        SerCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if(ProCon != null)if(ProCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add("Codigo");
        ProCon = new ProdutosConsulta(parametros);
        ProCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(SitCad != null)if(SitCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        SitCad = new SituacoesCadastro(parametros);
        SitCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        if(SitCon != null)if(SitCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        SitCon = new SituacoesConsulta(parametros);
        SitCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        if(OrdSerConEMan != null)if(OrdSerConEMan.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        OrdSerConEMan = new OrdemServicoConsultaEManutencao("N", "S");
        OrdSerConEMan.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        CarregarAbas();
        PegaParametrosProducao();
        setTitle("Módulo de Produção: " + fc.FormataCampo(String.valueOf(parametrosNS.bge.CodigoGrupo), 2, 0) + "." + parametrosNS.bge.NomeGrupo + " - " + fc.FormataCampo(String.valueOf(parametrosNS.be.CodigoEmpresa), 3, 0) + "." + parametrosNS.be.NomeEmpresa);
        
        txt_rodape.setText("Usuario: " + parametrosNS.bu.usuario);
        
        PegaOrdemServico();
        CarregaOSs();
    }//GEN-LAST:event_formWindowOpened
    
    private void CarregaOSs(){
        ActionListener action = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                PegaOrdemServico();
            }
        };
        Tempo = new Timer(5000, action);
        Tempo.start();
    }
    
    private void Sair(){
        dispose();
        if(OrdSerCad     != null)OrdSerCad    .dispose();
        if(SitCad        != null)SitCad       .dispose();
        if(SitCon        != null)SitCon       .dispose();
        if(CliCad        != null)CliCad       .dispose();
        if(CliCon        != null)CliCon       .dispose();
        if(CanCad        != null)CanCad       .dispose();
        if(CanCon        != null)CanCon       .dispose();
        if(SerCad        != null)SerCad       .dispose();
        if(SerCon        != null)SerCon       .dispose();
        if(ProCad        != null)ProCad       .dispose();
        if(ProCon        != null)ProCon       .dispose();
        if(ForCad        != null)ForCad       .dispose();
        if(ForCon        != null)ForCon       .dispose();
        if(FabCad        != null)FabCad       .dispose();
        if(FabCon        != null)FabCon       .dispose();
        if(OrdSerConEMan != null)OrdSerConEMan.dispose();
        if(RelOrdSerGer  != null)RelOrdSerGer .dispose();
        if(ParPro        != null)ParPro       .dispose();
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){
            Frame.setVisible(false);
            MenPri = new MenuPrincipal();
            MenPri.setVisible(true);
            return;
        }
//        Frame.setVisible(true);
    }
    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Sair();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){
            dispose();
            return;
        }
        if(abriuDataProducao == 0)
            return;
        AbriuDataProducao();
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbriuDataProducao(){
        if(abriuDataProducao == 0)
            return;
        abriuDataProducao = 0;
        PegaParametrosProducao();
    }
    
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if(RelOrdSerGer != null)if(RelOrdSerGer.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        RelOrdSerGer = new RelatorioOrdensServicoGeral();
        RelOrdSerGer.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        if(CliCon != null)if(CliCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        CliCon = new ClientesConsulta("N");
        CliCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        if(CliCad != null)if(CliCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        CliCad = new ClientesCadastro("N", 0);
        CliCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if(SerCad != null)if(SerCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        SerCad = new ServicoCadastro("N", 0);
        SerCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        if(ProCad != null)if(ProCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        ProCad = new ProdutosCadastro("N", 0);
        ProCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        if(CanCad != null)if(CanCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        CanCad = new CancelamentosCadastro("N", 0);
        CanCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        if(CanCon != null)if(CanCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        CanCon = new CancelamentosConsulta("N");
        CanCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        if(ForCad != null)if(ForCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        ForCad = new FornecedorCadastro("N", 0);
        ForCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        if(ForCon != null)if(ForCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        ForCon = new FornecedorConsulta("N");
        ForCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        if(FabCad != null)if(FabCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        FabCad = new FabricanteCadastro("N", 0);
        FabCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        if(FabCon != null)if(FabCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        FabCon = new FabricanteConsulta("N");
        FabCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        if(GruProCad != null)
            if(GruProCad.isVisible()){
                GruProCad.setState(JFrame.NORMAL);
                return;
            }
        GruProCad = new GrupoProdutoCadastro("N", 0);
        GruProCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        if(GruProCon != null)
            if(GruProCon.isVisible()){
                GruProCon.setState(JFrame.NORMAL);
                return;
            }
        GruProCon = new GrupoProdutoConsulta("N");
        GruProCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        if(SubGruProCad != null)
            if(SubGruProCad.isVisible()){
                SubGruProCad.setState(JFrame.NORMAL);
                return;
            }
        SubGruProCad = new SubGrupoProdutoCadastro("N", 0, 0);
        SubGruProCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        if(SubGruProCon != null)
            if(SubGruProCon.isVisible()){
                SubGruProCon.setState(JFrame.NORMAL);
                return;
            }
        SubGruProCon = new SubGrupoProdutoConsulta("N");
        SubGruProCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed
        if(GerBolItau   != null)
            if(GerBolItau.isVisible()){
                GerBolItau.setState(JFrame.NORMAL);
                return;
            }
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        parametros.add(0);
        parametros.add("Boleto");
        GerBolItau = new GerarBoletoItau(parametros);
        GerBolItau.setVisible(true);
    }//GEN-LAST:event_jMenuItem28ActionPerformed

    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem29ActionPerformed
        if(GerBolHsbc   != null)
            if(GerBolHsbc.isVisible()){
                GerBolHsbc.setState(JFrame.NORMAL);
                return;
            }
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        parametros.add(0);
        GerBolHsbc = new GerarBoletoHsbc(parametros);
        GerBolHsbc.setVisible(true);
    }//GEN-LAST:event_jMenuItem29ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        if(GerBolSant   != null)
            if(GerBolSant.isVisible()){
                GerBolSant.setState(JFrame.NORMAL);
                return;
            }
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        parametros.add(0);
        parametros.add("Boleto");
        GerBolSant = new GerarBoletoSantander(parametros);
        GerBolSant.setVisible(true);
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem31ActionPerformed
        if(GerBolBrad   != null)
            if(GerBolBrad.isVisible()){
                GerBolBrad.setState(JFrame.NORMAL);
                return;
            }
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        parametros.add(0);
        parametros.add("Boleto");
        GerBolBrad = new GerarBoletoBradesco(parametros);
        GerBolBrad.setVisible(true);
    }//GEN-LAST:event_jMenuItem31ActionPerformed

    private void jMenuItem32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem32ActionPerformed
        if(BolCon   != null)
            if(BolCon.isVisible()){
                BolCon.setState(JFrame.NORMAL);
                return;
            }
        parametros.clear();
        parametros.add("N");
        parametros.add("N");
        parametros.add("");
        parametros.add("");
        BolCon = new BoletosConsulta(parametros);
        BolCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem32ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        if(ConCorCad   != null)
            if(ConCorCad.isVisible()){
                ConCorCad.setState(JFrame.NORMAL);
                return;
            }
        ConCorCad = new ContaCorrenteCadastro("N", 0);
        ConCorCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        if(ConCorCon   != null)
            if(ConCorCon.isVisible()){
                ConCorCon.setState(JFrame.NORMAL);
                return;
            }
        ConCorCon = new ContaCorrenteConsulta("N");
        ConCorCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        if(InsBolCad   != null)
            if(InsBolCad.isVisible()){
                InsBolCad.setState(JFrame.NORMAL);
                return;
            }
        InsBolCad = new InstrucoesDeBoletosCadastro("N", 0);
        InsBolCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
        if(InsBolCon   != null)
            if(InsBolCon.isVisible()){
                InsBolCon.setState(JFrame.NORMAL);
                return;
            }
        InsBolCon = new InstrucoesDeBoletosConsulta("N");
        InsBolCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void jMenuItem33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem33ActionPerformed
        if(ForDePagCad   != null)
            if(ForDePagCad.isVisible()){
                ForDePagCad.setState(JFrame.NORMAL);
                return;
            }
        ForDePagCad = new FormasDePagamentoCadastro("N", 0);
        ForDePagCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem33ActionPerformed

    private void jMenuItem34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem34ActionPerformed
        if(ForDePagCon != null)
            if(ForDePagCon.isVisible()){
                ForDePagCon.setState(JFrame.NORMAL);
                return;
            }
        ForDePagCon = new FormasDePagamentoConsulta("N");
        ForDePagCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem34ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        if(ParPro != null)
            if(ParPro.isVisible()){
                ParPro.setState(JFrame.NORMAL);
                return;
            }
        ParPro = new ParametrosProducao();
        ParPro.setVisible(true);
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
        if(SelDatDoSisPro != null)if(SelDatDoSisPro.isVisible()){
            Mensagem = "Tela já Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuDataProducao = 1;
        SelDatDoSisPro = new SelecionarDataDoSistemaProducao();
        SelDatDoSisPro.setVisible(true);
    }//GEN-LAST:event_jMenuItem35ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu bt_arquivos;
    private javax.swing.JMenu bt_consultas;
    private javax.swing.JMenu bt_especiais;
    private javax.swing.JMenu bt_movimentos;
    private javax.swing.JMenu bt_parametros;
    private javax.swing.JMenu bt_relatorios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel txt_dataProducao;
    private javax.swing.JTextField txt_os_cadastradas;
    private javax.swing.JTextField txt_os_canceladas;
    private javax.swing.JTextField txt_os_faturadas;
    private javax.swing.JTextField txt_os_finalizadas;
    private javax.swing.JTextField txt_os_pendentes;
    private javax.swing.JTextField txt_os_semSolucao;
    private javax.swing.JLabel txt_rodape;
    // End of variables declaration//GEN-END:variables
    
    private void PegaOrdemServico(){
        sql = "select statusOs from tb_os where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosOrdemServico.clear();
        dadosOrdemServico = parametrosNS.dao.Consulta(sql);
        PegaDadosOrdemServico();
    }
    
    private void PegaDadosOrdemServico(){
        QtdTotalDeOs            = 0;
        QtdTotalDeOsPendentes   = 0;
        QtdTotalDeOsFinalizadas = 0;
        QtdTotalDeOsSemSolucao  = 0;
        QtdTotalDeOsCanceladas  = 0;
        QtdTotalDeOsFaturadas   = 0;
        for(int i = 0; i < dadosOrdemServico.size(); i++){
            if(dadosOrdemServico.get(i).get(0) != null)
                bos.statusOs                = Integer.parseInt(String.valueOf(dadosOrdemServico.get(i).get(0)));
            QtdTotalDeOs++;
            switch(bos.statusOs){
                case 0: QtdTotalDeOsPendentes  ++;  break;
                case 1: QtdTotalDeOsCanceladas ++;  break;
                case 2: QtdTotalDeOsFinalizadas++;  break;
                case 3: QtdTotalDeOsSemSolucao ++;  break;
                case 4: QtdTotalDeOsFaturadas  ++;  break;
            }
        }
        parametrosNS.codigoOS = dadosOrdemServico.size();
        txt_os_cadastradas          .setText(String.valueOf(QtdTotalDeOs));
        txt_os_pendentes            .setText(String.valueOf(QtdTotalDeOsPendentes));
        txt_os_canceladas           .setText(String.valueOf(QtdTotalDeOsCanceladas));
        txt_os_finalizadas          .setText(String.valueOf(QtdTotalDeOsFinalizadas));
        txt_os_semSolucao           .setText(String.valueOf(QtdTotalDeOsSemSolucao));
        txt_os_faturadas            .setText(String.valueOf(QtdTotalDeOsFaturadas));
    }
    
}
