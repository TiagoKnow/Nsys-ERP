package FuncoesInternas;

import Beans.BeanClientes;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 @author Tiago e Paulo 13/02/2017 15:36
 */
public class EmailMontagem extends javax.swing.JFrame {
    //Email's
    String servidorEmail                    = "";
    int    portaEmail                       = 0;
    String usuarioEmail                     = "";
    String senhaEmail                       = "";
    int    autenticacaoSSL                  = 0;
    String destinatarioEmail                = "";
    String assuntoEmail                     = "";
    String mensagemEmail                    = "";
    String descriptionEmail                 = "";
    String nameEmail                        = "";
    String Valida                           = "";
    String fatal                            = "";
    String sql                              = "";
    String Mensagem                         = "";
    
    //int's
    int    length                           = 0;
    
    //Vetores
    ArrayList            parametros                    = new ArrayList();
    ArrayList            dadosAnexo                    = new ArrayList();
    ArrayList            dadosEmail                    = new ArrayList();
    ArrayList<ArrayList> dadosCliente                  = new ArrayList<ArrayList>();
    
    //Bean's
    BeanClientes                bc          = new BeanClientes();
    
    //Telas
    EmailAnexoEnviar            EmaAneEnv   = new EmailAnexoEnviar();
    
    //File
    JFileChooser    Seletor                         = new JFileChooser();
    File            ArquivoPasta;
    File            PastaAntiga;
    File            PastaNova;
    
    public EmailMontagem(ArrayList DadosEmail){
        dadosEmail          = DadosEmail;
        
        bc.codigoCliente    = (int)     dadosEmail.get(0);
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_destinatarios = new javax.swing.JTextField();
        txt_assunto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_mensagem = new javax.swing.JTextArea();
        bt_enviarEmail = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_anexos = new javax.swing.JTextField();
        bt_anexar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Enviar Email");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Destinatários:");

        txt_destinatarios.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_destinatariosFocusLost(evt);
            }
        });
        txt_destinatarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_destinatariosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_destinatariosKeyReleased(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Assunto:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Mensagem:");

        txt_mensagem.setColumns(20);
        txt_mensagem.setLineWrap(true);
        txt_mensagem.setRows(5);
        jScrollPane1.setViewportView(txt_mensagem);

        bt_enviarEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Mail.png"))); // NOI18N
        bt_enviarEmail.setText("Enviar");
        bt_enviarEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_enviarEmailActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Anexos:");

        bt_anexar.setText("Anexar");
        bt_anexar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_anexarActionPerformed(evt);
            }
        });

        jButton1.setText("Remover Anexos");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_destinatarios)
                            .addComponent(jScrollPane1)
                            .addComponent(txt_anexos)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_assunto, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 469, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_enviarEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_anexar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_sair)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_destinatarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_assunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_anexos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_enviarEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_anexar)
                        .addComponent(jButton1))
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_anexar, bt_enviarEmail, bt_sair, jButton1, jLabel1, jLabel2, jLabel3, jLabel4, txt_anexos, txt_assunto, txt_destinatarios});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_destinatariosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_destinatariosKeyPressed
        
    }//GEN-LAST:event_txt_destinatariosKeyPressed

    private void txt_destinatariosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_destinatariosKeyReleased
        if(txt_destinatarios.getText().replace(" ", "").equals("")){
            txt_destinatarios.setText("");
            length = 0;
            return;
        }
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        ValidaEmail();
        if(fatal.equals("N"))
            txt_destinatarios.setText(txt_destinatarios.getText() + "; ");
        length = txt_destinatarios.getText().length();
    }//GEN-LAST:event_txt_destinatariosKeyReleased

    private void txt_destinatariosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_destinatariosFocusLost
        if(txt_destinatarios.getText().replace(" ", "").equals("")){
            txt_destinatarios.setText("");
            length = 0;
            return;
        }
        if(txt_destinatarios.getText().replace(" ", "").substring(txt_destinatarios.getText().length() - 1, txt_destinatarios.getText().length()).equals(";"))
            return;
        ValidaEmail();
        if(fatal.equals("N"))
            txt_destinatarios.setText(txt_destinatarios.getText() + "; ");
        length = txt_destinatarios.getText().length();
    }//GEN-LAST:event_txt_destinatariosFocusLost

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(bc.codigoCliente != 0)
            PegaCliente();
    }//GEN-LAST:event_formWindowOpened

    private void bt_enviarEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_enviarEmailActionPerformed
        PegaValores();
        if(fatal.equals("S"))
            return;
        parametros.clear();
        parametros.add(destinatarioEmail);
        parametros.add(assuntoEmail);
        parametros.add(mensagemEmail);
        EmaAneEnv.EnviarEmailAnexo(parametros, dadosAnexo);
    }//GEN-LAST:event_bt_enviarEmailActionPerformed

    private void bt_anexarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_anexarActionPerformed
        Seletor = new JFileChooser("C:/");
        Seletor.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = Seletor.showOpenDialog(null);
        if(i == 1)
            return;
        ArquivoPasta = Seletor.getSelectedFile();
        if(ArquivoPasta.getPath().equals(""))
            return;
        if(parametrosNS.bbd.so.equalsIgnoreCase("Linux"))
            txt_anexos.setText(txt_anexos.getText() + ArquivoPasta.getPath().substring(ArquivoPasta.getPath().lastIndexOf("/")  + 1, ArquivoPasta.getPath().length()) + "; ");
        if(parametrosNS.bbd.so.equalsIgnoreCase("Windows"))
            txt_anexos.setText(txt_anexos.getText() + ArquivoPasta.getPath().substring(ArquivoPasta.getPath().lastIndexOf("\\") + 1, ArquivoPasta.getPath().length()) + "; ");
        dadosAnexo.add(ArquivoPasta.getPath());
    }//GEN-LAST:event_bt_anexarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txt_anexos.setText("");
        dadosAnexo.clear();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_anexar;
    private javax.swing.JButton bt_enviarEmail;
    private javax.swing.JButton bt_sair;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_anexos;
    private javax.swing.JTextField txt_assunto;
    private javax.swing.JTextField txt_destinatarios;
    private javax.swing.JTextArea txt_mensagem;
    // End of variables declaration//GEN-END:variables
    
    private void ValidaEmail(){
        fatal = "S";
        for(int i = length; i < txt_destinatarios.getText().length(); i++){
            Valida = txt_destinatarios.getText().substring(i, i + 1);
            if(Valida.equals("@")){
                fatal = "N";
                break;
            }
        }
    }
    
    private void PegaCliente(){
        sql = "select idCliente, idEmpresa, codigoGrupo, codigoEmpresa, codigoCliente, email from tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCliente = " + bc.codigoCliente + ";";
        dadosCliente.clear();
        dadosCliente = parametrosNS.dao.Consulta(sql);
        if(dadosCliente.isEmpty())
            return;
        PegaDadosCliente();
    }
    
    private void PegaDadosCliente(){
        for(int i = 0; i < dadosCliente.size(); i++){
            bc.idCliente            = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(0)));
            bc.idEmpresa            = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(1)));
            bc.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(2)));
            bc.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(3)));
            bc.codigoCliente        = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(4)));
            bc.nome                 =                    String.valueOf(dadosCliente.get(i).get(5));
        }
        if(!bc.email.equals(""))
            txt_destinatarios.setText(bc.email + "; ");
    }
    
    private void PegaValores(){
        fatal = "N";
        destinatarioEmail       = txt_destinatarios.getText();
        if(destinatarioEmail.equals("")){
            Mensagem = "Destinatários inválidos!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        assuntoEmail            = txt_assunto.getText();
        if(assuntoEmail.equals("")){
            Mensagem = "Assunto inválido, deseja encaminhar o E-mail mesmo assim?";
            if(JOptionPane.showConfirmDialog(null, Mensagem, "", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION){
                fatal = "S";
                return;
            }
        }
        mensagemEmail           = txt_mensagem.getText();
        if(mensagemEmail.equals("")){
            Mensagem = "Mensagem de E-mail inválida, deseja encaminhar o E-mail mesmo assim?";
            if(JOptionPane.showConfirmDialog(null, Mensagem, "", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION){
                fatal = "S";
                return;
            }
        }
    }
    
}
