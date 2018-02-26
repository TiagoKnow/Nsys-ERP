package TelasProducao;

import Beans.BeanCancelamentos;
import Beans.BeanComputadores;
import Beans.BeanOrdemServico;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import Telas.CancelamentosConsulta;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/*
 @author Tiago e Paulo
 */
public class OrdemServicoSemSolucaoCadastro extends javax.swing.JFrame {
    //int's
    int    abriuPesquisaCancelamento    = 0;
    
    //String's
    String sql                          = "";
    String fatal                        = "";
    String sqlstate                     = "";
    String Mensagem                     = "";
    String retorno                      = "";
    
    //Vetores
    ArrayList            parametros                = new ArrayList();
//    ArrayList            dadosPadroes              = new ArrayList();
    ArrayList<ArrayList> dadosOrdemServico         = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosCancelamentos        = new ArrayList<ArrayList>();
    
    //Bean's
    BeanOrdemServico            bos     = new BeanOrdemServico();
    BeanCancelamentos           bcan    = new BeanCancelamentos();
    BeanComputadores            bcomp   = new BeanComputadores();
    
    //Especiais
    FormataCampo                fc      = new FormataCampo();
    InverterData                invdata = new InverterData();
    CapturarDataHora            cdh     = new CapturarDataHora();
    
    //Telas
    CancelamentosConsulta       CanCon;
    
    public OrdemServicoSemSolucaoCadastro(int IdOrdemServico){
        bos.idOrdemServico = IdOrdemServico;
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigoOrdemServico = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_codigoMotivo = new javax.swing.JFormattedTextField();
        bt_pesquisar = new javax.swing.JButton();
        label_descricao = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_detalhes = new javax.swing.JTextArea();
        bt_confirma = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        jLabel1.setText("Ordem de Serviço Sem Solução");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Ordem de Serviço:");

        txt_codigoOrdemServico.setEditable(false);
        try {
            txt_codigoOrdemServico.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoOrdemServico.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Motivo:");

        try {
            txt_codigoMotivo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoMotivo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoMotivoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoMotivoFocusLost(evt);
            }
        });
        txt_codigoMotivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoMotivoKeyPressed(evt);
            }
        });

        bt_pesquisar.setText("...");
        bt_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisarActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Detalhes:");

        txt_detalhes.setColumns(20);
        txt_detalhes.setRows(5);
        jScrollPane1.setViewportView(txt_detalhes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_descricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoOrdemServico, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_codigoOrdemServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_codigoMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 79, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisar, jLabel2, jLabel3, jLabel4, label_descricao, txt_codigoMotivo, txt_codigoOrdemServico});

        bt_confirma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_confirma.setText("Confirma");
        bt_confirma.setEnabled(false);
        bt_confirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmaActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_confirma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_confirma, javax.swing.GroupLayout.PREFERRED_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoMotivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoMotivoKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        txt_detalhes.grabFocus();
    }//GEN-LAST:event_txt_codigoMotivoKeyPressed

    private void txt_codigoMotivoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoMotivoFocusLost
        if(txt_codigoMotivo.getText().replace(" ", "").equals(""))
            return;
        if(txt_codigoMotivo.isEditable() == false)
            return;
        PegaCancelamento();
    }//GEN-LAST:event_txt_codigoMotivoFocusLost

    private void bt_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisarActionPerformed
        if(CanCon != null)if(CanCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuPesquisaCancelamento = 1;
        CanCon = new CancelamentosConsulta("N");
        CanCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisarActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuPesquisaCancelamento == 0)
            return;
        abriuPesquisaCancelamento = 0;
        retorno = CanCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoMotivo.setText(retorno);
        PegaCancelamento();
    }//GEN-LAST:event_formWindowGainedFocus

    private void bt_confirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmaActionPerformed
        PegaValores();
        if(fatal.equals("S"))
            return;
        sql = "update tb_os set statusOs = 3, "
                             + "codigoCancelamentoSemSolucao = "    + bos.codigoCancelamentoSemSolucao   + ", "
                             + "detalhesCancelamentoSemSolucao = '" + bos.detalhesCancelamentoSemSolucao + "', "
                             + "dataSemSolucao = '"                 + bos.dataSemSolucao                 + "', "
                             + "horaSemSolucao = '"                 + bos.horaSemSolucao                 + "', "
                             + "usuarioSemSolucao = "               + bos.usuarioSemSolucao              + ", "
                             + "idEmpresaSemSolucao = "             + bos.idEmpresaSemSolucao            + ", "
                             + "computadorSemSolucao = "            + bos.computadorSemSolucao           + " "
                             + "where idOrdemServico = " + bos.idOrdemServico + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        sqlstate = "ok";
        dispose();
    }//GEN-LAST:event_bt_confirmaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        sqlstate = "";
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_codigoMotivoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoMotivoFocusGained
        if(txt_codigoMotivo.isEditable() == false)
            return;
        bos.codigoCancelamentoSemSolucao = 0;
        txt_codigoMotivo.setText("");
        label_descricao.setText("");
    }//GEN-LAST:event_txt_codigoMotivoFocusGained

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(bos.idOrdemServico != 0)
            PegaOrdemServico();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(CanCon   != null)CanCon.dispose();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_confirma;
    private javax.swing.JButton bt_pesquisar;
    private javax.swing.JMenuItem bt_sair;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_descricao;
    private javax.swing.JFormattedTextField txt_codigoMotivo;
    private javax.swing.JFormattedTextField txt_codigoOrdemServico;
    private javax.swing.JTextArea txt_detalhes;
    // End of variables declaration//GEN-END:variables
    
    public String getRetornoFinalizaOrdemServicoSemSolucao(){
        return sqlstate;
    }
    
    private void PegaOrdemServico(){
        sql = "select \n"
            + "   idOrdemServico, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoOrdemServico, \n"
            + "   codigoCliente, \n"
            + "   codigoUsuario, \n"
            + "   statusOs \n"
            + "from \n"
            + "   tb_os where idOrdemServico = " + bos.idOrdemServico + ";";
        dadosOrdemServico.clear();
        dadosOrdemServico = parametrosNS.dao.Consulta(sql);
        if(dadosOrdemServico.isEmpty()){
            Mensagem = "Ordem Serviço n°" + bos.codigoOrdemServico + " não encontrada!";
            new MostraMensagem(Mensagem);
            bt_confirma.setEnabled(false);
            return;
        }
        PegaDadosOrdemServico();
    }
    
    private void PegaDadosOrdemServico(){
        for(int i = 0; i < dadosOrdemServico.size(); i++){
            bos     = new BeanOrdemServico();
            if(dadosOrdemServico.get(i).get(0) != null)
                bos.idOrdemServico          = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(0)));
            if(dadosOrdemServico.get(i).get(1) != null)
                bos.idEmpresa               = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(1)));
            if(dadosOrdemServico.get(i).get(2) != null)
                bos.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(2)));
            if(dadosOrdemServico.get(i).get(3) != null)
                bos.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(3)));
            if(dadosOrdemServico.get(i).get(4) != null)
                bos.codigoOrdemServico      = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(4)));
            if(dadosOrdemServico.get(i).get(5) != null)
                bos.codigoCliente           = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(5)));
            if(dadosOrdemServico.get(i).get(6) != null)
                bos.codigoUsuario           = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(6)));
            if(dadosOrdemServico.get(i).get(7) != null)
                bos.statusOs                = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(7)));
        }
        if(bos.statusOs == 3){
            Mensagem = "Ordem de Serviço n°" + bos.codigoOrdemServico + " já foi Finalizada como Sem Solução!";
            new MostraMensagem(Mensagem);
            return;
        }
        txt_codigoOrdemServico.setText(fc.FormataCampo(String.valueOf(bos.codigoOrdemServico), 9, 0));
        bt_confirma.setEnabled(true);
    }
    
    private void PegaCancelamento(){
        txt_codigoMotivo.setText(fc.FormataCampo(txt_codigoMotivo.getText(), 2, 0));
        bcan.codigoCancelamento = Integer.parseInt(txt_codigoMotivo.getText());
        if(bcan.codigoCancelamento == 0){
            bt_confirma.setEnabled(false);
            return;
        }
        sql = "select \n"
            + "   idCancelamento, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoCancelamento, \n"
            + "   descricaoCancelamento \n"
            + "from \n"
            + "   tb_cancelamento where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCancelamento = " + bcan.codigoCancelamento + ";";
        dadosCancelamentos.clear();
        dadosCancelamentos = parametrosNS.dao.Consulta(sql);
        if(dadosCancelamentos.isEmpty()){
            bt_confirma.setEnabled(false);
            Mensagem = "Motivo " + bcan.codigoCancelamento + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        bt_confirma.setEnabled(true);
        PegaDadosCancelamento();
    }
    
    private void PegaDadosCancelamento(){
        for(int i = 0; i < dadosCancelamentos.size(); i++){
            bcan.idCancelamento         = Integer.parseInt(  String.valueOf(dadosCancelamentos.get(i).get(0)));
            bcan.idEmpresa              = Integer.parseInt(  String.valueOf(dadosCancelamentos.get(i).get(1)));
            bcan.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosCancelamentos.get(i).get(2)));
            bcan.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosCancelamentos.get(i).get(3)));
            bcan.codigoCancelamento     = Integer.parseInt(  String.valueOf(dadosCancelamentos.get(i).get(4)));
            bcan.descricaoCancelamento  =                    String.valueOf(dadosCancelamentos.get(i).get(5));
        }
        label_descricao.setText(bcan.descricaoCancelamento);
        txt_detalhes.grabFocus();
    }
    
    private void PegaValores(){
        if(txt_codigoMotivo.getText().replace(" ", "").equals("")){
            fatal = "S";
            Mensagem = "Código do Motivo Inválido!";
            new MostraMensagem(Mensagem);
            return;
        }
        bos.codigoCancelamentoSemSolucao    = Integer.parseInt(txt_codigoMotivo.getText());
        bos.detalhesCancelamentoSemSolucao  = txt_detalhes.getText();
        if(bos.detalhesCancelamentoSemSolucao.equals("")){
            fatal = "S";
            Mensagem = "Motivo Inválido!";
            new MostraMensagem(Mensagem);
            return;
        }
        bos.dataSemSolucao            = invdata.inverterData(cdh.CapturarData(), 2);
        bos.horaSemSolucao            = cdh.CapturaHora();
        bos.usuarioSemSolucao         = parametrosNS.bu.codigoUsuario;
        bos.idEmpresaSemSolucao       = parametrosNS.be.idEmpresa;
        bos.computadorSemSolucao      = parametrosNS.bcomp.codigoComputador;
    }
    
}
