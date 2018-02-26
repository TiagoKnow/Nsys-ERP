package TelasEstoque;

import Beans.BeanIntervalos;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.TestarData;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;

/*
 @author Tiago e Paulo
 */
public class RelatorioDeProdutosMaisVendidos extends javax.swing.JFrame {
    //String's
    String sql                          = "";
    String Mensagem                     = "";
    
    //Bean's
    BeanIntervalos              binter  = new BeanIntervalos();
    
    //Especiais
    FormataCampo                fc      = new FormataCampo();
    TestarData                  Test    = new TestarData();
    
    //Telas
    parametrosNS Ini;
    
    public RelatorioDeProdutosMaisVendidos(parametrosNS ini){
        initComponents();
        Ini         = ini;
    }
    
    private void InicializaCampos(){
        txt_codigoProdutoInicial    .setText(fc.FormataCampo("", 6, 0));
        txt_codigoProdutoFinal      .setText("999999");
        txt_codigoFornecedorInicial .setText(fc.FormataCampo("", 5, 0));
        txt_codigoFornecedorFinal   .setText("99999");
        txt_dataVendaInicial        .setText(fc.FormataCampo("", 8, 0));
        txt_dataVendaFinal          .setText("99999999");
        txt_codigoFabricanteInicial .setText(fc.FormataCampo("", 5, 0));
        txt_codigoFabricanteFinal   .setText("99999");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigoProdutoInicial = new javax.swing.JFormattedTextField();
        bt_pesquisaProdutoInicial = new javax.swing.JButton();
        txt_codigoProdutoFinal = new javax.swing.JFormattedTextField();
        bt_pesquisarProdutoFinal = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_dataVendaInicial = new javax.swing.JFormattedTextField();
        txt_dataVendaFinal = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_codigoFornecedorInicial = new javax.swing.JFormattedTextField();
        bt_pesquisarFornecedorInicial = new javax.swing.JButton();
        txt_codigoFornecedorFinal = new javax.swing.JFormattedTextField();
        bt_pesquisarFornecedorFinal = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_codigoFabricanteInicial = new javax.swing.JFormattedTextField();
        bt_pesquisarFabricanteInicial = new javax.swing.JButton();
        txt_codigoFabricanteFinal = new javax.swing.JFormattedTextField();
        bt_pesquisarFabricanteFinal = new javax.swing.JButton();
        bt_imprimir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Relatório de Produtos mais Vendidos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Produto:");

        try {
            txt_codigoProdutoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoProdutoInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoProdutoInicial.setText("000000");
        txt_codigoProdutoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoProdutoInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoProdutoInicialFocusLost(evt);
            }
        });
        txt_codigoProdutoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoProdutoInicialKeyPressed(evt);
            }
        });

        bt_pesquisaProdutoInicial.setText("...");

        try {
            txt_codigoProdutoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoProdutoFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoProdutoFinal.setText("999999");
        txt_codigoProdutoFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoProdutoFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoProdutoFinalFocusLost(evt);
            }
        });
        txt_codigoProdutoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoProdutoFinalKeyPressed(evt);
            }
        });

        bt_pesquisarProdutoFinal.setText("...");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Data:");

        try {
            txt_dataVendaInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataVendaInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataVendaInicial.setText("00/00/0000");
        txt_dataVendaInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataVendaInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataVendaInicialFocusLost(evt);
            }
        });
        txt_dataVendaInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataVendaInicialKeyPressed(evt);
            }
        });

        try {
            txt_dataVendaFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataVendaFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataVendaFinal.setText("99/99/9999");
        txt_dataVendaFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataVendaFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataVendaFinalFocusLost(evt);
            }
        });
        txt_dataVendaFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataVendaFinalKeyPressed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Fornecedor:");

        try {
            txt_codigoFornecedorInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoFornecedorInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoFornecedorInicial.setText("00000");
        txt_codigoFornecedorInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoFornecedorInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoFornecedorInicialFocusLost(evt);
            }
        });
        txt_codigoFornecedorInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoFornecedorInicialKeyPressed(evt);
            }
        });

        bt_pesquisarFornecedorInicial.setText("...");

        try {
            txt_codigoFornecedorFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoFornecedorFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoFornecedorFinal.setText("99999");
        txt_codigoFornecedorFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoFornecedorFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoFornecedorFinalFocusLost(evt);
            }
        });
        txt_codigoFornecedorFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoFornecedorFinalKeyPressed(evt);
            }
        });

        bt_pesquisarFornecedorFinal.setText("...");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Fabricante:");

        try {
            txt_codigoFabricanteInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoFabricanteInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoFabricanteInicial.setText("00000");
        txt_codigoFabricanteInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoFabricanteInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoFabricanteInicialFocusLost(evt);
            }
        });
        txt_codigoFabricanteInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoFabricanteInicialKeyPressed(evt);
            }
        });

        bt_pesquisarFabricanteInicial.setText("jButton1");

        try {
            txt_codigoFabricanteFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoFabricanteFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoFabricanteFinal.setText("99999");
        txt_codigoFabricanteFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoFabricanteFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoFabricanteFinalFocusLost(evt);
            }
        });
        txt_codigoFabricanteFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoFabricanteFinalKeyPressed(evt);
            }
        });

        bt_pesquisarFabricanteFinal.setText("...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoProdutoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisaProdutoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_dataVendaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoProdutoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisarProdutoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_dataVendaFinal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_codigoFabricanteInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(txt_codigoFornecedorInicial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_pesquisarFabricanteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisarFornecedorInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoFabricanteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisarFabricanteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoFornecedorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisarFornecedorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, jLabel5});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_codigoFabricanteFinal, txt_codigoFornecedorFinal});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_codigoFabricanteInicial, txt_codigoFornecedorInicial});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_pesquisarFabricanteInicial, bt_pesquisarFornecedorInicial});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_pesquisarFabricanteFinal, bt_pesquisarFornecedorFinal});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_codigoProdutoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaProdutoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoProdutoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisarProdutoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(bt_pesquisarFornecedorInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoFornecedorInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoFornecedorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisarFornecedorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_dataVendaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dataVendaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txt_codigoFabricanteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisarFabricanteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoFabricanteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisarFabricanteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaProdutoInicial, bt_pesquisarFabricanteFinal, bt_pesquisarFabricanteInicial, bt_pesquisarFornecedorFinal, bt_pesquisarFornecedorInicial, bt_pesquisarProdutoFinal, jLabel2, jLabel3, jLabel4, jLabel5, txt_codigoFabricanteFinal, txt_codigoFabricanteInicial, txt_codigoFornecedorFinal, txt_codigoFornecedorInicial, txt_codigoProdutoFinal, txt_codigoProdutoInicial, txt_dataVendaFinal, txt_dataVendaInicial});

        bt_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/print.png"))); // NOI18N
        bt_imprimir.setText("Imprimir");
        bt_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imprimirActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_imprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        InicializaCampos();
    }//GEN-LAST:event_formWindowOpened

    private void bt_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimirActionPerformed
        PegaValores();
    }//GEN-LAST:event_bt_imprimirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_codigoProdutoInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoProdutoInicialFocusGained
        txt_codigoProdutoInicial.setSelectionStart(0);
        txt_codigoProdutoInicial.setSelectionEnd  (txt_codigoProdutoInicial.getText().length());
    }//GEN-LAST:event_txt_codigoProdutoInicialFocusGained

    private void txt_codigoProdutoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoProdutoInicialFocusLost
        txt_codigoProdutoInicial.setText(fc.FormataCampo(txt_codigoProdutoInicial.getText().replace(" ", ""), 6, 0));
    }//GEN-LAST:event_txt_codigoProdutoInicialFocusLost

    private void txt_codigoProdutoInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoProdutoInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoProdutoFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoProdutoInicial.setText(fc.FormataCampo("", 6, 0));
            txt_codigoProdutoFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoProdutoInicialKeyPressed

    private void txt_codigoProdutoFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoProdutoFinalFocusGained
        txt_codigoProdutoFinal.setSelectionStart(0);
        txt_codigoProdutoFinal.setSelectionEnd  (txt_codigoProdutoFinal.getText().length());
    }//GEN-LAST:event_txt_codigoProdutoFinalFocusGained

    private void txt_codigoProdutoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoProdutoFinalFocusLost
        txt_codigoProdutoFinal.setText(fc.FormataCampo(txt_codigoProdutoFinal.getText().replace(" ", ""), 6, 0));
    }//GEN-LAST:event_txt_codigoProdutoFinalFocusLost

    private void txt_codigoProdutoFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoProdutoFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoFornecedorInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoProdutoFinal.setText("999999");
            txt_codigoFornecedorInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoProdutoFinalKeyPressed

    private void txt_codigoFornecedorInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFornecedorInicialFocusGained
        txt_codigoFornecedorInicial.setSelectionStart(0);
        txt_codigoFornecedorInicial.setSelectionEnd  (txt_codigoFornecedorInicial.getText().length());
    }//GEN-LAST:event_txt_codigoFornecedorInicialFocusGained

    private void txt_codigoFornecedorInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFornecedorInicialFocusLost
        txt_codigoFornecedorInicial.setText(fc.FormataCampo(txt_codigoFornecedorInicial.getText().replace(" ", ""), 5, 0));
    }//GEN-LAST:event_txt_codigoFornecedorInicialFocusLost

    private void txt_codigoFornecedorInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoFornecedorInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoFornecedorFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoFornecedorInicial.setText(fc.FormataCampo("", 5, 0));
            txt_codigoFornecedorFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoFornecedorInicialKeyPressed

    private void txt_codigoFornecedorFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFornecedorFinalFocusGained
        txt_codigoFornecedorFinal.setSelectionStart(0);
        txt_codigoFornecedorFinal.setSelectionEnd  (txt_codigoFornecedorFinal.getText().length());
    }//GEN-LAST:event_txt_codigoFornecedorFinalFocusGained

    private void txt_codigoFornecedorFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFornecedorFinalFocusLost
        txt_codigoFornecedorFinal.setText(fc.FormataCampo(txt_codigoFornecedorFinal.getText().replace(" ", ""), 5, 0));
    }//GEN-LAST:event_txt_codigoFornecedorFinalFocusLost

    private void txt_codigoFornecedorFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoFornecedorFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataVendaInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoFornecedorFinal.setText("99999");
            txt_dataVendaInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoFornecedorFinalKeyPressed

    private void txt_dataVendaInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVendaInicialFocusGained
        txt_dataVendaInicial.setSelectionStart(0);
        txt_dataVendaInicial.setSelectionEnd  (txt_dataVendaInicial.getText().length());
    }//GEN-LAST:event_txt_dataVendaInicialFocusGained

    private void txt_dataVendaInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVendaInicialFocusLost
        txt_dataVendaInicial.setText(fc.FormataCampo(txt_dataVendaInicial.getText().replace(" ", ""), 8, 0));
    }//GEN-LAST:event_txt_dataVendaInicialFocusLost

    private void txt_dataVendaInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataVendaInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataVendaFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataVendaInicial.setText(fc.FormataCampo("", 8, 0));
            txt_dataVendaFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataVendaInicialKeyPressed

    private void txt_dataVendaFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVendaFinalFocusGained
        txt_dataVendaFinal.setSelectionStart(0);
        txt_dataVendaFinal.setSelectionEnd  (txt_dataVendaFinal.getText().length());
    }//GEN-LAST:event_txt_dataVendaFinalFocusGained

    private void txt_dataVendaFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVendaFinalFocusLost
        txt_dataVendaFinal.setText(fc.FormataCampo(txt_dataVendaFinal.getText().replace(" ", ""), 8, 0));
    }//GEN-LAST:event_txt_dataVendaFinalFocusLost

    private void txt_dataVendaFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataVendaFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoFabricanteInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataVendaFinal.setText("99999999");
            txt_codigoFabricanteInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataVendaFinalKeyPressed

    private void txt_codigoFabricanteInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFabricanteInicialFocusGained
        txt_codigoFabricanteInicial.setSelectionStart(0);
        txt_codigoFabricanteInicial.setSelectionEnd  (txt_codigoFabricanteInicial.getText().length());
    }//GEN-LAST:event_txt_codigoFabricanteInicialFocusGained

    private void txt_codigoFabricanteInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFabricanteInicialFocusLost
        txt_codigoFabricanteInicial.setText(fc.FormataCampo(txt_codigoFabricanteInicial.getText().replace(" ", ""), 5, 0));
    }//GEN-LAST:event_txt_codigoFabricanteInicialFocusLost

    private void txt_codigoFabricanteInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoFabricanteInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoFabricanteFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoFabricanteInicial.setText(fc.FormataCampo("", 5, 0));
            txt_codigoFabricanteFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoFabricanteInicialKeyPressed

    private void txt_codigoFabricanteFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFabricanteFinalFocusGained
        txt_codigoFabricanteFinal.setSelectionStart(0);
        txt_codigoFabricanteFinal.setSelectionEnd  (txt_codigoFabricanteFinal.getText().length());
    }//GEN-LAST:event_txt_codigoFabricanteFinalFocusGained

    private void txt_codigoFabricanteFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFabricanteFinalFocusLost
        txt_codigoFabricanteFinal.setText(fc.FormataCampo(txt_codigoFabricanteFinal.getText().replace(" ", ""), 5, 0));
    }//GEN-LAST:event_txt_codigoFabricanteFinalFocusLost

    private void txt_codigoFabricanteFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoFabricanteFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            bt_imprimir.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoFabricanteFinal.setText("99999");
            bt_imprimir.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoFabricanteFinalKeyPressed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(Ini.dao.sqlstate.equals("08S01") || Ini.dao.sqlstate.equals("08003")){dispose();}
    }//GEN-LAST:event_formWindowGainedFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_imprimir;
    private javax.swing.JButton bt_pesquisaProdutoInicial;
    private javax.swing.JButton bt_pesquisarFabricanteFinal;
    private javax.swing.JButton bt_pesquisarFabricanteInicial;
    private javax.swing.JButton bt_pesquisarFornecedorFinal;
    private javax.swing.JButton bt_pesquisarFornecedorInicial;
    private javax.swing.JButton bt_pesquisarProdutoFinal;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txt_codigoFabricanteFinal;
    private javax.swing.JFormattedTextField txt_codigoFabricanteInicial;
    private javax.swing.JFormattedTextField txt_codigoFornecedorFinal;
    private javax.swing.JFormattedTextField txt_codigoFornecedorInicial;
    private javax.swing.JFormattedTextField txt_codigoProdutoFinal;
    private javax.swing.JFormattedTextField txt_codigoProdutoInicial;
    private javax.swing.JFormattedTextField txt_dataVendaFinal;
    private javax.swing.JFormattedTextField txt_dataVendaInicial;
    // End of variables declaration//GEN-END:variables
    
    private void PegaValores(){
        binter.produtoInicial       = Integer.parseInt(txt_codigoProdutoInicial.getText());
        binter.produtoFinal         = Integer.parseInt(txt_codigoProdutoFinal.getText());
        if(binter.produtoInicial > binter.produtoFinal){
            Mensagem = "Produto Inicial não pode ser maior do que o Produto Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        
        binter.fornecedorInicial    = Integer.parseInt(txt_codigoFornecedorInicial.getText());
        binter.fornecedorFinal      = Integer.parseInt(txt_codigoFornecedorFinal.getText());
        if(binter.fornecedorInicial > binter.fornecedorFinal){
            Mensagem = "Fornecedor Inicial não pode ser maior do que o Fornecedor Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        
        binter.dataVendaInicial     = Test.Testa(txt_dataVendaInicial.getText());
        binter.dataVendaFinal       = Test.Testa(txt_dataVendaFinal.getText());
        if(binter.dataVendaInicial > binter.dataVendaFinal){
            Mensagem = "Data Inicial não pode ser maior do que a Data Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        
        binter.fabricanteInicial    = Integer.parseInt(txt_codigoFabricanteInicial.getText());
        binter.fabricanteFinal      = Integer.parseInt(txt_codigoFabricanteFinal.getText());
        if(binter.fabricanteInicial > binter.fabricanteFinal){
            Mensagem = "Fabricante Inicial não pode ser maior do que o Fabricante Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        
        MontaSQL();
    }
    
    private void MontaSQL(){
        sql = "";
    }
    
}
