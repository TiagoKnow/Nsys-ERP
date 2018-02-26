package TelasContasCorrente;

import Beans.BeanBoletosInstrucoes;
import BeansNS.BeanEmpresas;
import Dao.DaoMySQL;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import Parametros.parametrosNS;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 @author Tiago e Paulo
 */
public class InstrucoesDeBoletosConsulta extends javax.swing.JFrame {
    //int's
    int     Linha                       = 0;
    int     abriuBoletosInstrucoes      = 0;
    
    //String's
    String  sql                         = "";
    String  sqlstate                    = "";
    String  somostra                    = "";
    String  Mensagem                    = "";
    String  retorno                     = "";
    
    //Vetores
    ArrayList            parametros                = new ArrayList();
//    ArrayList            dadosPadroes              = new ArrayList();
    ArrayList<ArrayList> dadosBoletosInstrucoes    = new ArrayList<ArrayList>();
    
    //Bean's
    BeanBoletosInstrucoes       bbi     = new BeanBoletosInstrucoes();
    
    //Especiais
    FormataCampo                fc      = new FormataCampo();
    DefaultTableModel           TableBoletosInstrucoes;
    
    //Telas
    InstrucoesDeBoletosCadastro InsBolCad;
    
    public InstrucoesDeBoletosConsulta(String Somostra){
        somostra                        = Somostra;
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_detalhes = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_instrucoes = new javax.swing.JTable();
        txt_codigoBoletoInstrucao = new javax.swing.JFormattedTextField();
        txt_descricaoInstrucao = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair2 = new javax.swing.JMenuItem();

        bt_detalhes.setText("Detalhes");
        bt_detalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_detalhesActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_detalhes);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Instruções de Boletos Bancários");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consulta Instruções de Boletos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_instrucoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Instrução"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_instrucoes.getTableHeader().setReorderingAllowed(false);
        tabela_instrucoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_instrucoesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_instrucoes);
        if (tabela_instrucoes.getColumnModel().getColumnCount() > 0) {
            tabela_instrucoes.getColumnModel().getColumn(0).setResizable(false);
            tabela_instrucoes.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabela_instrucoes.getColumnModel().getColumn(1).setResizable(false);
            tabela_instrucoes.getColumnModel().getColumn(1).setPreferredWidth(480);
        }

        try {
            txt_codigoBoletoInstrucao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoBoletoInstrucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoBoletoInstrucaoKeyReleased(evt);
            }
        });

        txt_descricaoInstrucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_descricaoInstrucaoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoBoletoInstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_descricaoInstrucao)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoBoletoInstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_descricaoInstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        bt_sair2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        bt_sair2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair2.setText("Sair");
        bt_sair2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sair2ActionPerformed(evt);
            }
        });
        jMenu1.add(bt_sair2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabela_instrucoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_instrucoesMouseClicked
        Linha   = tabela_instrucoes.getSelectedRow();
        if(Linha < 0){
            Mensagem = "Item não selecionado!";
            new MostraMensagem(Mensagem);
            return;
        }
        if(evt.getButton() == MouseEvent.BUTTON3)
            if(somostra.equals("N"))
                MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
        retorno = String.valueOf(Integer.parseInt(String.valueOf(tabela_instrucoes.getValueAt(Linha, 0))));
        if(evt.getClickCount()> 1)
            dispose();
    }//GEN-LAST:event_tabela_instrucoesMouseClicked

    private void bt_detalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesActionPerformed
        if(InsBolCad   != null)if(InsBolCad.isVisible()){
            Mensagem = "Tela ja Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuBoletosInstrucoes = 1;
        InsBolCad = new InstrucoesDeBoletosCadastro("S", Integer.parseInt(retorno));
        InsBolCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesActionPerformed

    private void txt_codigoBoletoInstrucaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoBoletoInstrucaoKeyReleased
        if(txt_codigoBoletoInstrucao.getText().replace(" ", "").equals("")){
            sql = "select * from tb_boletos_instrucoes where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaBoletosInstrucoes();
            return;
        }
        bbi.codigoBoletoInstrucao   = Integer.parseInt(txt_codigoBoletoInstrucao.getText().replace(" ", ""));
        sql = "select * from tb_boletos_instrucoes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoBoletoInstrucao = " + bbi.codigoBoletoInstrucao + ";";
        PegaBoletosInstrucoes();
    }//GEN-LAST:event_txt_codigoBoletoInstrucaoKeyReleased

    private void txt_descricaoInstrucaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descricaoInstrucaoKeyReleased
        bbi.descricaoInstrucao      = txt_descricaoInstrucao.getText();
        if(bbi.descricaoInstrucao.equals("")){
            sql = "select * from tb_boletos_instrucoes where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaBoletosInstrucoes();
            return;
        }
        sql = "select * from tb_boletos_instrucoes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and  descricaoInstrucao like '%" + bbi.descricaoInstrucao + "%';";
        PegaBoletosInstrucoes();
    }//GEN-LAST:event_txt_descricaoInstrucaoKeyReleased

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
        if(abriuBoletosInstrucoes == 0)
            return;
        sql = "select * from tb_boletos_instrucoes where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        PegaBoletosInstrucoes();
    }//GEN-LAST:event_formWindowGainedFocus

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bt_sair2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair2ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        TableBoletosInstrucoes   = (DefaultTableModel)tabela_instrucoes.getModel();
        sql = "select * from tb_boletos_instrucoes where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        PegaBoletosInstrucoes();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(InsBolCad    != null)InsBolCad.dispose();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_detalhes;
    private javax.swing.JMenuItem bt_sair2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_instrucoes;
    private javax.swing.JFormattedTextField txt_codigoBoletoInstrucao;
    private javax.swing.JTextField txt_descricaoInstrucao;
    // End of variables declaration//GEN-END:variables
    
    public String getRetornoBoletoInstrucoes(){
        return retorno;
    }
    
    private void PegaBoletosInstrucoes(){
        dadosBoletosInstrucoes.clear();
        dadosBoletosInstrucoes = parametrosNS.dao.Consulta(sql);
        PegaDadosBoletosInstrucoes();
    }
    
    private void PegaDadosBoletosInstrucoes(){
        TableBoletosInstrucoes.setNumRows(0);
        for(int i = 0; i < dadosBoletosInstrucoes.size(); i++){
            bbi.idBoletoInstrucao       = Integer.parseInt(  String.valueOf(dadosBoletosInstrucoes.get(i).get(0)));
            bbi.idEmpresa               = Integer.parseInt(  String.valueOf(dadosBoletosInstrucoes.get(i).get(1)));
            bbi.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosBoletosInstrucoes.get(i).get(2)));
            bbi.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosBoletosInstrucoes.get(i).get(3)));
            bbi.codigoBoletoInstrucao   = Integer.parseInt(  String.valueOf(dadosBoletosInstrucoes.get(i).get(4)));
            bbi.descricaoInstrucao      =                    String.valueOf(dadosBoletosInstrucoes.get(i).get(5));
            bbi.primeiraInstrucao       =                    String.valueOf(dadosBoletosInstrucoes.get(i).get(6));
            bbi.segundaInstrucao        =                    String.valueOf(dadosBoletosInstrucoes.get(i).get(7));
            bbi.terceiraInstrucao       =                    String.valueOf(dadosBoletosInstrucoes.get(i).get(8));
            
            TableBoletosInstrucoes.addRow(new Object [] {fc.FormataCampo(String.valueOf(bbi.codigoBoletoInstrucao), 2, 0), bbi.descricaoInstrucao});
        }
    }
    
}
