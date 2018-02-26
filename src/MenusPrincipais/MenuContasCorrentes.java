package MenusPrincipais;

import Telas.MenuPrincipal;
import Beans.*;
import FuncoesInternas.*;
import Parametros.ParametrosCC;
import Telas.BancosConsulta;
import TelasContasCorrente.BoletosConsulta;
import TelasContasCorrente.ContaCorrenteCadastro;
import TelasContasCorrente.ContaCorrenteConsulta;
import TelasContasCorrente.GerarBoletoBradesco;
import TelasContasCorrente.GerarBoletoHsbc;
import TelasContasCorrente.ProcessarArquivoRemessa;
import TelasContasCorrente.GerarBoletoItau;
import TelasContasCorrente.GerarBoletoSantander;
import TelasContasCorrente.InstrucoesDeBoletosCadastro;
import TelasContasCorrente.InstrucoesDeBoletosConsulta;
import TelasContasCorrente.ProcessarArquivoRetorno;
import Parametros.parametrosNS;
import TelasContasCorrente.GerarBoletosPorGrupo;
import java.util.*;
import javax.swing.*;

/*
 @author Tiago e Paulo
 */
public class MenuContasCorrentes extends javax.swing.JFrame {
    //String's
    String sql                      = "";
    String sqlstate                 = "";
    String Mensagem                 = "";
    
    //Bean's
    BeanModulos             bm      = new BeanModulos();
    
    //ArrayList's padroes não alterar
    ArrayList parametros            = new ArrayList();
    
    //Especiais
    CapturarDataHora        cdh     = new CapturarDataHora();
    FormataCampo            fc      = new FormataCampo();
    
    //Telas
    JFrame                      Frame;
    MenuPrincipal               MenPri;
    BancosConsulta              BanCon;
    BoletosConsulta             BolCon;
    ContaCorrenteCadastro       ConCorCad;
    ContaCorrenteConsulta       ConCorCon;
    InstrucoesDeBoletosCadastro InsBolCad;
    InstrucoesDeBoletosConsulta InsBolCon;
    GerarBoletoBradesco         GerBolBrad;
    GerarBoletoItau             GerBolItau;
    GerarBoletoHsbc             GerBolHsbc;
    GerarBoletoSantander        GerBolSant;
    ProcessarArquivoRemessa     ProArqRemItau;
    ProcessarArquivoRetorno     ProArqRetItau;
    ParametrosCC                ParConCor;
    GerarBoletosPorGrupo        GerBolPorGru;
    
    public MenuContasCorrentes(JFrame frame){
        initComponents();
        Frame       = frame;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    private void CarregarAbas() {
        bm.abasCC           = parametrosNS.bm.abasCC;
        bm.abaConsultas     = bm.abasCC.substring(0, 1);
        bm.abaArquivo       = bm.abasCC.substring(1, 2);
        bm.abaMovimentos    = bm.abasCC.substring(2, 3);
        bm.abaRelatorios    = bm.abasCC.substring(3, 4);
        bm.abaParametros    = bm.abasCC.substring(4, 5);
        bm.abaEspeciais     = bm.abasCC.substring(5, 6);
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
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem10 = new javax.swing.JMenuItem();
        bt_arquivos = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        bt_movimentos = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jMenu13 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenu14 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu15 = new javax.swing.JMenu();
        jMenu16 = new javax.swing.JMenu();
        jMenu17 = new javax.swing.JMenu();
        bt_relatorios = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        bt_parametros = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        bt_especiais = new javax.swing.JMenu();

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
            .addComponent(txt_rodape, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
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

        jMenuItem2.setText("Conta Corrente (Consulta)");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        bt_consultas.add(jMenuItem2);

        jMenu2.setText("Boletos");

        jMenuItem6.setText("Boletos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem4.setText("Intruções");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        bt_consultas.add(jMenu2);
        bt_consultas.add(jSeparator1);

        jMenuItem10.setText("Bancos");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        bt_consultas.add(jMenuItem10);

        jMenuBar1.add(bt_consultas);

        bt_arquivos.setBackground(new java.awt.Color(255, 255, 255));
        bt_arquivos.setText("Arquivos");

        jMenuItem1.setText("Conta Corrente (Cadastro)");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        bt_arquivos.add(jMenuItem1);

        jMenu1.setText("Boletos");

        jMenuItem3.setText("Intruções (Cadastro)");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        bt_arquivos.add(jMenu1);

        jMenuBar1.add(bt_arquivos);

        bt_movimentos.setBackground(new java.awt.Color(255, 255, 255));
        bt_movimentos.setText("Movimentos");

        jMenu3.setText("Boleto (Gerar)");

        jMenu4.setText("Itaú");

        jMenuItem5.setText("Cobrança 109 (Sem registro)");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenu3.add(jMenu4);

        jMenu5.setText("HSBC");

        jMenuItem11.setText("HSBC Cobrança");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);

        jMenu3.add(jMenu5);

        jMenu6.setText("Santander");

        jMenuItem12.setText("Santander Cobrança");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem12);

        jMenu3.add(jMenu6);

        jMenu7.setText("Bradesco");

        jMenuItem13.setText("Bradesco Cobrança");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem13);

        jMenu3.add(jMenu7);

        bt_movimentos.add(jMenu3);

        jMenu8.setText("Processar Arquivo de Remessa");

        jMenu10.setText("Itaú");

        jMenuItem7.setText("Cobrança 109 (Sem registro)");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem7);

        jMenu8.add(jMenu10);

        jMenu11.setText("HSBC");
        jMenu8.add(jMenu11);

        jMenu12.setText("Santander");
        jMenu8.add(jMenu12);

        jMenu13.setText("Bradesco");
        jMenu8.add(jMenu13);

        bt_movimentos.add(jMenu8);

        jMenu9.setText("Processar Arquivo de Retorno");

        jMenu14.setText("Itaú");

        jMenuItem8.setText("Cobrança 109 (Sem registro)");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem8);

        jMenu9.add(jMenu14);

        jMenu15.setText("HSBC");
        jMenu9.add(jMenu15);

        jMenu16.setText("Santander");
        jMenu9.add(jMenu16);

        jMenu17.setText("Bradesco");
        jMenu9.add(jMenu17);

        bt_movimentos.add(jMenu9);

        jMenuBar1.add(bt_movimentos);

        bt_relatorios.setBackground(new java.awt.Color(255, 255, 255));
        bt_relatorios.setText("Relatórios");

        jMenuItem14.setText("Imprimir boletos por grupo");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        bt_relatorios.add(jMenuItem14);

        jMenuBar1.add(bt_relatorios);

        bt_parametros.setBackground(new java.awt.Color(255, 255, 255));
        bt_parametros.setText("Parâmetros");

        jMenuItem9.setText("Parâmetros de Contas Correntes");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        bt_parametros.add(jMenuItem9);

        jMenuBar1.add(bt_parametros);

        bt_especiais.setBackground(new java.awt.Color(255, 255, 255));
        bt_especiais.setText("Especiais");
        jMenuBar1.add(bt_especiais);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(ConCorCad   != null)if(ConCorCad.isVisible()){
            Mensagem = "Tela ja Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        ConCorCad = new ContaCorrenteCadastro("N", 0);
        ConCorCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if(ConCorCon   != null)if(ConCorCon.isVisible()){
            Mensagem = "Tela ja Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        ConCorCon = new ContaCorrenteConsulta("N");
        ConCorCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if(InsBolCad   != null)if(InsBolCad.isVisible()){
            Mensagem = "Tela ja Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        InsBolCad = new InstrucoesDeBoletosCadastro("N", 0);
        InsBolCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if(InsBolCon   != null)if(InsBolCon.isVisible()){
            Mensagem = "Tela ja Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        InsBolCon = new InstrucoesDeBoletosConsulta("N");
        InsBolCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if(GerBolItau   != null)if(GerBolItau.isVisible()){
            Mensagem = "Tela ja Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        parametros.add(0);
        parametros.add("Boleto");
        GerBolItau = new GerarBoletoItau(parametros);
        GerBolItau.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        if(BolCon   != null)if(BolCon.isVisible()){
            Mensagem = "Tela ja Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add("N");
        parametros.add("");
        parametros.add("");
        BolCon = new BoletosConsulta(parametros);
        BolCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        if(ParConCor   != null)if(ParConCor.isVisible()){
            Mensagem = "Tela ja Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        ParConCor = new ParametrosCC();
        ParConCor.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        if(BanCon   != null)if(BanCon.isVisible()){
            Mensagem = "Tela ja Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        BanCon = new BancosConsulta();
        BanCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        if(GerBolHsbc   != null)if(GerBolHsbc.isVisible()){
            Mensagem = "Tela ja Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        parametros.add(0);
        GerBolHsbc = new GerarBoletoHsbc(parametros);
        GerBolHsbc.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        CarregarAbas();
        
        setTitle("Módulo Contas Correntes: " + fc.FormataCampo(String.valueOf(parametrosNS.bge.CodigoGrupo), 2, 0) + "." + parametrosNS.bge.NomeGrupo + " - " + fc.FormataCampo(String.valueOf(parametrosNS.be.CodigoEmpresa), 3, 0) + "." + parametrosNS.be.NomeEmpresa);
        
        txt_rodape.setText("Usuario: " + parametrosNS.bu.usuario);
    }//GEN-LAST:event_formWindowOpened
    
    private void Sair(){
        dispose();
        if(BanCon           != null)BanCon          .dispose();
        if(BolCon           != null)BolCon          .dispose();
        if(ConCorCad        != null)ConCorCad       .dispose();
        if(ConCorCon        != null)ConCorCon       .dispose();
        if(InsBolCad        != null)InsBolCad       .dispose();
        if(InsBolCon        != null)InsBolCon       .dispose();
        if(GerBolItau       != null)GerBolItau      .dispose();
        if(GerBolHsbc       != null)GerBolHsbc      .dispose();
        if(GerBolSant       != null)GerBolSant      .dispose();
        if(ProArqRemItau    != null)ProArqRemItau   .dispose();
        if(ProArqRetItau    != null)ProArqRetItau   .dispose();
        if(ParConCor        != null)ParConCor       .dispose();
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

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        if(GerBolSant   != null)if(GerBolSant.isVisible()){
            Mensagem = "Tela ja Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        parametros.add(0);
        parametros.add("Boleto");
        GerBolSant = new GerarBoletoSantander(parametros);
        GerBolSant.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        if(GerBolBrad   != null)if(GerBolBrad.isVisible()){
            Mensagem = "Tela ja Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        parametros.add(0);
        parametros.add("Boleto");
        GerBolBrad = new GerarBoletoBradesco(parametros);
        GerBolBrad.setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003"))
            dispose();
    }//GEN-LAST:event_formWindowGainedFocus

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if(ProArqRemItau   != null)if(ProArqRemItau.isVisible()){
            Mensagem = "Tela ja Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("341");
        parametros.add("N");
        parametros.add("N");
        ProArqRemItau = new ProcessarArquivoRemessa(parametros);
        ProArqRemItau.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        if(ProArqRetItau    != null)if(ProArqRetItau.isVisible()){
            Mensagem = "Tela ja Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        ProArqRetItau = new ProcessarArquivoRetorno();
        ProArqRetItau.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        if(GerBolPorGru != null)if(GerBolPorGru.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        GerBolPorGru = new GerarBoletosPorGrupo();
        GerBolPorGru.setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu bt_arquivos;
    private javax.swing.JMenu bt_consultas;
    private javax.swing.JMenu bt_especiais;
    private javax.swing.JMenu bt_movimentos;
    private javax.swing.JMenu bt_parametros;
    private javax.swing.JMenu bt_relatorios;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
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
    private javax.swing.JLabel txt_rodape;
    // End of variables declaration//GEN-END:variables
}
