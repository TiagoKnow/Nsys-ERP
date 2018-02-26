package Parametros;

import Beans.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import FuncoesInternas.*;

/*
 @author Tiago e Paulo
 */
public class ParametrosEstoque extends javax.swing.JFrame {
    //Vetores
    ArrayList<ArrayList> dadosParametrosEstoque = new ArrayList<ArrayList>();
    
    //bean's
    BeanParametrosEstoque  bpare    = new BeanParametrosEstoque();
    
    //String's
    String sql                      = "";
    String operacao                 = "N";
    String fatal                    = "N";
    String Mensagem                 = "";
    String sqlstate                 = "00000";
    
    //Outros
    JFileChooser Seletor            = new JFileChooser();
    File ArquivoPasta               = null;
    
    //Telas
    
    public ParametrosEstoque(){
        initComponents();
    }
    
    public void CarregarParametrosEstoque(){
        sql = "select * from tb_parametrosestoque where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosParametrosEstoque.clear();
        dadosParametrosEstoque = parametrosNS.dao.Consulta(sql);
        if(dadosParametrosEstoque.isEmpty()){
            operacao = "I";
            return;
        }
        operacao = "A";
        PreencherCampos();
    }
    
    public void PreencherCampos(){
        for(int i = 0; i < dadosParametrosEstoque.size(); i++){
            bpare.idParametrosEstoque       = Integer.parseInt(String.valueOf(dadosParametrosEstoque.get(i).get(0)));
            bpare.idEmpresa                 = Integer.parseInt(String.valueOf(dadosParametrosEstoque.get(i).get(1)));
            bpare.codigoGrupo               = Integer.parseInt(String.valueOf(dadosParametrosEstoque.get(i).get(2)));
            bpare.codigoEmpresa             = Integer.parseInt(String.valueOf(dadosParametrosEstoque.get(i).get(3)));
            bpare.infFaltaEstoqueOuAbaixLim = Integer.parseInt(String.valueOf(dadosParametrosEstoque.get(i).get(4)));
        }
        combo_infFaltaEstoqueOuAbaixLim.setSelectedIndex(bpare.infFaltaEstoqueOuAbaixLim);//0-Não 1-Sim
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        combo_infFaltaEstoqueOuAbaixLim = new javax.swing.JComboBox<>();
        bt_confirma = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(jLabel6.getFont().deriveFont(jLabel6.getFont().getStyle() | java.awt.Font.BOLD, 12));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Informar quando produto estiver abaixo do limite ou em falta:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Parametros de Estoque");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        combo_infFaltaEstoqueOuAbaixLim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_infFaltaEstoqueOuAbaixLim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(368, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_infFaltaEstoqueOuAbaixLim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {combo_infFaltaEstoqueOuAbaixLim, jLabel6});

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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_confirma, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_confirma, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_confirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmaActionPerformed
        if(operacao.equals("I")){
            IncluirParametrosEstoque();
            return;
        }
        AlterarParametrosEstoque();
    }//GEN-LAST:event_bt_confirmaActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        CarregarParametrosEstoque();
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_confirma;
    private javax.swing.JButton bt_sair;
    private javax.swing.JComboBox<String> combo_infFaltaEstoqueOuAbaixLim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    
    public void PegaValores(){
        fatal = "N";
        bpare.idEmpresa                 = parametrosNS.be.IdEmpresa;
        bpare.codigoGrupo               = parametrosNS.bge.CodigoGrupo;
        bpare.codigoEmpresa             = parametrosNS.be.CodigoEmpresa;
        bpare.infFaltaEstoqueOuAbaixLim = combo_infFaltaEstoqueOuAbaixLim.getSelectedIndex();
   }
    
    public void MontaArquivo(){
//        bpare.pastaImagemProdutos       = txt_pastaImagemProdutos.getText().replace("\\", "\\\\");
//        bpare.pastaImagemProdutos       = txt_pastaImagemProdutos.getText().replace("/", "//");
//        bpare.extensaoImagemProdutos    = String.valueOf(combo_extensaoImagemProdutos.getSelectedItem());
    }
    
    public void IncluirParametrosEstoque(){
        PegaValores();
        if(fatal.equals("S"))
            return;
        MontaArquivo();
        sql = "insert into tb_parametrosestoque (idEmpresa, codigoGrupo, codigoEmpresa, infFaltaEstoqueOuAbaixLim, atualizado) "
            + "values (" + bpare.idEmpresa + ", " + bpare.codigoGrupo + ", " + bpare.codigoEmpresa + ", " + bpare.infFaltaEstoqueOuAbaixLim + ", 1);";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        Mensagem = "Parâmetros incluidos com Sucesso!!!";
        new MostraMensagem(Mensagem);
    }
    
    public void AlterarParametrosEstoque(){
        PegaValores();
        if(fatal.equals("S"))
            return;
        MontaArquivo();
        sql = "update tb_parametrosestoque set infFaltaEstoqueOuAbaixLim = " + bpare.infFaltaEstoqueOuAbaixLim  + ", " +
                                              "where idParametrosEstoque = "  + bpare.idParametrosEstoque       + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        Mensagem = "Parâmetros alterados com Sucesso!!!";
        new MostraMensagem(Mensagem);
    }
    
}
