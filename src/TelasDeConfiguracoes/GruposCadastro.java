package TelasDeConfiguracoes;

import Main.*;
import BeansNS.BeanBancoDados;
import BeansNS.BeanGrupoEmpresa;
import Beans.BeanVariaveisDeDiretorio;
import FuncoesInternas.*;
import Telas.Senha;
import Parametros.parametrosNS;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/*
 @author Tiago e Paulo
 */
public class GruposCadastro extends javax.swing.JFrame {
    //int's
    int abriuCodigo = 0;
    int abriuSenha  = 0;
    int Liberou     = 0;
    
    //String's
    String   sql                    = "";
    String   sqlstate               = "00000";
    String   mensagem               = "";
    String   fatal                  = "N";
    String   Tipo                   = "";
    String   retorno                = "";
    String   operacao               = "I";
    String   operacaoBancoDeDados   = "I";
    
    //ArrayList's
    ArrayList            parametros         = new ArrayList();
    ArrayList<ArrayList> dadosGrupos        = new ArrayList<ArrayList>();
    
    //bean's
    BeanBancoDados              bbd     = new BeanBancoDados();
    BeanGrupoEmpresa            bge     = new BeanGrupoEmpresa();
    BeanVariaveisDeDiretorio    bvdir   = new BeanVariaveisDeDiretorio();
    
    //Especiais
    FormataCampo                fc      = new FormataCampo();
    Criptografia                crpt    = new Criptografia();
    JFileChooser                Seletor = new JFileChooser();
    File                        ArquivoPasta;
    
    //telas
    BarraInicial            Bar;
    ProcessoInicial         ProIni;
    Senha                   Senha;
    GruposConsulta          GruCon;
    
    public GruposCadastro(String tipo){
        initComponents();
        Tipo    = tipo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_grupo = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_descricao = new javax.swing.JTextField();
        bt_confirma = new javax.swing.JButton();
        bt_novo = new javax.swing.JButton();
        bt_pesquisa = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txt_limiteusuarios = new javax.swing.JFormattedTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(":: Cadastro de Grupos");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Grupo: ");

        try {
            txt_grupo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_grupo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_grupo.setText("00");
        txt_grupo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_grupoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_grupoFocusLost(evt);
            }
        });
        txt_grupo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_grupoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_grupoKeyReleased(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Descrição: ");

        txt_descricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_descricaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_descricaoFocusLost(evt);
            }
        });

        bt_confirma.setText("Confirma");
        bt_confirma.setEnabled(false);
        bt_confirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmaActionPerformed(evt);
            }
        });

        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        bt_pesquisa.setText("Pesquisa");
        bt_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaActionPerformed(evt);
            }
        });

        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Limite de Usuarios: ");

        try {
            txt_limiteusuarios.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_limiteusuarios.setEditable(false);
        try {
            txt_limiteusuarios.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_limiteusuarios.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_limiteusuarios.setText("0020");
        txt_limiteusuarios.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_limiteusuariosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_limiteusuariosFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_limiteusuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(407, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txt_limiteusuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel19, txt_limiteusuarios});

        jTabbedPane1.addTab("Informações do Grupo", jPanel2);

        jMenu1.setText("Arquivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        jMenuItem1.setText("Liberar Campos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        jMenuItem2.setText("Sair");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_confirma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_pesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_sair))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_descricao)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_novo)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_grupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_novo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_confirma)
                    .addComponent(bt_pesquisa)
                    .addComponent(bt_sair))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, jLabel1, txt_grupo});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, txt_descricao});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_grupoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_grupoFocusLost
        if(txt_grupo.isEditable() == false)
            return;
        if(txt_grupo.getText().replace(" ", "").equals(""))
            return;
        PegaGrupo();
    }//GEN-LAST:event_txt_grupoFocusLost
    
    private void bt_confirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmaActionPerformed
        PegaValoresGrupo();
        ConfirmarGravacaoOuAlteracao();
        if(fatal.equals("S"))
            return;
        if(operacao.equals("I")){IncluirArquivo();     }else{AlteraArquivo();}
    }//GEN-LAST:event_bt_confirmaActionPerformed

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        bge.codigoGrupo = parametrosNS.dao.ConsultaAutoIncremento("ns_grupoempresa");
        txt_grupo.setText(fc.FormataCampo(String.valueOf(bge.codigoGrupo), 2, 0));
        
        ReiniciaCampos();
        
        operacao                = "I";
        operacaoBancoDeDados    = "I";
        bt_confirma.setEnabled(true);
    }//GEN-LAST:event_bt_novoActionPerformed

    private void txt_grupoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_grupoKeyPressed
        
    }//GEN-LAST:event_txt_grupoKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
        if(abriuCodigo == 0){
            AbreSenha();
            return;
        }
        retorno = GruCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_grupo.setText(String.valueOf(retorno));
        PegaGrupo();
        abriuCodigo = 0;
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbreSenha(){
        if(abriuSenha == 0)
            return;
        abriuSenha = 0;
        retorno = Senha.getRetorno();
        if(!retorno.equalsIgnoreCase("OK"))
            return;
        Liberou = 1;
        txt_limiteusuarios  .setEditable(true);
        txt_limiteusuarios  .grabFocus();
    }
    
    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        abriuCodigo = 1;
        GruCon = new GruposConsulta();
        GruCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void txt_grupoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_grupoFocusGained
        txt_grupo.setSelectionStart(0);
        txt_grupo.setSelectionEnd  (txt_grupo.getText().length());
        ReiniciaCampos();
    }//GEN-LAST:event_txt_grupoFocusGained

    private void txt_grupoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_grupoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_grupoKeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(Senha    != null)Senha   .dispose();
        if(GruCon   != null)GruCon  .dispose();
    }//GEN-LAST:event_formWindowClosed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        Sair();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void txt_limiteusuariosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_limiteusuariosFocusGained
        txt_limiteusuarios.setSelectionStart(0);
        txt_limiteusuarios.setSelectionEnd  (txt_limiteusuarios.getText().length());
    }//GEN-LAST:event_txt_limiteusuariosFocusGained

    private void txt_limiteusuariosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_limiteusuariosFocusLost
        
    }//GEN-LAST:event_txt_limiteusuariosFocusLost

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(Senha != null)if(Senha.isVisible()){
            mensagem = "Tela já Aberta!";
            mostraMensagem();
            return;
        }
        abriuSenha  = 1;
        Senha = new Senha("");
        Senha.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Sair();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txt_descricaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_descricaoFocusLost
        
    }//GEN-LAST:event_txt_descricaoFocusLost

    private void txt_descricaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_descricaoFocusGained
        
    }//GEN-LAST:event_txt_descricaoFocusGained
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_confirma;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisa;
    private javax.swing.JButton bt_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txt_descricao;
    private javax.swing.JFormattedTextField txt_grupo;
    private javax.swing.JFormattedTextField txt_limiteusuarios;
    // End of variables declaration//GEN-END:variables
    
    private void mostraMensagem() {
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    private void ReiniciaCampos(){
        bge = new BeanGrupoEmpresa();
        bbd = new BeanBancoDados();
        bt_confirma         .setEnabled (false);
        txt_descricao       .setText    ("");
        txt_limiteusuarios  .setText    (fc.FormataCampo("20", 4, 0));
    }

    private void ConfirmarGravacaoOuAlteracao() {
        fatal = "S";
        if(operacao.equals("I")){
            if(JOptionPane.showConfirmDialog(null, "Confirma Gravação?", "", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION)
                return;
        }else{
            if(JOptionPane.showConfirmDialog(null, "Confirma Alteração?", "", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION)
                return;
        }
        fatal = "N";
    }
    
    private void PegaValoresGrupo(){
        fatal = "N";
        bge.codigoGrupo      = Integer.parseInt(txt_grupo.getText().replace(" ", ""));
        bge.nomeGrupo = txt_descricao.getText();
        if(bge.nomeGrupo.equals("")) {
            mensagem = "Descrição inválida!!!";
            mostraMensagem();
            fatal = "S";
            return;
        }
        bge.limiteUsuarios          = Integer.parseInt(txt_limiteusuarios.getText().replace(" ", ""));
    }

    private void IncluirArquivo() {
        if(fatal.equals("S"))
            return;
        sql = "insert into ns_grupoempresa (nomeGrupo, limiteUsuarios) "
            + "values ('" + bge.nomeGrupo + "', " + bge.limiteUsuarios + ");";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        mensagem = "Registro Incluído com Sucesso!";
        mostraMensagem();
    }
    
    private void AlteraArquivo(){
        if(fatal.equals("S"))
            return;
        sql = "update ns_grupoempresa set nomeGrupo = '"                + bge.nomeGrupo                 + "', " +
                                         "limiteUsuarios = "            + bge.limiteUsuarios            + " "   +
                                         "where codigoGrupo = "         + bge.codigoGrupo               + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        mensagem = "Registro Alterado com Sucesso!";
        mostraMensagem();
    }
    
    private void PegaGrupo(){
        fatal = "N";
        txt_grupo.setText(fc.FormataCampo(txt_grupo.getText(), 2, 0));
        bge.codigoGrupo = Integer.parseInt(txt_grupo.getText());
        if(bge.codigoGrupo == 0)
             return;
        sql = "select * from ns_grupoempresa where codigoGrupo = " + bge.codigoGrupo + ";";
        dadosGrupos.clear();
        dadosGrupos = parametrosNS.dao.Consulta(sql);
        if(dadosGrupos.isEmpty()){
            mensagem = "Grupo " + bge.codigoGrupo + " não Encontrado!";
            mostraMensagem();
            fatal = "S";
            return;
        }
        operacao = "A";
        PreencherCampos();
    }
    
    private void PreencherCampos(){
        for(int i = 0; i < dadosGrupos.size(); i++){
            bge.codigoGrupo             = Integer.parseInt( String.valueOf(dadosGrupos.get(i).get(0)));
            bge.nomeGrupo               =                   String.valueOf(dadosGrupos.get(i).get(1));
            bge.limiteUsuarios          = Integer.parseInt( String.valueOf(dadosGrupos.get(i).get(2)));
        }
        txt_descricao                   .setText(bge.nomeGrupo);
        txt_limiteusuarios              .setText(fc.FormataCampo(String.valueOf(bge.limiteUsuarios), 4, 0));
        bt_confirma                     .setEnabled(true);
    }
    
    private void Sair(){
        dispose();
        if(!Tipo.equalsIgnoreCase("Login"))
            return;
        Bar     = new BarraInicial();
        ProIni  = new ProcessoInicial(Bar);
    }
    
}
