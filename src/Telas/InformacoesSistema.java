package Telas;

import Beans.BeanComputadores;
import Beans.BeanTerminais;
import FuncoesInternas.CapturarDataHora;
import BeansNS.BeanBancoDados;
import Parametros.parametrosNS;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.lang.management.ManagementFactory;
import javax.swing.Timer;
import java.net.*;
/*
 @author Tiago e Paulo
 */
public class InformacoesSistema extends javax.swing.JFrame {
    //String's
    String ConexaoComBanco = "";
    
    //Timer
    Timer Tempo;
    
    InetAddress addr;
    
    //Qual disco
    String  HD      = System.getProperty("user.dir").substring(0, 3);
    File    MeuHD   = new File(HD);
    
    //Especiais do Sistema
    com.sun.management.OperatingSystemMXBean mxbean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    
    //Variavies de conversão
    double  TotalDeRam  = 0;
    double  RamLivre    = 0;
    double  UsoDeRam    = 0;
    double  TotalDeHD   = 0;
    double  HDLivre     = 0;
    double  UsoDeHD     = 0;
    
    //Especiais
    CapturarDataHora cdh        = new CapturarDataHora();
    
    //Variaveis de Conexao Com a Internet
    URL url                     = null;
    URLConnection urlCon        = null;
    HttpURLConnection httpCon   = null;
    String ConexaoComInternet   = "Sem Conexão!";
    
    //Telas
    
    public InformacoesSistema(){
        initComponents();
    }
    
    private void CarregarAutomaticamenteInformacoes(){
        ActionListener action = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CarregaMemoriaRam();
                InformacoesDeProcessamento();
            }
        };
        Tempo = new Timer(5000, action);
        Tempo.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_host = new javax.swing.JTextField();
        txt_porta = new javax.swing.JTextField();
        txt_bd = new javax.swing.JTextField();
        txt_usuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_statusConexaoBanco = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_ip = new javax.swing.JTextField();
        txt_userPC = new javax.swing.JTextField();
        txt_dirProg = new javax.swing.JTextField();
        txt_dataAtual = new javax.swing.JTextField();
        txt_nomeTerminal = new javax.swing.JTextField();
        txt_memoria = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        txt_hd = new javax.swing.JTextField();
        txt_Internet = new javax.swing.JTextField();
        txt_memoriaEmUso = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_memoriaDisponivel = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_hdEmUso = new javax.swing.JTextField();
        txt_hdDisponivel = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_ok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(":: Informações Tecnicas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(":: Informações do Servidor"));

        jLabel1.setText("Servidor: ");

        jLabel2.setText("Usuário: ");

        jLabel3.setText("BD: ");

        jLabel4.setText("Porta: ");

        txt_host.setEditable(false);
        txt_host.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        txt_porta.setEditable(false);
        txt_porta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        txt_bd.setEditable(false);
        txt_bd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        txt_usuario.setEditable(false);
        txt_usuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel5.setText("Status: ");

        txt_statusConexaoBanco.setEditable(false);
        txt_statusConexaoBanco.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_host)
                    .addComponent(txt_porta)
                    .addComponent(txt_bd, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_usuario, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_statusConexaoBanco))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_host, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_porta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_bd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_statusConexaoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(":: Informações do Terminal"));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("IP / Host: ");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Usuário Terminal: ");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Pasta do Sistema: ");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Data atual: ");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Nome Terminal: ");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Memória RAM: ");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Processador: ");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("HD: ");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Conexão com a Internet: ");

        txt_ip.setEditable(false);

        txt_userPC.setEditable(false);

        txt_dirProg.setEditable(false);

        txt_dataAtual.setEditable(false);
        txt_dataAtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dataAtualActionPerformed(evt);
            }
        });

        txt_nomeTerminal.setEditable(false);

        txt_memoria.setEditable(false);

        jTextField8.setEditable(false);

        txt_hd.setEditable(false);

        txt_Internet.setEditable(false);
        txt_Internet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_InternetActionPerformed(evt);
            }
        });

        txt_memoriaEmUso.setEditable(false);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Memória RAM (Em Uso): ");

        txt_memoriaDisponivel.setEditable(false);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Memória RAM (Disponível): ");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("HD (Em Uso): ");

        txt_hdEmUso.setEditable(false);

        txt_hdDisponivel.setEditable(false);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("HD (Disponível): ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_userPC, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                            .addComponent(txt_dirProg, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                            .addComponent(txt_dataAtual, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                            .addComponent(txt_memoria, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                            .addComponent(txt_memoriaEmUso, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                            .addComponent(txt_memoriaDisponivel, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                            .addComponent(txt_ip)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                            .addComponent(txt_hd, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                            .addComponent(txt_Internet, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                            .addComponent(txt_hdEmUso, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                            .addComponent(txt_hdDisponivel, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nomeTerminal, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel12, jLabel13, jLabel14, jLabel15, jLabel16, jLabel17, jLabel18, jLabel7, jLabel8, jLabel9});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_nomeTerminal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_userPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_dirProg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_dataAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_memoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txt_memoriaEmUso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txt_memoriaDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_hd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txt_hdEmUso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txt_hdDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txt_Internet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel12, jLabel13, jLabel14, jLabel15, jLabel16, jLabel17, jLabel18, jLabel6, jLabel7, jLabel8, jLabel9, jTextField8, txt_Internet, txt_dataAtual, txt_dirProg, txt_hd, txt_hdDisponivel, txt_hdEmUso, txt_ip, txt_memoria, txt_memoriaDisponivel, txt_memoriaEmUso, txt_nomeTerminal, txt_userPC});

        txt_ok.setText("OK");
        txt_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_okActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(txt_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_ok)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(parametrosNS.con != null)
            ConexaoComBanco = "Conectado!";
        else
            ConexaoComBanco = "Sem Conexão!";
        
        CarregarConexaoComInternet();
        InformacoesServidor();
        InformacoesComputador();
        CarregaHardDrive();
        CarregarAutomaticamenteInformacoes();
    }//GEN-LAST:event_formWindowOpened

    private void txt_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_okActionPerformed
        dispose();
    }//GEN-LAST:event_txt_okActionPerformed

    private void txt_dataAtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dataAtualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dataAtualActionPerformed

    private void txt_InternetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_InternetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_InternetActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField txt_Internet;
    private javax.swing.JTextField txt_bd;
    private javax.swing.JTextField txt_dataAtual;
    private javax.swing.JTextField txt_dirProg;
    private javax.swing.JTextField txt_hd;
    private javax.swing.JTextField txt_hdDisponivel;
    private javax.swing.JTextField txt_hdEmUso;
    private javax.swing.JTextField txt_host;
    private javax.swing.JTextField txt_ip;
    private javax.swing.JTextField txt_memoria;
    private javax.swing.JTextField txt_memoriaDisponivel;
    private javax.swing.JTextField txt_memoriaEmUso;
    private javax.swing.JTextField txt_nomeTerminal;
    private javax.swing.JButton txt_ok;
    private javax.swing.JTextField txt_porta;
    private javax.swing.JTextField txt_statusConexaoBanco;
    private javax.swing.JTextField txt_userPC;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
    
    private void InformacoesServidor() {
        txt_bd.setText(parametrosNS.bbd.nomeBanco);
        txt_host.setText(parametrosNS.bbd.servidor);
        txt_porta.setText(String.valueOf(parametrosNS.bbd.porta));
        txt_usuario.setText(parametrosNS.bbd.usuario);
        txt_statusConexaoBanco.setText(ConexaoComBanco);
    }
    
    private void CarregarConexaoComInternet(){
        try{
            url     = new java.net.URL("http://www.google.com");
            urlCon  = url.openConnection();
            httpCon = (java.net.HttpURLConnection) urlCon;
            httpCon.connect();
            int x = httpCon.getResponseCode();
            if(x == 200){
                ConexaoComInternet = "Conectado!";
                return;
            }
            ConexaoComInternet = "Sem Conexão!";
        }catch(java.net.MalformedURLException urlMal){
            
        }catch(java.io.IOException ioexcp){
            
        }
    }
    
    private void InformacoesComputador(){
        txt_nomeTerminal.setText(parametrosNS.bcomp.nomeComputador);
        txt_dataAtual.setText(cdh.CapturarData());
        txt_ip.setText(parametrosNS.bcomp.ipv4);
        txt_userPC.setText(parametrosNS.bcomp.usuarioMachine);
        txt_dirProg.setText(parametrosNS.PastaSistema);
        txt_Internet.setText(ConexaoComInternet);
    }
    
    private void CarregaMemoriaRam(){
        TotalDeRam  = mxbean.getTotalPhysicalMemorySize();
        RamLivre    = mxbean.getFreePhysicalMemorySize();
        UsoDeRam    = TotalDeRam - RamLivre;
        TotalDeRam  = TotalDeRam / Math.pow(1024, 3);
        RamLivre    = RamLivre   / Math.pow(1024, 3);
        UsoDeRam    = UsoDeRam   / Math.pow(1024, 3);
    }
    
    private void CarregaHardDrive(){
        TotalDeHD   = MeuHD.getTotalSpace();
        HDLivre     = MeuHD.getFreeSpace();
        UsoDeHD     = TotalDeHD - HDLivre;
        TotalDeHD   = TotalDeHD / Math.pow(1024, 3);
        HDLivre     = HDLivre   / Math.pow(1024, 3);
        UsoDeHD     = UsoDeHD   / Math.pow(1024, 3);
    }
    
    private void InformacoesDeProcessamento(){
        try {
            TotalDeRam  = Double.parseDouble(String.valueOf(TotalDeRam) .substring(0, 6));
            RamLivre    = Double.parseDouble(String.valueOf(RamLivre)   .substring(0, 6));
            UsoDeRam    = Double.parseDouble(String.valueOf(UsoDeRam)   .substring(0, 6));
            
            TotalDeHD   = Double.parseDouble(String.valueOf(TotalDeHD)  .substring(0, 6));
            HDLivre     = Double.parseDouble(String.valueOf(HDLivre)    .substring(0, 6));
            UsoDeHD     = Double.parseDouble(String.valueOf(UsoDeHD)    .substring(0, 6));
            
            txt_memoria             .setText(TotalDeRam + " GB");
            txt_memoriaEmUso        .setText(UsoDeRam   + " GB");
            txt_memoriaDisponivel   .setText(RamLivre   + " GB");
            
            txt_hd                  .setText(TotalDeHD  + " GB");
            txt_hdEmUso             .setText(UsoDeHD    + " GB");
            txt_hdDisponivel        .setText(HDLivre    + " GB");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
    }
}
