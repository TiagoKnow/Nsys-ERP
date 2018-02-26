package TelasFaturamento;

import Beans.BeanClientes;
import Beans.BeanClientesHistorico;
import Beans.BeanIntervalos;
import Beans.BeanUsuarios;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.TestarData;
import Parametros.parametrosNS;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 @author Tiago e Paulo
 */
public class HistoricoConsulta extends javax.swing.JFrame {
    //String's
    String sql                              = "";
    String sqlstate                         = "";
    String Mensagem                         = "";
    
    //ArrayList's
    ArrayList            parametros                    = new ArrayList();
    ArrayList            dadosPadroes                  = new ArrayList();
    ArrayList<ArrayList> dadosHistorico                = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosUsuario                  = new ArrayList<ArrayList>();
    
    //Beans
    BeanClientes                    bc      = new BeanClientes();
    BeanClientesHistorico           bhis    = new BeanClientesHistorico();
    BeanIntervalos                  binter  = new BeanIntervalos();
    BeanUsuarios                    bu      = new BeanUsuarios();
    
    //Especiais
    DefaultTableModel               TableHistorico;
    FormataCampo                    fc      = new FormataCampo();
    InverterData                    invdata = new InverterData();
    TestarData                      Test    = new TestarData();
    
    //Telas
    
    public HistoricoConsulta(ArrayList DadosPadroes){
        dadosPadroes = DadosPadroes;
        
        bc.codigoCliente    = (int)     dadosPadroes.get(0);
        
        initComponents();
    }
    
    private void InicializaCampos(){
        txt_codigoClienteInicial    .setText(fc.FormataCampo("", 5, 0));
        txt_codigoClienteFinal      .setText("99999");
        txt_dataCadastroInicial     .setText(fc.FormataCampo("", 10, 2));
        txt_dataCadastroFinal       .setText("99999999");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_historico = new javax.swing.JTable();
        bt_sair = new javax.swing.JButton();
        bt_processa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigoClienteInicial = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_codigoClienteFinal = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_dataCadastroFinal = new javax.swing.JFormattedTextField();
        txt_dataCadastroInicial = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_codigoUsuarioInicial = new javax.swing.JFormattedTextField();
        txt_codigoUsuarioFinal = new javax.swing.JFormattedTextField();
        bt_pesquisaClienteInicial = new javax.swing.JButton();
        bt_pesquisaClienteFinal = new javax.swing.JButton();
        bt_pesquisaUsuarioInicial = new javax.swing.JButton();
        bt_pesquisaUsuarioFinal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Históricos");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dados de Históricos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_historico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Data de Cadastro", "Descrição do Histórico"
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
        tabela_historico.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_historico.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabela_historico);
        if (tabela_historico.getColumnModel().getColumnCount() > 0) {
            tabela_historico.getColumnModel().getColumn(0).setResizable(false);
            tabela_historico.getColumnModel().getColumn(1).setResizable(false);
            tabela_historico.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 993, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        bt_processa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/1280454766_system-software-update.png"))); // NOI18N
        bt_processa.setText("Processa");
        bt_processa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_processaActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Intervalos de Consulta    F11[Geral]");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Final");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Inicial");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Cliente:");

        try {
            txt_codigoClienteInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoClienteInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoClienteInicial.setText("00000");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Inicial");

        try {
            txt_codigoClienteFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoClienteFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoClienteFinal.setText("99999");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Data de Cadastro:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Final");

        try {
            txt_dataCadastroFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataCadastroFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataCadastroFinal.setText("99/99/9999");

        try {
            txt_dataCadastroInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataCadastroInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataCadastroInicial.setText("00/00/0000");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Incluso Por:");

        try {
            txt_codigoUsuarioInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoUsuarioInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoUsuarioInicial.setText("000");

        try {
            txt_codigoUsuarioFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoUsuarioFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoUsuarioFinal.setText("999");

        bt_pesquisaClienteInicial.setText("...");

        bt_pesquisaClienteFinal.setText("...");

        bt_pesquisaUsuarioInicial.setText("...");

        bt_pesquisaUsuarioFinal.setText("...");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_dataCadastroInicial)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_codigoClienteInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bt_pesquisaClienteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_codigoClienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_pesquisaClienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_codigoUsuarioInicial)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                        .addGap(3, 3, 3)
                        .addComponent(bt_pesquisaUsuarioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_codigoUsuarioFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisaUsuarioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_dataCadastroFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel4, txt_codigoClienteFinal, txt_codigoClienteInicial});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel6, jLabel7, txt_codigoUsuarioFinal, txt_codigoUsuarioInicial});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_codigoClienteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoClienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txt_codigoUsuarioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoUsuarioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaClienteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaClienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaUsuarioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaUsuarioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_dataCadastroInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dataCadastroFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaClienteFinal, bt_pesquisaClienteInicial, bt_pesquisaUsuarioFinal, bt_pesquisaUsuarioInicial, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel9, txt_codigoClienteFinal, txt_codigoClienteInicial, txt_codigoUsuarioFinal, txt_codigoUsuarioInicial, txt_dataCadastroFinal, txt_dataCadastroInicial});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bt_processa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_sair))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_processa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        TableHistorico = (DefaultTableModel)tabela_historico.getModel();
        InicializaCampos();
        if(bc.codigoCliente != 0){
            txt_codigoClienteInicial    .setText(fc.FormataCampo(String.valueOf(bc.codigoCliente), 5, 0));
            txt_codigoClienteInicial    .setEditable    (false);
            txt_codigoClienteInicial    .setFocusable   (false);
            bt_pesquisaClienteInicial   .setEnabled     (false);
            bt_pesquisaClienteInicial   .setFocusable   (false);
            txt_codigoClienteFinal      .setText(fc.FormataCampo(String.valueOf(bc.codigoCliente), 5, 0));
            txt_codigoClienteFinal      .setEditable    (false);
            txt_codigoClienteFinal      .setFocusable   (false);
            bt_pesquisaClienteFinal     .setEnabled     (false);
            bt_pesquisaClienteFinal     .setFocusable   (false);
        }
        PegaValores();
        bt_processa.grabFocus();
    }//GEN-LAST:event_formWindowOpened

    private void bt_processaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_processaActionPerformed
        PegaValores();
    }//GEN-LAST:event_bt_processaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_pesquisaClienteFinal;
    private javax.swing.JButton bt_pesquisaClienteInicial;
    private javax.swing.JButton bt_pesquisaUsuarioFinal;
    private javax.swing.JButton bt_pesquisaUsuarioInicial;
    private javax.swing.JButton bt_processa;
    private javax.swing.JButton bt_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_historico;
    private javax.swing.JFormattedTextField txt_codigoClienteFinal;
    private javax.swing.JFormattedTextField txt_codigoClienteInicial;
    private javax.swing.JFormattedTextField txt_codigoUsuarioFinal;
    private javax.swing.JFormattedTextField txt_codigoUsuarioInicial;
    private javax.swing.JFormattedTextField txt_dataCadastroFinal;
    private javax.swing.JFormattedTextField txt_dataCadastroInicial;
    // End of variables declaration//GEN-END:variables
    
    private void PegaValores(){
        binter.clienteInicial       = Integer.parseInt(txt_codigoClienteInicial.getText());
        binter.clienteFinal         = Integer.parseInt(txt_codigoClienteFinal.getText());
        if(binter.clienteInicial > binter.clienteFinal){
            Mensagem = "Cliente Inicial não pode ser maior do que o Cliente Final!";
            new MostraMensagem(Mensagem);
            txt_codigoClienteInicial.grabFocus();
            return;
        }
        
        binter.usuarioInicial       = Integer.parseInt(txt_codigoUsuarioInicial.getText());
        binter.usuarioFinal         = Integer.parseInt(txt_codigoUsuarioFinal.getText());
        if(binter.usuarioInicial > binter.usuarioFinal){
            Mensagem = "Usuário Inicial não pode ser maior do que o Usuário Final";
            new MostraMensagem(Mensagem);
            txt_codigoUsuarioInicial.grabFocus();
            return;
        }
        
        binter.dataCadastroInicial  = Test.Testa(txt_dataCadastroInicial.getText());
        binter.dataCadastroFinal    = Test.Testa(txt_dataCadastroFinal.getText());
        if(binter.dataCadastroInicial > binter.dataCadastroFinal){
            Mensagem = "Data de Cadastro Inicial não pode ser maior do que a data de Cadastro Final!";
            new MostraMensagem(Mensagem);
            txt_dataCadastroInicial.grabFocus();
            return;
        }
        
        MontaSQL();
    }
    
    private void MontaSQL(){
        sql = "select " +
                "  cli.idCliente, " +
                "  cli.idEmpresa, " +
                "  cli.codigoGrupo, " +
                "  cli.codigoEmpresa, " +
                "  cli.codigoCliente, " +
                "  cli.nome, " +
                "  clih.codigoHistorico, " +
                "  clih.descricaoHistorico, " +
                "  clih.codigoUsuario, " +
                "  clih.dataCadastro, " +
                "  clih.horaCadastro, " +
                "  usu.usuario " +
                "from " +
                "  tb_clientes cli" +
                "  inner join tb_clientes_historico clih on ((cli.idEmpresa = clih.idEmpresa) and (cli.codigoCliente = clih.codigoCliente))" +
                "  inner join tb_usuarios usu on ((clih.idEmpresa = usu.idEmpresa) and (clih.codigoUsuario = usu.codigoUsuario))" +
                "  where cli.idEmpresa = " + parametrosNS.be.IdEmpresa + " and " +
                "    cli.codigoCliente between "    + binter.clienteInicial         + " and " + binter.clienteFinal         + " and " +
                "    clih.codigoUsuario between "   + binter.usuarioInicial         + " and " + binter.usuarioFinal         + " and " +
                "    clih.dataCadastro between "    + binter.dataCadastroInicial    + " and " + binter.dataCadastroFinal    + ";";
        dadosHistorico.clear();
        dadosHistorico = parametrosNS.dao.Consulta(sql);
        PegaDadosHistorico();
    }
    
    private void PegaDadosHistorico(){
        tabela_historico.getColumnModel().getColumn(0).setResizable(true);
        tabela_historico.getColumnModel().getColumn(0).setPreferredWidth(300);
        tabela_historico.getColumnModel().getColumn(1).setResizable(false);
        tabela_historico.getColumnModel().getColumn(1).setPreferredWidth(125);
        tabela_historico.getColumnModel().getColumn(2).setResizable(true);
        tabela_historico.getColumnModel().getColumn(2).setPreferredWidth(500);
        
        TableHistorico.setNumRows(0);
        for(int i = 0; i < dadosHistorico.size(); i++){
            bhis    = new BeanClientesHistorico();
            bc      = new BeanClientes();
            bu      = new BeanUsuarios();
            
            bc.idCliente                = Integer.parseInt(  String.valueOf(dadosHistorico.get(i).get(0)));
            bc.idEmpresa                = Integer.parseInt(  String.valueOf(dadosHistorico.get(i).get(1)));
            bc.codigoGrupo              = Integer.parseInt(  String.valueOf(dadosHistorico.get(i).get(2)));
            bc.codigoEmpresa            = Integer.parseInt(  String.valueOf(dadosHistorico.get(i).get(3)));
            bc.codigoCliente            = Integer.parseInt(  String.valueOf(dadosHistorico.get(i).get(4)));
            bc.nome                     =                    String.valueOf(dadosHistorico.get(i).get(5));
            bhis.codigoHistorico        = Integer.parseInt(  String.valueOf(dadosHistorico.get(i).get(6)));
            bhis.descricaoHistorico     =                    String.valueOf(dadosHistorico.get(i).get(7));
            bhis.codigoUsuario          = Integer.parseInt(  String.valueOf(dadosHistorico.get(i).get(8)));
            bhis.dataCadastro           =                    String.valueOf(dadosHistorico.get(i).get(9));
            bhis.horaCadastro           =                    String.valueOf(dadosHistorico.get(i).get(10));
            bu.usuario                  =                    String.valueOf(dadosHistorico.get(i).get(11));
            
            bhis.dataCadastro           = invdata.inverterData(bhis.dataCadastro, 1) + " " + bhis.horaCadastro;
            
            TableHistorico.addRow(new Object [] {fc.FormataCampo(String.valueOf(bc.codigoCliente), 5, 0) + "-" + bc.nome, bhis.dataCadastro, bhis.descricaoHistorico});
        }
    }
    
}
