package TelasFaturamento;

import Beans.BeanTransportadora;
import FuncoesInternas.FormataCPFCNPJ;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import Parametros.parametrosNS;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 @author Tiago e Paulo
 */
public class TransportadoraConsulta extends javax.swing.JFrame {
    //String's
    String sql                      = "";
    String sqlstate                 = "";
    String Mensagem                 = "";
    String somostra                 = "";
    String retorno                  = "";
    
    //int's
    int    Linha                    = 0;
    
    //Vetores
    ArrayList            parametros            = new ArrayList();
    ArrayList            dadosPadroes          = new ArrayList();
    ArrayList<ArrayList> dadosTransportadora   = new ArrayList<ArrayList>();
    
    //Bean's
    BeanTransportadora      btrans  = new BeanTransportadora();
    
    //Especiais
    DefaultTableModel       TableTransportadoras;
    FormataCPFCNPJ          FCpfCnpj= new FormataCPFCNPJ();
    FormataCampo            fc      = new FormataCampo();
    
    //Telas
    TransportadoraCadastro  TransCad;
    
    public TransportadoraConsulta(ArrayList DadosPadroes){
        dadosPadroes                = DadosPadroes;
        
        somostra                    = (String)  dadosPadroes.get(0);
        
        initComponents();
    }
    
    private void PegaTransportadoras(){
        dadosTransportadora.clear();
        dadosTransportadora = parametrosNS.dao.Consulta(sql);
        PegaDadosTransportadoras();
    }
    
    private void PegaDadosTransportadoras(){
        for(int i = 0; i < dadosTransportadora.size(); i++){
            if(dadosTransportadora.get(i).get(0) != null)
                btrans.idTransportadora     = Integer.parseInt(  String.valueOf(dadosTransportadora.get(i).get(0)));
            if(dadosTransportadora.get(i).get(1) != null)
                btrans.idEmpresa            = Integer.parseInt(  String.valueOf(dadosTransportadora.get(i).get(1)));
            if(dadosTransportadora.get(i).get(2) != null)
                btrans.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosTransportadora.get(i).get(2)));
            if(dadosTransportadora.get(i).get(3) != null)
                btrans.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosTransportadora.get(i).get(3)));
            if(dadosTransportadora.get(i).get(4) != null)
                btrans.codigoTransportadora = Integer.parseInt(  String.valueOf(dadosTransportadora.get(i).get(4)));
            if(dadosTransportadora.get(i).get(5) != null)
                btrans.fisicaJuridica       = Integer.parseInt(  String.valueOf(dadosTransportadora.get(i).get(5)));
                btrans.cpfCnpj              =                    String.valueOf(dadosTransportadora.get(i).get(6));
                btrans.InscricaoEstadual    =                    String.valueOf(dadosTransportadora.get(i).get(7));
                btrans.NomeTransportadora   =                    String.valueOf(dadosTransportadora.get(i).get(8));
                btrans.Cep                  =                    String.valueOf(dadosTransportadora.get(i).get(9));
                btrans.Uf                   =                    String.valueOf(dadosTransportadora.get(i).get(10));
                btrans.Cidade               =                    String.valueOf(dadosTransportadora.get(i).get(11));
                btrans.Bairro               =                    String.valueOf(dadosTransportadora.get(i).get(12));
                btrans.Endereco             =                    String.valueOf(dadosTransportadora.get(i).get(13));
                btrans.Numero               =                    String.valueOf(dadosTransportadora.get(i).get(14));
            if(dadosTransportadora.get(i).get(15) != null)
                btrans.codigoPais           = Integer.parseInt(  String.valueOf(dadosTransportadora.get(i).get(15)));
            
            btrans.cpfCnpj              = FCpfCnpj.FormataCPFCNPJ(btrans.cpfCnpj);
            
            TableTransportadoras.addRow(new Object [] {fc.FormataCampo(String.valueOf(btrans.codigoTransportadora), 5, 0), btrans.NomeTransportadora, btrans.cpfCnpj, btrans.InscricaoEstadual});
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
        tabela_transportadoras = new javax.swing.JTable();
        txt_codigoTransportadora = new javax.swing.JFormattedTextField();
        txt_nomeTransportadora = new javax.swing.JTextField();
        txt_cpfCnpj = new javax.swing.JTextField();
        txt_inscricaoEstadual = new javax.swing.JTextField();
        bt_sair = new javax.swing.JButton();
        jMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_cadastrarTransportadoras = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        bt_sair1 = new javax.swing.JMenuItem();

        bt_detalhes.setText("Detalhes");
        bt_detalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_detalhesActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_detalhes);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Transportadoras");
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
        jLabel1.setText("Consulta de Transportadoras");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_transportadoras.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_transportadoras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome da Transportadora", "CPF / CNPJ", "Inscrição Estadual"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_transportadoras.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_transportadoras.getTableHeader().setReorderingAllowed(false);
        tabela_transportadoras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_transportadorasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_transportadoras);
        if (tabela_transportadoras.getColumnModel().getColumnCount() > 0) {
            tabela_transportadoras.getColumnModel().getColumn(0).setResizable(false);
            tabela_transportadoras.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabela_transportadoras.getColumnModel().getColumn(1).setResizable(false);
            tabela_transportadoras.getColumnModel().getColumn(1).setPreferredWidth(250);
            tabela_transportadoras.getColumnModel().getColumn(2).setResizable(false);
            tabela_transportadoras.getColumnModel().getColumn(2).setPreferredWidth(125);
            tabela_transportadoras.getColumnModel().getColumn(3).setResizable(false);
            tabela_transportadoras.getColumnModel().getColumn(3).setPreferredWidth(125);
        }

        try {
            txt_codigoTransportadora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoTransportadora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoTransportadoraKeyReleased(evt);
            }
        });

        txt_nomeTransportadora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nomeTransportadoraKeyReleased(evt);
            }
        });

        txt_cpfCnpj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cpfCnpjKeyReleased(evt);
            }
        });

        txt_inscricaoEstadual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_inscricaoEstadualKeyReleased(evt);
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
                        .addComponent(txt_codigoTransportadora, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nomeTransportadora, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_inscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoTransportadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nomeTransportadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_inscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
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

        bt_cadastrarTransportadoras.setText("Cadastrar Transportadoras");
        bt_cadastrarTransportadoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastrarTransportadorasActionPerformed(evt);
            }
        });
        jMenu1.add(bt_cadastrarTransportadoras);
        jMenu1.add(jSeparator1);

        bt_sair1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        bt_sair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair1.setText("Sair");
        bt_sair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sair1ActionPerformed(evt);
            }
        });
        jMenu1.add(bt_sair1);

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
        TableTransportadoras = (DefaultTableModel)tabela_transportadoras.getModel();
        sql = "select * from tb_transportadoras where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        PegaTransportadoras();
        
        if(parametrosNS.bu.nivelUsuario  < 4 | somostra.equals("S"))
            jMenu.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void txt_codigoTransportadoraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoTransportadoraKeyReleased
        if(txt_codigoTransportadora.getText().replace(" ", "").equals("")){
            sql = "select * from tb_transportadoras where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaTransportadoras();
            return;
        }
        btrans.codigoTransportadora = Integer.parseInt(txt_codigoTransportadora.getText().replace(" ", ""));
        sql = "select * from tb_transportadoras where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoTransportadora = " + btrans.codigoTransportadora + ";";
        PegaTransportadoras();
    }//GEN-LAST:event_txt_codigoTransportadoraKeyReleased

    private void txt_nomeTransportadoraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nomeTransportadoraKeyReleased
        btrans.NomeTransportadora   = txt_nomeTransportadora.getText();
        if(btrans.NomeTransportadora.equals("")){
            sql = "select * from tb_transportadoras where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaTransportadoras();
            return;
        }
        sql = "select * from tb_transportadoras where idEmpresa = " + parametrosNS.be.IdEmpresa + " and NomeTransportadora like '%" + btrans.NomeTransportadora + "%';";
        PegaTransportadoras();
    }//GEN-LAST:event_txt_nomeTransportadoraKeyReleased

    private void txt_cpfCnpjKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cpfCnpjKeyReleased
        btrans.cpfCnpj              = txt_cpfCnpj.getText();
        if(btrans.cpfCnpj.equals("")){
            sql = "select * from tb_transportadoras where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaTransportadoras();
            return;
        }
        sql = "select * from tb_transportadoras where idEmpresa = " + parametrosNS.be.IdEmpresa + " and cpfCnpj like '%" + btrans.cpfCnpj + "%';";
        PegaTransportadoras();
    }//GEN-LAST:event_txt_cpfCnpjKeyReleased

    private void txt_inscricaoEstadualKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_inscricaoEstadualKeyReleased
        btrans.InscricaoEstadual    = txt_cpfCnpj.getText();
        btrans.InscricaoEstadual    = btrans.InscricaoEstadual.replace(".", "");
        if(btrans.InscricaoEstadual.equals("")){
            sql = "select * from tb_transportadoras where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaTransportadoras();
            return;
        }
        sql = "select * from tb_transportadoras where idEmpresa = " + parametrosNS.be.IdEmpresa + " and replace(InscricaoEstadual, '.', '') like '%" + btrans.InscricaoEstadual + "%';";
        PegaTransportadoras();
    }//GEN-LAST:event_txt_inscricaoEstadualKeyReleased

    private void bt_cadastrarTransportadorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastrarTransportadorasActionPerformed
        if(TransCad != null)if(TransCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("SN");
        parametros.add(0);
        TransCad = new TransportadoraCadastro(parametros);
        TransCad.setVisible(true);
    }//GEN-LAST:event_bt_cadastrarTransportadorasActionPerformed

    private void bt_detalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesActionPerformed
        if(TransCad != null)if(TransCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("S");
        parametros.add(Integer.parseInt(retorno));
        TransCad = new TransportadoraCadastro(parametros);
        TransCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesActionPerformed

    private void tabela_transportadorasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_transportadorasMouseClicked
        Linha = tabela_transportadoras.getSelectedRow();
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
        retorno = String.valueOf(Integer.parseInt(String.valueOf(tabela_transportadoras.getValueAt(Linha, 0))));
        if(evt.getClickCount() < 2)
            return;
        dispose();
    }//GEN-LAST:event_tabela_transportadorasMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(TransCad != null)TransCad.dispose();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_cadastrarTransportadoras;
    private javax.swing.JMenuItem bt_detalhes;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable tabela_transportadoras;
    private javax.swing.JFormattedTextField txt_codigoTransportadora;
    private javax.swing.JTextField txt_cpfCnpj;
    private javax.swing.JTextField txt_inscricaoEstadual;
    private javax.swing.JTextField txt_nomeTransportadora;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
}
