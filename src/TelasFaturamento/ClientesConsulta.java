package TelasFaturamento;

import Beans.BeanClientes;
import TelasFaturamento.ClientesCadastro;
import FuncoesInternas.*;
import Parametros.parametrosNS;
import TelasVendas.PDV;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.table.*;

/*
 @author Tiago e Paulo
 */
public class ClientesConsulta extends javax.swing.JFrame {
    //String's
    String sql        = "";
    String sqlstate   = "";
    String Mensagem   = "";
    String somostra   = "";
    String retorno    = "";
    String textoBusca = "";
    
    //Special
    public String Modo = "";
    
    //int's
    int    linha = 0;
    int    index = 0;
    
    //ArrayList's
    ArrayList            parametros            = new ArrayList();
//    ArrayList            dadosPadroes          = new ArrayList();
    ArrayList<ArrayList> dadosCliente          = new ArrayList<ArrayList>();
    
    //Bean's
    BeanClientes            bc      = new BeanClientes();
    
    //Especiais
    DefaultTableModel TableClientes;
    FormataCPFCNPJ    FCpfCnpj= new FormataCPFCNPJ();
    FormataCampo      fc      = new FormataCampo();
    
    //Telas
    ClientesCadastro  CliCad;
    PDV               Pdv;
    
    public ClientesConsulta(String Somostra){
        somostra                    = Somostra;
        initComponents();
    }
    
    private void PegaClientes(){
        sql = "select idCliente, idEmpresa, codigoGrupo, codigoEmpresa, codigoCliente, nome, cpfCnpj from tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa;
        switch(index){
            case 1: sql += " and codigoCliente like '%" + textoBusca + "%'"; break;
            case 2: sql += " and nome like '%"          + textoBusca + "%'"; break;
            case 3: sql += " and cpfCnpj like '%"       + textoBusca + "%'"; break;
        }
        sql += " order by codigoCliente asc;";
        dadosCliente.clear();
        dadosCliente = parametrosNS.dao.Consulta(sql);
        if(dadosCliente.isEmpty()){
            index++;
            if(index < 4){
                PegaClientes();
                return;
            }
        }
        PreencherTabela();
    }
    
    private void PreencherTabela(){
        TableClientes.setNumRows(0);
        for(int i = 0; i < dadosCliente.size(); i++){
            bc = new BeanClientes();
            bc.idCliente            = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(0)));
            bc.idEmpresa            = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(1)));
            bc.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(2)));
            bc.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(3)));
            bc.codigoCliente        = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(4)));
            bc.nome                 =                    String.valueOf(dadosCliente.get(i).get(5));
            bc.cpfCnpj              =                    String.valueOf(dadosCliente.get(i).get(6));
            
            bc.cpfCnpj      = FCpfCnpj.FormataCPFCNPJ(bc.cpfCnpj);
            
            TableClientes.addRow(new Object [] {fc.FormataCampo(String.valueOf(bc.codigoCliente), 5, 0), bc.nome, bc.cpfCnpj});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_detalhesItem = new javax.swing.JMenuItem();
        bt_alterar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela_Clientes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        bt_sair = new javax.swing.JButton();
        jMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        bt_cadastroClientes = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        bt_sair1 = new javax.swing.JMenuItem();

        bt_detalhesItem.setText("Detalhes");
        bt_detalhesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_detalhesItemActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_detalhesItem);

        bt_alterar.setText("Alterar Registro");
        bt_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterarActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_alterar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Tabela_Clientes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Tabela_Clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código do Cliente", "Nome do Cliente", "CPF / CNPJ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabela_Clientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Tabela_Clientes.getTableHeader().setReorderingAllowed(false);
        Tabela_Clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabela_ClientesMouseClicked(evt);
            }
        });
        Tabela_Clientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Tabela_ClientesKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(Tabela_Clientes);
        if (Tabela_Clientes.getColumnModel().getColumnCount() > 0) {
            Tabela_Clientes.getColumnModel().getColumn(0).setResizable(false);
            Tabela_Clientes.getColumnModel().getColumn(1).setResizable(false);
            Tabela_Clientes.getColumnModel().getColumn(1).setPreferredWidth(240);
            Tabela_Clientes.getColumnModel().getColumn(2).setResizable(false);
            Tabela_Clientes.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Consulta de Clientes");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nomeKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                    .addComponent(txt_nome))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        jMenu2.setText("Cadastro");

        bt_cadastroClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        bt_cadastroClientes.setText("Clientes");
        bt_cadastroClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastroClientesActionPerformed(evt);
            }
        });
        jMenu2.add(bt_cadastroClientes);

        jMenu1.add(jMenu2);
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_sair)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        retorno = "";
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void Tabela_ClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabela_ClientesMouseClicked
//        System.out.println("Click: ");
        RetornaCliente();
        if(linha < 0)
            return;
        if(evt.getButton() == MouseEvent.BUTTON3)
            if(somostra.equals("N")){
                if(parametrosNS.bu.nivelUsuario < 4)
                    bt_alterar.setVisible(false);
                MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        if(evt.getClickCount() < 2)
            return;
        SetaParametrosRetornoCliente();
        dispose();
    }//GEN-LAST:event_Tabela_ClientesMouseClicked

    private void bt_detalhesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesItemActionPerformed
        if(CliCad != null){
            CliCad.setState(JFrame.NORMAL);
            return;
        }
        CliCad = new ClientesCadastro("S", Integer.parseInt(retorno));
        CliCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesItemActionPerformed

    private void txt_nomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nomeKeyReleased
        textoBusca = txt_nome.getText();
        if(textoBusca.equals("")){
            index = 0;
            sql = "select idCliente, idEmpresa, codigoGrupo, codigoEmpresa, codigoCliente, nome, cpfCnpj from tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
            PegaClientes();
            return;
        }
        index = 1;
        PegaClientes();
    }//GEN-LAST:event_txt_nomeKeyReleased

    private void bt_cadastroClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastroClientesActionPerformed
        if(CliCad != null)if(CliCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        CliCad = new ClientesCadastro("SN", 0);
        CliCad.setVisible(true);
    }//GEN-LAST:event_bt_cadastroClientesActionPerformed

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        TableClientes       = (DefaultTableModel)Tabela_Clientes.getModel();
        index = 0;
        PegaClientes();
        
        txt_nome.grabFocus();
        
        if(parametrosNS.bu.nivelUsuario  < 4 | somostra.equals("S"))
            jMenu.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(CliCad   != null)CliCad.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        if(CliCad != null)if(CliCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        CliCad = new ClientesCadastro("SN", Integer.parseInt(retorno));
        CliCad.setVisible(true);
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    private void Tabela_ClientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tabela_ClientesKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        RetornaCliente();
        if(linha < 0)
            return;
        SetaParametrosRetornoCliente();
        dispose();
    }//GEN-LAST:event_Tabela_ClientesKeyPressed
    
    private void SetaParametrosRetornoCliente(){
        if(!retorno.equals("")){
            parametrosNS.codigoCliente = Integer.parseInt(retorno);
            parametrosNS.cpfCnpj       = "";
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JTable Tabela_Clientes;
    private javax.swing.JMenuItem bt_alterar;
    private javax.swing.JMenuItem bt_cadastroClientes;
    private javax.swing.JMenuItem bt_detalhesItem;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextField txt_nome;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
    private void RetornaCliente(){
        linha = Tabela_Clientes.getSelectedRow();
        if(linha < 0){
            Mensagem = "Cliente não selecionado!";
            new MostraMensagem(Mensagem);
            return;
        }
        retorno = String.valueOf(Integer.parseInt(String.valueOf(Tabela_Clientes.getValueAt(linha, 0))));
//        System.out.println(linha + " - " + retorno);
        if(retorno.equals("null"))
            retorno = "";
    }
    
}
