package MenusPrincipais;

import Telas.MenuPrincipal;
import Beans.*;
import FuncoesInternas.*;
import TelasContabil.BalanceteContabilPorEmpresa;
import Telas.Senha;
import TelasContabil.PlanoDeContasCadastro;
import TelasContabil.PlanoDeContasConsulta;
import TelasContabil.PlanoReferencialConsulta;
import TelasContabil.ImportarTabelaPlanoReferencial;
import TelasContabil.MovimentoContabilConsulta;
import TelasContabil.RelacionamentoContabil;
import TelasContabil.SelecionarDataDoSistemaContabil;
import Parametros.parametrosNS;
import java.util.*;
import javax.swing.*;
/*
 @author Tiago e Paulo
 */
public class MenuContabil extends javax.swing.JFrame {
    //String's
    String sql                              = "";
    String sqlstate                         = "";
    String Mensagem                         = "";
    String retorno                          = "";
    
    //int's
    int    User                             = 0;
    int    abriuSenhaSistema                = 0;
    int    abriuDataContabil                = 0;
    
    //Vetores
    ArrayList            parametros                    = new ArrayList<Object>();
    ArrayList<ArrayList> dadosParametrosContabil       = new ArrayList<ArrayList>();
    
    //Bean's
    BeanModulos                     bm      = new BeanModulos();
    BeanParametrosContabil          bparcon = new BeanParametrosContabil();
    
    //Especiais
    CapturarDataHora                cdh     = new CapturarDataHora();
    FormataCampo                    fc      = new FormataCampo();
    InverterData                    invdata = new InverterData();
    
    //Telas
    JFrame                          Frame;
    Senha                           senha;
    MenuPrincipal                   MenPri;
    BalanceteContabilPorEmpresa     BalConPorEmp;
    PlanoReferencialConsulta        ConPlaRef;
    ImportarTabelaPlanoReferencial  ImpTabPlaRef;
    PlanoDeContasCadastro           CadPlaDeCon;
    PlanoDeContasConsulta           ConPlaDeCon;
    RelacionamentoContabil          RelCon;
    MovimentoContabilConsulta       MovConCon;
    SelecionarDataDoSistemaContabil SelDatDoSisCon;
    
    public MenuContabil(JFrame frame){
        initComponents();
        Frame       = frame;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    private void CarregarAbas() {
        bm.abasContabil     = parametrosNS.bm.abasContabil;
        bm.abaConsultas     = bm.abasContabil.substring(0, 1);
        bm.abaArquivo       = bm.abasContabil.substring(1, 2);
        bm.abaMovimentos    = bm.abasContabil.substring(2, 3);
        bm.abaRelatorios    = bm.abasContabil.substring(3, 4);
        bm.abaParametros    = bm.abasContabil.substring(4, 5);
        bm.abaEspeciais     = bm.abasContabil.substring(5, 6);
        VerificaAbas();
    }
    
    private void VerificaAbas(){
        if(bm.abaConsultas .equals("0"))bt_consultas .setVisible(false);
        if(bm.abaArquivo   .equals("0"))bt_arquivos  .setVisible(false);
        if(bm.abaMovimentos.equals("0"))bt_movimentos.setVisible(false);
        if(bm.abaRelatorios.equals("0"))bt_relatorios.setVisible(false);
        if(bm.abaParametros.equals("0"))bt_parametros.setVisible(false);
        if(bm.abaEspeciais .equals("0"))bt_especiais .setVisible(false);
    }
    
    private void PegaParametrosContabil(){
        sql = "select * from tb_parametroscontabil where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosParametrosContabil.clear();
        dadosParametrosContabil = parametrosNS.dao.Consulta(sql);
        if(dadosParametrosContabil.isEmpty()){
            bparcon.dataContabil    = cdh.CapturarData();
            txt_dataContabil.setText(bparcon.dataContabil);
            return;
        }
        PegaDadosParametrosContabil();
    }
    
    private void PegaDadosParametrosContabil(){
        for(int i = 0; i < dadosParametrosContabil.size(); i++){
            if(dadosParametrosContabil.get(i).get(0) != null)
                bparcon.idParametrosContabil    = Integer.parseInt(  String.valueOf(dadosParametrosContabil.get(i).get(0)));
            if(dadosParametrosContabil.get(i).get(1) != null)
                bparcon.idEmpresa               = Integer.parseInt(  String.valueOf(dadosParametrosContabil.get(i).get(1)));
            if(dadosParametrosContabil.get(i).get(2) != null)
                bparcon.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosParametrosContabil.get(i).get(2)));
            if(dadosParametrosContabil.get(i).get(3) != null)
                bparcon.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosParametrosContabil.get(i).get(3)));
            if(dadosParametrosContabil.get(i).get(4) != null)
                bparcon.dataContabil            =                    String.valueOf(dadosParametrosContabil.get(i).get(4));
        }
        if(!bparcon.dataContabil.equals(""))
            bparcon.dataContabil    = invdata.inverterData(bparcon.dataContabil, 1);
        txt_dataContabil        .setText(bparcon.dataContabil);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_rodape = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_dataContabil = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        bt_consultas = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        bt_arquivos = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        bt_movimentos = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        bt_relatorios = new javax.swing.JMenu();
        bt_parametros = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        bt_especiais = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_rodape.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_rodape.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_rodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txt_rodape, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/logo-top.png"))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mudar [F11]");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Data Contábil");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
        );

        txt_dataContabil.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txt_dataContabil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_dataContabil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_dataContabil, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel3, jPanel4});

        bt_consultas.setBackground(new java.awt.Color(255, 255, 255));
        bt_consultas.setText("Consultas");

        jMenu2.setText("Planos");

        jMenuItem4.setText("Plano de Contas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        bt_consultas.add(jMenu2);

        jMenuBar1.add(bt_consultas);

        bt_arquivos.setBackground(new java.awt.Color(255, 255, 255));
        bt_arquivos.setText("Arquivos");

        jMenuItem3.setText("Plano de Contas");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        bt_arquivos.add(jMenuItem3);
        bt_arquivos.add(jSeparator1);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        jMenuItem6.setText("Mudar data Contábil");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        bt_arquivos.add(jMenuItem6);

        jMenuBar1.add(bt_arquivos);

        bt_movimentos.setBackground(new java.awt.Color(255, 255, 255));
        bt_movimentos.setText("Movimentos");

        jMenuItem5.setText("Movimentos Contábil");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        bt_movimentos.add(jMenuItem5);

        jMenuItem7.setText("Balancete Contábil");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        bt_movimentos.add(jMenuItem7);

        jMenuBar1.add(bt_movimentos);

        bt_relatorios.setBackground(new java.awt.Color(255, 255, 255));
        bt_relatorios.setText("Relatórios");
        jMenuBar1.add(bt_relatorios);

        bt_parametros.setBackground(new java.awt.Color(255, 255, 255));
        bt_parametros.setText("Parâmetros");

        jMenuItem2.setText("Relacionamento Contábil");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        bt_parametros.add(jMenuItem2);

        jMenuBar1.add(bt_parametros);

        bt_especiais.setBackground(new java.awt.Color(255, 255, 255));
        bt_especiais.setText("Especiais");

        jMenu1.setText("Importação");

        jMenuItem1.setText("Importar Plano Referencial 2016");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        bt_especiais.add(jMenu1);

        jMenuBar1.add(bt_especiais);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        abriuSenhaSistema = 1;
        AbreSenhaDoSistema();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){
            dispose();
            return;
        }
        if(abriuSenhaSistema == 0){
            AbriuDataContabil();
            return;
        }
        abriuSenhaSistema = 0;
        retorno = senha.getRetorno();
        if(!retorno.equalsIgnoreCase("OK")){
            return;
        }
        ImpTabPlaRef = new ImportarTabelaPlanoReferencial();
        ImpTabPlaRef.setVisible(true);
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbriuDataContabil(){
        if(abriuDataContabil == 0){
            return;
        }
        abriuDataContabil = 0;
        PegaParametrosContabil();
        jMenuItem7.setText("Balancete Contábil " + bparcon.dataContabil.replace("/", "").substring(4, 8));
    }
    
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if(CadPlaDeCon != null)if(CadPlaDeCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add("");
        CadPlaDeCon = new PlanoDeContasCadastro(parametros);
        CadPlaDeCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        parametros.clear();
        parametros.add("N");
        ConPlaDeCon = new PlanoDeContasConsulta(parametros);
        ConPlaDeCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        CarregarAbas();
        PegaParametrosContabil();
        jMenuItem7.setText("Balancete Contábil " + bparcon.dataContabil.replace("/", "").substring(4, 8));
        
        setTitle("Módulo Contábil: " + fc.FormataCampo(String.valueOf(parametrosNS.bge.CodigoGrupo), 2, 0) + "." + parametrosNS.bge.NomeGrupo + " - " + fc.FormataCampo(String.valueOf(parametrosNS.be.CodigoEmpresa), 3, 0) + "." + parametrosNS.be.NomeEmpresa);
        
        txt_rodape.setText("Usuario: " + parametrosNS.bu.usuario);
    }//GEN-LAST:event_formWindowOpened
    
    private void Sair(){
        dispose();
        if(ConPlaRef    != null)ConPlaRef   .dispose();
        if(ImpTabPlaRef != null)ImpTabPlaRef.dispose();
        if(CadPlaDeCon  != null)CadPlaDeCon .dispose();
        if(ConPlaDeCon  != null)ConPlaDeCon .dispose();
        if(RelCon       != null)RelCon      .dispose();
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){
            Frame.setVisible(false);
            MenPri = new MenuPrincipal();
            MenPri.setVisible(true);
            return;
        }
//        Frame.setVisible(true);
    }
    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Sair();
    }//GEN-LAST:event_formWindowClosed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if(RelCon != null)if(RelCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        RelCon = new RelacionamentoContabil();
        RelCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if(MovConCon != null)if(MovConCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        MovConCon = new MovimentoContabilConsulta(parametros);
        MovConCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        if(SelDatDoSisCon != null)if(SelDatDoSisCon.isVisible()){
            Mensagem = "Tela já Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuDataContabil = 1;
        SelDatDoSisCon = new SelecionarDataDoSistemaContabil();
        SelDatDoSisCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if(BalConPorEmp != null)if(BalConPorEmp.isVisible()){
            Mensagem = "Tela já Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        BalConPorEmp = new BalanceteContabilPorEmpresa(parametros);
        BalConPorEmp.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu bt_arquivos;
    private javax.swing.JMenu bt_consultas;
    private javax.swing.JMenu bt_especiais;
    private javax.swing.JMenu bt_movimentos;
    private javax.swing.JMenu bt_parametros;
    private javax.swing.JMenu bt_relatorios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel txt_dataContabil;
    private javax.swing.JLabel txt_rodape;
    // End of variables declaration//GEN-END:variables
    
    private void AbreSenhaDoSistema(){
        senha = new Senha("");
        senha.setVisible(true);
    }
    
}
