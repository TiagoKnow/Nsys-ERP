package TelasFaturamento;

import Beans.BeanVeiculos;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import Parametros.parametrosNS;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 @author Tiago e Paulo
 */
public class VeiculosConsulta extends javax.swing.JFrame {
    //String's
    String sql                              = "";
    String sqlstate                         = "";
    String Mensagem                         = "";
    String somostra                         = "";
    String retorno                          = "";
    
    //int's
    int    Linha                            = 0;
    int    abriuVeiCad                      = 0;
    
    //Vetores
    ArrayList            parametros                    = new ArrayList();
    ArrayList            dadosPadroes                  = new ArrayList();
    ArrayList<ArrayList> dadosVeiculos                 = new ArrayList<ArrayList>();
    
    //Bean's
    BeanVeiculos                    bvei    = new BeanVeiculos();
    
    //Especiais
    FormataCampo                    fc      = new FormataCampo();
    DefaultTableModel               TableVeiculos;
    
    //Telas
    VeiculosCadastro                VeiCad;
    
    public VeiculosConsulta(ArrayList DadosPadroes){
        dadosPadroes                        = DadosPadroes;
        
        somostra                            = (String)  dadosPadroes.get(0);
        
        initComponents();
    }
    
    private void PegaVeiculos(){
        dadosVeiculos.clear();
        dadosVeiculos = parametrosNS.dao.Consulta(sql);
        PegaDadosVeiculos();
    }
    
    private void PegaDadosVeiculos(){
        tabela_veiculos.getColumnModel().getColumn(0).setResizable(false);
        tabela_veiculos.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabela_veiculos.getColumnModel().getColumn(1).setResizable(false);
        tabela_veiculos.getColumnModel().getColumn(1).setPreferredWidth(125);
        tabela_veiculos.getColumnModel().getColumn(2).setResizable(false);
        tabela_veiculos.getColumnModel().getColumn(2).setPreferredWidth(30);
        tabela_veiculos.getColumnModel().getColumn(3).setResizable(false);
        tabela_veiculos.getColumnModel().getColumn(3).setPreferredWidth(150);
        tabela_veiculos.getColumnModel().getColumn(4).setResizable(false);
        tabela_veiculos.getColumnModel().getColumn(4).setPreferredWidth(250);
        
        TableVeiculos.setNumRows(0);
        for(int i = 0; i < dadosVeiculos.size(); i++){
            if(dadosVeiculos.get(i).get(0) != null)
                bvei.idVeiculo      = Integer.parseInt(  String.valueOf(dadosVeiculos.get(i).get(0)));
            if(dadosVeiculos.get(i).get(1) != null)
                bvei.idEmpresa      = Integer.parseInt(  String.valueOf(dadosVeiculos.get(i).get(1)));
            if(dadosVeiculos.get(i).get(2) != null)
                bvei.codigoGrupo    = Integer.parseInt(  String.valueOf(dadosVeiculos.get(i).get(2)));
            if(dadosVeiculos.get(i).get(3) != null)
                bvei.codigoEmpresa  = Integer.parseInt(  String.valueOf(dadosVeiculos.get(i).get(3)));
            if(dadosVeiculos.get(i).get(4) != null)
                bvei.codigoVeiculo  = Integer.parseInt(  String.valueOf(dadosVeiculos.get(i).get(4)));
                bvei.placaVeiculo   =                    String.valueOf(dadosVeiculos.get(i).get(5));
                bvei.ufVeiculo      =                    String.valueOf(dadosVeiculos.get(i).get(6));
                bvei.cidadeVeiculo  =                    String.valueOf(dadosVeiculos.get(i).get(7));
                bvei.rntcVeiculo    =                    String.valueOf(dadosVeiculos.get(i).get(8));
                
            if(bvei.rntcVeiculo.equals("null"))
                bvei.rntcVeiculo = "";
                
            TableVeiculos.addRow(new Object [] {fc.FormataCampo(String.valueOf(bvei.codigoVeiculo), 6, 0), bvei.placaVeiculo, bvei.ufVeiculo, bvei.cidadeVeiculo, bvei.rntcVeiculo});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_detalhes = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_veiculos = new javax.swing.JTable();
        txt_codigoVeiculo = new javax.swing.JFormattedTextField();
        txt_placaVeiculo = new javax.swing.JFormattedTextField();
        txt_ufVeiculo = new javax.swing.JFormattedTextField();
        txt_cidadeVeiculo = new javax.swing.JTextField();
        txt_rntcVeiculo = new javax.swing.JTextField();
        bt_sair = new javax.swing.JButton();
        jMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_cadastrarVeiculos = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();

        bt_detalhes.setText("Detalhes");
        bt_detalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_detalhesActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_detalhes);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Veículos");
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
        jLabel1.setText("Consulta de Veículos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_veiculos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_veiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Placa", "UF", "Cidade", "RNTC"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_veiculos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_veiculos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_veiculos.getTableHeader().setReorderingAllowed(false);
        tabela_veiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_veiculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_veiculos);
        if (tabela_veiculos.getColumnModel().getColumnCount() > 0) {
            tabela_veiculos.getColumnModel().getColumn(0).setResizable(false);
            tabela_veiculos.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabela_veiculos.getColumnModel().getColumn(1).setResizable(false);
            tabela_veiculos.getColumnModel().getColumn(1).setPreferredWidth(125);
            tabela_veiculos.getColumnModel().getColumn(2).setResizable(false);
            tabela_veiculos.getColumnModel().getColumn(2).setPreferredWidth(30);
            tabela_veiculos.getColumnModel().getColumn(3).setResizable(false);
            tabela_veiculos.getColumnModel().getColumn(3).setPreferredWidth(150);
            tabela_veiculos.getColumnModel().getColumn(4).setResizable(false);
            tabela_veiculos.getColumnModel().getColumn(4).setPreferredWidth(250);
        }

        try {
            txt_codigoVeiculo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoVeiculo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoVeiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoVeiculoKeyReleased(evt);
            }
        });

        try {
            txt_placaVeiculo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**********")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_placaVeiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_placaVeiculoKeyReleased(evt);
            }
        });

        try {
            txt_ufVeiculo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_ufVeiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_ufVeiculoKeyReleased(evt);
            }
        });

        txt_cidadeVeiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cidadeVeiculoKeyReleased(evt);
            }
        });

        txt_rntcVeiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_rntcVeiculoKeyReleased(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_placaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ufVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cidadeVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_rntcVeiculo)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_placaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ufVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cidadeVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_rntcVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addGap(11, 11, 11))
        );

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        bt_cadastrarVeiculos.setText("Cadastro de Veículos");
        bt_cadastrarVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastrarVeiculosActionPerformed(evt);
            }
        });
        jMenu1.add(bt_cadastrarVeiculos);
        jMenu1.add(jSeparator1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        jMenuItem2.setText("Sair");
        jMenu1.add(jMenuItem2);

        jMenu.add(jMenu1);

        setJMenuBar(jMenu);

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
                .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        TableVeiculos = (DefaultTableModel)tabela_veiculos.getModel();
        sql = "select * from tb_veiculos where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        PegaVeiculos();
        
        if(parametrosNS.bu.nivelUsuario  < 4 | somostra.equals("S"))
            jMenu.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void txt_codigoVeiculoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoVeiculoKeyReleased
        if(txt_codigoVeiculo.getText().replace(" ", "").equals("")){
            sql = "select * from tb_veiculos where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaVeiculos();
            return;
        }
        bvei.codigoVeiculo  = Integer.parseInt(txt_codigoVeiculo.getText().replace(" ", ""));
        sql = "select * from tb_veiculos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoVeiculo >= " + bvei.codigoVeiculo + ";";
        PegaVeiculos();
    }//GEN-LAST:event_txt_codigoVeiculoKeyReleased

    private void txt_placaVeiculoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placaVeiculoKeyReleased
        bvei.placaVeiculo   = txt_placaVeiculo.getText().replace(" ", "");
        bvei.placaVeiculo   = bvei.placaVeiculo.replace("-", "");
        if(bvei.placaVeiculo.equals("")){
            sql = "select * from tb_veiculos where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaVeiculos();
            return;
        }
        sql = "select * from tb_veiculos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and replace(placaVeiculo, '-', '') like '%" + bvei.placaVeiculo + "%';";
        PegaVeiculos();
    }//GEN-LAST:event_txt_placaVeiculoKeyReleased

    private void txt_ufVeiculoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ufVeiculoKeyReleased
        bvei.ufVeiculo      = txt_ufVeiculo.getText().replace(" ", "");
        if(bvei.ufVeiculo.equals("")){
            sql = "select * from tb_veiculos where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaVeiculos();
            return;
        }
        sql = "select * from tb_veiculos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and ufVeiculo like '%" + bvei.ufVeiculo + "%';";
        PegaVeiculos();
    }//GEN-LAST:event_txt_ufVeiculoKeyReleased

    private void txt_cidadeVeiculoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cidadeVeiculoKeyReleased
        bvei.cidadeVeiculo  = txt_cidadeVeiculo.getText();
        if(bvei.cidadeVeiculo.equals("")){
            sql = "select * from tb_veiculos where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaVeiculos();
            return;
        }
        sql = "select * from tb_veiculos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and cidadeVeiculo like '%" + bvei.cidadeVeiculo + "%';";
        PegaVeiculos();
    }//GEN-LAST:event_txt_cidadeVeiculoKeyReleased

    private void txt_rntcVeiculoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rntcVeiculoKeyReleased
        bvei.rntcVeiculo    = txt_rntcVeiculo.getText();
        if(bvei.rntcVeiculo.equals("")){
            sql = "select * from tb_veiculos where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaVeiculos();
            return;
        }
        sql = "select * from tb_veiculos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and rntcVeiculo like '%" + bvei.rntcVeiculo + "%';";
        PegaVeiculos();
    }//GEN-LAST:event_txt_rntcVeiculoKeyReleased

    private void tabela_veiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_veiculosMouseClicked
        Linha = tabela_veiculos.getSelectedRow();
        if(Linha < 0){
            Mensagem = "Item não selecionado!";
            new MostraMensagem(Mensagem);
            return;
        }
        if(evt.getButton() == MouseEvent.BUTTON3){
            if(somostra.equalsIgnoreCase("N")){
                MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
        retorno = String.valueOf(Integer.parseInt(String.valueOf(tabela_veiculos.getValueAt(Linha, 0))));
        if(evt.getClickCount() < 2)
            return;
        dispose();
    }//GEN-LAST:event_tabela_veiculosMouseClicked

    private void bt_detalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesActionPerformed
        parametros.clear();
        parametros.add("S");
        parametros.add(Integer.parseInt(retorno));
        if(VeiCad != null)if(VeiCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        VeiCad = new VeiculosCadastro(parametros);
        VeiCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesActionPerformed

    private void bt_cadastrarVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastrarVeiculosActionPerformed
        parametros.clear();
        parametros.add("SN");
        parametros.add(0);
        if(VeiCad != null)if(VeiCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuVeiCad = 1;
        VeiCad = new VeiculosCadastro(parametros);
        VeiCad.setVisible(true);
    }//GEN-LAST:event_bt_cadastrarVeiculosActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuVeiCad == 0)
            return;
        abriuVeiCad = 0;
        sql = "select * from tb_veiculos where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        PegaVeiculos();
    }//GEN-LAST:event_formWindowGainedFocus

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(VeiCad   != null)VeiCad.dispose();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_cadastrarVeiculos;
    private javax.swing.JMenuItem bt_detalhes;
    private javax.swing.JButton bt_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable tabela_veiculos;
    private javax.swing.JTextField txt_cidadeVeiculo;
    private javax.swing.JFormattedTextField txt_codigoVeiculo;
    private javax.swing.JFormattedTextField txt_placaVeiculo;
    private javax.swing.JTextField txt_rntcVeiculo;
    private javax.swing.JFormattedTextField txt_ufVeiculo;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
}
