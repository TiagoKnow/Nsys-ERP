package TelasContabil;

import Beans.BeanPlanoDeContas;
import Beans.BeanPlanoDeContasRelacionamento;
import FuncoesInternas.MostraMensagem;
import Parametros.parametrosNS;
import java.util.ArrayList;

/*
 @author Tiago e Paulo
 */
public class RelacionamentoContabil extends javax.swing.JFrame {
    //String's
    String sql                                  = "";
    String sqlstate                             = "";
    String fatal                                = "";
    String Mensagem                             = "";
    String operacao                             = "";
    String retorno                              = "";
    
    //int's
    int    abriuPesquisaPlanoDeContasVendas     = 0;
    int    abriuPesquisaPlanoDeContasOS         = 0;
    int    abriuPesquisaPlanoDeContasBoletos    = 0;
    int    abriuPesquisaPlanoDeContasRecibos    = 0;
    
    //Vetores
    ArrayList            parametros                        = new ArrayList();
    ArrayList<ArrayList> dadosRelacionamento               = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosPlanoDeContas                = new ArrayList<ArrayList>();
    
    //Bean's
    BeanPlanoDeContas                   bpla    = new BeanPlanoDeContas();
    BeanPlanoDeContasRelacionamento     bplarel = new BeanPlanoDeContasRelacionamento();
    
    //Telas
    PlanoDeContasConsulta       PlaDeConCon;
    
    public RelacionamentoContabil(){
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigoPlanoDeContasVendas = new javax.swing.JTextField();
        bt_pesquisarPlanoDeContasVendas = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_codigoPlanoDeContasOS = new javax.swing.JTextField();
        txt_codigoPlanoDeContasBoletos = new javax.swing.JTextField();
        bt_pesquisarPlanoDeContasOS = new javax.swing.JButton();
        bt_pesquisarPlanoDeContaBoletos = new javax.swing.JButton();
        label_planoDeContasVendas = new javax.swing.JLabel();
        label_planoDeContasOS = new javax.swing.JLabel();
        label_planoDeContasBoletos = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_codigoPlanoDeContasRecibos = new javax.swing.JTextField();
        bt_pesquisarPlanoDeContaRecibos = new javax.swing.JButton();
        label_planoDeContasRecibos = new javax.swing.JLabel();
        bt_confirma = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relacionamento Contábil");
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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Relacionamento Contábil");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Plano De Contas(Vendas):");

        txt_codigoPlanoDeContasVendas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoDeContasVendasFocusLost(evt);
            }
        });

        bt_pesquisarPlanoDeContasVendas.setText("...");
        bt_pesquisarPlanoDeContasVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisarPlanoDeContasVendasActionPerformed(evt);
            }
        });

        jLabel3.setText("Plano De Contas(Ordem de Serviço):");

        jLabel4.setText("Plano De Contas(Boletos):");

        txt_codigoPlanoDeContasOS.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoDeContasOSFocusLost(evt);
            }
        });

        txt_codigoPlanoDeContasBoletos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoDeContasBoletosFocusLost(evt);
            }
        });

        bt_pesquisarPlanoDeContasOS.setText("...");
        bt_pesquisarPlanoDeContasOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisarPlanoDeContasOSActionPerformed(evt);
            }
        });

        bt_pesquisarPlanoDeContaBoletos.setText("...");
        bt_pesquisarPlanoDeContaBoletos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisarPlanoDeContaBoletosActionPerformed(evt);
            }
        });

        jLabel5.setText("Plano De Contas(Recibos):");

        txt_codigoPlanoDeContasRecibos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoPlanoDeContasRecibosFocusLost(evt);
            }
        });

        bt_pesquisarPlanoDeContaRecibos.setText("...");
        bt_pesquisarPlanoDeContaRecibos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisarPlanoDeContaRecibosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_codigoPlanoDeContasVendas)
                    .addComponent(txt_codigoPlanoDeContasOS)
                    .addComponent(txt_codigoPlanoDeContasBoletos, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(txt_codigoPlanoDeContasRecibos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bt_pesquisarPlanoDeContasOS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(bt_pesquisarPlanoDeContasVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisarPlanoDeContaBoletos, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(bt_pesquisarPlanoDeContaRecibos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_planoDeContasOS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_planoDeContasBoletos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_planoDeContasVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_planoDeContasRecibos))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_pesquisarPlanoDeContaBoletos, bt_pesquisarPlanoDeContaRecibos, bt_pesquisarPlanoDeContasOS, bt_pesquisarPlanoDeContasVendas});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {label_planoDeContasBoletos, label_planoDeContasOS, label_planoDeContasRecibos, label_planoDeContasVendas});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_codigoPlanoDeContasVendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisarPlanoDeContasVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_planoDeContasVendas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_codigoPlanoDeContasOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisarPlanoDeContasOS, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_planoDeContasOS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_codigoPlanoDeContasBoletos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisarPlanoDeContaBoletos, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_planoDeContasBoletos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_pesquisarPlanoDeContaRecibos, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txt_codigoPlanoDeContasRecibos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_planoDeContasRecibos)))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisarPlanoDeContaBoletos, bt_pesquisarPlanoDeContaRecibos, bt_pesquisarPlanoDeContasOS, bt_pesquisarPlanoDeContasVendas, jLabel2, jLabel3, jLabel4, jLabel5, label_planoDeContasBoletos, label_planoDeContasOS, label_planoDeContasRecibos, label_planoDeContasVendas, txt_codigoPlanoDeContasBoletos, txt_codigoPlanoDeContasOS, txt_codigoPlanoDeContasRecibos, txt_codigoPlanoDeContasVendas});

        bt_confirma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_confirma.setText("Confirma");
        bt_confirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmaActionPerformed(evt);
            }
        });

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
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
                        .addComponent(bt_confirma)
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
                    .addComponent(bt_confirma, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoPlanoDeContasVendasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContasVendasFocusLost
        bpla.codigoPlanoDeContas    = txt_codigoPlanoDeContasVendas.getText().replace(".", "");
        if(bpla.codigoPlanoDeContas.equals("")){
            return;
        }
        sql = "select idPlanoDeContas, idEmpresa, codigoGrupo, codigoEmpresa, codigoPlanoDeContas, descricaoPlanoDeContas, tipoPlanoDeContas, nivelPlanoDeContas from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and replace(codigoPlanoDeContas, '.', '') = '" + bpla.codigoPlanoDeContas + "';";
        PegaPlanoDeContas();
        if(dadosPlanoDeContas.isEmpty()){
            return;
        }
        bplarel.codigoPlanoDeContasVendas  = bpla.codigoPlanoDeContas;
        label_planoDeContasVendas   .setText(bpla.descricaoPlanoDeContas);
    }//GEN-LAST:event_txt_codigoPlanoDeContasVendasFocusLost

    private void txt_codigoPlanoDeContasOSFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContasOSFocusLost
        bpla.codigoPlanoDeContas    = txt_codigoPlanoDeContasOS.getText().replace(".", "");
        if(bpla.codigoPlanoDeContas.equals(""))
            return;
        sql = "select idPlanoDeContas, idEmpresa, codigoGrupo, codigoEmpresa, codigoPlanoDeContas, descricaoPlanoDeContas, tipoPlanoDeContas, nivelPlanoDeContas from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and replace(codigoPlanoDeContas, '.', '') = '" + bpla.codigoPlanoDeContas + "';";
        PegaPlanoDeContas();
        if(dadosPlanoDeContas.isEmpty())return;
        bplarel.codigoPlanoDeContasOS      = bpla.codigoPlanoDeContas;
        label_planoDeContasOS       .setText(bpla.descricaoPlanoDeContas);
    }//GEN-LAST:event_txt_codigoPlanoDeContasOSFocusLost

    private void txt_codigoPlanoDeContasBoletosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContasBoletosFocusLost
        bpla.codigoPlanoDeContas    = txt_codigoPlanoDeContasBoletos.getText().replace(".", "");
        if(bpla.codigoPlanoDeContas.equals(""))
            return;
        sql = "select idPlanoDeContas, idEmpresa, codigoGrupo, codigoEmpresa, codigoPlanoDeContas, descricaoPlanoDeContas, tipoPlanoDeContas, nivelPlanoDeContas from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and replace(codigoPlanoDeContas, '.', '') = '" + bpla.codigoPlanoDeContas + "';";
        PegaPlanoDeContas();
        if(dadosPlanoDeContas.isEmpty())return;
        bplarel.codigoPlanoDeContasBoletos = bpla.codigoPlanoDeContas;
        label_planoDeContasBoletos  .setText(bpla.descricaoPlanoDeContas);
    }//GEN-LAST:event_txt_codigoPlanoDeContasBoletosFocusLost

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_pesquisarPlanoDeContasVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisarPlanoDeContasVendasActionPerformed
        if(PlaDeConCon != null)if(PlaDeConCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuPesquisaPlanoDeContasVendas = 1;
        parametros.clear();
        parametros.add("N");
        PlaDeConCon = new PlanoDeContasConsulta(parametros);
        PlaDeConCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisarPlanoDeContasVendasActionPerformed

    private void bt_pesquisarPlanoDeContasOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisarPlanoDeContasOSActionPerformed
        if(PlaDeConCon != null)if(PlaDeConCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuPesquisaPlanoDeContasOS = 1;
        parametros.clear();
        parametros.add("N");
        PlaDeConCon = new PlanoDeContasConsulta(parametros);
        PlaDeConCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisarPlanoDeContasOSActionPerformed

    private void bt_pesquisarPlanoDeContaBoletosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisarPlanoDeContaBoletosActionPerformed
        if(PlaDeConCon != null)if(PlaDeConCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuPesquisaPlanoDeContasBoletos = 1;
        parametros.clear();
        parametros.add("N");
        PlaDeConCon = new PlanoDeContasConsulta(parametros);
        PlaDeConCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisarPlanoDeContaBoletosActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        PegaRelacionamento();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
        if(abriuPesquisaPlanoDeContasVendas == 0){
            AbriuPlanoDeContasOS();
            return;
        }
        abriuPesquisaPlanoDeContasVendas = 0;
        retorno = PlaDeConCon.getRetorno();
        if(retorno.equals(""))
            return;
        bpla.codigoPlanoDeContas = retorno;
        sql = "select idPlanoDeContas, idEmpresa, codigoGrupo, codigoEmpresa, codigoPlanoDeContas, descricaoPlanoDeContas, tipoPlanoDeContas, nivelPlanoDeContas from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and replace(codigoPlanoDeContas, '.', '') = '" + bpla.codigoPlanoDeContas + "';";
        PegaPlanoDeContas();
        bplarel.codigoPlanoDeContasVendas = bpla.codigoPlanoDeContas;
        txt_codigoPlanoDeContasVendas   .setText(bpla.codigoPlanoDeContas);
        label_planoDeContasVendas       .setText(bpla.descricaoPlanoDeContas);
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbriuPlanoDeContasOS(){
        if(abriuPesquisaPlanoDeContasOS == 0){
            AbriuPlanoDeContasBoletos();
            return;
        }
        abriuPesquisaPlanoDeContasOS = 0;
        retorno = PlaDeConCon.getRetorno();
        if(retorno.equals(""))
            return;
        bpla.codigoPlanoDeContas = retorno;
        sql = "select idPlanoDeContas, idEmpresa, codigoGrupo, codigoEmpresa, codigoPlanoDeContas, descricaoPlanoDeContas, tipoPlanoDeContas, nivelPlanoDeContas from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and replace(codigoPlanoDeContas, '.', '') = '" + bpla.codigoPlanoDeContas + "';";
        PegaPlanoDeContas();
        bplarel.codigoPlanoDeContasOS = bpla.codigoPlanoDeContas;
        txt_codigoPlanoDeContasOS       .setText(bpla.codigoPlanoDeContas);
        label_planoDeContasOS           .setText(bpla.descricaoPlanoDeContas);
    }
    
    private void AbriuPlanoDeContasBoletos(){
        if(abriuPesquisaPlanoDeContasBoletos == 0){
            AbriuPlanoDeContasRecibos();
            return;
        }
        abriuPesquisaPlanoDeContasBoletos = 0;
        retorno = PlaDeConCon.getRetorno();
        if(retorno.equals(""))
            return;
        bpla.codigoPlanoDeContas = retorno;
        sql = "select idPlanoDeContas, idEmpresa, codigoGrupo, codigoEmpresa, codigoPlanoDeContas, descricaoPlanoDeContas, tipoPlanoDeContas, nivelPlanoDeContas from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and replace(codigoPlanoDeContas, '.', '') = '" + bpla.codigoPlanoDeContas + "';";
        PegaPlanoDeContas();
        bplarel.codigoPlanoDeContasBoletos = bpla.codigoPlanoDeContas;
        txt_codigoPlanoDeContasBoletos  .setText(bpla.codigoPlanoDeContas);
        label_planoDeContasBoletos      .setText(bpla.descricaoPlanoDeContas);
    }
    
    private void AbriuPlanoDeContasRecibos(){
        if(abriuPesquisaPlanoDeContasRecibos == 0)
            return;
        abriuPesquisaPlanoDeContasRecibos = 0;
        retorno = PlaDeConCon.getRetorno();
        if(retorno.equals(""))
            return;
        bpla.codigoPlanoDeContas = retorno;
        sql = "select idPlanoDeContas, idEmpresa, codigoGrupo, codigoEmpresa, codigoPlanoDeContas, descricaoPlanoDeContas, tipoPlanoDeContas, nivelPlanoDeContas from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and replace(codigoPlanoDeContas, '.', '') = '" + bpla.codigoPlanoDeContas + "';";
        PegaPlanoDeContas();
        bplarel.codigoPlanoDeContasRecibos = bpla.codigoPlanoDeContas;
        txt_codigoPlanoDeContasRecibos  .setText(bpla.codigoPlanoDeContas);
        label_planoDeContasRecibos      .setText(bpla.descricaoPlanoDeContas);
    }
    
    private void bt_confirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmaActionPerformed
        VerificaContaAnalitica();
        if(fatal.equals("S"))return;
        if(operacao.equals("I")){
            IncluirRelacionamento();
            return;
        }
        AlterarRelacionamento();
    }//GEN-LAST:event_bt_confirmaActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(PlaDeConCon  != null)PlaDeConCon.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void txt_codigoPlanoDeContasRecibosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPlanoDeContasRecibosFocusLost
        bpla.codigoPlanoDeContas    = txt_codigoPlanoDeContasRecibos.getText().replace(".", "");
        if(bpla.codigoPlanoDeContas.equals(""))
            return;
        sql = "select idPlanoDeContas, idEmpresa, codigoGrupo, codigoEmpresa, codigoPlanoDeContas, descricaoPlanoDeContas, tipoPlanoDeContas, nivelPlanoDeContas from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and replace(codigoPlanoDeContas, '.', '') = '" + bpla.codigoPlanoDeContas + "';";
        PegaPlanoDeContas();
        if(dadosPlanoDeContas.isEmpty())return;
        bplarel.codigoPlanoDeContasRecibos = bpla.codigoPlanoDeContas;
        label_planoDeContasRecibos  .setText(bpla.descricaoPlanoDeContas);
    }//GEN-LAST:event_txt_codigoPlanoDeContasRecibosFocusLost

    private void bt_pesquisarPlanoDeContaRecibosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisarPlanoDeContaRecibosActionPerformed
        if(PlaDeConCon != null)if(PlaDeConCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuPesquisaPlanoDeContasRecibos = 1;
        parametros.clear();
        parametros.add("N");
        PlaDeConCon = new PlanoDeContasConsulta(parametros);
        PlaDeConCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisarPlanoDeContaRecibosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_confirma;
    private javax.swing.JButton bt_pesquisarPlanoDeContaBoletos;
    private javax.swing.JButton bt_pesquisarPlanoDeContaRecibos;
    private javax.swing.JButton bt_pesquisarPlanoDeContasOS;
    private javax.swing.JButton bt_pesquisarPlanoDeContasVendas;
    private javax.swing.JButton bt_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_planoDeContasBoletos;
    private javax.swing.JLabel label_planoDeContasOS;
    private javax.swing.JLabel label_planoDeContasRecibos;
    private javax.swing.JLabel label_planoDeContasVendas;
    private javax.swing.JTextField txt_codigoPlanoDeContasBoletos;
    private javax.swing.JTextField txt_codigoPlanoDeContasOS;
    private javax.swing.JTextField txt_codigoPlanoDeContasRecibos;
    private javax.swing.JTextField txt_codigoPlanoDeContasVendas;
    // End of variables declaration//GEN-END:variables
    
    private void PegaRelacionamento(){
        sql = "select * from tb_planodecontasrelacionamento where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + ";";
        dadosRelacionamento.clear();
        dadosRelacionamento = parametrosNS.dao.Consulta(sql);
        if(dadosRelacionamento.isEmpty()){
            operacao = "I";
            return;
        }
        operacao = "A";
        PegaDadosRelacionamento();
    }
    
    private void PegaDadosRelacionamento(){
        for(int i = 0; i < dadosRelacionamento.size(); i++){
            bplarel = new BeanPlanoDeContasRelacionamento();
            if(dadosRelacionamento.get(i).get(0) != null){bplarel.idPlanoDeContasRelacionamento   = Integer.parseInt(String.valueOf(dadosRelacionamento.get(i).get(0)));}
            if(dadosRelacionamento.get(i).get(1) != null){bplarel.idEmpresa                       = Integer.parseInt(String.valueOf(dadosRelacionamento.get(i).get(1)));}
            if(dadosRelacionamento.get(i).get(2) != null){bplarel.codigoGrupo                     = Integer.parseInt(String.valueOf(dadosRelacionamento.get(i).get(2)));}
            if(dadosRelacionamento.get(i).get(3) != null){bplarel.codigoEmpresa                   = Integer.parseInt(String.valueOf(dadosRelacionamento.get(i).get(3)));}
            if(dadosRelacionamento.get(i).get(4) != null){bplarel.codigoPlanoDeContasVendas       =                  String.valueOf(dadosRelacionamento.get(i).get(4));}
            if(dadosRelacionamento.get(i).get(5) != null){bplarel.codigoPlanoDeContasOS           =                  String.valueOf(dadosRelacionamento.get(i).get(5));}
            if(dadosRelacionamento.get(i).get(6) != null){bplarel.codigoPlanoDeContasBoletos      =                  String.valueOf(dadosRelacionamento.get(i).get(6));}
            if(dadosRelacionamento.get(i).get(7) != null){bplarel.codigoPlanoDeContasRecibos      =                  String.valueOf(dadosRelacionamento.get(i).get(7));}
        }
        
        if(!bplarel.codigoPlanoDeContasVendas.equals("")){
            bpla.codigoPlanoDeContas = bplarel.codigoPlanoDeContasVendas;
            sql = "select idPlanoDeContas, idEmpresa, codigoGrupo, codigoEmpresa, codigoPlanoDeContas, descricaoPlanoDeContas, tipoPlanoDeContas, nivelPlanoDeContas from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and codigoPlanoDeContas = " + bpla.codigoPlanoDeContas + ";";
            PegaPlanoDeContas();
            txt_codigoPlanoDeContasVendas   .setText(bpla.codigoPlanoDeContas);
            label_planoDeContasVendas       .setText(bpla.descricaoPlanoDeContas);
        }
        if(!bplarel.codigoPlanoDeContasOS.equals("")){
            bpla.codigoPlanoDeContas = bplarel.codigoPlanoDeContasOS;
            sql = "select idPlanoDeContas, idEmpresa, codigoGrupo, codigoEmpresa, codigoPlanoDeContas, descricaoPlanoDeContas, tipoPlanoDeContas, nivelPlanoDeContas from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and codigoPlanoDeContas = " + bpla.codigoPlanoDeContas + ";";
            PegaPlanoDeContas();
            txt_codigoPlanoDeContasOS       .setText(bpla.codigoPlanoDeContas);
            label_planoDeContasOS           .setText(bpla.descricaoPlanoDeContas);
        }
        if(!bplarel.codigoPlanoDeContasBoletos.equals("")){
            bpla.codigoPlanoDeContas = bplarel.codigoPlanoDeContasBoletos;
            sql = "select idPlanoDeContas, idEmpresa, codigoGrupo, codigoEmpresa, codigoPlanoDeContas, descricaoPlanoDeContas, tipoPlanoDeContas, nivelPlanoDeContas from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and codigoPlanoDeContas = " + bpla.codigoPlanoDeContas + ";";
            PegaPlanoDeContas();
            txt_codigoPlanoDeContasBoletos  .setText(bpla.codigoPlanoDeContas);
            label_planoDeContasBoletos      .setText(bpla.descricaoPlanoDeContas);
        }
        if(!bplarel.codigoPlanoDeContasRecibos.equals("")){
            bpla.codigoPlanoDeContas = bplarel.codigoPlanoDeContasRecibos;
            sql = "select idPlanoDeContas, idEmpresa, codigoGrupo, codigoEmpresa, codigoPlanoDeContas, descricaoPlanoDeContas, tipoPlanoDeContas, nivelPlanoDeContas from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and codigoPlanoDeContas = " + bpla.codigoPlanoDeContas + ";";
            PegaPlanoDeContas();
            txt_codigoPlanoDeContasRecibos  .setText(bpla.codigoPlanoDeContas);
            label_planoDeContasRecibos      .setText(bpla.descricaoPlanoDeContas);
        }
    }
    
    private void PegaPlanoDeContas(){
        dadosPlanoDeContas.clear();
        dadosPlanoDeContas = parametrosNS.dao.Consulta(sql);
        if(dadosPlanoDeContas.isEmpty()){
            Mensagem = "Plano de Contas n°" + bpla.codigoPlanoDeContas + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosPlanoDeContas();
    }
    
    private void PegaDadosPlanoDeContas(){
        for(int i = 0; i < dadosPlanoDeContas.size(); i++){
            bpla = new BeanPlanoDeContas();
            bpla.idPlanoDeContas                = Integer.parseInt(  String.valueOf(dadosPlanoDeContas.get(i).get(0)));
            bpla.idEmpresa                      = Integer.parseInt(  String.valueOf(dadosPlanoDeContas.get(i).get(1)));
            bpla.codigoGrupo                    = Integer.parseInt(  String.valueOf(dadosPlanoDeContas.get(i).get(2)));
            bpla.codigoEmpresa                  = Integer.parseInt(  String.valueOf(dadosPlanoDeContas.get(i).get(3)));
            bpla.codigoPlanoDeContas            =                    String.valueOf(dadosPlanoDeContas.get(i).get(4));
            bpla.descricaoPlanoDeContas         =                    String.valueOf(dadosPlanoDeContas.get(i).get(5));
            bpla.tipoPlanoDeContas              =                    String.valueOf(dadosPlanoDeContas.get(i).get(6));
            bpla.nivelPlanoDeContas             = Integer.parseInt(  String.valueOf(dadosPlanoDeContas.get(i).get(7)));
        }
        bpla.RecarregaCodigosPlanosDeContas();
        bpla.RecarregaPlanoDeContas("S", "N");
    }
    
    private void VerificaContaAnalitica(){
        fatal = "N";
        bplarel.idEmpresa       = parametrosNS.be.IdEmpresa;
        bplarel.codigoGrupo     = parametrosNS.bge.CodigoGrupo;
        bplarel.codigoEmpresa   = parametrosNS.be.CodigoEmpresa;
        bpla.CarregaPlanoDeContas();
        bplarel.codigoPlanoDeContasBoletos  = bpla.codigoPlanoDeContas;
        sql = "select idPlanoDeContas, idEmpresa, codigoGrupo, codigoEmpresa, codigoPlanoDeContas, descricaoPlanoDeContas, tipoPlanoDeContas, nivelPlanoDeContas from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and codigoPlanoDeContas = '" + bplarel.codigoPlanoDeContasBoletos + "';";
        PegaPlanoDeContas();
        if(bpla.nivelPlanoDeContas < 6){
            Mensagem = "Impossível Relacionar Boletos com Plano Sintético!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bplarel.codigoPlanoDeContasOS  = bpla.codigoPlanoDeContas;
        sql = "select idPlanoDeContas, idEmpresa, codigoGrupo, codigoEmpresa, codigoPlanoDeContas, descricaoPlanoDeContas, tipoPlanoDeContas, nivelPlanoDeContas from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and codigoPlanoDeContas = '" + bplarel.codigoPlanoDeContasOS + "';";
        PegaPlanoDeContas();
        if(bpla.nivelPlanoDeContas < 6){
            Mensagem = "Impossível Relacionar Ordens de Serviços com Plano Sintético!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bplarel.codigoPlanoDeContasRecibos  = bpla.codigoPlanoDeContas;
        sql = "select idPlanoDeContas, idEmpresa, codigoGrupo, codigoEmpresa, codigoPlanoDeContas, descricaoPlanoDeContas, tipoPlanoDeContas, nivelPlanoDeContas from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and codigoPlanoDeContas = '" + bplarel.codigoPlanoDeContasRecibos + "';";
        PegaPlanoDeContas();
        if(bpla.nivelPlanoDeContas < 6){
            Mensagem = "Impossível Relacionar Recibos com Plano Sintético!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bplarel.codigoPlanoDeContasVendas  = bpla.codigoPlanoDeContas;
        sql = "select idPlanoDeContas, idEmpresa, codigoGrupo, codigoEmpresa, codigoPlanoDeContas, descricaoPlanoDeContas, tipoPlanoDeContas, nivelPlanoDeContas from tb_planodecontas where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " and codigoPlanoDeContas = '" + bplarel.codigoPlanoDeContasVendas + "';";
        PegaPlanoDeContas();
        if(bpla.nivelPlanoDeContas < 6){
            Mensagem = "Impossível Relacionar Vendas com Plano Sintético!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
    }
    
    private void IncluirRelacionamento(){
        sql = "insert into tb_planodecontasrelacionamento (idEmpresa, codigoGrupo, codigoEmpresa, codigoPlanoDeContasVendas, codigoPlanoDeContasOS, codigoPlanoDeContasBoletos, codigoPlanoDeContasRecibos) "
            + "values (" + bplarel.idEmpresa + ", " + bplarel.codigoGrupo + ", " + bplarel.codigoEmpresa + ", " + bplarel.codigoPlanoDeContasVendas + ", " + bplarel.codigoPlanoDeContasOS + ", " + bplarel.codigoPlanoDeContasBoletos + ", " + bplarel.codigoPlanoDeContasRecibos + ");";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        operacao = "A";
        Mensagem = "Registro Gravado com Sucesso!";
        new MostraMensagem(Mensagem);
    }
    
    private void AlterarRelacionamento(){
        sql = "update tb_planodecontasrelacionamento set idPlanoDeContasVendas = "                  + bplarel.codigoPlanoDeContasVendas         + ", "  +
                                                        "idPlanoDeContasOS = "                      + bplarel.codigoPlanoDeContasOS             + ", "  +
                                                        "idPlanoDeContasBoletos = "                 + bplarel.codigoPlanoDeContasBoletos        + ", "  +
                                                        "idPlanoDeContasRecibos = "                 + bplarel.codigoPlanoDeContasRecibos        + " "   +
                                                        "where idPlanoDeContasRelacionamento = "    + bplarel.idPlanoDeContasRelacionamento + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        Mensagem = "Registro Alterado com Sucesso!";
        new MostraMensagem(Mensagem);
    }
    
}
