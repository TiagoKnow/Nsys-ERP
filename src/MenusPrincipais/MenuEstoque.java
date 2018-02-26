package MenusPrincipais;

import Telas.MenuPrincipal;
import Parametros.ParametrosEstoque;
import Beans.*;
import FuncoesInternas.*;
import TelasEstoque.*;
import TelasVendas.FormasDePagamentoCadastro;
import Parametros.parametrosNS;
import TelasEstoque.FabricanteCadastro;
import TelasEstoque.FabricanteConsulta;
import TelasEstoque.FornecedorCadastro;
import TelasEstoque.FornecedorConsulta;
import TelasEstoque.GeradorEtiquetas;
import TelasEstoque.GrupoProdutoCadastro;
import TelasEstoque.GrupoProdutoConsulta;
import TelasEstoque.ProdutosCadastro;
import TelasEstoque.ProdutosConsulta;
import TelasEstoque.SubGrupoProdutoCadastro;
import TelasEstoque.SubGrupoProdutoConsulta;
import TelasVendas.FormasDePagamentoConsulta;
import java.util.*;
import javax.swing.*;

/**
 * @author Tiago e Paulo 15/03/2016 11:33
 */
public class MenuEstoque extends javax.swing.JFrame {
    //String's
    String sql                      = "";
    String sqlstate                 = "";
    String Mensagem                 = "";
    
    //Bean's
    BeanUsuarios            bu      = new BeanUsuarios();
    BeanModulos             bm      = new BeanModulos();
    
    //ArrayList's padroes não alterar
    ArrayList parametros            = new ArrayList();
    
    //Especiais
    CapturarDataHora        cdh     = new CapturarDataHora();
    FormataCampo            fc      = new FormataCampo();
    
    //Telas
    JFrame                      Frame;
    MenuPrincipal               MenPri;
    ProdutosCadastro            ProCad;
    ProdutosConsulta            ProCon;
    GrupoProdutoCadastro        ProCadGru;
    GrupoProdutoConsulta        ProConGru;
    SubGrupoProdutoCadastro     SubGruProCad;
    SubGrupoProdutoConsulta     SubGruProCon;
    FabricanteCadastro          FabCad;
    FabricanteConsulta          FabCon;
    FornecedorCadastro          ForCad;
    FornecedorConsulta          ForCon;
    FormasDePagamentoCadastro   ForDePagCad;
    FormasDePagamentoConsulta   ForDePagCon;
    ParametrosEstoque           ParEst;
    
    public MenuEstoque(JFrame frame){
        initComponents();
        Frame       = frame;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    private void CarregarAbas() {
        bm.abasEstoque      = parametrosNS.bm.abasEstoque;
        bm.abaConsultas     = bm.abasEstoque.substring(0, 1);
        bm.abaArquivo       = bm.abasEstoque.substring(1, 2);
        bm.abaMovimentos    = bm.abasEstoque.substring(2, 3);
        bm.abaRelatorios    = bm.abasEstoque.substring(3, 4);
        bm.abaParametros    = bm.abasEstoque.substring(4, 5);
        bm.abaEspeciais     = bm.abasEstoque.substring(5, 6);
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
        jMenu2 = new javax.swing.JMenu();
        bt_pesquisaProdutos = new javax.swing.JMenuItem();
        bt_pesquisaGruposDeProdutos = new javax.swing.JMenuItem();
        bt_pesquisaSubGruposDeProdutos = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        bt_arquivos = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        bt_gerarEtiquetas = new javax.swing.JMenuItem();
        bt_movimentos = new javax.swing.JMenu();
        bt_relatorios = new javax.swing.JMenu();
        bt_parametros = new javax.swing.JMenu();
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

        jMenu2.setText("Produtos");

        bt_pesquisaProdutos.setText("Consulta Produtos");
        bt_pesquisaProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaProdutosActionPerformed(evt);
            }
        });
        jMenu2.add(bt_pesquisaProdutos);

        bt_pesquisaGruposDeProdutos.setText("Grupos de Produtos");
        bt_pesquisaGruposDeProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaGruposDeProdutosActionPerformed(evt);
            }
        });
        jMenu2.add(bt_pesquisaGruposDeProdutos);

        bt_pesquisaSubGruposDeProdutos.setText("SubGrupos de Produtos");
        bt_pesquisaSubGruposDeProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaSubGruposDeProdutosActionPerformed(evt);
            }
        });
        jMenu2.add(bt_pesquisaSubGruposDeProdutos);

        bt_consultas.add(jMenu2);

        jMenuItem2.setText("Formas de pagamentos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        bt_consultas.add(jMenuItem2);

        jMenuItem9.setText("Fornecedores");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        bt_consultas.add(jMenuItem9);

        jMenuItem8.setText("Fabricantes");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        bt_consultas.add(jMenuItem8);

        jMenuBar1.add(bt_consultas);

        bt_arquivos.setBackground(new java.awt.Color(255, 255, 255));
        bt_arquivos.setText("Arquivos");

        jMenu1.setText("Produtos");

        jMenuItem1.setText("Cadastrar Produtos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setText("Grupos de Produtos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem5.setText("Sub Grupos de Produtos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        bt_arquivos.add(jMenu1);

        jMenuItem4.setText("Formas de pagamentos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        bt_arquivos.add(jMenuItem4);

        jMenuItem6.setText("Fornecedores");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        bt_arquivos.add(jMenuItem6);

        jMenuItem7.setText("Fabricantes");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        bt_arquivos.add(jMenuItem7);

        bt_gerarEtiquetas.setText("Gerador de etiquetas (Código de barras)");
        bt_gerarEtiquetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_gerarEtiquetasActionPerformed(evt);
            }
        });
        bt_arquivos.add(bt_gerarEtiquetas);

        jMenuBar1.add(bt_arquivos);

        bt_movimentos.setBackground(new java.awt.Color(255, 255, 255));
        bt_movimentos.setText("Movimentos");
        jMenuBar1.add(bt_movimentos);

        bt_relatorios.setBackground(new java.awt.Color(255, 255, 255));
        bt_relatorios.setText("Relatórios");
        jMenuBar1.add(bt_relatorios);

        bt_parametros.setBackground(new java.awt.Color(255, 255, 255));
        bt_parametros.setText("Parâmetros");
        jMenuBar1.add(bt_parametros);

        bt_especiais.setBackground(new java.awt.Color(255, 255, 255));
        bt_especiais.setText("Especiais");
        jMenuBar1.add(bt_especiais);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 311, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(ProCad != null)if(ProCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        ProCad = new ProdutosCadastro("N", 0);
        ProCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if(ProCadGru != null)if(ProCadGru.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        ProCadGru = new GrupoProdutoCadastro("N", 0);
        ProCadGru.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if(ForDePagCad != null)if(ForDePagCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        ForDePagCad = new FormasDePagamentoCadastro("N" ,0);
        ForDePagCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if(SubGruProCad != null)if(SubGruProCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        SubGruProCad = new SubGrupoProdutoCadastro("N", 0, 0);
        SubGruProCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        if(ForCad != null)if(ForCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        ForCad = new FornecedorCadastro("N", 0);
        ForCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if(FabCad != null)if(FabCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        FabCad = new FabricanteCadastro("N", 0);
        FabCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        if(FabCon != null)if(FabCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        FabCon = new FabricanteConsulta("N");
        FabCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        if(ForCon != null)if(ForCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        ForCon = new FornecedorConsulta("N");
        ForCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void bt_pesquisaProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaProdutosActionPerformed
        if(ProCon != null)if(ProCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add("Codigo");
        ProCon = new ProdutosConsulta(parametros);
        ProCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaProdutosActionPerformed

    private void bt_pesquisaSubGruposDeProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaSubGruposDeProdutosActionPerformed
        if(SubGruProCon != null)if(SubGruProCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        SubGruProCon = new SubGrupoProdutoConsulta("N");
        SubGruProCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaSubGruposDeProdutosActionPerformed

    private void bt_pesquisaGruposDeProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaGruposDeProdutosActionPerformed
        if(ProConGru != null)if(ProConGru.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        ProConGru = new GrupoProdutoConsulta("N");
        ProConGru.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaGruposDeProdutosActionPerformed
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        CarregarAbas();
        
        setTitle("Módulo de Estoque: " + fc.FormataCampo(String.valueOf(parametrosNS.bge.CodigoGrupo), 2, 0) + "." + parametrosNS.bge.NomeGrupo + " - " + fc.FormataCampo(String.valueOf(parametrosNS.be.CodigoEmpresa), 3, 0) + "." + parametrosNS.be.NomeEmpresa);
        
        txt_rodape.setText("Usuario: " + parametrosNS.bu.usuario);
    }//GEN-LAST:event_formWindowOpened
    
    private void Sair(){
        dispose();
        if(ProCad          != null)ProCad          .dispose();
        if(ProCon          != null)ProCon          .dispose();
        if(ProCadGru       != null)ProCadGru       .dispose();
        if(ProConGru       != null)ProConGru       .dispose();
        if(SubGruProCad    != null)SubGruProCad    .dispose();
        if(SubGruProCon    != null)SubGruProCon    .dispose();
        if(FabCad          != null)FabCad          .dispose();
        if(FabCon          != null)FabCon          .dispose();
        if(ForCad          != null)ForCad          .dispose();
        if(ForCon          != null)ForCon          .dispose();
        if(ForDePagCad     != null)ForDePagCad     .dispose();
        if(ParEst          != null)ParEst          .dispose();
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

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003"))
            dispose();
    }//GEN-LAST:event_formWindowGainedFocus

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if(ForDePagCon   != null)if(ForDePagCon.isVisible()){
            Mensagem = "Tela ja Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        ForDePagCon = new FormasDePagamentoConsulta("N");
        ForDePagCon.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void bt_gerarEtiquetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_gerarEtiquetasActionPerformed
        GeradorEtiquetas ger = new GeradorEtiquetas("", "", 0, "");
        ger.setVisible(true);
    }//GEN-LAST:event_bt_gerarEtiquetasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu bt_arquivos;
    private javax.swing.JMenu bt_consultas;
    private javax.swing.JMenu bt_especiais;
    private javax.swing.JMenuItem bt_gerarEtiquetas;
    private javax.swing.JMenu bt_movimentos;
    private javax.swing.JMenu bt_parametros;
    private javax.swing.JMenuItem bt_pesquisaGruposDeProdutos;
    private javax.swing.JMenuItem bt_pesquisaProdutos;
    private javax.swing.JMenuItem bt_pesquisaSubGruposDeProdutos;
    private javax.swing.JMenu bt_relatorios;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txt_rodape;
    // End of variables declaration//GEN-END:variables
    
}
