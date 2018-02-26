package TelasGestao;

import Beans.BeanParametrosGestao;
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
public class SelecionarDataDoSistemaAdministrativa extends javax.swing.JFrame {
    //String's
    String sql                          = "";
    String sqlstate                     = "";
    String Mensagem                     = "";
    String fatal                        = "";
    String operacaoParametrosGestao     = "";
    
    //Vetores
    ArrayList            parametros                = new ArrayList<Object>();
    ArrayList<ArrayList> dadosParametrosGestao     = new ArrayList<ArrayList>();
    
    //Bean's
    BeanParametrosGestao        bparges = new BeanParametrosGestao();
    
    //Especiais
    CapturarDataHora            cdh     = new CapturarDataHora();
    InverterData                invdata = new InverterData();
    ValidarData                 ValData = new ValidarData();
    
    //Telas
    
    public SelecionarDataDoSistemaAdministrativa(){
        initComponents();
    }
    
    private void PegaParametrosGestao(){
        sql = "select * from tb_parametrosgestao where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosParametrosGestao.clear();
        dadosParametrosGestao = parametrosNS.dao.Consulta(sql);
        if(dadosParametrosGestao.isEmpty()){
            bparges.dataGestao      = cdh.CapturarData();
            txt_dataGestao.setText(bparges.dataGestao);
            operacaoParametrosGestao  = "I";
            return;
        }
        operacaoParametrosGestao  = "A";
        PegaDadosParametrosGestao();
    }
    
    private void PegaDadosParametrosGestao(){
        for(int i = 0; i < dadosParametrosGestao.size(); i++){
            bparges.idParametrosGestao  = Integer.parseInt(  String.valueOf(dadosParametrosGestao.get(i).get(0)));
            bparges.idEmpresa           = Integer.parseInt(  String.valueOf(dadosParametrosGestao.get(i).get(1)));
            bparges.codigoGrupo         = Integer.parseInt(  String.valueOf(dadosParametrosGestao.get(i).get(2)));
            bparges.codigoEmpresa       = Integer.parseInt(  String.valueOf(dadosParametrosGestao.get(i).get(3)));
            bparges.dataGestao          =                    String.valueOf(dadosParametrosGestao.get(i).get(4));
        }
        bparges.dataGestao      = invdata.inverterData(bparges.dataGestao, 1);
        txt_dataGestao        .setText(bparges.dataGestao);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_dataGestao = new javax.swing.JFormattedTextField();
        bt_confirma = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mudar Data Contábil");
        setResizable(false);
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
        jLabel1.setText("Selecionar Data Administrativa");

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
            txt_dataGestao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataGestao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataGestao.setText("00/00/0000");
        txt_dataGestao.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txt_dataGestao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataGestaoFocusLost(evt);
            }
        });
        txt_dataGestao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataGestaoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_dataGestao, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_dataGestao, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

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
        if(operacaoParametrosGestao.equals("I")){
            IncluirDataGestao();
            return;
        }
        AlterarDataGestao();
    }//GEN-LAST:event_bt_confirmaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        PegaParametrosGestao();
    }//GEN-LAST:event_formWindowOpened

    private void txt_dataGestaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataGestaoFocusLost
        bt_confirma.setEnabled(false);
        if(ValData.ValidaData(txt_dataGestao.getText()).equals("N")){
            Mensagem = "Data Inválida!";
            new MostraMensagem(Mensagem);
            txt_dataGestao.grabFocus();
            return;
        }
        bt_confirma.setEnabled(true);
        bt_confirma.grabFocus();
    }//GEN-LAST:event_txt_dataGestaoFocusLost

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void txt_dataGestaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataGestaoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jLabel1.grabFocus();
        }
    }//GEN-LAST:event_txt_dataGestaoKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_confirma;
    private javax.swing.JButton bt_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JFormattedTextField txt_dataGestao;
    // End of variables declaration//GEN-END:variables
    
    private void PegaValores(){
        fatal = "N";
        bparges.idEmpresa       = parametrosNS.be.IdEmpresa;
        bparges.codigoGrupo     = parametrosNS.bge.CodigoGrupo;
        bparges.codigoEmpresa   = parametrosNS.be.CodigoEmpresa;
        bparges.dataGestao      = txt_dataGestao.getText().replace(" ", "");
        bparges.dataGestao      = bparges.dataGestao.replace("/", "");
        if(bparges.dataGestao.equals("")){
            Mensagem = "Data Administrativa Inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bparges.dataGestao      = invdata.inverterData(txt_dataGestao.getText(), 2);
        bparges.codigoContaCorrenteBoleto        = 0;
        bparges.codigoContaCorrenteOrdemServico  = 0;
        bparges.codigoContaCorrenteRecibo        = 0;
        bparges.codigoContaCorrenteVenda         = 0;
    }
    
    private void IncluirDataGestao(){
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "insert into tb_parametrosgestao (idEmpresa, codigoGrupo, codigoEmpresa, dataGestao, codigoContaCorrenteBoleto, codigoContaCorrenteOrdemServico, codigoContaCorrenteRecibo, codigoContaCorrenteVenda) "
            + "values (" + bparges.idEmpresa + ", " + bparges.codigoGrupo + ", " + bparges.codigoEmpresa + ", '" + bparges.dataGestao + "', 0, 0, 0, 0);";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        dispose();
    }
    
    private void AlterarDataGestao(){
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "update tb_parametrosgestao set dataGestao = '"           + bparges.dataGestao            + "' "
                                     + "where idParametrosGestao = "    + bparges.idParametrosGestao    + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        dispose();
    }
    
}
