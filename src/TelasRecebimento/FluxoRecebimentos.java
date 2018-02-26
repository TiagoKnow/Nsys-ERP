package TelasRecebimento;

import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.FormataCampo;
import java.awt.event.KeyEvent;

/**
 * @author Tiago
 */
public class FluxoRecebimentos extends javax.swing.JFrame {
    
    //Funções
    FormataCampo     fc  = new FormataCampo();
    CapturarDataHora cdh = new CapturarDataHora();
    
    public FluxoRecebimentos() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_diaInicial = new javax.swing.JFormattedTextField();
        txt_diaFinal = new javax.swing.JFormattedTextField();
        txt_mesInicial = new javax.swing.JFormattedTextField();
        txt_mesFinal = new javax.swing.JFormattedTextField();
        txt_anoFinal = new javax.swing.JFormattedTextField();
        txt_anoInicial = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        bt_imprimir = new javax.swing.JButton();
        bt_exportarExcel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Intervalos de Consulta     F11[Geral]");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Intervalo de datas: ");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Inicial:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Final:");

        try {
            txt_diaInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_diaInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_diaInicial.setText("00");
        txt_diaInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_diaInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_diaInicialFocusLost(evt);
            }
        });
        txt_diaInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_diaInicialKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_diaInicialKeyReleased(evt);
            }
        });

        try {
            txt_diaFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_diaFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_diaFinal.setText("99");
        txt_diaFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_diaFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_diaFinalFocusLost(evt);
            }
        });
        txt_diaFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_diaFinalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_diaFinalKeyReleased(evt);
            }
        });

        try {
            txt_mesInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_mesInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_mesInicial.setText("00");
        txt_mesInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_mesInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_mesInicialFocusLost(evt);
            }
        });
        txt_mesInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_mesInicialKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_mesInicialKeyReleased(evt);
            }
        });

        try {
            txt_mesFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_mesFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_mesFinal.setText("99");
        txt_mesFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_mesFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_mesFinalFocusLost(evt);
            }
        });
        txt_mesFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_mesFinalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_mesFinalKeyReleased(evt);
            }
        });

        try {
            txt_anoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_anoFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_anoFinal.setText("9999");
        txt_anoFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_anoFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_anoFinalFocusLost(evt);
            }
        });
        txt_anoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_anoFinalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_anoFinalKeyReleased(evt);
            }
        });

        try {
            txt_anoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_anoInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_anoInicial.setText("0000");
        txt_anoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_anoInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_anoInicialFocusLost(evt);
            }
        });
        txt_anoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_anoInicialKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_anoInicialKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_diaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_diaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_mesInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_anoInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(txt_anoFinal)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_diaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_mesInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_anoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_diaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_mesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_anoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Descrições");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        bt_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Print.png"))); // NOI18N
        bt_imprimir.setText("Imprimir");
        bt_imprimir.setEnabled(false);
        bt_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imprimirActionPerformed(evt);
            }
        });

        bt_exportarExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Print.png"))); // NOI18N
        bt_exportarExcel.setText("Exportar Excel");
        bt_exportarExcel.setEnabled(false);
        bt_exportarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_exportarExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bt_exportarExcel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_imprimir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(bt_exportarExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_diaInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_diaInicialFocusGained
        txt_diaInicial.setText("");
    }//GEN-LAST:event_txt_diaInicialFocusGained

    private void txt_diaInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_diaInicialFocusLost
        txt_diaInicial.setText(fc.FormataCampo(txt_diaInicial.getText().replace(" ", ""), 2, 0));
    }//GEN-LAST:event_txt_diaInicialFocusLost

    private void txt_diaInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_diaInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_mesInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_diaInicial.setText(fc.FormataCampo("", 2, 0));
            txt_mesInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_diaInicialKeyPressed

    private void txt_diaInicialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_diaInicialKeyReleased
        if(txt_diaInicial.getText().replace(" ", "").length() > 1)
        txt_mesInicial.grabFocus();
    }//GEN-LAST:event_txt_diaInicialKeyReleased

    private void txt_diaFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_diaFinalFocusGained
        txt_diaFinal.setText("");
    }//GEN-LAST:event_txt_diaFinalFocusGained

    private void txt_diaFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_diaFinalFocusLost
        if(!txt_diaFinal.getText().replace(" ", "").equals("")){
            txt_diaFinal  .setText(fc.FormataCampo(txt_diaFinal.getText().replace(" ", ""), 2, 0));
        }else{
            txt_diaFinal  .setText("31");
        }
    }//GEN-LAST:event_txt_diaFinalFocusLost

    private void txt_diaFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_diaFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_mesFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_diaFinal.setText("31");
            txt_mesFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_diaFinalKeyPressed

    private void txt_diaFinalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_diaFinalKeyReleased
        if(txt_diaFinal.getText().replace(" ", "").length() > 1)
        txt_mesFinal.grabFocus();
    }//GEN-LAST:event_txt_diaFinalKeyReleased

    private void txt_mesInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_mesInicialFocusGained
        txt_mesInicial.setText("");
    }//GEN-LAST:event_txt_mesInicialFocusGained

    private void txt_mesInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_mesInicialFocusLost
        txt_mesInicial.setText(fc.FormataCampo(txt_mesInicial.getText().replace(" ", ""), 2, 0));
    }//GEN-LAST:event_txt_mesInicialFocusLost

    private void txt_mesInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mesInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_anoInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_mesInicial.setText(fc.FormataCampo("", 2, 0));
            txt_anoInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_mesInicialKeyPressed

    private void txt_mesInicialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mesInicialKeyReleased
        if(txt_mesInicial.getText().replace(" ", "").length() > 1)
        txt_anoInicial.grabFocus();
    }//GEN-LAST:event_txt_mesInicialKeyReleased

    private void txt_mesFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_mesFinalFocusGained
        txt_mesFinal.setText("");
    }//GEN-LAST:event_txt_mesFinalFocusGained

    private void txt_mesFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_mesFinalFocusLost
        if(!txt_mesFinal.getText().replace(" ", "").equals("")){
            txt_mesFinal  .setText(fc.FormataCampo(txt_mesFinal.getText().replace(" ", ""), 2, 0));
        }else{
            txt_mesFinal  .setText("12");
        }
    }//GEN-LAST:event_txt_mesFinalFocusLost

    private void txt_mesFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mesFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_anoFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_mesFinal.setText("12");
            txt_anoFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_mesFinalKeyPressed

    private void txt_mesFinalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mesFinalKeyReleased
        if(txt_mesFinal.getText().replace(" ", "").length() > 1)
        txt_anoFinal.grabFocus();
    }//GEN-LAST:event_txt_mesFinalKeyReleased

    private void txt_anoFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_anoFinalFocusGained
        txt_anoFinal.setText("");
    }//GEN-LAST:event_txt_anoFinalFocusGained

    private void txt_anoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_anoFinalFocusLost
        if(!txt_anoFinal.getText().replace(" ", "").equals("")){
            txt_anoFinal  .setText(fc.FormataCampo(txt_anoFinal.getText().replace(" ", ""), 4, 0));
        }else{
            txt_anoFinal  .setText(cdh.CapturarData().substring(6, 10));
        }
    }//GEN-LAST:event_txt_anoFinalFocusLost

    private void txt_anoFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_anoFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            //check_entradas.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_anoFinal.setText(cdh.CapturarData().substring(6, 10));
            //check_entradas.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_anoFinalKeyPressed

    private void txt_anoFinalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_anoFinalKeyReleased
        if(txt_anoFinal.getText().replace(" ", "").length() > 3){
            
        }
        //check_entradas.grabFocus();
    }//GEN-LAST:event_txt_anoFinalKeyReleased

    private void txt_anoInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_anoInicialFocusGained
        txt_anoInicial.setText("");
    }//GEN-LAST:event_txt_anoInicialFocusGained

    private void txt_anoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_anoInicialFocusLost
        txt_anoInicial.setText(fc.FormataCampo(txt_anoInicial.getText().replace(" ", ""), 4, 0));
    }//GEN-LAST:event_txt_anoInicialFocusLost

    private void txt_anoInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_anoInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_diaFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_anoInicial.setText(fc.FormataCampo("", 4, 0));
            txt_diaFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_anoInicialKeyPressed

    private void txt_anoInicialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_anoInicialKeyReleased
        if(txt_anoInicial.getText().replace(" ", "").length() > 3)
        txt_diaFinal.grabFocus();
    }//GEN-LAST:event_txt_anoInicialKeyReleased

    private void bt_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimirActionPerformed
        //        bv.codigoVenda      = Integer.parseInt(txt_codigoVenda.getText());
        //        bv.codigoCliente    = Integer.parseInt(txt_codigoCliente.getText());
        //        sql = "select * from tb_vendas ven inner join tb_vendas_itens venIte on venIte.codigoVenda = " + bv.codigoVenda + " inner join tb_produtos pro on pro.codigoProduto = venIte.codigoProduto inner join tb_clientes cli on cli.codigoCliente = " + bv.codigoCliente + " where ven.codigoVenda = " + bv.codigoVenda + ";";
        //        Imprimir();
    }//GEN-LAST:event_bt_imprimirActionPerformed

    private void bt_exportarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_exportarExcelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_exportarExcelActionPerformed
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_exportarExcel;
    private javax.swing.JButton bt_imprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JFormattedTextField txt_anoFinal;
    private javax.swing.JFormattedTextField txt_anoInicial;
    private javax.swing.JFormattedTextField txt_diaFinal;
    private javax.swing.JFormattedTextField txt_diaInicial;
    private javax.swing.JFormattedTextField txt_mesFinal;
    private javax.swing.JFormattedTextField txt_mesInicial;
    // End of variables declaration//GEN-END:variables
}
