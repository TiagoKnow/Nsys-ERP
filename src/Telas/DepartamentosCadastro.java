package Telas;

import BeansNS.BeanGrupoEmpresa;
import java.sql.Connection;
import java.util.ArrayList;
import Beans.*;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import Dao.*;
import FuncoesInternas.*;
import Main.BarraInicial;
import Main.ProcessoInicial;
import Parametros.parametrosNS;
/*
 @author Tiago e Paulo
 */
public class DepartamentosCadastro extends javax.swing.JFrame {
    //String's
    String sql                                  = "";
    String sqlstate                             = "";
    String fatal                                = "";
    String somostra                             = "";
    String Mensagem                             = "";
    String retorno                              = "";
    String operacao                             = "";
    String Tipo                                 = "";
    
    //int's
    int    UltimoRegistro                       = 0;
    int    abriuDepartamento                    = 0;
    
    //ArrayList's
    ArrayList            parametros                        = new ArrayList();
    ArrayList<ArrayList> dadosDepartamentos                = new ArrayList<ArrayList>();
    ArrayList            dadosPadroes                      = new ArrayList();
    
    //Bean's
    BeanGrupoEmpresa                bge         = new BeanGrupoEmpresa();
    BeanDepartamento                bd          = new BeanDepartamento();
    
    //Especiais
    FormataCampo                    fc          = new FormataCampo();
    PegaProximoRegistro             PegProReg   = new PegaProximoRegistro();
    
    //Telas
    BarraInicial                    Bar;
    ProcessoInicial                 ProIni;
    DepartamentosConsulta           ConDep;
    
    public DepartamentosCadastro(ArrayList DadosPadroes){
        dadosPadroes = DadosPadroes;
        
        somostra                = (String)  dadosPadroes.get(0);
        Tipo                    = (String)  dadosPadroes.get(1);
        bd.codigoDepartamento   = (int)     dadosPadroes.get(2);
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_excluir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        bt_novo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_descricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_codigoDepartamento = new javax.swing.JFormattedTextField();
        bt_alterar = new javax.swing.JButton();
        bt_incluir = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        bt_pesquisaDepartamentos = new javax.swing.JButton();

        bt_excluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Delete.png"))); // NOI18N
        bt_excluir.setText("Excluir");
        bt_excluir.setEnabled(false);
        bt_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluirActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cadastro de Departamento");
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

        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Código: ");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Descrição: ");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cadastro de Departamento");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_codigoDepartamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoDepartamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoDepartamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoDepartamentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoDepartamentoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_novo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txt_descricao))
                .addContainerGap())
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, jLabel1, jLabel2, txt_codigoDepartamento, txt_descricao});

        bt_alterar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Save.png"))); // NOI18N
        bt_alterar.setText("Alterar");
        bt_alterar.setEnabled(false);
        bt_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterarActionPerformed(evt);
            }
        });

        bt_incluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_incluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_incluir.setText("Incluir");
        bt_incluir.setEnabled(false);
        bt_incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_incluirActionPerformed(evt);
            }
        });

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        bt_pesquisaDepartamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/View.png"))); // NOI18N
        bt_pesquisaDepartamentos.setText("Pesquisa");
        bt_pesquisaDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaDepartamentosActionPerformed(evt);
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
                        .addComponent(bt_incluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_alterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_pesquisaDepartamentos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_sair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaDepartamentos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_alterar, bt_incluir, bt_pesquisaDepartamentos, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        ReiniciaCampos();
        HabilitaCampos(true);
        
        bd.codigoDepartamento = PegProReg.PegaProximoRegistro("tb_departamento", "codigoDepartamento", "");
        txt_codigoDepartamento.setText(fc.FormataCampo(String.valueOf(bd.codigoDepartamento), 2, 0));
        
        operacao = "I";
        HabilitaBotoes();
        txt_descricao.grabFocus();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void bt_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluirActionPerformed
        bd.codigoDepartamento   = Integer.parseInt(txt_codigoDepartamento.getText().replace(" ", ""));
        if(JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir o registro n° " + bd.codigoDepartamento + "?") != JOptionPane.YES_OPTION)
            return;
        sql = "delete from tb_departamento where idDepartamento = " + bd.idDepartamento + ";";
        sqlstate = parametrosNS.dao.ExcluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoDepartamento.grabFocus();
    }//GEN-LAST:event_bt_excluirActionPerformed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        sql = "update tb_departamento set descricaoDepartamento = '" + bd.descricaoDepartamento + "' where idDepartamento = " + bd.idDepartamento + ";";
        
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");

        if(!sqlstate.equals("00000"))
            return;
        txt_codigoDepartamento.grabFocus();
    }//GEN-LAST:event_bt_alterarActionPerformed
    
    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        sql = "insert into tb_departamento (idEmpresa, codigoGrupo, codigoEmpresa, codigoDepartamento, descricaoDepartamento) "
            + "values (" + bd.idEmpresa + ", " + bd.codigoGrupo + ", " + bd.codigoEmpresa + ", " + bd.codigoDepartamento + ", '" + bd.descricaoDepartamento + "')";

        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoDepartamento.grabFocus();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
        if(!Tipo.equalsIgnoreCase("Login"))
            return;
        Sair();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_pesquisaDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaDepartamentosActionPerformed
        if(ConDep != null)if(ConDep.isVisible()){
            Mensagem = "Tela já Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuDepartamento = 1;
        ConDep = new DepartamentosConsulta("S");
        ConDep.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaDepartamentosActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
        if(abriuDepartamento == 0)
            return;
        retorno = ConDep.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoDepartamento.setText(retorno);
        abriuDepartamento = 0;
        PegaDepartamento();
    }//GEN-LAST:event_formWindowGainedFocus

    private void txt_codigoDepartamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoDepartamentoFocusGained
        if(txt_codigoDepartamento.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        operacao = "";
        ReiniciaCampos();
        HabilitaBotoes();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoDepartamentoFocusGained

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HabilitaCampos(false);
        if(bd.codigoDepartamento != 0){
            txt_codigoDepartamento.setText(String.valueOf(bd.codigoDepartamento));
            PegaDepartamento();
        }
        if(somostra.equals("S")){
            txt_codigoDepartamento  .setEditable(false);
            bt_pesquisaDepartamentos.setVisible (false);
            bt_novo                 .setEnabled (false);
            bt_incluir              .setVisible (false);
            bt_alterar              .setVisible (false);
            bt_excluir              .setVisible (false);
        }
    }//GEN-LAST:event_formWindowOpened

    private void txt_codigoDepartamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoDepartamentoFocusLost
        if(txt_codigoDepartamento.isEditable() == false)
            return;
        if(txt_codigoDepartamento.getText().replace(" ", "").equals(""))
            return;
        PegaDepartamento();
    }//GEN-LAST:event_txt_codigoDepartamentoFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_excluir;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisaDepartamentos;
    private javax.swing.JButton bt_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txt_codigoDepartamento;
    private javax.swing.JTextField txt_descricao;
    // End of variables declaration//GEN-END:variables
    
    public void ReiniciaCampos(){
        txt_codigoDepartamento.setText("");
        txt_descricao.setText("");
    }
    
    private void HabilitaCampos(boolean Habilita){
        txt_descricao.setEditable(Habilita);
    }
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_incluir      .setEnabled     (true);
            bt_incluir      .setFocusable   (true);
            bt_alterar      .setEnabled     (false);
            bt_alterar      .setFocusable   (false);
            bt_excluir      .setEnabled     (false);
            bt_excluir      .setFocusable   (false);
            return;
        }
        if(operacao.equals("A")){
            bt_incluir      .setEnabled     (false);
            bt_incluir      .setFocusable   (false);
            bt_alterar      .setEnabled     (true);
            bt_alterar      .setFocusable   (true);
            bt_excluir      .setEnabled     (true);
            bt_excluir      .setFocusable   (true);
            return;
        }
        bt_incluir          .setEnabled     (false);
        bt_incluir          .setFocusable   (false);
        bt_alterar          .setEnabled     (false);
        bt_alterar          .setFocusable   (false);
        bt_excluir          .setEnabled     (false);
        bt_excluir          .setFocusable   (false);
    }
    
    private void PegaValores(){
        fatal = "N";
        bd.idEmpresa                = parametrosNS.be.IdEmpresa;
        bd.codigoGrupo              = parametrosNS.bge.CodigoGrupo;
        bd.codigoEmpresa            = parametrosNS.be.CodigoEmpresa;
        bd.codigoDepartamento       = Integer.parseInt(txt_codigoDepartamento.getText());
        bd.descricaoDepartamento    = txt_descricao.getText();
        if(bd.descricaoDepartamento.equals("")){
            Mensagem = "Descrição inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
//            return;
        }
    }
    
    public void PegaDepartamento(){
        txt_codigoDepartamento.setText(fc.FormataCampo(txt_codigoDepartamento.getText(), 2, 0));
        bd.codigoDepartamento = Integer.parseInt(txt_codigoDepartamento.getText());
        if(bd.codigoDepartamento == 0)
            return;
        sql = "select * from tb_departamento where idEmpresa = " + parametrosNS.be.IdEmpresa+ " and codigoDepartamento = " + bd.codigoDepartamento + ";";
        dadosDepartamentos.clear();
        dadosDepartamentos = parametrosNS.dao.Consulta(sql);
        if(dadosDepartamentos.isEmpty()){
            Mensagem = "Departemtno n°" + bd.codigoDepartamento + " não cadastrado!!!";
            new MostraMensagem(Mensagem);
            txt_codigoDepartamento.grabFocus();
            fatal = "S";
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        HabilitaCampos(true);
        PegaDadosDepartamento();
    }
    
    public void PegaDadosDepartamento(){
        for(int i = 0; i < dadosDepartamentos.size(); i++){
            bd = new BeanDepartamento();
            bd.idDepartamento           = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(0)));
            bd.idEmpresa                = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(1)));
            bd.codigoGrupo              = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(2)));
            bd.codigoEmpresa            = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(3)));
            bd.codigoDepartamento       = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(4)));
            bd.descricaoDepartamento    =                    String.valueOf(dadosDepartamentos.get(i).get(5));
        }
        txt_descricao.setText(bd.descricaoDepartamento);
    }
    
    private void Sair(){
        Bar     = new BarraInicial();
        ProIni  = new ProcessoInicial(Bar);
    }
    
}
