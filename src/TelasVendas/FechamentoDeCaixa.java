package TelasVendas;

import Beans.BeanCaixaAbertura;
import Beans.BeanCaixaFechamento;
import Beans.BeanCaixaFechamentoDetalhes;
import Beans.BeanCaixaSaida;
import Beans.BeanFormasPagamentos;
import Beans.BeanInnerJoin;
import Beans.BeanIntervalos;
import Beans.BeanParametros;
import Beans.BeanUsuarios;
import Beans.BeanVendas;
import Beans.BeanVendasPagamentos;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.FormataCPFCNPJ;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.PegaProximoRegistro;
import FuncoesInternas.TestarData;
import FuncoesInternas.TransformaValorStringeDouble;
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/*
 @author Tiago e Paulo
 */
public class FechamentoDeCaixa extends javax.swing.JFrame {
    //String's
    String  sql                                 = "";
    String  fatal                               = "";
    String  sqlstate                            = "";
    String  Mensagem                            = "";
    
    //int's
    int     linha                               = 0;
    int     UltimoRegistro                      = 0;
    int     dataUltimaLeituraX                  = 0;
    int     horaUltimaLeituraX                  = 0;
    int     dataAtual                           = 0;
    int     horaAtual                           = 0;
    
    //double's
    double  ValorTotalDoPagamento               = 0;
    double  ValorTotalDeSaidaDeCaixa            = 0;
    double  ValorTotalConferido                 = 0;
    double  ValorTotalIncluso                   = 0;
    
    //Vetores ArrayList
//    ArrayList            dadosPadroes                      = new ArrayList();
    ArrayList            dadosPagamentos                   = new ArrayList();
    
    //Vetores ArrayList<ArrayList>
    ArrayList<ArrayList> dadosCaixaAbertura                = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosCaixaSaida                   = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosFechamentoCaixa              = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosFechamentoCaixaItens         = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosParametros                   = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosUsuario                      = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosVendas                       = new ArrayList<ArrayList>();
    
    //Bean's
    BeanUsuarios                    bu          = new BeanUsuarios();
    BeanCaixaAbertura               bca         = new BeanCaixaAbertura();
    BeanCaixaFechamento             bcf         = new BeanCaixaFechamento();
    BeanCaixaSaida                  bcs         = new BeanCaixaSaida();
    BeanVendas                      bv          = new BeanVendas();
    BeanVendasPagamentos            bvp         = new BeanVendasPagamentos();
    BeanFormasPagamentos            bfp         = new BeanFormasPagamentos();
    BeanCaixaFechamentoDetalhes     bcfd        = new BeanCaixaFechamentoDetalhes();
    BeanIntervalos                  binter      = new BeanIntervalos();
    BeanInnerJoin                   bin         = new BeanInnerJoin();
    BeanParametros                  bpar        = new BeanParametros();
    
    //Outros
    DefaultTableModel               Table;
    DefaultTableModel               Table1;
    PreparedStatement               stmt;
    ResultSet                       rs;
    JRResultSetDataSource           js;
    
    //Especiais para Relatórios
    String      jpv = "";
    JasperPrint jpp = null;
    HashMap     hm  = new HashMap();
    
    //Especiais
    BufferedImage                buffImg;
    ImageIcon                    imgIcon;
    Image                        img;
    CapturarDataHora             cdh         = new CapturarDataHora();
    InverterData                 invdata     = new InverterData();
    FormataCampo                 fc          = new FormataCampo();
    FormataCPFCNPJ               FCpfCnpj    = new FormataCPFCNPJ();
    TestarData                   Test        = new TestarData();
    PegaProximoRegistro          PegProReg   = new PegaProximoRegistro();
    TransformaValorStringeDouble TransStrDou = new TransformaValorStringeDouble();
    
    //Telas
    
    public FechamentoDeCaixa(String TipoFechamento){
        bcf.tipoFechamento = TipoFechamento;
        
        initComponents();
    }
    
//    private void PegaParametros(){
//        sql = "select * from tb_parametros where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
//        dadosParametros.clear();
//        dadosParametros = parametrosNS.dao.Consulta(sql);
//        if(dadosParametros.isEmpty()){
//            bt_fecharCaixa.setEnabled(false);
//            Mensagem = "Parâmetros de Impressão não encontrados!";
//            new MostraMensagem(Mensagem);
//            fatal = "S";
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
    
    private void PegaUsuario(){
        sql = "select codigoUsuario, usuario from tb_usuarios where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
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
        for(int i = 0; i < dadosUsuario.size(); i++){
            bu.codigoUsuario = Integer.parseInt(String.valueOf(dadosUsuario.get(i).get(0)));
            bu.usuario       = String.valueOf(dadosUsuario.get(i).get(1));
        }
        txt_codigoUsuario.setText(fc.FormataCampo(String.valueOf(bu.codigoUsuario), 3, 0));
    }
    
    private void PegaCaixaAberto(){
        fatal = "N";
        sql = "select * from tb_caixa_abertura where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoComputador = " + parametrosNS.bcomp.codigoComputador + " and status = 'A';";
        dadosCaixaAbertura.clear();
        dadosCaixaAbertura = parametrosNS.dao.Consulta(sql);
        if(dadosCaixaAbertura.isEmpty()){
            fatal = "S";
            bt_fecharCaixa.setEnabled(false);
            Mensagem = "Caixa não aberto para fechamento!";
            new MostraMensagem(Mensagem);
            return;
        }
        bt_fecharCaixa.setEnabled(true);
        PegaDadosCaixaAberto();
    }
    
    private void PegaDadosCaixaAberto(){
        for(int i = 0; i < dadosCaixaAbertura.size(); i++){
            bca.idAbertura              = Integer.parseInt(  String.valueOf(dadosCaixaAbertura.get(i).get(0)));
            bca.idEmpresa               = Integer.parseInt(  String.valueOf(dadosCaixaAbertura.get(i).get(1)));
            bca.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosCaixaAbertura.get(i).get(2)));
            bca.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosCaixaAbertura.get(i).get(3)));
            bca.codigoAbertura          = Integer.parseInt(  String.valueOf(dadosCaixaAbertura.get(i).get(4)));
            bca.codigoComputador        = Integer.parseInt(  String.valueOf(dadosCaixaAbertura.get(i).get(5)));
            bca.codigoUsuario           = Integer.parseInt(  String.valueOf(dadosCaixaAbertura.get(i).get(6)));
            bca.dataAbertura            =                    String.valueOf(dadosCaixaAbertura.get(i).get(7));
            bca.horaAbertura            =                    String.valueOf(dadosCaixaAbertura.get(i).get(8));
            bca.valorDoCaixa            = Double.parseDouble(String.valueOf(dadosCaixaAbertura.get(i).get(9)));
        }
        bu.codigoUsuario    = bca.codigoUsuario;
        PegaUsuario();
        label_nomeUsuario   .setText(bu.usuario);
        txt_dataFechamento  .setText(invdata.inverterData(bca.dataAbertura, 1));
        txt_horaFechamento  .setText(bca.horaAbertura);
        txt_dataDoFechamento.setText(cdh.CapturarData());
        txt_horaDoFechamento.setText(cdh.CapturaHora());
    }
    
    private void PegaUltimaLeituraX(){
        fatal = "N";
        bcf.dataDoFechamento        = bca.dataAbertura;
        sql = "select * from tb_caixa_fechamento where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoComputador = " + parametrosNS.bcomp.codigoComputador + " and tipoFechamento = 'X' and dataDoFechamento between " + bcf.dataDoFechamento + " and " + invdata.inverterData(cdh.CapturarData(), 2) + " order by codigoFechamento asc;";
        dadosFechamentoCaixa.clear();
        dadosFechamentoCaixa = parametrosNS.dao.Consulta(sql);
        if(dadosFechamentoCaixa.isEmpty())
            return;
        bt_fecharCaixa.setEnabled(true);
        PegaDadosUltimaLeituraX();
    }
    
    private void PegaDadosUltimaLeituraX(){
        for(int i = 0; i < dadosFechamentoCaixa.size(); i++){
            bcf.idFechamento            = Integer.parseInt(  String.valueOf(dadosFechamentoCaixa.get(i).get(0)));
            bcf.idEmpresa               = Integer.parseInt(  String.valueOf(dadosFechamentoCaixa.get(i).get(1)));
            bcf.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosFechamentoCaixa.get(i).get(2)));
            bcf.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosFechamentoCaixa.get(i).get(3)));
            bcf.codigoFechamento        = Integer.parseInt(  String.valueOf(dadosFechamentoCaixa.get(i).get(4)));
            bcf.codigoComputador        = Integer.parseInt(  String.valueOf(dadosFechamentoCaixa.get(i).get(5)));
            bcf.codigoAbertura          = Integer.parseInt(  String.valueOf(dadosFechamentoCaixa.get(i).get(6)));
            bcf.codigoUsuario           = Integer.parseInt(  String.valueOf(dadosFechamentoCaixa.get(i).get(7)));
            bcf.dataDoFechamento        =                    String.valueOf(dadosFechamentoCaixa.get(i).get(8));
            bcf.horaDoFechamento        =                    String.valueOf(dadosFechamentoCaixa.get(i).get(9));
        }
        bu.codigoUsuario    = bcf.codigoUsuario;
        PegaUsuario();
        label_nomeUsuario.setText(bu.usuario);
        txt_dataFechamento  .setText(invdata.inverterData(bcf.dataDoFechamento, 1));
        txt_horaFechamento  .setText(bcf.horaDoFechamento);
        txt_dataDoFechamento.setText(cdh.CapturarData());
        txt_horaDoFechamento.setText(cdh.CapturaHora());
    }
    
    private void PegaVendas(){
        fatal = "N";
        binter.dataVendaInicial = Test.Testa(txt_dataFechamento.getText());
        binter.dataVendaFinal   = Test.Testa(txt_dataDoFechamento.getText());
        MontaSQLInnerJoin();
        dadosVendas.clear();
        dadosVendas = parametrosNS.dao.Consulta(sql);
        if(dadosVendas.isEmpty()){
            fatal = "S";
            Mensagem = "Não existem vendas cadastradas para o intervalo " + txt_dataFechamento.getText() + " e " + txt_dataDoFechamento.getText() + "!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosVendas();
    }
    
    private void PegaDadosVendas(){
        combo_formasPagamentos.removeAllItems();
        combo_formasPagamentos.addItem("----------");
        
        Table.setNumRows(0);
        
        ValorTotalDoPagamento       = 0;
        for(int i = 0; i < dadosVendas.size(); i++){
            bin.codigoComputador        = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(0)));
            bin.codigoPagamento         = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(1)));
            bin.descricaoPagamento      =                    String.valueOf(dadosVendas.get(i).get(2));
            bin.totalEmitido            = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(3)));
            bin.valorTotal              = Double.parseDouble(String.valueOf(dadosVendas.get(i).get(4)));
            bin.trocoDoPagamento        = Double.parseDouble(String.valueOf(dadosVendas.get(i).get(5)));
            
            bin.valorTotal  = bin.valorTotal / 2;
            
            if(bcf.tipoFechamento.equals("X"))PegaValorTotalConferido();
            if(bcf.tipoFechamento.equals("X"))bin.valorTotal    = bin.valorTotal - ValorTotalConferido;
            
            if(bin.valorTotal < 0){
                bin.valorTotal = 0;
                continue;
            }
            
            ValorTotalDoPagamento      += bin.valorTotal;
            
            bin.descricaoPagamento      = fc.FormataCampo(String.valueOf(bin.codigoPagamento), 2, 0) + "-" + bin.descricaoPagamento;
            combo_formasPagamentos.addItem(bin.descricaoPagamento);
            
            Table.addRow(new Object [] {bin.descricaoPagamento, TransStrDou.TransformaValorStringeDouble(String.valueOf(bin.valorTotal), 0)});
        }
        if(tabela_formasPagamentos.getRowCount() > 0)
            Table.addRow(new Object [] {"Totais", TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotalDoPagamento), 0)});
        if(bcf.tipoFechamento.equals("Z"))return;
        if(ValorTotalDoPagamento <= 0){
            Mensagem = "Não existe valor para fechamento em Leitura X!";
            new MostraMensagem(Mensagem);
            bt_fecharCaixa.setEnabled(false);
            return;
        }
    }
    
    private void PegaValorTotalConferido(){
        binter.dataFechamentoInicial    = Test.Testa(txt_dataFechamento.getText());
        binter.dataFechamentoFinal      = Test.Testa(txt_dataDoFechamento.getText());
        sql =   "select \n" +
                "  sum(fdet.valorTotalDoFechamento) \n" +
                "from tb_caixa_fechamento fec\n" +
                "  inner join tb_caixa_fechamento_detalhes fdet on (fec.idFechamento = fdet.idFechamento)\n" +
                "  inner join tb_formaspagamentos forp on ((fec.idEmpresa = forp.idEmpresa) and (fdet.codigoPagamento = forp.codigoPagamento))\n" +
                "  where fec.codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and fec.codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and \n" +
                "        fec.codigoComputador = " + parametrosNS.bcomp.codigoComputador + " and fdet.codigoPagamento = " + bin.codigoPagamento + " and \n" +
                "        fec.dataDoFechamento between " + binter.dataFechamentoInicial + " and " + binter.dataFechamentoFinal + ";";
        dadosFechamentoCaixaItens.clear();
        dadosFechamentoCaixaItens = parametrosNS.dao.Consulta(sql);
        PegaDadosValorTotalConferido();
    }
    
    private void PegaDadosValorTotalConferido(){
        ValorTotalConferido         = 0;
        for(int i = 0; i < dadosFechamentoCaixaItens.size(); i++){
            if(dadosFechamentoCaixaItens.get(i).get(0) != null)
            bin.valorTotalConferido = Double.parseDouble(  String.valueOf(dadosFechamentoCaixaItens.get(i).get(0)));
            
            ValorTotalConferido     = bin.valorTotalConferido;
        }
    }
    
    private void PegaSaidaDeCaixa(){
        binter.dataVendaInicial     = Test.Testa(txt_dataFechamento.getText());
        binter.dataVendaFinal       = Test.Testa(txt_dataDoFechamento.getText());
        bcs.codigoAbertura          = bca.codigoAbertura;
        sql = "select idCaixaSaida, idEmpresa, codigoGrupo, codigoEmpresa, codigoCaixaSaida, codigoComputador, codigoAbertura, codigoMotivoSaida, codigoUsuario, valorDeSaida from tb_caixa_saida where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoComputador = " + parametrosNS.bcomp.codigoComputador + " and codigoAbertura = " + bcs.codigoAbertura + " and statusSaida = 0;";
        dadosCaixaSaida.clear();
        dadosCaixaSaida = parametrosNS.dao.Consulta(sql);
        PegaDadoSaidaCaixa();
    }
    
    private void PegaDadoSaidaCaixa(){
        ValorTotalDeSaidaDeCaixa = 0;
        for(int i = 0; i < dadosCaixaSaida.size(); i++){
            bcs = new BeanCaixaSaida();
            bcs.idCaixaSaida            = Integer.parseInt(  String.valueOf(dadosCaixaSaida.get(i).get(0)));
            bcs.idEmpresa               = Integer.parseInt(  String.valueOf(dadosCaixaSaida.get(i).get(1)));
            bcs.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosCaixaSaida.get(i).get(2)));
            bcs.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosCaixaSaida.get(i).get(3)));
            bcs.codigoCaixaSaida        = Integer.parseInt(  String.valueOf(dadosCaixaSaida.get(i).get(4)));
            bcs.codigoComputador        = Integer.parseInt(  String.valueOf(dadosCaixaSaida.get(i).get(5)));
            bcs.codigoAbertura          = Integer.parseInt(  String.valueOf(dadosCaixaSaida.get(i).get(6)));
            bcs.codigoMotivoSaida       = Integer.parseInt(  String.valueOf(dadosCaixaSaida.get(i).get(7)));
            bcs.codigoUsuario           = Integer.parseInt(  String.valueOf(dadosCaixaSaida.get(i).get(8)));
            bcs.valorDeSaida            = Double.parseDouble(String.valueOf(dadosCaixaSaida.get(i).get(9)));
            
            ValorTotalDeSaidaDeCaixa   += bcs.valorDeSaida;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_dataFechamento = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_dataDoFechamento = new javax.swing.JFormattedTextField();
        txt_horaDoFechamento = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_codigoComputador = new javax.swing.JFormattedTextField();
        txt_codigoUsuario = new javax.swing.JFormattedTextField();
        label_nomeComputador = new javax.swing.JLabel();
        label_nomeUsuario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_formasPagamentos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txt_horaFechamento = new javax.swing.JFormattedTextField();
        bt_fecharCaixa = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        combo_formasPagamentos = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_pagamentosCaixa = new javax.swing.JTable();
        txt_valorDoCaixa = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        bt_sair1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fechamento de Caixa");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Fechamento de Caixa");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Fechamento de Caixa do Dia:");

        txt_dataFechamento.setEditable(false);
        try {
            txt_dataFechamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataFechamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Data Atual:");

        txt_dataDoFechamento.setEditable(false);
        try {
            txt_dataDoFechamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataDoFechamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_horaDoFechamento.setEditable(false);
        try {
            txt_horaDoFechamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_horaDoFechamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Hora:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Caixa aberto por:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Computador:");

        txt_codigoComputador.setEditable(false);
        try {
            txt_codigoComputador.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoComputador.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_codigoUsuario.setEditable(false);
        try {
            txt_codigoUsuario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tabela_formasPagamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fomas de Pagamentos", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_formasPagamentos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabela_formasPagamentos);
        if (tabela_formasPagamentos.getColumnModel().getColumnCount() > 0) {
            tabela_formasPagamentos.getColumnModel().getColumn(0).setResizable(false);
            tabela_formasPagamentos.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Hora:");

        txt_horaFechamento.setEditable(false);
        try {
            txt_horaFechamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_horaFechamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_codigoComputador)
                                    .addComponent(txt_codigoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_nomeComputador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_nomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap())))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_dataFechamento, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(txt_dataDoFechamento))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_horaDoFechamento))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_horaFechamento)))
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel5, jLabel6});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_dataDoFechamento, txt_dataFechamento});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_codigoComputador, txt_codigoUsuario});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_codigoComputador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nomeComputador))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_codigoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nomeUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_dataFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_horaFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txt_dataDoFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_horaDoFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, label_nomeComputador, label_nomeUsuario, txt_codigoComputador, txt_codigoUsuario, txt_dataDoFechamento, txt_dataFechamento, txt_horaDoFechamento});

        bt_fecharCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_fecharCaixa.setText("Fechar Caixa");
        bt_fecharCaixa.setEnabled(false);
        bt_fecharCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_fecharCaixaActionPerformed(evt);
            }
        });
        bt_fecharCaixa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bt_fecharCaixaKeyPressed(evt);
            }
        });

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Conferência de Caixa");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setText("Forma de pagamento:");

        combo_formasPagamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------------" }));
        combo_formasPagamentos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo_formasPagamentosKeyPressed(evt);
            }
        });

        tabela_pagamentosCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fomas de Pagamentos", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_pagamentosCaixa.setToolTipText("[F9] - Limpa Pagamentos, [F10] - Remove Pagamento");
        tabela_pagamentosCaixa.getTableHeader().setReorderingAllowed(false);
        tabela_pagamentosCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_pagamentosCaixaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabela_pagamentosCaixa);
        if (tabela_pagamentosCaixa.getColumnModel().getColumnCount() > 0) {
            tabela_pagamentosCaixa.getColumnModel().getColumn(0).setResizable(false);
            tabela_pagamentosCaixa.getColumnModel().getColumn(1).setResizable(false);
        }

        txt_valorDoCaixa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_valorDoCaixaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorDoCaixaFocusLost(evt);
            }
        });
        txt_valorDoCaixa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_valorDoCaixaKeyPressed(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Valor do Caixa:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_formasPagamentos, 0, 241, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_valorDoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel8});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(combo_formasPagamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_valorDoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {combo_formasPagamentos, jLabel10, jLabel8, txt_valorDoCaixa});

        jMenu1.setText("Funções");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        jMenuItem1.setText("Limpar Pagamentos Efetuados");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        jMenuItem2.setText("Remover Pagamento Selecionado");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator1);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(bt_fecharCaixa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_sair))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_fecharCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_fecharCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fecharCaixaActionPerformed
        PegaValores();
    }//GEN-LAST:event_bt_fecharCaixaActionPerformed

    private void txt_valorDoCaixaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorDoCaixaFocusLost
        if(txt_valorDoCaixa.getText().equals(""))
            return;
        txt_valorDoCaixa.setText(TransStrDou.TransformaValorStringeDouble(txt_valorDoCaixa.getText(), 0));
        bt_fecharCaixa.grabFocus();
    }//GEN-LAST:event_txt_valorDoCaixaFocusLost

    private void txt_valorDoCaixaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorDoCaixaFocusGained
        if(txt_valorDoCaixa.getText().equals(""))
            return;
        txt_valorDoCaixa.setText(TransStrDou.TransformaValorStringeDouble(txt_valorDoCaixa.getText(), 1));
        txt_valorDoCaixa.setSelectionStart(0);
        txt_valorDoCaixa.setSelectionEnd  (txt_valorDoCaixa.getText().length());
    }//GEN-LAST:event_txt_valorDoCaixaFocusGained

    private void txt_valorDoCaixaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valorDoCaixaKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        if(txt_valorDoCaixa.getText().equals("")){
            bt_fecharCaixa.grabFocus();
            return;
        }
        IncluirPagamento();
    }//GEN-LAST:event_txt_valorDoCaixaKeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Table1.setNumRows(0);
        dadosPagamentos.clear();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Table1.removeRow(linha);
        dadosPagamentos.remove(linha);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void tabela_pagamentosCaixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_pagamentosCaixaMouseClicked
        linha = tabela_pagamentosCaixa.getSelectedRow();
    }//GEN-LAST:event_tabela_pagamentosCaixaMouseClicked

    private void combo_formasPagamentosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_formasPagamentosKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        txt_valorDoCaixa.grabFocus();
    }//GEN-LAST:event_combo_formasPagamentosKeyPressed

    private void bt_fecharCaixaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bt_fecharCaixaKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        PegaValores();
    }//GEN-LAST:event_bt_fecharCaixaKeyPressed

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txt_codigoComputador.setText(fc.FormataCampo(String.valueOf(parametrosNS.bcomp.codigoComputador), 2, 0));
        label_nomeComputador.setText(parametrosNS.bcomp.nomeComputador);
        label_nomeUsuario   .setText(parametrosNS.bu.usuario);
        
        Table   = (DefaultTableModel)tabela_formasPagamentos.getModel();
        Table1  = (DefaultTableModel)tabela_pagamentosCaixa.getModel();
        
        setTitle("Fechamento de Caixa Completo (Redução Z)");
        PegaCaixaAberto();
        if(fatal.equals("S"))
            return;
        if(bcf.tipoFechamento.equals("X")){
            setTitle("Fechamento de Caixa Parcial (Leitura X)");
            PegaUltimaLeituraX();
        }
//        PegaParametros();
//        if(fatal.equals("S"))return;
        PegaVendas();
        if(fatal.equals("S"))return;
        PegaSaidaDeCaixa();
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_fecharCaixa;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JComboBox<String> combo_formasPagamentos;
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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel label_nomeComputador;
    private javax.swing.JLabel label_nomeUsuario;
    private javax.swing.JTable tabela_formasPagamentos;
    private javax.swing.JTable tabela_pagamentosCaixa;
    private javax.swing.JFormattedTextField txt_codigoComputador;
    private javax.swing.JFormattedTextField txt_codigoUsuario;
    private javax.swing.JFormattedTextField txt_dataDoFechamento;
    private javax.swing.JFormattedTextField txt_dataFechamento;
    private javax.swing.JFormattedTextField txt_horaDoFechamento;
    private javax.swing.JFormattedTextField txt_horaFechamento;
    private javax.swing.JTextField txt_valorDoCaixa;
    // End of variables declaration//GEN-END:variables
    
    private void PegaValores(){
        if(tabela_formasPagamentos.getRowCount() - 1 > tabela_pagamentosCaixa.getRowCount()){
            txt_valorDoCaixa.grabFocus();
            Mensagem = "Quantidade de pagamentos inválido!";
            new MostraMensagem(Mensagem);
            return;
        }
        if(ValorTotalDoPagamento - ValorTotalIncluso > 0.02){
            txt_valorDoCaixa.grabFocus();
            Mensagem = "Valor pagamento inválido!";
            new MostraMensagem(Mensagem);
            return;
        }
        if(JOptionPane.showConfirmDialog(null, "Deseja realmente Finalizar o Caixa?", "", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION)
            return;
        bcf.idEmpresa               = parametrosNS.be.IdEmpresa;
        bcf.codigoGrupo             = parametrosNS.bge.CodigoGrupo;
        bcf.codigoEmpresa           = parametrosNS.be.CodigoEmpresa;
        bcf.codigoFechamento        = PegProReg.PegaProximoRegistro("tb_caixa_fechamento", "codigoFechamento", "");
        bcf.codigoComputador        = parametrosNS.bcomp.codigoComputador;
        bcf.codigoAbertura          = bca.codigoAbertura;
        bcf.codigoUsuario           = parametrosNS.bu.codigoUsuario;
        bcf.dataDoFechamento        = invdata.inverterData(txt_dataDoFechamento.getText(), 2);
        bcf.horaDoFechamento        = txt_horaDoFechamento.getText();
        IncluirFechamento();
    }
    
    private void IncluirFechamento(){
        sql = "insert into tb_caixa_fechamento (idEmpresa, codigoGrupo, codigoEmpresa, codigoFechamento, codigoComputador, codigoAbertura, codigoUsuario, dataDoFechamento, horaDoFechamento, tipoFechamento) "
            + "values (" + bcf.idEmpresa + ", " + bcf.codigoGrupo + ", " + bcf.codigoEmpresa + ", " + bcf.codigoFechamento + ", " + bcf.codigoComputador + ", " + bcf.codigoAbertura + ", " + bcf.codigoUsuario + ", '" + bcf.dataDoFechamento + "', '" + bcf.horaDoFechamento + "', '" + bcf.tipoFechamento + "');";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        sql = "select idFechamento from tb_caixa_fechamento where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoFechamento = " + bcf.codigoFechamento + ";";
        dadosFechamentoCaixa.clear();
        dadosFechamentoCaixa = parametrosNS.dao.Consulta(sql);
        bcf.idFechamento     = Integer.parseInt(String.valueOf(dadosFechamentoCaixa.get(0).get(0)));
        if(bcf.tipoFechamento.equals("Z")){
            FinalizarCaixa();
            if(!sqlstate.equals("00000"))
                return;
        }
        IncluirDetalhesDoFechamento();
        ImprimirFechamento();
    }
    
    private void FinalizarCaixa(){
        sql = "update tb_caixa_abertura set status = 'Z' where idAbertura = " + bca.idAbertura + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
    }
    
    private void IncluirDetalhesDoFechamento(){
        bcfd.idFechamento               = bcf.idFechamento;
        bcfd.codigoComputador           = parametrosNS.bcomp.codigoComputador;
        int linha = tabela_pagamentosCaixa.getRowCount();
        for(int i = 0; i < linha; i++){
            bcfd.codigoPagamento        = Integer.parseInt(String.valueOf(tabela_pagamentosCaixa.getValueAt(i, 0)).substring(0, 2));
            bcfd.dataPagamento          = invdata.inverterData(cdh.CapturarData(), 2);
            bcfd.valorTotalDoFechamento = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(String.valueOf(tabela_pagamentosCaixa.getValueAt(i, 1)), 1));
            
            sql = "insert into tb_caixa_fechamento_detalhes (idFechamento, codigoComputador, codigoPagamento, dataPagamento, valorTotalDoFechamento) "
                + "values (" + bcfd.idFechamento + ", " + bcfd.codigoComputador + ", " + bcfd.codigoPagamento + ", '" + bcfd.dataPagamento + "', " + bcfd.valorTotalDoFechamento + ");";
            sqlstate = parametrosNS.dao.incluirRegistro(sql);
            if(sqlstate.equals("00000"))
                continue;
            Mensagem = "Erro ao incluir froma de pagamento n°" + parametrosNS.fc.FormataCampo(String.valueOf(bcfd.codigoPagamento), 2, 0) + "!";
            new MostraMensagem(Mensagem);
            return;
        }
        if(bcf.tipoFechamento.equals("X")){
            Mensagem = "Caixa fechado com Leitura X!";
            new MostraMensagem(Mensagem);
        }
        if(bcf.tipoFechamento.equals("Z")){
            Mensagem = "Caixa fechado com Redução Z!";
            new MostraMensagem(Mensagem);
        }
        dispose();
    }
    
    private void MontaSQLInnerJoin(){
        sql =   "select \n" +
                "  ven.codigoComputador        as codigoComputador,\n" +
                "  pag.codigoPagamento         as codigoPagamento, \n" +
                "  forp.descricaoPagamento     as descricaoPagamento, \n" +
                "  count(pag.codigoVenda)      as totalEmitido, \n" +
                "  sum(pag.valorDoPagamento)   as valorTotal, \n" +
                "  sum(pag.trocoDoPagamento)   as trocoDoPagamento \n" +
                "from tb_vendas ven \n" +
                "  inner join tb_vendas_pagamentos pag on ((pag.idEmpresa = ven.idEmpresa) and (pag.codigoVenda = ven.codigoVenda)) \n" +
                "  inner join tb_formaspagamentos forp on ((pag.idEmpresa = forp.idEmpresa) and (pag.codigoPagamento = forp.codigoPagamento)) \n" +
                "  where ven.idEmpresa = " + parametrosNS.be.IdEmpresa + " and \n" +
                "  ven.codigoComputador = " + parametrosNS.bcomp.codigoComputador + " and ven.dataVenda between " + binter.dataVendaInicial + " and " + binter.dataVendaFinal + "\n" +
                "    group by forp.codigoPagamento" +
                "    order by forp.codigoPagamento asc;";
    }
    
    private void ImprimirFechamento(){
        binter.dataVendaInicial     = Test.Testa(txt_dataFechamento.getText());
        binter.dataVendaFinal       = Test.Testa(txt_dataDoFechamento.getText());
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
            if(parametrosNS.be.ImagemLogotipoEmpresa != null)
                hm.put("logotipoEmpresa", img);
            else
                hm.put("logotipoEmpresa"    , null);
            hm.put("codigoComputadorInicial", parametrosNS.bcomp.codigoComputador);
            hm.put("codigoComputadorFinal"  , parametrosNS.bcomp.codigoComputador);
            hm.put("dataAberturaInicial"    , binter.dataVendaInicial);
            hm.put("dataAberturaFinal"      , binter.dataVendaFinal);
            
            jpv     = "Relatorios/RelatorioDeFechamentoDeCaixa.jasper";
            
            jpp     = JasperFillManager.fillReport(jpv, hm, parametrosNS.con);
            JasperViewer.viewReport(jpp, false);
        }catch(Exception erro){
            Mensagem = "Erro ao imprimir: " + erro.getMessage();
            new MostraMensagem(Mensagem);
        }
    }
    
    private void IncluirPagamento(){
        if(combo_formasPagamentos.getSelectedIndex() == 0){
            Mensagem = "Pagamento não Selecionado!";
            new MostraMensagem(Mensagem);
            return;
        }
        
        bfp.codigoPagamento         = Integer.parseInt(String.valueOf(combo_formasPagamentos.getSelectedItem()).substring(0, 2));
        bfp.descricaoPagamento      = String.valueOf(combo_formasPagamentos.getSelectedItem());
        bcfd.valorTotalDoFechamento = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_valorDoCaixa.getText(), 1));
        for(int i = 0; i < dadosPagamentos.size(); i++){
            int Valor   = (int) dadosPagamentos.get(i);
            if(bfp.codigoPagamento != Valor)
                continue;
            Mensagem = "Pagamento já incluso!";
            new MostraMensagem(Mensagem);
            return;
        }
        
        ValorTotalIncluso = ValorTotalIncluso + bcfd.valorTotalDoFechamento;
        
        dadosPagamentos.add(bfp.codigoPagamento);
        
        txt_valorDoCaixa.setText("");
        combo_formasPagamentos.grabFocus();
        
        Table1.addRow(new Object [] {bfp.descricaoPagamento, TransStrDou.TransformaValorStringeDouble(String.valueOf(bcfd.valorTotalDoFechamento), 0)});
    }
    
}