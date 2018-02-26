package Telas;

import Beans.BeanIntervalos;
import Beans.BeanLogAcesso;
import Beans.BeanUsuarios;
import BeansNS.BeanEmpresas;
import BeansNS.BeanGrupoEmpresa;
import BeansNS.BeanBancoDados;
import FuncoesInternas.*;
import Parametros.parametrosNS;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;
/*
 author Tiago e Paulo
 */
public class LogAcesso extends javax.swing.JFrame {
    //String's
    String  ordem            = "";
    String  mensagem         = "";
    String  sql              = "";
    String  descricaoEmpresa = "";
    
    //int's
    int     index          = 0;
    int     Qtd            = 0;
    
    //Bean's
    BeanBancoDados   bbd    = new BeanBancoDados();
    BeanEmpresas     be     = new BeanEmpresas();
    BeanGrupoEmpresa bge    = new BeanGrupoEmpresa();
    BeanIntervalos   binter = new BeanIntervalos();
    BeanLogAcesso    bla    = new BeanLogAcesso();
    BeanUsuarios     bu     = new BeanUsuarios();
    
    //ArrayList's
    ArrayList<ArrayList> dadosLogsDeAcesso         = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosUsuario              = new ArrayList<ArrayList>();
    
    //Outros
    DefaultTableModel           Table;
    TestarData                  Test    = new TestarData();
    
    //Telas
    
    public LogAcesso(){
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        Combo_ordem = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_datainicial = new javax.swing.JFormattedTextField();
        txt_datafinal = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_usuarioInicial = new javax.swing.JFormattedTextField();
        txt_usuarioFinal = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        check_todasEmpresas = new javax.swing.JCheckBox();
        txt_qtd = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        bt_exp = new javax.swing.JButton();
        bt_processa = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelalogins = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Logs de Acesso");
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

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Combo_ordem.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        Combo_ordem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Crescente", "Decrescente" }));
        Combo_ordem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_ordemActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Ordem:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Inicial");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Final");

        try {
            txt_datainicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        try {
            txt_datainicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_datainicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_datainicial.setText("00/00/0000");
        txt_datainicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_datainicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_datainicialFocusLost(evt);
            }
        });
        txt_datainicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_datainicialKeyPressed(evt);
            }
        });

        try {
            txt_datafinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        try {
            txt_datafinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_datafinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_datafinal.setText("99/99/9999");
        txt_datafinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_datafinalKeyPressed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Data:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Usuário:");

        try {
            txt_usuarioInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_usuarioInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_usuarioInicial.setText("000");
        txt_usuarioInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_usuarioInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usuarioInicialFocusLost(evt);
            }
        });
        txt_usuarioInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usuarioInicialKeyPressed(evt);
            }
        });

        try {
            txt_usuarioFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_usuarioFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_usuarioFinal.setText("999");
        txt_usuarioFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_usuarioFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usuarioFinalFocusLost(evt);
            }
        });
        txt_usuarioFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usuarioFinalKeyPressed(evt);
            }
        });

        jLabel3.setText("Mostrar os");

        jLabel8.setText("primeiros registros");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Intervalos de Pesquisa");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        check_todasEmpresas.setText("Todas as Empresas");

        try {
            txt_qtd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_qtd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_qtd.setText("1000");
        txt_qtd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_qtdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_qtdFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_usuarioInicial)
                    .addComponent(txt_datainicial, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_datafinal, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(txt_usuarioFinal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_qtd, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Combo_ordem, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(check_todasEmpresas, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel6, txt_datafinal, txt_datainicial});

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel7});

        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(Combo_ordem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(9, 9, 9)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txt_datainicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_datafinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel8)
                        .addComponent(txt_qtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_usuarioInicial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_usuarioFinal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_todasEmpresas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Combo_ordem, jLabel1});

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {check_todasEmpresas, jLabel2, jLabel3, jLabel7, jLabel8, txt_datafinal, txt_datainicial, txt_usuarioFinal, txt_usuarioInicial});

        jButton1.setBackground(new java.awt.Color(234, 230, 222));
        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        bt_exp.setBackground(new java.awt.Color(234, 230, 222));
        bt_exp.setText("Exportar Log");
        bt_exp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_expActionPerformed(evt);
            }
        });

        bt_processa.setText("Processar");
        bt_processa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_processaActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabelalogins.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabelalogins.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Grupo e Empresa", "Código", "Usuário", "Data", "Entrada", "Saída", "Terminal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Short.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tabelalogins.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabelalogins.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tabelalogins);
        if (tabelalogins.getColumnModel().getColumnCount() > 0) {
            tabelalogins.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Resultado da Pesquisa");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("Funções");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Pesquisar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

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
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_processa, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 518, Short.MAX_VALUE)
                        .addComponent(bt_exp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_exp)
                    .addComponent(jButton1)
                    .addComponent(bt_processa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    void bt_expActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_expActionPerformed
        exportarLog();
    }//GEN-LAST:event_bt_expActionPerformed

    void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    void Combo_ordemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_ordemActionPerformed
        VerificaCombo();
    }//GEN-LAST:event_Combo_ordemActionPerformed
    
    public void VerificaCombo(){
        index = Combo_ordem.getSelectedIndex();
        switch(index){
            case 0: ordem = "asc";  break;
            case 1: ordem = "desc"; break;
        }
    }
    
    private void txt_datafinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_datafinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_usuarioInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_datafinal.setText("99999999");
            txt_usuarioInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_datafinalKeyPressed

    private void txt_datainicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_datainicialFocusLost
        txt_datainicial.setText(parametrosNS.fc.FormataCampo(txt_datainicial.getText(), 10, 2));
    }//GEN-LAST:event_txt_datainicialFocusLost

    private void txt_datainicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_datainicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_datafinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_datainicial.setText(parametrosNS.fc.FormataCampo("", 10, 2));
            txt_datafinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_datainicialKeyPressed

    private void txt_datainicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_datainicialFocusGained
        txt_datainicial.setSelectionStart(0);
        txt_datainicial.setSelectionEnd  (txt_datainicial.getText().length());
    }//GEN-LAST:event_txt_datainicialFocusGained

    private void bt_processaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_processaActionPerformed
        PegaValores();
    }//GEN-LAST:event_bt_processaActionPerformed

    private void txt_usuarioInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usuarioInicialFocusLost
        txt_usuarioInicial.setText(parametrosNS.fc.FormataCampo(txt_usuarioInicial.getText(), 3, 0));
    }//GEN-LAST:event_txt_usuarioInicialFocusLost

    private void txt_usuarioFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usuarioFinalFocusLost
        txt_usuarioFinal.setText(parametrosNS.fc.FormataCampo(txt_usuarioFinal.getText(), 3, 0));
    }//GEN-LAST:event_txt_usuarioFinalFocusLost

    private void txt_usuarioInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usuarioInicialFocusGained
        txt_usuarioInicial.setSelectionStart(0);
        txt_usuarioInicial.setSelectionEnd(txt_usuarioInicial.getText().length());
    }//GEN-LAST:event_txt_usuarioInicialFocusGained

    private void txt_usuarioFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usuarioFinalFocusGained
        txt_usuarioFinal.setSelectionStart(0);
        txt_usuarioFinal.setSelectionEnd(txt_usuarioFinal.getText().length());
    }//GEN-LAST:event_txt_usuarioFinalFocusGained

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        PegaValores();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txt_usuarioInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_usuarioFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_usuarioInicial.setText(parametrosNS.fc.FormataCampo("", 3, 0));
            txt_usuarioFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_usuarioInicialKeyPressed

    private void txt_usuarioFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            bt_processa.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_usuarioFinal.setText("999");
            bt_processa.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_usuarioFinalKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Table = (DefaultTableModel)tabelalogins.getModel();
        
        Combo_ordem.setSelectedIndex(1);
        VerificaCombo();
        
        if(parametrosNS.bu.codigoUsuario != 999)
            check_todasEmpresas.setVisible(false);
        
        txt_datainicial .setText(parametrosNS.cdh.CapturarData());
        txt_datafinal   .setText(parametrosNS.cdh.CapturarData());
        
        PegaValores();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
    }//GEN-LAST:event_formWindowGainedFocus

    private void txt_qtdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_qtdFocusGained
        txt_qtd.setSelectionStart(0);
        txt_qtd.setSelectionEnd  (txt_qtd.getText().length());
    }//GEN-LAST:event_txt_qtdFocusGained

    private void txt_qtdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_qtdFocusLost
        txt_qtd.setText(parametrosNS.fc.FormataCampo(txt_qtd.getText(), 4, 0));
    }//GEN-LAST:event_txt_qtdFocusLost
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Combo_ordem;
    private javax.swing.JButton bt_exp;
    private javax.swing.JButton bt_processa;
    private javax.swing.JCheckBox check_todasEmpresas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tabelalogins;
    private javax.swing.JFormattedTextField txt_datafinal;
    private javax.swing.JFormattedTextField txt_datainicial;
    private javax.swing.JFormattedTextField txt_qtd;
    private javax.swing.JFormattedTextField txt_usuarioFinal;
    private javax.swing.JFormattedTextField txt_usuarioInicial;
    // End of variables declaration//GEN-END:variables

    void exportarLog() {
         try {
            JasperPrint rU = null;
            HashMap map = new HashMap();

            String arquivoJasper = "/Sistema/relatorios/relatorioAcessos.jasper";
            try{
                rU = JasperFillManager.fillReport(arquivoJasper, map, parametrosNS.con);
            }catch(Exception e){       
                JOptionPane.showMessageDialog(null, "visualizar relatorio " + e);
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            JasperViewer.viewReport(rU, false);       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "o erro foi ao gerar relatorio " + e);
        }
    }
    
    public void PegaValores(){
        binter.dataInicial         = Test.Testa(txt_datainicial.getText());
        binter.dataFinal           = Test.Testa(txt_datafinal.getText());
        if(binter.dataInicial > binter.dataFinal){
            mensagem = "Data inicial não pode ser maior do que data final!";
            new MostraMensagem(mensagem);
            return;
        }
        
        binter.usuarioInicial      = Integer.parseInt(txt_usuarioInicial.getText());
        binter.usuarioFinal        = Integer.parseInt(txt_usuarioFinal.getText());
        if(binter.usuarioInicial > binter.usuarioFinal){
            mensagem = "Usuário inicial não pode ser maior do que usuário final!";
            new MostraMensagem(mensagem);
            return;
        }
        
        Qtd = Integer.parseInt(txt_qtd.getText());
        
        PegaLogsDeAcesso();
    }
    
    public void PegaLogsDeAcesso(){
        sql = "select \n" +
              "  log.idLogAcesso, \n" +
              "  log.idEmpresa, \n" +
              "  log.codigoGrupo, \n" +
              "  nsgru.nomeGrupo, \n" +
              "  log.codigoEmpresa, \n" +
              "  nsemp.nomeEmpresa, \n" +
              "  log.codigoLogAcesso, \n" +
              "  log.codigoUsuario, \n" +
              "  usu.usuario, \n" +
              "  log.ip, \n" +
              "  log.terminal, \n" +
              "  log.data, \n" +
              "  log.horaEntrada, \n" +
              "  log.horaSaida \n" +
              "from \n" +
              "  tb_logacesso log \n" +
              "  inner join ns_grupoempresa nsgru on (log.codigoGrupo = nsgru.codigoGrupo) \n" +
              "  inner join ns_empresas nsemp on ((log.codigoGrupo = nsemp.codigoGrupo) and (log.codigoEmpresa = nsemp.codigoEmpresa)) \n" +
              "  inner join tb_usuarios usu on ((log.codigoGrupo = usu.codigoGrupo) and (log.codigoEmpresa = usu.codigoEmpresa) and (log.codigoUsuario = usu.codigoUsuario)) \n";
        if(parametrosNS.bu.codigoUsuario != 999){
            sql += "where log.codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and log.codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + "\n";
        }
        if(parametrosNS.bu.codigoUsuario == 999){
            if(check_todasEmpresas.isSelected()){
                sql += "where log.codigoGrupo = " + parametrosNS.bge.CodigoGrupo + "\n";
            }else{
                sql += "where log.codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and log.codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + "\n";
            }
        }
        sql += " and log.data between '"          + binter.dataInicial       + "' and '" + binter.dataFinal     + "' \n"
            +  " and log.codigoUsuario between "  + binter.usuarioInicial    + "  and  " + binter.usuarioFinal  + ";";
        dadosLogsDeAcesso.clear();
        dadosLogsDeAcesso = parametrosNS.dao.Consulta(sql);
        PegaDadosLogsDeAcesso();
    }
    
    public void PegaDadosLogsDeAcesso(){
        tabelalogins.getColumnModel().getColumn(0).setMaxWidth(0);       //Empresa
        tabelalogins.getColumnModel().getColumn(0).setMinWidth(0);       //Empresa
        tabelalogins.getColumnModel().getColumn(0).setPreferredWidth(0); //Empresa
        tabelalogins.getColumnModel().getColumn(0).setResizable(false);
        if(parametrosNS.bu.codigoUsuario == 999){
            tabelalogins.getColumnModel().getColumn(0).setMaxWidth(350);       //Empresa
            tabelalogins.getColumnModel().getColumn(0).setMinWidth(0);         //Empresa
            tabelalogins.getColumnModel().getColumn(0).setPreferredWidth(250); //Empresa
            tabelalogins.getColumnModel().getColumn(0).setResizable(true);
        }
        
        tabelalogins.getColumnModel().getColumn(1).setPreferredWidth(45);  //Código
        tabelalogins.getColumnModel().getColumn(2).setPreferredWidth(100); //Usuário
        tabelalogins.getColumnModel().getColumn(3).setPreferredWidth(120); //Data de Entrada
        tabelalogins.getColumnModel().getColumn(4).setPreferredWidth(80);  //Hora de Entrada
        tabelalogins.getColumnModel().getColumn(5).setPreferredWidth(80);  //Hora de Saída
        tabelalogins.getColumnModel().getColumn(6).setPreferredWidth(150); //Computador
        
        Table.setNumRows(0);
        for(int i = 0; i < dadosLogsDeAcesso.size(); i++){
            bla = new BeanLogAcesso();
            bla.idLogAcesso         = Integer.parseInt(  String.valueOf(dadosLogsDeAcesso.get(i).get(0)));
            bla.idEmpresa           = Integer.parseInt(  String.valueOf(dadosLogsDeAcesso.get(i).get(1)));
            
            bla.codigoGrupo         = Integer.parseInt(  String.valueOf(dadosLogsDeAcesso.get(i).get(2)));
            bge.codigoGrupo         = bla.codigoGrupo;
            bge.nomeGrupo           = String.valueOf(dadosLogsDeAcesso.get(i).get(3));
            
            bla.codigoEmpresa       = Integer.parseInt(  String.valueOf(dadosLogsDeAcesso.get(i).get(4)));
            be.idEmpresa            = bla.idEmpresa;
            be.codigoGrupo          = bge.codigoGrupo;
            be.codigoEmpresa        = bla.codigoEmpresa;
            be.nomeEmpresa          =                    String.valueOf(dadosLogsDeAcesso.get(i).get(5));
            
            bla.codigoLogAcesso     = Integer.parseInt(  String.valueOf(dadosLogsDeAcesso.get(i).get(6)));
            
            bla.codigoUsuario       = Integer.parseInt(  String.valueOf(dadosLogsDeAcesso.get(i).get(7)));
            bu.idEmpresa            = bla.idEmpresa;
            bu.codigoGrupo          = bge.codigoGrupo;
            bu.codigoEmpresa        = be.codigoEmpresa;
            bu.usuario              =                    String.valueOf(dadosLogsDeAcesso.get(i).get(8));
            
            if(dadosLogsDeAcesso.get(i).get(9) != null){
                bla.ip                  =                    String.valueOf(dadosLogsDeAcesso.get(i).get(9));
            }
            if(dadosLogsDeAcesso.get(i).get(10) != null){
                bla.terminal            =                    String.valueOf(dadosLogsDeAcesso.get(i).get(10));
            }
            if(dadosLogsDeAcesso.get(i).get(11) != null){
                bla.data                =                    String.valueOf(dadosLogsDeAcesso.get(i).get(11));
            }
            if(dadosLogsDeAcesso.get(i).get(12) != null){
                bla.horaEntrada         =                    String.valueOf(dadosLogsDeAcesso.get(i).get(12));
            }
            if(dadosLogsDeAcesso.get(i).get(13) != null){
                bla.horaSaida           =                    String.valueOf(dadosLogsDeAcesso.get(i).get(13));
            }
            
            bla.data = parametrosNS.invdata.inverterData(bla.data, 1);
            
            descricaoEmpresa    = "";
            if(parametrosNS.bu.codigoUsuario == 999){
                descricaoEmpresa = parametrosNS.fc.FormataCampo(String.valueOf(parametrosNS.bge.CodigoGrupo), 2, 0) + "-" + bge.nomeGrupo + "    " + parametrosNS.fc.FormataCampo(String.valueOf(parametrosNS.be.codigoEmpresa), 3, 0) + "-" + be.nomeEmpresa;
            }
            
            Table.addRow(new Object [] {descricaoEmpresa , parametrosNS.fc.FormataCampo(String.valueOf(bla.codigoUsuario), 3, 0), bu.usuario, bla.data, bla.horaEntrada, bla.horaSaida, bla.terminal});
        }
    }
    
}
