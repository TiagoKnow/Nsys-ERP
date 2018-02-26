package Parametros;

import Beans.BeanContaCorrente;
import Beans.BeanParametrosGestao;
import BeansNS.BeanBanco;
import BeansNS.BeanEmpresas;
import Parametros.parametrosNS;
import TelasContasCorrente.ContaCorrenteConsulta;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 @author Paulo
 */
public class ParametrosGestao extends javax.swing.JFrame {
    //String
    String sql                  = "";
    String sqlstate             = "";
    String mensagem             = "";
    String retorno              = "";
    String operacao             = "";
    String Modulo               = "";
    String numeroAgencia        = "";
    String numeroContaCorrente  = "";
    
    //int
    int    abriuContaCorrente = 0;
    
    //Bean
    BeanBanco            bb      = new BeanBanco();
    BeanContaCorrente    bcc     = new BeanContaCorrente();
    BeanEmpresas         be      = new BeanEmpresas();
    BeanParametrosGestao bparges = new BeanParametrosGestao();
    
    //ArrayList
    ArrayList<ArrayList> dadosContaCorrente    = new ArrayList();
    ArrayList<ArrayList> dadosParametrosGestao = new ArrayList();
    
    //Telas
    ContaCorrenteConsulta   ConCorCon;
    
    public ParametrosGestao(){
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_Boletos = new javax.swing.JLabel();
        txt_agenciaBoletos = new javax.swing.JTextField();
        txt_contaCorrenteBoletos = new javax.swing.JTextField();
        bt_pesquisaContaCorrenteBoletos = new javax.swing.JButton();
        txt_agenciaOrdensServico = new javax.swing.JTextField();
        txt_contaCorrenteOrdensServico = new javax.swing.JTextField();
        bt_pesquisaContaCorrenteOrdensServico = new javax.swing.JButton();
        jLabel_OrdensServico = new javax.swing.JLabel();
        txt_contaCorrenteRecibos = new javax.swing.JTextField();
        bt_pesquisaContaCorrenteRecibos = new javax.swing.JButton();
        txt_agenciaRecibos = new javax.swing.JTextField();
        jLabel_Recibos = new javax.swing.JLabel();
        jLabel_Vendas = new javax.swing.JLabel();
        txt_agenciaVendas = new javax.swing.JTextField();
        bt_pesquisaContaCorrenteVendas = new javax.swing.JButton();
        txt_contaCorrenteVendas = new javax.swing.JTextField();
        check_contaCorrentePadraoVendas = new javax.swing.JCheckBox();
        check_contaCorrentePadraoRecibos = new javax.swing.JCheckBox();
        check_contaCorrentePadraoOrdensServico = new javax.swing.JCheckBox();
        check_contaCorrentePadraoBoletos = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        label_descricaoBoletos = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        label_descricaoOrdensServico = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        label_descricaoRecibos = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        label_descricaoVendas = new javax.swing.JTextArea();
        bt_confirma = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Confirguações de contas correntes");
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Parâmetros");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel_Boletos.setText("Conta corrente padrão para boletos:");

        txt_agenciaBoletos.setEditable(false);
        txt_agenciaBoletos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_agenciaBoletos.setToolTipText("Agência");
        txt_agenciaBoletos.setFocusable(false);

        txt_contaCorrenteBoletos.setEditable(false);
        txt_contaCorrenteBoletos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_contaCorrenteBoletos.setToolTipText("Conta Corrente");
        txt_contaCorrenteBoletos.setFocusable(false);

        bt_pesquisaContaCorrenteBoletos.setText("jButton1");
        bt_pesquisaContaCorrenteBoletos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaContaCorrenteBoletosActionPerformed(evt);
            }
        });

        txt_agenciaOrdensServico.setEditable(false);
        txt_agenciaOrdensServico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_agenciaOrdensServico.setToolTipText("Agência");
        txt_agenciaOrdensServico.setFocusable(false);

        txt_contaCorrenteOrdensServico.setEditable(false);
        txt_contaCorrenteOrdensServico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_contaCorrenteOrdensServico.setToolTipText("Conta Corrente");
        txt_contaCorrenteOrdensServico.setFocusable(false);

        bt_pesquisaContaCorrenteOrdensServico.setText("jButton1");
        bt_pesquisaContaCorrenteOrdensServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaContaCorrenteOrdensServicoActionPerformed(evt);
            }
        });

        jLabel_OrdensServico.setText("Conta corrente padrão para ordens de serviço:");

        txt_contaCorrenteRecibos.setEditable(false);
        txt_contaCorrenteRecibos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_contaCorrenteRecibos.setToolTipText("Conta Corrente");
        txt_contaCorrenteRecibos.setFocusable(false);

        bt_pesquisaContaCorrenteRecibos.setText("jButton1");
        bt_pesquisaContaCorrenteRecibos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaContaCorrenteRecibosActionPerformed(evt);
            }
        });

        txt_agenciaRecibos.setEditable(false);
        txt_agenciaRecibos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_agenciaRecibos.setToolTipText("Agência");
        txt_agenciaRecibos.setFocusable(false);

        jLabel_Recibos.setText("Conta corrente padrão para recibos:");

        jLabel_Vendas.setText("Conta corrente padrão para vendas:");

        txt_agenciaVendas.setEditable(false);
        txt_agenciaVendas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_agenciaVendas.setToolTipText("Agência");
        txt_agenciaVendas.setFocusable(false);

        bt_pesquisaContaCorrenteVendas.setText("jButton1");
        bt_pesquisaContaCorrenteVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaContaCorrenteVendasActionPerformed(evt);
            }
        });

        txt_contaCorrenteVendas.setEditable(false);
        txt_contaCorrenteVendas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_contaCorrenteVendas.setToolTipText("Conta Corrente");
        txt_contaCorrenteVendas.setFocusable(false);

        check_contaCorrentePadraoVendas.setText("Utilizar a conta corrente padrão da empresa");
        check_contaCorrentePadraoVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_contaCorrentePadraoVendasActionPerformed(evt);
            }
        });

        check_contaCorrentePadraoRecibos.setText("Utilizar a conta corrente padrão da empresa");
        check_contaCorrentePadraoRecibos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_contaCorrentePadraoRecibosActionPerformed(evt);
            }
        });

        check_contaCorrentePadraoOrdensServico.setText("Utilizar a conta corrente padrão da empresa");
        check_contaCorrentePadraoOrdensServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_contaCorrentePadraoOrdensServicoActionPerformed(evt);
            }
        });

        check_contaCorrentePadraoBoletos.setText("Utilizar a conta corrente padrão da empresa");
        check_contaCorrentePadraoBoletos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_contaCorrentePadraoBoletosActionPerformed(evt);
            }
        });

        label_descricaoBoletos.setEditable(false);
        label_descricaoBoletos.setColumns(20);
        label_descricaoBoletos.setLineWrap(true);
        label_descricaoBoletos.setRows(5);
        label_descricaoBoletos.setFocusable(false);
        jScrollPane1.setViewportView(label_descricaoBoletos);

        label_descricaoOrdensServico.setEditable(false);
        label_descricaoOrdensServico.setColumns(20);
        label_descricaoOrdensServico.setLineWrap(true);
        label_descricaoOrdensServico.setRows(5);
        label_descricaoOrdensServico.setFocusable(false);
        jScrollPane2.setViewportView(label_descricaoOrdensServico);

        label_descricaoRecibos.setEditable(false);
        label_descricaoRecibos.setColumns(20);
        label_descricaoRecibos.setLineWrap(true);
        label_descricaoRecibos.setRows(5);
        label_descricaoRecibos.setFocusable(false);
        jScrollPane3.setViewportView(label_descricaoRecibos);

        label_descricaoVendas.setEditable(false);
        label_descricaoVendas.setColumns(20);
        label_descricaoVendas.setLineWrap(true);
        label_descricaoVendas.setRows(5);
        label_descricaoVendas.setFocusable(false);
        jScrollPane4.setViewportView(label_descricaoVendas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_Boletos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_OrdensServico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_Recibos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_Vendas, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_agenciaBoletos, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_contaCorrenteBoletos, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_pesquisaContaCorrenteBoletos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_agenciaOrdensServico, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_contaCorrenteOrdensServico, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_pesquisaContaCorrenteOrdensServico, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_agenciaRecibos, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_contaCorrenteRecibos, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_pesquisaContaCorrenteRecibos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_agenciaVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_contaCorrenteVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_pesquisaContaCorrenteVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(check_contaCorrentePadraoVendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(check_contaCorrentePadraoRecibos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(check_contaCorrentePadraoOrdensServico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(check_contaCorrentePadraoBoletos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Boletos)
                    .addComponent(txt_agenciaBoletos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_contaCorrenteBoletos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaContaCorrenteBoletos, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_contaCorrentePadraoBoletos, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_OrdensServico)
                    .addComponent(txt_agenciaOrdensServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_contaCorrenteOrdensServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaContaCorrenteOrdensServico, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_contaCorrentePadraoOrdensServico, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Recibos)
                    .addComponent(txt_agenciaRecibos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_contaCorrenteRecibos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaContaCorrenteRecibos, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_contaCorrentePadraoRecibos, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Vendas)
                    .addComponent(txt_agenciaVendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_contaCorrenteVendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaContaCorrenteVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_contaCorrentePadraoVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaContaCorrenteBoletos, check_contaCorrentePadraoBoletos, jLabel_Boletos, txt_agenciaBoletos, txt_contaCorrenteBoletos});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaContaCorrenteOrdensServico, check_contaCorrentePadraoOrdensServico, jLabel_OrdensServico, txt_agenciaOrdensServico, txt_contaCorrenteOrdensServico});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaContaCorrenteRecibos, check_contaCorrentePadraoRecibos, jLabel_Recibos, txt_agenciaRecibos, txt_contaCorrenteRecibos});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaContaCorrenteVendas, check_contaCorrentePadraoVendas, jLabel_Vendas, txt_agenciaVendas, txt_contaCorrenteVendas});

        bt_confirma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_confirma.setText("Confirma");
        bt_confirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmaActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        jButton2.setText("Sair");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_confirma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_confirma, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_confirma, jButton2});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        VerificaAcessoModulos();
        
        operacao = "I";
        PegaParametrosGestao();
    }//GEN-LAST:event_formWindowOpened
    
    private void VerificaAcessoModulos(){
        if(parametrosNS.bma.moduloCC == 0 || parametrosNS.bm.moduloCC == 0){
            jLabel_Boletos                 .setVisible(false);
            txt_agenciaBoletos             .setVisible(false);
            txt_contaCorrenteBoletos       .setVisible(false);
            bt_pesquisaContaCorrenteBoletos.setVisible(false);
            label_descricaoBoletos         .setVisible(false);
        }
        if(parametrosNS.bma.moduloProducao == 0 || parametrosNS.bm.moduloProducao == 0){
            jLabel_OrdensServico                 .setVisible(false);
            txt_agenciaOrdensServico             .setVisible(false);
            txt_contaCorrenteOrdensServico       .setVisible(false);
            bt_pesquisaContaCorrenteOrdensServico.setVisible(false);
            label_descricaoOrdensServico         .setVisible(false);
        }
        if(parametrosNS.bma.moduloRecebimento == 0 || parametrosNS.bm.moduloRecebimento == 0){
            jLabel_Recibos                 .setVisible(false);
            txt_agenciaRecibos             .setVisible(false);
            txt_contaCorrenteRecibos       .setVisible(false);
            bt_pesquisaContaCorrenteRecibos.setVisible(false);
            label_descricaoRecibos         .setVisible(false);
        }
        if(parametrosNS.bma.moduloVendas == 0 || parametrosNS.bm.moduloVendas == 0){
            jLabel_Vendas                 .setVisible(false);
            txt_agenciaVendas             .setVisible(false);
            txt_contaCorrenteVendas       .setVisible(false);
            bt_pesquisaContaCorrenteVendas.setVisible(false);
            label_descricaoVendas         .setVisible(false);
        }
    }
    
    private void bt_pesquisaContaCorrenteBoletosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaContaCorrenteBoletosActionPerformed
        if(ConCorCon != null)if(ConCorCon.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        abriuContaCorrente = 1;
        Modulo = "CC";
        ConCorCon = new ContaCorrenteConsulta("N");
        ConCorCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaContaCorrenteBoletosActionPerformed

    private void bt_pesquisaContaCorrenteOrdensServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaContaCorrenteOrdensServicoActionPerformed
        if(ConCorCon != null)if(ConCorCon.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        abriuContaCorrente = 1;
        Modulo = "Producao";
        ConCorCon = new ContaCorrenteConsulta("N");
        ConCorCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaContaCorrenteOrdensServicoActionPerformed

    private void bt_pesquisaContaCorrenteRecibosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaContaCorrenteRecibosActionPerformed
        if(ConCorCon != null)if(ConCorCon.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        abriuContaCorrente = 1;
        Modulo = "Recibos";
        ConCorCon = new ContaCorrenteConsulta("N");
        ConCorCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaContaCorrenteRecibosActionPerformed

    private void bt_pesquisaContaCorrenteVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaContaCorrenteVendasActionPerformed
        if(ConCorCon != null)if(ConCorCon.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        abriuContaCorrente = 1;
        Modulo = "Vendas";
        ConCorCon = new ContaCorrenteConsulta("N");
        ConCorCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaContaCorrenteVendasActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuContaCorrente == 0){
            return;
        }
        retorno = ConCorCon.getRetornoContaCorrente();
        if(retorno.equals("")){
            ReiniciaCampos();
            return;
        }
        bcc.idContaCorrente = Integer.parseInt(retorno);
        PegaContaCorrente();
    }//GEN-LAST:event_formWindowGainedFocus

    private void check_contaCorrentePadraoBoletosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_contaCorrentePadraoBoletosActionPerformed
        if(ConCorCon != null)if(ConCorCon.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        Modulo = "CC";
        if(check_contaCorrentePadraoBoletos.isSelected() == false){
            ReiniciaCampos();
            return;
        }
        abriuContaCorrente = 1;
        ConCorCon = new ContaCorrenteConsulta("P");
        ConCorCon.setVisible(true);
    }//GEN-LAST:event_check_contaCorrentePadraoBoletosActionPerformed

    private void check_contaCorrentePadraoOrdensServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_contaCorrentePadraoOrdensServicoActionPerformed
        if(ConCorCon != null)if(ConCorCon.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        Modulo = "Producao";
        if(check_contaCorrentePadraoOrdensServico.isSelected() == false){
            ReiniciaCampos();
            return;
        }
        abriuContaCorrente = 1;
        ConCorCon = new ContaCorrenteConsulta("P");
        ConCorCon.setVisible(true);
    }//GEN-LAST:event_check_contaCorrentePadraoOrdensServicoActionPerformed

    private void check_contaCorrentePadraoRecibosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_contaCorrentePadraoRecibosActionPerformed
        if(ConCorCon != null)if(ConCorCon.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        Modulo = "Recibos";
        if(check_contaCorrentePadraoRecibos.isSelected() == false){
            ReiniciaCampos();
            return;
        }
        abriuContaCorrente = 1;
        ConCorCon = new ContaCorrenteConsulta("P");
        ConCorCon.setVisible(true);
    }//GEN-LAST:event_check_contaCorrentePadraoRecibosActionPerformed

    private void check_contaCorrentePadraoVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_contaCorrentePadraoVendasActionPerformed
        if(ConCorCon != null)if(ConCorCon.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        Modulo = "Vendas";
        if(check_contaCorrentePadraoVendas.isSelected() == false){
            ReiniciaCampos();
            return;
        }
        abriuContaCorrente = 1;
        ConCorCon = new ContaCorrenteConsulta("P");
        ConCorCon.setVisible(true);
    }//GEN-LAST:event_check_contaCorrentePadraoVendasActionPerformed

    private void bt_confirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmaActionPerformed
        if(operacao.equals("I")){
            IncluirRegistro();
            return;
        }
        AlterarRegistro();
    }//GEN-LAST:event_bt_confirmaActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_confirma;
    private javax.swing.JButton bt_pesquisaContaCorrenteBoletos;
    private javax.swing.JButton bt_pesquisaContaCorrenteOrdensServico;
    private javax.swing.JButton bt_pesquisaContaCorrenteRecibos;
    private javax.swing.JButton bt_pesquisaContaCorrenteVendas;
    private javax.swing.JCheckBox check_contaCorrentePadraoBoletos;
    private javax.swing.JCheckBox check_contaCorrentePadraoOrdensServico;
    private javax.swing.JCheckBox check_contaCorrentePadraoRecibos;
    private javax.swing.JCheckBox check_contaCorrentePadraoVendas;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Boletos;
    private javax.swing.JLabel jLabel_OrdensServico;
    private javax.swing.JLabel jLabel_Recibos;
    private javax.swing.JLabel jLabel_Vendas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea label_descricaoBoletos;
    private javax.swing.JTextArea label_descricaoOrdensServico;
    private javax.swing.JTextArea label_descricaoRecibos;
    private javax.swing.JTextArea label_descricaoVendas;
    private javax.swing.JTextField txt_agenciaBoletos;
    private javax.swing.JTextField txt_agenciaOrdensServico;
    private javax.swing.JTextField txt_agenciaRecibos;
    private javax.swing.JTextField txt_agenciaVendas;
    private javax.swing.JTextField txt_contaCorrenteBoletos;
    private javax.swing.JTextField txt_contaCorrenteOrdensServico;
    private javax.swing.JTextField txt_contaCorrenteRecibos;
    private javax.swing.JTextField txt_contaCorrenteVendas;
    // End of variables declaration//GEN-END:variables
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    private void ReiniciaCampos(){
        if(Modulo.equals("CC")){
            bparges.codigoContaCorrenteBoleto = 0;
            txt_agenciaBoletos              .setText("");
            txt_contaCorrenteBoletos        .setText("");
            check_contaCorrentePadraoBoletos.setSelected(false);
            label_descricaoBoletos          .setText("");
            return;
        }
        if(Modulo.equals("Producao")){
            bparges.codigoContaCorrenteOrdemServico = 0;
            txt_agenciaOrdensServico              .setText("");
            txt_contaCorrenteOrdensServico        .setText("");
            check_contaCorrentePadraoOrdensServico.setSelected(false);
            label_descricaoOrdensServico          .setText("");
            return;
        }
        if(Modulo.equals("Recibos")){
            bparges.codigoContaCorrenteRecibo  = 0;
            txt_agenciaRecibos              .setText("");
            txt_contaCorrenteRecibos        .setText("");
            check_contaCorrentePadraoRecibos.setSelected(false);
            label_descricaoRecibos          .setText("");
            return;
        }
        if(Modulo.equals("Vendas")){
            bparges.codigoContaCorrenteVenda  = 0;
            txt_agenciaVendas               .setText("");
            txt_contaCorrenteVendas         .setText("");
            check_contaCorrentePadraoVendas .setSelected(false);
            label_descricaoVendas           .setText("");
            return;
        }
    }
    
    private void PegaContaCorrente(){
        if(bcc.codigoContaCorrente == 0){
            return;
        }
        sql = "select \n" +
              "  cc.idContaCorrente, \n" +
              "  cc.idEmpresa, \n" +
              "  cc.codigoGrupo, \n" +
              "  cc.codigoEmpresa, \n" +
              "  nsemp.nomeEmpresa, \n" +
              "  cc.codigoContaCorrente, \n" +
              "  cc.idBanco, \n" +
              "  ban.nomebanco, \n" +
              "  ban.codigobanco, \n" +
              "  cc.numeroAgencia, \n" +
              "  cc.digitoVerificadorAgencia, \n" +
              "  cc.numeroContaCorrente, \n" +
              "  cc.digitoVerificador \n" +
              "from \n" +
              "  tb_contacorrente cc \n" +
              "    inner join ns_empresas nsemp on (cc.idEmpresa = nsemp.idEmpresa) \n" +
              "    inner join ns_bancos ban on (cc.idBanco = ban.id) \n" +
              "    where cc.idEmpresa = " + parametrosNS.be.IdEmpresa + " and cc.codigoContaCorrente = " + bcc.codigoContaCorrente + ";";
        dadosContaCorrente.clear();
        dadosContaCorrente = parametrosNS.dao.Consulta(sql);
        if(dadosContaCorrente.isEmpty()){
            mensagem = "Não foi encontrada a conta corrente selecionada!";
            mostraMensagem();
            return;
        }
        PegaDadosContaCorrente();
    }
    
    private void PegaDadosContaCorrente(){
        for(int i = 0; i < dadosContaCorrente.size(); i++){
            if(dadosContaCorrente.get(i).get(0) != null){bcc.idContaCorrente          = Integer.parseInt(String.valueOf(dadosContaCorrente.get(i).get(0)));}
            if(dadosContaCorrente.get(i).get(1) != null){bcc.idEmpresa                = Integer.parseInt(String.valueOf(dadosContaCorrente.get(i).get(1)));}
            if(dadosContaCorrente.get(i).get(2) != null){bcc.codigoGrupo              = Integer.parseInt(String.valueOf(dadosContaCorrente.get(i).get(2)));}
            if(dadosContaCorrente.get(i).get(3) != null){bcc.codigoEmpresa            = Integer.parseInt(String.valueOf(dadosContaCorrente.get(i).get(3)));}
                
                be.idEmpresa     = bcc.idEmpresa;
                be.codigoGrupo   = bcc.codigoGrupo;
                be.codigoEmpresa = bcc.codigoEmpresa;
            if(dadosContaCorrente.get(i).get(4) != null){be.nomeEmpresa   = String.valueOf(dadosContaCorrente.get(i).get(4));}
                
            if(dadosContaCorrente.get(i).get(5) != null){bcc.codigoContaCorrente      = Integer.parseInt(String.valueOf(dadosContaCorrente.get(i).get(5)));}
            if(dadosContaCorrente.get(i).get(6) != null){bcc.idBanco                  = Integer.parseInt(String.valueOf(dadosContaCorrente.get(i).get(6)));}
                
                bb.idBanco       = bcc.idBanco;
            if(dadosContaCorrente.get(i).get(7) != null){bb.nomeBanco     = String.valueOf(dadosContaCorrente.get(0).get(7));}
            if(dadosContaCorrente.get(i).get(8) != null){bb.codigoBanco   = String.valueOf(dadosContaCorrente.get(0).get(8));}
                
            if(dadosContaCorrente.get(i).get(9)  != null) {bcc.numeroAgencia            = Integer.parseInt(String.valueOf(dadosContaCorrente.get(i).get(9)));}
            if(dadosContaCorrente.get(i).get(10) != null){bcc.digitoVerificadorAgencia = Integer.parseInt(String.valueOf(dadosContaCorrente.get(i).get(10)));}
            if(dadosContaCorrente.get(i).get(11) != null){bcc.numeroContaCorrente      = Integer.parseInt(String.valueOf(dadosContaCorrente.get(i).get(11)));}
            if(dadosContaCorrente.get(i).get(12) != null){bcc.digitoVerificador        = Integer.parseInt(String.valueOf(dadosContaCorrente.get(i).get(12)));}
        }
        if(Modulo.equals("CC")){
            bparges.codigoContaCorrenteBoleto = bcc.codigoContaCorrente;
            VerificaBanco();
            txt_agenciaBoletos      .setText(numeroAgencia);
            txt_contaCorrenteBoletos.setText(numeroContaCorrente);
            label_descricaoBoletos  .setText("Empresa: " + be.nomeEmpresa + "\nBanco: " + parametrosNS.fc.FormataCampo(String.valueOf(bb.codigoBanco), 3, 0) + "-" + bb.nomeBanco);
        }
        if(Modulo.equals("Producao")){
            bparges.codigoContaCorrenteOrdemServico = bcc.codigoContaCorrente;
            VerificaBanco();
            txt_agenciaOrdensServico      .setText(numeroAgencia);
            txt_contaCorrenteOrdensServico.setText(numeroContaCorrente);
            label_descricaoOrdensServico  .setText("Empresa: " + be.nomeEmpresa + "\nBanco: " + parametrosNS.fc.FormataCampo(String.valueOf(bb.codigoBanco), 3, 0) + "-" + bb.nomeBanco);
        }
        if(Modulo.equals("Recibos")){
            bparges.codigoContaCorrenteRecibo  = bcc.codigoContaCorrente;
            VerificaBanco();
            txt_agenciaRecibos      .setText(numeroAgencia);
            txt_contaCorrenteRecibos.setText(numeroContaCorrente);
            label_descricaoRecibos  .setText("Empresa: " + be.nomeEmpresa + "\nBanco: " + parametrosNS.fc.FormataCampo(String.valueOf(bb.codigoBanco), 3, 0) + "-" + bb.nomeBanco);
        }
        if(Modulo.equals("Vendas")){
            bparges.codigoContaCorrenteVenda  = bcc.codigoContaCorrente;
            VerificaBanco();
            txt_agenciaVendas       .setText(numeroAgencia);
            txt_contaCorrenteVendas .setText(numeroContaCorrente);
            label_descricaoVendas   .setText("Empresa: " + be.nomeEmpresa + "\nBanco: " + parametrosNS.fc.FormataCampo(String.valueOf(bb.codigoBanco), 3, 0) + "-" + bb.nomeBanco);
        }
    }
    
    private void VerificaBanco(){
        if(bb.idBanco == 999){
            numeroAgencia       = "Caixa";
            numeroContaCorrente = "";
            return;
        }
        if(bb.codigoBanco.equals("341")){//Itaú
            numeroAgencia       = parametrosNS.fc.FormataCampo(String.valueOf(bcc.numeroAgencia), 4, 0);
            numeroContaCorrente = parametrosNS.fc.FormataCampo(String.valueOf(bcc.numeroContaCorrente), 5, 0) + "-" + String.valueOf(bcc.digitoVerificador);
        }
        if(bb.codigoBanco.equals("399")){//HSBC
            numeroAgencia       = parametrosNS.fc.FormataCampo(String.valueOf(bcc.numeroAgencia), 4, 0);
            numeroContaCorrente = parametrosNS.fc.FormataCampo(String.valueOf(bcc.numeroContaCorrente), 7, 0);
        }
        if(bb.codigoBanco.equals("033")){//Santander
            numeroAgencia       = parametrosNS.fc.FormataCampo(String.valueOf(bcc.numeroAgencia), 4, 0) + "-" + String.valueOf(bcc.digitoVerificadorAgencia);
            numeroContaCorrente = parametrosNS.fc.FormataCampo(String.valueOf(bcc.numeroContaCorrente), 7, 0);
        }
        if(bb.codigoBanco.equals("237")){//Bradesco
            numeroAgencia       = parametrosNS.fc.FormataCampo(String.valueOf(bcc.numeroAgencia), 4, 0) + "-" + String.valueOf(bcc.digitoVerificadorAgencia);
            numeroContaCorrente = parametrosNS.fc.FormataCampo(String.valueOf(bcc.numeroContaCorrente), 7, 0) + "-" + String.valueOf(bcc.digitoVerificador);
        }
    }
    
    private void PegaParametrosGestao(){
        sql = "select * from tb_parametrosgestao where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosParametrosGestao.clear();
        dadosParametrosGestao = parametrosNS.dao.Consulta(sql);
        if(dadosParametrosGestao.isEmpty())
            return;
        operacao = "A";
        PegaDadosParametrosGestao();
    }
    
    private void PegaDadosParametrosGestao(){
        for(int i = 0; i < dadosParametrosGestao.size(); i++){
            if(dadosParametrosGestao.get(i).get(0) != null){bparges.idParametrosGestao              = Integer.parseInt(String.valueOf(dadosParametrosGestao.get(i).get(0)));}
            if(dadosParametrosGestao.get(i).get(1) != null){bparges.idEmpresa                       = Integer.parseInt(String.valueOf(dadosParametrosGestao.get(i).get(1)));}
            if(dadosParametrosGestao.get(i).get(2) != null){bparges.codigoGrupo                     = Integer.parseInt(String.valueOf(dadosParametrosGestao.get(i).get(2)));}
            if(dadosParametrosGestao.get(i).get(3) != null){bparges.codigoEmpresa                   = Integer.parseInt(String.valueOf(dadosParametrosGestao.get(i).get(3)));}
            if(dadosParametrosGestao.get(i).get(4) != null){bparges.dataGestao                      =                  String.valueOf(dadosParametrosGestao.get(i).get(4));}
            if(dadosParametrosGestao.get(i).get(5) != null){bparges.codigoContaCorrenteBoleto       = Integer.parseInt(String.valueOf(dadosParametrosGestao.get(i).get(5)));}
            if(dadosParametrosGestao.get(i).get(6) != null){bparges.codigoContaCorrenteOrdemServico = Integer.parseInt(String.valueOf(dadosParametrosGestao.get(i).get(6)));}
            if(dadosParametrosGestao.get(i).get(7) != null){bparges.codigoContaCorrenteRecibo       = Integer.parseInt(String.valueOf(dadosParametrosGestao.get(i).get(7)));}
            if(dadosParametrosGestao.get(i).get(8) != null){bparges.codigoContaCorrenteVenda        = Integer.parseInt(String.valueOf(dadosParametrosGestao.get(i).get(8)));}
        }
        Modulo = "CC";
        bcc.codigoContaCorrente = bparges.codigoContaCorrenteBoleto;
        PegaContaCorrente();
        
        Modulo = "Producao";
        bcc.codigoContaCorrente = bparges.codigoContaCorrenteOrdemServico;
        PegaContaCorrente();
        
        Modulo = "Recibos";
        bcc.codigoContaCorrente = bparges.codigoContaCorrenteRecibo;
        PegaContaCorrente();
        
        Modulo = "Vendas";
        bcc.codigoContaCorrente = bparges.codigoContaCorrenteVenda;
        PegaContaCorrente();
    }
    
    private void PegaValores(){
        bparges.idEmpresa       = parametrosNS.be.IdEmpresa;
        bparges.codigoGrupo     = parametrosNS.bge.CodigoGrupo;
        bparges.codigoEmpresa   = parametrosNS.be.CodigoEmpresa;
        bparges.dataGestao      = null;
    }
    
    private void IncluirRegistro(){
        PegaValores();
        sql = "insert into tb_parametrosgestao (idEmpresa, codigoGrupo, codigoEmpresa, dataGestao, codigoContaCorrenteBoleto, codigoContaCorrenteOrdemServico, codigoContaCorrenteRecibo, codigoContaCorrenteVenda) "
            + "values (" + bparges.idEmpresa + ", " + bparges.codigoGrupo + ", " + bparges.codigoEmpresa + ", " + bparges.dataGestao + ", " + bparges.codigoContaCorrenteBoleto + ", " + bparges.codigoContaCorrenteOrdemServico + ", " + bparges.codigoContaCorrenteRecibo + ", " + bparges.codigoContaCorrenteVenda + ");";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        mensagem = "Registro incluso com sucesso!";
        mostraMensagem();
    }
    
    private void AlterarRegistro(){
        PegaValores();
        sql = "update tb_parametrosgestao set codigoContaCorrenteBoleto = "          + bparges.codigoContaCorrenteBoleto          + ", " +
                                             "codigoContaCorrenteOrdemServico = "    + bparges.codigoContaCorrenteOrdemServico    + ", " +
                                             "codigoContaCorrenteRecibo = "          + bparges.codigoContaCorrenteRecibo          + ", " +
                                             "codigoContaCorrenteVenda = "           + bparges.codigoContaCorrenteVenda           + " " +
                                             "where idParametrosGestao = " + bparges.idParametrosGestao + ";";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        mensagem = "Registro atualizado com sucesso!";
        mostraMensagem();
    }
    
}
