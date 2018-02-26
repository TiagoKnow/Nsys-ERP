package Telas;

import Beans.BeanUsuarios;
import Beans.BeanDepartamento;
import Beans.BeanComputadores;
import FuncoesInternas.InverterData;
import FuncoesInternas.*;
import Main.BarraInicial;
import Main.ProcessoInicial;
import Parametros.parametrosNS;
import java.net.InetAddress;
import java.util.*;
/*
 @author Tiago e Paulo
 */
public class ComputadoresCadastro extends javax.swing.JFrame {
    //String's
    String Mensagem                             = "";
    String fatal                                = "N";
    String operacao                             = "";
    String retorno                              = "";
    String valorcomputador                      = "";
    String valordepartamento                    = "";
    String sql                                  = "";
    String Tipo                                 = "";
    String sqlstate                             = "";
    
    //int's
    int    abriuDepartamento                    = 0;
    int    User                                 = 0;
    int    ip1                                  = 0;
    int    ip2                                  = 0;
    int    ip3                                  = 0;
    int    ip4                                  = 0;
    
    //ArrayList's
    ArrayList            parametros                        = new ArrayList();
    ArrayList<ArrayList> dadosDepartamentos                = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosComputadores                 = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosUsuario                      = new ArrayList<ArrayList>();
    
    //bean's
    BeanComputadores                bcomp       = new BeanComputadores();
    BeanDepartamento                bd          = new BeanDepartamento();
    BeanUsuarios                    bu          = new BeanUsuarios();
    
    //Outros
    CapturarDataHora                cdh         = new CapturarDataHora();
    FormataCampo                    fc          = new FormataCampo();
    InverterData                    invdata     = new InverterData();
    PegaProximoRegistro             PegProReg   = new PegaProximoRegistro();
    
    //Telas
    BarraInicial                    Bar;
    ProcessoInicial                 ProIni;
    DepartamentosConsulta           ConDep;
    
    public ComputadoresCadastro(String tipo){
        initComponents();
        Tipo                = tipo;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigoComputador = new javax.swing.JFormattedTextField();
        bt_novo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_nomeComputador = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_ip1 = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_userMachine = new javax.swing.JTextField();
        check_estatico = new javax.swing.JCheckBox();
        txt_departamento = new javax.swing.JFormattedTextField();
        label_departamento = new javax.swing.JLabel();
        bt_pesquisaDepartamentos = new javax.swing.JButton();
        txt_ip2 = new javax.swing.JFormattedTextField();
        txt_ip3 = new javax.swing.JFormattedTextField();
        txt_ip4 = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_funcaoComputador = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        check_Inoperante = new javax.swing.JCheckBox();
        bt_incluir = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        label_alteracao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Computadores");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Codigo");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_codigoComputador.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoComputador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoComputador.setText("  ");
        txt_codigoComputador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoComputadorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoComputadorFocusLost(evt);
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
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_codigoComputador, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_novo, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoComputador, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_novo))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nome do Computador");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_nomeComputador)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_nomeComputador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Dados do Computador");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Endereço IP:");

        try {
            txt_ip1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("***")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_ip1.setEditable(false);
        txt_ip1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ip1.setText("   ");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Departamento:");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Usuário logado no Computador:");
        jLabel7.setToolTipText("Usuário conectado na máquina ou Servidor");

        txt_userMachine.setToolTipText("Usuário conectado na máquina ou Servidor");

        check_estatico.setText("IP Estático");
        check_estatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_estaticoActionPerformed(evt);
            }
        });

        try {
            txt_departamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_departamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_departamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_departamentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_departamentoFocusLost(evt);
            }
        });

        bt_pesquisaDepartamentos.setText("...");
        bt_pesquisaDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaDepartamentosActionPerformed(evt);
            }
        });

        try {
            txt_ip2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("***")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_ip2.setEditable(false);
        txt_ip2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ip2.setText("   ");

        try {
            txt_ip3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("***")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_ip3.setEditable(false);
        txt_ip3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ip3.setText("   ");

        try {
            txt_ip4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("***")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_ip4.setEditable(false);
        txt_ip4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ip4.setText("   ");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Função do Computador:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_userMachine)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txt_ip1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ip2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ip3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ip4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(check_estatico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txt_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_pesquisaDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txt_funcaoComputador, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, jLabel6, jLabel7, jLabel9});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_ip1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_estatico)
                    .addComponent(txt_ip2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ip3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ip4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_userMachine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_funcaoComputador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_pesquisaDepartamentos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txt_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_departamento)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel4, jLabel6, jLabel7, label_departamento, txt_departamento, txt_ip1});

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sem Utilização");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        check_Inoperante.setText("Inoperante");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(check_Inoperante)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(check_Inoperante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bt_incluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_incluir.setText("Incluir");
        bt_incluir.setEnabled(false);
        bt_incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_incluirActionPerformed(evt);
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

        label_alteracao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label_alteracao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_incluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_alterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_sair))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(label_alteracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_alteracao, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void check_estaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_estaticoActionPerformed
        if(check_estatico.isSelected() == false){
            txt_userMachine.grabFocus();
            txt_ip1.setEditable(false);
            txt_ip2.setEditable(false);
            txt_ip3.setEditable(false);
            txt_ip4.setEditable(false);
            return;
        }
        txt_ip1.setEditable(true);
        txt_ip2.setEditable(true);
        txt_ip3.setEditable(true);
        txt_ip4.setEditable(true);
        txt_ip1.grabFocus();
    }//GEN-LAST:event_check_estaticoActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
        if(!Tipo.equalsIgnoreCase("Login"))
            return;
        Sair();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void txt_codigoComputadorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoComputadorFocusLost
        if(txt_codigoComputador.isEditable() == false)
            return;
        if(txt_codigoComputador.getText().replace(" ", "").equals(""))
            return;
        PegaComputador();
    }//GEN-LAST:event_txt_codigoComputadorFocusLost

    private void txt_departamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_departamentoFocusLost
        if(txt_departamento.getText().replace(" ", "").equals(""))
            return;
        PegaDepartamento();
    }//GEN-LAST:event_txt_departamentoFocusLost

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        ReiniciaTela();
        
        bcomp.codigoComputador = PegProReg.PegaProximoRegistro("tb_computadores", "codigoComputador", "");
        txt_codigoComputador.setText(fc.FormataCampo(String.valueOf(bcomp.codigoComputador), 2, 0));
        
        operacao = "I";
        HabilitaBotoes();
        txt_nomeComputador.grabFocus();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void txt_codigoComputadorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoComputadorFocusGained
        if(txt_codigoComputador.isEnabled() == false)
            return;
        ReiniciaTela();
    }//GEN-LAST:event_txt_codigoComputadorFocusGained

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S"))
            return;
        sql = "insert into tb_computadores (idEmpresa, codigoGrupo, codigoEmpresa, codigoComputador, computadorInoperante, nomeComputador, ipv4, ipEstatico, usuarioMachine, computadorDepartamento, funcaoComputador) "
            + "values (" + bcomp.idEmpresa + ", " + bcomp.codigoGrupo + ", " + bcomp.codigoEmpresa + ", " + bcomp.codigoComputador + ", " + bcomp.computadorInoperante + ", '" + bcomp.nomeComputador + "', '" + bcomp.ipv4 + "', " + bcomp.ipEstatico + ", '" + bcomp.usuarioMachine + "', " + bcomp.computadorDepartamento + ", '" + bcomp.funcaoComputador + "');";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        
        if(!sqlstate.equals("00000"))
            return;
        if(!Tipo.equalsIgnoreCase("Login")){
            txt_codigoComputador.grabFocus();
            return;
        }
        Sair();
    }//GEN-LAST:event_bt_incluirActionPerformed
    
    private void PegaValores(){
        fatal = "N";
        bcomp.idEmpresa                 = parametrosNS.be.IdEmpresa;
        bcomp.codigoGrupo               = parametrosNS.bge.CodigoGrupo;
        bcomp.codigoEmpresa             = parametrosNS.be.CodigoEmpresa;
        bcomp.codigoComputador          = Integer.parseInt(txt_codigoComputador.getText());
        if(check_Inoperante.isSelected() == false)
            bcomp.computadorInoperante = 0;
        else
            bcomp.computadorInoperante = 1;
        bcomp.nomeComputador            = txt_nomeComputador.getText();
        if(bcomp.nomeComputador.equals("")){
            Mensagem = "Nome do computador Inválido!!!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        if(check_estatico.isSelected() == false){
            bcomp.ipEstatico            = 0;
            bcomp.ipv4 = "";
        }else{
            bcomp.ipEstatico            = 1;
            bcomp.ipv4 = txt_ip1.getText() + txt_ip2.getText() + txt_ip3.getText() + txt_ip4.getText();
            bcomp.ipv4 = bcomp.ipv4.replace(" ", "");
            if(bcomp.ipv4.equals("")){
                Mensagem = "IPV4 inválido!!!";
                new MostraMensagem(Mensagem);
                fatal = "S";
                return;
            }
            bcomp.ipv4 = fc.FormataCampo(txt_ip1.getText(), 3, 0) + "." + fc.FormataCampo(txt_ip2.getText(), 3, 0) + "." + fc.FormataCampo( txt_ip3.getText(), 3, 0) + "." + fc.FormataCampo(txt_ip4.getText(), 3, 0);
        }
        bcomp.usuarioMachine            = txt_userMachine.getText();
        if(bcomp.usuarioMachine.equals("")){
            Mensagem = "Usuário do computador Inválido!!!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        valordepartamento = txt_departamento.getText().replace(" ", "");
        if(valordepartamento.equals("")){
            Mensagem = "Departamento Inválido!!!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bcomp.computadorDepartamento    = Integer.parseInt(valordepartamento);
        bcomp.funcaoComputador          = txt_funcaoComputador.getText();
        bcomp.idEmpresaAlterou          = parametrosNS.be.idEmpresa;
        bcomp.codigoGrupoAlterou        = parametrosNS.bge.codigoGrupo;
        bcomp.codigoEmpresaAlterou      = parametrosNS.be.codigoEmpresa;
        bcomp.dataAlterou               = invdata.inverterData(cdh.CapturarData(), 2);
        bcomp.horaAlterou               = cdh.CapturaHora();
        bcomp.usuarioAlterou            = parametrosNS.bu.codigoUsuario;
    }
    
    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S"))
            return;
        sql = "update tb_computadores set computadorInoperante = "      + bcomp.computadorInoperante    + ", "  + 
                                         "nomeComputador = '"           + bcomp.nomeComputador          + "', " + 
                                         "ipv4 = '"                     + bcomp.ipv4                    + "', " + 
                                         "ipEstatico = "                + bcomp.ipEstatico              + ", "  + 
                                         "usuarioMachine = '"           + bcomp.usuarioMachine          + "', " + 
                                         "computadorDepartamento = '"   + bcomp.computadorDepartamento  + "', " + 
                                         "funcaoComputador = '"         + bcomp.funcaoComputador        + "', " + 
                                         "dataAlterou = '"              + bcomp.dataAlterou             + "', " + 
                                         "horaAlterou = '"              + bcomp.horaAlterou             + "', " + 
                                         "usuarioAlterou = "            + bcomp.usuarioAlterou          + " "   + 
                                         "where idComputador = "    + bcomp.idComputador            + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoComputador.grabFocus();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void txt_departamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_departamentoFocusGained
        txt_departamento.setSelectionStart(0);
        txt_departamento.setSelectionEnd(txt_departamento.getText().length());
    }//GEN-LAST:event_txt_departamentoFocusGained

    private void bt_pesquisaDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaDepartamentosActionPerformed
        if(ConDep != null)if(ConDep.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuDepartamento = 1;
        ConDep = new DepartamentosConsulta("N");
        ConDep.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaDepartamentosActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
//        if(abriuComputador == 0){
            AbreDepartamento();
//            return;
//        }
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbreDepartamento(){
        if(abriuDepartamento == 0)
            return;
        abriuDepartamento = 0;
        retorno = ConDep.getRetorno();
        if(retorno.equals(""))
            return;
        txt_departamento.setText(retorno);
        PegaDepartamento();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisaDepartamentos;
    private javax.swing.JButton bt_sair;
    private javax.swing.JCheckBox check_Inoperante;
    private javax.swing.JCheckBox check_estatico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel label_alteracao;
    private javax.swing.JLabel label_departamento;
    private javax.swing.JFormattedTextField txt_codigoComputador;
    private javax.swing.JFormattedTextField txt_departamento;
    private javax.swing.JTextField txt_funcaoComputador;
    private javax.swing.JFormattedTextField txt_ip1;
    private javax.swing.JFormattedTextField txt_ip2;
    private javax.swing.JFormattedTextField txt_ip3;
    private javax.swing.JFormattedTextField txt_ip4;
    private javax.swing.JTextField txt_nomeComputador;
    private javax.swing.JTextField txt_userMachine;
    // End of variables declaration//GEN-END:variables
    
    private void ReiniciaTela(){
        txt_codigoComputador.setText("");
        check_Inoperante.setSelected(false);
        txt_nomeComputador.setText("");
        txt_ip1.setText("");
        txt_ip2.setText("");
        txt_ip3.setText("");
        txt_ip4.setText("");
        check_estatico.setSelected(false);
        txt_userMachine.setText("");
        txt_departamento.setText("");
        label_departamento.setText("");
        txt_funcaoComputador.setText("");
        label_alteracao.setText("");
        bt_incluir.setEnabled(false);
        bt_alterar.setEnabled(false);
        CarregaInformacoes();
    }
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_incluir.setEnabled(true);
            bt_alterar.setEnabled(false);
            return;
        }
        if(operacao.equals("I")){
            bt_incluir.setEnabled(false);
            bt_alterar.setEnabled(true);
            return;
        }
        bt_incluir.setEnabled(false);
        bt_alterar.setEnabled(false);
    }
    
    private void Sair(){
        dispose();
        Bar     = new BarraInicial();
        ProIni  = new ProcessoInicial(Bar);
    }

    private void PegaComputador(){
        txt_codigoComputador.setText(fc.FormataCampo(txt_codigoComputador.getText(), 2, 0));
        bcomp.codigoComputador = Integer.parseInt(txt_codigoComputador.getText());
        if(bcomp.codigoComputador == 0)
            return;
        sql = "select * from tb_computadores where idEmpresa = " + parametrosNS.be.IdEmpresa+ " and codigoComputador = " + bcomp.codigoComputador + ";";
        dadosComputadores.clear();
        dadosComputadores = parametrosNS.dao.Consulta(sql);
        if(dadosComputadores.isEmpty()){
            Mensagem = "Computador não encontrado!!!";
            new MostraMensagem(Mensagem);
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        PegaDadosComputadores();
    }
    
    private void PegaDadosComputadores(){
        fatal = "N";
        for(int i = 0; i < dadosComputadores.size(); i++){
            bcomp = new BeanComputadores();
            if(dadosComputadores.get(i).get(0) != null){
                bcomp.idComputador              = Integer.parseInt(  String.valueOf(dadosComputadores.get(i).get(0)));
            }
            if(dadosComputadores.get(i).get(1) != null){
                bcomp.idEmpresa                 = Integer.parseInt(  String.valueOf(dadosComputadores.get(i).get(1)));
            }
            if(dadosComputadores.get(i).get(2) != null){
                bcomp.codigoGrupo               = Integer.parseInt(  String.valueOf(dadosComputadores.get(i).get(2)));
            }
            if(dadosComputadores.get(i).get(3) != null){
                bcomp.codigoEmpresa             = Integer.parseInt(  String.valueOf(dadosComputadores.get(i).get(3)));
            }
            if(dadosComputadores.get(i).get(4) != null){
                bcomp.codigoComputador          = Integer.parseInt(  String.valueOf(dadosComputadores.get(i).get(4)));
            }
            if(dadosComputadores.get(i).get(5) != null){
                bcomp.computadorInoperante      = Integer.parseInt(  String.valueOf(dadosComputadores.get(i).get(5)));
            }
            if(dadosComputadores.get(i).get(6) != null){
                bcomp.nomeComputador            =                    String.valueOf(dadosComputadores.get(i).get(6));
            }
            if(dadosComputadores.get(i).get(7) != null){
                bcomp.ipv4                      =                    String.valueOf(dadosComputadores.get(i).get(7));
            }
            if(dadosComputadores.get(i).get(8) != null){
                bcomp.ipEstatico                = Integer.parseInt(  String.valueOf(dadosComputadores.get(i).get(8)));
            }
            if(dadosComputadores.get(i).get(9) != null){
                bcomp.usuarioMachine            =                    String.valueOf(dadosComputadores.get(i).get(9));
            }
            if(dadosComputadores.get(i).get(10) != null){
                bcomp.computadorDepartamento    = Integer.parseInt(  String.valueOf(dadosComputadores.get(i).get(10)));
            }
            if(dadosComputadores.get(i).get(11) != null){
                bcomp.funcaoComputador          =                    String.valueOf(dadosComputadores.get(i).get(11));
            }
            if(dadosComputadores.get(i).get(12) != null){
                bcomp.dataAlterou               =                    String.valueOf(dadosComputadores.get(i).get(12));
            }
            if(dadosComputadores.get(i).get(13) != null){
                bcomp.horaAlterou               =                    String.valueOf(dadosComputadores.get(i).get(13));
            }
            if(dadosComputadores.get(i).get(14) != null){
                bcomp.usuarioAlterou            = Integer.parseInt(  String.valueOf(dadosComputadores.get(i).get(14)));
            }
            if(dadosComputadores.get(i).get(15) != null){
                bcomp.idEmpresaAlterou          = Integer.parseInt(  String.valueOf(dadosComputadores.get(i).get(15)));
            }
            if(dadosComputadores.get(i).get(16) != null){
                bcomp.codigoGrupoAlterou        = Integer.parseInt(  String.valueOf(dadosComputadores.get(i).get(16)));
            }
            if(dadosComputadores.get(i).get(17) != null){
                bcomp.codigoEmpresaAlterou      = Integer.parseInt(  String.valueOf(dadosComputadores.get(i).get(17)));
            }
        }
        if(bcomp.computadorInoperante == 0){
            check_Inoperante.setSelected(false);
        }else{
            check_Inoperante.setSelected(true);
        }
        txt_nomeComputador.setText(bcomp.nomeComputador);
        bcomp.ipv4      = bcomp.ipv4.replace(".", "");
        if(!bcomp.ipv4.equals("")){
            ip1             = Integer.parseInt(bcomp.ipv4.substring(0, 3));
            txt_ip1.setText(String.valueOf(ip1));
            ip2             = Integer.parseInt(bcomp.ipv4.substring(3, 6));
            txt_ip2.setText(String.valueOf(ip2));
            ip3             = Integer.parseInt(bcomp.ipv4.substring(6, 9));
            txt_ip3.setText(String.valueOf(ip3));
            ip4             = Integer.parseInt(bcomp.ipv4.substring(9,12));
            txt_ip4.setText(String.valueOf(ip4));
        }
        if(bcomp.ipEstatico == 0){
            check_estatico.setSelected(false);
            txt_ip1.setEditable(false);
            txt_ip2.setEditable(false);
            txt_ip3.setEditable(false);
            txt_ip4.setEditable(false);
        }else{
            check_estatico.setSelected(true);
            txt_ip1.setEditable(true);
            txt_ip2.setEditable(true);
            txt_ip3.setEditable(true);
            txt_ip4.setEditable(true);
        }
        txt_userMachine.setText(bcomp.usuarioMachine);
        txt_departamento.setText(fc.FormataCampo(String.valueOf(bcomp.computadorDepartamento), 2, 0));
        PegaDepartamento();
        txt_funcaoComputador.setText(bcomp.funcaoComputador);
        bt_alterar.setEnabled(true);
        if(bcomp.usuarioAlterou != 0){
            bu.usuario          = "NS3";
            bcomp.dataAlterou   = invdata.inverterData(bcomp.dataAlterou, 1);
            if(bcomp.usuarioAlterou != 999){
                bu.idEmpresa            = bcomp.idEmpresaAlterou;
                bu.codigoGrupo          = bcomp.codigoGrupoAlterou;
                bu.codigoEmpresa        = bcomp.codigoEmpresaAlterou;
                bu.codigoUsuario        = bcomp.usuarioAlterou;
                PegaUsuario();
            }
            label_alteracao.setText("Última alteração feita em " + bcomp.dataAlterou + " às " + bcomp.horaAlterou + " por " + bu.usuario);
        }
    }
    
    private void PegaDepartamento(){
        txt_departamento.setText(fc.FormataCampo(txt_departamento.getText(), 2, 0));
        bd.codigoDepartamento = Integer.parseInt(txt_departamento.getText());
        if(bd.codigoDepartamento == 0)
            return;
        sql = "select * from tb_departamento where idEmpresa = " + parametrosNS.be.IdEmpresa+ " and codigoDepartamento = " + bd.codigoDepartamento + ";";
        //System.out.println(sql);
        dadosDepartamentos.clear();
        dadosDepartamentos = parametrosNS.dao.Consulta(sql);
        if(dadosDepartamentos.isEmpty()){
            label_departamento.setText("Não existe");
            bt_incluir.setEnabled(false);
            bt_alterar.setEnabled(false);
            return;
        }
        PegaDadosDepartamento();
    }
    
    private void PegaDadosDepartamento(){
        for(int i = 0; i < dadosDepartamentos.size(); i++){
            bd = new BeanDepartamento();
            bd.idDepartamento           = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(0)));
            bd.idEmpresa                = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(1)));
            bd.codigoGrupo              = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(2)));
            bd.codigoEmpresa            = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(3)));
            bd.codigoDepartamento       = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(4)));
            bd.descricaoDepartamento    =                    String.valueOf(dadosDepartamentos.get(i).get(5));
        }
        label_departamento.setText(bd.descricaoDepartamento);
    }
    
    private void PegaUsuario(){
        sql = "select usuario from tb_usuarios where codigoGrupo = " + bu.codigoGrupo + " and codigoEmpresa = " + bu.codigoEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
        dadosUsuario.clear();
        dadosUsuario = parametrosNS.dao.Consulta(sql);
        if(dadosUsuario.isEmpty()){
            Mensagem = "Codigo do Usuário " + bu.codigoUsuario + " não encontrado!!!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosUsuario();
    }
    
    private void PegaDadosUsuario(){
        for(int i = 0; i < dadosUsuario.size(); i++)
            bu.usuario              = String.valueOf(dadosUsuario.get(i).get(12));
    }

    private void CarregaInformacoes() {
        bcomp = new BeanComputadores();
        try{
            bcomp.nomeComputador = InetAddress.getLocalHost().getHostName().toString();
            bcomp.usuarioMachine = System.getProperty("user.name");
            SetarTexto();
        }catch(Exception er){
            Mensagem = "Erro: " + er;
            new MostraMensagem(Mensagem);
        }
    }

    private void SetarTexto() {
        txt_nomeComputador.setText(bcomp.nomeComputador);
        txt_userMachine.setText(bcomp.usuarioMachine);
        txt_userMachine.setEditable(false);
    }
    
}
