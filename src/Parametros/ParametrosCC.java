package Parametros;

import Beans.BeanComputadores;
import Beans.BeanParametrosCC;
import Beans.BeanUsuarios;
import Dao.DaoMySQL;
import FuncoesInternas.MostraMensagem;
import Parametros.parametrosNS;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
/*
 @author Tiago e Paulo 10/08/2016 16:11
 */
public class ParametrosCC extends javax.swing.JFrame {
    //ArrayList's
    ArrayList<ArrayList> dadosParametrosCC = new ArrayList<ArrayList>();
    
    //bean's
    BeanParametrosCC    bparcc  = new BeanParametrosCC();
    
    //String's
    String sql                  = "";
    String operacao             = "N";
    String fatal                = "N";
    String mensagem             = "";
    String leuImagem            = "";
    String sqlstate             = "00000";
    String imagemBoletos        = "";
    
    //Outros
    JFileChooser        Seletor = new JFileChooser();
    File                arquivoPasta    = null;
    
    //Especiais
    BufferedImage                   BuffImg;
    ByteArrayOutputStream           BytesImg;
    ImageIcon                       imgIcon;
    Image                           img;
    
    public ParametrosCC(){
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_imagemBoletos = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        bt_confirma = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Parâmetros de Contas Correntes");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Parametros Contas Correntes");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Imagem Padronizada para Boletos:");

        txt_imagemBoletos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_imagemBoletos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Buscar imagem");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_imagemBoletos, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(348, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jButton1)
                    .addComponent(txt_imagemBoletos, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jLabel2});

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        bt_confirma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_confirma.setText("Confirma");
        bt_confirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmaActionPerformed(evt);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_confirma, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_confirma, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_confirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmaActionPerformed
        if(operacao.equals("I")){
            IncluirParametrosCC();
            return;
        }
        AlterarParametrosCC();
    }//GEN-LAST:event_bt_confirmaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        PegaParametros();
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Seletor = new JFileChooser("C:/"); 
        Seletor.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = Seletor.showOpenDialog(null);
        if(i == 1)
            return;
        arquivoPasta = Seletor.getSelectedFile();
        if(arquivoPasta.getPath().equals(""))
            return;
        imagemBoletos = arquivoPasta.getPath();
        CarregaImagem();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void CarregaImagem(){
        imgIcon = null;
        imgIcon = new ImageIcon(imagemBoletos);
        img     = imgIcon.getImage();
        img     = img.getScaledInstance(txt_imagemBoletos.getWidth() - 1, txt_imagemBoletos.getHeight() - 1, img.SCALE_DEFAULT);
        txt_imagemBoletos.setIcon(new ImageIcon(img));
    }
    
    public void PegaParametros(){
        sql = "select * from tb_parametroscc where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosParametrosCC.clear();
        dadosParametrosCC = parametrosNS.dao.Consulta(sql);
        if(dadosParametrosCC.isEmpty()){
            operacao = "I";
            return;
        }
        operacao = "A";
        PegaDadosParametros();
    }
    
    private void PegaDadosParametros(){
        for(int i = 0; i < dadosParametrosCC.size(); i++){
            bparcc.idParametrosCC           = Integer.parseInt(  String.valueOf(dadosParametrosCC.get(i).get(0)));
            bparcc.idEmpresa                = Integer.parseInt(  String.valueOf(dadosParametrosCC.get(i).get(1)));
            bparcc.codigoGrupo              = Integer.parseInt(  String.valueOf(dadosParametrosCC.get(i).get(2)));
            bparcc.codigoEmpresa            = Integer.parseInt(  String.valueOf(dadosParametrosCC.get(i).get(3)));
        }
        
        PegaImagemBoletos();
        if(bparcc.imagemBoletos == null)
            return;
        try{
            BuffImg = ImageIO.read(new ByteArrayInputStream(bparcc.imagemBoletos));
            imgIcon = new ImageIcon(BuffImg);
            img     = imgIcon.getImage();
            img     = img.getScaledInstance(txt_imagemBoletos.getWidth() - 5, txt_imagemBoletos.getHeight() - 5, img.SCALE_DEFAULT);
            
            txt_imagemBoletos.setIcon(new ImageIcon(img));
        }catch(IOException e){
            
        }
    }
    
    private void PegaImagemBoletos(){
        sql = "select imagemBoletos from tb_parametroscc where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        bparcc.imagemBoletos = parametrosNS.dao.ConsultaLogotipo(sql, "imagemBoletos");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_confirma;
    private javax.swing.JButton bt_sair;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txt_imagemBoletos;
    // End of variables declaration//GEN-END:variables
    
    private void PegaValores(){
        fatal = "N";
        bparcc.idEmpresa                = parametrosNS.be.IdEmpresa;
        bparcc.codigoGrupo              = parametrosNS.bge.CodigoGrupo;
        bparcc.codigoEmpresa            = parametrosNS.be.CodigoEmpresa;
        
        try{
            BuffImg  = ImageIO.read(new File(imagemBoletos));
            BytesImg = new ByteArrayOutputStream();
            
            ImageIO.write((BufferedImage)BuffImg, "jpg", BytesImg);
            BytesImg.flush();
            
            bparcc.imagemBoletos    = BytesImg.toByteArray();
            BytesImg.close();
            bparcc.setImagemBoletos(bparcc.imagemBoletos);
        }catch(Exception erro){
            
        }
    }
    
    private void IncluirParametrosCC(){
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "insert into tb_parametroscc (idEmpresa, codigoGrupo, codigoEmpresa, atualizado) "
            + "values (" + bparcc.idEmpresa + ", " + bparcc.codigoGrupo + ", " + bparcc.codigoEmpresa + ", 1);";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao alterar parametros!";
            new MostraMensagem(mensagem);
            return;
        }
        AtualizaImagens();
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao incluir imagem!";
            new MostraMensagem(mensagem);
            return;
        }
        mensagem = "Registro incluido com sucesso!";
        new MostraMensagem(mensagem);
    }
    
    private void AlterarParametrosCC(){
        PegaValores();
        if(fatal.equals("S"))return;
        
        AtualizaImagens();
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao alterar imagem!";
            new MostraMensagem(mensagem);
            return;
        }
        mensagem = "Registro alterado com sucesso!";
        new MostraMensagem(mensagem);
    }
    
    private void AtualizaImagens(){
        sql = "update tb_parametroscc set imagemBoletos = ?, atualizado = 1 where idEmpresa = " + bparcc.idEmpresa + ";";
        sqlstate = parametrosNS.dao.atualizarImagens(sql, bparcc.getImagemBoletos());
    }
    
}
