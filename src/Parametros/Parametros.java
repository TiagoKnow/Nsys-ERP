package Parametros;

import Beans.BeanParametros;
import FuncoesInternas.*;
import Parametros.parametrosNS;
import java.io.File;
import java.util.*;
import javax.swing.*;

/*
 @author Tiago e Paulo
 */
public class Parametros extends javax.swing.JFrame {//String's
    String sql                  = "";
    String operacao             = "N";
    String fatal                = "N";
    String Mensagem             = "";
    String sqlstate             = "00000";
    
    //ArrayList's
    ArrayList<ArrayList> dadosParametros        = new ArrayList<ArrayList>();
    
    //bean's
    BeanParametros      bpar    = new BeanParametros();
    
    
    //Outros
    JFileChooser Seletor        = new JFileChooser();
    File ArquivoPasta           = null;
    
    public Parametros(){
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_confirma = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_pasta_relatorio = new javax.swing.JTextField();
        bt_diretorio_relatorios = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(":: Parâmetros");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

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

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(jLabel3.getFont().deriveFont(jLabel3.getFont().getStyle() | java.awt.Font.BOLD, 12));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Diretório de Relatórios: ");

        txt_pasta_relatorio.setEditable(false);
        txt_pasta_relatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pasta_relatorioActionPerformed(evt);
            }
        });

        bt_diretorio_relatorios.setText("...");
        bt_diretorio_relatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_diretorio_relatoriosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Parametros");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_pasta_relatorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_diretorio_relatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_pasta_relatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_diretorio_relatorios))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_diretorio_relatorios, jLabel3, txt_pasta_relatorio});

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 611, Short.MAX_VALUE)
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
                    .addComponent(bt_confirma, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public void PegaParametros(){
        sql = "select * from tb_parametros where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosParametros.clear();
        dadosParametros = parametrosNS.dao.Consulta(sql);
        if(dadosParametros.isEmpty()){
            operacao = "I";
            return;
        }
        operacao = "A";
        PegaDadosParametros();
    }
    
    public void PegaDadosParametros(){
        for(int i = 0; i < dadosParametros.size(); i++){
            bpar.idParametros       = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(0)));
            bpar.idEmpresa          = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(1)));
            bpar.codigoGrupo        = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(2)));
            bpar.codigoEmpresa      = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(3)));
            bpar.pastaRelatorios    =                    String.valueOf(dadosParametros.get(i).get(4));
        }
        bpar.pastaRelatorios    = bpar.pastaRelatorios.replace("\\\\", "\\");
        bpar.pastaRelatorios    = bpar.pastaRelatorios.replace("//", "/");
        txt_pasta_relatorio.setText(bpar.pastaRelatorios);
    }
    
    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_confirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmaActionPerformed
        if(operacao.equals("I")){
            IncluirParametros();
            return;
        }
        AlterarParametros();
    }//GEN-LAST:event_bt_confirmaActionPerformed

    private void bt_diretorio_relatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_diretorio_relatoriosActionPerformed
        Seletor = new JFileChooser();
        Seletor.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int i = Seletor.showOpenDialog(null);
        if(i == 1){
            return;
        }
        ArquivoPasta = Seletor.getSelectedFile();
        if(ArquivoPasta.getPath().equals(""))
            return;
        txt_pasta_relatorio.setText(ArquivoPasta.getPath());
    }//GEN-LAST:event_bt_diretorio_relatoriosActionPerformed

    private void txt_pasta_relatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pasta_relatorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pasta_relatorioActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        PegaParametros();
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_confirma;
    private javax.swing.JButton bt_diretorio_relatorios;
    private javax.swing.JButton bt_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_pasta_relatorio;
    // End of variables declaration//GEN-END:variables
    
    public void VerificaValores(){
        fatal = "N";
        bpar.idEmpresa                  = parametrosNS.be.IdEmpresa;
        bpar.codigoGrupo                = parametrosNS.bge.CodigoGrupo;
        bpar.codigoEmpresa              = parametrosNS.be.CodigoEmpresa;
        bpar.pastaRelatorios            = txt_pasta_relatorio.getText();
        if(bpar.pastaRelatorios.equals("")){
            Mensagem = "Pasta direcionada aos relatórios está Invalida!!!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bpar.pastaRelatorios            = txt_pasta_relatorio.getText().replace("/", "//");
        bpar.pastaRelatorios            = txt_pasta_relatorio.getText().replace("\\", "\\\\");
    }
    
    public void IncluirParametros(){
        VerificaValores();
        if(fatal.equals("S"))
            return;
        sql = "insert into tb_parametros (idEmpresa, codigoGrupo, codigoEmpresa, pastaRelatorios, atualizado) "
            + "values (" + bpar.idEmpresa + ", " + bpar.codigoGrupo + ", " + bpar.codigoEmpresa + ", '" + bpar.pastaRelatorios + "', 1);";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        bt_sair.grabFocus();
        Mensagem = "Parâmetros incluidos com Sucesso!!!";
        new MostraMensagem(Mensagem);
    }
    
    public void AlterarParametros(){
        VerificaValores();
        if(fatal.equals("S"))
            return;
        sql = "update tb_parametros set pastaRelatorios = '"        + bpar.pastaRelatorios  + "'," +
                                       "atualizado = 1 " +
                                       "where idParametros = "   + bpar.idParametros     + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        bt_sair.grabFocus();
        Mensagem = "Parâmetros alterados com Sucesso!!!";
        new MostraMensagem(Mensagem);
    }
    
}
