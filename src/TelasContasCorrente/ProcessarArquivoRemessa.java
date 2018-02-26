package TelasContasCorrente;

import BeansNS.BeanBanco;
import Beans.BeanBoletos;
import Beans.BeanClientes;
import Beans.BeanIntervalos;
import Beans.BeanUsuarios;
import FuncoesInternas.ArquivoRemessaBradesco;
import FuncoesInternas.ArquivoRemessaItau;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.TestarData;
import Parametros.parametrosNS;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/*
 @author Tiago e Paulo 05/08/2016 as 23:00
 */
public class ProcessarArquivoRemessa extends javax.swing.JFrame {
    //Int's
    int TotalBoletos                    = 0;
    int TotalBoletosPendentes           = 0;
    int abriuDigitadoUsuario            = 0;
    
    //String
    String Mensagem                     = "";
    String somostra                     = "";
    String fazManutencao                = "";
    String sql                          = "";
    String Campo                        = "";
    String ocorrencia                   = "";
    
    //Float
    double ValorTotalBoletos            = 0;
    double ValorTotalBoletosPagos       = 0;
    double ValorTotalBoletosPendentes   = 0;
    
    //Beans
    BeanBanco                           bb      = new BeanBanco();
    BeanBoletos                         bbol    = new BeanBoletos();
    BeanClientes                        bc      = new BeanClientes();
    BeanUsuarios                        bu      = new BeanUsuarios();
    BeanIntervalos                      binter  = new BeanIntervalos();
    
    //Vetores
    ArrayList            parametros                        = new ArrayList();
    ArrayList            dadosPadroes                      = new ArrayList();
    ArrayList<ArrayList> dadosBoletos                      = new ArrayList();
    ArrayList<ArrayList> dadosCliente                      = new ArrayList();
    ArrayList<ArrayList> dadosUsuario                      = new ArrayList();
    ArrayList            dadosRegistro                     = new ArrayList();
    
    //Funções
    InverterData                invdata                 = new InverterData();
    NumberFormat                nf                      = new DecimalFormat("R$ ###,##0.00");
    FormataCampo                fc                      = new FormataCampo();
    TestarData                  Test                    = new TestarData();
    ArquivoRemessaItau          GerarRemessaItau        = new ArquivoRemessaItau();
    ArquivoRemessaBradesco      GerarRemessaBradesco    = new ArquivoRemessaBradesco();
    
    //DefaultTableModel
    DefaultTableModel   tbBoletos;
    
    //Telas
    
    public ProcessarArquivoRemessa(ArrayList DadosPadroes){
        dadosPadroes                            = DadosPadroes;
        
        bb.codigoBanco                          = (String)  dadosPadroes.get(0);
        somostra                                = (String)  dadosPadroes.get(1);
        fazManutencao                           = (String)  dadosPadroes.get(2);
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_boletos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_totalBoletos = new javax.swing.JTextField();
        txt_totalBoletosPendentes = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        bt_sair = new javax.swing.JButton();
        bt_gerar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerar Arquivo de Remessa");
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

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Boletos do Sistema");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_boletos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_boletos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Boleto", "Cliente", "Tipo Faturamento", "Data de Emissão", "Descrição", "Valor Devido", "Data de Vencimento", "Ocorrência"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_boletos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_boletos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabela_boletos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Total de Boletos Listados: ");

        txt_totalBoletos.setEditable(false);
        txt_totalBoletos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        txt_totalBoletosPendentes.setEditable(false);
        txt_totalBoletosPendentes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Total de Boletos Reenviados: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_totalBoletos, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_totalBoletosPendentes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(368, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_totalBoletos, txt_totalBoletosPendentes});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txt_totalBoletosPendentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txt_totalBoletos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel4, txt_totalBoletos, txt_totalBoletosPendentes});

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        bt_gerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Document.png"))); // NOI18N
        bt_gerar.setText("Gerar Remessa");
        bt_gerar.setEnabled(false);
        bt_gerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_gerarActionPerformed(evt);
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_gerar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_gerar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tbBoletos = (DefaultTableModel)tabela_boletos.getModel();
        MontaSQL();
    }//GEN-LAST:event_formWindowOpened

    private void bt_gerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_gerarActionPerformed
        if(bb.codigoBanco.equals("341"))GeraRemessaItau();
        if(bb.codigoBanco.equals("237"))GeraRemessaBradesco();
    }//GEN-LAST:event_bt_gerarActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
    }//GEN-LAST:event_formWindowGainedFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_gerar;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_boletos;
    private javax.swing.JTextField txt_totalBoletos;
    private javax.swing.JTextField txt_totalBoletosPendentes;
    // End of variables declaration//GEN-END:variables
    
    private void PegaCliente() {
        sql = "select idCliente, idEmpresa, codigoGrupo, codigoEmpresa, codigoCliente, nome from tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCliente = " + bc.codigoCliente + ";";
        dadosCliente.clear();
        dadosCliente = parametrosNS.dao.Consulta(sql);
        if(dadosCliente.isEmpty()){
            Mensagem = "Erro ao consultar o cliente: " + bc.codigoCliente + "";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosCliente();
    }
    
    private void PegaDadosCliente(){
        for(int i = 0; i < dadosCliente.size(); i++){
            bc.idCliente            = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(0)));
            bc.idEmpresa            = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(1)));
            bc.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(2)));
            bc.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(3)));
            bc.codigoCliente        = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(4)));
            bc.nome                 =                    String.valueOf(dadosCliente.get(i).get(5));
        }
    }
    
    private void PegaUsuario() {
        sql = "select usuario from tb_usuarios where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoUsuario = '" + bu.codigoUsuario + "'";
        dadosUsuario.clear();
        dadosUsuario = parametrosNS.dao.Consulta(sql);
        if(dadosUsuario.isEmpty()){
            Mensagem = "Erro ao consultar o cliente: " + bu.codigoUsuario + "";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosUsuario();
    }
    
    private void PegaDadosUsuario(){
        for(int i = 0; i < dadosUsuario.size(); i++)
            bu.usuario = String.valueOf(  dadosUsuario.get(i).get(0));
    }
    
    private void MontaSQL(){
        sql =   "select * from tb_boletos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and substring(CodigoDeBarras, 1, 3) = '" + bb.codigoBanco + "' and ((statusBoleto = 0 and ocorrenciaRemessa = 1) or (statusBoleto = 2 and (ocorrenciaRemessa = 3 or ocorrenciaRemessa = 17 or ocorrenciaRemessa = 31)));";
        bt_gerar.setEnabled(false);
        dadosBoletos.clear();
        dadosBoletos = parametrosNS.dao.Consulta(sql);
        PegaBoletos();
    }
    
    private void PegaBoletos(){
        tabela_boletos.getColumnModel().getColumn(0) .setPreferredWidth(90);    //codigoBoleto    
        tabela_boletos.getColumnModel().getColumn(1) .setPreferredWidth(300);   //Cliente     
        tabela_boletos.getColumnModel().getColumn(2) .setPreferredWidth(80);    //tipo de fatura   
        tabela_boletos.getColumnModel().getColumn(3) .setPreferredWidth(95);    //data de emissao
        tabela_boletos.getColumnModel().getColumn(4) .setPreferredWidth(270);   //descricao
        tabela_boletos.getColumnModel().getColumn(5) .setPreferredWidth(95);    //valor devido
        tabela_boletos.getColumnModel().getColumn(6) .setPreferredWidth(95);    //data de vencimento
        tabela_boletos.getColumnModel().getColumn(7) .setPreferredWidth(175);   //ocorrencia
        
        tbBoletos.setNumRows(0);
        TotalBoletos                = 0;
        ValorTotalBoletos           = 0;
        ValorTotalBoletosPendentes  = 0;
        
        for(int i = 0; i < dadosBoletos.size(); i++){
            bbol = new BeanBoletos();
            if(dadosBoletos.get(i).get(0) != null)
                bbol.idBoletos              = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(0)));
            if(dadosBoletos.get(i).get(1) != null)
                bbol.idEmpresa              = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(1)));
            if(dadosBoletos.get(i).get(2) != null)
                bbol.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(2)));
            if(dadosBoletos.get(i).get(3) != null)
                bbol.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(3)));
            if(dadosBoletos.get(i).get(4) != null)
                bbol.codigoBoleto           = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(4)));
            if(dadosBoletos.get(i).get(5) != null)
                bbol.codigoCliente          = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(5)));
            if(dadosBoletos.get(i).get(6) != null)
                bbol.codigoContaCorrente    = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(6)));
            if(dadosBoletos.get(i).get(7) != null)
                bbol.codigoBoletoInstrucao  = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(7)));
            if(dadosBoletos.get(i).get(8) != null)
                bbol.codigoUsuario          = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(8)));
            if(dadosBoletos.get(i).get(9) != null)
                bbol.codigoPagamento        = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(9)));
                bbol.tipoDeFaturamento      =                    String.valueOf(dadosBoletos.get(i).get(10));
                bbol.nossoNumero            =                    String.valueOf(dadosBoletos.get(i).get(11));
                bbol.dataEmissao            =                    String.valueOf(dadosBoletos.get(i).get(12));
                bbol.numeroDocumento        =                    String.valueOf(dadosBoletos.get(i).get(13));
                bbol.numeroDAC              =                    String.valueOf(dadosBoletos.get(i).get(14));
            if(dadosBoletos.get(i).get(15) != null)
                bbol.valorDevido            = Double.parseDouble(String.valueOf(dadosBoletos.get(i).get(15)));
                bbol.dataDeVencimento       =                    String.valueOf(dadosBoletos.get(i).get(16));
            if(dadosBoletos.get(i).get(17) != null)
                bbol.valorPago              = Double.parseDouble(String.valueOf(dadosBoletos.get(i).get(17)));
                bbol.dataDePagamento        =                    String.valueOf(dadosBoletos.get(i).get(18));
                bbol.Instrucao1             =                    String.valueOf(dadosBoletos.get(i).get(19));
                bbol.Instrucao3             =                    String.valueOf(dadosBoletos.get(i).get(20));
                bbol.CodigoDeBarras1        =                    String.valueOf(dadosBoletos.get(i).get(21));
                bbol.CodigoDeBarras2        =                    String.valueOf(dadosBoletos.get(i).get(22));
                bbol.CodigoDeBarras3        =                    String.valueOf(dadosBoletos.get(i).get(23));
                bbol.CodigoDeBarras4        =                    String.valueOf(dadosBoletos.get(i).get(24));
                bbol.CodigoDeBarras5        =                    String.valueOf(dadosBoletos.get(i).get(25));
                bbol.CodigoDeBarras         =                    String.valueOf(dadosBoletos.get(i).get(26));
            if(dadosBoletos.get(i).get(27) != null)
                bbol.ocorrenciaRemessa      = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(27)));
            if(dadosBoletos.get(i).get(28) != null)
                bbol.ocorrenciaRetorno      = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(28)));
            if(dadosBoletos.get(i).get(29) != null)
                bbol.ParcelaAtual           = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(29)));
            if(dadosBoletos.get(i).get(30) != null)
                bbol.TotalDeParcelas        = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(30)));
            if(dadosBoletos.get(i).get(31) != null)
                bbol.statusBoleto           = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(31)));
                bbol.dataAlterou            =                    String.valueOf(dadosBoletos.get(i).get(32));
                bbol.horaAlterou            =                    String.valueOf(dadosBoletos.get(i).get(33));
            if(dadosBoletos.get(i).get(34) != null)
                bbol.usuarioAlterou         = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(34)));
            if(dadosBoletos.get(i).get(35) != null)
                bbol.idEmpresaAlterou       = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(35)));
            if(dadosBoletos.get(i).get(36) != null)
                bbol.codigoGrupoAlterou     = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(36)));
            if(dadosBoletos.get(i).get(37) != null)
                bbol.codigoEmpresaAlterou   = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(37)));
            
            bc.codigoCliente          = bbol.codigoCliente;
            PegaCliente();
            
            bu.codigoUsuario          = bbol.codigoUsuario;
            PegaUsuario();
            
            if(bbol.valorPago == 0.0)
                TotalBoletosPendentes  = TotalBoletosPendentes + 1;
            else
                ValorTotalBoletosPagos = ValorTotalBoletosPagos + 1;
            
            if(bbol.ocorrenciaRemessa ==  1)ocorrencia = "Gerado pelo Sistema";
            if(bbol.ocorrenciaRemessa ==  3)ocorrencia = "Entrada rejeitada, reenvio";
            if(bbol.ocorrenciaRemessa == 31)ocorrencia = "Boleto Alterado";
            
            TotalBoletos                = i                          + 1;
            ValorTotalBoletos           = ValorTotalBoletos          + bbol.valorDevido;
            ValorTotalBoletosPendentes  = ValorTotalBoletosPendentes + bbol.valorDevido;
            
            tbBoletos.addRow(new Object[]{fc.FormataCampo(String.valueOf(bbol.codigoBoleto), 8, 0), fc.FormataCampo(String.valueOf(bbol.codigoCliente), 5, 0) + " - " + bc.nome, bbol.tipoDeFaturamento, bbol.dataEmissao, bbol.Instrucao1, nf.format(bbol.valorDevido), bbol.dataDeVencimento, bbol.ocorrenciaRemessa + " - " + ocorrencia});
        }
        if(tabela_boletos.getRowCount() > 0){
            tbBoletos.addRow(new Object[]{"", "Totais: ", "", "", "", nf.format(ValorTotalBoletos), "", ""});
            bt_gerar.setEnabled(true);
        }
        txt_totalBoletos.setText(String.valueOf(TotalBoletos));
        txt_totalBoletosPendentes.setText(String.valueOf(TotalBoletosPendentes));
    }
    
    private void GeraRemessaItau(){
        dadosRegistro.clear();
        for(int i = 0; i < tabela_boletos.getRowCount() - 1; i++){
            dadosRegistro.add(Integer.parseInt(String.valueOf(tabela_boletos.getValueAt(i, 0))));
        }
        GerarRemessaItau.gerarArquivo(dadosRegistro);
    }
    
    private void GeraRemessaBradesco(){
        dadosRegistro.clear();
        for(int i = 0; i < tabela_boletos.getRowCount() - 1; i++){
            dadosRegistro.add(Integer.parseInt(String.valueOf(tabela_boletos.getValueAt(i, 0))));
        }
        GerarRemessaBradesco.gerarArquivo(dadosRegistro);
    }
    
}
