package TelasDeConfiguracoes;

import BeansNS.BeanBancoDados;
import FuncoesInternas.Criptografia;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import Main.BarraInicial;
import Main.ProcessoInicial;
import Telas.Login;
import java.util.ArrayList;
/*
 @author Tiago e Paulo
 */
public class SalvarBancoDeDados extends javax.swing.JFrame {
    //String's
    String sql                      = "";
    String sqlstate                 = "";
    String Mensagem                 = "";
    String operacao                 = "";
    String fatal                    = "";
    String Tipo                     = "";
    
    //Especiais
    FormataCampo            fc      = new FormataCampo();
    Criptografia            crpt    = new Criptografia();
    
    //ArrayList's
    ArrayList<ArrayList>    dadosBancoDados     = new ArrayList<ArrayList>();
    
    //Bean's
    BeanBancoDados          bbd     = new BeanBancoDados();
    
    //Dao
    daoSQLITE               dlite;
    
    //Telas
    BarraInicial            Bar;
    ProcessoInicial         ProIni;
    Login                   lg;
    
    public SalvarBancoDeDados(String tipo){
        Tipo    = tipo;
        
        initComponents();
        PegaBancoDados();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_gravar = new javax.swing.JButton();
        combo_conexao = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_servidor = new javax.swing.JTextField();
        txt_porta = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_banco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        combo_so = new javax.swing.JComboBox<>();
        txt_senha = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurações de Banco de Dados");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        bt_gravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_gravar.setText("Gravar");
        bt_gravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_gravarActionPerformed(evt);
            }
        });

        combo_conexao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----------", "MySql", "SqLite", "Firebird", "SQL Server" }));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Conexão:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Servidor:");

        try {
            txt_porta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_porta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_porta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_portaFocusLost(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Banco:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Usuário:");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Senha:");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Sistema Operacional:");

        combo_so.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----------", "Windows", "Linux", "Mac" }));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_usuario, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_servidor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_so, 0, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_porta, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combo_conexao, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_banco, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_gravar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(256, 256, 256)
                        .addComponent(jButton1)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel3, jLabel6});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel5, jLabel7});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {combo_conexao, txt_banco, txt_senha});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_conexao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(combo_so, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_servidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_porta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txt_banco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_gravar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel5, jLabel6, jLabel7, txt_senha, txt_servidor, txt_usuario});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {combo_conexao, txt_banco});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_gravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_gravarActionPerformed
        if(operacao.equals("I")){
            IncluirBancoDados();
            return;
        }
        AlterarBancoDados();
    }//GEN-LAST:event_bt_gravarActionPerformed

    private void txt_portaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_portaFocusLost
        if(txt_porta.getText().replace(" ", "").equals(""))
            return;
        txt_porta.setText(fc.FormataCampo(txt_porta.getText(), 4, 0));
    }//GEN-LAST:event_txt_portaFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(!Tipo.equalsIgnoreCase("Login"))
            return;
        Bar     = new BarraInicial();
        ProIni  = new ProcessoInicial(Bar);
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_gravar;
    private javax.swing.JComboBox<String> combo_conexao;
    private javax.swing.JComboBox<String> combo_so;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txt_banco;
    private javax.swing.JFormattedTextField txt_porta;
    private javax.swing.JPasswordField txt_senha;
    private javax.swing.JTextField txt_servidor;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
    
    private void PegaValores(){
        fatal = "N";
        if(combo_so.getSelectedIndex() == 0){
            Mensagem = "Sistema Operacional inválido!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bbd.so          = String.valueOf(combo_so.getSelectedItem());
        if(combo_conexao.getSelectedIndex() == 0){
            Mensagem = "Conexão inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bbd.conexao     = combo_conexao.getSelectedIndex();
        bbd.servidor    = txt_servidor.getText();
        if(bbd.servidor.equals("")){
            Mensagem = "Servidor inválido!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        if(txt_porta.getText().replace(" ", "").equals("")){
            Mensagem = "Porta inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bbd.porta       = Integer.parseInt(txt_porta.getText().replace(" ", ""));
        bbd.nomeBanco   = txt_banco.getText();
        if(bbd.nomeBanco.equals("")){
            Mensagem = "Nome do Banco inválido!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bbd.usuario     = txt_usuario.getText();
        if(bbd.usuario.equals("")){
            Mensagem = "Usuário inválido!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bbd.senha       = txt_senha.getText();
        if(bbd.senha.equals("")){
            Mensagem = "Senha inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
    }
    
    private void IncluirBancoDados(){
        PegaValores();
        if(fatal.equals("S"))
            return;
        sql = "insert into nsconfig (so, conexao, servidor, porta, nomeBanco, usuario, senha) "
            + "values ('" + bbd.so + "', '" + bbd.conexao + "', '" + bbd.servidor + "', '" + bbd.porta + "', '" + bbd.nomeBanco + "', '" + bbd.usuario + "', '" + bbd.senha + "');";
        dlite = new daoSQLITE();
        sqlstate = dlite.IncluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        dispose();
    }
    
    private void AlterarBancoDados(){
        PegaValores();
        if(fatal.equals("S"))
            return;
        sql = "update nsconfig set so = '"          + bbd.so        + "', "
                                + "conexao = '"     + bbd.conexao   + "', "
                                + "servidor = '"    + bbd.servidor  + "', "
                                + "porta = '"       + bbd.porta     + "', "
                                + "nomeBanco = '"   + bbd.nomeBanco + "', "
                                + "usuario = '"     + bbd.usuario   + "', "
                                + "senha = '"       + bbd.senha     + "';";
        dlite = new daoSQLITE();
        sqlstate = dlite.AlterarRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        dispose();
    }
    
    private void PegaBancoDados(){
        dlite = new daoSQLITE();
        sql = "select * from nsconfig;";
        dadosBancoDados.clear();
        dadosBancoDados = dlite.Consulta(sql);
        if(dadosBancoDados.isEmpty()){
            operacao = "I";
            return;
        }
        operacao = "A";
        PegaDadosBancoDados();
    }
    
    private void PegaDadosBancoDados(){
        for(int i = 0; i < dadosBancoDados.size(); i++){
            bbd.so              =                    String.valueOf(dadosBancoDados.get(i).get(0));
            bbd.conexao         = Integer.parseInt(  String.valueOf(dadosBancoDados.get(i).get(1)));
            bbd.servidor        =                    String.valueOf(dadosBancoDados.get(i).get(2));
            bbd.porta           = Integer.parseInt(  String.valueOf(dadosBancoDados.get(i).get(3)));
            bbd.nomeBanco       =                    String.valueOf(dadosBancoDados.get(i).get(4));
            bbd.usuario         =                    String.valueOf(dadosBancoDados.get(i).get(5));
            bbd.senha           =                    String.valueOf(dadosBancoDados.get(i).get(6));
        }
        combo_so        .setSelectedItem    (bbd.so);
        combo_conexao   .setSelectedIndex   (bbd.conexao);
        txt_servidor    .setText            (bbd.servidor);
        txt_porta       .setText            (fc.FormataCampo(String.valueOf(bbd.porta), 4, 0));
        txt_banco       .setText            (bbd.nomeBanco);
        txt_usuario     .setText            (bbd.usuario);
        txt_senha       .setText            (bbd.senha);
    }
    
}
