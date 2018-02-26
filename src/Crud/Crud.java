package Crud;

import Beans.BeanCrud;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Crud extends javax.swing.JFrame {
    //String
    String sql          = "";
    String sqlstate     = "";
    String fatal        = "";
    String mensagem     = "";
    String operacao     = "";
    String cpfCnpj      = "";
    String retorno      = "";

    //int
    int abriuCrud   = 0;
    
    //boolean
    boolean validadorCpfCnpj  = false;
    
    //Vetores
    ArrayList<ArrayList> dadosCrud      = new ArrayList();
    
    //Bean
    BeanCrud bcrud  = new BeanCrud();
    
    //Telas
    CrudConsulta    CrudCon;
    
    public Crud(int idExemplo){
        bcrud.idExemplo = idExemplo;
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        bt_incluir = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_excluir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        bt_pesquisa = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_id = new javax.swing.JFormattedTextField();
        bt_novo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_numero = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        txt_cnpj = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_texto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_valor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        check_check = new javax.swing.JCheckBox();
        combo_combo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        radio_Fisica = new javax.swing.JRadioButton();
        radio_Juridica = new javax.swing.JRadioButton();
        txt_cpf = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        bt_incluir.setText("Incluir");
        bt_incluir.setEnabled(false);
        bt_incluir.setFocusable(false);
        bt_incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_incluirActionPerformed(evt);
            }
        });

        bt_alterar.setText("Alterar");
        bt_alterar.setEnabled(false);
        bt_alterar.setFocusable(false);
        bt_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterarActionPerformed(evt);
            }
        });

        bt_excluir.setText("Excluir");
        bt_excluir.setEnabled(false);
        bt_excluir.setFocusable(false);
        bt_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluirActionPerformed(evt);
            }
        });

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        bt_pesquisa.setText("Pesquisa");
        bt_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_id.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_idFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_idFocusLost(evt);
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
                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_novo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, jLabel1, txt_id});

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Número:");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_numero.setEditable(false);
        try {
            txt_numero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_numero.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_numero.setFocusable(false);
        txt_numero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_numeroFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel3, txt_numero});

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_cnpj.setEditable(false);
        try {
            txt_cnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cnpj.setFocusable(false);
        txt_cnpj.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cnpjFocusLost(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Texto:");

        txt_texto.setEditable(false);
        txt_texto.setFocusable(false);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Valor:");

        txt_valor.setEditable(false);
        txt_valor.setFocusable(false);
        txt_valor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_valorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorFocusLost(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Check Exemplo:");

        check_check.setText("Check");
        check_check.setEnabled(false);
        check_check.setFocusable(false);

        combo_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----", "Não", "Sim" }));
        combo_combo.setEnabled(false);
        combo_combo.setFocusable(false);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Radio:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Combo:");

        buttonGroup1.add(radio_Fisica);
        radio_Fisica.setText("Física");
        radio_Fisica.setEnabled(false);
        radio_Fisica.setFocusable(false);
        radio_Fisica.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radio_FisicaItemStateChanged(evt);
            }
        });
        radio_Fisica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                radio_FisicaKeyPressed(evt);
            }
        });

        buttonGroup1.add(radio_Juridica);
        radio_Juridica.setText("Jurídica");
        radio_Juridica.setEnabled(false);
        radio_Juridica.setFocusable(false);
        radio_Juridica.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radio_JuridicaItemStateChanged(evt);
            }
        });
        radio_Juridica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                radio_JuridicaKeyPressed(evt);
            }
        });

        txt_cpf.setEditable(false);
        try {
            txt_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cpf.setFocusable(false);
        txt_cpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cpfFocusLost(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("jLabel8");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(radio_Fisica, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(radio_Juridica, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_cnpj, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                            .addComponent(txt_cpf)))
                    .addComponent(check_check, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_valor)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(combo_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txt_texto))
                .addContainerGap())
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel4, jLabel5, jLabel6});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(check_check))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radio_Fisica)
                            .addComponent(txt_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radio_Juridica)
                            .addComponent(txt_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {check_check, combo_combo, jLabel2, jLabel4, jLabel5, jLabel6, radio_Fisica, radio_Juridica, txt_cnpj, txt_cpf, txt_texto, txt_valor});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_incluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_alterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_excluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_pesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_incluir)
                    .addComponent(bt_alterar)
                    .addComponent(bt_excluir)
                    .addComponent(jButton1)
                    .addComponent(bt_pesquisa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        ReiniciaCampos();
        HabilitaCampos(true);
        bcrud.idExemplo = parametrosNS.dao.ConsultaAutoIncremento("tb_crud");
        if(bcrud.idExemplo == 0)
            bcrud.idExemplo = 1;
        
        operacao = "I";
        HabilitaBotoes();
        txt_id.setText(parametrosNS.fc.FormataCampo(String.valueOf(bcrud.idExemplo), 3, 0));
    }//GEN-LAST:event_bt_novoActionPerformed

    private void txt_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_idFocusLost
        if(txt_id.getText().replace(" ", "").equals(""))
            return;
        if(txt_id.isEditable() == false)
            return;
        PegaCrud();
    }//GEN-LAST:event_txt_idFocusLost

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S"))
            return;
        sql = "insert into tb_crud (intExemplo, comboExemplo, textoExemplo, valorExemplo, checkBox, radioBoxCpfCnpjExemplo, cpfExemplo, cnpjExemplo) "
            + "values(" + bcrud.intExemplo + ", " + bcrud.comboExemplo + ", '" + bcrud.textoExemplo + "', " + bcrud.valorExemplo + ", " + bcrud.checkBox + ", " + bcrud.radioBoxCpfCnpjExemplo + ", " + bcrud.cpfExemplo + ", " + bcrud.cnpjExemplo + ");";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        mensagem = "Registro incluído com sucesso!";
        mostraMensagem();
        txt_id.grabFocus();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S"))
            return;
        sql = "update tb_crud set comboExemplo = "              + bcrud.comboExemplo            + ", " +
                                 "textoExemplo = '"             + bcrud.textoExemplo            + "', " +
                                 "valorExemplo = "              + bcrud.valorExemplo            + ", " +
                                 "checkBox = "                  + bcrud.checkBox                + ", " +
                                 "radioBoxCpfCnpjExemplo = "    + bcrud.radioBoxCpfCnpjExemplo  + ", " +
                                 "cpfExemplo = "                + bcrud.cpfExemplo              + ", " +
                                 "cnpjExemplo = "               + bcrud.cnpjExemplo             + " " +
                                 "where idExemplo = " + bcrud.idExemplo + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        mensagem = "Registro alterado com sucesso!";
        mostraMensagem();
        txt_id.grabFocus();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void bt_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluirActionPerformed
        PegaValores();
        
        sql = "delete from tb_crud where idExemplo = " + bcrud.idExemplo + ";";
        sqlstate = parametrosNS.dao.ExcluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        mensagem = "Registro excluído com sucesso!";
        mostraMensagem();
    }//GEN-LAST:event_bt_excluirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(bcrud.idExemplo != 0){
            txt_id.setText(String.valueOf(bcrud.idExemplo));
            PegaCrud();
            bt_novo.setEnabled    (false);
            txt_id.setEditable    (false);
            txt_id.setFocusable   (false);
            bt_incluir.setVisible (false);
            bt_alterar.setVisible (false);
            bt_excluir.setVisible (false);
            bt_pesquisa.setVisible(false);
            HabilitaCampos(false);
        }
    }//GEN-LAST:event_formWindowOpened

    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        if(CrudCon != null)
            if(CrudCon.isVisible()){
                CrudCon.setState(JFrame.NORMAL);
                return;
            }
        abriuCrud = 1;
        CrudCon = new CrudConsulta("S");
        CrudCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void txt_numeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_numeroFocusLost
        txt_numero.setText(parametrosNS.fc.FormataCampo(txt_numero.getText(), 3, 0));
    }//GEN-LAST:event_txt_numeroFocusLost

    private void txt_valorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorFocusGained
        if(!txt_valor.getText().equals(""))
            txt_valor.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valor.getText(), 1));
    }//GEN-LAST:event_txt_valorFocusGained

    private void txt_valorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorFocusLost
        if(!txt_valor.getText().equals(""))
            txt_valor.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valor.getText(), 0));
    }//GEN-LAST:event_txt_valorFocusLost

    private void radio_FisicaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radio_FisicaItemStateChanged
        HabilitaCampos();
    }//GEN-LAST:event_radio_FisicaItemStateChanged

    private void radio_JuridicaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radio_JuridicaItemStateChanged
        HabilitaCampos();
    }//GEN-LAST:event_radio_JuridicaItemStateChanged

    private void radio_FisicaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_radio_FisicaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            txt_cpf.grabFocus();;
        if(evt.getKeyCode() == KeyEvent.VK_DOWN)
            radio_Juridica.setSelected(true);
    }//GEN-LAST:event_radio_FisicaKeyPressed

    private void radio_JuridicaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_radio_JuridicaKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            txt_cnpj.grabFocus();
        if(evt.getKeyCode() == KeyEvent.VK_UP)
            radio_Fisica.setSelected(true);
    }//GEN-LAST:event_radio_JuridicaKeyPressed

    private void txt_cpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfFocusLost
        bcrud.cpfExemplo  = txt_cpf.getText();
        bcrud.cpfExemplo  = bcrud.cpfExemplo.replace(" ", "");
        bcrud.cpfExemplo  = bcrud.cpfExemplo.replace(".", "");
        bcrud.cpfExemplo  = bcrud.cpfExemplo.replace("-", "");
        if(bcrud.cpfExemplo.equals(""))
            return;
        if(txt_cpf.isEditable() == false)
            return;
        cpfCnpj = bcrud.cpfExemplo;
        VerificaCpfCnpj();
    }//GEN-LAST:event_txt_cpfFocusLost

    private void txt_cnpjFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cnpjFocusLost
        bcrud.cnpjExemplo = txt_cnpj.getText();
        bcrud.cnpjExemplo = bcrud.cnpjExemplo.replace(" ", "");
        bcrud.cnpjExemplo = bcrud.cnpjExemplo.replace(".", "");
        bcrud.cnpjExemplo = bcrud.cnpjExemplo.replace("/", "");
        bcrud.cnpjExemplo = bcrud.cnpjExemplo.replace("-", "");
        if(bcrud.cnpjExemplo.equals(""))
            return;
        if(txt_cnpj.isEditable() == false)
            return;
        cpfCnpj = bcrud.cnpjExemplo;
        VerificaCpfCnpj();
    }//GEN-LAST:event_txt_cnpjFocusLost

    private void txt_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_idFocusGained
        operacao = "";
        HabilitaBotoes();
        ReiniciaCampos();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_idFocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuCrud == 0)
            return;
        abriuCrud = 0;
        retorno = CrudCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_id.setText(retorno);
        PegaCrud();
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void VerificaCpfCnpj(){
        validadorCpfCnpj = parametrosNS.Vcc.VALIDARCPFCNPJ(cpfCnpj);
        if(validadorCpfCnpj != false){
            HabilitaBotoes();
            return;
        }
        bt_incluir.setEnabled  (false);
        bt_incluir.setFocusable(false);
        bt_alterar.setEnabled  (false);
        bt_alterar.setFocusable(false);
        if(radio_Fisica.isSelected())
            mensagem = "CPF inválido!";
        else
            mensagem = "CNPJ inválido!";
        mostraMensagem();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_excluir;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox check_check;
    private javax.swing.JComboBox<String> combo_combo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton radio_Fisica;
    private javax.swing.JRadioButton radio_Juridica;
    private javax.swing.JFormattedTextField txt_cnpj;
    private javax.swing.JFormattedTextField txt_cpf;
    private javax.swing.JFormattedTextField txt_id;
    private javax.swing.JFormattedTextField txt_numero;
    private javax.swing.JTextField txt_texto;
    private javax.swing.JTextField txt_valor;
    // End of variables declaration//GEN-END:variables
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    private void ReiniciaCampos(){
        txt_id          .setText(null);
        txt_numero      .setText(null);
        combo_combo     .setSelectedIndex(0);
        txt_texto       .setText(null);
        txt_valor       .setText(null);
        check_check     .setSelected(false);
        radio_Fisica    .setSelected(true);
        radio_Juridica  .setSelected(false);
    }
    
    private void HabilitaCampos(boolean Habilita){
//        txt_id          .setEditable (Habilita);
//        txt_id          .setFocusable(Habilita);
        txt_numero      .setEditable (Habilita);
        txt_numero      .setFocusable(Habilita);
        combo_combo     .setEnabled  (Habilita);
        combo_combo     .setFocusable(Habilita);
        txt_texto       .setEditable (Habilita);
        txt_texto       .setFocusable(Habilita);
        txt_valor       .setEditable (Habilita);
        txt_valor       .setFocusable(Habilita);
        check_check     .setEnabled  (Habilita);
        check_check     .setFocusable(Habilita);
        radio_Fisica    .setEnabled  (Habilita);
        radio_Fisica    .setFocusable(Habilita);
        radio_Juridica  .setEnabled  (Habilita);
        radio_Juridica  .setFocusable(Habilita);
        txt_cpf         .setEnabled  (Habilita);
        txt_cpf         .setFocusable(Habilita);
        txt_cnpj        .setEnabled  (Habilita);
        txt_cnpj        .setFocusable(Habilita);
    }
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_incluir  .setEnabled(true);
            bt_alterar  .setEnabled(false);
            bt_excluir  .setEnabled(false);
            return;
        }
        if(operacao.equals("A")){
            bt_incluir  .setEnabled(false);
            bt_alterar  .setEnabled(true);
            bt_excluir  .setEnabled(true);
            return;
        }
        bt_incluir      .setEnabled(false);
        bt_alterar      .setEnabled(false);
        bt_excluir      .setEnabled(false);
    }
    
    private void HabilitaCampos(){
        txt_cpf .setText     ("");
        txt_cpf .setEditable (false);
        txt_cpf .setFocusable(false);
        txt_cnpj.setText     ("");
        txt_cnpj.setEditable (false);
        txt_cnpj.setFocusable(false);
        if(radio_Fisica.isSelected()){
            txt_cpf .setEditable(true);
            txt_cpf .setFocusable(true);
            txt_cpf .grabFocus();
            return;
        }
        if(radio_Juridica.isSelected()){
            txt_cnpj.setEditable(true);
            txt_cnpj.setFocusable(true);
            txt_cnpj.grabFocus();
            return;
        }
    }
    
    private void PegaCrud(){
        bcrud.idExemplo = Integer.parseInt(txt_id.getText().replace(" ", ""));
        sql = "select * from tb_crud where idExemplo = " + bcrud.idExemplo + ";";
        dadosCrud.clear();
        dadosCrud = parametrosNS.dao.Consulta(sql);
        if(dadosCrud.isEmpty()){
            mensagem = "Registro n°" + bcrud.idExemplo + " não encontrado!";
            mostraMensagem();
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        PegaDadosCrud();
    }
    
    private void PegaDadosCrud(){ 
        for(int i = 0; i < dadosCrud.size (); i++){
            bcrud = new BeanCrud();
            if(dadosCrud.get(i).get(0) != null)
                bcrud.idExemplo              = Integer.parseInt(  String.valueOf(dadosCrud.get(i).get(0)));
            if(dadosCrud.get(i).get(1) != null)
                bcrud.intExemplo             = Integer.parseInt(  String.valueOf(dadosCrud.get(i).get(1)));
            if(dadosCrud.get(i).get(2) != null)
                bcrud.comboExemplo           = Integer.parseInt(  String.valueOf(dadosCrud.get(i).get(2)));
            if(dadosCrud.get(i).get(3) != null)
                bcrud.textoExemplo           =                    String.valueOf(dadosCrud.get(i).get(3));
            if(dadosCrud.get(i).get(4) != null)
                bcrud.valorExemplo           = Double.parseDouble(String.valueOf(dadosCrud.get(i).get(4)));
            if(dadosCrud.get(i).get(5) != null)
                bcrud.checkBox               = Integer.parseInt(  String.valueOf(dadosCrud.get(i).get(5)));
            if(dadosCrud.get(i).get(6) != null)
                bcrud.radioBoxCpfCnpjExemplo = Integer.parseInt(  String.valueOf(dadosCrud.get(i).get(6)));
            if(dadosCrud.get(i).get(7) != null)
                bcrud.cpfExemplo             =                    String.valueOf(dadosCrud.get(i).get(7));
            if(dadosCrud.get(i).get(8) != null)
                bcrud.cnpjExemplo            =                    String.valueOf(dadosCrud.get(i).get(8));
        }
        txt_id              .setText(parametrosNS.fc.FormataCampo(String.valueOf(bcrud.idExemplo) , 3, 0));
        if(bcrud.intExemplo != 0)
            txt_numero          .setText(parametrosNS.fc.FormataCampo(String.valueOf(bcrud.intExemplo), 3, 0));
        combo_combo         .setSelectedIndex(bcrud.comboExemplo);
        txt_texto           .setText(bcrud.textoExemplo);
        txt_valor           .setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bcrud.valorExemplo), 0));
        if(bcrud.checkBox == 0)
            check_check.setSelected(false);
        else
            check_check.setSelected(true);
        if(bcrud.radioBoxCpfCnpjExemplo == 0){
            radio_Fisica    .setSelected(true);
            radio_Juridica  .setSelected(false);
        }else{
            radio_Fisica    .setSelected(false);
            radio_Juridica  .setSelected(true);
        }
        if(!bcrud.cpfExemplo .equals(""))
            txt_cpf.setText (bcrud.cpfExemplo);
        if(!bcrud.cnpjExemplo.equals(""))
            txt_cnpj.setText(bcrud.cnpjExemplo);
    }
    
    private void PegaValores(){
        fatal = "N";
        if(txt_numero.getText().replace(" ", "").equals("")){
            mensagem = "Número inválido!";
            mostraMensagem();
            fatal = "S";
            return;
        }
        bcrud.intExemplo        = Integer.parseInt(txt_numero.getText());
        bcrud.comboExemplo      = combo_combo.getSelectedIndex();
        if(bcrud.comboExemplo == 0){
            mensagem = "Combo inválida!";
            mostraMensagem();
            fatal = "S";
            return;
        }
        bcrud.textoExemplo      = txt_texto.getText();
        if(bcrud.textoExemplo.equals("")){
            mensagem = "Texto inválido!";
            mostraMensagem();
            fatal = "S";
            return;
        }
        if(txt_valor.getText().equals("")){
            mensagem = "Valor inválido!";
            mostraMensagem();
            fatal = "S";
            return;
        }
        bcrud.valorExemplo      = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valor.getText(), 1));
        if(check_check.isSelected() == false)
            bcrud.checkBox      = 0;
        else
            bcrud.checkBox      = 1;
        cpfCnpj = txt_cpf.getText() + txt_cnpj.getText();
        cpfCnpj = cpfCnpj.replace(" ", "");
        cpfCnpj = cpfCnpj.replace(".", "");
        cpfCnpj = cpfCnpj.replace("/", "");
        cpfCnpj = cpfCnpj.replace("-", "");
        if(radio_Fisica.isSelected()){
            bcrud.radioBoxCpfCnpjExemplo = 1;
            bcrud.cpfExemplo    = "'" + cpfCnpj + "'";
            bcrud.cnpjExemplo   = null;
        }else{
            bcrud.radioBoxCpfCnpjExemplo = 2;
            bcrud.cpfExemplo    = null;
            bcrud.cnpjExemplo   = "'" + cpfCnpj + "'";
        }
    }
    
}
