package TelasVendas;

import Beans.BeanCaixaAbertura;
import Beans.BeanUsuarios;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.ConverteValorDigitadoEmDouble;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.ImprimeAberturaCaixa;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.PegaProximoRegistro;
import FuncoesInternas.TransformaValorStringeDouble;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
/*
 @author Tiago e Paulo
 */
public class AberturaDeCaixa extends javax.swing.JFrame {
    //String's
    String sql                                  = "";
    String sqlstate                             = "";
    String Mensagem                             = "";
    
    public String Modo  = "";
    
    //Vetores
    ArrayList<ArrayList> dadosAberturaCaixa                = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosUsuario                      = new ArrayList<ArrayList>();
    
    //Beans
    BeanCaixaAbertura               bca         = new BeanCaixaAbertura();
    BeanUsuarios                    bu          = new BeanUsuarios();
    
    //Especiais
    CapturarDataHora                cdh         = new CapturarDataHora();
    InverterData                    invdata     = new InverterData();
    FormataCampo                    fc          = new FormataCampo();
    PegaProximoRegistro             PegProReg   = new PegaProximoRegistro();
    TransformaValorStringeDouble    TransStrDou = new TransformaValorStringeDouble();
    
    //Telas
    InformarCPFouCNPJ       InfCPFouCNPJ;
    ImprimeAberturaCaixa    ImpAbeCai   = new ImprimeAberturaCaixa();
    
    public AberturaDeCaixa(){
        initComponents();
    }
    
    private void PegaUsuario(){
        txt_codigoUsuario.setText(fc.FormataCampo(String.valueOf(bu.codigoUsuario), 3, 0));
        sql = "select idUsuario, idEmpresa, codigoGrupo, codigoEmpresa, codigoUsuario, usuario from tb_usuarios where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
        dadosUsuario.clear();
        dadosUsuario = parametrosNS.dao.Consulta(sql);
        if(dadosUsuario.isEmpty()){
            Mensagem = "Usuário " + bu.codigoUsuario + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosUsuario();
    }
    
    private void PegaDadosUsuario(){
        for(int i = 0; i < dadosUsuario.size(); i++){
            bu.idUsuario            = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(0)));
            bu.idEmpresa            = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(1)));
            bu.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(2)));
            bu.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(3)));
            bu.codigoUsuario        = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(4)));
            bu.usuario              =                    String.valueOf(dadosUsuario.get(i).get(5));
        }
    }
    
    private void VerificaCaixaAberto(){
        bca.codigoComputador        = parametrosNS.bcomp.codigoComputador;
        bca.dataAbertura            = invdata.inverterData(cdh.CapturarData(), 2);
        sql = "select * from tb_caixa_abertura where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoComputador = " + bca.codigoComputador + " and status = 'A';";
        dadosAberturaCaixa.clear();
        dadosAberturaCaixa = parametrosNS.dao.Consulta(sql);
        if(dadosAberturaCaixa.isEmpty()){
            sql = "select * from tb_caixa_abertura where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoComputador = " + bca.codigoComputador + " and dataAbertura = '" + bca.dataAbertura + "' and status = 'Z';";
            dadosAberturaCaixa.clear();
            dadosAberturaCaixa = parametrosNS.dao.Consulta(sql);
            if(dadosAberturaCaixa.isEmpty()){
                return;
            }
            Mensagem = "Caixa já fechado com Redução Z!";
            new MostraMensagem(Mensagem);
            return;
        }
        Mensagem = "Caixa já Aberto para esse Terminal!";
        new MostraMensagem(Mensagem);
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
        bu.codigoUsuario    = bca.codigoUsuario;
        PegaUsuario();
        label_nomeUsuario.setText(bu.usuario);
        
        txt_dataAtual.setText(invdata.inverterData(bca.dataAbertura, 1));
        txt_horaAtual.setText(bca.horaAbertura);
        //txt_valorFundoCaixa.setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(bca.valorDoCaixa), 0));
        bt_abrirFecharCaixa.setEnabled(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_cancelar = new javax.swing.JButton();
        bt_abrirFecharCaixa = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        label_titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_valorFundoCaixa = new javax.swing.JTextField();
        txt_dataAtual = new javax.swing.JFormattedTextField();
        txt_horaAtual = new javax.swing.JFormattedTextField();
        txt_codigoComputador = new javax.swing.JFormattedTextField();
        label_nomeComputador = new javax.swing.JLabel();
        txt_codigoUsuario = new javax.swing.JFormattedTextField();
        label_nomeUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        bt_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/24x24/Exit.png"))); // NOI18N
        bt_cancelar.setText("Sair");
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        bt_abrirFecharCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/24x24/Apply.png"))); // NOI18N
        bt_abrirFecharCaixa.setText("Abrir Caixa");
        bt_abrirFecharCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_abrirFecharCaixaActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        label_titulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titulo.setText("Abertura de Caixa");
        label_titulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Computador:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Usuário: ");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Data: ");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Hora: ");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Fundo de Caixa: ");

        txt_valorFundoCaixa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_valorFundoCaixaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorFundoCaixaFocusLost(evt);
            }
        });
        txt_valorFundoCaixa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_valorFundoCaixaKeyPressed(evt);
            }
        });

        txt_dataAtual.setEditable(false);
        try {
            txt_dataAtual.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txt_horaAtual.setEditable(false);
        try {
            txt_horaAtual.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_horaAtual.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_codigoComputador.setEditable(false);
        try {
            txt_codigoComputador.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoComputador.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_codigoUsuario.setEditable(false);
        try {
            txt_codigoUsuario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_valorFundoCaixa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(txt_dataAtual, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_horaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_codigoComputador)
                            .addComponent(txt_codigoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_nomeComputador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label_nomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel3, jLabel4, jLabel6});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(label_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_codigoComputador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nomeComputador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_codigoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nomeUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txt_dataAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_horaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_valorFundoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel3, jLabel4, jLabel5, jLabel6, label_nomeComputador, label_nomeUsuario, txt_codigoComputador, txt_codigoUsuario, txt_dataAtual, txt_horaAtual, txt_valorFundoCaixa});

        jMenu1.setText("Arquivo");

        bt_sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });
        jMenu1.add(bt_sair);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_abrirFecharCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_abrirFecharCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void txt_valorFundoCaixaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorFundoCaixaFocusLost
        if(txt_valorFundoCaixa.getText().equals("")){
            return;
        }
        txt_valorFundoCaixa.setText(TransStrDou.TransformaValorStringeDouble(txt_valorFundoCaixa.getText(), 0));
        bt_abrirFecharCaixa.grabFocus();
    }//GEN-LAST:event_txt_valorFundoCaixaFocusLost

    private void txt_valorFundoCaixaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorFundoCaixaFocusGained
        if(txt_valorFundoCaixa.getText().equals("")){
            return;
        }
        txt_valorFundoCaixa.setText(TransStrDou.TransformaValorStringeDouble(txt_valorFundoCaixa.getText(), 1));
    }//GEN-LAST:event_txt_valorFundoCaixaFocusGained

    private void bt_abrirFecharCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_abrirFecharCaixaActionPerformed
        PegaValoresCaixa();
    }//GEN-LAST:event_bt_abrirFecharCaixaActionPerformed

    private void txt_valorFundoCaixaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valorFundoCaixaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            bt_abrirFecharCaixa.grabFocus();
//            return;
        }
    }//GEN-LAST:event_txt_valorFundoCaixaKeyPressed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(parametrosNS.bu.codigoUsuario != 999)
            if(parametrosNS.be.idEmpresa != parametrosNS.be.IdEmpresa){
                dispose();
                return;
            }
        
        txt_codigoComputador.setText(fc.FormataCampo(String.valueOf(parametrosNS.bcomp.codigoComputador), 2, 0));
        label_nomeComputador.setText(parametrosNS.bcomp.nomeComputador);
        
        txt_dataAtual       .setText(cdh.CapturarData());
        txt_horaAtual       .setText(cdh.CapturaHora());
        
        txt_codigoUsuario   .setText(fc.FormataCampo(String.valueOf(parametrosNS.bu.codigoUsuario), 3, 0));
        label_nomeUsuario   .setText(parametrosNS.bu.usuario);
        txt_valorFundoCaixa .setText(TransStrDou.TransformaValorStringeDouble("0", 0));
        
        VerificaCaixaAberto();
    }//GEN-LAST:event_formWindowOpened
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_abrirFecharCaixa;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JMenuItem bt_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_nomeComputador;
    private javax.swing.JLabel label_nomeUsuario;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JFormattedTextField txt_codigoComputador;
    private javax.swing.JFormattedTextField txt_codigoUsuario;
    private javax.swing.JFormattedTextField txt_dataAtual;
    private javax.swing.JFormattedTextField txt_horaAtual;
    private javax.swing.JTextField txt_valorFundoCaixa;
    // End of variables declaration//GEN-END:variables

    private void PegaValoresCaixa(){
        bca.idEmpresa               = parametrosNS.be.IdEmpresa;
        bca.codigoGrupo             = parametrosNS.bge.CodigoGrupo;
        bca.codigoEmpresa           = parametrosNS.be.CodigoEmpresa;
        bca.codigoAbertura          = PegProReg.PegaProximoRegistro("tb_caixa_abertura", "codigoAbertura", "");
        bca.codigoComputador        = parametrosNS.bcomp.codigoComputador;
        bca.codigoUsuario           = parametrosNS.bu.codigoUsuario;
        bca.dataAbertura            = invdata.inverterData(txt_dataAtual.getText(), 2);
        bca.horaAbertura            = txt_horaAtual.getText();
        bca.valorDoCaixa            = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_valorFundoCaixa.getText(), 1));
        bca.status                  = "A";
        AbrirCaixa();
    }
    
    private void AbrirCaixa(){
        sql = "insert into tb_caixa_abertura (idEmpresa, codigoGrupo, codigoEmpresa, codigoAbertura, codigoComputador, codigoUsuario, dataAbertura, horaAbertura, valorDoCaixa, status) "
            + "values (" + bca.idEmpresa + ", " + bca.codigoGrupo + ", " + bca.codigoEmpresa + ", " + bca.codigoAbertura + ", " + bca.codigoComputador + ", " + bca.codigoUsuario + ", '" + bca.dataAbertura + "', '" + bca.horaAbertura + "', '" + bca.valorDoCaixa + "', '" + bca.status + "');";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            return;
        }
        Mensagem = "Caixa Aberto!";
        new MostraMensagem(Mensagem);
        ImpAbeCai.gerarImpressaoAberturaCaixa(bca);
        dispose();
        if(!Modo.equals("Venda")){
            return;
        }
        InfCPFouCNPJ = new InformarCPFouCNPJ();
        InfCPFouCNPJ.setVisible(true);
    }
    
}
