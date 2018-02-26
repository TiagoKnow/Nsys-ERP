package Telas;

import BeansNS.BeanModulosAcesso;
import Beans.BeanUsuarios;
import TelasDeConfiguracoes.*;
import FuncoesInternas.*;
import Main.BarraInicial;
import Main.ProcessoInicial;
import Telas.ComputadoresCadastro;
import Telas.DepartamentosCadastro;
import Telas.Login;
import Telas.UsuariosCadastro;
import Parametros.parametrosNS;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

/*
 @author Tiago, Paulo e Jonas
 */
public class Senha extends javax.swing.JFrame {
    //String
    String Tipo                 = "";
    String senha                = "";
    String Mensagem             = "";
    String retorno              = "";
    String SenhaSistema         = "Admin*10verintel2";
    
    //int
    int    User                 = 0;
    
    //Vetores
    ArrayList parametros        = new ArrayList();
    
    //Telas
    BarraInicial                Bar;
    ProcessoInicial             ProIni;
    GruposCadastro              CadGru;
    EmpresasCadastro            CadEmp;
    UsuariosCadastro            CadUsu;
    ComputadoresCadastro        CadComp;
    DepartamentosCadastro       CadDep;
    
    public Senha(String tipo){
        initComponents();
        Tipo        = tipo;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_senha = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Senha:");

        txt_senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_senhaKeyPressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_sair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_sair, jButton1, jLabel1, txt_senha});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_senhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_senhaKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        VerificaSenha();
    }//GEN-LAST:event_txt_senhaKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VerificaSenha();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        Sair();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
    }//GEN-LAST:event_formWindowGainedFocus
    
    public void VerificaSenha(){
        if(Tipo.equalsIgnoreCase("Modulos"))
            SenhaSistema = "Admin*10verintel2";
        senha = txt_senha.getText();
        if(!senha.equals(SenhaSistema)){
            Mensagem = "Senha inválida!";
            new MostraMensagem(Mensagem);
            txt_senha.setText("");
            txt_senha.grabFocus();
            return;
        }
        retorno = "OK";
        VerificaTela();
    }
    
    public void VerificaTela(){
        if(Tipo.equalsIgnoreCase("Grupo"))          AbreCadastroDeGrupos();
        if(Tipo.equalsIgnoreCase("Empresa"))        AbreCadastroDeEmpresas();
        if(Tipo.equalsIgnoreCase("Usuarios"))       AbreUsuarios();
        Sair();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_sair;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField txt_senha;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
    private void AbreUsuarios(){
        parametros.clear();
        parametros.add("N");
        parametros.add("Login");
        parametros.add(0);
        CadUsu = new UsuariosCadastro(parametros);
        CadUsu.setVisible(true);
    }
    
    private void AbreCadastroDeGrupos(){
        dispose();
        CadGru = new GruposCadastro("Login");
        CadGru.setVisible(true);
    }
    
    private void AbreCadastroDeEmpresas(){
        dispose();
        CadEmp = new EmpresasCadastro();
        CadEmp.setVisible(true);
    }
    
    private int Sair(){
        dispose();
        if(!Tipo.equalsIgnoreCase("Login"))
            return 0;
        Bar     = new BarraInicial();
        ProIni  = new ProcessoInicial(Bar);
        return 0;
    }
    
}
