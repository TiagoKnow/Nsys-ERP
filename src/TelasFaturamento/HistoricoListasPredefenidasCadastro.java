package TelasFaturamento;

import TelasFaturamento.ClientesConsulta;
import Beans.BeanUsuarios;
import Beans.BeanClientesHistoricoLista;
import FuncoesInternas.InverterData;
import Dao.DaoMySQL;
import FuncoesInternas.*;
import Parametros.parametrosNS;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * @author Tiago e Paulo
 */
public class HistoricoListasPredefenidasCadastro extends javax.swing.JFrame {
    //Connection 
    Connection con;
    
    //int's
    int    UltimoRegistro                       = 0;
    int    AbriuCliente                         = 0;
    
    //String's
    String sql                                  = "";
    String sqlstate                             = "";
    String fatal                                = "";
    String Mensagem                             = "";
    String operacao                             = "";
    String retorno                              = "";
    String pegouCodigoHistorico                 = "";
    
    //ArrayList's
    ArrayList            parametros                        = new ArrayList();
    ArrayList<ArrayList> dadosPredefenidas                 = new ArrayList<ArrayList>();
    
    //Bean's
    BeanClientesHistoricoLista      bchl        = new BeanClientesHistoricoLista();
    
    //Especiais
    FormataCampo                    fc          = new FormataCampo();
    InverterData                    desp        = new InverterData();
    CapturarDataHora                cdh         = new CapturarDataHora();
    PegaProximoRegistro             PegProReg   = new PegaProximoRegistro();
    
    //Telas
    ClientesConsulta                ConCli;
    
    public HistoricoListasPredefenidasCadastro(){
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_pesquisa = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_descricaoPredefenida = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_codigoPredefenido = new javax.swing.JFormattedTextField();
        bt_novo = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_dataCadastro = new javax.swing.JFormattedTextField();
        bt_incluir = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        label_alteracao = new javax.swing.JLabel();
        bt_proximo = new javax.swing.JButton();
        bt_anterior = new javax.swing.JButton();

        bt_pesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/View.png"))); // NOI18N
        bt_pesquisa.setText("Pesquisa");
        bt_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(":: Cadastro Listas Predefinidas");
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

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Detalhes");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Descrição: ");

        jLabel3.setText("Código:");

        try {
            txt_codigoPredefenido.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoPredefenido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoPredefenido.setText("     ");
        txt_codigoPredefenido.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                txt_codigoPredefenidoAncestorRemoved(evt);
            }
        });
        txt_codigoPredefenido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoPredefenidoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoPredefenidoFocusLost(evt);
            }
        });
        txt_codigoPredefenido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_codigoPredefenidoMouseClicked(evt);
            }
        });
        txt_codigoPredefenido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoPredefenidoActionPerformed(evt);
            }
        });

        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        jLabel5.setText("Data de Cadastro:");

        txt_dataCadastro.setEditable(false);
        try {
            txt_dataCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataCadastro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataCadastro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataCadastroFocusLost(evt);
            }
        });
        txt_dataCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dataCadastroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoPredefenido, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_novo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_dataCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                    .addComponent(txt_descricaoPredefenida))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_codigoPredefenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_novo)
                    .addComponent(jLabel5)
                    .addComponent(txt_dataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_descricaoPredefenida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, jLabel1, jLabel3, txt_codigoPredefenido, txt_descricaoPredefenida});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel5, txt_dataCadastro});

        bt_incluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_incluir.setText("Incluir");
        bt_incluir.setEnabled(false);
        bt_incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_incluirActionPerformed(evt);
            }
        });

        bt_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Save.png"))); // NOI18N
        bt_alterar.setText("Alterar");
        bt_alterar.setEnabled(false);
        bt_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        label_alteracao.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_alteracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_alteracao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        bt_proximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Next.png"))); // NOI18N
        bt_proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_proximoActionPerformed(evt);
            }
        });

        bt_anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Previous.png"))); // NOI18N
        bt_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_anteriorActionPerformed(evt);
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
                        .addComponent(bt_incluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_alterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_proximo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bt_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_proximo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_alterar, bt_anterior, bt_incluir});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoPredefenidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPredefenidoFocusGained
        operacao = "";
        txt_codigoPredefenido.setText("");
        HabilitaBotoes();
        ReiniciaCampos(true);
    }//GEN-LAST:event_txt_codigoPredefenidoFocusGained

    private void txt_codigoPredefenidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPredefenidoFocusLost
        if(txt_codigoPredefenido.getText().replace(" ", "").equals(""))
            return;
        txt_codigoPredefenido.setText(fc.FormataCampo(txt_codigoPredefenido.getText(), 9, 0));
        PegaHistorico();
    }//GEN-LAST:event_txt_codigoPredefenidoFocusLost

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        txt_descricaoPredefenida.grabFocus();
        ReiniciaCampos(true);
        
        bchl.codigoPredefenido  = PegProReg.PegaProximoRegistro("tb_clientes_historico_listas", "codigoPredefenido", "");
        txt_codigoPredefenido.setText(fc.FormataCampo(String.valueOf(bchl.codigoPredefenido), 9, 0));
        
        operacao = "I";
        HabilitaBotoes();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        sql = "insert into tb_clientes_historico_listas (idEmpresa, codigoGrupo, codigoEmpresa, descricaoPredefenida, dataCadastro) "
            + "values (" + bchl.idEmpresa + ", " + bchl.codigoGrupo + ", " + bchl.codigoEmpresa + ", '" + bchl.descricaoPredefenida + "', '" + bchl.dataCadastro + "');";
        
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.contains("00000"))
            return;
        txt_codigoPredefenido.grabFocus();
        VerificaUltimoRegistro();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void txt_codigoPredefenidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoPredefenidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoPredefenidoActionPerformed

    private void txt_dataCadastroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataCadastroFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dataCadastroFocusLost

    private void txt_dataCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dataCadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dataCadastroActionPerformed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        sql = "update tb_clientes_historico_listas set descricaoPredefenida = '"    + bchl.descricaoPredefenida + "' "
                                                + "where idClienteHistorico = "     + bchl.idClienteHistorico   + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoPredefenido.grabFocus();
        VerificaUltimoRegistro();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void bt_proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_proximoActionPerformed
        if(txt_codigoPredefenido.getText().replace(" ", "").equals(""))
            txt_codigoPredefenido.setText(fc.FormataCampo(txt_codigoPredefenido.getText(), 9, 0));
        bchl.codigoPredefenido    = Integer.parseInt(txt_codigoPredefenido.getText().replace(" ", ""));
        bchl.codigoPredefenido    = bchl.codigoPredefenido + 1;
        if(bchl.codigoPredefenido > UltimoRegistro){
            bchl.codigoPredefenido = UltimoRegistro;
            Mensagem = "Esse é o último registro!";
            new MostraMensagem(Mensagem);
            return;
        }
        txt_codigoPredefenido.setText(fc.FormataCampo(String.valueOf(bchl.codigoPredefenido), 9, 0));
        PegaHistorico();
    }//GEN-LAST:event_bt_proximoActionPerformed

    private void bt_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_anteriorActionPerformed
        if(txt_codigoPredefenido.getText().replace(" ", "").equals(""))
            txt_codigoPredefenido.setText(fc.FormataCampo("2", 9, 0));
        bchl.codigoPredefenido = Integer.parseInt(txt_codigoPredefenido.getText());
        bchl.codigoPredefenido = bchl.codigoPredefenido - 1;
        if(bchl.codigoPredefenido <= 0){
            bchl.codigoPredefenido = 1;
            Mensagem = "Não existe registro anterior!";
            new MostraMensagem(Mensagem);
            return;
        }
        if(bchl.codigoPredefenido > UltimoRegistro)
            bchl.codigoPredefenido = UltimoRegistro;
        txt_codigoPredefenido.setText(fc.FormataCampo(String.valueOf(bchl.codigoPredefenido), 9, 0));
        PegaHistorico();
    }//GEN-LAST:event_bt_anteriorActionPerformed

    private void txt_codigoPredefenidoAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txt_codigoPredefenidoAncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoPredefenidoAncestorRemoved

    private void txt_codigoPredefenidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_codigoPredefenidoMouseClicked
        if(evt.getClickCount() < 2)
            return;
    }//GEN-LAST:event_txt_codigoPredefenidoMouseClicked

    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        if(ConCli != null)if(ConCli.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        AbriuCliente = 1;
        ConCli = new ClientesConsulta("N");
        ConCli.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
//        if(AbriuCliente == 0)
//            return;
//        retorno = CC.getRetorno();
//        if(retorno.equals(""))
//            return;
//        txt_codigoPredefenido.setText(retorno);
//        txt_codigoPredefenido.setText(fc.FormataCampo(txt_codigoPredefenido.getText(), 0));
//        AbriuCliente = 0;
//        ConsultaCliente();
//        VerificaUltimoRegistro();
    }//GEN-LAST:event_formWindowGainedFocus

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HabilitaCampos(false);
        VerificaUltimoRegistro();
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_anterior;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisa;
    private javax.swing.JButton bt_proximo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel label_alteracao;
    private javax.swing.JFormattedTextField txt_codigoPredefenido;
    private javax.swing.JFormattedTextField txt_dataCadastro;
    private javax.swing.JTextField txt_descricaoPredefenida;
    // End of variables declaration//GEN-END:variables
    
    private void PegaHistorico() {
        bchl.codigoPredefenido = Integer.parseInt(txt_codigoPredefenido.getText());
        sql = "select * from tb_clientes_historico_listas where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoPredefenido = " + bchl.codigoPredefenido + ";";
        dadosPredefenidas.clear();
        dadosPredefenidas = parametrosNS.dao.Consulta(sql);
        if(dadosPredefenidas.isEmpty()){
            Mensagem = "Histórico " + bchl.codigoPredefenido + " não encontrado!";
            new MostraMensagem(Mensagem);
            operacao = "";
            HabilitaBotoes();
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        PegaDadosHistorico();
    }
    
    private void PegaDadosHistorico(){
        for(int i = 0; i < dadosPredefenidas.size(); i++){
            bchl = new BeanClientesHistoricoLista();
            bchl.idClienteHistorico         = Integer.parseInt(  String.valueOf(dadosPredefenidas.get(i).get(0)));
            bchl.idEmpresa                  = Integer.parseInt(  String.valueOf(dadosPredefenidas.get(i).get(1)));
            bchl.codigoGrupo                = Integer.parseInt(  String.valueOf(dadosPredefenidas.get(i).get(2)));
            bchl.codigoEmpresa              = Integer.parseInt(  String.valueOf(dadosPredefenidas.get(i).get(3)));
            bchl.codigoPredefenido          = Integer.parseInt(  String.valueOf(dadosPredefenidas.get(i).get(4)));
            bchl.descricaoPredefenida       =                    String.valueOf(dadosPredefenidas.get(i).get(5));
            bchl.dataCadastro               =                    String.valueOf(dadosPredefenidas.get(i).get(6));
        }
        ReiniciaCampos(true);
        txt_dataCadastro.setText(desp.inverterData(bchl.dataCadastro, 1));
        txt_descricaoPredefenida.setText(bchl.descricaoPredefenida);
    }
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_incluir.setEnabled(true);
            bt_alterar.setEnabled(false);
            return;
        }
        if(operacao.equals("A")){
            bt_incluir.setEnabled(false);
            bt_alterar.setEnabled(true);
            return;
        }
        bt_incluir.setEnabled(false);
        bt_alterar.setEnabled(false);
    }
    
    private void ReiniciaCampos(boolean Habilita){
        txt_dataCadastro.setText(cdh.CapturarData());
        txt_descricaoPredefenida.setText("");
        label_alteracao.setText("");
        HabilitaCampos(Habilita);
    }
    
    private void HabilitaCampos(boolean Habilita){
        txt_descricaoPredefenida.setEditable(Habilita);
    }
    
    private void PegaValores(){
        fatal = "N";
        bchl.idEmpresa              = parametrosNS.be.IdEmpresa;
        bchl.codigoGrupo            = parametrosNS.bge.CodigoGrupo;
        bchl.codigoEmpresa          = parametrosNS.be.CodigoEmpresa;
        bchl.codigoPredefenido      = Integer.parseInt(txt_codigoPredefenido.getText());
        bchl.descricaoPredefenida   = txt_descricaoPredefenida.getText();
        if(bchl.descricaoPredefenida.equals("")){
            Mensagem = "Descrição inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bchl.dataCadastro           = desp.inverterData(txt_dataCadastro.getText(), 2);
    }
    
    private void VerificaUltimoRegistro(){
        sql = "select max(codigoPredefenido) from tb_clientes_historico_listas where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosPredefenidas.clear();
        dadosPredefenidas = parametrosNS.dao.Consulta(sql);
        UltimoRegistro = Integer.parseInt(  String.valueOf(dadosPredefenidas.get(0).get(0)));
    }
    
}
