package TelasCompras;

import Beans.BeanFormasPagamentos;
import Beans.BeanFornecedor;
import Beans.BeanIntervalos;
import Beans.BeanOrdemCompra;
import Beans.BeanUsuarios;
import BeansNS.BeanEmpresas;
import FuncoesInternas.AjustarLarguraColunas;
import FuncoesInternas.MostraMensagem;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 @author Tiago e Paulo 02/10/2017 14:35
 */
public class OrdemCompraConsultaEManutencao extends javax.swing.JFrame {
    //String
    String sql           = "";
    String sql1          = "";
    String somostra      = "";
    String fazManutencao = "";
    String mensagem      = "";
    String retorno       = "";
    String fatal         = "";
    String textoBusca    = "";
    
    //int
    int    qtdRegistros  = 0;
    int    contador      = 0;
    int    linha         = 0;
    
    //double
    double ValorTotalOrdemCompra    = 0;
    
    //Vetores
    ArrayList            parametros         = new ArrayList();
    ArrayList<ArrayList> dadosEmpresas      = new ArrayList();
    ArrayList<ArrayList> dadosPagamentos    = new ArrayList();
    ArrayList<ArrayList> dadosFornecedor    = new ArrayList();
    ArrayList<ArrayList> dadosOrdemCompra   = new ArrayList();
    ArrayList<ArrayList> dadosUsuarios      = new ArrayList();
    
    //Bean
    BeanEmpresas         be      = new BeanEmpresas();
    BeanFormasPagamentos bforp   = new BeanFormasPagamentos();
    BeanFornecedor       bfor    = new BeanFornecedor();
    BeanIntervalos       binter  = new BeanIntervalos();
    BeanOrdemCompra      boc     = new BeanOrdemCompra();
    BeanUsuarios         bu      = new BeanUsuarios();
    
    //Especiais
    DefaultTableModel Table;
    
    //Telas
    OrdemCompraCadastro OrdComCad;
    
    public OrdemCompraConsultaEManutencao(String Somostra, String FazManutencao){
        somostra      = Somostra;
        fazManutencao = FazManutencao;
        initComponents();
    }
    
    private void InicializaCampos(){
        txt_ocInicial.setText(parametrosNS.fc.FormataCampo("", 9, 0));
        txt_ocFinal  .setText("999999999");
        txt_descricao.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_detalhesItem = new javax.swing.JMenuItem();
        bt_alterarOC = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_ocInicial = new javax.swing.JFormattedTextField();
        txt_ocFinal = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_descricao = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_qtdRegistros = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        check_todasEmpresas = new javax.swing.JCheckBox();
        barra_progresso = new javax.swing.JProgressBar();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_OrdemCompra = new javax.swing.JTable();
        bt_processa = new javax.swing.JButton();
        bt_exportar = new javax.swing.JButton();
        label_processando = new javax.swing.JLabel();
        bt_sair = new javax.swing.JButton();
        label_contador = new javax.swing.JLabel();
        label_divisor = new javax.swing.JLabel();
        label_totalOC = new javax.swing.JLabel();

        bt_detalhesItem.setText("Detalhes");
        bt_detalhesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_detalhesItemActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_detalhesItem);

        bt_alterarOC.setText("jMenuItem1");
        MenuPopup.add(bt_alterarOC);

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

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Intervaloes de Consulta      F11[Geral]");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Inicial");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("OC:");

        try {
            txt_ocInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_ocInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ocInicial.setText("000000000");
        txt_ocInicial.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txt_ocInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_ocInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_ocInicialFocusLost(evt);
            }
        });
        txt_ocInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ocInicialKeyPressed(evt);
            }
        });

        try {
            txt_ocFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_ocFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ocFinal.setText("999999999");
        txt_ocFinal.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txt_ocFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_ocFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_ocFinalFocusLost(evt);
            }
        });
        txt_ocFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ocFinalKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Final");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Descrição:");

        txt_descricao.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txt_descricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_descricaoKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel6.setText("Mostrar os");

        try {
            txt_qtdRegistros.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_qtdRegistros.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_qtdRegistros.setText("030");
        txt_qtdRegistros.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel7.setText("primeiros registros");

        check_todasEmpresas.setText("Todas Empresas");
        check_todasEmpresas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txt_ocInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(txt_ocFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(check_todasEmpresas))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_qtdRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
                .addContainerGap(133, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, txt_ocInicial});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, txt_ocFinal});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel5});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txt_ocInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_ocFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(check_todasEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_qtdRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {check_todasEmpresas, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, txt_descricao, txt_ocFinal, txt_ocInicial, txt_qtdRegistros});

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Ordens de Compra");
        jLabel8.setAutoscrolls(true);
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_OrdemCompra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_OrdemCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Código", "Compradora", "Fornecedor", "Data de Cadastro", "Data da Compra", "Valor da Compra", "Pagamento", "Recebimento", "Responsável"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_OrdemCompra.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_OrdemCompra.getTableHeader().setReorderingAllowed(false);
        tabela_OrdemCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_OrdemCompraMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabela_OrdemCompra);
        if (tabela_OrdemCompra.getColumnModel().getColumnCount() > 0) {
            tabela_OrdemCompra.getColumnModel().getColumn(0).setMinWidth(0);
            tabela_OrdemCompra.getColumnModel().getColumn(0).setPreferredWidth(0);
            tabela_OrdemCompra.getColumnModel().getColumn(0).setMaxWidth(0);
            tabela_OrdemCompra.getColumnModel().getColumn(1).setResizable(false);
            tabela_OrdemCompra.getColumnModel().getColumn(3).setResizable(false);
            tabela_OrdemCompra.getColumnModel().getColumn(4).setResizable(false);
            tabela_OrdemCompra.getColumnModel().getColumn(5).setResizable(false);
            tabela_OrdemCompra.getColumnModel().getColumn(6).setResizable(false);
            tabela_OrdemCompra.getColumnModel().getColumn(7).setResizable(false);
            tabela_OrdemCompra.getColumnModel().getColumn(8).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addContainerGap())
        );

        bt_processa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/1280454766_system-software-update.png"))); // NOI18N
        bt_processa.setText("Processar");
        bt_processa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_processaActionPerformed(evt);
            }
        });

        bt_exportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Table.png"))); // NOI18N
        bt_exportar.setText("Exportar");
        bt_exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_exportarActionPerformed(evt);
            }
        });

        label_processando.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_processando.setText("Processando... Aguarde...");

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        label_contador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_contador.setText("00000");

        label_divisor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_divisor.setText("/");

        label_totalOC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_totalOC.setText("00000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_processa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_exportar)
                        .addGap(32, 32, 32)
                        .addComponent(label_processando, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_sair))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(barra_progresso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_contador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_divisor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_totalOC)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(barra_progresso, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(label_contador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_divisor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_totalOC)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_processa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_exportar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_processando, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {barra_progresso, label_contador, label_divisor, label_totalOC});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(parametrosNS.bu.nivelUsuario < 4)
            check_todasEmpresas.setVisible(false);
        Table = (DefaultTableModel)tabela_OrdemCompra.getModel();
        if(fazManutencao.equals("N")){
            bt_alterarOC .setVisible(false);
            setTitle("Consulta Ordens de Compra");
        }else{
            bt_alterarOC .setVisible(true);
            setTitle("Manutenção Ordens de Compra");
        }
        
        InicializaCampos();
        
        label_processando.setVisible(false);
//        new Thread(){
//            public void run(){
//                index2 = 1;
                PegaOrdemCompra("S");
//            }
//        }.start();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        
    }//GEN-LAST:event_formWindowGainedFocus

    private void txt_ocInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_ocInicialFocusGained
        txt_ocInicial.setSelectionStart(0);
        txt_ocInicial.setSelectionEnd  (txt_ocInicial.getText().length());
    }//GEN-LAST:event_txt_ocInicialFocusGained

    private void txt_ocInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_ocInicialFocusLost
        txt_ocInicial.setText(parametrosNS.fc.FormataCampo(txt_ocInicial.getText(), 9, 0));
    }//GEN-LAST:event_txt_ocInicialFocusLost

    private void txt_ocInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ocInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_ocFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_ocInicial.setText(parametrosNS.fc.FormataCampo("", 9, 0));
            txt_ocFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_ocInicialKeyPressed

    private void txt_ocFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_ocFinalFocusGained
        txt_ocFinal.setSelectionStart(0);
        txt_ocFinal.setSelectionEnd  (txt_ocFinal.getText().length());
    }//GEN-LAST:event_txt_ocFinalFocusGained

    private void txt_ocFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_ocFinalFocusLost
        if(txt_ocFinal.getText().replace(" ", "").equals("")){
            txt_ocFinal.setText("999999999");
            return;
        }
        txt_ocFinal.setText(parametrosNS.fc.FormataCampo(txt_ocFinal.getText(), 9, 0));
    }//GEN-LAST:event_txt_ocFinalFocusLost

    private void txt_ocFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ocFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_descricao.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_ocFinal.setText("999999999");
            txt_descricao.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_ocFinalKeyPressed

    private void txt_descricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descricaoKeyReleased
        txt_descricao.setEditable (false);
        txt_descricao.setFocusable(false);
        textoBusca = txt_descricao.getText();
        PegaOrdemCompra("S");
        txt_descricao.setEditable (true);
        txt_descricao.setFocusable(true);
        txt_descricao.grabFocus();
    }//GEN-LAST:event_txt_descricaoKeyReleased

    private void bt_processaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_processaActionPerformed
        bt_processa.setEnabled  (false);
        bt_processa.setFocusable(false);
//        new Thread(){
//            public void run(){
                PegaOrdemCompra("S");
//            }
//        }.start();
        bt_processa.setEnabled  (true);
        bt_processa.setFocusable(true);
    }//GEN-LAST:event_bt_processaActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void tabela_OrdemCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_OrdemCompraMouseClicked
        linha = tabela_OrdemCompra.getSelectedRow();
        if(linha < 0){
            mensagem = "Item não selecionado";
            mostraMensagem();
            return;
        }
        retorno = String.valueOf(Integer.parseInt(String.valueOf(tabela_OrdemCompra.getValueAt(linha, 0))));
        if(evt.getButton() == MouseEvent.BUTTON3){
            if(somostra.equals("N")){
                MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
        if(evt.getClickCount() < 2){
            return;
        }
        dispose();
    }//GEN-LAST:event_tabela_OrdemCompraMouseClicked

    private void bt_exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_exportarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_exportarActionPerformed

    private void bt_detalhesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesItemActionPerformed
        if(OrdComCad != null){
            if(OrdComCad.isVisible()){
                OrdComCad.setState(JFrame.NORMAL);
                return;
            }
        }
        OrdComCad = new OrdemCompraCadastro("S", Integer.parseInt(retorno));
        OrdComCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JProgressBar barra_progresso;
    private javax.swing.JMenuItem bt_alterarOC;
    private javax.swing.JMenuItem bt_detalhesItem;
    private javax.swing.JButton bt_exportar;
    private javax.swing.JButton bt_processa;
    private javax.swing.JButton bt_sair;
    private javax.swing.JCheckBox check_todasEmpresas;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_contador;
    private javax.swing.JLabel label_divisor;
    private javax.swing.JLabel label_processando;
    private javax.swing.JLabel label_totalOC;
    private javax.swing.JTable tabela_OrdemCompra;
    private javax.swing.JTextField txt_descricao;
    private javax.swing.JFormattedTextField txt_ocFinal;
    private javax.swing.JFormattedTextField txt_ocInicial;
    private javax.swing.JFormattedTextField txt_qtdRegistros;
    // End of variables declaration//GEN-END:variables
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    public String getRetorno(){
        return retorno;
    }
    
//    private void PegaUsuario(){
//        bu.usuario = "----------";
//        if(bu.codigoUsuario == 0)
//            return;
//        sql = "select idUsuario, idEmpresa, codigoGrupo, codigoEmpresa, codigoUsuario, usuario from tb_usuarios where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
//        dadosUsuarios.clear();
//        dadosUsuarios = parametrosNS.dao.Consulta(sql);
//        if(dadosUsuarios.isEmpty()){
//            mensagem = "Usuario " + bu.codigoUsuario + " não encontrado!";
//            new MostraMensagem(mensagem);
//            return;
//        }
//        PegaDadosUsuario();
//    }
//    
//    private void PegaDadosUsuario(){
//        for(int i = 0; i < dadosUsuarios.size(); i++){
//            bu.idUsuario            = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(0)));
//            bu.idEmpresa            = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(1)));
//            bu.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(2)));
//            bu.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(3)));
//            bu.codigoUsuario        = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(4)));
//            bu.usuario              =                    String.valueOf(dadosUsuarios.get(i).get(5));
//        }
//    }
    
    private void PegaValores(){
        fatal = "N";
        binter.ocInicial    = Integer.parseInt(txt_ocInicial.getText());
        binter.ocFinal      = Integer.parseInt(txt_ocFinal.getText());
        if(binter.ocInicial > binter.osFinal){
            mensagem = "OC inicial não pode ser maior do que a OC final!";
            mostraMensagem();
            fatal = "S";
            return;
        }
        textoBusca   = txt_descricao.getText();
        qtdRegistros = Integer.parseInt(txt_qtdRegistros.getText());
    }
    
    private void PegaOrdemCompra(String Mostra){
        tabela_OrdemCompra.getColumnModel().getColumn(0).setMinWidth(0);
        tabela_OrdemCompra.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabela_OrdemCompra.getColumnModel().getColumn(0).setMaxWidth(0);
        tabela_OrdemCompra.getColumnModel().getColumn(1).setResizable(false);
        
        tabela_OrdemCompra.getColumnModel().getColumn(2).setMinWidth(0);
        tabela_OrdemCompra.getColumnModel().getColumn(2).setPreferredWidth(0);
        tabela_OrdemCompra.getColumnModel().getColumn(2).setMaxWidth(0);
        if(check_todasEmpresas.isSelected()){
            tabela_OrdemCompra.getColumnModel().getColumn(2).setMinWidth(0);
            tabela_OrdemCompra.getColumnModel().getColumn(2).setPreferredWidth(0);
            tabela_OrdemCompra.getColumnModel().getColumn(2).setMaxWidth(500);
        }
        tabela_OrdemCompra.getColumnModel().getColumn(2).setResizable(false);
        tabela_OrdemCompra.getColumnModel().getColumn(3).setResizable(false);
        tabela_OrdemCompra.getColumnModel().getColumn(4).setResizable(false);
        tabela_OrdemCompra.getColumnModel().getColumn(5).setResizable(false);
        
        tabela_OrdemCompra.getColumnModel().getColumn(6).setResizable(false);
        tabela_OrdemCompra.getColumnModel().getColumn(6).setCellRenderer(parametrosNS.tableDireita);
        
        tabela_OrdemCompra.getColumnModel().getColumn(7).setResizable(false);
        tabela_OrdemCompra.getColumnModel().getColumn(8).setResizable(false);
        tabela_OrdemCompra.getColumnModel().getColumn(9).setResizable(false);
        
        if(Mostra.equals("S")){
            label_processando.setVisible(true);
        }
        PegaValores();
        if(fatal.equals("S")){
            return;
        }
        sql1 = "";
        sql = "select \n"
/*00*/      + "   oc.idOrdemCompra, \n"
/*01*/      + "   oc.idEmpresa, \n"
/*02*/      + "   oc.codigoGrupo, \n"
/*03*/      + "   oc.codigoEmpresa, \n"
/*04*/      + "   oc.codigoOrdemCompra, \n"
/*05*/      + "   oc.codigoComprador, \n"
/*06*/      + "   nsemp.nomeEmpresa, \n"
/*07*/      + "   oc.codigoFornecedor, \n"
/*08*/      + "   forn.nome, \n"
/*09*/      + "   oc.dataCadastro, \n"
/*10*/      + "   oc.dataDeCompra, \n"
/*11*/      + "   oc.horaDeCompra, \n"
/*12*/      + "   oc.valorDeCompra, \n"
/*13*/      + "   oc.codigoPagamento, \n"
/*14*/      + "   forp.descricaoPagamento, \n"
/*15*/      + "   oc.dataDePagamento, \n"
/*16*/      + "   oc.horaDePagamento, \n"
/*17*/      + "   oc.dataDeRecebimento, \n"
/*18*/      + "   oc.horaDeRecebimento, \n"
/*19*/      + "   oc.responsavelPeloRecebimento \n"
            + "from \n"
            + "   tb_oc oc \n"
            + "   left join ns_empresas nsemp  on (oc.idEmpresa = nsemp.idEmpresa) \n"
            + "   left join tb_fornecedor forn on ((oc.idEmpresa = forn.idEmpresa) and (oc.codigoFornecedor = forn.codigoFornecedor)) \n"
            + "   left join tb_formaspagamentos forp on ((oc.idEmpresa = forp.idEmpresa) and (oc.codigoPagamento = forp.codigoPagamento)) ";
        if(Mostra.equals("S")){
            if(check_todasEmpresas.isSelected()){
                sql += "\n   where oc.codigoGrupo = " + parametrosNS.bge.CodigoGrupo;
                tabela_OrdemCompra.setEnabled  (false);
                tabela_OrdemCompra.setFocusable(false);
            }else{
                sql += "\n   where oc.codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and oc.codigoEmpresa = " + parametrosNS.be.CodigoEmpresa;
                tabela_OrdemCompra.setEnabled  (true);
                tabela_OrdemCompra.setFocusable(true);
            }
            sql += "\n and codigoOrdemCompra between " + binter.ocInicial + " and " + binter.ocFinal;
            if(!textoBusca.equals("")){
                sql += "\n and oc.";
                sql1 = " like '%" + textoBusca + "%'";
            }
            sql1 += "\n      order by oc.codigoOrdemCompra desc limit " + qtdRegistros + ";";
            if(textoBusca.equals("")){
                sql += sql1;
                sql1 = "";
            }
        }
        if(Mostra.equals("N")){
            sql += "\n where oc.idOrdemCompra = " + boc.idOrdemCompra + ";";
        }
        if( sql1.equals("")){dadosOrdemCompra = parametrosNS.dao.Consulta(sql);}
        if(!sql1.equals("")){dadosOrdemCompra = parametrosNS.PesqAvan.PesquisaAvancada(sql, sql1, "tb_oc");}
        if(Mostra.equals("S")){
            barra_progresso.setValue(0);
            barra_progresso.setMaximum(dadosOrdemCompra.size());
        }
        if(dadosOrdemCompra.isEmpty()){
            if(Mostra.equals("S")){
                PegaOrdemCompra("S");
                bt_exportar.setEnabled(false);
                return;
            }
            return;
        }
        if(Mostra.equals("S")){label_totalOC.setText(parametrosNS.fc.FormataCampo(String.valueOf(dadosOrdemCompra.size()), 5, 0));}
        PreencherTabelaOrdemCompra(Mostra);
        label_processando.setVisible(false);
    }
    
    private void PreencherTabelaOrdemCompra(String Mostra){
        tabela_OrdemCompra.getColumnModel().getColumn(0).setMinWidth(0);
        tabela_OrdemCompra.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabela_OrdemCompra.getColumnModel().getColumn(0).setMaxWidth(0);
        tabela_OrdemCompra.getColumnModel().getColumn(1).setResizable(false);
        tabela_OrdemCompra.getColumnModel().getColumn(2).setResizable(false);
        tabela_OrdemCompra.getColumnModel().getColumn(3).setResizable(false);
        tabela_OrdemCompra.getColumnModel().getColumn(4).setResizable(false);
        tabela_OrdemCompra.getColumnModel().getColumn(5).setResizable(false);
        tabela_OrdemCompra.getColumnModel().getColumn(6).setResizable(false);
        tabela_OrdemCompra.getColumnModel().getColumn(7).setResizable(false);
        tabela_OrdemCompra.getColumnModel().getColumn(8).setResizable(false);
        tabela_OrdemCompra.getColumnModel().getColumn(9).setResizable(false);
        
        if(Mostra.equals("S"))
            Table.setNumRows(0);
        String nomeFornecedor       = "";
        String descricaoPagamento   = "";
        String nomeCompradora       = "";
        
        ValorTotalOrdemCompra   = 0;
        contador = 0;
        for(int i = 0; i < dadosOrdemCompra.size(); i++){
            nomeFornecedor      = "";
            descricaoPagamento  = "";
            boc     = new BeanOrdemCompra();
            bfor    = new BeanFornecedor();
            
            if(dadosOrdemCompra.get(i).get(0)  != null)
                boc.idOrdemCompra              = Integer.parseInt(  String.valueOf(dadosOrdemCompra.get(i).get(0)));
            if(dadosOrdemCompra.get(i).get(1)  != null)
                boc.idEmpresa                  = Integer.parseInt(  String.valueOf(dadosOrdemCompra.get(i).get(1)));
            if(dadosOrdemCompra.get(i).get(2)  != null)
                boc.codigoGrupo                = Integer.parseInt(  String.valueOf(dadosOrdemCompra.get(i).get(2)));
            if(dadosOrdemCompra.get(i).get(3) != null)
                boc.codigoEmpresa              = Integer.parseInt(  String.valueOf(dadosOrdemCompra.get(i).get(3)));
            if(dadosOrdemCompra.get(i).get(4)  != null)
                boc.codigoOrdemCompra          = Integer.parseInt(  String.valueOf(dadosOrdemCompra.get(i).get(4)));
            
            be.idEmpresa     = boc.idEmpresa;
            be.codigoGrupo   = boc.codigoGrupo;
            if(dadosOrdemCompra.get(i).get(5)  != null)
                boc.codigoComprador            = Integer.parseInt(  String.valueOf(dadosOrdemCompra.get(i).get(5)));
            be.codigoEmpresa = boc.codigoComprador;
            if(dadosOrdemCompra.get(i).get(6)  != null)
                be.nomeEmpresa                 =                    String.valueOf(dadosOrdemCompra.get(i).get(6));
            if(dadosOrdemCompra.get(i).get(7)  != null)
                boc.codigoFornecedor           = Integer.parseInt(  String.valueOf(dadosOrdemCompra.get(i).get(7)));
            if(dadosOrdemCompra.get(i).get(8)  != null)
                bfor.nome                      =                    String.valueOf(dadosOrdemCompra.get(i).get(8));
            if(dadosOrdemCompra.get(i).get(9)  != null)
                boc.dataCadastro               =                    String.valueOf(dadosOrdemCompra.get(i).get(9));
            if(dadosOrdemCompra.get(i).get(10)  != null)
                boc.dataDeCompra               =                    String.valueOf(dadosOrdemCompra.get(i).get(10));
            if(dadosOrdemCompra.get(i).get(11)  != null)
                boc.horaDeCompra               =                    String.valueOf(dadosOrdemCompra.get(i).get(11));
            if(dadosOrdemCompra.get(i).get(12) != null)
                boc.valorDeCompra              = Double.parseDouble(String.valueOf(dadosOrdemCompra.get(i).get(12)));
            if(dadosOrdemCompra.get(i).get(13) != null)
                boc.codigoPagamento            = Integer.parseInt(  String.valueOf(dadosOrdemCompra.get(i).get(13)));
            if(dadosOrdemCompra.get(i).get(14) != null)
                bforp.descricaoPagamento       =                    String.valueOf(dadosOrdemCompra.get(i).get(14));
            if(dadosOrdemCompra.get(i).get(15) != null)
                boc.dataDePagamento            =                    String.valueOf(dadosOrdemCompra.get(i).get(15));
            if(dadosOrdemCompra.get(i).get(16) != null)
                boc.horaDePagamento            =                    String.valueOf(dadosOrdemCompra.get(i).get(16));
            if(dadosOrdemCompra.get(i).get(17) != null)
                boc.dataDeRecebimento          =                    String.valueOf(dadosOrdemCompra.get(i).get(17));
            if(dadosOrdemCompra.get(i).get(18) != null)
                boc.horaDeRecebimento          =                    String.valueOf(dadosOrdemCompra.get(i).get(18));
            if(dadosOrdemCompra.get(i).get(19) != null)
                boc.responsavelPeloRecebimento =                    String.valueOf(dadosOrdemCompra.get(i).get(19));
            
            if(Mostra.equals("N")){
                return;
            }
            
            setaBarra();
            
            if(!boc.dataCadastro.equals("")){
                boc.dataCadastro        = parametrosNS.invdata.inverterData(boc.dataCadastro     , 1);
            }
            if(!boc.dataDeCompra.equals("")){
                boc.dataDeCompra        = parametrosNS.invdata.inverterData(boc.dataDeCompra     , 1) + "  " + boc.horaDeCompra;
            }
            if(!boc.dataDePagamento.equals("")){
                boc.dataDePagamento     = parametrosNS.invdata.inverterData(boc.dataDePagamento  , 1) + "  " + boc.horaDePagamento;
            }
            if(!boc.dataDeRecebimento.equals("")){
                boc.dataDeRecebimento   = parametrosNS.invdata.inverterData(boc.dataDeRecebimento, 1) + "  " + boc.horaDeRecebimento;
            }
            
            nomeCompradora          = parametrosNS.fc.FormataCampo(String.valueOf(be.codigoEmpresa), 3, 0) + "-" + be.nomeEmpresa;
            
            bfor.idEmpresa          = boc.idEmpresa;
            bfor.codigoGrupo        = boc.codigoGrupo;
            bfor.codigoEmpresa      = boc.codigoEmpresa;
            bfor.codigoFornecedor   = boc.codigoFornecedor;
            nomeFornecedor          = parametrosNS.fc.FormataCampo(String.valueOf(bfor.codigoFornecedor), 5, 0) + "-" + bfor.nome;
            
            bforp.idEmpresa         = boc.idEmpresa;
            bforp.codigoGrupo       = boc.codigoGrupo;
            bforp.codigoEmpresa     = boc.codigoEmpresa;
            bforp.codigoPagamento   = boc.codigoPagamento;
            descricaoPagamento      = boc.dataDePagamento + "  " + parametrosNS.fc.FormataCampo(String.valueOf(bforp.codigoPagamento), 2, 0) + "-" + bforp.descricaoPagamento;
            
            Table.addRow(new Object [] {parametrosNS.fc.FormataCampo(String.valueOf(boc.idOrdemCompra), 9, 0), parametrosNS.fc.FormataCampo(String.valueOf(boc.codigoOrdemCompra), 9, 0), nomeCompradora, nomeFornecedor, boc.dataCadastro, boc.dataDeCompra, parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(boc.valorDeCompra), 0), descricaoPagamento, boc.dataDeRecebimento, boc.responsavelPeloRecebimento});
        }
//        if(tabela_OrdemCompra.getRowCount() > 0)
            new AjustarLarguraColunas(tabela_OrdemCompra);
    }
    
    private void setaBarra(){
        contador++;
        barra_progresso.setValue(contador);
        barra_progresso.repaint();
        label_contador .setText(parametrosNS.fc.FormataCampo(String.valueOf(contador), 5, 0));
    }
    
//    private void PegaFornecedor(){
//        bfor.nome = "----------";
//        sql = "select \n"
//            + "   idFornecedor, \n"
//            + "   idEmpresa, \n"
//            + "   codigoGrupo, \n"
//            + "   codigoEmpresa, \n"
//            + "   codigoFornecedor, \n"
//            + "   nome \n"
//            + "from \n"
//            + "   tb_fornecedor where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoFornecedor = " + bfor.codigoFornecedor + ";";
//        dadosFornecedor.clear();
//        dadosFornecedor = parametrosNS.dao.Consulta(sql1);
//        if(dadosFornecedor.isEmpty())
//            return;
//        PegaDadosFornecedor();
//    }
//    
//    private void PegaDadosFornecedor(){
//        for(int i = 0; i < dadosFornecedor.size(); i++){
//            bfor.idFornecedor       = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(0)));
//            bfor.idEmpresa          = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(1)));
//            bfor.codigoGrupo        = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(2)));
//            bfor.codigoEmpresa      = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(3)));
//            bfor.codigoFornecedor   = Integer.parseInt(  String.valueOf(dadosFornecedor.get(i).get(4)));
//            bfor.nome               =                    String.valueOf(dadosFornecedor.get(i).get(5));
//        }
//    }
//    
//    private void PegaFormaDePagamento(){
//        bforp.descricaoPagamento = "---------------";
//        sql = "select \n"
//            + "   idPagamento, \n"
//            + "   idEmpresa, \n"
//            + "   codigoGrupo, \n"
//            + "   codigoEmpresa, \n"
//            + "   codigoPagamento, \n"
//            + "   descricaoPagamento, \n"
//            + "   codigoContaCorrente \n"
//            + "from \n"
//            + "   tb_formaspagamentos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoPagamento = " + bforp.codigoPagamento + ";";
//        dadosPagamentos.clear();
//        dadosPagamentos = parametrosNS.dao.Consulta(sql);
//        if(dadosFornecedor.isEmpty())
//            return;
//        PegaDadosFormaDePagamento();
//    }
//    
//    private void PegaDadosFormaDePagamento(){
//        for(int i = 0; i < dadosPagamentos.size(); i++){
//            bforp.idPagamento           = Integer.parseInt(String.valueOf(dadosPagamentos.get(i).get(0)));
//            bforp.idEmpresa             = Integer.parseInt(String.valueOf(dadosPagamentos.get(i).get(1)));
//            bforp.codigoGrupo           = Integer.parseInt(String.valueOf(dadosPagamentos.get(i).get(2)));
//            bforp.codigoEmpresa         = Integer.parseInt(String.valueOf(dadosPagamentos.get(i).get(3)));
//            bforp.codigoPagamento       = Integer.parseInt(String.valueOf(dadosPagamentos.get(i).get(4)));
//            bforp.descricaoPagamento    =                  String.valueOf(dadosPagamentos.get(i).get(5));
//            bforp.codigoContaCorrente   = Integer.parseInt(String.valueOf(dadosPagamentos.get(i).get(6)));
//        }
//    }
    
}
