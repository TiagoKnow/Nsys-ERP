package TelasVendas;

import Beans.BeanCaixaAbertura;
import Beans.BeanCaixaMotivoSaida;
import Beans.BeanCaixaSaida;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.ConverteValorDigitadoEmDouble;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.PegaProximoRegistro;
import FuncoesInternas.TransformaValorStringeDouble;
import Parametros.parametrosNS;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/*
 @author Tiago e Paulo
 */
public class SaidaDeCaixaCadastro extends javax.swing.JFrame {
    //String's
    String sql                                  = "";
    String somostra                             = "";
    String sqlstate                             = "";
    String retorno                              = "";
    String Mensagem                             = "";
    String operacao                             = "";
    String fatal                                = "";
    
    //int's
    int    UltimoRegistro                       = 0;
    int    abriuMotivos                         = 0;
    
    //Vetores ArrayList
    ArrayList            parametros             = new ArrayList();
    ArrayList<ArrayList> dadosAberturaCaixa     = new ArrayList<ArrayList>();
    ArrayList            dadosPadroes           = new ArrayList();
    ArrayList<ArrayList> dadosSaidaCaixa        = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosMotivoSaida       = new ArrayList<ArrayList>();
    
    //Bean's
    BeanCaixaSaida              bcs             = new BeanCaixaSaida();
    BeanCaixaMotivoSaida        bcms            = new BeanCaixaMotivoSaida();
    BeanCaixaAbertura           bca             = new BeanCaixaAbertura();
    
    //Especiais
    FormataCampo                    fc          = new FormataCampo();
    InverterData                    invdata     = new InverterData();
    CapturarDataHora                cdh         = new CapturarDataHora();
    PegaProximoRegistro             PegProReg   = new PegaProximoRegistro();
    TransformaValorStringeDouble    TransStrDou = new TransformaValorStringeDouble();
    
    //Telas
    MotivosDeSaidaDeCaixaConsulta   MotSaiCaiCon;
    
    public SaidaDeCaixaCadastro(ArrayList DadosPadroes){
        dadosPadroes                            = DadosPadroes;
        
        somostra                                = (String)  dadosPadroes.get(0);
        bcs.codigoCaixaSaida                    = (int)     dadosPadroes.get(1);
        
        initComponents();
    }
    
    private void PegaCaixaAberto(){
        bca.dataAbertura            = invdata.inverterData(cdh.CapturarData(), 2);
        sql = "select * from tb_caixa_abertura where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoComputador = " + parametrosNS.bcomp.codigoComputador + " and status = 'A';";
        dadosAberturaCaixa.clear();
        dadosAberturaCaixa = parametrosNS.dao.Consulta(sql);
        if(dadosAberturaCaixa.isEmpty()){
            txt_codigoCaixaSaida.setEditable(false);
            txt_codigoMotivoSaida.setEditable(false);
            bt_novo.setEnabled(false);
            bt_pesquisaMotivo.setEnabled(false);
            operacao = "";
            HabilitaBotoes();
            Mensagem = "Não foi encontrado caixa aberto para esse terminal!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosCaixaAberto();
    }
    
    private void PegaDadosCaixaAberto(){
        for(int i = 0; i < dadosAberturaCaixa.size(); i++){
            bca.idAbertura              = Integer.parseInt(  String.valueOf(dadosAberturaCaixa.get(i).get(0)));
            bca.idEmpresa               = Integer.parseInt(  String.valueOf(dadosAberturaCaixa.get(i).get(1)));
            bca.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosAberturaCaixa.get(i).get(2)));
            bca.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosAberturaCaixa.get(i).get(3)));
            bca.codigoAbertura          = Integer.parseInt(  String.valueOf(dadosAberturaCaixa.get(i).get(4)));
            bca.codigoComputador        = Integer.parseInt(  String.valueOf(dadosAberturaCaixa.get(i).get(5)));
            bca.codigoUsuario           = Integer.parseInt(  String.valueOf(dadosAberturaCaixa.get(i).get(6)));
            bca.dataAbertura            =                    String.valueOf(dadosAberturaCaixa.get(i).get(7));
            bca.horaAbertura            =                    String.valueOf(dadosAberturaCaixa.get(i).get(8));
            bca.valorDoCaixa            = Double.parseDouble(String.valueOf(dadosAberturaCaixa.get(i).get(9)));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_codigoCaixaSaida = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        bt_novo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_codigoMotivoSaida = new javax.swing.JFormattedTextField();
        bt_pesquisaMotivo = new javax.swing.JButton();
        label_descricaoMotivoSaida = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_valorDeSaida = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_detalhesCaixaSaida = new javax.swing.JTextArea();
        bt_incluir = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Saída de Caixa");
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
        jLabel1.setText("Saida de Caixa");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_codigoCaixaSaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoCaixaSaida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoCaixaSaida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoCaixaSaidaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoCaixaSaidaFocusLost(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Código:");

        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Motivo:");

        try {
            txt_codigoMotivoSaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoMotivoSaida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoMotivoSaida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoMotivoSaidaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoMotivoSaidaFocusLost(evt);
            }
        });

        bt_pesquisaMotivo.setText("...");
        bt_pesquisaMotivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaMotivoActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Saída de Caixa (R$):");

        txt_valorDeSaida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_valorDeSaidaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorDeSaidaFocusLost(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Descrição da Saída:");

        txt_detalhesCaixaSaida.setColumns(20);
        txt_detalhesCaixaSaida.setRows(5);
        jScrollPane1.setViewportView(txt_detalhesCaixaSaida);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_codigoMotivoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bt_pesquisaMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_codigoCaixaSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(bt_novo)
                                        .addGap(98, 224, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_descricaoMotivoSaida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap())))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_valorDeSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoCaixaSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txt_codigoMotivoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_pesquisaMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label_descricaoMotivoSaida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_valorDeSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, bt_pesquisaMotivo, jLabel2, jLabel3, jLabel4, jLabel5, label_descricaoMotivoSaida, txt_codigoCaixaSaida, txt_codigoMotivoSaida});

        bt_incluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_incluir.setText("Incluir");
        bt_incluir.setEnabled(false);
        bt_incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_incluirActionPerformed(evt);
            }
        });

        bt_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Delete.png"))); // NOI18N
        bt_cancelar.setText("Cancelar");
        bt_cancelar.setEnabled(false);
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        bt_sair1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        bt_sair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair1.setText("Sair");
        bt_sair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sair1ActionPerformed(evt);
            }
        });
        jMenu1.add(bt_sair1);

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_incluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_sair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_cancelar, bt_incluir, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        txt_codigoMotivoSaida.grabFocus();
        ReiniciaCampos();
        HabilitaCampos(true);
        
        bcs.codigoCaixaSaida    = PegProReg.PegaProximoRegistro("tb_caixa_saida", "codigoCaixaSaida", "");
        txt_codigoCaixaSaida.setText(fc.FormataCampo(String.valueOf(bcs.codigoCaixaSaida), 6, 0));
        
        operacao = "I";
        HabilitaBotoes();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void txt_codigoCaixaSaidaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoCaixaSaidaFocusGained
        if(somostra.equalsIgnoreCase("S"))
            return;
        operacao = "";
        ReiniciaCampos();
        HabilitaBotoes();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoCaixaSaidaFocusGained

    private void txt_codigoCaixaSaidaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoCaixaSaidaFocusLost
        if(txt_codigoCaixaSaida.getText().replace(" ", "").equals(""))
            return;
        if(somostra.equalsIgnoreCase("S"))
            return;
        PegaSaidaDeCaixa();
    }//GEN-LAST:event_txt_codigoCaixaSaidaFocusLost

    private void txt_codigoMotivoSaidaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoMotivoSaidaFocusGained
        txt_codigoMotivoSaida.setSelectionStart(0);
        txt_codigoMotivoSaida.setSelectionEnd  (txt_codigoMotivoSaida.getText().length());
        label_descricaoMotivoSaida.setText("");
    }//GEN-LAST:event_txt_codigoMotivoSaidaFocusGained

    private void txt_codigoMotivoSaidaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoMotivoSaidaFocusLost
        if(txt_codigoMotivoSaida.getText().replace(" ", "").equals(""))
            return;
        if(somostra.equalsIgnoreCase("S"))
            return;
        PegaMotivoSaida();
    }//GEN-LAST:event_txt_codigoMotivoSaidaFocusLost

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        sql = "insert into tb_caixa_saida (idEmpresa, codigoGrupo, codigoEmpresa, codigoCaixaSaida, codigoComputador, codigoAbertura, codigoMotivoSaida, codigoUsuario, dataSaidaCaixa, horaSaidaCaixa, valorDeSaida, detalhesMotivoSaida, statusSaida) "
            + "values (" + bcs.idEmpresa + ", " + bcs.codigoGrupo + ", " + bcs.codigoEmpresa + ", " + bcs.codigoCaixaSaida + ", " + bcs.codigoComputador + ", " + bcs.codigoAbertura + ", " + bcs.codigoMotivoSaida + ", " + bcs.codigoUsuario + ", '" + bcs.dataSaidaCaixa + "', '" + bcs.horaSaidaCaixa + "', " + bcs.valorDeSaida + ", '" + bcs.detalhesMotivoSaida + "', " + bcs.statusSaida + ");";
        
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoCaixaSaida.grabFocus();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        if(JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar a Saída de Caixa " + bcs.codigoCaixaSaida + "?") != JOptionPane.YES_OPTION)
            return;
        
        sql = "update tb_caixa_saida set statusSaida = 1 where idCaixaSaida = " + bcs.idCaixaSaida + ";";
        
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        dispose();
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_pesquisaMotivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaMotivoActionPerformed
        if(MotSaiCaiCon != null)if(MotSaiCaiCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuMotivos = 1;
        parametros.clear();
        parametros.add("N");
        MotSaiCaiCon = new MotivosDeSaidaDeCaixaConsulta(parametros);
        MotSaiCaiCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaMotivoActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuMotivos == 0)
            return;
        abriuMotivos = 0;
        retorno = MotSaiCaiCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoMotivoSaida.setText(retorno);
        PegaMotivoSaida();
    }//GEN-LAST:event_formWindowGainedFocus

    private void txt_valorDeSaidaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorDeSaidaFocusLost
        if(txt_valorDeSaida.getText().equals("")){
            return;
        }
        txt_valorDeSaida.setText(TransStrDou.TransformaValorStringeDouble(txt_valorDeSaida.getText(), 0));
        txt_detalhesCaixaSaida.grabFocus();
    }//GEN-LAST:event_txt_valorDeSaidaFocusLost

    private void txt_valorDeSaidaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorDeSaidaFocusGained
        if(txt_valorDeSaida.getText().equals("")){
            return;
        }
        txt_valorDeSaida.setText(TransStrDou.TransformaValorStringeDouble(txt_valorDeSaida.getText(), 1));
    }//GEN-LAST:event_txt_valorDeSaidaFocusGained

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(MotSaiCaiCon != null)MotSaiCaiCon.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        PegaCaixaAberto();
        
        if(somostra.equalsIgnoreCase("S")){
            bt_incluir                          .setVisible(false);
            bt_cancelar                         .setVisible(false);
            txt_codigoCaixaSaida                .setEditable(false);
            bt_novo                             .setEnabled(false);
        }
        if(bcs.codigoCaixaSaida   != 0){
            txt_codigoCaixaSaida.setText(String.valueOf(bcs.codigoCaixaSaida));
            PegaSaidaDeCaixa();
        }
        
        HabilitaCampos(false);
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisaMotivo;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_descricaoMotivoSaida;
    private javax.swing.JFormattedTextField txt_codigoCaixaSaida;
    private javax.swing.JFormattedTextField txt_codigoMotivoSaida;
    private javax.swing.JTextArea txt_detalhesCaixaSaida;
    private javax.swing.JTextField txt_valorDeSaida;
    // End of variables declaration//GEN-END:variables

    private void ReiniciaCampos(){
        txt_codigoCaixaSaida            .setText("");
        txt_codigoMotivoSaida           .setText("");
        label_descricaoMotivoSaida      .setText("");
        txt_valorDeSaida                .setText("");
        txt_detalhesCaixaSaida          .setText("");
    }
    
    private void HabilitaCampos(boolean Habilita){
        txt_codigoMotivoSaida           .setEditable    (Habilita);
        txt_codigoMotivoSaida           .setFocusable   (Habilita);
        bt_pesquisaMotivo               .setEnabled     (Habilita);
        bt_pesquisaMotivo               .setFocusable   (Habilita);
        txt_valorDeSaida                .setEditable    (Habilita);
        txt_valorDeSaida                .setFocusable   (Habilita);
        txt_detalhesCaixaSaida          .setEditable    (Habilita);
        txt_detalhesCaixaSaida          .setFocusable   (Habilita);
    }
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_incluir.setEnabled(true);
            bt_cancelar.setEnabled(false);
            return;
        }
        if(operacao.equals("A")){
            bt_incluir.setEnabled(false);
            bt_cancelar.setEnabled(true);
            return;
        }
        bt_incluir .setEnabled(false);
        bt_cancelar.setEnabled(false);
    }
    
    private void PegaSaidaDeCaixa(){
        txt_codigoCaixaSaida.setText(fc.FormataCampo(txt_codigoCaixaSaida.getText(), 6, 0));
        bcs.codigoCaixaSaida    = Integer.parseInt(txt_codigoCaixaSaida.getText());
        if(bcs.codigoCaixaSaida == 0)
            return;
        sql = "select idCaixaSaida, idEmpresa, codigoGrupo, codigoEmpresa, codigoCaixaSaida, codigoComputador, codigoUsuario, codigoMotivoSaida, valorDeSaida, detalhesMotivoSaida, statusSaida from tb_caixa_saida where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoComputador = " + parametrosNS.bcomp.codigoComputador + " and codigoAbertura = " + bcs.codigoAbertura + " and codigoCaixaSaida = " + bcs.codigoCaixaSaida + ";";
        dadosSaidaCaixa.clear();
        dadosSaidaCaixa = parametrosNS.dao.Consulta(sql);
        if(dadosSaidaCaixa.isEmpty()){
            Mensagem = "Código " + bcs.codigoCaixaSaida + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        HabilitaCampos(true);
        PegaDadosSaidaDeCaixa();
    }
    
    private void PegaDadosSaidaDeCaixa(){
        for(int i = 0; i < dadosSaidaCaixa.size(); i++){
            bcs.idCaixaSaida            = Integer.parseInt(  String.valueOf(dadosSaidaCaixa.get(i).get(0)));
            bcs.idEmpresa               = Integer.parseInt(  String.valueOf(dadosSaidaCaixa.get(i).get(1)));
            bcs.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosSaidaCaixa.get(i).get(2)));
            bcs.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosSaidaCaixa.get(i).get(3)));
            bcs.codigoCaixaSaida        = Integer.parseInt(  String.valueOf(dadosSaidaCaixa.get(i).get(4)));
            bcs.codigoComputador        = Integer.parseInt(  String.valueOf(dadosSaidaCaixa.get(i).get(5)));
            bcs.codigoUsuario           = Integer.parseInt(  String.valueOf(dadosSaidaCaixa.get(i).get(6)));
            bcs.codigoMotivoSaida       = Integer.parseInt(  String.valueOf(dadosSaidaCaixa.get(i).get(7)));
            bcs.valorDeSaida            = Double.parseDouble(String.valueOf(dadosSaidaCaixa.get(i).get(8)));
            bcs.detalhesMotivoSaida     =                    String.valueOf(dadosSaidaCaixa.get(i).get(9));
            bcs.statusSaida             = Integer.parseInt(  String.valueOf(dadosSaidaCaixa.get(i).get(10)));
        }
        if(bcs.statusSaida == 1){
            operacao = "";
            HabilitaBotoes();
            Mensagem = "Saída de Caixa Cancelada!";
            new MostraMensagem(Mensagem);
            return;
        }
        txt_codigoMotivoSaida.setText(fc.FormataCampo(String.valueOf(bcs.codigoMotivoSaida), 3, 0));
        PegaMotivoSaida();
        txt_valorDeSaida.setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(bcs.valorDeSaida), 0));
        txt_detalhesCaixaSaida.setText(bcs.detalhesMotivoSaida);
        bt_cancelar.setEnabled(true);
    }
    
    private void PegaMotivoSaida(){
        txt_codigoMotivoSaida.setText(fc.FormataCampo(txt_codigoMotivoSaida.getText(), 3, 0));
        bcms.codigoMotivoSaida      = Integer.parseInt(txt_codigoMotivoSaida.getText());
        if(bcms.codigoMotivoSaida == 0)
            return;
        sql = "select * from tb_caixa_motivo_saida where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoMotivoSaida = " + bcms.codigoMotivoSaida + ";";
        dadosMotivoSaida.clear();
        dadosMotivoSaida = parametrosNS.dao.Consulta(sql);
        if(dadosMotivoSaida.isEmpty()){
            Mensagem = "Código " + bcms + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosMotivoSaida();
    }
    
    private void PegaDadosMotivoSaida(){
        for(int i = 0; i < dadosMotivoSaida.size(); i++){
            bcms.idMotivoSaida          = Integer.parseInt(  String.valueOf(dadosMotivoSaida.get(i).get(0)));
            bcms.idEmpresa              = Integer.parseInt(  String.valueOf(dadosMotivoSaida.get(i).get(1)));
            bcms.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosMotivoSaida.get(i).get(2)));
            bcms.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosMotivoSaida.get(i).get(3)));
            bcms.codigoMotivoSaida      = Integer.parseInt(  String.valueOf(dadosMotivoSaida.get(i).get(4)));
            bcms.descricaoMotivoSaida   =                    String.valueOf(dadosMotivoSaida.get(i).get(5));
        }
        label_descricaoMotivoSaida.setText(bcms.descricaoMotivoSaida);
    }
    
    private void PegaValores(){
        fatal = "N";
        bcs.idEmpresa               = parametrosNS.be.IdEmpresa;
        bcs.codigoGrupo             = parametrosNS.bge.CodigoGrupo;
        bcs.codigoEmpresa           = parametrosNS.be.CodigoEmpresa;
        bcs.codigoCaixaSaida        = Integer.parseInt(txt_codigoCaixaSaida.getText());
        bcs.codigoComputador        = parametrosNS.bcomp.codigoComputador;
        bcs.codigoAbertura          = bca.codigoAbertura;
        bcs.codigoMotivoSaida       = Integer.parseInt(txt_codigoMotivoSaida.getText());
        if(bcs.codigoMotivoSaida == 0){
            fatal = "S";
            Mensagem = "Motivo de Saída de Caixa inválida!";
            new MostraMensagem(Mensagem);
            return;
        }
        bcs.codigoUsuario           = parametrosNS.bu.codigoUsuario;
        bcs.dataSaidaCaixa          = invdata.inverterData(cdh.CapturarData(), 2);
        bcs.horaSaidaCaixa          = cdh.CapturaHora();
        if(txt_codigoMotivoSaida.getText().replace(" ", "").equals("")){
            fatal = "S";
            Mensagem = "Motivo de Saída de Caixa inválida!";
            new MostraMensagem(Mensagem);
            return;
        }
        if(txt_valorDeSaida.getText().equals("")){
            fatal = "S";
            Mensagem = "Valor de Saída inválido!";
            new MostraMensagem(Mensagem);
            return;
        }
        bcs.valorDeSaida            = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_valorDeSaida.getText(), 1));
        if(bcs.valorDeSaida == 0){
            fatal = "S";
            Mensagem = "Valor de Saída inválido!";
            new MostraMensagem(Mensagem);
            return;
        }
        bcs.detalhesMotivoSaida     = txt_detalhesCaixaSaida.getText();
        if(bcs.detalhesMotivoSaida.equals("")){
            fatal = "S";
            Mensagem = "Detalhes de Saída inválido!";
            new MostraMensagem(Mensagem);
            return;
        }
        bcs.statusSaida             = 0;
    }
    
}
