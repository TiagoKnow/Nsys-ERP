package TelasContabil;

import Beans.BeanParametrosContabil;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.ValidarData;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/*
 @author Tiago e Paulo
 */
public class SelecionarDataDoSistemaContabil extends javax.swing.JFrame {
    //String's
    String sql                          = "";
    String sqlstate                     = "";
    String Mensagem                     = "";
    String fatal                        = "";
    String operacaoParametrosContabil   = "";
    
    //Vetores
    ArrayList            parametros                = new ArrayList<Object>();
    ArrayList<ArrayList> dadosParametrosContabil   = new ArrayList<ArrayList>();
    
    //Bean's
    BeanParametrosContabil      bparcon = new BeanParametrosContabil();
    
    //Especiais
    CapturarDataHora            cdh     = new CapturarDataHora();
    InverterData                invdata = new InverterData();
    ValidarData                 ValData = new ValidarData();
    
    //Telas
    
    public SelecionarDataDoSistemaContabil(){
        initComponents();
    }
    
    private void PegaParametrosContabil(){
        sql = "select * from tb_parametroscontabil where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + ";";
        dadosParametrosContabil.clear();
        dadosParametrosContabil = parametrosNS.dao.Consulta(sql);
        if(dadosParametrosContabil.isEmpty()){
            bparcon.dataContabil    = cdh.CapturarData();
            txt_dataContabil.setText(bparcon.dataContabil);
            operacaoParametrosContabil  = "I";
            return;
        }
        operacaoParametrosContabil  = "A";
        PegaDadosParametrosContabil();
    }
    
    private void PegaDadosParametrosContabil(){
        for(int i = 0; i < dadosParametrosContabil.size(); i++){
            bparcon.idParametrosContabil    = Integer.parseInt(  String.valueOf(dadosParametrosContabil.get(i).get(0)));
            bparcon.idEmpresa               = Integer.parseInt(  String.valueOf(dadosParametrosContabil.get(i).get(1)));
            bparcon.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosParametrosContabil.get(i).get(2)));
            bparcon.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosParametrosContabil.get(i).get(3)));
            bparcon.dataContabil            =                    String.valueOf(dadosParametrosContabil.get(i).get(4));
        }
        bparcon.dataContabil    = invdata.inverterData(bparcon.dataContabil, 1);
        txt_dataContabil        .setText(bparcon.dataContabil);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_dataContabil = new javax.swing.JFormattedTextField();
        bt_confirma = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mudar Data Contábil");
        setResizable(false);
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

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Selecionar Data Contábil");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
        );

        try {
            txt_dataContabil.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataContabil.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataContabil.setText("00/00/0000");
        txt_dataContabil.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txt_dataContabil.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataContabilFocusLost(evt);
            }
        });
        txt_dataContabil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataContabilKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_dataContabil, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_dataContabil, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        bt_confirma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_confirma.setText("Confirma");
        bt_confirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmaActionPerformed(evt);
            }
        });
        bt_confirma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bt_confirmaKeyPressed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_confirma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_sair)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_confirma, bt_sair});

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

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_confirma, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_confirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmaActionPerformed
        IncluirOuAlterarData();
    }//GEN-LAST:event_bt_confirmaActionPerformed
    
    private void IncluirOuAlterarData(){
        if(operacaoParametrosContabil.equals("I")){
            IncluirDataContabil();
            return;
        }
        AlterarDataContabil();
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        PegaParametrosContabil();
    }//GEN-LAST:event_formWindowOpened

    private void txt_dataContabilFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataContabilFocusLost
        bt_confirma.setEnabled(false);
        if(ValData.ValidaData(txt_dataContabil.getText()).equals("N")){
            Mensagem = "Data Inválida!";
            new MostraMensagem(Mensagem);
            txt_dataContabil.grabFocus();
            return;
        }
        bt_confirma.setEnabled(true);
        bt_confirma.grabFocus();
    }//GEN-LAST:event_txt_dataContabilFocusLost

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void txt_dataContabilKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataContabilKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jLabel1.grabFocus();
        }
    }//GEN-LAST:event_txt_dataContabilKeyPressed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
    }//GEN-LAST:event_formWindowGainedFocus

    private void bt_confirmaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bt_confirmaKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        IncluirOuAlterarData();
    }//GEN-LAST:event_bt_confirmaKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_confirma;
    private javax.swing.JButton bt_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JFormattedTextField txt_dataContabil;
    // End of variables declaration//GEN-END:variables
    
    private void PegaValores(){
        fatal = "N";
        bparcon.idEmpresa       = parametrosNS.be.IdEmpresa;
        bparcon.codigoGrupo     = parametrosNS.bge.CodigoGrupo;
        bparcon.codigoEmpresa   = parametrosNS.be.CodigoEmpresa;
        bparcon.dataContabil    = txt_dataContabil.getText().replace(" ", "");
        bparcon.dataContabil    = bparcon.dataContabil.replace("/", "");
        if(bparcon.dataContabil.equals("")){
            Mensagem = "Data Contábil Inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bparcon.dataContabil    = invdata.inverterData(txt_dataContabil.getText(), 2);
    }
    
    private void IncluirDataContabil(){
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "insert into tb_parametroscontabil (idEmpresa, codigoGrupo, codigoEmpresa, dataContabil) "
            + "values (" + bparcon.idEmpresa + ", " + bparcon.codigoGrupo + ", " + bparcon.codigoEmpresa + ", '" + bparcon.dataContabil + "');";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        dispose();
    }
    
    private void AlterarDataContabil(){
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "update tb_parametroscontabil set dataContabil = '"           + bparcon.dataContabil          + "' " +
                                            "where idParametrosContabil = " + bparcon.idParametrosContabil  + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        dispose();
    }
    
}
