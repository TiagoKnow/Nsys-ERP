package TelasVendas;

import Telas.CancelamentosConsulta;
import Beans.BeanCancelamentos;
import Beans.BeanVendas;
import Beans.BeanVendasCanceladas;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import com.sun.glass.events.KeyEvent;
import Parametros.parametrosNS;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/*
 @author Tiago e Paulo
 */
public class CancelarVenda extends javax.swing.JFrame {
    //String's
    String sql                          = "";
    String fatal                        = "";
    String sqlstate                     = "";
    String Mensagem                     = "";
    String retorno                      = "";
    
    //int's
    int    abriuPesquisaCancelamento    = 0;
    
    //Vetores
    ArrayList            parametros                = new ArrayList();
//    ArrayList            dadosPadroes              = new ArrayList();
    ArrayList<ArrayList> dadosVendas               = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosCancelamentos        = new ArrayList<ArrayList>();
    
    //Bean's
    BeanVendas                  bv      = new BeanVendas();
    BeanCancelamentos           bcan    = new BeanCancelamentos();
    BeanVendasCanceladas        bvc     = new BeanVendasCanceladas();
    
    //Especiais
    FormataCampo                fc      = new FormataCampo();
    
    //Telas
    CancelamentosConsulta       CanCon;
    
    public CancelarVenda(int idVenda){
        bv.idVenda  = idVenda;
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigoVenda = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_codigoCancelamento = new javax.swing.JFormattedTextField();
        bt_pesquisarCancelamento = new javax.swing.JButton();
        label_descricaoCancelamento = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_detalhesCancelamento = new javax.swing.JTextArea();
        bt_confirma = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
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
        jLabel1.setText("Cancelar Venda");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Venda:");

        txt_codigoVenda.setEditable(false);
        try {
            txt_codigoVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoVenda.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Motivo:");

        try {
            txt_codigoCancelamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoCancelamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoCancelamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoCancelamentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoCancelamentoFocusLost(evt);
            }
        });
        txt_codigoCancelamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoCancelamentoKeyPressed(evt);
            }
        });

        bt_pesquisarCancelamento.setText("...");
        bt_pesquisarCancelamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisarCancelamentoActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Detalhes do Cancelamento:");

        txt_detalhesCancelamento.setColumns(20);
        txt_detalhesCancelamento.setRows(5);
        jScrollPane1.setViewportView(txt_detalhesCancelamento);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoCancelamento, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisarCancelamento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_descricaoCancelamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel4});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_codigoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_codigoCancelamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisarCancelamento, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_descricaoCancelamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisarCancelamento, jLabel2, jLabel3, jLabel4, label_descricaoCancelamento, txt_codigoCancelamento, txt_codigoVenda});

        bt_confirma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_confirma.setText("Confirma");
        bt_confirma.setEnabled(false);
        bt_confirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmaActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 420, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(bt_confirma, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoCancelamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoCancelamentoKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        txt_detalhesCancelamento.grabFocus();
    }//GEN-LAST:event_txt_codigoCancelamentoKeyPressed

    private void txt_codigoCancelamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoCancelamentoFocusLost
        if(txt_codigoCancelamento.getText().replace(" ", "").equals(""))
            return;
        if(txt_codigoCancelamento.isEditable() == false)
            return;
        PegaCancelamento();
    }//GEN-LAST:event_txt_codigoCancelamentoFocusLost

    private void bt_pesquisarCancelamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisarCancelamentoActionPerformed
        if(CanCon != null)if(CanCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuPesquisaCancelamento = 1;
        CanCon = new CancelamentosConsulta("N");
        CanCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisarCancelamentoActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuPesquisaCancelamento == 0)
            return;
        abriuPesquisaCancelamento = 0;
        retorno = CanCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoCancelamento.setText(retorno);
        PegaCancelamento();
    }//GEN-LAST:event_formWindowGainedFocus

    private void bt_confirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmaActionPerformed
        PegaValores();
        if(fatal.equals("S")){
            return;
        }
        if(JOptionPane.showConfirmDialog(null, "Confirma Cancelamento da Venda n°" + bv.codigoVenda + "?", "", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION){
            return;
        }
        sql = "update tb_vendas set status = 1 where idVenda = " + bv.idVenda + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000")){
            return;
        }
        sql = "insert into tb_vendas_canceladas (idEmpresa, codigoGrupo, codigoEmpresa, codigoVenda, codigoCancelamento, detalhesCancelamento) "
            + "values (" + bvc.idEmpresa + ", " + bvc.codigoGrupo + ", " + bvc.codigoEmpresa + ", " + bvc.codigoVenda + ", " + bvc.codigoCancelamento + ", '" + bvc.detalhesCancelamento + "');";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            return;
        }
        dispose();
    }//GEN-LAST:event_bt_confirmaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        sqlstate = "";
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_codigoCancelamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoCancelamentoFocusGained
        if(txt_codigoCancelamento.isEditable() == false){
            return;
        }
        bvc = new BeanVendasCanceladas();
        txt_codigoCancelamento.setText("");
        label_descricaoCancelamento.setText("");
    }//GEN-LAST:event_txt_codigoCancelamentoFocusGained

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(bv.idVenda != 0)
            PegaVenda();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(CanCon   != null)CanCon.dispose();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_confirma;
    private javax.swing.JButton bt_pesquisarCancelamento;
    private javax.swing.JMenuItem bt_sair;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_descricaoCancelamento;
    private javax.swing.JFormattedTextField txt_codigoCancelamento;
    private javax.swing.JFormattedTextField txt_codigoVenda;
    private javax.swing.JTextArea txt_detalhesCancelamento;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return sqlstate;
    }
    
    private void PegaVenda(){
        sql = "select \n"
            + "   idVenda, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoVenda, \n"
            + "   codigoUsuario, \n"
            + "   codigoCliente, \n"
            + "   codigoComputador, \n"
            + "   status \n"
            + "from \n"
            + "   tb_vendas where idVenda = " + bv.idVenda + ";";
        dadosVendas.clear();
        dadosVendas = parametrosNS.dao.Consulta(sql);
        if(dadosVendas.isEmpty()){
            Mensagem = "Venda não encontrada!";
            new MostraMensagem(Mensagem);
            bt_confirma.setEnabled(false);
            return;
        }
        PegaDadosVenda();
    }
    
    private void PegaDadosVenda(){
        for(int i = 0; i < dadosVendas.size(); i++){
            bv = new BeanVendas();
            if(dadosVendas.get(i).get(0) != null){bv.idVenda          = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(0)));}
            if(dadosVendas.get(i).get(1) != null){bv.idEmpresa        = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(1)));}
            if(dadosVendas.get(i).get(2) != null){bv.codigoGrupo      = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(2)));}
            if(dadosVendas.get(i).get(3) != null){bv.codigoEmpresa    = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(3)));}
            if(dadosVendas.get(i).get(4) != null){bv.codigoVenda      = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(4)));}
            if(dadosVendas.get(i).get(5) != null){bv.codigoUsuario    = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(5)));}
            if(dadosVendas.get(i).get(6) != null){bv.codigoCliente    = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(6)));}
            if(dadosVendas.get(i).get(7) != null){bv.codigoComputador = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(7)));}
            if(dadosVendas.get(i).get(8) != null){bv.status           = Integer.parseInt(  String.valueOf(dadosVendas.get(i).get(8)));}
        }
        if(bv.status == 1){
            Mensagem = "Venda n°" + bv.codigoVenda + " já foi Cancelada!";
            new MostraMensagem(Mensagem);
            return;
        }
        txt_codigoVenda.setText(fc.FormataCampo(String.valueOf(bv.codigoVenda), 9, 0));
        bt_confirma.setEnabled(true);
    }
    
    private void PegaCancelamento(){
        txt_codigoCancelamento.setText(fc.FormataCampo(txt_codigoCancelamento.getText(), 2, 0));
        bcan.codigoCancelamento = Integer.parseInt(txt_codigoCancelamento.getText());
        if(bcan.codigoCancelamento == 0){
            bt_confirma.setEnabled(false);
            return;
        }
        sql = "select * from tb_cancelamento where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCancelamento = '" + bcan.codigoCancelamento + "';";
        dadosCancelamentos.clear();
        dadosCancelamentos = parametrosNS.dao.Consulta(sql);
        if(dadosCancelamentos.isEmpty()){
            bt_confirma.setEnabled(false);
            Mensagem = "Cancelamento " + bcan.codigoCancelamento + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        bt_confirma.setEnabled(true);
        PegaDadosCancelamento();
        txt_detalhesCancelamento.grabFocus();
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
        label_descricaoCancelamento.setText(bcan.descricaoCancelamento);
    }
    
    private void PegaValores(){
        bvc.idEmpresa       = bv.idEmpresa;
        bvc.codigoGrupo     = bv.codigoGrupo;
        bvc.codigoEmpresa   = bv.codigoEmpresa;
        bvc.codigoVenda     = bv.codigoVenda;
        if(txt_codigoCancelamento.getText().replace(" ", "").equals("")){
            fatal = "S";
            Mensagem = "Código de Cancelamento inválido!";
            new MostraMensagem(Mensagem);
            return;
        }
        bvc.idEmpresa            = parametrosNS.be.IdEmpresa;
        bvc.codigoCancelamento   = Integer.parseInt(txt_codigoCancelamento.getText());
        bvc.detalhesCancelamento = txt_detalhesCancelamento.getText();
        if(bvc.detalhesCancelamento.equals("")){
            fatal = "S";
            Mensagem = "Motivo do Cancelamento inválido!";
            new MostraMensagem(Mensagem);
            return;
        }
    }
    
}
