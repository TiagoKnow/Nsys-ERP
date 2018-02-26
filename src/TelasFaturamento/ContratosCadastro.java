package TelasFaturamento;

import Beans.BeanClientes;
import Beans.BeanContratos;
import Beans.BeanUsuarios;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.PegaProximoRegistro;
import FuncoesInternas.TransformaValorStringeDouble;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
/*
 @author Tiago e Paulo
 */
public class ContratosCadastro extends javax.swing.JFrame {
    //String's
    String sql                                      = "";
    String sqlstate                                 = "";
    String Mensagem                                 = "";
    String fatal                                    = "";
    String somostra                                 = "";
    String operacao                                 = "";
    String retorno                                  = "";
    
    //int's
    int    abriuContratos                           = 0;
    int    abriuClientes                            = 0;
    int    abriuManutencoes                         = 0;
    
    //Vetores
    ArrayList            parametros                            = new ArrayList();
    ArrayList            dadosPadroes                          = new ArrayList();
    ArrayList<ArrayList> dadosCliente                          = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosContratos                        = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosUsuario                          = new ArrayList<ArrayList>();
    
    //Bean's
    BeanClientes                    bc          = new BeanClientes();
    BeanContratos                   bcon        = new BeanContratos();
    BeanUsuarios                    bu          = new BeanUsuarios();
    
    //Especiais
    FormataCampo                    fc          = new FormataCampo();
    CapturarDataHora                cdh         = new CapturarDataHora();
    InverterData                    invdata     = new InverterData();
    PegaProximoRegistro             PegProReg   = new PegaProximoRegistro();
    TransformaValorStringeDouble    TransStrDou = new TransformaValorStringeDouble();
    
    //Telas
    ContratosConsulta                   ConCon;
    ClientesConsulta                    CliCon;
    ManutencoesConsulta                 ManCon;
    
    public ContratosCadastro(ArrayList DadosPadroes){
        dadosPadroes                    = DadosPadroes;
        
        somostra                        = (String)  dadosPadroes.get(0);
        bc.codigoCliente                = (int)     dadosPadroes.get(1);
        bcon.codigoContrato             = (int)     dadosPadroes.get(2);
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_codigoContrato = new javax.swing.JFormattedTextField();
        bt_novo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigoCliente = new javax.swing.JFormattedTextField();
        label_nomeCliente = new javax.swing.JLabel();
        bt_pesquisaCliente = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_dataContrato = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_dataCadastro = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_dataVencimento = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descricaoContrato = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        txt_valorContrato = new javax.swing.JTextField();
        txt_dataReajuste = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        bt_incluir = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        bt_pesquisa = new javax.swing.JButton();
        label_alteracao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Contratos");
        setResizable(false);
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

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Código");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_codigoContrato.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoContrato.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoContrato.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoContratoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoContratoFocusLost(evt);
            }
        });
        txt_codigoContrato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoContratoKeyPressed(evt);
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
                .addComponent(txt_codigoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(txt_codigoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, txt_codigoContrato});

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cliente");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_codigoCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoClienteFocusLost(evt);
            }
        });

        bt_pesquisaCliente.setText("...");
        bt_pesquisaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_pesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nomeCliente)
                    .addComponent(bt_pesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaCliente, label_nomeCliente, txt_codigoCliente});

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Dados do Contrato");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Data do Contrato:");

        try {
            txt_dataContrato.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataContrato.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setText("Data do Cadastro:");

        txt_dataCadastro.setEditable(false);
        try {
            txt_dataCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataCadastro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataCadastro.setFocusable(false);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Data do Vencimento:");

        try {
            txt_dataVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataVencimento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Descrição do Contrato:");

        txt_descricaoContrato.setColumns(20);
        txt_descricaoContrato.setRows(5);
        jScrollPane1.setViewportView(txt_descricaoContrato);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Valor do Contrato:");

        txt_valorContrato.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_valorContratoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorContratoFocusLost(evt);
            }
        });

        try {
            txt_dataReajuste.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataReajuste.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel10.setText("Data do Reajuste:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_valorContrato, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_dataContrato, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_dataVencimento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                        .addGap(90, 90, 90)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_dataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_dataReajuste, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel5, jLabel7, jLabel8, jLabel9});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_valorContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_dataContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_dataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txt_dataReajuste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txt_dataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, txt_dataContrato});

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

        bt_pesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/View.png"))); // NOI18N
        bt_pesquisa.setText("Pesquisa");
        bt_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaActionPerformed(evt);
            }
        });

        label_alteracao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label_alteracao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_alteracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(bt_incluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_alterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_pesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_sair)))
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
                    .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_alteracao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_alterar, bt_incluir, bt_pesquisa, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoContratoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoContratoFocusGained
        if(txt_codigoContrato.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        operacao = "";
        ReiniciaCampos();
        HabilitaBotoes();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoContratoFocusGained

    private void txt_codigoContratoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoContratoFocusLost
        if(txt_codigoContrato.isEditable() == false)
            return;
        if(txt_codigoContrato.getText().replace(" ", "").equals(""))
            return;
        PegaContrato();
    }//GEN-LAST:event_txt_codigoContratoFocusLost

    private void txt_codigoContratoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoContratoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            txt_codigoCliente.grabFocus();
    }//GEN-LAST:event_txt_codigoContratoKeyPressed

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        NovoContrato();
    }//GEN-LAST:event_bt_novoActionPerformed
    
    private void NovoContrato(){
        ReiniciaCampos();
        HabilitaCampos(true);
        
        bcon.codigoContrato     = PegProReg.PegaProximoRegistro("tb_contratos", "codigoContrato", "");
        txt_codigoContrato.setText(fc.FormataCampo(String.valueOf(bcon.codigoContrato), 9, 0));
        
        operacao = "I";
        HabilitaBotoes();
        if(txt_codigoCliente.getText().replace(" ", "").equals(""))
            txt_codigoCliente.grabFocus();
        else
            txt_valorContrato.grabFocus();
    }
    
    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "insert into tb_contratos (idEmpresa, codigoGrupo, codigoEmpresa, codigoContrato, codigoCliente, codigoUsuario, valorContrato, dataCadastro, dataContrato, dataVencimento, dataReajuste, descricaoContrato, statusContrato) "
            + "values (" + bcon.idEmpresa + ", " + bcon.codigoGrupo + ", " + bcon.codigoEmpresa + ", " + bcon.codigoContrato + ", " + bcon.codigoCliente + ", " + bcon.codigoUsuario + ", " + bcon.valorContrato + ", '" + bcon.dataCadastro + "', '" + bcon.dataContrato + "', " + bcon.dataVencimento + ", '" + bcon.dataReajuste + "', '" + bcon.descricaoContrato + "', 0);";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoContrato.grabFocus();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "update tb_contratos set dataContrato = '"        + bcon.dataContrato         + "', "
                                    + "dataVencimento = "       + bcon.dataVencimento       + ", "
                                    + "dataReajuste = '"        + bcon.dataReajuste         + "', "
                                    + "descricaoContrato = '"   + bcon.descricaoContrato    + "', "
                                    + "idEmpresaAlterou = "     + bcon.idEmpresaAlterou     + ", "
                                    + "codigoGrupoAlterou = "   + bcon.codigoGrupoAlterou   + ", "
                                    + "codigoEmpresaAlterou = " + bcon.codigoEmpresaAlterou + ", "
                                    + "dataAlterou = '"         + bcon.dataAlterou          + "', "
                                    + "horaAlterou = '"         + bcon.horaAlterou          + "', "
                                    + "usuarioAlterou = "       + bcon.usuarioAlterou       + " "
                                    + "where idContrato = " + bcon.idContrato   + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoContrato.grabFocus();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        parametros.clear();
        parametros.add("S");
        if(txt_codigoCliente.isEditable()){
            parametros.add(0);
        }else{
            parametros.add(Integer.parseInt(txt_codigoCliente.getText()));
        }
        if(ConCon != null)if(ConCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuContratos = 1;
        ConCon = new ContratosConsulta(parametros);
        ConCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuContratos == 0){
            AbreClientes();
            return;
        }
        abriuContratos = 0;
        retorno = ConCon.getRetornoContrato();
        if(retorno.equals(""))
            return;
        txt_codigoContrato.setText(retorno);
        PegaContrato();
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbreClientes(){
        if(abriuClientes == 0)
            return;
        abriuClientes = 0;
        retorno = CliCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoCliente.setText(retorno);
        PegaCliente();
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(somostra.equals("S")){
            bt_novo                     .setEnabled (false);
            txt_codigoContrato          .setEditable(false);
            txt_codigoCliente           .setEditable(false);
            txt_valorContrato           .setEditable(false);
            bt_pesquisaCliente          .setEnabled (false);
            bt_incluir                  .setVisible (false);
            bt_alterar                  .setVisible (false);
            bt_pesquisa                 .setVisible (false);
        }
        if(somostra.equals("SN"))
            bt_pesquisa.setVisible(false);
        if(bcon.codigoContrato != 0){
            txt_codigoContrato.setText(String.valueOf(bcon.codigoContrato));
            PegaContrato();
        }
        if(bc.codigoCliente != 0){
            txt_codigoCliente   .setText        (String.valueOf(bc.codigoCliente));
            PegaCliente();
            txt_codigoCliente   .setEditable    (false);
            txt_codigoCliente   .setFocusable   (false);
            bt_pesquisaCliente  .setEnabled     (false);
        }
    }//GEN-LAST:event_formWindowOpened

    private void txt_codigoClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteFocusGained
        if(txt_codigoContrato.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        txt_codigoCliente.setText("");
        label_nomeCliente.setText("");
    }//GEN-LAST:event_txt_codigoClienteFocusGained

    private void txt_codigoClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteFocusLost
        if(txt_codigoCliente.isEditable() == false)
            return;
        if(txt_codigoCliente.getText().replace(" ", "").equals(""))
            return;
        PegaCliente();
    }//GEN-LAST:event_txt_codigoClienteFocusLost

    private void bt_pesquisaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaClienteActionPerformed
        if(CliCon != null)if(CliCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuClientes = 1;
        CliCon = new ClientesConsulta("N");
        CliCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaClienteActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(ConCon   != null)ConCon.dispose();
        if(CliCon   != null)CliCon.dispose();
        if(ManCon   != null)ManCon.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void txt_valorContratoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorContratoFocusLost
        if(txt_valorContrato.isEditable() == false)
            return;
        if(!txt_valorContrato.getText().equals(""))
            txt_valorContrato.setText(TransStrDou.TransformaValorStringeDouble(txt_valorContrato.getText(), 0));
    }//GEN-LAST:event_txt_valorContratoFocusLost

    private void txt_valorContratoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorContratoFocusGained
        if(txt_valorContrato.isEditable() == false)
            return;
        if(!txt_valorContrato.getText().equals(""))
            txt_valorContrato.setText(TransStrDou.TransformaValorStringeDouble(txt_valorContrato.getText(), 1));
    }//GEN-LAST:event_txt_valorContratoFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisa;
    private javax.swing.JButton bt_pesquisaCliente;
    private javax.swing.JButton bt_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_alteracao;
    private javax.swing.JLabel label_nomeCliente;
    private javax.swing.JFormattedTextField txt_codigoCliente;
    private javax.swing.JFormattedTextField txt_codigoContrato;
    private javax.swing.JFormattedTextField txt_dataCadastro;
    private javax.swing.JFormattedTextField txt_dataContrato;
    private javax.swing.JFormattedTextField txt_dataReajuste;
    private javax.swing.JFormattedTextField txt_dataVencimento;
    private javax.swing.JTextArea txt_descricaoContrato;
    private javax.swing.JTextField txt_valorContrato;
    // End of variables declaration//GEN-END:variables
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_incluir  .setEnabled(true);
            bt_alterar  .setEnabled(false);
            return;
        }
        if(operacao.equals("A")){
            bt_incluir  .setEnabled(false);
            bt_alterar  .setEnabled(true);
            return;
        }
        bt_incluir      .setEnabled(false);
        bt_alterar      .setEnabled(false);
    }
    
    private void ReiniciaCampos(){
        if(txt_codigoCliente.isEditable() == true){
            bc  = new BeanClientes();
            txt_codigoCliente   .setText("");
            label_nomeCliente   .setText("");
        }
        bcon    = new BeanContratos();
        bu      = new BeanUsuarios();
        txt_codigoContrato      .setText("");
        txt_valorContrato       .setText("");
        txt_dataContrato        .setText("");
        txt_dataCadastro        .setText(cdh.CapturarData());
        txt_dataVencimento      .setText("");
        txt_dataReajuste        .setText("");
        txt_descricaoContrato   .setText("");
        label_alteracao         .setText("");
    }
    
    private void HabilitaCampos(boolean Habilita){
        if(txt_codigoCliente.isEditable() == false){
            txt_codigoCliente           .setEditable    (false);
            txt_codigoCliente           .setFocusable   (false);
            bt_pesquisaCliente          .setEnabled     (false);
            bt_pesquisaCliente          .setFocusable   (false);
        }else{
            txt_codigoCliente           .setEditable    (true);
            txt_codigoCliente           .setFocusable   (true);
            bt_pesquisaCliente          .setEnabled     (true);
            bt_pesquisaCliente          .setFocusable   (true);
        }
        txt_valorContrato           .setEditable    (Habilita);
        txt_valorContrato           .setFocusable   (Habilita);
        txt_dataContrato            .setEditable    (Habilita);
        txt_dataContrato            .setFocusable   (Habilita);
        txt_dataVencimento          .setEditable    (Habilita);
        txt_dataVencimento          .setFocusable   (Habilita);
        txt_dataReajuste            .setEditable    (Habilita);
        txt_dataReajuste            .setFocusable   (Habilita);
        txt_descricaoContrato       .setEditable    (Habilita);
        txt_descricaoContrato       .setFocusable   (Habilita);
    }
    
    private void PegaContrato(){
        txt_codigoContrato.setText(fc.FormataCampo(txt_codigoContrato.getText(), 9, 0));
        bcon.codigoContrato     = Integer.parseInt(txt_codigoContrato.getText());
        sql = "select * from tb_contratos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoContrato = " + bcon.codigoContrato + ";";
        dadosContratos.clear();
        dadosContratos = parametrosNS.dao.Consulta(sql);
        if(dadosContratos.isEmpty()){
            Mensagem = "Contrato n°" + bcon.codigoContrato + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        HabilitaCampos(true);
        PegaDadosContrato();
    }
    
    private void PegaDadosContrato(){
        for(int i = 0; i < dadosContratos.size(); i++){
            bcon = new BeanContratos();
            if(dadosContratos.get(i).get(0) != null)
                bcon.idContrato             = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(0)));
            if(dadosContratos.get(i).get(1) != null)
                bcon.idEmpresa              = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(1)));
            if(dadosContratos.get(i).get(2) != null)
                bcon.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(2)));
            if(dadosContratos.get(i).get(3) != null)
                bcon.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(3)));
            if(dadosContratos.get(i).get(4) != null)
                bcon.codigoContrato         = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(4)));
            if(dadosContratos.get(i).get(5) != null)
                bcon.codigoCliente          = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(5)));
            if(dadosContratos.get(i).get(6) != null)
                bcon.codigoUsuario          = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(6)));
            if(dadosContratos.get(i).get(7) != null)
                bcon.valorContrato          = Double.parseDouble(String.valueOf(dadosContratos.get(i).get(7)));
                bcon.dataCadastro           =                    String.valueOf(dadosContratos.get(i).get(8));
                bcon.dataContrato           =                    String.valueOf(dadosContratos.get(i).get(9));
                bcon.dataVencimento         =                    String.valueOf(dadosContratos.get(i).get(10));
                bcon.dataReajuste           =                    String.valueOf(dadosContratos.get(i).get(11));
                bcon.descricaoContrato      =                    String.valueOf(dadosContratos.get(i).get(12));
            if(dadosContratos.get(i).get(13) != null)
                bcon.statusContrato         = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(13)));
                bcon.dataAlterou            =                    String.valueOf(dadosContratos.get(i).get(14));
                bcon.horaAlterou            =                    String.valueOf(dadosContratos.get(i).get(15));
            if(dadosContratos.get(i).get(16) != null)
                bcon.usuarioAlterou         = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(16)));
            if(dadosContratos.get(i).get(17) != null)
                bcon.idEmpresaAlterou       = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(17)));
            if(dadosContratos.get(i).get(18) != null)
                bcon.codigoGrupoAlterou     = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(18)));
            if(dadosContratos.get(i).get(19) != null)
                bcon.codigoEmpresaAlterou   = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(19)));
        }
        
        if(bc.codigoCliente != 0)
            if(bc.codigoCliente != bcon.codigoCliente){
                txt_codigoContrato  .grabFocus();
                Mensagem = "Contrato n°" + bcon.codigoContrato + " não pertence ao Cliente n°" + bc.codigoCliente + "!";
                new MostraMensagem(Mensagem);
                return;
            }
        
        bc.codigoCliente            = bcon.codigoCliente;
        txt_codigoCliente           .setText(String.valueOf(bc.codigoCliente));
        PegaCliente();
        
        txt_valorContrato       .setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(bcon.valorContrato), 0));
        txt_dataContrato        .setText(invdata.inverterData(bcon.dataContrato     , 1));
        txt_dataCadastro        .setText(invdata.inverterData(bcon.dataCadastro     , 1));
        txt_dataVencimento      .setText(invdata.inverterData(bcon.dataVencimento   , 1));
        txt_dataReajuste        .setText(invdata.inverterData(bcon.dataReajuste     , 1));
        txt_descricaoContrato   .setText(bcon.descricaoContrato);
        
        if(bcon.usuarioAlterou != 0){
            bu.usuario          = "NS3";
            bcon.dataAlterou    = invdata.inverterData(bcon.dataAlterou, 1);
            if(parametrosNS.bu.codigoUsuario != 999){
                bu.idEmpresa            = bcon.idEmpresaAlterou;
                bu.codigoGrupo          = bcon.codigoGrupoAlterou;
                bu.codigoEmpresa        = bcon.codigoEmpresaAlterou;
                bu.codigoUsuario        = bcon.usuarioAlterou;
                PegaUsuario();
            }
            label_alteracao.setText("Última alteração feita em " + bcon.dataAlterou + " as " + bcon.horaAlterou + " por " + bu.usuario);
        }
    }
    
    private void PegaUsuario(){
        bu.usuario = "----------";
        sql = "select usuario from tb_usuarios where codigoGrupo = " + bu.codigoGrupo + " and codigoEmpresa = " + bu.codigoEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
        dadosUsuario.clear();
        dadosUsuario = parametrosNS.dao.Consulta(sql);
        if(dadosUsuario.isEmpty()){
            Mensagem = "Usuário n" + bu.codigoUsuario + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosUsuario();
    }
    
    private void PegaDadosUsuario(){
        for(int i = 0; i < dadosUsuario.size(); i++)
            bu.usuario = String.valueOf(dadosUsuario.get(i).get(0));
    }
    
    private void PegaCliente(){
        txt_codigoCliente.setText(fc.FormataCampo(txt_codigoCliente.getText(), 5, 0));
        bc.codigoCliente        = Integer.parseInt(txt_codigoCliente.getText());
        if(bc.codigoCliente == 0)
            return;
        sql = "select idCliente, idEmpresa, codigoGrupo, codigoEmpresa, codigoCliente, nome from tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCliente = " + bc.codigoCliente + ";";
        dadosCliente.clear();
        dadosCliente = parametrosNS.dao.Consulta(sql);
        if(dadosCliente.isEmpty()){
            Mensagem = "Cliente n°" + bc.codigoCliente + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosCliente();
    }
    
    private void PegaDadosCliente(){
        for(int i = 0; i < dadosCliente.size(); i++){
            bc = new BeanClientes();
            bc.idCliente            = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(0)));
            bc.idEmpresa            = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(1)));
            bc.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(2)));
            bc.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(3)));
            bc.codigoCliente        = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(4)));
            bc.nome                 =                    String.valueOf(dadosCliente.get(i).get(5));
        }
        label_nomeCliente.setText(bc.nome);
    }
    
    private void PegaValores(){
        bcon.idEmpresa              = parametrosNS.be.IdEmpresa;
        bcon.codigoGrupo            = parametrosNS.bge.CodigoGrupo;
        bcon.codigoEmpresa          = parametrosNS.be.CodigoEmpresa;
        bcon.codigoContrato         = Integer.parseInt(txt_codigoContrato.getText());
        if(txt_codigoCliente.getText().replace(" ", "").equals("")){
            Mensagem = "Código do cliente Inválido!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bcon.codigoCliente          = Integer.parseInt(txt_codigoCliente.getText());
        bcon.codigoUsuario          = parametrosNS.bu.codigoUsuario;
        bcon.valorContrato          = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_valorContrato.getText(), 1));
        bcon.dataContrato           = txt_dataContrato.getText();
        bcon.dataContrato           = bcon.dataContrato.replace("/", "");
        bcon.dataContrato           = bcon.dataContrato.replace(" ", "");
        if(bcon.dataContrato.equals("")){
            Mensagem = "Data do Contrato Inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bcon.dataContrato           = invdata.inverterData(txt_dataContrato.getText(), 2);
        bcon.dataCadastro           = invdata.inverterData(txt_dataCadastro.getText(), 2);
        bcon.dataVencimento         = txt_dataVencimento.getText();
        bcon.dataVencimento         = bcon.dataVencimento.replace("/", "");
        bcon.dataVencimento         = bcon.dataVencimento.replace(" ", "");
        if(bcon.dataVencimento.equals("")){
            bcon.dataVencimento     = null;
        }else{
            bcon.dataVencimento     = "'" + invdata.inverterData(bcon.dataVencimento, 2) + "'";
        }
        bcon.dataReajuste           = txt_dataReajuste.getText();
        bcon.dataReajuste           = bcon.dataReajuste.replace("/", "");
        bcon.dataReajuste           = bcon.dataReajuste.replace(" ", "");
        if(bcon.dataReajuste.equals("")){
            Mensagem = "Data do Reajuste Inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bcon.dataReajuste           = invdata.inverterData(txt_dataReajuste.getText(), 2);
        bcon.descricaoContrato      = txt_descricaoContrato.getText();
        
        bcon.idEmpresaAlterou       = parametrosNS.be.idEmpresa;
        bcon.codigoGrupoAlterou     = parametrosNS.bge.codigoGrupo;
        bcon.codigoEmpresaAlterou   = parametrosNS.be.codigoEmpresa;
        bcon.dataAlterou            = invdata.inverterData(cdh.CapturarData(), 2);
        bcon.horaAlterou            = cdh.CapturaHora();
        bcon.usuarioAlterou         = parametrosNS.bu.codigoUsuario;
    }
    
}
