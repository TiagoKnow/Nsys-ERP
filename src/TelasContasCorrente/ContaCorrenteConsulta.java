package TelasContasCorrente;

import BeansNS.BeanBanco;
import Beans.BeanContaCorrente;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import BeansNS.BeanEmpresas;
import Parametros.parametrosNS;
import com.sun.glass.events.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 @author Tiago e Paulo
 */
public class ContaCorrenteConsulta extends javax.swing.JFrame {
    //int's
    int     linha      = 0;
    int     abriuConta = 0;
    int     index      = 0;
    
    //String's
    String  sql           = "";
    String  sqlstate      = "";
    String  retorno       = "";
    String  mensagem      = "";
    String  somostra      = "";
    String  preenchimento = "";
    String  textoBusca    = "";
    
    //Vetores
    ArrayList            parametros                = new ArrayList();
//    ArrayList            dadosPadroes              = new ArrayList();
    ArrayList<ArrayList> dadosEmpresas             = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosBanco                = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosContaCorrente        = new ArrayList<ArrayList>();
    
    //Bean's
    BeanBanco                   bb      = new BeanBanco();
    BeanEmpresas                be      = new BeanEmpresas();
    BeanContaCorrente           bcc     = new BeanContaCorrente();
    
    //Especiais
    DefaultTableModel           TableContaCorrente;
    FormataCampo                fc      = new FormataCampo();
    
    //Telas
    ContaCorrenteCadastro       ConCorCad;
    
    public ContaCorrenteConsulta(String Somostra){
        somostra    = Somostra;
        
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
        tabela_contaCorrente = new javax.swing.JTable();
        txt_descricao = new javax.swing.JTextField();
        bt_sair = new javax.swing.JButton();
        check_todasEmpresas = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair1 = new javax.swing.JMenuItem();

        bt_detalhes.setText("Detalhes");
        bt_detalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_detalhesActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_detalhes);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Contas Correntes");
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
        jLabel1.setText("Contas Correntes");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_contaCorrente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_contaCorrente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Seq", "Descricao", "Nome da Empresa", "Nome do Banco", "N° da Agência", "N° da Conta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_contaCorrente.getTableHeader().setReorderingAllowed(false);
        tabela_contaCorrente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_contaCorrenteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_contaCorrente);
        if (tabela_contaCorrente.getColumnModel().getColumnCount() > 0) {
            tabela_contaCorrente.getColumnModel().getColumn(0).setResizable(false);
            tabela_contaCorrente.getColumnModel().getColumn(0).setPreferredWidth(0);
            tabela_contaCorrente.getColumnModel().getColumn(1).setResizable(false);
            tabela_contaCorrente.getColumnModel().getColumn(1).setPreferredWidth(80);
            tabela_contaCorrente.getColumnModel().getColumn(2).setResizable(false);
            tabela_contaCorrente.getColumnModel().getColumn(2).setPreferredWidth(225);
            tabela_contaCorrente.getColumnModel().getColumn(3).setResizable(false);
            tabela_contaCorrente.getColumnModel().getColumn(3).setPreferredWidth(300);
            tabela_contaCorrente.getColumnModel().getColumn(4).setResizable(false);
            tabela_contaCorrente.getColumnModel().getColumn(4).setPreferredWidth(200);
            tabela_contaCorrente.getColumnModel().getColumn(5).setResizable(false);
            tabela_contaCorrente.getColumnModel().getColumn(5).setPreferredWidth(150);
            tabela_contaCorrente.getColumnModel().getColumn(6).setResizable(false);
            tabela_contaCorrente.getColumnModel().getColumn(6).setPreferredWidth(150);
        }

        txt_descricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_descricaoKeyReleased(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
                    .addComponent(txt_descricao))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addComponent(txt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        check_todasEmpresas.setText("Todas Empresas");
        check_todasEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_todasEmpresasActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        bt_sair1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        bt_sair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair1.setText("Sair");
        bt_sair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sair1ActionPerformed(evt);
            }
        });
        jMenu1.add(bt_sair1);

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(check_todasEmpresas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_sair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_sair)
                    .addComponent(check_todasEmpresas))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        retorno = "";
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void tabela_contaCorrenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_contaCorrenteMouseClicked
        if(tabela_contaCorrente.isEnabled() == false){
            return;
        }
        linha           = tabela_contaCorrente.getSelectedRow();
        if(linha < 0){
            mensagem = "Item não selecionado!";
            new MostraMensagem(mensagem);
            return;
        }
        if(evt.getButton() == MouseEvent.BUTTON3){
            if(somostra.equals("N")){
                MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
        retorno = String.valueOf(Integer.parseInt(String.valueOf(tabela_contaCorrente.getValueAt(linha, 1))));
        if(evt.getClickCount() < 2){
            return;
        }
        dispose();
    }//GEN-LAST:event_tabela_contaCorrenteMouseClicked

    private void bt_detalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesActionPerformed
        if(ConCorCad != null)if(ConCorCad.isVisible()){
            mensagem = "Tela já Aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        abriuConta = 1;
        ConCorCad = new ContaCorrenteCadastro("S", Integer.parseInt(retorno));
        ConCorCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
        if(abriuConta == 0){
            return;
        }
        preenchimento = "cc.codigoGrupo = " + parametrosNS.bge.codigoGrupo;
        if(check_todasEmpresas.isSelected() == false){
            preenchimento += " and cc.codigoEmpresa = " + parametrosNS.be.CodigoEmpresa;
        }
        sql = "select * from tb_contacorrente where codigoGrupo = " + parametrosNS.bge.codigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " order by idEmpresa, codigoContaCorrente asc;";
        PegaContaCorrente();
    }//GEN-LAST:event_formWindowGainedFocus

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(parametrosNS.bu.nivelUsuario < 4){
            check_todasEmpresas.setVisible(false);
        }
        TableContaCorrente = (DefaultTableModel)tabela_contaCorrente.getModel();
        preenchimento = "cc.codigoGrupo = " + parametrosNS.bge.codigoGrupo;
        if(check_todasEmpresas.isSelected() == false){
            preenchimento += " and cc.codigoEmpresa = " + parametrosNS.be.CodigoEmpresa;
        }
        index = 0;
        PegaContaCorrente();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(ConCorCad    != null){ConCorCad.dispose();}
    }//GEN-LAST:event_formWindowClosed

    private void check_todasEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_todasEmpresasActionPerformed
        tabela_contaCorrente.setEnabled     (true);
        tabela_contaCorrente.setFocusable   (true);
        if(check_todasEmpresas.isSelected()){
            tabela_contaCorrente.setEnabled     (false);
            tabela_contaCorrente.setFocusable   (false);
        }
        preenchimento = "cc.codigoGrupo = " + parametrosNS.bge.codigoGrupo;
        if(check_todasEmpresas.isSelected() == false){
            preenchimento += " and cc.codigoEmpresa = " + parametrosNS.be.CodigoEmpresa;
        }
        textoBusca   = txt_descricao.getText();
        if(textoBusca.replace(" ", "").equals("")){
            index = 0;
            PegaContaCorrente();
            return;
        }
        index = 1;
        PegaContaCorrente();
    }//GEN-LAST:event_check_todasEmpresasActionPerformed

    private void txt_descricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descricaoKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_CAPS_LOCK){
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_SHIFT){
            return;
        }
        preenchimento = "cc.codigoGrupo = " + parametrosNS.bge.codigoGrupo;
        if(check_todasEmpresas.isSelected() == false){
            preenchimento += " and cc.codigoEmpresa = " + parametrosNS.be.CodigoEmpresa;
        }
        textoBusca   = txt_descricao.getText();
        if(textoBusca.replace(" ", "").equals("")){
            index = 0;
            PegaContaCorrente();
            return;
        }
        index = 1;
        PegaContaCorrente();
    }//GEN-LAST:event_txt_descricaoKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_detalhes;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JCheckBox check_todasEmpresas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_contaCorrente;
    private javax.swing.JTextField txt_descricao;
    // End of variables declaration//GEN-END:variables
    
    public String getRetornoContaCorrente(){
        return retorno;
    }
    
    private void PegaContaCorrente(){
        tabela_contaCorrente.getColumnModel().getColumn(0).setMaxWidth(0);  //Ocultar a CI de controle 25/04/2017
        tabela_contaCorrente.getColumnModel().getColumn(0).setMinWidth(0);  
        tabela_contaCorrente.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);  
        tabela_contaCorrente.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0); 
        
        tabela_contaCorrente.getColumnModel().getColumn(1).setResizable(false);
        tabela_contaCorrente.getColumnModel().getColumn(1).setPreferredWidth(80);
        tabela_contaCorrente.getColumnModel().getColumn(2).setResizable(false);
        tabela_contaCorrente.getColumnModel().getColumn(2).setPreferredWidth(225);
        tabela_contaCorrente.getColumnModel().getColumn(3).setResizable(false);
        tabela_contaCorrente.getColumnModel().getColumn(3).setPreferredWidth(300);
        tabela_contaCorrente.getColumnModel().getColumn(4).setResizable(false);
        tabela_contaCorrente.getColumnModel().getColumn(4).setPreferredWidth(200);
        tabela_contaCorrente.getColumnModel().getColumn(5).setResizable(false);
        tabela_contaCorrente.getColumnModel().getColumn(5).setPreferredWidth(150);
        tabela_contaCorrente.getColumnModel().getColumn(6).setResizable(false);
        tabela_contaCorrente.getColumnModel().getColumn(6).setPreferredWidth(150);
        
        sql = "select " +
              "   cc.idContaCorrente, " +
              "   cc.idEmpresa, " +
              "   cc.codigoGrupo, " +
              "   cc.codigoEmpresa, " +
              "   cc.codigoContaCorrente, " +
              "   cc.idBanco, " +
              "   cc.numeroAgencia, " +
              "   cc.digitoVerificadorAgencia, " +
              "   cc.numeroContaCorrente, " +
              "   cc.digitoVerificador, " +
              "   cc.descricao, " +
              "   nsemp.nomeEmpresa, " +
              "   nsemp.nomeFantasia, " +
              "   nsemp.cnpjEmpresa, " +
              "   nsban.nomeBanco, " +
              "   nsban.codigoBanco " +
              "from ns_empresas nsemp " +
              "   left join tb_contacorrente cc on (nsemp.idEmpresa = cc.idEmpresa) " +
              "   left join ns_bancos nsban on (nsban.id = cc.idBanco) ";
        switch(index){
            case 1:  sql += "where " + preenchimento + " and cc.descricao like '%"           + textoBusca + "%'"; break;
            case 2:  sql += "where " + preenchimento + " and nsemp.codigoEmpresa like 1%"    + textoBusca + "%'"; break;
            case 3:  sql += "where " + preenchimento + " and nsemp.nomeEmpresa like '%"      + textoBusca + "%'"; break;
            case 4:  sql += "where " + preenchimento + " and nsban.codigoBanco like '%"      + textoBusca + "%'"; break;
            case 5:  sql += "where " + preenchimento + " and nsban.nomeBanco like '%"        + textoBusca + "%'"; break;
            case 6:  sql += "where " + preenchimento + " and cc.numeroAgencia like '%"       + textoBusca + "%'"; break;
            case 7:  sql += "where " + preenchimento + " and cc.numeroContaCorrente like '%" + textoBusca + "%'"; break;
            default: sql += "where " + preenchimento; break;
        }
        if(somostra.equalsIgnoreCase("P")){
            sql += " and cc.contaCorrentePadrao = 1";
        }
        sql += " order by cc.idEmpresa, cc.codigoContaCorrente asc;";
        dadosContaCorrente.clear();
        dadosContaCorrente = parametrosNS.dao.Consulta(sql);
        if(dadosContaCorrente.isEmpty()){
            if(textoBusca.equals("")){
                return;
            }
            index++;
            if(index < 8){
                PegaContaCorrente();
                return;
            }
        }
        PegaDadosConteCorrente();
    }
    
    private void PegaDadosConteCorrente(){
        TableContaCorrente.setNumRows(0);
        String seq                  = "";
        String NumeroAgencia        = "";
        String NumeroContaCorrente  = "";
        for(int i = 0; i < dadosContaCorrente.size(); i++){
            bcc = new BeanContaCorrente();
            be  = new BeanEmpresas();
            bb  = new BeanBanco();
            if(dadosContaCorrente.get(i).get(0) != null){
                bcc.idContaCorrente             = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(0)));
            }
            if(dadosContaCorrente.get(i).get(1) != null){
                bcc.idEmpresa                   = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(1)));
            }
            if(dadosContaCorrente.get(i).get(2) != null){
                bcc.codigoGrupo                 = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(2)));
            }
            if(dadosContaCorrente.get(i).get(3) != null){
                bcc.codigoEmpresa               = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(3)));
            }
            if(dadosContaCorrente.get(i).get(4) != null){
                bcc.codigoContaCorrente         = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(4)));
            }
            if(dadosContaCorrente.get(i).get(5) != null){
                bcc.idBanco                     = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(5)));
            }
            if(dadosContaCorrente.get(i).get(6) != null){
                bcc.numeroAgencia               = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(6)));
            }
            if(dadosContaCorrente.get(i).get(7) != null){
                bcc.digitoVerificadorAgencia    = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(7)));
            }
            if(dadosContaCorrente.get(i).get(8) != null){
                bcc.numeroContaCorrente         = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(8)));
            }
            if(dadosContaCorrente.get(i).get(9) != null){
                bcc.digitoVerificador           = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(9)));
            }
            if(dadosContaCorrente.get(i).get(10) != null){
                bcc.descricao                   =                    String.valueOf(dadosContaCorrente.get(i).get(10));
            }
            
            be.CodigoGrupo   = bcc.codigoGrupo;
            be.CodigoEmpresa = bcc.codigoEmpresa;
            be.NomeEmpresa   =                    String.valueOf(dadosContaCorrente.get(i).get(11));
            be.NomeFantasia  =                    String.valueOf(dadosContaCorrente.get(i).get(12));
            be.CnpjEmpresa   =                    String.valueOf(dadosContaCorrente.get(i).get(13));
            
            bb.idBanco       = bcc.idBanco;
            bb.nomeBanco     =                    String.valueOf(dadosContaCorrente.get(i).get(14));
            bb.codigoBanco   =                    String.valueOf(dadosContaCorrente.get(i).get(15));
            
            NumeroAgencia       = String.valueOf(bcc.numeroAgencia);
            if(bb.codigoBanco.equals("001"))NumeroAgencia  = fc.FormataCampo(NumeroAgencia, 4, 0) + "-" + bcc.digitoVerificadorAgencia;
            if(bb.codigoBanco.equals("033"))NumeroAgencia  = fc.FormataCampo(NumeroAgencia, 4, 0) + "-" + bcc.digitoVerificadorAgencia;
            if(bb.codigoBanco.equals("237"))NumeroAgencia  = fc.FormataCampo(NumeroAgencia, 4, 0) + "-" + bcc.digitoVerificadorAgencia;
            if(bb.codigoBanco.equals("341"))NumeroAgencia  = fc.FormataCampo(NumeroAgencia, 4, 0);
            if(bb.codigoBanco.equals("399"))NumeroAgencia  = fc.FormataCampo(NumeroAgencia, 4, 0);
            if(bb.codigoBanco.equals("999"))NumeroAgencia  = "";
            
            NumeroContaCorrente = String.valueOf(bcc.numeroContaCorrente);
            if(bb.codigoBanco.equals("001"))NumeroContaCorrente = fc.FormataCampo(NumeroContaCorrente, 8, 0) + "-" + bcc.digitoVerificador;
            if(bb.codigoBanco.equals("033"))NumeroContaCorrente = fc.FormataCampo(NumeroContaCorrente, 7, 0);
            if(bb.codigoBanco.equals("237"))NumeroContaCorrente = fc.FormataCampo(NumeroContaCorrente, 7, 0) + "-" + bcc.digitoVerificador;
            if(bb.codigoBanco.equals("341"))NumeroContaCorrente = fc.FormataCampo(NumeroContaCorrente, 5, 0) + "-" + bcc.digitoVerificador;
            if(bb.codigoBanco.equals("399"))NumeroContaCorrente = fc.FormataCampo(NumeroContaCorrente, 7, 0);
            if(bb.codigoBanco.equals("999"))NumeroContaCorrente = "";
            
            seq = fc.FormataCampo(String.valueOf(bcc.codigoContaCorrente), 6, 0);
            if(check_todasEmpresas.isSelected()){
                seq = fc.FormataCampo(String.valueOf(i + 1), 6, 0);
            }
            
            TableContaCorrente.addRow(new Object[] {fc.FormataCampo(String.valueOf(bcc.idContaCorrente), 9, 0), seq, bcc.descricao, fc.FormataCampo(String.valueOf(be.CodigoEmpresa), 3, 0) + "-" + be.NomeEmpresa, bb.codigoBanco + "-" + bb.nomeBanco, NumeroAgencia, NumeroContaCorrente});
        }
    }
    
}
