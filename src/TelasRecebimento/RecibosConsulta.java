package TelasRecebimento;

import Beans.BeanClientes;
import Beans.BeanRecibos;
import Beans.BeanRecibosDetalhes;
import Beans.BeanRecibosPagamentos;
import FuncoesInternas.ConverteValorDigitadoEmDouble;
import FuncoesInternas.FormataCPFCNPJ;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.TransformaValorStringeDouble;
import java.util.ArrayList;
import Parametros.parametrosNS;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.table.DefaultTableModel;
/*
 @author Tiago e Paulo 07/11/2016
 */
public class RecibosConsulta extends javax.swing.JFrame {
    //String
    String sql                              = "";
    String Mensagem                         = "";
    String somostra                         = "";
    String retorno                          = "";
    
    //Int
    int    totalRegistros                   = 0;
    int    QuantidadeItens                  = 0;
    int    Linha                            = 0;
    
    //Float
    double ValorRecibo                      = 0;
    
    //Beans
    BeanClientes                    bc      = new BeanClientes();
    BeanRecibos                     br      = new BeanRecibos();
    BeanRecibosDetalhes             brd     = new BeanRecibosDetalhes();
    BeanRecibosPagamentos           brp     = new BeanRecibosPagamentos();
    
    //Vetores
    ArrayList            parametros                    = new ArrayList();
    ArrayList            dadosPadroes                  = new ArrayList();
    ArrayList<ArrayList> dadosCliente                  = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosRecibos                  = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosRecibosDetalhes          = new ArrayList<ArrayList>();
//    ArrayList<ArrayList> dadosRecibosPagamentos        = new ArrayList<ArrayList>();
    
    //Especiais
    DefaultTableModel               TableRecibos;
    FormataCampo                    fc          = new FormataCampo();
    FormataCPFCNPJ                  FCpfCnpj    = new FormataCPFCNPJ();
    InverterData                    invdata     = new InverterData();
    TransformaValorStringeDouble    TransStrDou = new TransformaValorStringeDouble();
    
    //Telas
    RecibosCadastro                 RecCad;
    
    public RecibosConsulta(String Somostra){
        somostra = Somostra;
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_detalhes = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_recibos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_codigoRecibo = new javax.swing.JFormattedTextField();
        txt_codigoCliente = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        bt_sair = new javax.swing.JButton();

        bt_detalhes.setText("Detalhes");
        bt_detalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_detalhesActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_detalhes);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Recibos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_recibos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_recibos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome do Cliente", "CPF/CNPJ", "Itens", "Valor Recibo", "Data do Recibo", "Status Lote"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_recibos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_recibos.getTableHeader().setReorderingAllowed(false);
        tabela_recibos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_recibosMouseClicked(evt);
            }
        });
        tabela_recibos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabela_recibosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_recibos);
        if (tabela_recibos.getColumnModel().getColumnCount() > 0) {
            tabela_recibos.getColumnModel().getColumn(0).setResizable(false);
            tabela_recibos.getColumnModel().getColumn(1).setResizable(false);
            tabela_recibos.getColumnModel().getColumn(2).setResizable(false);
            tabela_recibos.getColumnModel().getColumn(3).setResizable(false);
            tabela_recibos.getColumnModel().getColumn(4).setResizable(false);
            tabela_recibos.getColumnModel().getColumn(5).setResizable(false);
            tabela_recibos.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Consulta de Recibos");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_codigoRecibo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoRecibo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoReciboKeyReleased(evt);
            }
        });

        try {
            txt_codigoCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoClienteKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel3.setText("Total de Registros: ");

        jTextField1.setEditable(false);

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 607, Short.MAX_VALUE)
                .addComponent(bt_sair)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(483, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(41, Short.MAX_VALUE)))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_sair, jLabel3, jTextField1});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabela_recibosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_recibosMouseClicked
        Linha = tabela_recibos.getSelectedRow();
        if(Linha < 0){
            Mensagem = "Item não selecionado!";
            new MostraMensagem(Mensagem);
            return;
        }
        if(evt.getButton() == MouseEvent.BUTTON3){
            if(somostra.equals("N")){
                MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
        retorno = String.valueOf(Integer.parseInt(String.valueOf(tabela_recibos.getValueAt(Linha, 0))));
        if(evt.getClickCount() < 2)
            return;
        dispose();
    }//GEN-LAST:event_tabela_recibosMouseClicked

    private void tabela_recibosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabela_recibosKeyPressed
//        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
//        return;
//        RetornaCliente();
//        dispose();
    }//GEN-LAST:event_tabela_recibosKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        TableRecibos  = (DefaultTableModel)tabela_recibos.getModel();
        
        tabela_recibos.getColumnModel().getColumn(0).setResizable(false);
        tabela_recibos.getColumnModel().getColumn(0).setPreferredWidth(75);
        tabela_recibos.getColumnModel().getColumn(1).setResizable(false);
        tabela_recibos.getColumnModel().getColumn(1).setPreferredWidth(300);
        tabela_recibos.getColumnModel().getColumn(2).setResizable(false);
        tabela_recibos.getColumnModel().getColumn(2).setPreferredWidth(120);
        tabela_recibos.getColumnModel().getColumn(3).setResizable(false);
        tabela_recibos.getColumnModel().getColumn(3).setPreferredWidth(40);
        tabela_recibos.getColumnModel().getColumn(4).setResizable(false);
        tabela_recibos.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabela_recibos.getColumnModel().getColumn(5).setResizable(false);
        tabela_recibos.getColumnModel().getColumn(5).setPreferredWidth(90);
        tabela_recibos.getColumnModel().getColumn(6).setResizable(false);
        tabela_recibos.getColumnModel().getColumn(6).setPreferredWidth(100);
        
        sql = "select * from tb_recibos where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        PegaRecibos();
    }//GEN-LAST:event_formWindowOpened

    private void txt_codigoReciboKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoReciboKeyReleased
        if(txt_codigoRecibo.getText().replace(" ", "").equals("")){
            sql = "select * from tb_recibos where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaRecibos();
            return;
        }
        br.codigoRecibo     = Integer.parseInt(txt_codigoRecibo.getText().replace(" ", ""));
        sql = "select * from tb_recibos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoRecibo >= " + br.codigoRecibo + ";";
        PegaRecibos();
    }//GEN-LAST:event_txt_codigoReciboKeyReleased

    private void txt_codigoClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoClienteKeyReleased
        if(txt_codigoCliente.getText().replace(" ", "").equals("")){
            sql = "select * from tb_recibos where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaRecibos();
            return;
        }
        br.codigoCliente    = Integer.parseInt(txt_codigoCliente.getText().replace(" ", ""));
        sql = "select * from tb_recibos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCliente >= " + br.codigoCliente + ";";
        PegaRecibos();
    }//GEN-LAST:event_txt_codigoClienteKeyReleased

    private void bt_detalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesActionPerformed
        if(RecCad != null)if(RecCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("S");
        parametros.add(Integer.parseInt(retorno));
        RecCad = new RecibosCadastro(parametros);
        RecCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_detalhes;
    private javax.swing.JButton bt_sair;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabela_recibos;
    private javax.swing.JFormattedTextField txt_codigoCliente;
    private javax.swing.JFormattedTextField txt_codigoRecibo;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
    private void PegaRecibos(){
        dadosRecibos.clear();
        dadosRecibos = parametrosNS.dao.Consulta(sql);
        PegaDadosRecibos();
    }
    
    private void PegaDadosRecibos(){
        TableRecibos.setNumRows(0);
        for(int i = 0; i < dadosRecibos.size(); i++){
            br = new BeanRecibos();
            if(dadosRecibos.get(i).get(0) != null)
                br.idRecibo             = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(0)));
            if(dadosRecibos.get(i).get(1) != null)
                br.idEmpresa            = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(1)));
            if(dadosRecibos.get(i).get(2) != null)
                br.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(2)));
            if(dadosRecibos.get(i).get(3) != null)
                br.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(3)));
            if(dadosRecibos.get(i).get(4) != null)
                br.codigoRecibo         = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(4)));
            if(dadosRecibos.get(i).get(5) != null)
                br.codigoCliente        = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(5)));
            if(dadosRecibos.get(i).get(6) != null)
                br.codigoUsuario        = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(6)));
                br.dataRecibo           =                    String.valueOf(dadosRecibos.get(i).get(7));
                br.horaRecibo           =                    String.valueOf(dadosRecibos.get(i).get(8));
            if(dadosRecibos.get(i).get(10) != null)
                br.status               = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(9)));
                br.observacoes          =                    String.valueOf(dadosRecibos.get(i).get(10));
            if(dadosRecibos.get(i).get(11) != null)
                br.ocorrenciaRecibo     = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(11)));
                br.dataEmissaoLote      =                    String.valueOf(dadosRecibos.get(i).get(12));
            
            bc.codigoCliente    = br.codigoCliente;
            sql = "select idCliente, idEmpresa, codigoGrupo, codigoEmpresa, codigoCliente, nome, cpfCnpj from tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCliente = " + bc.codigoCliente + ";";
            PegaCliente();
            
            brd.idEmpresa        = br.idEmpresa;
            brd.codigoGrupo      = br.codigoGrupo;
            brd.codigoEmpresa    = br.codigoEmpresa;
            brd.codigoRecibo     = br.codigoRecibo;
            PegaRecibosDetalhes();
//            
//            brp.idRecibo    = br.idRecibo;
//            PegaRecibosPagamentos();
            
            br.dataRecibo   = invdata.inverterData(br.dataRecibo, 1);
            
            TableRecibos.addRow(new Object [] {fc.FormataCampo(String.valueOf(br.codigoRecibo), 6, 0), fc.FormataCampo(String.valueOf(bc.codigoCliente), 5, 0) + " - " + bc.nome, bc.cpfCnpj, QuantidadeItens, TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorRecibo), 0), br.dataRecibo, br.ocorrenciaRecibo});
        }
    }
    
    private void PegaCliente(){
        dadosCliente.clear();
        dadosCliente = parametrosNS.dao.Consulta(sql);
        if(dadosCliente.isEmpty()){
            Mensagem = "Cliente n°" + bc.codigoCliente + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosCliente();
    }
    
    private void PegaDadosCliente(){
        for(int i = 0; i < dadosCliente.size(); i++){
            bc = new BeanClientes();
            bc.idCliente            = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(0)));
            bc.idEmpresa            = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(1)));
            bc.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(2)));
            bc.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(3)));
            bc.codigoCliente        = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(4)));
            bc.nome                 =                    String.valueOf(dadosCliente.get(i).get(5));
            bc.cpfCnpj              =                    String.valueOf(dadosCliente.get(i).get(6));
            
            bc.cpfCnpj  = FCpfCnpj.FormataCPFCNPJ(bc.cpfCnpj);
        }
    }
    
    private void PegaRecibosDetalhes(){
        sql = "select * from tb_recibos_detalhes where idEmpresa = " + brd.idEmpresa + " and codigoRecibo = " + brd.codigoRecibo + ";";
        dadosRecibosDetalhes.clear();
        dadosRecibosDetalhes = parametrosNS.dao.Consulta(sql);
        if(dadosRecibosDetalhes.isEmpty()){
            Mensagem = "Não foram encontrados itens para o Recibo n°" + br.codigoRecibo + "!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosRecibosDetalhes();
    }
    
    private void PegaDadosRecibosDetalhes(){
        QuantidadeItens = 0;
        ValorRecibo     = 0;
        for(int i = 0; i < dadosRecibosDetalhes.size(); i++){
            brd = new BeanRecibosDetalhes();
            if(dadosRecibosDetalhes.get(i).get(0) != null)brd.idReciboDetalhes  = Integer.parseInt(  String.valueOf(dadosRecibosDetalhes.get(i).get(0)));
            if(dadosRecibosDetalhes.get(i).get(1) != null)brd.idEmpresa         = Integer.parseInt(  String.valueOf(dadosRecibosDetalhes.get(i).get(1)));
            if(dadosRecibosDetalhes.get(i).get(2) != null)brd.codigoGrupo       = Integer.parseInt(  String.valueOf(dadosRecibosDetalhes.get(i).get(2)));
            if(dadosRecibosDetalhes.get(i).get(3) != null)brd.codigoEmpresa     = Integer.parseInt(  String.valueOf(dadosRecibosDetalhes.get(i).get(3)));
            if(dadosRecibosDetalhes.get(i).get(4) != null)brd.codigoRecibo      = Integer.parseInt(  String.valueOf(dadosRecibosDetalhes.get(i).get(4)));
            if(dadosRecibosDetalhes.get(i).get(5) != null)brd.codigoReciboItem  = Integer.parseInt(  String.valueOf(dadosRecibosDetalhes.get(i).get(5)));
            if(dadosRecibosDetalhes.get(i).get(6) != null)brd.codigoServico     = Integer.parseInt(  String.valueOf(dadosRecibosDetalhes.get(i).get(6)));
            if(dadosRecibosDetalhes.get(i).get(7) != null)brd.valorServico      = Double.parseDouble(String.valueOf(dadosRecibosDetalhes.get(i).get(7)));
            if(dadosRecibosDetalhes.get(i).get(8) != null)brd.quantidade        = Integer.parseInt(  String.valueOf(dadosRecibosDetalhes.get(i).get(8)));
            if(dadosRecibosDetalhes.get(i).get(9) != null)brd.valorTotal        = Double.parseDouble(String.valueOf(dadosRecibosDetalhes.get(i).get(9)));
            
            QuantidadeItens++;
            
            ValorRecibo            += brd.valorTotal;
        }
    }
    
//    private void PegaRecibosPagamentos(){
//        sql = "select * from tb_recibos_pagamentos where idRecibo = " + brp.idRecibo + "";
//        dadosRecibosPagamentos.clear();
//        dadosRecibosPagamentos = parametrosNS.dao.Consulta(sql);
//        if(dadosRecibosPagamentos.isEmpty()){
//            Mensagem = "Não foram encontrados pagamentos para o Recibo n°" + br.codigoRecibo + "!";
//            new MostraMensagem(Mensagem);
//            return;
//        }
//        PegaDadosRecibosPagamentos();
//    }
//    
//    private void PegaDadosRecibosPagamentos(){
//        for(int i = 0; i < dadosRecibosPagamentos.size(); i++){
//            brp = new BeanRecibosPagamentos();
//        if(dadosRecibosPagamentos.get(i).get(0) != null)
//            brp.idRecibosPagamento  = Integer.parseInt(  String.valueOf(dadosRecibosPagamentos.get(i).get(0)));
//        if(dadosRecibosPagamentos.get(i).get(1) != null)
//            brp.idRecibo            = Integer.parseInt(  String.valueOf(dadosRecibosPagamentos.get(i).get(1)));
//        if(dadosRecibosPagamentos.get(i).get(2) != null)
//            brp.codigoPagamento     = Integer.parseInt(  String.valueOf(dadosRecibosPagamentos.get(i).get(2)));
//        if(dadosRecibosPagamentos.get(i).get(3) != null)
//            brp.valorDoPagamento    = Double.parseDouble(String.valueOf(dadosRecibosPagamentos.get(i).get(3)));
//        if(dadosRecibosPagamentos.get(i).get(4) != null)
//            brp.trocoDoPagamento    = Double.parseDouble(String.valueOf(dadosRecibosPagamentos.get(i).get(4)));
//        }
//    }
    
}
