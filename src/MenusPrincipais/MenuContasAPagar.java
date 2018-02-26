package MenusPrincipais;

import Telas.MenuPrincipal;
import BeansNS.BeanBancoDados;
import BeansNS.BeanEmpresas;
import BeansNS.BeanGrupoEmpresa;
import Beans.*;
import FuncoesInternas.*;
import Parametros.parametrosNS;
import Telas.BancosConsulta;
import TelasContasCorrente.ContaCorrenteCadastro;
import TelasContasCorrente.ContaCorrenteConsulta;
import TelasFinanceiro.DespesasCadastro;
import TelasFinanceiro.DespesasConsulta;
import TelasFinanceiro.DespesasTipoCadastro;
import TelasFinanceiro.DespesasTipoConsulta;
import java.util.*;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;

import org.jfree.data.category.DefaultCategoryDataset;

/*
 @author Tiago e Paulo
 */
public class MenuContasAPagar extends javax.swing.JFrame {
    //String
    String sql                      = "";
    String sqlstate                 = "";
    String mensagem                 = "";
    
    //int
    int    TotalDespesasCadastradas = 0;
    int    TotalDespesasAVencer     = 0;
    int    TotalDespesasVencidas    = 0;
    int    TotalDespesasPagas       = 0;
    int    TotalDespesasEmAberto    = 0;
    int    dataVencimento           = 0;
    int    dataAtual                = 0;
    
    //Beans
    BeanGrupoEmpresa        bge     = new BeanGrupoEmpresa();
    BeanDespesas            bdes    = new BeanDespesas();
    BeanEmpresas            be      = new BeanEmpresas();
    BeanBancoDados          bbd     = new BeanBancoDados();
    BeanUsuarios            bu      = new BeanUsuarios();
    BeanModulos             bm      = new BeanModulos();
    
    //Vetores padroes não alterar
    ArrayList            parametros            = new ArrayList();
    ArrayList<ArrayList> dadosDespesas         = new ArrayList();
    
    //Especiais
    CapturarDataHora        cdh     = new CapturarDataHora();
    TestarData              Test    = new TestarData();
    InverterData            invdata = new InverterData();
    FormataCampo            fc      = new FormataCampo();
    
    //Telas
    JFrame                  Frame;
    MenuPrincipal           MenPri;
    BancosConsulta          BanCon;
    ContaCorrenteCadastro   ConCorCad;
    ContaCorrenteConsulta   ConCorCon;
    DespesasCadastro        DesCad;
    DespesasConsulta        DesCon;
    DespesasTipoCadastro    DesCadTipo;
    DespesasTipoConsulta    DesConTipo;
    
    public MenuContasAPagar(JFrame frame){
        initComponents();
        Frame       = frame;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    private void CarregarAbas() {
        bm.abasContasAPagar = parametrosNS.bm.abasContasAPagar;
        bm.abaConsultas     = bm.abasContasAPagar.substring(0, 1);
        bm.abaArquivo       = bm.abasContasAPagar.substring(1, 2);
        bm.abaMovimentos    = bm.abasContasAPagar.substring(2, 3);
        bm.abaRelatorios    = bm.abasContasAPagar.substring(3, 4);
        bm.abaParametros    = bm.abasContasAPagar.substring(4, 5);
        bm.abaEspeciais     = bm.abasContasAPagar.substring(5, 6);
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

        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txt_rodape = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_totalDespesasCadastradas = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_totalDespesasAVencer = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_totalDespesasVencidas = new javax.swing.JTextField();
        txt_totalDespesasPagas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_totalDespesasEmAberto = new javax.swing.JTextField();
        painel_dashboard = new javax.swing.JPanel();
        dashboard1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        bt_consultas = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem10 = new javax.swing.JMenuItem();
        bt_arquivos = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        bt_movimentos = new javax.swing.JMenu();
        bt_relatorios = new javax.swing.JMenu();
        bt_parametros = new javax.swing.JMenu();
        bt_especiais = new javax.swing.JMenu();

        jButton1.setText("Despesas e transferências");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Contas bancárias");
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("Relatório de despesas");
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jButton2.setText("Relatório de transferências");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
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

        txt_totalDespesasCadastradas.setEditable(false);
        txt_totalDespesasCadastradas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_totalDespesasCadastradas.setFocusable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Total de despesas cadastradas:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Total de despesas a vencer:");

        txt_totalDespesasAVencer.setEditable(false);
        txt_totalDespesasAVencer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_totalDespesasAVencer.setFocusable(false);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Total de despesas vencidas:");

        txt_totalDespesasVencidas.setEditable(false);
        txt_totalDespesasVencidas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_totalDespesasVencidas.setFocusable(false);

        txt_totalDespesasPagas.setEditable(false);
        txt_totalDespesasPagas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_totalDespesasPagas.setFocusable(false);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Total de despesas pagas:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Total de despesas em aberto:");

        txt_totalDespesasEmAberto.setEditable(false);
        txt_totalDespesasEmAberto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_totalDespesasEmAberto.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_totalDespesasAVencer)
                    .addComponent(txt_totalDespesasCadastradas, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(txt_totalDespesasVencidas)
                    .addComponent(txt_totalDespesasPagas)
                    .addComponent(txt_totalDespesasEmAberto))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel3, jLabel4, jLabel5, jLabel6});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_totalDespesasCadastradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_totalDespesasAVencer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_totalDespesasVencidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_totalDespesasPagas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_totalDespesasEmAberto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, txt_totalDespesasCadastradas});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel3, jLabel4, jLabel5, jLabel6, txt_totalDespesasAVencer, txt_totalDespesasEmAberto, txt_totalDespesasPagas, txt_totalDespesasVencidas});

        painel_dashboard.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        dashboard1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dashboard"));

        javax.swing.GroupLayout dashboard1Layout = new javax.swing.GroupLayout(dashboard1);
        dashboard1.setLayout(dashboard1Layout);
        dashboard1Layout.setHorizontalGroup(
            dashboard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );
        dashboard1Layout.setVerticalGroup(
            dashboard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout painel_dashboardLayout = new javax.swing.GroupLayout(painel_dashboard);
        painel_dashboard.setLayout(painel_dashboardLayout);
        painel_dashboardLayout.setHorizontalGroup(
            painel_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_dashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashboard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        painel_dashboardLayout.setVerticalGroup(
            painel_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_dashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashboard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bt_consultas.setBackground(new java.awt.Color(255, 255, 255));
        bt_consultas.setText("Consultas");

        jMenu1.setText("Despesas");

        jMenuItem2.setText("Despesas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Tipos de Despesas");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        bt_consultas.add(jMenu1);

        jMenuItem7.setText("Conta Corrente (Consulta)");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        bt_consultas.add(jMenuItem7);
        bt_consultas.add(jSeparator1);

        jMenuItem10.setText("Bancos");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        bt_consultas.add(jMenuItem10);

        jMenuBar1.add(bt_consultas);

        bt_arquivos.setBackground(new java.awt.Color(255, 255, 255));
        bt_arquivos.setText("Arquivos");

        jMenu2.setText("Despesas");

        jMenuItem1.setText("Despesas e transferências");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem4.setText("Tipos de despesas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        bt_arquivos.add(jMenu2);

        jMenuItem6.setText("Conta Corrente (Cadastro)");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        bt_arquivos.add(jMenuItem6);

        jMenuBar1.add(bt_arquivos);

        bt_movimentos.setBackground(new java.awt.Color(255, 255, 255));
        bt_movimentos.setText("Movimentos");
        jMenuBar1.add(bt_movimentos);

        bt_relatorios.setBackground(new java.awt.Color(255, 255, 255));
        bt_relatorios.setText("Relatórios");
        jMenuBar1.add(bt_relatorios);

        bt_parametros.setBackground(new java.awt.Color(255, 255, 255));
        bt_parametros.setText("Parâmetros");
        jMenuBar1.add(bt_parametros);

        bt_especiais.setBackground(new java.awt.Color(255, 255, 255));
        bt_especiais.setText("Especiais");
        jMenuBar1.add(bt_especiais);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painel_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painel_dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(DesCad != null)if(DesCad.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        DesCad = new DespesasCadastro("N", 0);
        DesCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if(DesCon != null)if(DesCon.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        DesCon = new DespesasConsulta("N");
        DesCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
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
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if(DesConTipo != null)if(DesConTipo.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        parametros.clear();
        parametros.add("N");
        DesConTipo = new DespesasTipoConsulta(parametros);
        DesConTipo.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        painel_dashboard.setVisible(false);
        CarregarAbas();
        setTitle("Módulo de Contas à Pagar: " + fc.FormataCampo(String.valueOf(parametrosNS.bge.CodigoGrupo), 2, 0) + "." + parametrosNS.bge.NomeGrupo + " - " + fc.FormataCampo(String.valueOf(parametrosNS.be.CodigoEmpresa), 3, 0) + "." + parametrosNS.be.NomeEmpresa);
        
        txt_rodape.setText("Usuario: " + parametrosNS.bu.usuario);
        PegaDespesas();
        
        criaGrafico();
    }//GEN-LAST:event_formWindowOpened
        
    private void Sair(){
        dispose();
        if(DesCad       != null)DesCad      .dispose();
        if(DesCon       != null)DesCon      .dispose();
        if(DesCadTipo   != null)DesCadTipo  .dispose();
        if(DesConTipo   != null)DesConTipo  .dispose();
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
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003"))
            dispose();
    }//GEN-LAST:event_formWindowGainedFocus

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(DesCad != null)if(DesCad.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        DesCad = new DespesasCadastro("N", 0);
        DesCad.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        criaGrafico();
    }//GEN-LAST:event_formWindowStateChanged

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        criaGrafico();
    }//GEN-LAST:event_formComponentResized

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        if(ConCorCad   != null)if(ConCorCad.isVisible()){
            mensagem = "Tela já Aberta!";
            mostraMensagem();
            return;
        }
        ConCorCad = new ContaCorrenteCadastro("N", 0);
        ConCorCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if(ConCorCon   != null)if(ConCorCon.isVisible()){
            mensagem = "Tela já Aberta!";
            mostraMensagem();
            return;
        }
        ConCorCon = new ContaCorrenteConsulta("N");
        ConCorCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        if(BanCon   != null)if(BanCon.isVisible()){
            mensagem = "Tela já Aberta!";
            mostraMensagem();
            return;
        }
        BanCon = new BancosConsulta();
        BanCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu bt_arquivos;
    private javax.swing.JMenu bt_consultas;
    private javax.swing.JMenu bt_especiais;
    private javax.swing.JMenu bt_movimentos;
    private javax.swing.JMenu bt_parametros;
    private javax.swing.JMenu bt_relatorios;
    private javax.swing.JPanel dashboard1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    public static transient volatile javax.swing.JPanel painel_dashboard;
    private javax.swing.JLabel txt_rodape;
    private javax.swing.JTextField txt_totalDespesasAVencer;
    private javax.swing.JTextField txt_totalDespesasCadastradas;
    private javax.swing.JTextField txt_totalDespesasEmAberto;
    private javax.swing.JTextField txt_totalDespesasPagas;
    private javax.swing.JTextField txt_totalDespesasVencidas;
    // End of variables declaration//GEN-END:variables
    
    private void PegaDespesas(){
        sql = "select "
              + "   idDespesa, \n"
              + "   idEmpresa, \n"
              + "   codigoGrupo, \n"
              + "   codigoEmpresa, \n"
              + "   codigoDespesa, \n"
              + "   valorDespesa, \n"
              + "   valorPago, \n"
              + "   dataVencimento, \n"
              + "   dataPagamento \n"
              + "from "
              + "   tb_despesas where \n"
              + "   idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosDespesas.clear();
        dadosDespesas = parametrosNS.dao.Consulta(sql);
        PegaDadosDespesas();
    }
    
    private void PegaDadosDespesas(){
        TotalDespesasCadastradas = 0;
        TotalDespesasAVencer     = 0;
        TotalDespesasVencidas    = 0;
        TotalDespesasPagas       = 0;
        TotalDespesasEmAberto    = 0;
        for(int i = 0; i < dadosDespesas.size(); i++){
            bdes = new BeanDespesas();
            if(dadosDespesas.get(i).get(0) != null)
                bdes.idDespesa              = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(0)));
            if(dadosDespesas.get(i).get(1) != null)
                bdes.idEmpresa              = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(1)));
            if(dadosDespesas.get(i).get(2) != null)
                bdes.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(2)));
            if(dadosDespesas.get(i).get(3) != null)
                bdes.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(3)));
            if(dadosDespesas.get(i).get(4) != null)
                bdes.codigoDespesa          = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(4)));
            if(dadosDespesas.get(i).get(5) != null)
                bdes.valorDespesa           = Double.parseDouble(String.valueOf(dadosDespesas.get(i).get(5)));
            if(dadosDespesas.get(i).get(6) != null)
                bdes.valorPago              = Double.parseDouble(String.valueOf(dadosDespesas.get(i).get(6)));
                bdes.dataVencimento         =                    String.valueOf(dadosDespesas.get(i).get(7));
                bdes.dataPagamento          =                    String.valueOf(dadosDespesas.get(i).get(8));
            
            dataVencimento  = Test.Testa(invdata.inverterData(bdes.dataVencimento, 1));
            dataAtual       = Test.Testa(cdh.CapturarData());
            if(bdes.dataPagamento != null){
                bdes.dataPagamento      = bdes.dataPagamento.replace("-", "");
                bdes.dataPagamento      = bdes.dataPagamento.replace(" ", "");
            }else
                bdes.dataPagamento = "";
            
            TotalDespesasCadastradas++;
            if(dataVencimento - dataAtual >= 0 && dataVencimento - dataAtual <= 10 && bdes.valorDespesa >  bdes.valorPago){
                TotalDespesasAVencer   ++;continue;
            }
            if(bdes.valorDespesa >  bdes.valorPago && dataVencimento < dataAtual){
                TotalDespesasVencidas  ++;continue;
            }
            if(!bdes.dataPagamento.equals(""))
                TotalDespesasPagas++;
            else
                TotalDespesasEmAberto++;
        }
        txt_totalDespesasCadastradas.setText(String.valueOf(TotalDespesasCadastradas));
        txt_totalDespesasAVencer    .setText(String.valueOf(TotalDespesasAVencer));
        txt_totalDespesasVencidas   .setText(String.valueOf(TotalDespesasVencidas));
        txt_totalDespesasPagas      .setText(String.valueOf(TotalDespesasPagas));
        txt_totalDespesasEmAberto   .setText(String.valueOf(TotalDespesasEmAberto));
    }
    
    private CategoryDataset createDataset() { 
        DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
        dataset.addValue(1000.0,"01/2012","Mês/Ano");
        dataset.addValue(1750.0,"02/2012","Mês/Ano");
        dataset.addValue(1500.0,"03/2012","Mês/Ano");
        return dataset; 
    }
    
    public void criaGrafico() {
        CategoryDataset cds = createDataset();
        String titulo = "Gráfico de Teste";
        String eixoy = "Valores";
        String txt_legenda = "Ledenda:";
        boolean legenda = true;
        boolean tooltips = true;
        boolean urls = true;
        JFreeChart graf = ChartFactory.createLineChart(titulo, txt_legenda, eixoy, cds, PlotOrientation.VERTICAL, legenda, tooltips, urls);
        ChartPanel myChartPanel = new ChartPanel(graf, true);
        myChartPanel.setSize(dashboard1.getWidth(),dashboard1.getHeight());
        myChartPanel.setVisible(true); 
        dashboard1.removeAll();
        dashboard1.add(myChartPanel); 
        dashboard1.revalidate();
        dashboard1.repaint(); 
    }

    private void mostraMensagem() {
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
}
