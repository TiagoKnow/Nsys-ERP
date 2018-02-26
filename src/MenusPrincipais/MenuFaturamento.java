package MenusPrincipais;

import Telas.MenuPrincipal;
import TelasFaturamento.HistoricoListasPredefenidasCadastro;
import TelasFaturamento.ClientesCadastro;
import TelasFaturamento.ClientesConsulta;
import TelasFaturamento.RelatorioDeCliente;
import Beans.*;
import FuncoesInternas.*;
import TelasFaturamento.ContratosCadastro;
import TelasFaturamento.ContratosCobranca;
import TelasFaturamento.ManutencoesCadastro;
import TelasFaturamento.ManutencoesConsulta;
import TelasFaturamento.ContratosConsulta;
import TelasFaturamento.TransportadoraCadastro;
import TelasFaturamento.TransportadoraConsulta;
import TelasFaturamento.VeiculosCadastro;
import TelasFaturamento.VeiculosConsulta;
import Parametros.parametrosNS;
import java.sql.*;
import java.util.*;
import javax.swing.*;

/*
 @author Tiago e Paulo
 */
public class MenuFaturamento extends javax.swing.JFrame {
    //String's
    String sql                              = "";
    String sqlstate                         = "";
    String Mensagem                         = "";
    
    //Bean's
    BeanModulos                     bm      = new BeanModulos();
    
    //Vetores
    ArrayList parametros                    = new ArrayList();
    
    //Especiais
    CapturarDataHora                cdh     = new CapturarDataHora();
    FormataCampo                    fc      = new FormataCampo();
    TransformaValorStringeDouble    TransStrDou = new TransformaValorStringeDouble();
    
    //Telas
    JFrame                          Frame;
    MenuPrincipal                   MenPri;
    RelatorioDeCliente              RelDeCli;
    HistoricoListasPredefenidasCadastro     HisLisPre;
    ClientesCadastro                CadCli;
    ClientesConsulta                ConCli;
    ContratosCadastro               CadCon;
    ContratosCobranca               ConCob;
    ContratosConsulta               ConCon;
    ManutencoesCadastro             ManCad;
    ManutencoesConsulta             ManCon;
    VeiculosCadastro                VeiCad;
    VeiculosConsulta                VeiCon;
    TransportadoraCadastro          TransCad;
    TransportadoraConsulta          TransCon;
    
    public MenuFaturamento(JFrame frame){
        initComponents();
        Frame       = frame;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    private void CarregarAbas() {
        bm.abasFaturamento  = parametrosNS.bm.abasFaturamento;
        bm.abaConsultas     = bm.abasFaturamento.substring(0, 1);
        bm.abaArquivo       = bm.abasFaturamento.substring(1, 2);
        bm.abaMovimentos    = bm.abasFaturamento.substring(2, 3);
        bm.abaRelatorios    = bm.abasFaturamento.substring(3, 4);
        bm.abaParametros    = bm.abasFaturamento.substring(4, 5);
        bm.abaEspeciais     = bm.abasFaturamento.substring(5, 6);
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_rodape = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        bt_consultas = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        bt_arquivos = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        bt_movimentos = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        bt_relatorios = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        bt_parametros = new javax.swing.JMenu();
        bt_especiais = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();

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

        bt_consultas.setBackground(new java.awt.Color(255, 255, 255));
        bt_consultas.setText("Consultas");

        jMenuItem2.setText("Clientes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        bt_consultas.add(jMenuItem2);

        jMenuItem5.setText("Contratos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        bt_consultas.add(jMenuItem5);

        jMenuItem11.setText("Manutenções");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        bt_consultas.add(jMenuItem11);
        bt_consultas.add(jSeparator2);

        jMenuItem12.setText("Veículos");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        bt_consultas.add(jMenuItem12);

        jMenuItem14.setText("Transportadora");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        bt_consultas.add(jMenuItem14);

        jMenuBar1.add(bt_consultas);

        bt_arquivos.setBackground(new java.awt.Color(255, 255, 255));
        bt_arquivos.setText("Arquivos");

        jMenuItem1.setText("Cadastro de Clientes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        bt_arquivos.add(jMenuItem1);

        jMenuItem6.setText("Cadastro de Contratos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        bt_arquivos.add(jMenuItem6);

        jMenu1.setText("Cadastros");

        jMenuItem4.setText("Lista de Histórico Predefinidas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem10.setText("Manutenções");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        bt_arquivos.add(jMenu1);
        bt_arquivos.add(jSeparator1);

        jMenuItem9.setText("Veículos");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        bt_arquivos.add(jMenuItem9);

        jMenuItem13.setText("Transportadora");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        bt_arquivos.add(jMenuItem13);

        jMenuBar1.add(bt_arquivos);

        bt_movimentos.setBackground(new java.awt.Color(255, 255, 255));
        bt_movimentos.setText("Movimentos");

        jMenu2.setText("Contratos");

        jMenuItem7.setText("Cobrança");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        bt_movimentos.add(jMenu2);

        jMenuBar1.add(bt_movimentos);

        bt_relatorios.setBackground(new java.awt.Color(255, 255, 255));
        bt_relatorios.setText("Relatórios");

        jMenuItem3.setText("Clientes");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        bt_relatorios.add(jMenuItem3);

        jMenuItem8.setText("Contratos");
        bt_relatorios.add(jMenuItem8);

        jMenuBar1.add(bt_relatorios);

        bt_parametros.setBackground(new java.awt.Color(255, 255, 255));
        bt_parametros.setText("Parâmetros");
        jMenuBar1.add(bt_parametros);

        bt_especiais.setBackground(new java.awt.Color(255, 255, 255));
        bt_especiais.setText("Especiais");

        jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        jMenuItem15.setText("Mudar Usuário Atual");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        bt_especiais.add(jMenuItem15);

        jMenuBar1.add(bt_especiais);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 311, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if(ConCli != null)if(ConCli.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        ConCli = new ClientesConsulta("N");
        ConCli.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if(RelDeCli != null)if(RelDeCli.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        RelDeCli = new RelatorioDeCliente();
        RelDeCli.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(CadCli != null)if(CadCli.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        CadCli = new ClientesCadastro("N", 0);
        CadCli.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if(HisLisPre != null)if(HisLisPre.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        HisLisPre = new HistoricoListasPredefenidasCadastro();
        HisLisPre.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        if(CadCon != null)if(CadCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        parametros.add(0);
        CadCon = new ContratosCadastro(parametros);
        CadCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if(ConCon != null)if(ConCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        ConCon = new ContratosConsulta(parametros);
        ConCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        if(ManCad != null)if(ManCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        ManCad = new ManutencoesCadastro(parametros);
        ManCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        if(ManCon != null)if(ManCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        ManCon = new ManutencoesConsulta(parametros);
        ManCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        CarregarAbas();
        
        setTitle("Módulo de Faturamento: " + fc.FormataCampo(String.valueOf(parametrosNS.bge.codigoGrupo), 2, 0) + "." + parametrosNS.bge.nomeGrupo + " - " + fc.FormataCampo(String.valueOf(parametrosNS.be.CodigoEmpresa), 3, 0) + "." + parametrosNS.be.NomeEmpresa);
        
        txt_rodape.setText("Usuario: " + parametrosNS.bu.usuario);
    }//GEN-LAST:event_formWindowOpened
    
    private void Sair(){
        dispose();
        if(RelDeCli     != null)RelDeCli    .dispose();
        if(HisLisPre    != null)HisLisPre   .dispose();
        if(CadCli       != null)CadCli      .dispose();
        if(ConCli       != null)ConCli      .dispose();
        if(CadCon       != null)CadCon      .dispose();
        if(ConCob       != null)ConCob      .dispose();
        if(ConCon       != null)ConCon      .dispose();
        if(ManCad       != null)ManCad      .dispose();
        if(ManCon       != null)ManCon      .dispose();
        if(VeiCad       != null)VeiCad      .dispose();
        if(VeiCon       != null)VeiCon      .dispose();
        if(TransCad     != null)TransCad    .dispose();
        if(TransCon     != null)TransCon    .dispose();
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

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        if(VeiCad != null)if(VeiCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        VeiCad = new VeiculosCadastro(parametros);
        VeiCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        parametros.clear();
        parametros.add("N");
        if(VeiCon != null)if(VeiCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        VeiCon = new VeiculosConsulta(parametros);
        VeiCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        if(TransCad != null)if(TransCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        TransCad = new TransportadoraCadastro(parametros);
        TransCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        parametros.clear();
        parametros.add("N");
        if(TransCon != null)if(TransCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        TransCon = new TransportadoraConsulta(parametros);
        TransCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if(ConCob != null)if(ConCob.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        ConCob = new ContratosCobranca();
        ConCob.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003"))
            dispose();
    }//GEN-LAST:event_formWindowGainedFocus

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        
    }//GEN-LAST:event_jMenuItem15ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu bt_arquivos;
    private javax.swing.JMenu bt_consultas;
    private javax.swing.JMenu bt_especiais;
    private javax.swing.JMenu bt_movimentos;
    private javax.swing.JMenu bt_parametros;
    private javax.swing.JMenu bt_relatorios;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel txt_rodape;
    // End of variables declaration//GEN-END:variables
    
}
