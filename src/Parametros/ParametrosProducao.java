package Parametros;

import Beans.BeanParametrosProducao;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 @author Tiago e Paulo 07/09/2017 as 09:19
 */
public class ParametrosProducao extends javax.swing.JFrame {
    //String
    String sql      = "";
    String sqlstate = "";
    String fatal    = "";
    String mensagem = "";
    String operacao = "";
    
    //int
    
    //Vetores
    ArrayList<ArrayList> dadosParametrosProducao    = new ArrayList();
    
    //Bean
    BeanParametrosProducao bparpro  = new BeanParametrosProducao();
    
    public ParametrosProducao() {
        initComponents();
    }
    
    private void PegaParametrosProducao(){
        sql = "select * from tb_parametrosproducao where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosParametrosProducao.clear();
        dadosParametrosProducao = parametrosNS.dao.Consulta(sql);
        if(dadosParametrosProducao.isEmpty()){
            operacao = "I";
            return;
        }
        operacao = "A";
        PegaDadosParametrosProducao();
    }
    
    private void PegaDadosParametrosProducao(){
        for(int i = 0; i < dadosParametrosProducao.size(); i++){
            bparpro  = new BeanParametrosProducao();
            if(dadosParametrosProducao.get(i).get(0) != null)
                bparpro.idParametrosProducao = Integer.parseInt(String.valueOf(dadosParametrosProducao.get(i).get(0)));
            if(dadosParametrosProducao.get(i).get(1) != null)
                bparpro.idEmpresa            = Integer.parseInt(String.valueOf(dadosParametrosProducao.get(i).get(1)));
            if(dadosParametrosProducao.get(i).get(2) != null)
                bparpro.codigoGrupo          = Integer.parseInt(String.valueOf(dadosParametrosProducao.get(i).get(2)));
            if(dadosParametrosProducao.get(i).get(3) != null)
                bparpro.codigoEmpresa        = Integer.parseInt(String.valueOf(dadosParametrosProducao.get(i).get(3)));
            if(dadosParametrosProducao.get(i).get(4) != null)
                bparpro.dataProducao         =                  String.valueOf(dadosParametrosProducao.get(i).get(4));
            if(dadosParametrosProducao.get(i).get(5) != null)
                bparpro.impressaoDoLaudo     = Integer.parseInt(String.valueOf(dadosParametrosProducao.get(i).get(5)));
            if(dadosParametrosProducao.get(i).get(6) != null)
                bparpro.termoDeRecebimento   =                  String.valueOf(dadosParametrosProducao.get(i).get(6));
        }
        combo_impressaoDoLaudo.setSelectedIndex(bparpro.impressaoDoLaudo);
        txt_termoDeRecebimento.setText(bparpro.termoDeRecebimento);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        combo_impressaoDoLaudo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_termoDeRecebimento = new javax.swing.JTextArea();
        bt_confirma = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Parâmetros de Produção");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Parâmetros de Produção");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Imprimir Laudo na OS:");

        combo_impressaoDoLaudo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----", "Não", "Sim" }));

        jLabel3.setText("Termo de recebimento e aceitação dos serviços realizados:");

        txt_termoDeRecebimento.setColumns(20);
        txt_termoDeRecebimento.setLineWrap(true);
        txt_termoDeRecebimento.setRows(5);
        jScrollPane1.setViewportView(txt_termoDeRecebimento);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(combo_impressaoDoLaudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(combo_impressaoDoLaudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {combo_impressaoDoLaudo, jLabel2, jLabel3});

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 709, Short.MAX_VALUE)
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        PegaParametrosProducao();
    }//GEN-LAST:event_formWindowOpened

    private void bt_confirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmaActionPerformed
        IncluirOuAlterarData();
    }//GEN-LAST:event_bt_confirmaActionPerformed
    
    private void IncluirOuAlterarData(){
        if(operacao.equals("I")){
            IncluirRegistro();
            return;
        }
        AlterarRegistro();
    }
    
    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_confirma;
    private javax.swing.JButton bt_sair;
    private javax.swing.JComboBox<String> combo_impressaoDoLaudo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt_termoDeRecebimento;
    // End of variables declaration//GEN-END:variables
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    private void PegaValores(){
        fatal = "N";
        bparpro.idEmpresa        = parametrosNS.be.IdEmpresa;
        bparpro.codigoGrupo      = parametrosNS.bge.CodigoGrupo;
        bparpro.codigoEmpresa    = parametrosNS.be.CodigoEmpresa;
        bparpro.dataProducao     = null;
        if(combo_impressaoDoLaudo.getSelectedIndex() == 0){
            mensagem = "Parâmetro de impressão do laudo inválida!";
            mostraMensagem();
            fatal = "S";
            return;
        }
        bparpro.impressaoDoLaudo = combo_impressaoDoLaudo.getSelectedIndex();
        bparpro.termoDeRecebimento = txt_termoDeRecebimento.getText();
        if(bparpro.termoDeRecebimento.equals("")){
            mensagem = "Termo de recebimento inválido!";
            mostraMensagem();
            fatal = "S";
            return;
        }
    }
    
    private void IncluirRegistro(){
        PegaValores();
        if(fatal.equals("S"))
            return;
        sql = "insert into tb_parametrosproducao (idEmpresa, codigoGrupo, codigoEmpresa, dataProducao, impressaoDoLaudo, termoDeRecebimento) "
            + "values (" + bparpro.idEmpresa + ", " + bparpro.codigoGrupo + ", " + bparpro.codigoEmpresa + ", " + bparpro.dataProducao + ", " + bparpro.impressaoDoLaudo + ", '" + bparpro.termoDeRecebimento + "');";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        mensagem = "Registro incluído com sucesso!";
        mostraMensagem();
    }
    
    private void AlterarRegistro(){
        PegaValores();
        if(fatal.equals("S"))
            return;
        sql = "update tb_parametrosproducao set impressaoDoLaudo = "            + bparpro.impressaoDoLaudo     + ", " +
                                               "termoDeRecebimento = '"         + bparpro.termoDeRecebimento   + "' " +
                                               "where idParametrosProducao = "  + bparpro.idParametrosProducao + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        mensagem = "Registro alterado com sucesso!";
        mostraMensagem();
    }
    
}
