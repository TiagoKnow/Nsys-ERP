package MenusPrincipais;

import Telas.MenuPrincipal;
import Beans.*;
import TelasFaturamento.ClientesCadastro;
import TelasFaturamento.ClientesConsulta;
import TelasFaturamento.TransportadoraCadastro;
import TelasFaturamento.TransportadoraConsulta;
import TelasFinanceiro.DespesasCadastro;
import TelasFinanceiro.DespesasConsulta;
import TelasFinanceiro.DespesasTipoCadastro;
import TelasFinanceiro.DespesasTipoConsulta;
import FuncoesInternas.*;
import Parametros.ParametrosVendas;
import TelasEstoque.ProdutosConsulta;
import Telas.CancelamentosCadastro;
import Telas.CancelamentosConsulta;
import Parametros.parametrosNS;
import RelatoriosVendas.RelatorioFechamentoCaixaGeral;
import TelasEstoque.FornecedorCadastro;
import TelasEstoque.FornecedorConsulta;
import TelasEstoque.ProdutosCadastro;
import TelasRH.FuncionariosCadastro;
import TelasRH.FuncionariosConsulta;
import TelasVendas.AberturaDeCaixa;
import TelasVendas.ComandasCadastro;
import TelasVendas.ComandasConsulta;
import TelasVendas.FechamentoDeCaixa;
import TelasVendas.FormasDePagamentoCadastro;
import TelasVendas.FormasDePagamentoConsulta;
import TelasVendas.GerenciarComandas;
import TelasVendas.InformarCPFouCNPJ;
import TelasVendas.MotivosDeSaidaDeCaixaCadastro;
import TelasVendas.MotivosDeSaidaDeCaixaConsulta;
import TelasVendas.OrcamentosCadastro;
import TelasVendas.OrcamentosConsulta;
import TelasVendas.PDV;
import TelasVendas.RelatorioDeProdutosVendidos;
import TelasVendas.RelatorioDeVendas;
import TelasVendas.RelatorioDeVendasMensalPorUsuario;
import TelasVendas.SaidaDeCaixaCadastro;
import TelasVendas.VendasConsultaEManutencao;
import java.util.*;
import javax.swing.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;
/*
 @author Tiago e Paulo
 */
public class MenuVendas extends javax.swing.JFrame {
    //String
    String sql           = "";
    String sqlstate      = "";
    String mensagem      = "";
    String tipoRelatorio = "";
    
    String Modo          = "";
    
    //Bean
    BeanModulos bm = new BeanModulos();
    
    //Vetores
    ArrayList parametros = new ArrayList();
    
    //Funções
    CapturarDataHora cdh = new CapturarDataHora();
    FormataCampo     fc  = new FormataCampo();
    
    //Telas
    JFrame                            Frame;
    MenuPrincipal                     MenPri;
    AberturaDeCaixa                   AberDeCaixa;
    ClientesCadastro                  CliCad;
    ClientesConsulta                  CliCon;
    ComandasCadastro                  ComCad;
    ComandasConsulta                  ComCon;
    CancelamentosCadastro             CadCan;
    CancelamentosConsulta             ConCan;
    DespesasCadastro                  DesCad;
    DespesasConsulta                  DesCon;
    DespesasTipoCadastro              DesCadTipo;
    DespesasTipoConsulta              DesConTipo;
    GerenciarComandas                 GerCom;
    FechamentoDeCaixa                 FecDeCaixa;
    FormasDePagamentoCadastro         ForDePagCad;
    FormasDePagamentoConsulta         ForDePagCon;
    FornecedorCadastro                ForCad;
    FornecedorConsulta                ForCon;
    FuncionariosConsulta              FunCon;
    FuncionariosCadastro              FunCad;
    InformarCPFouCNPJ                 InfCPFouCNPJ;
    MotivosDeSaidaDeCaixaCadastro     MotDeSaiDeCaiCad;
    MotivosDeSaidaDeCaixaConsulta     MotDeSaiDeCaiCon;
    OrcamentosCadastro                OrcCad;
    OrcamentosConsulta                OrcCon;
    ParametrosVendas                  ParVen;
    PDV                               Pdv;
    ProdutosCadastro                  ProCad;
    ProdutosConsulta                  ProCon;
    RelatorioDeProdutosVendidos       RelDeProVen;
    RelatorioDeVendas                 RelVen;
    RelatorioDeVendasMensalPorUsuario RelDeVenMenPorUsu;
    RelatorioFechamentoCaixaGeral     RelFecCaiGer;
    SaidaDeCaixaCadastro              SaiDeCaixaCad;
    TransportadoraCadastro            TransCad;
    TransportadoraConsulta            TransCon;
    VendasConsultaEManutencao         VenConMan;
    IntervaloDatas                    IntDat;
    
    public MenuVendas(JFrame frame){
        initComponents();
        Frame       = frame;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    private void CarregarAbas(){
        bm.abasVendas       = parametrosNS.bm.abasVendas;
        bm.abaConsultas     = bm.abasVendas.substring(0, 1);
        bm.abaArquivo       = bm.abasVendas.substring(1, 2);
        bm.abaMovimentos    = bm.abasVendas.substring(2, 3);
        bm.abaRelatorios    = bm.abasVendas.substring(3, 4);
        bm.abaParametros    = bm.abasVendas.substring(4, 5);
        bm.abaEspeciais     = bm.abasVendas.substring(5, 6);
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jMenuItem55 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem62 = new javax.swing.JMenuItem();
        jMenuItem60 = new javax.swing.JMenuItem();
        jMenuItem61 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem39 = new javax.swing.JMenuItem();
        jMenuItem58 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem33 = new javax.swing.JMenuItem();
        jMenuItem34 = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        jMenuItem36 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenuItem31 = new javax.swing.JMenuItem();
        jMenuItem32 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPanel3 = new javax.swing.JPanel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel1 = new javax.swing.JPanel();
        txt_rodape = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_rodape1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        bt_consultas = new javax.swing.JMenu();
        jMenuItem42 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem45 = new javax.swing.JMenuItem();
        jMenuItem54 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem37 = new javax.swing.JMenuItem();
        jMenuItem64 = new javax.swing.JMenuItem();
        jMenuItem41 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem47 = new javax.swing.JMenuItem();
        jMenuItem51 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        bt_arquivos = new javax.swing.JMenu();
        jMenuItem38 = new javax.swing.JMenuItem();
        menu_pdv = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem53 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem40 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem48 = new javax.swing.JMenuItem();
        jMenuItem50 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        bt_movimentos = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem49 = new javax.swing.JMenuItem();
        jMenuItem57 = new javax.swing.JMenuItem();
        jMenuItem52 = new javax.swing.JMenuItem();
        jMenuItem44 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        bt_relatorios = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem43 = new javax.swing.JMenuItem();
        jMenuItem46 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem59 = new javax.swing.JMenuItem();
        jMenuItem63 = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        bt_parametros = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        bt_especiais = new javax.swing.JMenu();

        jMenuItem55.setText("Orçamentos");
        jMenuItem55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem55ActionPerformed(evt);
            }
        });

        jMenuItem9.setText("Movimento do Caixa");

        jMenuItem62.setText("Relatório de vendas por cliente");
        jMenuItem62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem62ActionPerformed(evt);
            }
        });

        jMenuItem60.setText("Relatório de vendas por usuário");
        jMenuItem60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem60ActionPerformed(evt);
            }
        });

        jMenuItem61.setText("Relatório de produtos vendidos por período");
        jMenuItem61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem61ActionPerformed(evt);
            }
        });

        jMenu9.setText("(NOVO)");
        jMenu9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem39.setText("Relatório de Produtos Vendidos ");
        jMenuItem39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem39ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem39);

        jMenuItem58.setText("Relatório de Pagamentos Efetuados");
        jMenuItem58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem58ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem58);

        jMenu5.setText("Controle de Vendas");

        jMenuItem33.setText("Vendas Diárias");
        jMenu5.add(jMenuItem33);

        jMenuItem34.setText("Controle de Vendas");
        jMenu5.add(jMenuItem34);

        jMenuItem35.setText("Lucro das Vendas");
        jMenu5.add(jMenuItem35);

        jMenuItem36.setText("Faturamento Sintético");
        jMenu5.add(jMenuItem36);

        jMenu4.setText("Reimpressões");

        jMenuItem30.setText("Recibo de Venda");
        jMenu4.add(jMenuItem30);

        jMenuItem31.setText("Emissão do Carnê");
        jMenu4.add(jMenuItem31);

        jMenuItem32.setText("Nota Promissória");
        jMenu4.add(jMenuItem32);

        jMenuItem29.setText("Saldos");

        jMenuItem28.setText("Demonstrativo do Caixa");

        jMenuItem3.setText("Clientes (Simples)");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/logo-top.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(102, 102, 102));

        txt_rodape1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_rodape1.setForeground(new java.awt.Color(255, 255, 255));
        txt_rodape1.setText(" PDV - F1 | Comandas - F2 | Orçamentos - F3 ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_rodape1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txt_rodape1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        bt_consultas.setBackground(new java.awt.Color(255, 255, 255));
        bt_consultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconesPDV/Lupa.png"))); // NOI18N
        bt_consultas.setText("  Consultas");
        bt_consultas.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jMenuItem42.setText("Vendas (Geral)");
        jMenuItem42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem42ActionPerformed(evt);
            }
        });
        bt_consultas.add(jMenuItem42);
        bt_consultas.add(jSeparator6);

        jMenu10.setText("Consultas");

        jMenuItem45.setText("Produtos");
        jMenuItem45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem45ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem45);

        jMenuItem54.setText("Comandas");
        jMenuItem54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem54ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem54);

        jMenuItem2.setText("Clientes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem2);

        jMenuItem26.setText("Fornecedores");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem26);

        jMenuItem37.setText("Transportadores");
        jMenuItem37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem37ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem37);

        jMenuItem64.setText("Funcionários");
        jMenuItem64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem64ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem64);

        jMenuItem41.setText("Formas de Pagamentos");
        jMenuItem41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem41ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem41);

        bt_consultas.add(jMenu10);
        bt_consultas.add(jSeparator7);

        jMenu7.setText("Motivos");

        jMenuItem47.setText("Motivos de Cancelamento de Vendas");
        jMenuItem47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem47ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem47);

        jMenuItem51.setText("Motivos de Saida de Caixa");
        jMenuItem51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem51ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem51);

        bt_consultas.add(jMenu7);
        bt_consultas.add(jSeparator4);

        jMenu3.setText("Despesas");

        jMenuItem11.setText("Despesas");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuItem13.setText("Tipos de Despesas");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem13);

        bt_consultas.add(jMenu3);

        jMenuBar1.add(bt_consultas);

        bt_arquivos.setBackground(new java.awt.Color(255, 255, 255));
        bt_arquivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconesPDV/Tela.png"))); // NOI18N
        bt_arquivos.setText("  Arquivos");
        bt_arquivos.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jMenuItem38.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem38.setText("Ponto de Vendas (PDV - Simples)");
        jMenuItem38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem38ActionPerformed(evt);
            }
        });
        bt_arquivos.add(jMenuItem38);

        menu_pdv.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        menu_pdv.setText("Ponto de Vendas (PDV - Completo)");
        menu_pdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_pdvActionPerformed(evt);
            }
        });
        bt_arquivos.add(menu_pdv);

        jMenuItem24.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem24.setText("Comandas (CDV)");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        bt_arquivos.add(jMenuItem24);
        bt_arquivos.add(jSeparator1);

        jMenu1.setText("Cadastros");

        jMenuItem7.setText("Produtos");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem53.setText("Comandas");
        jMenuItem53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem53ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem53);

        jMenuItem4.setText("Clientes");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Fornecedores");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Transportadoras");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem20.setText("Funcionários");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem20);

        jMenuItem40.setText("Formas de Pagamentos");
        jMenuItem40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem40ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem40);

        bt_arquivos.add(jMenu1);

        jMenu6.setText("Motivos");

        jMenuItem48.setText("Motivos de Cancelamento");
        jMenuItem48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem48ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem48);

        jMenuItem50.setText("Motivos de Saida de Caixa");
        jMenuItem50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem50ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem50);

        bt_arquivos.add(jMenu6);
        bt_arquivos.add(jSeparator3);

        jMenu2.setText("Despesas");

        jMenuItem10.setText("Despesas e transferências");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuItem12.setText("Tipos de despesas");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem12);

        bt_arquivos.add(jMenu2);

        jMenuBar1.add(bt_arquivos);

        bt_movimentos.setBackground(new java.awt.Color(255, 255, 255));
        bt_movimentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconesPDV/Carrinho.png"))); // NOI18N
        bt_movimentos.setText("  Movimentos");
        bt_movimentos.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jMenu8.setText("Caixa");

        jMenuItem8.setText("Abertura de Caixa");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem8);

        jMenuItem49.setText("Fechamento de Caixa Parcial");
        jMenuItem49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem49ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem49);

        jMenuItem57.setText("Fechamento de Caixa Geral");
        jMenuItem57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem57ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem57);

        jMenuItem52.setText("Saida de Caixa (Sangria)");
        jMenuItem52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem52ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem52);

        bt_movimentos.add(jMenu8);

        jMenuItem44.setText("Manutenção de Vendas");
        jMenuItem44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem44ActionPerformed(evt);
            }
        });
        bt_movimentos.add(jMenuItem44);

        jMenuItem1.setText("Movimentação Bancária");
        bt_movimentos.add(jMenuItem1);

        jMenuBar1.add(bt_movimentos);

        bt_relatorios.setBackground(new java.awt.Color(255, 255, 255));
        bt_relatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconesPDV/Relatorios.png"))); // NOI18N
        bt_relatorios.setText("  Relatórios");
        bt_relatorios.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jMenu11.setText("Relatório de Vendas");

        jMenuItem43.setText("Relatório Geral");
        jMenuItem43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem43ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem43);

        jMenuItem46.setText("Relatório por Itens");
        jMenuItem46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem46ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem46);
        jMenu11.add(jSeparator5);

        jMenuItem14.setText("Relatório de comparativo de Metas");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem14);

        bt_relatorios.add(jMenu11);

        jMenu12.setText("Relatório de Pagamentos");

        jMenuItem59.setText("Relatório Consolidado");
        jMenuItem59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem59ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem59);

        jMenuItem63.setText("Relatório por Forma de Pagamento");
        jMenuItem63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem63ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem63);

        bt_relatorios.add(jMenu12);

        jMenu13.setText("Relatório de Produtos");

        jMenuItem16.setText("Relatórios de produtos mais vendidos");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem16);

        bt_relatorios.add(jMenu13);

        jMenuItem27.setText("Fechamento de Caixa");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        bt_relatorios.add(jMenuItem27);

        jMenuBar1.add(bt_relatorios);

        bt_parametros.setBackground(new java.awt.Color(255, 255, 255));
        bt_parametros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconesPDV/Editar.png"))); // NOI18N
        bt_parametros.setText("  Parâmetros");
        bt_parametros.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jMenuItem15.setText("Parâmetros");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        bt_parametros.add(jMenuItem15);

        jMenuBar1.add(bt_parametros);

        bt_especiais.setBackground(new java.awt.Color(255, 255, 255));
        bt_especiais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconesPDV/Adicionar.png"))); // NOI18N
        bt_especiais.setText("Especiais");
        bt_especiais.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jMenuBar1.add(bt_especiais);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 328, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        CarregarAbas();
        
        setTitle("Modulo de Vendas: " + fc.FormataCampo(String.valueOf(parametrosNS.bge.CodigoGrupo), 2, 0) + "." + parametrosNS.bge.NomeGrupo + " - " + fc.FormataCampo(String.valueOf(parametrosNS.be.CodigoEmpresa), 3, 0) + "." + parametrosNS.be.NomeEmpresa);
        
        txt_rodape.setText("Usuario: " + parametrosNS.bu.usuario);
        
        bloquearMenus();
        if(parametrosNS.bcomp.funcaoComputador.equalsIgnoreCase("pdv")){
            Modo = "S";
            AbrePDV();
        }
    }//GEN-LAST:event_formWindowOpened
    
    private void jMenuItem40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem40ActionPerformed
        if(ForDePagCad != null)if(ForDePagCad.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        ForDePagCad = new FormasDePagamentoCadastro("N" ,0);
        ForDePagCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem40ActionPerformed

    private void jMenuItem41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem41ActionPerformed
        if(ForDePagCad != null)if(ForDePagCon.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        ForDePagCon = new FormasDePagamentoConsulta("N");
        ForDePagCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem41ActionPerformed

    private void jMenuItem42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem42ActionPerformed
        if(VenConMan != null)if(VenConMan.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add("N");
        VenConMan = new VendasConsultaEManutencao(parametros);
        VenConMan.setVisible(true);
    }//GEN-LAST:event_jMenuItem42ActionPerformed

    private void jMenuItem44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem44ActionPerformed
        if(VenConMan != null)if(VenConMan.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add("S");
        VenConMan = new VendasConsultaEManutencao(parametros);
        VenConMan.setVisible(true);
    }//GEN-LAST:event_jMenuItem44ActionPerformed

    private void jMenuItem45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem45ActionPerformed
        if(ProCon != null)if(ProCon.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add("Codigo");
        ProCon = new ProdutosConsulta(parametros);
        ProCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem45ActionPerformed

    private void jMenuItem47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem47ActionPerformed
        if(ConCan != null)if(ConCan.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        ConCan = new CancelamentosConsulta("N");
        ConCan.setVisible(true);
    }//GEN-LAST:event_jMenuItem47ActionPerformed

    private void jMenuItem48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem48ActionPerformed
        if(CadCan != null)if(CadCan.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        CadCan = new CancelamentosCadastro("N", 0);
        CadCan.setVisible(true);
    }//GEN-LAST:event_jMenuItem48ActionPerformed

    private void jMenuItem46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem46ActionPerformed
        if(RelVen != null)if(RelVen.isVisible()){//Relatório por Itens
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        RelVen = new RelatorioDeVendas();
        RelVen.Modo = "";
        RelVen.setVisible(true);
    }//GEN-LAST:event_jMenuItem46ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        if(AberDeCaixa != null)if(AberDeCaixa.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        AberDeCaixa = new AberturaDeCaixa();
        AberDeCaixa.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem49ActionPerformed
        if(FecDeCaixa != null)if(FecDeCaixa.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        FecDeCaixa = new FechamentoDeCaixa("X");
        FecDeCaixa.setVisible(true);
    }//GEN-LAST:event_jMenuItem49ActionPerformed

    private void jMenuItem50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem50ActionPerformed
        if(MotDeSaiDeCaiCad != null)if(MotDeSaiDeCaiCad.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        MotDeSaiDeCaiCad = new MotivosDeSaidaDeCaixaCadastro(parametros);
        MotDeSaiDeCaiCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem50ActionPerformed

    private void jMenuItem51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem51ActionPerformed
        if(MotDeSaiDeCaiCon != null)if(MotDeSaiDeCaiCon.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        MotDeSaiDeCaiCon = new MotivosDeSaidaDeCaixaConsulta(parametros);
        MotDeSaiDeCaiCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem51ActionPerformed

    private void jMenuItem52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem52ActionPerformed
        if(SaiDeCaixaCad != null)if(SaiDeCaixaCad.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        SaiDeCaixaCad = new SaidaDeCaixaCadastro(parametros);
        SaiDeCaixaCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem52ActionPerformed

    private void jMenuItem53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem53ActionPerformed
        if(ComCad != null)if(ComCad.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        ComCad = new ComandasCadastro(parametros);
        ComCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem53ActionPerformed

    private void jMenuItem54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem54ActionPerformed
        if(ComCon != null)if(ComCon.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add("");
        ComCon = new ComandasConsulta(parametros);
        ComCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem54ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        if(GerCom != null)if(GerCom.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add("");
        GerCom = new GerenciarComandas(parametros);
        GerCom.setVisible(true);
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem57ActionPerformed
        if(FecDeCaixa != null)if(FecDeCaixa.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        FecDeCaixa = new FechamentoDeCaixa("Z");
        FecDeCaixa.setVisible(true);
    }//GEN-LAST:event_jMenuItem57ActionPerformed
    
    private void Sair(){
        dispose();
        if(MenPri           != null)MenPri          .dispose();
        if(AberDeCaixa      != null)AberDeCaixa     .dispose();
        if(ComCad           != null)ComCad          .dispose();
        if(ComCon           != null)ComCon          .dispose();
        if(CadCan           != null)CadCan          .dispose();
        if(ConCan           != null)ConCan          .dispose();
        if(GerCom           != null)GerCom          .dispose();
        if(FecDeCaixa       != null)FecDeCaixa      .dispose();
        if(ForDePagCad      != null)ForDePagCad     .dispose();
        if(ForDePagCon      != null)ForDePagCon     .dispose();
        if(InfCPFouCNPJ     != null)InfCPFouCNPJ    .dispose();
        if(MotDeSaiDeCaiCad != null)MotDeSaiDeCaiCad.dispose();
        if(MotDeSaiDeCaiCon != null)MotDeSaiDeCaiCon.dispose();
        if(OrcCad           != null)OrcCad          .dispose();
        if(OrcCon           != null)OrcCon          .dispose();
        if(Pdv              != null)Pdv             .dispose();
        if(ProCon           != null)ProCon          .dispose();
        if(RelVen           != null)RelVen          .dispose();
        if(RelFecCaiGer     != null)RelFecCaiGer    .dispose();
        if(SaiDeCaixaCad    != null)SaiDeCaixaCad   .dispose();
        if(VenConMan        != null)VenConMan       .dispose();
        if(IntDat           != null)IntDat          .dispose();
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

    private void jMenuItem39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem39ActionPerformed
        tipoRelatorio = "Produtos Vendidos";
        if(IntDat != null)if(IntDat.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        IntDat = new IntervaloDatas(tipoRelatorio);
        IntDat.setVisible(true);
    }//GEN-LAST:event_jMenuItem39ActionPerformed

    private void jMenuItem58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem58ActionPerformed
        if(IntDat != null)if(IntDat.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        tipoRelatorio = "Formas de Pagamento";
        IntDat = new IntervaloDatas(tipoRelatorio);
        IntDat.setVisible(true);
    }//GEN-LAST:event_jMenuItem58ActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){
            dispose();
        }
//        if(parametrosNS.bcomp.funcaoComputador.equals("logout")){
//            dispose();
//        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
        if(RelFecCaiGer != null)if(RelFecCaiGer.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        RelFecCaiGer = new RelatorioFechamentoCaixaGeral();
        RelFecCaiGer.setVisible(true);
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if(ProCad != null)if(ProCad.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        ProCad = new ProdutosCadastro("N", 0);
        ProCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if(CliCad != null)if(CliCad.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        CliCad = new ClientesCadastro("N", 0);
        CliCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if(ForCad != null)if(ForCad.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        ForCad = new FornecedorCadastro("N", 0);
        ForCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        if(TransCad != null)if(TransCad.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        TransCad = new TransportadoraCadastro(parametros);
        TransCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if(CliCon != null)if(CliCon.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        CliCon = new ClientesConsulta("N");
        CliCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        if(ForCon != null)if(ForCon.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        ForCon = new FornecedorConsulta("N");
        ForCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem37ActionPerformed
        if(TransCon != null)if(TransCon.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        TransCon = new TransportadoraConsulta(parametros);
        TransCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem37ActionPerformed

    private void jMenuItem38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem38ActionPerformed
        Modo = "S";
        AbrePDV();
    }//GEN-LAST:event_jMenuItem38ActionPerformed
    
    private void AbrePDV(){
        if(Pdv != null)if(Pdv.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        parametros.add(0);
        parametros.add(0);
        parametros.add("");
        Pdv = new PDV(parametros);
        Pdv.Modo = Modo;
        Pdv.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Pdv.setVisible(true);
    }
    
    private void menu_pdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_pdvActionPerformed
        Modo = "";
        AbrePDV();
    }//GEN-LAST:event_menu_pdvActionPerformed

    private void jMenuItem43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem43ActionPerformed
        if(RelVen != null)if(RelVen.isVisible()){//Relatório Geral
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        RelVen = new RelatorioDeVendas();
        RelVen.Modo = "VPP";//Venda Por Periodo
        RelVen.setVisible(true);
    }//GEN-LAST:event_jMenuItem43ActionPerformed

    private void jMenuItem59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem59ActionPerformed
        if(RelVen != null)if(RelVen.isVisible()){//Relatório Consolidado
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        RelVen = new RelatorioDeVendas();
        RelVen.Modo = "GPPP";//Geral Pagamento Por Periodo
        RelVen.setVisible(true);
    }//GEN-LAST:event_jMenuItem59ActionPerformed

    private void jMenuItem63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem63ActionPerformed
        if(RelVen != null)if(RelVen.isVisible()){//Relatório por Forma de Pagamento
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        RelVen = new RelatorioDeVendas();
        RelVen.Modo = "DPPP";//Diário Pagamento Por Periodo
        RelVen.setVisible(true);
    }//GEN-LAST:event_jMenuItem63ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        if(ParVen != null){
            if(ParVen.isVisible()){
                ParVen.setState(JFrame.NORMAL);
                return;
            }
        }
        ParVen = new ParametrosVendas();
        ParVen.setVisible(true);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        if(RelDeProVen != null){
            if(RelDeProVen.isVisible()){
                RelDeProVen.setState(JFrame.NORMAL);
                return;
            }
        }
        RelDeProVen = new RelatorioDeProdutosVendidos();
        RelDeProVen.setVisible(true);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem64ActionPerformed
        if(FunCon != null)if(FunCon.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        FunCon = new FuncionariosConsulta("N");
        FunCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem64ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        if(FunCad != null)if(FunCad.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        FunCad = new FuncionariosCadastro("N", 0);
        FunCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem61ActionPerformed

    }//GEN-LAST:event_jMenuItem61ActionPerformed

    private void jMenuItem55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem55ActionPerformed
        if(OrcCad != null)if(OrcCad.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        OrcCad = new OrcamentosCadastro(parametros);
        OrcCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem55ActionPerformed

    private void jMenuItem62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem62ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem62ActionPerformed

    private void jMenuItem60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem60ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem60ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        if(DesCad != null)if(DesCad.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        DesCad = new DespesasCadastro("N", 0);
        DesCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        if(DesCadTipo != null)if(DesCad.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        DesCadTipo = new DespesasTipoCadastro(parametros);
        DesCadTipo.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        if(DesCon != null)if(DesCon.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        DesCon = new DespesasConsulta("N");
        DesCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        if(DesConTipo != null)if(DesConTipo.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        parametros.clear();
        parametros.add("N");
        DesConTipo = new DespesasTipoConsulta(parametros);
        DesConTipo.setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        if(RelDeVenMenPorUsu != null)if(RelDeVenMenPorUsu.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        RelDeVenMenPorUsu = new RelatorioDeVendasMensalPorUsuario();
        RelDeVenMenPorUsu.setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu bt_arquivos;
    private javax.swing.JMenu bt_consultas;
    private javax.swing.JMenu bt_especiais;
    private javax.swing.JMenu bt_movimentos;
    private javax.swing.JMenu bt_parametros;
    private javax.swing.JMenu bt_relatorios;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
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
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem24;
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
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem37;
    private javax.swing.JMenuItem jMenuItem38;
    private javax.swing.JMenuItem jMenuItem39;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem40;
    private javax.swing.JMenuItem jMenuItem41;
    private javax.swing.JMenuItem jMenuItem42;
    private javax.swing.JMenuItem jMenuItem43;
    private javax.swing.JMenuItem jMenuItem44;
    private javax.swing.JMenuItem jMenuItem45;
    private javax.swing.JMenuItem jMenuItem46;
    private javax.swing.JMenuItem jMenuItem47;
    private javax.swing.JMenuItem jMenuItem48;
    private javax.swing.JMenuItem jMenuItem49;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem50;
    private javax.swing.JMenuItem jMenuItem51;
    private javax.swing.JMenuItem jMenuItem52;
    private javax.swing.JMenuItem jMenuItem53;
    private javax.swing.JMenuItem jMenuItem54;
    private javax.swing.JMenuItem jMenuItem55;
    private javax.swing.JMenuItem jMenuItem57;
    private javax.swing.JMenuItem jMenuItem58;
    private javax.swing.JMenuItem jMenuItem59;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem60;
    private javax.swing.JMenuItem jMenuItem61;
    private javax.swing.JMenuItem jMenuItem62;
    private javax.swing.JMenuItem jMenuItem63;
    private javax.swing.JMenuItem jMenuItem64;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JMenuItem menu_pdv;
    private javax.swing.JLabel txt_rodape;
    private javax.swing.JLabel txt_rodape1;
    // End of variables declaration//GEN-END:variables
    
    private void mostraMensagem() {
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    private void gerarRelatorioCargos() {
            try {
            String arquivoJasper = null;
            String c = null;
            JasperPrint rel = null;
            //Connection con = FabricaConexao.getConexao();

            HashMap map = new HashMap();

            arquivoJasper = "Relatorios\\relatorioCargos.jasper";
           

            try{
                rel = JasperFillManager.fillReport(arquivoJasper, map, parametrosNS.con);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "visualizar relatorioCargos" + e);
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
                //JasperFillManager.fillReport(arquivoJasper, map, con);
            JasperViewer.viewReport(rel, false);

            //this.setVisible(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "O erro foi no relatorioCargos: " + e);
        }
    }

    private void gerarRelatorioAcesso() {
        
        try {
            String arquivoJasper = null;
            String c = null;
            JasperPrint rel = null;
            //Connection con = FabricaConexao.getConexao();

            HashMap map = new HashMap();

            arquivoJasper = "Relatorios\\relatorioAcesso.jasper";
            try{
                rel = JasperFillManager.fillReport(arquivoJasper, map, parametrosNS.con);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "visualizar relatorioAcesso" + e);
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
                //JasperFillManager.fillReport(arquivoJasper, map, con);
            JasperViewer.viewReport(rel, false);

            //this.setVisible(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "O erro foi no relatorioAcesso: " + e);
        }
    }

//    public void carregarTabelaComandas() {
//        ArrayList Tabela = new ArrayList();
//        
//        sql = "select * from tb_comanda;";
//        
//        Tabela = dc.ConsultaComanda(sql);
//        preencherTabelaComandas();
//    }

//    public void preencherTabelaComandas() {
//        DefaultTableModel Table = (DefaultTableModel)tabela_comanda.getModel();
//        Table.setNumRows(0);
//        
//        for(int i = 0; i < Tabela.size(); i++){
//            int    CODIGO       = ((beanComandas)(Tabela.get(i))).getCODIGO();
//            String COMANDA         = ((beanComandas)(Tabela.get(i))).getCODBARRAS();
//            String STATUS      = ((beanComandas)(Tabela.get(i))).getSTATUS();
//           
//            
//            Table.addRow(new Object [] {String.valueOf(CODIGO), COMANDA, STATUS});
//        }
//    }
    
    String Valor = "";

    private void bloquearMenus() {
//        bt_parametros.setEnabled(false); // por enquanto - Tiago e Guilherme 06/01/2016 paula bixa at 18:39
//        bt_especiais.setEnabled(true); // tiago 22/01/2016 as 13:38
//        bt_sair2.setEnabled(true);
        //Consultas.setEnabled(false);
        
        //=== Vendas   ===//
//        menuGestao.setEnabled(true);
//        m_Orcamentos.setEnabled(false);
//        trocas.setEnabled(false);
        //=== Arquivos ===//
    //    malaDireta.setEnabled(false); liberado 10/12/2015 por Tiago at 15:52
    }

//    public void gravaTxt() throws IOException{
//        String nomeArq = (User) + "conec" + con;
//        
//        
//        //FileWriter arq = new FileWriter("c://NSYS/logVenda.txt");
//        FileWriter arq = new FileWriter("logs/pdv-"+nomeArq+".txt");
//        PrintWriter gravarArq = new PrintWriter(arq);
//        gravarArq.println((User));
//        gravarArq.println((cdh.CapturaHora()));
//        gravarArq.println((cdh.CapturaHora()));
//        gravarArq.println((ipv4));
//        gravarArq.println((String.valueOf(NomeMachine)));
//        gravarArq.println("--------------------------------");
//        gravarArq.println("ok - tiago 22/12/2015");
//        gravarArq.println("");
//                arq.close();
//    }

    private void estoque() {
//        parametros.clear();
//        parametros.add(bu.CODIGOUSUARIO);
//        parametros.add("CODIGO");
//        parametros.add("N");
//        gerenciarEstoque ge = new gerenciarEstoque(con, parametros, dadosEmpresa);
//        ge.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        ge.setVisible(true);
    }
    
}
