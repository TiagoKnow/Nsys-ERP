package TelasVendas;

import Beans.BeanCaixaMotivoSaida;
import Dao.DaoMySQL;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import Parametros.parametrosNS;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/*
 @author Tiago e Paulo
 */
public class MotivosDeSaidaDeCaixaConsulta extends javax.swing.JFrame {
    //String's
    String sql      = "";
    String Mensagem = "";
    String somostra = "";
    String retorno  = "";
    
    //int's
    int    linha        = 0;
    int    abriuMotivos = 0;
    
    //Vetores
    ArrayList            parametros            = new ArrayList();
    ArrayList            dadosPadroes          = new ArrayList();
    ArrayList<ArrayList> dadosMotivoSaida      = new ArrayList<ArrayList>();
    
    //Bean's
    BeanCaixaMotivoSaida    bcms    = new BeanCaixaMotivoSaida();
    
    //Especiais
    FormataCampo      fc      = new FormataCampo();
    DefaultTableModel Table;
    
    //Telas
    MotivosDeSaidaDeCaixaCadastro   MotSaiCaiCad;
    
    public MotivosDeSaidaDeCaixaConsulta(ArrayList DadosPadroes) {
        dadosPadroes                = DadosPadroes;
        
        somostra                    = (String)  dadosPadroes.get(0);
        
        initComponents();
    }
    
    private void PegaMotivosDeSaidaDeCaixa(){
        linha = 0;
        dadosMotivoSaida.clear();
        dadosMotivoSaida = parametrosNS.dao.Consulta(sql);
        PegaDadosMotivosDeSaidaDeCaixa();
    }
    
    private void PegaDadosMotivosDeSaidaDeCaixa(){
        Table.setNumRows(0);
        for(int i = 0; i < dadosMotivoSaida.size(); i++){
            bcms.idMotivoSaida          = Integer.parseInt(  String.valueOf(dadosMotivoSaida.get(i).get(0)));
            bcms.idEmpresa              = Integer.parseInt(  String.valueOf(dadosMotivoSaida.get(i).get(1)));
            bcms.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosMotivoSaida.get(i).get(2)));
            bcms.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosMotivoSaida.get(i).get(3)));
            bcms.codigoMotivoSaida      = Integer.parseInt(  String.valueOf(dadosMotivoSaida.get(i).get(4)));
            bcms.descricaoMotivoSaida   =                    String.valueOf(dadosMotivoSaida.get(i).get(5));
            
            Table.addRow(new Object [] {fc.FormataCampo(String.valueOf(bcms.codigoMotivoSaida), 3, 0), bcms.descricaoMotivoSaida});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_detalhesItem = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_motivoSaida = new javax.swing.JTable();
        txt_codigoMotivoSaida = new javax.swing.JFormattedTextField();
        txt_descricaoMotivoSaida = new javax.swing.JTextField();
        bt_sair = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        br_sair1 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        bt_cadastroSaidaDeCaixa = new javax.swing.JMenuItem();
        bt_sair1 = new javax.swing.JMenuItem();

        bt_detalhesItem.setText("Detalhes");
        bt_detalhesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_detalhesItemActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_detalhesItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Motivo de Saida de Caixa");
        setResizable(false);
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consulta Movitos de Saida de Caixa");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_motivoSaida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição do Motivo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_motivoSaida.getTableHeader().setReorderingAllowed(false);
        tabela_motivoSaida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_motivoSaidaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_motivoSaida);
        if (tabela_motivoSaida.getColumnModel().getColumnCount() > 0) {
            tabela_motivoSaida.getColumnModel().getColumn(1).setResizable(false);
            tabela_motivoSaida.getColumnModel().getColumn(1).setPreferredWidth(350);
        }

        try {
            txt_codigoMotivoSaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoMotivoSaida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoMotivoSaida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoMotivoSaidaKeyReleased(evt);
            }
        });

        txt_descricaoMotivoSaida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_descricaoMotivoSaidaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoMotivoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_descricaoMotivoSaida)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoMotivoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_descricaoMotivoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
        );

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        br_sair1.setText("Arquivo");

        jMenu1.setText("Cadastro");

        bt_cadastroSaidaDeCaixa.setText("Motivo de Saída de Caixa");
        bt_cadastroSaidaDeCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastroSaidaDeCaixaActionPerformed(evt);
            }
        });
        jMenu1.add(bt_cadastroSaidaDeCaixa);

        br_sair1.add(jMenu1);

        bt_sair1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        bt_sair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair1.setText("Sair");
        bt_sair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sair1ActionPerformed(evt);
            }
        });
        br_sair1.add(bt_sair1);

        jMenuBar1.add(br_sair1);

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
                        .addComponent(bt_sair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_sair)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabela_motivoSaidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_motivoSaidaMouseClicked
        linha   = tabela_motivoSaida.getSelectedRow();
        if(linha < 0){
            Mensagem = "Item não selecionado!";
            new MostraMensagem(Mensagem);
            return;
        }
        linha = linha + 1;
        if(evt.getButton() == MouseEvent.BUTTON3){
            if(somostra.equalsIgnoreCase("S"))
                return;
            MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
            return;
        }
        if(evt.getClickCount() > 1){
            retorno = String.valueOf(Integer.parseInt(String.valueOf(tabela_motivoSaida.getValueAt(linha - 1, 0))));
            dispose();
        }
    }//GEN-LAST:event_tabela_motivoSaidaMouseClicked

    private void bt_detalhesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesItemActionPerformed
        if(MotSaiCaiCad != null)if(MotSaiCaiCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        if(linha == 0){
            Mensagem = "Item não selecionado!";
            new MostraMensagem(Mensagem);
            return;
        }
        linha = linha - 1;
        bcms.codigoMotivoSaida  = Integer.parseInt(String.valueOf(tabela_motivoSaida.getValueAt(linha, 0)));
        parametros.clear();
        parametros.add("S");
        parametros.add(bcms.codigoMotivoSaida);
        MotSaiCaiCad = new MotivosDeSaidaDeCaixaCadastro(parametros);
        MotSaiCaiCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesItemActionPerformed

    private void txt_codigoMotivoSaidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoMotivoSaidaKeyReleased
        if(txt_codigoMotivoSaida.getText().replace(" ", "").equals("")){
            sql = "select * from tb_caixa_motivo_saida where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaMotivosDeSaidaDeCaixa();
            return;
        }
        bcms.codigoMotivoSaida  = Integer.parseInt(txt_codigoMotivoSaida.getText().replace(" ", ""));
        sql = "select * from tb_caixa_motivo_saida where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoMotivoSaida >= " + bcms.codigoMotivoSaida + ";";
        PegaMotivosDeSaidaDeCaixa();
    }//GEN-LAST:event_txt_codigoMotivoSaidaKeyReleased

    private void txt_descricaoMotivoSaidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descricaoMotivoSaidaKeyReleased
        bcms.descricaoMotivoSaida   = txt_descricaoMotivoSaida.getText();
        if(bcms.descricaoMotivoSaida.equals("")){
            sql = "select * from tb_caixa_motivo_saida where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaMotivosDeSaidaDeCaixa();
            return;
        }
        sql = "select * from tb_caixa_motivo_saida where idEmpresa = " + parametrosNS.be.IdEmpresa + " and descricaoMotivoSaida like '%" + bcms.descricaoMotivoSaida + "%';";
        PegaMotivosDeSaidaDeCaixa();
    }//GEN-LAST:event_txt_descricaoMotivoSaidaKeyReleased

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Table   = (DefaultTableModel)tabela_motivoSaida.getModel();
        
        sql = "select * from tb_caixa_motivo_saida where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        PegaMotivosDeSaidaDeCaixa();
    }//GEN-LAST:event_formWindowOpened

    private void bt_cadastroSaidaDeCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastroSaidaDeCaixaActionPerformed
        if(MotSaiCaiCad != null){
            if(MotSaiCaiCad.isVisible()){
                MotSaiCaiCad.setState(JFrame.NORMAL);
                return;
            }
        }
        abriuMotivos = 1;
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        MotSaiCaiCad = new MotivosDeSaidaDeCaixaCadastro(parametros);
        MotSaiCaiCad.setVisible(true);
    }//GEN-LAST:event_bt_cadastroSaidaDeCaixaActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuMotivos == 0)
            return;
        PegaMotivosDeSaidaDeCaixa();
    }//GEN-LAST:event_formWindowGainedFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenu br_sair1;
    private javax.swing.JMenuItem bt_cadastroSaidaDeCaixa;
    private javax.swing.JMenuItem bt_detalhesItem;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_motivoSaida;
    private javax.swing.JFormattedTextField txt_codigoMotivoSaida;
    private javax.swing.JTextField txt_descricaoMotivoSaida;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
}
